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
/* loaded from: classes7.dex */
public class EntryScrollView extends com.kwad.sdk.entry.view.a {

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f35400c;

    /* renamed from: d  reason: collision with root package name */
    public EntryViewPager f35401d;

    /* renamed from: e  reason: collision with root package name */
    public a f35402e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f35403f;

    /* renamed from: g  reason: collision with root package name */
    public View.OnClickListener f35404g;

    /* loaded from: classes7.dex */
    public class a extends PagerAdapter implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public List<EntryPhotoView> f35408b;

        /* renamed from: c  reason: collision with root package name */
        public List<EntryPhotoView> f35409c;

        public a() {
            this.f35408b = new ArrayList();
            this.f35409c = new ArrayList();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
            if (obj instanceof View) {
                viewGroup.removeView((View) obj);
                this.f35408b.add((EntryPhotoView) obj);
                this.f35409c.remove(obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return EntryScrollView.this.f35400c.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i2) {
            return EntryScrollView.this.a(getCount(), i2);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
            EntryPhotoView entryPhotoView;
            if (this.f35408b.size() > 0) {
                entryPhotoView = this.f35408b.remove(0);
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
            entryPhotoView.a(i2, ((com.kwad.sdk.entry.view.a) EntryScrollView.this).f35441a.f34705e);
            entryPhotoView.a((AdTemplate) EntryScrollView.this.f35400c.get(i2), ((com.kwad.sdk.entry.view.a) EntryScrollView.this).f35441a);
            entryPhotoView.setLikeViewPos(((com.kwad.sdk.entry.view.a) EntryScrollView.this).f35441a.f34704d);
            entryPhotoView.setOnClickListener(EntryScrollView.this.f35404g);
            if (i2 != getCount() - 1 || EntryScrollView.this.f35403f) {
                entryPhotoView.setLookMoreVisible(false);
            } else {
                entryPhotoView.setLookMoreVisible(true);
            }
            entryPhotoView.setId(i2);
            this.f35409c.add(entryPhotoView);
            return entryPhotoView;
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
            EntryPhotoView entryPhotoView = (EntryPhotoView) EntryScrollView.this.f35401d.findViewById(i2);
            if (entryPhotoView != null) {
                entryPhotoView.f();
            }
            for (EntryPhotoView entryPhotoView2 : this.f35409c) {
                if (entryPhotoView2 != entryPhotoView) {
                    entryPhotoView2.g();
                }
            }
        }
    }

    public EntryScrollView(@NonNull Context context) {
        super(context);
        this.f35400c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35404g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryPhotoView entryPhotoView = (EntryPhotoView) view;
                EntryScrollView.this.a(entryPhotoView.getTemplateData(), entryPhotoView.getPosition(), view, 1);
            }
        };
    }

    public EntryScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35400c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35404g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryPhotoView entryPhotoView = (EntryPhotoView) view;
                EntryScrollView.this.a(entryPhotoView.getTemplateData(), entryPhotoView.getPosition(), view, 1);
            }
        };
    }

    private void c() {
        EntryViewPager entryViewPager = (EntryViewPager) findViewById(R.id.ksad_entry_viewpager);
        this.f35401d = entryViewPager;
        entryViewPager.setPageMargin(ao.a(getContext(), 7.0f));
        this.f35401d.setOffscreenPageLimit(3);
    }

    public float a(int i2, int i3) {
        return 0.4f;
    }

    @Override // com.kwad.sdk.entry.view.a, com.kwad.sdk.widget.b
    public void a() {
        super.a();
    }

    @Override // com.kwad.sdk.entry.view.a
    public boolean b() {
        this.f35400c.clear();
        for (AdTemplate adTemplate : ((com.kwad.sdk.entry.view.a) this).f35441a.k) {
            if (!adTemplate.needHide) {
                this.f35400c.add(adTemplate);
            }
        }
        if (this.f35400c.size() < 3) {
            setVisibility(8);
            return false;
        }
        setVisibility(0);
        this.f35402e = new a();
        int k = com.kwad.sdk.core.config.c.k();
        boolean z = this.f35400c.size() >= k && k > 0;
        this.f35403f = z;
        if (z) {
            this.f35401d.setDragSideEnable(true);
            this.f35401d.setOnDragOpenListener(new EntryViewPager.c() { // from class: com.kwad.sdk.entry.view.EntryScrollView.1
                @Override // com.kwad.sdk.entry.view.EntryViewPager.c
                public void a() {
                    int size = EntryScrollView.this.f35400c.size() - 1;
                    View findViewById = EntryScrollView.this.f35401d.findViewById(size);
                    EntryScrollView entryScrollView = EntryScrollView.this;
                    entryScrollView.a((AdTemplate) entryScrollView.f35400c.get(size), size, findViewById, 4);
                }
            });
        } else {
            this.f35401d.setDragSideEnable(false);
        }
        this.f35401d.setAdapter(this.f35402e);
        this.f35401d.setOnPageChangeListener(this.f35402e);
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
        return this.f35400c;
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
    public void onMeasure(int i2, int i3) {
        float ratio = getRatio();
        if (ratio != 0.0f) {
            i3 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i2) * ratio), 1073741824);
        }
        super.onMeasure(i2, i3);
    }
}
