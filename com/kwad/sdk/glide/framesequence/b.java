package com.kwad.sdk.glide.framesequence;

import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes5.dex */
public class b implements s<FrameSequence> {

    /* renamed from: a  reason: collision with root package name */
    private final FrameSequence f10291a;

    public b(FrameSequence frameSequence) {
        this.f10291a = frameSequence;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public Class<FrameSequence> a() {
        return FrameSequence.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.s
    /* renamed from: b */
    public FrameSequence e() {
        return this.f10291a;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f10291a.getWidth() * this.f10291a.getHeight() * 4;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
    }
}
