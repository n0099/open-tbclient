package com.kwad.sdk.contentalliance.trends.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
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
/* loaded from: classes3.dex */
public class TrendsPanelLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f8884a;

    /* renamed from: b  reason: collision with root package name */
    private com.kwad.sdk.contentalliance.trends.view.a f8885b;
    private a c;
    private b d;
    private ImageView e;
    private LinearLayout f;
    private RelativeLayout g;
    private TextView h;
    private TranslateAnimation i;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(View view, TrendInfo trendInfo, int i);
    }

    public TrendsPanelLayout(Context context) {
        super(context);
        this.c = null;
        this.d = null;
    }

    public TrendsPanelLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
        this.d = null;
    }

    public TrendsPanelLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = null;
        this.d = null;
    }

    private void d() {
        this.f = (LinearLayout) findViewById(R.id.ksad_trend_list_panel_space);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TrendsPanelLayout.this.a(3);
            }
        });
        this.g = (RelativeLayout) findViewById(R.id.ksad_trend_list_panel_layout);
        this.f8884a = (RecyclerView) findViewById(R.id.ksad_trend_list_recycler_view);
        this.e = (ImageView) findViewById(R.id.ksad_trend_list_panel_close_button);
        this.h = (TextView) findViewById(R.id.ksad_trend_panel_title);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams.addRule(9);
        layoutParams.leftMargin = ao.a(getContext(), 16.0f);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TrendsPanelLayout.this.a(1);
            }
        });
        this.f8884a.setVisibility(8);
        setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void e() {
        this.i = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        this.i.setDuration(300L);
        this.i.setInterpolator(AnimationUtils.loadInterpolator(getContext(), 17432580));
        this.g.startAnimation(this.i);
    }

    private void f() {
        this.i = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        this.i.setDuration(300L);
        this.i.setInterpolator(AnimationUtils.loadInterpolator(getContext(), 17432580));
        this.i.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TrendsPanelLayout.this.g.setVisibility(8);
                TrendsPanelLayout.this.f.setVisibility(8);
                TrendsPanelLayout.this.setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.g.startAnimation(this.i);
    }

    public void a() {
        this.f8884a.setVisibility(0);
        this.g.setVisibility(0);
        this.f.setVisibility(0);
        setVisibility(0);
        e();
    }

    public void a(int i) {
        f();
        if (this.c != null) {
            this.c.a(i);
        }
    }

    public void a(@NonNull com.kwad.sdk.contentalliance.trends.view.b bVar) {
        this.f8884a.setItemAnimator(null);
        this.f8884a.setLayoutManager(b());
        this.f8885b = b(bVar);
        this.f8884a.setAdapter(this.f8885b);
    }

    @NonNull
    protected RecyclerView.LayoutManager b() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        return linearLayoutManager;
    }

    protected com.kwad.sdk.contentalliance.trends.view.a b(@NonNull com.kwad.sdk.contentalliance.trends.view.b bVar) {
        return new com.kwad.sdk.contentalliance.trends.view.a(getContext(), bVar, new b() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.5
            @Override // com.kwad.sdk.contentalliance.trends.view.TrendsPanelLayout.b
            public void a(View view, TrendInfo trendInfo, int i) {
                if (TrendsPanelLayout.this.d != null) {
                    TrendsPanelLayout.this.d.a(view, trendInfo, i);
                }
                TrendsPanelLayout.this.a(4);
            }
        });
    }

    public void c() {
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case 1:
                getParent().requestDisallowInterceptTouchEvent(false);
                break;
            case 2:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        d();
    }

    public void setCloseListener(@NonNull a aVar) {
        this.c = aVar;
    }

    public void setItemClickListener(@NonNull b bVar) {
        this.d = bVar;
    }
}
