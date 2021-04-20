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
    public ByteBuffer f35366b;

    /* renamed from: c  reason: collision with root package name */
    public c f35367c;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f35365a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    public int f35368d = 0;

    private void a(int i) {
        boolean z = false;
        while (!z && !o() && this.f35367c.f35359c <= i) {
            int m = m();
            if (m == 33) {
                int m2 = m();
                if (m2 != 1) {
                    if (m2 == 249) {
                        this.f35367c.f35360d = new b();
                        e();
                    } else if (m2 != 254 && m2 == 255) {
                        l();
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < 11; i2++) {
                            sb.append((char) this.f35365a[i2]);
                        }
                        if (sb.toString().equals("NETSCAPE2.0")) {
                            g();
                        }
                    }
                }
                k();
            } else if (m == 44) {
                c cVar = this.f35367c;
                if (cVar.f35360d == null) {
                    cVar.f35360d = new b();
                }
                f();
            } else if (m != 59) {
                this.f35367c.f35358b = 1;
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
            this.f35366b.get(bArr);
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
            this.f35367c.f35358b = 1;
        }
        return iArr;
    }

    private void c() {
        this.f35366b = null;
        Arrays.fill(this.f35365a, (byte) 0);
        this.f35367c = new c();
        this.f35368d = 0;
    }

    private void d() {
        a(Integer.MAX_VALUE);
    }

    private void e() {
        m();
        int m = m();
        b bVar = this.f35367c.f35360d;
        int i = (m & 28) >> 2;
        bVar.f35355g = i;
        if (i == 0) {
            bVar.f35355g = 1;
        }
        this.f35367c.f35360d.f35354f = (m & 1) != 0;
        int n = n();
        if (n < 2) {
            n = 10;
        }
        b bVar2 = this.f35367c.f35360d;
        bVar2.i = n * 10;
        bVar2.f35356h = m();
        m();
    }

    private void f() {
        this.f35367c.f35360d.f35349a = n();
        this.f35367c.f35360d.f35350b = n();
        this.f35367c.f35360d.f35351c = n();
        this.f35367c.f35360d.f35352d = n();
        int m = m();
        boolean z = (m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (m & 7) + 1);
        this.f35367c.f35360d.f35353e = (m & 64) != 0;
        b bVar = this.f35367c.f35360d;
        if (z) {
            bVar.k = b(pow);
        } else {
            bVar.k = null;
        }
        this.f35367c.f35360d.j = this.f35366b.position();
        j();
        if (o()) {
            return;
        }
        c cVar = this.f35367c;
        cVar.f35359c++;
        cVar.f35361e.add(cVar.f35360d);
    }

    private void g() {
        do {
            l();
            byte[] bArr = this.f35365a;
            if (bArr[0] == 1) {
                this.f35367c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f35368d <= 0) {
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
            this.f35367c.f35358b = 1;
            return;
        }
        i();
        if (!this.f35367c.f35364h || o()) {
            return;
        }
        c cVar = this.f35367c;
        cVar.f35357a = b(cVar.i);
        c cVar2 = this.f35367c;
        cVar2.l = cVar2.f35357a[cVar2.j];
    }

    private void i() {
        this.f35367c.f35362f = n();
        this.f35367c.f35363g = n();
        int m = m();
        this.f35367c.f35364h = (m & 128) != 0;
        this.f35367c.i = (int) Math.pow(2.0d, (m & 7) + 1);
        this.f35367c.j = m();
        this.f35367c.k = m();
    }

    private void j() {
        m();
        k();
    }

    private void k() {
        int m;
        do {
            m = m();
            this.f35366b.position(Math.min(this.f35366b.position() + m, this.f35366b.limit()));
        } while (m > 0);
    }

    private void l() {
        int m = m();
        this.f35368d = m;
        if (m > 0) {
            int i = 0;
            int i2 = 0;
            while (i < this.f35368d) {
                try {
                    i2 = this.f35368d - i;
                    this.f35366b.get(this.f35365a, i, i2);
                    i += i2;
                } catch (Exception e2) {
                    if (Log.isLoggable(GifHeaderParser.TAG, 3)) {
                        Log.d(GifHeaderParser.TAG, "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f35368d, e2);
                    }
                    this.f35367c.f35358b = 1;
                    return;
                }
            }
        }
    }

    private int m() {
        try {
            return this.f35366b.get() & 255;
        } catch (Exception unused) {
            this.f35367c.f35358b = 1;
            return 0;
        }
    }

    private int n() {
        return this.f35366b.getShort();
    }

    private boolean o() {
        return this.f35367c.f35358b != 0;
    }

    public d a(@NonNull ByteBuffer byteBuffer) {
        c();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f35366b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f35366b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public void a() {
        this.f35366b = null;
        this.f35367c = null;
    }

    @NonNull
    public c b() {
        if (this.f35366b != null) {
            if (o()) {
                return this.f35367c;
            }
            h();
            if (!o()) {
                d();
                c cVar = this.f35367c;
                if (cVar.f35359c < 0) {
                    cVar.f35358b = 1;
                }
            }
            return this.f35367c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }
}
