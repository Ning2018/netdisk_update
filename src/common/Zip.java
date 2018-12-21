package common;

import java.io.*;
import org.apache.tools.zip.*;


public class Zip
{	
	private static void zipDirectory(ZipOutputStream zos, String dirName,
			String basePath) throws Exception
	{
		System.out.println("in Zip.java, dirName: "+dirName+"  basePath: "+basePath);
		File dir = new File(dirName);
		if (dir.exists())
		{
			File files[] = dir.listFiles();
			if (files.length > 0)
			{
				for (File file : files)
				{
					System.out.println(file.getName());

					if (file.isDirectory())
					{
						zipDirectory(zos, file.getPath(), basePath
								+ file.getName().substring(
										file.getName().lastIndexOf(
												"\\") + 1)
								+ "\\");
					}
					else
					{
						System.out.println("in Zip.java, zipDirectory, is Directory's file is not directory");
						zipFile(zos, file.getPath(), basePath);
					}
				}
			}
			else
			{
				ZipEntry ze = new ZipEntry(basePath);
				zos.putNextEntry(ze);
			}
		}
	}

	private static void  zipFile(ZipOutputStream zos, String filename,
			String basePath) throws Exception
	{
		File file = new File(filename);
     
		if (file.exists())
		{
			
			FileInputStream fis = new FileInputStream(filename);
			ZipEntry ze = new ZipEntry(basePath+file.getName()); //previous is basePath+ + file.getName()

			zos.putNextEntry(ze);
			byte[] buffer = new byte[8192];
			int count = 0;
			while ((count = fis.read(buffer)) > 0)
			{
				zos.write(buffer, 0, count);
			}
			fis.close();					
		}
	}

	public static void compress(String zipFilename, String... paths)
			throws Exception
	{
		compress(new FileOutputStream(zipFilename), paths);

	}

	public static void  compress(OutputStream os, String... paths)
			throws Exception
	{
		ZipOutputStream zos = new ZipOutputStream(os);

		for (String path : paths)
		{
			if(path.equals("")) continue;
			java.io.File file = new java.io.File(path);
			if (file.exists())
			{

				if (file.isDirectory())
				{
					System.out.println("in Zip.java, if file isDirectory:"+file.getPath()+"  file Name:"+file.getName());
					zipDirectory(zos, file.getPath(), file.getName() + "\\");
				}
				else
				{
					System.out.println("in Zip.java, if file isFile:"+file.getPath());
					zipFile(zos, file.getPath(), "");
				}
			}
		}
		zos.close();
	}
}
