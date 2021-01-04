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
/* loaded from: classes5.dex */
public class CommentLikeButton extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private int f8734a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f8735b;
    private TextView c;
    private LottieAnimationView d;
    private long e;
    private a f;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i);
    }

    public CommentLikeButton(Context context) {
        super(context);
        this.f8734a = 1;
        this.f8735b = null;
        this.c = null;
        c();
    }

    public CommentLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8734a = 1;
        this.f8735b = null;
        this.c = null;
        c();
    }

    public CommentLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8734a = 1;
        this.f8735b = null;
        this.c = null;
        c();
    }

    private void a(final int i) {
        this.d.d();
        boolean z = i == 2;
        this.d.a(true);
        this.d.setAnimation(z ? R.raw.ksad_detail_comment_like_anim_2 : R.raw.ksad_detail_comment_unlike_anim_2);
        this.d.setVisibility(0);
        this.d.a(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.photo.comment.CommentLikeButton.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                CommentLikeButton.this.setImageView(i);
                CommentLikeButton.this.f8735b.setVisibility(0);
                CommentLikeButton.this.d.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                CommentLikeButton.this.setImageView(i);
                CommentLikeButton.this.f8735b.setVisibility(0);
                CommentLikeButton.this.d.setVisibility(8);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                CommentLikeButton.this.f8735b.setVisibility(8);
            }
        });
        this.d.b();
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(R.layout.ksad_content_alliance_comment_like_button_2, (ViewGroup) this, true);
        this.f8735b = (ImageView) findViewById(R.id.ksad_photo_comment_like_button_image);
        this.c = (TextView) findViewById(R.id.ksad_photo_comment_like_count_text);
        this.d = (LottieAnimationView) findViewById(R.id.ksad_photo_comment_like_animation_view);
        setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageView(int i) {
        this.f8735b.setImageResource(i == 1 ? R.drawable.ksad_photo_comment_like_button_2_normal : R.drawable.ksad_photo_comment_like_button_2_selected);
    }

    private void setImageViewWithAnimator(int i) {
        setImageView(i);
        a(i);
    }

    public void a(int i, long j) {
        this.f8734a = i;
        setImageView(i);
        this.d.setVisibility(8);
        this.e = j;
        setLikeCount(j);
        setLikeCountColor(i);
    }

    public boolean a() {
        return this.f8734a == 2;
    }

    public void b() {
        if (this.d.c()) {
            this.d.d();
        }
    }

    public int getLikeState() {
        return this.f8734a;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (a()) {
            setLikeState(1);
            if (this.f != null) {
                this.f.a(1);
            }
            long j = this.e - 1;
            this.e = j;
            setLikeCount(j);
            return;
        }
        setLikeState(2);
        if (this.f != null) {
            this.f.a(2);
        }
        long j2 = this.e + 1;
        this.e = j2;
        setLikeCount(j2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public void setLikeCount(long j) {
        this.c.setText(ag.a(j, ""));
    }

    public void setLikeCountColor(int i) {
        this.c.setTextColor(i == 2 ? -61862 : -7828591);
    }

    public void setLikeState(int i) {
        this.f8734a = i;
        setImageViewWithAnimator(i);
        setLikeCountColor(i);
    }

    public void setLikeStateListener(a aVar) {
        this.f = aVar;
    }
}
