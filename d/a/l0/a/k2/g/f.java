package d.a.l0.a.k2.g;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes3.dex */
public class f extends d {
    @Override // d.a.l0.a.k2.g.d
    public Bundle a(c cVar) {
        b b2 = h.b(cVar.f46946a);
        if (b2 == null) {
            if (!d.f46950a) {
                return Bundle.EMPTY;
            }
            throw new IllegalArgumentException("illegal sp.");
        }
        int i2 = cVar.f46947b;
        if (i2 == 1) {
            b2.putInt(cVar.f46948c, Integer.parseInt(cVar.f46949d));
        } else if (i2 == 2) {
            b2.putLong(cVar.f46948c, Long.parseLong(cVar.f46949d));
        } else if (i2 == 3) {
            b2.putBoolean(cVar.f46948c, Boolean.parseBoolean(cVar.f46949d));
        } else if (i2 == 4) {
            b2.putString(cVar.f46948c, cVar.f46949d);
        } else if (i2 != 5) {
            if (d.f46950a) {
                throw new IllegalArgumentException("wrong info params.");
            }
        } else {
            b2.putFloat(cVar.f46948c, Float.parseFloat(cVar.f46949d));
        }
        if (d.f46950a) {
            Log.d("SwanAppSpDelegation", "Put: " + cVar);
        }
        return Bundle.EMPTY;
    }
}
