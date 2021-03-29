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
    public int f32847h;
    public final DataSetObserver i;

    public b(@NonNull KsFragmentManager ksFragmentManager) {
        super(ksFragmentManager);
        this.f32847h = 5000;
        this.i = new DataSetObserver() { // from class: com.kwad.sdk.contentalliance.home.viewpager.b.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "onChanged");
                b bVar = b.this;
                ((a) bVar).f32826c = -1;
                ((a) bVar).f32825b = -1;
                bVar.f32828e.a(SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_SCROLL_END);
            }
        };
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int a(int i) {
        return i - this.f32847h;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(SlidePlayViewPager slidePlayViewPager) {
        super.a(slidePlayViewPager);
        slidePlayViewPager.a(this.i);
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(List<AdTemplate> list, @Nullable AdTemplate adTemplate, int i, int i2, boolean z) {
        this.f32827d = i;
        if (list == null || list.isEmpty()) {
            return;
        }
        int i3 = 5000;
        if (adTemplate != null) {
            int a2 = a(this.f32828e.getCurrentItem());
            int indexOf = (this.f32827d != 0 || i2 <= -1) ? list.indexOf(adTemplate) : i2;
            StringBuilder sb = new StringBuilder();
            sb.append("mStartIndex=");
            sb.append(this.f32847h);
            sb.append("--beforeUpdatedIndex=");
            sb.append(a2);
            sb.append("--afterUpdatedIndex");
            sb.append(indexOf);
            sb.append("--feedReplacedIndex=");
            sb.append(i2);
            sb.append("--mSourceType=");
            sb.append(this.f32827d == 0 ? "FEED" : "PROFILE");
            com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", sb.toString());
            if (a2 >= 0 && indexOf >= 0) {
                i3 = this.f32847h + (a2 - indexOf);
            }
        }
        this.f32847h = i3;
        ((a) this).f32824a.clear();
        ((a) this).f32824a.addAll(list);
        if (this.f32827d == 1 && e(a(this.f32828e.getCurrentItem())) == null) {
            this.f32847h = this.f32828e.getCurrentItem();
            com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "correct mStartIndex:" + this.f32847h);
        }
        ((a) this).f32826c = -2;
        if (!z) {
            ((a) this).f32825b = this.f32828e.getCurrentItem();
        }
        com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "replaceFeed notifyDataSetChanged mStartIndex:" + this.f32847h);
        notifyDataSetChanged();
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(boolean z) {
        super.a(z);
        this.f32828e.b(this.i);
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int b() {
        return this.f32847h;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void b(int i) {
        super.b(i);
        this.f32847h += i;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int c() {
        return (b() + a()) - 1;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int c(int i) {
        return i + this.f32847h;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 10000;
    }
}
