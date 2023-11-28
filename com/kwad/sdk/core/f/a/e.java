package com.kwad.sdk.core.f.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
/* loaded from: classes10.dex */
public final class e {
    public Context mContext;

    public e(Context context) {
        this.mContext = context;
    }

    public final String getOAID() {
        Bundle call;
        String str = "";
        try {
            Uri parse = Uri.parse("content://cn.nubia.identity/identity");
            if (Build.VERSION.SDK_INT > 17) {
                ContentProviderClient acquireContentProviderClient = this.mContext.getContentResolver().acquireContentProviderClient(parse);
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = this.mContext.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if (call != null) {
                if (call.getInt("code", -1) == 0) {
                    str = call.getString("id");
                }
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
