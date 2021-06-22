package d.a.m0.a.e2.c.j;

import android.annotation.SuppressLint;
import android.app.Activity;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.swan.apps.statistic.interfacestability.SwanInterfaceType;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends h<b> {
    public final String m;
    public final Activity n;
    public final boolean o;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f45523a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f45524b;

        /* renamed from: c  reason: collision with root package name */
        public final JSONObject f45525c;

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.f45524b), this.f45523a);
        }

        public b(boolean z, String str, JSONObject jSONObject) {
            this.f45523a = str == null ? "" : str;
            this.f45524b = z;
            this.f45525c = jSONObject;
        }
    }

    public a(Activity activity, boolean z, String str, String str2) {
        this.n = activity;
        this.m = str;
        this.o = z;
    }

    @Override // d.a.m0.a.e2.c.j.h
    public SwanInterfaceType A() {
        return SwanInterfaceType.ACCREDIT_DATA;
    }

    @Override // d.a.m0.a.e2.c.j.h
    public void J() {
        super.J();
        d.a.m0.a.n1.q.c.a.f();
    }

    @SuppressLint({"BDThrowableCheck"})
    public b Q(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        JSONObject c2 = d.a.m0.a.e2.c.d.c(jSONObject);
        int optInt = c2.optInt("errno", 10001);
        if (optInt != 0) {
            if (11001 == optInt) {
                d.a.m0.a.e2.c.d.l(c2);
                d.a.m0.a.e2.c.d.s("Accredit", c2.toString());
            }
            if (d.a.m0.a.e2.c.c.f45458f) {
                throw new JSONException("Illegal errno=" + optInt + " errms=" + c2.optString("errms"));
            }
        }
        JSONObject jSONObject3 = c2.getJSONObject("data");
        String str = "";
        if (jSONObject3 != null) {
            str = jSONObject3.optString("code", "");
            jSONObject2 = jSONObject3.optJSONObject("opendata");
        } else {
            jSONObject2 = null;
        }
        return new b(this.o, str, jSONObject2);
    }

    @Override // d.a.m0.a.e2.c.j.h
    public HttpRequest x(h hVar) {
        return d.a.m0.a.c1.a.n().o(this.n, hVar.C());
    }
}
