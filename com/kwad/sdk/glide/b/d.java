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
    public ByteBuffer f35077b;

    /* renamed from: c  reason: collision with root package name */
    public c f35078c;

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f35076a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    public int f35079d = 0;

    private void a(int i) {
        boolean z = false;
        while (!z && !o() && this.f35078c.f35070c <= i) {
            int m = m();
            if (m == 33) {
                int m2 = m();
                if (m2 != 1) {
                    if (m2 == 249) {
                        this.f35078c.f35071d = new b();
                        e();
                    } else if (m2 != 254 && m2 == 255) {
                        l();
                        StringBuilder sb = new StringBuilder();
                        for (int i2 = 0; i2 < 11; i2++) {
                            sb.append((char) this.f35076a[i2]);
                        }
                        if (sb.toString().equals("NETSCAPE2.0")) {
                            g();
                        }
                    }
                }
                k();
            } else if (m == 44) {
                c cVar = this.f35078c;
                if (cVar.f35071d == null) {
                    cVar.f35071d = new b();
                }
                f();
            } else if (m != 59) {
                this.f35078c.f35069b = 1;
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
            this.f35077b.get(bArr);
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
            this.f35078c.f35069b = 1;
        }
        return iArr;
    }

    private void c() {
        this.f35077b = null;
        Arrays.fill(this.f35076a, (byte) 0);
        this.f35078c = new c();
        this.f35079d = 0;
    }

    private void d() {
        a(Integer.MAX_VALUE);
    }

    private void e() {
        m();
        int m = m();
        b bVar = this.f35078c.f35071d;
        int i = (m & 28) >> 2;
        bVar.f35066g = i;
        if (i == 0) {
            bVar.f35066g = 1;
        }
        this.f35078c.f35071d.f35065f = (m & 1) != 0;
        int n = n();
        if (n < 2) {
            n = 10;
        }
        b bVar2 = this.f35078c.f35071d;
        bVar2.i = n * 10;
        bVar2.f35067h = m();
        m();
    }

    private void f() {
        this.f35078c.f35071d.f35060a = n();
        this.f35078c.f35071d.f35061b = n();
        this.f35078c.f35071d.f35062c = n();
        this.f35078c.f35071d.f35063d = n();
        int m = m();
        boolean z = (m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (m & 7) + 1);
        this.f35078c.f35071d.f35064e = (m & 64) != 0;
        b bVar = this.f35078c.f35071d;
        if (z) {
            bVar.k = b(pow);
        } else {
            bVar.k = null;
        }
        this.f35078c.f35071d.j = this.f35077b.position();
        j();
        if (o()) {
            return;
        }
        c cVar = this.f35078c;
        cVar.f35070c++;
        cVar.f35072e.add(cVar.f35071d);
    }

    private void g() {
        do {
            l();
            byte[] bArr = this.f35076a;
            if (bArr[0] == 1) {
                this.f35078c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f35079d <= 0) {
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
            this.f35078c.f35069b = 1;
            return;
        }
        i();
        if (!this.f35078c.f35075h || o()) {
            return;
        }
        c cVar = this.f35078c;
        cVar.f35068a = b(cVar.i);
        c cVar2 = this.f35078c;
        cVar2.l = cVar2.f35068a[cVar2.j];
    }

    private void i() {
        this.f35078c.f35073f = n();
        this.f35078c.f35074g = n();
        int m = m();
        this.f35078c.f35075h = (m & 128) != 0;
        this.f35078c.i = (int) Math.pow(2.0d, (m & 7) + 1);
        this.f35078c.j = m();
        this.f35078c.k = m();
    }

    private void j() {
        m();
        k();
    }

    private void k() {
        int m;
        do {
            m = m();
            this.f35077b.position(Math.min(this.f35077b.position() + m, this.f35077b.limit()));
        } while (m > 0);
    }

    private void l() {
        int m = m();
        this.f35079d = m;
        if (m > 0) {
            int i = 0;
            int i2 = 0;
            while (i < this.f35079d) {
                try {
                    i2 = this.f35079d - i;
                    this.f35077b.get(this.f35076a, i, i2);
                    i += i2;
                } catch (Exception e2) {
                    if (Log.isLoggable(GifHeaderParser.TAG, 3)) {
                        Log.d(GifHeaderParser.TAG, "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f35079d, e2);
                    }
                    this.f35078c.f35069b = 1;
                    return;
                }
            }
        }
    }

    private int m() {
        try {
            return this.f35077b.get() & 255;
        } catch (Exception unused) {
            this.f35078c.f35069b = 1;
            return 0;
        }
    }

    private int n() {
        return this.f35077b.getShort();
    }

    private boolean o() {
        return this.f35078c.f35069b != 0;
    }

    public d a(@NonNull ByteBuffer byteBuffer) {
        c();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f35077b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f35077b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public void a() {
        this.f35077b = null;
        this.f35078c = null;
    }

    @NonNull
    public c b() {
        if (this.f35077b != null) {
            if (o()) {
                return this.f35078c;
            }
            h();
            if (!o()) {
                d();
                c cVar = this.f35078c;
                if (cVar.f35070c < 0) {
                    cVar.f35069b = 1;
                }
            }
            return this.f35078c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }
}
