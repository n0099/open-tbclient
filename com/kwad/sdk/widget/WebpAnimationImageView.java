package com.kwad.sdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.glide.framesequence.FrameSequenceDrawable;
/* loaded from: classes3.dex */
public class WebpAnimationImageView extends RoundAngleImageView {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public FrameSequenceDrawable f58112b;

    /* renamed from: c  reason: collision with root package name */
    public a f58113c;

    /* renamed from: d  reason: collision with root package name */
    public FrameSequenceDrawable.b f58114d;

    /* loaded from: classes3.dex */
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

    public WebpAnimationImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 1;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f58114d = new FrameSequenceDrawable.b() { // from class: com.kwad.sdk.widget.WebpAnimationImageView.1
            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.b
            public void a(FrameSequenceDrawable frameSequenceDrawable) {
                if (WebpAnimationImageView.this.f58113c != null) {
                    WebpAnimationImageView.this.f58113c.a();
                }
            }
        };
        com.kwad.sdk.glide.kwai.a.a(context);
    }

    public void a() {
        FrameSequenceDrawable frameSequenceDrawable = this.f58112b;
        if (frameSequenceDrawable != null) {
            frameSequenceDrawable.start();
        }
    }

    public void b() {
        FrameSequenceDrawable frameSequenceDrawable = this.f58112b;
        if (frameSequenceDrawable != null) {
            frameSequenceDrawable.stop();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.f58113c = aVar;
    }

    public void setWebpStream(FrameSequence frameSequence) {
        if (frameSequence == null) {
            return;
        }
        try {
            FrameSequenceDrawable frameSequenceDrawable = new FrameSequenceDrawable(frameSequence);
            frameSequenceDrawable.setLoopCount(this.a);
            frameSequenceDrawable.setOnFinishedListener(this.f58114d);
            setImageDrawable(frameSequenceDrawable);
            if (this.f58112b != null) {
                this.f58112b.destroy();
            }
            this.f58112b = frameSequenceDrawable;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
