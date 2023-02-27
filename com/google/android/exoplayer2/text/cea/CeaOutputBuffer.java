package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.SubtitleOutputBuffer;
/* loaded from: classes7.dex */
public final class CeaOutputBuffer extends SubtitleOutputBuffer {
    public final CeaDecoder owner;

    public CeaOutputBuffer(CeaDecoder ceaDecoder) {
        this.owner = ceaDecoder;
    }

    @Override // com.google.android.exoplayer2.text.SubtitleOutputBuffer, com.google.android.exoplayer2.decoder.OutputBuffer
    public final void release() {
        this.owner.releaseOutputBuffer(this);
    }
}
