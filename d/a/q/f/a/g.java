package d.a.q.f.a;

import android.content.Context;
import com.baidu.common.param.CommonUrlParamManager;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public i f67879a = new f();

    /* renamed from: b  reason: collision with root package name */
    public l f67880b = new p();

    /* renamed from: c  reason: collision with root package name */
    public h f67881c = new e();

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f67882d;

    /* renamed from: e  reason: collision with root package name */
    public Context f67883e;

    public g(Context context) {
        if (this.f67882d == null) {
            c(context);
        }
    }

    @Override // d.a.q.f.a.c
    public JSONObject a() {
        if (this.f67882d == null) {
            c(this.f67883e);
        }
        return this.f67882d;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("aid", this.f67879a.a(this.f67883e));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject.put("uid", this.f67881c.a(this.f67883e));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("adrid", this.f67880b.c(this.f67883e));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put("network", this.f67880b.d(this.f67883e));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("pkg", this.f67880b.b(this.f67883e));
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put("ctime", this.f67880b.b());
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("ua", this.f67880b.a(this.f67883e));
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put("ut", this.f67880b.a());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            jSONObject.put(CommonUrlParamManager.PARAM_IID, this.f67879a.e(this.f67883e));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put("sids", this.f67879a.b(this.f67883e));
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        try {
            jSONObject.put("oid", this.f67879a.c(this.f67883e));
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        try {
            jSONObject.put("gaid", this.f67879a.d(this.f67883e));
        } catch (Exception e14) {
            e14.printStackTrace();
        }
        return jSONObject;
    }

    public final void c(Context context) {
        if (context == null) {
            throw new NullPointerException("ctx should not be null");
        }
        if (this.f67883e == null) {
            this.f67883e = context.getApplicationContext();
        }
        this.f67882d = b();
    }
}
