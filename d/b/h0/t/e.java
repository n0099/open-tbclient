package d.b.h0.t;

import com.baidu.adp.lib.util.BdLog;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: d  reason: collision with root package name */
    public static e f51459d;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, String> f51460a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, String> f51461b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, String> f51462c = new HashMap<>();

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (f51459d == null) {
                f51459d = new e();
            }
            eVar = f51459d;
        }
        return eVar;
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
                    this.f51460a.put("2g", optString);
                }
                if (optString2 != null) {
                    this.f51460a.put("3g", optString2);
                }
                if (optString3 != null) {
                    this.f51460a.put("4g", optString3);
                }
                if (optString4 != null) {
                    this.f51460a.put("wifi", optString4);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("upload_data_num");
            if (optJSONObject2 != null) {
                String optString5 = optJSONObject2.optString("2g");
                String optString6 = optJSONObject2.optString("3g");
                String optString7 = optJSONObject2.optString("4g");
                String optString8 = optJSONObject2.optString("wifi");
                if (optString5 != null) {
                    this.f51461b.put("2g", optString5);
                }
                if (optString6 != null) {
                    this.f51461b.put("3g", optString6);
                }
                if (optString7 != null) {
                    this.f51461b.put("4g", optString7);
                }
                if (optString8 != null) {
                    this.f51461b.put("wifi", optString8);
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("merge_data_frequency");
            if (optJSONObject3 != null) {
                String optString9 = optJSONObject3.optString("2g");
                String optString10 = optJSONObject3.optString("3g");
                String optString11 = optJSONObject3.optString("4g");
                String optString12 = optJSONObject3.optString("wifi");
                if (optString9 != null) {
                    this.f51462c.put("2g", optString9);
                }
                if (optString10 != null) {
                    this.f51462c.put("3g", optString10);
                }
                if (optString11 != null) {
                    this.f51462c.put("4g", optString11);
                }
                if (optString12 != null) {
                    this.f51462c.put("wifi", optString12);
                }
            }
            jSONObject.optString("is_on");
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
