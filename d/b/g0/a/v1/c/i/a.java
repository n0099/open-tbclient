package d.b.g0.a.v1.c.i;

import android.app.Activity;
import com.baidu.searchbox.http.request.HttpRequest;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends h<b> {
    public final String l;
    public final Activity m;
    public final boolean n;

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f46810a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f46811b;

        /* renamed from: c  reason: collision with root package name */
        public final JSONObject f46812c;

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.f46811b), this.f46810a);
        }

        public b(boolean z, String str, JSONObject jSONObject) {
            this.f46810a = str == null ? "" : str;
            this.f46811b = z;
            this.f46812c = jSONObject;
        }
    }

    public a(Activity activity, boolean z, String str, String str2) {
        this.m = activity;
        this.l = str;
        this.n = z;
    }

    @Override // d.b.g0.a.v1.c.i.h
    public void E() {
        super.E();
        d.b.g0.a.g1.o.c.a.f();
    }

    public b I(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        JSONObject c2 = d.b.g0.a.v1.c.c.c(jSONObject);
        int optInt = c2.optInt("errno", 10001);
        if (optInt == 0) {
            JSONObject jSONObject3 = c2.getJSONObject("data");
            String str = "";
            if (jSONObject3 != null) {
                str = jSONObject3.optString("code", "");
                jSONObject2 = jSONObject3.optJSONObject("opendata");
            } else {
                jSONObject2 = null;
            }
            return new b(this.n, str, jSONObject2);
        }
        throw new JSONException("Illegal errno=" + optInt + " errms=" + c2.optString("errms"));
    }

    @Override // d.b.g0.a.v1.c.i.h
    public HttpRequest x(h hVar) {
        return d.b.g0.a.w0.a.l().B(this.m, hVar.A());
    }
}
