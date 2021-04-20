package d.b.g0.p;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.kwai.video.player.KsMediaMeta;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static int f49726a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static int f49727b = 1;

    public static void A(@NonNull List<String> list, @NonNull File file) {
        if (file.exists()) {
            FileWriter fileWriter = null;
            try {
                try {
                    FileWriter fileWriter2 = new FileWriter(file);
                    for (int i = 0; i < list.size(); i++) {
                        try {
                            fileWriter2.write(list.get(i));
                            if (i != list.size() - 1) {
                                fileWriter2.write("\n");
                            }
                        } catch (IOException unused) {
                            fileWriter = fileWriter2;
                            if (fileWriter != null) {
                                fileWriter.close();
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileWriter = fileWriter2;
                            if (fileWriter != null) {
                                try {
                                    fileWriter.close();
                                } catch (IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                    fileWriter2.flush();
                    fileWriter2.close();
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static void B(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        }
        try {
            d(inputStream, fileOutputStream);
            a(fileOutputStream);
        } catch (FileNotFoundException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            a(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            a(fileOutputStream2);
            throw th;
        }
    }

    public static void C(InputStream inputStream, File file, boolean z) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, z);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e2) {
            e = e2;
        }
        try {
            d(inputStream, fileOutputStream);
            a(fileOutputStream);
        } catch (FileNotFoundException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            a(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            a(fileOutputStream2);
            throw th;
        }
    }

    public static void D(String str, File file, boolean z) {
        C(new ByteArrayInputStream(str.getBytes()), file, z);
    }

    public static String E(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString);
            sb.append(str);
        }
        return sb.toString();
    }

    public static boolean F(String str, String str2) {
        return H(str, str2) == null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: java.io.BufferedOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean G(String str, String str2) {
        ZipInputStream zipInputStream;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            InputStream inputStream = null;
            try {
                InputStream open = AppRuntime.getAppContext().getAssets().open(str);
                try {
                    zipInputStream = new ZipInputStream(open);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry != null) {
                                if (!TextUtils.isEmpty(nextEntry.getName()) && !o(nextEntry.getName())) {
                                    File file2 = new File(str2 + File.separator + nextEntry.getName());
                                    if (nextEntry.isDirectory()) {
                                        if (!file2.exists()) {
                                            file2.mkdir();
                                        }
                                    } else if (file2.exists()) {
                                        continue;
                                    } else {
                                        e(file2);
                                        try {
                                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), 2048);
                                            while (true) {
                                                try {
                                                    int read = zipInputStream.read(bArr);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    bufferedOutputStream.write(bArr, 0, read);
                                                } catch (Throwable th) {
                                                    th = th;
                                                    inputStream = bufferedOutputStream;
                                                    a(inputStream);
                                                    throw th;
                                                }
                                            }
                                            a(bufferedOutputStream);
                                            inputStream = bufferedOutputStream;
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    }
                                }
                            } else {
                                a(open);
                                a(zipInputStream);
                                return true;
                            }
                        }
                    } catch (IOException unused) {
                        inputStream = open;
                        a(inputStream);
                        a(zipInputStream);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = open;
                        a(inputStream);
                        a(zipInputStream);
                        throw th;
                    }
                } catch (IOException unused2) {
                    zipInputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    zipInputStream = null;
                }
            } catch (IOException unused3) {
                zipInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                zipInputStream = null;
            }
        }
        return false;
    }

    public static Exception H(String str, String str2) {
        ZipFile zipFile;
        BufferedInputStream bufferedInputStream;
        System.currentTimeMillis();
        if (str == null) {
            return new Exception("srcFileName is null");
        }
        if (str2 == null) {
            str2 = new File(str).getParent();
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            zipFile = new ZipFile(str);
            try {
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                BufferedOutputStream bufferedOutputStream2 = null;
                bufferedInputStream = null;
                while (entries.hasMoreElements()) {
                    try {
                        ZipEntry nextElement = entries.nextElement();
                        if (!TextUtils.isEmpty(nextElement.getName()) && !o(nextElement.getName())) {
                            File file = new File(str2 + "/" + nextElement.getName());
                            if (nextElement.isDirectory()) {
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                            } else {
                                if (!file.exists()) {
                                    e(file);
                                }
                                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                try {
                                    BufferedOutputStream bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(file), 2048);
                                    try {
                                        byte[] bArr = new byte[2048];
                                        while (true) {
                                            int read = bufferedInputStream2.read(bArr, 0, 2048);
                                            if (read == -1) {
                                                break;
                                            }
                                            bufferedOutputStream3.write(bArr, 0, read);
                                        }
                                        a(bufferedInputStream2);
                                        a(bufferedOutputStream3);
                                        bufferedOutputStream2 = bufferedOutputStream3;
                                        bufferedInputStream = bufferedInputStream2;
                                    } catch (IOException e2) {
                                        e = e2;
                                        bufferedOutputStream = bufferedOutputStream3;
                                        bufferedInputStream = bufferedInputStream2;
                                        try {
                                            e.printStackTrace();
                                            a(bufferedOutputStream);
                                            a(bufferedInputStream);
                                            a(zipFile);
                                            System.currentTimeMillis();
                                            return e;
                                        } catch (Throwable th) {
                                            th = th;
                                            a(bufferedOutputStream);
                                            a(bufferedInputStream);
                                            a(zipFile);
                                            System.currentTimeMillis();
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedOutputStream = bufferedOutputStream3;
                                        bufferedInputStream = bufferedInputStream2;
                                        a(bufferedOutputStream);
                                        a(bufferedInputStream);
                                        a(zipFile);
                                        System.currentTimeMillis();
                                        throw th;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    bufferedOutputStream = bufferedOutputStream2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    bufferedOutputStream = bufferedOutputStream2;
                                }
                            }
                        }
                    } catch (IOException e4) {
                        e = e4;
                        bufferedOutputStream = bufferedOutputStream2;
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedOutputStream = bufferedOutputStream2;
                    }
                }
                a(bufferedOutputStream2);
                a(bufferedInputStream);
                a(zipFile);
                System.currentTimeMillis();
                return null;
            } catch (IOException e5) {
                e = e5;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = null;
            }
        } catch (IOException e6) {
            e = e6;
            zipFile = null;
            bufferedInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            zipFile = null;
            bufferedInputStream = null;
        }
    }

    public static void a(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void b(File file, File file2) {
        String[] list;
        if (file == null || file2 == null || (list = file.list()) == null || list.length == 0) {
            return;
        }
        h(file2);
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                File file3 = new File(file, str);
                File file4 = new File(file2, str);
                if (file3.isDirectory()) {
                    b(file3, file4);
                }
                if (file3.isFile()) {
                    e(file4);
                    c(file3, file4);
                }
            }
        }
    }

    public static long c(File file, File file2) {
        FileOutputStream fileOutputStream;
        long j = 0;
        if (file == null || file2 == null || !file.exists()) {
            return 0L;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    j = d(fileInputStream2, fileOutputStream);
                    a(fileInputStream2);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        a(fileInputStream);
                        a(fileOutputStream);
                        return j;
                    } catch (Throwable th) {
                        th = th;
                        a(fileInputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    a(fileInputStream);
                    a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        a(fileOutputStream);
        return j;
    }

    public static long d(InputStream inputStream, OutputStream outputStream) {
        if (inputStream != null && outputStream != null) {
            try {
                byte[] bArr = new byte[3072];
                long j = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        outputStream.write(bArr, 0, read);
                        j += read;
                    } else {
                        outputStream.flush();
                        return j;
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return 0L;
    }

    public static boolean e(File file) {
        if (file != null && !file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                return file.createNewFile();
            } catch (IOException unused) {
            }
        }
        return false;
    }

    public static boolean f(File file) {
        if (file == null) {
            return false;
        }
        boolean z = true;
        if (file.exists()) {
            if (file.isFile()) {
                return true & file.delete();
            }
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        z &= f(file2);
                    }
                }
                return z & file.delete();
            }
            return true;
        }
        return true;
    }

    public static boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return f(file);
        }
        return false;
    }

    public static boolean h(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        try {
            file.mkdirs();
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static String i(long j) {
        Float valueOf;
        String str;
        if (j <= 0) {
            return FileUtils.UNKNOW;
        }
        if (j < 1024) {
            return j + "B";
        }
        if (j < 1048576) {
            valueOf = Float.valueOf(((float) j) / 1024.0f);
            str = "KB";
        } else if (j < KsMediaMeta.AV_CH_STEREO_RIGHT) {
            valueOf = Float.valueOf(((float) j) / 1048576.0f);
            str = "MB";
        } else {
            valueOf = Float.valueOf(((float) j) / 1.0737418E9f);
            str = "GB";
        }
        DecimalFormat decimalFormat = new DecimalFormat("####.##");
        return decimalFormat.format(valueOf) + str;
    }

    @Nullable
    @CheckResult
    public static String j(@Nullable String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str) || str.endsWith(File.separator)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        int length = str.length();
        return (lastIndexOf == f49726a || length <= lastIndexOf) ? str : str.substring(lastIndexOf + f49727b, length);
    }

    public static String l(String str) {
        int lastIndexOf;
        String k = k(str);
        return (TextUtils.isEmpty(k) || (lastIndexOf = k.lastIndexOf(".")) == f49726a || lastIndexOf == k.length() + (-1)) ? "" : k.substring(lastIndexOf + 1);
    }

    public static long m(String str) {
        long j = -1;
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(str);
            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
            if (!TextUtils.isEmpty(extractMetadata)) {
                j = Long.parseLong(extractMetadata);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
        mediaMetadataRetriever.release();
        return j;
    }

    public static boolean n(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean o(String str) {
        return str.contains(Constants.PATH_PARENT);
    }

    public static boolean p(File file) {
        return file != null && file.exists() && file.isFile();
    }

    @Nullable
    public static String q(Context context, String str) {
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                inputStream = context.getAssets().open(str);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                sb.append(readLine);
                            } else {
                                String sb2 = sb.toString();
                                a(inputStream);
                                a(bufferedReader);
                                return sb2;
                            }
                        }
                    } catch (IOException unused) {
                        a(inputStream);
                        a(bufferedReader);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        a(inputStream);
                        a(bufferedReader);
                        throw th;
                    }
                } catch (IOException unused2) {
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
            } catch (IOException unused3) {
                inputStream = null;
                bufferedReader = null;
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
                inputStream = null;
            }
        }
        return null;
    }

    public static String r(File file) {
        try {
            return u(new FileInputStream(file));
        } catch (FileNotFoundException unused) {
            return "";
        }
    }

    public static List<String> s(File file) {
        try {
            return v(new FileInputStream(file));
        } catch (FileNotFoundException unused) {
            return new ArrayList();
        }
    }

    public static byte[] t(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null) {
            return null;
        }
        byte[] bArr = new byte[Long.valueOf(file.length()).intValue()];
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileInputStream.read(bArr);
                fileInputStream.close();
                a(fileInputStream);
                return bArr;
            } catch (Exception unused) {
                a(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                a(fileInputStream2);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String u(FileInputStream fileInputStream) {
        if (fileInputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    return sb.toString();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        } finally {
            a(fileInputStream);
        }
    }

    public static List<String> v(FileInputStream fileInputStream) {
        ArrayList arrayList = new ArrayList();
        try {
            if (fileInputStream == null) {
                return arrayList;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        arrayList.add(readLine);
                    } else {
                        try {
                            break;
                        } catch (IOException unused) {
                        }
                    }
                }
                fileInputStream.close();
                return arrayList;
            } catch (IOException unused2) {
                ArrayList arrayList2 = new ArrayList();
                try {
                    fileInputStream.close();
                } catch (IOException unused3) {
                }
                return arrayList2;
            }
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (IOException unused4) {
            }
            throw th;
        }
    }

    public static boolean w(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    String absolutePath = file.getAbsolutePath();
                    File file2 = new File(absolutePath);
                    long currentTimeMillis = System.currentTimeMillis();
                    File file3 = new File(absolutePath + currentTimeMillis + ".tmp");
                    if (file2.renameTo(file3)) {
                        return f(file3);
                    }
                    return f(file);
                }
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static boolean x(String str) {
        return !TextUtils.isEmpty(str) && w(new File(str));
    }

    public static boolean y(String str, File file) {
        if (TextUtils.isEmpty(str) || file.exists()) {
            return false;
        }
        z(str.getBytes(), file);
        return true;
    }

    public static void z(byte[] bArr, File file) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        B(byteArrayInputStream, file);
        a(byteArrayInputStream);
    }
}
