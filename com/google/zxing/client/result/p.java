package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
/* loaded from: classes.dex */
public final class p extends t {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.zxing.client.result.t
    /* renamed from: a */
    public o b(com.google.zxing.h hVar) {
        if (hVar.c() != BarcodeFormat.EAN_13) {
            return null;
        }
        String c = c(hVar);
        if (c.length() == 13) {
            if (c.startsWith("978") || c.startsWith("979")) {
                return new o(c);
            }
            return null;
        }
        return null;
    }
}
