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
/* loaded from: classes4.dex */
public class TrendTubeScrollView extends com.kwad.sdk.widget.b {

    /* renamed from: a  reason: collision with root package name */
    protected TubeProfile f9001a;

    /* renamed from: b  reason: collision with root package name */
    private a f9002b;
    private com.kwad.sdk.lib.widget.b<AdTemplate> c;
    private TrendTubeEpisodeViewPager d;
    private b e;
    private View.OnClickListener f;

    /* loaded from: classes4.dex */
    public interface a {
        void a(AdTemplate adTemplate, int i, View view);
    }

    /* loaded from: classes4.dex */
    private class b extends PagerAdapter implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private List<EpisodePhotoView> f9005b;
        private List<EpisodePhotoView> c;

        private b() {
            this.f9005b = new ArrayList();
            this.c = new ArrayList();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            if (obj instanceof View) {
                viewGroup.removeView((View) obj);
                this.f9005b.add((EpisodePhotoView) obj);
                this.c.remove(obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return TrendTubeScrollView.this.c.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i) {
            return TrendTubeScrollView.this.a(getCount(), i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            EpisodePhotoView episodePhotoView;
            if (this.f9005b.size() > 0) {
                EpisodePhotoView remove = this.f9005b.remove(0);
                remove.l();
                episodePhotoView = remove;
            } else {
                episodePhotoView = (EpisodePhotoView) View.inflate(TrendTubeScrollView.this.getContext(), R.layout.ksad_tube_trend_scroll_view_episode_photo, null);
            }
            viewGroup.addView(episodePhotoView);
            episodePhotoView.a(i, TrendTubeScrollView.this.f9001a.tubeInfo.tubeId);
            episodePhotoView.setTemplateData((AdTemplate) TrendTubeScrollView.this.c.get(i));
            episodePhotoView.setOnClickListener(TrendTubeScrollView.this.f);
            if (i < 5 || i != getCount() - 1 || TrendTubeScrollView.this.f9001a.tubeInfo.totalEpisodeCount <= 6) {
                episodePhotoView.setLookMoreVisibility(false);
            } else {
                episodePhotoView.setLookMoreVisibility(true);
            }
            episodePhotoView.setId(i);
            this.c.add(episodePhotoView);
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
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
        }
    }

    public TrendTubeScrollView(Context context) {
        super(context);
        this.c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EpisodePhotoView episodePhotoView = (EpisodePhotoView) view;
                TrendTubeScrollView.this.a(episodePhotoView.getTemplateData(), episodePhotoView.getPosition(), view);
            }
        };
    }

    public TrendTubeScrollView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f = new View.OnClickListener() { // from class: com.kwad.sdk.contentalliance.tube.view.TrendTubeScrollView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EpisodePhotoView episodePhotoView = (EpisodePhotoView) view;
                TrendTubeScrollView.this.a(episodePhotoView.getTemplateData(), episodePhotoView.getPosition(), view);
            }
        };
    }

    private void b() {
        this.d = (TrendTubeEpisodeViewPager) findViewById(R.id.ksad_tube_trend_item_viewpager);
        this.d.setPageMargin(ao.a(getContext(), 4.0f));
        this.d.setOffscreenPageLimit(3);
    }

    protected float a(int i, int i2) {
        return 0.29f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.widget.b
    public void a() {
        super.a();
    }

    public void a(TubeProfile tubeProfile) {
        this.f9001a = tubeProfile;
        if (this.f9001a == null) {
            removeAllViews();
            return;
        }
        this.c.clear();
        Iterator<AdTemplate> it = this.f9001a.adTemplateList.iterator();
        int i = 0;
        while (it.hasNext()) {
            this.c.add(it.next());
            int i2 = i + 1;
            if (i2 == 6) {
                break;
            }
            i = i2;
        }
        setVisibility(0);
        this.e = new b();
        this.d.setAdapter(this.e);
        this.d.setOnPageChangeListener(this.e);
    }

    protected void a(AdTemplate adTemplate, int i, View view) {
        if (this.f9002b == null) {
            return;
        }
        this.f9002b.a(adTemplate, i, view);
    }

    protected float getRatio() {
        return 0.38f;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.feed.widget.base.b, android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        float ratio = getRatio();
        if (ratio != 0.0f) {
            int size = View.MeasureSpec.getSize(i);
            com.kwad.sdk.core.d.a.a("TrendTubeScrollView", "ratio = " + ratio + " widthSize=" + size);
            i2 = View.MeasureSpec.makeMeasureSpec((int) (ratio * size), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public void setEpisodeItemClickListener(a aVar) {
        this.f9002b = aVar;
    }
}
