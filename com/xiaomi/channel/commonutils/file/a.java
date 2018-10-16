package com.xiaomi.channel.commonutils.file;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.canvas.model.CanvasToTempFileModel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Date;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes3.dex */
public class a {
    public static final String[] a = {CanvasToTempFileModel.IMAGE_EXT_JPG, CanvasToTempFileModel.IMAGE_EXT_PNG, "bmp", "gif", "webp"};

    public static void a(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor != null) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e) {
            }
        }
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
            com.xiaomi.channel.commonutils.logger.b.a("zip file failure + " + e.getMessage());
            a(zipOutputStream2);
        } catch (Throwable th2) {
            zipOutputStream2 = zipOutputStream;
            th = th2;
            a(zipOutputStream2);
            throw th;
        }
    }

    public static void a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
            }
        }
    }

    public static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (IOException e) {
            }
            try {
                outputStream.close();
            } catch (IOException e2) {
            }
        }
    }

    public static void a(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
            }
        }
    }

    public static void a(Writer writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
            }
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
                    File[] listFiles2 = file.listFiles(new b());
                    if (listFiles2 != null) {
                        for (File file2 : listFiles2) {
                            a(zipOutputStream, file2, str2 + File.separator + file2.getName(), fileFilter);
                        }
                    }
                    fileInputStream = null;
                } else {
                    if (TextUtils.isEmpty(str)) {
                        zipOutputStream.putNextEntry(new ZipEntry(String.valueOf(new Date().getTime()) + ".txt"));
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

    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                int read = inputStream.read(bArr, 0, 8192);
                if (read <= 0) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                a(inputStream);
                a(byteArrayOutputStream);
            }
        }
    }
}
