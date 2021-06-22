package d.a.o0.m0;

import android.graphics.Bitmap;
import com.baidu.spswitch.emotion.resource.EmotionResourceProvider;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.FileHelper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes4.dex */
public class b {
    public static List<String> a(String str, InputStream inputStream) throws Exception {
        ZipInputStream zipInputStream = null;
        try {
            ZipInputStream zipInputStream2 = new ZipInputStream(new BufferedInputStream(inputStream));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    } else if (!nextEntry.isDirectory()) {
                        h(str, nextEntry.getName(), zipInputStream2);
                    }
                } catch (Throwable th) {
                    th = th;
                    zipInputStream = zipInputStream2;
                    d.a.c.e.p.m.e(zipInputStream);
                    throw th;
                }
            }
            zipInputStream2.close();
            d.a.c.e.p.m.e(zipInputStream2);
            byte[] e2 = e(str, "map.txt");
            if (e2 != null) {
                String str2 = new String(e2, "UTF-8");
                LinkedList linkedList = new LinkedList();
                for (String str3 : str2.split("\n")) {
                    String trim = str3.trim();
                    if (trim.startsWith(SmallTailInfo.EMOTION_PREFIX)) {
                        String[] split = trim.split("=");
                        if (split.length == 2) {
                            String trim2 = split[0].trim();
                            String trim3 = split[1].trim();
                            g(str, "s_" + trim3 + EmotionResourceProvider.EMOTION_RES_NAME_SUFFIX, b(trim2, false));
                            g(str, "d_" + trim3 + ".gif", b(trim2, true));
                            linkedList.add(trim2);
                        }
                    }
                }
                return linkedList;
            }
            throw new FileNotFoundException("map.txt file not exsit!");
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b(String str, boolean z) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "d_" : "s_");
        sb.append(hashCode);
        return sb.toString();
    }

    public static String c(String str, boolean z, boolean z2) {
        long hashCode = str.hashCode();
        if (hashCode < 0) {
            hashCode *= -1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(z ? "s_" : "d_");
        sb.append(hashCode);
        String sb2 = sb.toString();
        if (z2 && !z) {
            return sb2 + ".gif";
        }
        return sb2 + ".jpg";
    }

    public static boolean d(String str) {
        Bitmap f2 = f(str, "panel.png");
        if (f2 == null) {
            return false;
        }
        f2.recycle();
        return true;
    }

    public static byte[] e(String str, String str2) {
        return FileHelper.GetFileData(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + (".emotions/" + str) + "/" + str2);
    }

    public static Bitmap f(String str, String str2) {
        return FileHelper.getImage(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/" + (".emotions/" + str) + "/" + str2);
    }

    public static boolean g(String str, String str2, String str3) {
        String str4 = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.emotions/" + str + "/";
        File file = new File(str4, str2);
        if (file.exists()) {
            File file2 = new File(str4, str3);
            if (file2.exists()) {
                if (file2.delete() && file.renameTo(file2)) {
                    return true;
                }
                return FileHelper.CopyFile(file.getAbsolutePath(), file2.getAbsolutePath());
            } else if (file.renameTo(file2)) {
                return true;
            } else {
                return FileHelper.CopyFile(file.getAbsolutePath(), file2.getAbsolutePath());
            }
        }
        return false;
    }

    public static boolean h(String str, String str2, InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        sb.append(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath());
        sb.append("/");
        sb.append(".emotions/" + str);
        sb.append("/");
        sb.append(str2);
        return FileHelper.saveFile(sb.toString(), inputStream) != null;
    }
}
