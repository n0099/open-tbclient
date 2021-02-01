package com.vivo.push.util;

import android.content.Context;
/* loaded from: classes15.dex */
public class NotifyUtil {
    private static BaseNotifyDataAdapter sNotifyData;
    private static BaseNotifyLayoutAdapter sNotifyLayout;
    private static String sNotifyDataAdapter = "com.vivo.push.util.NotifyDataAdapter";
    private static String sNotifyLayoutAdapter = "com.vivo.push.util.NotifyLayoutAdapter";

    private static Object getObjectByReflect(String str, Object obj) {
        Class<?> cls;
        Object obj2 = null;
        try {
            cls = Class.forName(str);
        } catch (Exception e) {
            cls = null;
        }
        if (cls != null) {
            try {
                obj2 = cls.newInstance();
            } catch (Exception e2) {
            }
        }
        return obj2 == null ? obj : obj2;
    }

    private static synchronized void initAdapter(Context context) {
        synchronized (NotifyUtil.class) {
            if (sNotifyData == null) {
                BaseNotifyDataAdapter baseNotifyDataAdapter = (BaseNotifyDataAdapter) getObjectByReflect(sNotifyDataAdapter, new i());
                sNotifyData = baseNotifyDataAdapter;
                baseNotifyDataAdapter.init(context);
            }
            if (sNotifyLayout == null) {
                BaseNotifyLayoutAdapter baseNotifyLayoutAdapter = (BaseNotifyLayoutAdapter) getObjectByReflect(sNotifyLayoutAdapter, new j());
                sNotifyLayout = baseNotifyLayoutAdapter;
                baseNotifyLayoutAdapter.init(context);
            }
        }
    }

    public static BaseNotifyDataAdapter getNotifyDataAdapter(Context context) {
        initAdapter(context);
        return sNotifyData;
    }

    public static BaseNotifyLayoutAdapter getNotifyLayoutAdapter(Context context) {
        initAdapter(context);
        return sNotifyLayout;
    }
}
