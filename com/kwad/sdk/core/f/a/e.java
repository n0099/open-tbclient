package com.kwad.sdk.core.f.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public Context f33024a;

    public e(Context context) {
        this.f33024a = context;
    }

    public String a() {
        String str;
        Bundle call;
        str = "";
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient acquireContentProviderClient = this.f33024a.getContentResolver().acquireContentProviderClient(parse);
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = this.f33024a.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if (call != null) {
                str = call.getInt("code", -1) == 0 ? call.getString("id") : "";
                String string = call.getString("message");
                com.kwad.sdk.core.d.a.c("NubiaDeviceIDHelper", "getOAID oaid:" + str + "faledMsg:" + string);
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.c("NubiaDeviceIDHelper", "getOAID fail");
            com.kwad.sdk.core.d.a.a(e2);
        }
        return str;
    }
}
