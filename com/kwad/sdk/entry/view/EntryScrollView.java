package com.kwad.sdk.entry.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.entry.view.EntryViewPager;
import com.kwad.sdk.utils.ao;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class EntryScrollView extends com.kwad.sdk.entry.view.a {

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f35126c;

    /* renamed from: d  reason: collision with root package name */
    public EntryViewPager f35127d;

    /* renamed from: e  reason: collision with root package name */
    public a f35128e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35129f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f35130g;

    /* loaded from: classes6.dex */
    public class a extends PagerAdapter implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public List<EntryPhotoView> f35134b;

        /* renamed from: c  reason: collision with root package name */
        public List<EntryPhotoView> f35135c;

        public a() {
            this.f35134b = new ArrayList();
            this.f35135c = new ArrayList();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            if (obj instanceof View) {
                viewGroup.removeView((View) obj);
                this.f35134b.add((EntryPhotoView) obj);
                this.f35135c.remove(obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return EntryScrollView.this.f35126c.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i) {
            return EntryScrollView.this.a(getCount(), i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            EntryPhotoView entryPhotoView;
            if (this.f35134b.size() > 0) {
                entryPhotoView = this.f35134b.remove(0);
                entryPhotoView.l();
            } else {
                entryPhotoView = (EntryPhotoView) View.inflate(EntryScrollView.this.getContext(), R.layout.ksad_view_entryphoto, null);
            }
            if (EntryScrollView.this.getItemPlayRes() > 0) {
                entryPhotoView.setPlayBtnRes(EntryScrollView.this.getItemPlayRes());
            }
            entryPhotoView.setAdShowStyle(EntryScrollView.this.getAdShowStyle());
            viewGroup.addView(entryPhotoView);
            entryPhotoView.a(EntryScrollView.this.getEnableWebp(), true);
            entryPhotoView.a(i, ((com.kwad.sdk.entry.view.a) EntryScrollView.this).f35165a.f34453e);
            entryPhotoView.a((AdTemplate) EntryScrollView.this.f35126c.get(i), ((com.kwad.sdk.entry.view.a) EntryScrollView.this).f35165a);
            entryPhotoView.setLikeViewPos(((com.kwad.sdk.entry.view.a) EntryScrollView.this).f35165a.f34452d);
            entryPhotoView.setOnClickListener(EntryScrollView.this.f35130g);
            if (i != getCount() - 1 || EntryScrollView.this.f35129f) {
                entryPhotoView.setLookMoreVisible(false);
            } else {
                entryPhotoView.setLookMoreVisible(true);
            }
            entryPhotoView.setId(i);
            this.f35135c.add(entryPhotoView);
            return entryPhotoView;
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
            EntryPhotoView entryPhotoView = (EntryPhotoView) EntryScrollView.this.f35127d.findViewById(i);
            if (entryPhotoView != null) {
                entryPhotoView.f();
            }
            for (EntryPhotoView entryPhotoView2 : this.f35135c) {
                if (entryPhotoView2 != entryPhotoView) {
                    entryPhotoView2.g();
                }
            }
        }
    }

    public EntryScrollView(@NonNull Context context) {
        super(context);
        this.f35126c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35130g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryPhotoView entryPhotoView = (EntryPhotoView) view;
                EntryScrollView.this.a(entryPhotoView.getTemplateData(), entryPhotoView.getPosition(), view, 1);
            }
        };
    }

    public EntryScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35126c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35130g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryPhotoView entryPhotoView = (EntryPhotoView) view;
                EntryScrollView.this.a(entryPhotoView.getTemplateData(), entryPhotoView.getPosition(), view, 1);
            }
        };
    }

    private void c() {
        EntryViewPager entryViewPager = (EntryViewPager) findViewById(R.id.ksad_entry_viewpager);
        this.f35127d = entryViewPager;
        entryViewPager.setPageMargin(ao.a(getContext(), 7.0f));
        this.f35127d.setOffscreenPageLimit(3);
    }

    public float a(int i, int i2) {
        return 0.4f;
    }

    @Override // com.kwad.sdk.entry.view.a, com.kwad.sdk.widget.b
    public void a() {
        super.a();
    }

    @Override // com.kwad.sdk.entry.view.a
    public boolean b() {
        this.f35126c.clear();
        for (AdTemplate adTemplate : ((com.kwad.sdk.entry.view.a) this).f35165a.k) {
            if (!adTemplate.needHide) {
                this.f35126c.add(adTemplate);
            }
        }
        if (this.f35126c.size() < 3) {
            setVisibility(8);
            return false;
        }
        setVisibility(0);
        this.f35128e = new a();
        int k = com.kwad.sdk.core.config.c.k();
        boolean z = this.f35126c.size() >= k && k > 0;
        this.f35129f = z;
        if (z) {
            this.f35127d.setDragSideEnable(true);
            this.f35127d.setOnDragOpenListener(new EntryViewPager.c() { // from class: com.kwad.sdk.entry.view.EntryScrollView.1
                @Override // com.kwad.sdk.entry.view.EntryViewPager.c
                public void a() {
                    int size = EntryScrollView.this.f35126c.size() - 1;
                    View findViewById = EntryScrollView.this.f35127d.findViewById(size);
                    EntryScrollView entryScrollView = EntryScrollView.this;
                    entryScrollView.a((AdTemplate) entryScrollView.f35126c.get(size), size, findViewById, 4);
                }
            });
        } else {
            this.f35127d.setDragSideEnable(false);
        }
        this.f35127d.setAdapter(this.f35128e);
        this.f35127d.setOnPageChangeListener(this.f35128e);
        return true;
    }

    public int getAdShowStyle() {
        return 1;
    }

    public boolean getEnableWebp() {
        return true;
    }

    public int getItemPlayRes() {
        return 0;
    }

    public float getRatio() {
        return 0.68f;
    }

    @Override // com.kwad.sdk.entry.view.a
    public List<AdTemplate> getRealShowData() {
        return this.f35126c;
    }

    @Override // com.kwad.sdk.entry.view.a
    public int getSourceRightMargin() {
        return ao.a(getContext(), 16.0f);
    }

    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    @Override // com.kwad.sdk.feed.widget.base.b, android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        float ratio = getRatio();
        if (ratio != 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * ratio), 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
