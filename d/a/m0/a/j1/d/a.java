package d.a.m0.a.j1.d;

import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f46868a;

    /* renamed from: b  reason: collision with root package name */
    public String f46869b;

    /* renamed from: c  reason: collision with root package name */
    public String f46870c;

    /* renamed from: d  reason: collision with root package name */
    public String f46871d;

    /* renamed from: e  reason: collision with root package name */
    public String f46872e;

    /* renamed from: f  reason: collision with root package name */
    public String f46873f;

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
        aVar.f46868a = optJSONObject2.optString(ContentUtil.RESULT_KEY_AK);
        aVar.f46869b = optJSONObject2.optString(ContentUtil.RESULT_KEY_SK);
        aVar.f46870c = optJSONObject2.optString("token");
        aVar.f46871d = optJSONObject2.optString(ContentUtil.RESULT_KEY_BUCKET);
        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("oname_list");
        if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject(str)) != null) {
            aVar.f46873f = optJSONObject.optString("bosobject");
            aVar.f46872e = optJSONObject.optString("bosurl");
        }
        return aVar;
    }
}
