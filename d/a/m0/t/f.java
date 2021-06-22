package d.a.m0.t;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes3.dex */
public class f {
    public static String a(byte[] bArr, String str, boolean z) {
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

    public static String b(File file, boolean z) {
        ReadableByteChannel readableByteChannel;
        ReadableByteChannel readableByteChannel2 = null;
        try {
            readableByteChannel = Channels.newChannel(new FileInputStream(file));
            try {
                String c2 = c(z, readableByteChannel);
                if (readableByteChannel != null && readableByteChannel.isOpen()) {
                    d.d(readableByteChannel);
                }
                return c2;
            } catch (IOException unused) {
                if (readableByteChannel != null && readableByteChannel.isOpen()) {
                    d.d(readableByteChannel);
                }
                return null;
            } catch (Throwable th) {
                th = th;
                readableByteChannel2 = readableByteChannel;
                if (readableByteChannel2 != null && readableByteChannel2.isOpen()) {
                    d.d(readableByteChannel2);
                }
                throw th;
            }
        } catch (IOException unused2) {
            readableByteChannel = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String c(boolean z, ReadableByteChannel readableByteChannel) throws IOException {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            ByteBuffer allocate = ByteBuffer.allocate(8192);
            while (readableByteChannel.read(allocate) != -1) {
                allocate.flip();
                messageDigest.update(allocate);
                allocate.clear();
            }
            return a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String d(byte[] bArr, boolean z) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return a(messageDigest.digest(), "", z);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }
}
