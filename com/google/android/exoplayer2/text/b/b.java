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
    private static final byte[] mCa = {0, 7, 8, 15};
    private static final byte[] mCb = {0, 119, -120, -1};
    private static final byte[] mCc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private Bitmap bitmap;
    private final Canvas lHm;
    private final Paint mCd = new Paint();
    private final Paint mCe;
    private final C0687b mCf;
    private final a mCg;
    private final h mCh;

    public b(int i, int i2) {
        this.mCd.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mCd.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.mCd.setPathEffect(null);
        this.mCe = new Paint();
        this.mCe.setStyle(Paint.Style.FILL);
        this.mCe.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.mCe.setPathEffect(null);
        this.lHm = new Canvas();
        this.mCf = new C0687b(719, 575, 0, 719, 0, 575);
        this.mCg = new a(0, dyF(), dyG(), dyH());
        this.mCh = new h(i, i2);
    }

    public void reset() {
        this.mCh.reset();
    }

    public List<com.google.android.exoplayer2.text.b> C(byte[] bArr, int i) {
        int i2;
        k kVar = new k(bArr, i);
        while (kVar.dzN() >= 48 && kVar.readBits(8) == 15) {
            a(kVar, this.mCh);
        }
        if (this.mCh.mCQ == null) {
            return Collections.emptyList();
        }
        C0687b c0687b = this.mCh.mCP != null ? this.mCh.mCP : this.mCf;
        if (this.bitmap == null || c0687b.width + 1 != this.bitmap.getWidth() || c0687b.height + 1 != this.bitmap.getHeight()) {
            this.bitmap = Bitmap.createBitmap(c0687b.width + 1, c0687b.height + 1, Bitmap.Config.ARGB_8888);
            this.lHm.setBitmap(this.bitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray = this.mCh.mCQ.mCt;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= sparseArray.size()) {
                return arrayList;
            }
            e valueAt = sparseArray.valueAt(i4);
            f fVar = this.mCh.mCt.get(sparseArray.keyAt(i4));
            int i5 = valueAt.mCu + c0687b.mCl;
            int i6 = valueAt.mCw + c0687b.mCn;
            this.lHm.clipRect(i5, i6, Math.min(fVar.width + i5, c0687b.mCm), Math.min(fVar.height + i6, c0687b.mCo), Region.Op.REPLACE);
            a aVar = this.mCh.mCL.get(fVar.mCz);
            a aVar2 = (aVar == null && (aVar = this.mCh.mCN.get(fVar.mCz)) == null) ? this.mCg : aVar;
            SparseArray<g> sparseArray2 = fVar.mCD;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= sparseArray2.size()) {
                    break;
                }
                int keyAt = sparseArray2.keyAt(i8);
                g valueAt2 = sparseArray2.valueAt(i8);
                c cVar = this.mCh.mCM.get(keyAt);
                if (cVar == null) {
                    cVar = this.mCh.mCO.get(keyAt);
                }
                if (cVar != null) {
                    a(cVar, aVar2, fVar.depth, valueAt2.mCF + i5, valueAt2.mCG + i6, cVar.mCp ? null : this.mCd, this.lHm);
                }
                i7 = i8 + 1;
            }
            if (fVar.mCx) {
                if (fVar.depth == 3) {
                    i2 = aVar2.mCk[fVar.mCA];
                } else if (fVar.depth == 2) {
                    i2 = aVar2.mCj[fVar.mCB];
                } else {
                    i2 = aVar2.mCi[fVar.mCC];
                }
                this.mCe.setColor(i2);
                this.lHm.drawRect(i5, i6, fVar.width + i5, fVar.height + i6, this.mCe);
            }
            arrayList.add(new com.google.android.exoplayer2.text.b(Bitmap.createBitmap(this.bitmap, i5, i6, fVar.width, fVar.height), i5 / c0687b.width, 0, i6 / c0687b.height, 0, fVar.width / c0687b.width, fVar.height / c0687b.height));
            this.lHm.drawColor(0, PorterDuff.Mode.CLEAR);
            i3 = i4 + 1;
        }
    }

    private static void a(k kVar, h hVar) {
        int readBits = kVar.readBits(8);
        int readBits2 = kVar.readBits(16);
        int readBits3 = kVar.readBits(16);
        int dzO = kVar.dzO() + readBits3;
        if (readBits3 * 8 > kVar.dzN()) {
            Log.w("DvbParser", "Data field length exceeds limit");
            kVar.Ka(kVar.dzN());
            return;
        }
        switch (readBits) {
            case 16:
                if (readBits2 == hVar.mCJ) {
                    d dVar = hVar.mCQ;
                    d b = b(kVar, readBits3);
                    if (b.state != 0) {
                        hVar.mCQ = b;
                        hVar.mCt.clear();
                        hVar.mCL.clear();
                        hVar.mCM.clear();
                        break;
                    } else if (dVar != null && dVar.version != b.version) {
                        hVar.mCQ = b;
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.mCQ;
                if (readBits2 == hVar.mCJ && dVar2 != null) {
                    f c2 = c(kVar, readBits3);
                    if (dVar2.state == 0) {
                        c2.a(hVar.mCt.get(c2.id));
                    }
                    hVar.mCt.put(c2.id, c2);
                    break;
                }
                break;
            case 18:
                if (readBits2 == hVar.mCJ) {
                    a d2 = d(kVar, readBits3);
                    hVar.mCL.put(d2.id, d2);
                    break;
                } else if (readBits2 == hVar.mCK) {
                    a d3 = d(kVar, readBits3);
                    hVar.mCN.put(d3.id, d3);
                    break;
                }
                break;
            case 19:
                if (readBits2 == hVar.mCJ) {
                    c i = i(kVar);
                    hVar.mCM.put(i.id, i);
                    break;
                } else if (readBits2 == hVar.mCK) {
                    c i2 = i(kVar);
                    hVar.mCO.put(i2.id, i2);
                    break;
                }
                break;
            case 20:
                if (readBits2 == hVar.mCJ) {
                    hVar.mCP = h(kVar);
                    break;
                }
                break;
        }
        kVar.skipBytes(dzO - kVar.dzO());
    }

    private static C0687b h(k kVar) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        kVar.Ka(4);
        boolean dvL = kVar.dvL();
        kVar.Ka(3);
        int readBits = kVar.readBits(16);
        int readBits2 = kVar.readBits(16);
        if (dvL) {
            i3 = kVar.readBits(16);
            i2 = kVar.readBits(16);
            i4 = kVar.readBits(16);
            i = kVar.readBits(16);
        } else {
            i = readBits2;
            i2 = readBits;
            i3 = 0;
        }
        return new C0687b(readBits, readBits2, i3, i2, i4, i);
    }

    private static d b(k kVar, int i) {
        int readBits = kVar.readBits(8);
        int readBits2 = kVar.readBits(4);
        int readBits3 = kVar.readBits(2);
        kVar.Ka(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int readBits4 = kVar.readBits(8);
            kVar.Ka(8);
            i2 -= 6;
            sparseArray.put(readBits4, new e(kVar.readBits(16), kVar.readBits(16)));
        }
        return new d(readBits, readBits2, readBits3, sparseArray);
    }

    private static f c(k kVar, int i) {
        int readBits = kVar.readBits(8);
        kVar.Ka(4);
        boolean dvL = kVar.dvL();
        kVar.Ka(3);
        int readBits2 = kVar.readBits(16);
        int readBits3 = kVar.readBits(16);
        int readBits4 = kVar.readBits(3);
        int readBits5 = kVar.readBits(3);
        kVar.Ka(2);
        int readBits6 = kVar.readBits(8);
        int readBits7 = kVar.readBits(8);
        int readBits8 = kVar.readBits(4);
        int readBits9 = kVar.readBits(2);
        kVar.Ka(2);
        int i2 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int readBits10 = kVar.readBits(16);
            int readBits11 = kVar.readBits(2);
            int readBits12 = kVar.readBits(2);
            int readBits13 = kVar.readBits(12);
            kVar.Ka(4);
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
        return new f(readBits, dvL, readBits2, readBits3, readBits4, readBits5, readBits6, readBits7, readBits8, readBits9, sparseArray);
    }

    private static a d(k kVar, int i) {
        int[] iArr;
        int readBits;
        int readBits2;
        int readBits3;
        int readBits4;
        int readBits5 = kVar.readBits(8);
        kVar.Ka(8);
        int i2 = i - 2;
        int[] dyF = dyF();
        int[] dyG = dyG();
        int[] dyH = dyH();
        while (i2 > 0) {
            int readBits6 = kVar.readBits(8);
            int readBits7 = kVar.readBits(8);
            int i3 = i2 - 2;
            if ((readBits7 & 128) != 0) {
                iArr = dyF;
            } else {
                iArr = (readBits7 & 64) != 0 ? dyG : dyH;
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
        return new a(readBits5, dyF, dyG, dyH);
    }

    private static c i(k kVar) {
        byte[] bArr;
        byte[] bArr2 = null;
        int readBits = kVar.readBits(16);
        kVar.Ka(4);
        int readBits2 = kVar.readBits(2);
        boolean dvL = kVar.dvL();
        kVar.Ka(1);
        if (readBits2 == 1) {
            kVar.Ka(kVar.readBits(8) * 16);
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
        return new c(readBits, dvL, bArr, bArr2);
    }

    private static int[] dyF() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] dyG() {
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

    private static int[] dyH() {
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
            iArr = aVar.mCk;
        } else if (i == 2) {
            iArr = aVar.mCj;
        } else {
            iArr = aVar.mCi;
        }
        a(cVar.mCq, iArr, i, i2, i3, paint, canvas);
        a(cVar.mCr, iArr, i, i2, i3 + 1, paint, canvas);
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
        while (kVar.dzN() != 0) {
            switch (kVar.readBits(8)) {
                case 16:
                    if (i == 3) {
                        bArr5 = bArr7 == null ? mCb : bArr7;
                    } else if (i == 2) {
                        bArr5 = bArr6 == null ? mCa : bArr6;
                    } else {
                        bArr5 = null;
                    }
                    i5 = a(kVar, iArr, bArr5, i5, i4, paint, canvas);
                    kVar.dzQ();
                    bArr2 = bArr7;
                    bArr3 = bArr6;
                    break;
                case 17:
                    if (i == 3) {
                        bArr4 = 0 == 0 ? mCc : null;
                    } else {
                        bArr4 = null;
                    }
                    i5 = b(kVar, iArr, bArr4, i5, i4, paint, canvas);
                    kVar.dzQ();
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
            } else if (kVar.dvL()) {
                readBits = kVar.readBits(3) + 3;
                z = z2;
                readBits2 = kVar.readBits(2);
            } else if (!kVar.dvL()) {
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
            } else if (!kVar.dvL()) {
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
            } else if (!kVar.dvL()) {
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
            } else if (!kVar.dvL()) {
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
        public final int mCJ;
        public final int mCK;
        public C0687b mCP;
        public d mCQ;
        public final SparseArray<f> mCt = new SparseArray<>();
        public final SparseArray<a> mCL = new SparseArray<>();
        public final SparseArray<c> mCM = new SparseArray<>();
        public final SparseArray<a> mCN = new SparseArray<>();
        public final SparseArray<c> mCO = new SparseArray<>();

        public h(int i, int i2) {
            this.mCJ = i;
            this.mCK = i2;
        }

        public void reset() {
            this.mCt.clear();
            this.mCL.clear();
            this.mCM.clear();
            this.mCN.clear();
            this.mCO.clear();
            this.mCP = null;
            this.mCQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.text.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0687b {
        public final int height;
        public final int mCl;
        public final int mCm;
        public final int mCn;
        public final int mCo;
        public final int width;

        public C0687b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.width = i;
            this.height = i2;
            this.mCl = i3;
            this.mCm = i4;
            this.mCn = i5;
            this.mCo = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class d {
        public final int mCs;
        public final SparseArray<e> mCt;
        public final int state;
        public final int version;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.mCs = i;
            this.version = i2;
            this.state = i3;
            this.mCt = sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class e {
        public final int mCu;
        public final int mCw;

        public e(int i, int i2) {
            this.mCu = i;
            this.mCw = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class f {
        public final int depth;
        public final int height;
        public final int id;
        public final int mCA;
        public final int mCB;
        public final int mCC;
        public final SparseArray<g> mCD;
        public final boolean mCx;
        public final int mCy;
        public final int mCz;
        public final int width;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.id = i;
            this.mCx = z;
            this.width = i2;
            this.height = i3;
            this.mCy = i4;
            this.depth = i5;
            this.mCz = i6;
            this.mCA = i7;
            this.mCB = i8;
            this.mCC = i9;
            this.mCD = sparseArray;
        }

        public void a(f fVar) {
            if (fVar != null) {
                SparseArray<g> sparseArray = fVar.mCD;
                for (int i = 0; i < sparseArray.size(); i++) {
                    this.mCD.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class g {
        public final int mCE;
        public final int mCF;
        public final int mCG;
        public final int mCH;
        public final int mCI;
        public final int type;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.type = i;
            this.mCE = i2;
            this.mCF = i3;
            this.mCG = i4;
            this.mCH = i5;
            this.mCI = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final int id;
        public final int[] mCi;
        public final int[] mCj;
        public final int[] mCk;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.id = i;
            this.mCi = iArr;
            this.mCj = iArr2;
            this.mCk = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c {
        public final int id;
        public final boolean mCp;
        public final byte[] mCq;
        public final byte[] mCr;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.id = i;
            this.mCp = z;
            this.mCq = bArr;
            this.mCr = bArr2;
        }
    }
}
