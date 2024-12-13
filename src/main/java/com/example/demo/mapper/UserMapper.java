@Mapper
public interface UserMapper{
    public int addUser(User user);
    public int deleteUserById(Integer id);
    public int updateUser(User user);
    public User getUserById(Integer id);
    public List<User> getUserListByExample(Example<User> example);
}
