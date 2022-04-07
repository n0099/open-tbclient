package com.kuaishou.tachikoma.api.app;

import java.util.Map;
/* loaded from: classes5.dex */
public interface IRequestDelegate {
    void get(IRequestCallback iRequestCallback);

    void post(IRequestCallback iRequestCallback);

    void setBody(Map<String, String> map);

    void setHeader(Map<String, String> map);

    void setHost(String str);

    void setInterval(int i);

    void setParams(Map<String, String> map);

    void setPath(String str);

    void setScheme(String str);

    void setUserInfo(Map<String, Object> map);
}
