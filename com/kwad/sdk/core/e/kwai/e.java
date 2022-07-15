package com.kwad.sdk.core.e.kwai;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
/* loaded from: classes5.dex */
public final class e {
    public Context a;

    public e(Context context) {
        this.a = context;
    }

    public final String a() {
        String str;
        Bundle call;
        str = "";
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient acquireContentProviderClient = this.a.getContentResolver().acquireContentProviderClient(parse);
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = this.a.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if (call != null) {
                str = call.getInt("code", -1) == 0 ? call.getString("id") : "";
                String string = call.getString("message");
                StringBuilder sb = new StringBuilder("getOAID oaid:");
                sb.append(str);
                sb.append("faledMsg:");
                sb.append(string);
            }
        } catch (Exception unused) {
        }
        return str;
    }
}
