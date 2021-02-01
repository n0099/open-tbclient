package com.ss.android.socialbase.appdownloader.f.a;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private InputStream f13046a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f13047b;
    private int c;

    public d() {
    }

    public d(InputStream inputStream, boolean z) {
        b(inputStream, z);
    }

    public final void b(InputStream inputStream, boolean z) {
        this.f13046a = inputStream;
        this.f13047b = z;
        this.c = 0;
    }

    public final void a() {
        if (this.f13046a != null) {
            try {
                this.f13046a.close();
            } catch (IOException e) {
            }
            b(null, false);
        }
    }

    public final int b() throws IOException {
        return a(4);
    }

    public final int a(int i) throws IOException {
        int i2;
        if (i >= 0 && i <= 4) {
            if (this.f13047b) {
                i2 = 0;
                for (int i3 = (i - 1) * 8; i3 >= 0; i3 -= 8) {
                    int read = this.f13046a.read();
                    if (read == -1) {
                        throw new EOFException();
                    }
                    this.c++;
                    i2 |= read << i3;
                }
            } else {
                int i4 = i * 8;
                i2 = 0;
                for (int i5 = 0; i5 != i4; i5 += 8) {
                    int read2 = this.f13046a.read();
                    if (read2 == -1) {
                        throw new EOFException();
                    }
                    this.c++;
                    i2 |= read2 << i5;
                }
            }
            return i2;
        }
        throw new IllegalArgumentException();
    }

    public final int[] b(int i) throws IOException {
        int[] iArr = new int[i];
        d(iArr, 0, i);
        return iArr;
    }

    public final void d(int[] iArr, int i, int i2) throws IOException {
        while (i2 > 0) {
            iArr[i] = b();
            i2--;
            i++;
        }
    }

    public final void c(int i) throws IOException {
        if (i > 0) {
            long skip = this.f13046a.skip(i);
            this.c = (int) (this.c + skip);
            if (skip != i) {
                throw new EOFException();
            }
        }
    }

    public final void c() throws IOException {
        c(4);
    }
}
