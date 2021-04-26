package d.r.c.f;

import android.content.Context;
import com.yy.open.deviceidentifiertest.VirtualDevice;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f67480a;

    public static String a(Context context) {
        try {
            if (f67480a == null) {
                f67480a = new VirtualDevice().getDeviceID(context);
            }
            return f67480a;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
