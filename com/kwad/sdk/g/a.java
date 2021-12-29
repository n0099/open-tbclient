package com.kwad.sdk.g;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.miitmdid.interfaces.IIdentifierListener;
/* loaded from: classes3.dex */
public class a {
    public static boolean a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f59182b;

    /* renamed from: com.kwad.sdk.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2111a {
    }

    public static void a(Context context, final InterfaceC2111a interfaceC2111a) {
        if (context == null || f59182b) {
            return;
        }
        if (!a()) {
            f59182b = true;
        } else if (a) {
        } else {
            a = true;
            try {
                final long currentTimeMillis = System.currentTimeMillis();
                String str = "[OADIDSDKHelper25]:sdk init time=" + (System.currentTimeMillis() - currentTimeMillis) + "--result=" + MdidSdkHelper.InitSdk(context.getApplicationContext(), true, new IIdentifierListener() { // from class: com.kwad.sdk.g.a.1
                });
            } catch (Throwable th) {
                String str2 = "[OADIDSDKHelper25]:oaid sdk not find " + th.getMessage();
                a = false;
                f59182b = true;
            }
        }
    }

    public static boolean a() {
        try {
            new IIdentifierListener() { // from class: com.kwad.sdk.g.a.2
            }.OnSupport(true, null);
            return true;
        } catch (Throwable th) {
            String str = "[OADIDSDKHelper25]:oaid sdk not find " + th.getMessage();
            return false;
        }
    }
}
