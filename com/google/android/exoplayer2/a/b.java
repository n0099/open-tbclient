package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
public final class b {
    public byte[] iv;
    public int mdA;
    private final MediaCodec.CryptoInfo mdB;
    private final a mdC;
    public byte[] mdv;
    public int[] mdw;
    public int[] mdx;
    public int mdy;
    public int mdz;
    public int mode;

    public b() {
        this.mdB = v.SDK_INT >= 16 ? duy() : null;
        this.mdC = v.SDK_INT >= 24 ? new a(this.mdB) : null;
    }

    public void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.mdy = i;
        this.mdw = iArr;
        this.mdx = iArr2;
        this.mdv = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.mdz = i3;
        this.mdA = i4;
        if (v.SDK_INT >= 16) {
            duz();
        }
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo dux() {
        return this.mdB;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo duy() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void duz() {
        this.mdB.numSubSamples = this.mdy;
        this.mdB.numBytesOfClearData = this.mdw;
        this.mdB.numBytesOfEncryptedData = this.mdx;
        this.mdB.key = this.mdv;
        this.mdB.iv = this.iv;
        this.mdB.mode = this.mode;
        if (v.SDK_INT < 24) {
            return;
        }
        this.mdC.set(this.mdz, this.mdA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes6.dex */
    public static final class a {
        private final MediaCodec.CryptoInfo mdB;
        private final MediaCodec.CryptoInfo.Pattern mdD;

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.mdB = cryptoInfo;
            this.mdD = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void set(int i, int i2) {
            this.mdD.set(i, i2);
            this.mdB.setPattern(this.mdD);
        }
    }
}
