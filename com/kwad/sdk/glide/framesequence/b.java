package com.kwad.sdk.glide.framesequence;

import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes6.dex */
public class b implements s<FrameSequence> {

    /* renamed from: a  reason: collision with root package name */
    public final FrameSequence f35561a;

    public b(FrameSequence frameSequence) {
        this.f35561a = frameSequence;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public Class<FrameSequence> a() {
        return FrameSequence.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.engine.s
    /* renamed from: b */
    public FrameSequence e() {
        return this.f35561a;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return this.f35561a.getWidth() * this.f35561a.getHeight() * 4;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
    }
}
