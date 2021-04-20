package d.b.f0.e;

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
        public final /* synthetic */ int f43293a;

        public a(int i) {
            this.f43293a = i;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            f.this.v(str, this.f43293a, 1);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements PreCodeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f43295a;

        public b(int i) {
            this.f43295a = i;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            f.this.v(str, this.f43295a, 3);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43297f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43298g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43299h;

        public c(String str, int i, int i2) {
            this.f43297f = str;
            this.f43298g = i;
            this.f43299h = i2;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject(this.f43297f);
                if (jSONObject.optInt("result", -1) == 0) {
                    f.this.y(jSONObject, this.f43298g, this.f43299h);
                } else {
                    f.this.w(jSONObject, this.f43298g, this.f43299h);
                }
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f43300f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43301g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43302h;

        public d(int i, int i2, JSONObject jSONObject) {
            this.f43300f = i;
            this.f43301g = i2;
            this.f43302h = jSONObject;
        }

        @Override // d.b.f0.k.c
        public void b() {
            String str;
            try {
                if (d.b.f0.b.c.f43221c) {
                    f.this.d(this.f43300f, 1, 999, f.this.f43328c, "device has risk.", this.f43301g);
                    return;
                }
                JSONObject optJSONObject = this.f43302h.optJSONObject("data");
                if (this.f43301g == 1) {
                    f.this.f43330e = optJSONObject.optString("accessCode", "");
                    f.this.f43332g = optJSONObject.optString(IdCardActivity.KEY_NUMBER, "");
                    f.this.f43331f = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, f.this.f43332g);
                    str = jSONObject.toString();
                } else {
                    f.this.f43333h = optJSONObject.optString("accessCode", "");
                    f.this.i = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                    str = "preVerify success";
                }
                f.this.d(this.f43300f, 0, 0, f.this.f43328c, str, this.f43301g);
            } catch (Throwable unused) {
                f fVar = f.this;
                fVar.d(this.f43300f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar.f43328c, "ct on handle pre login or verify unknown error.", this.f43301g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f43303f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f43304g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f43305h;

        public e(JSONObject jSONObject, int i, int i2) {
            this.f43303f = jSONObject;
            this.f43304g = i;
            this.f43305h = i2;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                int optInt = this.f43303f.optInt("result", -1);
                String optString = this.f43303f.optString("msg", "");
                if (f.this.f43328c != f.this.f43329d && (optInt == -10009 || optInt == -10008)) {
                    f.this.d(this.f43304g, 3, 2002, f.this.f43328c, "pre login error, wrong sim operator", this.f43305h);
                } else {
                    f fVar = f.this;
                    int i = this.f43304g;
                    int i2 = f.this.f43328c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ct pre login error.");
                    sb.append(optString);
                    sb.append(", status ");
                    sb.append(optInt);
                    fVar.d(i, 2, optInt, i2, sb.toString(), this.f43305h);
                }
            } catch (Throwable unused) {
                f fVar2 = f.this;
                fVar2.d(this.f43304g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar2.f43328c, "ct on handle pre login or verify unknown error.", this.f43305h);
            }
        }
    }

    public f(Context context) {
        super(context);
        this.s = false;
        this.f43328c = 3;
    }

    @Override // d.b.f0.e.i
    public void g(Context context, int i) {
        super.g(context, i);
        if (!d.b.f0.b.a.g(this.f43326a).c()) {
            d(i, 3, 997, this.f43328c, "pre login error. sdk stop run.", 1);
        } else if (!q()) {
            d(i, 3, 2006, this.f43328c, "pre login error. ct has not valid config.", 1);
        } else if (d.b.f0.b.a.g(this.f43326a).n0()) {
            if (!this.s) {
                CtAuth.init(0, 0, 8000, null);
                this.s = true;
            }
            CtAuth.requestPreAuthCode(context, i.m, i.n, new a(i));
        } else {
            d(i, 3, 996, this.f43328c, "pre login error. ct sdk stop run.", 1);
        }
    }

    @Override // d.b.f0.e.i
    public void n(Context context, int i) {
        super.n(context, i);
        if (!d.b.f0.b.a.g(this.f43326a).c()) {
            d(i, 3, 997, this.f43328c, "pre verify error. sdk stop run.", 3);
        } else if (!q()) {
            d(i, 3, 2006, this.f43328c, "pre verify error. ct has not valid config.", 3);
        } else if (d.b.f0.b.a.g(this.f43326a).n0()) {
            if (!this.s) {
                CtAuth.init(0, 0, 8000, null);
                this.s = true;
            }
            CtAuth.requestPreAuthCode(context, i.m, i.n, new b(i));
        } else {
            d(i, 3, 996, this.f43328c, "pre verify error. ct sdk stop run.", 3);
        }
    }

    @Override // d.b.f0.e.j, d.b.f0.e.i
    public void o(Context context, int i, long j) {
        super.o(context, i, j);
    }

    public final void v(String str, int i, int i2) {
        d.b.f0.k.e.c().b(new c(str, i, i2));
    }

    public final void w(JSONObject jSONObject, int i, int i2) {
        d.b.f0.k.e.c().b(new e(jSONObject, i, i2));
    }

    public final void y(JSONObject jSONObject, int i, int i2) {
        d.b.f0.k.e.c().b(new d(i, i2, jSONObject));
    }
}
