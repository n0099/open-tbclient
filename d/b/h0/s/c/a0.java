package d.b.h0.s.c;

import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a0 {

    /* renamed from: a  reason: collision with root package name */
    public String f51538a;

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == null) {
            return;
        }
        jSONObject.optInt("offline");
        jSONObject.optString("title");
        String optString = jSONObject.optString("link");
        this.f51538a = optString;
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        this.f51538a = this.f51538a.replaceFirst("webview:", "http://");
    }
}
