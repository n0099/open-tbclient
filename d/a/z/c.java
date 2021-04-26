package d.a.z;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f64224a;

    public static synchronized c f() {
        c cVar;
        synchronized (c.class) {
            if (f64224a == null) {
                synchronized (c.class) {
                    if (f64224a == null) {
                        f64224a = new c();
                    }
                }
            }
            cVar = f64224a;
        }
        return cVar;
    }

    public boolean a(Activity activity, String str, d.a.z.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.a().b(activity, str, aVar);
        return true;
    }

    public boolean b(Activity activity, String str, d.a.z.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.a().d(activity, str, aVar);
        return true;
    }

    public boolean c(Activity activity, JSONObject jSONObject, d.a.z.e.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.a().i(activity, jSONObject, aVar);
        return true;
    }

    public boolean d(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.a().f(context, jSONObject);
        return true;
    }

    public boolean e(Context context, JSONObject jSONObject, d.a.z.e.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.a().c(context, jSONObject, aVar);
        return true;
    }
}
