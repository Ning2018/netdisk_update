package common;

import java.io.File;

public class UserInfo
{
    private String cookieUser;
    private String root;
    private String userRoot;
	private String dir;
	private String parentPath;
	private String time;
	/**
	 * time���Ե�getter����
	 */
	public String getTime()
	{
	
		return time;
	}
	/**
	 * time���Ե�setter���� 
	 */
	public void setTime(String time)
	{
		this.time = time;
	}
	/**
	 * dir���Ե�getter����
	 */
	public String getDir()
	{
		return dir;
	}
	/**
	 * dir���Ե�setter����
	 */
	public void setDir(String dir)
	{
		this.dir = dir;
	}
	/**
	 * parentPath���Ե�getter����
	 */
	public String getParentPath()
	{
		return parentPath;
	}
	/**
	 * parentPath���Ե�setter����
	 */
	public void setParentPath(String parentPath)
	{
		this.parentPath = parentPath;
	}
	/**
	 * cookieUser���Ե�getter����
	 */
	public String getCookieUser()
	{
		return cookieUser;
	}
	/**
	 * cookieUser���Ե�setter����
	 */
	public void setCookieUser(String cookieUser)
	{
		this.cookieUser = cookieUser;
	}
	/**
	 * root���Ե�getter����
	 */
	public String getRoot()
	{
		return root;
	}
	/**
	 * root���Ե�setter����
	 */
	public void setRoot(String root)
	{
		this.root = root;
	}
	/**
	 * userRoot���Ե�getter����
	 */
	public String getUserRoot()
	{
		return userRoot;
	}
	/**
	 * userRoot���Ե�setter����
	 */
	public void setUserRoot(String userRoot)
	{
		this.userRoot = userRoot;
	}
	
	public String getAbsolutePath(String path)
	{
		String absolutePath = userRoot
		+ (File.separator.equals("\\") ? path.replaceAll(
				"/", "\\\\") : path);
		return absolutePath;
	}
	@Override
	public String toString() {
		return "UserInfo [cookieUser=" + cookieUser + ", root=" + root + ", userRoot=" + userRoot + ", dir=" + dir
				+ ", parentPath=" + parentPath + ", time=" + time + "]";
	}
	
	
}
