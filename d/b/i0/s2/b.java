package d.b.i0.s2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.io.File;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f61589a = TbadkCoreApplication.getInst().getApp().getExternalCacheDir() + "/nadDir";

    public static File a(@NonNull String str) {
        return FileHelper.CreateFileIfNotFoundAbsolutePath(g(str));
    }

    public static void b(String str) {
        c(e(f(str)));
    }

    public static void c(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        int length = listFiles.length;
                        for (int i = 0; i < length; i++) {
                            if (listFiles[i].isFile()) {
                                listFiles[i].delete();
                            } else {
                                c(listFiles[i]);
                            }
                        }
                    }
                    file.delete();
                }
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                TiebaStatic.file(e2, "FileHelper.deleteFileOrDir");
            }
        }
    }

    public static File d(@NonNull String str) {
        return FileHelper.GetFileByAbsolutePath(str);
    }

    public static File e(@NonNull String str) {
        if (!d.b.i0.a.e().o()) {
            return FileHelper.GetFile(str);
        }
        return d(g(str));
    }

    public static String f(@NonNull String str) {
        return str.replace(".", "_") + ".apk";
    }

    public static String g(@NonNull String str) {
        if (!d.b.i0.a.e().o()) {
            StringBuilder sb = new StringBuilder();
            sb.append(FileHelper.getCacheDir());
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            sb.append("/");
            sb.append(str);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f61589a);
        File file2 = new File(sb2.toString());
        if (!file2.exists()) {
            file2.mkdirs();
        }
        sb2.append("/");
        sb2.append(str);
        return sb2.toString();
    }

    public static String h(String str) {
        return g(f(str));
    }

    public static String i(@NonNull String str, @NonNull String str2) {
        return str + "_" + str2 + ".tmp";
    }

    public static boolean j(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return l(e(f(str)));
    }

    public static boolean k(@NonNull String str, @NonNull String str2) {
        if (TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L) == 0) {
            return false;
        }
        return l(e(i(str, str2)));
    }

    public static boolean l(File file) {
        return file != null && file.exists() && file.isFile();
    }
}
