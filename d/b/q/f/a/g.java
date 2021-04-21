package d.b.q.f.a;

import android.content.Context;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public i f65330a = new f();

    /* renamed from: b  reason: collision with root package name */
    public l f65331b = new p();

    /* renamed from: c  reason: collision with root package name */
    public h f65332c = new e();

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f65333d;

    /* renamed from: e  reason: collision with root package name */
    public Context f65334e;

    public g(Context context) {
        if (this.f65333d == null) {
            c(context);
        }
    }

    @Override // d.b.q.f.a.c
    public JSONObject a() {
        if (this.f65333d == null) {
            c(this.f65334e);
        }
        return this.f65333d;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ver", 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            jSONObject.put("aid", this.f65330a.a(this.f65334e));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            jSONObject.put("uid", this.f65332c.a(this.f65334e));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        try {
            jSONObject.put("adrid", this.f65331b.c(this.f65334e));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        try {
            jSONObject.put("network", this.f65331b.d(this.f65334e));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        try {
            jSONObject.put("pkg", this.f65331b.b(this.f65334e));
        } catch (Exception e7) {
            e7.printStackTrace();
        }
        try {
            jSONObject.put("ctime", this.f65331b.b());
        } catch (Exception e8) {
            e8.printStackTrace();
        }
        try {
            jSONObject.put("ua", this.f65331b.a(this.f65334e));
        } catch (Exception e9) {
            e9.printStackTrace();
        }
        try {
            jSONObject.put("ut", this.f65331b.a());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            jSONObject.put("iid", this.f65330a.e(this.f65334e));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        try {
            jSONObject.put("sids", this.f65330a.b(this.f65334e));
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        try {
            jSONObject.put("oid", this.f65330a.c(this.f65334e));
        } catch (Exception e13) {
            e13.printStackTrace();
        }
        try {
            jSONObject.put("gaid", this.f65330a.d(this.f65334e));
        } catch (Exception e14) {
            e14.printStackTrace();
        }
        return jSONObject;
    }

    public final void c(Context context) {
        if (context == null) {
            throw new NullPointerException("ctx should not be null");
        }
        if (this.f65334e == null) {
            this.f65334e = context.getApplicationContext();
        }
        this.f65333d = b();
    }
}
