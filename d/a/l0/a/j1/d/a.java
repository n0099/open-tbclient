package d.a.l0.a.j1.d;

import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f46760a;

    /* renamed from: b  reason: collision with root package name */
    public String f46761b;

    /* renamed from: c  reason: collision with root package name */
    public String f46762c;

    /* renamed from: d  reason: collision with root package name */
    public String f46763d;

    /* renamed from: e  reason: collision with root package name */
    public String f46764e;

    /* renamed from: f  reason: collision with root package name */
    public String f46765f;

    public static a a(JSONObject jSONObject, String str) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        String optString = jSONObject.optString("error");
        if (optJSONObject2 == null || !TextUtils.equals(optString, "0")) {
            return null;
        }
        a aVar = new a();
        aVar.f46760a = optJSONObject2.optString(ContentUtil.RESULT_KEY_AK);
        aVar.f46761b = optJSONObject2.optString(ContentUtil.RESULT_KEY_SK);
        aVar.f46762c = optJSONObject2.optString("token");
        aVar.f46763d = optJSONObject2.optString(ContentUtil.RESULT_KEY_BUCKET);
        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("oname_list");
        if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject(str)) != null) {
            aVar.f46765f = optJSONObject.optString("bosobject");
            aVar.f46764e = optJSONObject.optString("bosurl");
        }
        return aVar;
    }
}
