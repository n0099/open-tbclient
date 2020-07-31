package com.google.zxing.pdf417.encoder;
/* loaded from: classes6.dex */
final class BarcodeRow {
    private int currentLocation = 0;
    private final byte[] row;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BarcodeRow(int i) {
        this.row = new byte[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void set(int i, byte b) {
        this.row[i] = b;
    }

    private void set(int i, boolean z) {
        this.row[i] = (byte) (z ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addBar(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.currentLocation;
            this.currentLocation = i3 + 1;
            set(i3, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getScaledRow(int i) {
        byte[] bArr = new byte[this.row.length * i];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = this.row[i2 / i];
        }
        return bArr;
    }
}
