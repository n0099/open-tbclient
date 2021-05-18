package d.a.i0.a.k2.g;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes3.dex */
public class e extends d {
    @Override // d.a.i0.a.k2.g.d
    public Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b b2 = h.b(cVar.f43096a);
        if (b2 == null) {
            if (d.f43100a) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return bundle;
        }
        int i2 = cVar.f43097b;
        if (i2 == 1) {
            bundle.putInt("result_value", b2.getInt(cVar.f43098c, Integer.parseInt(cVar.f43099d)));
        } else if (i2 == 2) {
            bundle.putLong("result_value", b2.getLong(cVar.f43098c, Long.parseLong(cVar.f43099d)));
        } else if (i2 == 3) {
            bundle.putBoolean("result_value", b2.getBoolean(cVar.f43098c, Boolean.parseBoolean(cVar.f43099d)));
        } else if (i2 == 4) {
            bundle.putString("result_value", b2.getString(cVar.f43098c, cVar.f43099d));
        } else if (i2 != 5) {
            if (d.f43100a) {
                throw new IllegalArgumentException("wrong info params.");
            }
        } else {
            bundle.putFloat("result_value", b2.getFloat(cVar.f43098c, Float.parseFloat(cVar.f43099d)));
        }
        if (d.f43100a) {
            Log.d("SwanAppSpDelegation", "Get: " + cVar);
        }
        return bundle;
    }
}
