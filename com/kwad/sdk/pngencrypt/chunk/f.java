package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;
/* loaded from: classes7.dex */
public class f extends e {

    /* renamed from: d  reason: collision with root package name */
    public final List<PngChunk> f40650d;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public String toString() {
        return "ChunkList: written: " + a().size() + " queue: " + this.f40650d.size();
    }
}
