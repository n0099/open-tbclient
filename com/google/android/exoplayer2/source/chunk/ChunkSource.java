package com.google.android.exoplayer2.source.chunk;

import java.io.IOException;
import java.util.List;
/* loaded from: classes7.dex */
public interface ChunkSource {
    void getNextChunk(MediaChunk mediaChunk, long j2, long j3, ChunkHolder chunkHolder);

    int getPreferredQueueSize(long j2, List<? extends MediaChunk> list);

    void maybeThrowError() throws IOException;

    void onChunkLoadCompleted(Chunk chunk);

    boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc);
}
