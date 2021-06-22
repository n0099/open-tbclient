package d.a.o0.k1.p;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f60564a;

    /* renamed from: b  reason: collision with root package name */
    public String f60565b;

    /* renamed from: c  reason: collision with root package name */
    public String f60566c;

    /* renamed from: d  reason: collision with root package name */
    public int f60567d;

    /* renamed from: e  reason: collision with root package name */
    public String f60568e;

    /* renamed from: f  reason: collision with root package name */
    public String f60569f;

    /* renamed from: g  reason: collision with root package name */
    public String f60570g;

    public boolean a() {
        if (TextUtils.isEmpty(this.f60566c)) {
            return false;
        }
        return this.f60567d == 2 ? (TextUtils.isEmpty(this.f60568e) || TextUtils.isEmpty(this.f60569f) || TextUtils.isEmpty(this.f60570g)) ? false : true : (TextUtils.isEmpty(this.f60564a) || TextUtils.isEmpty(this.f60565b)) ? false : true;
    }

    public void b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return;
        }
        this.f60564a = jSONObject.optString("pic");
        this.f60565b = jSONObject.optString("picNight");
        this.f60566c = jSONObject.optString("scheme");
        int optInt = jSONObject.optInt("type", 1);
        this.f60567d = optInt;
        if (optInt != 2 || (optJSONObject = jSONObject.optJSONObject("extra")) == null) {
            return;
        }
        this.f60568e = optJSONObject.optString("title");
        this.f60569f = optJSONObject.optString("content");
        this.f60570g = optJSONObject.optString("imageUrl");
    }
}
