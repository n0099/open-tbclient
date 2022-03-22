package com.kwad.sdk.g;

import android.content.Context;
import android.util.Log;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
/* loaded from: classes7.dex */
public class b {
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f40549b;

    /* loaded from: classes7.dex */
    public interface a {
    }

    public static void a(Context context, final a aVar) {
        if (context == null || f40549b) {
            return;
        }
        if (!a()) {
            f40549b = true;
        } else if (a) {
        } else {
            a = true;
            try {
                final long currentTimeMillis = System.currentTimeMillis();
                int InitSdk = MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener() { // from class: com.kwad.sdk.g.b.1
                });
                Log.d("KSAdSDK", "[OADIDSDKHelper26]:sdk init time=" + (System.currentTimeMillis() - currentTimeMillis) + "--result=" + InitSdk);
            } catch (Throwable th) {
                Log.d("KSAdSDK", "[OADIDSDKHelper26]:oaid sdk not find " + th.getMessage());
                a = false;
                f40549b = true;
            }
        }
    }

    public static boolean a() {
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.g.b.2
            }.onSupport(null);
            return true;
        } catch (Throwable th) {
            Log.d("KSAdSDK", "[OADIDSDKHelper26]:oaid sdk not find " + th.getMessage());
            return false;
        }
    }
}
