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
    public int f33541h;

    /* renamed from: i  reason: collision with root package name */
    public final DataSetObserver f33542i;

    public b(@NonNull KsFragmentManager ksFragmentManager) {
        super(ksFragmentManager);
        this.f33541h = 5000;
        this.f33542i = new DataSetObserver() { // from class: com.kwad.sdk.contentalliance.home.viewpager.b.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "onChanged");
                b bVar = b.this;
                ((a) bVar).f33518c = -1;
                ((a) bVar).f33517b = -1;
                bVar.f33520e.a(SlidePlayTouchViewPager.TargetBoundUpdatedType.ON_SCROLL_END);
            }
        };
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int a(int i2) {
        return i2 - this.f33541h;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(SlidePlayViewPager slidePlayViewPager) {
        super.a(slidePlayViewPager);
        slidePlayViewPager.a(this.f33542i);
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(List<AdTemplate> list, @Nullable AdTemplate adTemplate, int i2, int i3, boolean z) {
        this.f33519d = i2;
        if (list == null || list.isEmpty()) {
            return;
        }
        int i4 = 5000;
        if (adTemplate != null) {
            int a2 = a(this.f33520e.getCurrentItem());
            int indexOf = (this.f33519d != 0 || i3 <= -1) ? list.indexOf(adTemplate) : i3;
            StringBuilder sb = new StringBuilder();
            sb.append("mStartIndex=");
            sb.append(this.f33541h);
            sb.append("--beforeUpdatedIndex=");
            sb.append(a2);
            sb.append("--afterUpdatedIndex");
            sb.append(indexOf);
            sb.append("--feedReplacedIndex=");
            sb.append(i3);
            sb.append("--mSourceType=");
            sb.append(this.f33519d == 0 ? "FEED" : "PROFILE");
            com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", sb.toString());
            if (a2 >= 0 && indexOf >= 0) {
                i4 = this.f33541h + (a2 - indexOf);
            }
        }
        this.f33541h = i4;
        ((a) this).f33516a.clear();
        ((a) this).f33516a.addAll(list);
        if (this.f33519d == 1 && e(a(this.f33520e.getCurrentItem())) == null) {
            this.f33541h = this.f33520e.getCurrentItem();
            com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "correct mStartIndex:" + this.f33541h);
        }
        ((a) this).f33518c = -2;
        if (!z) {
            ((a) this).f33517b = this.f33520e.getCurrentItem();
        }
        com.kwad.sdk.core.d.a.a("SlidePlaySmoothUpdatePagerAdapter", "replaceFeed notifyDataSetChanged mStartIndex:" + this.f33541h);
        notifyDataSetChanged();
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void a(boolean z) {
        super.a(z);
        this.f33520e.b(this.f33542i);
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int b() {
        return this.f33541h;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public void b(int i2) {
        super.b(i2);
        this.f33541h += i2;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int c() {
        return (b() + a()) - 1;
    }

    @Override // com.kwad.sdk.contentalliance.home.viewpager.a
    public int c(int i2) {
        return i2 + this.f33541h;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 10000;
    }
}
