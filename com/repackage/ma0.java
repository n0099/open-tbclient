package com.repackage;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
/* loaded from: classes6.dex */
public interface ma0<T> {
    void onNetResponse(NetResponse netResponse, T t);

    T onParseResponseInBackground(NetResponse netResponse);
}
