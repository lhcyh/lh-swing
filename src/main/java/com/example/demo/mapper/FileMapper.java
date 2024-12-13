@Mapper
public interface FileMapper{
    public int addFile(File file);
    public int deleteFileById(Integer id);
    public int updateFile(File file);
    public File getFileById(Integer id);
    public List<File> getFileListByExample(Example<File> example);
}
