package d.a.i0.a.k2.g;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes3.dex */
public class f extends d {
    @Override // d.a.i0.a.k2.g.d
    public Bundle a(c cVar) {
        b b2 = h.b(cVar.f43096a);
        if (b2 == null) {
            if (!d.f43100a) {
                return Bundle.EMPTY;
            }
            throw new IllegalArgumentException("illegal sp.");
        }
        int i2 = cVar.f43097b;
        if (i2 == 1) {
            b2.putInt(cVar.f43098c, Integer.parseInt(cVar.f43099d));
        } else if (i2 == 2) {
            b2.putLong(cVar.f43098c, Long.parseLong(cVar.f43099d));
        } else if (i2 == 3) {
            b2.putBoolean(cVar.f43098c, Boolean.parseBoolean(cVar.f43099d));
        } else if (i2 == 4) {
            b2.putString(cVar.f43098c, cVar.f43099d);
        } else if (i2 != 5) {
            if (d.f43100a) {
                throw new IllegalArgumentException("wrong info params.");
            }
        } else {
            b2.putFloat(cVar.f43098c, Float.parseFloat(cVar.f43099d));
        }
        if (d.f43100a) {
            Log.d("SwanAppSpDelegation", "Put: " + cVar);
        }
        return Bundle.EMPTY;
    }
}
