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
    public TextView f33010b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f33011c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f33012d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f33013e;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f33015g;

    /* renamed from: f  reason: collision with root package name */
    public boolean f33014f = false;

    /* renamed from: h  reason: collision with root package name */
    public com.kwad.sdk.contentalliance.a.a f33016h = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.trends.a.a.b.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (b.this.f33014f) {
                b.this.f33013e.postDelayed(new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.a.a.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.f33012d.setVisibility(8);
                    }
                }, 1000L);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            if (b.this.f33014f) {
                b.this.f33013e.removeCallbacksAndMessages(null);
            }
        }
    };
    public ViewPager.OnPageChangeListener i = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.trends.a.a.b.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
            CharSequence pageTitle = ((com.kwad.sdk.contentalliance.detail.b) b.this).f32133a.l.getAdapter().getPageTitle(((com.kwad.sdk.contentalliance.detail.b) b.this).f32133a.l.getCurrentItem());
            if (!b.this.f33014f || ((com.kwad.sdk.contentalliance.detail.b) b.this).f32133a.j.mCurrentTrendTitle == null || ((com.kwad.sdk.contentalliance.detail.b) b.this).f32133a.j.mCurrentTrendTitle.equals(pageTitle.toString()) || b.this.f33012d.getVisibility() == 0) {
                return;
            }
            b.this.f33012d.setVisibility(0);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    };

    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.f33012d.setVisibility(8);
        if (c.B(((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j)) {
            com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a;
            if (cVar.j.mTrendSlideType != null) {
                cVar.f32153b.add(this.f33016h);
                TrendInfo trendInfo = new TrendInfo();
                try {
                    trendInfo.parseJson(new JSONObject(((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j.mCurrentTrendTitle));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.f33011c.setText(trendInfo.name);
                this.f33010b.setText(((com.kwad.sdk.contentalliance.detail.b) this).f32133a.j.mTrendSlideType);
                this.f33014f = true;
                ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.l.a(this.i);
            }
            this.f33015g.setVisibility(0);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        com.kwad.sdk.contentalliance.detail.c cVar = ((com.kwad.sdk.contentalliance.detail.b) this).f32133a;
        if (cVar.j.mTrendSlideType != null) {
            cVar.f32153b.remove(this.f33016h);
            ((com.kwad.sdk.contentalliance.detail.b) this).f32133a.l.b(this.i);
        }
        this.f33013e.removeCallbacksAndMessages(null);
        this.f33012d.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.f33013e = new Handler();
        this.f33012d = (ViewGroup) b(R.id.ksad_photo_trend_container);
        this.f33011c = (TextView) b(R.id.ksad_content_alliance_trend_title);
        this.f33010b = (TextView) b(R.id.ksad_content_alliance_trend_type);
        this.f33015g = (ViewGroup) b(R.id.ksad_trend_feed_margin);
    }
}
