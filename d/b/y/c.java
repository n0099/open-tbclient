package d.b.y;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f65605a;

    public static synchronized c f() {
        c cVar;
        synchronized (c.class) {
            if (f65605a == null) {
                synchronized (c.class) {
                    if (f65605a == null) {
                        f65605a = new c();
                    }
                }
            }
            cVar = f65605a;
        }
        return cVar;
    }

    public boolean a(Activity activity, String str, d.b.y.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.a().d(activity, str, aVar);
        return true;
    }

    public boolean b(Activity activity, String str, d.b.y.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.a().c(activity, str, aVar);
        return true;
    }

    public boolean c(Activity activity, JSONObject jSONObject, d.b.y.e.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.a().g(activity, jSONObject, aVar);
        return true;
    }

    public boolean d(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.a().f(context, jSONObject);
        return true;
    }

    public boolean e(Context context, JSONObject jSONObject, d.b.y.e.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.a().a(context, jSONObject, aVar);
        return true;
    }
}
