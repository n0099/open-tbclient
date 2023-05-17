package com.google.android.exoplayer2.decoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.exoplayer2.util.Util;
/* loaded from: classes9.dex */
public final class CryptoInfo {
    public int clearBlocks;
    public int encryptedBlocks;
    public final MediaCodec.CryptoInfo frameworkCryptoInfo;
    public byte[] iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;
    public final PatternHolderV24 patternHolder;

    @TargetApi(24)
    /* loaded from: classes9.dex */
    public static final class PatternHolderV24 {
        public final MediaCodec.CryptoInfo frameworkCryptoInfo;
        public final MediaCodec.CryptoInfo.Pattern pattern;

        public PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo) {
            this.frameworkCryptoInfo = cryptoInfo;
            this.pattern = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void set(int i, int i2) {
            this.pattern.set(i, i2);
            this.frameworkCryptoInfo.setPattern(this.pattern);
        }
    }

    public CryptoInfo() {
        MediaCodec.CryptoInfo cryptoInfo;
        if (Util.SDK_INT >= 16) {
            cryptoInfo = newFrameworkCryptoInfoV16();
        } else {
            cryptoInfo = null;
        }
        this.frameworkCryptoInfo = cryptoInfo;
        this.patternHolder = Util.SDK_INT >= 24 ? new PatternHolderV24(cryptoInfo) : null;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo newFrameworkCryptoInfoV16() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void updateFrameworkCryptoInfoV16() {
        MediaCodec.CryptoInfo cryptoInfo = this.frameworkCryptoInfo;
        cryptoInfo.numSubSamples = this.numSubSamples;
        cryptoInfo.numBytesOfClearData = this.numBytesOfClearData;
        cryptoInfo.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
        cryptoInfo.key = this.key;
        cryptoInfo.iv = this.iv;
        cryptoInfo.mode = this.mode;
        if (Util.SDK_INT < 24) {
            return;
        }
        this.patternHolder.set(this.encryptedBlocks, this.clearBlocks);
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo getFrameworkCryptoInfoV16() {
        return this.frameworkCryptoInfo;
    }

    public void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.encryptedBlocks = i3;
        this.clearBlocks = i4;
        if (Util.SDK_INT >= 16) {
            updateFrameworkCryptoInfoV16();
        }
    }
}
