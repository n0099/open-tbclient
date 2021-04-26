package d.a.h0.a.a2.g;

import android.os.Bundle;
import android.util.Log;
/* loaded from: classes3.dex */
public class e extends d {
    @Override // d.a.h0.a.a2.g.d
    public Bundle a(c cVar) {
        Bundle bundle = new Bundle();
        b b2 = h.b(cVar.f41256a);
        if (b2 == null) {
            if (d.f41260a) {
                throw new IllegalArgumentException("illegal sp.");
            }
            return bundle;
        }
        int i2 = cVar.f41257b;
        if (i2 == 1) {
            bundle.putInt("result_value", b2.getInt(cVar.f41258c, Integer.parseInt(cVar.f41259d)));
        } else if (i2 == 2) {
            bundle.putLong("result_value", b2.getLong(cVar.f41258c, Long.parseLong(cVar.f41259d)));
        } else if (i2 == 3) {
            bundle.putBoolean("result_value", b2.getBoolean(cVar.f41258c, Boolean.parseBoolean(cVar.f41259d)));
        } else if (i2 == 4) {
            bundle.putString("result_value", b2.getString(cVar.f41258c, cVar.f41259d));
        } else if (i2 != 5) {
            if (d.f41260a) {
                throw new IllegalArgumentException("wrong info params.");
            }
        } else {
            bundle.putFloat("result_value", b2.getFloat(cVar.f41258c, Float.parseFloat(cVar.f41259d)));
        }
        if (d.f41260a) {
            Log.d("SwanAppSpDelegation", "Get: " + cVar);
        }
        return bundle;
    }
}
