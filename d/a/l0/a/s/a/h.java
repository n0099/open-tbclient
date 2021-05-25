package d.a.l0.a.s.a;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static String f44592a;

    /* renamed from: b  reason: collision with root package name */
    public static final h f44593b = new h();

    public final String a() {
        String str = f44592a;
        if (str == null || StringsKt__StringsJVMKt.isBlank(str)) {
            f44592a = b();
        }
        return f44592a;
    }

    public final String b() {
        d.a.l0.a.k2.g.b a2 = d.a.l0.a.k2.g.h.a();
        if (a2 != null) {
            return a2.getString("alliance_login_uk", null);
        }
        return null;
    }

    public final void c(int i2, JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        if (i2 == 0) {
            e(jsonObject);
        }
    }

    public final void d() {
        d.a.l0.a.k2.g.h.a().putString("alliance_login_uk", "");
        f44592a = null;
    }

    public final void e(JSONObject jSONObject) {
        d.a.l0.a.k2.g.h.a().putString("alliance_login_uk", jSONObject.optString("uk"));
    }
}
