package com.win.opensdk;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
/* loaded from: classes4.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    public static String f14027a;

    /* renamed from: b  reason: collision with root package name */
    public static String f14028b;

    /* renamed from: case  reason: not valid java name */
    public static String f27case;
    private static int java;

    /* renamed from: java  reason: collision with other field name */
    public static final String f28java = bl.class.getSimpleName();
    private static boolean qdm = true;

    public static void iK(Context context) {
        if (!bk.java()) {
            qdm = false;
            return;
        }
        try {
            int InitSdk = MdidSdkHelper.InitSdk(context, true, new IIdentifierListener() { // from class: com.win.opensdk.bl.1
            });
            if (InitSdk == 1008612) {
                Tq(InitSdk);
            } else if (InitSdk == 1008613) {
                Tq(InitSdk);
            } else if (InitSdk == 1008611) {
                Tq(InitSdk);
            } else if (InitSdk == 1008614) {
                Tq(InitSdk);
            } else if (InitSdk == 1008615) {
                Tq(InitSdk);
            }
        } catch (Exception e) {
        }
    }

    private static void Tq(int i) {
        qdm = false;
        java = i;
    }

    public static String java() {
        return f27case;
    }

    public static String eKw() {
        return f14027a;
    }

    public static String a() {
        return f14028b;
    }
}
