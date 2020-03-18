package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
public final class b {
    public byte[] iv;
    public byte[] mfb;
    public int[] mfc;
    public int[] mfd;
    public int mfe;
    public int mff;
    public int mfg;
    private final MediaCodec.CryptoInfo mfh;
    private final a mfi;
    public int mode;

    public b() {
        this.mfh = v.SDK_INT >= 16 ? duV() : null;
        this.mfi = v.SDK_INT >= 24 ? new a(this.mfh) : null;
    }

    public void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.mfe = i;
        this.mfc = iArr;
        this.mfd = iArr2;
        this.mfb = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.mff = i3;
        this.mfg = i4;
        if (v.SDK_INT >= 16) {
            duW();
        }
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo duU() {
        return this.mfh;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo duV() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void duW() {
        this.mfh.numSubSamples = this.mfe;
        this.mfh.numBytesOfClearData = this.mfc;
        this.mfh.numBytesOfEncryptedData = this.mfd;
        this.mfh.key = this.mfb;
        this.mfh.iv = this.iv;
        this.mfh.mode = this.mode;
        if (v.SDK_INT < 24) {
            return;
        }
        this.mfi.set(this.mff, this.mfg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes6.dex */
    public static final class a {
        private final MediaCodec.CryptoInfo mfh;
        private final MediaCodec.CryptoInfo.Pattern mfj;

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.mfh = cryptoInfo;
            this.mfj = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void set(int i, int i2) {
            this.mfj.set(i, i2);
            this.mfh.setPattern(this.mfj);
        }
    }
}
