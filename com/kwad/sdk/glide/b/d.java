package com.kwad.sdk.glide.b;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.baidu.appsearch.update.patchupdate.GDiffPatcher;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class d {
    private ByteBuffer b;
    private c c;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f6583a = new byte[256];
    private int d = 0;

    private void a(int i) {
        boolean z = false;
        while (!z && !o() && this.c.c <= i) {
            switch (m()) {
                case 33:
                    switch (m()) {
                        case 1:
                            k();
                            continue;
                        case 249:
                            this.c.d = new b();
                            e();
                            continue;
                        case GDiffPatcher.COPY_INT_INT /* 254 */:
                            k();
                            continue;
                        case 255:
                            l();
                            StringBuilder sb = new StringBuilder();
                            for (int i2 = 0; i2 < 11; i2++) {
                                sb.append((char) this.f6583a[i2]);
                            }
                            if (sb.toString().equals("NETSCAPE2.0")) {
                                g();
                                break;
                            } else {
                                k();
                                continue;
                            }
                        default:
                            k();
                            continue;
                    }
                case 44:
                    if (this.c.d == null) {
                        this.c.d = new b();
                    }
                    f();
                    break;
                case 59:
                    z = true;
                    break;
                default:
                    this.c.b = 1;
                    break;
            }
        }
    }

    @Nullable
    private int[] b(int i) {
        int[] iArr = null;
        byte[] bArr = new byte[i * 3];
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i3 < i) {
                int i4 = i2 + 1;
                int i5 = bArr[i2] & 255;
                int i6 = i4 + 1;
                int i7 = bArr[i4] & 255;
                i2 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = (i5 << 16) | ViewCompat.MEASURED_STATE_MASK | (i7 << 8) | (bArr[i6] & 255);
                i3 = i8;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.c.b = 1;
        }
        return iArr;
    }

    private void c() {
        this.b = null;
        Arrays.fill(this.f6583a, (byte) 0);
        this.c = new c();
        this.d = 0;
    }

    private void d() {
        a(Integer.MAX_VALUE);
    }

    private void e() {
        m();
        int m = m();
        this.c.d.g = (m & 28) >> 2;
        if (this.c.d.g == 0) {
            this.c.d.g = 1;
        }
        this.c.d.f = (m & 1) != 0;
        int n = n();
        if (n < 2) {
            n = 10;
        }
        this.c.d.i = n * 10;
        this.c.d.h = m();
        m();
    }

    private void f() {
        this.c.d.f6581a = n();
        this.c.d.b = n();
        this.c.d.c = n();
        this.c.d.d = n();
        int m = m();
        boolean z = (m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (m & 7) + 1);
        this.c.d.e = (m & 64) != 0;
        if (z) {
            this.c.d.k = b(pow);
        } else {
            this.c.d.k = null;
        }
        this.c.d.j = this.b.position();
        j();
        if (o()) {
            return;
        }
        this.c.c++;
        this.c.e.add(this.c.d);
    }

    private void g() {
        do {
            l();
            if (this.f6583a[0] == 1) {
                this.c.m = (this.f6583a[1] & 255) | ((this.f6583a[2] & 255) << 8);
            }
            if (this.d <= 0) {
                return;
            }
        } while (!o());
    }

    private void h() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) m());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        i();
        if (!this.c.h || o()) {
            return;
        }
        this.c.f6582a = b(this.c.i);
        this.c.l = this.c.f6582a[this.c.j];
    }

    private void i() {
        this.c.f = n();
        this.c.g = n();
        int m = m();
        this.c.h = (m & 128) != 0;
        this.c.i = (int) Math.pow(2.0d, (m & 7) + 1);
        this.c.j = m();
        this.c.k = m();
    }

    private void j() {
        m();
        k();
    }

    private void k() {
        int m;
        do {
            m = m();
            this.b.position(Math.min(this.b.position() + m, this.b.limit()));
        } while (m > 0);
    }

    private void l() {
        int i;
        int i2 = 0;
        this.d = m();
        if (this.d <= 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            try {
                i = i2;
                if (i >= this.d) {
                    return;
                }
                i3 = this.d - i;
                this.b.get(this.f6583a, i, i3);
                i2 = i + i3;
            } catch (Exception e) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i3 + " blockSize: " + this.d, e);
                }
                this.c.b = 1;
                return;
            }
        }
    }

    private int m() {
        try {
            return this.b.get() & 255;
        } catch (Exception e) {
            this.c.b = 1;
            return 0;
        }
    }

    private int n() {
        return this.b.getShort();
    }

    private boolean o() {
        return this.c.b != 0;
    }

    public d a(@NonNull ByteBuffer byteBuffer) {
        c();
        this.b = byteBuffer.asReadOnlyBuffer();
        this.b.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public void a() {
        this.b = null;
        this.c = null;
    }

    @NonNull
    public c b() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (o()) {
            return this.c;
        }
        h();
        if (!o()) {
            d();
            if (this.c.c < 0) {
                this.c.b = 1;
            }
        }
        return this.c;
    }
}
