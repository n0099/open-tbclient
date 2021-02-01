package com.kwad.sdk.glide.framesequence;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.framesequence.FrameSequenceDrawable;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes3.dex */
public class e implements com.kwad.sdk.glide.load.resource.e.e<FrameSequence, FrameSequenceDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final FrameSequenceDrawable.a f9998a;

    public e(final com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar) {
        this.f9998a = new FrameSequenceDrawable.a() { // from class: com.kwad.sdk.glide.framesequence.e.1
            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
            public Bitmap a(int i, int i2) {
                return eVar.a(i, i2, Bitmap.Config.ARGB_8888);
            }

            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.a
            public void a(Bitmap bitmap) {
                eVar.a(bitmap);
            }
        };
    }

    @Override // com.kwad.sdk.glide.load.resource.e.e
    public s<FrameSequenceDrawable> a(s<FrameSequence> sVar, com.kwad.sdk.glide.load.e eVar) {
        return new d(new FrameSequenceDrawable(sVar.e(), this.f9998a));
    }
}
