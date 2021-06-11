package d.a.j0.e;

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
        public final /* synthetic */ int f44020a;

        public a(long j, int i2) {
            this.f44020a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            f.this.w(str, this.f44020a, 1);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements PreCodeListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f44022a;

        public b(int i2) {
            this.f44022a = i2;
        }

        @Override // cn.com.chinatelecom.gateway.lib.PreCodeListener
        public void onResult(String str) {
            f.this.w(str, this.f44022a, 3);
        }
    }

    /* loaded from: classes2.dex */
    public class c extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44024f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44025g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44026h;

        public c(String str, int i2, int i3) {
            this.f44024f = str;
            this.f44025g = i2;
            this.f44026h = i3;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                JSONObject jSONObject = new JSONObject(this.f44024f);
                if (jSONObject.optInt("result", -1) == 0) {
                    f.this.z(jSONObject, this.f44025g, this.f44026h);
                } else {
                    f.this.x(jSONObject, this.f44025g, this.f44026h);
                }
            } catch (Throwable th) {
                d.a.j0.l.c.d(th);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f44028f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44029g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44030h;

        public d(int i2, int i3, JSONObject jSONObject) {
            this.f44028f = i2;
            this.f44029g = i3;
            this.f44030h = jSONObject;
        }

        @Override // d.a.j0.k.c
        public void b() {
            String str;
            try {
                if (d.a.j0.b.c.f43950c) {
                    f.this.e(this.f44028f, 1, 999, f.this.f44060c, "device has risk.", this.f44029g);
                    return;
                }
                JSONObject optJSONObject = this.f44030h.optJSONObject("data");
                if (this.f44029g == 1) {
                    f.this.f44062e = optJSONObject.optString("accessCode", "");
                    f.this.f44064g = optJSONObject.optString(IdCardActivity.KEY_NUMBER, "");
                    f.this.f44063f = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(OneKeyLoginOptResult.OptResultFields.SECURITY_PHONE, f.this.a(f.this.f44064g));
                    str = jSONObject.toString();
                } else {
                    f.this.f44065h = optJSONObject.optString("accessCode", "");
                    f.this.f44066i = System.currentTimeMillis() + (optJSONObject.optInt(RetrieveFileData.EXPIRED, 0) * 1000);
                    str = "preVerify success";
                }
                f.this.e(this.f44028f, 0, 0, f.this.f44060c, str, this.f44029g);
            } catch (Throwable unused) {
                f fVar = f.this;
                fVar.e(this.f44028f, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar.f44060c, "ct on handle pre login or verify unknown error.", this.f44029g);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e extends d.a.j0.k.c {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44032f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f44033g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ int f44034h;

        public e(JSONObject jSONObject, int i2, int i3) {
            this.f44032f = jSONObject;
            this.f44033g = i2;
            this.f44034h = i3;
        }

        @Override // d.a.j0.k.c
        public void b() {
            try {
                int optInt = this.f44032f.optInt("result", -1);
                String optString = this.f44032f.optString("msg", "");
                if (f.this.f44060c != f.this.f44061d && (optInt == -10009 || optInt == -10008)) {
                    f.this.e(this.f44033g, 3, 2002, f.this.f44060c, "pre login error, wrong sim operator", this.f44034h);
                } else {
                    f fVar = f.this;
                    int i2 = this.f44033g;
                    int i3 = f.this.f44060c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("ct pre login error.");
                    sb.append(optString);
                    sb.append(", status ");
                    sb.append(optInt);
                    fVar.e(i2, 2, optInt, i3, sb.toString(), this.f44034h);
                }
            } catch (Throwable unused) {
                f fVar2 = f.this;
                fVar2.e(this.f44033g, 3, UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND_NAV_MODULE, fVar2.f44060c, "ct on handle pre login or verify unknown error.", this.f44034h);
            }
        }
    }

    public f(Context context) {
        super(context);
        this.s = false;
        this.f44060c = 3;
    }

    @Override // d.a.j0.e.i
    public void h(Context context, int i2) {
        super.h(context, i2);
        if (!d.a.j0.b.a.h(this.f44058a).d()) {
            e(i2, 3, 997, this.f44060c, "pre login error. sdk stop run.", 1);
        } else if (!r()) {
            e(i2, 3, 2006, this.f44060c, "pre login error. ct has not valid config.", 1);
        } else if (d.a.j0.b.a.h(this.f44058a).a()) {
            if (!this.s) {
                System.currentTimeMillis();
                CtAuth.init(0, 0, 8000, null);
                this.s = true;
            }
            CtAuth.requestPreAuthCode(context, i.m, i.n, new a(System.currentTimeMillis(), i2));
        } else {
            e(i2, 3, 996, this.f44060c, "pre login error. ct sdk stop run.", 1);
        }
    }

    @Override // d.a.j0.e.i
    public void o(Context context, int i2) {
        super.o(context, i2);
        if (!d.a.j0.b.a.h(this.f44058a).d()) {
            e(i2, 3, 997, this.f44060c, "pre verify error. sdk stop run.", 3);
        } else if (!r()) {
            e(i2, 3, 2006, this.f44060c, "pre verify error. ct has not valid config.", 3);
        } else if (d.a.j0.b.a.h(this.f44058a).a()) {
            if (!this.s) {
                CtAuth.init(0, 0, 8000, null);
                this.s = true;
            }
            CtAuth.requestPreAuthCode(context, i.m, i.n, new b(i2));
        } else {
            e(i2, 3, 996, this.f44060c, "pre verify error. ct sdk stop run.", 3);
        }
    }

    @Override // d.a.j0.e.j, d.a.j0.e.i
    public void p(Context context, int i2, long j) {
        super.p(context, i2, j);
    }

    public final void w(String str, int i2, int i3) {
        d.a.j0.k.e.c().b(new c(str, i2, i3));
    }

    public final void x(JSONObject jSONObject, int i2, int i3) {
        d.a.j0.k.e.c().b(new e(jSONObject, i2, i3));
    }

    public final void z(JSONObject jSONObject, int i2, int i3) {
        d.a.j0.k.e.c().b(new d(i2, i3, jSONObject));
    }
}
