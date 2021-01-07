package com.kwad.sdk.contentalliance.trends.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.TrendInfo;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class TrendsRollingTextContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Handler f9189a;

    /* renamed from: b  reason: collision with root package name */
    public TextView[] f9190b;
    private int c;
    private int d;
    private List<TrendInfo> e;
    private AlphaAnimation f;
    private AlphaAnimation g;
    private Runnable h;
    private Runnable i;

    public TrendsRollingTextContainer(@NonNull Context context) {
        super(context);
        this.f9190b = new TextView[2];
        this.c = 0;
        this.d = 0;
        this.e = new ArrayList();
        this.f = null;
        this.g = null;
        this.h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer.this.b(TrendsRollingTextContainer.this.f9190b[TrendsRollingTextContainer.this.c]);
                TrendsRollingTextContainer.this.f9189a.removeCallbacks(TrendsRollingTextContainer.this.i);
                TrendsRollingTextContainer.this.f9189a.postDelayed(TrendsRollingTextContainer.this.i, 200L);
            }
        };
        this.i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer.this.f9190b[1 - TrendsRollingTextContainer.this.c].setText(((TrendInfo) TrendsRollingTextContainer.this.e.get(TrendsRollingTextContainer.this.d % TrendsRollingTextContainer.this.e.size())).name);
                    TrendsRollingTextContainer.this.a(TrendsRollingTextContainer.this.f9190b[1 - TrendsRollingTextContainer.this.c]);
                }
            }
        };
        d();
    }

    public TrendsRollingTextContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9190b = new TextView[2];
        this.c = 0;
        this.d = 0;
        this.e = new ArrayList();
        this.f = null;
        this.g = null;
        this.h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer.this.b(TrendsRollingTextContainer.this.f9190b[TrendsRollingTextContainer.this.c]);
                TrendsRollingTextContainer.this.f9189a.removeCallbacks(TrendsRollingTextContainer.this.i);
                TrendsRollingTextContainer.this.f9189a.postDelayed(TrendsRollingTextContainer.this.i, 200L);
            }
        };
        this.i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer.this.f9190b[1 - TrendsRollingTextContainer.this.c].setText(((TrendInfo) TrendsRollingTextContainer.this.e.get(TrendsRollingTextContainer.this.d % TrendsRollingTextContainer.this.e.size())).name);
                    TrendsRollingTextContainer.this.a(TrendsRollingTextContainer.this.f9190b[1 - TrendsRollingTextContainer.this.c]);
                }
            }
        };
        d();
    }

    public TrendsRollingTextContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9190b = new TextView[2];
        this.c = 0;
        this.d = 0;
        this.e = new ArrayList();
        this.f = null;
        this.g = null;
        this.h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer.this.b(TrendsRollingTextContainer.this.f9190b[TrendsRollingTextContainer.this.c]);
                TrendsRollingTextContainer.this.f9189a.removeCallbacks(TrendsRollingTextContainer.this.i);
                TrendsRollingTextContainer.this.f9189a.postDelayed(TrendsRollingTextContainer.this.i, 200L);
            }
        };
        this.i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer.this.f9190b[1 - TrendsRollingTextContainer.this.c].setText(((TrendInfo) TrendsRollingTextContainer.this.e.get(TrendsRollingTextContainer.this.d % TrendsRollingTextContainer.this.e.size())).name);
                    TrendsRollingTextContainer.this.a(TrendsRollingTextContainer.this.f9190b[1 - TrendsRollingTextContainer.this.c]);
                }
            }
        };
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView) {
        if (this.g != null) {
            textView.startAnimation(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView) {
        if (this.f != null) {
            textView.startAnimation(this.f);
        }
    }

    static /* synthetic */ int d(TrendsRollingTextContainer trendsRollingTextContainer) {
        int i = trendsRollingTextContainer.d;
        trendsRollingTextContainer.d = i + 1;
        return i;
    }

    private void d() {
        this.f9189a = new Handler(getContext().getMainLooper());
    }

    private void e() {
        this.f9190b[0] = (TextView) findViewById(R.id.ksad_trends_rolling_trend_name1);
        this.f9190b[1] = (TextView) findViewById(R.id.ksad_trends_rolling_trend_name2);
    }

    private void f() {
        if (this.e.size() > 0) {
            this.f9190b[this.c].setText(this.e.get(this.d % this.e.size()).name);
            this.f9190b[this.c].setVisibility(0);
            this.f9190b[1 - this.c].setVisibility(8);
        }
    }

    private void g() {
        this.f = new AlphaAnimation(1.0f, 0.0f);
        this.f.setDuration(300L);
        this.f.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TrendsRollingTextContainer.this.f9190b[TrendsRollingTextContainer.this.c].setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                TrendsRollingTextContainer.this.f9190b[TrendsRollingTextContainer.this.c].setVisibility(0);
            }
        });
        this.g = new AlphaAnimation(0.0f, 1.0f);
        this.g.setDuration(300L);
        this.g.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TrendsRollingTextContainer.this.f9190b[1 - TrendsRollingTextContainer.this.c].setVisibility(0);
                TrendsRollingTextContainer.this.c = 1 - TrendsRollingTextContainer.this.c;
                TrendsRollingTextContainer.this.c();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                TrendsRollingTextContainer.this.f9190b[1 - TrendsRollingTextContainer.this.c].setVisibility(0);
            }
        });
    }

    public void a() {
        setOnClickListener(null);
        if (this.f != null) {
            this.f.cancel();
            this.f.setAnimationListener(null);
        }
        if (this.g != null) {
            this.g.cancel();
            this.g.setAnimationListener(null);
        }
        b();
    }

    public void a(List<TrendInfo> list) {
        e();
        this.e = list;
        this.c = 0;
        this.d = 0;
        if (this.e.size() == 1) {
            f();
            setVisibility(0);
        } else if (this.e.size() < 2) {
            setVisibility(8);
        } else {
            f();
            setVisibility(0);
            g();
            c();
        }
    }

    public void b() {
        this.f9189a.removeCallbacks(this.i);
        this.f9189a.removeCallbacks(this.h);
        f();
    }

    public void c() {
        if (this.e.size() > 1) {
            this.f9189a.removeCallbacks(this.h);
            this.f9189a.postDelayed(this.h, 2000L);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        e();
    }
}
