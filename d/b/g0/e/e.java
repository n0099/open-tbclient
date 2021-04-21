package d.b.g0.e;

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
        public final /* synthetic */ int f43573a;

        public a(int i) {
            this.f43573a = i;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.y(jSONObject, this.f43573a);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43575a;

        public b(int i) {
            this.f43575a = i;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.B(jSONObject, this.f43575a);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43577f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43578g;

        public c(JSONObject jSONObject, int i) {
            this.f43577f = jSONObject;
            this.f43578g = i;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                int optInt = this.f43577f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                String optString = this.f43577f.optString("authTypeDes", "");
                if (optInt == 103000) {
                    if (!d.b.g0.b.c.f43518c) {
                        e.this.u = System.currentTimeMillis();
                        e.this.f43630h = this.f43577f.optString("token", "");
                        e.this.d(this.f43578g, 0, 0, e.this.f43625c, "preVerify success", 3);
                        return;
                    }
                    e.this.d(this.f43578g, 1, 999, e.this.f43625c, "device has risk.", 3);
                } else if (optInt == 105312 && e.this.f43625c != e.this.f43626d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("pre verify");
                    sb.append(" error, wrong sim operator");
                    e.this.d(this.f43578g, 3, 2002, e.this.f43625c, sb.toString(), 3);
                } else {
                    e eVar = e.this;
                    int i = this.f43578g;
                    int i2 = e.this.f43625c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("pre verify");
                    sb2.append(" error.");
                    sb2.append(optString);
                    eVar.d(i, 2, optInt, i2, sb2.toString(), 3);
                }
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
                e eVar2 = e.this;
                int i3 = this.f43578g;
                int i4 = eVar2.f43625c;
                eVar2.d(i3, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, i4, "cm on handle pre verify unknown error.", 3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43580f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43581g;

        public d(JSONObject jSONObject, int i) {
            this.f43580f = jSONObject;
            this.f43581g = i;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                int optInt = this.f43580f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                String optString = this.f43580f.optString("desc", "");
                if (optInt == 103000) {
                    if (!d.b.g0.b.c.f43518c) {
                        e.this.t = System.currentTimeMillis();
                        e.this.f43629g = this.f43580f.optString("securityphone", "");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, e.this.f43629g);
                        e.this.d(this.f43581g, 0, 0, e.this.f43625c, jSONObject.toString(), 1);
                        return;
                    }
                    e.this.d(this.f43581g, 1, 999, e.this.f43625c, "device has risk.", 1);
                } else if (optInt == 105312 && e.this.f43625c != e.this.f43626d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("pre login");
                    sb.append(" error, wrong sim operator");
                    e.this.d(this.f43581g, 3, 2002, e.this.f43625c, sb.toString(), 1);
                } else {
                    e eVar = e.this;
                    int i = this.f43581g;
                    int i2 = e.this.f43625c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("pre login");
                    sb2.append(" error.");
                    sb2.append(optString);
                    eVar.d(i, 2, optInt, i2, sb2.toString(), 1);
                }
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
                e eVar2 = e.this;
                int i3 = this.f43581g;
                int i4 = eVar2.f43625c;
                eVar2.d(i3, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, i4, "cm on handle pre login unknown error.", 1);
            }
        }
    }

    /* renamed from: d.b.g0.e.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0613e extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43583f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43584g;

        public C0613e(JSONObject jSONObject, int i) {
            this.f43583f = jSONObject;
            this.f43584g = i;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                int optInt = this.f43583f.has(MiPushCommandMessage.KEY_RESULT_CODE) ? this.f43583f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1) : -1;
                if (optInt == 103000) {
                    e.this.f43627e = this.f43583f.optString("token");
                    e.this.a(this.f43584g);
                    return;
                }
                String optString = this.f43583f.optString("resultDesc", "");
                e eVar = e.this;
                int i = this.f43584g;
                int i2 = e.this.f43625c;
                StringBuilder sb = new StringBuilder();
                sb.append("error:");
                sb.append(optString);
                eVar.c(i, 2, optInt, i2, sb.toString());
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
                e eVar2 = e.this;
                eVar2.c(this.f43584g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, eVar2.f43625c, "cm on handle login unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43586f;

        public f(int i) {
            this.f43586f = i;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                e.this.f(this.f43586f, e.this.f43625c, e.this.f43630h);
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
                e eVar = e.this;
                eVar.l(this.f43586f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, eVar.f43625c, "cm on handle verify unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43588a;

        public g(int i) {
            this.f43588a = i;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.v(jSONObject, this.f43588a);
        }
    }

    public e(Context context) {
        super(context);
        this.t = 0L;
        this.u = 0L;
        this.v = false;
        this.f43625c = 1;
    }

    public final void B(JSONObject jSONObject, int i) {
        d.b.g0.k.e.c().b(new c(jSONObject, i));
    }

    @Override // d.b.g0.e.i
    public void g(Context context, int i) {
        super.g(context, i);
        if (!d.b.g0.b.a.g(this.f43623a).c()) {
            d(i, 3, 997, this.f43625c, "pre login error. sdk stop run.", 1);
        } else if (!q()) {
            d(i, 3, 2006, this.f43625c, "pre login error. cm has not valid config.", 1);
        } else if (d.b.g0.b.a.g(this.f43623a).m0()) {
            if (!this.v) {
                AuthnHelper authnHelper = AuthnHelper.getInstance(this.f43623a);
                this.s = authnHelper;
                authnHelper.setOverTime(8000L);
                this.v = true;
            }
            this.s.getPhoneInfo(i.k, i.l, new a(i));
        } else {
            d(i, 3, 994, this.f43625c, "pre login error. cm sdk stop run.", 1);
        }
    }

    @Override // d.b.g0.e.i
    public void h(Context context, int i, long j) {
        super.h(context, i, j);
        b(i, 2);
        this.s.loginAuth(i.k, i.l, new g(i));
    }

    @Override // d.b.g0.e.i
    public boolean j() {
        return this.t == 0 || System.currentTimeMillis() - this.t >= TimeUnit.HOURS.toMillis(1L);
    }

    @Override // d.b.g0.e.i
    public void n(Context context, int i) {
        super.n(context, i);
        if (!d.b.g0.b.a.g(this.f43623a).c()) {
            d(i, 3, 997, this.f43625c, "pre verify error. sdk stop run.", 3);
        } else if (!q()) {
            d(i, 3, 2006, this.f43625c, "pre verify error. cm has not valid config.", 3);
        } else if (d.b.g0.b.a.g(this.f43623a).m0()) {
            if (!this.v) {
                AuthnHelper authnHelper = AuthnHelper.getInstance(this.f43623a);
                this.s = authnHelper;
                authnHelper.setOverTime(8000L);
                this.v = true;
            }
            this.s.mobileAuth(i.k, i.l, new b(i));
        } else {
            d(i, 3, 994, this.f43625c, "pre verify error. cm sdk stop run.", 3);
        }
    }

    @Override // d.b.g0.e.i
    public void o(Context context, int i, long j) {
        super.o(context, i, j);
        b(i, 4);
        z(i);
    }

    @Override // d.b.g0.e.i
    public boolean p() {
        return System.currentTimeMillis() - this.u > 115000;
    }

    @Override // d.b.g0.e.i
    public void r() {
        this.f43627e = null;
    }

    @Override // d.b.g0.e.i
    public void s() {
        this.f43630h = null;
        this.u = 0L;
    }

    public final void v(JSONObject jSONObject, int i) {
        d.b.g0.k.e.c().b(new C0613e(jSONObject, i));
    }

    public final void y(JSONObject jSONObject, int i) {
        d.b.g0.k.e.c().b(new d(jSONObject, i));
    }

    public final void z(int i) {
        d.b.g0.k.e.c().b(new f(i));
    }
}
