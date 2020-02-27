package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
public final class b {
    public byte[] iv;
    public byte[] mdi;
    public int[] mdj;
    public int[] mdk;
    public int mdl;
    public int mdm;
    public int mdn;
    private final MediaCodec.CryptoInfo mdo;
    private final a mdp;
    public int mode;

    public b() {
        this.mdo = v.SDK_INT >= 16 ? duv() : null;
        this.mdp = v.SDK_INT >= 24 ? new a(this.mdo) : null;
    }

    public void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.mdl = i;
        this.mdj = iArr;
        this.mdk = iArr2;
        this.mdi = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.mdm = i3;
        this.mdn = i4;
        if (v.SDK_INT >= 16) {
            duw();
        }
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo duu() {
        return this.mdo;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo duv() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void duw() {
        this.mdo.numSubSamples = this.mdl;
        this.mdo.numBytesOfClearData = this.mdj;
        this.mdo.numBytesOfEncryptedData = this.mdk;
        this.mdo.key = this.mdi;
        this.mdo.iv = this.iv;
        this.mdo.mode = this.mode;
        if (v.SDK_INT < 24) {
            return;
        }
        this.mdp.set(this.mdm, this.mdn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes6.dex */
    public static final class a {
        private final MediaCodec.CryptoInfo mdo;
        private final MediaCodec.CryptoInfo.Pattern mdq;

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.mdo = cryptoInfo;
            this.mdq = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void set(int i, int i2) {
            this.mdq.set(i, i2);
            this.mdo.setPattern(this.mdq);
        }
    }
}
