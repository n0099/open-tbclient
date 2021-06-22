package d.a.n0.a.e0;

import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.StatisticItem;
import d.a.c.e.p.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static JSONObject a(@Nullable JSONObject jSONObject, int i2, int i3, String str) {
        if (i2 != 0 && i3 != 0 && !k.isEmpty(str)) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put(i2 + "-" + i3, str);
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }
        return jSONObject;
    }

    public static void b(int i2, int i3) {
        new StatisticItem("c13318").param("obj_source", i2).param("obj_type", i3).eventStat();
    }

    public static void c(int i2, int i3) {
        new StatisticItem("c13317").param("obj_source", i2).param("obj_type", i3).eventStat();
    }
}
