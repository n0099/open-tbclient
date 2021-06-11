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
    public com.kwad.sdk.lib.widget.b<AdTemplate> f33418a;

    /* renamed from: b  reason: collision with root package name */
    public int f33419b;

    /* renamed from: c  reason: collision with root package name */
    public int f33420c;

    /* renamed from: d  reason: collision with root package name */
    public int f33421d;

    /* renamed from: e  reason: collision with root package name */
    public SlidePlayViewPager f33422e;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<KsFragment> f33423h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f33424i;
    public List<AdTemplate> j;
    public com.kwad.sdk.contentalliance.detail.b.b k;
    public h l;

    public a(@NonNull KsFragmentManager ksFragmentManager) {
        super(ksFragmentManager);
        this.f33423h = new SparseArray<>();
        this.f33418a = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f33419b = -1;
        this.f33420c = -1;
        this.f33421d = 0;
    }

    private void b(int i2, boolean z) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "notifyDetachedItems position=" + i2);
        for (int i3 = 0; i3 < this.f33423h.size(); i3++) {
            int keyAt = this.f33423h.keyAt(i3);
            KsFragment valueAt = this.f33423h.valueAt(i3);
            if (keyAt != i2 && (valueAt instanceof com.kwad.sdk.contentalliance.detail.a)) {
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
        for (int i2 = 0; i2 < this.f33423h.size(); i2++) {
            KsFragment valueAt = this.f33423h.valueAt(i2);
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

    private void c(int i2, boolean z) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "notifyAttachedItem position=" + i2);
        KsFragment ksFragment = this.f33423h.get(i2);
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
    private boolean g(int i2) {
        int a2 = a(i2);
        boolean z = false;
        if (a2 < 0) {
            return false;
        }
        boolean z2 = true;
        if (a2 < this.f33418a.size() - 1) {
            AdTemplate adTemplate = this.f33418a.get(a2 + 1);
            if (d(i2 + 1) == -2) {
                this.f33418a.remove(adTemplate);
                List<AdTemplate> list = this.j;
                if (list != null) {
                    list.remove(adTemplate);
                }
                if (com.kwad.sdk.core.d.a.f34079a) {
                    com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "无效作品移除 template:" + adTemplate.toJson());
                }
                z = true;
            }
        }
        if (a2 > 0 && a2 < this.f33418a.size()) {
            AdTemplate adTemplate2 = this.f33418a.get(a2 - 1);
            if (d(i2 - 1) == -2) {
                this.f33418a.remove(adTemplate2);
                List<AdTemplate> list2 = this.j;
                if (list2 != null) {
                    list2.remove(adTemplate2);
                }
                b(1);
                if (com.kwad.sdk.core.d.a.f34079a) {
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
        return this.f33418a.size();
    }

    public abstract int a(int i2);

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
    public KsFragment a(int i2, int i3) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "onCreateItem position=" + i2);
        return i3 >= 1000 ? new com.kwad.sdk.contentalliance.detail.b.a() : i3 == 0 ? new com.kwad.sdk.contentalliance.detail.ad.a() : i3 == 100 ? new com.kwad.sdk.contentalliance.detail.photo.a() : i3 == 200 ? ((com.kwad.sdk.plugin.d) g.a(com.kwad.sdk.plugin.d.class)).a() : new KsFragment();
    }

    public void a(int i2, boolean z) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "onSelectChanged position=" + i2);
        if (this.f33424i) {
            return;
        }
        b(i2, z);
        c(i2, z);
        g(i2);
    }

    @Override // com.kwad.sdk.contentalliance.b.a
    public void a(KsFragment ksFragment, int i2, int i3) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "onBindItem position=" + i2 + " viewType=" + i3);
        int a2 = a(i2);
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
        this.f33422e = slidePlayViewPager;
    }

    public void a(List<AdTemplate> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.j = list;
        this.f33418a.clear();
        this.f33418a.addAll(list);
        if (g(this.f33422e.getCurrentItem())) {
            return;
        }
        notifyDataSetChanged();
    }

    public void a(List<AdTemplate> list, @Nullable AdTemplate adTemplate, int i2, int i3, boolean z) {
    }

    public void a(boolean z) {
        this.l.b();
        b(z);
        this.f33424i = true;
        this.f33423h.clear();
    }

    public abstract int b();

    public void b(int i2) {
    }

    @Override // com.kwad.sdk.contentalliance.b.a
    public boolean b(KsFragment ksFragment) {
        return ksFragment instanceof com.kwad.sdk.contentalliance.detail.a;
    }

    public abstract int c();

    public abstract int c(int i2);

    @Override // com.kwad.sdk.contentalliance.b.a
    public int d(int i2) {
        int a2 = a(i2);
        AdTemplate e2 = e(a2);
        int i3 = -1;
        if (e2 != null) {
            int i4 = e2.contentType;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        com.kwad.sdk.contentalliance.detail.b.b bVar = this.k;
                        int a3 = bVar != null ? bVar.a(e2, a2) : 0;
                        if (a3 == 3) {
                            i3 = this.k.a(e2).getItemViewType() + 1000;
                        } else if (a3 != 2) {
                            i3 = -2;
                        }
                    } else if (i4 == 4) {
                        i3 = 200;
                    }
                }
                i3 = 0;
            } else {
                i3 = 100;
            }
        }
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "getItemViewType position=" + i2 + "--realPosition=" + a2 + "--itemType=" + i3 + "--size=" + this.f33418a.size());
        return i3;
    }

    public List<AdTemplate> d() {
        return this.f33418a;
    }

    @Override // com.kwad.sdk.contentalliance.b.a, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        super.destroyItem(viewGroup, i2, obj);
        this.f33423h.remove(i2);
    }

    public AdTemplate e(int i2) {
        if (i2 < 0 || this.f33418a.size() <= i2) {
            return null;
        }
        return this.f33418a.get(i2);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        StringBuilder sb;
        if (obj instanceof b.C0361b) {
            b.C0361b c0361b = (b.C0361b) obj;
            int i2 = this.f33419b;
            if (i2 > -1 && i2 == c0361b.f32450b) {
                this.f33419b = -1;
                com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "getItemPosition11 position:" + c0361b.f32450b + "--POSITION_UNCHANGED");
                return -1;
            } else if (!(c0361b.f32449a instanceof com.kwad.sdk.contentalliance.detail.a) && d(c0361b.f32450b) != -1) {
                com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "getItemPosition22 position:" + c0361b.f32450b + "--POSITION_NONE");
                return -2;
            } else {
                sb = new StringBuilder();
                sb.append("getItemPosition33 position:");
                sb.append(c0361b.f32450b);
                sb.append("--mItemPosition=");
                sb.append(this.f33420c == -1 ? "POSITION_UNCHANGED" : "POSITION_NONE");
            }
        } else {
            sb = new StringBuilder();
            sb.append("getItemPosition 1111111 object:");
            sb.append(obj);
        }
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", sb.toString());
        return this.f33420c;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public CharSequence getPageTitle(int i2) {
        int a2 = a(i2);
        if (a2 < 0 || a2 >= this.f33418a.size()) {
            return "";
        }
        AdTemplate adTemplate = this.f33418a.get(a2);
        return !TextUtils.isEmpty(adTemplate.mCurrentTrendTitle) ? adTemplate.mCurrentTrendTitle : "";
    }

    @Override // com.kwad.sdk.contentalliance.b.a, androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "instantiateItem position=" + i2);
        KsFragment ksFragment = (KsFragment) super.instantiateItem(viewGroup, i2);
        this.f33423h.put(i2, ksFragment);
        return ksFragment;
    }
}
