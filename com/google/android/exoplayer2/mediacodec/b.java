package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
/* loaded from: classes4.dex */
public interface b {
    public static final b mly = new b() { // from class: com.google.android.exoplayer2.mediacodec.b.1
        @Override // com.google.android.exoplayer2.mediacodec.b
        public a aL(String str, boolean z) throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.aL(str, z);
        }

        @Override // com.google.android.exoplayer2.mediacodec.b
        public a dtz() throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.dtz();
        }
    };

    a aL(String str, boolean z) throws MediaCodecUtil.DecoderQueryException;

    a dtz() throws MediaCodecUtil.DecoderQueryException;
}
