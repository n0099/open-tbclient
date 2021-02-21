package com.tencent.open.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;
/* loaded from: classes15.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final k f13424a = new k(101010256);

    /* renamed from: b  reason: collision with root package name */
    private static final l f13425b = new l(38651);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.tencent.open.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C1273a {

        /* renamed from: a  reason: collision with root package name */
        Properties f13426a;

        /* renamed from: b  reason: collision with root package name */
        byte[] f13427b;

        private C1273a() {
            this.f13426a = new Properties();
        }

        void a(byte[] bArr) throws IOException {
            if (bArr != null) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                int length = a.f13425b.a().length;
                byte[] bArr2 = new byte[length];
                wrap.get(bArr2);
                if (!a.f13425b.equals(new l(bArr2))) {
                    throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
                }
                if (bArr.length - length > 2) {
                    byte[] bArr3 = new byte[2];
                    wrap.get(bArr3);
                    int b2 = new l(bArr3).b();
                    if ((bArr.length - length) - 2 >= b2) {
                        byte[] bArr4 = new byte[b2];
                        wrap.get(bArr4);
                        this.f13426a.load(new ByteArrayInputStream(bArr4));
                        int length2 = ((bArr.length - length) - b2) - 2;
                        if (length2 > 0) {
                            this.f13427b = new byte[length2];
                            wrap.get(this.f13427b);
                        }
                    }
                }
            }
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.f13426a + ", otherData=" + Arrays.toString(this.f13427b) + "]";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [146=4] */
    public static String a(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        String str2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                byte[] a2 = a(randomAccessFile);
                if (a2 != null) {
                    C1273a c1273a = new C1273a();
                    c1273a.a(a2);
                    str2 = c1273a.f13426a.getProperty(str);
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                } else if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                return str2;
            } catch (Throwable th) {
                th = th;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static String a(File file) throws IOException {
        return a(file, "channelNo");
    }

    private static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        boolean z = true;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a2 = f13424a.a();
        int read = randomAccessFile.read();
        while (true) {
            if (read == -1) {
                z = false;
                break;
            } else if (read == a2[0] && randomAccessFile.read() == a2[1] && randomAccessFile.read() == a2[2] && randomAccessFile.read() == a2[3]) {
                break;
            } else {
                length--;
                randomAccessFile.seek(length);
                read = randomAccessFile.read();
            }
        }
        if (!z) {
            throw new ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek(16 + length + 4);
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        int b2 = new l(bArr).b();
        if (b2 == 0) {
            return null;
        }
        byte[] bArr2 = new byte[b2];
        randomAccessFile.read(bArr2);
        return bArr2;
    }
}
