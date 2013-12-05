package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.b;
import com.google.zxing.common.c;
import com.google.zxing.common.e;
import com.google.zxing.g;
import com.google.zxing.h;
import com.google.zxing.i;
import com.google.zxing.qrcode.decoder.m;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private static final i[] f2876a = new i[0];
    private final m b = new m();

    @Override // com.google.zxing.g
    public final h a(b bVar, Map<DecodeHintType, ?> map) {
        c a2;
        i[] b;
        if (map != null && map.containsKey(DecodeHintType.PURE_BARCODE)) {
            a2 = this.b.a(a(bVar.a()), map);
            b = f2876a;
        } else {
            e a3 = new com.google.zxing.qrcode.detector.c(bVar.a()).a(map);
            a2 = this.b.a(a3.a(), map);
            b = a3.b();
        }
        h hVar = new h(a2.b(), a2.a(), b, BarcodeFormat.QR_CODE);
        List<byte[]> c = a2.c();
        if (c != null) {
            hVar.a(ResultMetadataType.BYTE_SEGMENTS, c);
        }
        String d = a2.d();
        if (d != null) {
            hVar.a(ResultMetadataType.ERROR_CORRECTION_LEVEL, d);
        }
        return hVar;
    }

    @Override // com.google.zxing.g
    public void a() {
    }

    private static com.google.zxing.common.a a(com.google.zxing.common.a aVar) {
        int[] a2 = aVar.a();
        int[] b = aVar.b();
        if (a2 == null || b == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float a3 = a(a2, aVar);
        int i = a2[1];
        int i2 = b[1];
        int i3 = a2[0];
        int i4 = b[0];
        if (i3 >= i4 || i >= i2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (i2 - i != i4 - i3) {
            i4 = (i2 - i) + i3;
        }
        int round = Math.round(((i4 - i3) + 1) / a3);
        int round2 = Math.round(((i2 - i) + 1) / a3);
        if (round <= 0 || round2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (round2 != round) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = (int) (a3 / 2.0f);
        int i6 = i + i5;
        int i7 = i3 + i5;
        int i8 = (((int) ((round - 1) * a3)) + i7) - (i4 - 1);
        int i9 = i8 > 0 ? i7 - i8 : i7;
        int i10 = (((int) ((round2 - 1) * a3)) + i6) - (i2 - 1);
        int i11 = i10 > 0 ? i6 - i10 : i6;
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a(round, round2);
        for (int i12 = 0; i12 < round2; i12++) {
            int i13 = i11 + ((int) (i12 * a3));
            for (int i14 = 0; i14 < round; i14++) {
                if (aVar.a(((int) (i14 * a3)) + i9, i13)) {
                    aVar2.b(i14, i12);
                }
            }
        }
        return aVar2;
    }

    private static float a(int[] iArr, com.google.zxing.common.a aVar) {
        boolean z;
        int d = aVar.d();
        int c = aVar.c();
        int i = iArr[0];
        boolean z2 = true;
        int i2 = iArr[1];
        int i3 = i;
        int i4 = 0;
        while (i3 < c && i2 < d) {
            if (z2 != aVar.a(i3, i2)) {
                int i5 = i4 + 1;
                if (i5 == 5) {
                    break;
                }
                z = !z2;
                i4 = i5;
            } else {
                z = z2;
            }
            i3++;
            i2++;
            z2 = z;
        }
        if (i3 == c || i2 == d) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (i3 - iArr[0]) / 7.0f;
    }
}
