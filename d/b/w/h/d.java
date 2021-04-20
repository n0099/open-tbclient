package d.b.w.h;

import android.content.pm.PackageInfo;
import com.baidu.nps.utils.ContextHolder;
import java.io.File;
/* loaded from: classes2.dex */
public class d {
    public static PackageInfo a(String str, int i) {
        if (new File(str).exists()) {
            return ContextHolder.getApplicationContext().getPackageManager().getPackageArchiveInfo(str, i);
        }
        return null;
    }
}
