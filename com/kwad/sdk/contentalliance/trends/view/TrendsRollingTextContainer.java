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
    public Handler f33794a;

    /* renamed from: b  reason: collision with root package name */
    public TextView[] f33795b;

    /* renamed from: c  reason: collision with root package name */
    public int f33796c;

    /* renamed from: d  reason: collision with root package name */
    public int f33797d;

    /* renamed from: e  reason: collision with root package name */
    public List<TrendInfo> f33798e;

    /* renamed from: f  reason: collision with root package name */
    public AlphaAnimation f33799f;

    /* renamed from: g  reason: collision with root package name */
    public AlphaAnimation f33800g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f33801h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f33802i;

    public TrendsRollingTextContainer(@NonNull Context context) {
        super(context);
        this.f33795b = new TextView[2];
        this.f33796c = 0;
        this.f33797d = 0;
        this.f33798e = new ArrayList();
        this.f33799f = null;
        this.f33800g = null;
        this.f33801h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.b(trendsRollingTextContainer.f33795b[trendsRollingTextContainer.f33796c]);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33794a.removeCallbacks(trendsRollingTextContainer2.f33802i);
                TrendsRollingTextContainer trendsRollingTextContainer3 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer3.f33794a.postDelayed(trendsRollingTextContainer3.f33802i, 200L);
            }
        };
        this.f33802i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.f33798e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.f33795b[1 - trendsRollingTextContainer.f33796c].setText(((TrendInfo) TrendsRollingTextContainer.this.f33798e.get(TrendsRollingTextContainer.this.f33797d % TrendsRollingTextContainer.this.f33798e.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer2.a(trendsRollingTextContainer2.f33795b[1 - trendsRollingTextContainer2.f33796c]);
                }
            }
        };
        d();
    }

    public TrendsRollingTextContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33795b = new TextView[2];
        this.f33796c = 0;
        this.f33797d = 0;
        this.f33798e = new ArrayList();
        this.f33799f = null;
        this.f33800g = null;
        this.f33801h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.b(trendsRollingTextContainer.f33795b[trendsRollingTextContainer.f33796c]);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33794a.removeCallbacks(trendsRollingTextContainer2.f33802i);
                TrendsRollingTextContainer trendsRollingTextContainer3 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer3.f33794a.postDelayed(trendsRollingTextContainer3.f33802i, 200L);
            }
        };
        this.f33802i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.f33798e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.f33795b[1 - trendsRollingTextContainer.f33796c].setText(((TrendInfo) TrendsRollingTextContainer.this.f33798e.get(TrendsRollingTextContainer.this.f33797d % TrendsRollingTextContainer.this.f33798e.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer2.a(trendsRollingTextContainer2.f33795b[1 - trendsRollingTextContainer2.f33796c]);
                }
            }
        };
        d();
    }

    public TrendsRollingTextContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33795b = new TextView[2];
        this.f33796c = 0;
        this.f33797d = 0;
        this.f33798e = new ArrayList();
        this.f33799f = null;
        this.f33800g = null;
        this.f33801h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.b(trendsRollingTextContainer.f33795b[trendsRollingTextContainer.f33796c]);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33794a.removeCallbacks(trendsRollingTextContainer2.f33802i);
                TrendsRollingTextContainer trendsRollingTextContainer3 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer3.f33794a.postDelayed(trendsRollingTextContainer3.f33802i, 200L);
            }
        };
        this.f33802i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.f33798e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.f33795b[1 - trendsRollingTextContainer.f33796c].setText(((TrendInfo) TrendsRollingTextContainer.this.f33798e.get(TrendsRollingTextContainer.this.f33797d % TrendsRollingTextContainer.this.f33798e.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer2.a(trendsRollingTextContainer2.f33795b[1 - trendsRollingTextContainer2.f33796c]);
                }
            }
        };
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView) {
        AlphaAnimation alphaAnimation = this.f33800g;
        if (alphaAnimation != null) {
            textView.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView) {
        AlphaAnimation alphaAnimation = this.f33799f;
        if (alphaAnimation != null) {
            textView.startAnimation(alphaAnimation);
        }
    }

    public static /* synthetic */ int d(TrendsRollingTextContainer trendsRollingTextContainer) {
        int i2 = trendsRollingTextContainer.f33797d;
        trendsRollingTextContainer.f33797d = i2 + 1;
        return i2;
    }

    private void d() {
        this.f33794a = new Handler(getContext().getMainLooper());
    }

    private void e() {
        this.f33795b[0] = (TextView) findViewById(R.id.ksad_trends_rolling_trend_name1);
        this.f33795b[1] = (TextView) findViewById(R.id.ksad_trends_rolling_trend_name2);
    }

    private void f() {
        if (this.f33798e.size() > 0) {
            TextView textView = this.f33795b[this.f33796c];
            List<TrendInfo> list = this.f33798e;
            textView.setText(list.get(this.f33797d % list.size()).name);
            this.f33795b[this.f33796c].setVisibility(0);
            this.f33795b[1 - this.f33796c].setVisibility(8);
        }
    }

    private void g() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.f33799f = alphaAnimation;
        alphaAnimation.setDuration(300L);
        this.f33799f.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33795b[trendsRollingTextContainer.f33796c].setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33795b[trendsRollingTextContainer.f33796c].setVisibility(0);
            }
        });
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.f33800g = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.f33800g.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33795b[1 - trendsRollingTextContainer.f33796c].setVisibility(0);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33796c = 1 - trendsRollingTextContainer2.f33796c;
                TrendsRollingTextContainer.this.c();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33795b[1 - trendsRollingTextContainer.f33796c].setVisibility(0);
            }
        });
    }

    public void a() {
        setOnClickListener(null);
        AlphaAnimation alphaAnimation = this.f33799f;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
            this.f33799f.setAnimationListener(null);
        }
        AlphaAnimation alphaAnimation2 = this.f33800g;
        if (alphaAnimation2 != null) {
            alphaAnimation2.cancel();
            this.f33800g.setAnimationListener(null);
        }
        b();
    }

    public void a(List<TrendInfo> list) {
        e();
        this.f33798e = list;
        this.f33796c = 0;
        this.f33797d = 0;
        if (list.size() == 1) {
            f();
            setVisibility(0);
        } else if (this.f33798e.size() < 2) {
            setVisibility(8);
        } else {
            f();
            setVisibility(0);
            g();
            c();
        }
    }

    public void b() {
        this.f33794a.removeCallbacks(this.f33802i);
        this.f33794a.removeCallbacks(this.f33801h);
        f();
    }

    public void c() {
        if (this.f33798e.size() > 1) {
            this.f33794a.removeCallbacks(this.f33801h);
            this.f33794a.postDelayed(this.f33801h, 2000L);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        e();
    }
}
