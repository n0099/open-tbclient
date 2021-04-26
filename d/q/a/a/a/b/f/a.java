package d.q.a.a.a.b.f;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
/* loaded from: classes7.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f66835b;

    /* renamed from: c  reason: collision with root package name */
    public static Uri f66836c = Uri.parse("content://cn.nubia.identity/identity");

    /* renamed from: a  reason: collision with root package name */
    public Context f66837a;

    public a(Context context) {
        this.f66837a = context;
    }

    public static a a(Context context) {
        if (f66835b == null) {
            synchronized (a.class) {
                if (f66835b == null) {
                    f66835b = new a(context);
                }
            }
        }
        return f66835b;
    }

    public final String b(String str, String str2) {
        Bundle call;
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                ContentProviderClient acquireUnstableContentProviderClient = this.f66837a.getContentResolver().acquireUnstableContentProviderClient(f66836c);
                call = acquireUnstableContentProviderClient.call(str2, null, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = this.f66837a.getContentResolver().call(f66836c, str2, (String) null, (Bundle) null);
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
                ContentProviderClient acquireUnstableContentProviderClient = this.f66837a.getContentResolver().acquireUnstableContentProviderClient(f66836c);
                call = acquireUnstableContentProviderClient.call("isSupport", null, null);
                if (acquireUnstableContentProviderClient != null) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        acquireUnstableContentProviderClient.close();
                    } else {
                        acquireUnstableContentProviderClient.release();
                    }
                }
            } else {
                call = this.f66837a.getContentResolver().call(f66836c, "isSupport", (String) null, (Bundle) null);
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
