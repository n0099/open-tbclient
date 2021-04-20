package d.b.h0.r.g0.b;

import com.baidu.tbadk.core.util.FileHelper;
import d.b.c.e.p.q;
import java.io.File;
/* loaded from: classes3.dex */
public class b {
    public static synchronized void a() {
        synchronized (b.class) {
            File file = new File(FileHelper.getCacheDir() + "voice");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        }
    }

    public static boolean b(String str, String str2) {
        return FileHelper.renameTo(str, FileHelper.getFilePath(str2, 1, true));
    }

    public static a c(String str) {
        a aVar = new a();
        if (str == null) {
            aVar.f50996c = 6;
            aVar.f50997d = a.a(6);
            return aVar;
        }
        if (!FileHelper.CheckTempDir(FileHelper.getCacheDir() + "voice")) {
            aVar.f50996c = 7;
            aVar.f50997d = a.a(7);
            return aVar;
        }
        String b2 = q.b(FileHelper.GetStreamFromTmpFile(str));
        if (b2 == null) {
            aVar.f50996c = 5;
            aVar.f50997d = a.a(5);
        } else {
            String filePath = FileHelper.getFilePath(b2, 1, true);
            if (FileHelper.renameTo(str, filePath)) {
                aVar.f50995b = filePath;
                aVar.f50994a = b2;
            } else {
                aVar.f50996c = 1;
                aVar.f50997d = a.a(1);
            }
        }
        return aVar;
    }
}
