package d.b.q.f.a;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public i f64371a = new f();

    /* renamed from: b  reason: collision with root package name */
    public l f64372b = new p();

    /* renamed from: c  reason: collision with root package name */
    public h f64373c = new e();

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f64374d;

    /* renamed from: e  reason: collision with root package name */
    public Context f64375e;

    public g(Context context) {
        if (this.f64374d == null) {
            c(context);
        }
    }

    @Override // d.b.q.f.a.c
    public JSONObject a() {
        if (this.f64374d == null) {
            c(this.f64375e);
        }
        return this.f64374d;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("aid", this.f64371a.a(this.f64375e));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject.put("uid", this.f64373c.a(this.f64375e));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("adrid", this.f64372b.c(this.f64375e));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put("network", this.f64372b.d(this.f64375e));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("pkg", this.f64372b.b(this.f64375e));
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put("ctime", this.f64372b.b());
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("ua", this.f64372b.a(this.f64375e));
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put("ut", this.f64372b.a());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            jSONObject.put("iid", this.f64371a.e(this.f64375e));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put("sids", this.f64371a.b(this.f64375e));
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        try {
            jSONObject.put("oid", this.f64371a.c(this.f64375e));
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        try {
            jSONObject.put("gaid", this.f64371a.d(this.f64375e));
        } catch (Exception e14) {
            e14.printStackTrace();
        }
        return jSONObject;
    }

    public final void c(Context context) {
        if (context == null) {
            throw new NullPointerException("ctx should not be null");
        }
        if (this.f64375e == null) {
            this.f64375e = context.getApplicationContext();
        }
        this.f64374d = b();
    }
}
