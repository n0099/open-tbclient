package d.b.g0.a.a2.g;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes3.dex */
public class f extends d {
    @Override // d.b.g0.a.a2.g.d
    public Bundle a(c cVar) {
        b b2 = h.b(cVar.f43657a);
        if (b2 == null) {
            if (!d.f43661a) {
                return Bundle.EMPTY;
            }
            throw new IllegalArgumentException("illegal sp.");
        }
        int i = cVar.f43658b;
        if (i == 1) {
            b2.putInt(cVar.f43659c, Integer.parseInt(cVar.f43660d));
        } else if (i == 2) {
            b2.putLong(cVar.f43659c, Long.parseLong(cVar.f43660d));
        } else if (i == 3) {
            b2.putBoolean(cVar.f43659c, Boolean.parseBoolean(cVar.f43660d));
        } else if (i == 4) {
            b2.putString(cVar.f43659c, cVar.f43660d);
        } else if (i != 5) {
            if (d.f43661a) {
                throw new IllegalArgumentException("wrong info params.");
            }
        } else {
            b2.putFloat(cVar.f43659c, Float.parseFloat(cVar.f43660d));
        }
        if (d.f43661a) {
            Log.d("SwanAppSpDelegation", "Put: " + cVar);
        }
        return Bundle.EMPTY;
    }
}
