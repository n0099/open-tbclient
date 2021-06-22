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
    public TubeProfile f34055a;

    /* renamed from: b  reason: collision with root package name */
    public a f34056b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f34057c;

    /* renamed from: d  reason: collision with root package name */
    public TrendTubeEpisodeViewPager f34058d;

    /* renamed from: e  reason: collision with root package name */
    public b f34059e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f34060f;

    /* loaded from: classes6.dex */
    public interface a {
        void a(AdTemplate adTemplate, int i2, View view);
    }

    /* loaded from: classes6.dex */
    public class b extends PagerAdapter implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public List<EpisodePhotoView> f34063b;

        /* renamed from: c  reason: collision with root package name */
        public List<EpisodePhotoView> f34064c;

        public b() {
            this.f34063b = new ArrayList();
            this.f34064c = new ArrayList();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            if (obj instanceof View) {
                viewGroup.removeView((View) obj);
                this.f34063b.add((EpisodePhotoView) obj);
                this.f34064c.remove(obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return TrendTubeScrollView.this.f34057c.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i2) {
            return TrendTubeScrollView.this.a(getCount(), i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
            EpisodePhotoView episodePhotoView;
            if (this.f34063b.size() > 0) {
                episodePhotoView = this.f34063b.remove(0);
                episodePhotoView.l();
            } else {
                episodePhotoView = (EpisodePhotoView) View.inflate(TrendTubeScrollView.this.getContext(), R.layout.ksad_tube_trend_scroll_view_episode_photo, null);
            }
            viewGroup.addView(episodePhotoView);
            episodePhotoView.a(i2, TrendTubeScrollView.this.f34055a.tubeInfo.tubeId);
            episodePhotoView.setTemplateData((AdTemplate) TrendTubeScrollView.this.f34057c.get(i2));
            episodePhotoView.setOnClickListener(TrendTubeScrollView.this.f34060f);
            if (i2 < 5 || i2 != getCount() - 1 || TrendTubeScrollView.this.f34055a.tubeInfo.totalEpisodeCount <= 6) {
                episodePhotoView.setLookMoreVisibility(false);
            } else {
                episodePhotoView.setLookMoreVisibility(true);
            }
            episodePhotoView.setId(i2);
            this.f34064c.add(episodePhotoView);
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
        this.f34057c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f34060f = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EpisodePhotoView episodePhotoView = (EpisodePhotoView) view;
                TrendTubeScrollView.this.a(episodePhotoView.getTemplateData(), episodePhotoView.getPosition(), view);
            }
        };
    }

    public TrendTubeScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34057c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f34060f = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EpisodePhotoView episodePhotoView = (EpisodePhotoView) view;
                TrendTubeScrollView.this.a(episodePhotoView.getTemplateData(), episodePhotoView.getPosition(), view);
            }
        };
    }

    private void b() {
        TrendTubeEpisodeViewPager trendTubeEpisodeViewPager = (TrendTubeEpisodeViewPager) findViewById(R.id.ksad_tube_trend_item_viewpager);
        this.f34058d = trendTubeEpisodeViewPager;
        trendTubeEpisodeViewPager.setPageMargin(ao.a(getContext(), 4.0f));
        this.f34058d.setOffscreenPageLimit(3);
    }

    public float a(int i2, int i3) {
        return 0.29f;
    }

    @Override // com.kwad.sdk.widget.b
    public void a() {
        super.a();
    }

    public void a(TubeProfile tubeProfile) {
        this.f34055a = tubeProfile;
        if (tubeProfile == null) {
            removeAllViews();
            return;
        }
        this.f34057c.clear();
        Iterator<AdTemplate> it = this.f34055a.adTemplateList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            this.f34057c.add(it.next());
            i2++;
            if (i2 == 6) {
                break;
            }
        }
        setVisibility(0);
        b bVar = new b();
        this.f34059e = bVar;
        this.f34058d.setAdapter(bVar);
        this.f34058d.setOnPageChangeListener(this.f34059e);
    }

    public void a(AdTemplate adTemplate, int i2, View view) {
        a aVar = this.f34056b;
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
        this.f34056b = aVar;
    }
}
