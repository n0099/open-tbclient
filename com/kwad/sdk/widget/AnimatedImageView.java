package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.glide.framesequence.FrameSequenceDrawable;
/* loaded from: classes6.dex */
public class AnimatedImageView extends RoundAngleImageView {

    /* renamed from: a  reason: collision with root package name */
    public int f34922a;

    /* renamed from: b  reason: collision with root package name */
    public FrameSequenceDrawable f34923b;

    /* renamed from: c  reason: collision with root package name */
    public a f34924c;

    /* renamed from: d  reason: collision with root package name */
    public FrameSequenceDrawable.b f34925d;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public AnimatedImageView(Context context) {
        super(context);
        this.f34922a = 1;
    }

    public AnimatedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34922a = 1;
        a(context, attributeSet);
    }

    public AnimatedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f34922a = 1;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f34925d = new FrameSequenceDrawable.b() { // from class: com.kwad.sdk.widget.AnimatedImageView.1
            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.b
            public void a(FrameSequenceDrawable frameSequenceDrawable) {
                if (AnimatedImageView.this.f34924c != null) {
                    AnimatedImageView.this.f34924c.a();
                }
            }
        };
        com.kwad.sdk.glide.a.a.a(context);
    }

    public void a() {
        FrameSequenceDrawable frameSequenceDrawable = this.f34923b;
        if (frameSequenceDrawable != null) {
            frameSequenceDrawable.start();
        }
    }

    public void b() {
        FrameSequenceDrawable frameSequenceDrawable = this.f34923b;
        if (frameSequenceDrawable != null) {
            frameSequenceDrawable.stop();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.f34924c = aVar;
    }

    public void setWebpStream(FrameSequence frameSequence) {
        if (frameSequence == null) {
            return;
        }
        try {
            FrameSequenceDrawable frameSequenceDrawable = new FrameSequenceDrawable(frameSequence);
            frameSequenceDrawable.setLoopCount(this.f34922a);
            frameSequenceDrawable.setOnFinishedListener(this.f34925d);
            setImageDrawable(frameSequenceDrawable);
            if (this.f34923b != null) {
                this.f34923b.destroy();
            }
            this.f34923b = frameSequenceDrawable;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
