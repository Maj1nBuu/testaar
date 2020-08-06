package com.sxnet.liba;

import com.google.gson.Gson;

/**
 * Created by MajinBuu on 2020/8/6 0006.
 *
 * @desc .
 */
public class TestA {

    public String compute() {
//        return new TestB().getValue(1, 1);
        Gson gson = new Gson();
        String aaa = gson.toJson("aaa");
        return aaa;
    }
}
