package com.qq.e.comm.net;

import com.qq.e.comm.net.rr.Request;
import com.qq.e.comm.net.rr.Response;
/* loaded from: classes10.dex */
public interface NetworkCallBack {
    void onException(Exception exc);

    void onResponse(Request request, Response response);
}
