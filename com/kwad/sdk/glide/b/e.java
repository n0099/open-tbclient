package com.kwad.sdk.glide.b;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.b.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f35756a = "e";
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    public int[] f35757b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    public final int[] f35758c;

    /* renamed from: d  reason: collision with root package name */
    public final a.InterfaceC0407a f35759d;

    /* renamed from: e  reason: collision with root package name */
    public ByteBuffer f35760e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f35761f;

    /* renamed from: g  reason: collision with root package name */
    public short[] f35762g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f35763h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f35764i;
    public byte[] j;
    @ColorInt
    public int[] k;
    public int l;
    public c m;
    public Bitmap n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public int s;
    @Nullable
    public Boolean t;
    @NonNull
    public Bitmap.Config u;

    public e(@NonNull a.InterfaceC0407a interfaceC0407a) {
        this.f35758c = new int[256];
        this.u = Bitmap.Config.ARGB_8888;
        this.f35759d = interfaceC0407a;
        this.m = new c();
    }

    public e(@NonNull a.InterfaceC0407a interfaceC0407a, c cVar, ByteBuffer byteBuffer, int i2) {
        this(interfaceC0407a);
        a(cVar, byteBuffer, i2);
    }

    @ColorInt
    private int a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.q + i2; i10++) {
            byte[] bArr = this.j;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.f35757b[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.q + i12; i13++) {
            byte[] bArr2 = this.j;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.f35757b[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    private Bitmap a(b bVar, b bVar2) {
        int i2;
        int i3;
        Bitmap bitmap;
        int[] iArr = this.k;
        int i4 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.n;
            if (bitmap2 != null) {
                this.f35759d.a(bitmap2);
            }
            this.n = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f35740g == 3 && this.n == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i3 = bVar2.f35740g) > 0) {
            if (i3 == 2) {
                if (!bVar.f35739f) {
                    c cVar = this.m;
                    int i5 = cVar.l;
                    if (bVar.k == null || cVar.j != bVar.f35741h) {
                        i4 = i5;
                    }
                } else if (this.l == 0) {
                    this.t = Boolean.TRUE;
                }
                int i6 = bVar2.f35737d;
                int i7 = this.q;
                int i8 = i6 / i7;
                int i9 = bVar2.f35735b / i7;
                int i10 = bVar2.f35736c / i7;
                int i11 = bVar2.f35734a / i7;
                int i12 = this.s;
                int i13 = (i9 * i12) + i11;
                int i14 = (i8 * i12) + i13;
                while (i13 < i14) {
                    int i15 = i13 + i10;
                    for (int i16 = i13; i16 < i15; i16++) {
                        iArr[i16] = i4;
                    }
                    i13 += this.s;
                }
            } else if (i3 == 3 && (bitmap = this.n) != null) {
                int i17 = this.s;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.r);
            }
        }
        c(bVar);
        if (bVar.f35738e || this.q != 1) {
            b(bVar);
        } else {
            a(bVar);
        }
        if (this.o && ((i2 = bVar.f35740g) == 0 || i2 == 1)) {
            if (this.n == null) {
                this.n = l();
            }
            Bitmap bitmap3 = this.n;
            int i18 = this.s;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.r);
        }
        Bitmap l = l();
        int i19 = this.s;
        l.setPixels(iArr, 0, i19, 0, 0, i19, this.r);
        return l;
    }

    private void a(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.k;
        int i2 = bVar2.f35737d;
        int i3 = bVar2.f35735b;
        int i4 = bVar2.f35736c;
        int i5 = bVar2.f35734a;
        boolean z = this.l == 0;
        int i6 = this.s;
        byte[] bArr = this.j;
        int[] iArr2 = this.f35757b;
        int i7 = 0;
        byte b2 = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = bVar2.f35736c * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b3 = bArr[i12];
                int i14 = i2;
                int i15 = b3 & 255;
                if (i15 != b2) {
                    int i16 = iArr2[i15];
                    if (i16 != 0) {
                        iArr[i13] = i16;
                    } else {
                        b2 = b3;
                    }
                }
                i12++;
                i13++;
                i2 = i14;
            }
            i7++;
            bVar2 = bVar;
        }
        this.t = Boolean.valueOf(this.t == null && z && b2 != -1);
    }

    private void b(b bVar) {
        Boolean bool;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr = this.k;
        int i7 = bVar.f35737d;
        int i8 = this.q;
        int i9 = i7 / i8;
        int i10 = bVar.f35735b / i8;
        int i11 = bVar.f35736c / i8;
        int i12 = bVar.f35734a / i8;
        boolean z = this.l == 0;
        int i13 = this.q;
        int i14 = this.s;
        int i15 = this.r;
        byte[] bArr = this.j;
        int[] iArr2 = this.f35757b;
        Boolean bool2 = this.t;
        int i16 = 8;
        int i17 = 0;
        int i18 = 0;
        int i19 = 1;
        while (true) {
            bool = bool2;
            if (i17 >= i9) {
                break;
            }
            if (bVar.f35738e) {
                if (i18 >= i9) {
                    i2 = i9;
                    int i20 = i19 + 1;
                    if (i20 == 2) {
                        i19 = i20;
                        i18 = 4;
                    } else if (i20 != 3) {
                        i19 = i20;
                        if (i20 == 4) {
                            i18 = 1;
                            i16 = 2;
                        }
                    } else {
                        i19 = i20;
                        i18 = 2;
                        i16 = 4;
                    }
                } else {
                    i2 = i9;
                }
                i3 = i18 + i16;
            } else {
                i2 = i9;
                i3 = i18;
                i18 = i17;
            }
            int i21 = i18 + i10;
            boolean z2 = i13 == 1;
            if (i21 < i15) {
                int i22 = i21 * i14;
                int i23 = i22 + i12;
                int i24 = i23 + i11;
                int i25 = i22 + i14;
                if (i25 < i24) {
                    i24 = i25;
                }
                i4 = i3;
                int i26 = i17 * i13 * bVar.f35736c;
                if (z2) {
                    int i27 = i23;
                    while (true) {
                        i5 = i10;
                        if (i27 >= i24) {
                            break;
                        }
                        int i28 = iArr2[bArr[i26] & 255];
                        if (i28 != 0) {
                            iArr[i27] = i28;
                        } else if (z && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i26 += i13;
                        i27++;
                        i10 = i5;
                    }
                } else {
                    i5 = i10;
                    int i29 = ((i24 - i23) * i13) + i26;
                    int i30 = i23;
                    while (true) {
                        i6 = i11;
                        if (i30 < i24) {
                            int a2 = a(i26, i29, bVar.f35736c);
                            if (a2 != 0) {
                                iArr[i30] = a2;
                            } else if (z && bool == null) {
                                bool = Boolean.TRUE;
                            }
                            i26 += i13;
                            i30++;
                            i11 = i6;
                        }
                    }
                    bool2 = bool;
                    i17++;
                    i10 = i5;
                    i11 = i6;
                    i9 = i2;
                    i18 = i4;
                }
            } else {
                i4 = i3;
                i5 = i10;
            }
            i6 = i11;
            bool2 = bool;
            i17++;
            i10 = i5;
            i11 = i6;
            i9 = i2;
            i18 = i4;
        }
        if (this.t == null) {
            this.t = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x00f7 */
    /* JADX DEBUG: Multi-variable search result rejected for r7v15, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void c(b bVar) {
        int i2;
        int i3;
        short s;
        e eVar = this;
        if (bVar != null) {
            eVar.f35760e.position(bVar.j);
        }
        if (bVar == null) {
            c cVar = eVar.m;
            i2 = cVar.f35748f;
            i3 = cVar.f35749g;
        } else {
            i2 = bVar.f35736c;
            i3 = bVar.f35737d;
        }
        int i4 = i2 * i3;
        byte[] bArr = eVar.j;
        if (bArr == null || bArr.length < i4) {
            eVar.j = eVar.f35759d.a(i4);
        }
        byte[] bArr2 = eVar.j;
        if (eVar.f35762g == null) {
            eVar.f35762g = new short[4096];
        }
        short[] sArr = eVar.f35762g;
        if (eVar.f35763h == null) {
            eVar.f35763h = new byte[4096];
        }
        byte[] bArr3 = eVar.f35763h;
        if (eVar.f35764i == null) {
            eVar.f35764i = new byte[4097];
        }
        byte[] bArr4 = eVar.f35764i;
        int j = j();
        int i5 = 1 << j;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = j + 1;
        int i9 = (1 << i8) - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            sArr[i11] = 0;
            bArr3[i11] = (byte) i11;
        }
        byte[] bArr5 = eVar.f35761f;
        int i12 = i8;
        int i13 = i7;
        int i14 = i9;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = -1;
        int i21 = 0;
        int i22 = 0;
        while (true) {
            if (i10 >= i4) {
                break;
            }
            if (i15 == 0) {
                i15 = k();
                if (i15 <= 0) {
                    eVar.p = 3;
                    break;
                }
                i16 = 0;
            }
            i18 += (bArr5[i16] & 255) << i17;
            i16++;
            i15--;
            int i23 = i17 + 8;
            int i24 = i13;
            int i25 = i12;
            int i26 = i20;
            int i27 = i8;
            int i28 = i21;
            while (true) {
                if (i23 < i25) {
                    i20 = i26;
                    i13 = i24;
                    i17 = i23;
                    eVar = this;
                    i21 = i28;
                    i8 = i27;
                    i12 = i25;
                    break;
                }
                int i29 = i7;
                int i30 = i18 & i14;
                i18 >>= i25;
                i23 -= i25;
                if (i30 == i5) {
                    i14 = i9;
                    i25 = i27;
                    i24 = i29;
                    i7 = i24;
                    i26 = -1;
                } else if (i30 == i6) {
                    i17 = i23;
                    i21 = i28;
                    i13 = i24;
                    i8 = i27;
                    i7 = i29;
                    i20 = i26;
                    i12 = i25;
                    eVar = this;
                    break;
                } else if (i26 == -1) {
                    bArr2[i19] = bArr3[i30];
                    i19++;
                    i10++;
                    i26 = i30;
                    i28 = i26;
                    i7 = i29;
                    i23 = i23;
                } else {
                    if (i30 >= i24) {
                        bArr4[i22] = (byte) i28;
                        i22++;
                        s = i26;
                    } else {
                        s = i30;
                    }
                    while (s >= i5) {
                        bArr4[i22] = bArr3[s];
                        i22++;
                        s = sArr[s];
                    }
                    i28 = bArr3[s] & 255;
                    byte b2 = (byte) i28;
                    bArr2[i19] = b2;
                    while (true) {
                        i19++;
                        i10++;
                        if (i22 <= 0) {
                            break;
                        }
                        i22--;
                        bArr2[i19] = bArr4[i22];
                    }
                    byte[] bArr6 = bArr4;
                    if (i24 < 4096) {
                        sArr[i24] = (short) i26;
                        bArr3[i24] = b2;
                        i24++;
                        if ((i24 & i14) == 0 && i24 < 4096) {
                            i25++;
                            i14 += i24;
                        }
                    }
                    i26 = i30;
                    i7 = i29;
                    i23 = i23;
                    bArr4 = bArr6;
                }
            }
        }
        Arrays.fill(bArr2, i19, i4, (byte) 0);
    }

    private int j() {
        return this.f35760e.get() & 255;
    }

    private int k() {
        int j = j();
        if (j <= 0) {
            return j;
        }
        ByteBuffer byteBuffer = this.f35760e;
        byteBuffer.get(this.f35761f, 0, Math.min(j, byteBuffer.remaining()));
        return j;
    }

    private Bitmap l() {
        Boolean bool = this.t;
        Bitmap a2 = this.f35759d.a(this.s, this.r, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.u);
        a2.setHasAlpha(true);
        return a2;
    }

    public int a(int i2) {
        if (i2 >= 0) {
            c cVar = this.m;
            if (i2 < cVar.f35745c) {
                return cVar.f35747e.get(i2).f35742i;
            }
        }
        return -1;
    }

    @Override // com.kwad.sdk.glide.b.a
    @NonNull
    public ByteBuffer a() {
        return this.f35760e;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void a(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.u = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public synchronized void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
        int highestOneBit = Integer.highestOneBit(i2);
        this.p = 0;
        this.m = cVar;
        this.l = -1;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f35760e = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f35760e.order(ByteOrder.LITTLE_ENDIAN);
        this.o = false;
        Iterator<b> it = cVar.f35747e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().f35740g == 3) {
                this.o = true;
                break;
            }
        }
        this.q = highestOneBit;
        this.s = cVar.f35748f / highestOneBit;
        this.r = cVar.f35749g / highestOneBit;
        this.j = this.f35759d.a(cVar.f35748f * cVar.f35749g);
        this.k = this.f35759d.b(this.s * this.r);
    }

    @Override // com.kwad.sdk.glide.b.a
    public void b() {
        this.l = (this.l + 1) % this.m.f35745c;
    }

    @Override // com.kwad.sdk.glide.b.a
    public int c() {
        int i2;
        if (this.m.f35745c <= 0 || (i2 = this.l) < 0) {
            return 0;
        }
        return a(i2);
    }

    @Override // com.kwad.sdk.glide.b.a
    public int d() {
        return this.m.f35745c;
    }

    @Override // com.kwad.sdk.glide.b.a
    public int e() {
        return this.l;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void f() {
        this.l = -1;
    }

    @Override // com.kwad.sdk.glide.b.a
    public int g() {
        return this.f35760e.limit() + this.j.length + (this.k.length * 4);
    }

    @Override // com.kwad.sdk.glide.b.a
    @Nullable
    public synchronized Bitmap h() {
        if (this.m.f35745c <= 0 || this.l < 0) {
            if (Log.isLoggable(f35756a, 3)) {
                String str = f35756a;
                Log.d(str, "Unable to decode frame, frameCount=" + this.m.f35745c + ", framePointer=" + this.l);
            }
            this.p = 1;
        }
        if (this.p != 1 && this.p != 2) {
            this.p = 0;
            if (this.f35761f == null) {
                this.f35761f = this.f35759d.a(255);
            }
            b bVar = this.m.f35747e.get(this.l);
            int i2 = this.l - 1;
            b bVar2 = i2 >= 0 ? this.m.f35747e.get(i2) : null;
            int[] iArr = bVar.k != null ? bVar.k : this.m.f35743a;
            this.f35757b = iArr;
            if (iArr != null) {
                if (bVar.f35739f) {
                    System.arraycopy(iArr, 0, this.f35758c, 0, iArr.length);
                    int[] iArr2 = this.f35758c;
                    this.f35757b = iArr2;
                    iArr2[bVar.f35741h] = 0;
                }
                return a(bVar, bVar2);
            }
            if (Log.isLoggable(f35756a, 3)) {
                String str2 = f35756a;
                Log.d(str2, "No valid color table found for frame #" + this.l);
            }
            this.p = 1;
            return null;
        }
        if (Log.isLoggable(f35756a, 3)) {
            String str3 = f35756a;
            Log.d(str3, "Unable to decode frame, status=" + this.p);
        }
        return null;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void i() {
        this.m = null;
        byte[] bArr = this.j;
        if (bArr != null) {
            this.f35759d.a(bArr);
        }
        int[] iArr = this.k;
        if (iArr != null) {
            this.f35759d.a(iArr);
        }
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.f35759d.a(bitmap);
        }
        this.n = null;
        this.f35760e = null;
        this.t = null;
        byte[] bArr2 = this.f35761f;
        if (bArr2 != null) {
            this.f35759d.a(bArr2);
        }
    }
}
