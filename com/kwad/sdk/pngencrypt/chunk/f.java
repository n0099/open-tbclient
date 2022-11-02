package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;
/* loaded from: classes8.dex */
public final class f extends e {
    public final List<PngChunk> alJ;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public final String toString() {
        return "ChunkList: written: " + yH().size() + " queue: " + this.alJ.size();
    }
}
