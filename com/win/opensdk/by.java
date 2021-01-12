package com.win.opensdk;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
/* loaded from: classes3.dex */
public class by {
    private static final String java = by.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private int f13733a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f34a;

    /* renamed from: a  reason: collision with other field name */
    private int[] f35a;

    /* renamed from: b  reason: collision with root package name */
    private int f13734b;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f36b;
    private int c;

    /* renamed from: c  reason: collision with other field name */
    private byte[] f37c;

    /* renamed from: case  reason: not valid java name */
    public int f38case;
    private int d;
    private int e;
    private int f;

    /* renamed from: java  reason: collision with other field name */
    public int f39java;

    /* renamed from: java  reason: collision with other field name */
    private int[] f40java;
    private boolean pYL;
    private boolean pZl;
    private final int[] pZt;
    private byte[] pZy;
    private Bitmap qaB;
    private ByteBuffer qaL;
    @Nullable
    private byte[] qaM;
    private cb qaN;
    private short[] qaO;
    public ca qaP;
    private a qaQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a {
        byte[] RK(int i);

        int[] RL(int i);

        @NonNull
        Bitmap j(int i, int i2, Bitmap.Config config);
    }

    private by(a aVar) {
        this.pZt = new int[256];
        this.f13733a = 0;
        this.f13734b = 0;
        this.qaQ = aVar;
        this.qaP = new ca();
    }

