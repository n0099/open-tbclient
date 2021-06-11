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
    public TubeProfile f33957a;

    /* renamed from: b  reason: collision with root package name */
    public a f33958b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f33959c;

    /* renamed from: d  reason: collision with root package name */
    public TrendTubeEpisodeViewPager f33960d;

    /* renamed from: e  reason: collision with root package name */
    public b f33961e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f33962f;

    /* loaded from: classes6.dex */
    public interface a {
        void a(AdTemplate adTemplate, int i2, View view);
    }

    /* loaded from: classes6.dex */
    public class b extends PagerAdapter implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public List<EpisodePhotoView> f33965b;

        /* renamed from: c  reason: collision with root package name */
        public List<EpisodePhotoView> f33966c;

        public b() {
            this.f33965b = new ArrayList();
            this.f33966c = new ArrayList();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            if (obj instanceof View) {
                viewGroup.removeView((View) obj);
                this.f33965b.add((EpisodePhotoView) obj);
                this.f33966c.remove(obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return TrendTubeScrollView.this.f33959c.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i2) {
            return TrendTubeScrollView.this.a(getCount(), i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
            EpisodePhotoView episodePhotoView;
            if (this.f33965b.size() > 0) {
                episodePhotoView = this.f33965b.remove(0);
                episodePhotoView.l();
            } else {
                episodePhotoView = (EpisodePhotoView) View.inflate(TrendTubeScrollView.this.getContext(), R.layout.ksad_tube_trend_scroll_view_episode_photo, null);
            }
            viewGroup.addView(episodePhotoView);
            episodePhotoView.a(i2, TrendTubeScrollView.this.f33957a.tubeInfo.tubeId);
            episodePhotoView.setTemplateData((AdTemplate) TrendTubeScrollView.this.f33959c.get(i2));
            episodePhotoView.setOnClickListener(TrendTubeScrollView.this.f33962f);
            if (i2 < 5 || i2 != getCount() - 1 || TrendTubeScrollView.this.f33957a.tubeInfo.totalEpisodeCount <= 6) {
                episodePhotoView.setLookMoreVisibility(false);
            } else {
                episodePhotoView.setLookMoreVisibility(true);
            }
            episodePhotoView.setId(i2);
            this.f33966c.add(episodePhotoView);
            return episodePhotoView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
            return view == obj;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
        }
    }

    public TrendTubeScrollView(Context context) {
        super(context);
        this.f33959c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f33962f = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EpisodePhotoView episodePhotoView = (EpisodePhotoView) view;
                TrendTubeScrollView.this.a(episodePhotoView.getTemplateData(), episodePhotoView.getPosition(), view);
            }
        };
    }

    public TrendTubeScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33959c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f33962f = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EpisodePhotoView episodePhotoView = (EpisodePhotoView) view;
                TrendTubeScrollView.this.a(episodePhotoView.getTemplateData(), episodePhotoView.getPosition(), view);
            }
        };
    }

    private void b() {
        TrendTubeEpisodeViewPager trendTubeEpisodeViewPager = (TrendTubeEpisodeViewPager) findViewById(R.id.ksad_tube_trend_item_viewpager);
        this.f33960d = trendTubeEpisodeViewPager;
        trendTubeEpisodeViewPager.setPageMargin(ao.a(getContext(), 4.0f));
        this.f33960d.setOffscreenPageLimit(3);
    }

    public float a(int i2, int i3) {
        return 0.29f;
    }

    @Override // com.kwad.sdk.widget.b
    public void a() {
        super.a();
    }

    public void a(TubeProfile tubeProfile) {
        this.f33957a = tubeProfile;
        if (tubeProfile == null) {
            removeAllViews();
            return;
        }
        this.f33959c.clear();
        Iterator<AdTemplate> it = this.f33957a.adTemplateList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            this.f33959c.add(it.next());
            i2++;
            if (i2 == 6) {
                break;
            }
        }
        setVisibility(0);
        b bVar = new b();
        this.f33961e = bVar;
        this.f33960d.setAdapter(bVar);
        this.f33960d.setOnPageChangeListener(this.f33961e);
    }

    public void a(AdTemplate adTemplate, int i2, View view) {
        a aVar = this.f33958b;
        if (aVar == null) {
            return;
        }
        aVar.a(adTemplate, i2, view);
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
    public void onMeasure(int i2, int i3) {
        float ratio = getRatio();
        if (ratio != 0.0f) {
            int size = View.MeasureSpec.getSize(i2);
            com.kwad.sdk.core.d.a.a("TrendTubeScrollView", "ratio = " + ratio + " widthSize=" + size);
            i3 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * ratio), 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    public void setEpisodeItemClickListener(a aVar) {
        this.f33958b = aVar;
    }
}
