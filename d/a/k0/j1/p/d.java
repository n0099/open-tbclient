package d.a.k0.j1.p;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f56570a;

    /* renamed from: b  reason: collision with root package name */
    public String f56571b;

    /* renamed from: c  reason: collision with root package name */
    public String f56572c;

    /* renamed from: d  reason: collision with root package name */
    public int f56573d;

    /* renamed from: e  reason: collision with root package name */
    public String f56574e;

    /* renamed from: f  reason: collision with root package name */
    public String f56575f;

    /* renamed from: g  reason: collision with root package name */
    public String f56576g;

    public boolean a() {
        if (TextUtils.isEmpty(this.f56572c)) {
            return false;
        }
        return this.f56573d == 2 ? (TextUtils.isEmpty(this.f56574e) || TextUtils.isEmpty(this.f56575f) || TextUtils.isEmpty(this.f56576g)) ? false : true : (TextUtils.isEmpty(this.f56570a) || TextUtils.isEmpty(this.f56571b)) ? false : true;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        this.f56570a = jSONObject.optString("pic");
        this.f56571b = jSONObject.optString("picNight");
        this.f56572c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f56573d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f56574e = optJSONObject.optString("title");
        this.f56575f = optJSONObject.optString("content");
        this.f56576g = optJSONObject.optString("imageUrl");
    }
}
