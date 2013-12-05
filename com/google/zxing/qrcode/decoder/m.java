package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.zxing.common.reedsolomon.c f2883a = new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.e);

    public com.google.zxing.common.c a(com.google.zxing.common.a aVar, Map<DecodeHintType, ?> map) {
        a aVar2 = new a(aVar);
        o b = aVar2.b();
        ErrorCorrectionLevel a2 = aVar2.a().a();
        b[] a3 = b.a(aVar2.c(), b, a2);
        int i = 0;
        for (b bVar : a3) {
            i += bVar.a();
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (b bVar2 : a3) {
            byte[] b2 = bVar2.b();
            int a4 = bVar2.a();
            a(b2, a4);
            int i3 = 0;
            while (i3 < a4) {
                bArr[i2] = b2[i3];
                i3++;
                i2++;
            }
        }
        return l.a(bArr, b, a2, map);
    }

    private void a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f2883a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException e) {
            throw ChecksumException.getChecksumInstance();
        }
    }
}
