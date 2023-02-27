package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
@Nullsafe(Nullsafe.Mode.STRICT)
/* loaded from: classes7.dex */
public class Files {
    public static byte[] readFile(InputStream inputStream, long j) throws IOException {
        if (j <= 2147483647L) {
            if (j == 0) {
                return ByteStreams.toByteArray(inputStream);
            }
            return ByteStreams.toByteArray(inputStream, (int) j);
        }
        throw new OutOfMemoryError("file is too large to fit in a byte array: " + j + " bytes");
    }

    public static byte[] toByteArray(File file) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] readFile = readFile(fileInputStream2, fileInputStream2.getChannel().size());
                fileInputStream2.close();
                return readFile;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
