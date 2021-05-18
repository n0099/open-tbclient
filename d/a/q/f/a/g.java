package d.a.q.f.a;

import android.content.Context;
import com.baidu.common.param.CommonUrlParamManager;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public i f64285a = new f();

    /* renamed from: b  reason: collision with root package name */
    public l f64286b = new p();

    /* renamed from: c  reason: collision with root package name */
    public h f64287c = new e();

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f64288d;

    /* renamed from: e  reason: collision with root package name */
    public Context f64289e;

    public g(Context context) {
        if (this.f64288d == null) {
            c(context);
        }
    }

    @Override // d.a.q.f.a.c
    public JSONObject a() {
        if (this.f64288d == null) {
            c(this.f64289e);
        }
        return this.f64288d;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("aid", this.f64285a.a(this.f64289e));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject.put("uid", this.f64287c.a(this.f64289e));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("adrid", this.f64286b.c(this.f64289e));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put("network", this.f64286b.d(this.f64289e));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("pkg", this.f64286b.b(this.f64289e));
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put("ctime", this.f64286b.b());
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("ua", this.f64286b.a(this.f64289e));
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put("ut", this.f64286b.a());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            jSONObject.put(CommonUrlParamManager.PARAM_IID, this.f64285a.e(this.f64289e));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put("sids", this.f64285a.b(this.f64289e));
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        try {
            jSONObject.put("oid", this.f64285a.c(this.f64289e));
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        try {
            jSONObject.put("gaid", this.f64285a.d(this.f64289e));
        } catch (Exception e14) {
            e14.printStackTrace();
        }
        return jSONObject;
    }

    public final void c(Context context) {
        if (context == null) {
            throw new NullPointerException("ctx should not be null");
        }
        if (this.f64289e == null) {
            this.f64289e = context.getApplicationContext();
        }
        this.f64288d = b();
    }
}
