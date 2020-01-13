package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes5.dex */
public final class b {
    public byte[] iv;
    public int mcA;
    public int mcB;
    public int mcC;
    private final MediaCodec.CryptoInfo mcD;
    private final a mcE;
    public byte[] mcx;
    public int[] mcy;
    public int[] mcz;
    public int mode;

    public b() {
        this.mcD = v.SDK_INT >= 16 ? dti() : null;
        this.mcE = v.SDK_INT >= 24 ? new a(this.mcD) : null;
    }

    public void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.mcA = i;
        this.mcy = iArr;
        this.mcz = iArr2;
        this.mcx = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.mcB = i3;
        this.mcC = i4;
        if (v.SDK_INT >= 16) {
            dtj();
        }
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo dth() {
        return this.mcD;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo dti() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void dtj() {
        this.mcD.numSubSamples = this.mcA;
        this.mcD.numBytesOfClearData = this.mcy;
        this.mcD.numBytesOfEncryptedData = this.mcz;
        this.mcD.key = this.mcx;
        this.mcD.iv = this.iv;
        this.mcD.mode = this.mode;
        if (v.SDK_INT < 24) {
            return;
        }
        this.mcE.set(this.mcB, this.mcC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes5.dex */
    public static final class a {
        private final MediaCodec.CryptoInfo mcD;
        private final MediaCodec.CryptoInfo.Pattern mcF;

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.mcD = cryptoInfo;
            this.mcF = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void set(int i, int i2) {
            this.mcF.set(i, i2);
            this.mcD.setPattern(this.mcF);
        }
    }
}
