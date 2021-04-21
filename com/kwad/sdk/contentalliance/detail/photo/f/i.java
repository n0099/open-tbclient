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
    public int f32758a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32759b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32760c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f32761d;

    public i(Context context) {
        this(context, null);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32758a = 1;
        this.f32759b = null;
        this.f32760c = null;
        c();
    }

    private void a(final int i) {
        this.f32761d.d();
        final boolean z = i == 2;
        this.f32761d.setSpeed(z ? 1.2f : 1.0f);
        this.f32761d.a(true);
        this.f32761d.setAnimation(z ? R.raw.ksad_detail_right_button_like_anim_2 : R.raw.ksad_detail_right_button_unlike_anim_2);
        this.f32761d.setVisibility(0);
        this.f32759b.setVisibility(8);
        this.f32761d.a(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.i.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                i.this.setImageView(i);
                i.this.f32759b.setVisibility(0);
                i.this.f32761d.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                i.this.setImageView(i);
                i.this.f32759b.setVisibility(0);
                i.this.f32761d.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ImageView imageView;
                int i2;
                super.onAnimationStart(animator);
                if (z) {
                    imageView = i.this.f32759b;
                    i2 = 8;
                } else {
                    i.this.setImageView(i);
                    imageView = i.this.f32759b;
                    i2 = 0;
                }
                imageView.setVisibility(i2);
            }
        });
        this.f32761d.b();
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_photo_like_button_2, (ViewGroup) this, true);
        this.f32759b = (ImageView) findViewById(R.id.ksad_photo_like_button_image);
        this.f32760c = (TextView) findViewById(R.id.ksad_photo_like_count_text);
        this.f32761d = (LottieAnimationView) findViewById(R.id.ksad_photo_like_animation_view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageView(int i) {
        this.f32759b.setImageResource(i == 1 ? R.drawable.ksad_photo_like_button_2_normal : R.drawable.ksad_photo_like_button_2_selected);
    }

    private void setImageViewWithAnimator(int i) {
        setImageView(i);
        a(i);
    }

    public void a(int i, long j) {
        this.f32758a = i;
        setImageView(i);
        setLikeCount(j);
    }

    public boolean a() {
        return this.f32758a == 2;
    }

    public void b() {
        if (this.f32761d.c()) {
            this.f32761d.d();
        }
    }

    public int getLikeState() {
        return this.f32758a;
    }

    public void setLikeCount(long j) {
        this.f32760c.setText(ag.a(j, "赞"));
    }

    public void setLikeState(int i) {
        this.f32758a = i;
        setImageViewWithAnimator(i);
    }
}
