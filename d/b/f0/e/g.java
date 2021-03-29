package d.b.f0.e;

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
        public final /* synthetic */ int f42914a;

        public a(int i) {
            this.f42914a = i;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i, int i2, String str, String str2) {
            g.this.x(i2, str, this.f42914a);
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i, String str, int i2, Object obj, String str2) {
            if (i == 0) {
                g.this.w(obj, this.f42914a);
            } else {
                g.this.x(i2, str, this.f42914a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements CallBack<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f42916a;

        public b(int i) {
            this.f42916a = i;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i, int i2, String str, String str2) {
            g.this.t(i2, str, this.f42916a);
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i, String str, int i2, Object obj, String str2) {
            if (i == 0) {
                g.this.z(obj, this.f42916a);
            } else {
                g.this.t(i2, str, this.f42916a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42918f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f42919g;

        public c(int i, Object obj) {
            this.f42918f = i;
            this.f42919g = obj;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                if (d.b.f0.b.c.f42829c) {
                    g.this.d(this.f42918f, 1, 999, g.this.f42936c, "device has risk.", 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject((String) this.f42919g);
                g.this.f42940g = jSONObject.optString(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                g.this.f42938e = jSONObject.optString("accessCode");
                g.this.f42939f = jSONObject.optLong("exp");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, g.this.f42940g);
                g.this.d(this.f42918f, 0, 0, g.this.f42936c, jSONObject2.toString(), 1);
            } catch (Throwable unused) {
                g gVar = g.this;
                gVar.d(this.f42918f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f42936c, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42921f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42922g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f42923h;

        public d(int i, int i2, String str) {
            this.f42921f = i;
            this.f42922g = i2;
            this.f42923h = str;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                if (g.this.f42936c != g.this.f42937d && this.f42921f == 1101) {
                    g.this.d(this.f42922g, 3, 2002, g.this.f42936c, "pre login error, wrong sim operator", 1);
                } else {
                    g gVar = g.this;
                    int i = this.f42922g;
                    int i2 = this.f42921f;
                    int i3 = g.this.f42936c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cu pre login error.");
                    sb.append(this.f42923h);
                    sb.append(", status ");
                    sb.append(this.f42921f);
                    gVar.d(i, 2, i2, i3, sb.toString(), 1);
                }
            } catch (Throwable unused) {
                g gVar2 = g.this;
                gVar2.d(this.f42922g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f42936c, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42924f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f42925g;

        public e(int i, Object obj) {
            this.f42924f = i;
            this.f42925g = obj;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                if (d.b.f0.b.c.f42829c) {
                    g.this.d(this.f42924f, 1, 999, g.this.f42936c, "device has risk.", 3);
                    return;
                }
                JSONObject jSONObject = new JSONObject((String) this.f42925g);
                g.this.f42941h = jSONObject.optString("accessCode");
                g.this.i = jSONObject.optLong("exp");
                g.this.d(this.f42924f, 0, 0, g.this.f42936c, "preVerify success", 3);
            } catch (Throwable unused) {
                g gVar = g.this;
                gVar.d(this.f42924f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f42936c, "cu on handle preVerify unknown error.", 3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42927f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42928g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f42929h;

        public f(int i, int i2, String str) {
            this.f42927f = i;
            this.f42928g = i2;
            this.f42929h = str;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                if (g.this.f42936c != g.this.f42937d && this.f42927f == 1101) {
                    g.this.d(this.f42928g, 3, 2002, g.this.f42936c, "pre verify error, wrong sim operator", 3);
                } else {
                    g gVar = g.this;
                    int i = this.f42928g;
                    int i2 = this.f42927f;
                    int i3 = g.this.f42936c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cu pre verify error.");
                    sb.append(this.f42929h);
                    sb.append(", status ");
                    sb.append(this.f42927f);
                    gVar.d(i, 2, i2, i3, sb.toString(), 3);
                }
            } catch (Throwable unused) {
                g gVar2 = g.this;
                gVar2.d(this.f42928g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f42936c, "cu on handle verify unknown error.", 3);
            }
        }
    }

    public g(Context context) {
        super(context);
        this.s = false;
        this.f42936c = 2;
    }

    @Override // d.b.f0.e.i
    public void g(Context context, int i) {
        super.g(context, i);
        if (!d.b.f0.b.a.g(this.f42934a).c()) {
            d(i, 3, 997, this.f42936c, "pre login error. sdk stop run", 1);
        } else if (!q()) {
            d(i, 3, 2006, this.f42936c, "pre login error. cu has not valid config.", 1);
        } else if (d.b.f0.b.a.g(this.f42934a).a()) {
            if (!this.s) {
                SDKManager.init(this.f42934a, i.o, i.p);
                SDKManager.setUseCache(false);
                this.s = true;
            }
            UiOauthManager.getInstance(context).login(8, new a(i));
        } else {
            d(i, 3, 995, this.f42936c, "pre login error. cu sdk stop run.", 1);
        }
    }

    @Override // d.b.f0.e.i
    public void n(Context context, int i) {
        super.n(context, i);
        if (!d.b.f0.b.a.g(this.f42934a).c()) {
            d(i, 3, 997, this.f42936c, "pre verify error. sdk stop run", 3);
        } else if (!q()) {
            d(i, 3, 2006, this.f42936c, "pre verify error. cu has not valid config.", 3);
        } else if (d.b.f0.b.a.g(this.f42934a).a()) {
            if (!this.s) {
                SDKManager.init(this.f42934a, i.o, i.p);
                SDKManager.setUseCache(false);
                this.s = true;
            }
            OauthManager.getInstance(this.f42934a).getAuthoriseCode(8, new b(i));
        } else {
            d(i, 3, 995, this.f42936c, "pre verify error. cu sdk stop run.", 3);
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
