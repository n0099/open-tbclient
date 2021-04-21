package d.b.h0.p;

import android.text.TextUtils;
import android.util.Xml;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* loaded from: classes3.dex */
public class f {
    public static boolean a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        boolean z = false;
        if (inputStream == null || file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            z = true;
            d.a(fileOutputStream);
        } catch (Exception e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            d.a(fileOutputStream2);
            d.a(inputStream);
            return z;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d.a(fileOutputStream2);
            d.a(inputStream);
            throw th;
        }
        d.a(inputStream);
        return z;
    }

    public static String b(InputStream inputStream) {
        return c(inputStream, Xml.Encoding.UTF_8.toString());
    }

    public static String c(InputStream inputStream, String str) {
        if (inputStream == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str), 8192);
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
            } catch (Throwable th) {
                d.a(inputStream);
                throw th;
            }
        } catch (Exception | OutOfMemoryError e2) {
            e2.printStackTrace();
        }
        d.a(inputStream);
        return sb.toString();
    }

    public static boolean d(InputStream inputStream, String str) {
        boolean z = false;
        if (inputStream != null && !TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            byte[] bArr = new byte[8192];
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        break;
                    }
                    String str2 = str + "/" + nextEntry.getName();
                    if (nextEntry.isDirectory()) {
                        File file2 = new File(str2);
                        if (!file2.exists()) {
                            file2.mkdirs();
                        }
                    } else {
                        File parentFile = new File(str2).getParentFile();
                        if (!parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        if (!parentFile.isDirectory()) {
                            parentFile.delete();
                            parentFile.mkdirs();
                        }
                        FileOutputStream fileOutputStream = new FileOutputStream(str2);
                        while (true) {
                            try {
                                int read = zipInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                            } finally {
                            }
                        }
                        d.a(fileOutputStream);
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    d.a(zipInputStream);
                    throw th;
                }
            }
            z = true;
            d.a(zipInputStream);
        }
        return z;
    }
}
