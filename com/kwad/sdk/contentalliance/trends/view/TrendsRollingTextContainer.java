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
/* loaded from: classes6.dex */
public class TrendsRollingTextContainer extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Handler f33088a;

    /* renamed from: b  reason: collision with root package name */
    public TextView[] f33089b;

    /* renamed from: c  reason: collision with root package name */
    public int f33090c;

    /* renamed from: d  reason: collision with root package name */
    public int f33091d;

    /* renamed from: e  reason: collision with root package name */
    public List<TrendInfo> f33092e;

    /* renamed from: f  reason: collision with root package name */
    public AlphaAnimation f33093f;

    /* renamed from: g  reason: collision with root package name */
    public AlphaAnimation f33094g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f33095h;
    public Runnable i;

    public TrendsRollingTextContainer(@NonNull Context context) {
        super(context);
        this.f33089b = new TextView[2];
        this.f33090c = 0;
        this.f33091d = 0;
        this.f33092e = new ArrayList();
        this.f33093f = null;
        this.f33094g = null;
        this.f33095h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.b(trendsRollingTextContainer.f33089b[trendsRollingTextContainer.f33090c]);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33088a.removeCallbacks(trendsRollingTextContainer2.i);
                TrendsRollingTextContainer trendsRollingTextContainer3 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer3.f33088a.postDelayed(trendsRollingTextContainer3.i, 200L);
            }
        };
        this.i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.f33092e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.f33089b[1 - trendsRollingTextContainer.f33090c].setText(((TrendInfo) TrendsRollingTextContainer.this.f33092e.get(TrendsRollingTextContainer.this.f33091d % TrendsRollingTextContainer.this.f33092e.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer2.a(trendsRollingTextContainer2.f33089b[1 - trendsRollingTextContainer2.f33090c]);
                }
            }
        };
        d();
    }

    public TrendsRollingTextContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33089b = new TextView[2];
        this.f33090c = 0;
        this.f33091d = 0;
        this.f33092e = new ArrayList();
        this.f33093f = null;
        this.f33094g = null;
        this.f33095h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.b(trendsRollingTextContainer.f33089b[trendsRollingTextContainer.f33090c]);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33088a.removeCallbacks(trendsRollingTextContainer2.i);
                TrendsRollingTextContainer trendsRollingTextContainer3 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer3.f33088a.postDelayed(trendsRollingTextContainer3.i, 200L);
            }
        };
        this.i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.f33092e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.f33089b[1 - trendsRollingTextContainer.f33090c].setText(((TrendInfo) TrendsRollingTextContainer.this.f33092e.get(TrendsRollingTextContainer.this.f33091d % TrendsRollingTextContainer.this.f33092e.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer2.a(trendsRollingTextContainer2.f33089b[1 - trendsRollingTextContainer2.f33090c]);
                }
            }
        };
        d();
    }

    public TrendsRollingTextContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33089b = new TextView[2];
        this.f33090c = 0;
        this.f33091d = 0;
        this.f33092e = new ArrayList();
        this.f33093f = null;
        this.f33094g = null;
        this.f33095h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.b(trendsRollingTextContainer.f33089b[trendsRollingTextContainer.f33090c]);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33088a.removeCallbacks(trendsRollingTextContainer2.i);
                TrendsRollingTextContainer trendsRollingTextContainer3 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer3.f33088a.postDelayed(trendsRollingTextContainer3.i, 200L);
            }
        };
        this.i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.f33092e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.f33089b[1 - trendsRollingTextContainer.f33090c].setText(((TrendInfo) TrendsRollingTextContainer.this.f33092e.get(TrendsRollingTextContainer.this.f33091d % TrendsRollingTextContainer.this.f33092e.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer2.a(trendsRollingTextContainer2.f33089b[1 - trendsRollingTextContainer2.f33090c]);
                }
            }
        };
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView) {
        AlphaAnimation alphaAnimation = this.f33094g;
        if (alphaAnimation != null) {
            textView.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView) {
        AlphaAnimation alphaAnimation = this.f33093f;
        if (alphaAnimation != null) {
            textView.startAnimation(alphaAnimation);
        }
    }

    public static /* synthetic */ int d(TrendsRollingTextContainer trendsRollingTextContainer) {
        int i = trendsRollingTextContainer.f33091d;
        trendsRollingTextContainer.f33091d = i + 1;
        return i;
    }

    private void d() {
        this.f33088a = new Handler(getContext().getMainLooper());
    }

    private void e() {
        this.f33089b[0] = (TextView) findViewById(R.id.ksad_trends_rolling_trend_name1);
        this.f33089b[1] = (TextView) findViewById(R.id.ksad_trends_rolling_trend_name2);
    }

    private void f() {
        if (this.f33092e.size() > 0) {
            TextView textView = this.f33089b[this.f33090c];
            List<TrendInfo> list = this.f33092e;
            textView.setText(list.get(this.f33091d % list.size()).name);
            this.f33089b[this.f33090c].setVisibility(0);
            this.f33089b[1 - this.f33090c].setVisibility(8);
        }
    }

    private void g() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.f33093f = alphaAnimation;
        alphaAnimation.setDuration(300L);
        this.f33093f.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33089b[trendsRollingTextContainer.f33090c].setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33089b[trendsRollingTextContainer.f33090c].setVisibility(0);
            }
        });
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.f33094g = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.f33094g.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33089b[1 - trendsRollingTextContainer.f33090c].setVisibility(0);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33090c = 1 - trendsRollingTextContainer2.f33090c;
                TrendsRollingTextContainer.this.c();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33089b[1 - trendsRollingTextContainer.f33090c].setVisibility(0);
            }
        });
    }

    public void a() {
        setOnClickListener(null);
        AlphaAnimation alphaAnimation = this.f33093f;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
            this.f33093f.setAnimationListener(null);
        }
        AlphaAnimation alphaAnimation2 = this.f33094g;
        if (alphaAnimation2 != null) {
            alphaAnimation2.cancel();
            this.f33094g.setAnimationListener(null);
        }
        b();
    }

    public void a(List<TrendInfo> list) {
        e();
        this.f33092e = list;
        this.f33090c = 0;
        this.f33091d = 0;
        if (list.size() == 1) {
            f();
            setVisibility(0);
        } else if (this.f33092e.size() < 2) {
            setVisibility(8);
        } else {
            f();
            setVisibility(0);
            g();
            c();
        }
    }

    public void b() {
        this.f33088a.removeCallbacks(this.i);
        this.f33088a.removeCallbacks(this.f33095h);
        f();
    }

    public void c() {
        if (this.f33092e.size() > 1) {
            this.f33088a.removeCallbacks(this.f33095h);
            this.f33088a.postDelayed(this.f33095h, 2000L);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        e();
    }
}
