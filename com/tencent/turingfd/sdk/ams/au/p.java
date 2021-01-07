package com.tencent.turingfd.sdk.ams.au;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
/* loaded from: classes4.dex */
public class p implements k {
    @Override // com.tencent.turingfd.sdk.ams.au.k
    public n a(Context context) {
        Bundle call;
        Uri parse = Uri.parse(y.a(y.av));
        String a2 = y.a(y.f13854a);
        if (Build.VERSION.SDK_INT >= 17) {
            ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
            try {
                Bundle call2 = acquireContentProviderClient.call(a2, null, null);
                if (Build.VERSION.SDK_INT >= 24) {
                    acquireContentProviderClient.close();
                    call = call2;
                } else {
                    acquireContentProviderClient.release();
                    call = call2;
                }
            } catch (Throwable th) {
                if (acquireContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireContentProviderClient.close();
                    } else {
                        acquireContentProviderClient.release();
                    }
                }
                call = null;
            }
        } else {
            call = context.getContentResolver().call(parse, a2, (String) null, (Bundle) null);
        }
        return call == null ? n.a(-1) : call.getInt(y.a(y.aw), -1) != 0 ? n.a(-2) : new n(call.getString(y.a(y.ax)), 0);
    }

    @Override // com.tencent.turingfd.sdk.ams.au.k
    public void b(Context context) {
    }
}
