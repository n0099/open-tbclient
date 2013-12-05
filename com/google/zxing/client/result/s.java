package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
/* loaded from: classes.dex */
public final class s extends t {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public r b(com.google.zxing.h hVar) {
        BarcodeFormat c = hVar.c();
        if (c == BarcodeFormat.UPC_A || c == BarcodeFormat.UPC_E || c == BarcodeFormat.EAN_8 || c == BarcodeFormat.EAN_13) {
            String c2 = c(hVar);
            int length = c2.length();
            for (int i = 0; i < length; i++) {
                char charAt = c2.charAt(i);
                if (charAt < '0' || charAt > '9') {
                    return null;
                }
            }
            return new r(c2, c2);
        }
        return null;
    }
}
