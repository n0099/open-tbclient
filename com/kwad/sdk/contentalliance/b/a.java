package com.kwad.sdk.contentalliance.b;

import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.core.fragment.KsFragmentManager;
import com.kwad.sdk.api.core.fragment.KsFragmentTransaction;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class a extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public final KsFragmentManager f34295a;

    /* renamed from: b  reason: collision with root package name */
    public KsFragmentTransaction f34296b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34297c;

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<List<KsFragment>> f34298f;

    /* renamed from: g  reason: collision with root package name */
    public KsFragment f34299g;

    public a(@NonNull KsFragmentManager ksFragmentManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ksFragmentManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f34298f = new SparseArray<>();
        this.f34296b = null;
        this.f34299g = null;
        this.f34295a = ksFragmentManager;
    }

    public static String a(int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            return "android:switcher:" + i2 + ":" + j;
        }
        return (String) invokeCommon.objValue;
    }

    private List<KsFragment> a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, this, i2)) == null) ? this.f34298f.get(i2) : (List) invokeI.objValue;
    }

    private long b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    public int a(KsFragment ksFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, ksFragment)) == null) {
            return 0;
        }
        return invokeL.intValue;
    }

    public abstract KsFragment a(int i2, int i3);

    public abstract void a(KsFragment ksFragment, int i2, int i3);

    public abstract boolean b(KsFragment ksFragment);

    public int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048581, this, viewGroup, i2, obj) == null) {
            if (this.f34296b == null) {
                this.f34296b = this.f34295a.beginTransaction();
            }
            KsFragment ksFragment = (KsFragment) obj;
            if (!this.f34297c) {
                this.f34296b.detach(ksFragment);
                if (!b(ksFragment)) {
                    return;
                }
                int a2 = a(ksFragment);
                if (f(a2)) {
                    List<KsFragment> a3 = a(a2);
                    if (a3 == null) {
                        a3 = new ArrayList<>();
                        this.f34298f.put(a2, a3);
                    }
                    a3.add(ksFragment);
                    return;
                }
            }
            this.f34296b.remove(ksFragment);
        }
    }

    public boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup viewGroup) {
        KsFragmentTransaction ksFragmentTransaction;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, viewGroup) == null) || (ksFragmentTransaction = this.f34296b) == null) {
            return;
        }
        try {
            ksFragmentTransaction.commitNowAllowingStateLoss();
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        this.f34296b = null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i2)) == null) {
            if (this.f34296b == null) {
                this.f34296b = this.f34295a.beginTransaction();
            }
            long b2 = b(i2);
            int d2 = d(i2);
            KsFragment ksFragment = null;
            List<KsFragment> a2 = a(d2);
            if (a2 != null && a2.size() > 0) {
                ksFragment = a2.remove(0);
            }
            if (ksFragment != null) {
                a(ksFragment, i2, d2);
                this.f34296b.attach(ksFragment);
            } else {
                ksFragment = a(i2, d2);
                a(ksFragment, i2, d2);
                this.f34296b.add(viewGroup.getId(), ksFragment, a(viewGroup.getId(), b2));
            }
            if (ksFragment != this.f34299g) {
                ksFragment.setMenuVisibility(false);
                ksFragment.setUserVisibleHint(false);
            }
            return ksFragment;
        }
        return invokeLI.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, view, obj)) == null) ? ((KsFragment) obj).getView() == view : invokeLL.booleanValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, parcelable, classLoader) == null) {
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Parcelable saveState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return null;
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        KsFragment ksFragment;
        KsFragment ksFragment2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048588, this, viewGroup, i2, obj) == null) || (ksFragment = (KsFragment) obj) == (ksFragment2 = this.f34299g)) {
            return;
        }
        if (ksFragment2 != null) {
            ksFragment2.setMenuVisibility(false);
            this.f34299g.setUserVisibleHint(false);
        }
        ksFragment.setMenuVisibility(true);
        ksFragment.setUserVisibleHint(true);
        this.f34299g = ksFragment;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, viewGroup) == null) && viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }
}
