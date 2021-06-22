package d.a.m0.b.l;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.m0.a.e2.c.i;
import d.a.m0.a.e2.c.j.b;
import d.a.m0.b.n.g.e;
import d.a.m0.b.n.g.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.m0.a.u.c.d {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50063e;

        public a(String str) {
            this.f50063e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                c.this.w(this.f50063e);
                return;
            }
            int b2 = iVar.b();
            String f2 = d.a.m0.a.e2.c.d.f(b2);
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.e("Api-QuickLogin", "quick login failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            c.this.d(this.f50063e, new d.a.m0.a.u.h.b(b2, d.a.m0.a.e2.c.d.f(b2)));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.m0.b.n.g.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50065a;

        /* loaded from: classes3.dex */
        public class a implements e {
            public a() {
            }

            @Override // d.a.m0.b.n.g.e
            public void onResult(int i2) {
                if (i2 == 0) {
                    b bVar = b.this;
                    c.this.d(bVar.f50065a, new d.a.m0.a.u.h.b(0));
                    return;
                }
                b bVar2 = b.this;
                c.this.d(bVar2.f50065a, new d.a.m0.a.u.h.b(10004, "user not logged in"));
            }
        }

        public b(String str) {
            this.f50065a = str;
        }

        @Override // d.a.m0.b.n.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            if (quickLoginInfo == null) {
                c.this.d(this.f50065a, new d.a.m0.a.u.h.b(1001));
                return;
            }
            boolean z = quickLoginInfo.supportQuickLogin;
            int i2 = quickLoginInfo.loginMode;
            if (z) {
                f.e(d.a.m0.a.a2.d.g().x(), i2, new a());
            } else {
                c.this.d(this.f50065a, new d.a.m0.a.u.h.b(10004, "user not logged in"));
            }
        }
    }

    /* renamed from: d.a.m0.b.l.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1005c implements d.a.m0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50068e;

        public C1005c(String str) {
            this.f50068e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.m0.a.e2.c.d.h(iVar)) {
                c.this.v(this.f50068e);
                return;
            }
            int b2 = iVar.b();
            String f2 = d.a.m0.a.e2.c.d.f(b2);
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.e("Api-QuickLogin", "query quick login info failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            c.this.d(this.f50068e, new d.a.m0.a.u.h.b(b2, d.a.m0.a.e2.c.d.f(b2)));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.m0.b.n.g.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50070a;

        public d(String str) {
            this.f50070a = str;
        }

        @Override // d.a.m0.b.n.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            if (quickLoginInfo == null) {
                c.this.x(this.f50070a);
            } else {
                c.this.y(this.f50070a, quickLoginInfo);
            }
        }
    }

    public c(@NonNull d.a.m0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.m0.a.u.h.b A(String str) {
        Object obj;
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-QuickLogin", "exec quickLogin");
        }
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-QuickLogin", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (bVar.isSuccess() && (obj = b2.second) != null) {
            String optString = ((JSONObject) obj).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.m0.a.u.h.b(1001, "cb is empty");
            }
            d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
            if (Q == null) {
                return new d.a.m0.a.u.h.b(1001);
            }
            Q.T().g(i(), "scope_quick_login", new a(optString));
            return new d.a.m0.a.u.h.b(0);
        }
        d.a.m0.a.e0.d.b("Api-QuickLogin", "parse fail");
        return bVar;
    }

    public final void v(String str) {
        f.b(new d(str));
    }

    public final void w(String str) {
        f.b(new b(str));
    }

    public final void x(String str) {
        d(str, new d.a.m0.a.u.h.b(10001, "internal error"));
    }

    public final void y(String str, QuickLoginInfo quickLoginInfo) {
        if (quickLoginInfo == null) {
            d(str, new d.a.m0.a.u.h.b(1001));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("supportQuickLogin", quickLoginInfo.supportQuickLogin);
            jSONObject.put("encryptPhoneNum", quickLoginInfo.encryptPhoneNum);
            jSONObject.put("serviceAgreement", quickLoginInfo.serviceAgreement);
            jSONObject.put("hasHistory", quickLoginInfo.hasHistory);
            if (d.a.m0.a.u.c.d.f48594c) {
                Log.d("Api-QuickLogin", "query login info; data: " + jSONObject.toString());
            }
            d(str, new d.a.m0.a.u.h.b(0, jSONObject));
        } catch (JSONException e2) {
            if (d.a.m0.a.u.c.d.f48594c) {
                e2.printStackTrace();
            }
            d(str, new d.a.m0.a.u.h.b(1001));
        }
    }

    public d.a.m0.a.u.h.b z(String str) {
        Object obj;
        if (d.a.m0.a.u.c.d.f48594c) {
            Log.d("Api-QuickLogin", "query quick login info");
        }
        Pair<d.a.m0.a.u.h.b, JSONObject> b2 = d.a.m0.a.u.i.b.b("Api-QuickLogin", str);
        d.a.m0.a.u.h.b bVar = (d.a.m0.a.u.h.b) b2.first;
        if (bVar.isSuccess() && (obj = b2.second) != null) {
            String optString = ((JSONObject) obj).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.m0.a.u.h.b(1001, "cb is empty");
            }
            d.a.m0.a.a2.e Q = d.a.m0.a.a2.e.Q();
            if (Q == null) {
                return new d.a.m0.a.u.h.b(1001);
            }
            Q.T().g(i(), "scope_quick_login", new C1005c(optString));
            return new d.a.m0.a.u.h.b(0);
        }
        d.a.m0.a.e0.d.b("Api-QuickLogin", "parse fail");
        return bVar;
    }
}
