package d.b.g0.e;

import android.content.Context;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.sdk.base.api.CallBack;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.manager.login.cucc.UiOauthManager;
import com.sdk.mobile.manager.oauth.cucc.OauthManager;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g extends j {
    public boolean s;

    /* loaded from: classes2.dex */
    public class a implements CallBack<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43603a;

        public a(int i) {
            this.f43603a = i;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i, int i2, String str, String str2) {
            g.this.x(i2, str, this.f43603a);
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i, String str, int i2, Object obj, String str2) {
            if (i == 0) {
                g.this.w(obj, this.f43603a);
            } else {
                g.this.x(i2, str, this.f43603a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements CallBack<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43605a;

        public b(int i) {
            this.f43605a = i;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i, int i2, String str, String str2) {
            g.this.t(i2, str, this.f43605a);
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i, String str, int i2, Object obj, String str2) {
            if (i == 0) {
                g.this.z(obj, this.f43605a);
            } else {
                g.this.t(i2, str, this.f43605a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43607f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f43608g;

        public c(int i, Object obj) {
            this.f43607f = i;
            this.f43608g = obj;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                if (d.b.g0.b.c.f43518c) {
                    g.this.d(this.f43607f, 1, 999, g.this.f43625c, "device has risk.", 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject((String) this.f43608g);
                g.this.f43629g = jSONObject.optString(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                g.this.f43627e = jSONObject.optString("accessCode");
                g.this.f43628f = jSONObject.optLong("exp");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, g.this.f43629g);
                g.this.d(this.f43607f, 0, 0, g.this.f43625c, jSONObject2.toString(), 1);
            } catch (Throwable unused) {
                g gVar = g.this;
                gVar.d(this.f43607f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f43625c, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43610f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43611g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43612h;

        public d(int i, int i2, String str) {
            this.f43610f = i;
            this.f43611g = i2;
            this.f43612h = str;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                if (g.this.f43625c != g.this.f43626d && this.f43610f == 1101) {
                    g.this.d(this.f43611g, 3, 2002, g.this.f43625c, "pre login error, wrong sim operator", 1);
                } else {
                    g gVar = g.this;
                    int i = this.f43611g;
                    int i2 = this.f43610f;
                    int i3 = g.this.f43625c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cu pre login error.");
                    sb.append(this.f43612h);
                    sb.append(", status ");
                    sb.append(this.f43610f);
                    gVar.d(i, 2, i2, i3, sb.toString(), 1);
                }
            } catch (Throwable unused) {
                g gVar2 = g.this;
                gVar2.d(this.f43611g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f43625c, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43613f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f43614g;

        public e(int i, Object obj) {
            this.f43613f = i;
            this.f43614g = obj;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                if (d.b.g0.b.c.f43518c) {
                    g.this.d(this.f43613f, 1, 999, g.this.f43625c, "device has risk.", 3);
                    return;
                }
                JSONObject jSONObject = new JSONObject((String) this.f43614g);
                g.this.f43630h = jSONObject.optString("accessCode");
                g.this.i = jSONObject.optLong("exp");
                g.this.d(this.f43613f, 0, 0, g.this.f43625c, "preVerify success", 3);
            } catch (Throwable unused) {
                g gVar = g.this;
                gVar.d(this.f43613f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f43625c, "cu on handle preVerify unknown error.", 3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43616f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43617g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43618h;

        public f(int i, int i2, String str) {
            this.f43616f = i;
            this.f43617g = i2;
            this.f43618h = str;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                if (g.this.f43625c != g.this.f43626d && this.f43616f == 1101) {
                    g.this.d(this.f43617g, 3, 2002, g.this.f43625c, "pre verify error, wrong sim operator", 3);
                } else {
                    g gVar = g.this;
                    int i = this.f43617g;
                    int i2 = this.f43616f;
                    int i3 = g.this.f43625c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cu pre verify error.");
                    sb.append(this.f43618h);
                    sb.append(", status ");
                    sb.append(this.f43616f);
                    gVar.d(i, 2, i2, i3, sb.toString(), 3);
                }
            } catch (Throwable unused) {
                g gVar2 = g.this;
                gVar2.d(this.f43617g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f43625c, "cu on handle verify unknown error.", 3);
            }
        }
    }

    public g(Context context) {
        super(context);
        this.s = false;
        this.f43625c = 2;
    }

    @Override // d.b.g0.e.i
    public void g(Context context, int i) {
        super.g(context, i);
        if (!d.b.g0.b.a.g(this.f43623a).c()) {
            d(i, 3, 997, this.f43625c, "pre login error. sdk stop run", 1);
        } else if (!q()) {
            d(i, 3, 2006, this.f43625c, "pre login error. cu has not valid config.", 1);
        } else if (d.b.g0.b.a.g(this.f43623a).a()) {
            if (!this.s) {
                SDKManager.init(this.f43623a, i.o, i.p);
                SDKManager.setUseCache(false);
                this.s = true;
            }
            UiOauthManager.getInstance(context).login(8, new a(i));
        } else {
            d(i, 3, 995, this.f43625c, "pre login error. cu sdk stop run.", 1);
        }
    }

    @Override // d.b.g0.e.i
    public void n(Context context, int i) {
        super.n(context, i);
        if (!d.b.g0.b.a.g(this.f43623a).c()) {
            d(i, 3, 997, this.f43625c, "pre verify error. sdk stop run", 3);
        } else if (!q()) {
            d(i, 3, 2006, this.f43625c, "pre verify error. cu has not valid config.", 3);
        } else if (d.b.g0.b.a.g(this.f43623a).a()) {
            if (!this.s) {
                SDKManager.init(this.f43623a, i.o, i.p);
                SDKManager.setUseCache(false);
                this.s = true;
            }
            OauthManager.getInstance(this.f43623a).getAuthoriseCode(8, new b(i));
        } else {
            d(i, 3, 995, this.f43625c, "pre verify error. cu sdk stop run.", 3);
        }
    }

    @Override // d.b.g0.e.j, d.b.g0.e.i
    public void o(Context context, int i, long j) {
        super.o(context, i, j);
    }

    public void t(int i, String str, int i2) {
        d.b.g0.k.e.c().b(new f(i, i2, str));
    }

    public final void w(Object obj, int i) {
        d.b.g0.k.e.c().b(new c(i, obj));
    }

    public final void x(int i, String str, int i2) {
        d.b.g0.k.e.c().b(new d(i, i2, str));
    }

    public final void z(Object obj, int i) {
        d.b.g0.k.e.c().b(new e(i, obj));
    }
}
