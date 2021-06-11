package com.kwad.sdk.contentalliance.home.viewpager;

import android.database.DataSetObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.contentalliance.home.viewpager.SlidePlayTouchViewPager;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
/* loaded from: classes6.dex */
public class b extends a {

    /* renamed from: h  reason: collision with root package name */
    public int f33443h;

    /* renamed from: i  reason: collision with root package name */
    public final DataSetObserver f33444i;

    public b(@NonNull KsFragmentManager ksFragmentManager) {
        super(ksFragmentManager);
        this.f33443h = 5000;
        this.f33444i = new DataSetObserver() { // from class: com.kwad.sdk.contentalliance.home.viewpager.b.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "onChanged");
                b bVar = b.this;
                ((a) bVar).f33420c = -1;
                ((a) bVar).f33419b = -1;
                bVar.f33422e.a(SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_SCROLL_END);
            }
        };
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int a(int i2) {
        return i2 - this.f33443h;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(SlidePlayViewPager slidePlayViewPager) {
        super.a(slidePlayViewPager);
        slidePlayViewPager.a(this.f33444i);
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(List<AdTemplate> list, @Nullable AdTemplate adTemplate, int i2, int i3, boolean z) {
        this.f33421d = i2;
        if (list == null || list.isEmpty()) {
            return;
        }
        int i4 = 5000;
        if (adTemplate != null) {
            int a2 = a(this.f33422e.getCurrentItem());
            int indexOf = (this.f33421d != 0 || i3 <= -1) ? list.indexOf(adTemplate) : i3;
            StringBuilder sb = new StringBuilder();
            sb.append("mStartIndex=");
            sb.append(this.f33443h);
            sb.append("--beforeUpdatedIndex=");
            sb.append(a2);
            sb.append("--afterUpdatedIndex");
            sb.append(indexOf);
            sb.append("--feedReplacedIndex=");
            sb.append(i3);
            sb.append("--mSourceType=");
            sb.append(this.f33421d == 0 ? "FEED" : "PROFILE");
            com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", sb.toString());
            if (a2 >= 0 && indexOf >= 0) {
                i4 = this.f33443h + (a2 - indexOf);
            }
        }
        this.f33443h = i4;
        ((a) this).f33418a.clear();
        ((a) this).f33418a.addAll(list);
        if (this.f33421d == 1 && e(a(this.f33422e.getCurrentItem())) == null) {
            this.f33443h = this.f33422e.getCurrentItem();
            com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "correct mStartIndex:" + this.f33443h);
        }
        ((a) this).f33420c = -2;
        if (!z) {
            ((a) this).f33419b = this.f33422e.getCurrentItem();
        }
        com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "replaceFeed notifyDataSetChanged mStartIndex:" + this.f33443h);
        notifyDataSetChanged();
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(boolean z) {
        super.a(z);
        this.f33422e.b(this.f33444i);
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int b() {
        return this.f33443h;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void b(int i2) {
        super.b(i2);
        this.f33443h += i2;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int c() {
        return (b() + a()) - 1;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int c(int i2) {
        return i2 + this.f33443h;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 10000;
    }
}
