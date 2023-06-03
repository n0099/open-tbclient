package org.chromium.base;

import android.annotation.SuppressLint;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.SecureRandom;
@SuppressLint({"SecureRandom"})
/* loaded from: classes2.dex */
public class SecureRandomInitializer {
    public static final int NUM_RANDOM_BYTES = 16;

    public static void initialize(SecureRandom secureRandom) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/dev/urandom");
        try {
            byte[] bArr = new byte[16];
            if (fileInputStream.read(bArr) == 16) {
                secureRandom.setSeed(bArr);
                fileInputStream.close();
                return;
            }
            throw new IOException("Failed to get enough random data.");
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
