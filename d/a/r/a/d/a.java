package d.a.r.a.d;

import com.baidu.searchbox.logsystem.basic.upload.Constant;
import d.a.r.a.e.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f68183a;

    /* renamed from: b  reason: collision with root package name */
    public String f68184b = String.valueOf(System.currentTimeMillis());

    /* renamed from: c  reason: collision with root package name */
    public boolean f68185c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f68186d;

    public a(boolean z, JSONArray jSONArray) {
        this.f68185c = z;
        this.f68183a = jSONArray;
    }

    public final JSONObject a() {
        JSONArray jSONArray = this.f68183a;
        if (jSONArray == null || jSONArray.length() < 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadata", b());
            jSONObject.put(Constant.IS_REAL, this.f68185c ? "1" : "0");
            jSONObject.put("data", this.f68183a);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c.a("UploadData", "uploadJson:" + jSONObject.toString());
        return jSONObject;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uploadtime", this.f68184b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f68186d = jSONObject;
        return jSONObject;
    }
}
