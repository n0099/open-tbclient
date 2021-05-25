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
        public final /* synthetic */ int f40357a;

        public a(int i2) {
            this.f40357a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            g.this.x(i3, str, this.f40357a);
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            if (i2 == 0) {
                g.this.w(obj, this.f40357a);
            } else {
                g.this.x(i3, str, this.f40357a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements CallBack<Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f40359a;

        public b(int i2) {
            this.f40359a = i2;
        }

        @Override // com.sdk.base.api.CallBack
        public void onFailed(int i2, int i3, String str, String str2) {
            g.this.t(i3, str, this.f40359a);
        }

        @Override // com.sdk.base.api.CallBack
        public void onSuccess(int i2, String str, int i3, Object obj, String str2) {
            if (i2 == 0) {
                g.this.z(obj, this.f40359a);
            } else {
                g.this.t(i3, str, this.f40359a);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40361f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f40362g;

        public c(int i2, Object obj) {
            this.f40361f = i2;
            this.f40362g = obj;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                if (d.a.j0.b.c.f40269c) {
                    g.this.d(this.f40361f, 1, 999, g.this.f40381c, "device has risk.", 1);
                    return;
                }
                JSONObject jSONObject = new JSONObject((String) this.f40362g);
                g.this.f40385g = jSONObject.optString(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE);
                g.this.f40383e = jSONObject.optString("accessCode");
                g.this.f40384f = jSONObject.optLong("exp");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, g.this.f40385g);
                g.this.d(this.f40361f, 0, 0, g.this.f40381c, jSONObject2.toString(), 1);
            } catch (Throwable unused) {
                g gVar = g.this;
                gVar.d(this.f40361f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f40381c, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40364f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40365g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f40366h;

        public d(int i2, int i3, String str) {
            this.f40364f = i2;
            this.f40365g = i3;
            this.f40366h = str;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                if (g.this.f40381c != g.this.f40382d && this.f40364f == 1101) {
                    g.this.d(this.f40365g, 3, 2002, g.this.f40381c, "pre login error, wrong sim operator", 1);
                } else {
                    g gVar = g.this;
                    int i2 = this.f40365g;
                    int i3 = this.f40364f;
                    int i4 = g.this.f40381c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cu pre login error.");
                    sb.append(this.f40366h);
                    sb.append(", status ");
                    sb.append(this.f40364f);
                    gVar.d(i2, 2, i3, i4, sb.toString(), 1);
                }
            } catch (Throwable unused) {
                g gVar2 = g.this;
                gVar2.d(this.f40365g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f40381c, "cu on handle login unknown error.", 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40368f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Object f40369g;

        public e(int i2, Object obj) {
            this.f40368f = i2;
            this.f40369g = obj;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                if (d.a.j0.b.c.f40269c) {
                    g.this.d(this.f40368f, 1, 999, g.this.f40381c, "device has risk.", 3);
                    return;
                }
                JSONObject jSONObject = new JSONObject((String) this.f40369g);
                g.this.f40386h = jSONObject.optString("accessCode");
                g.this.f40387i = jSONObject.optLong("exp");
                g.this.d(this.f40368f, 0, 0, g.this.f40381c, "preVerify success", 3);
            } catch (Throwable unused) {
                g gVar = g.this;
                gVar.d(this.f40368f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar.f40381c, "cu on handle preVerify unknown error.", 3);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40371f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40372g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f40373h;

        public f(int i2, int i3, String str) {
            this.f40371f = i2;
            this.f40372g = i3;
            this.f40373h = str;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                if (g.this.f40381c != g.this.f40382d && this.f40371f == 1101) {
                    g.this.d(this.f40372g, 3, 2002, g.this.f40381c, "pre verify error, wrong sim operator", 3);
                } else {
                    g gVar = g.this;
                    int i2 = this.f40372g;
                    int i3 = this.f40371f;
                    int i4 = g.this.f40381c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("cu pre verify error.");
                    sb.append(this.f40373h);
                    sb.append(", status ");
                    sb.append(this.f40371f);
                    gVar.d(i2, 2, i3, i4, sb.toString(), 3);
                }
            } catch (Throwable unused) {
                g gVar2 = g.this;
                gVar2.d(this.f40372g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, gVar2.f40381c, "cu on handle verify unknown error.", 3);
            }
        }
    }

    public g(Context context) {
        super(context);
        this.s = false;
        this.f40381c = 2;
    }

    @Override // d.a.j0.e.i
    public void g(Context context, int i2) {
        super.g(context, i2);
        if (!d.a.j0.b.a.g(this.f40379a).c()) {
            d(i2, 3, 997, this.f40381c, "pre login error. sdk stop run", 1);
        } else if (!q()) {
            d(i2, 3, 2006, this.f40381c, "pre login error. cu has not valid config.", 1);
        } else if (d.a.j0.b.a.g(this.f40379a).a()) {
            if (!this.s) {
                SDKManager.init(this.f40379a, i.o, i.p);
                SDKManager.setUseCache(false);
                this.s = true;
            }
            UiOauthManager.getInstance(context).login(8, new a(i2));
        } else {
            d(i2, 3, 995, this.f40381c, "pre login error. cu sdk stop run.", 1);
        }
    }

    @Override // d.a.j0.e.i
    public void n(Context context, int i2) {
        super.n(context, i2);
        if (!d.a.j0.b.a.g(this.f40379a).c()) {
            d(i2, 3, 997, this.f40381c, "pre verify error. sdk stop run", 3);
        } else if (!q()) {
            d(i2, 3, 2006, this.f40381c, "pre verify error. cu has not valid config.", 3);
        } else if (d.a.j0.b.a.g(this.f40379a).a()) {
            if (!this.s) {
                SDKManager.init(this.f40379a, i.o, i.p);
                SDKManager.setUseCache(false);
                this.s = true;
            }
            OauthManager.getInstance(this.f40379a).getAuthoriseCode(8, new b(i2));
        } else {
            d(i2, 3, 995, this.f40381c, "pre verify error. cu sdk stop run.", 3);
        }
    }

    @Override // d.a.j0.e.j, d.a.j0.e.i
    public void o(Context context, int i2, long j) {
        super.o(context, i2, j);
    }

    public void t(int i2, String str, int i3) {
        d.a.j0.k.e.c().b(new f(i2, i3, str));
    }

    public final void w(Object obj, int i2) {
        d.a.j0.k.e.c().b(new c(i2, obj));
    }

    public final void x(int i2, String str, int i3) {
        d.a.j0.k.e.c().b(new d(i2, i3, str));
    }

    public final void z(Object obj, int i2) {
        d.a.j0.k.e.c().b(new e(i2, obj));
    }
}
