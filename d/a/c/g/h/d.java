package d.a.c.g.h;

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
    public static String f42803a = "11446";

    /* renamed from: b  reason: collision with root package name */
    public static String f42804b = "type";

    /* renamed from: c  reason: collision with root package name */
    public static String f42805c = "value";

    /* renamed from: d  reason: collision with root package name */
    public static String f42806d = "ext";

    /* renamed from: e  reason: collision with root package name */
    public static String f42807e = "suc";

    /* renamed from: f  reason: collision with root package name */
    public static String f42808f = "fail";

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "-" : str;
    }

    public static void b(String str, List<AbstractMap.SimpleEntry<String, String>> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f42804b, f42808f);
            jSONObject.put(f42805c, str);
            JSONObject jSONObject2 = new JSONObject();
            if (list != null && !list.isEmpty()) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    AbstractMap.SimpleEntry<String, String> simpleEntry = list.get(i2);
                    if (simpleEntry != null && !TextUtils.isEmpty(simpleEntry.getKey())) {
                        jSONObject2.put(simpleEntry.getKey(), a(simpleEntry.getValue()));
                    }
                }
            }
            jSONObject.put(f42806d, jSONObject2);
            d(f42803a, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void c(String str, List<AbstractMap.SimpleEntry<String, String>> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f42804b, f42807e);
            jSONObject.put(f42805c, str);
            JSONObject jSONObject2 = new JSONObject();
            if (list != null && !list.isEmpty()) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    AbstractMap.SimpleEntry<String, String> simpleEntry = list.get(i2);
                    if (simpleEntry != null && !TextUtils.isEmpty(simpleEntry.getKey())) {
                        jSONObject2.put(simpleEntry.getKey(), a(simpleEntry.getValue()));
                    }
                }
            }
            jSONObject.put(f42806d, jSONObject2);
            d(f42803a, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void d(String str, JSONObject jSONObject) {
        ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, jSONObject);
    }
}
