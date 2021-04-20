package d.q.a.a.a.b.f;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f68309b;

    /* renamed from: c  reason: collision with root package name */
    public static Uri f68310c = Uri.parse("content://cn.nubia.identity/identity");

    /* renamed from: a  reason: collision with root package name */
    public Context f68311a;

    public a(Context context) {
        this.f68311a = context;
    }

    public static a a(Context context) {
        if (f68309b == null) {
            synchronized (a.class) {
                if (f68309b == null) {
                    f68309b = new a(context);
                }
            }
        }
        return f68309b;
    }

    public final String b(String str, String str2) {
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = this.f68311a.getContentResolver().acquireUnstableContentProviderClient(f68310c);
                call = acquireUnstableContentProviderClient.call(str2, null, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = this.f68311a.getContentResolver().call(f68310c, str2, (String) null, (Bundle) null);
            }
            return (call == null || call.getInt("code", -1) != 0) ? "" : call.getString("id");
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return "";
        }
    }

    public final boolean c() {
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = this.f68311a.getContentResolver().acquireUnstableContentProviderClient(f68310c);
                call = acquireUnstableContentProviderClient.call("isSupport", null, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = this.f68311a.getContentResolver().call(f68310c, "isSupport", (String) null, (Bundle) null);
            }
            if (call.getInt("code", -1) == 0) {
                return call.getBoolean("issupport", true);
            }
            return false;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return false;
        }
    }

    public final String d() {
        return b(null, "getOAID");
    }
}
