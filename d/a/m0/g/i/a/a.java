package d.a.m0.g.i.a;

import android.util.Log;
import d.a.m0.a.a2.e;
import d.a.m0.a.f2.a;
import d.a.m0.a.k;
import d.a.m0.a.u0.b;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends d.a.m0.g.f.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f50870c = k.f46983a;

    /* renamed from: d.a.m0.g.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1063a implements a.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f50871a;

        public C1063a(a aVar, b bVar) {
            this.f50871a = bVar;
        }

        @Override // d.a.m0.a.f2.a.f
        public void a(int i2) {
            if (i2 == -1) {
                a.c(this.f50871a, "202");
            } else if (i2 != 1) {
                this.f50871a.onFail(101, "noPermission");
            } else {
                a.c(this.f50871a, "200");
            }
        }
    }

    public a() {
        super("addShortcutToDesktop");
    }

    public static void c(b bVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", str);
        } catch (JSONException e2) {
            if (f50870c) {
                e2.printStackTrace();
            }
        }
        bVar.a(jSONObject);
    }

    @Override // d.a.m0.g.f.a
    public d.a.m0.a.u.h.b a(JSONObject jSONObject, b bVar) {
        e Q = e.Q();
        if (Q != null && Q.x() != null && Q.L() != null) {
            if (d.a.m0.a.f2.a.s(Q.x(), Q.L().K(), Q.L().H()) == 1) {
                c(bVar, "201");
                return null;
            }
            d.a.m0.a.f2.a.j(Q.x(), Q.L(), 1, new C1063a(this, bVar));
            return null;
        }
        bVar.onFail(100, "swan or activity is null");
        if (f50870c) {
            Log.d("AddShortcutToDesktop", "swan or activity is null");
            return null;
        }
        return null;
    }
}
