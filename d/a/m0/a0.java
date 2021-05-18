package d.a.m0;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes5.dex */
public class a0 {
    public static void a(i0 i0Var) {
        if (i0Var == null || i0Var.j()) {
            return;
        }
        JSONArray d2 = i0Var.d();
        int length = d2.length();
        boolean l = i0Var.l();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                if (l != g.m().e(d2.getJSONObject(i2).getString("id"))) {
                    Log.w("UBCDebug", " data is " + l + "  content " + i0Var.i().toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(String str) {
    }
}
