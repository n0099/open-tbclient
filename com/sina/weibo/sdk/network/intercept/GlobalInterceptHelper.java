package com.sina.weibo.sdk.network.intercept;

import com.sina.weibo.sdk.network.IRequestIntercept;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class GlobalInterceptHelper {
    public static GlobalInterceptHelper globalInterceptHelper;
    public HashMap<String, IRequestIntercept> globalIntercept;

    public GlobalInterceptHelper() {
        HashMap<String, IRequestIntercept> hashMap = new HashMap<>();
        this.globalIntercept = hashMap;
        hashMap.put(GuestParamInterception.class.getName(), new GuestParamInterception());
        this.globalIntercept.put(CommonParamInterception.class.getName(), new CommonParamInterception());
    }

    public static GlobalInterceptHelper init() {
        if (globalInterceptHelper == null) {
            globalInterceptHelper = new GlobalInterceptHelper();
        }
        return globalInterceptHelper;
    }

    public void addIntercept(String str, IRequestIntercept iRequestIntercept) {
        this.globalIntercept.put(str, iRequestIntercept);
    }

    public HashMap<String, IRequestIntercept> getGlobalIntercept() {
        HashMap<String, IRequestIntercept> hashMap = this.globalIntercept;
        return hashMap == null ? new HashMap<>() : hashMap;
    }

    public void removeIntercept(String str) {
        if (this.globalIntercept.containsKey(str)) {
            this.globalIntercept.remove(str);
        }
    }
}
