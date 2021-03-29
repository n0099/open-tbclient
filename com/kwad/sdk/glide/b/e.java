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
/* loaded from: classes6.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f35080a = "e";
    @ColorInt

    /* renamed from: b  reason: collision with root package name */
    public int[] f35081b;
    @ColorInt

    /* renamed from: c  reason: collision with root package name */
    public final int[] f35082c;

    /* renamed from: d  reason: collision with root package name */
    public final a.InterfaceC0407a f35083d;

    /* renamed from: e  reason: collision with root package name */
    public ByteBuffer f35084e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f35085f;

    /* renamed from: g  reason: collision with root package name */
    public short[] f35086g;

    /* renamed from: h  reason: collision with root package name */
    public byte[] f35087h;
    public byte[] i;
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
        this.f35082c = new int[256];
        this.u = Bitmap.Config.ARGB_8888;
        this.f35083d = interfaceC0407a;
        this.m = new c();
    }

    public e(@NonNull a.InterfaceC0407a interfaceC0407a, c cVar, ByteBuffer byteBuffer, int i) {
        this(interfaceC0407a);
        a(cVar, byteBuffer, i);
    }

    @ColorInt
    private int a(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.q + i; i9++) {
            byte[] bArr = this.j;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.f35081b[bArr[i9] & 255];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.q + i11; i12++) {
            byte[] bArr2 = this.j;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.f35081b[bArr2[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    private Bitmap a(b bVar, b bVar2) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.k;
        int i3 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.n;
            if (bitmap2 != null) {
                this.f35083d.a(bitmap2);
            }
            this.n = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f35066g == 3 && this.n == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i2 = bVar2.f35066g) > 0) {
            if (i2 == 2) {
                if (!bVar.f35065f) {
                    c cVar = this.m;
                    int i4 = cVar.l;
                    if (bVar.k == null || cVar.j != bVar.f35067h) {
                        i3 = i4;
                    }
                } else if (this.l == 0) {
                    this.t = Boolean.TRUE;
                }
                int i5 = bVar2.f35063d;
                int i6 = this.q;
                int i7 = i5 / i6;
                int i8 = bVar2.f35061b / i6;
                int i9 = bVar2.f35062c / i6;
                int i10 = bVar2.f35060a / i6;
                int i11 = this.s;
                int i12 = (i8 * i11) + i10;
                int i13 = (i7 * i11) + i12;
                while (i12 < i13) {
                    int i14 = i12 + i9;
                    for (int i15 = i12; i15 < i14; i15++) {
                        iArr[i15] = i3;
                    }
                    i12 += this.s;
                }
            } else if (i2 == 3 && (bitmap = this.n) != null) {
                int i16 = this.s;
                bitmap.getPixels(iArr, 0, i16, 0, 0, i16, this.r);
            }
        }
        c(bVar);
        if (bVar.f35064e || this.q != 1) {
            b(bVar);
        } else {
            a(bVar);
        }
        if (this.o && ((i = bVar.f35066g) == 0 || i == 1)) {
            if (this.n == null) {
                this.n = l();
            }
            Bitmap bitmap3 = this.n;
            int i17 = this.s;
            bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.r);
        }
        Bitmap l = l();
        int i18 = this.s;
        l.setPixels(iArr, 0, i18, 0, 0, i18, this.r);
        return l;
    }

    private void a(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.k;
        int i = bVar2.f35063d;
        int i2 = bVar2.f35061b;
        int i3 = bVar2.f35062c;
        int i4 = bVar2.f35060a;
        boolean z = this.l == 0;
        int i5 = this.s;
        byte[] bArr = this.j;
        int[] iArr2 = this.f35081b;
        int i6 = 0;
        byte b2 = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = bVar2.f35062c * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b3 = bArr[i11];
                int i13 = i;
                int i14 = b3 & 255;
                if (i14 != b2) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i12] = i15;
                    } else {
                        b2 = b3;
                    }
                }
                i11++;
                i12++;
                i = i13;
            }
            i6++;
            bVar2 = bVar;
        }
        this.t = Boolean.valueOf(this.t == null && z && b2 != -1);
    }

    private void b(b bVar) {
        Boolean bool;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.k;
        int i6 = bVar.f35063d;
        int i7 = this.q;
        int i8 = i6 / i7;
        int i9 = bVar.f35061b / i7;
        int i10 = bVar.f35062c / i7;
        int i11 = bVar.f35060a / i7;
        boolean z = this.l == 0;
        int i12 = this.q;
        int i13 = this.s;
        int i14 = this.r;
        byte[] bArr = this.j;
        int[] iArr2 = this.f35081b;
        Boolean bool2 = this.t;
        int i15 = 8;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        while (true) {
            bool = bool2;
            if (i16 >= i8) {
                break;
            }
            if (bVar.f35064e) {
                if (i17 >= i8) {
                    i = i8;
                    int i19 = i18 + 1;
                    if (i19 == 2) {
                        i18 = i19;
                        i17 = 4;
                    } else if (i19 != 3) {
                        i18 = i19;
                        if (i19 == 4) {
                            i17 = 1;
                            i15 = 2;
                        }
                    } else {
                        i18 = i19;
                        i17 = 2;
                        i15 = 4;
                    }
                } else {
                    i = i8;
                }
                i2 = i17 + i15;
            } else {
                i = i8;
                i2 = i17;
                i17 = i16;
            }
            int i20 = i17 + i9;
            boolean z2 = i12 == 1;
            if (i20 < i14) {
                int i21 = i20 * i13;
                int i22 = i21 + i11;
                int i23 = i22 + i10;
                int i24 = i21 + i13;
                if (i24 < i23) {
                    i23 = i24;
                }
                i3 = i2;
                int i25 = i16 * i12 * bVar.f35062c;
                if (z2) {
                    int i26 = i22;
                    while (true) {
                        i4 = i9;
                        if (i26 >= i23) {
                            break;
                        }
                        int i27 = iArr2[bArr[i25] & 255];
                        if (i27 != 0) {
                            iArr[i26] = i27;
                        } else if (z && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i25 += i12;
                        i26++;
                        i9 = i4;
                    }
                } else {
                    i4 = i9;
                    int i28 = ((i23 - i22) * i12) + i25;
                    int i29 = i22;
                    while (true) {
                        i5 = i10;
                        if (i29 < i23) {
                            int a2 = a(i25, i28, bVar.f35062c);
                            if (a2 != 0) {
                                iArr[i29] = a2;
                            } else if (z && bool == null) {
                                bool = Boolean.TRUE;
                            }
                            i25 += i12;
                            i29++;
                            i10 = i5;
                        }
                    }
                    bool2 = bool;
                    i16++;
                    i9 = i4;
                    i10 = i5;
                    i8 = i;
                    i17 = i3;
                }
            } else {
                i3 = i2;
                i4 = i9;
            }
            i5 = i10;
            bool2 = bool;
            i16++;
            i9 = i4;
            i10 = i5;
            i8 = i;
            i17 = i3;
        }
        if (this.t == null) {
            this.t = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x00f7 */
    /* JADX DEBUG: Multi-variable search result rejected for r7v15, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    private void c(b bVar) {
        int i;
        int i2;
        short s;
        e eVar = this;
        if (bVar != null) {
            eVar.f35084e.position(bVar.j);
        }
        if (bVar == null) {
            c cVar = eVar.m;
            i = cVar.f35073f;
            i2 = cVar.f35074g;
        } else {
            i = bVar.f35062c;
            i2 = bVar.f35063d;
        }
        int i3 = i * i2;
        byte[] bArr = eVar.j;
        if (bArr == null || bArr.length < i3) {
            eVar.j = eVar.f35083d.a(i3);
        }
        byte[] bArr2 = eVar.j;
        if (eVar.f35086g == null) {
            eVar.f35086g = new short[4096];
        }
        short[] sArr = eVar.f35086g;
        if (eVar.f35087h == null) {
            eVar.f35087h = new byte[4096];
        }
        byte[] bArr3 = eVar.f35087h;
        if (eVar.i == null) {
            eVar.i = new byte[4097];
        }
        byte[] bArr4 = eVar.i;
        int j = j();
        int i4 = 1 << j;
        int i5 = i4 + 1;
        int i6 = i4 + 2;
        int i7 = j + 1;
        int i8 = (1 << i7) - 1;
        int i9 = 0;
        for (int i10 = 0; i10 < i4; i10++) {
            sArr[i10] = 0;
            bArr3[i10] = (byte) i10;
        }
        byte[] bArr5 = eVar.f35085f;
        int i11 = i7;
        int i12 = i6;
        int i13 = i8;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = -1;
        int i20 = 0;
        int i21 = 0;
        while (true) {
            if (i9 >= i3) {
                break;
            }
            if (i14 == 0) {
                i14 = k();
                if (i14 <= 0) {
                    eVar.p = 3;
                    break;
                }
                i15 = 0;
            }
            i17 += (bArr5[i15] & 255) << i16;
            i15++;
            i14--;
            int i22 = i16 + 8;
            int i23 = i12;
            int i24 = i11;
            int i25 = i19;
            int i26 = i7;
            int i27 = i20;
            while (true) {
                if (i22 < i24) {
                    i19 = i25;
                    i12 = i23;
                    i16 = i22;
                    eVar = this;
                    i20 = i27;
                    i7 = i26;
                    i11 = i24;
                    break;
                }
                int i28 = i6;
                int i29 = i17 & i13;
                i17 >>= i24;
                i22 -= i24;
                if (i29 == i4) {
                    i13 = i8;
                    i24 = i26;
                    i23 = i28;
                    i6 = i23;
                    i25 = -1;
                } else if (i29 == i5) {
                    i16 = i22;
                    i20 = i27;
                    i12 = i23;
                    i7 = i26;
                    i6 = i28;
                    i19 = i25;
                    i11 = i24;
                    eVar = this;
                    break;
                } else if (i25 == -1) {
                    bArr2[i18] = bArr3[i29];
                    i18++;
                    i9++;
                    i25 = i29;
                    i27 = i25;
                    i6 = i28;
                    i22 = i22;
                } else {
                    if (i29 >= i23) {
                        bArr4[i21] = (byte) i27;
                        i21++;
                        s = i25;
                    } else {
                        s = i29;
                    }
                    while (s >= i4) {
                        bArr4[i21] = bArr3[s];
                        i21++;
                        s = sArr[s];
                    }
                    i27 = bArr3[s] & 255;
                    byte b2 = (byte) i27;
                    bArr2[i18] = b2;
                    while (true) {
                        i18++;
                        i9++;
                        if (i21 <= 0) {
                            break;
                        }
                        i21--;
                        bArr2[i18] = bArr4[i21];
                    }
                    byte[] bArr6 = bArr4;
                    if (i23 < 4096) {
                        sArr[i23] = (short) i25;
                        bArr3[i23] = b2;
                        i23++;
                        if ((i23 & i13) == 0 && i23 < 4096) {
                            i24++;
                            i13 += i23;
                        }
                    }
                    i25 = i29;
                    i6 = i28;
                    i22 = i22;
                    bArr4 = bArr6;
                }
            }
        }
        Arrays.fill(bArr2, i18, i3, (byte) 0);
    }

    private int j() {
        return this.f35084e.get() & 255;
    }

    private int k() {
        int j = j();
        if (j <= 0) {
            return j;
        }
        ByteBuffer byteBuffer = this.f35084e;
        byteBuffer.get(this.f35085f, 0, Math.min(j, byteBuffer.remaining()));
        return j;
    }

    private Bitmap l() {
        Boolean bool = this.t;
        Bitmap a2 = this.f35083d.a(this.s, this.r, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.u);
        a2.setHasAlpha(true);
        return a2;
    }

    public int a(int i) {
        if (i >= 0) {
            c cVar = this.m;
            if (i < cVar.f35070c) {
                return cVar.f35072e.get(i).i;
            }
        }
        return -1;
    }

    @Override // com.kwad.sdk.glide.b.a
    @NonNull
    public ByteBuffer a() {
        return this.f35084e;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void a(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.u = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    public synchronized void a(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int highestOneBit = Integer.highestOneBit(i);
        this.p = 0;
        this.m = cVar;
        this.l = -1;
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f35084e = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f35084e.order(ByteOrder.LITTLE_ENDIAN);
        this.o = false;
        Iterator<b> it = cVar.f35072e.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().f35066g == 3) {
                this.o = true;
                break;
            }
        }
        this.q = highestOneBit;
        this.s = cVar.f35073f / highestOneBit;
        this.r = cVar.f35074g / highestOneBit;
        this.j = this.f35083d.a(cVar.f35073f * cVar.f35074g);
        this.k = this.f35083d.b(this.s * this.r);
    }

    @Override // com.kwad.sdk.glide.b.a
    public void b() {
        this.l = (this.l + 1) % this.m.f35070c;
    }

    @Override // com.kwad.sdk.glide.b.a
    public int c() {
        int i;
        if (this.m.f35070c <= 0 || (i = this.l) < 0) {
            return 0;
        }
        return a(i);
    }

    @Override // com.kwad.sdk.glide.b.a
    public int d() {
        return this.m.f35070c;
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
        return this.f35084e.limit() + this.j.length + (this.k.length * 4);
    }

    @Override // com.kwad.sdk.glide.b.a
    @Nullable
    public synchronized Bitmap h() {
        if (this.m.f35070c <= 0 || this.l < 0) {
            if (Log.isLoggable(f35080a, 3)) {
                String str = f35080a;
                Log.d(str, "Unable to decode frame, frameCount=" + this.m.f35070c + ", framePointer=" + this.l);
            }
            this.p = 1;
        }
        if (this.p != 1 && this.p != 2) {
            this.p = 0;
            if (this.f35085f == null) {
                this.f35085f = this.f35083d.a(255);
            }
            b bVar = this.m.f35072e.get(this.l);
            int i = this.l - 1;
            b bVar2 = i >= 0 ? this.m.f35072e.get(i) : null;
            int[] iArr = bVar.k != null ? bVar.k : this.m.f35068a;
            this.f35081b = iArr;
            if (iArr != null) {
                if (bVar.f35065f) {
                    System.arraycopy(iArr, 0, this.f35082c, 0, iArr.length);
                    int[] iArr2 = this.f35082c;
                    this.f35081b = iArr2;
                    iArr2[bVar.f35067h] = 0;
                }
                return a(bVar, bVar2);
            }
            if (Log.isLoggable(f35080a, 3)) {
                String str2 = f35080a;
                Log.d(str2, "No valid color table found for frame #" + this.l);
            }
            this.p = 1;
            return null;
        }
        if (Log.isLoggable(f35080a, 3)) {
            String str3 = f35080a;
            Log.d(str3, "Unable to decode frame, status=" + this.p);
        }
        return null;
    }

    @Override // com.kwad.sdk.glide.b.a
    public void i() {
        this.m = null;
        byte[] bArr = this.j;
        if (bArr != null) {
            this.f35083d.a(bArr);
        }
        int[] iArr = this.k;
        if (iArr != null) {
            this.f35083d.a(iArr);
        }
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.f35083d.a(bitmap);
        }
        this.n = null;
        this.f35084e = null;
        this.t = null;
        byte[] bArr2 = this.f35085f;
        if (bArr2 != null) {
            this.f35083d.a(bArr2);
        }
    }
}
