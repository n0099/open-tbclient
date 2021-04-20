package com.kwad.sdk.glide.framesequence;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.framesequence.FrameSequenceDrawable;
import com.kwad.sdk.glide.load.engine.s;
/* loaded from: classes6.dex */
public class c<DataType> implements com.kwad.sdk.glide.load.f<DataType, FrameSequenceDrawable> {

    /* renamed from: a  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.f<DataType, FrameSequence> f35467a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameSequenceDrawable.a f35468b;

    public c(final com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.f<DataType, FrameSequence> fVar) {
        this.f35467a = fVar;
        this.f35468b = new FrameSequenceDrawable.a() { // from class: com.kwad.sdk.glide.framesequence.c.1
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

    @Override // com.kwad.sdk.glide.load.f
    @Nullable
    public s<FrameSequenceDrawable> a(DataType datatype, int i, int i2, com.kwad.sdk.glide.load.e eVar) {
        s<FrameSequence> a2 = this.f35467a.a(datatype, i, i2, eVar);
        if (a2 == null) {
            return null;
        }
        return new d(new FrameSequenceDrawable(a2.e(), this.f35468b));
    }

    @Override // com.kwad.sdk.glide.load.f
    public boolean a(DataType datatype, com.kwad.sdk.glide.load.e eVar) {
        return this.f35467a.a(datatype, eVar);
    }
}
