package d.a.i0.r;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f48222a;

    /* renamed from: b  reason: collision with root package name */
    public String f48223b;

    /* renamed from: c  reason: collision with root package name */
    public int f48224c;

    /* renamed from: d  reason: collision with root package name */
    public String f48225d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f48226e;

    /* renamed from: f  reason: collision with root package name */
    public long f48227f;

    /* renamed from: g  reason: collision with root package name */
    public int f48228g;

    /* renamed from: h  reason: collision with root package name */
    public String f48229h;

    /* renamed from: i  reason: collision with root package name */
    public String f48230i;
    public boolean j;
    public String k;

    public i(String str, String str2, int i2) {
        this.f48225d = "";
        this.j = false;
        this.k = "";
        this.f48222a = str;
        this.f48223b = str;
        this.f48224c = -1;
        this.f48225d = str2;
        this.f48228g = i2;
        if ((i2 & 2) == 0) {
            this.f48227f = System.currentTimeMillis();
        }
        try {
            this.f48226e = new JSONObject(this.f48225d);
        } catch (JSONException unused) {
        }
    }

    public String a() {
        JSONObject jSONObject = this.f48226e;
        return jSONObject != null ? jSONObject.optString("bizId") : "";
    }

    public void b() {
        String str = this.f48222a;
        if (str != null && str.equals(this.f48223b) && d.g().a(this.f48222a)) {
            this.f48229h = e.h().h();
        }
    }

    public i(String str, JSONObject jSONObject, int i2) {
        this.f48225d = "";
        this.j = false;
        this.k = "";
        this.f48222a = str;
        this.f48223b = str;
        this.f48224c = -1;
        this.f48226e = jSONObject;
        this.f48228g = i2;
        if ((i2 & 2) == 0) {
            this.f48227f = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i2, String str3, int i3) {
        this.f48225d = "";
        this.j = false;
        this.k = "";
        this.f48222a = str2;
        this.f48223b = str;
        this.f48224c = i2;
        this.f48225d = str3;
        this.f48228g = i3;
        if ((i3 & 2) == 0) {
            this.f48227f = System.currentTimeMillis();
        }
        try {
            this.f48226e = new JSONObject(this.f48225d);
        } catch (JSONException unused) {
        }
    }

    public i(String str, String str2, int i2, String str3, long j, int i3) {
        this.f48225d = "";
        this.j = false;
        this.k = "";
        this.f48222a = str2;
        this.f48223b = str;
        this.f48224c = i2;
        this.f48225d = str3;
        this.f48228g = i3;
        if ((i3 & 2) == 0) {
            if (j > 0) {
                this.f48227f = j;
            } else {
                this.f48227f = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(this.f48225d)) {
            return;
        }
        try {
            this.f48226e = new JSONObject(this.f48225d);
        } catch (JSONException unused) {
        }
    }
}
