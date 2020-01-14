package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
public final class b {
    public byte[] iv;
    public byte[] mcC;
    public int[] mcD;
    public int[] mcE;
    public int mcF;
    public int mcG;
    public int mcH;
    private final MediaCodec.CryptoInfo mcI;
    private final a mcJ;
    public int mode;

    public b() {
        this.mcI = v.SDK_INT >= 16 ? dtk() : null;
        this.mcJ = v.SDK_INT >= 24 ? new a(this.mcI) : null;
    }

    public void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.mcF = i;
        this.mcD = iArr;
        this.mcE = iArr2;
        this.mcC = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.mcG = i3;
        this.mcH = i4;
        if (v.SDK_INT >= 16) {
            dtl();
        }
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo dtj() {
        return this.mcI;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo dtk() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void dtl() {
        this.mcI.numSubSamples = this.mcF;
        this.mcI.numBytesOfClearData = this.mcD;
        this.mcI.numBytesOfEncryptedData = this.mcE;
        this.mcI.key = this.mcC;
        this.mcI.iv = this.iv;
        this.mcI.mode = this.mode;
        if (v.SDK_INT < 24) {
            return;
        }
        this.mcJ.set(this.mcG, this.mcH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes5.dex */
    public static final class a {
        private final MediaCodec.CryptoInfo mcI;
        private final MediaCodec.CryptoInfo.Pattern mcK;

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.mcI = cryptoInfo;
            this.mcK = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void set(int i, int i2) {
            this.mcK.set(i, i2);
            this.mcI.setPattern(this.mcK);
        }
    }
}
