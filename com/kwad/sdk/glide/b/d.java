package com.kwad.sdk.glide.b;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f35753b;

    /* renamed from: c  reason: collision with root package name */
    public c f35754c;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f35752a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    public int f35755d = 0;

    private void a(int i2) {
        boolean z = false;
        while (!z && !o() && this.f35754c.f35745c <= i2) {
            int m = m();
            if (m == 33) {
                int m2 = m();
                if (m2 != 1) {
                    if (m2 == 249) {
                        this.f35754c.f35746d = new b();
                        e();
                    } else if (m2 != 254 && m2 == 255) {
                        l();
                        StringBuilder sb = new StringBuilder();
                        for (int i3 = 0; i3 < 11; i3++) {
                            sb.append((char) this.f35752a[i3]);
                        }
                        if (sb.toString().equals("NETSCAPE2.0")) {
                            g();
                        }
                    }
                }
                k();
            } else if (m == 44) {
                c cVar = this.f35754c;
                if (cVar.f35746d == null) {
                    cVar.f35746d = new b();
                }
                f();
            } else if (m != 59) {
                this.f35754c.f35744b = 1;
            } else {
                z = true;
            }
        }
    }

    @Nullable
    private int[] b(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.f35753b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                i4 = i7;
                i3 = i8;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable(GifHeaderParser.TAG, 3)) {
                Log.d(GifHeaderParser.TAG, "Format Error Reading Color Table", e2);
            }
            this.f35754c.f35744b = 1;
        }
        return iArr;
    }

    private void c() {
        this.f35753b = null;
        Arrays.fill(this.f35752a, (byte) 0);
        this.f35754c = new c();
        this.f35755d = 0;
    }

    private void d() {
        a(Integer.MAX_VALUE);
    }

    private void e() {
        m();
        int m = m();
        b bVar = this.f35754c.f35746d;
        int i2 = (m & 28) >> 2;
        bVar.f35740g = i2;
        if (i2 == 0) {
            bVar.f35740g = 1;
        }
        this.f35754c.f35746d.f35739f = (m & 1) != 0;
        int n = n();
        if (n < 2) {
            n = 10;
        }
        b bVar2 = this.f35754c.f35746d;
        bVar2.f35742i = n * 10;
        bVar2.f35741h = m();
        m();
    }

    private void f() {
        this.f35754c.f35746d.f35734a = n();
        this.f35754c.f35746d.f35735b = n();
        this.f35754c.f35746d.f35736c = n();
        this.f35754c.f35746d.f35737d = n();
        int m = m();
        boolean z = (m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (m & 7) + 1);
        this.f35754c.f35746d.f35738e = (m & 64) != 0;
        b bVar = this.f35754c.f35746d;
        if (z) {
            bVar.k = b(pow);
        } else {
            bVar.k = null;
        }
        this.f35754c.f35746d.j = this.f35753b.position();
        j();
        if (o()) {
            return;
        }
        c cVar = this.f35754c;
        cVar.f35745c++;
        cVar.f35747e.add(cVar.f35746d);
    }

    private void g() {
        do {
            l();
            byte[] bArr = this.f35752a;
            if (bArr[0] == 1) {
                this.f35754c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f35755d <= 0) {
                return;
            }
        } while (!o());
    }

    private void h() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) m());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f35754c.f35744b = 1;
            return;
        }
        i();
        if (!this.f35754c.f35750h || o()) {
            return;
        }
        c cVar = this.f35754c;
        cVar.f35743a = b(cVar.f35751i);
        c cVar2 = this.f35754c;
        cVar2.l = cVar2.f35743a[cVar2.j];
    }

    private void i() {
        this.f35754c.f35748f = n();
        this.f35754c.f35749g = n();
        int m = m();
        this.f35754c.f35750h = (m & 128) != 0;
        this.f35754c.f35751i = (int) Math.pow(2.0d, (m & 7) + 1);
        this.f35754c.j = m();
        this.f35754c.k = m();
    }

    private void j() {
        m();
        k();
    }

    private void k() {
        int m;
        do {
            m = m();
            this.f35753b.position(Math.min(this.f35753b.position() + m, this.f35753b.limit()));
        } while (m > 0);
    }

    private void l() {
        int m = m();
        this.f35755d = m;
        if (m > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.f35755d) {
                try {
                    i3 = this.f35755d - i2;
                    this.f35753b.get(this.f35752a, i2, i3);
                    i2 += i3;
                } catch (Exception e2) {
                    if (Log.isLoggable(GifHeaderParser.TAG, 3)) {
                        Log.d(GifHeaderParser.TAG, "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f35755d, e2);
                    }
                    this.f35754c.f35744b = 1;
                    return;
                }
            }
        }
    }

    private int m() {
        try {
            return this.f35753b.get() & 255;
        } catch (Exception unused) {
            this.f35754c.f35744b = 1;
            return 0;
        }
    }

    private int n() {
        return this.f35753b.getShort();
    }

    private boolean o() {
        return this.f35754c.f35744b != 0;
    }

    public d a(@NonNull ByteBuffer byteBuffer) {
        c();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f35753b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f35753b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public void a() {
        this.f35753b = null;
        this.f35754c = null;
    }

    @NonNull
    public c b() {
        if (this.f35753b != null) {
            if (o()) {
                return this.f35754c;
            }
            h();
            if (!o()) {
                d();
                c cVar = this.f35754c;
                if (cVar.f35745c < 0) {
                    cVar.f35744b = 1;
                }
            }
            return this.f35754c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }
}
