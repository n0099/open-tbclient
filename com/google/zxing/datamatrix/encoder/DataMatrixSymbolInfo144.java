package com.google.zxing.datamatrix.encoder;

import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
/* loaded from: classes10.dex */
public final class DataMatrixSymbolInfo144 extends SymbolInfo {
    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getDataLengthForInterleavedBlock(int i) {
        if (i <= 8) {
            return Cea708Decoder.COMMAND_DS4;
        }
        return 155;
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getInterleavedBlockCount() {
        return 10;
    }

    public DataMatrixSymbolInfo144() {
        super(false, 1558, PassBiometricUtil.f, 22, 22, 36, -1, 62);
    }
}
