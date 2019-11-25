package cn.edu.bistu.cs.se.words;

public interface HttpCallBack {
    void onSuccess(String result);
    void onFailure(String exception);
}
