package d.b.f0.e;

import android.content.Context;
import cn.com.chinatelecom.gateway.lib.CtAuth;
import cn.com.chinatelecom.gateway.lib.PreCodeListener;
import com.baidu.android.imsdk.retrieve.RetrieveFileData;
import com.baidu.mapapi.UIMsg;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.wallet.base.iddetect.IdCardActivity;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f extends j {
    public boolean s;

    /* loaded from: classes3.dex */
    public class a implements PreCodeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f42900a;

        public a(int i) {
            this.f42900a = i;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            f.this.v(str, this.f42900a, 1);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements PreCodeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f42902a;

        public b(int i) {
            this.f42902a = i;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            f.this.v(str, this.f42902a, 3);
        }
    }

    /* loaded from: classes3.dex */
    public class c extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f42904f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42905g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f42906h;

        public c(String str, int i, int i2) {
            this.f42904f = str;
            this.f42905g = i;
            this.f42906h = i2;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject(this.f42904f);
                if (jSONObject.optInt("result", -1) == 0) {
                    f.this.y(jSONObject, this.f42905g, this.f42906h);
                } else {
                    f.this.w(jSONObject, this.f42905g, this.f42906h);
                }
            } catch (Throwable th) {
                d.b.f0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f42907f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42908g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42909h;

        public d(int i, int i2, JSONObject jSONObject) {
            this.f42907f = i;
            this.f42908g = i2;
            this.f42909h = jSONObject;
        }

        @Override // d.b.f0.k.c
        public void b() {
            String str;
            try {
                if (d.b.f0.b.c.f42828c) {
                    f.this.d(this.f42907f, 1, 999, f.this.f42935c, "device has risk.", this.f42908g);
                    return;
                }
                JSONObject optJSONObject = this.f42909h.optJSONObject("data");
                if (this.f42908g == 1) {
                    f.this.f42937e = optJSONObject.optString("accessCode", "");
                    f.this.f42939g = optJSONObject.optString(IdCardActivity.KEY_NUMBER, "");
                    f.this.f42938f = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, f.this.f42939g);
                    str = jSONObject.toString();
                } else {
                    f.this.f42940h = optJSONObject.optString("accessCode", "");
                    f.this.i = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                    str = "preVerify success";
                }
                f.this.d(this.f42907f, 0, 0, f.this.f42935c, str, this.f42908g);
            } catch (Throwable unused) {
                f fVar = f.this;
                fVar.d(this.f42907f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar.f42935c, "ct on handle pre login or verify unknown error.", this.f42908g);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends d.b.f0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f42910f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f42911g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f42912h;

        public e(JSONObject jSONObject, int i, int i2) {
            this.f42910f = jSONObject;
            this.f42911g = i;
            this.f42912h = i2;
        }

        @Override // d.b.f0.k.c
        public void b() {
            try {
                int optInt = this.f42910f.optInt("result", -1);
                String optString = this.f42910f.optString("msg", "");
                if (f.this.f42935c != f.this.f42936d && (optInt == -10009 || optInt == -10008)) {
                    f.this.d(this.f42911g, 3, 2002, f.this.f42935c, "pre login error, wrong sim operator", this.f42912h);
                } else {
                    f fVar = f.this;
                    int i = this.f42911g;
                    int i2 = f.this.f42935c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ct pre login error.");
                    sb.append(optString);
                    sb.append(", status ");
                    sb.append(optInt);
                    fVar.d(i, 2, optInt, i2, sb.toString(), this.f42912h);
                }
            } catch (Throwable unused) {
                f fVar2 = f.this;
                fVar2.d(this.f42911g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar2.f42935c, "ct on handle pre login or verify unknown error.", this.f42912h);
            }
        }
    }

    public f(Context context) {
        super(context);
        this.s = false;
        this.f42935c = 3;
    }

    @Override // d.b.f0.e.i
    public void g(Context context, int i) {
        super.g(context, i);
        if (!d.b.f0.b.a.g(this.f42933a).c()) {
            d(i, 3, 997, this.f42935c, "pre login error. sdk stop run.", 1);
        } else if (!q()) {
            d(i, 3, 2006, this.f42935c, "pre login error. ct has not valid config.", 1);
        } else if (d.b.f0.b.a.g(this.f42933a).n0()) {
            if (!this.s) {
                CtAuth.init(0, 0, 8000, null);
                this.s = true;
            }
            CtAuth.requestPreAuthCode(context, i.m, i.n, new a(i));
        } else {
            d(i, 3, 996, this.f42935c, "pre login error. ct sdk stop run.", 1);
        }
    }

    @Override // d.b.f0.e.i
    public void n(Context context, int i) {
        super.n(context, i);
        if (!d.b.f0.b.a.g(this.f42933a).c()) {
            d(i, 3, 997, this.f42935c, "pre verify error. sdk stop run.", 3);
        } else if (!q()) {
            d(i, 3, 2006, this.f42935c, "pre verify error. ct has not valid config.", 3);
        } else if (d.b.f0.b.a.g(this.f42933a).n0()) {
            if (!this.s) {
                CtAuth.init(0, 0, 8000, null);
                this.s = true;
            }
            CtAuth.requestPreAuthCode(context, i.m, i.n, new b(i));
        } else {
            d(i, 3, 996, this.f42935c, "pre verify error. ct sdk stop run.", 3);
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
