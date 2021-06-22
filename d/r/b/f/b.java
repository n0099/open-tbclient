package d.r.b.f;

import android.content.Context;
import com.yy.open.deviceidentifiertest.VirtualDevice;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f71569a;

    public static String a(Context context) {
        try {
            if (f71569a == null) {
                f71569a = new VirtualDevice().getDeviceID(context);
            }
            return f71569a;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
