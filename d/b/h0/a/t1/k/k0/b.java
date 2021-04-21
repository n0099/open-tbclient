package d.b.h0.a.t1.k.k0;

import android.util.Log;
import d.b.h0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static boolean q = k.f45772a;
    public static String r = "LocationResult";

    /* renamed from: a  reason: collision with root package name */
    public final String f47171a;

    /* renamed from: b  reason: collision with root package name */
    public final double f47172b;

    /* renamed from: c  reason: collision with root package name */
    public final double f47173c;

    /* renamed from: d  reason: collision with root package name */
    public final float f47174d;

    /* renamed from: e  reason: collision with root package name */
    public final double f47175e;

    /* renamed from: f  reason: collision with root package name */
    public final double f47176f;

    /* renamed from: g  reason: collision with root package name */
    public final double f47177g = 0.0d;

    /* renamed from: h  reason: collision with root package name */
    public final double f47178h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;

    public b(String str, double d2, double d3, float f2, double d4, double d5, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f47171a = str;
        this.f47172b = d2;
        this.f47173c = d3;
        this.f47174d = f2;
        this.f47175e = d4;
        this.f47176f = d5;
        this.f47178h = d4;
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
            jSONObject.put("longitude", this.f47172b);
            jSONObject.put("latitude", this.f47173c);
            jSONObject.put("speed", this.f47174d);
            jSONObject.put("accuracy", this.f47175e);
            jSONObject.put("altitude", this.f47176f);
            jSONObject.put("verticalAccuracy", this.f47177g);
            jSONObject.put("horizontalAccuracy", this.f47178h);
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
