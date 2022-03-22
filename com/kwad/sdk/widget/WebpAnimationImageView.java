package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.glide.framesequence.FrameSequenceDrawable;
/* loaded from: classes7.dex */
public class WebpAnimationImageView extends RoundAngleImageView {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public FrameSequenceDrawable f41508b;

    /* renamed from: c  reason: collision with root package name */
    public a f41509c;

    /* renamed from: d  reason: collision with root package name */
    public FrameSequenceDrawable.b f41510d;

    /* loaded from: classes7.dex */
    public interface a {
        void a();
    }

    public WebpAnimationImageView(Context context) {
        super(context);
        this.a = 1;
    }

    public WebpAnimationImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 1;
        a(context, attributeSet);
    }

    public WebpAnimationImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 1;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f41510d = new FrameSequenceDrawable.b() { // from class: com.kwad.sdk.widget.WebpAnimationImageView.1
            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.b
            public void a(FrameSequenceDrawable frameSequenceDrawable) {
                if (WebpAnimationImageView.this.f41509c != null) {
                    WebpAnimationImageView.this.f41509c.a();
                }
            }
        };
        com.kwad.sdk.glide.kwai.a.a(context);
    }

    public void a() {
        FrameSequenceDrawable frameSequenceDrawable = this.f41508b;
        if (frameSequenceDrawable != null) {
            frameSequenceDrawable.start();
        }
    }

    public void b() {
        FrameSequenceDrawable frameSequenceDrawable = this.f41508b;
        if (frameSequenceDrawable != null) {
            frameSequenceDrawable.stop();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.f41509c = aVar;
    }

    public void setWebpStream(FrameSequence frameSequence) {
        if (frameSequence == null) {
            return;
        }
        try {
            FrameSequenceDrawable frameSequenceDrawable = new FrameSequenceDrawable(frameSequence);
            frameSequenceDrawable.setLoopCount(this.a);
            frameSequenceDrawable.setOnFinishedListener(this.f41510d);
            setImageDrawable(frameSequenceDrawable);
            if (this.f41508b != null) {
                this.f41508b.destroy();
            }
            this.f41508b = frameSequenceDrawable;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
