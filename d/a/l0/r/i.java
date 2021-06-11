package d.a.l0.r;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f52072a;

    /* renamed from: b  reason: collision with root package name */
    public String f52073b;

    /* renamed from: c  reason: collision with root package name */
    public int f52074c;

    /* renamed from: d  reason: collision with root package name */
    public String f52075d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f52076e;

    /* renamed from: f  reason: collision with root package name */
    public long f52077f;

    /* renamed from: g  reason: collision with root package name */
    public int f52078g;

    /* renamed from: h  reason: collision with root package name */
    public String f52079h;

    /* renamed from: i  reason: collision with root package name */
    public String f52080i;
    public boolean j;
    public String k;

    public i(String str, String str2, int i2) {
        this.f52075d = "";
        this.j = false;
        this.k = "";
        this.f52072a = str;
        this.f52073b = str;
        this.f52074c = -1;
        this.f52075d = str2;
        this.f52078g = i2;
        if ((i2 & 2) == 0) {
            this.f52077f = System.currentTimeMillis();
        }
        try {
            this.f52076e = new JSONObject(this.f52075d);
        } catch (JSONException unused) {
        }
    }

    public String a() {
        JSONObject jSONObject = this.f52076e;
        return jSONObject != null ? jSONObject.optString("bizId") : "";
    }

    public void b() {
        String str = this.f52072a;
        if (str != null && str.equals(this.f52073b) && d.g().a(this.f52072a)) {
            this.f52079h = e.h().h();
        }
    }

    public i(String str, JSONObject jSONObject, int i2) {
        this.f52075d = "";
        this.j = false;
        this.k = "";
        this.f52072a = str;
        this.f52073b = str;
        this.f52074c = -1;
        this.f52076e = jSONObject;
        this.f52078g = i2;
        if ((i2 & 2) == 0) {
            this.f52077f = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i2, String str3, int i3) {
        this.f52075d = "";
        this.j = false;
        this.k = "";
        this.f52072a = str2;
        this.f52073b = str;
        this.f52074c = i2;
        this.f52075d = str3;
        this.f52078g = i3;
        if ((i3 & 2) == 0) {
            this.f52077f = System.currentTimeMillis();
        }
        try {
            this.f52076e = new JSONObject(this.f52075d);
        } catch (JSONException unused) {
        }
    }

    public i(String str, String str2, int i2, String str3, long j, int i3) {
        this.f52075d = "";
        this.j = false;
        this.k = "";
        this.f52072a = str2;
        this.f52073b = str;
        this.f52074c = i2;
        this.f52075d = str3;
        this.f52078g = i3;
        if ((i3 & 2) == 0) {
            if (j > 0) {
                this.f52077f = j;
            } else {
                this.f52077f = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(this.f52075d)) {
            return;
        }
        try {
            this.f52076e = new JSONObject(this.f52075d);
        } catch (JSONException unused) {
        }
    }
}
