package com.kwad.sdk.contentalliance.detail.photo.comment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ksad.lottie.LottieAnimationView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ag;
/* loaded from: classes6.dex */
public class CommentLikeButton extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public int f32883a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32884b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32885c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f32886d;

    /* renamed from: e  reason: collision with root package name */
    public long f32887e;

    /* renamed from: f  reason: collision with root package name */
    public a f32888f;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i2);
    }

    public CommentLikeButton(Context context) {
        super(context);
        this.f32883a = 1;
        this.f32884b = null;
        this.f32885c = null;
        c();
    }

    public CommentLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32883a = 1;
        this.f32884b = null;
        this.f32885c = null;
        c();
    }

    public CommentLikeButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f32883a = 1;
        this.f32884b = null;
        this.f32885c = null;
        c();
    }

    private void a(final int i2) {
        this.f32886d.d();
        boolean z = i2 == 2;
        this.f32886d.a(true);
        this.f32886d.setAnimation(z ? R.raw.ksad_detail_comment_like_anim_2 : R.raw.ksad_detail_comment_unlike_anim_2);
        this.f32886d.setVisibility(0);
        this.f32886d.a(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentLikeButton.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                CommentLikeButton.this.setImageView(i2);
                CommentLikeButton.this.f32884b.setVisibility(0);
                CommentLikeButton.this.f32886d.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CommentLikeButton.this.setImageView(i2);
                CommentLikeButton.this.f32884b.setVisibility(0);
                CommentLikeButton.this.f32886d.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                CommentLikeButton.this.f32884b.setVisibility(8);
            }
        });
        this.f32886d.b();
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_comment_like_button_2, (ViewGroup) this, true);
        this.f32884b = (ImageView) findViewById(R.id.ksad_photo_comment_like_button_image);
        this.f32885c = (TextView) findViewById(R.id.ksad_photo_comment_like_count_text);
        this.f32886d = (LottieAnimationView) findViewById(R.id.ksad_photo_comment_like_animation_view);
        setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageView(int i2) {
        this.f32884b.setImageResource(i2 == 1 ? R.drawable.ksad_photo_comment_like_button_2_normal : R.drawable.ksad_photo_comment_like_button_2_selected);
    }

    private void setImageViewWithAnimator(int i2) {
        setImageView(i2);
        a(i2);
    }

    public void a(int i2, long j) {
        this.f32883a = i2;
        setImageView(i2);
        this.f32886d.setVisibility(8);
        this.f32887e = j;
        setLikeCount(j);
        setLikeCountColor(i2);
    }

    public boolean a() {
        return this.f32883a == 2;
    }

    public void b() {
        if (this.f32886d.c()) {
            this.f32886d.d();
        }
    }

    public int getLikeState() {
        return this.f32883a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        if (a()) {
            setLikeState(1);
            a aVar = this.f32888f;
            if (aVar != null) {
                aVar.a(1);
            }
            j = this.f32887e - 1;
        } else {
            setLikeState(2);
            a aVar2 = this.f32888f;
            if (aVar2 != null) {
                aVar2.a(2);
            }
            j = this.f32887e + 1;
        }
        this.f32887e = j;
        setLikeCount(j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public void setLikeCount(long j) {
        this.f32885c.setText(ag.a(j, ""));
    }

    public void setLikeCountColor(int i2) {
        this.f32885c.setTextColor(i2 == 2 ? -61862 : -7828591);
    }

    public void setLikeState(int i2) {
        this.f32883a = i2;
        setImageViewWithAnimator(i2);
        setLikeCountColor(i2);
    }

    public void setLikeStateListener(a aVar) {
        this.f32888f = aVar;
    }
}
