package com.kwad.sdk.contentalliance.home.viewpager;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.contentalliance.b.b;
import com.kwad.sdk.contentalliance.home.h;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.plugin.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a extends com.kwad.sdk.contentalliance.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public com.kwad.sdk.lib.widget.b<AdTemplate> f35279a;

    /* renamed from: b  reason: collision with root package name */
    public int f35280b;

    /* renamed from: c  reason: collision with root package name */
    public int f35281c;

    /* renamed from: d  reason: collision with root package name */
    public int f35282d;

    /* renamed from: e  reason: collision with root package name */
    public SlidePlayViewPager f35283e;

    /* renamed from: h  reason: collision with root package name */
    public final SparseArray<KsFragment> f35284h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f35285i;
    public List<AdTemplate> j;
    public com.kwad.sdk.contentalliance.detail.b.b k;
    public h l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull KsFragmentManager ksFragmentManager) {
        super(ksFragmentManager);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksFragmentManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((KsFragmentManager) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35284h = new SparseArray<>();
        this.f35279a = new com.kwad.sdk.lib.widget.b<>(new ArrayList());
        this.f35280b = -1;
        this.f35281c = -1;
        this.f35282d = 0;
    }

    private void b(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "notifyDetachedItems position=" + i2);
            for (int i3 = 0; i3 < this.f35284h.size(); i3++) {
                int keyAt = this.f35284h.keyAt(i3);
                KsFragment valueAt = this.f35284h.valueAt(i3);
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
    }

    private void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, this, z) == null) {
            for (int i2 = 0; i2 < this.f35284h.size(); i2++) {
                KsFragment valueAt = this.f35284h.valueAt(i2);
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
    }

    private void c(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "notifyAttachedItem position=" + i2);
            KsFragment ksFragment = this.f35284h.get(i2);
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
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65540, this, i2)) == null) {
            int a2 = a(i2);
            boolean z = false;
            if (a2 < 0) {
                return false;
            }
            boolean z2 = true;
            if (a2 < this.f35279a.size() - 1) {
                AdTemplate adTemplate = this.f35279a.get(a2 + 1);
                if (d(i2 + 1) == -2) {
                    this.f35279a.remove(adTemplate);
                    List<AdTemplate> list = this.j;
                    if (list != null) {
                        list.remove(adTemplate);
                    }
                    if (com.kwad.sdk.core.d.a.f35940a) {
                        com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "无效作品移除 template:" + adTemplate.toJson());
                    }
                    z = true;
                }
            }
            if (a2 > 0 && a2 < this.f35279a.size()) {
                AdTemplate adTemplate2 = this.f35279a.get(a2 - 1);
                if (d(i2 - 1) == -2) {
                    this.f35279a.remove(adTemplate2);
                    List<AdTemplate> list2 = this.j;
                    if (list2 != null) {
                        list2.remove(adTemplate2);
                    }
                    b(1);
                    if (com.kwad.sdk.core.d.a.f35940a) {
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
        return invokeI.booleanValue;
    }

    public int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35279a.size() : invokeV.intValue;
    }

    public abstract int a(int i2);

    @Override // com.kwad.sdk.contentalliance.b.a
    public int a(KsFragment ksFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ksFragment)) == null) {
            com.kwad.sdk.plugin.d dVar = (com.kwad.sdk.plugin.d) g.a(com.kwad.sdk.plugin.d.class);
            if (ksFragment instanceof com.kwad.sdk.contentalliance.detail.ad.a) {
                return 0;
            }
            if (ksFragment instanceof com.kwad.sdk.contentalliance.detail.photo.a) {
                return 100;
            }
            return (dVar == null || !dVar.a(ksFragment)) ? -1 : 200;
        }
        return invokeL.intValue;
    }

    @Override // com.kwad.sdk.contentalliance.b.a
    public KsFragment a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i2, i3)) == null) {
            com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "onCreateItem position=" + i2);
            return i3 >= 1000 ? new com.kwad.sdk.contentalliance.detail.b.a() : i3 == 0 ? new com.kwad.sdk.contentalliance.detail.ad.a() : i3 == 100 ? new com.kwad.sdk.contentalliance.detail.photo.a() : i3 == 200 ? ((com.kwad.sdk.plugin.d) g.a(com.kwad.sdk.plugin.d.class)).a() : new KsFragment();
        }
        return (KsFragment) invokeII.objValue;
    }

    public void a(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "onSelectChanged position=" + i2);
            if (this.f35285i) {
                return;
            }
            b(i2, z);
            c(i2, z);
            g(i2);
        }
    }

    @Override // com.kwad.sdk.contentalliance.b.a
    public void a(KsFragment ksFragment, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, ksFragment, i2, i3) == null) {
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
    }

    public void a(com.kwad.sdk.contentalliance.detail.b.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void a(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, hVar) == null) {
            this.l = hVar;
        }
    }

    public void a(SlidePlayViewPager slidePlayViewPager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, slidePlayViewPager) == null) {
            this.f35283e = slidePlayViewPager;
        }
    }

    public void a(List<AdTemplate> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, list) == null) || list == null || list.isEmpty()) {
            return;
        }
        this.j = list;
        this.f35279a.clear();
        this.f35279a.addAll(list);
        if (g(this.f35283e.getCurrentItem())) {
            return;
        }
        notifyDataSetChanged();
    }

    public void a(List<AdTemplate> list, @Nullable AdTemplate adTemplate, int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{list, adTemplate, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.l.b();
            b(z);
            this.f35285i = true;
            this.f35284h.clear();
        }
    }

    public abstract int b();

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
        }
    }

    @Override // com.kwad.sdk.contentalliance.b.a
    public boolean b(KsFragment ksFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, ksFragment)) == null) ? ksFragment instanceof com.kwad.sdk.contentalliance.detail.a : invokeL.booleanValue;
    }

    public abstract int c();

    public abstract int c(int i2);

    @Override // com.kwad.sdk.contentalliance.b.a
    public int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
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
            com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "getItemViewType position=" + i2 + "--realPosition=" + a2 + "--itemType=" + i3 + "--size=" + this.f35279a.size());
            return i3;
        }
        return invokeI.intValue;
    }

    public List<AdTemplate> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.f35279a : (List) invokeV.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.b.a, androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048595, this, viewGroup, i2, obj) == null) {
            super.destroyItem(viewGroup, i2, obj);
            this.f35284h.remove(i2);
        }
    }

    public AdTemplate e(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i2)) == null) {
            if (i2 < 0 || this.f35279a.size() <= i2) {
                return null;
            }
            return this.f35279a.get(i2);
        }
        return (AdTemplate) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        InterceptResult invokeL;
        StringBuilder sb;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, obj)) == null) {
            if (obj instanceof b.C0408b) {
                b.C0408b c0408b = (b.C0408b) obj;
                int i2 = this.f35280b;
                if (i2 > -1 && i2 == c0408b.f34311b) {
                    this.f35280b = -1;
                    com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "getItemPosition11 position:" + c0408b.f34311b + "--POSITION_UNCHANGED");
                    return -1;
                } else if (!(c0408b.f34310a instanceof com.kwad.sdk.contentalliance.detail.a) && d(c0408b.f34311b) != -1) {
                    com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "getItemPosition22 position:" + c0408b.f34311b + "--POSITION_NONE");
                    return -2;
                } else {
                    sb = new StringBuilder();
                    sb.append("getItemPosition33 position:");
                    sb.append(c0408b.f34311b);
                    sb.append("--mItemPosition=");
                    sb.append(this.f35281c == -1 ? "POSITION_UNCHANGED" : "POSITION_NONE");
                }
            } else {
                sb = new StringBuilder();
                sb.append("getItemPosition 1111111 object:");
                sb.append(obj);
            }
            com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", sb.toString());
            return this.f35281c;
        }
        return invokeL.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public CharSequence getPageTitle(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            int a2 = a(i2);
            if (a2 < 0 || a2 >= this.f35279a.size()) {
                return "";
            }
            AdTemplate adTemplate = this.f35279a.get(a2);
            return !TextUtils.isEmpty(adTemplate.mCurrentTrendTitle) ? adTemplate.mCurrentTrendTitle : "";
        }
        return (CharSequence) invokeI.objValue;
    }

    @Override // com.kwad.sdk.contentalliance.b.a, androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048599, this, viewGroup, i2)) == null) {
            com.kwad.sdk.core.d.a.a("SlidePlayPagerAdapter", "instantiateItem position=" + i2);
            KsFragment ksFragment = (KsFragment) super.instantiateItem(viewGroup, i2);
            this.f35284h.put(i2, ksFragment);
            return ksFragment;
        }
        return invokeLI.objValue;
    }
}
