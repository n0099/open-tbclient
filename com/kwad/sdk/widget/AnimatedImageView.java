package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.glide.framesequence.FrameSequenceDrawable;
import com.kwad.sdk.glide.webp.e;
/* loaded from: classes7.dex */
public class AnimatedImageView extends RoundAngleImageView {

    /* renamed from: a  reason: collision with root package name */
    public int f37555a;

    /* renamed from: b  reason: collision with root package name */
    public FrameSequenceDrawable f37556b;

    /* renamed from: c  reason: collision with root package name */
    public a f37557c;

    /* renamed from: d  reason: collision with root package name */
    public FrameSequenceDrawable.b f37558d;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    public AnimatedImageView(Context context) {
        super(context);
        this.f37555a = 1;
    }

    public AnimatedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37555a = 1;
        a(context, attributeSet);
    }

    public AnimatedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f37555a = 1;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f37558d = new FrameSequenceDrawable.b() { // from class: com.kwad.sdk.widget.AnimatedImageView.1
            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.b
            public void a(FrameSequenceDrawable frameSequenceDrawable) {
                if (AnimatedImageView.this.f37557c != null) {
                    AnimatedImageView.this.f37557c.a();
                }
            }
        };
        e.a(context);
    }

    public void a() {
        FrameSequenceDrawable frameSequenceDrawable = this.f37556b;
        if (frameSequenceDrawable != null) {
            frameSequenceDrawable.start();
        }
    }

    public void b() {
        FrameSequenceDrawable frameSequenceDrawable = this.f37556b;
        if (frameSequenceDrawable != null) {
            frameSequenceDrawable.stop();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.f37557c = aVar;
    }

    public void setWebpStream(FrameSequence frameSequence) {
        if (frameSequence == null) {
            return;
        }
        try {
            FrameSequenceDrawable frameSequenceDrawable = new FrameSequenceDrawable(frameSequence);
            frameSequenceDrawable.setLoopCount(this.f37555a);
            frameSequenceDrawable.setOnFinishedListener(this.f37558d);
            setImageDrawable(frameSequenceDrawable);
            if (this.f37556b != null) {
                this.f37556b.destroy();
            }
            this.f37556b = frameSequenceDrawable;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
