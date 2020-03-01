public class EatTest {
    /**
     * test1:抛出“喝大了”异常
     * test2:调用test1,捕获"喝大了"异常,并且包装成运行时异常,继续抛出
     * main方法中,调用test2,尝试捕获test2抛出的异常
     */

    public static void main(String[] args) {

        EatTest eatTest = new EatTest();
        try{
            eatTest.test2();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void test1() throws DrunkException{
        throw new DrunkException("开酒别喝车");
    }

    public void test2() throws RuntimeException{
        try {
            test1();
        } catch (DrunkException e) {
            RuntimeException newexc = new RuntimeException(e);
//            newexc.initCause(e);
            throw newexc;
        }

    }
}
