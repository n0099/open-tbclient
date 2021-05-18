package d.a.i0.a.q0;

import android.text.TextUtils;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.searchbox.config.QuickPersistConfigConst;
import d.a.i0.a.a2.e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {
    public static String a() {
        String optString;
        int indexOf;
        e Q = e.Q();
        JSONObject jSONObject = new JSONObject();
        if (Q != null) {
            jSONObject = Q.L().M();
        }
        return (jSONObject == null || (optString = jSONObject.optString("keyfeed")) == null || (indexOf = optString.indexOf("_")) < 0 || !TextUtils.equals("miniapp", optString.substring(0, indexOf))) ? "" : optString.substring(indexOf + 1);
    }

    public static Map<String, Object> b(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_key", str);
        hashMap.put("op_type", str2);
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            hashMap.put("nid", a2);
        }
        return hashMap;
    }

    public static Map<String, Object> c(String str, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("app_key", str);
        hashMap.put(QuickPersistConfigConst.KEY_SPLASH_SORT, Integer.valueOf(i2));
        hashMap.put("op_type", IMTrack.DbBuilder.ACTION_ADD);
        return hashMap;
    }
}
