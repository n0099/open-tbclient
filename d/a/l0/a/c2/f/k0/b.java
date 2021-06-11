package d.a.l0.a.c2.f.k0;

import android.util.Log;
import d.a.l0.a.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public static boolean q = k.f46875a;
    public static String r = "LocationResult";

    /* renamed from: a  reason: collision with root package name */
    public final String f44803a;

    /* renamed from: b  reason: collision with root package name */
    public final double f44804b;

    /* renamed from: c  reason: collision with root package name */
    public final double f44805c;

    /* renamed from: d  reason: collision with root package name */
    public final float f44806d;

    /* renamed from: e  reason: collision with root package name */
    public final double f44807e;

    /* renamed from: f  reason: collision with root package name */
    public final double f44808f;

    /* renamed from: g  reason: collision with root package name */
    public final double f44809g = 0.0d;

    /* renamed from: h  reason: collision with root package name */
    public final double f44810h;

    /* renamed from: i  reason: collision with root package name */
    public final String f44811i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;

    public b(String str, double d2, double d3, float f2, double d4, double d5, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.f44803a = str;
        this.f44804b = d2;
        this.f44805c = d3;
        this.f44806d = f2;
        this.f44807e = d4;
        this.f44808f = d5;
        this.f44810h = d4;
        this.f44811i = str2;
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
            jSONObject.put("longitude", this.f44804b);
            jSONObject.put("latitude", this.f44805c);
            jSONObject.put("speed", this.f44806d);
            jSONObject.put("accuracy", this.f44807e);
            jSONObject.put("altitude", this.f44808f);
            jSONObject.put("verticalAccuracy", this.f44809g);
            jSONObject.put("horizontalAccuracy", this.f44810h);
            jSONObject.put("country", this.f44811i);
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
