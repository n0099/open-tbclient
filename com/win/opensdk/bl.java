package com.win.opensdk;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
/* loaded from: classes3.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    public static String f13727a;

    /* renamed from: b  reason: collision with root package name */
    public static String f13728b;

    /* renamed from: case  reason: not valid java name */
    public static String f26case;
    private static int java;

    /* renamed from: java  reason: collision with other field name */
    public static final String f27java = bl.class.getSimpleName();
    private static boolean pYL = true;

    public static void iI(Context context) {
        if (!bk.java()) {
            pYL = false;
            return;
        }
        try {
            int InitSdk = MdidSdkHelper.InitSdk(context, true, new IIdentifierListener() { // from class: com.win.opensdk.bl.1
            });
            if (InitSdk == 1008612) {
                RJ(InitSdk);
            } else if (InitSdk == 1008613) {
                RJ(InitSdk);
            } else if (InitSdk == 1008611) {
                RJ(InitSdk);
            } else if (InitSdk == 1008614) {
                RJ(InitSdk);
            } else if (InitSdk == 1008615) {
                RJ(InitSdk);
            }
        } catch (Exception e) {
        }
    }

    private static void RJ(int i) {
        pYL = false;
        java = i;
    }

    public static String java() {
        return f26case;
    }

    public static String eGG() {
        return f13727a;
    }

    public static String a() {
        return f13728b;
    }
}