    public by() {
        this(new cc());
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:222:0x0251 */
    /* JADX DEBUG: Multi-variable search result rejected for r7v38, resolved type: short */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x043e, code lost:
        r4 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized Bitmap eHb() {
        Bitmap bitmap;
        bz bzVar;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        short s;
        int i8;
        if (this.qaP.f43case <= 0 || this.f39java < 0) {
            this.c = 1;
        }
        if (this.c == 1 || this.c == 2) {
            bitmap = null;
        } else {
            this.c = 0;
            bz bzVar2 = this.qaP.pZM.get(this.f39java);
            int i9 = this.f39java - 1;
            if (i9 < 0) {
                bzVar = null;
            } else {
                bzVar = this.qaP.pZM.get(i9);
            }
            this.f40java = bzVar2.f42java != null ? bzVar2.f42java : this.qaP.f44java;
            if (this.f40java == null) {
                this.c = 1;
                bitmap = null;
            } else {
                if (bzVar2.pZl) {
                    System.arraycopy(this.f40java, 0, this.pZt, 0, this.f40java.length);
                    this.f40java = this.pZt;
                    this.f40java[bzVar2.d] = 0;
                }
                int[] iArr = this.f35a;
                if (bzVar == null) {
                    Arrays.fill(iArr, 0);
                }
                if (bzVar != null && bzVar.c > 0) {
                    if (bzVar.c == 2) {
                        int i10 = 0;
                        if (!bzVar2.pZl) {
                            i10 = this.qaP.f;
                            if (bzVar2.f42java != null && this.qaP.d == bzVar2.d) {
                                i10 = 0;
                            }
                        } else if (this.f39java == 0) {
                            this.pZl = true;
                        }
                        a(iArr, bzVar, i10);
                    } else if (bzVar.c == 3) {
                        if (this.qaB == null) {
                            a(iArr, bzVar, 0);
                        } else {
                            int i11 = bzVar.f13736b / this.d;
                            int i12 = bzVar.f41case / this.d;
                            int i13 = bzVar.f13735a / this.d;
                            int i14 = bzVar.java / this.d;
                            this.qaB.getPixels(iArr, (this.f * i12) + i14, this.f, i14, i12, i13, i11);
                        }
                    }
                }
                this.f13733a = 0;
                this.f13734b = 0;
                if (bzVar2 != null) {
                    this.qaL.position(bzVar2.f);
                }
                int i15 = bzVar2 == null ? this.qaP.f13737a * this.qaP.f13738b : bzVar2.f13735a * bzVar2.f13736b;
                if (this.f37c == null || this.f37c.length < i15) {
                    this.f37c = this.qaQ.RK(i15);
                }
                if (this.qaO == null) {
                    this.qaO = new short[4096];
                }
                if (this.f34a == null) {
                    this.f34a = new byte[4096];
                }
                if (this.f36b == null) {
                    this.f36b = new byte[4097];
                }
                int eGL = eGL();
                int i16 = 1 << eGL;
                int i17 = i16 + 1;
                int i18 = i16 + 2;
                int i19 = eGL + 1;
                int i20 = (1 << i19) - 1;
                for (int i21 = 0; i21 < i16; i21++) {
                    this.qaO[i21] = 0;
                    this.f34a[i21] = (byte) i21;
                }
                int i22 = 0;
                int i23 = 0;
                int i24 = -1;
                int i25 = 0;
                int i26 = 0;
                int i27 = 0;
                int i28 = 0;
                int i29 = 0;
                int i30 = 0;
                while (true) {
                    if (i22 >= i15) {
                        break;
                    }
                    if (i30 == 0) {
                        int eHc = eHc();
                        if (eHc <= 0) {
                            this.c = 3;
                            break;
                        }
                        i6 = 0;
                        i7 = eHc;
                    } else {
                        i6 = i26;
                        i7 = i30;
                    }
                    int i31 = i29 + ((this.pZy[i6] & 255) << i23);
                    int i32 = i23 + 8;
                    i26 = i6 + 1;
                    i30 = i7 - 1;
                    int i33 = i24;
                    int i34 = i28;
                    i29 = i31;
                    while (true) {
                        if (i32 < i19) {
                            i23 = i32;
                            i24 = i33;
                            i28 = i34;
                            break;
                        }
                        int i35 = i29 & i20;
                        i29 >>= i19;
                        int i36 = i32 - i19;
                        if (i35 == i16) {
                            i19 = eGL + 1;
                            i20 = (1 << i19) - 1;
                            i18 = i16 + 2;
                            i32 = i36;
                            i33 = -1;
                        } else if (i35 > i18) {
                            this.c = 3;
                            i23 = i36;
                            i24 = i33;
                            i28 = i34;
                            break;
                        } else if (i35 == i17) {
                            i23 = i36;
                            i24 = i33;
                            i28 = i34;
                            break;
                        } else if (i33 == -1) {
                            this.f36b[i27] = this.f34a[i35];
                            i32 = i36;
                            i33 = i35;
                            i27++;
                            i34 = i35;
                        } else {
                            if (i35 >= i18) {
                                i8 = i27 + 1;
                                this.f36b[i27] = (byte) i34;
                                s = i33;
                            } else {
                                s = i35;
                                i8 = i27;
                            }
                            while (s >= i16) {
                                this.f36b[i8] = this.f34a[s];
                                s = this.qaO[s];
                                i8++;
                            }
                            i34 = this.f34a[s] & 255;
                            int i37 = i8 + 1;
                            this.f36b[i8] = (byte) i34;
                            if (i18 < 4096) {
                                this.qaO[i18] = (short) i33;
                                this.f34a[i18] = (byte) i34;
                                i18++;
                                if ((i18 & i20) == 0 && i18 < 4096) {
                                    i19++;
                                    i20 += i18;
                                }
                            }
                            int i38 = i37;
                            while (i38 > 0) {
                                i38--;
                                this.f37c[i25] = this.f36b[i38];
                                i22++;
                                i25++;
                            }
                            i32 = i36;
                            i33 = i35;
                            i27 = i38;
                        }
                    }
                }
                for (int i39 = i25; i39 < i15; i39++) {
                    this.f37c[i39] = 0;
                }
                int i40 = bzVar2.f13736b / this.d;
                int i41 = bzVar2.f41case / this.d;
                int i42 = bzVar2.f13735a / this.d;
                int i43 = bzVar2.java / this.d;
                int i44 = 1;
                int i45 = 8;
                int i46 = 0;
                boolean z = this.f39java == 0;
                int i47 = 0;
                while (i47 < i40) {
                    if (bzVar2.pYL) {
                        if (i46 >= i40) {
                            i44++;
                            switch (i44) {
                                case 2:
                                    i46 = 4;
                                    break;
                                case 3:
                                    i46 = 2;
                                    i45 = 4;
                                    break;
                                case 4:
                                    i46 = 1;
                                    i45 = 2;
                                    break;
                            }
                        }
                        i = i46;
                        i2 = i46 + i45;
                        i3 = i45;
                        i4 = i44;
                    } else {
                        i = i47;
                        i2 = i46;
                        i3 = i45;
                        i4 = i44;
                    }
                    int i48 = i + i41;
                    if (i48 < this.e) {
                        int i49 = i48 * this.f;
                        int i50 = i49 + i43;
                        int i51 = i50 + i42;
                        int i52 = this.f + i49 < i51 ? this.f + i49 : i51;
                        int i53 = this.d * i47 * bzVar2.f13735a;
                        int i54 = i53 + ((i52 - i50) * this.d);
                        int i55 = i50;
                        int i56 = i53;
                        while (i55 < i52) {
                            if (this.d == 1) {
                                i5 = this.f40java[this.f37c[i56] & 255];
                            } else {
                                int i57 = bzVar2.f13735a;
                                int i58 = 0;
                                int i59 = 0;
                                int i60 = 0;
                                int i61 = 0;
                                int i62 = 0;
                                for (int i63 = i56; i63 < this.d + i56 && i63 < this.f37c.length && i63 < i54; i63++) {
                                    int i64 = this.f40java[this.f37c[i63] & 255];
                                    if (i64 != 0) {
                                        i58 += (i64 >> 24) & 255;
                                        i59 += (i64 >> 16) & 255;
                                        i60 += (i64 >> 8) & 255;
                                        i61 += i64 & 255;
                                        i62++;
                                    }
                                }
                                for (int i65 = i56 + i57; i65 < i56 + i57 + this.d && i65 < this.f37c.length && i65 < i54; i65++) {
                                    int i66 = this.f40java[this.f37c[i65] & 255];
                                    if (i66 != 0) {
                                        i58 += (i66 >> 24) & 255;
                                        i59 += (i66 >> 16) & 255;
                                        i60 += (i66 >> 8) & 255;
                                        i61 += i66 & 255;
                                        i62++;
                                    }
                                }
                                i5 = (i61 / i62) | ((i60 / i62) << 8) | ((i59 / i62) << 16) | ((i58 / i62) << 24);
                            }
                            if (i5 != 0) {
                                iArr[i55] = i5;
                            } else if (!this.pZl && z) {
                                this.pZl = true;
                            }
                            i55++;
                            i56 += this.d;
                        }
                    }
                    i47++;
                    i46 = i2;
                    i45 = i3;
                    i44 = i4;
                }
                if (this.pYL && (bzVar2.c == 0 || bzVar2.c == 1)) {
                    if (this.qaB == null) {
                        this.qaB = eHd();
                    }
                    this.qaB.setPixels(iArr, 0, this.f, 0, 0, this.f, this.e);
                }
                bitmap = eHd();
                bitmap.setPixels(iArr, 0, this.f, 0, 0, this.f, this.e);
            }
        }
        return bitmap;
    }

    private synchronized void a(ca caVar, byte[] bArr) {
        a(caVar, ByteBuffer.wrap(bArr));
    }

    private synchronized void a(ca caVar, ByteBuffer byteBuffer) {
        b(caVar, byteBuffer);
    }

    private synchronized void b(ca caVar, ByteBuffer byteBuffer) {
        int highestOneBit = Integer.highestOneBit(1);
        this.c = 0;
        this.qaP = caVar;
        this.pZl = false;
        this.f39java = -1;
        this.f38case = 0;
        this.qaL = byteBuffer.asReadOnlyBuffer();
        this.qaL.position(0);
        this.qaL.order(ByteOrder.LITTLE_ENDIAN);
        this.pYL = false;
        Iterator<bz> it = caVar.pZM.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().c == 3) {
                this.pYL = true;
                break;
            }
        }
        this.d = highestOneBit;
        this.f = caVar.f13737a / highestOneBit;
        this.e = caVar.f13738b / highestOneBit;
        this.f37c = this.qaQ.RK(caVar.f13737a * caVar.f13738b);
        this.f35a = this.qaQ.RL(this.f * this.e);
    }

    public final synchronized int at(byte[] bArr) {
        if (this.qaN == null) {
            this.qaN = new cb();
        }
        cb cbVar = this.qaN;
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            cbVar.qaL = null;
            Arrays.fill(cbVar.pZy, (byte) 0);
            cbVar.qaP = new ca();
            cbVar.java = 0;
            cbVar.qaL = wrap.asReadOnlyBuffer();
            cbVar.qaL.position(0);
            cbVar.qaL.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            cbVar.qaL = null;
            cbVar.qaP.java = 2;
        }
        if (cbVar.qaL == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (!cbVar.java()) {
            cbVar.eGA();
            if (!cbVar.java()) {
                cbVar.eGz();
                if (cbVar.qaP.f43case < 0) {
                    cbVar.qaP.java = 1;
                }
            }
        }
        this.qaP = cbVar.qaP;
        if (bArr != null) {
            a(this.qaP, bArr);
        }
        return this.c;
    }

    private void a(int[] iArr, bz bzVar, int i) {
        int i2 = bzVar.f13736b / this.d;
        int i3 = bzVar.f41case / this.d;
        int i4 = bzVar.f13735a / this.d;
        int i5 = (i3 * this.f) + (bzVar.java / this.d);
        int i6 = i5 + (i2 * this.f);
        while (i5 < i6) {
            int i7 = i5 + i4;
            for (int i8 = i5; i8 < i7; i8++) {
                iArr[i8] = i;
            }
            i5 += this.f;
        }
    }

    private void eGz() {
        if (this.f13733a <= this.f13734b) {
            if (this.qaM == null) {
                this.qaM = this.qaQ.RK(16384);
            }
            this.f13734b = 0;
            this.f13733a = Math.min(this.qaL.remaining(), 16384);
            this.qaL.get(this.qaM, 0, this.f13733a);
        }
    }

    private int eGL() {
        try {
            eGz();
            byte[] bArr = this.qaM;
            int i = this.f13734b;
            this.f13734b = i + 1;
            return bArr[i] & 255;
        } catch (Exception e) {
            this.c = 1;
            return 0;
        }
    }

    private int eHc() {
        int eGL = eGL();
        if (eGL > 0) {
            try {
                if (this.pZy == null) {
                    this.pZy = this.qaQ.RK(255);
                }
                int i = this.f13733a - this.f13734b;
                if (i >= eGL) {
                    System.arraycopy(this.qaM, this.f13734b, this.pZy, 0, eGL);
                    this.f13734b += eGL;
                } else if (this.qaL.remaining() + i >= eGL) {
                    System.arraycopy(this.qaM, this.f13734b, this.pZy, 0, i);
                    this.f13734b = this.f13733a;
                    eGz();
                    int i2 = eGL - i;
                    System.arraycopy(this.qaM, 0, this.pZy, i, i2);
                    this.f13734b += i2;
                } else {
                    this.c = 1;
                }
            } catch (Exception e) {
                this.c = 1;
            }
        }
        return eGL;
    }

    private Bitmap eHd() {
        Bitmap j = this.qaQ.j(this.f, this.e, this.pZl ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        al(j);
        return j;
    }

    @TargetApi(12)
    private static void al(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }
}
