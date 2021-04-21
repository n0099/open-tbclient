package d.b.c.g.h;

import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.ubc.UBCManager;
import java.util.AbstractMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f42919a = "11446";

    /* renamed from: b  reason: collision with root package name */
    public static String f42920b = "type";

    /* renamed from: c  reason: collision with root package name */
    public static String f42921c = "value";

    /* renamed from: d  reason: collision with root package name */
    public static String f42922d = "ext";

    /* renamed from: e  reason: collision with root package name */
    public static String f42923e = "suc";

    /* renamed from: f  reason: collision with root package name */
    public static String f42924f = "fail";

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "-" : str;
    }

    public static void b(String str, List<AbstractMap.SimpleEntry<String, String>> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f42920b, f42924f);
            jSONObject.put(f42921c, str);
            JSONObject jSONObject2 = new JSONObject();
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    AbstractMap.SimpleEntry<String, String> simpleEntry = list.get(i);
                    if (simpleEntry != null && !TextUtils.isEmpty(simpleEntry.getKey())) {
                        jSONObject2.put(simpleEntry.getKey(), a(simpleEntry.getValue()));
                    }
                }
            }
            jSONObject.put(f42922d, jSONObject2);
            d(f42919a, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void c(String str, List<AbstractMap.SimpleEntry<String, String>> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f42920b, f42923e);
            jSONObject.put(f42921c, str);
            JSONObject jSONObject2 = new JSONObject();
            if (list != null && !list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    AbstractMap.SimpleEntry<String, String> simpleEntry = list.get(i);
                    if (simpleEntry != null && !TextUtils.isEmpty(simpleEntry.getKey())) {
                        jSONObject2.put(simpleEntry.getKey(), a(simpleEntry.getValue()));
                    }
                }
            }
            jSONObject.put(f42922d, jSONObject2);
            d(f42919a, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void d(String str, JSONObject jSONObject) {
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, jSONObject);
    }
}
