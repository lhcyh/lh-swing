package lhuitest;

import io.gitee.lianghang.lhmybatis.Generator;
import io.gitee.lianghang.lhswing.LhBody;
import io.gitee.lianghang.lhswing.LhDiv;
import io.gitee.lianghang.lhswing.LhScrollPane;

/**
 * @ClassName：Test
 * @Author：lh
 * @Date：2024/12/3 13:56
 */
public class Test {
    public static void main(String[] args) {
        testGenerator();
        //test1();
    }

    private static void testGenerator(){
        new Generator();
    }

    private static void test1(){
        LhBody lhBody=new LhBody("测试");
        LhDiv root=lhBody.getDiv();
//        root.setJustifyContent(JustifyContent.CENTER);
//        root.setAlignItems(AlignItems.CENTER);
//        LhDiv content=new LhDiv();
//        content.setFlexDirection(FlexDirection.COLUMN);
//        content.setJustifyContent(JustifyContent.CENTER);
//        LhButton button=new LhButton("连接数据库");
//        content.add(button);

        LhScrollPane lhScrollPane=new LhScrollPane();
        root.add(lhScrollPane);
        lhScrollPane.setWidthPercent(0.3f);
        lhScrollPane.setHeightPercent(1f);

        //root.add(content);
    }

}
