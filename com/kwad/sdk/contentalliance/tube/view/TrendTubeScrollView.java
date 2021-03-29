package com.kwad.sdk.contentalliance.tube.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.contentalliance.tube.model.TubeProfile;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes6.dex */
public class TrendTubeScrollView extends com.kwad.sdk.widget.b {

    /* renamed from: a  reason: collision with root package name */
    public TubeProfile f33341a;

    /* renamed from: b  reason: collision with root package name */
    public a f33342b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f33343c;

    /* renamed from: d  reason: collision with root package name */
    public TrendTubeEpisodeViewPager f33344d;

    /* renamed from: e  reason: collision with root package name */
    public b f33345e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f33346f;

    /* loaded from: classes6.dex */
    public interface a {
        void a(AdTemplate adTemplate, int i, View view);
    }

    /* loaded from: classes6.dex */
    public class b extends PagerAdapter implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public List<EpisodePhotoView> f33349b;

        /* renamed from: c  reason: collision with root package name */
        public List<EpisodePhotoView> f33350c;

        public b() {
            this.f33349b = new ArrayList();
            this.f33350c = new ArrayList();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            if (obj instanceof View) {
                viewGroup.removeView((View) obj);
                this.f33349b.add((EpisodePhotoView) obj);
                this.f33350c.remove(obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return TrendTubeScrollView.this.f33343c.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i) {
            return TrendTubeScrollView.this.a(getCount(), i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            EpisodePhotoView episodePhotoView;
            if (this.f33349b.size() > 0) {
                episodePhotoView = this.f33349b.remove(0);
                episodePhotoView.l();
            } else {
                episodePhotoView = (EpisodePhotoView) View.inflate(TrendTubeScrollView.this.getContext(), R.layout.ksad_tube_trend_scroll_view_episode_photo, null);
            }
            viewGroup.addView(episodePhotoView);
            episodePhotoView.a(i, TrendTubeScrollView.this.f33341a.tubeInfo.tubeId);
            episodePhotoView.setTemplateData((AdTemplate) TrendTubeScrollView.this.f33343c.get(i));
            episodePhotoView.setOnClickListener(TrendTubeScrollView.this.f33346f);
            if (i < 5 || i != getCount() - 1 || TrendTubeScrollView.this.f33341a.tubeInfo.totalEpisodeCount <= 6) {
                episodePhotoView.setLookMoreVisibility(false);
            } else {
                episodePhotoView.setLookMoreVisibility(true);
            }
            episodePhotoView.setId(i);
            this.f33350c.add(episodePhotoView);
            return episodePhotoView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    }

    public TrendTubeScrollView(Context context) {
        super(context);
        this.f33343c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f33346f = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EpisodePhotoView episodePhotoView = (EpisodePhotoView) view;
                TrendTubeScrollView.this.a(episodePhotoView.getTemplateData(), episodePhotoView.getPosition(), view);
            }
        };
    }

    public TrendTubeScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33343c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f33346f = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EpisodePhotoView episodePhotoView = (EpisodePhotoView) view;
                TrendTubeScrollView.this.a(episodePhotoView.getTemplateData(), episodePhotoView.getPosition(), view);
            }
        };
    }

    private void b() {
        TrendTubeEpisodeViewPager trendTubeEpisodeViewPager = (TrendTubeEpisodeViewPager) findViewById(R.id.ksad_tube_trend_item_viewpager);
        this.f33344d = trendTubeEpisodeViewPager;
        trendTubeEpisodeViewPager.setPageMargin(ao.a(getContext(), 4.0f));
        this.f33344d.setOffscreenPageLimit(3);
    }

    public float a(int i, int i2) {
        return 0.29f;
    }

    @Override // com.kwad.sdk.widget.b
    public void a() {
        super.a();
    }

    public void a(TubeProfile tubeProfile) {
        this.f33341a = tubeProfile;
        if (tubeProfile == null) {
            removeAllViews();
            return;
        }
        this.f33343c.clear();
        Iterator<AdTemplate> it = this.f33341a.adTemplateList.iterator();
        int i = 0;
        while (it.hasNext()) {
            this.f33343c.add(it.next());
            i++;
            if (i == 6) {
                break;
            }
        }
        setVisibility(0);
        b bVar = new b();
        this.f33345e = bVar;
        this.f33344d.setAdapter(bVar);
        this.f33344d.setOnPageChangeListener(this.f33345e);
    }

    public void a(AdTemplate adTemplate, int i, View view) {
        a aVar = this.f33342b;
        if (aVar == null) {
            return;
        }
        aVar.a(adTemplate, i, view);
    }

    public float getRatio() {
        return 0.38f;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    @Override // com.kwad.sdk.feed.widget.base.b, android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        float ratio = getRatio();
        if (ratio != 0.0f) {
            int size = View.MeasureSpec.getSize(i);
            com.kwad.sdk.core.d.a.a("TrendTubeScrollView", "ratio = " + ratio + " widthSize=" + size);
            i2 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * ratio), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setEpisodeItemClickListener(a aVar) {
        this.f33342b = aVar;
    }
}
