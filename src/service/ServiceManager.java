package service;

import serviceInterfaces.*;

public class ServiceManager
{
    private UserService userService;
    private DirectoryService directoryService;
    private FileService fileService;

	public FileService getFileService()
	{
		return fileService;
	}
	public void setFileService(FileService fileService)
	{
		this.fileService = fileService;
	}
	/**
	 * directoryService���Ե�getter����
	 */
	public DirectoryService getDirectoryService()
	{
		return directoryService;
	}
	/**
	 * directoryService���Ե�setter����
	 */
	public void setDirectoryService(DirectoryService directoryService)
	{
		this.directoryService = directoryService;
	}
	/**
	 * userService���Ե�getter����
	 */
	public UserService getUserService()
	{
		return userService;
	}
	/**
	 * userService���Ե�setter����
	 */
	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}
}
