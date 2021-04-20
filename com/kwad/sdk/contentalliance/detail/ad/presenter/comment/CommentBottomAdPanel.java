package com.kwad.sdk.contentalliance.detail.ad.presenter.comment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.download.b.a;
import com.kwad.sdk.core.download.b.b;
import com.kwad.sdk.core.download.b.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseLinearLayout;
import com.kwad.sdk.core.view.e;
import com.kwad.sdk.utils.ao;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class CommentBottomAdPanel extends AdBaseLinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public TextView f32403a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f32404b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32405c;

    /* renamed from: d  reason: collision with root package name */
    public View f32406d;

    /* renamed from: e  reason: collision with root package name */
    public View f32407e;

    /* renamed from: f  reason: collision with root package name */
    public View f32408f;

    /* renamed from: g  reason: collision with root package name */
    public AnimatorSet f32409g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f32410h;
    public AdTemplate i;
    public AdInfo j;
    @Nullable
    public b k;
    public List<a> l;
    public View.OnClickListener m;
    public KsAppDownloadListener n;

    /* loaded from: classes6.dex */
    public interface a {
        void a();
    }

    public CommentBottomAdPanel(Context context) {
        super(context);
        this.l = new ArrayList();
        this.m = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentBottomAdPanel.this.c();
                com.kwad.sdk.core.report.b.l(CommentBottomAdPanel.this.i);
            }
        };
        this.n = new c() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.2
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                super.a(i);
                CommentBottomAdPanel.this.b(true, true);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.a());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                CommentBottomAdPanel.this.b(false, false);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.x(CommentBottomAdPanel.this.j));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                CommentBottomAdPanel.this.b(false, true);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.a(CommentBottomAdPanel.this.i));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                CommentBottomAdPanel.this.b(false, false);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.x(CommentBottomAdPanel.this.j));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                CommentBottomAdPanel.this.b(false, true);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.b());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                CommentBottomAdPanel.this.b(true, true);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.b(i));
            }
        };
        b();
    }

    public CommentBottomAdPanel(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.l = new ArrayList();
        this.m = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentBottomAdPanel.this.c();
                com.kwad.sdk.core.report.b.l(CommentBottomAdPanel.this.i);
            }
        };
        this.n = new c() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.2
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i) {
                super.a(i);
                CommentBottomAdPanel.this.b(true, true);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.a());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                CommentBottomAdPanel.this.b(false, false);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.x(CommentBottomAdPanel.this.j));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                CommentBottomAdPanel.this.b(false, true);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.a(CommentBottomAdPanel.this.i));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                CommentBottomAdPanel.this.b(false, false);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.x(CommentBottomAdPanel.this.j));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                CommentBottomAdPanel.this.b(false, true);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.b());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i) {
                CommentBottomAdPanel.this.b(true, true);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.b(i));
            }
        };
        b();
    }

    public CommentBottomAdPanel(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = new ArrayList();
        this.m = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentBottomAdPanel.this.c();
                com.kwad.sdk.core.report.b.l(CommentBottomAdPanel.this.i);
            }
        };
        this.n = new c() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.2
            @Override // com.kwad.sdk.core.download.b.c
            public void a(int i2) {
                super.a(i2);
                CommentBottomAdPanel.this.b(true, true);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.a());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFailed() {
                CommentBottomAdPanel.this.b(false, false);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.x(CommentBottomAdPanel.this.j));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onDownloadFinished() {
                CommentBottomAdPanel.this.b(false, true);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.a(CommentBottomAdPanel.this.i));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onIdle() {
                CommentBottomAdPanel.this.b(false, false);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.x(CommentBottomAdPanel.this.j));
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onInstalled() {
                CommentBottomAdPanel.this.b(false, true);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.b());
            }

            @Override // com.kwad.sdk.api.KsAppDownloadListener
            public void onProgressUpdate(int i2) {
                CommentBottomAdPanel.this.b(true, true);
                CommentBottomAdPanel.this.f32405c.setText(com.kwad.sdk.core.response.b.a.b(i2));
            }
        };
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        b.a(this.k, true);
        com.kwad.sdk.core.download.b.a.a(getContext(), this.i, new a.InterfaceC0393a() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.8
            @Override // com.kwad.sdk.core.download.b.a.InterfaceC0393a
            public void a() {
                com.kwad.sdk.core.d.a.a("commentBottomAdPanel", "notifyAdContentClick onAdContentClick itemClickType:" + i);
                com.kwad.sdk.core.report.b.a(CommentBottomAdPanel.this.i, i, CommentBottomAdPanel.this.getTouchCoords());
            }
        }, this.k);
    }

    private void b() {
        com.kwad.sdk.core.d.a.a("commentBottomAdPanel", "initView");
        this.f32410h = com.kwad.sdk.core.config.c.D() == 1;
        LayoutInflater.from(getContext()).inflate(this.f32410h ? R.layout.ksad_comment_bottom_ad_panel_layout : R.layout.ksad_comment_bottom_ad_panel_layout_2, (ViewGroup) this, true);
        this.f32403a = (TextView) findViewById(R.id.kasd_comment_bottom_ad_author_name);
        this.f32404b = (TextView) findViewById(R.id.kasd_comment_bottom_ad_content);
        this.f32405c = (TextView) findViewById(R.id.kasd_comment_bottom_ad_link_btn);
        this.f32408f = findViewById(R.id.kasd_comment_bottom_ad_link_btn_layout);
        this.f32406d = findViewById(R.id.kasd_comment_bottom_ad_close_btn);
        View findViewById = findViewById(R.id.kasd_comment_bottom_ad_layout);
        this.f32407e = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentBottomAdPanel.this.a(35);
            }
        });
        this.f32408f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentBottomAdPanel.this.a(34);
            }
        });
        this.f32403a.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentBottomAdPanel.this.a(90);
            }
        });
        this.f32404b.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommentBottomAdPanel.this.a(91);
            }
        });
        this.f32406d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (CommentBottomAdPanel.this.m != null) {
                    CommentBottomAdPanel.this.m.onClick(view);
                }
            }
        });
        if (this.f32410h) {
            e.a(this, -1, ao.a(getContext(), 6.0f), Color.parseColor("#14000000"), ao.a(getContext(), 4.0f), 0, 1);
        } else {
            e.a(this, getContext().getResources().getDrawable(R.drawable.ksad_comment_bottom_ad_bg));
        }
        setTranslationY(ao.a(getContext(), 80.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, boolean z2) {
        ViewGroup.LayoutParams layoutParams;
        TextView textView;
        int i;
        TextView textView2 = this.f32405c;
        if (textView2 == null || (layoutParams = textView2.getLayoutParams()) == null) {
            return;
        }
        if (z) {
            layoutParams.width = this.f32410h ? ao.a(getContext(), 104.0f) : -2;
            layoutParams.height = -2;
            textView = this.f32405c;
            i = 10;
        } else {
            layoutParams.width = -2;
            layoutParams.height = -2;
            textView = this.f32405c;
            i = 6;
        }
        textView.setMaxEms(i);
        this.f32405c.setSelected(z2);
        this.f32405c.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        for (a aVar : this.l) {
            aVar.a();
        }
    }

    public void a() {
        b bVar = this.k;
        if (bVar != null) {
            bVar.b(this.n);
        }
        this.l.clear();
    }

    public void a(@NonNull a aVar) {
        this.l.add(aVar);
    }

    public void a(AdTemplate adTemplate, @Nullable b bVar) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Context context;
        float f2;
        if (adTemplate == null) {
            return;
        }
        this.i = adTemplate;
        this.j = com.kwad.sdk.core.response.b.c.j(adTemplate);
        this.k = bVar;
        this.f32404b.setText(com.kwad.sdk.core.response.b.c.x(adTemplate));
        this.f32403a.setText(com.kwad.sdk.core.response.b.c.v(adTemplate));
        b(false, false);
        this.f32405c.setText(com.kwad.sdk.core.response.b.a.x(com.kwad.sdk.core.response.b.c.j(adTemplate)));
        b bVar2 = this.k;
        if (bVar2 != null) {
            bVar2.a(this.n);
        }
        if (this.f32410h) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            context = getContext();
            f2 = 8.0f;
        } else {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            context = getContext();
            f2 = 0.0f;
        }
        int a2 = ao.a(context, f2);
        marginLayoutParams.setMargins(a2, a2, a2, a2);
        setLayoutParams(marginLayoutParams);
        invalidate();
    }

    public void a(final boolean z, boolean z2) {
        if (z2) {
            setVisibility(8);
        }
        AnimatorSet animatorSet = this.f32409g;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f32409g.removeAllListeners();
            this.f32409g.cancel();
        }
        this.f32409g = new AnimatorSet();
        int a2 = ao.a(getContext(), 80.0f);
        com.kwad.sdk.core.d.a.a("commentBottomAdPanel", "bottomViewAnimate + isShow : " + z);
        String name = View.TRANSLATION_Y.getName();
        float[] fArr = new float[1];
        fArr[0] = z ? 0.0f : a2;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, name, fArr);
        ofFloat.setDuration(z ? 350L : 300L);
        this.f32409g.playTogether(ofFloat);
        this.f32409g.removeAllListeners();
        this.f32409g.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.sdk.contentalliance.detail.ad.presenter.comment.CommentBottomAdPanel.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                CommentBottomAdPanel.this.setVisibility(z ? 4 : 0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (z) {
                    return;
                }
                CommentBottomAdPanel.this.setVisibility(4);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator) {
                super.onAnimationPause(animator);
                CommentBottomAdPanel.this.setVisibility(z ? 4 : 0);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (z) {
                    CommentBottomAdPanel.this.setVisibility(0);
                }
            }
        });
        this.f32409g.start();
    }

    public void b(@NonNull a aVar) {
        this.l.remove(aVar);
    }

    public void setName(String str) {
        this.f32403a.setText(str);
    }
}
