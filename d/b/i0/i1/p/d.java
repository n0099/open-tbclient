package d.b.i0.i1.p;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f56023a;

    /* renamed from: b  reason: collision with root package name */
    public String f56024b;

    /* renamed from: c  reason: collision with root package name */
    public String f56025c;

    /* renamed from: d  reason: collision with root package name */
    public int f56026d;

    /* renamed from: e  reason: collision with root package name */
    public String f56027e;

    /* renamed from: f  reason: collision with root package name */
    public String f56028f;

    /* renamed from: g  reason: collision with root package name */
    public String f56029g;

    public boolean a() {
        if (TextUtils.isEmpty(this.f56025c)) {
            return false;
        }
        return this.f56026d == 2 ? (TextUtils.isEmpty(this.f56027e) || TextUtils.isEmpty(this.f56028f) || TextUtils.isEmpty(this.f56029g)) ? false : true : (TextUtils.isEmpty(this.f56023a) || TextUtils.isEmpty(this.f56024b)) ? false : true;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        this.f56023a = jSONObject.optString("pic");
        this.f56024b = jSONObject.optString("picNight");
        this.f56025c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f56026d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f56027e = optJSONObject.optString("title");
        this.f56028f = optJSONObject.optString("content");
        this.f56029g = optJSONObject.optString("imageUrl");
    }
}
