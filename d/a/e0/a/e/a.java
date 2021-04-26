package d.a.e0.a.e;

import android.text.TextUtils;
import java.io.File;
/* loaded from: classes2.dex */
public final class a {
    public static boolean a(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return a(new File(str));
    }
}
