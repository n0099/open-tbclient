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
        public final /* synthetic */ int f42884a;

        public a(int i) {
            this.f42884a = i;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.y(jSONObject, this.f42884a);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f42886a;

        public b(int i) {
            this.f42886a = i;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.B(jSONObject, this.f42886a);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42888f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42889g;

        public c(JSONObject jSONObject, int i) {
            this.f42888f = jSONObject;
            this.f42889g = i;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                int optInt = this.f42888f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                String optString = this.f42888f.optString("authTypeDes", "");
                if (optInt == 103000) {
                    if (!d.b.f0.b.c.f42829c) {
                        e.this.u = System.currentTimeMillis();
                        e.this.f42941h = this.f42888f.optString("token", "");
                        e.this.d(this.f42889g, 0, 0, e.this.f42936c, "preVerify success", 3);
                        return;
                    }
                    e.this.d(this.f42889g, 1, 999, e.this.f42936c, "device has risk.", 3);
                } else if (optInt == 105312 && e.this.f42936c != e.this.f42937d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("pre verify");
                    sb.append(" error, wrong sim operator");
                    e.this.d(this.f42889g, 3, 2002, e.this.f42936c, sb.toString(), 3);
                } else {
                    e eVar = e.this;
                    int i = this.f42889g;
                    int i2 = e.this.f42936c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("pre verify");
                    sb2.append(" error.");
                    sb2.append(optString);
                    eVar.d(i, 2, optInt, i2, sb2.toString(), 3);
                }
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
                e eVar2 = e.this;
                int i3 = this.f42889g;
                int i4 = eVar2.f42936c;
                eVar2.d(i3, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, i4, "cm on handle pre verify unknown error.", 3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42891f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42892g;

        public d(JSONObject jSONObject, int i) {
            this.f42891f = jSONObject;
            this.f42892g = i;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                int optInt = this.f42891f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                String optString = this.f42891f.optString("desc", "");
                if (optInt == 103000) {
                    if (!d.b.f0.b.c.f42829c) {
                        e.this.t = System.currentTimeMillis();
                        e.this.f42940g = this.f42891f.optString("securityphone", "");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, e.this.f42940g);
                        e.this.d(this.f42892g, 0, 0, e.this.f42936c, jSONObject.toString(), 1);
                        return;
                    }
                    e.this.d(this.f42892g, 1, 999, e.this.f42936c, "device has risk.", 1);
                } else if (optInt == 105312 && e.this.f42936c != e.this.f42937d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("pre login");
                    sb.append(" error, wrong sim operator");
                    e.this.d(this.f42892g, 3, 2002, e.this.f42936c, sb.toString(), 1);
                } else {
                    e eVar = e.this;
                    int i = this.f42892g;
                    int i2 = e.this.f42936c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("pre login");
                    sb2.append(" error.");
                    sb2.append(optString);
                    eVar.d(i, 2, optInt, i2, sb2.toString(), 1);
                }
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
                e eVar2 = e.this;
                int i3 = this.f42892g;
                int i4 = eVar2.f42936c;
                eVar2.d(i3, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, i4, "cm on handle pre login unknown error.", 1);
            }
        }
    }

    /* renamed from: d.b.f0.e.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0582e extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42894f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42895g;

        public C0582e(JSONObject jSONObject, int i) {
            this.f42894f = jSONObject;
            this.f42895g = i;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                int optInt = this.f42894f.has(MiPushCommandMessage.KEY_RESULT_CODE) ? this.f42894f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1) : -1;
                if (optInt == 103000) {
                    e.this.f42938e = this.f42894f.optString("token");
                    e.this.a(this.f42895g);
                    return;
                }
                String optString = this.f42894f.optString("resultDesc", "");
                e eVar = e.this;
                int i = this.f42895g;
                int i2 = e.this.f42936c;
                StringBuilder sb = new StringBuilder();
                sb.append("error:");
                sb.append(optString);
                eVar.c(i, 2, optInt, i2, sb.toString());
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
                e eVar2 = e.this;
                eVar2.c(this.f42895g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, eVar2.f42936c, "cm on handle login unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42897f;

        public f(int i) {
            this.f42897f = i;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                e.this.f(this.f42897f, e.this.f42936c, e.this.f42941h);
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
                e eVar = e.this;
                eVar.l(this.f42897f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, eVar.f42936c, "cm on handle verify unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f42899a;

        public g(int i) {
            this.f42899a = i;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.v(jSONObject, this.f42899a);
        }
    }

    public e(Context context) {
        super(context);
        this.t = 0L;
        this.u = 0L;
        this.v = false;
        this.f42936c = 1;
    }

    public final void B(JSONObject jSONObject, int i) {
        d.b.f0.k.e.c().b(new c(jSONObject, i));
    }

    @Override // d.b.f0.e.i
    public void g(Context context, int i) {
        super.g(context, i);
        if (!d.b.f0.b.a.g(this.f42934a).c()) {
            d(i, 3, 997, this.f42936c, "pre login error. sdk stop run.", 1);
        } else if (!q()) {
            d(i, 3, 2006, this.f42936c, "pre login error. cm has not valid config.", 1);
        } else if (d.b.f0.b.a.g(this.f42934a).m0()) {
            if (!this.v) {
                AuthnHelper authnHelper = AuthnHelper.getInstance(this.f42934a);
                this.s = authnHelper;
                authnHelper.setOverTime(8000L);
                this.v = true;
            }
            this.s.getPhoneInfo(i.k, i.l, new a(i));
        } else {
            d(i, 3, 994, this.f42936c, "pre login error. cm sdk stop run.", 1);
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
        if (!d.b.f0.b.a.g(this.f42934a).c()) {
            d(i, 3, 997, this.f42936c, "pre verify error. sdk stop run.", 3);
        } else if (!q()) {
            d(i, 3, 2006, this.f42936c, "pre verify error. cm has not valid config.", 3);
        } else if (d.b.f0.b.a.g(this.f42934a).m0()) {
            if (!this.v) {
                AuthnHelper authnHelper = AuthnHelper.getInstance(this.f42934a);
                this.s = authnHelper;
                authnHelper.setOverTime(8000L);
                this.v = true;
            }
            this.s.mobileAuth(i.k, i.l, new b(i));
        } else {
            d(i, 3, 994, this.f42936c, "pre verify error. cm sdk stop run.", 3);
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
        this.f42938e = null;
    }

    @Override // d.b.f0.e.i
    public void s() {
        this.f42941h = null;
        this.u = 0L;
    }

    public final void v(JSONObject jSONObject, int i) {
        d.b.f0.k.e.c().b(new C0582e(jSONObject, i));
    }

    public final void y(JSONObject jSONObject, int i) {
        d.b.f0.k.e.c().b(new d(jSONObject, i));
    }

    public final void z(int i) {
        d.b.f0.k.e.c().b(new f(i));
    }
}
