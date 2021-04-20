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
/* loaded from: classes6.dex */
public abstract class a extends com.kwad.sdk.contentalliance.b.a {

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f33113a;

    /* renamed from: b  reason: collision with root package name */
    public int f33114b;

    /* renamed from: c  reason: collision with root package name */
    public int f33115c;

    /* renamed from: d  reason: collision with root package name */
    public int f33116d;

    /* renamed from: e  reason: collision with root package name */
    public SlidePlayViewPager f33117e;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<KsFragment> f33118h;
    public boolean i;
    public List<AdTemplate> j;
    public com.kwad.sdk.contentalliance.detail.b.b k;
    public h l;

    public a(@NonNull KsFragmentManager ksFragmentManager) {
        super(ksFragmentManager);
        this.f33118h = new SparseArray<>();
        this.f33113a = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f33114b = -1;
        this.f33115c = -1;
        this.f33116d = 0;
    }

    private void b(int i, boolean z) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "notifyDetachedItems position=" + i);
        for (int i2 = 0; i2 < this.f33118h.size(); i2++) {
            int keyAt = this.f33118h.keyAt(i2);
            KsFragment valueAt = this.f33118h.valueAt(i2);
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
        }
    }

    private void b(boolean z) {
        for (int i = 0; i < this.f33118h.size(); i++) {
            KsFragment valueAt = this.f33118h.valueAt(i);
            if (valueAt instanceof com.kwad.sdk.contentalliance.detail.a) {
                com.kwad.sdk.contentalliance.detail.a aVar = (com.kwad.sdk.contentalliance.detail.a) valueAt;
                aVar.f();
                aVar.h();
                if (z) {
                    aVar.a();
                }
            }
        }
    }

    private void c(int i, boolean z) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "notifyAttachedItem position=" + i);
        KsFragment ksFragment = this.f33118h.get(i);
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

    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean g(int i) {
        int a2 = a(i);
        boolean z = false;
        if (a2 < 0) {
            return false;
        }
        boolean z2 = true;
        if (a2 < this.f33113a.size() - 1) {
            AdTemplate adTemplate = this.f33113a.get(a2 + 1);
            if (d(i + 1) == -2) {
                this.f33113a.remove(adTemplate);
                List<AdTemplate> list = this.j;
                if (list != null) {
                    list.remove(adTemplate);
                }
                if (com.kwad.sdk.core.d.a.f33747a) {
                    com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "无效作品移除 template:" + adTemplate.toJson());
                }
                z = true;
            }
        }
        if (a2 > 0 && a2 < this.f33113a.size()) {
            AdTemplate adTemplate2 = this.f33113a.get(a2 - 1);
            if (d(i - 1) == -2) {
                this.f33113a.remove(adTemplate2);
                List<AdTemplate> list2 = this.j;
                if (list2 != null) {
                    list2.remove(adTemplate2);
                }
                b(1);
                if (com.kwad.sdk.core.d.a.f33747a) {
                    com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "无效作品移除 template:" + adTemplate2.toJson());
                }
                if (z2) {
                    notifyDataSetChanged();
                }
                return z2;
            }
        }
        z2 = z;
        if (z2) {
        }
        return z2;
    }

    public int a() {
        return this.f33113a.size();
    }

    public abstract int a(int i);

    @Override // com.kwad.sdk.contentalliance.b.a
    public int a(KsFragment ksFragment) {
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
    public KsFragment a(int i, int i2) {
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
    public void a(KsFragment ksFragment, int i, int i2) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "onBindItem position=" + i + " viewType=" + i2);
        int a2 = a(i);
        AdTemplate e2 = e(a2);
        if (e2 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_INDEX_IN_VIEW_PAGER", a2);
        bundle.putSerializable("key_template", e2);
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
        this.f33117e = slidePlayViewPager;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.j = list;
        this.f33113a.clear();
        this.f33113a.addAll(list);
        if (g(this.f33117e.getCurrentItem())) {
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
        this.f33118h.clear();
    }

    public abstract int b();

    public void b(int i) {
    }

    @Override // com.kwad.sdk.contentalliance.b.a
    public boolean b(KsFragment ksFragment) {
        return ksFragment instanceof com.kwad.sdk.contentalliance.detail.a;
    }

    public abstract int c();

    public abstract int c(int i);

    @Override // com.kwad.sdk.contentalliance.b.a
    public int d(int i) {
        int a2 = a(i);
        AdTemplate e2 = e(a2);
        int i2 = -1;
        if (e2 != null) {
            int i3 = e2.contentType;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        com.kwad.sdk.contentalliance.detail.b.b bVar = this.k;
                        int a3 = bVar != null ? bVar.a(e2, a2) : 0;
                        if (a3 == 3) {
                            i2 = this.k.a(e2).getItemViewType() + 1000;
                        } else if (a3 != 2) {
                            i2 = -2;
                        }
                    } else if (i3 == 4) {
                        i2 = 200;
                    }
                }
                i2 = 0;
            } else {
                i2 = 100;
            }
        }
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "getItemViewType position=" + i + "--realPosition=" + a2 + "--itemType=" + i2 + "--size=" + this.f33113a.size());
        return i2;
    }

    public List<AdTemplate> d() {
        return this.f33113a;
    }

    @Override // com.kwad.sdk.contentalliance.b.a, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        super.destroyItem(viewGroup, i, obj);
        this.f33118h.remove(i);
    }

    public AdTemplate e(int i) {
        if (i < 0 || this.f33113a.size() <= i) {
            return null;
        }
        return this.f33113a.get(i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        StringBuilder sb;
        if (obj instanceof b.C0375b) {
            b.C0375b c0375b = (b.C0375b) obj;
            int i = this.f33114b;
            if (i > -1 && i == c0375b.f32191b) {
                this.f33114b = -1;
                com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "getItemPosition11 position:" + c0375b.f32191b + "--POSITION_UNCHANGED");
                return -1;
            } else if (!(c0375b.f32190a instanceof com.kwad.sdk.contentalliance.detail.a) && d(c0375b.f32191b) != -1) {
                com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "getItemPosition22 position:" + c0375b.f32191b + "--POSITION_NONE");
                return -2;
            } else {
                sb = new StringBuilder();
                sb.append("getItemPosition33 position:");
                sb.append(c0375b.f32191b);
                sb.append("--mItemPosition=");
                sb.append(this.f33115c == -1 ? "POSITION_UNCHANGED" : "POSITION_NONE");
            }
        } else {
            sb = new StringBuilder();
            sb.append("getItemPosition 1111111 object:");
            sb.append(obj);
        }
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", sb.toString());
        return this.f33115c;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public CharSequence getPageTitle(int i) {
        int a2 = a(i);
        if (a2 < 0 || a2 >= this.f33113a.size()) {
            return "";
        }
        AdTemplate adTemplate = this.f33113a.get(a2);
        return !TextUtils.isEmpty(adTemplate.mCurrentTrendTitle) ? adTemplate.mCurrentTrendTitle : "";
    }

    @Override // com.kwad.sdk.contentalliance.b.a, androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "instantiateItem position=" + i);
        KsFragment ksFragment = (KsFragment) super.instantiateItem(viewGroup, i);
        this.f33118h.put(i, ksFragment);
        return ksFragment;
    }
}
