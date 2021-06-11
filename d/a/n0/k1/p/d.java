package d.a.n0.k1.p;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f60439a;

    /* renamed from: b  reason: collision with root package name */
    public String f60440b;

    /* renamed from: c  reason: collision with root package name */
    public String f60441c;

    /* renamed from: d  reason: collision with root package name */
    public int f60442d;

    /* renamed from: e  reason: collision with root package name */
    public String f60443e;

    /* renamed from: f  reason: collision with root package name */
    public String f60444f;

    /* renamed from: g  reason: collision with root package name */
    public String f60445g;

    public boolean a() {
        if (TextUtils.isEmpty(this.f60441c)) {
            return false;
        }
        return this.f60442d == 2 ? (TextUtils.isEmpty(this.f60443e) || TextUtils.isEmpty(this.f60444f) || TextUtils.isEmpty(this.f60445g)) ? false : true : (TextUtils.isEmpty(this.f60439a) || TextUtils.isEmpty(this.f60440b)) ? false : true;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        this.f60439a = jSONObject.optString("pic");
        this.f60440b = jSONObject.optString("picNight");
        this.f60441c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f60442d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f60443e = optJSONObject.optString("title");
        this.f60444f = optJSONObject.optString("content");
        this.f60445g = optJSONObject.optString("imageUrl");
    }
}
