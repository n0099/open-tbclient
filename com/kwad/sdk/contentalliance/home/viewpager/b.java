package com.kwad.sdk.contentalliance.home.viewpager;

import android.database.DataSetObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends a {
    private int h;
    private final DataSetObserver i;

    public b(@NonNull KsFragmentManager ksFragmentManager) {
        super(ksFragmentManager);
        this.h = 5000;
        this.i = new DataSetObserver() { // from class: com.kwad.sdk.contentalliance.home.viewpager.b.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "onChanged");
                b.this.c = -1;
                b.this.f8757b = -1;
                b.this.e.a(SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_SCROLL_END);
            }
        };
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int a(int i) {
        return i - this.h;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(SlidePlayViewPager slidePlayViewPager) {
        super.a(slidePlayViewPager);
        slidePlayViewPager.a(this.i);
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(List<AdTemplate> list, @Nullable AdTemplate adTemplate, int i, int i2, boolean z) {
        this.d = i;
        if (list == null || list.isEmpty()) {
            return;
        }
        if (adTemplate == null) {
            this.h = 5000;
        } else {
            int a2 = a(this.e.getCurrentItem());
            int indexOf = (this.d != 0 || i2 <= -1) ? list.indexOf(adTemplate) : i2;
            com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "mStartIndex=" + this.h + "--beforeUpdatedIndex=" + a2 + "--afterUpdatedIndex" + indexOf + "--feedReplacedIndex=" + i2 + "--mSourceType=" + (this.d == 0 ? "FEED" : "PROFILE"));
            if (a2 < 0 || indexOf < 0) {
                this.h = 5000;
            } else {
                this.h = (a2 - indexOf) + this.h;
            }
        }
        this.f8756a.clear();
        this.f8756a.addAll(list);
        if (this.d == 1 && e(a(this.e.getCurrentItem())) == null) {
            this.h = this.e.getCurrentItem();
            com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "correct mStartIndex:" + this.h);
        }
        this.c = -2;
        if (!z) {
            this.f8757b = this.e.getCurrentItem();
        }
        com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "replaceFeed notifyDataSetChanged mStartIndex:" + this.h);
        notifyDataSetChanged();
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(boolean z) {
        super.a(z);
        this.e.b(this.i);
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int b() {
        return this.h;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void b(int i) {
        super.b(i);
        this.h += i;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int c() {
        return (b() + a()) - 1;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int c(int i) {
        return this.h + i;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 10000;
    }
}
