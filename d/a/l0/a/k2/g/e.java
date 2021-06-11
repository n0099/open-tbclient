package d.a.l0.a.k2.g;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes3.dex */
public class e extends d {
    @Override // d.a.l0.a.k2.g.d
    public Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b b2 = h.b(cVar.f46946a);
        if (b2 == null) {
            if (d.f46950a) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return bundle;
        }
        int i2 = cVar.f46947b;
        if (i2 == 1) {
            bundle.putInt("result_value", b2.getInt(cVar.f46948c, Integer.parseInt(cVar.f46949d)));
        } else if (i2 == 2) {
            bundle.putLong("result_value", b2.getLong(cVar.f46948c, Long.parseLong(cVar.f46949d)));
        } else if (i2 == 3) {
            bundle.putBoolean("result_value", b2.getBoolean(cVar.f46948c, Boolean.parseBoolean(cVar.f46949d)));
        } else if (i2 == 4) {
            bundle.putString("result_value", b2.getString(cVar.f46948c, cVar.f46949d));
        } else if (i2 != 5) {
            if (d.f46950a) {
                throw new IllegalArgumentException("wrong info params.");
            }
        } else {
            bundle.putFloat("result_value", b2.getFloat(cVar.f46948c, Float.parseFloat(cVar.f46949d)));
        }
        if (d.f46950a) {
            Log.d("SwanAppSpDelegation", "Get: " + cVar);
        }
        return bundle;
    }
}
