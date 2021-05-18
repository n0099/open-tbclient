package d.a.i0.a.c2.f.k0;

import android.util.Log;
import d.a.i0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static boolean q = k.f43025a;
    public static String r = "LocationResult";

    /* renamed from: a  reason: collision with root package name */
    public final String f40953a;

    /* renamed from: b  reason: collision with root package name */
    public final double f40954b;

    /* renamed from: c  reason: collision with root package name */
    public final double f40955c;

    /* renamed from: d  reason: collision with root package name */
    public final float f40956d;

    /* renamed from: e  reason: collision with root package name */
    public final double f40957e;

    /* renamed from: f  reason: collision with root package name */
    public final double f40958f;

    /* renamed from: g  reason: collision with root package name */
    public final double f40959g = 0.0d;

    /* renamed from: h  reason: collision with root package name */
    public final double f40960h;

    /* renamed from: i  reason: collision with root package name */
    public final String f40961i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;

    public b(String str, double d2, double d3, float f2, double d4, double d5, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f40953a = str;
        this.f40954b = d2;
        this.f40955c = d3;
        this.f40956d = f2;
        this.f40957e = d4;
        this.f40958f = d5;
        this.f40960h = d4;
        this.f40961i = str2;
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
            jSONObject.put("longitude", this.f40954b);
            jSONObject.put("latitude", this.f40955c);
            jSONObject.put("speed", this.f40956d);
            jSONObject.put("accuracy", this.f40957e);
            jSONObject.put("altitude", this.f40958f);
            jSONObject.put("verticalAccuracy", this.f40959g);
            jSONObject.put("horizontalAccuracy", this.f40960h);
            jSONObject.put("country", this.f40961i);
            jSONObject.put("countryCode", this.j);
            jSONObject.put("city", this.k);
            jSONObject.put("cityCode", this.l);
            jSONObject.put("province", this.m);
            jSONObject.put("district", this.n);
            jSONObject.put("street", this.o);
            jSONObject.put("streetNumber", this.p);
            jSONObject.put("isFullAccuracy", true);
        } catch (JSONException e2) {
            if (q) {
                String str = r;
                Log.e(str, "toJSON error: " + Log.getStackTraceString(e2));
            }
        }
        return jSONObject;
    }
}
