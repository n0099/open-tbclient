package d.a.i0.o.a.a;

import android.app.Activity;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public interface a {
        void validateRequestPermissionsRequestCode(int i2);
    }

    public static void a(Activity activity, String[] strArr, int i2) {
        if (activity instanceof a) {
            ((a) activity).validateRequestPermissionsRequestCode(i2);
        }
        activity.requestPermissions(strArr, i2);
    }

    public static boolean b(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
