package com.google.zxing.qrcode.decoder;
/* loaded from: classes.dex */
final class j extends c {
    private j() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(j jVar) {
        this();
    }

    @Override // com.google.zxing.qrcode.decoder.c
    boolean a(int i, int i2) {
        int i3 = i * i2;
        return (((i3 % 3) + (i3 & 1)) & 1) == 0;
    }
}
