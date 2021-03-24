package d.b.g0.a.t1.k.k0;

import android.util.Log;
import d.b.g0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static boolean q = k.f45050a;
    public static String r = "LocationResult";

    /* renamed from: a  reason: collision with root package name */
    public final String f46449a;

    /* renamed from: b  reason: collision with root package name */
    public final double f46450b;

    /* renamed from: c  reason: collision with root package name */
    public final double f46451c;

    /* renamed from: d  reason: collision with root package name */
    public final float f46452d;

    /* renamed from: e  reason: collision with root package name */
    public final double f46453e;

    /* renamed from: f  reason: collision with root package name */
    public final double f46454f;

    /* renamed from: g  reason: collision with root package name */
    public final double f46455g = 0.0d;

    /* renamed from: h  reason: collision with root package name */
    public final double f46456h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;

    public b(String str, double d2, double d3, float f2, double d4, double d5, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f46449a = str;
        this.f46450b = d2;
        this.f46451c = d3;
        this.f46452d = f2;
        this.f46453e = d4;
        this.f46454f = d5;
        this.f46456h = d4;
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
            jSONObject.put("longitude", this.f46450b);
            jSONObject.put("latitude", this.f46451c);
            jSONObject.put("speed", this.f46452d);
            jSONObject.put("accuracy", this.f46453e);
            jSONObject.put("altitude", this.f46454f);
            jSONObject.put("verticalAccuracy", this.f46455g);
            jSONObject.put("horizontalAccuracy", this.f46456h);
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
