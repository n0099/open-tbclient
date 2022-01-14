package com.kwad.sdk.g;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
/* loaded from: classes3.dex */
public class b {
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f56956b;

    /* loaded from: classes3.dex */
    public interface a {
    }

    public static void a(Context context, final a aVar) {
        if (context == null || f56956b) {
            return;
        }
        if (!a()) {
            f56956b = true;
        } else if (a) {
        } else {
            a = true;
            try {
                final long currentTimeMillis = System.currentTimeMillis();
                String str = "[OADIDSDKHelper26]:sdk init time=" + (System.currentTimeMillis() - currentTimeMillis) + "--result=" + MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener() { // from class: com.kwad.sdk.g.b.1
                });
            } catch (Throwable th) {
                String str2 = "[OADIDSDKHelper26]:oaid sdk not find " + th.getMessage();
                a = false;
                f56956b = true;
            }
        }
    }

    public static boolean a() {
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.g.b.2
            }.onSupport(null);
            return true;
        } catch (Throwable th) {
            String str = "[OADIDSDKHelper26]:oaid sdk not find " + th.getMessage();
            return false;
        }
    }
}
