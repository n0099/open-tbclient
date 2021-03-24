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
    public int f32373a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32374b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32375c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f32376d;

    public i(Context context) {
        this(context, null);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32373a = 1;
        this.f32374b = null;
        this.f32375c = null;
        c();
    }

    private void a(final int i) {
        this.f32376d.d();
        final boolean z = i == 2;
        this.f32376d.setSpeed(z ? 1.2f : 1.0f);
        this.f32376d.a(true);
        this.f32376d.setAnimation(z ? R.raw.ksad_detail_right_button_like_anim_2 : R.raw.ksad_detail_right_button_unlike_anim_2);
        this.f32376d.setVisibility(0);
        this.f32374b.setVisibility(8);
        this.f32376d.a(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.i.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                i.this.setImageView(i);
                i.this.f32374b.setVisibility(0);
                i.this.f32376d.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                i.this.setImageView(i);
                i.this.f32374b.setVisibility(0);
                i.this.f32376d.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ImageView imageView;
                int i2;
                super.onAnimationStart(animator);
                if (z) {
                    imageView = i.this.f32374b;
                    i2 = 8;
                } else {
                    i.this.setImageView(i);
                    imageView = i.this.f32374b;
                    i2 = 0;
                }
                imageView.setVisibility(i2);
            }
        });
        this.f32376d.b();
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_photo_like_button_2, (ViewGroup) this, true);
        this.f32374b = (ImageView) findViewById(R.id.ksad_photo_like_button_image);
        this.f32375c = (TextView) findViewById(R.id.ksad_photo_like_count_text);
        this.f32376d = (LottieAnimationView) findViewById(R.id.ksad_photo_like_animation_view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageView(int i) {
        this.f32374b.setImageResource(i == 1 ? R.drawable.ksad_photo_like_button_2_normal : R.drawable.ksad_photo_like_button_2_selected);
    }

    private void setImageViewWithAnimator(int i) {
        setImageView(i);
        a(i);
    }

    public void a(int i, long j) {
        this.f32373a = i;
        setImageView(i);
        setLikeCount(j);
    }

    public boolean a() {
        return this.f32373a == 2;
    }

    public void b() {
        if (this.f32376d.c()) {
            this.f32376d.d();
        }
    }

    public int getLikeState() {
        return this.f32373a;
    }

    public void setLikeCount(long j) {
        this.f32375c.setText(ag.a(j, "赞"));
    }

    public void setLikeState(int i) {
        this.f32373a = i;
        setImageViewWithAnimator(i);
    }
}
