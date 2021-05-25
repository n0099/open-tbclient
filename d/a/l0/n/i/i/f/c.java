package d.a.l0.n.i.i.f;

import android.util.Log;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f48046a = d.a.l0.n.c.f47984a;

    public static e a(String str) throws Exception {
        if (f48046a) {
            Log.d("PMSGetRequestManager", "executeGetRequestSync-url:" + str);
        }
        Response executeSync = d.a.l0.m.e.a.g().getRequest().url(str).build().executeSync();
        if (executeSync == null) {
            return null;
        }
        return new a(executeSync);
    }
}
