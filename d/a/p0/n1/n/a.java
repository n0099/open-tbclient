package d.a.p0.n1.n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.lego.card.view.BaseLegoCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.e;
import d.a.p0.n1.o.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public List<ICardInfo> n;
    public int o;
    public boolean p;
    public NoDataView q;
    public FrameLayout r;
    public NoDataViewFactory.e s;
    public NoDataViewFactory.d t;
    public NoDataViewFactory.c u;
    public FrameLayout.LayoutParams v;
    public String w;
    public boolean x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 0;
        this.p = true;
        this.m = tbPageContext;
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<ICardInfo> list = this.n;
            return list != null && list.size() == 0;
        }
        return invokeV.booleanValue;
    }

    public final void B(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            ICardInfo iCardInfo = this.n.get(i2);
            if (iCardInfo instanceof d.a.p0.n1.o.i.a) {
                ((d.a.p0.n1.o.i.a) iCardInfo).doLoad(iCardInfo, this.m);
            }
        }
    }

    public void C(List<ICardInfo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            List<ICardInfo> list2 = this.n;
            if (list2 == null) {
                this.n = new ArrayList();
            } else {
                list2.clear();
            }
            if (list != null) {
                this.n.addAll(list);
            }
            this.o = w();
            notifyDataSetChanged();
        }
    }

    public final void D(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            if (this.x) {
                int u = u(i2 - 1);
                int u2 = u(i2 - 2);
                B(u);
                B(u2);
                return;
            }
            int u3 = u(i2 + 1);
            int u4 = u(i2 + 2);
            B(u3);
            B(u4);
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.w = str;
        }
    }

    public void F(NoDataViewFactory.d dVar, NoDataViewFactory.e eVar, NoDataViewFactory.c cVar, FrameLayout.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, dVar, eVar, cVar, layoutParams) == null) {
            this.t = dVar;
            this.s = eVar;
            this.u = cVar;
            this.v = layoutParams;
            NoDataView noDataView = this.q;
            if (noDataView != null) {
                noDataView.setTextOption(eVar);
                this.q.setImgOption(dVar);
                this.q.setButtonOption(cVar);
                if (layoutParams != null) {
                    this.q.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.p = z;
        }
    }

    public void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.x = z;
        }
    }

    @Override // d.a.c.k.e.e, android.widget.Adapter, d.a.c.k.e.o
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.o == 0 && this.p) {
                return 1;
            }
            return this.o;
        }
        return invokeV.intValue;
    }

    @Override // d.a.c.k.e.e, android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // d.a.c.k.e.e, android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            ICardInfo x = x(i2);
            if (x != null) {
                return d.a.p0.n1.o.e.f60549a.get(x.getAdapterType());
            }
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // d.a.c.k.e.e, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048588, this, i2, view, viewGroup)) == null) {
            if (this.p && A()) {
                return t();
            }
            v();
            D(i2);
            ICardInfo x = x(i2);
            BaseLegoCardView y = y(view, x);
            if (y != null) {
                y.f18230e = this.w;
                y.h(x);
            }
            return y;
        }
        return (View) invokeILL.objValue;
    }

    @Override // d.a.c.k.e.e, android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? d.a.p0.n1.o.e.f60549a.size() + 1 : invokeV.intValue;
    }

    @Override // d.a.c.k.e.e, android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.o == 0 : invokeV.booleanValue;
    }

    public View t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.r == null) {
                this.r = new FrameLayout(this.m.getPageActivity());
            }
            if (this.q == null) {
                this.q = NoDataViewFactory.a(this.m.getPageActivity(), this.r, this.t, this.s, this.u);
            }
            this.q.setVisibility(0);
            FrameLayout.LayoutParams layoutParams = this.v;
            if (layoutParams != null) {
                this.q.setLayoutParams(layoutParams);
            }
            this.r.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            this.q.f(this.m, TbadkCoreApplication.getInst().getSkinType());
            return this.r;
        }
        return (View) invokeV.objValue;
    }

    public final int u(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            return i2 >= this.n.size() ? this.n.size() - 1 : i2;
        }
        return invokeI.intValue;
    }

    public void v() {
        FrameLayout frameLayout;
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (frameLayout = this.r) == null || (noDataView = this.q) == null) {
            return;
        }
        frameLayout.removeView(noDataView);
        this.q = null;
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            List<ICardInfo> list = this.n;
            int i2 = 0;
            if (list == null) {
                return 0;
            }
            for (ICardInfo iCardInfo : list) {
                i2 += iCardInfo.getAdapterCount();
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final ICardInfo x(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            for (ICardInfo iCardInfo : this.n) {
                int adapterCount = iCardInfo.getAdapterCount();
                if (i2 < adapterCount) {
                    return iCardInfo.getAdapterItem(i2);
                }
                i2 -= adapterCount;
            }
            return null;
        }
        return (ICardInfo) invokeI.objValue;
    }

    public BaseLegoCardView y(View view, ICardInfo iCardInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, view, iCardInfo)) == null) {
            if (iCardInfo == null) {
                return null;
            }
            if (view instanceof BaseLegoCardView) {
                return (BaseLegoCardView) view;
            }
            return (BaseLegoCardView) b.h().a(this.m, iCardInfo, 0);
        }
        return (BaseLegoCardView) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.e, android.widget.Adapter, d.a.c.k.e.o
    /* renamed from: z */
    public ICardInfo getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) ? x(i2) : (ICardInfo) invokeI.objValue;
    }
}
