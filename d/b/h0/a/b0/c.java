package d.b.h0.a.b0;

import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.StatisticItem;
import d.b.c.e.p.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static JSONObject a(@Nullable JSONObject jSONObject, int i, int i2, String str) {
        if (i != 0 && i2 != 0 && !k.isEmpty(str)) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put(i + "-" + i2, str);
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }
        return jSONObject;
    }

    public static void b(int i, int i2) {
        new StatisticItem("c13318").param("obj_source", i).param("obj_type", i2).eventStat();
    }

    public static void c(int i, int i2) {
        new StatisticItem("c13317").param("obj_source", i).param("obj_type", i2).eventStat();
    }
}
