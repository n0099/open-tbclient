package com.tachikoma.core.api;

import com.tachikoma.core.component.network.ResponseCallBackInner;
import java.util.Map;
/* loaded from: classes8.dex */
public interface IRequestDelegateInner {
    void get(ResponseCallBackInner responseCallBackInner);

    void post(ResponseCallBackInner responseCallBackInner);

    void setBody(Map<String, String> map);

    void setHeader(Map<String, String> map);

    void setHost(String str);

    void setInterval(int i);

    void setParams(Map<String, String> map);

    void setPath(String str);

    void setScheme(String str);

    void setUserInfo(Map<String, Object> map);
}
