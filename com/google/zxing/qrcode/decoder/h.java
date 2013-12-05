package com.google.zxing.qrcode.decoder;
/* loaded from: classes.dex */
final class h extends c {
    private h() {
        super(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ h(h hVar) {
        this();
    }

    @Override // com.google.zxing.qrcode.decoder.c
    boolean a(int i, int i2) {
        return (((i >>> 1) + (i2 / 3)) & 1) == 0;
    }
}
