package com.kwad.sdk.utils;

import androidx.annotation.RequiresApi;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes5.dex */
public final class l {
    public static void a(File[] fileArr, String str) {
        a(fileArr, str, -1);
    }

    public static void a(File[] fileArr, String str, int i) {
        ZipOutputStream zipOutputStream;
        BufferedInputStream bufferedInputStream = null;
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
            try {
                try {
                    byte[] bArr = new byte[4096];
                    int i2 = 0;
                    while (i2 < fileArr.length) {
                        BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(fileArr[i2]), 4096);
                        try {
                            String absolutePath = fileArr[i2].getAbsolutePath();
                            zipOutputStream.putNextEntry(new ZipEntry(absolutePath.substring(absolutePath.lastIndexOf("/") + 1)));
                            while (true) {
                                int read = bufferedInputStream2.read(bArr, 0, 4096);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            bufferedInputStream2.close();
                            i2++;
                            bufferedInputStream = bufferedInputStream2;
                        } catch (Exception e) {
                            e = e;
                            bufferedInputStream = bufferedInputStream2;
                            com.kwad.sdk.core.d.b.a(e);
                            com.kwad.sdk.crash.utils.b.a(bufferedInputStream);
                            com.kwad.sdk.crash.utils.b.a(zipOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            com.kwad.sdk.crash.utils.b.a(bufferedInputStream);
                            com.kwad.sdk.crash.utils.b.a(zipOutputStream);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
            zipOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            zipOutputStream = null;
        }
        com.kwad.sdk.crash.utils.b.a(bufferedInputStream);
        com.kwad.sdk.crash.utils.b.a(zipOutputStream);
    }

    @RequiresApi(api = 19)
    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                bArr2 = byteArrayOutputStream.toByteArray();
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
            } catch (IOException e) {
                com.kwad.sdk.core.d.b.a(e);
            }
        }
        return bArr2;
    }
}
