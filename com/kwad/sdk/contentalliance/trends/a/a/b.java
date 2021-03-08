package com.kwad.sdk.contentalliance.trends.a.a;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.b.c;
import com.kwad.sdk.core.response.model.TrendInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends com.kwad.sdk.contentalliance.detail.b {
    private TextView b;
    private TextView c;
    private ViewGroup d;
    private Handler e;
    private ViewGroup g;
    private boolean f = false;
    private com.kwad.sdk.contentalliance.a.a h = new com.kwad.sdk.contentalliance.a.b() { // from class: com.kwad.sdk.contentalliance.trends.a.a.b.1
        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void j() {
            super.j();
            if (b.this.f) {
                b.this.e.postDelayed(new Runnable() { // from class: com.kwad.sdk.contentalliance.trends.a.a.b.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.d.setVisibility(8);
                    }
                }, 1000L);
            }
        }

        @Override // com.kwad.sdk.contentalliance.a.b, com.kwad.sdk.contentalliance.a.a
        public void k() {
            super.k();
            if (b.this.f) {
                b.this.e.removeCallbacksAndMessages(null);
            }
        }
    };
    private ViewPager.OnPageChangeListener i = new ViewPager.OnPageChangeListener() { // from class: com.kwad.sdk.contentalliance.trends.a.a.b.2
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            CharSequence pageTitle = b.this.f5594a.l.getAdapter().getPageTitle(b.this.f5594a.l.getCurrentItem());
            if (!b.this.f || b.this.f5594a.j.mCurrentTrendTitle == null || b.this.f5594a.j.mCurrentTrendTitle.equals(pageTitle.toString()) || b.this.d.getVisibility() == 0) {
                return;
            }
            b.this.d.setVisibility(0);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.contentalliance.detail.b, com.kwad.sdk.mvp.Presenter
    public void a() {
        super.a();
        this.d.setVisibility(8);
        if (c.B(this.f5594a.j)) {
            if (this.f5594a.j.mTrendSlideType != null) {
                this.f5594a.b.add(this.h);
                TrendInfo trendInfo = new TrendInfo();
                try {
                    trendInfo.parseJson(new JSONObject(this.f5594a.j.mCurrentTrendTitle));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.c.setText(trendInfo.name);
                this.b.setText(this.f5594a.j.mTrendSlideType);
                this.f = true;
                this.f5594a.l.a(this.i);
            }
            this.g.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void b_() {
        super.b_();
        if (this.f5594a.j.mTrendSlideType != null) {
            this.f5594a.b.remove(this.h);
            this.f5594a.l.b(this.i);
        }
        this.e.removeCallbacksAndMessages(null);
        this.d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.mvp.Presenter
    public void c() {
        super.c();
        this.e = new Handler();
        this.d = (ViewGroup) b(R.id.ksad_photo_trend_container);
        this.c = (TextView) b(R.id.ksad_content_alliance_trend_title);
        this.b = (TextView) b(R.id.ksad_content_alliance_trend_type);
        this.g = (ViewGroup) b(R.id.ksad_trend_feed_margin);
    }
}
