package test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import dbo.Student;
public class TestMysql {
    public static void main(String args[]) {
        try {
            System.setProperty("user.timezone","GMT +08");
            InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
            // 根据配置文件构建SqlSessionFactory
//            System.out.println(TestMysql.readStream(config));
//            System.exit(0);
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
            // 通过 SqlSessionFactory 创建 SqlSession
            SqlSession ss = ssf.openSession();
            //增
            Student addst = new Student("令狐冲",(byte)22,
                    (int)(System.currentTimeMillis()/1000),(int)(System.currentTimeMillis()/1000));
            ss.insert("mapper.StudentMapper.addUser", addst);
            addst.setName("任盈盈");
            addst.setAge((byte)18);
            addst.setUdpated_at((int)(System.currentTimeMillis()/1000));
            addst.setCreated_at((int)(System.currentTimeMillis()/1000));
            ss.insert("mapper.StudentMapper.addUser", addst);
            addst.setName("林平之");
            addst.setAge((byte)56);
            addst.setUdpated_at((int)(System.currentTimeMillis()/1000));
            addst.setCreated_at((int)(System.currentTimeMillis()/1000));
            ss.insert("mapper.StudentMapper.addUser", addst);
            addst.setName("任我行");
            addst.setAge((byte)56);
            addst.setUdpated_at((int)(System.currentTimeMillis()/1000));
            addst.setCreated_at((int)(System.currentTimeMillis()/1000));
            ss.insert("mapper.StudentMapper.addUser", addst);
            //查
            Student st = ss.selectOne(
                    "mapper.StudentMapper.selectUserById", 3);
            System.out.println(st);
            System.out.println("-------");
            //改
            Student updateSt = new Student(3,"风清扬",(byte)88,
                    (int)(System.currentTimeMillis()/1000));
            ss.update("mapper.StudentMapper.updateUser", updateSt);
            //删
            ss.delete("mapper.StudentMapper.deleteUser", 4);
            //查所有
            List<Student> listMu = ss
                    .selectList("mapper.StudentMapper.selectAllUser");
            for (Student MyStudent : listMu) {
                System.out.println(MyStudent);
            }

            ss.commit();
            ss.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static String readStream(InputStream in) {
        try {
            //<1>创建字节数组输出流，用来输出读取到的内容
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //<2>创建缓存大小
            byte[] buffer = new byte[1024]; // 1KB
            //每次读取到内容的长度
            int len = -1;
            //<3>开始读取输入流中的内容
            while ((len = in.read(buffer)) != -1) { //当等于-1说明没有数据可以读取了
                baos.write(buffer, 0, len);   //把读取到的内容写到输出流中
            }
            //<4> 把字节数组转换为字符串
            String content = baos.toString();
            //<5>关闭输入流和输出流
            in.close();
            baos.close();
            //<6>返回字符串结果
            return content;
        } catch (Exception e) {
            e.printStackTrace();
            return  e.getMessage();
        }
    }
}
