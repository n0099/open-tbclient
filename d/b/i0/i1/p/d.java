package d.b.i0.i1.p;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f56022a;

    /* renamed from: b  reason: collision with root package name */
    public String f56023b;

    /* renamed from: c  reason: collision with root package name */
    public String f56024c;

    /* renamed from: d  reason: collision with root package name */
    public int f56025d;

    /* renamed from: e  reason: collision with root package name */
    public String f56026e;

    /* renamed from: f  reason: collision with root package name */
    public String f56027f;

    /* renamed from: g  reason: collision with root package name */
    public String f56028g;

    public boolean a() {
        if (TextUtils.isEmpty(this.f56024c)) {
            return false;
        }
        return this.f56025d == 2 ? (TextUtils.isEmpty(this.f56026e) || TextUtils.isEmpty(this.f56027f) || TextUtils.isEmpty(this.f56028g)) ? false : true : (TextUtils.isEmpty(this.f56022a) || TextUtils.isEmpty(this.f56023b)) ? false : true;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        this.f56022a = jSONObject.optString("pic");
        this.f56023b = jSONObject.optString("picNight");
        this.f56024c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f56025d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f56026e = optJSONObject.optString("title");
        this.f56027f = optJSONObject.optString("content");
        this.f56028g = optJSONObject.optString("imageUrl");
    }
}
