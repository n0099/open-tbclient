package d.a.m0.a.k2.g;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes3.dex */
public class e extends d {
    @Override // d.a.m0.a.k2.g.d
    public Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b b2 = h.b(cVar.f47054a);
        if (b2 == null) {
            if (d.f47058a) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return bundle;
        }
        int i2 = cVar.f47055b;
        if (i2 == 1) {
            bundle.putInt("result_value", b2.getInt(cVar.f47056c, Integer.parseInt(cVar.f47057d)));
        } else if (i2 == 2) {
            bundle.putLong("result_value", b2.getLong(cVar.f47056c, Long.parseLong(cVar.f47057d)));
        } else if (i2 == 3) {
            bundle.putBoolean("result_value", b2.getBoolean(cVar.f47056c, Boolean.parseBoolean(cVar.f47057d)));
        } else if (i2 == 4) {
            bundle.putString("result_value", b2.getString(cVar.f47056c, cVar.f47057d));
        } else if (i2 != 5) {
            if (d.f47058a) {
                throw new IllegalArgumentException("wrong info params.");
            }
        } else {
            bundle.putFloat("result_value", b2.getFloat(cVar.f47056c, Float.parseFloat(cVar.f47057d)));
        }
        if (d.f47058a) {
            Log.d("SwanAppSpDelegation", "Get: " + cVar);
        }
        return bundle;
    }
}
