package com.sina.weibo.sdk.component;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class WeiboCallbackManager {
    private static WeiboCallbackManager sInstance;
    private Context mContext;
    private Map<String, WeiboAuthListener> mWeiboAuthListenerMap = new HashMap();
    private Map<String, WidgetRequestParam.WidgetRequestCallback> mWidgetRequestCallbackMap = new HashMap();

    private WeiboCallbackManager(Context context) {
        this.mContext = context;
    }

    public static synchronized WeiboCallbackManager getInstance(Context context) {
        WeiboCallbackManager weiboCallbackManager;
        synchronized (WeiboCallbackManager.class) {
            if (sInstance == null) {
                sInstance = new WeiboCallbackManager(context);
            }
            weiboCallbackManager = sInstance;
        }
        return weiboCallbackManager;
    }

    public synchronized WeiboAuthListener getWeiboAuthListener(String str) {
        return TextUtils.isEmpty(str) ? null : this.mWeiboAuthListenerMap.get(str);
    }

    public synchronized void setWeiboAuthListener(String str, WeiboAuthListener weiboAuthListener) {
        if (!TextUtils.isEmpty(str) && weiboAuthListener != null) {
            this.mWeiboAuthListenerMap.put(str, weiboAuthListener);
        }
    }

    public synchronized void removeWeiboAuthListener(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mWeiboAuthListenerMap.remove(str);
        }
    }

    public synchronized WidgetRequestParam.WidgetRequestCallback getWidgetRequestCallback(String str) {
        return TextUtils.isEmpty(str) ? null : this.mWidgetRequestCallbackMap.get(str);
    }

    public synchronized void setWidgetRequestCallback(String str, WidgetRequestParam.WidgetRequestCallback widgetRequestCallback) {
        if (!TextUtils.isEmpty(str) && widgetRequestCallback != null) {
            this.mWidgetRequestCallbackMap.put(str, widgetRequestCallback);
        }
    }

    public synchronized void removeWidgetRequestCallback(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mWidgetRequestCallbackMap.remove(str);
        }
    }

    public String genCallbackKey() {
        return String.valueOf(System.currentTimeMillis());
    }
}
