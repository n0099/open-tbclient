package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.glide.framesequence.FrameSequenceDrawable;
import com.kwad.sdk.glide.webp.e;
/* loaded from: classes5.dex */
public class AnimatedImageView extends RoundAngleImageView {

    /* renamed from: a  reason: collision with root package name */
    private int f11135a;

    /* renamed from: b  reason: collision with root package name */
    private FrameSequenceDrawable f11136b;
    private a c;
    private FrameSequenceDrawable.b d;

    /* loaded from: classes5.dex */
    public interface a {
        void a();
    }

    public AnimatedImageView(Context context) {
        super(context);
        this.f11135a = 1;
    }

    public AnimatedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11135a = 1;
        a(context, attributeSet);
    }

    public AnimatedImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11135a = 1;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.d = new FrameSequenceDrawable.b() { // from class: com.kwad.sdk.widget.AnimatedImageView.1
            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.b
            public void a(FrameSequenceDrawable frameSequenceDrawable) {
                if (AnimatedImageView.this.c != null) {
                    AnimatedImageView.this.c.a();
                }
            }
        };
        e.a(context);
    }

    public void a() {
        if (this.f11136b != null) {
            this.f11136b.start();
        }
    }

    public void b() {
        if (this.f11136b != null) {
            this.f11136b.stop();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.c = aVar;
    }

    public void setWebpStream(FrameSequence frameSequence) {
        if (frameSequence == null) {
            return;
        }
        try {
            FrameSequenceDrawable frameSequenceDrawable = new FrameSequenceDrawable(frameSequence);
            frameSequenceDrawable.setLoopCount(this.f11135a);
            frameSequenceDrawable.setOnFinishedListener(this.d);
            setImageDrawable(frameSequenceDrawable);
            if (this.f11136b != null) {
                this.f11136b.destroy();
            }
            this.f11136b = frameSequenceDrawable;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
