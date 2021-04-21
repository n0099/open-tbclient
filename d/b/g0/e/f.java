package d.b.g0.e;

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
        public final /* synthetic */ int f43590a;

        public a(int i) {
            this.f43590a = i;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            f.this.v(str, this.f43590a, 1);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements PreCodeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43592a;

        public b(int i) {
            this.f43592a = i;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            f.this.v(str, this.f43592a, 3);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43594f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43595g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43596h;

        public c(String str, int i, int i2) {
            this.f43594f = str;
            this.f43595g = i;
            this.f43596h = i2;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject(this.f43594f);
                if (jSONObject.optInt("result", -1) == 0) {
                    f.this.y(jSONObject, this.f43595g, this.f43596h);
                } else {
                    f.this.w(jSONObject, this.f43595g, this.f43596h);
                }
            } catch (Throwable th) {
                d.b.g0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43597f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43598g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43599h;

        public d(int i, int i2, JSONObject jSONObject) {
            this.f43597f = i;
            this.f43598g = i2;
            this.f43599h = jSONObject;
        }

        @Override // d.b.g0.k.c
        public void b() {
            String str;
            try {
                if (d.b.g0.b.c.f43518c) {
                    f.this.d(this.f43597f, 1, 999, f.this.f43625c, "device has risk.", this.f43598g);
                    return;
                }
                JSONObject optJSONObject = this.f43599h.optJSONObject("data");
                if (this.f43598g == 1) {
                    f.this.f43627e = optJSONObject.optString("accessCode", "");
                    f.this.f43629g = optJSONObject.optString(IdCardActivity.KEY_NUMBER, "");
                    f.this.f43628f = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, f.this.f43629g);
                    str = jSONObject.toString();
                } else {
                    f.this.f43630h = optJSONObject.optString("accessCode", "");
                    f.this.i = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                    str = "preVerify success";
                }
                f.this.d(this.f43597f, 0, 0, f.this.f43625c, str, this.f43598g);
            } catch (Throwable unused) {
                f fVar = f.this;
                fVar.d(this.f43597f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar.f43625c, "ct on handle pre login or verify unknown error.", this.f43598g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends d.b.g0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43600f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43601g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43602h;

        public e(JSONObject jSONObject, int i, int i2) {
            this.f43600f = jSONObject;
            this.f43601g = i;
            this.f43602h = i2;
        }

        @Override // d.b.g0.k.c
        public void b() {
            try {
                int optInt = this.f43600f.optInt("result", -1);
                String optString = this.f43600f.optString("msg", "");
                if (f.this.f43625c != f.this.f43626d && (optInt == -10009 || optInt == -10008)) {
                    f.this.d(this.f43601g, 3, 2002, f.this.f43625c, "pre login error, wrong sim operator", this.f43602h);
                } else {
                    f fVar = f.this;
                    int i = this.f43601g;
                    int i2 = f.this.f43625c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ct pre login error.");
                    sb.append(optString);
                    sb.append(", status ");
                    sb.append(optInt);
                    fVar.d(i, 2, optInt, i2, sb.toString(), this.f43602h);
                }
            } catch (Throwable unused) {
                f fVar2 = f.this;
                fVar2.d(this.f43601g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar2.f43625c, "ct on handle pre login or verify unknown error.", this.f43602h);
            }
        }
    }

    public f(Context context) {
        super(context);
        this.s = false;
        this.f43625c = 3;
    }

    @Override // d.b.g0.e.i
    public void g(Context context, int i) {
        super.g(context, i);
        if (!d.b.g0.b.a.g(this.f43623a).c()) {
            d(i, 3, 997, this.f43625c, "pre login error. sdk stop run.", 1);
        } else if (!q()) {
            d(i, 3, 2006, this.f43625c, "pre login error. ct has not valid config.", 1);
        } else if (d.b.g0.b.a.g(this.f43623a).n0()) {
            if (!this.s) {
                CtAuth.init(0, 0, 8000, null);
                this.s = true;
            }
            CtAuth.requestPreAuthCode(context, i.m, i.n, new a(i));
        } else {
            d(i, 3, 996, this.f43625c, "pre login error. ct sdk stop run.", 1);
        }
    }

    @Override // d.b.g0.e.i
    public void n(Context context, int i) {
        super.n(context, i);
        if (!d.b.g0.b.a.g(this.f43623a).c()) {
            d(i, 3, 997, this.f43625c, "pre verify error. sdk stop run.", 3);
        } else if (!q()) {
            d(i, 3, 2006, this.f43625c, "pre verify error. ct has not valid config.", 3);
        } else if (d.b.g0.b.a.g(this.f43623a).n0()) {
            if (!this.s) {
                CtAuth.init(0, 0, 8000, null);
                this.s = true;
            }
            CtAuth.requestPreAuthCode(context, i.m, i.n, new b(i));
        } else {
            d(i, 3, 996, this.f43625c, "pre verify error. ct sdk stop run.", 3);
        }
    }

    @Override // d.b.g0.e.j, d.b.g0.e.i
    public void o(Context context, int i, long j) {
        super.o(context, i, j);
    }

    public final void v(String str, int i, int i2) {
        d.b.g0.k.e.c().b(new c(str, i, i2));
    }

    public final void w(JSONObject jSONObject, int i, int i2) {
        d.b.g0.k.e.c().b(new e(jSONObject, i, i2));
    }

    public final void y(JSONObject jSONObject, int i, int i2) {
        d.b.g0.k.e.c().b(new d(i, i2, jSONObject));
    }
}
