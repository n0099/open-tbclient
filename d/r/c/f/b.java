package d.r.c.f;

import android.content.Context;
import com.yy.open.deviceidentifiertest.VirtualDevice;
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f68166a;

    public static String a(Context context) {
        try {
            if (f68166a == null) {
                f68166a = new VirtualDevice().getDeviceID(context);
            }
            return f68166a;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
