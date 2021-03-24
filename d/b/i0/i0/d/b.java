package d.b.i0.i0.d;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f55473a;

    /* renamed from: b  reason: collision with root package name */
    public int f55474b;

    /* renamed from: c  reason: collision with root package name */
    public String f55475c;

    public boolean a() {
        return !TextUtils.isEmpty(this.f55475c);
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString("pic");
        this.f55473a = jSONObject.optString("url");
        jSONObject.optInt("server_time");
        this.f55474b = jSONObject.optInt("adid");
        this.f55475c = jSONObject.optString("big_pic");
        jSONObject.optString("small_pic");
    }
}
