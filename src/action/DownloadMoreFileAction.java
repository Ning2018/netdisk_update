package action;

import common.*;
import service.ServiceManager;

import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DownloadMoreFileAction extends BaseAction
{

	private String[] names;
	private String path;

	public void setNames(String names)
	{
		this.names = names.split(";");
	}

	public String getPath()
	{
		return path;
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	public String execute() throws Exception
	{
		System.out.println(" in download more file action..");
		try
		{
			if (path != null && names != null)
			{
				response.setContentType("application/octet-stream");

				if (path.equals("/"))
				{
					response.addHeader("Content-Disposition",
							"attachment;filename="
									+ java.net.URLEncoder.encode("����Ӳ�̸�Ŀ¼.zip",
											"utf-8"));
				}

				else if (path.length() > 0)
				{
					System.out.println("in DownloadMoreFileAction"+path);
					String[] array = path.split("/");
                    System.out.println("after path split"+array);
                    System.out.println("array length: "+array.length);
					if (array.length > 1) // ���鳤��������2 ���޸�֮ǰ�� array.length>1
					{
						String zipName = array[array.length - 1] + ".zip";
						response.addHeader("Content-Disposition",
								"attachment;filename=" + zipName);

					}
					else
						return null;
				}
				else
					return null;

				
				for (int i = 0; i < names.length; i++)
				{
					String name = names[i];
					if (!name.equals(""))
					{
						String filename =   // userInfo.getUserRoot()+
								 path + name;
						System.out.println("path+name:"+filename);
						filename = java.net.URLDecoder
								.decode(filename, "UTF-8");

						names[i] = filename;
						System.out.println("names after decode:"+names[i]);
					}
				}
				Zip.compress(response.getOutputStream(), names);

				
			}
			
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
	}
}