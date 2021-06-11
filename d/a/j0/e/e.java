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
        public final /* synthetic */ int f44003a;

        public a(long j, int i2) {
            this.f44003a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.z(jSONObject, this.f44003a);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f44005a;

        public b(int i2) {
            this.f44005a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.C(jSONObject, this.f44005a);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44007f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44008g;

        public c(JSONObject jSONObject, int i2) {
            this.f44007f = jSONObject;
            this.f44008g = i2;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                int optInt = this.f44007f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                String optString = this.f44007f.optString("authTypeDes", "");
                if (optInt == 103000) {
                    if (!d.a.j0.b.c.f43950c) {
                        e.this.u = System.currentTimeMillis();
                        e.this.f44065h = this.f44007f.optString("token", "");
                        e.this.e(this.f44008g, 0, 0, e.this.f44060c, "preVerify success", 3);
                        return;
                    }
                    e.this.e(this.f44008g, 1, 999, e.this.f44060c, "device has risk.", 3);
                } else if (optInt == 105312 && e.this.f44060c != e.this.f44061d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("pre verify");
                    sb.append(" error, wrong sim operator");
                    e.this.e(this.f44008g, 3, 2002, e.this.f44060c, sb.toString(), 3);
                } else {
                    e eVar = e.this;
                    int i2 = this.f44008g;
                    int i3 = e.this.f44060c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("pre verify");
                    sb2.append(" error.");
                    sb2.append(optString);
                    eVar.e(i2, 2, optInt, i3, sb2.toString(), 3);
                }
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
                e eVar2 = e.this;
                int i4 = this.f44008g;
                int i5 = eVar2.f44060c;
                eVar2.e(i4, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, i5, "cm on handle pre verify unknown error.", 3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44010f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44011g;

        public d(JSONObject jSONObject, int i2) {
            this.f44010f = jSONObject;
            this.f44011g = i2;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                int optInt = this.f44010f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                String optString = this.f44010f.optString("desc", "");
                if (optInt == 103000) {
                    if (!d.a.j0.b.c.f43950c) {
                        e.this.t = System.currentTimeMillis();
                        e.this.f44064g = this.f44010f.optString("securityphone", "");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, e.this.a(e.this.f44064g));
                        e.this.e(this.f44011g, 0, 0, e.this.f44060c, jSONObject.toString(), 1);
                        return;
                    }
                    e.this.e(this.f44011g, 1, 999, e.this.f44060c, "device has risk.", 1);
                } else if (optInt == 105312 && e.this.f44060c != e.this.f44061d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("pre login");
                    sb.append(" error, wrong sim operator");
                    e.this.e(this.f44011g, 3, 2002, e.this.f44060c, sb.toString(), 1);
                } else {
                    e eVar = e.this;
                    int i2 = this.f44011g;
                    int i3 = e.this.f44060c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("pre login");
                    sb2.append(" error.");
                    sb2.append(optString);
                    eVar.e(i2, 2, optInt, i3, sb2.toString(), 1);
                }
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
                e eVar2 = e.this;
                int i4 = this.f44011g;
                int i5 = eVar2.f44060c;
                eVar2.e(i4, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, i5, "cm on handle pre login unknown error.", 1);
            }
        }
    }

    /* renamed from: d.a.j0.e.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0609e extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44013f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44014g;

        public C0609e(JSONObject jSONObject, int i2) {
            this.f44013f = jSONObject;
            this.f44014g = i2;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                int optInt = this.f44013f.has(MiPushCommandMessage.KEY_RESULT_CODE) ? this.f44013f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1) : -1;
                if (optInt == 103000) {
                    e.this.f44062e = this.f44013f.optString("token");
                    e.this.b(this.f44014g);
                    return;
                }
                String optString = this.f44013f.optString("resultDesc", "");
                e eVar = e.this;
                int i2 = this.f44014g;
                int i3 = e.this.f44060c;
                StringBuilder sb = new StringBuilder();
                sb.append("error:");
                sb.append(optString);
                eVar.d(i2, 2, optInt, i3, sb.toString());
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
                e eVar2 = e.this;
                eVar2.d(this.f44014g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, eVar2.f44060c, "cm on handle login unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44016f;

        public f(int i2) {
            this.f44016f = i2;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                e.this.g(this.f44016f, e.this.f44060c, e.this.f44065h);
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
                e eVar = e.this;
                eVar.m(this.f44016f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, eVar.f44060c, "cm on handle verify unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f44018a;

        public g(int i2) {
            this.f44018a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.w(jSONObject, this.f44018a);
        }
    }

    public e(Context context) {
        super(context);
        this.t = 0L;
        this.u = 0L;
        this.v = false;
        this.f44060c = 1;
    }

    public final void A(int i2) {
        d.a.j0.k.e.c().b(new f(i2));
    }

    public final void C(JSONObject jSONObject, int i2) {
        d.a.j0.k.e.c().b(new c(jSONObject, i2));
    }

    @Override // d.a.j0.e.i
    public void h(Context context, int i2) {
        super.h(context, i2);
        if (!d.a.j0.b.a.h(this.f44058a).d()) {
            e(i2, 3, 997, this.f44060c, "pre login error. sdk stop run.", 1);
        } else if (!r()) {
            e(i2, 3, 2006, this.f44060c, "pre login error. cm has not valid config.", 1);
        } else if (d.a.j0.b.a.h(this.f44058a).p0()) {
            if (!this.v) {
                System.currentTimeMillis();
                AuthnHelper authnHelper = AuthnHelper.getInstance(this.f44058a);
                this.s = authnHelper;
                authnHelper.setOverTime(8000L);
                this.v = true;
            }
            this.s.getPhoneInfo(i.k, i.l, new a(System.currentTimeMillis(), i2));
        } else {
            e(i2, 3, 994, this.f44060c, "pre login error. cm sdk stop run.", 1);
        }
    }

    @Override // d.a.j0.e.i
    public void i(Context context, int i2, long j) {
        super.i(context, i2, j);
        c(i2, 2);
        this.s.loginAuth(i.k, i.l, new g(i2));
    }

    @Override // d.a.j0.e.i
    public boolean k() {
        return this.t == 0 || System.currentTimeMillis() - this.t >= TimeUnit.HOURS.toMillis(1L);
    }

    @Override // d.a.j0.e.i
    public void o(Context context, int i2) {
        super.o(context, i2);
        if (!d.a.j0.b.a.h(this.f44058a).d()) {
            e(i2, 3, 997, this.f44060c, "pre verify error. sdk stop run.", 3);
        } else if (!r()) {
            e(i2, 3, 2006, this.f44060c, "pre verify error. cm has not valid config.", 3);
        } else if (d.a.j0.b.a.h(this.f44058a).p0()) {
            if (!this.v) {
                AuthnHelper authnHelper = AuthnHelper.getInstance(this.f44058a);
                this.s = authnHelper;
                authnHelper.setOverTime(8000L);
                this.v = true;
            }
            this.s.mobileAuth(i.k, i.l, new b(i2));
        } else {
            e(i2, 3, 994, this.f44060c, "pre verify error. cm sdk stop run.", 3);
        }
    }

    @Override // d.a.j0.e.i
    public void p(Context context, int i2, long j) {
        super.p(context, i2, j);
        c(i2, 4);
        A(i2);
    }

    @Override // d.a.j0.e.i
    public boolean q() {
        return System.currentTimeMillis() - this.u > 115000;
    }

    @Override // d.a.j0.e.i
    public void s() {
        this.f44062e = null;
    }

    @Override // d.a.j0.e.i
    public void t() {
        this.f44065h = null;
        this.u = 0L;
    }

    public final void w(JSONObject jSONObject, int i2) {
        d.a.j0.k.e.c().b(new C0609e(jSONObject, i2));
    }

    public final void z(JSONObject jSONObject, int i2) {
        d.a.j0.k.e.c().b(new d(jSONObject, i2));
    }
}
