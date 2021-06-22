package d.a.m0.n.i.i.f;

import android.util.Log;
import okhttp3.Response;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51828a = d.a.m0.n.c.f51766a;

    public static e a(String str) throws Exception {
        if (f51828a) {
            Log.d("PMSGetRequestManager", "executeGetRequestSync-url:" + str);
        }
        Response executeSync = d.a.m0.m.e.a.g().getRequest().url(str).build().executeSync();
        if (executeSync == null) {
            return null;
        }
        return new a(executeSync);
    }
}
