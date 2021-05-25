package d.r.c.f;

import android.content.Context;
import com.yy.open.deviceidentifiertest.VirtualDevice;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f68209a;

    public static String a(Context context) {
        try {
            if (f68209a == null) {
                f68209a = new VirtualDevice().getDeviceID(context);
            }
            return f68209a;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
