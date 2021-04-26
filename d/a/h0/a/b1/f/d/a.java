package d.a.h0.a.b1.f.d;

import android.telephony.PhoneStateListener;
import android.util.Log;
import d.a.h0.a.k;
/* loaded from: classes3.dex */
public class a extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f41493a = k.f43101a;

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i2, String str) {
        super.onCallStateChanged(i2, str);
        if (i2 == 0) {
            d.a.h0.a.b1.f.e.a.k().o();
            if (f41493a) {
                Log.i("PhoneStateListener", "挂断");
            }
        } else if (i2 == 1) {
            d.a.h0.a.b1.f.e.a.k().n();
            if (f41493a) {
                Log.i("PhoneStateListener", "响铃:" + str);
            }
        } else if (i2 != 2) {
            if (f41493a) {
                Log.e("PhoneStateListener", "invalid state");
            }
        } else {
            d.a.h0.a.b1.f.e.a.k().n();
            if (f41493a) {
                Log.i("PhoneStateListener", "接听");
            }
        }
    }
}
