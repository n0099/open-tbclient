package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;
/* loaded from: classes3.dex */
public class f extends e {

    /* renamed from: d  reason: collision with root package name */
    public final List<PngChunk> f57074d;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public String toString() {
        return "ChunkList: written: " + a().size() + " queue: " + this.f57074d.size();
    }
}
