package com.google.android.exoplayer2.source.chunk;

import java.io.IOException;
import java.util.List;
/* loaded from: classes5.dex */
public interface ChunkSource {
    void getNextChunk(MediaChunk mediaChunk, long j, long j2, ChunkHolder chunkHolder);

    int getPreferredQueueSize(long j, List<? extends MediaChunk> list);

    void maybeThrowError() throws IOException;

    void onChunkLoadCompleted(Chunk chunk);

    boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc);
}
