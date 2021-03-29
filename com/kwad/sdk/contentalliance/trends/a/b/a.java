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
    public TextView f33021c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f33022d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f33023e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f33024f;

    /* renamed from: g  reason: collision with root package name */
    public i f33025g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f33026h;
    public com.kwad.sdk.contentalliance.trends.view.c i = new d() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.1
        @Override // com.kwad.sdk.contentalliance.trends.view.d, com.kwad.sdk.contentalliance.trends.view.c
        public void a() {
            a.this.f();
            a.this.f33022d.setVisibility(8);
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
            a.this.f33022d.setVisibility(0);
        }
    };
    public com.kwad.sdk.contentalliance.home.a.d j = new com.kwad.sdk.contentalliance.home.a.e() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.2
        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(int i, String str) {
            com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", " onError code " + i + " msg " + str);
            if (((e) a.this).f32769a.f32772c.getAdapter().a() == 0) {
                a.this.f33021c.setVisibility(8);
                a.this.f33023e.setVisibility(8);
                a.this.f33026h = true;
            }
        }

        @Override // com.kwad.sdk.contentalliance.home.a.e, com.kwad.sdk.contentalliance.home.a.d
        public void a(boolean z, int i) {
            com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", " onFinishLoading  " + z);
            a.this.f33026h = false;
            a.this.f33021c.setVisibility(0);
            a.this.f33023e.setVisibility(0);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public Runnable f33020b = new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.f33021c.setAlpha(1.0f);
            a.this.f33023e.setAlpha(1.0f);
            a.this.e();
        }
    };
    public ViewPager.OnPageChangeListener k = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.4
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            String str;
            int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i3 == 0 || ((e) a.this).f32769a.f32772c.getAdapter() == null) {
                return;
            }
            CharSequence pageTitle = ((e) a.this).f32769a.f32772c.getAdapter().getPageTitle(i);
            TrendInfo trendInfo = new TrendInfo();
            try {
                trendInfo.parseJson(new JSONObject(pageTitle.toString()));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            TrendInfo trendInfo2 = new TrendInfo();
            boolean z = true;
            if (((e) a.this).f32769a.f32772c.k()) {
                try {
                    trendInfo2.parseJson(new JSONObject(((e) a.this).f32769a.f32772c.getAdapter().getPageTitle(i + 1).toString()));
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            String str2 = trendInfo.name;
            if (!((str2 == null || (str = trendInfo2.name) == null || str2.equals(str)) ? false : false) || i3 == 0) {
                a.this.f33021c.setAlpha(1.0f);
                a.this.f33023e.setAlpha(1.0f);
                return;
            }
            float abs = Math.abs(f2 - 0.5f) * 2.0f;
            if (abs <= a.this.f33021c.getAlpha() || abs == 1.0f) {
                a.this.f33021c.setAlpha(abs);
                a.this.f33023e.setAlpha(abs);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (((e) a.this).f32769a.f32772c.getAdapter() != null) {
                CharSequence pageTitle = ((e) a.this).f32769a.f32772c.getAdapter().getPageTitle(i);
                if (TextUtils.isEmpty(pageTitle)) {
                    return;
                }
                TrendInfo trendInfo = new TrendInfo();
                try {
                    trendInfo.parseJson(new JSONObject(pageTitle.toString()));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                CharSequence text = a.this.f33021c.getText();
                if (TextUtils.isEmpty(trendInfo.name) || TextUtils.isEmpty(text) || text.equals(trendInfo.name)) {
                    a.this.a(trendInfo);
                    a.this.e();
                    return;
                }
                ((e) a.this).f32769a.i = trendInfo;
                a.this.a(trendInfo);
                a.this.f33021c.setVisibility(8);
                a.this.f33023e.setVisibility(8);
                a.this.f33021c.postDelayed(a.this.f33020b, IMLikeRequest.TIME_INTERVAL);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull TrendInfo trendInfo) {
        this.f33021c.setText(trendInfo.name);
        this.f33023e.setText(String.format(m().getString(R.string.ksad_trend_title_info_format), Integer.valueOf(trendInfo.rank), ag.b(trendInfo.viewCount)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        h hVar = ((e) this).f32769a.f32775f;
        if (hVar == null || hVar.l || this.f33026h) {
            return;
        }
        this.f33021c.setVisibility(0);
        this.f33023e.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f33021c.setVisibility(8);
        this.f33023e.setVisibility(8);
    }

    @Override // com.kwad.sdk.contentalliance.home.e, com.kwad.sdk.mvp.Presenter
    public void a() {
        ViewGroup viewGroup;
        int i;
        super.a();
        i iVar = ((e) this).f32769a.f32771b;
        this.f33025g = iVar;
        iVar.a(this.j);
        ((e) this).f32769a.f32772c.a(this.k);
        a(((e) this).f32769a.i);
        com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", "mCallerContext.mTrendListData size=" + ((e) this).f32769a.f32777h.size());
        TrendInfo trendInfo = ((e) this).f32769a.i;
        if (trendInfo != null) {
            com.kwad.sdk.core.d.a.a("PhotoTrendFeedTitlePresenter", "trendInfo" + trendInfo.toJson());
            a(trendInfo);
            this.f33021c.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
            viewGroup = this.f33024f;
            i = 0;
        } else {
            viewGroup = this.f33024f;
            i = 8;
        }
        viewGroup.setVisibility(i);
        ((e) this).f32769a.o.add(this.i);
        this.f33022d.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.trends.a.b.a.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Activity activity = ((e) a.this).f32769a.f32770a.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        ((e) this).f32769a.f32772c.b(this.k);
        ((e) this).f32769a.o.remove(this.i);
        this.f33025g.b(this.j);
        this.f33022d.setOnClickListener(null);
        this.f33021c.removeCallbacks(this.f33020b);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33024f = (ViewGroup) b(R.id.ksad_trends_feed_title_info);
        this.f33023e = (TextView) b(R.id.ksad_trends_feed_info_text);
        this.f33021c = (TextView) b(R.id.ksad_trends_feed_title);
        this.f33022d = (ImageView) b(R.id.ksad_trends_feed_back);
    }
}
