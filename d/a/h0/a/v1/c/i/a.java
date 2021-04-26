package d.a.h0.a.v1.c.i;

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
        public final String f44955a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f44956b;

        /* renamed from: c  reason: collision with root package name */
        public final JSONObject f44957c;

        public String toString() {
            return String.format("Result(%b):%s", Boolean.valueOf(this.f44956b), this.f44955a);
        }

        public b(boolean z, String str, JSONObject jSONObject) {
            this.f44955a = str == null ? "" : str;
            this.f44956b = z;
            this.f44957c = jSONObject;
        }
    }

    public a(Activity activity, boolean z, String str, String str2) {
        this.m = activity;
        this.l = str;
        this.n = z;
    }

    @Override // d.a.h0.a.v1.c.i.h
    public void E() {
        super.E();
        d.a.h0.a.g1.o.c.a.f();
    }

    public b I(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        JSONObject c2 = d.a.h0.a.v1.c.c.c(jSONObject);
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

    @Override // d.a.h0.a.v1.c.i.h
    public HttpRequest x(h hVar) {
        return d.a.h0.a.w0.a.l().n(this.m, hVar.A());
    }
}
