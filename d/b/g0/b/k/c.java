package d.b.g0.b.k;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.b.g0.a.v1.c.h;
import d.b.g0.a.v1.c.i.b;
import d.b.g0.b.m.g.e;
import d.b.g0.b.m.g.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.b.g0.a.t.b.d {

    /* loaded from: classes3.dex */
    public class a implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47319e;

        public a(String str) {
            this.f47319e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                c.this.v(this.f47319e);
                return;
            }
            int b2 = hVar.b();
            String f2 = d.b.g0.a.v1.c.c.f(b2);
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.e("Api-QuickLogin", "quick login failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            c.this.c(this.f47319e, new d.b.g0.a.t.e.b(b2, d.b.g0.a.v1.c.c.f(b2)));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.g0.b.m.g.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47321a;

        /* loaded from: classes3.dex */
        public class a implements e {
            public a() {
            }

            @Override // d.b.g0.b.m.g.e
            public void onResult(int i) {
                if (i == 0) {
                    b bVar = b.this;
                    c.this.c(bVar.f47321a, new d.b.g0.a.t.e.b(0));
                    return;
                }
                b bVar2 = b.this;
                c.this.c(bVar2.f47321a, new d.b.g0.a.t.e.b(10004, "user not logged in"));
            }
        }

        public b(String str) {
            this.f47321a = str;
        }

        @Override // d.b.g0.b.m.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            if (quickLoginInfo == null) {
                c.this.c(this.f47321a, new d.b.g0.a.t.e.b(1001));
                return;
            }
            boolean z = quickLoginInfo.supportQuickLogin;
            int i = quickLoginInfo.loginMode;
            if (z) {
                f.e(d.b.g0.a.r1.d.e().n(), i, new a());
            } else {
                c.this.c(this.f47321a, new d.b.g0.a.t.e.b(10004, "user not logged in"));
            }
        }
    }

    /* renamed from: d.b.g0.b.k.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0903c implements d.b.g0.a.i2.u0.b<h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47324e;

        public C0903c(String str) {
            this.f47324e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(h<b.e> hVar) {
            if (d.b.g0.a.v1.c.c.h(hVar)) {
                c.this.u(this.f47324e);
                return;
            }
            int b2 = hVar.b();
            String f2 = d.b.g0.a.v1.c.c.f(b2);
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.e("Api-QuickLogin", "query quick login info failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            c.this.c(this.f47324e, new d.b.g0.a.t.e.b(b2, d.b.g0.a.v1.c.c.f(b2)));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.b.g0.b.m.g.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f47326a;

        public d(String str) {
            this.f47326a = str;
        }

        @Override // d.b.g0.b.m.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            if (quickLoginInfo == null) {
                c.this.w(this.f47326a);
            } else {
                c.this.x(this.f47326a, quickLoginInfo);
            }
        }
    }

    public c(@NonNull d.b.g0.a.t.b.b bVar) {
        super(bVar);
    }

    public final void u(String str) {
        f.b(new d(str));
    }

    public final void v(String str) {
        f.b(new b(str));
    }

    public final void w(String str) {
        c(str, new d.b.g0.a.t.e.b(10001, "internal error"));
    }

    public final void x(String str, QuickLoginInfo quickLoginInfo) {
        if (quickLoginInfo == null) {
            c(str, new d.b.g0.a.t.e.b(1001));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("supportQuickLogin", quickLoginInfo.supportQuickLogin);
            jSONObject.put("encryptPhoneNum", quickLoginInfo.encryptPhoneNum);
            jSONObject.put("serviceAgreement", quickLoginInfo.serviceAgreement);
            jSONObject.put("hasHistory", quickLoginInfo.hasHistory);
            if (d.b.g0.a.t.b.d.f45929c) {
                Log.d("Api-QuickLogin", "query login info; data: " + jSONObject.toString());
            }
            c(str, new d.b.g0.a.t.e.b(0, jSONObject));
        } catch (JSONException e2) {
            if (d.b.g0.a.t.b.d.f45929c) {
                e2.printStackTrace();
            }
            c(str, new d.b.g0.a.t.e.b(1001));
        }
    }

    public d.b.g0.a.t.e.b y(String str) {
        Object obj;
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-QuickLogin", "query quick login info");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-QuickLogin", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (bVar.b() && (obj = a2.second) != null) {
            String optString = ((JSONObject) obj).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.b.g0.a.t.e.b(1001, "cb is empty");
            }
            d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
            if (O == null) {
                return new d.b.g0.a.t.e.b(1001);
            }
            O.R().g(h(), "scope_quick_login", new C0903c(optString));
            return new d.b.g0.a.t.e.b(0);
        }
        d.b.g0.a.c0.c.b("Api-QuickLogin", "parse fail");
        return bVar;
    }

    public d.b.g0.a.t.e.b z(String str) {
        Object obj;
        if (d.b.g0.a.t.b.d.f45929c) {
            Log.d("Api-QuickLogin", "exec quickLogin");
        }
        Pair<d.b.g0.a.t.e.b, JSONObject> a2 = d.b.g0.a.t.f.b.a("Api-QuickLogin", str);
        d.b.g0.a.t.e.b bVar = (d.b.g0.a.t.e.b) a2.first;
        if (bVar.b() && (obj = a2.second) != null) {
            String optString = ((JSONObject) obj).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.b.g0.a.t.e.b(1001, "cb is empty");
            }
            d.b.g0.a.r1.e O = d.b.g0.a.r1.e.O();
            if (O == null) {
                return new d.b.g0.a.t.e.b(1001);
            }
            O.R().g(h(), "scope_quick_login", new a(optString));
            return new d.b.g0.a.t.e.b(0);
        }
        d.b.g0.a.c0.c.b("Api-QuickLogin", "parse fail");
        return bVar;
    }
}
