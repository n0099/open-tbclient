package com.kwad.sdk.g;

import android.content.Context;
import android.util.Log;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
/* loaded from: classes5.dex */
public class a {
    public static boolean a;
    public static boolean b;

    /* renamed from: com.kwad.sdk.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public interface InterfaceC0323a {
    }

    public static void a(Context context, final InterfaceC0323a interfaceC0323a) {
        if (context == null || b) {
            return;
        }
        if (!a()) {
            b = true;
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
                b = true;
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
