package com.kwad.sdk.lib.widget.viewpager.tabstrip;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.api.core.fragment.KsFragmentTransaction;
import com.kwad.sdk.api.core.fragment.KsSavedState;
import com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends PagerAdapter implements PagerSlidingTabStrip.c.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f38624a;

    /* renamed from: b  reason: collision with root package name */
    public final KsFragmentManager f38625b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f38626c;

    /* renamed from: d  reason: collision with root package name */
    public KsFragmentTransaction f38627d;

    /* renamed from: e  reason: collision with root package name */
    public SparseArray<KsFragment> f38628e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<KsSavedState> f38629f;

    /* renamed from: g  reason: collision with root package name */
    public SparseArray<Bundle> f38630g;

    /* renamed from: h  reason: collision with root package name */
    public KsFragment f38631h;

    /* renamed from: i  reason: collision with root package name */
    public int f38632i;

    /* renamed from: com.kwad.sdk.lib.widget.viewpager.tabstrip.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0476a {
        void a(Bundle bundle);
    }

    public a(Context context, KsFragmentManager ksFragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, ksFragmentManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38626c = new ArrayList();
        this.f38627d = null;
        this.f38628e = new SparseArray<>();
        this.f38629f = new SparseArray<>();
        this.f38630g = new SparseArray<>();
        this.f38631h = null;
        this.f38625b = ksFragmentManager;
        this.f38624a = context;
    }

    private KsFragment d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) ? KsFragment.instantiate(this.f38624a, this.f38626c.get(i2).b().getName(), this.f38630g.get(i2)) : (KsFragment) invokeI.objValue;
    }

    public int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.f38626c != null && !TextUtils.isEmpty(str)) {
                for (int i2 = 0; i2 < this.f38626c.size(); i2++) {
                    b bVar = this.f38626c.get(i2);
                    if (bVar != null && bVar.a() != null && str.equals(bVar.a().a())) {
                        return i2;
                    }
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public KsFragment a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f38631h : (KsFragment) invokeV.objValue;
    }

    public KsFragment a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? this.f38628e.get(i2) : (KsFragment) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: a */
    public KsFragment instantiateItem(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, viewGroup, i2)) == null) {
            KsFragment ksFragment = this.f38628e.get(i2);
            if (ksFragment != null) {
                this.f38626c.get(i2).a(i2, ksFragment);
                return ksFragment;
            }
            if (this.f38627d == null) {
                this.f38627d = this.f38625b.beginTransaction();
            }
            KsFragment d2 = d(i2);
            this.f38626c.get(i2).a(i2, d2);
            KsSavedState ksSavedState = this.f38629f.get(i2);
            if (ksSavedState != null) {
                d2.setInitialSavedState(ksSavedState);
            }
            d2.setMenuVisibility(false);
            d2.setUserVisibleHint(false);
            this.f38628e.put(i2, d2);
            this.f38627d.add(viewGroup.getId(), d2);
            return d2;
        }
        return (KsFragment) invokeLI.objValue;
    }

    public void a(int i2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048580, this, i2, bundle) == null) || bundle == null) {
            return;
        }
        Bundle bundle2 = this.f38630g.get(i2);
        if (bundle2 != null) {
            bundle2.putAll(bundle);
            bundle = bundle2;
        }
        this.f38630g.put(i2, bundle);
        KsFragment a2 = a(i2);
        if (a2 instanceof InterfaceC0476a) {
            ((InterfaceC0476a) a2).a(bundle);
        }
    }

    public void a(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, list) == null) {
            this.f38626c.clear();
            b(list);
        }
    }

    @Override // com.kwad.sdk.lib.widget.viewpager.tabstrip.PagerSlidingTabStrip.c.a
    public PagerSlidingTabStrip.c b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (!this.f38626c.isEmpty() && i2 >= 0 && i2 < this.f38626c.size()) {
                return this.f38626c.get(i2).a();
            }
            return null;
        }
        return (PagerSlidingTabStrip.c) invokeI.objValue;
    }

    public void b(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            if (list == null) {
                throw new RuntimeException("delegates should not be null for setFragments()");
            }
            int size = this.f38626c.size();
            int size2 = list.size() + size;
            for (int i2 = size; i2 < size2; i2++) {
                this.f38630g.put(i2, list.get(i2 - size).c());
            }
            this.f38626c.addAll(list);
            notifyDataSetChanged();
        }
    }

    public String c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            PagerSlidingTabStrip.c b2 = b(i2);
            return (b2 == null || b2.a() == null) ? "" : b2.a();
        }
        return (String) invokeI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048585, this, viewGroup, i2, obj) == null) {
            KsFragment ksFragment = (KsFragment) obj;
            if (this.f38627d == null) {
                this.f38627d = this.f38625b.beginTransaction();
            }
            this.f38629f.put(i2, this.f38625b.saveFragmentInstanceState(ksFragment));
            this.f38628e.remove(i2);
            this.f38627d.remove(ksFragment);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(ViewGroup viewGroup) {
        KsFragmentTransaction ksFragmentTransaction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, viewGroup) == null) || (ksFragmentTransaction = this.f38627d) == null) {
            return;
        }
        ksFragmentTransaction.commitAllowingStateLoss();
        this.f38627d = null;
        try {
            this.f38625b.executePendingTransactions();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f38626c.size() : invokeV.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, view, obj)) == null) ? ((KsFragment) obj).getView() == view : invokeLL.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, parcelable, classLoader) == null) {
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        KsFragment ksFragment;
        KsFragment ksFragment2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048592, this, viewGroup, i2, obj) == null) || (ksFragment = (KsFragment) obj) == (ksFragment2 = this.f38631h)) {
            return;
        }
        if (ksFragment2 != null) {
            ksFragment2.setMenuVisibility(false);
            this.f38631h.setUserVisibleHint(false);
        }
        if (ksFragment != null) {
            ksFragment.setMenuVisibility(true);
            ksFragment.setUserVisibleHint(true);
        }
        this.f38631h = ksFragment;
        this.f38632i = i2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, viewGroup) == null) {
        }
    }
}
