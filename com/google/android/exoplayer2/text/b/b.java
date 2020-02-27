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
    private static final byte[] mAf = {0, 7, 8, 15};
    private static final byte[] mAg = {0, 119, -120, -1};
    private static final byte[] mAh = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private Bitmap bitmap;
    private final Canvas lFv;
    private final Paint mAi = new Paint();
    private final Paint mAj;
    private final C0686b mAl;
    private final a mAm;
    private final h mAn;

    public b(int i, int i2) {
        this.mAi.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mAi.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.mAi.setPathEffect(null);
        this.mAj = new Paint();
        this.mAj.setStyle(Paint.Style.FILL);
        this.mAj.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.mAj.setPathEffect(null);
        this.lFv = new Canvas();
        this.mAl = new C0686b(719, 575, 0, 719, 0, 575);
        this.mAm = new a(0, dyf(), dyg(), dyh());
        this.mAn = new h(i, i2);
    }

    public void reset() {
        this.mAn.reset();
    }

    public List<com.google.android.exoplayer2.text.b> C(byte[] bArr, int i) {
        int i2;
        k kVar = new k(bArr, i);
        while (kVar.dzn() >= 48 && kVar.readBits(8) == 15) {
            a(kVar, this.mAn);
        }
        if (this.mAn.mAV == null) {
            return Collections.emptyList();
        }
        C0686b c0686b = this.mAn.mAU != null ? this.mAn.mAU : this.mAl;
        if (this.bitmap == null || c0686b.width + 1 != this.bitmap.getWidth() || c0686b.height + 1 != this.bitmap.getHeight()) {
            this.bitmap = Bitmap.createBitmap(c0686b.width + 1, c0686b.height + 1, Bitmap.Config.ARGB_8888);
            this.lFv.setBitmap(this.bitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray = this.mAn.mAV.mAz;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= sparseArray.size()) {
                return arrayList;
            }
            e valueAt = sparseArray.valueAt(i4);
            f fVar = this.mAn.mAz.get(sparseArray.keyAt(i4));
            int i5 = valueAt.mAA + c0686b.mAr;
            int i6 = valueAt.mAB + c0686b.mAt;
            this.lFv.clipRect(i5, i6, Math.min(fVar.width + i5, c0686b.mAs), Math.min(fVar.height + i6, c0686b.mAu), Region.Op.REPLACE);
            a aVar = this.mAn.mAQ.get(fVar.mAE);
            a aVar2 = (aVar == null && (aVar = this.mAn.mAS.get(fVar.mAE)) == null) ? this.mAm : aVar;
            SparseArray<g> sparseArray2 = fVar.mAI;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= sparseArray2.size()) {
                    break;
                }
                int keyAt = sparseArray2.keyAt(i8);
                g valueAt2 = sparseArray2.valueAt(i8);
                c cVar = this.mAn.mAR.get(keyAt);
                if (cVar == null) {
                    cVar = this.mAn.mAT.get(keyAt);
                }
                if (cVar != null) {
                    a(cVar, aVar2, fVar.depth, valueAt2.mAK + i5, valueAt2.mAL + i6, cVar.mAv ? null : this.mAi, this.lFv);
                }
                i7 = i8 + 1;
            }
            if (fVar.mAC) {
                if (fVar.depth == 3) {
                    i2 = aVar2.mAq[fVar.mAF];
                } else if (fVar.depth == 2) {
                    i2 = aVar2.mAp[fVar.mAG];
                } else {
                    i2 = aVar2.mAo[fVar.mAH];
                }
                this.mAj.setColor(i2);
                this.lFv.drawRect(i5, i6, fVar.width + i5, fVar.height + i6, this.mAj);
            }
            arrayList.add(new com.google.android.exoplayer2.text.b(Bitmap.createBitmap(this.bitmap, i5, i6, fVar.width, fVar.height), i5 / c0686b.width, 0, i6 / c0686b.height, 0, fVar.width / c0686b.width, fVar.height / c0686b.height));
            this.lFv.drawColor(0, PorterDuff.Mode.CLEAR);
            i3 = i4 + 1;
        }
    }

    private static void a(k kVar, h hVar) {
        int readBits = kVar.readBits(8);
        int readBits2 = kVar.readBits(16);
        int readBits3 = kVar.readBits(16);
        int dzo = kVar.dzo() + readBits3;
        if (readBits3 * 8 > kVar.dzn()) {
            Log.w("DvbParser", "Data field length exceeds limit");
            kVar.JU(kVar.dzn());
            return;
        }
        switch (readBits) {
            case 16:
                if (readBits2 == hVar.mAO) {
                    d dVar = hVar.mAV;
                    d b = b(kVar, readBits3);
                    if (b.state != 0) {
                        hVar.mAV = b;
                        hVar.mAz.clear();
                        hVar.mAQ.clear();
                        hVar.mAR.clear();
                        break;
                    } else if (dVar != null && dVar.version != b.version) {
                        hVar.mAV = b;
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.mAV;
                if (readBits2 == hVar.mAO && dVar2 != null) {
                    f c2 = c(kVar, readBits3);
                    if (dVar2.state == 0) {
                        c2.a(hVar.mAz.get(c2.id));
                    }
                    hVar.mAz.put(c2.id, c2);
                    break;
                }
                break;
            case 18:
                if (readBits2 == hVar.mAO) {
                    a d2 = d(kVar, readBits3);
                    hVar.mAQ.put(d2.id, d2);
                    break;
                } else if (readBits2 == hVar.mAP) {
                    a d3 = d(kVar, readBits3);
                    hVar.mAS.put(d3.id, d3);
                    break;
                }
                break;
            case 19:
                if (readBits2 == hVar.mAO) {
                    c i = i(kVar);
                    hVar.mAR.put(i.id, i);
                    break;
                } else if (readBits2 == hVar.mAP) {
                    c i2 = i(kVar);
                    hVar.mAT.put(i2.id, i2);
                    break;
                }
                break;
            case 20:
                if (readBits2 == hVar.mAO) {
                    hVar.mAU = h(kVar);
                    break;
                }
                break;
        }
        kVar.skipBytes(dzo - kVar.dzo());
    }

    private static C0686b h(k kVar) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        kVar.JU(4);
        boolean dvl = kVar.dvl();
        kVar.JU(3);
        int readBits = kVar.readBits(16);
        int readBits2 = kVar.readBits(16);
        if (dvl) {
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
        boolean dvl = kVar.dvl();
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
        return new f(readBits, dvl, readBits2, readBits3, readBits4, readBits5, readBits6, readBits7, readBits8, readBits9, sparseArray);
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
        int[] dyf = dyf();
        int[] dyg = dyg();
        int[] dyh = dyh();
        while (i2 > 0) {
            int readBits6 = kVar.readBits(8);
            int readBits7 = kVar.readBits(8);
            int i3 = i2 - 2;
            if ((readBits7 & 128) != 0) {
                iArr = dyf;
            } else {
                iArr = (readBits7 & 64) != 0 ? dyg : dyh;
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
        return new a(readBits5, dyf, dyg, dyh);
    }

    private static c i(k kVar) {
        byte[] bArr;
        byte[] bArr2 = null;
        int readBits = kVar.readBits(16);
        kVar.JU(4);
        int readBits2 = kVar.readBits(2);
        boolean dvl = kVar.dvl();
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
        return new c(readBits, dvl, bArr, bArr2);
    }

    private static int[] dyf() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] dyg() {
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

    private static int[] dyh() {
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
            iArr = aVar.mAq;
        } else if (i == 2) {
            iArr = aVar.mAp;
        } else {
            iArr = aVar.mAo;
        }
        a(cVar.mAw, iArr, i, i2, i3, paint, canvas);
        a(cVar.mAx, iArr, i, i2, i3 + 1, paint, canvas);
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
        while (kVar.dzn() != 0) {
            switch (kVar.readBits(8)) {
                case 16:
                    if (i == 3) {
                        bArr5 = bArr7 == null ? mAg : bArr7;
                    } else if (i == 2) {
                        bArr5 = bArr6 == null ? mAf : bArr6;
                    } else {
                        bArr5 = null;
                    }
                    i5 = a(kVar, iArr, bArr5, i5, i4, paint, canvas);
                    kVar.dzq();
                    bArr2 = bArr7;
                    bArr3 = bArr6;
                    break;
                case 17:
                    if (i == 3) {
                        bArr4 = 0 == 0 ? mAh : null;
                    } else {
                        bArr4 = null;
                    }
                    i5 = b(kVar, iArr, bArr4, i5, i4, paint, canvas);
                    kVar.dzq();
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
            } else if (kVar.dvl()) {
                readBits = kVar.readBits(3) + 3;
                z = z2;
                readBits2 = kVar.readBits(2);
            } else if (!kVar.dvl()) {
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
            } else if (!kVar.dvl()) {
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
            } else if (!kVar.dvl()) {
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
            } else if (!kVar.dvl()) {
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
        public final int mAO;
        public final int mAP;
        public C0686b mAU;
        public d mAV;
        public final SparseArray<f> mAz = new SparseArray<>();
        public final SparseArray<a> mAQ = new SparseArray<>();
        public final SparseArray<c> mAR = new SparseArray<>();
        public final SparseArray<a> mAS = new SparseArray<>();
        public final SparseArray<c> mAT = new SparseArray<>();

        public h(int i, int i2) {
            this.mAO = i;
            this.mAP = i2;
        }

        public void reset() {
            this.mAz.clear();
            this.mAQ.clear();
            this.mAR.clear();
            this.mAS.clear();
            this.mAT.clear();
            this.mAU = null;
            this.mAV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.text.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0686b {
        public final int height;
        public final int mAr;
        public final int mAs;
        public final int mAt;
        public final int mAu;
        public final int width;

        public C0686b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.width = i;
            this.height = i2;
            this.mAr = i3;
            this.mAs = i4;
            this.mAt = i5;
            this.mAu = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class d {
        public final int mAy;
        public final SparseArray<e> mAz;
        public final int state;
        public final int version;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.mAy = i;
            this.version = i2;
            this.state = i3;
            this.mAz = sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class e {
        public final int mAA;
        public final int mAB;

        public e(int i, int i2) {
            this.mAA = i;
            this.mAB = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class f {
        public final int depth;
        public final int height;
        public final int id;
        public final boolean mAC;
        public final int mAD;
        public final int mAE;
        public final int mAF;
        public final int mAG;
        public final int mAH;
        public final SparseArray<g> mAI;
        public final int width;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.id = i;
            this.mAC = z;
            this.width = i2;
            this.height = i3;
            this.mAD = i4;
            this.depth = i5;
            this.mAE = i6;
            this.mAF = i7;
            this.mAG = i8;
            this.mAH = i9;
            this.mAI = sparseArray;
        }

        public void a(f fVar) {
            if (fVar != null) {
                SparseArray<g> sparseArray = fVar.mAI;
                for (int i = 0; i < sparseArray.size(); i++) {
                    this.mAI.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class g {
        public final int mAJ;
        public final int mAK;
        public final int mAL;
        public final int mAM;
        public final int mAN;
        public final int type;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.type = i;
            this.mAJ = i2;
            this.mAK = i3;
            this.mAL = i4;
            this.mAM = i5;
            this.mAN = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        public final int id;
        public final int[] mAo;
        public final int[] mAp;
        public final int[] mAq;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.id = i;
            this.mAo = iArr;
            this.mAp = iArr2;
            this.mAq = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class c {
        public final int id;
        public final boolean mAv;
        public final byte[] mAw;
        public final byte[] mAx;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.id = i;
            this.mAv = z;
            this.mAw = bArr;
            this.mAx = bArr2;
        }
    }
}
