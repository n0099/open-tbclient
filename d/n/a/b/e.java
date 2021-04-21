package d.n.a.b;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.plugin.install.PluginInstallerService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static List<String> f67424a = new ArrayList();

    public static File a(Context context) {
        if (context == null || context.getFilesDir() == null) {
            return null;
        }
        File file = new File(context.getFilesDir(), "libso");
        if (!file.exists()) {
            b.d(file.getAbsolutePath());
        }
        return file;
    }

    public static String b(Context context, String str, File file) {
        InputStream inputStream;
        ZipFile zipFile;
        String message;
        ZipEntry entry;
        FileOutputStream fileOutputStream = null;
        try {
            zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir), 1);
            try {
                entry = zipFile.getEntry(PluginInstallerService.APK_LIB_DIR_PREFIX + Build.CPU_ABI + "/" + System.mapLibraryName(str));
            } catch (Throwable th) {
                th = th;
                inputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            zipFile = null;
        }
        if (entry == null) {
            int indexOf = Build.CPU_ABI.indexOf(45);
            StringBuilder sb = new StringBuilder();
            sb.append(PluginInstallerService.APK_LIB_DIR_PREFIX);
            String str2 = Build.CPU_ABI;
            if (indexOf <= 0) {
                indexOf = Build.CPU_ABI.length();
            }
            sb.append(str2.substring(0, indexOf));
            sb.append("/");
            sb.append(System.mapLibraryName(str));
            String sb2 = sb.toString();
            ZipEntry entry2 = zipFile.getEntry(sb2);
            if (entry2 == null) {
                message = "Library entry not found:" + sb2;
                b.a(null);
                b.a(null);
                b.c(zipFile);
                return message;
            }
            entry = entry2;
        }
        file.createNewFile();
        InputStream inputStream2 = zipFile.getInputStream(entry);
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream2.read(bArr);
                    if (read <= 0) {
                        b.b(file.getAbsolutePath(), 493);
                        b.a(fileOutputStream2);
                        b.a(inputStream2);
                        b.c(zipFile);
                        return null;
                    }
                    fileOutputStream2.write(bArr, 0, read);
                }
            } catch (Throwable th3) {
                fileOutputStream = fileOutputStream2;
                inputStream = inputStream2;
                th = th3;
                try {
                    message = th.getMessage();
                    b.a(fileOutputStream);
                    b.a(inputStream);
                    b.c(zipFile);
                    return message;
                } catch (Throwable th4) {
                    b.a(fileOutputStream);
                    b.a(inputStream);
                    b.c(zipFile);
                    throw th4;
                }
            }
        } catch (Throwable th5) {
            inputStream = inputStream2;
            th = th5;
        }
    }

    public static synchronized boolean c(Context context, String str) {
        synchronized (e.class) {
            if (f67424a.contains(str)) {
                return true;
            }
            try {
                System.loadLibrary(str);
                f67424a.add(str);
            } catch (UnsatisfiedLinkError unused) {
                File d2 = d(context, str);
                if (d2 == null) {
                    return false;
                }
                if (d2.exists()) {
                    d2.delete();
                }
                if (b(context, str, d2) != null) {
                    return false;
                }
                try {
                    System.load(d2.getAbsolutePath());
                    f67424a.add(str);
                } catch (Throwable unused2) {
                    return false;
                }
            } catch (Throwable unused3) {
                return false;
            }
            return true;
        }
    }

    public static File d(Context context, String str) {
        String mapLibraryName = System.mapLibraryName(str);
        File a2 = a(context);
        if (a2 != null) {
            return new File(a2, mapLibraryName);
        }
        return null;
    }
}
