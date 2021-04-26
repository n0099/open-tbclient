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
        public final /* synthetic */ int f40835a;

        public a(int i2) {
            this.f40835a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            f.this.v(str, this.f40835a, 1);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements PreCodeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f40837a;

        public b(int i2) {
            this.f40837a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            f.this.v(str, this.f40837a, 3);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f40839f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40840g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f40841h;

        public c(String str, int i2, int i3) {
            this.f40839f = str;
            this.f40840g = i2;
            this.f40841h = i3;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject(this.f40839f);
                if (jSONObject.optInt("result", -1) == 0) {
                    f.this.y(jSONObject, this.f40840g, this.f40841h);
                } else {
                    f.this.w(jSONObject, this.f40840g, this.f40841h);
                }
            } catch (Throwable th) {
                d.a.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f40843f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40844g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f40845h;

        public d(int i2, int i3, JSONObject jSONObject) {
            this.f40843f = i2;
            this.f40844g = i3;
            this.f40845h = jSONObject;
        }

        @Override // d.a.g0.k.c
        public void b() {
            String str;
            try {
                if (d.a.g0.b.c.f40763c) {
                    f.this.d(this.f40843f, 1, 999, f.this.f40875c, "device has risk.", this.f40844g);
                    return;
                }
                JSONObject optJSONObject = this.f40845h.optJSONObject("data");
                if (this.f40844g == 1) {
                    f.this.f40877e = optJSONObject.optString("accessCode", "");
                    f.this.f40879g = optJSONObject.optString(IdCardActivity.KEY_NUMBER, "");
                    f.this.f40878f = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, f.this.f40879g);
                    str = jSONObject.toString();
                } else {
                    f.this.f40880h = optJSONObject.optString("accessCode", "");
                    f.this.f40881i = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                    str = "preVerify success";
                }
                f.this.d(this.f40843f, 0, 0, f.this.f40875c, str, this.f40844g);
            } catch (Throwable unused) {
                f fVar = f.this;
                fVar.d(this.f40843f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar.f40875c, "ct on handle pre login or verify unknown error.", this.f40844g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends d.a.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f40847f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f40848g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f40849h;

        public e(JSONObject jSONObject, int i2, int i3) {
            this.f40847f = jSONObject;
            this.f40848g = i2;
            this.f40849h = i3;
        }

        @Override // d.a.g0.k.c
        public void b() {
            try {
                int optInt = this.f40847f.optInt("result", -1);
                String optString = this.f40847f.optString("msg", "");
                if (f.this.f40875c != f.this.f40876d && (optInt == -10009 || optInt == -10008)) {
                    f.this.d(this.f40848g, 3, 2002, f.this.f40875c, "pre login error, wrong sim operator", this.f40849h);
                } else {
                    f fVar = f.this;
                    int i2 = this.f40848g;
                    int i3 = f.this.f40875c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ct pre login error.");
                    sb.append(optString);
                    sb.append(", status ");
                    sb.append(optInt);
                    fVar.d(i2, 2, optInt, i3, sb.toString(), this.f40849h);
                }
            } catch (Throwable unused) {
                f fVar2 = f.this;
                fVar2.d(this.f40848g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar2.f40875c, "ct on handle pre login or verify unknown error.", this.f40849h);
            }
        }
    }

    public f(Context context) {
        super(context);
        this.s = false;
        this.f40875c = 3;
    }

    @Override // d.a.g0.e.i
    public void g(Context context, int i2) {
        super.g(context, i2);
        if (!d.a.g0.b.a.g(this.f40873a).c()) {
            d(i2, 3, 997, this.f40875c, "pre login error. sdk stop run.", 1);
        } else if (!q()) {
            d(i2, 3, 2006, this.f40875c, "pre login error. ct has not valid config.", 1);
        } else if (d.a.g0.b.a.g(this.f40873a).n0()) {
            if (!this.s) {
                CtAuth.init(0, 0, 8000, null);
                this.s = true;
            }
            CtAuth.requestPreAuthCode(context, i.m, i.n, new a(i2));
        } else {
            d(i2, 3, 996, this.f40875c, "pre login error. ct sdk stop run.", 1);
        }
    }

    @Override // d.a.g0.e.i
    public void n(Context context, int i2) {
        super.n(context, i2);
        if (!d.a.g0.b.a.g(this.f40873a).c()) {
            d(i2, 3, 997, this.f40875c, "pre verify error. sdk stop run.", 3);
        } else if (!q()) {
            d(i2, 3, 2006, this.f40875c, "pre verify error. ct has not valid config.", 3);
        } else if (d.a.g0.b.a.g(this.f40873a).n0()) {
            if (!this.s) {
                CtAuth.init(0, 0, 8000, null);
                this.s = true;
            }
            CtAuth.requestPreAuthCode(context, i.m, i.n, new b(i2));
        } else {
            d(i2, 3, 996, this.f40875c, "pre verify error. ct sdk stop run.", 3);
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
