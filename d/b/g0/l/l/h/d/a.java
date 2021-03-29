package d.b.g0.l.l.h.d;

import android.util.Log;
import d.b.g0.l.f;
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
                if (f.f48889a) {
                    Log.e("PriorityOptionHelper", e2.toString());
                    e2.printStackTrace();
                }
            }
        }
        return 100;
    }
}
