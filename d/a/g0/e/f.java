package d.a.g0.e;

import android.content.Context;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import com.baidu.android.imsdk.retrieve.RetrieveFileData;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f extends j {
    public boolean s;

    /* loaded from: classes2.dex */
    public class a implements PreCodeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f40080a;

        public a(int i2) {
            this.f40080a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            f.this.v(str, this.f40080a, 1);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements PreCodeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f40082a;

        public b(int i2) {
            this.f40082a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            f.this.v(str, this.f40082a, 3);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40084f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40085g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f40086h;

        public c(String str, int i2, int i3) {
            this.f40084f = str;
            this.f40085g = i2;
            this.f40086h = i3;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject(this.f40084f);
                if (jSONObject.optInt("result", -1) == 0) {
                    f.this.y(jSONObject, this.f40085g, this.f40086h);
                } else {
                    f.this.w(jSONObject, this.f40085g, this.f40086h);
                }
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40088f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40089g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f40090h;

        public d(int i2, int i3, JSONObject jSONObject) {
            this.f40088f = i2;
            this.f40089g = i3;
            this.f40090h = jSONObject;
        }

        @Override // d.a.g0.k.c
        public void b() {
            String str;
            try {
                if (d.a.g0.b.c.f40008c) {
                    f.this.d(this.f40088f, 1, 999, f.this.f40120c, "device has risk.", this.f40089g);
                    return;
                }
                JSONObject optJSONObject = this.f40090h.optJSONObject("data");
                if (this.f40089g == 1) {
                    f.this.f40122e = optJSONObject.optString("accessCode", "");
                    f.this.f40124g = optJSONObject.optString(IdCardActivity.KEY_NUMBER, "");
                    f.this.f40123f = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, f.this.f40124g);
                    str = jSONObject.toString();
                } else {
                    f.this.f40125h = optJSONObject.optString("accessCode", "");
                    f.this.f40126i = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                    str = "preVerify success";
                }
                f.this.d(this.f40088f, 0, 0, f.this.f40120c, str, this.f40089g);
            } catch (Throwable unused) {
                f fVar = f.this;
                fVar.d(this.f40088f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar.f40120c, "ct on handle pre login or verify unknown error.", this.f40089g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f40092f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40093g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f40094h;

        public e(JSONObject jSONObject, int i2, int i3) {
            this.f40092f = jSONObject;
            this.f40093g = i2;
            this.f40094h = i3;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                int optInt = this.f40092f.optInt("result", -1);
                String optString = this.f40092f.optString("msg", "");
                if (f.this.f40120c != f.this.f40121d && (optInt == -10009 || optInt == -10008)) {
                    f.this.d(this.f40093g, 3, 2002, f.this.f40120c, "pre login error, wrong sim operator", this.f40094h);
                } else {
                    f fVar = f.this;
                    int i2 = this.f40093g;
                    int i3 = f.this.f40120c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ct pre login error.");
                    sb.append(optString);
                    sb.append(", status ");
                    sb.append(optInt);
                    fVar.d(i2, 2, optInt, i3, sb.toString(), this.f40094h);
                }
            } catch (Throwable unused) {
                f fVar2 = f.this;
                fVar2.d(this.f40093g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar2.f40120c, "ct on handle pre login or verify unknown error.", this.f40094h);
            }
        }
    }

    public f(Context context) {
        super(context);
        this.s = false;
        this.f40120c = 3;
    }

    @Override // d.a.g0.e.i
    public void g(Context context, int i2) {
        super.g(context, i2);
        if (!d.a.g0.b.a.g(this.f40118a).c()) {
            d(i2, 3, 997, this.f40120c, "pre login error. sdk stop run.", 1);
        } else if (!q()) {
            d(i2, 3, 2006, this.f40120c, "pre login error. ct has not valid config.", 1);
        } else if (d.a.g0.b.a.g(this.f40118a).n0()) {
            if (!this.s) {
                CtAuth.init(0, 0, 8000, null);
                this.s = true;
            }
            CtAuth.requestPreAuthCode(context, i.m, i.n, new a(i2));
        } else {
            d(i2, 3, 996, this.f40120c, "pre login error. ct sdk stop run.", 1);
        }
    }

    @Override // d.a.g0.e.i
    public void n(Context context, int i2) {
        super.n(context, i2);
        if (!d.a.g0.b.a.g(this.f40118a).c()) {
            d(i2, 3, 997, this.f40120c, "pre verify error. sdk stop run.", 3);
        } else if (!q()) {
            d(i2, 3, 2006, this.f40120c, "pre verify error. ct has not valid config.", 3);
        } else if (d.a.g0.b.a.g(this.f40118a).n0()) {
            if (!this.s) {
                CtAuth.init(0, 0, 8000, null);
                this.s = true;
            }
            CtAuth.requestPreAuthCode(context, i.m, i.n, new b(i2));
        } else {
            d(i2, 3, 996, this.f40120c, "pre verify error. ct sdk stop run.", 3);
        }
    }

    @Override // d.a.g0.e.j, d.a.g0.e.i
    public void o(Context context, int i2, long j) {
        super.o(context, i2, j);
    }

    public final void v(String str, int i2, int i3) {
        d.a.g0.k.e.c().b(new c(str, i2, i3));
    }

    public final void w(JSONObject jSONObject, int i2, int i3) {
        d.a.g0.k.e.c().b(new e(jSONObject, i2, i3));
    }

    public final void y(JSONObject jSONObject, int i2, int i3) {
        d.a.g0.k.e.c().b(new d(i2, i3, jSONObject));
    }
}
