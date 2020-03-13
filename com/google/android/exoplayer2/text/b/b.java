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
/* loaded from: classes6.dex */
final class b {
    private static final byte[] mAt = {0, 7, 8, 15};
    private static final byte[] mAu = {0, 119, -120, -1};
    private static final byte[] mAv = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private Bitmap bitmap;
    private final Canvas lFI;
    private final h mAA;
    private final Paint mAw = new Paint();
    private final Paint mAx;
    private final C0686b mAy;
    private final a mAz;

    public b(int i, int i2) {
        this.mAw.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mAw.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.mAw.setPathEffect(null);
        this.mAx = new Paint();
        this.mAx.setStyle(Paint.Style.FILL);
        this.mAx.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.mAx.setPathEffect(null);
        this.lFI = new Canvas();
        this.mAy = new C0686b(719, 575, 0, 719, 0, 575);
        this.mAz = new a(0, dyi(), dyj(), dyk());
        this.mAA = new h(i, i2);
    }

    public void reset() {
        this.mAA.reset();
    }

    public List<com.google.android.exoplayer2.text.b> C(byte[] bArr, int i) {
        int i2;
        k kVar = new k(bArr, i);
        while (kVar.dzq() >= 48 && kVar.readBits(8) == 15) {
            a(kVar, this.mAA);
        }
        if (this.mAA.mBj == null) {
            return Collections.emptyList();
        }
        C0686b c0686b = this.mAA.mBi != null ? this.mAA.mBi : this.mAy;
        if (this.bitmap == null || c0686b.width + 1 != this.bitmap.getWidth() || c0686b.height + 1 != this.bitmap.getHeight()) {
            this.bitmap = Bitmap.createBitmap(c0686b.width + 1, c0686b.height + 1, Bitmap.Config.ARGB_8888);
            this.lFI.setBitmap(this.bitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray = this.mAA.mBj.mAM;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= sparseArray.size()) {
                return arrayList;
            }
            e valueAt = sparseArray.valueAt(i4);
            f fVar = this.mAA.mAM.get(sparseArray.keyAt(i4));
            int i5 = valueAt.mAN + c0686b.mAE;
            int i6 = valueAt.mAO + c0686b.mAG;
            this.lFI.clipRect(i5, i6, Math.min(fVar.width + i5, c0686b.mAF), Math.min(fVar.height + i6, c0686b.mAH), Region.Op.REPLACE);
            a aVar = this.mAA.mBd.get(fVar.mAR);
            a aVar2 = (aVar == null && (aVar = this.mAA.mBf.get(fVar.mAR)) == null) ? this.mAz : aVar;
            SparseArray<g> sparseArray2 = fVar.mAV;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= sparseArray2.size()) {
                    break;
                }
                int keyAt = sparseArray2.keyAt(i8);
                g valueAt2 = sparseArray2.valueAt(i8);
                c cVar = this.mAA.mBe.get(keyAt);
                if (cVar == null) {
                    cVar = this.mAA.mBh.get(keyAt);
                }
                if (cVar != null) {
                    a(cVar, aVar2, fVar.depth, valueAt2.mAX + i5, valueAt2.mAY + i6, cVar.mAI ? null : this.mAw, this.lFI);
                }
                i7 = i8 + 1;
            }
            if (fVar.mAP) {
                if (fVar.depth == 3) {
                    i2 = aVar2.mAD[fVar.mAS];
                } else if (fVar.depth == 2) {
                    i2 = aVar2.mAC[fVar.mAT];
                } else {
                    i2 = aVar2.mAB[fVar.mAU];
                }
                this.mAx.setColor(i2);
                this.lFI.drawRect(i5, i6, fVar.width + i5, fVar.height + i6, this.mAx);
            }
            arrayList.add(new com.google.android.exoplayer2.text.b(Bitmap.createBitmap(this.bitmap, i5, i6, fVar.width, fVar.height), i5 / c0686b.width, 0, i6 / c0686b.height, 0, fVar.width / c0686b.width, fVar.height / c0686b.height));
            this.lFI.drawColor(0, PorterDuff.Mode.CLEAR);
            i3 = i4 + 1;
        }
    }

    private static void a(k kVar, h hVar) {
        int readBits = kVar.readBits(8);
        int readBits2 = kVar.readBits(16);
        int readBits3 = kVar.readBits(16);
        int dzr = kVar.dzr() + readBits3;
        if (readBits3 * 8 > kVar.dzq()) {
            Log.w("DvbParser", "Data field length exceeds limit");
            kVar.JU(kVar.dzq());
            return;
        }
        switch (readBits) {
            case 16:
                if (readBits2 == hVar.mBb) {
                    d dVar = hVar.mBj;
                    d b = b(kVar, readBits3);
                    if (b.state != 0) {
                        hVar.mBj = b;
                        hVar.mAM.clear();
                        hVar.mBd.clear();
                        hVar.mBe.clear();
                        break;
                    } else if (dVar != null && dVar.version != b.version) {
                        hVar.mBj = b;
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.mBj;
                if (readBits2 == hVar.mBb && dVar2 != null) {
                    f c2 = c(kVar, readBits3);
                    if (dVar2.state == 0) {
                        c2.a(hVar.mAM.get(c2.id));
                    }
                    hVar.mAM.put(c2.id, c2);
                    break;
                }
                break;
            case 18:
                if (readBits2 == hVar.mBb) {
                    a d2 = d(kVar, readBits3);
                    hVar.mBd.put(d2.id, d2);
                    break;
                } else if (readBits2 == hVar.mBc) {
                    a d3 = d(kVar, readBits3);
                    hVar.mBf.put(d3.id, d3);
                    break;
                }
                break;
            case 19:
                if (readBits2 == hVar.mBb) {
                    c i = i(kVar);
                    hVar.mBe.put(i.id, i);
                    break;
                } else if (readBits2 == hVar.mBc) {
                    c i2 = i(kVar);
                    hVar.mBh.put(i2.id, i2);
                    break;
                }
                break;
            case 20:
                if (readBits2 == hVar.mBb) {
                    hVar.mBi = h(kVar);
                    break;
                }
                break;
        }
        kVar.skipBytes(dzr - kVar.dzr());
    }

    private static C0686b h(k kVar) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        kVar.JU(4);
        boolean dvo = kVar.dvo();
        kVar.JU(3);
        int readBits = kVar.readBits(16);
        int readBits2 = kVar.readBits(16);
        if (dvo) {
            i3 = kVar.readBits(16);
            i2 = kVar.readBits(16);
            i4 = kVar.readBits(16);
            i = kVar.readBits(16);
        } else {
            i = readBits2;
            i2 = readBits;
            i3 = 0;
        }
        return new C0686b(readBits, readBits2, i3, i2, i4, i);
    }

    private static d b(k kVar, int i) {
        int readBits = kVar.readBits(8);
        int readBits2 = kVar.readBits(4);
        int readBits3 = kVar.readBits(2);
        kVar.JU(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int readBits4 = kVar.readBits(8);
            kVar.JU(8);
            i2 -= 6;
            sparseArray.put(readBits4, new e(kVar.readBits(16), kVar.readBits(16)));
        }
        return new d(readBits, readBits2, readBits3, sparseArray);
    }

    private static f c(k kVar, int i) {
        int readBits = kVar.readBits(8);
        kVar.JU(4);
        boolean dvo = kVar.dvo();
        kVar.JU(3);
        int readBits2 = kVar.readBits(16);
        int readBits3 = kVar.readBits(16);
        int readBits4 = kVar.readBits(3);
        int readBits5 = kVar.readBits(3);
        kVar.JU(2);
        int readBits6 = kVar.readBits(8);
        int readBits7 = kVar.readBits(8);
        int readBits8 = kVar.readBits(4);
        int readBits9 = kVar.readBits(2);
        kVar.JU(2);
        int i2 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int readBits10 = kVar.readBits(16);
            int readBits11 = kVar.readBits(2);
            int readBits12 = kVar.readBits(2);
            int readBits13 = kVar.readBits(12);
            kVar.JU(4);
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
        return new f(readBits, dvo, readBits2, readBits3, readBits4, readBits5, readBits6, readBits7, readBits8, readBits9, sparseArray);
    }

    private static a d(k kVar, int i) {
        int[] iArr;
        int readBits;
        int readBits2;
        int readBits3;
        int readBits4;
        int readBits5 = kVar.readBits(8);
        kVar.JU(8);
        int i2 = i - 2;
        int[] dyi = dyi();
        int[] dyj = dyj();
        int[] dyk = dyk();
        while (i2 > 0) {
            int readBits6 = kVar.readBits(8);
            int readBits7 = kVar.readBits(8);
            int i3 = i2 - 2;
            if ((readBits7 & 128) != 0) {
                iArr = dyi;
            } else {
                iArr = (readBits7 & 64) != 0 ? dyj : dyk;
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
            iArr[readBits6] = L((byte) (255 - (readBits4 & 255)), v.am((int) (readBits + (1.402d * (readBits2 - 128))), 0, 255), v.am((int) ((readBits - (0.34414d * (readBits3 - 128))) - (0.71414d * (readBits2 - 128))), 0, 255), v.am((int) (readBits + (1.772d * (readBits3 - 128))), 0, 255));
        }
        return new a(readBits5, dyi, dyj, dyk);
    }

    private static c i(k kVar) {
        byte[] bArr;
        byte[] bArr2 = null;
        int readBits = kVar.readBits(16);
        kVar.JU(4);
        int readBits2 = kVar.readBits(2);
        boolean dvo = kVar.dvo();
        kVar.JU(1);
        if (readBits2 == 1) {
            kVar.JU(kVar.readBits(8) * 16);
            bArr = null;
        } else if (readBits2 == 0) {
            int readBits3 = kVar.readBits(16);
            int readBits4 = kVar.readBits(16);
            if (readBits3 > 0) {
                bArr = new byte[readBits3];
                kVar.G(bArr, 0, readBits3);
            } else {
                bArr = null;
            }
            if (readBits4 > 0) {
                bArr2 = new byte[readBits4];
                kVar.G(bArr2, 0, readBits4);
            } else {
                bArr2 = bArr;
            }
        } else {
            bArr = null;
        }
        return new c(readBits, dvo, bArr, bArr2);
    }

    private static int[] dyi() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] dyj() {
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

    private static int[] dyk() {
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
            iArr = aVar.mAD;
        } else if (i == 2) {
            iArr = aVar.mAC;
        } else {
            iArr = aVar.mAB;
        }
        a(cVar.mAJ, iArr, i, i2, i3, paint, canvas);
        a(cVar.mAK, iArr, i, i2, i3 + 1, paint, canvas);
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
        while (kVar.dzq() != 0) {
            switch (kVar.readBits(8)) {
                case 16:
                    if (i == 3) {
                        bArr5 = bArr7 == null ? mAu : bArr7;
                    } else if (i == 2) {
                        bArr5 = bArr6 == null ? mAt : bArr6;
                    } else {
                        bArr5 = null;
                    }
                    i5 = a(kVar, iArr, bArr5, i5, i4, paint, canvas);
                    kVar.dzt();
                    bArr2 = bArr7;
                    bArr3 = bArr6;
                    break;
                case 17:
                    if (i == 3) {
                        bArr4 = 0 == 0 ? mAv : null;
                    } else {
                        bArr4 = null;
                    }
                    i5 = b(kVar, iArr, bArr4, i5, i4, paint, canvas);
                    kVar.dzt();
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
            } else if (kVar.dvo()) {
                readBits = kVar.readBits(3) + 3;
                z = z2;
                readBits2 = kVar.readBits(2);
            } else if (!kVar.dvo()) {
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
            } else if (!kVar.dvo()) {
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
            } else if (!kVar.dvo()) {
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
            } else if (!kVar.dvo()) {
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
    /* loaded from: classes6.dex */
    public static final class h {
        public final int mBb;
        public final int mBc;
        public C0686b mBi;
        public d mBj;
        public final SparseArray<f> mAM = new SparseArray<>();
        public final SparseArray<a> mBd = new SparseArray<>();
        public final SparseArray<c> mBe = new SparseArray<>();
        public final SparseArray<a> mBf = new SparseArray<>();
        public final SparseArray<c> mBh = new SparseArray<>();

        public h(int i, int i2) {
            this.mBb = i;
            this.mBc = i2;
        }

        public void reset() {
            this.mAM.clear();
            this.mBd.clear();
            this.mBe.clear();
            this.mBf.clear();
            this.mBh.clear();
            this.mBi = null;
            this.mBj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.text.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0686b {
        public final int height;
        public final int mAE;
        public final int mAF;
        public final int mAG;
        public final int mAH;
        public final int width;

        public C0686b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.width = i;
            this.height = i2;
            this.mAE = i3;
            this.mAF = i4;
            this.mAG = i5;
            this.mAH = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class d {
        public final int mAL;
        public final SparseArray<e> mAM;
        public final int state;
        public final int version;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.mAL = i;
            this.version = i2;
            this.state = i3;
            this.mAM = sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class e {
        public final int mAN;
        public final int mAO;

        public e(int i, int i2) {
            this.mAN = i;
            this.mAO = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class f {
        public final int depth;
        public final int height;
        public final int id;
        public final boolean mAP;
        public final int mAQ;
        public final int mAR;
        public final int mAS;
        public final int mAT;
        public final int mAU;
        public final SparseArray<g> mAV;
        public final int width;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.id = i;
            this.mAP = z;
            this.width = i2;
            this.height = i3;
            this.mAQ = i4;
            this.depth = i5;
            this.mAR = i6;
            this.mAS = i7;
            this.mAT = i8;
            this.mAU = i9;
            this.mAV = sparseArray;
        }

        public void a(f fVar) {
            if (fVar != null) {
                SparseArray<g> sparseArray = fVar.mAV;
                for (int i = 0; i < sparseArray.size(); i++) {
                    this.mAV.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class g {
        public final int mAW;
        public final int mAX;
        public final int mAY;
        public final int mAZ;
        public final int mBa;
        public final int type;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.type = i;
            this.mAW = i2;
            this.mAX = i3;
            this.mAY = i4;
            this.mAZ = i5;
            this.mBa = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final int id;
        public final int[] mAB;
        public final int[] mAC;
        public final int[] mAD;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.id = i;
            this.mAB = iArr;
            this.mAC = iArr2;
            this.mAD = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c {
        public final int id;
        public final boolean mAI;
        public final byte[] mAJ;
        public final byte[] mAK;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.id = i;
            this.mAI = z;
            this.mAJ = bArr;
            this.mAK = bArr2;
        }
    }
}
