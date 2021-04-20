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
    public int f32507a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f32508b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32509c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f32510d;

    /* renamed from: e  reason: collision with root package name */
    public long f32511e;

    /* renamed from: f  reason: collision with root package name */
    public a f32512f;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i);
    }

    public CommentLikeButton(Context context) {
        super(context);
        this.f32507a = 1;
        this.f32508b = null;
        this.f32509c = null;
        c();
    }

    public CommentLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32507a = 1;
        this.f32508b = null;
        this.f32509c = null;
        c();
    }

    public CommentLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f32507a = 1;
        this.f32508b = null;
        this.f32509c = null;
        c();
    }

    private void a(final int i) {
        this.f32510d.d();
        boolean z = i == 2;
        this.f32510d.a(true);
        this.f32510d.setAnimation(z ? R.raw.ksad_detail_comment_like_anim_2 : R.raw.ksad_detail_comment_unlike_anim_2);
        this.f32510d.setVisibility(0);
        this.f32510d.a(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentLikeButton.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                CommentLikeButton.this.setImageView(i);
                CommentLikeButton.this.f32508b.setVisibility(0);
                CommentLikeButton.this.f32510d.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CommentLikeButton.this.setImageView(i);
                CommentLikeButton.this.f32508b.setVisibility(0);
                CommentLikeButton.this.f32510d.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                CommentLikeButton.this.f32508b.setVisibility(8);
            }
        });
        this.f32510d.b();
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_comment_like_button_2, (ViewGroup) this, true);
        this.f32508b = (ImageView) findViewById(R.id.ksad_photo_comment_like_button_image);
        this.f32509c = (TextView) findViewById(R.id.ksad_photo_comment_like_count_text);
        this.f32510d = (LottieAnimationView) findViewById(R.id.ksad_photo_comment_like_animation_view);
        setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageView(int i) {
        this.f32508b.setImageResource(i == 1 ? R.drawable.ksad_photo_comment_like_button_2_normal : R.drawable.ksad_photo_comment_like_button_2_selected);
    }

    private void setImageViewWithAnimator(int i) {
        setImageView(i);
        a(i);
    }

    public void a(int i, long j) {
        this.f32507a = i;
        setImageView(i);
        this.f32510d.setVisibility(8);
        this.f32511e = j;
        setLikeCount(j);
        setLikeCountColor(i);
    }

    public boolean a() {
        return this.f32507a == 2;
    }

    public void b() {
        if (this.f32510d.c()) {
            this.f32510d.d();
        }
    }

    public int getLikeState() {
        return this.f32507a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        long j;
        if (a()) {
            setLikeState(1);
            a aVar = this.f32512f;
            if (aVar != null) {
                aVar.a(1);
            }
            j = this.f32511e - 1;
        } else {
            setLikeState(2);
            a aVar2 = this.f32512f;
            if (aVar2 != null) {
                aVar2.a(2);
            }
            j = this.f32511e + 1;
        }
        this.f32511e = j;
        setLikeCount(j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public void setLikeCount(long j) {
        this.f32509c.setText(ag.a(j, ""));
    }

    public void setLikeCountColor(int i) {
        this.f32509c.setTextColor(i == 2 ? -61862 : -7828591);
    }

    public void setLikeState(int i) {
        this.f32507a = i;
        setImageViewWithAnimator(i);
        setLikeCountColor(i);
    }

    public void setLikeStateListener(a aVar) {
        this.f32512f = aVar;
    }
}
