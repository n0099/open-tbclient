package com.win.opensdk;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
/* loaded from: classes3.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    public static String f13729a;

    /* renamed from: b  reason: collision with root package name */
    public static String f13730b;

    /* renamed from: case  reason: not valid java name */
    public static String f26case;
    private static int java;

    /* renamed from: java  reason: collision with other field name */
    public static final String f27java = bl.class.getSimpleName();
    private static boolean qiQ = true;

    public static void iL(Context context) {
        if (!bk.java()) {
            qiQ = false;
            return;
        }
        try {
            int InitSdk = MdidSdkHelper.InitSdk(context, true, new IIdentifierListener() { // from class: com.win.opensdk.bl.1
            });
            if (InitSdk == 1008612) {
                Se(InitSdk);
            } else if (InitSdk == 1008613) {
                Se(InitSdk);
            } else if (InitSdk == 1008611) {
                Se(InitSdk);
            } else if (InitSdk == 1008614) {
                Se(InitSdk);
            } else if (InitSdk == 1008615) {
                Se(InitSdk);
            }
        } catch (Exception e) {
        }
    }

    private static void Se(int i) {
        qiQ = false;
        java = i;
    }

    public static String java() {
        return f26case;
    }

    public static String eIW() {
        return f13729a;
    }

    public static String a() {
        return f13730b;
    }
}
