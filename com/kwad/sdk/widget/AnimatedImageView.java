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
    public int f37653a;

    /* renamed from: b  reason: collision with root package name */
    public FrameSequenceDrawable f37654b;

    /* renamed from: c  reason: collision with root package name */
    public a f37655c;

    /* renamed from: d  reason: collision with root package name */
    public FrameSequenceDrawable.b f37656d;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    public AnimatedImageView(Context context) {
        super(context);
        this.f37653a = 1;
    }

    public AnimatedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37653a = 1;
        a(context, attributeSet);
    }

    public AnimatedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f37653a = 1;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f37656d = new FrameSequenceDrawable.b() { // from class: com.kwad.sdk.widget.AnimatedImageView.1
            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.b
            public void a(FrameSequenceDrawable frameSequenceDrawable) {
                if (AnimatedImageView.this.f37655c != null) {
                    AnimatedImageView.this.f37655c.a();
                }
            }
        };
        e.a(context);
    }

    public void a() {
        FrameSequenceDrawable frameSequenceDrawable = this.f37654b;
        if (frameSequenceDrawable != null) {
            frameSequenceDrawable.start();
        }
    }

    public void b() {
        FrameSequenceDrawable frameSequenceDrawable = this.f37654b;
        if (frameSequenceDrawable != null) {
            frameSequenceDrawable.stop();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.f37655c = aVar;
    }

    public void setWebpStream(FrameSequence frameSequence) {
        if (frameSequence == null) {
            return;
        }
        try {
            FrameSequenceDrawable frameSequenceDrawable = new FrameSequenceDrawable(frameSequence);
            frameSequenceDrawable.setLoopCount(this.f37653a);
            frameSequenceDrawable.setOnFinishedListener(this.f37656d);
            setImageDrawable(frameSequenceDrawable);
            if (this.f37654b != null) {
                this.f37654b.destroy();
            }
            this.f37654b = frameSequenceDrawable;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
