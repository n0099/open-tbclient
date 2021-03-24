package d.b.k0;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes5.dex */
public class z {
    public static void a(h0 h0Var) {
        if (h0Var == null || h0Var.j()) {
            return;
        }
        JSONArray d2 = h0Var.d();
        int length = d2.length();
        boolean l = h0Var.l();
        for (int i = 0; i < length; i++) {
            try {
                if (l != g.m().e(d2.getJSONObject(i).getString("id"))) {
                    Log.w("UBCDebug", " data is " + l + "  content " + h0Var.i().toString());
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(String str) {
    }
}
