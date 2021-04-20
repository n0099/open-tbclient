package d.b.i0.d3;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.baidu.tbadk.core.util.PermissionUtil;
/* loaded from: classes3.dex */
public class z {
    public static boolean a(Activity activity) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        boolean checkWriteExternalStorage = PermissionUtil.checkWriteExternalStorage(activity);
        if (activity.getApplicationInfo().targetSdkVersion >= 23 || !Environment.getExternalStorageState().equals("unmounted")) {
            return checkWriteExternalStorage;
        }
        return false;
    }

    public static boolean b(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 0) != null;
    }
}
