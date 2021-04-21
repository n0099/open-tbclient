package d.b.j0.o2;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes3.dex */
public class b {
    public static boolean a() {
        String systemProperty = UtilHelper.getSystemProperty("ro.miui.ui.version.name");
        return !StringUtils.isNull(systemProperty) && d.b.c.e.m.b.d(systemProperty.replace(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ""), 0) >= 9;
    }

    public static boolean b() {
        PackageManager packageManager = TbadkCoreApplication.getInst().getPackageManager();
        try {
            try {
            } catch (PackageManager.NameNotFoundException unused) {
                if (packageManager.getActivityInfo(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.StartBgActivityControlActivity"), 0) != null) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return packageManager.getActivityInfo(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.ScreenLockedActionControlActivity"), 0) != null;
    }
}
