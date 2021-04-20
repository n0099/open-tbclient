package d.b.g0.a.t1.k.k0;

import android.util.Log;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static boolean q = k.f45443a;
    public static String r = "LocationResult";

    /* renamed from: a  reason: collision with root package name */
    public final String f46842a;

    /* renamed from: b  reason: collision with root package name */
    public final double f46843b;

    /* renamed from: c  reason: collision with root package name */
    public final double f46844c;

    /* renamed from: d  reason: collision with root package name */
    public final float f46845d;

    /* renamed from: e  reason: collision with root package name */
    public final double f46846e;

    /* renamed from: f  reason: collision with root package name */
    public final double f46847f;

    /* renamed from: g  reason: collision with root package name */
    public final double f46848g = 0.0d;

    /* renamed from: h  reason: collision with root package name */
    public final double f46849h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;

    public b(String str, double d2, double d3, float f2, double d4, double d5, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f46842a = str;
        this.f46843b = d2;
        this.f46844c = d3;
        this.f46845d = f2;
        this.f46846e = d4;
        this.f46847f = d5;
        this.f46849h = d4;
        this.i = str2;
        this.j = str3;
        this.k = str4;
        this.l = str5;
        this.m = str6;
        this.n = str7;
        this.o = str8;
        this.p = str9;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("longitude", this.f46843b);
            jSONObject.put("latitude", this.f46844c);
            jSONObject.put("speed", this.f46845d);
            jSONObject.put("accuracy", this.f46846e);
            jSONObject.put("altitude", this.f46847f);
            jSONObject.put("verticalAccuracy", this.f46848g);
            jSONObject.put("horizontalAccuracy", this.f46849h);
            jSONObject.put("country", this.i);
            jSONObject.put("countryCode", this.j);
            jSONObject.put("city", this.k);
            jSONObject.put("cityCode", this.l);
            jSONObject.put("province", this.m);
            jSONObject.put("district", this.n);
            jSONObject.put("street", this.o);
            jSONObject.put("streetNumber", this.p);
        } catch (JSONException e2) {
            if (q) {
                String str = r;
                Log.e(str, "toJSON error: " + Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }
}
