package d.a.l0.a.i1.f.d;

import android.telephony.PhoneStateListener;
import android.util.Log;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class a extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f42940a = k.f43199a;

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i2, String str) {
        super.onCallStateChanged(i2, str);
        if (i2 == 0) {
            d.a.l0.a.i1.f.e.a.k().o();
            if (f42940a) {
                Log.i("PhoneStateListener", "挂断");
            }
        } else if (i2 == 1) {
            d.a.l0.a.i1.f.e.a.k().n();
            if (f42940a) {
                Log.i("PhoneStateListener", "响铃:" + str);
            }
        } else if (i2 != 2) {
            if (f42940a) {
                Log.e("PhoneStateListener", "invalid state");
            }
        } else {
            d.a.l0.a.i1.f.e.a.k().n();
            if (f42940a) {
                Log.i("PhoneStateListener", "接听");
            }
        }
    }
}
