package com.google.zxing.qrcode.decoder;
/* loaded from: classes.dex */
final class k extends c {
    private k() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(k kVar) {
        this();
    }

    @Override // com.google.zxing.qrcode.decoder.c
    boolean a(int i, int i2) {
        return ((((i + i2) & 1) + ((i * i2) % 3)) & 1) == 0;
    }
}
