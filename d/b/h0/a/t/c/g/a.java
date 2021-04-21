package d.b.h0.a.t.c.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.mapsdkplatform.comapi.location.CoordinateType;
import d.b.h0.a.i2.k0;
import d.b.h0.a.r1.e;
import d.b.h0.a.t.b.d;
import d.b.h0.a.t.c.g.b;
import d.b.h0.a.v1.c.h;
import d.b.h0.a.v1.c.i.b;
import d.b.h0.a.w0.c.d;
import d.b.h0.a.z0.f;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends d implements b.c {

    /* renamed from: d.b.h0.a.t.c.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0845a implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f46790e;

        public C0845a(c cVar) {
            this.f46790e = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            a.this.s(hVar, this.f46790e, false);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.h0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46792e;

        /* renamed from: d.b.h0.a.t.c.g.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0846a implements d.a {
            public C0846a(b bVar) {
            }

            @Override // d.b.h0.a.w0.c.d.a
            public void a(d.b.h0.a.t1.k.k0.b bVar) {
                HashMap hashMap = new HashMap();
                hashMap.put("data", bVar.a().toString());
                f.V().N(new d.b.h0.a.k0.b.b("locationChange", hashMap));
            }

            @Override // d.b.h0.a.w0.c.d.a
            public void onFailed(int i) {
            }
        }

        public b(String str) {
            this.f46792e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (!d.b.h0.a.v1.c.c.h(hVar)) {
                int b2 = hVar.b();
                a.this.c(this.f46792e, new d.b.h0.a.t.e.b(b2, d.b.h0.a.v1.c.c.f(b2)));
            } else if (!k0.I()) {
                a.this.c(this.f46792e, new d.b.h0.a.t.e.b(10005, d.b.h0.a.v1.c.c.f(10005)));
            } else {
                a.this.c(this.f46792e, new d.b.h0.a.t.e.b(0));
                d.b.h0.a.w0.a.w().e(new C0846a(this));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public String f46794a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f46795b;

        /* renamed from: c  reason: collision with root package name */
        public String f46796c;

        public static c b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            c cVar = new c();
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("type");
                cVar.f46794a = optString;
                if (TextUtils.isEmpty(optString)) {
                    cVar.f46794a = CoordinateType.WGS84;
                }
                cVar.f46795b = jSONObject.optBoolean("altitude");
                String optString2 = jSONObject.optString("cb");
                cVar.f46796c = optString2;
                if (TextUtils.isEmpty(optString2)) {
                    return null;
                }
                return cVar;
            } catch (JSONException e2) {
                if (d.b.h0.a.t.b.d.f46650c) {
                    Log.e("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e2));
                }
                d.b.h0.a.c0.c.b("Api-GetLocationAction", "parse failed: " + Log.getStackTraceString(e2));
                return null;
            }
        }

        public boolean a() {
            return (TextUtils.equals(this.f46794a, CoordinateType.WGS84) || TextUtils.equals(this.f46794a, "gcj02") || TextUtils.equals(this.f46794a, "bd09ll")) && !TextUtils.isEmpty(this.f46796c);
        }
    }

    public a(@NonNull d.b.h0.a.t.b.b bVar) {
        super(bVar);
    }

    @Override // d.b.h0.a.t.c.g.b.c
    public void b(c cVar, int i) {
        d.b.h0.a.c0.c.b("Api-GetLocationAction", "request location error code : " + i);
        c(cVar.f46796c, new d.b.h0.a.t.e.b(1001, String.valueOf(i)));
    }

    @Override // d.b.h0.a.t.c.g.b.c
    public void d(c cVar, String str) {
        c(cVar.f46796c, new d.b.h0.a.t.e.b(10005, "system deny"));
    }

    @Override // d.b.h0.a.t.c.g.b.c
    public void f(c cVar, d.b.h0.a.t1.k.k0.b bVar) {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-GetLocationAction", "convert info : " + bVar.a());
        }
        c(cVar.f46796c, new d.b.h0.a.t.e.b(0, "success", bVar.a()));
    }

    public d.b.h0.a.t.e.b r(String str) {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-GetLocationAction", "handle: " + str);
        }
        e O = e.O();
        if (O == null) {
            return new d.b.h0.a.t.e.b(1001, "SwanApp is null");
        }
        Pair<d.b.h0.a.t.e.b, JSONObject> a2 = d.b.h0.a.t.f.b.a("Api-GetLocationAction", str);
        d.b.h0.a.t.e.b bVar = (d.b.h0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.h0.a.t.b.d.f46650c) {
                d.b.h0.a.c0.c.b("Api-GetLocationAction", "parse fail");
            }
            return bVar;
        }
        c b2 = c.b(((JSONObject) a2.second).toString());
        if (b2 != null && b2.a()) {
            if (TextUtils.isEmpty(b2.f46796c)) {
                d.b.h0.a.c0.c.b("Api-GetLocationAction", "empty cb");
                return new d.b.h0.a.t.e.b(201, "empty cb");
            }
            O.R().g(h(), "mapp_location", new C0845a(b2));
            return new d.b.h0.a.t.e.b(0);
        }
        d.b.h0.a.c0.c.b("Api-GetLocationAction", "params is invalid");
        return new d.b.h0.a.t.e.b(201, "params is invalid");
    }

    public final void s(h<b.e> hVar, c cVar, boolean z) {
        d.b.h0.a.c0.c.g("Api-GetLocationAction", "authorized result is " + hVar);
        if (d.b.h0.a.v1.c.c.h(hVar)) {
            d.b.h0.a.t.c.g.b.d().e(cVar, this, z);
            return;
        }
        int b2 = hVar.b();
        c(cVar.f46796c, new d.b.h0.a.t.e.b(b2, d.b.h0.a.v1.c.c.f(b2)));
    }

    public d.b.h0.a.t.e.b t(String str) {
        if (d.b.h0.a.t.b.d.f46650c) {
            Log.d("Api-GetLocationAction", "handle: " + str);
        }
        e O = e.O();
        if (O == null) {
            return new d.b.h0.a.t.e.b(1001, "SwanApp is null");
        }
        Pair<d.b.h0.a.t.e.b, JSONObject> a2 = d.b.h0.a.t.f.b.a("Api-GetLocationAction", str);
        d.b.h0.a.t.e.b bVar = (d.b.h0.a.t.e.b) a2.first;
        if (!bVar.b()) {
            if (d.b.h0.a.t.b.d.f46650c) {
                d.b.h0.a.c0.c.b("Api-GetLocationAction", "parse fail");
            }
            return bVar;
        }
        String optString = ((JSONObject) a2.second).optString("cb");
        if (TextUtils.isEmpty(optString)) {
            return new d.b.h0.a.t.e.b(201, "empty cb");
        }
        O.R().g(h(), "mapp_location", new b(optString));
        return new d.b.h0.a.t.e.b(0);
    }

    public d.b.h0.a.t.e.b u() {
        d.b.h0.a.w0.a.w().c();
        return new d.b.h0.a.t.e.b(0);
    }
}
