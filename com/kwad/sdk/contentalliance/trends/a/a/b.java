package com.kwad.sdk.contentalliance.trends.a.a;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.TrendInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {

    /* renamed from: b  reason: collision with root package name */
    public TextView f33394b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33395c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f33396d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f33397e;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f33399g;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33398f = false;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f33400h = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.trends.a.a.b.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (b.this.f33398f) {
                b.this.f33397e.postDelayed(new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.a.a.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.f33396d.setVisibility(8);
                    }
                }, 1000L);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            if (b.this.f33398f) {
                b.this.f33397e.removeCallbacksAndMessages(null);
            }
        }
    };
    public ViewPager.OnPageChangeListener i = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.trends.a.a.b.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            CharSequence pageTitle = ((com.kwad.sdk.contentalliance.detail.b) b.this).f32517a.l.getAdapter().getPageTitle(((com.kwad.sdk.contentalliance.detail.b) b.this).f32517a.l.getCurrentItem());
            if (!b.this.f33398f || ((com.kwad.sdk.contentalliance.detail.b) b.this).f32517a.j.mCurrentTrendTitle == null || ((com.kwad.sdk.contentalliance.detail.b) b.this).f32517a.j.mCurrentTrendTitle.equals(pageTitle.toString()) || b.this.f33396d.getVisibility() == 0) {
                return;
            }
            b.this.f33396d.setVisibility(0);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    };

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33396d.setVisibility(8);
        if (c.B(((com.kwad.sdk.contentalliance.detail.b) this).f32517a.j)) {
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a;
            if (cVar.j.mTrendSlideType != null) {
                cVar.f32537b.add(this.f33400h);
                TrendInfo trendInfo = new TrendInfo();
                try {
                    trendInfo.parseJson(new JSONObject(((com.kwad.sdk.contentalliance.detail.b) this).f32517a.j.mCurrentTrendTitle));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.f33395c.setText(trendInfo.name);
                this.f33394b.setText(((com.kwad.sdk.contentalliance.detail.b) this).f32517a.j.mTrendSlideType);
                this.f33398f = true;
                ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.l.a(this.i);
            }
            this.f33399g.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32517a;
        if (cVar.j.mTrendSlideType != null) {
            cVar.f32537b.remove(this.f33400h);
            ((com.kwad.sdk.contentalliance.detail.b) this).f32517a.l.b(this.i);
        }
        this.f33397e.removeCallbacksAndMessages(null);
        this.f33396d.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33397e = new Handler();
        this.f33396d = (ViewGroup) b(R.id.ksad_photo_trend_container);
        this.f33395c = (TextView) b(R.id.ksad_content_alliance_trend_title);
        this.f33394b = (TextView) b(R.id.ksad_content_alliance_trend_type);
        this.f33399g = (ViewGroup) b(R.id.ksad_trend_feed_margin);
    }
}
