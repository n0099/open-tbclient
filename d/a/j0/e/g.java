package d.a.j0.e;

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
        public final /* synthetic */ int f44036a;

        public a(long j, int i2) {
            this.f44036a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            g.this.y(i3, str, this.f44036a);
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            if (i2 == 0) {
                g.this.x(obj, this.f44036a);
            } else {
                g.this.y(i3, str, this.f44036a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements CallBack<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f44038a;

        public b(int i2) {
            this.f44038a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            g.this.u(i3, str, this.f44038a);
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            if (i2 == 0) {
                g.this.A(obj, this.f44038a);
            } else {
                g.this.u(i3, str, this.f44038a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44040f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f44041g;

        public c(int i2, Object obj) {
            this.f44040f = i2;
            this.f44041g = obj;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                if (d.a.j0.b.c.f43950c) {
                    g.this.e(this.f44040f, 1, 999, g.this.f44060c, "device has risk.", 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject((String) this.f44041g);
                g.this.f44064g = jSONObject.optString(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                g.this.f44062e = jSONObject.optString("accessCode");
                g.this.f44063f = jSONObject.optLong("exp");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, g.this.a(g.this.f44064g));
                g.this.e(this.f44040f, 0, 0, g.this.f44060c, jSONObject2.toString(), 1);
            } catch (Throwable unused) {
                g gVar = g.this;
                gVar.e(this.f44040f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f44060c, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44043f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44044g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44045h;

        public d(int i2, int i3, String str) {
            this.f44043f = i2;
            this.f44044g = i3;
            this.f44045h = str;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                if (g.this.f44060c != g.this.f44061d && this.f44043f == 1101) {
                    g.this.e(this.f44044g, 3, 2002, g.this.f44060c, "pre login error, wrong sim operator", 1);
                } else {
                    g gVar = g.this;
                    int i2 = this.f44044g;
                    int i3 = this.f44043f;
                    int i4 = g.this.f44060c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cu pre login error.");
                    sb.append(this.f44045h);
                    sb.append(", status ");
                    sb.append(this.f44043f);
                    gVar.e(i2, 2, i3, i4, sb.toString(), 1);
                }
            } catch (Throwable unused) {
                g gVar2 = g.this;
                gVar2.e(this.f44044g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f44060c, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44047f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f44048g;

        public e(int i2, Object obj) {
            this.f44047f = i2;
            this.f44048g = obj;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                if (d.a.j0.b.c.f43950c) {
                    g.this.e(this.f44047f, 1, 999, g.this.f44060c, "device has risk.", 3);
                    return;
                }
                JSONObject jSONObject = new JSONObject((String) this.f44048g);
                g.this.f44065h = jSONObject.optString("accessCode");
                g.this.f44066i = jSONObject.optLong("exp");
                g.this.e(this.f44047f, 0, 0, g.this.f44060c, "preVerify success", 3);
            } catch (Throwable unused) {
                g gVar = g.this;
                gVar.e(this.f44047f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f44060c, "cu on handle preVerify unknown error.", 3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44050f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44051g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44052h;

        public f(int i2, int i3, String str) {
            this.f44050f = i2;
            this.f44051g = i3;
            this.f44052h = str;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                if (g.this.f44060c != g.this.f44061d && this.f44050f == 1101) {
                    g.this.e(this.f44051g, 3, 2002, g.this.f44060c, "pre verify error, wrong sim operator", 3);
                } else {
                    g gVar = g.this;
                    int i2 = this.f44051g;
                    int i3 = this.f44050f;
                    int i4 = g.this.f44060c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cu pre verify error.");
                    sb.append(this.f44052h);
                    sb.append(", status ");
                    sb.append(this.f44050f);
                    gVar.e(i2, 2, i3, i4, sb.toString(), 3);
                }
            } catch (Throwable unused) {
                g gVar2 = g.this;
                gVar2.e(this.f44051g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f44060c, "cu on handle verify unknown error.", 3);
            }
        }
    }

    public g(Context context) {
        super(context);
        this.s = false;
        this.f44060c = 2;
    }

    public final void A(Object obj, int i2) {
        d.a.j0.k.e.c().b(new e(i2, obj));
    }

    @Override // d.a.j0.e.i
    public void h(Context context, int i2) {
        super.h(context, i2);
        if (!d.a.j0.b.a.h(this.f44058a).d()) {
            e(i2, 3, 997, this.f44060c, "pre login error. sdk stop run", 1);
        } else if (!r()) {
            e(i2, 3, 2006, this.f44060c, "pre login error. cu has not valid config.", 1);
        } else if (d.a.j0.b.a.h(this.f44058a).b()) {
            if (!this.s) {
                System.currentTimeMillis();
                SDKManager.init(this.f44058a, i.o, i.p);
                SDKManager.setUseCache(false);
                this.s = true;
            }
            UiOauthManager.getInstance(context).login(8, new a(System.currentTimeMillis(), i2));
        } else {
            e(i2, 3, 995, this.f44060c, "pre login error. cu sdk stop run.", 1);
        }
    }

    @Override // d.a.j0.e.i
    public void o(Context context, int i2) {
        super.o(context, i2);
        if (!d.a.j0.b.a.h(this.f44058a).d()) {
            e(i2, 3, 997, this.f44060c, "pre verify error. sdk stop run", 3);
        } else if (!r()) {
            e(i2, 3, 2006, this.f44060c, "pre verify error. cu has not valid config.", 3);
        } else if (d.a.j0.b.a.h(this.f44058a).b()) {
            if (!this.s) {
                SDKManager.init(this.f44058a, i.o, i.p);
                SDKManager.setUseCache(false);
                this.s = true;
            }
            OauthManager.getInstance(this.f44058a).getAuthoriseCode(8, new b(i2));
        } else {
            e(i2, 3, 995, this.f44060c, "pre verify error. cu sdk stop run.", 3);
        }
    }

    @Override // d.a.j0.e.j, d.a.j0.e.i
    public void p(Context context, int i2, long j) {
        super.p(context, i2, j);
    }

    public void u(int i2, String str, int i3) {
        d.a.j0.k.e.c().b(new f(i2, i3, str));
    }

    public final void x(Object obj, int i2) {
        d.a.j0.k.e.c().b(new c(i2, obj));
    }

    public final void y(int i2, String str, int i3) {
        d.a.j0.k.e.c().b(new d(i2, i3, str));
    }
}
