package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.adp.widget.ListView.TypeAdapter.ViewHolder;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class wm<T, V extends TypeAdapter.ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public tn b;
    public un c;
    public BdUniqueId d;
    public BdUniqueId e;
    public on<jn> f;
    public V g;
    public rm h;

    public wm(Context context, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.d = bdUniqueId;
        this.h = new rm();
    }

    public tn A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (tn) invokeV.objValue;
    }

    public un B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : (un) invokeV.objValue;
    }

    public int C(int i) {
        InterceptResult invokeI;
        BdUniqueId bdUniqueId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            on<jn> onVar = this.f;
            if (onVar == null || (bdUniqueId = this.d) == null) {
                return -1;
            }
            return onVar.b(i, bdUniqueId.getId());
        }
        return invokeI.intValue;
    }

    public tm D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? this.h.a(i) : (tm) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.repackage.wm<T, V extends com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder> */
    /* JADX WARN: Multi-variable type inference failed */
    public View E(int i, View view2, ViewGroup viewGroup, T t) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t})) == null) {
            if (G(view2)) {
                V v = (V) N(viewGroup, t);
                this.g = v;
                view2 = v.b();
                if (BdBaseApplication.getInst().isDebugMode()) {
                    BdLog.i("convertView is creating" + this.g.getClass().getName());
                }
            }
            View view3 = view2;
            return S(i, view3, viewGroup, t, (TypeAdapter.ViewHolder) view3.getTag());
        }
        return (View) invokeCommon.objValue;
    }

    public boolean F(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? this.h.b(i) : invokeI.booleanValue;
    }

    public final boolean G(View view2) {
        InterceptResult invokeL;
        V v;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) ? view2 == null || view2.getTag() == null || (v = this.g) == null || !v.getClass().isAssignableFrom(view2.getTag().getClass()) || !view2.getTag().getClass().isAssignableFrom(this.g.getClass()) : invokeL.booleanValue;
    }

    public void H() {
        on<jn> onVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (onVar = this.f) == null) {
            return;
        }
        onVar.notifyDataSetChanged();
    }

    public V I(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, t)) == null) {
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public V J(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, viewGroup, t)) == null) {
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public V K(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, viewGroup, t)) == null) {
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public V L(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, viewGroup, t)) == null) {
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public abstract V M(ViewGroup viewGroup);

    public V N(ViewGroup viewGroup, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, viewGroup, t)) == null) ? M(viewGroup) : (V) invokeLL.objValue;
    }

    public View O(int i, View view2, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t, v})) == null) ? S(i, view2, viewGroup, t, v) : (View) invokeCommon.objValue;
    }

    public View P(int i, View view2, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t, v})) == null) ? S(i, view2, viewGroup, t, v) : (View) invokeCommon.objValue;
    }

    public View Q(int i, View view2, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t, v})) == null) ? S(i, view2, viewGroup, t, v) : (View) invokeCommon.objValue;
    }

    public View R(int i, View view2, ViewGroup viewGroup, T t, V v) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t, v})) == null) ? S(i, view2, viewGroup, t, v) : (View) invokeCommon.objValue;
    }

    public abstract View S(int i, View view2, ViewGroup viewGroup, T t, V v);

    public void T(int i, ViewGroup viewGroup, V v, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), viewGroup, v, t}) == null) {
            S(i, v.b(), viewGroup, t, v);
        }
    }

    public void U(on<jn> onVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onVar) == null) {
            this.f = onVar;
        }
    }

    public void V(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, tnVar) == null) {
            this.b = tnVar;
        }
    }

    public void W(un unVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, unVar) == null) {
            this.c = unVar;
        }
    }

    public void X(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bdUniqueId) == null) {
            this.e = bdUniqueId;
        }
    }

    public boolean Y(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIII = interceptable.invokeIII(1048600, this, i, i2, i3)) == null) ? this.h.c(i, i2, i3) : invokeIII.booleanValue;
    }

    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.d : (BdUniqueId) invokeV.objValue;
    }

    public ViewGroup.LayoutParams u(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, viewGroup)) == null) {
            if (viewGroup instanceof ListView) {
                return new AbsListView.LayoutParams(-1, -2);
            }
            if (viewGroup instanceof RecyclerView) {
                return new RecyclerView.LayoutParams(-1, -2);
            }
            return new ViewGroup.LayoutParams(-1, -2);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public BdUniqueId v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public BdUniqueId w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public BdUniqueId x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public BdUniqueId y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return null;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public jn z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i)) == null) {
            on<jn> onVar = this.f;
            if (onVar != null) {
                return onVar.getItem(i);
            }
            return null;
        }
        return (jn) invokeI.objValue;
    }

    public wm(Context context, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.d = bdUniqueId;
        this.e = bdUniqueId2;
        this.h = new rm();
    }
}
