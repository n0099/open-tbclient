package d.b.g0.a.b1.f.d;

import android.telephony.PhoneStateListener;
import android.util.Log;
import d.b.g0.a.k;
/* loaded from: classes3.dex */
public class a extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43491a = k.f45050a;

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i, String str) {
        super.onCallStateChanged(i, str);
        if (i == 0) {
            d.b.g0.a.b1.f.e.a.k().o();
            if (f43491a) {
                Log.i("PhoneStateListener", "挂断");
            }
        } else if (i == 1) {
            d.b.g0.a.b1.f.e.a.k().n();
            if (f43491a) {
                Log.i("PhoneStateListener", "响铃:" + str);
            }
        } else if (i != 2) {
            if (f43491a) {
                Log.e("PhoneStateListener", "invalid state");
            }
        } else {
            d.b.g0.a.b1.f.e.a.k().n();
            if (f43491a) {
                Log.i("PhoneStateListener", "接听");
            }
        }
    }
}
