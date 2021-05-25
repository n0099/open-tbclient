package d.a.j0.e;

import android.content.Context;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.cmic.sso.sdk.auth.AuthnHelper;
import com.cmic.sso.sdk.auth.TokenListener;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e extends i {
    public AuthnHelper s;
    public long t;
    public long u;
    public boolean v;

    /* loaded from: classes2.dex */
    public class a implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f40324a;

        public a(int i2) {
            this.f40324a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.y(jSONObject, this.f40324a);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f40326a;

        public b(int i2) {
            this.f40326a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.B(jSONObject, this.f40326a);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f40328f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40329g;

        public c(JSONObject jSONObject, int i2) {
            this.f40328f = jSONObject;
            this.f40329g = i2;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                int optInt = this.f40328f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                String optString = this.f40328f.optString("authTypeDes", "");
                if (optInt == 103000) {
                    if (!d.a.j0.b.c.f40269c) {
                        e.this.u = System.currentTimeMillis();
                        e.this.f40386h = this.f40328f.optString("token", "");
                        e.this.d(this.f40329g, 0, 0, e.this.f40381c, "preVerify success", 3);
                        return;
                    }
                    e.this.d(this.f40329g, 1, 999, e.this.f40381c, "device has risk.", 3);
                } else if (optInt == 105312 && e.this.f40381c != e.this.f40382d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("pre verify");
                    sb.append(" error, wrong sim operator");
                    e.this.d(this.f40329g, 3, 2002, e.this.f40381c, sb.toString(), 3);
                } else {
                    e eVar = e.this;
                    int i2 = this.f40329g;
                    int i3 = e.this.f40381c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("pre verify");
                    sb2.append(" error.");
                    sb2.append(optString);
                    eVar.d(i2, 2, optInt, i3, sb2.toString(), 3);
                }
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
                e eVar2 = e.this;
                int i4 = this.f40329g;
                int i5 = eVar2.f40381c;
                eVar2.d(i4, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, i5, "cm on handle pre verify unknown error.", 3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f40331f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40332g;

        public d(JSONObject jSONObject, int i2) {
            this.f40331f = jSONObject;
            this.f40332g = i2;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                int optInt = this.f40331f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                String optString = this.f40331f.optString("desc", "");
                if (optInt == 103000) {
                    if (!d.a.j0.b.c.f40269c) {
                        e.this.t = System.currentTimeMillis();
                        e.this.f40385g = this.f40331f.optString("securityphone", "");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, e.this.f40385g);
                        e.this.d(this.f40332g, 0, 0, e.this.f40381c, jSONObject.toString(), 1);
                        return;
                    }
                    e.this.d(this.f40332g, 1, 999, e.this.f40381c, "device has risk.", 1);
                } else if (optInt == 105312 && e.this.f40381c != e.this.f40382d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("pre login");
                    sb.append(" error, wrong sim operator");
                    e.this.d(this.f40332g, 3, 2002, e.this.f40381c, sb.toString(), 1);
                } else {
                    e eVar = e.this;
                    int i2 = this.f40332g;
                    int i3 = e.this.f40381c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("pre login");
                    sb2.append(" error.");
                    sb2.append(optString);
                    eVar.d(i2, 2, optInt, i3, sb2.toString(), 1);
                }
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
                e eVar2 = e.this;
                int i4 = this.f40332g;
                int i5 = eVar2.f40381c;
                eVar2.d(i4, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, i5, "cm on handle pre login unknown error.", 1);
            }
        }
    }

    /* renamed from: d.a.j0.e.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0552e extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f40334f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40335g;

        public C0552e(JSONObject jSONObject, int i2) {
            this.f40334f = jSONObject;
            this.f40335g = i2;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                int optInt = this.f40334f.has(MiPushCommandMessage.KEY_RESULT_CODE) ? this.f40334f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1) : -1;
                if (optInt == 103000) {
                    e.this.f40383e = this.f40334f.optString("token");
                    e.this.a(this.f40335g);
                    return;
                }
                String optString = this.f40334f.optString("resultDesc", "");
                e eVar = e.this;
                int i2 = this.f40335g;
                int i3 = e.this.f40381c;
                StringBuilder sb = new StringBuilder();
                sb.append("error:");
                sb.append(optString);
                eVar.c(i2, 2, optInt, i3, sb.toString());
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
                e eVar2 = e.this;
                eVar2.c(this.f40335g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, eVar2.f40381c, "cm on handle login unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40337f;

        public f(int i2) {
            this.f40337f = i2;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                e.this.f(this.f40337f, e.this.f40381c, e.this.f40386h);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
                e eVar = e.this;
                eVar.l(this.f40337f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, eVar.f40381c, "cm on handle verify unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f40339a;

        public g(int i2) {
            this.f40339a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.v(jSONObject, this.f40339a);
        }
    }

    public e(Context context) {
        super(context);
        this.t = 0L;
        this.u = 0L;
        this.v = false;
        this.f40381c = 1;
    }

    public final void B(JSONObject jSONObject, int i2) {
        d.a.j0.k.e.c().b(new c(jSONObject, i2));
    }

    @Override // d.a.j0.e.i
    public void g(Context context, int i2) {
        super.g(context, i2);
        if (!d.a.j0.b.a.g(this.f40379a).c()) {
            d(i2, 3, 997, this.f40381c, "pre login error. sdk stop run.", 1);
        } else if (!q()) {
            d(i2, 3, 2006, this.f40381c, "pre login error. cm has not valid config.", 1);
        } else if (d.a.j0.b.a.g(this.f40379a).m0()) {
            if (!this.v) {
                AuthnHelper authnHelper = AuthnHelper.getInstance(this.f40379a);
                this.s = authnHelper;
                authnHelper.setOverTime(8000L);
                this.v = true;
            }
            this.s.getPhoneInfo(i.k, i.l, new a(i2));
        } else {
            d(i2, 3, 994, this.f40381c, "pre login error. cm sdk stop run.", 1);
        }
    }

    @Override // d.a.j0.e.i
    public void h(Context context, int i2, long j) {
        super.h(context, i2, j);
        b(i2, 2);
        this.s.loginAuth(i.k, i.l, new g(i2));
    }

    @Override // d.a.j0.e.i
    public boolean j() {
        return this.t == 0 || System.currentTimeMillis() - this.t >= TimeUnit.HOURS.toMillis(1L);
    }

    @Override // d.a.j0.e.i
    public void n(Context context, int i2) {
        super.n(context, i2);
        if (!d.a.j0.b.a.g(this.f40379a).c()) {
            d(i2, 3, 997, this.f40381c, "pre verify error. sdk stop run.", 3);
        } else if (!q()) {
            d(i2, 3, 2006, this.f40381c, "pre verify error. cm has not valid config.", 3);
        } else if (d.a.j0.b.a.g(this.f40379a).m0()) {
            if (!this.v) {
                AuthnHelper authnHelper = AuthnHelper.getInstance(this.f40379a);
                this.s = authnHelper;
                authnHelper.setOverTime(8000L);
                this.v = true;
            }
            this.s.mobileAuth(i.k, i.l, new b(i2));
        } else {
            d(i2, 3, 994, this.f40381c, "pre verify error. cm sdk stop run.", 3);
        }
    }

    @Override // d.a.j0.e.i
    public void o(Context context, int i2, long j) {
        super.o(context, i2, j);
        b(i2, 4);
        z(i2);
    }

    @Override // d.a.j0.e.i
    public boolean p() {
        return System.currentTimeMillis() - this.u > 115000;
    }

    @Override // d.a.j0.e.i
    public void r() {
        this.f40383e = null;
    }

    @Override // d.a.j0.e.i
    public void s() {
        this.f40386h = null;
        this.u = 0L;
    }

    public final void v(JSONObject jSONObject, int i2) {
        d.a.j0.k.e.c().b(new C0552e(jSONObject, i2));
    }

    public final void y(JSONObject jSONObject, int i2) {
        d.a.j0.k.e.c().b(new d(jSONObject, i2));
    }

    public final void z(int i2) {
        d.a.j0.k.e.c().b(new f(i2));
    }
}
