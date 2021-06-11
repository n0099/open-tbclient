package d.r.b.f;

import android.content.Context;
import com.yy.open.deviceidentifiertest.VirtualDevice;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f71465a;

    public static String a(Context context) {
        try {
            if (f71465a == null) {
                f71465a = new VirtualDevice().getDeviceID(context);
            }
            return f71465a;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
