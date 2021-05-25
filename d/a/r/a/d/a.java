package d.a.r.a.d;

import com.baidu.searchbox.logsystem.basic.upload.Constant;
import d.a.r.a.e.c;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f64361a;

    /* renamed from: b  reason: collision with root package name */
    public String f64362b = String.valueOf(System.currentTimeMillis());

    /* renamed from: c  reason: collision with root package name */
    public boolean f64363c;

    /* renamed from: d  reason: collision with root package name */
    public JSONObject f64364d;

    public a(boolean z, JSONArray jSONArray) {
        this.f64363c = z;
        this.f64361a = jSONArray;
    }

    public final JSONObject a() {
        JSONArray jSONArray = this.f64361a;
        if (jSONArray == null || jSONArray.length() < 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("metadata", b());
            jSONObject.put(Constant.IS_REAL, this.f64363c ? "1" : "0");
            jSONObject.put("data", this.f64361a);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        c.a("UploadData", "uploadJson:" + jSONObject.toString());
        return jSONObject;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("uploadtime", this.f64362b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f64364d = jSONObject;
        return jSONObject;
    }
}
