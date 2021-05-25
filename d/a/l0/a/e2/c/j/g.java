package d.a.l0.a.e2.c.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.text.TextUtils;
import com.baidu.fsg.face.liveness.activity.LivenessRecogActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends h<JSONObject> {
    public static final boolean r = k.f43199a;
    public final Activity m;
    public final String n;
    public final String o;
    public boolean p;
    public int q;

    public g(Activity activity, String str, String str2, boolean z) {
        this.m = activity;
        this.n = str;
        this.o = str2;
        this.p = z;
    }

    @Override // d.a.l0.a.e2.c.j.h
    public SwanInterfaceType A() {
        return SwanInterfaceType.OPEN_DATA;
    }

    @Override // d.a.l0.a.e2.c.j.h
    public boolean F() {
        return d.a.l0.a.e2.c.b.b() && !R();
    }

    @Override // d.a.l0.a.e2.c.j.h
    public void L() {
        this.q++;
    }

    public JSONObject Q() {
        JSONObject jSONObject = new JSONObject();
        try {
            d.a.l0.a.a2.e N = N();
            jSONObject.put("ma_id", N.D());
            jSONObject.put("scope", this.n);
            jSONObject.put("host_pkgname", AppRuntime.getApplication().getPackageName());
            jSONObject.put("host_key_hash", d.a.l0.a.e2.c.d.g());
            jSONObject.put("app_key", N.D());
            if (N.N() != null && N.N().T() != null) {
                jSONObject.put("scene", N.N().T());
            }
            if (this.p) {
                jSONObject.put(LivenessRecogActivity.EXTRA_UPLOAD_ACTION_TYPE, "1");
            }
            String l = d.a.l0.a.c1.a.n().l();
            if (!TextUtils.isEmpty(l)) {
                jSONObject.put("host_api_key", l);
            }
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("provider_appkey", this.o);
            }
        } catch (JSONException e2) {
            if (r) {
                e2.printStackTrace();
            }
        }
        return jSONObject;
    }

    public boolean R() {
        return this.q >= B();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.e2.c.c
    @SuppressLint({"BDThrowableCheck"})
    /* renamed from: S */
    public JSONObject n(JSONObject jSONObject) throws JSONException {
        JSONObject c2 = d.a.l0.a.e2.c.d.c(jSONObject);
        int optInt = c2.optInt("errno", 10001);
        if (optInt != 0) {
            if (11001 == optInt) {
                d.a.l0.a.e2.c.d.l(c2);
                d.a.l0.a.e2.c.d.s("MaOpenDataRequest", c2.toString());
            }
            if (r) {
                throw new JSONException("Illegal errno=" + optInt + " errms=" + c2.optString("errms"));
            }
        }
        return c2;
    }

    @Override // d.a.l0.a.e2.c.c
    public boolean k() {
        w("data", Q().toString());
        return true;
    }

    @Override // d.a.l0.a.e2.c.j.h
    public HttpRequest x(h hVar) {
        return d.a.l0.a.c1.a.n().s(this.m, hVar.C());
    }
}
