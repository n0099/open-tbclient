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
    public Handler f33696a;

    /* renamed from: b  reason: collision with root package name */
    public TextView[] f33697b;

    /* renamed from: c  reason: collision with root package name */
    public int f33698c;

    /* renamed from: d  reason: collision with root package name */
    public int f33699d;

    /* renamed from: e  reason: collision with root package name */
    public List<TrendInfo> f33700e;

    /* renamed from: f  reason: collision with root package name */
    public AlphaAnimation f33701f;

    /* renamed from: g  reason: collision with root package name */
    public AlphaAnimation f33702g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f33703h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f33704i;

    public TrendsRollingTextContainer(@NonNull Context context) {
        super(context);
        this.f33697b = new TextView[2];
        this.f33698c = 0;
        this.f33699d = 0;
        this.f33700e = new ArrayList();
        this.f33701f = null;
        this.f33702g = null;
        this.f33703h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.b(trendsRollingTextContainer.f33697b[trendsRollingTextContainer.f33698c]);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33696a.removeCallbacks(trendsRollingTextContainer2.f33704i);
                TrendsRollingTextContainer trendsRollingTextContainer3 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer3.f33696a.postDelayed(trendsRollingTextContainer3.f33704i, 200L);
            }
        };
        this.f33704i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.f33700e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.f33697b[1 - trendsRollingTextContainer.f33698c].setText(((TrendInfo) TrendsRollingTextContainer.this.f33700e.get(TrendsRollingTextContainer.this.f33699d % TrendsRollingTextContainer.this.f33700e.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer2.a(trendsRollingTextContainer2.f33697b[1 - trendsRollingTextContainer2.f33698c]);
                }
            }
        };
        d();
    }

    public TrendsRollingTextContainer(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33697b = new TextView[2];
        this.f33698c = 0;
        this.f33699d = 0;
        this.f33700e = new ArrayList();
        this.f33701f = null;
        this.f33702g = null;
        this.f33703h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.b(trendsRollingTextContainer.f33697b[trendsRollingTextContainer.f33698c]);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33696a.removeCallbacks(trendsRollingTextContainer2.f33704i);
                TrendsRollingTextContainer trendsRollingTextContainer3 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer3.f33696a.postDelayed(trendsRollingTextContainer3.f33704i, 200L);
            }
        };
        this.f33704i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.f33700e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.f33697b[1 - trendsRollingTextContainer.f33698c].setText(((TrendInfo) TrendsRollingTextContainer.this.f33700e.get(TrendsRollingTextContainer.this.f33699d % TrendsRollingTextContainer.this.f33700e.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer2.a(trendsRollingTextContainer2.f33697b[1 - trendsRollingTextContainer2.f33698c]);
                }
            }
        };
        d();
    }

    public TrendsRollingTextContainer(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f33697b = new TextView[2];
        this.f33698c = 0;
        this.f33699d = 0;
        this.f33700e = new ArrayList();
        this.f33701f = null;
        this.f33702g = null;
        this.f33703h = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.1
            @Override // java.lang.Runnable
            public void run() {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.b(trendsRollingTextContainer.f33697b[trendsRollingTextContainer.f33698c]);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33696a.removeCallbacks(trendsRollingTextContainer2.f33704i);
                TrendsRollingTextContainer trendsRollingTextContainer3 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer3.f33696a.postDelayed(trendsRollingTextContainer3.f33704i, 200L);
            }
        };
        this.f33704i = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.2
            @Override // java.lang.Runnable
            public void run() {
                if (TrendsRollingTextContainer.this.f33700e.size() > 0) {
                    TrendsRollingTextContainer.d(TrendsRollingTextContainer.this);
                    TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer.f33697b[1 - trendsRollingTextContainer.f33698c].setText(((TrendInfo) TrendsRollingTextContainer.this.f33700e.get(TrendsRollingTextContainer.this.f33699d % TrendsRollingTextContainer.this.f33700e.size())).name);
                    TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                    trendsRollingTextContainer2.a(trendsRollingTextContainer2.f33697b[1 - trendsRollingTextContainer2.f33698c]);
                }
            }
        };
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView) {
        AlphaAnimation alphaAnimation = this.f33702g;
        if (alphaAnimation != null) {
            textView.startAnimation(alphaAnimation);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView) {
        AlphaAnimation alphaAnimation = this.f33701f;
        if (alphaAnimation != null) {
            textView.startAnimation(alphaAnimation);
        }
    }

    public static /* synthetic */ int d(TrendsRollingTextContainer trendsRollingTextContainer) {
        int i2 = trendsRollingTextContainer.f33699d;
        trendsRollingTextContainer.f33699d = i2 + 1;
        return i2;
    }

    private void d() {
        this.f33696a = new Handler(getContext().getMainLooper());
    }

    private void e() {
        this.f33697b[0] = (TextView) findViewById(R.id.ksad_trends_rolling_trend_name1);
        this.f33697b[1] = (TextView) findViewById(R.id.ksad_trends_rolling_trend_name2);
    }

    private void f() {
        if (this.f33700e.size() > 0) {
            TextView textView = this.f33697b[this.f33698c];
            List<TrendInfo> list = this.f33700e;
            textView.setText(list.get(this.f33699d % list.size()).name);
            this.f33697b[this.f33698c].setVisibility(0);
            this.f33697b[1 - this.f33698c].setVisibility(8);
        }
    }

    private void g() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        this.f33701f = alphaAnimation;
        alphaAnimation.setDuration(300L);
        this.f33701f.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33697b[trendsRollingTextContainer.f33698c].setVisibility(8);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33697b[trendsRollingTextContainer.f33698c].setVisibility(0);
            }
        });
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.f33702g = alphaAnimation2;
        alphaAnimation2.setDuration(300L);
        this.f33702g.setAnimationListener(new Animation.AnimationListener() { // from class: com.kwad.sdk.contentalliance.trends.view.TrendsRollingTextContainer.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33697b[1 - trendsRollingTextContainer.f33698c].setVisibility(0);
                TrendsRollingTextContainer trendsRollingTextContainer2 = TrendsRollingTextContainer.this;
                trendsRollingTextContainer2.f33698c = 1 - trendsRollingTextContainer2.f33698c;
                TrendsRollingTextContainer.this.c();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                TrendsRollingTextContainer trendsRollingTextContainer = TrendsRollingTextContainer.this;
                trendsRollingTextContainer.f33697b[1 - trendsRollingTextContainer.f33698c].setVisibility(0);
            }
        });
    }

    public void a() {
        setOnClickListener(null);
        AlphaAnimation alphaAnimation = this.f33701f;
        if (alphaAnimation != null) {
            alphaAnimation.cancel();
            this.f33701f.setAnimationListener(null);
        }
        AlphaAnimation alphaAnimation2 = this.f33702g;
        if (alphaAnimation2 != null) {
            alphaAnimation2.cancel();
            this.f33702g.setAnimationListener(null);
        }
        b();
    }

    public void a(List<TrendInfo> list) {
        e();
        this.f33700e = list;
        this.f33698c = 0;
        this.f33699d = 0;
        if (list.size() == 1) {
            f();
            setVisibility(0);
        } else if (this.f33700e.size() < 2) {
            setVisibility(8);
        } else {
            f();
            setVisibility(0);
            g();
            c();
        }
    }

    public void b() {
        this.f33696a.removeCallbacks(this.f33704i);
        this.f33696a.removeCallbacks(this.f33703h);
        f();
    }

    public void c() {
        if (this.f33700e.size() > 1) {
            this.f33696a.removeCallbacks(this.f33703h);
            this.f33696a.postDelayed(this.f33703h, 2000L);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        e();
    }
}
