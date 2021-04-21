package d.p.a.d.n;

import java.io.File;
/* loaded from: classes6.dex */
public class g {
    public static long a(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return b(file, file.lastModified(), 0);
    }

    public static long b(File file, long j, int i) {
        File[] listFiles;
        if (file != null && file.exists()) {
            j = Math.max(j, file.lastModified());
            int i2 = i + 1;
            if (i2 >= 50) {
                return j;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    j = Math.max(j, b(file2, j, i2));
                }
            }
        }
        return j;
    }
}
