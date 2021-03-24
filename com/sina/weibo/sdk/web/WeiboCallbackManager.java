package com.sina.weibo.sdk.web;

import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WbAuthListener;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class WeiboCallbackManager {
    public static WeiboCallbackManager sInstance;
    public Map<String, WbAuthListener> mWeiboAuthListenerMap = new HashMap();

    public static synchronized WeiboCallbackManager getInstance() {
        WeiboCallbackManager weiboCallbackManager;
        synchronized (WeiboCallbackManager.class) {
            if (sInstance == null) {
                sInstance = new WeiboCallbackManager();
            }
            weiboCallbackManager = sInstance;
        }
        return weiboCallbackManager;
    }

    public String genCallbackKey() {
        return String.valueOf(System.currentTimeMillis());
    }

    public synchronized WbAuthListener getWeiboAuthListener(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mWeiboAuthListenerMap.get(str);
    }

    public synchronized void removeWeiboAuthListener(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mWeiboAuthListenerMap.remove(str);
    }

    public synchronized void setWeiboAuthListener(String str, WbAuthListener wbAuthListener) {
        if (!TextUtils.isEmpty(str) && wbAuthListener != null) {
            this.mWeiboAuthListenerMap.put(str, wbAuthListener);
        }
    }
}
