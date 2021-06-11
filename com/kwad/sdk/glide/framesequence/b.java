package com.kwad.sdk.glide.framesequence;

import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes7.dex */
public class b implements s<FrameSequence> {

    /* renamed from: a  reason: collision with root package name */
    public final FrameSequence f35859a;

    public b(FrameSequence frameSequence) {
        this.f35859a = frameSequence;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public Class<FrameSequence> a() {
        return FrameSequence.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.s
    /* renamed from: b */
    public FrameSequence e() {
        return this.f35859a;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f35859a.getWidth() * this.f35859a.getHeight() * 4;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
    }
}
