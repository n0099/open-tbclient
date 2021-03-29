package d.b.q.f.a;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public i f64372a = new f();

    /* renamed from: b  reason: collision with root package name */
    public l f64373b = new p();

    /* renamed from: c  reason: collision with root package name */
    public h f64374c = new e();

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f64375d;

    /* renamed from: e  reason: collision with root package name */
    public Context f64376e;

    public g(Context context) {
        if (this.f64375d == null) {
            c(context);
        }
    }

    @Override // d.b.q.f.a.c
    public JSONObject a() {
        if (this.f64375d == null) {
            c(this.f64376e);
        }
        return this.f64375d;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("aid", this.f64372a.a(this.f64376e));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject.put("uid", this.f64374c.a(this.f64376e));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("adrid", this.f64373b.c(this.f64376e));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put("network", this.f64373b.d(this.f64376e));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("pkg", this.f64373b.b(this.f64376e));
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put("ctime", this.f64373b.b());
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("ua", this.f64373b.a(this.f64376e));
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put("ut", this.f64373b.a());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            jSONObject.put("iid", this.f64372a.e(this.f64376e));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put("sids", this.f64372a.b(this.f64376e));
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        try {
            jSONObject.put("oid", this.f64372a.c(this.f64376e));
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        try {
            jSONObject.put("gaid", this.f64372a.d(this.f64376e));
        } catch (Exception e14) {
            e14.printStackTrace();
        }
        return jSONObject;
    }

    public final void c(Context context) {
        if (context == null) {
            throw new NullPointerException("ctx should not be null");
        }
        if (this.f64376e == null) {
            this.f64376e = context.getApplicationContext();
        }
        this.f64375d = b();
    }
}
