package com.kwad.sdk.glide.b;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f35461b;

    /* renamed from: c  reason: collision with root package name */
    public c f35462c;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f35460a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    public int f35463d = 0;

    private void a(int i) {
        boolean z = false;
        while (!z && !o() && this.f35462c.f35454c <= i) {
            int m = m();
            if (m == 33) {
                int m2 = m();
                if (m2 != 1) {
                    if (m2 == 249) {
                        this.f35462c.f35455d = new b();
                        e();
                    } else if (m2 != 254 && m2 == 255) {
                        l();
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < 11; i2++) {
                            sb.append((char) this.f35460a[i2]);
                        }
                        if (sb.toString().equals("NETSCAPE2.0")) {
                            g();
                        }
                    }
                }
                k();
            } else if (m == 44) {
                c cVar = this.f35462c;
                if (cVar.f35455d == null) {
                    cVar.f35455d = new b();
                }
                f();
            } else if (m != 59) {
                this.f35462c.f35453b = 1;
            } else {
                z = true;
            }
        }
    }

    @Nullable
    private int[] b(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.f35461b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable(GifHeaderParser.TAG, 3)) {
                Log.d(GifHeaderParser.TAG, "Format Error Reading Color Table", e2);
            }
            this.f35462c.f35453b = 1;
        }
        return iArr;
    }

    private void c() {
        this.f35461b = null;
        Arrays.fill(this.f35460a, (byte) 0);
        this.f35462c = new c();
        this.f35463d = 0;
    }

    private void d() {
        a(Integer.MAX_VALUE);
    }

    private void e() {
        m();
        int m = m();
        b bVar = this.f35462c.f35455d;
        int i = (m & 28) >> 2;
        bVar.f35450g = i;
        if (i == 0) {
            bVar.f35450g = 1;
        }
        this.f35462c.f35455d.f35449f = (m & 1) != 0;
        int n = n();
        if (n < 2) {
            n = 10;
        }
        b bVar2 = this.f35462c.f35455d;
        bVar2.i = n * 10;
        bVar2.f35451h = m();
        m();
    }

    private void f() {
        this.f35462c.f35455d.f35444a = n();
        this.f35462c.f35455d.f35445b = n();
        this.f35462c.f35455d.f35446c = n();
        this.f35462c.f35455d.f35447d = n();
        int m = m();
        boolean z = (m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (m & 7) + 1);
        this.f35462c.f35455d.f35448e = (m & 64) != 0;
        b bVar = this.f35462c.f35455d;
        if (z) {
            bVar.k = b(pow);
        } else {
            bVar.k = null;
        }
        this.f35462c.f35455d.j = this.f35461b.position();
        j();
        if (o()) {
            return;
        }
        c cVar = this.f35462c;
        cVar.f35454c++;
        cVar.f35456e.add(cVar.f35455d);
    }

    private void g() {
        do {
            l();
            byte[] bArr = this.f35460a;
            if (bArr[0] == 1) {
                this.f35462c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f35463d <= 0) {
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
            this.f35462c.f35453b = 1;
            return;
        }
        i();
        if (!this.f35462c.f35459h || o()) {
            return;
        }
        c cVar = this.f35462c;
        cVar.f35452a = b(cVar.i);
        c cVar2 = this.f35462c;
        cVar2.l = cVar2.f35452a[cVar2.j];
    }

    private void i() {
        this.f35462c.f35457f = n();
        this.f35462c.f35458g = n();
        int m = m();
        this.f35462c.f35459h = (m & 128) != 0;
        this.f35462c.i = (int) Math.pow(2.0d, (m & 7) + 1);
        this.f35462c.j = m();
        this.f35462c.k = m();
    }

    private void j() {
        m();
        k();
    }

    private void k() {
        int m;
        do {
            m = m();
            this.f35461b.position(Math.min(this.f35461b.position() + m, this.f35461b.limit()));
        } while (m > 0);
    }

    private void l() {
        int m = m();
        this.f35463d = m;
        if (m > 0) {
            int i = 0;
            int i2 = 0;
            while (i < this.f35463d) {
                try {
                    i2 = this.f35463d - i;
                    this.f35461b.get(this.f35460a, i, i2);
                    i += i2;
                } catch (Exception e2) {
                    if (Log.isLoggable(GifHeaderParser.TAG, 3)) {
                        Log.d(GifHeaderParser.TAG, "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f35463d, e2);
                    }
                    this.f35462c.f35453b = 1;
                    return;
                }
            }
        }
    }

    private int m() {
        try {
            return this.f35461b.get() & 255;
        } catch (Exception unused) {
            this.f35462c.f35453b = 1;
            return 0;
        }
    }

    private int n() {
        return this.f35461b.getShort();
    }

    private boolean o() {
        return this.f35462c.f35453b != 0;
    }

    public d a(@NonNull ByteBuffer byteBuffer) {
        c();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f35461b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f35461b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public void a() {
        this.f35461b = null;
        this.f35462c = null;
    }

    @NonNull
    public c b() {
        if (this.f35461b != null) {
            if (o()) {
                return this.f35462c;
            }
            h();
            if (!o()) {
                d();
                c cVar = this.f35462c;
                if (cVar.f35454c < 0) {
                    cVar.f35453b = 1;
                }
            }
            return this.f35462c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }
}
