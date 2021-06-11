package d.a.l0.n.i.i.d;

import android.util.Log;
import d.a.l0.n.c;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {
    public Integer a(Map<String, Object> map) {
        if (map != null && !map.isEmpty() && map.containsKey("queue_priority")) {
            try {
                int intValue = ((Integer) map.get("queue_priority")).intValue();
                if (intValue == 200 || intValue == 300) {
                    return Integer.valueOf(intValue);
                }
            } catch (Exception e2) {
                if (c.f51658a) {
                    Log.e("PriorityOptionHelper", e2.toString());
                    e2.printStackTrace();
                }
            }
        }
        return 100;
    }
}
