package d.a.g0.e;

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
        public final /* synthetic */ int f40851a;

        public a(int i2) {
            this.f40851a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            g.this.x(i3, str, this.f40851a);
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            if (i2 == 0) {
                g.this.w(obj, this.f40851a);
            } else {
                g.this.x(i3, str, this.f40851a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements CallBack<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f40853a;

        public b(int i2) {
            this.f40853a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            g.this.t(i3, str, this.f40853a);
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            if (i2 == 0) {
                g.this.z(obj, this.f40853a);
            } else {
                g.this.t(i3, str, this.f40853a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40855f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f40856g;

        public c(int i2, Object obj) {
            this.f40855f = i2;
            this.f40856g = obj;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                if (d.a.g0.b.c.f40763c) {
                    g.this.d(this.f40855f, 1, 999, g.this.f40875c, "device has risk.", 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject((String) this.f40856g);
                g.this.f40879g = jSONObject.optString(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                g.this.f40877e = jSONObject.optString("accessCode");
                g.this.f40878f = jSONObject.optLong("exp");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, g.this.f40879g);
                g.this.d(this.f40855f, 0, 0, g.this.f40875c, jSONObject2.toString(), 1);
            } catch (Throwable unused) {
                g gVar = g.this;
                gVar.d(this.f40855f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f40875c, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40858f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40859g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f40860h;

        public d(int i2, int i3, String str) {
            this.f40858f = i2;
            this.f40859g = i3;
            this.f40860h = str;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                if (g.this.f40875c != g.this.f40876d && this.f40858f == 1101) {
                    g.this.d(this.f40859g, 3, 2002, g.this.f40875c, "pre login error, wrong sim operator", 1);
                } else {
                    g gVar = g.this;
                    int i2 = this.f40859g;
                    int i3 = this.f40858f;
                    int i4 = g.this.f40875c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cu pre login error.");
                    sb.append(this.f40860h);
                    sb.append(", status ");
                    sb.append(this.f40858f);
                    gVar.d(i2, 2, i3, i4, sb.toString(), 1);
                }
            } catch (Throwable unused) {
                g gVar2 = g.this;
                gVar2.d(this.f40859g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f40875c, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40862f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f40863g;

        public e(int i2, Object obj) {
            this.f40862f = i2;
            this.f40863g = obj;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                if (d.a.g0.b.c.f40763c) {
                    g.this.d(this.f40862f, 1, 999, g.this.f40875c, "device has risk.", 3);
                    return;
                }
                JSONObject jSONObject = new JSONObject((String) this.f40863g);
                g.this.f40880h = jSONObject.optString("accessCode");
                g.this.f40881i = jSONObject.optLong("exp");
                g.this.d(this.f40862f, 0, 0, g.this.f40875c, "preVerify success", 3);
            } catch (Throwable unused) {
                g gVar = g.this;
                gVar.d(this.f40862f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f40875c, "cu on handle preVerify unknown error.", 3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40865f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40866g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f40867h;

        public f(int i2, int i3, String str) {
            this.f40865f = i2;
            this.f40866g = i3;
            this.f40867h = str;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                if (g.this.f40875c != g.this.f40876d && this.f40865f == 1101) {
                    g.this.d(this.f40866g, 3, 2002, g.this.f40875c, "pre verify error, wrong sim operator", 3);
                } else {
                    g gVar = g.this;
                    int i2 = this.f40866g;
                    int i3 = this.f40865f;
                    int i4 = g.this.f40875c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cu pre verify error.");
                    sb.append(this.f40867h);
                    sb.append(", status ");
                    sb.append(this.f40865f);
                    gVar.d(i2, 2, i3, i4, sb.toString(), 3);
                }
            } catch (Throwable unused) {
                g gVar2 = g.this;
                gVar2.d(this.f40866g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f40875c, "cu on handle verify unknown error.", 3);
            }
        }
    }

    public g(Context context) {
        super(context);
        this.s = false;
        this.f40875c = 2;
    }

    @Override // d.a.g0.e.i
    public void g(Context context, int i2) {
        super.g(context, i2);
        if (!d.a.g0.b.a.g(this.f40873a).c()) {
            d(i2, 3, 997, this.f40875c, "pre login error. sdk stop run", 1);
        } else if (!q()) {
            d(i2, 3, 2006, this.f40875c, "pre login error. cu has not valid config.", 1);
        } else if (d.a.g0.b.a.g(this.f40873a).a()) {
            if (!this.s) {
                SDKManager.init(this.f40873a, i.o, i.p);
                SDKManager.setUseCache(false);
                this.s = true;
            }
            UiOauthManager.getInstance(context).login(8, new a(i2));
        } else {
            d(i2, 3, 995, this.f40875c, "pre login error. cu sdk stop run.", 1);
        }
    }

    @Override // d.a.g0.e.i
    public void n(Context context, int i2) {
        super.n(context, i2);
        if (!d.a.g0.b.a.g(this.f40873a).c()) {
            d(i2, 3, 997, this.f40875c, "pre verify error. sdk stop run", 3);
        } else if (!q()) {
            d(i2, 3, 2006, this.f40875c, "pre verify error. cu has not valid config.", 3);
        } else if (d.a.g0.b.a.g(this.f40873a).a()) {
            if (!this.s) {
                SDKManager.init(this.f40873a, i.o, i.p);
                SDKManager.setUseCache(false);
                this.s = true;
            }
            OauthManager.getInstance(this.f40873a).getAuthoriseCode(8, new b(i2));
        } else {
            d(i2, 3, 995, this.f40875c, "pre verify error. cu sdk stop run.", 3);
        }
    }

    @Override // d.a.g0.e.j, d.a.g0.e.i
    public void o(Context context, int i2, long j) {
        super.o(context, i2, j);
    }

    public void t(int i2, String str, int i3) {
        d.a.g0.k.e.c().b(new f(i2, i3, str));
    }

    public final void w(Object obj, int i2) {
        d.a.g0.k.e.c().b(new c(i2, obj));
    }

    public final void x(int i2, String str, int i3) {
        d.a.g0.k.e.c().b(new d(i2, i3, str));
    }

    public final void z(Object obj, int i2) {
        d.a.g0.k.e.c().b(new e(i2, obj));
    }
}
