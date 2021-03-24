package com.facebook.common.util;

import com.facebook.common.internal.ByteStreams;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class StreamUtil {
    public static byte[] getBytesFromStream(InputStream inputStream) throws IOException {
        return getBytesFromStream(inputStream, inputStream.available());
    }

    public static long skip(InputStream inputStream, long j) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkArgument(j >= 0);
        long j2 = j;
        while (j2 > 0) {
            long skip = inputStream.skip(j2);
            if (skip <= 0) {
                if (inputStream.read() == -1) {
                    return j - j2;
                }
                skip = 1;
            }
            j2 -= skip;
        }
        return j;
    }

    public static byte[] getBytesFromStream(InputStream inputStream, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i) { // from class: com.facebook.common.util.StreamUtil.1
            @Override // java.io.ByteArrayOutputStream
            public byte[] toByteArray() {
                int i2 = ((ByteArrayOutputStream) this).count;
                byte[] bArr = ((ByteArrayOutputStream) this).buf;
                return i2 == bArr.length ? bArr : super.toByteArray();
            }
        };
        ByteStreams.copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
