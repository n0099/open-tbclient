package d.a.l0.r;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f48398a;

    /* renamed from: b  reason: collision with root package name */
    public String f48399b;

    /* renamed from: c  reason: collision with root package name */
    public int f48400c;

    /* renamed from: d  reason: collision with root package name */
    public String f48401d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f48402e;

    /* renamed from: f  reason: collision with root package name */
    public long f48403f;

    /* renamed from: g  reason: collision with root package name */
    public int f48404g;

    /* renamed from: h  reason: collision with root package name */
    public String f48405h;

    /* renamed from: i  reason: collision with root package name */
    public String f48406i;
    public boolean j;
    public String k;

    public i(String str, String str2, int i2) {
        this.f48401d = "";
        this.j = false;
        this.k = "";
        this.f48398a = str;
        this.f48399b = str;
        this.f48400c = -1;
        this.f48401d = str2;
        this.f48404g = i2;
        if ((i2 & 2) == 0) {
            this.f48403f = System.currentTimeMillis();
        }
        try {
            this.f48402e = new JSONObject(this.f48401d);
        } catch (JSONException unused) {
        }
    }

    public String a() {
        JSONObject jSONObject = this.f48402e;
        return jSONObject != null ? jSONObject.optString("bizId") : "";
    }

    public void b() {
        String str = this.f48398a;
        if (str != null && str.equals(this.f48399b) && d.g().a(this.f48398a)) {
            this.f48405h = e.h().h();
        }
    }

    public i(String str, JSONObject jSONObject, int i2) {
        this.f48401d = "";
        this.j = false;
        this.k = "";
        this.f48398a = str;
        this.f48399b = str;
        this.f48400c = -1;
        this.f48402e = jSONObject;
        this.f48404g = i2;
        if ((i2 & 2) == 0) {
            this.f48403f = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i2, String str3, int i3) {
        this.f48401d = "";
        this.j = false;
        this.k = "";
        this.f48398a = str2;
        this.f48399b = str;
        this.f48400c = i2;
        this.f48401d = str3;
        this.f48404g = i3;
        if ((i3 & 2) == 0) {
            this.f48403f = System.currentTimeMillis();
        }
        try {
            this.f48402e = new JSONObject(this.f48401d);
        } catch (JSONException unused) {
        }
    }

    public i(String str, String str2, int i2, String str3, long j, int i3) {
        this.f48401d = "";
        this.j = false;
        this.k = "";
        this.f48398a = str2;
        this.f48399b = str;
        this.f48400c = i2;
        this.f48401d = str3;
        this.f48404g = i3;
        if ((i3 & 2) == 0) {
            if (j > 0) {
                this.f48403f = j;
            } else {
                this.f48403f = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(this.f48401d)) {
            return;
        }
        try {
            this.f48402e = new JSONObject(this.f48401d);
        } catch (JSONException unused) {
        }
    }
}
