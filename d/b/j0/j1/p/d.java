package d.b.j0.j1.p;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f57891a;

    /* renamed from: b  reason: collision with root package name */
    public String f57892b;

    /* renamed from: c  reason: collision with root package name */
    public String f57893c;

    /* renamed from: d  reason: collision with root package name */
    public int f57894d;

    /* renamed from: e  reason: collision with root package name */
    public String f57895e;

    /* renamed from: f  reason: collision with root package name */
    public String f57896f;

    /* renamed from: g  reason: collision with root package name */
    public String f57897g;

    public boolean a() {
        if (TextUtils.isEmpty(this.f57893c)) {
            return false;
        }
        return this.f57894d == 2 ? (TextUtils.isEmpty(this.f57895e) || TextUtils.isEmpty(this.f57896f) || TextUtils.isEmpty(this.f57897g)) ? false : true : (TextUtils.isEmpty(this.f57891a) || TextUtils.isEmpty(this.f57892b)) ? false : true;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        this.f57891a = jSONObject.optString("pic");
        this.f57892b = jSONObject.optString("picNight");
        this.f57893c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f57894d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f57895e = optJSONObject.optString("title");
        this.f57896f = optJSONObject.optString("content");
        this.f57897g = optJSONObject.optString("imageUrl");
    }
}
