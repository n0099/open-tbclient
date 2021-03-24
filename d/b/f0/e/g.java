package d.b.f0.e;

import android.content.Context;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.sdk.base.api.CallBack;
import com.sdk.base.module.manager.SDKManager;
import com.sdk.mobile.manager.login.cucc.UiOauthManager;
import com.sdk.mobile.manager.oauth.cucc.OauthManager;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends j {
    public boolean s;

    /* loaded from: classes3.dex */
    public class a implements CallBack<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f42913a;

        public a(int i) {
            this.f42913a = i;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i, int i2, String str, String str2) {
            g.this.x(i2, str, this.f42913a);
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i, String str, int i2, Object obj, String str2) {
            if (i == 0) {
                g.this.w(obj, this.f42913a);
            } else {
                g.this.x(i2, str, this.f42913a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements CallBack<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f42915a;

        public b(int i) {
            this.f42915a = i;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i, int i2, String str, String str2) {
            g.this.t(i2, str, this.f42915a);
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i, String str, int i2, Object obj, String str2) {
            if (i == 0) {
                g.this.z(obj, this.f42915a);
            } else {
                g.this.t(i2, str, this.f42915a);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42917f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f42918g;

        public c(int i, Object obj) {
            this.f42917f = i;
            this.f42918g = obj;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                if (d.b.f0.b.c.f42828c) {
                    g.this.d(this.f42917f, 1, 999, g.this.f42935c, "device has risk.", 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject((String) this.f42918g);
                g.this.f42939g = jSONObject.optString(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                g.this.f42937e = jSONObject.optString("accessCode");
                g.this.f42938f = jSONObject.optLong("exp");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, g.this.f42939g);
                g.this.d(this.f42917f, 0, 0, g.this.f42935c, jSONObject2.toString(), 1);
            } catch (Throwable unused) {
                g gVar = g.this;
                gVar.d(this.f42917f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f42935c, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42920f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42921g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f42922h;

        public d(int i, int i2, String str) {
            this.f42920f = i;
            this.f42921g = i2;
            this.f42922h = str;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                if (g.this.f42935c != g.this.f42936d && this.f42920f == 1101) {
                    g.this.d(this.f42921g, 3, 2002, g.this.f42935c, "pre login error, wrong sim operator", 1);
                } else {
                    g gVar = g.this;
                    int i = this.f42921g;
                    int i2 = this.f42920f;
                    int i3 = g.this.f42935c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cu pre login error.");
                    sb.append(this.f42922h);
                    sb.append(", status ");
                    sb.append(this.f42920f);
                    gVar.d(i, 2, i2, i3, sb.toString(), 1);
                }
            } catch (Throwable unused) {
                g gVar2 = g.this;
                gVar2.d(this.f42921g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f42935c, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42923f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f42924g;

        public e(int i, Object obj) {
            this.f42923f = i;
            this.f42924g = obj;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                if (d.b.f0.b.c.f42828c) {
                    g.this.d(this.f42923f, 1, 999, g.this.f42935c, "device has risk.", 3);
                    return;
                }
                JSONObject jSONObject = new JSONObject((String) this.f42924g);
                g.this.f42940h = jSONObject.optString("accessCode");
                g.this.i = jSONObject.optLong("exp");
                g.this.d(this.f42923f, 0, 0, g.this.f42935c, "preVerify success", 3);
            } catch (Throwable unused) {
                g gVar = g.this;
                gVar.d(this.f42923f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f42935c, "cu on handle preVerify unknown error.", 3);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42926f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42927g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f42928h;

        public f(int i, int i2, String str) {
            this.f42926f = i;
            this.f42927g = i2;
            this.f42928h = str;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                if (g.this.f42935c != g.this.f42936d && this.f42926f == 1101) {
                    g.this.d(this.f42927g, 3, 2002, g.this.f42935c, "pre verify error, wrong sim operator", 3);
                } else {
                    g gVar = g.this;
                    int i = this.f42927g;
                    int i2 = this.f42926f;
                    int i3 = g.this.f42935c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cu pre verify error.");
                    sb.append(this.f42928h);
                    sb.append(", status ");
                    sb.append(this.f42926f);
                    gVar.d(i, 2, i2, i3, sb.toString(), 3);
                }
            } catch (Throwable unused) {
                g gVar2 = g.this;
                gVar2.d(this.f42927g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f42935c, "cu on handle verify unknown error.", 3);
            }
        }
    }

    public g(Context context) {
        super(context);
        this.s = false;
        this.f42935c = 2;
    }

    @Override // d.b.f0.e.i
    public void g(Context context, int i) {
        super.g(context, i);
        if (!d.b.f0.b.a.g(this.f42933a).c()) {
            d(i, 3, 997, this.f42935c, "pre login error. sdk stop run", 1);
        } else if (!q()) {
            d(i, 3, 2006, this.f42935c, "pre login error. cu has not valid config.", 1);
        } else if (d.b.f0.b.a.g(this.f42933a).a()) {
            if (!this.s) {
                SDKManager.init(this.f42933a, i.o, i.p);
                SDKManager.setUseCache(false);
                this.s = true;
            }
            UiOauthManager.getInstance(context).login(8, new a(i));
        } else {
            d(i, 3, 995, this.f42935c, "pre login error. cu sdk stop run.", 1);
        }
    }

    @Override // d.b.f0.e.i
    public void n(Context context, int i) {
        super.n(context, i);
        if (!d.b.f0.b.a.g(this.f42933a).c()) {
            d(i, 3, 997, this.f42935c, "pre verify error. sdk stop run", 3);
        } else if (!q()) {
            d(i, 3, 2006, this.f42935c, "pre verify error. cu has not valid config.", 3);
        } else if (d.b.f0.b.a.g(this.f42933a).a()) {
            if (!this.s) {
                SDKManager.init(this.f42933a, i.o, i.p);
                SDKManager.setUseCache(false);
                this.s = true;
            }
            OauthManager.getInstance(this.f42933a).getAuthoriseCode(8, new b(i));
        } else {
            d(i, 3, 995, this.f42935c, "pre verify error. cu sdk stop run.", 3);
        }
    }

    @Override // d.b.f0.e.j, d.b.f0.e.i
    public void o(Context context, int i, long j) {
        super.o(context, i, j);
    }

    public void t(int i, String str, int i2) {
        d.b.f0.k.e.c().b(new f(i, i2, str));
    }

    public final void w(Object obj, int i) {
        d.b.f0.k.e.c().b(new c(i, obj));
    }

    public final void x(int i, String str, int i2) {
        d.b.f0.k.e.c().b(new d(i, i2, str));
    }

    public final void z(Object obj, int i) {
        d.b.f0.k.e.c().b(new e(i, obj));
    }
}
