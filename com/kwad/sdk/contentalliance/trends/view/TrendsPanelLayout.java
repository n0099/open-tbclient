package com.kwad.sdk.contentalliance.trends.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.utils.ao;
/* loaded from: classes6.dex */
public class TrendsPanelLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f33075a;

    /* renamed from: b  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.view.a f33076b;

    /* renamed from: c  reason: collision with root package name */
    public a f33077c;

    /* renamed from: d  reason: collision with root package name */
    public b f33078d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f33079e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f33080f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f33081g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f33082h;
    public TranslateAnimation i;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(View view, TrendInfo trendInfo, int i);
    }

    public TrendsPanelLayout(Context context) {
        super(context);
        this.f33077c = null;
        this.f33078d = null;
    }

    public TrendsPanelLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33077c = null;
        this.f33078d = null;
    }

    public TrendsPanelLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33077c = null;
        this.f33078d = null;
    }

    private void d() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ksad_trend_list_panel_space);
        this.f33080f = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TrendsPanelLayout.this.a(3);
            }
        });
        this.f33081g = (RelativeLayout) findViewById(R.id.ksad_trend_list_panel_layout);
        this.f33075a = (RecyclerView) findViewById(R.id.ksad_trend_list_recycler_view);
        this.f33079e = (ImageView) findViewById(R.id.ksad_trend_list_panel_close_button);
        TextView textView = (TextView) findViewById(R.id.ksad_trend_panel_title);
        this.f33082h = textView;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.addRule(9);
        layoutParams.leftMargin = ao.a(getContext(), 16.0f);
        this.f33079e.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TrendsPanelLayout.this.a(1);
            }
        });
        this.f33075a.setVisibility(8);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void e() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        this.i = translateAnimation;
        translateAnimation.setDuration(300L);
        this.i.setInterpolator(AnimationUtils.loadInterpolator(getContext(), 17432580));
        this.f33081g.startAnimation(this.i);
    }

    private void f() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        this.i = translateAnimation;
        translateAnimation.setDuration(300L);
        this.i.setInterpolator(AnimationUtils.loadInterpolator(getContext(), 17432580));
        this.i.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TrendsPanelLayout.this.f33081g.setVisibility(8);
                TrendsPanelLayout.this.f33080f.setVisibility(8);
                TrendsPanelLayout.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f33081g.startAnimation(this.i);
    }

    public void a() {
        this.f33075a.setVisibility(0);
        this.f33081g.setVisibility(0);
        this.f33080f.setVisibility(0);
        setVisibility(0);
        e();
    }

    public void a(int i) {
        f();
        a aVar = this.f33077c;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.trends.view.b bVar) {
        this.f33075a.setItemAnimator(null);
        this.f33075a.setLayoutManager(b());
        com.kwad.sdk.contentalliance.trends.view.a b2 = b(bVar);
        this.f33076b = b2;
        this.f33075a.setAdapter(b2);
    }

    @NonNull
    public RecyclerView.LayoutManager b() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        return linearLayoutManager;
    }

    public com.kwad.sdk.contentalliance.trends.view.a b(@NonNull com.kwad.sdk.contentalliance.trends.view.b bVar) {
        return new com.kwad.sdk.contentalliance.trends.view.a(getContext(), bVar, new b() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.5
            @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.b
            public void a(View view, TrendInfo trendInfo, int i) {
                if (TrendsPanelLayout.this.f33078d != null) {
                    TrendsPanelLayout.this.f33078d.a(view, trendInfo, i);
                }
                TrendsPanelLayout.this.a(4);
            }
        });
    }

    public void c() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000a, code lost:
        if (r0 != 2) goto L6;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        int action = motionEvent.getAction();
        boolean z = true;
        if (action != 0) {
            if (action == 1) {
                parent = getParent();
                z = false;
                parent.requestDisallowInterceptTouchEvent(z);
                return super.dispatchTouchEvent(motionEvent);
            }
        }
        parent = getParent();
        parent.requestDisallowInterceptTouchEvent(z);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        d();
    }

    public void setCloseListener(@NonNull a aVar) {
        this.f33077c = aVar;
    }

    public void setItemClickListener(@NonNull b bVar) {
        this.f33078d = bVar;
    }
}
