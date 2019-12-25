package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes4.dex */
public final class b {
    public byte[] iv;
    public byte[] lYF;
    public int[] lYG;
    public int[] lYH;
    public int lYI;
    public int lYJ;
    public int lYK;
    private final MediaCodec.CryptoInfo lYL;
    private final a lYM;
    public int mode;

    public b() {
        this.lYL = v.SDK_INT >= 16 ? drW() : null;
        this.lYM = v.SDK_INT >= 24 ? new a(this.lYL) : null;
    }

    public void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.lYI = i;
        this.lYG = iArr;
        this.lYH = iArr2;
        this.lYF = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.lYJ = i3;
        this.lYK = i4;
        if (v.SDK_INT >= 16) {
            drX();
        }
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo drV() {
        return this.lYL;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo drW() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void drX() {
        this.lYL.numSubSamples = this.lYI;
        this.lYL.numBytesOfClearData = this.lYG;
        this.lYL.numBytesOfEncryptedData = this.lYH;
        this.lYL.key = this.lYF;
        this.lYL.iv = this.iv;
        this.lYL.mode = this.mode;
        if (v.SDK_INT < 24) {
            return;
        }
        this.lYM.set(this.lYJ, this.lYK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes4.dex */
    public static final class a {
        private final MediaCodec.CryptoInfo lYL;
        private final MediaCodec.CryptoInfo.Pattern lYN;

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.lYL = cryptoInfo;
            this.lYN = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void set(int i, int i2) {
            this.lYN.set(i, i2);
            this.lYL.setPattern(this.lYN);
        }
    }
}
