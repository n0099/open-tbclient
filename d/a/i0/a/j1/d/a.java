package d.a.i0.a.j1.d;

import android.text.TextUtils;
import com.baidu.searchbox.aperf.bosuploader.ContentUtil;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f42910a;

    /* renamed from: b  reason: collision with root package name */
    public String f42911b;

    /* renamed from: c  reason: collision with root package name */
    public String f42912c;

    /* renamed from: d  reason: collision with root package name */
    public String f42913d;

    /* renamed from: e  reason: collision with root package name */
    public String f42914e;

    /* renamed from: f  reason: collision with root package name */
    public String f42915f;

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
        aVar.f42910a = optJSONObject2.optString(ContentUtil.RESULT_KEY_AK);
        aVar.f42911b = optJSONObject2.optString(ContentUtil.RESULT_KEY_SK);
        aVar.f42912c = optJSONObject2.optString("token");
        aVar.f42913d = optJSONObject2.optString(ContentUtil.RESULT_KEY_BUCKET);
        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("oname_list");
        if (optJSONObject3 != null && (optJSONObject = optJSONObject3.optJSONObject(str)) != null) {
            aVar.f42915f = optJSONObject.optString("bosobject");
            aVar.f42914e = optJSONObject.optString("bosurl");
        }
        return aVar;
    }
}
