package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import com.google.android.exoplayer2.util.v;
/* loaded from: classes6.dex */
public final class b {
    public byte[] iv;
    public byte[] mdk;
    public int[] mdl;
    public int[] mdm;
    public int mdn;
    public int mdo;
    public int mdp;
    private final MediaCodec.CryptoInfo mdq;
    private final a mdr;
    public int mode;

    public b() {
        this.mdq = v.SDK_INT >= 16 ? dux() : null;
        this.mdr = v.SDK_INT >= 24 ? new a(this.mdq) : null;
    }

    public void a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.mdn = i;
        this.mdl = iArr;
        this.mdm = iArr2;
        this.mdk = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.mdo = i3;
        this.mdp = i4;
        if (v.SDK_INT >= 16) {
            duy();
        }
    }

    @TargetApi(16)
    public MediaCodec.CryptoInfo duw() {
        return this.mdq;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo dux() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void duy() {
        this.mdq.numSubSamples = this.mdn;
        this.mdq.numBytesOfClearData = this.mdl;
        this.mdq.numBytesOfEncryptedData = this.mdm;
        this.mdq.key = this.mdk;
        this.mdq.iv = this.iv;
        this.mdq.mode = this.mode;
        if (v.SDK_INT < 24) {
            return;
        }
        this.mdr.set(this.mdo, this.mdp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(24)
    /* loaded from: classes6.dex */
    public static final class a {
        private final MediaCodec.CryptoInfo mdq;
        private final MediaCodec.CryptoInfo.Pattern mds;

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.mdq = cryptoInfo;
            this.mds = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void set(int i, int i2) {
            this.mds.set(i, i2);
            this.mdq.setPattern(this.mds);
        }
    }
}
