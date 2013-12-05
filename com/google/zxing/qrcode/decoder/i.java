package com.google.zxing.qrcode.decoder;
/* loaded from: classes.dex */
final class i extends c {
    private i() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(i iVar) {
        this();
    }

    @Override // com.google.zxing.qrcode.decoder.c
    boolean a(int i, int i2) {
        int i3 = i * i2;
        return (i3 % 3) + (i3 & 1) == 0;
    }
}
