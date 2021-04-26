package d.a.q.f.a;

import android.content.Context;
import com.baidu.common.param.CommonUrlParamManager;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public i f63648a = new f();

    /* renamed from: b  reason: collision with root package name */
    public l f63649b = new p();

    /* renamed from: c  reason: collision with root package name */
    public h f63650c = new e();

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f63651d;

    /* renamed from: e  reason: collision with root package name */
    public Context f63652e;

    public g(Context context) {
        if (this.f63651d == null) {
            c(context);
        }
    }

    @Override // d.a.q.f.a.c
    public JSONObject a() {
        if (this.f63651d == null) {
            c(this.f63652e);
        }
        return this.f63651d;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("aid", this.f63648a.a(this.f63652e));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject.put("uid", this.f63650c.a(this.f63652e));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("adrid", this.f63649b.c(this.f63652e));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put("network", this.f63649b.d(this.f63652e));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("pkg", this.f63649b.b(this.f63652e));
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put("ctime", this.f63649b.b());
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("ua", this.f63649b.a(this.f63652e));
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put("ut", this.f63649b.a());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            jSONObject.put(CommonUrlParamManager.PARAM_IID, this.f63648a.e(this.f63652e));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put("sids", this.f63648a.b(this.f63652e));
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        try {
            jSONObject.put("oid", this.f63648a.c(this.f63652e));
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        try {
            jSONObject.put("gaid", this.f63648a.d(this.f63652e));
        } catch (Exception e14) {
            e14.printStackTrace();
        }
        return jSONObject;
    }

    public final void c(Context context) {
        if (context == null) {
            throw new NullPointerException("ctx should not be null");
        }
        if (this.f63652e == null) {
            this.f63652e = context.getApplicationContext();
        }
        this.f63651d = b();
    }
}
