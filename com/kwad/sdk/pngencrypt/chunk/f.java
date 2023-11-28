package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;
/* loaded from: classes10.dex */
public final class f extends e {
    public final List<PngChunk> aKy;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public final String toString() {
        return "ChunkList: written: " + IK().size() + " queue: " + this.aKy.size();
    }
}
