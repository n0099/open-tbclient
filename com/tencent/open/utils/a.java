package com.tencent.open.utils;

import com.baidu.mapsdkplatform.comapi.map.r;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final k f39678a = new k(101010256);

    /* renamed from: b  reason: collision with root package name */
    public static final l f39679b = new l(38651);

    /* renamed from: com.tencent.open.utils.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0537a {

        /* renamed from: a  reason: collision with root package name */
        public Properties f39680a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f39681b;

        public C0537a() {
            this.f39680a = new Properties();
        }

        public void a(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = a.f39679b.a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (a.f39679b.equals(new l(bArr2))) {
                if (bArr.length - length <= 2) {
                    return;
                }
                byte[] bArr3 = new byte[2];
                wrap.get(bArr3);
                int b2 = new l(bArr3).b();
                if ((bArr.length - length) - 2 < b2) {
                    return;
                }
                byte[] bArr4 = new byte[b2];
                wrap.get(bArr4);
                this.f39680a.load(new ByteArrayInputStream(bArr4));
                int length2 = ((bArr.length - length) - b2) - 2;
                if (length2 > 0) {
                    byte[] bArr5 = new byte[length2];
                    this.f39681b = bArr5;
                    wrap.get(bArr5);
                    return;
                }
                return;
            }
            throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.f39680a + ", otherData=" + Arrays.toString(this.f39681b) + "]";
        }
    }

    public static String a(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, r.f7699a);
            try {
                byte[] a2 = a(randomAccessFile2);
                if (a2 == null) {
                    randomAccessFile2.close();
                    return null;
                }
                C0537a c0537a = new C0537a();
                c0537a.a(a2);
                String property = c0537a.f39680a.getProperty(str);
                randomAccessFile2.close();
                return property;
            } catch (Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String a(File file) throws IOException {
        return a(file, "channelNo");
    }

    public static byte[] a(RandomAccessFile randomAccessFile) throws IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a2 = f39678a.a();
        int read = randomAccessFile.read();
        while (true) {
            z = true;
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
        if (z) {
            randomAccessFile.seek(length + 16 + 4);
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
        throw new ZipException("archive is not a ZIP archive");
    }
}
