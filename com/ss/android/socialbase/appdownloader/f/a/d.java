package com.ss.android.socialbase.appdownloader.f.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class d {
    public InputStream a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f60000b;

    /* renamed from: c  reason: collision with root package name */
    public int f60001c;

    public d() {
    }

    public final void a(InputStream inputStream, boolean z) {
        this.a = inputStream;
        this.f60000b = z;
        this.f60001c = 0;
    }

    public final int b() throws IOException {
        return a(4);
    }

    public final void c(int i2) throws IOException {
        if (i2 > 0) {
            long j2 = i2;
            long skip = this.a.skip(j2);
            this.f60001c = (int) (this.f60001c + skip);
            if (skip != j2) {
                throw new EOFException();
            }
        }
    }

    public d(InputStream inputStream, boolean z) {
        a(inputStream, z);
    }

    public final int[] b(int i2) throws IOException {
        int[] iArr = new int[i2];
        a(iArr, 0, i2);
        return iArr;
    }

    public final void a() {
        InputStream inputStream = this.a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            a(null, false);
        }
    }

    public final void c() throws IOException {
        c(4);
    }

    public final int a(int i2) throws IOException {
        if (i2 >= 0 && i2 <= 4) {
            int i3 = 0;
            if (this.f60000b) {
                for (int i4 = (i2 - 1) * 8; i4 >= 0; i4 -= 8) {
                    int read = this.a.read();
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.f60001c++;
                    i3 |= read << i4;
                }
                return i3;
            }
            int i5 = i2 * 8;
            int i6 = 0;
            while (i3 != i5) {
                int read2 = this.a.read();
                if (read2 == -1) {
                    throw new EOFException();
                }
                this.f60001c++;
                i6 |= read2 << i3;
                i3 += 8;
            }
            return i6;
        }
        throw new IllegalArgumentException();
    }

    public final void a(int[] iArr, int i2, int i3) throws IOException {
        while (i3 > 0) {
            iArr[i2] = b();
            i3--;
            i2++;
        }
    }
}
