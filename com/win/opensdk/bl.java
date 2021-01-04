package com.win.opensdk;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
/* loaded from: classes4.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    public static String f14026a;

    /* renamed from: b  reason: collision with root package name */
    public static String f14027b;

    /* renamed from: case  reason: not valid java name */
    public static String f26case;
    private static int java;

    /* renamed from: java  reason: collision with other field name */
    public static final String f27java = bl.class.getSimpleName();
    private static boolean qbE = true;

    public static void iK(Context context) {
        if (!bk.java()) {
            qbE = false;
            return;
        }
        try {
            int InitSdk = MdidSdkHelper.InitSdk(context, true, new IIdentifierListener() { // from class: com.win.opensdk.bl.1
            });
            if (InitSdk == 1008612) {
                Ta(InitSdk);
            } else if (InitSdk == 1008613) {
                Ta(InitSdk);
            } else if (InitSdk == 1008611) {
                Ta(InitSdk);
            } else if (InitSdk == 1008614) {
                Ta(InitSdk);
            } else if (InitSdk == 1008615) {
                Ta(InitSdk);
            }
        } catch (Exception e) {
        }
    }

    private static void Ta(int i) {
        qbE = false;
        java = i;
    }

    public static String java() {
        return f26case;
    }

    public static String eJS() {
        return f14026a;
    }

    public static String a() {
        return f14027b;
    }
}
