package d.a.l0.a.j1.d;

import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f43084a;

    /* renamed from: b  reason: collision with root package name */
    public String f43085b;

    /* renamed from: c  reason: collision with root package name */
    public String f43086c;

    /* renamed from: d  reason: collision with root package name */
    public String f43087d;

    /* renamed from: e  reason: collision with root package name */
    public String f43088e;

    /* renamed from: f  reason: collision with root package name */
    public String f43089f;

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
        aVar.f43084a = optJSONObject2.optString(ContentUtil.RESULT_KEY_AK);
        aVar.f43085b = optJSONObject2.optString(ContentUtil.RESULT_KEY_SK);
        aVar.f43086c = optJSONObject2.optString("token");
        aVar.f43087d = optJSONObject2.optString(ContentUtil.RESULT_KEY_BUCKET);
        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("oname_list");
        if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject(str)) != null) {
            aVar.f43089f = optJSONObject.optString("bosobject");
            aVar.f43088e = optJSONObject.optString("bosurl");
        }
        return aVar;
    }
}
