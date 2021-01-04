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
/* loaded from: classes5.dex */
public class i extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f8821a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f8822b;
    private TextView c;
    private LottieAnimationView d;

    public i(Context context) {
        this(context, null);
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8821a = 1;
        this.f8822b = null;
        this.c = null;
        c();
    }

    private void a(final int i) {
        this.d.d();
        final boolean z = i == 2;
        this.d.setSpeed(z ? 1.2f : 1.0f);
        this.d.a(true);
        this.d.setAnimation(z ? R.raw.ksad_detail_right_button_like_anim_2 : R.raw.ksad_detail_right_button_unlike_anim_2);
        this.d.setVisibility(0);
        this.f8822b.setVisibility(8);
        this.d.a(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.photo.f.i.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                i.this.setImageView(i);
                i.this.f8822b.setVisibility(0);
                i.this.d.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                i.this.setImageView(i);
                i.this.f8822b.setVisibility(0);
                i.this.d.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z) {
                    i.this.f8822b.setVisibility(8);
                    return;
                }
                i.this.setImageView(i);
                i.this.f8822b.setVisibility(0);
            }
        });
        this.d.b();
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_photo_like_button_2, (ViewGroup) this, true);
        this.f8822b = (ImageView) findViewById(R.id.ksad_photo_like_button_image);
        this.c = (TextView) findViewById(R.id.ksad_photo_like_count_text);
        this.d = (LottieAnimationView) findViewById(R.id.ksad_photo_like_animation_view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageView(int i) {
        this.f8822b.setImageResource(i == 1 ? R.drawable.ksad_photo_like_button_2_normal : R.drawable.ksad_photo_like_button_2_selected);
    }

    private void setImageViewWithAnimator(int i) {
        setImageView(i);
        a(i);
    }

    public void a(int i, long j) {
        this.f8821a = i;
        setImageView(i);
        setLikeCount(j);
    }

    public boolean a() {
        return this.f8821a == 2;
    }

    public void b() {
        if (this.d.c()) {
            this.d.d();
        }
    }

    public int getLikeState() {
        return this.f8821a;
    }

    public void setLikeCount(long j) {
        this.c.setText(ag.a(j, "赞"));
    }

    public void setLikeState(int i) {
        this.f8821a = i;
        setImageViewWithAnimator(i);
    }
}
