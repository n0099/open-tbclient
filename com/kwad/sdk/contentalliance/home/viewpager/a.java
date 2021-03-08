package com.kwad.sdk.contentalliance.home.viewpager;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.contentalliance.b.b;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.plugin.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class a extends com.kwad.sdk.contentalliance.b.a {

    /* renamed from: a  reason: collision with root package name */
    protected com.kwad.sdk.lib.widget.b<AdTemplate> f5833a;
    protected int b;
    protected int c;
    protected int d;
    protected SlidePlayViewPager e;
    private final SparseArray<KsFragment> h;
    private boolean i;
    private List<AdTemplate> j;
    private com.kwad.sdk.contentalliance.detail.b.b k;
    private h l;

    public a(@NonNull KsFragmentManager ksFragmentManager) {
        super(ksFragmentManager);
        this.h = new SparseArray<>();
        this.f5833a = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.b = -1;
        this.c = -1;
        this.d = 0;
    }

    private void b(int i, boolean z) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "notifyDetachedItems position=" + i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.h.size()) {
                return;
            }
            int keyAt = this.h.keyAt(i3);
            KsFragment valueAt = this.h.valueAt(i3);
            if (keyAt != i && (valueAt instanceof com.kwad.sdk.contentalliance.detail.a)) {
                com.kwad.sdk.contentalliance.detail.a aVar = (com.kwad.sdk.contentalliance.detail.a) valueAt;
                if (aVar.n()) {
                    if (z) {
                        aVar.h();
                    } else {
                        aVar.f();
                    }
                }
            }
            i2 = i3 + 1;
        }
    }

    private void b(boolean z) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.h.size()) {
                return;
            }
            KsFragment valueAt = this.h.valueAt(i2);
            if (valueAt instanceof com.kwad.sdk.contentalliance.detail.a) {
                com.kwad.sdk.contentalliance.detail.a aVar = (com.kwad.sdk.contentalliance.detail.a) valueAt;
                aVar.f();
                aVar.h();
                if (z) {
                    aVar.a();
                }
            }
            i = i2 + 1;
        }
    }

    private void c(int i, boolean z) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "notifyAttachedItem position=" + i);
        KsFragment ksFragment = this.h.get(i);
        if (ksFragment instanceof com.kwad.sdk.contentalliance.detail.a) {
            com.kwad.sdk.contentalliance.detail.a aVar = (com.kwad.sdk.contentalliance.detail.a) ksFragment;
            if (aVar.n()) {
                if (z) {
                    aVar.g();
                } else {
                    aVar.e();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean g(int i) {
        boolean z;
        boolean z2 = false;
        int a2 = a(i);
        if (a2 < 0) {
            return false;
        }
        if (a2 < this.f5833a.size() - 1) {
            AdTemplate adTemplate = this.f5833a.get(a2 + 1);
            if (d(i + 1) == -2) {
                this.f5833a.remove(adTemplate);
                if (this.j != null) {
                    this.j.remove(adTemplate);
                }
                if (com.kwad.sdk.core.d.a.f6021a) {
                    com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "无效作品移除 template:" + adTemplate.toJson());
                }
                z2 = true;
            }
        }
        if (a2 > 0 && a2 < this.f5833a.size()) {
            AdTemplate adTemplate2 = this.f5833a.get(a2 - 1);
            if (d(i - 1) == -2) {
                this.f5833a.remove(adTemplate2);
                if (this.j != null) {
                    this.j.remove(adTemplate2);
                }
                b(1);
                if (com.kwad.sdk.core.d.a.f6021a) {
                    com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "无效作品移除 template:" + adTemplate2.toJson());
                }
                z = true;
                if (z) {
                    return z;
                }
                notifyDataSetChanged();
                return z;
            }
        }
        z = z2;
        if (z) {
        }
    }

    public int a() {
        return this.f5833a.size();
    }

    public abstract int a(int i);

    @Override // com.kwad.sdk.contentalliance.b.a
    protected int a(KsFragment ksFragment) {
        com.kwad.sdk.plugin.d dVar = (com.kwad.sdk.plugin.d) g.a(com.kwad.sdk.plugin.d.class);
        if (ksFragment instanceof com.kwad.sdk.contentalliance.detail.ad.a) {
            return 0;
        }
        if (ksFragment instanceof com.kwad.sdk.contentalliance.detail.photo.a) {
            return 100;
        }
        return (dVar == null || !dVar.a(ksFragment)) ? -1 : 200;
    }

    @Override // com.kwad.sdk.contentalliance.b.a
    protected KsFragment a(int i, int i2) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "onCreateItem position=" + i);
        return i2 >= 1000 ? new com.kwad.sdk.contentalliance.detail.b.a() : i2 == 0 ? new com.kwad.sdk.contentalliance.detail.ad.a() : i2 == 100 ? new com.kwad.sdk.contentalliance.detail.photo.a() : i2 == 200 ? ((com.kwad.sdk.plugin.d) g.a(com.kwad.sdk.plugin.d.class)).a() : new KsFragment();
    }

    public void a(int i, boolean z) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "onSelectChanged position=" + i);
        if (this.i) {
            return;
        }
        b(i, z);
        c(i, z);
        g(i);
    }

    @Override // com.kwad.sdk.contentalliance.b.a
    protected void a(KsFragment ksFragment, int i, int i2) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "onBindItem position=" + i + " viewType=" + i2);
        int a2 = a(i);
        AdTemplate e = e(a2);
        if (e == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_INDEX_IN_VIEW_PAGER", a2);
        bundle.putSerializable("key_template", e);
        if (ksFragment.getArguments() != null) {
            ksFragment.getArguments().clear();
            ksFragment.getArguments().putAll(bundle);
        } else {
            ksFragment.setArguments(bundle);
        }
        if (ksFragment instanceof com.kwad.sdk.contentalliance.detail.b.a) {
            ((com.kwad.sdk.contentalliance.detail.b.a) ksFragment).a(this.k);
        }
        if (ksFragment instanceof com.kwad.sdk.contentalliance.detail.a) {
            ((com.kwad.sdk.contentalliance.detail.a) ksFragment).a(this.l);
        }
    }

    public void a(com.kwad.sdk.contentalliance.detail.b.b bVar) {
        this.k = bVar;
    }

    public void a(h hVar) {
        this.l = hVar;
    }

    public void a(SlidePlayViewPager slidePlayViewPager) {
        this.e = slidePlayViewPager;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.j = list;
        this.f5833a.clear();
        this.f5833a.addAll(list);
        if (g(this.e.getCurrentItem())) {
            return;
        }
        notifyDataSetChanged();
    }

    public void a(List<AdTemplate> list, @Nullable AdTemplate adTemplate, int i, int i2, boolean z) {
    }

    public void a(boolean z) {
        this.l.b();
        b(z);
        this.i = true;
        this.h.clear();
    }

    public abstract int b();

    public void b(int i) {
    }

    @Override // com.kwad.sdk.contentalliance.b.a
    protected boolean b(KsFragment ksFragment) {
        return ksFragment instanceof com.kwad.sdk.contentalliance.detail.a;
    }

    public abstract int c();

    public abstract int c(int i);

    @Override // com.kwad.sdk.contentalliance.b.a
    protected int d(int i) {
        int i2 = 0;
        int a2 = a(i);
        AdTemplate e = e(a2);
        if (e != null) {
            switch (e.contentType) {
                case 1:
                    i2 = 100;
                    break;
                case 2:
                    break;
                case 3:
                    int a3 = this.k != null ? this.k.a(e, a2) : 0;
                    if (a3 != 3) {
                        if (a3 != 2) {
                            i2 = -2;
                            break;
                        }
                    } else {
                        i2 = this.k.a(e).getItemViewType() + 1000;
                        break;
                    }
                    break;
                case 4:
                    i2 = 200;
                    break;
                default:
                    i2 = -1;
                    break;
            }
        } else {
            i2 = -1;
        }
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "getItemViewType position=" + i + "--realPosition=" + a2 + "--itemType=" + i2 + "--size=" + this.f5833a.size());
        return i2;
    }

    public List<AdTemplate> d() {
        return this.f5833a;
    }

    @Override // com.kwad.sdk.contentalliance.b.a, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.h.remove(i);
    }

    public AdTemplate e(int i) {
        if (i < 0 || this.f5833a.size() <= i) {
            return null;
        }
        return this.f5833a.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        if (obj instanceof b.C1093b) {
            b.C1093b c1093b = (b.C1093b) obj;
            if (this.b > -1 && this.b == c1093b.b) {
                this.b = -1;
                com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "getItemPosition11 position:" + c1093b.b + "--POSITION_UNCHANGED");
                return -1;
            } else if (!(c1093b.f5505a instanceof com.kwad.sdk.contentalliance.detail.a) && d(c1093b.b) != -1) {
                com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "getItemPosition22 position:" + c1093b.b + "--POSITION_NONE");
                return -2;
            } else {
                com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "getItemPosition33 position:" + c1093b.b + "--mItemPosition=" + (this.c == -1 ? "POSITION_UNCHANGED" : "POSITION_NONE"));
            }
        } else {
            com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "getItemPosition 1111111 object:" + obj);
        }
        return this.c;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public CharSequence getPageTitle(int i) {
        int a2 = a(i);
        if (a2 >= 0 && a2 < this.f5833a.size()) {
            AdTemplate adTemplate = this.f5833a.get(a2);
            if (!TextUtils.isEmpty(adTemplate.mCurrentTrendTitle)) {
                return adTemplate.mCurrentTrendTitle;
            }
        }
        return "";
    }

    @Override // com.kwad.sdk.contentalliance.b.a, androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "instantiateItem position=" + i);
        KsFragment ksFragment = (KsFragment) super.instantiateItem(viewGroup, i);
        this.h.put(i, ksFragment);
        return ksFragment;
    }
}
