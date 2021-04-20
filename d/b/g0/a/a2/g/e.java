package d.b.g0.a.a2.g;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes3.dex */
public class e extends d {
    @Override // d.b.g0.a.a2.g.d
    public Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b b2 = h.b(cVar.f43657a);
        if (b2 == null) {
            if (d.f43661a) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return bundle;
        }
        int i = cVar.f43658b;
        if (i == 1) {
            bundle.putInt("result_value", b2.getInt(cVar.f43659c, Integer.parseInt(cVar.f43660d)));
        } else if (i == 2) {
            bundle.putLong("result_value", b2.getLong(cVar.f43659c, Long.parseLong(cVar.f43660d)));
        } else if (i == 3) {
            bundle.putBoolean("result_value", b2.getBoolean(cVar.f43659c, Boolean.parseBoolean(cVar.f43660d)));
        } else if (i == 4) {
            bundle.putString("result_value", b2.getString(cVar.f43659c, cVar.f43660d));
        } else if (i != 5) {
            if (d.f43661a) {
                throw new IllegalArgumentException("wrong info params.");
            }
        } else {
            bundle.putFloat("result_value", b2.getFloat(cVar.f43659c, Float.parseFloat(cVar.f43660d)));
        }
        if (d.f43661a) {
            Log.d("SwanAppSpDelegation", "Get: " + cVar);
        }
        return bundle;
    }
}
