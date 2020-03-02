package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
/* loaded from: classes6.dex */
public interface b {
    public static final b mqa = new b() { // from class: com.google.android.exoplayer2.mediacodec.b.1
        @Override // com.google.android.exoplayer2.mediacodec.b
        public a aL(String str, boolean z) throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.aL(str, z);
        }

        @Override // com.google.android.exoplayer2.mediacodec.b
        public a dvY() throws MediaCodecUtil.DecoderQueryException {
            return MediaCodecUtil.dvY();
        }
    };

    a aL(String str, boolean z) throws MediaCodecUtil.DecoderQueryException;

    a dvY() throws MediaCodecUtil.DecoderQueryException;
}
