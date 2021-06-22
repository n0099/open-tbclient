package d.a.m0.a.c2.f.k0;

import android.util.Log;
import d.a.m0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static boolean q = k.f46983a;
    public static String r = "LocationResult";

    /* renamed from: a  reason: collision with root package name */
    public final String f44911a;

    /* renamed from: b  reason: collision with root package name */
    public final double f44912b;

    /* renamed from: c  reason: collision with root package name */
    public final double f44913c;

    /* renamed from: d  reason: collision with root package name */
    public final float f44914d;

    /* renamed from: e  reason: collision with root package name */
    public final double f44915e;

    /* renamed from: f  reason: collision with root package name */
    public final double f44916f;

    /* renamed from: g  reason: collision with root package name */
    public final double f44917g = 0.0d;

    /* renamed from: h  reason: collision with root package name */
    public final double f44918h;

    /* renamed from: i  reason: collision with root package name */
    public final String f44919i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;

    public b(String str, double d2, double d3, float f2, double d4, double d5, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f44911a = str;
        this.f44912b = d2;
        this.f44913c = d3;
        this.f44914d = f2;
        this.f44915e = d4;
        this.f44916f = d5;
        this.f44918h = d4;
        this.f44919i = str2;
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
            jSONObject.put("longitude", this.f44912b);
            jSONObject.put("latitude", this.f44913c);
            jSONObject.put("speed", this.f44914d);
            jSONObject.put("accuracy", this.f44915e);
            jSONObject.put("altitude", this.f44916f);
            jSONObject.put("verticalAccuracy", this.f44917g);
            jSONObject.put("horizontalAccuracy", this.f44918h);
            jSONObject.put("country", this.f44919i);
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
