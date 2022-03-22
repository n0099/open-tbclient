package com.kwad.sdk.g;

import android.content.Context;
import android.util.Log;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
/* loaded from: classes7.dex */
public class a {
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f40547b;

    /* renamed from: com.kwad.sdk.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1984a {
    }

    public static void a(Context context, final InterfaceC1984a interfaceC1984a) {
        if (context == null || f40547b) {
            return;
        }
        if (!a()) {
            f40547b = true;
        } else if (a) {
        } else {
            a = true;
            try {
                final long currentTimeMillis = System.currentTimeMillis();
                int InitSdk = MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener() { // from class: com.kwad.sdk.g.a.1
                });
                Log.d("KSAdSDK", "[OADIDSDKHelper25]:sdk init time=" + (System.currentTimeMillis() - currentTimeMillis) + "--result=" + InitSdk);
            } catch (Throwable th) {
                Log.d("KSAdSDK", "[OADIDSDKHelper25]:oaid sdk not find " + th.getMessage());
                a = false;
                f40547b = true;
            }
        }
    }

    public static boolean a() {
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.g.a.2
            }.OnSupport(true, null);
            return true;
        } catch (Throwable th) {
            Log.d("KSAdSDK", "[OADIDSDKHelper25]:oaid sdk not find " + th.getMessage());
            return false;
        }
    }
}
