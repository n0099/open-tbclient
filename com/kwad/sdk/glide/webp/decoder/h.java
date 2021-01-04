package com.kwad.sdk.glide.webp.decoder;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
class h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, int i2, int i3, int i4) {
        int min = Math.min(i2 / i4, i / i3);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("Utils", 2) && max > 1) {
            Log.v("Utils", "Downsampling WEBP, sampleSize: " + max + ", target dimens: [" + i3 + "x" + i4 + "], actual dimens: [" + i + "x" + i2 + "]");
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e) {
            if (Log.isLoggable("Utils", 5)) {
                Log.w("Utils", "Error reading data from stream", e);
            }
            return null;
        }
    }
}
