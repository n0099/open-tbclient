package d.a.z.i;

import android.content.pm.PackageInfo;
import com.baidu.nps.utils.ContextHolder;
import java.io.File;
/* loaded from: classes2.dex */
public class e {
    public static PackageInfo a(String str, int i2) {
        if (new File(str).exists()) {
            return ContextHolder.getApplicationContext().getPackageManager().getPackageArchiveInfo(str, i2);
        }
        return null;
    }
}
