package com.google.android.exoplayer2.text;

import androidx.annotation.NonNull;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
/* loaded from: classes7.dex */
public final class SubtitleInputBuffer extends DecoderInputBuffer implements Comparable<SubtitleInputBuffer> {
    public long subsampleOffsetUs;

    public SubtitleInputBuffer() {
        super(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(@NonNull SubtitleInputBuffer subtitleInputBuffer) {
        if (isEndOfStream() != subtitleInputBuffer.isEndOfStream()) {
            if (isEndOfStream()) {
                return 1;
            }
            return -1;
        }
        int i = ((this.timeUs - subtitleInputBuffer.timeUs) > 0L ? 1 : ((this.timeUs - subtitleInputBuffer.timeUs) == 0L ? 0 : -1));
        if (i == 0) {
            return 0;
        }
        if (i > 0) {
            return 1;
        }
        return -1;
    }
}
