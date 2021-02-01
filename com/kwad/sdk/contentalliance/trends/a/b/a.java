package com.kwad.sdk.contentalliance.trends.a.b;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.contentalliance.home.e;
import com.kwad.sdk.contentalliance.trends.view.d;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends e {
    private TextView c;
    private ImageView d;
    private TextView e;
    private ViewGroup f;
    private i g;
    private boolean h;
    private com.kwad.sdk.contentalliance.trends.view.c i = new d() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a() {
            a.this.f();
            a.this.d.setVisibility(8);
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a(View view, TrendInfo trendInfo, int i) {
            if (trendInfo != null) {
                a.this.a(trendInfo);
            }
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void b() {
            a.this.e();
            a.this.d.setVisibility(0);
        }
    };
    private com.kwad.sdk.contentalliance.home.a.d j = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.2
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", " onError code " + i + " msg " + str);
            if (a.this.f8736a.c.getAdapter().a() == 0) {
                a.this.c.setVisibility(8);
                a.this.e.setVisibility(8);
                a.this.h = true;
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", " onFinishLoading  " + z);
            a.this.h = false;
            a.this.c.setVisibility(0);
            a.this.e.setVisibility(0);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    Runnable f8855b = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.c.setAlpha(1.0f);
            a.this.e.setAlpha(1.0f);
            a.this.e();
        }
    };
    private ViewPager.OnPageChangeListener k = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.4
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            if (f == 0.0f || a.this.f8736a.c.getAdapter() == null) {
                return;
            }
            CharSequence pageTitle = a.this.f8736a.c.getAdapter().getPageTitle(i);
            TrendInfo trendInfo = new TrendInfo();
            try {
                trendInfo.parseJson(new JSONObject(pageTitle.toString()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            TrendInfo trendInfo2 = new TrendInfo();
            if (a.this.f8736a.c.k()) {
                try {
                    trendInfo2.parseJson(new JSONObject(a.this.f8736a.c.getAdapter().getPageTitle(i + 1).toString()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            if (!((trendInfo.name == null || trendInfo2.name == null || trendInfo.name.equals(trendInfo2.name)) ? false : true) || f == 0.0f) {
                a.this.c.setAlpha(1.0f);
                a.this.e.setAlpha(1.0f);
                return;
            }
            float abs = Math.abs(f - 0.5f) * 2.0f;
            if (abs <= a.this.c.getAlpha() || abs == 1.0f) {
                a.this.c.setAlpha(abs);
                a.this.e.setAlpha(abs);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (a.this.f8736a.c.getAdapter() != null) {
                CharSequence pageTitle = a.this.f8736a.c.getAdapter().getPageTitle(i);
                if (TextUtils.isEmpty(pageTitle)) {
                    return;
                }
                TrendInfo trendInfo = new TrendInfo();
                try {
                    trendInfo.parseJson(new JSONObject(pageTitle.toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                CharSequence text = a.this.c.getText();
                if (TextUtils.isEmpty(trendInfo.name) || TextUtils.isEmpty(text) || text.equals(trendInfo.name)) {
                    a.this.a(trendInfo);
                    a.this.e();
                    return;
                }
                a.this.f8736a.i = trendInfo;
                a.this.a(trendInfo);
                a.this.c.setVisibility(8);
                a.this.e.setVisibility(8);
                a.this.c.postDelayed(a.this.f8855b, 1200L);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull TrendInfo trendInfo) {
        this.c.setText(trendInfo.name);
        this.e.setText(String.format(m().getString(R.string.ksad_trend_title_info_format), Integer.valueOf(trendInfo.rank), ag.b(trendInfo.viewCount)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f8736a.f == null || this.f8736a.f.l || this.h) {
            return;
        }
        this.c.setVisibility(0);
        this.e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.c.setVisibility(8);
        this.e.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.g = this.f8736a.f8738b;
        this.g.a(this.j);
        this.f8736a.c.a(this.k);
        a(this.f8736a.i);
        com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", "mCallerContext.mTrendListData size=" + this.f8736a.h.size());
        TrendInfo trendInfo = this.f8736a.i;
        if (trendInfo != null) {
            com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", "trendInfo" + trendInfo.toJson());
            a(trendInfo);
            this.c.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
        this.f8736a.o.add(this.i);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity activity = a.this.f8736a.f8737a.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        this.f8736a.c.b(this.k);
        this.f8736a.o.remove(this.i);
        this.g.b(this.j);
        this.d.setOnClickListener(null);
        this.c.removeCallbacks(this.f8855b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f = (ViewGroup) b(R.id.ksad_trends_feed_title_info);
        this.e = (TextView) b(R.id.ksad_trends_feed_info_text);
        this.c = (TextView) b(R.id.ksad_trends_feed_title);
        this.d = (ImageView) b(R.id.ksad_trends_feed_back);
    }
}
