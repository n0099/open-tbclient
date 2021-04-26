package d.a.g0.e;

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
        public final /* synthetic */ int f40818a;

        public a(int i2) {
            this.f40818a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.y(jSONObject, this.f40818a);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f40820a;

        public b(int i2) {
            this.f40820a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.B(jSONObject, this.f40820a);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f40822f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40823g;

        public c(JSONObject jSONObject, int i2) {
            this.f40822f = jSONObject;
            this.f40823g = i2;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                int optInt = this.f40822f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                String optString = this.f40822f.optString("authTypeDes", "");
                if (optInt == 103000) {
                    if (!d.a.g0.b.c.f40763c) {
                        e.this.u = System.currentTimeMillis();
                        e.this.f40880h = this.f40822f.optString("token", "");
                        e.this.d(this.f40823g, 0, 0, e.this.f40875c, "preVerify success", 3);
                        return;
                    }
                    e.this.d(this.f40823g, 1, 999, e.this.f40875c, "device has risk.", 3);
                } else if (optInt == 105312 && e.this.f40875c != e.this.f40876d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("pre verify");
                    sb.append(" error, wrong sim operator");
                    e.this.d(this.f40823g, 3, 2002, e.this.f40875c, sb.toString(), 3);
                } else {
                    e eVar = e.this;
                    int i2 = this.f40823g;
                    int i3 = e.this.f40875c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("pre verify");
                    sb2.append(" error.");
                    sb2.append(optString);
                    eVar.d(i2, 2, optInt, i3, sb2.toString(), 3);
                }
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
                e eVar2 = e.this;
                int i4 = this.f40823g;
                int i5 = eVar2.f40875c;
                eVar2.d(i4, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, i5, "cm on handle pre verify unknown error.", 3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f40825f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40826g;

        public d(JSONObject jSONObject, int i2) {
            this.f40825f = jSONObject;
            this.f40826g = i2;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                int optInt = this.f40825f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1);
                String optString = this.f40825f.optString("desc", "");
                if (optInt == 103000) {
                    if (!d.a.g0.b.c.f40763c) {
                        e.this.t = System.currentTimeMillis();
                        e.this.f40879g = this.f40825f.optString("securityphone", "");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, e.this.f40879g);
                        e.this.d(this.f40826g, 0, 0, e.this.f40875c, jSONObject.toString(), 1);
                        return;
                    }
                    e.this.d(this.f40826g, 1, 999, e.this.f40875c, "device has risk.", 1);
                } else if (optInt == 105312 && e.this.f40875c != e.this.f40876d) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("pre login");
                    sb.append(" error, wrong sim operator");
                    e.this.d(this.f40826g, 3, 2002, e.this.f40875c, sb.toString(), 1);
                } else {
                    e eVar = e.this;
                    int i2 = this.f40826g;
                    int i3 = e.this.f40875c;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("pre login");
                    sb2.append(" error.");
                    sb2.append(optString);
                    eVar.d(i2, 2, optInt, i3, sb2.toString(), 1);
                }
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
                e eVar2 = e.this;
                int i4 = this.f40826g;
                int i5 = eVar2.f40875c;
                eVar2.d(i4, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, i5, "cm on handle pre login unknown error.", 1);
            }
        }
    }

    /* renamed from: d.a.g0.e.e$e  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0552e extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f40828f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40829g;

        public C0552e(JSONObject jSONObject, int i2) {
            this.f40828f = jSONObject;
            this.f40829g = i2;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                int optInt = this.f40828f.has(MiPushCommandMessage.KEY_RESULT_CODE) ? this.f40828f.optInt(MiPushCommandMessage.KEY_RESULT_CODE, -1) : -1;
                if (optInt == 103000) {
                    e.this.f40877e = this.f40828f.optString("token");
                    e.this.a(this.f40829g);
                    return;
                }
                String optString = this.f40828f.optString("resultDesc", "");
                e eVar = e.this;
                int i2 = this.f40829g;
                int i3 = e.this.f40875c;
                StringBuilder sb = new StringBuilder();
                sb.append("error:");
                sb.append(optString);
                eVar.c(i2, 2, optInt, i3, sb.toString());
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
                e eVar2 = e.this;
                eVar2.c(this.f40829g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, eVar2.f40875c, "cm on handle login unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40831f;

        public f(int i2) {
            this.f40831f = i2;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                e.this.f(this.f40831f, e.this.f40875c, e.this.f40880h);
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
                e eVar = e.this;
                eVar.l(this.f40831f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, eVar.f40875c, "cm on handle verify unknown error.");
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements TokenListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f40833a;

        public g(int i2) {
            this.f40833a = i2;
        }

        @Override // com.cmic.sso.sdk.auth.TokenListener
        public void onGetTokenComplete(JSONObject jSONObject) {
            e.this.v(jSONObject, this.f40833a);
        }
    }

    public e(Context context) {
        super(context);
        this.t = 0L;
        this.u = 0L;
        this.v = false;
        this.f40875c = 1;
    }

    public final void B(JSONObject jSONObject, int i2) {
        d.a.g0.k.e.c().b(new c(jSONObject, i2));
    }

    @Override // d.a.g0.e.i
    public void g(Context context, int i2) {
        super.g(context, i2);
        if (!d.a.g0.b.a.g(this.f40873a).c()) {
            d(i2, 3, 997, this.f40875c, "pre login error. sdk stop run.", 1);
        } else if (!q()) {
            d(i2, 3, 2006, this.f40875c, "pre login error. cm has not valid config.", 1);
        } else if (d.a.g0.b.a.g(this.f40873a).m0()) {
            if (!this.v) {
                AuthnHelper authnHelper = AuthnHelper.getInstance(this.f40873a);
                this.s = authnHelper;
                authnHelper.setOverTime(8000L);
                this.v = true;
            }
            this.s.getPhoneInfo(i.k, i.l, new a(i2));
        } else {
            d(i2, 3, 994, this.f40875c, "pre login error. cm sdk stop run.", 1);
        }
    }

    @Override // d.a.g0.e.i
    public void h(Context context, int i2, long j) {
        super.h(context, i2, j);
        b(i2, 2);
        this.s.loginAuth(i.k, i.l, new g(i2));
    }

    @Override // d.a.g0.e.i
    public boolean j() {
        return this.t == 0 || System.currentTimeMillis() - this.t >= TimeUnit.HOURS.toMillis(1L);
    }

    @Override // d.a.g0.e.i
    public void n(Context context, int i2) {
        super.n(context, i2);
        if (!d.a.g0.b.a.g(this.f40873a).c()) {
            d(i2, 3, 997, this.f40875c, "pre verify error. sdk stop run.", 3);
        } else if (!q()) {
            d(i2, 3, 2006, this.f40875c, "pre verify error. cm has not valid config.", 3);
        } else if (d.a.g0.b.a.g(this.f40873a).m0()) {
            if (!this.v) {
                AuthnHelper authnHelper = AuthnHelper.getInstance(this.f40873a);
                this.s = authnHelper;
                authnHelper.setOverTime(8000L);
                this.v = true;
            }
            this.s.mobileAuth(i.k, i.l, new b(i2));
        } else {
            d(i2, 3, 994, this.f40875c, "pre verify error. cm sdk stop run.", 3);
        }
    }

    @Override // d.a.g0.e.i
    public void o(Context context, int i2, long j) {
        super.o(context, i2, j);
        b(i2, 4);
        z(i2);
    }

    @Override // d.a.g0.e.i
    public boolean p() {
        return System.currentTimeMillis() - this.u > 115000;
    }

    @Override // d.a.g0.e.i
    public void r() {
        this.f40877e = null;
    }

    @Override // d.a.g0.e.i
    public void s() {
        this.f40880h = null;
        this.u = 0L;
    }

    public final void v(JSONObject jSONObject, int i2) {
        d.a.g0.k.e.c().b(new C0552e(jSONObject, i2));
    }

    public final void y(JSONObject jSONObject, int i2) {
        d.a.g0.k.e.c().b(new d(jSONObject, i2));
    }

    public final void z(int i2) {
        d.a.g0.k.e.c().b(new f(i2));
    }
}
