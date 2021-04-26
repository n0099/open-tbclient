package d.a.h0.a.a2.g;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes3.dex */
public class f extends d {
    @Override // d.a.h0.a.a2.g.d
    public Bundle a(c cVar) {
        b b2 = h.b(cVar.f41256a);
        if (b2 == null) {
            if (!d.f41260a) {
                return Bundle.EMPTY;
            }
            throw new IllegalArgumentException("illegal sp.");
        }
        int i2 = cVar.f41257b;
        if (i2 == 1) {
            b2.putInt(cVar.f41258c, Integer.parseInt(cVar.f41259d));
        } else if (i2 == 2) {
            b2.putLong(cVar.f41258c, Long.parseLong(cVar.f41259d));
        } else if (i2 == 3) {
            b2.putBoolean(cVar.f41258c, Boolean.parseBoolean(cVar.f41259d));
        } else if (i2 == 4) {
            b2.putString(cVar.f41258c, cVar.f41259d);
        } else if (i2 != 5) {
            if (d.f41260a) {
                throw new IllegalArgumentException("wrong info params.");
            }
        } else {
            b2.putFloat(cVar.f41258c, Float.parseFloat(cVar.f41259d));
        }
        if (d.f41260a) {
            Log.d("SwanAppSpDelegation", "Put: " + cVar);
        }
        return Bundle.EMPTY;
    }
}
