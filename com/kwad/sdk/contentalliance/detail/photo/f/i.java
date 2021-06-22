package com.kwad.sdk.contentalliance.detail.photo.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ag;
/* loaded from: classes6.dex */
public class i extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f33044a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f33045b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33046c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f33047d;

    public i(Context context) {
        this(context, null);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33044a = 1;
        this.f33045b = null;
        this.f33046c = null;
        c();
    }

    private void a(final int i2) {
        this.f33047d.d();
        final boolean z = i2 == 2;
        this.f33047d.setSpeed(z ? 1.2f : 1.0f);
        this.f33047d.a(true);
        this.f33047d.setAnimation(z ? R.raw.ksad_detail_right_button_like_anim_2 : R.raw.ksad_detail_right_button_unlike_anim_2);
        this.f33047d.setVisibility(0);
        this.f33045b.setVisibility(8);
        this.f33047d.a(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.i.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                i.this.setImageView(i2);
                i.this.f33045b.setVisibility(0);
                i.this.f33047d.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                i.this.setImageView(i2);
                i.this.f33045b.setVisibility(0);
                i.this.f33047d.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ImageView imageView;
                int i3;
                super.onAnimationStart(animator);
                if (z) {
                    imageView = i.this.f33045b;
                    i3 = 8;
                } else {
                    i.this.setImageView(i2);
                    imageView = i.this.f33045b;
                    i3 = 0;
                }
                imageView.setVisibility(i3);
            }
        });
        this.f33047d.b();
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_photo_like_button_2, (ViewGroup) this, true);
        this.f33045b = (ImageView) findViewById(R.id.ksad_photo_like_button_image);
        this.f33046c = (TextView) findViewById(R.id.ksad_photo_like_count_text);
        this.f33047d = (LottieAnimationView) findViewById(R.id.ksad_photo_like_animation_view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageView(int i2) {
        this.f33045b.setImageResource(i2 == 1 ? R.drawable.ksad_photo_like_button_2_normal : R.drawable.ksad_photo_like_button_2_selected);
    }

    private void setImageViewWithAnimator(int i2) {
        setImageView(i2);
        a(i2);
    }

    public void a(int i2, long j) {
        this.f33044a = i2;
        setImageView(i2);
        setLikeCount(j);
    }

    public boolean a() {
        return this.f33044a == 2;
    }

    public void b() {
        if (this.f33047d.c()) {
            this.f33047d.d();
        }
    }

    public int getLikeState() {
        return this.f33044a;
    }

    public void setLikeCount(long j) {
        this.f33046c.setText(ag.a(j, "赞"));
    }

    public void setLikeState(int i2) {
        this.f33044a = i2;
        setImageViewWithAnimator(i2);
    }
}
