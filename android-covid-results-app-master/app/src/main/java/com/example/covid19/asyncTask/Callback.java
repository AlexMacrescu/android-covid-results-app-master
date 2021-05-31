package com.example.covid19.asyncTask;

public interface Callback<R> {

    void runResultOnUiThread(R result);
}
