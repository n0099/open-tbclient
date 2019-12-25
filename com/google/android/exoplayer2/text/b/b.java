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
/* loaded from: classes4.dex */
final class b {
    private static final byte[] mvH = {0, 7, 8, 15};
    private static final byte[] mvI = {0, 119, -120, -1};
    private static final byte[] mvJ = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private Bitmap bitmap;
    private final Canvas lBl;
    private final Paint mvK = new Paint();
    private final Paint mvL;
    private final C0672b mvM;
    private final a mvN;
    private final h mvO;

    public b(int i, int i2) {
        this.mvK.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mvK.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        this.mvK.setPathEffect(null);
        this.mvL = new Paint();
        this.mvL.setStyle(Paint.Style.FILL);
        this.mvL.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        this.mvL.setPathEffect(null);
        this.lBl = new Canvas();
        this.mvM = new C0672b(719, 575, 0, 719, 0, 575);
        this.mvN = new a(0, dvI(), dvJ(), dvK());
        this.mvO = new h(i, i2);
    }

    public void reset() {
        this.mvO.reset();
    }

    public List<com.google.android.exoplayer2.text.b> A(byte[] bArr, int i) {
        int i2;
        k kVar = new k(bArr, i);
        while (kVar.dwR() >= 48 && kVar.readBits(8) == 15) {
            a(kVar, this.mvO);
        }
        if (this.mvO.mww == null) {
            return Collections.emptyList();
        }
        C0672b c0672b = this.mvO.mwv != null ? this.mvO.mwv : this.mvM;
        if (this.bitmap == null || c0672b.width + 1 != this.bitmap.getWidth() || c0672b.height + 1 != this.bitmap.getHeight()) {
            this.bitmap = Bitmap.createBitmap(c0672b.width + 1, c0672b.height + 1, Bitmap.Config.ARGB_8888);
            this.lBl.setBitmap(this.bitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray = this.mvO.mww.mwa;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= sparseArray.size()) {
                return arrayList;
            }
            e valueAt = sparseArray.valueAt(i4);
            f fVar = this.mvO.mwa.get(sparseArray.keyAt(i4));
            int i5 = valueAt.mwb + c0672b.mvS;
            int i6 = valueAt.mwc + c0672b.mvU;
            this.lBl.clipRect(i5, i6, Math.min(fVar.width + i5, c0672b.mvT), Math.min(fVar.height + i6, c0672b.mvV), Region.Op.REPLACE);
            a aVar = this.mvO.mwr.get(fVar.mwf);
            a aVar2 = (aVar == null && (aVar = this.mvO.mwt.get(fVar.mwf)) == null) ? this.mvN : aVar;
            SparseArray<g> sparseArray2 = fVar.mwj;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= sparseArray2.size()) {
                    break;
                }
                int keyAt = sparseArray2.keyAt(i8);
                g valueAt2 = sparseArray2.valueAt(i8);
                c cVar = this.mvO.mws.get(keyAt);
                if (cVar == null) {
                    cVar = this.mvO.mwu.get(keyAt);
                }
                if (cVar != null) {
                    a(cVar, aVar2, fVar.depth, valueAt2.mwl + i5, valueAt2.mwm + i6, cVar.mvW ? null : this.mvK, this.lBl);
                }
                i7 = i8 + 1;
            }
            if (fVar.mwd) {
                if (fVar.depth == 3) {
                    i2 = aVar2.mvR[fVar.mwg];
                } else if (fVar.depth == 2) {
                    i2 = aVar2.mvQ[fVar.mwh];
                } else {
                    i2 = aVar2.mvP[fVar.mwi];
                }
                this.mvL.setColor(i2);
                this.lBl.drawRect(i5, i6, fVar.width + i5, fVar.height + i6, this.mvL);
            }
            arrayList.add(new com.google.android.exoplayer2.text.b(Bitmap.createBitmap(this.bitmap, i5, i6, fVar.width, fVar.height), i5 / c0672b.width, 0, i6 / c0672b.height, 0, fVar.width / c0672b.width, fVar.height / c0672b.height));
            this.lBl.drawColor(0, PorterDuff.Mode.CLEAR);
            i3 = i4 + 1;
        }
    }

    private static void a(k kVar, h hVar) {
        int readBits = kVar.readBits(8);
        int readBits2 = kVar.readBits(16);
        int readBits3 = kVar.readBits(16);
        int dwS = kVar.dwS() + readBits3;
        if (readBits3 * 8 > kVar.dwR()) {
            Log.w("DvbParser", "Data field length exceeds limit");
            kVar.JG(kVar.dwR());
            return;
        }
        switch (readBits) {
            case 16:
                if (readBits2 == hVar.mwp) {
                    d dVar = hVar.mww;
                    d b = b(kVar, readBits3);
                    if (b.state != 0) {
                        hVar.mww = b;
                        hVar.mwa.clear();
                        hVar.mwr.clear();
                        hVar.mws.clear();
                        break;
                    } else if (dVar != null && dVar.version != b.version) {
                        hVar.mww = b;
                        break;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.mww;
                if (readBits2 == hVar.mwp && dVar2 != null) {
                    f c2 = c(kVar, readBits3);
                    if (dVar2.state == 0) {
                        c2.a(hVar.mwa.get(c2.id));
                    }
                    hVar.mwa.put(c2.id, c2);
                    break;
                }
                break;
            case 18:
                if (readBits2 == hVar.mwp) {
                    a d2 = d(kVar, readBits3);
                    hVar.mwr.put(d2.id, d2);
                    break;
                } else if (readBits2 == hVar.mwq) {
                    a d3 = d(kVar, readBits3);
                    hVar.mwt.put(d3.id, d3);
                    break;
                }
                break;
            case 19:
                if (readBits2 == hVar.mwp) {
                    c i = i(kVar);
                    hVar.mws.put(i.id, i);
                    break;
                } else if (readBits2 == hVar.mwq) {
                    c i2 = i(kVar);
                    hVar.mwu.put(i2.id, i2);
                    break;
                }
                break;
            case 20:
                if (readBits2 == hVar.mwp) {
                    hVar.mwv = h(kVar);
                    break;
                }
                break;
        }
        kVar.skipBytes(dwS - kVar.dwS());
    }

    private static C0672b h(k kVar) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        kVar.JG(4);
        boolean dsM = kVar.dsM();
        kVar.JG(3);
        int readBits = kVar.readBits(16);
        int readBits2 = kVar.readBits(16);
        if (dsM) {
            i3 = kVar.readBits(16);
            i2 = kVar.readBits(16);
            i4 = kVar.readBits(16);
            i = kVar.readBits(16);
        } else {
            i = readBits2;
            i2 = readBits;
            i3 = 0;
        }
        return new C0672b(readBits, readBits2, i3, i2, i4, i);
    }

    private static d b(k kVar, int i) {
        int readBits = kVar.readBits(8);
        int readBits2 = kVar.readBits(4);
        int readBits3 = kVar.readBits(2);
        kVar.JG(2);
        int i2 = i - 2;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int readBits4 = kVar.readBits(8);
            kVar.JG(8);
            i2 -= 6;
            sparseArray.put(readBits4, new e(kVar.readBits(16), kVar.readBits(16)));
        }
        return new d(readBits, readBits2, readBits3, sparseArray);
    }

    private static f c(k kVar, int i) {
        int readBits = kVar.readBits(8);
        kVar.JG(4);
        boolean dsM = kVar.dsM();
        kVar.JG(3);
        int readBits2 = kVar.readBits(16);
        int readBits3 = kVar.readBits(16);
        int readBits4 = kVar.readBits(3);
        int readBits5 = kVar.readBits(3);
        kVar.JG(2);
        int readBits6 = kVar.readBits(8);
        int readBits7 = kVar.readBits(8);
        int readBits8 = kVar.readBits(4);
        int readBits9 = kVar.readBits(2);
        kVar.JG(2);
        int i2 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int readBits10 = kVar.readBits(16);
            int readBits11 = kVar.readBits(2);
            int readBits12 = kVar.readBits(2);
            int readBits13 = kVar.readBits(12);
            kVar.JG(4);
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
        return new f(readBits, dsM, readBits2, readBits3, readBits4, readBits5, readBits6, readBits7, readBits8, readBits9, sparseArray);
    }

    private static a d(k kVar, int i) {
        int[] iArr;
        int readBits;
        int readBits2;
        int readBits3;
        int readBits4;
        int readBits5 = kVar.readBits(8);
        kVar.JG(8);
        int i2 = i - 2;
        int[] dvI = dvI();
        int[] dvJ = dvJ();
        int[] dvK = dvK();
        while (i2 > 0) {
            int readBits6 = kVar.readBits(8);
            int readBits7 = kVar.readBits(8);
            int i3 = i2 - 2;
            if ((readBits7 & 128) != 0) {
                iArr = dvI;
            } else {
                iArr = (readBits7 & 64) != 0 ? dvJ : dvK;
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
        return new a(readBits5, dvI, dvJ, dvK);
    }

    private static c i(k kVar) {
        byte[] bArr;
        byte[] bArr2 = null;
        int readBits = kVar.readBits(16);
        kVar.JG(4);
        int readBits2 = kVar.readBits(2);
        boolean dsM = kVar.dsM();
        kVar.JG(1);
        if (readBits2 == 1) {
            kVar.JG(kVar.readBits(8) * 16);
            bArr = null;
        } else if (readBits2 == 0) {
            int readBits3 = kVar.readBits(16);
            int readBits4 = kVar.readBits(16);
            if (readBits3 > 0) {
                bArr = new byte[readBits3];
                kVar.D(bArr, 0, readBits3);
            } else {
                bArr = null;
            }
            if (readBits4 > 0) {
                bArr2 = new byte[readBits4];
                kVar.D(bArr2, 0, readBits4);
            } else {
                bArr2 = bArr;
            }
        } else {
            bArr = null;
        }
        return new c(readBits, dsM, bArr, bArr2);
    }

    private static int[] dvI() {
        return new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    private static int[] dvJ() {
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

    private static int[] dvK() {
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
            iArr = aVar.mvR;
        } else if (i == 2) {
            iArr = aVar.mvQ;
        } else {
            iArr = aVar.mvP;
        }
        a(cVar.mvX, iArr, i, i2, i3, paint, canvas);
        a(cVar.mvY, iArr, i, i2, i3 + 1, paint, canvas);
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
        while (kVar.dwR() != 0) {
            switch (kVar.readBits(8)) {
                case 16:
                    if (i == 3) {
                        bArr5 = bArr7 == null ? mvI : bArr7;
                    } else if (i == 2) {
                        bArr5 = bArr6 == null ? mvH : bArr6;
                    } else {
                        bArr5 = null;
                    }
                    i5 = a(kVar, iArr, bArr5, i5, i4, paint, canvas);
                    kVar.dwU();
                    bArr2 = bArr7;
                    bArr3 = bArr6;
                    break;
                case 17:
                    if (i == 3) {
                        bArr4 = 0 == 0 ? mvJ : null;
                    } else {
                        bArr4 = null;
                    }
                    i5 = b(kVar, iArr, bArr4, i5, i4, paint, canvas);
                    kVar.dwU();
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
            } else if (kVar.dsM()) {
                readBits = kVar.readBits(3) + 3;
                z = z2;
                readBits2 = kVar.readBits(2);
            } else if (!kVar.dsM()) {
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
            } else if (!kVar.dsM()) {
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
            } else if (!kVar.dsM()) {
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
            } else if (!kVar.dsM()) {
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
    /* loaded from: classes4.dex */
    public static final class h {
        public final int mwp;
        public final int mwq;
        public C0672b mwv;
        public d mww;
        public final SparseArray<f> mwa = new SparseArray<>();
        public final SparseArray<a> mwr = new SparseArray<>();
        public final SparseArray<c> mws = new SparseArray<>();
        public final SparseArray<a> mwt = new SparseArray<>();
        public final SparseArray<c> mwu = new SparseArray<>();

        public h(int i, int i2) {
            this.mwp = i;
            this.mwq = i2;
        }

        public void reset() {
            this.mwa.clear();
            this.mwr.clear();
            this.mws.clear();
            this.mwt.clear();
            this.mwu.clear();
            this.mwv = null;
            this.mww = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.android.exoplayer2.text.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0672b {
        public final int height;
        public final int mvS;
        public final int mvT;
        public final int mvU;
        public final int mvV;
        public final int width;

        public C0672b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.width = i;
            this.height = i2;
            this.mvS = i3;
            this.mvT = i4;
            this.mvU = i5;
            this.mvV = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class d {
        public final int mvZ;
        public final SparseArray<e> mwa;
        public final int state;
        public final int version;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.mvZ = i;
            this.version = i2;
            this.state = i3;
            this.mwa = sparseArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class e {
        public final int mwb;
        public final int mwc;

        public e(int i, int i2) {
            this.mwb = i;
            this.mwc = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class f {
        public final int depth;
        public final int height;
        public final int id;
        public final boolean mwd;
        public final int mwe;
        public final int mwf;
        public final int mwg;
        public final int mwh;
        public final int mwi;
        public final SparseArray<g> mwj;
        public final int width;

        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.id = i;
            this.mwd = z;
            this.width = i2;
            this.height = i3;
            this.mwe = i4;
            this.depth = i5;
            this.mwf = i6;
            this.mwg = i7;
            this.mwh = i8;
            this.mwi = i9;
            this.mwj = sparseArray;
        }

        public void a(f fVar) {
            if (fVar != null) {
                SparseArray<g> sparseArray = fVar.mwj;
                for (int i = 0; i < sparseArray.size(); i++) {
                    this.mwj.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class g {
        public final int mwk;
        public final int mwl;
        public final int mwm;
        public final int mwn;
        public final int mwo;
        public final int type;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.type = i;
            this.mwk = i2;
            this.mwl = i3;
            this.mwm = i4;
            this.mwn = i5;
            this.mwo = i6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a {
        public final int id;
        public final int[] mvP;
        public final int[] mvQ;
        public final int[] mvR;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.id = i;
            this.mvP = iArr;
            this.mvQ = iArr2;
            this.mvR = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class c {
        public final int id;
        public final boolean mvW;
        public final byte[] mvX;
        public final byte[] mvY;

        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.id = i;
            this.mvW = z;
            this.mvX = bArr;
            this.mvY = bArr2;
        }
    }
}
