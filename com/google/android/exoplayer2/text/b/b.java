package com.google.android.exoplayer2.text.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
final class b {
    private Bitmap bitmap;
    private final Canvas lEO;
    private final Paint mzC = new Paint();
    private final Paint mzD;
    private final C0678b mzE;
    private final a mzF;
    private final h mzG;
    private static final byte[] mzz = {0, 7, 8, 15};
    private static final byte[] mzA = {0, 119, -120, -1};
    private static final byte[] mzB = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    public b(int i, int i2) {
        this.mzC.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mzC.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.mzC.setPathEffect(null);
        this.mzD = new Paint();
        this.mzD.setStyle(Paint.Style.FILL);
        this.mzD.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.mzD.setPathEffect(null);
        this.lEO = new Canvas();
        this.mzE = new C0678b(719, 575, 0, 719, 0, 575);
        this.mzF = new a(0, dwV(), dwW(), dwX());
        this.mzG = new h(i, i2);
    }

    public void reset() {
        this.mzG.reset();
    }

    public List<com.google.android.exoplayer2.text.b> A(byte[] bArr, int i) {
        int i2;
        k kVar = new k(bArr, i);
        while (kVar.dyd() >= 48 && kVar.readBits(8) == 15) {
            a(kVar, this.mzG);
        }
        if (this.mzG.mAp == null) {
            return Collections.emptyList();
        }
        C0678b c0678b = this.mzG.mAo != null ? this.mzG.mAo : this.mzE;
        if (this.bitmap == null || c0678b.width + 1 != this.bitmap.getWidth() || c0678b.height + 1 != this.bitmap.getHeight()) {
            this.bitmap = Bitmap.createBitmap(c0678b.width + 1, c0678b.height + 1, Bitmap.Config.ARGB_8888);
            this.lEO.setBitmap(this.bitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray = this.mzG.mAp.mzS;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= sparseArray.size()) {
                return arrayList;
            }
            e valueAt = sparseArray.valueAt(i4);
            f fVar = this.mzG.mzS.get(sparseArray.keyAt(i4));
            int i5 = valueAt.mzT + c0678b.mzK;
            int i6 = valueAt.mzU + c0678b.mzM;
            this.lEO.clipRect(i5, i6, Math.min(fVar.width + i5, c0678b.mzL), Math.min(fVar.height + i6, c0678b.mzN), Region.Op.REPLACE);
            a aVar = this.mzG.mAj.get(fVar.mzX);
            a aVar2 = (aVar == null && (aVar = this.mzG.mAm.get(fVar.mzX)) == null) ? this.mzF : aVar;
            SparseArray<g> sparseArray2 = fVar.mAb;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= sparseArray2.size()) {
                    break;
                }
                int keyAt = sparseArray2.keyAt(i8);
                g valueAt2 = sparseArray2.valueAt(i8);
                c cVar = this.mzG.mAl.get(keyAt);
                if (cVar == null) {
                    cVar = this.mzG.mAn.get(keyAt);
                }
                if (cVar != null) {
                    a(cVar, aVar2, fVar.depth, valueAt2.mAd + i5, valueAt2.mAe + i6, cVar.mzO ? null : this.mzC, this.lEO);
                }
                i7 = i8 + 1;
            }
            if (fVar.mzV) {
                if (fVar.depth == 3) {
                    i2 = aVar2.mzJ[fVar.mzY];
                } else if (fVar.depth == 2) {
                    i2 = aVar2.mzI[fVar.mzZ];
                } else {
                    i2 = aVar2.mzH[fVar.mAa];
                }
                this.mzD.setColor(i2);
                this.lEO.drawRect(i5, i6, fVar.width + i5, fVar.height + i6, this.mzD);
            }
            arrayList.add(new com.google.android.exoplayer2.text.b(Bitmap.createBitmap(this.bitmap, i5, i6, fVar.width, fVar.height), i5 / c0678b.width, 0, i6 / c0678b.height, 0, fVar.width / c0678b.width, fVar.height / c0678b.height));
            this.lEO.drawColor(0, PorterDuff.Mode.CLEAR);
            i3 = i4 + 1;
        }
    }

    private static void a(k kVar, h hVar) {
        int readBits = kVar.readBits(8);
        int readBits2 = kVar.readBits(16);
        int readBits3 = kVar.readBits(16);
        int dye = kVar.dye() + readBits3;
        if (readBits3 * 8 > kVar.dyd()) {
            Log.w("DvbParser", "Data field length exceeds limit");
            kVar.JP(kVar.dyd());
            return;
        }
        switch (readBits) {
            case 16:
                if (readBits2 == hVar.mAh) {
                    d dVar = hVar.mAp;
                    d b = b(kVar, readBits3);
                    if (b.state != 0) {
                        hVar.mAp = b;
                        hVar.mzS.clear();
                        hVar.mAj.clear();
                        hVar.mAl.clear();
                        break;
                    } else if (dVar != null && dVar.version != b.version) {
                        hVar.mAp = b;
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.mAp;
                if (readBits2 == hVar.mAh && dVar2 != null) {
                    f c2 = c(kVar, readBits3);
                    if (dVar2.state == 0) {
                        c2.a(hVar.mzS.get(c2.id));
                    }
                    hVar.mzS.put(c2.id, c2);
                    break;
                }
                break;
            case 18:
                if (readBits2 == hVar.mAh) {
                    a d2 = d(kVar, readBits3);
                    hVar.mAj.put(d2.id, d2);
                    break;
                } else if (readBits2 == hVar.mAi) {
                    a d3 = d(kVar, readBits3);
                    hVar.mAm.put(d3.id, d3);
                    break;
                }
                break;
            case 19:
                if (readBits2 == hVar.mAh) {
                    c i = i(kVar);
                    hVar.mAl.put(i.id, i);
                    break;
                } else if (readBits2 == hVar.mAi) {
                    c i2 = i(kVar);
                    hVar.mAn.put(i2.id, i2);
                    break;
                }
                break;
            case 20:
                if (readBits2 == hVar.mAh) {
                    hVar.mAo = h(kVar);
                    break;
                }
                break;
        }
        kVar.skipBytes(dye - kVar.dye());
    }

    private static C0678b h(k kVar) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        kVar.JP(4);
        boolean dua = kVar.dua();
        kVar.JP(3);
        int readBits = kVar.readBits(16);
        int readBits2 = kVar.readBits(16);
        if (dua) {
            i3 = kVar.readBits(16);
            i2 = kVar.readBits(16);
            i4 = kVar.readBits(16);
            i = kVar.readBits(16);
        } else {
            i = readBits2;
            i2 = readBits;
            i3 = 0;
        }
        return new C0678b(readBits, readBits2, i3, i2, i4, i);
    }

    private static d b(k kVar, int i) {
        int readBits = kVar.readBits(8);
        int readBits2 = kVar.readBits(4);
        int readBits3 = kVar.readBits(2);
        kVar.JP(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int readBits4 = kVar.readBits(8);
            kVar.JP(8);
            i2 -= 6;
            sparseArray.put(readBits4, new e(kVar.readBits(16), kVar.readBits(16)));
        }
        return new d(readBits, readBits2, readBits3, sparseArray);
    }

    private static f c(k kVar, int i) {
        int readBits = kVar.readBits(8);
        kVar.JP(4);
        boolean dua = kVar.dua();
        kVar.JP(3);
        int readBits2 = kVar.readBits(16);
        int readBits3 = kVar.readBits(16);
        int readBits4 = kVar.readBits(3);
        int readBits5 = kVar.readBits(3);
        kVar.JP(2);
        int readBits6 = kVar.readBits(8);
        int readBits7 = kVar.readBits(8);
        int readBits8 = kVar.readBits(4);
        int readBits9 = kVar.readBits(2);
        kVar.JP(2);
        int i2 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int readBits10 = kVar.readBits(16);
            int readBits11 = kVar.readBits(2);
            int readBits12 = kVar.readBits(2);
            int readBits13 = kVar.readBits(12);
            kVar.JP(4);
            int readBits14 = kVar.readBits(12);
            int i3 = i2 - 6;
            int i4 = 0;
            int i5 = 0;
            if (readBits11 == 1 || readBits11 == 2) {
                i4 = kVar.readBits(8);
                i5 = kVar.readBits(8);
                i3 -= 2;
            }
            i2 = i3;
            sparseArray.put(readBits10, new g(readBits11, readBits12, readBits13, readBits14, i4, i5));
        }
        return new f(readBits, dua, readBits2, readBits3, readBits4, readBits5, readBits6, readBits7, readBits8, readBits9, sparseArray);
    }

    private static a d(k kVar, int i) {
        int[] iArr;
        int readBits;
        int readBits2;
        int readBits3;
        int readBits4;
        int readBits5 = kVar.readBits(8);
        kVar.JP(8);
        int i2 = i - 2;
        int[] dwV = dwV();
        int[] dwW = dwW();
        int[] dwX = dwX();
        while (i2 > 0) {
            int readBits6 = kVar.readBits(8);
            int readBits7 = kVar.readBits(8);
            int i3 = i2 - 2;
            if ((readBits7 & 128) != 0) {
                iArr = dwV;
            } else {
                iArr = (readBits7 & 64) != 0 ? dwW : dwX;
            }
            if ((readBits7 & 1) != 0) {
                readBits = kVar.readBits(8);
                readBits2 = kVar.readBits(8);
                readBits3 = kVar.readBits(8);
                readBits4 = kVar.readBits(8);
                i2 = i3 - 4;
            } else {
                readBits = kVar.readBits(6) << 2;
                readBits2 = kVar.readBits(4) << 4;
                readBits3 = kVar.readBits(4) << 4;
                readBits4 = kVar.readBits(2) << 6;
                i2 = i3 - 2;
            }
            if (readBits == 0) {
                readBits2 = 0;
                readBits3 = 0;
                readBits4 = 255;
            }
            iArr[readBits6] = L((byte) (255 - (readBits4 & 255)), v.al((int) (readBits + (1.402d * (readBits2 - 128))), 0, 255), v.al((int) ((readBits - (0.34414d * (readBits3 - 128))) - (0.71414d * (readBits2 - 128))), 0, 255), v.al((int) (readBits + (1.772d * (readBits3 - 128))), 0, 255));
        }
        return new a(readBits5, dwV, dwW, dwX);
    }

    private static c i(k kVar) {
        byte[] bArr;
        byte[] bArr2 = null;
        int readBits = kVar.readBits(16);
        kVar.JP(4);
        int readBits2 = kVar.readBits(2);
        boolean dua = kVar.dua();
        kVar.JP(1);
        if (readBits2 == 1) {
            kVar.JP(kVar.readBits(8) * 16);
            bArr = null;
        } else if (readBits2 == 0) {
            int readBits3 = kVar.readBits(16);
            int readBits4 = kVar.readBits(16);
            if (readBits3 > 0) {
                bArr = new byte[readBits3];
                kVar.C(bArr, 0, readBits3);
            } else {
                bArr = null;
            }
            if (readBits4 > 0) {
                bArr2 = new byte[readBits4];
                kVar.C(bArr2, 0, readBits4);
            } else {
                bArr2 = bArr;
            }
        } else {
            bArr = null;
        }
        return new c(readBits, dua, bArr, bArr2);
    }

    private static int[] dwV() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] dwW() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < iArr.length; i++) {
            if (i < 8) {
                iArr[i] = L(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                iArr[i] = L(255, (i & 1) != 0 ? 127 : 0, (i & 2) != 0 ? 127 : 0, (i & 4) != 0 ? 127 : 0);
            }
        }
        return iArr;
    }

    private static int[] dwX() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < iArr.length; i++) {
            if (i < 8) {
                iArr[i] = L(63, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                switch (i & 136) {
                    case 0:
                        iArr[i] = L(255, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 64) != 0 ? 170 : 0) + ((i & 4) != 0 ? 85 : 0));
                        continue;
                    case 8:
                        iArr[i] = L(127, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 64) != 0 ? 170 : 0) + ((i & 4) != 0 ? 85 : 0));
                        continue;
                    case 128:
                        iArr[i] = L(255, ((i & 1) != 0 ? 43 : 0) + 127 + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0), ((i & 64) != 0 ? 85 : 0) + ((i & 4) != 0 ? 43 : 0) + 127);
                        continue;
                    case 136:
                        iArr[i] = L(255, ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 64) != 0 ? 85 : 0) + ((i & 4) != 0 ? 43 : 0));
                        continue;
                }
            }
        }
        return iArr;
    }

    private static int L(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static void a(c cVar, a aVar, int i, int i2, int i3, Paint paint, Canvas canvas) {
        int[] iArr;
        if (i == 3) {
            iArr = aVar.mzJ;
        } else if (i == 2) {
            iArr = aVar.mzI;
        } else {
            iArr = aVar.mzH;
        }
        a(cVar.mzP, iArr, i, i2, i3, paint, canvas);
        a(cVar.mzQ, iArr, i, i2, i3 + 1, paint, canvas);
    }

    private static void a(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        k kVar = new k(bArr);
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        int i4 = i3;
        int i5 = i2;
        while (kVar.dyd() != 0) {
            switch (kVar.readBits(8)) {
                case 16:
                    if (i == 3) {
                        bArr5 = bArr7 == null ? mzA : bArr7;
                    } else if (i == 2) {
                        bArr5 = bArr6 == null ? mzz : bArr6;
                    } else {
                        bArr5 = null;
                    }
                    i5 = a(kVar, iArr, bArr5, i5, i4, paint, canvas);
                    kVar.dyg();
                    bArr2 = bArr7;
                    bArr3 = bArr6;
                    break;
                case 17:
                    if (i == 3) {
                        bArr4 = 0 == 0 ? mzB : null;
                    } else {
                        bArr4 = null;
                    }
                    i5 = b(kVar, iArr, bArr4, i5, i4, paint, canvas);
                    kVar.dyg();
                    bArr2 = bArr7;
                    bArr3 = bArr6;
                    break;
                case 18:
                    i5 = c(kVar, iArr, null, i5, i4, paint, canvas);
                    bArr2 = bArr7;
                    bArr3 = bArr6;
                    break;
                case 32:
                    bArr3 = a(4, 4, kVar);
                    bArr2 = bArr7;
                    break;
                case 33:
                    bArr2 = a(4, 8, kVar);
                    bArr3 = bArr6;
                    break;
                case 34:
                    bArr2 = a(16, 8, kVar);
                    bArr3 = bArr6;
                    break;
                case 240:
                    i4 += 2;
                    bArr2 = bArr7;
                    bArr3 = bArr6;
                    i5 = i2;
                    break;
                default:
                    bArr2 = bArr7;
                    bArr3 = bArr6;
                    break;
            }
            bArr7 = bArr2;
            bArr6 = bArr3;
        }
    }

    private static int a(k kVar, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int readBits;
        boolean z;
        byte readBits2;
        boolean z2 = false;
        while (true) {
            int readBits3 = kVar.readBits(2);
            if (readBits3 != 0) {
                readBits = 1;
                z = z2;
                readBits2 = readBits3;
            } else if (kVar.dua()) {
                readBits = kVar.readBits(3) + 3;
                z = z2;
                readBits2 = kVar.readBits(2);
            } else if (!kVar.dua()) {
                switch (kVar.readBits(2)) {
                    case 0:
                        readBits = 0;
                        z = true;
                        readBits2 = 0;
                        break;
                    case 1:
                        readBits = 2;
                        z = z2;
                        readBits2 = 0;
                        break;
                    case 2:
                        readBits = kVar.readBits(4) + 12;
                        z = z2;
                        readBits2 = kVar.readBits(2);
                        break;
                    case 3:
                        readBits = kVar.readBits(8) + 29;
                        z = z2;
                        readBits2 = kVar.readBits(2);
                        break;
                    default:
                        readBits = 0;
                        z = z2;
                        readBits2 = 0;
                        break;
                }
            } else {
                readBits = 1;
                z = z2;
                readBits2 = 0;
            }
            if (readBits != 0 && paint != null) {
                if (bArr != null) {
                    readBits2 = bArr[readBits2];
                }
                paint.setColor(iArr[readBits2]);
                canvas.drawRect(i, i2, i + readBits, i2 + 1, paint);
            }
            i += readBits;
            if (z) {
                return i;
            }
            z2 = z;
        }
    }

    private static int b(k kVar, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int readBits;
        boolean z;
        byte readBits2;
        boolean z2 = false;
        while (true) {
            int readBits3 = kVar.readBits(4);
            if (readBits3 != 0) {
                readBits = 1;
                z = z2;
                readBits2 = readBits3;
            } else if (!kVar.dua()) {
                int readBits4 = kVar.readBits(3);
                if (readBits4 == 0) {
                    readBits = 0;
                    z = true;
                    readBits2 = 0;
                } else {
                    readBits = readBits4 + 2;
                    z = z2;
                    readBits2 = 0;
                }
            } else if (!kVar.dua()) {
                readBits = kVar.readBits(2) + 4;
                z = z2;
                readBits2 = kVar.readBits(4);
            } else {
                switch (kVar.readBits(2)) {
                    case 0:
                        readBits = 1;
                        z = z2;
                        readBits2 = 0;
                        break;
                    case 1:
                        readBits = 2;
                        z = z2;
                        readBits2 = 0;
                        break;
                    case 2:
                        readBits = kVar.readBits(4) + 9;
                        z = z2;
                        readBits2 = kVar.readBits(4);
                        break;
                    case 3:
                        readBits = kVar.readBits(8) + 25;
                        z = z2;
                        readBits2 = kVar.readBits(4);
                        break;
                    default:
                        readBits = 0;
                        z = z2;
                        readBits2 = 0;
                        break;
                }
            }
            if (readBits != 0 && paint != null) {
                if (bArr != null) {
                    readBits2 = bArr[readBits2];
                }
                paint.setColor(iArr[readBits2]);
                canvas.drawRect(i, i2, i + readBits, i2 + 1, paint);
            }
            i += readBits;
            if (z) {
                return i;
            }
            z2 = z;
        }
    }

    private static int c(k kVar, int[] iArr, byte[] bArr, int i, int i2, Paint paint, Canvas canvas) {
        int readBits;
        boolean z;
        byte readBits2;
        boolean z2 = false;
        while (true) {
            int readBits3 = kVar.readBits(8);
            if (readBits3 != 0) {
                readBits = 1;
                z = z2;
                readBits2 = readBits3;
            } else if (!kVar.dua()) {
                int readBits4 = kVar.readBits(7);
                if (readBits4 == 0) {
                    readBits = 0;
                    z = true;
                    readBits2 = 0;
                } else {
                    readBits = readBits4;
                    z = z2;
                    readBits2 = 0;
                }
            } else {
                readBits = kVar.readBits(7);
                z = z2;
                readBits2 = kVar.readBits(8);
            }
            if (readBits != 0 && paint != null) {
                if (bArr != null) {
                    readBits2 = bArr[readBits2];
                }
                paint.setColor(iArr[readBits2]);
                canvas.drawRect(i, i2, i + readBits, i2 + 1, paint);
            }
            i += readBits;
            if (z) {
                return i;
            }
            z2 = z;
        }
    }

    private static byte[] a(int i, int i2, k kVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) kVar.readBits(i2);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class h {
        public final int mAh;
        public final int mAi;
        public C0678b mAo;
        public d mAp;
        public final SparseArray<f> mzS = new SparseArray<>();
        public final SparseArray<a> mAj = new SparseArray<>();
        public final SparseArray<c> mAl = new SparseArray<>();
        public final SparseArray<a> mAm = new SparseArray<>();
        public final SparseArray<c> mAn = new SparseArray<>();

        public h(int i, int i2) {
            this.mAh = i;
            this.mAi = i2;
        }

        public void reset() {
            this.mzS.clear();
            this.mAj.clear();
            this.mAl.clear();
            this.mAm.clear();
            this.mAn.clear();
            this.mAo = null;
            this.mAp = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.text.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0678b {
        public final int height;
        public final int mzK;
        public final int mzL;
        public final int mzM;
        public final int mzN;
        public final int width;

        public C0678b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.width = i;
            this.height = i2;
            this.mzK = i3;
            this.mzL = i4;
            this.mzM = i5;
            this.mzN = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class d {
        public final int mzR;
        public final SparseArray<e> mzS;
        public final int state;
        public final int version;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.mzR = i;
            this.version = i2;
            this.state = i3;
            this.mzS = sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class e {
        public final int mzT;
        public final int mzU;

        public e(int i, int i2) {
            this.mzT = i;
            this.mzU = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class f {
        public final int depth;
        public final int height;
        public final int id;
        public final int mAa;
        public final SparseArray<g> mAb;
        public final boolean mzV;
        public final int mzW;
        public final int mzX;
        public final int mzY;
        public final int mzZ;
        public final int width;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.id = i;
            this.mzV = z;
            this.width = i2;
            this.height = i3;
            this.mzW = i4;
            this.depth = i5;
            this.mzX = i6;
            this.mzY = i7;
            this.mzZ = i8;
            this.mAa = i9;
            this.mAb = sparseArray;
        }

        public void a(f fVar) {
            if (fVar != null) {
                SparseArray<g> sparseArray = fVar.mAb;
                for (int i = 0; i < sparseArray.size(); i++) {
                    this.mAb.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class g {
        public final int mAc;
        public final int mAd;
        public final int mAe;
        public final int mAf;
        public final int mAg;
        public final int type;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.type = i;
            this.mAc = i2;
            this.mAd = i3;
            this.mAe = i4;
            this.mAf = i5;
            this.mAg = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        public final int id;
        public final int[] mzH;
        public final int[] mzI;
        public final int[] mzJ;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.id = i;
            this.mzH = iArr;
            this.mzI = iArr2;
            this.mzJ = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class c {
        public final int id;
        public final boolean mzO;
        public final byte[] mzP;
        public final byte[] mzQ;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.id = i;
            this.mzO = z;
            this.mzP = bArr;
            this.mzQ = bArr2;
        }
    }
}
