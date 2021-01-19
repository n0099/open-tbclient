package com.yxcorp.kuaishou.addfp.a.b.e;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f14355a;
    private static volatile a qbG = null;
    private static Uri c = Uri.parse("content://cn.nubia.identity/identity");

    private a(Context context) {
        this.f14355a = context;
    }

    private String a(String str, String str2) {
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = this.f14355a.getContentResolver().acquireUnstableContentProviderClient(c);
                call = acquireUnstableContentProviderClient.call(str2, null, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = this.f14355a.getContentResolver().call(c, str2, (String) null, (Bundle) null);
            }
            if (call != null && call.getInt("code", -1) == 0) {
                return call.getString("id");
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return "";
    }

    public static a ja(Context context) {
        if (qbG == null) {
            synchronized (a.class) {
                if (qbG == null) {
                    qbG = new a(context);
                }
            }
        }
        return qbG;
    }

    public final boolean a() {
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = this.f14355a.getContentResolver().acquireUnstableContentProviderClient(c);
                call = acquireUnstableContentProviderClient.call("isSupport", null, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = this.f14355a.getContentResolver().call(c, "isSupport", (String) null, (Bundle) null);
            }
            if (call.getInt("code", -1) == 0) {
                return call.getBoolean("issupport", true);
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return false;
    }

    public final String b() {
        return a(null, "getOAID");
    }
}
