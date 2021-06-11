package d.a.b0;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f41946a;

    public static synchronized c e() {
        c cVar;
        synchronized (c.class) {
            if (f41946a == null) {
                synchronized (c.class) {
                    if (f41946a == null) {
                        f41946a = new c();
                    }
                }
            }
            cVar = f41946a;
        }
        return cVar;
    }

    public boolean a(Activity activity, String str, d.a.b0.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.a().b(activity, str, aVar);
        return true;
    }

    public boolean b(Activity activity, String str, d.a.b0.e.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b.a().d(activity, str, aVar);
        return true;
    }

    public boolean c(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        b.a().f(context, jSONObject);
        return true;
    }

    public boolean d(Context context, JSONObject jSONObject, d.a.b0.e.a aVar) {
        if (jSONObject == null) {
            return false;
        }
        b.a().c(context, jSONObject, aVar);
        return true;
    }
}
