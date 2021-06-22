package d.a.m0.r;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f52180a;

    /* renamed from: b  reason: collision with root package name */
    public String f52181b;

    /* renamed from: c  reason: collision with root package name */
    public int f52182c;

    /* renamed from: d  reason: collision with root package name */
    public String f52183d;

    /* renamed from: e  reason: collision with root package name */
    public JSONObject f52184e;

    /* renamed from: f  reason: collision with root package name */
    public long f52185f;

    /* renamed from: g  reason: collision with root package name */
    public int f52186g;

    /* renamed from: h  reason: collision with root package name */
    public String f52187h;

    /* renamed from: i  reason: collision with root package name */
    public String f52188i;
    public boolean j;
    public String k;

    public i(String str, String str2, int i2) {
        this.f52183d = "";
        this.j = false;
        this.k = "";
        this.f52180a = str;
        this.f52181b = str;
        this.f52182c = -1;
        this.f52183d = str2;
        this.f52186g = i2;
        if ((i2 & 2) == 0) {
            this.f52185f = System.currentTimeMillis();
        }
        try {
            this.f52184e = new JSONObject(this.f52183d);
        } catch (JSONException unused) {
        }
    }

    public String a() {
        JSONObject jSONObject = this.f52184e;
        return jSONObject != null ? jSONObject.optString("bizId") : "";
    }

    public void b() {
        String str = this.f52180a;
        if (str != null && str.equals(this.f52181b) && d.g().a(this.f52180a)) {
            this.f52187h = e.h().h();
        }
    }

    public i(String str, JSONObject jSONObject, int i2) {
        this.f52183d = "";
        this.j = false;
        this.k = "";
        this.f52180a = str;
        this.f52181b = str;
        this.f52182c = -1;
        this.f52184e = jSONObject;
        this.f52186g = i2;
        if ((i2 & 2) == 0) {
            this.f52185f = System.currentTimeMillis();
        }
    }

    public i(String str, String str2, int i2, String str3, int i3) {
        this.f52183d = "";
        this.j = false;
        this.k = "";
        this.f52180a = str2;
        this.f52181b = str;
        this.f52182c = i2;
        this.f52183d = str3;
        this.f52186g = i3;
        if ((i3 & 2) == 0) {
            this.f52185f = System.currentTimeMillis();
        }
        try {
            this.f52184e = new JSONObject(this.f52183d);
        } catch (JSONException unused) {
        }
    }

    public i(String str, String str2, int i2, String str3, long j, int i3) {
        this.f52183d = "";
        this.j = false;
        this.k = "";
        this.f52180a = str2;
        this.f52181b = str;
        this.f52182c = i2;
        this.f52183d = str3;
        this.f52186g = i3;
        if ((i3 & 2) == 0) {
            if (j > 0) {
                this.f52185f = j;
            } else {
                this.f52185f = System.currentTimeMillis();
            }
        }
        if (TextUtils.isEmpty(this.f52183d)) {
            return;
        }
        try {
            this.f52184e = new JSONObject(this.f52183d);
        } catch (JSONException unused) {
        }
    }
}
