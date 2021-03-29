package d.b.i0.i0.d;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f55474a;

    /* renamed from: b  reason: collision with root package name */
    public int f55475b;

    /* renamed from: c  reason: collision with root package name */
    public String f55476c;

    public boolean a() {
        return !TextUtils.isEmpty(this.f55476c);
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString("pic");
        this.f55474a = jSONObject.optString("url");
        jSONObject.optInt("server_time");
        this.f55475b = jSONObject.optInt("adid");
        this.f55476c = jSONObject.optString("big_pic");
        jSONObject.optString("small_pic");
    }
}
