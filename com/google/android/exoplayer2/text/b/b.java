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
    private static final byte[] mzu = {0, 7, 8, 15};
    private static final byte[] mzv = {0, 119, -120, -1};
    private static final byte[] mzw = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private Bitmap bitmap;
    private final Canvas lEJ;
    private final a mzA;
    private final h mzB;
    private final Paint mzx = new Paint();
    private final Paint mzy;
    private final C0678b mzz;

    public b(int i, int i2) {
        this.mzx.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mzx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.mzx.setPathEffect(null);
        this.mzy = new Paint();
        this.mzy.setStyle(Paint.Style.FILL);
        this.mzy.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.mzy.setPathEffect(null);
        this.lEJ = new Canvas();
        this.mzz = new C0678b(719, 575, 0, 719, 0, 575);
        this.mzA = new a(0, dwT(), dwU(), dwV());
        this.mzB = new h(i, i2);
    }

    public void reset() {
        this.mzB.reset();
    }

    public List<com.google.android.exoplayer2.text.b> A(byte[] bArr, int i) {
        int i2;
        k kVar = new k(bArr, i);
        while (kVar.dyb() >= 48 && kVar.readBits(8) == 15) {
            a(kVar, this.mzB);
        }
        if (this.mzB.mAj == null) {
            return Collections.emptyList();
        }
        C0678b c0678b = this.mzB.mAi != null ? this.mzB.mAi : this.mzz;
        if (this.bitmap == null || c0678b.width + 1 != this.bitmap.getWidth() || c0678b.height + 1 != this.bitmap.getHeight()) {
            this.bitmap = Bitmap.createBitmap(c0678b.width + 1, c0678b.height + 1, Bitmap.Config.ARGB_8888);
            this.lEJ.setBitmap(this.bitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray = this.mzB.mAj.mzN;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= sparseArray.size()) {
                return arrayList;
            }
            e valueAt = sparseArray.valueAt(i4);
            f fVar = this.mzB.mzN.get(sparseArray.keyAt(i4));
            int i5 = valueAt.mzO + c0678b.mzF;
            int i6 = valueAt.mzP + c0678b.mzH;
            this.lEJ.clipRect(i5, i6, Math.min(fVar.width + i5, c0678b.mzG), Math.min(fVar.height + i6, c0678b.mzI), Region.Op.REPLACE);
            a aVar = this.mzB.mAe.get(fVar.mzS);
            a aVar2 = (aVar == null && (aVar = this.mzB.mAg.get(fVar.mzS)) == null) ? this.mzA : aVar;
            SparseArray<g> sparseArray2 = fVar.mzW;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= sparseArray2.size()) {
                    break;
                }
                int keyAt = sparseArray2.keyAt(i8);
                g valueAt2 = sparseArray2.valueAt(i8);
                c cVar = this.mzB.mAf.get(keyAt);
                if (cVar == null) {
                    cVar = this.mzB.mAh.get(keyAt);
                }
                if (cVar != null) {
                    a(cVar, aVar2, fVar.depth, valueAt2.mzY + i5, valueAt2.mzZ + i6, cVar.mzJ ? null : this.mzx, this.lEJ);
                }
                i7 = i8 + 1;
            }
            if (fVar.mzQ) {
                if (fVar.depth == 3) {
                    i2 = aVar2.mzE[fVar.mzT];
                } else if (fVar.depth == 2) {
                    i2 = aVar2.mzD[fVar.mzU];
                } else {
                    i2 = aVar2.mzC[fVar.mzV];
                }
                this.mzy.setColor(i2);
                this.lEJ.drawRect(i5, i6, fVar.width + i5, fVar.height + i6, this.mzy);
            }
            arrayList.add(new com.google.android.exoplayer2.text.b(Bitmap.createBitmap(this.bitmap, i5, i6, fVar.width, fVar.height), i5 / c0678b.width, 0, i6 / c0678b.height, 0, fVar.width / c0678b.width, fVar.height / c0678b.height));
            this.lEJ.drawColor(0, PorterDuff.Mode.CLEAR);
            i3 = i4 + 1;
        }
    }

    private static void a(k kVar, h hVar) {
        int readBits = kVar.readBits(8);
        int readBits2 = kVar.readBits(16);
        int readBits3 = kVar.readBits(16);
        int dyc = kVar.dyc() + readBits3;
        if (readBits3 * 8 > kVar.dyb()) {
            Log.w("DvbParser", "Data field length exceeds limit");
            kVar.JP(kVar.dyb());
            return;
        }
        switch (readBits) {
            case 16:
                if (readBits2 == hVar.mAc) {
                    d dVar = hVar.mAj;
                    d b = b(kVar, readBits3);
                    if (b.state != 0) {
                        hVar.mAj = b;
                        hVar.mzN.clear();
                        hVar.mAe.clear();
                        hVar.mAf.clear();
                        break;
                    } else if (dVar != null && dVar.version != b.version) {
                        hVar.mAj = b;
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.mAj;
                if (readBits2 == hVar.mAc && dVar2 != null) {
                    f c2 = c(kVar, readBits3);
                    if (dVar2.state == 0) {
                        c2.a(hVar.mzN.get(c2.id));
                    }
                    hVar.mzN.put(c2.id, c2);
                    break;
                }
                break;
            case 18:
                if (readBits2 == hVar.mAc) {
                    a d2 = d(kVar, readBits3);
                    hVar.mAe.put(d2.id, d2);
                    break;
                } else if (readBits2 == hVar.mAd) {
                    a d3 = d(kVar, readBits3);
                    hVar.mAg.put(d3.id, d3);
                    break;
                }
                break;
            case 19:
                if (readBits2 == hVar.mAc) {
                    c i = i(kVar);
                    hVar.mAf.put(i.id, i);
                    break;
                } else if (readBits2 == hVar.mAd) {
                    c i2 = i(kVar);
                    hVar.mAh.put(i2.id, i2);
                    break;
                }
                break;
            case 20:
                if (readBits2 == hVar.mAc) {
                    hVar.mAi = h(kVar);
                    break;
                }
                break;
        }
        kVar.skipBytes(dyc - kVar.dyc());
    }

    private static C0678b h(k kVar) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        kVar.JP(4);
        boolean dtY = kVar.dtY();
        kVar.JP(3);
        int readBits = kVar.readBits(16);
        int readBits2 = kVar.readBits(16);
        if (dtY) {
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
        boolean dtY = kVar.dtY();
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
        return new f(readBits, dtY, readBits2, readBits3, readBits4, readBits5, readBits6, readBits7, readBits8, readBits9, sparseArray);
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
        int[] dwT = dwT();
        int[] dwU = dwU();
        int[] dwV = dwV();
        while (i2 > 0) {
            int readBits6 = kVar.readBits(8);
            int readBits7 = kVar.readBits(8);
            int i3 = i2 - 2;
            if ((readBits7 & 128) != 0) {
                iArr = dwT;
            } else {
                iArr = (readBits7 & 64) != 0 ? dwU : dwV;
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
        return new a(readBits5, dwT, dwU, dwV);
    }

    private static c i(k kVar) {
        byte[] bArr;
        byte[] bArr2 = null;
        int readBits = kVar.readBits(16);
        kVar.JP(4);
        int readBits2 = kVar.readBits(2);
        boolean dtY = kVar.dtY();
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
        return new c(readBits, dtY, bArr, bArr2);
    }

    private static int[] dwT() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] dwU() {
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

    private static int[] dwV() {
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
            iArr = aVar.mzE;
        } else if (i == 2) {
            iArr = aVar.mzD;
        } else {
            iArr = aVar.mzC;
        }
        a(cVar.mzK, iArr, i, i2, i3, paint, canvas);
        a(cVar.mzL, iArr, i, i2, i3 + 1, paint, canvas);
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
        while (kVar.dyb() != 0) {
            switch (kVar.readBits(8)) {
                case 16:
                    if (i == 3) {
                        bArr5 = bArr7 == null ? mzv : bArr7;
                    } else if (i == 2) {
                        bArr5 = bArr6 == null ? mzu : bArr6;
                    } else {
                        bArr5 = null;
                    }
                    i5 = a(kVar, iArr, bArr5, i5, i4, paint, canvas);
                    kVar.dye();
                    bArr2 = bArr7;
                    bArr3 = bArr6;
                    break;
                case 17:
                    if (i == 3) {
                        bArr4 = 0 == 0 ? mzw : null;
                    } else {
                        bArr4 = null;
                    }
                    i5 = b(kVar, iArr, bArr4, i5, i4, paint, canvas);
                    kVar.dye();
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
            } else if (kVar.dtY()) {
                readBits = kVar.readBits(3) + 3;
                z = z2;
                readBits2 = kVar.readBits(2);
            } else if (!kVar.dtY()) {
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
            } else if (!kVar.dtY()) {
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
            } else if (!kVar.dtY()) {
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
            } else if (!kVar.dtY()) {
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
        public final int mAc;
        public final int mAd;
        public C0678b mAi;
        public d mAj;
        public final SparseArray<f> mzN = new SparseArray<>();
        public final SparseArray<a> mAe = new SparseArray<>();
        public final SparseArray<c> mAf = new SparseArray<>();
        public final SparseArray<a> mAg = new SparseArray<>();
        public final SparseArray<c> mAh = new SparseArray<>();

        public h(int i, int i2) {
            this.mAc = i;
            this.mAd = i2;
        }

        public void reset() {
            this.mzN.clear();
            this.mAe.clear();
            this.mAf.clear();
            this.mAg.clear();
            this.mAh.clear();
            this.mAi = null;
            this.mAj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.text.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0678b {
        public final int height;
        public final int mzF;
        public final int mzG;
        public final int mzH;
        public final int mzI;
        public final int width;

        public C0678b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.width = i;
            this.height = i2;
            this.mzF = i3;
            this.mzG = i4;
            this.mzH = i5;
            this.mzI = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class d {
        public final int mzM;
        public final SparseArray<e> mzN;
        public final int state;
        public final int version;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.mzM = i;
            this.version = i2;
            this.state = i3;
            this.mzN = sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class e {
        public final int mzO;
        public final int mzP;

        public e(int i, int i2) {
            this.mzO = i;
            this.mzP = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class f {
        public final int depth;
        public final int height;
        public final int id;
        public final boolean mzQ;
        public final int mzR;
        public final int mzS;
        public final int mzT;
        public final int mzU;
        public final int mzV;
        public final SparseArray<g> mzW;
        public final int width;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.id = i;
            this.mzQ = z;
            this.width = i2;
            this.height = i3;
            this.mzR = i4;
            this.depth = i5;
            this.mzS = i6;
            this.mzT = i7;
            this.mzU = i8;
            this.mzV = i9;
            this.mzW = sparseArray;
        }

        public void a(f fVar) {
            if (fVar != null) {
                SparseArray<g> sparseArray = fVar.mzW;
                for (int i = 0; i < sparseArray.size(); i++) {
                    this.mzW.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class g {
        public final int mAa;
        public final int mAb;
        public final int mzX;
        public final int mzY;
        public final int mzZ;
        public final int type;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.type = i;
            this.mzX = i2;
            this.mzY = i3;
            this.mzZ = i4;
            this.mAa = i5;
            this.mAb = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {
        public final int id;
        public final int[] mzC;
        public final int[] mzD;
        public final int[] mzE;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.id = i;
            this.mzC = iArr;
            this.mzD = iArr2;
            this.mzE = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class c {
        public final int id;
        public final boolean mzJ;
        public final byte[] mzK;
        public final byte[] mzL;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.id = i;
            this.mzJ = z;
            this.mzK = bArr;
            this.mzL = bArr2;
        }
    }
}
