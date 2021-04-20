package d.b.f0.e;

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
        public final /* synthetic */ int f43276a;

        public a(int i) {
            this.f43276a = i;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.y(jSONObject, this.f43276a);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43278a;

        public b(int i) {
            this.f43278a = i;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.B(jSONObject, this.f43278a);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43280f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43281g;

        public c(JSONObject jSONObject, int i) {
            this.f43280f = jSONObject;
            this.f43281g = i;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                int optInt = this.f43280f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                String optString = this.f43280f.optString("authTypeDes", "");
                if (optInt == 103000) {
                    if (!d.b.f0.b.c.f43221c) {
                        e.this.u = System.currentTimeMillis();
                        e.this.f43333h = this.f43280f.optString("token", "");
                        e.this.d(this.f43281g, 0, 0, e.this.f43328c, "preVerify success", 3);
                        return;
                    }
                    e.this.d(this.f43281g, 1, 999, e.this.f43328c, "device has risk.", 3);
                } else if (optInt == 105312 && e.this.f43328c != e.this.f43329d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("pre verify");
                    sb.append(" error, wrong sim operator");
                    e.this.d(this.f43281g, 3, 2002, e.this.f43328c, sb.toString(), 3);
                } else {
                    e eVar = e.this;
                    int i = this.f43281g;
                    int i2 = e.this.f43328c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("pre verify");
                    sb2.append(" error.");
                    sb2.append(optString);
                    eVar.d(i, 2, optInt, i2, sb2.toString(), 3);
                }
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
                e eVar2 = e.this;
                int i3 = this.f43281g;
                int i4 = eVar2.f43328c;
                eVar2.d(i3, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, i4, "cm on handle pre verify unknown error.", 3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43283f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43284g;

        public d(JSONObject jSONObject, int i) {
            this.f43283f = jSONObject;
            this.f43284g = i;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                int optInt = this.f43283f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                String optString = this.f43283f.optString("desc", "");
                if (optInt == 103000) {
                    if (!d.b.f0.b.c.f43221c) {
                        e.this.t = System.currentTimeMillis();
                        e.this.f43332g = this.f43283f.optString("securityphone", "");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, e.this.f43332g);
                        e.this.d(this.f43284g, 0, 0, e.this.f43328c, jSONObject.toString(), 1);
                        return;
                    }
                    e.this.d(this.f43284g, 1, 999, e.this.f43328c, "device has risk.", 1);
                } else if (optInt == 105312 && e.this.f43328c != e.this.f43329d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("pre login");
                    sb.append(" error, wrong sim operator");
                    e.this.d(this.f43284g, 3, 2002, e.this.f43328c, sb.toString(), 1);
                } else {
                    e eVar = e.this;
                    int i = this.f43284g;
                    int i2 = e.this.f43328c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("pre login");
                    sb2.append(" error.");
                    sb2.append(optString);
                    eVar.d(i, 2, optInt, i2, sb2.toString(), 1);
                }
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
                e eVar2 = e.this;
                int i3 = this.f43284g;
                int i4 = eVar2.f43328c;
                eVar2.d(i3, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, i4, "cm on handle pre login unknown error.", 1);
            }
        }
    }

    /* renamed from: d.b.f0.e.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0594e extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43286f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43287g;

        public C0594e(JSONObject jSONObject, int i) {
            this.f43286f = jSONObject;
            this.f43287g = i;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                int optInt = this.f43286f.has(MiPushCommandMessage.KEY_RESULT_CODE) ? this.f43286f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1) : -1;
                if (optInt == 103000) {
                    e.this.f43330e = this.f43286f.optString("token");
                    e.this.a(this.f43287g);
                    return;
                }
                String optString = this.f43286f.optString("resultDesc", "");
                e eVar = e.this;
                int i = this.f43287g;
                int i2 = e.this.f43328c;
                StringBuilder sb = new StringBuilder();
                sb.append("error:");
                sb.append(optString);
                eVar.c(i, 2, optInt, i2, sb.toString());
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
                e eVar2 = e.this;
                eVar2.c(this.f43287g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, eVar2.f43328c, "cm on handle login unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43289f;

        public f(int i) {
            this.f43289f = i;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                e.this.f(this.f43289f, e.this.f43328c, e.this.f43333h);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
                e eVar = e.this;
                eVar.l(this.f43289f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, eVar.f43328c, "cm on handle verify unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43291a;

        public g(int i) {
            this.f43291a = i;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.v(jSONObject, this.f43291a);
        }
    }

    public e(Context context) {
        super(context);
        this.t = 0L;
        this.u = 0L;
        this.v = false;
        this.f43328c = 1;
    }

    public final void B(JSONObject jSONObject, int i) {
        d.b.f0.k.e.c().b(new c(jSONObject, i));
    }

    @Override // d.b.f0.e.i
    public void g(Context context, int i) {
        super.g(context, i);
        if (!d.b.f0.b.a.g(this.f43326a).c()) {
            d(i, 3, 997, this.f43328c, "pre login error. sdk stop run.", 1);
        } else if (!q()) {
            d(i, 3, 2006, this.f43328c, "pre login error. cm has not valid config.", 1);
        } else if (d.b.f0.b.a.g(this.f43326a).m0()) {
            if (!this.v) {
                AuthnHelper authnHelper = AuthnHelper.getInstance(this.f43326a);
                this.s = authnHelper;
                authnHelper.setOverTime(8000L);
                this.v = true;
            }
            this.s.getPhoneInfo(i.k, i.l, new a(i));
        } else {
            d(i, 3, 994, this.f43328c, "pre login error. cm sdk stop run.", 1);
        }
    }

    @Override // d.b.f0.e.i
    public void h(Context context, int i, long j) {
        super.h(context, i, j);
        b(i, 2);
        this.s.loginAuth(i.k, i.l, new g(i));
    }

    @Override // d.b.f0.e.i
    public boolean j() {
        return this.t == 0 || System.currentTimeMillis() - this.t >= TimeUnit.HOURS.toMillis(1L);
    }

    @Override // d.b.f0.e.i
    public void n(Context context, int i) {
        super.n(context, i);
        if (!d.b.f0.b.a.g(this.f43326a).c()) {
            d(i, 3, 997, this.f43328c, "pre verify error. sdk stop run.", 3);
        } else if (!q()) {
            d(i, 3, 2006, this.f43328c, "pre verify error. cm has not valid config.", 3);
        } else if (d.b.f0.b.a.g(this.f43326a).m0()) {
            if (!this.v) {
                AuthnHelper authnHelper = AuthnHelper.getInstance(this.f43326a);
                this.s = authnHelper;
                authnHelper.setOverTime(8000L);
                this.v = true;
            }
            this.s.mobileAuth(i.k, i.l, new b(i));
        } else {
            d(i, 3, 994, this.f43328c, "pre verify error. cm sdk stop run.", 3);
        }
    }

    @Override // d.b.f0.e.i
    public void o(Context context, int i, long j) {
        super.o(context, i, j);
        b(i, 4);
        z(i);
    }

    @Override // d.b.f0.e.i
    public boolean p() {
        return System.currentTimeMillis() - this.u > 115000;
    }

    @Override // d.b.f0.e.i
    public void r() {
        this.f43330e = null;
    }

    @Override // d.b.f0.e.i
    public void s() {
        this.f43333h = null;
        this.u = 0L;
    }

    public final void v(JSONObject jSONObject, int i) {
        d.b.f0.k.e.c().b(new C0594e(jSONObject, i));
    }

    public final void y(JSONObject jSONObject, int i) {
        d.b.f0.k.e.c().b(new d(jSONObject, i));
    }

    public final void z(int i) {
        d.b.f0.k.e.c().b(new f(i));
    }
}
