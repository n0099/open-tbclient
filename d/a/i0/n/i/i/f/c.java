package d.a.i0.n.i.i.f;

import android.util.Log;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47870a = d.a.i0.n.c.f47808a;

    public static e a(String str) throws Exception {
        if (f47870a) {
            Log.d("PMSGetRequestManager", "executeGetRequestSync-url:" + str);
        }
        Response executeSync = d.a.i0.m.e.a.g().getRequest().url(str).build().executeSync();
        if (executeSync == null) {
            return null;
        }
        return new a(executeSync);
    }
}
