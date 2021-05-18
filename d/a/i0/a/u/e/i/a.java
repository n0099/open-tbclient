package d.a.i0.a.u.e.i;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import d.a.i0.a.a2.e;
import d.a.i0.a.c1.d.d;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.a.g1.f;
import d.a.i0.a.u.c.d;
import d.a.i0.a.u.e.i.b;
import d.a.i0.a.v2.q0;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d implements b.c {

    /* renamed from: d.a.i0.a.u.e.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0840a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f44842e;

        public C0840a(c cVar) {
            this.f44842e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            a.this.t(iVar, this.f44842e, false);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44844e;

        /* renamed from: d.a.i0.a.u.e.i.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0841a implements d.a {
            public C0841a(b bVar) {
            }

            @Override // d.a.i0.a.c1.d.d.a
            public void a(d.a.i0.a.c2.f.k0.b bVar) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", bVar.a().toString());
                f.V().v(new d.a.i0.a.o0.d.b("locationChange", hashMap));
            }

            @Override // d.a.i0.a.c1.d.d.a
            public void onFailed(int i2) {
            }
        }

        public b(String str) {
            this.f44844e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (!d.a.i0.a.e2.c.d.h(iVar)) {
                int b2 = iVar.b();
                a.this.d(this.f44844e, new d.a.i0.a.u.h.b(b2, d.a.i0.a.e2.c.d.f(b2)));
            } else if (!q0.L()) {
                a.this.d(this.f44844e, new d.a.i0.a.u.h.b(10005, d.a.i0.a.e2.c.d.f(10005)));
            } else {
                a.this.d(this.f44844e, new d.a.i0.a.u.h.b(0));
                d.a.i0.a.c1.a.E().f(new C0841a(this));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f44846a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f44847b;

        /* renamed from: c  reason: collision with root package name */
        public String f44848c;

        public static c b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            c cVar = new c();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("type");
                cVar.f44846a = optString;
                if (TextUtils.isEmpty(optString)) {
                    cVar.f44846a = CoordinateType.WGS84;
                }
                cVar.f44847b = jSONObject.optBoolean("altitude");
                String optString2 = jSONObject.optString("cb");
                cVar.f44848c = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    return null;
                }
                return cVar;
            } catch (JSONException e2) {
                if (d.a.i0.a.u.c.d.f44636c) {
                    Log.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e2));
                }
                d.a.i0.a.e0.d.b("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e2));
                return null;
            }
        }

        public boolean a() {
            return (TextUtils.equals(this.f44846a, CoordinateType.WGS84) || TextUtils.equals(this.f44846a, "gcj02") || TextUtils.equals(this.f44846a, "bd09ll")) && !TextUtils.isEmpty(this.f44848c);
        }
    }

    public a(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    @Override // d.a.i0.a.u.e.i.b.c
    public void b(c cVar, int i2) {
        d.a.i0.a.e0.d.b("Api-GetLocationAction", "request location error code : " + i2);
        d(cVar.f44848c, new d.a.i0.a.u.h.b(1001, String.valueOf(i2)));
    }

    @Override // d.a.i0.a.u.e.i.b.c
    public void f(c cVar, String str) {
        d(cVar.f44848c, new d.a.i0.a.u.h.b(10005, "system deny"));
    }

    @Override // d.a.i0.a.u.e.i.b.c
    public void g(c cVar, d.a.i0.a.c2.f.k0.b bVar) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-GetLocationAction", "convert info : " + bVar.a());
        }
        d(cVar.f44848c, new d.a.i0.a.u.h.b(0, "success", bVar.a()));
    }

    public d.a.i0.a.u.h.b s(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-GetLocationAction", "handle: " + str);
        }
        e Q = e.Q();
        if (Q == null) {
            return new d.a.i0.a.u.h.b(1001, "SwanApp is null");
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-GetLocationAction", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.i0.a.u.c.d.f44636c) {
                d.a.i0.a.e0.d.b("Api-GetLocationAction", "parse fail");
            }
            return bVar;
        }
        c b3 = c.b(((JSONObject) b2.second).toString());
        if (b3 != null && b3.a()) {
            if (TextUtils.isEmpty(b3.f44848c)) {
                d.a.i0.a.e0.d.b("Api-GetLocationAction", "empty cb");
                return new d.a.i0.a.u.h.b(201, "empty cb");
            }
            Q.T().g(i(), "mapp_location", new C0840a(b3));
            return new d.a.i0.a.u.h.b(0);
        }
        d.a.i0.a.e0.d.b("Api-GetLocationAction", "params is invalid");
        return new d.a.i0.a.u.h.b(201, "params is invalid");
    }

    public final void t(i<b.e> iVar, c cVar, boolean z) {
        d.a.i0.a.e0.d.g("Api-GetLocationAction", "authorized result is " + iVar);
        if (d.a.i0.a.e2.c.d.h(iVar)) {
            d.a.i0.a.u.e.i.b.d().e(cVar, this, z);
            return;
        }
        int b2 = iVar.b();
        d(cVar.f44848c, new d.a.i0.a.u.h.b(b2, d.a.i0.a.e2.c.d.f(b2)));
    }

    public d.a.i0.a.u.h.b u(String str) {
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-GetLocationAction", "handle: " + str);
        }
        e Q = e.Q();
        if (Q == null) {
            return new d.a.i0.a.u.h.b(1001, "SwanApp is null");
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-GetLocationAction", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (!bVar.a()) {
            if (d.a.i0.a.u.c.d.f44636c) {
                d.a.i0.a.e0.d.b("Api-GetLocationAction", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) b2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new d.a.i0.a.u.h.b(201, "empty cb");
        }
        Q.T().g(i(), "mapp_location", new b(optString));
        return new d.a.i0.a.u.h.b(0);
    }

    public d.a.i0.a.u.h.b v() {
        d.a.i0.a.c1.a.E().e();
        return new d.a.i0.a.u.h.b(0);
    }
}
