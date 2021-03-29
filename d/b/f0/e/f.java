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
        public final /* synthetic */ int f42901a;

        public a(int i) {
            this.f42901a = i;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            f.this.v(str, this.f42901a, 1);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements PreCodeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f42903a;

        public b(int i) {
            this.f42903a = i;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            f.this.v(str, this.f42903a, 3);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f42905f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42906g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f42907h;

        public c(String str, int i, int i2) {
            this.f42905f = str;
            this.f42906g = i;
            this.f42907h = i2;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject(this.f42905f);
                if (jSONObject.optInt("result", -1) == 0) {
                    f.this.y(jSONObject, this.f42906g, this.f42907h);
                } else {
                    f.this.w(jSONObject, this.f42906g, this.f42907h);
                }
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42908f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42909g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42910h;

        public d(int i, int i2, JSONObject jSONObject) {
            this.f42908f = i;
            this.f42909g = i2;
            this.f42910h = jSONObject;
        }

        @Override // d.b.f0.k.c
        public void b() {
            String str;
            try {
                if (d.b.f0.b.c.f42829c) {
                    f.this.d(this.f42908f, 1, 999, f.this.f42936c, "device has risk.", this.f42909g);
                    return;
                }
                JSONObject optJSONObject = this.f42910h.optJSONObject("data");
                if (this.f42909g == 1) {
                    f.this.f42938e = optJSONObject.optString("accessCode", "");
                    f.this.f42940g = optJSONObject.optString(IdCardActivity.KEY_NUMBER, "");
                    f.this.f42939f = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, f.this.f42940g);
                    str = jSONObject.toString();
                } else {
                    f.this.f42941h = optJSONObject.optString("accessCode", "");
                    f.this.i = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                    str = "preVerify success";
                }
                f.this.d(this.f42908f, 0, 0, f.this.f42936c, str, this.f42909g);
            } catch (Throwable unused) {
                f fVar = f.this;
                fVar.d(this.f42908f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar.f42936c, "ct on handle pre login or verify unknown error.", this.f42909g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42911f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42912g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f42913h;

        public e(JSONObject jSONObject, int i, int i2) {
            this.f42911f = jSONObject;
            this.f42912g = i;
            this.f42913h = i2;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                int optInt = this.f42911f.optInt("result", -1);
                String optString = this.f42911f.optString("msg", "");
                if (f.this.f42936c != f.this.f42937d && (optInt == -10009 || optInt == -10008)) {
                    f.this.d(this.f42912g, 3, 2002, f.this.f42936c, "pre login error, wrong sim operator", this.f42913h);
                } else {
                    f fVar = f.this;
                    int i = this.f42912g;
                    int i2 = f.this.f42936c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ct pre login error.");
                    sb.append(optString);
                    sb.append(", status ");
                    sb.append(optInt);
                    fVar.d(i, 2, optInt, i2, sb.toString(), this.f42913h);
                }
            } catch (Throwable unused) {
                f fVar2 = f.this;
                fVar2.d(this.f42912g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar2.f42936c, "ct on handle pre login or verify unknown error.", this.f42913h);
            }
        }
    }

    public f(Context context) {
        super(context);
        this.s = false;
        this.f42936c = 3;
    }

    @Override // d.b.f0.e.i
    public void g(Context context, int i) {
        super.g(context, i);
        if (!d.b.f0.b.a.g(this.f42934a).c()) {
            d(i, 3, 997, this.f42936c, "pre login error. sdk stop run.", 1);
        } else if (!q()) {
            d(i, 3, 2006, this.f42936c, "pre login error. ct has not valid config.", 1);
        } else if (d.b.f0.b.a.g(this.f42934a).n0()) {
            if (!this.s) {
                CtAuth.init(0, 0, 8000, null);
                this.s = true;
            }
            CtAuth.requestPreAuthCode(context, i.m, i.n, new a(i));
        } else {
            d(i, 3, 996, this.f42936c, "pre login error. ct sdk stop run.", 1);
        }
    }

    @Override // d.b.f0.e.i
    public void n(Context context, int i) {
        super.n(context, i);
        if (!d.b.f0.b.a.g(this.f42934a).c()) {
            d(i, 3, 997, this.f42936c, "pre verify error. sdk stop run.", 3);
        } else if (!q()) {
            d(i, 3, 2006, this.f42936c, "pre verify error. ct has not valid config.", 3);
        } else if (d.b.f0.b.a.g(this.f42934a).n0()) {
            if (!this.s) {
                CtAuth.init(0, 0, 8000, null);
                this.s = true;
            }
            CtAuth.requestPreAuthCode(context, i.m, i.n, new b(i));
        } else {
            d(i, 3, 996, this.f42936c, "pre verify error. ct sdk stop run.", 3);
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
