package d.a.k0.e;

import android.content.Context;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.activity.social.YYInnerSSOLoginActivity;
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
        public final /* synthetic */ int f44176a;

        public a(long j, int i2) {
            this.f44176a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            g.this.y(i3, str, this.f44176a);
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            if (i2 == 0) {
                g.this.x(obj, this.f44176a);
            } else {
                g.this.y(i3, str, this.f44176a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements CallBack<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f44178a;

        public b(int i2) {
            this.f44178a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            g.this.u(i3, str, this.f44178a);
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            if (i2 == 0) {
                g.this.A(obj, this.f44178a);
            } else {
                g.this.u(i3, str, this.f44178a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.k0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44180f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f44181g;

        public c(int i2, Object obj) {
            this.f44180f = i2;
            this.f44181g = obj;
        }

        @Override // d.a.k0.k.c
        public void b() {
            try {
                if (d.a.k0.b.c.f44090c) {
                    g.this.e(this.f44180f, 1, 999, g.this.f44200c, "device has risk.", 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject((String) this.f44181g);
                g.this.f44204g = jSONObject.optString(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                g.this.f44202e = jSONObject.optString(YYInnerSSOLoginActivity.o);
                g.this.f44203f = jSONObject.optLong("exp");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, g.this.a(g.this.f44204g));
                g.this.e(this.f44180f, 0, 0, g.this.f44200c, jSONObject2.toString(), 1);
            } catch (Throwable unused) {
                g gVar = g.this;
                gVar.e(this.f44180f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f44200c, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.a.k0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44183f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44184g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44185h;

        public d(int i2, int i3, String str) {
            this.f44183f = i2;
            this.f44184g = i3;
            this.f44185h = str;
        }

        @Override // d.a.k0.k.c
        public void b() {
            try {
                if (g.this.f44200c != g.this.f44201d && this.f44183f == 1101) {
                    g.this.e(this.f44184g, 3, 2002, g.this.f44200c, "pre login error, wrong sim operator", 1);
                } else {
                    g gVar = g.this;
                    int i2 = this.f44184g;
                    int i3 = this.f44183f;
                    int i4 = g.this.f44200c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cu pre login error.");
                    sb.append(this.f44185h);
                    sb.append(", status ");
                    sb.append(this.f44183f);
                    gVar.e(i2, 2, i3, i4, sb.toString(), 1);
                }
            } catch (Throwable unused) {
                g gVar2 = g.this;
                gVar2.e(this.f44184g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f44200c, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends d.a.k0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44187f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f44188g;

        public e(int i2, Object obj) {
            this.f44187f = i2;
            this.f44188g = obj;
        }

        @Override // d.a.k0.k.c
        public void b() {
            try {
                if (d.a.k0.b.c.f44090c) {
                    g.this.e(this.f44187f, 1, 999, g.this.f44200c, "device has risk.", 3);
                    return;
                }
                JSONObject jSONObject = new JSONObject((String) this.f44188g);
                g.this.f44205h = jSONObject.optString(YYInnerSSOLoginActivity.o);
                g.this.f44206i = jSONObject.optLong("exp");
                g.this.e(this.f44187f, 0, 0, g.this.f44200c, "preVerify success", 3);
            } catch (Throwable unused) {
                g gVar = g.this;
                gVar.e(this.f44187f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f44200c, "cu on handle preVerify unknown error.", 3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends d.a.k0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44190f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44191g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44192h;

        public f(int i2, int i3, String str) {
            this.f44190f = i2;
            this.f44191g = i3;
            this.f44192h = str;
        }

        @Override // d.a.k0.k.c
        public void b() {
            try {
                if (g.this.f44200c != g.this.f44201d && this.f44190f == 1101) {
                    g.this.e(this.f44191g, 3, 2002, g.this.f44200c, "pre verify error, wrong sim operator", 3);
                } else {
                    g gVar = g.this;
                    int i2 = this.f44191g;
                    int i3 = this.f44190f;
                    int i4 = g.this.f44200c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cu pre verify error.");
                    sb.append(this.f44192h);
                    sb.append(", status ");
                    sb.append(this.f44190f);
                    gVar.e(i2, 2, i3, i4, sb.toString(), 3);
                }
            } catch (Throwable unused) {
                g gVar2 = g.this;
                gVar2.e(this.f44191g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f44200c, "cu on handle verify unknown error.", 3);
            }
        }
    }

    public g(Context context) {
        super(context);
        this.s = false;
        this.f44200c = 2;
    }

    public final void A(Object obj, int i2) {
        d.a.k0.k.e.c().b(new e(i2, obj));
    }

    @Override // d.a.k0.e.i
    public void h(Context context, int i2) {
        super.h(context, i2);
        if (!d.a.k0.b.a.h(this.f44198a).d()) {
            e(i2, 3, 997, this.f44200c, "pre login error. sdk stop run", 1);
        } else if (!r()) {
            e(i2, 3, 2006, this.f44200c, "pre login error. cu has not valid config.", 1);
        } else if (d.a.k0.b.a.h(this.f44198a).b()) {
            if (!this.s) {
                System.currentTimeMillis();
                SDKManager.init(this.f44198a, i.o, i.p);
                SDKManager.setUseCache(false);
                this.s = true;
            }
            UiOauthManager.getInstance(context).login(8, new a(System.currentTimeMillis(), i2));
        } else {
            e(i2, 3, 995, this.f44200c, "pre login error. cu sdk stop run.", 1);
        }
    }

    @Override // d.a.k0.e.i
    public void o(Context context, int i2) {
        super.o(context, i2);
        if (!d.a.k0.b.a.h(this.f44198a).d()) {
            e(i2, 3, 997, this.f44200c, "pre verify error. sdk stop run", 3);
        } else if (!r()) {
            e(i2, 3, 2006, this.f44200c, "pre verify error. cu has not valid config.", 3);
        } else if (d.a.k0.b.a.h(this.f44198a).b()) {
            if (!this.s) {
                SDKManager.init(this.f44198a, i.o, i.p);
                SDKManager.setUseCache(false);
                this.s = true;
            }
            OauthManager.getInstance(this.f44198a).getAuthoriseCode(8, new b(i2));
        } else {
            e(i2, 3, 995, this.f44200c, "pre verify error. cu sdk stop run.", 3);
        }
    }

    @Override // d.a.k0.e.j, d.a.k0.e.i
    public void p(Context context, int i2, long j) {
        super.p(context, i2, j);
    }

    public void u(int i2, String str, int i3) {
        d.a.k0.k.e.c().b(new f(i2, i3, str));
    }

    public final void x(Object obj, int i2) {
        d.a.k0.k.e.c().b(new c(i2, obj));
    }

    public final void y(int i2, String str, int i3) {
        d.a.k0.k.e.c().b(new d(i2, i3, str));
    }
}
