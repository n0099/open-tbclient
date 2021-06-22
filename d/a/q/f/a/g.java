package d.a.q.f.a;

import android.content.Context;
import com.baidu.common.param.CommonUrlParamManager;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public i f67835a = new f();

    /* renamed from: b  reason: collision with root package name */
    public l f67836b = new p();

    /* renamed from: c  reason: collision with root package name */
    public h f67837c = new e();

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f67838d;

    /* renamed from: e  reason: collision with root package name */
    public Context f67839e;

    public g(Context context) {
        if (this.f67838d == null) {
            c(context);
        }
    }

    @Override // d.a.q.f.a.c
    public JSONObject a() {
        if (this.f67838d == null) {
            c(this.f67839e);
        }
        return this.f67838d;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("aid", this.f67835a.a(this.f67839e));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject.put("uid", this.f67837c.a(this.f67839e));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("adrid", this.f67836b.c(this.f67839e));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put("network", this.f67836b.d(this.f67839e));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("pkg", this.f67836b.b(this.f67839e));
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put("ctime", this.f67836b.b());
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("ua", this.f67836b.a(this.f67839e));
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put("ut", this.f67836b.a());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            jSONObject.put(CommonUrlParamManager.PARAM_IID, this.f67835a.e(this.f67839e));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put("sids", this.f67835a.b(this.f67839e));
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        try {
            jSONObject.put("oid", this.f67835a.c(this.f67839e));
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        try {
            jSONObject.put("gaid", this.f67835a.d(this.f67839e));
        } catch (Exception e14) {
            e14.printStackTrace();
        }
        return jSONObject;
    }

    public final void c(Context context) {
        if (context == null) {
            throw new NullPointerException("ctx should not be null");
        }
        if (this.f67839e == null) {
            this.f67839e = context.getApplicationContext();
        }
        this.f67838d = b();
    }
}
