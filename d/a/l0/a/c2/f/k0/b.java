package d.a.l0.a.c2.f.k0;

import android.util.Log;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static boolean q = k.f43199a;
    public static String r = "LocationResult";

    /* renamed from: a  reason: collision with root package name */
    public final String f41127a;

    /* renamed from: b  reason: collision with root package name */
    public final double f41128b;

    /* renamed from: c  reason: collision with root package name */
    public final double f41129c;

    /* renamed from: d  reason: collision with root package name */
    public final float f41130d;

    /* renamed from: e  reason: collision with root package name */
    public final double f41131e;

    /* renamed from: f  reason: collision with root package name */
    public final double f41132f;

    /* renamed from: g  reason: collision with root package name */
    public final double f41133g = 0.0d;

    /* renamed from: h  reason: collision with root package name */
    public final double f41134h;

    /* renamed from: i  reason: collision with root package name */
    public final String f41135i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;

    public b(String str, double d2, double d3, float f2, double d4, double d5, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f41127a = str;
        this.f41128b = d2;
        this.f41129c = d3;
        this.f41130d = f2;
        this.f41131e = d4;
        this.f41132f = d5;
        this.f41134h = d4;
        this.f41135i = str2;
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
            jSONObject.put("longitude", this.f41128b);
            jSONObject.put("latitude", this.f41129c);
            jSONObject.put("speed", this.f41130d);
            jSONObject.put("accuracy", this.f41131e);
            jSONObject.put("altitude", this.f41132f);
            jSONObject.put("verticalAccuracy", this.f41133g);
            jSONObject.put("horizontalAccuracy", this.f41134h);
            jSONObject.put("country", this.f41135i);
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
