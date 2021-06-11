package com.kwad.sdk.contentalliance.trends.a.b;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import com.baidu.livesdk.sdk.service.IMLikeRequest;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.home.a.i;
import com.kwad.sdk.contentalliance.home.e;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.contentalliance.trends.view.d;
import com.kwad.sdk.core.response.model.TrendInfo;
import com.kwad.sdk.utils.ag;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends e {

    /* renamed from: c  reason: collision with root package name */
    public TextView f33625c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f33626d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33627e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f33628f;

    /* renamed from: g  reason: collision with root package name */
    public i f33629g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33630h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.trends.view.c f33631i = new d() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a() {
            a.this.f();
            a.this.f33626d.setVisibility(8);
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a(View view, TrendInfo trendInfo, int i2) {
            if (trendInfo != null) {
                a.this.a(trendInfo);
            }
        }

        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void b() {
            a.this.e();
            a.this.f33626d.setVisibility(0);
        }
    };
    public com.kwad.sdk.contentalliance.home.a.d j = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.2
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(int i2, String str) {
            com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", " onError code " + i2 + " msg " + str);
            if (((e) a.this).f33357a.f33360c.getAdapter().a() == 0) {
                a.this.f33625c.setVisibility(8);
                a.this.f33627e.setVisibility(8);
                a.this.f33630h = true;
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i2) {
            com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", " onFinishLoading  " + z);
            a.this.f33630h = false;
            a.this.f33625c.setVisibility(0);
            a.this.f33627e.setVisibility(0);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public Runnable f33624b = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.f33625c.setAlpha(1.0f);
            a.this.f33627e.setAlpha(1.0f);
            a.this.e();
        }
    };
    public ViewPager.OnPageChangeListener k = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.4
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            String str;
            int i4 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i4 == 0 || ((e) a.this).f33357a.f33360c.getAdapter() == null) {
                return;
            }
            CharSequence pageTitle = ((e) a.this).f33357a.f33360c.getAdapter().getPageTitle(i2);
            TrendInfo trendInfo = new TrendInfo();
            try {
                trendInfo.parseJson(new JSONObject(pageTitle.toString()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            TrendInfo trendInfo2 = new TrendInfo();
            boolean z = true;
            if (((e) a.this).f33357a.f33360c.k()) {
                try {
                    trendInfo2.parseJson(new JSONObject(((e) a.this).f33357a.f33360c.getAdapter().getPageTitle(i2 + 1).toString()));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            String str2 = trendInfo.name;
            if (!((str2 == null || (str = trendInfo2.name) == null || str2.equals(str)) ? false : false) || i4 == 0) {
                a.this.f33625c.setAlpha(1.0f);
                a.this.f33627e.setAlpha(1.0f);
                return;
            }
            float abs = Math.abs(f2 - 0.5f) * 2.0f;
            if (abs <= a.this.f33625c.getAlpha() || abs == 1.0f) {
                a.this.f33625c.setAlpha(abs);
                a.this.f33627e.setAlpha(abs);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (((e) a.this).f33357a.f33360c.getAdapter() != null) {
                CharSequence pageTitle = ((e) a.this).f33357a.f33360c.getAdapter().getPageTitle(i2);
                if (TextUtils.isEmpty(pageTitle)) {
                    return;
                }
                TrendInfo trendInfo = new TrendInfo();
                try {
                    trendInfo.parseJson(new JSONObject(pageTitle.toString()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                CharSequence text = a.this.f33625c.getText();
                if (TextUtils.isEmpty(trendInfo.name) || TextUtils.isEmpty(text) || text.equals(trendInfo.name)) {
                    a.this.a(trendInfo);
                    a.this.e();
                    return;
                }
                ((e) a.this).f33357a.f33366i = trendInfo;
                a.this.a(trendInfo);
                a.this.f33625c.setVisibility(8);
                a.this.f33627e.setVisibility(8);
                a.this.f33625c.postDelayed(a.this.f33624b, IMLikeRequest.TIME_INTERVAL);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull TrendInfo trendInfo) {
        this.f33625c.setText(trendInfo.name);
        this.f33627e.setText(String.format(m().getString(R.string.ksad_trend_title_info_format), Integer.valueOf(trendInfo.rank), ag.b(trendInfo.viewCount)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        h hVar = ((e) this).f33357a.f33363f;
        if (hVar == null || hVar.l || this.f33630h) {
            return;
        }
        this.f33625c.setVisibility(0);
        this.f33627e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f33625c.setVisibility(8);
        this.f33627e.setVisibility(8);
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        int i2;
        super.a();
        i iVar = ((e) this).f33357a.f33359b;
        this.f33629g = iVar;
        iVar.a(this.j);
        ((e) this).f33357a.f33360c.a(this.k);
        a(((e) this).f33357a.f33366i);
        com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", "mCallerContext.mTrendListData size=" + ((e) this).f33357a.f33365h.size());
        TrendInfo trendInfo = ((e) this).f33357a.f33366i;
        if (trendInfo != null) {
            com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", "trendInfo" + trendInfo.toJson());
            a(trendInfo);
            this.f33625c.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            viewGroup = this.f33628f;
            i2 = 0;
        } else {
            viewGroup = this.f33628f;
            i2 = 8;
        }
        viewGroup.setVisibility(i2);
        ((e) this).f33357a.o.add(this.f33631i);
        this.f33626d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity activity = ((e) a.this).f33357a.f33358a.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((e) this).f33357a.f33360c.b(this.k);
        ((e) this).f33357a.o.remove(this.f33631i);
        this.f33629g.b(this.j);
        this.f33626d.setOnClickListener(null);
        this.f33625c.removeCallbacks(this.f33624b);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33628f = (ViewGroup) b(R.id.ksad_trends_feed_title_info);
        this.f33627e = (TextView) b(R.id.ksad_trends_feed_info_text);
        this.f33625c = (TextView) b(R.id.ksad_trends_feed_title);
        this.f33626d = (ImageView) b(R.id.ksad_trends_feed_back);
    }
}
