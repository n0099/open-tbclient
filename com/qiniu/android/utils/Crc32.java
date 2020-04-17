package com.qiniu.android.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;
/* loaded from: classes5.dex */
public final class Crc32 {
    public static long t(byte[] bArr, int i, int i2) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr, i, i2);
        return crc32.getValue();
    }

    public static long ak(byte[] bArr) {
        return t(bArr, 0, bArr.length);
    }

    public static long ai(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[65536];
        CRC32 crc32 = new CRC32();
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                crc32.update(bArr, 0, read);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                fileInputStream.close();
            }
        }
        return crc32.getValue();
    }
}
