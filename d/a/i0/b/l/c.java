package d.a.i0.b.l;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.bdprivate.extensions.quicklogin.QuickLoginInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.a.i0.a.e2.c.i;
import d.a.i0.a.e2.c.j.b;
import d.a.i0.b.n.g.e;
import d.a.i0.b.n.g.f;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.i0.a.u.c.d {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46105e;

        public a(String str) {
            this.f46105e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                c.this.w(this.f46105e);
                return;
            }
            int b2 = iVar.b();
            String f2 = d.a.i0.a.e2.c.d.f(b2);
            if (d.a.i0.a.u.c.d.f44636c) {
                Log.e("Api-QuickLogin", "quick login failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            c.this.d(this.f46105e, new d.a.i0.a.u.h.b(b2, d.a.i0.a.e2.c.d.f(b2)));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.i0.b.n.g.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46107a;

        /* loaded from: classes3.dex */
        public class a implements e {
            public a() {
            }

            @Override // d.a.i0.b.n.g.e
            public void onResult(int i2) {
                if (i2 == 0) {
                    b bVar = b.this;
                    c.this.d(bVar.f46107a, new d.a.i0.a.u.h.b(0));
                    return;
                }
                b bVar2 = b.this;
                c.this.d(bVar2.f46107a, new d.a.i0.a.u.h.b(10004, "user not logged in"));
            }
        }

        public b(String str) {
            this.f46107a = str;
        }

        @Override // d.a.i0.b.n.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            if (quickLoginInfo == null) {
                c.this.d(this.f46107a, new d.a.i0.a.u.h.b(1001));
                return;
            }
            boolean z = quickLoginInfo.supportQuickLogin;
            int i2 = quickLoginInfo.loginMode;
            if (z) {
                f.e(d.a.i0.a.a2.d.g().x(), i2, new a());
            } else {
                c.this.d(this.f46107a, new d.a.i0.a.u.h.b(10004, "user not logged in"));
            }
        }
    }

    /* renamed from: d.a.i0.b.l.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0935c implements d.a.i0.a.v2.e1.b<i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46110e;

        public C0935c(String str) {
            this.f46110e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            if (d.a.i0.a.e2.c.d.h(iVar)) {
                c.this.v(this.f46110e);
                return;
            }
            int b2 = iVar.b();
            String f2 = d.a.i0.a.e2.c.d.f(b2);
            if (d.a.i0.a.u.c.d.f44636c) {
                Log.e("Api-QuickLogin", "query quick login info failed: auth fail(" + b2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + f2 + SmallTailInfo.EMOTION_SUFFIX);
            }
            c.this.d(this.f46110e, new d.a.i0.a.u.h.b(b2, d.a.i0.a.e2.c.d.f(b2)));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements d.a.i0.b.n.g.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46112a;

        public d(String str) {
            this.f46112a = str;
        }

        @Override // d.a.i0.b.n.g.c
        public void a(QuickLoginInfo quickLoginInfo) {
            if (quickLoginInfo == null) {
                c.this.x(this.f46112a);
            } else {
                c.this.y(this.f46112a, quickLoginInfo);
            }
        }
    }

    public c(@NonNull d.a.i0.a.u.c.b bVar) {
        super(bVar);
    }

    public d.a.i0.a.u.h.b A(String str) {
        Object obj;
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-QuickLogin", "exec quickLogin");
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-QuickLogin", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (bVar.a() && (obj = b2.second) != null) {
            String optString = ((JSONObject) obj).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.i0.a.u.h.b(1001, "cb is empty");
            }
            d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
            if (Q == null) {
                return new d.a.i0.a.u.h.b(1001);
            }
            Q.T().g(i(), "scope_quick_login", new a(optString));
            return new d.a.i0.a.u.h.b(0);
        }
        d.a.i0.a.e0.d.b("Api-QuickLogin", "parse fail");
        return bVar;
    }

    public final void v(String str) {
        f.b(new d(str));
    }

    public final void w(String str) {
        f.b(new b(str));
    }

    public final void x(String str) {
        d(str, new d.a.i0.a.u.h.b(10001, "internal error"));
    }

    public final void y(String str, QuickLoginInfo quickLoginInfo) {
        if (quickLoginInfo == null) {
            d(str, new d.a.i0.a.u.h.b(1001));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("supportQuickLogin", quickLoginInfo.supportQuickLogin);
            jSONObject.put("encryptPhoneNum", quickLoginInfo.encryptPhoneNum);
            jSONObject.put("serviceAgreement", quickLoginInfo.serviceAgreement);
            jSONObject.put("hasHistory", quickLoginInfo.hasHistory);
            if (d.a.i0.a.u.c.d.f44636c) {
                Log.d("Api-QuickLogin", "query login info; data: " + jSONObject.toString());
            }
            d(str, new d.a.i0.a.u.h.b(0, jSONObject));
        } catch (JSONException e2) {
            if (d.a.i0.a.u.c.d.f44636c) {
                e2.printStackTrace();
            }
            d(str, new d.a.i0.a.u.h.b(1001));
        }
    }

    public d.a.i0.a.u.h.b z(String str) {
        Object obj;
        if (d.a.i0.a.u.c.d.f44636c) {
            Log.d("Api-QuickLogin", "query quick login info");
        }
        Pair<d.a.i0.a.u.h.b, JSONObject> b2 = d.a.i0.a.u.i.b.b("Api-QuickLogin", str);
        d.a.i0.a.u.h.b bVar = (d.a.i0.a.u.h.b) b2.first;
        if (bVar.a() && (obj = b2.second) != null) {
            String optString = ((JSONObject) obj).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                return new d.a.i0.a.u.h.b(1001, "cb is empty");
            }
            d.a.i0.a.a2.e Q = d.a.i0.a.a2.e.Q();
            if (Q == null) {
                return new d.a.i0.a.u.h.b(1001);
            }
            Q.T().g(i(), "scope_quick_login", new C0935c(optString));
            return new d.a.i0.a.u.h.b(0);
        }
        d.a.i0.a.e0.d.b("Api-QuickLogin", "parse fail");
        return bVar;
    }
}
