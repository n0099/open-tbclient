package d.a.c.e.p;

import android.os.Environment;
import android.os.StatFs;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.webkit.internal.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static String f39193a = "baidu";

    /* renamed from: b  reason: collision with root package name */
    public static final File f39194b = Environment.getExternalStorageDirectory();

    /* renamed from: c  reason: collision with root package name */
    public static final char f39195c = File.separatorChar;

    public static int A(String str) {
        int lastIndexOf;
        if (str != null && B(str) <= (lastIndexOf = str.lastIndexOf(46))) {
            return lastIndexOf;
        }
        return -1;
    }

    public static int B(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean C(File file) throws IOException {
        if (file != null) {
            if (D()) {
                return false;
            }
            if (file.getParent() != null) {
                file = new File(file.getParentFile().getCanonicalFile(), file.getName());
            }
            return !file.getCanonicalFile().equals(file.getAbsoluteFile());
        }
        throw new NullPointerException("File must not be null");
    }

    public static boolean D() {
        return f39195c == '\\';
    }

    public static void E(OutputStream outputStream) throws IOException {
        outputStream.write(new byte[]{Base64.INTERNAL_PADDING, PublicSuffixDatabase.EXCEPTION_MARKER, 65, 77, 82, 10}, 0, 6);
    }

    public static boolean a(String str, String str2) {
        File file = new File(r(v(str, str2)));
        if (file.exists()) {
            return true;
        }
        try {
            return file.mkdirs();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public static boolean b(String str) {
        String y = y(str);
        if (c()) {
            File file = new File(y);
            return file.exists() || file.mkdirs();
        }
        return false;
    }

    public static boolean c() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean d() {
        try {
            StatFs statFs = new StatFs(f39194b.getPath());
            return ((((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1024) / 1024 > 2;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void e(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    IOException e2 = null;
                    for (File file2 : listFiles) {
                        try {
                            p(file2);
                        } catch (IOException e3) {
                            e2 = e3;
                        }
                    }
                    if (e2 != null) {
                        throw e2;
                    }
                    return;
                }
                throw new IOException("Failed to list contents of " + file);
            }
            throw new IllegalArgumentException(file + " is not a directory");
        }
        throw new IllegalArgumentException(file + " does not exist");
    }

    public static void f(File file, File file2) throws IOException {
        g(file, file2, true);
    }

    public static void g(File file, File file2, boolean z) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 != null) {
            if (file.exists()) {
                if (!file.isDirectory()) {
                    if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
                        File parentFile = file2.getParentFile();
                        if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                            throw new IOException("Destination '" + parentFile + "' directory cannot be created");
                        } else if (file2.exists() && !file2.canWrite()) {
                            throw new IOException("Destination '" + file2 + "' exists but is read-only");
                        } else {
                            o(file, file2, z);
                            return;
                        }
                    }
                    throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
                }
                throw new IOException("Source '" + file + "' exists but is a directory");
            }
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
        throw new NullPointerException("Destination must not be null");
    }

    public static File h(String str, String str2) {
        if (b(str)) {
            try {
                if (a(str, str2)) {
                    File t = t(str, str2);
                    if (!t.exists() || t.delete()) {
                        if (t.createNewFile()) {
                            return t;
                        }
                        return null;
                    }
                    return null;
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return null;
    }

    public static File i(String str) {
        return j(null, str);
    }

    public static File j(String str, String str2) {
        if (b(str)) {
            try {
                File t = t(str, str2);
                if (t.exists()) {
                    return t;
                }
                if (t.createNewFile()) {
                    return t;
                }
                return null;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return null;
    }

    public static boolean k(String str) {
        return l(null, str);
    }

    public static boolean l(String str, String str2) {
        if (b(str)) {
            File t = t(str, str2);
            try {
                if (t.exists()) {
                    return t.delete();
                }
                return false;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
                return false;
            }
        }
        return false;
    }

    public static void m(File file) throws IOException {
        if (file.exists()) {
            if (!C(file)) {
                e(file);
            }
            if (file.delete()) {
                return;
            }
            throw new IOException("Unable to delete directory " + file + ".");
        }
    }

    public static boolean n(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                e(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x00a9 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.io.OutputStream, java.io.FileOutputStream] */
    public static void o(File file, File file2, boolean z) throws IOException {
        FileInputStream fileInputStream;
        ?? r6;
        FileChannel fileChannel;
        FileChannel fileChannel2;
        Object obj;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileChannel fileChannel3 = 0;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Error e2) {
            e = e2;
            fileChannel = null;
            r6 = 0;
            fileChannel2 = null;
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
            r6 = 0;
        }
        try {
            r6 = new FileOutputStream(file2);
            try {
                fileChannel2 = fileInputStream.getChannel();
            } catch (Error e3) {
                e = e3;
                fileChannel2 = null;
                obj = r6;
                fileChannel3 = fileInputStream;
                fileChannel = fileChannel2;
                r6 = obj;
                try {
                    throw new IOException("Failed Error to copy contents from '" + file + "' to '" + file2 + "' with " + e.toString());
                } catch (Throwable th2) {
                    th = th2;
                    FileChannel fileChannel4 = fileChannel;
                    fileInputStream = fileChannel3;
                    fileChannel3 = fileChannel4;
                    m.d(fileChannel3);
                    m.f(r6);
                    m.d(fileChannel2);
                    m.e(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel2 = null;
            }
            try {
                fileChannel3 = r6.getChannel();
                long size = fileChannel2.size();
                long j = 0;
                while (j < size) {
                    long j2 = size - j;
                    j += fileChannel3.transferFrom(fileChannel2, j, j2 > 31457280 ? 31457280L : j2);
                }
                m.d(fileChannel3);
                m.f(r6);
                m.d(fileChannel2);
                m.e(fileInputStream);
                if (file.length() == file2.length()) {
                    if (z) {
                        file2.setLastModified(file.lastModified());
                        return;
                    }
                    return;
                }
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "'");
            } catch (Error e4) {
                e = e4;
                fileChannel = fileChannel3;
                fileChannel3 = fileInputStream;
                r6 = r6;
                throw new IOException("Failed Error to copy contents from '" + file + "' to '" + file2 + "' with " + e.toString());
            } catch (Throwable th4) {
                th = th4;
                m.d(fileChannel3);
                m.f(r6);
                m.d(fileChannel2);
                m.e(fileInputStream);
                throw th;
            }
        } catch (Error e5) {
            e = e5;
            obj = null;
            fileChannel2 = null;
        } catch (Throwable th5) {
            th = th5;
            r6 = 0;
            fileChannel2 = r6;
            m.d(fileChannel3);
            m.f(r6);
            m.d(fileChannel2);
            m.e(fileInputStream);
            throw th;
        }
    }

    public static void p(File file) throws IOException {
        if (file.isDirectory()) {
            m(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!exists) {
            throw new FileNotFoundException("File does not exist: " + file);
        }
        throw new IOException("Unable to delete file: " + file);
    }

    public static void q(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
        } else if (file.mkdirs() || file.isDirectory()) {
        } else {
            throw new IOException("Unable to create directory " + file);
        }
    }

    public static String r(String str) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf <= 0 || lastIndexOf >= str.length()) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static String s(String str) {
        if (str == null) {
            return null;
        }
        int A = A(str);
        return A == -1 ? "" : str.substring(A + 1);
    }

    public static File t(String str, String str2) {
        if (b(str)) {
            try {
                return new File(v(str, str2));
            } catch (SecurityException e2) {
                BdLog.e(e2.getMessage());
                return null;
            }
        }
        return null;
    }

    public static String u(String str) {
        return v(null, str);
    }

    public static String v(String str, String str2) {
        if (str != null) {
            return f39194b + "/" + f39193a + "/" + str + "/" + str2;
        }
        return f39194b + "/" + f39193a + "/" + str2;
    }

    public static long w(File file) {
        long j = 0;
        FileInputStream fileInputStream = null;
        try {
            if (file.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    j = fileInputStream2.available();
                } catch (Exception unused) {
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    d.a.c.e.m.a.c(fileInputStream);
                    throw th;
                }
                fileInputStream = fileInputStream2;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        d.a.c.e.m.a.c(fileInputStream);
        return j;
    }

    public static InputStream x(File file) {
        if (file != null) {
            try {
                return new FileInputStream(file);
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
        return null;
    }

    public static String y(String str) {
        if (str != null) {
            return f39194b + "/" + f39193a + "/" + str + "/";
        }
        return f39194b + "/" + f39193a + "/";
    }

    public static int z() {
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals("mounted")) {
            return 0;
        }
        if (externalStorageState.equals("unmounted") || externalStorageState.equals("unmountable") || externalStorageState.equals("removed")) {
            return 1;
        }
        return externalStorageState.equals("shared") ? 2 : 3;
    }
}
