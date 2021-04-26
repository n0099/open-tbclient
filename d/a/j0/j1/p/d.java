package d.a.j0.j1.p;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f55863a;

    /* renamed from: b  reason: collision with root package name */
    public String f55864b;

    /* renamed from: c  reason: collision with root package name */
    public String f55865c;

    /* renamed from: d  reason: collision with root package name */
    public int f55866d;

    /* renamed from: e  reason: collision with root package name */
    public String f55867e;

    /* renamed from: f  reason: collision with root package name */
    public String f55868f;

    /* renamed from: g  reason: collision with root package name */
    public String f55869g;

    public boolean a() {
        if (TextUtils.isEmpty(this.f55865c)) {
            return false;
        }
        return this.f55866d == 2 ? (TextUtils.isEmpty(this.f55867e) || TextUtils.isEmpty(this.f55868f) || TextUtils.isEmpty(this.f55869g)) ? false : true : (TextUtils.isEmpty(this.f55863a) || TextUtils.isEmpty(this.f55864b)) ? false : true;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        this.f55863a = jSONObject.optString("pic");
        this.f55864b = jSONObject.optString("picNight");
        this.f55865c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f55866d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f55867e = optJSONObject.optString("title");
        this.f55868f = optJSONObject.optString("content");
        this.f55869g = optJSONObject.optString("imageUrl");
    }
}
