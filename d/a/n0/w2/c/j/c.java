package d.a.n0.w2.c.j;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.lib.util.BdLog;
import java.io.File;
/* loaded from: classes5.dex */
public class c {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf);
    }

    public static String b() {
        try {
            return Environment.getExternalStorageDirectory() + File.separator + "tieba/Logs/";
        } catch (Exception e2) {
            BdLog.e(Log.getStackTraceString(e2));
            return null;
        }
    }

    public static String c() {
        return d() + "tieba/Logs/";
    }

    public static String d() {
        String path = Environment.getExternalStorageDirectory().getPath();
        int length = path.length() - 1;
        if (length <= 0 || path.substring(length).equals(File.separator)) {
            return path;
        }
        return path + File.separator;
    }

    public static boolean e(String str) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        File file = new File(a2);
        return (file.exists() && file.isDirectory()) || file.mkdirs();
    }
}
