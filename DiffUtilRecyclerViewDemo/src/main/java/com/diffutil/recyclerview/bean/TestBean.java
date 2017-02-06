package com.diffutil.recyclerview.bean;

/**
 * Created by bobo on 2017/2/6.
 */

public class TestBean implements Cloneable {
    private String name;
    private String desc;
    private int pic;

    public TestBean() {
    }

    public TestBean(String desc, String name, int pic) {
        this.desc = desc;
        this.name = name;
        this.pic = pic;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //仅写DEMO 用 实现克隆方法
    @Override
    public TestBean clone() throws CloneNotSupportedException {
        TestBean bean = null;
        try {
            bean = (TestBean) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
