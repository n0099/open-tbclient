package d.a.n0.k1.p;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f56750a;

    /* renamed from: b  reason: collision with root package name */
    public String f56751b;

    /* renamed from: c  reason: collision with root package name */
    public String f56752c;

    /* renamed from: d  reason: collision with root package name */
    public int f56753d;

    /* renamed from: e  reason: collision with root package name */
    public String f56754e;

    /* renamed from: f  reason: collision with root package name */
    public String f56755f;

    /* renamed from: g  reason: collision with root package name */
    public String f56756g;

    public boolean a() {
        if (TextUtils.isEmpty(this.f56752c)) {
            return false;
        }
        return this.f56753d == 2 ? (TextUtils.isEmpty(this.f56754e) || TextUtils.isEmpty(this.f56755f) || TextUtils.isEmpty(this.f56756g)) ? false : true : (TextUtils.isEmpty(this.f56750a) || TextUtils.isEmpty(this.f56751b)) ? false : true;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        this.f56750a = jSONObject.optString("pic");
        this.f56751b = jSONObject.optString("picNight");
        this.f56752c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f56753d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f56754e = optJSONObject.optString("title");
        this.f56755f = optJSONObject.optString("content");
        this.f56756g = optJSONObject.optString("imageUrl");
    }
}
