package d.b.i0.t;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: d  reason: collision with root package name */
    public static f f52217d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f52218a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f52219b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f52220c = new HashMap<>();

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (f52217d == null) {
                f52217d = new f();
            }
            fVar = f52217d;
        }
        return fVar;
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("upload_file_frequency");
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("2g");
                String optString2 = optJSONObject.optString("3g");
                String optString3 = optJSONObject.optString("4g");
                String optString4 = optJSONObject.optString("wifi");
                if (optString != null) {
                    this.f52218a.put("2g", optString);
                }
                if (optString2 != null) {
                    this.f52218a.put("3g", optString2);
                }
                if (optString3 != null) {
                    this.f52218a.put("4g", optString3);
                }
                if (optString4 != null) {
                    this.f52218a.put("wifi", optString4);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
            if (optJSONObject2 != null) {
                String optString5 = optJSONObject2.optString("2g");
                String optString6 = optJSONObject2.optString("3g");
                String optString7 = optJSONObject2.optString("4g");
                String optString8 = optJSONObject2.optString("wifi");
                if (optString5 != null) {
                    this.f52219b.put("2g", optString5);
                }
                if (optString6 != null) {
                    this.f52219b.put("3g", optString6);
                }
                if (optString7 != null) {
                    this.f52219b.put("4g", optString7);
                }
                if (optString8 != null) {
                    this.f52219b.put("wifi", optString8);
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
            if (optJSONObject3 != null) {
                String optString9 = optJSONObject3.optString("2g");
                String optString10 = optJSONObject3.optString("3g");
                String optString11 = optJSONObject3.optString("4g");
                String optString12 = optJSONObject3.optString("wifi");
                if (optString9 != null) {
                    this.f52220c.put("2g", optString9);
                }
                if (optString10 != null) {
                    this.f52220c.put("3g", optString10);
                }
                if (optString11 != null) {
                    this.f52220c.put("4g", optString11);
                }
                if (optString12 != null) {
                    this.f52220c.put("wifi", optString12);
                }
            }
            jSONObject.optString("is_on");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
