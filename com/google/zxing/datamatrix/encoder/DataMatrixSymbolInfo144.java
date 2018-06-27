package com.google.zxing.datamatrix.encoder;

import com.baidu.sapi2.SapiAccountManager;
/* loaded from: classes3.dex */
final class DataMatrixSymbolInfo144 extends SymbolInfo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DataMatrixSymbolInfo144() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getInterleavedBlockCount() {
        return 10;
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getDataLengthForInterleavedBlock(int i) {
        if (i <= 8) {
            return SapiAccountManager.VERSION_CODE;
        }
        return 155;
    }
}
