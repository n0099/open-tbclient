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
/* loaded from: classes5.dex */
public class EntryScrollView extends com.kwad.sdk.entry.view.a {
    private com.kwad.sdk.lib.widget.b<AdTemplate> c;
    private EntryViewPager d;
    private a e;
    private boolean f;
    private View.OnClickListener g;

    /* loaded from: classes5.dex */
    private class a extends PagerAdapter implements ViewPager.OnPageChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private List<EntryPhotoView> f10089b;
        private List<EntryPhotoView> c;

        private a() {
            this.f10089b = new ArrayList();
            this.c = new ArrayList();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            if (obj instanceof View) {
                viewGroup.removeView((View) obj);
                this.f10089b.add((EntryPhotoView) obj);
                this.c.remove(obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return EntryScrollView.this.c.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public float getPageWidth(int i) {
            return EntryScrollView.this.a(getCount(), i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            EntryPhotoView entryPhotoView;
            if (this.f10089b.size() > 0) {
                EntryPhotoView remove = this.f10089b.remove(0);
                remove.l();
                entryPhotoView = remove;
            } else {
                entryPhotoView = (EntryPhotoView) View.inflate(EntryScrollView.this.getContext(), R.layout.ksad_view_entryphoto, null);
            }
            if (EntryScrollView.this.getItemPlayRes() > 0) {
                entryPhotoView.setPlayBtnRes(EntryScrollView.this.getItemPlayRes());
            }
            entryPhotoView.setAdShowStyle(EntryScrollView.this.getAdShowStyle());
            viewGroup.addView(entryPhotoView);
            entryPhotoView.a(EntryScrollView.this.getEnableWebp(), true);
            entryPhotoView.a(i, EntryScrollView.this.f10101a.e);
            entryPhotoView.a((AdTemplate) EntryScrollView.this.c.get(i), EntryScrollView.this.f10101a);
            entryPhotoView.setLikeViewPos(EntryScrollView.this.f10101a.d);
            entryPhotoView.setOnClickListener(EntryScrollView.this.g);
            if (i != getCount() - 1 || EntryScrollView.this.f) {
                entryPhotoView.setLookMoreVisible(false);
            } else {
                entryPhotoView.setLookMoreVisible(true);
            }
            entryPhotoView.setId(i);
            this.c.add(entryPhotoView);
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
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            EntryPhotoView entryPhotoView = (EntryPhotoView) EntryScrollView.this.d.findViewById(i);
            if (entryPhotoView != null) {
                entryPhotoView.f();
            }
            for (EntryPhotoView entryPhotoView2 : this.c) {
                if (entryPhotoView2 != entryPhotoView) {
                    entryPhotoView2.g();
                }
            }
        }
    }

    public EntryScrollView(@NonNull Context context) {
        super(context);
        this.c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryPhotoView entryPhotoView = (EntryPhotoView) view;
                EntryScrollView.this.a(entryPhotoView.getTemplateData(), entryPhotoView.getPosition(), view, 1);
            }
        };
    }

    public EntryScrollView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.g = new View.OnClickListener() { // from class: com.kwad.sdk.entry.view.EntryScrollView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EntryPhotoView entryPhotoView = (EntryPhotoView) view;
                EntryScrollView.this.a(entryPhotoView.getTemplateData(), entryPhotoView.getPosition(), view, 1);
            }
        };
    }

    private void c() {
        this.d = (EntryViewPager) findViewById(R.id.ksad_entry_viewpager);
        this.d.setPageMargin(ao.a(getContext(), 7.0f));
        this.d.setOffscreenPageLimit(3);
    }

    protected float a(int i, int i2) {
        return 0.4f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.entry.view.a, com.kwad.sdk.widget.b
    public void a() {
        super.a();
    }

    @Override // com.kwad.sdk.entry.view.a
    protected boolean b() {
        this.c.clear();
        for (AdTemplate adTemplate : this.f10101a.k) {
            if (!adTemplate.needHide) {
                this.c.add(adTemplate);
            }
        }
        if (this.c.size() < 3) {
            setVisibility(8);
            return false;
        }
        setVisibility(0);
        this.e = new a();
        int k = com.kwad.sdk.core.config.c.k();
        this.f = this.c.size() >= k && k > 0;
        if (this.f) {
            this.d.setDragSideEnable(true);
            this.d.setOnDragOpenListener(new EntryViewPager.c() { // from class: com.kwad.sdk.entry.view.EntryScrollView.1
                @Override // com.kwad.sdk.entry.view.EntryViewPager.c
                public void a() {
                    int size = EntryScrollView.this.c.size() - 1;
                    EntryScrollView.this.a((AdTemplate) EntryScrollView.this.c.get(size), size, EntryScrollView.this.d.findViewById(size), 4);
                }
            });
        } else {
            this.d.setDragSideEnable(false);
        }
        this.d.setAdapter(this.e);
        this.d.setOnPageChangeListener(this.e);
        return true;
    }

    protected int getAdShowStyle() {
        return 1;
    }

    protected boolean getEnableWebp() {
        return true;
    }

    protected int getItemPlayRes() {
        return 0;
    }

    protected float getRatio() {
        return 0.68f;
    }

    @Override // com.kwad.sdk.entry.view.a
    protected List<AdTemplate> getRealShowData() {
        return this.c;
    }

    @Override // com.kwad.sdk.entry.view.a
    public int getSourceRightMargin() {
        return ao.a(getContext(), 16.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.entry.view.a, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.feed.widget.base.b, android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        float ratio = getRatio();
        if (ratio != 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (ratio * View.MeasureSpec.getSize(i)), 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
