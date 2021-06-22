package d.a.m0.a.k2.g;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes3.dex */
public class f extends d {
    @Override // d.a.m0.a.k2.g.d
    public Bundle a(c cVar) {
        b b2 = h.b(cVar.f47054a);
        if (b2 == null) {
            if (!d.f47058a) {
                return Bundle.EMPTY;
            }
            throw new IllegalArgumentException("illegal sp.");
        }
        int i2 = cVar.f47055b;
        if (i2 == 1) {
            b2.putInt(cVar.f47056c, Integer.parseInt(cVar.f47057d));
        } else if (i2 == 2) {
            b2.putLong(cVar.f47056c, Long.parseLong(cVar.f47057d));
        } else if (i2 == 3) {
            b2.putBoolean(cVar.f47056c, Boolean.parseBoolean(cVar.f47057d));
        } else if (i2 == 4) {
            b2.putString(cVar.f47056c, cVar.f47057d);
        } else if (i2 != 5) {
            if (d.f47058a) {
                throw new IllegalArgumentException("wrong info params.");
            }
        } else {
            b2.putFloat(cVar.f47056c, Float.parseFloat(cVar.f47057d));
        }
        if (d.f47058a) {
            Log.d("SwanAppSpDelegation", "Put: " + cVar);
        }
        return Bundle.EMPTY;
    }
}
