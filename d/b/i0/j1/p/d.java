package d.b.i0.j1.p;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f57470a;

    /* renamed from: b  reason: collision with root package name */
    public String f57471b;

    /* renamed from: c  reason: collision with root package name */
    public String f57472c;

    /* renamed from: d  reason: collision with root package name */
    public int f57473d;

    /* renamed from: e  reason: collision with root package name */
    public String f57474e;

    /* renamed from: f  reason: collision with root package name */
    public String f57475f;

    /* renamed from: g  reason: collision with root package name */
    public String f57476g;

    public boolean a() {
        if (TextUtils.isEmpty(this.f57472c)) {
            return false;
        }
        return this.f57473d == 2 ? (TextUtils.isEmpty(this.f57474e) || TextUtils.isEmpty(this.f57475f) || TextUtils.isEmpty(this.f57476g)) ? false : true : (TextUtils.isEmpty(this.f57470a) || TextUtils.isEmpty(this.f57471b)) ? false : true;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        this.f57470a = jSONObject.optString("pic");
        this.f57471b = jSONObject.optString("picNight");
        this.f57472c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f57473d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f57474e = optJSONObject.optString("title");
        this.f57475f = optJSONObject.optString("content");
        this.f57476g = optJSONObject.optString("imageUrl");
    }
}
