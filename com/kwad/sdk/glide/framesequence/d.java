package com.kwad.sdk.glide.framesequence;
/* loaded from: classes7.dex */
public class d extends com.kwad.sdk.glide.load.resource.b.b<FrameSequenceDrawable> {
    public d(FrameSequenceDrawable frameSequenceDrawable) {
        super(frameSequenceDrawable);
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public Class<FrameSequenceDrawable> a() {
        return FrameSequenceDrawable.class;
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public int c() {
        return ((FrameSequenceDrawable) this.f36327a).getSize();
    }

    @Override // com.kwad.sdk.glide.load.engine.s
    public void d_() {
        ((FrameSequenceDrawable) this.f36327a).stop();
        ((FrameSequenceDrawable) this.f36327a).destroy();
    }
}
