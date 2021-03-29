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
    public com.kwad.sdk.lib.widget.b<AdTemplate> f34742c;

    /* renamed from: d  reason: collision with root package name */
    public EntryViewPager f34743d;

    /* renamed from: e  reason: collision with root package name */
    public a f34744e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f34745f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f34746g;

    /* loaded from: classes6.dex */
    public class a extends PagerAdapter implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public List<EntryPhotoView> f34750b;

        /* renamed from: c  reason: collision with root package name */
        public List<EntryPhotoView> f34751c;

        public a() {
            this.f34750b = new ArrayList();
            this.f34751c = new ArrayList();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            if (obj instanceof View) {
                viewGroup.removeView((View) obj);
                this.f34750b.add((EntryPhotoView) obj);
                this.f34751c.remove(obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return EntryScrollView.this.f34742c.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i) {
            return EntryScrollView.this.a(getCount(), i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            EntryPhotoView entryPhotoView;
            if (this.f34750b.size() > 0) {
                entryPhotoView = this.f34750b.remove(0);
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
            entryPhotoView.a(i, ((com.kwad.sdk.entry.view.a) EntryScrollView.this).f34781a.f34069e);
            entryPhotoView.a((AdTemplate) EntryScrollView.this.f34742c.get(i), ((com.kwad.sdk.entry.view.a) EntryScrollView.this).f34781a);
            entryPhotoView.setLikeViewPos(((com.kwad.sdk.entry.view.a) EntryScrollView.this).f34781a.f34068d);
            entryPhotoView.setOnClickListener(EntryScrollView.this.f34746g);
            if (i != getCount() - 1 || EntryScrollView.this.f34745f) {
                entryPhotoView.setLookMoreVisible(false);
            } else {
                entryPhotoView.setLookMoreVisible(true);
            }
            entryPhotoView.setId(i);
            this.f34751c.add(entryPhotoView);
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
            EntryPhotoView entryPhotoView = (EntryPhotoView) EntryScrollView.this.f34743d.findViewById(i);
            if (entryPhotoView != null) {
                entryPhotoView.f();
            }
            for (EntryPhotoView entryPhotoView2 : this.f34751c) {
                if (entryPhotoView2 != entryPhotoView) {
                    entryPhotoView2.g();
                }
            }
        }
    }

    public EntryScrollView(@NonNull Context context) {
        super(context);
        this.f34742c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f34746g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryPhotoView entryPhotoView = (EntryPhotoView) view;
                EntryScrollView.this.a(entryPhotoView.getTemplateData(), entryPhotoView.getPosition(), view, 1);
            }
        };
    }

    public EntryScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34742c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f34746g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryPhotoView entryPhotoView = (EntryPhotoView) view;
                EntryScrollView.this.a(entryPhotoView.getTemplateData(), entryPhotoView.getPosition(), view, 1);
            }
        };
    }

    private void c() {
        EntryViewPager entryViewPager = (EntryViewPager) findViewById(R.id.ksad_entry_viewpager);
        this.f34743d = entryViewPager;
        entryViewPager.setPageMargin(ao.a(getContext(), 7.0f));
        this.f34743d.setOffscreenPageLimit(3);
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
        this.f34742c.clear();
        for (AdTemplate adTemplate : ((com.kwad.sdk.entry.view.a) this).f34781a.k) {
            if (!adTemplate.needHide) {
                this.f34742c.add(adTemplate);
            }
        }
        if (this.f34742c.size() < 3) {
            setVisibility(8);
            return false;
        }
        setVisibility(0);
        this.f34744e = new a();
        int k = com.kwad.sdk.core.config.c.k();
        boolean z = this.f34742c.size() >= k && k > 0;
        this.f34745f = z;
        if (z) {
            this.f34743d.setDragSideEnable(true);
            this.f34743d.setOnDragOpenListener(new EntryViewPager.c() { // from class: com.kwad.sdk.entry.view.EntryScrollView.1
                @Override // com.kwad.sdk.entry.view.EntryViewPager.c
                public void a() {
                    int size = EntryScrollView.this.f34742c.size() - 1;
                    View findViewById = EntryScrollView.this.f34743d.findViewById(size);
                    EntryScrollView entryScrollView = EntryScrollView.this;
                    entryScrollView.a((AdTemplate) entryScrollView.f34742c.get(size), size, findViewById, 4);
                }
            });
        } else {
            this.f34743d.setDragSideEnable(false);
        }
        this.f34743d.setAdapter(this.f34744e);
        this.f34743d.setOnPageChangeListener(this.f34744e);
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
        return this.f34742c;
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
