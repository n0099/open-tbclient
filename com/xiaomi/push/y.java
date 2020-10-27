package com.xiaomi.push;

import android.text.TextUtils;
import com.baidu.android.util.media.WebpUtils;
import com.baidu.down.request.db.DownloadDataConstants;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes12.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f5127a = {"jpg", "png", "bmp", "gif", WebpUtils.TYPE_IMG_WEBP};

    public static String a(File file) {
        InputStreamReader inputStreamReader;
        Throwable th;
        String str = null;
        StringWriter stringWriter = new StringWriter();
        try {
            inputStreamReader = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)));
            try {
                try {
                    char[] cArr = new char[2048];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read == -1) {
                            break;
                        }
                        stringWriter.write(cArr, 0, read);
                    }
                    str = stringWriter.toString();
                    a(inputStreamReader);
                    a(stringWriter);
                } catch (IOException e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.c("read file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    a(inputStreamReader);
                    a(stringWriter);
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                a(inputStreamReader);
                a(stringWriter);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStreamReader = null;
        } catch (Throwable th3) {
            inputStreamReader = null;
            th = th3;
            a(inputStreamReader);
            a(stringWriter);
            throw th;
        }
        return str;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m589a(File file) {
        if (!file.isDirectory()) {
            if (file.exists()) {
                file.delete();
                return;
            }
            return;
        }
        for (File file2 : file.listFiles()) {
            m589a(file2);
        }
        file.delete();
    }

    public static void a(File file, File file2) {
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(file, false));
                zipOutputStream2 = null;
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            zipOutputStream = null;
        } catch (IOException e2) {
            e = e2;
        }
        try {
            a(zipOutputStream, file2, null, null);
            a(zipOutputStream);
        } catch (FileNotFoundException e3) {
            a(zipOutputStream);
        } catch (IOException e4) {
            zipOutputStream2 = zipOutputStream;
            e = e4;
            com.xiaomi.channel.commonutils.logger.b.m54a("zip file failure + " + e.getMessage());
            a(zipOutputStream2);
        } catch (Throwable th2) {
            zipOutputStream2 = zipOutputStream;
            th = th2;
            a(zipOutputStream2);
            throw th;
        }
    }

    public static void a(File file, String str) {
        BufferedWriter bufferedWriter;
        if (!file.exists()) {
            com.xiaomi.channel.commonutils.logger.b.c("mkdir " + file.getAbsolutePath());
            file.getParentFile().mkdirs();
        }
        try {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            try {
                try {
                    bufferedWriter.write(str);
                    a(bufferedWriter);
                } catch (IOException e) {
                    e = e;
                    com.xiaomi.channel.commonutils.logger.b.c("write file :" + file.getAbsolutePath() + " failure :" + e.getMessage());
                    a(bufferedWriter);
                }
            } catch (Throwable th) {
                th = th;
                a(bufferedWriter);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            bufferedWriter = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = null;
            a(bufferedWriter);
            throw th;
        }
    }

    public static void a(ZipOutputStream zipOutputStream, File file, String str, FileFilter fileFilter) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (str == null) {
            str = "";
        }
        try {
            try {
                if (file.isDirectory()) {
                    File[] listFiles = fileFilter != null ? file.listFiles(fileFilter) : file.listFiles();
                    zipOutputStream.putNextEntry(new ZipEntry(str + File.separator));
                    String str2 = TextUtils.isEmpty(str) ? "" : str + File.separator;
                    for (int i = 0; i < listFiles.length; i++) {
                        a(zipOutputStream, listFiles[i], str2 + listFiles[i].getName(), null);
                    }
                    File[] listFiles2 = file.listFiles(new z());
                    if (listFiles2 != null) {
                        for (File file2 : listFiles2) {
                            a(zipOutputStream, file2, str2 + File.separator + file2.getName(), fileFilter);
                        }
                    }
                    fileInputStream = null;
                } else {
                    if (TextUtils.isEmpty(str)) {
                        zipOutputStream.putNextEntry(new ZipEntry(String.valueOf(new Date().getTime()) + DownloadDataConstants.DEFAULT_DL_TEXT_EXTENSION));
                    } else {
                        zipOutputStream.putNextEntry(new ZipEntry(str));
                    }
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            zipOutputStream.write(bArr, 0, read);
                        }
                    } catch (IOException e) {
                        fileInputStream2 = fileInputStream;
                        e = e;
                        com.xiaomi.channel.commonutils.logger.b.d("zipFiction failed with exception:" + e.toString());
                        a(fileInputStream2);
                        return;
                    } catch (Throwable th) {
                        fileInputStream2 = fileInputStream;
                        th = th;
                        a(fileInputStream2);
                        throw th;
                    }
                }
                a(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m590a(File file) {
        try {
            if (file.isDirectory()) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            File parentFile = file.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                return file.createNewFile();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static byte[] a(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            return bArr;
        }
    }

    public static void b(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read < 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }
}
