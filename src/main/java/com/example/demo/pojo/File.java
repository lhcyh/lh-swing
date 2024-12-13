public class File{
    private Integer id;
    private String url;
    private String fileId;
    private String remarks;

    public Integer getId(){
      return id;
    }

    public void setId(Integer id){
      this.id=id;
    }

    public String getUrl(){
      return url;
    }

    public void setUrl(String url){
      this.url=url;
    }

    public String getFileId(){
      return fileId;
    }

    public void setFileId(String fileId){
      this.fileId=fileId;
    }

    public String getRemarks(){
      return remarks;
    }

    public void setRemarks(String remarks){
      this.remarks=remarks;
    }

}