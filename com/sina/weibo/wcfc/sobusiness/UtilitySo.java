package com.sina.weibo.wcfc.sobusiness;

import android.content.Context;
/* loaded from: classes7.dex */
public class UtilitySo {
    public static UtilitySo sInstance;

    static {
        try {
            System.loadLibrary("utility");
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    public static synchronized UtilitySo getInstance() {
        UtilitySo utilitySo;
        synchronized (UtilitySo.class) {
            if (sInstance == null) {
                sInstance = new UtilitySo();
            }
            utilitySo = sInstance;
        }
        return utilitySo;
    }

    public native String calculateS(Context context, String str);

    public native String generateCheckToken(Context context, String str, String str2);

    public native String getDecryptionString(Context context, String str);

    public native String getIValue(Context context, String str);
}
