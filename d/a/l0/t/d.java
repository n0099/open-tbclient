package d.a.l0.t;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.AtomicFile;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.retrieve.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f48490a = m();

    /* renamed from: b  reason: collision with root package name */
    public static int f48491b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static int f48492c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static int f48493d;

    public static boolean A(String str, String str2) {
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                if (!z(entries.nextElement(), str2)) {
                    zipFile.close();
                    return false;
                }
            }
            zipFile.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @NonNull
    public static File[] B(@Nullable File file) {
        if (file == null || !file.exists()) {
            return new File[0];
        }
        File[] listFiles = file.listFiles();
        return listFiles == null ? new File[0] : listFiles;
    }

    @Nullable
    public static String C(Context context, String str) {
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
                                d(inputStream);
                                d(bufferedReader);
                                return sb2;
                            }
                        }
                    } catch (IOException unused) {
                        d(inputStream);
                        d(bufferedReader);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        d(inputStream);
                        d(bufferedReader);
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

    public static String D(File file) {
        try {
            return G(new FileInputStream(file));
        } catch (FileNotFoundException unused) {
            return "";
        }
    }

    public static List<String> E(File file) {
        try {
            return H(new FileInputStream(file));
        } catch (FileNotFoundException unused) {
            return new ArrayList();
        }
    }

    public static byte[] F(File file) {
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
                d(fileInputStream);
                return bArr;
            } catch (Exception unused) {
                d(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                d(fileInputStream2);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String G(FileInputStream fileInputStream) {
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
            d(fileInputStream);
        }
    }

    public static List<String> H(FileInputStream fileInputStream) {
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

    public static String I(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    String absolutePath = file.getAbsolutePath();
                    File file2 = new File(absolutePath);
                    long currentTimeMillis = System.currentTimeMillis();
                    File file3 = new File(absolutePath + currentTimeMillis + ".tmp");
                    if (file2.renameTo(file3)) {
                        return file3.getAbsolutePath();
                    }
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String J(String str) {
        return TextUtils.isEmpty(str) ? "" : I(new File(str));
    }

    public static boolean K(File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    String absolutePath = file.getAbsolutePath();
                    File file2 = new File(absolutePath);
                    long currentTimeMillis = System.currentTimeMillis();
                    File file3 = new File(absolutePath + currentTimeMillis + ".tmp");
                    if (file2.renameTo(file3)) {
                        return i(file3);
                    }
                    return i(file);
                }
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static boolean L(String str) {
        return !TextUtils.isEmpty(str) && K(new File(str));
    }

    public static boolean M(String str, File file) {
        if (TextUtils.isEmpty(str) || file.exists()) {
            return false;
        }
        N(str.getBytes(), file);
        return true;
    }

    public static void N(byte[] bArr, File file) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        P(byteArrayInputStream, file);
        d(byteArrayInputStream);
    }

    public static void O(@NonNull List<String> list, @NonNull File file) {
        FileChannel fileChannel;
        FileLock fileLock;
        FileOutputStream fileOutputStream;
        AtomicFile atomicFile;
        if (!file.exists()) {
            return;
        }
        FileLock fileLock2 = null;
        fileLock2 = null;
        fileLock2 = null;
        AtomicFile atomicFile2 = null;
        try {
            try {
                try {
                    atomicFile = new AtomicFile(file);
                    try {
                        atomicFile.startWrite();
                        fileOutputStream = atomicFile.startWrite();
                        try {
                            fileChannel = fileOutputStream.getChannel();
                        } catch (IOException unused) {
                            fileLock = null;
                            fileChannel = null;
                        }
                    } catch (IOException unused2) {
                        fileLock = null;
                        fileOutputStream = null;
                        fileChannel = null;
                    }
                } catch (IOException unused3) {
                    fileLock = null;
                    fileOutputStream = null;
                    fileChannel = null;
                }
            } catch (Throwable th) {
                th = th;
                fileChannel = null;
            }
            try {
                fileLock2 = fileChannel.lock();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    fileOutputStream.write(list.get(i2).getBytes());
                    if (i2 != list.size() - 1) {
                        fileOutputStream.write("\n".getBytes());
                    }
                }
                atomicFile.finishWrite(fileOutputStream);
            } catch (IOException unused4) {
                fileLock = fileLock2;
                atomicFile2 = atomicFile;
                if (atomicFile2 != null) {
                    try {
                        atomicFile2.failWrite(fileOutputStream);
                    } catch (Throwable th2) {
                        fileLock2 = fileLock;
                        th = th2;
                        if (fileLock2 != null && fileChannel != null) {
                            try {
                                fileLock2.release();
                                fileChannel.close();
                            } catch (IOException unused5) {
                            }
                        }
                        throw th;
                    }
                }
                if (fileLock == null || fileChannel == null) {
                    return;
                }
                fileLock.release();
                fileChannel.close();
            } catch (Throwable th3) {
                th = th3;
                if (fileLock2 != null) {
                    fileLock2.release();
                    fileChannel.close();
                }
                throw th;
            }
            if (fileLock2 == null || fileChannel == null) {
                return;
            }
            fileLock2.release();
            fileChannel.close();
        } catch (IOException unused6) {
        }
    }

    public static void P(InputStream inputStream, File file) {
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
            g(inputStream, fileOutputStream);
            d(fileOutputStream);
        } catch (FileNotFoundException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            d(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d(fileOutputStream2);
            throw th;
        }
    }

    public static void Q(InputStream inputStream, File file, boolean z) {
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
            g(inputStream, fileOutputStream);
            d(fileOutputStream);
        } catch (FileNotFoundException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            e.printStackTrace();
            d(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d(fileOutputStream2);
            throw th;
        }
    }

    public static void R(String str, File file, boolean z) {
        Q(new ByteArrayInputStream(str.getBytes()), file, z);
    }

    public static String S(byte[] bArr, String str, boolean z) {
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

    public static boolean T(String str, String str2) {
        return V(str, str2) == null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: java.io.BufferedOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean U(String str, String str2) {
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
                        byte[] bArr = new byte[o()];
                        while (true) {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry != null) {
                                if (!TextUtils.isEmpty(nextEntry.getName()) && !w(nextEntry.getName())) {
                                    File file2 = new File(str2 + File.separator + nextEntry.getName());
                                    if (nextEntry.isDirectory()) {
                                        if (!file2.exists()) {
                                            file2.mkdir();
                                        }
                                    } else if (file2.exists()) {
                                        continue;
                                    } else {
                                        h(file2);
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
                                                    d(inputStream);
                                                    throw th;
                                                }
                                            }
                                            d(bufferedOutputStream);
                                            inputStream = bufferedOutputStream;
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                    }
                                }
                            } else {
                                d(open);
                                d(zipInputStream);
                                return true;
                            }
                        }
                    } catch (IOException unused) {
                        inputStream = open;
                        d(inputStream);
                        d(zipInputStream);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = open;
                        d(inputStream);
                        d(zipInputStream);
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

    public static Exception V(String str, String str2) {
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
                        if (!TextUtils.isEmpty(nextElement.getName()) && !w(nextElement.getName())) {
                            File file = new File(str2 + "/" + nextElement.getName());
                            if (nextElement.isDirectory()) {
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                            } else {
                                if (!file.exists()) {
                                    h(file);
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
                                        d(bufferedInputStream2);
                                        d(bufferedOutputStream3);
                                        bufferedOutputStream2 = bufferedOutputStream3;
                                        bufferedInputStream = bufferedInputStream2;
                                    } catch (IOException e2) {
                                        e = e2;
                                        bufferedOutputStream = bufferedOutputStream3;
                                        bufferedInputStream = bufferedInputStream2;
                                        try {
                                            e.printStackTrace();
                                            d(bufferedOutputStream);
                                            d(bufferedInputStream);
                                            d(zipFile);
                                            System.currentTimeMillis();
                                            return e;
                                        } catch (Throwable th) {
                                            th = th;
                                            d(bufferedOutputStream);
                                            d(bufferedInputStream);
                                            d(zipFile);
                                            System.currentTimeMillis();
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        bufferedOutputStream = bufferedOutputStream3;
                                        bufferedInputStream = bufferedInputStream2;
                                        d(bufferedOutputStream);
                                        d(bufferedInputStream);
                                        d(zipFile);
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
                d(bufferedOutputStream2);
                d(bufferedInputStream);
                d(zipFile);
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

    public static boolean W(String str, String str2) {
        File file;
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                File file2 = new File(str2);
                file = new File(str);
                zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (file.isFile()) {
                X(zipOutputStream, file, "");
            } else {
                for (File file3 : file.listFiles()) {
                    X(zipOutputStream, file3, "");
                }
            }
            d(zipOutputStream);
            return true;
        } catch (Exception e3) {
            e = e3;
            zipOutputStream2 = zipOutputStream;
            e.printStackTrace();
            d(zipOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            d(zipOutputStream2);
            throw th;
        }
    }

    public static void X(ZipOutputStream zipOutputStream, File file, String str) {
        File[] listFiles;
        FileInputStream fileInputStream = null;
        try {
            try {
                if (!file.isDirectory()) {
                    byte[] bArr = new byte[4096];
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, read);
                        }
                        zipOutputStream.closeEntry();
                        fileInputStream = fileInputStream2;
                    } catch (Exception e2) {
                        e = e2;
                        fileInputStream = fileInputStream2;
                        e.printStackTrace();
                        d(fileInputStream);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        d(fileInputStream);
                        throw th;
                    }
                } else {
                    for (File file2 : file.listFiles()) {
                        X(zipOutputStream, file2, str + file.getName() + File.separator);
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
            d(fileInputStream);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static long a(@Nullable File file) {
        long j = 0;
        if (file != null && file.exists()) {
            if (file.isFile()) {
                return file.length();
            }
            Stack stack = new Stack();
            stack.push(file);
            while (!stack.isEmpty()) {
                File file2 = (File) stack.pop();
                if (file2 != null) {
                    if (file2.isDirectory()) {
                        File[] listFiles = file2.listFiles();
                        if (listFiles != null && listFiles.length > 0) {
                            Collections.addAll(stack, listFiles);
                        }
                    } else {
                        j += file2.length();
                    }
                }
            }
        }
        return j;
    }

    public static long b(@NonNull File file, @NonNull String str, @Nullable String str2) {
        File[] B;
        long j = 0;
        for (File file2 : B(file)) {
            String name = file2.getName();
            if (name.startsWith(str) && str2 != null && !name.startsWith(str2)) {
                j += a(file2);
            }
        }
        return j;
    }

    public static long c(@Nullable File file, @NonNull Set<String> set) {
        File[] B;
        long j = 0;
        for (File file2 : B(file)) {
            if (set.contains(file2.getName())) {
                j += a(file2);
            }
        }
        return j;
    }

    public static void d(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void e(File file, File file2) {
        String[] list;
        if (file == null || file2 == null || (list = file.list()) == null || list.length == 0) {
            return;
        }
        k(file2);
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                File file3 = new File(file, str);
                File file4 = new File(file2, str);
                if (file3.isDirectory()) {
                    e(file3, file4);
                }
                if (file3.isFile()) {
                    h(file4);
                    f(file3, file4);
                }
            }
        }
    }

    public static long f(File file, File file2) {
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
                    j = g(fileInputStream2, fileOutputStream);
                    d(fileInputStream2);
                } catch (Exception e2) {
                    e = e2;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        d(fileInputStream);
                        d(fileOutputStream);
                        return j;
                    } catch (Throwable th) {
                        th = th;
                        d(fileInputStream);
                        d(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    d(fileInputStream);
                    d(fileOutputStream);
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
        d(fileOutputStream);
        return j;
    }

    public static long g(InputStream inputStream, OutputStream outputStream) {
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

    public static boolean h(File file) {
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

    public static boolean i(File file) {
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
                        z &= i(file2);
                    }
                }
                return z & file.delete();
            }
            return true;
        }
        return true;
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return i(file);
        }
        return false;
    }

    public static boolean k(File file) {
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

    public static String l(long j) {
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
        } else if (j < 1073741824) {
            valueOf = Float.valueOf(((float) j) / 1048576.0f);
            str = "MB";
        } else {
            valueOf = Float.valueOf(((float) j) / 1.0737418E9f);
            str = "GB";
        }
        DecimalFormat decimalFormat = new DecimalFormat("####.##");
        return decimalFormat.format(valueOf) + str;
    }

    public static String m() {
        if (TextUtils.isEmpty(f48490a)) {
            f48490a = n(AppRuntime.getAppContext());
        }
        return f48490a;
    }

    @SuppressLint({"NewApi", "ObsoleteSdkInt"})
    public static String n(Context context) {
        File externalCacheDir = Build.VERSION.SDK_INT >= 8 ? context.getExternalCacheDir() : null;
        if (externalCacheDir == null && v()) {
            externalCacheDir = Environment.getExternalStorageDirectory();
        }
        if (externalCacheDir == null) {
            externalCacheDir = context.getCacheDir();
        }
        if (externalCacheDir == null) {
            externalCacheDir = context.getFilesDir();
        }
        if (externalCacheDir != null) {
            return externalCacheDir.getAbsolutePath();
        }
        return null;
    }

    public static int o() {
        int i2 = f48493d;
        if (i2 > 0) {
            return i2;
        }
        try {
            f48493d = new StatFs("/data").getBlockSize();
        } catch (IllegalArgumentException unused) {
        }
        if (f48493d <= 0) {
            f48493d = 8192;
        }
        return f48493d;
    }

    @Nullable
    @CheckResult
    public static String p(@Nullable String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length() - 1) {
            return null;
        }
        return str.substring(lastIndexOf + 1);
    }

    public static String q(String str) {
        if (TextUtils.isEmpty(str) || str.endsWith(File.separator)) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        int length = str.length();
        return (lastIndexOf == f48491b || length <= lastIndexOf) ? str : str.substring(lastIndexOf + f48492c, length);
    }

    public static String r(String str) {
        int lastIndexOf;
        return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length()) ? str : str.substring(0, lastIndexOf);
    }

    public static String s(String str) {
        int lastIndexOf;
        String q = q(str);
        return (TextUtils.isEmpty(q) || (lastIndexOf = q.lastIndexOf(".")) == f48491b || lastIndexOf == q.length() + (-1)) ? "" : q.substring(lastIndexOf + 1);
    }

    public static long t(String str) {
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

    public static boolean u(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static boolean v() {
        if (!TextUtils.equals("mounted", Environment.getExternalStorageState()) || TextUtils.isEmpty(f48490a)) {
            return false;
        }
        try {
            File file = new File(f48490a, ".696E5309-E4A7-27C0-A787-0B2CEBF1F1AB");
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean w(String str) {
        return str.contains(Constants.PATH_PARENT);
    }

    public static boolean x(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean y(String str, String str2) {
        ZipEntry nextEntry;
        try {
            ZipInputStream zipInputStream = new ZipInputStream(AppRuntime.getAppContext().getAssets().open(str));
            do {
                nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    return true;
                }
            } while (z(nextEntry, str2));
            zipInputStream.close();
            return false;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean z(ZipEntry zipEntry, String str) {
        String name = zipEntry.getName();
        if (TextUtils.isEmpty(name) || w(name)) {
            return true;
        }
        File file = new File(str, name);
        if (zipEntry.isDirectory()) {
            return file.isDirectory();
        }
        return file.isFile() && file.length() == zipEntry.getSize();
    }
}
