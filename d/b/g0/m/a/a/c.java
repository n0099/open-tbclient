package d.b.g0.m.a.a;

import android.app.Activity;
/* loaded from: classes3.dex */
public class c {

    /* loaded from: classes3.dex */
    public interface a {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static void a(Activity activity, String[] strArr, int i) {
        if (activity instanceof a) {
            ((a) activity).validateRequestPermissionsRequestCode(i);
        }
        activity.requestPermissions(strArr, i);
    }
}
