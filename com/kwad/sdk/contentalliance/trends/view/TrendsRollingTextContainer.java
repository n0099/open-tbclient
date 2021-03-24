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
    public Handler f33087a;

    /* renamed from: b  reason: collision with root package name */
    public TextView[] f33088b;

    /* renamed from: c  reason: collision with root package name */
    public int f33089c;

    /* renamed from: d  reason: collision with root package name */
    public int f33090d;

    /* renamed from: e  reason: collision with root package name */
    public List<TrendInfo> f33091e;

    /* renamed from: f  reason: collision with root package name */
    public AlphaAnimation f33092f;

    /* renamed from: g  reason: collision with root package name */
    public AlphaAnimation f33093g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f33094h;
    public Runnable i;

    public TrendsRollingTextContainer(@NonNull Context context) {
        super(context);
        this.f33088b = new TextView[2];
        this.f33089c = 0;
        this.f33090d = 0;
        this.f33091e = new ArrayList();
        this.f33092f = null;
        this.f33093g = null;
        this.f33094h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.b(trendsRollingTextContainer.f33088b[trendsRollingTextContainer.f33089c]);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33087a.removeCallbacks(trendsRollingTextContainer2.i);
                TrendsRollingTextContainer trendsRollingTextContainer3 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer3.f33087a.postDelayed(trendsRollingTextContainer3.i, 200L);
            }
        };
        this.i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.f33091e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.f33088b[1 - trendsRollingTextContainer.f33089c].setText(((TrendInfo) TrendsRollingTextContainer.this.f33091e.get(TrendsRollingTextContainer.this.f33090d % TrendsRollingTextContainer.this.f33091e.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer2.a(trendsRollingTextContainer2.f33088b[1 - trendsRollingTextContainer2.f33089c]);
                }
            }
        };
        d();
    }

    public TrendsRollingTextContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33088b = new TextView[2];
        this.f33089c = 0;
        this.f33090d = 0;
        this.f33091e = new ArrayList();
        this.f33092f = null;
        this.f33093g = null;
        this.f33094h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.b(trendsRollingTextContainer.f33088b[trendsRollingTextContainer.f33089c]);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33087a.removeCallbacks(trendsRollingTextContainer2.i);
                TrendsRollingTextContainer trendsRollingTextContainer3 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer3.f33087a.postDelayed(trendsRollingTextContainer3.i, 200L);
            }
        };
        this.i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.f33091e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.f33088b[1 - trendsRollingTextContainer.f33089c].setText(((TrendInfo) TrendsRollingTextContainer.this.f33091e.get(TrendsRollingTextContainer.this.f33090d % TrendsRollingTextContainer.this.f33091e.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer2.a(trendsRollingTextContainer2.f33088b[1 - trendsRollingTextContainer2.f33089c]);
                }
            }
        };
        d();
    }

    public TrendsRollingTextContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33088b = new TextView[2];
        this.f33089c = 0;
        this.f33090d = 0;
        this.f33091e = new ArrayList();
        this.f33092f = null;
        this.f33093g = null;
        this.f33094h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.b(trendsRollingTextContainer.f33088b[trendsRollingTextContainer.f33089c]);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33087a.removeCallbacks(trendsRollingTextContainer2.i);
                TrendsRollingTextContainer trendsRollingTextContainer3 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer3.f33087a.postDelayed(trendsRollingTextContainer3.i, 200L);
            }
        };
        this.i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.f33091e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.f33088b[1 - trendsRollingTextContainer.f33089c].setText(((TrendInfo) TrendsRollingTextContainer.this.f33091e.get(TrendsRollingTextContainer.this.f33090d % TrendsRollingTextContainer.this.f33091e.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer2.a(trendsRollingTextContainer2.f33088b[1 - trendsRollingTextContainer2.f33089c]);
                }
            }
        };
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView) {
        AlphaAnimation alphaAnimation = this.f33093g;
        if (alphaAnimation != null) {
            textView.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView) {
        AlphaAnimation alphaAnimation = this.f33092f;
        if (alphaAnimation != null) {
            textView.startAnimation(alphaAnimation);
        }
    }

    public static /* synthetic */ int d(TrendsRollingTextContainer trendsRollingTextContainer) {
        int i = trendsRollingTextContainer.f33090d;
        trendsRollingTextContainer.f33090d = i + 1;
        return i;
    }

    private void d() {
        this.f33087a = new Handler(getContext().getMainLooper());
    }

    private void e() {
        this.f33088b[0] = (TextView) findViewById(R.id.ksad_trends_rolling_trend_name1);
        this.f33088b[1] = (TextView) findViewById(R.id.ksad_trends_rolling_trend_name2);
    }

    private void f() {
        if (this.f33091e.size() > 0) {
            TextView textView = this.f33088b[this.f33089c];
            List<TrendInfo> list = this.f33091e;
            textView.setText(list.get(this.f33090d % list.size()).name);
            this.f33088b[this.f33089c].setVisibility(0);
            this.f33088b[1 - this.f33089c].setVisibility(8);
        }
    }

    private void g() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.f33092f = alphaAnimation;
        alphaAnimation.setDuration(300L);
        this.f33092f.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33088b[trendsRollingTextContainer.f33089c].setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33088b[trendsRollingTextContainer.f33089c].setVisibility(0);
            }
        });
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.f33093g = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.f33093g.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33088b[1 - trendsRollingTextContainer.f33089c].setVisibility(0);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33089c = 1 - trendsRollingTextContainer2.f33089c;
                TrendsRollingTextContainer.this.c();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33088b[1 - trendsRollingTextContainer.f33089c].setVisibility(0);
            }
        });
    }

    public void a() {
        setOnClickListener(null);
        AlphaAnimation alphaAnimation = this.f33092f;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
            this.f33092f.setAnimationListener(null);
        }
        AlphaAnimation alphaAnimation2 = this.f33093g;
        if (alphaAnimation2 != null) {
            alphaAnimation2.cancel();
            this.f33093g.setAnimationListener(null);
        }
        b();
    }

    public void a(List<TrendInfo> list) {
        e();
        this.f33091e = list;
        this.f33089c = 0;
        this.f33090d = 0;
        if (list.size() == 1) {
            f();
            setVisibility(0);
        } else if (this.f33091e.size() < 2) {
            setVisibility(8);
        } else {
            f();
            setVisibility(0);
            g();
            c();
        }
    }

    public void b() {
        this.f33087a.removeCallbacks(this.i);
        this.f33087a.removeCallbacks(this.f33094h);
        f();
    }

    public void c() {
        if (this.f33091e.size() > 1) {
            this.f33087a.removeCallbacks(this.f33094h);
            this.f33087a.postDelayed(this.f33094h, 2000L);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        e();
    }
}
