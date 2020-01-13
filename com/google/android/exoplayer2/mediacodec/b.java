package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
/* loaded from: classes5.dex */
public interface b {
    public static final b mpn = new b() { // from class: com.google.android.exoplayer2.mediacodec.b.1
        @Override // com.google.android.exoplayer2.mediacodec.b
        public a aL(String str, boolean z) throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.aL(str, z);
        }

        @Override // com.google.android.exoplayer2.mediacodec.b
        public a duK() throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.duK();
        }
    };

    a aL(String str, boolean z) throws MediaCodecUtil.DecoderQueryException;

    a duK() throws MediaCodecUtil.DecoderQueryException;
}
