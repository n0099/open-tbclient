package javassist;

import com.tencent.mm.sdk.platformtools.LVBuffer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    protected b f2853a = null;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[class path: ");
        for (b bVar = this.f2853a; bVar != null; bVar = bVar.f2745a) {
            stringBuffer.append(bVar.b.toString());
            stringBuffer.append(File.pathSeparatorChar);
        }
        stringBuffer.append(']');
        return stringBuffer.toString();
    }

    public synchronized a a(a aVar) {
        this.f2853a = new b(aVar, this.f2853a);
        return aVar;
    }

    public synchronized a b(a aVar) {
        b bVar = new b(aVar, null);
        b bVar2 = this.f2853a;
        if (bVar2 == null) {
            this.f2853a = bVar;
        } else {
            while (bVar2.f2745a != null) {
                bVar2 = bVar2.f2745a;
            }
            bVar2.f2745a = bVar;
        }
        return aVar;
    }

    public synchronized void c(a aVar) {
        b bVar = this.f2853a;
        if (bVar != null) {
            if (bVar.b == aVar) {
                this.f2853a = bVar.f2745a;
            } else {
                while (bVar.f2745a != null) {
                    if (bVar.f2745a.b == aVar) {
                        bVar.f2745a = bVar.f2745a.f2745a;
                    } else {
                        bVar = bVar.f2745a;
                    }
                }
            }
        }
        aVar.a();
    }

    public a a() {
        return b(new ClassClassPath());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, OutputStream outputStream) {
        InputStream a2 = a(str);
        if (a2 == null) {
            throw new NotFoundException(str);
        }
        try {
            a(a2, outputStream);
        } finally {
            a2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputStream a(String str) {
        InputStream inputStream;
        NotFoundException notFoundException = null;
        InputStream inputStream2 = null;
        b bVar = this.f2853a;
        while (bVar != null) {
            try {
                inputStream = bVar.b.a(str);
            } catch (NotFoundException e) {
                if (notFoundException == null) {
                    notFoundException = e;
                    inputStream = inputStream2;
                } else {
                    inputStream = inputStream2;
                }
            }
            if (inputStream == null) {
                bVar = bVar.f2745a;
                inputStream2 = inputStream;
            } else {
                return inputStream;
            }
        }
        if (notFoundException != null) {
            throw notFoundException;
        }
        return null;
    }

    public URL b(String str) {
        for (b bVar = this.f2853a; bVar != null; bVar = bVar.f2745a) {
            URL b = bVar.b.b(str);
            if (b != null) {
                return b;
            }
        }
        return null;
    }

    public static byte[] a(InputStream inputStream) {
        byte[][] bArr = new byte[8];
        int i = 4096;
        for (int i2 = 0; i2 < 8; i2++) {
            bArr[i2] = new byte[i];
            int i3 = 0;
            do {
                int read = inputStream.read(bArr[i2], i3, i - i3);
                if (read >= 0) {
                    i3 += read;
                } else {
                    byte[] bArr2 = new byte[(i - 4096) + i3];
                    int i4 = 0;
                    for (int i5 = 0; i5 < i2; i5++) {
                        System.arraycopy(bArr[i5], 0, bArr2, i4, i4 + LVBuffer.LENGTH_ALLOC_PER_NEW);
                        i4 = i4 + i4 + LVBuffer.LENGTH_ALLOC_PER_NEW;
                    }
                    System.arraycopy(bArr[i2], 0, bArr2, i4, i3);
                    return bArr2;
                }
            } while (i3 < i);
            i *= 2;
        }
        throw new IOException("too much data");
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        int i = LVBuffer.LENGTH_ALLOC_PER_NEW;
        byte[] bArr = null;
        for (int i2 = 0; i2 < 64; i2++) {
            if (i2 < 8) {
                i *= 2;
                bArr = new byte[i];
            }
            int i3 = 0;
            do {
                int read = inputStream.read(bArr, i3, i - i3);
                if (read >= 0) {
                    i3 += read;
                } else {
                    outputStream.write(bArr, 0, i3);
                    return;
                }
            } while (i3 < i);
            outputStream.write(bArr);
        }
        throw new IOException("too much data");
    }
}
