package d.a.s0.e3.j;

import android.view.View;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.square.square.SquareActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.r0.r.f0.f;
/* loaded from: classes9.dex */
public class h extends d.a.c.a.d<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<Object> f59331a;

    /* renamed from: b  reason: collision with root package name */
    public View f59332b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f59333c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f59334d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.r.f0.g f59335e;

    /* renamed from: f  reason: collision with root package name */
    public e f59336f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f59337g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view, onKeyListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, view, onKeyListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (View) objArr2[1], (View.OnKeyListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f59335e.a0(bdUniqueId);
    }

    public void d(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f59334d.a(bVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f59333c.A(0L);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f59334d.setVisibility(0);
        }
    }

    public void g(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) {
            e();
            if (z || str == null) {
                return;
            }
            this.f59331a.showToast(str, true);
        }
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59332b : (View) invokeV.objValue;
    }

    public void i() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (noDataView = this.f59337g) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.f59333c.removeHeaderView(this.f59337g);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f59334d.setVisibility(8);
        }
    }

    public void l(f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) || fVar == null) {
            return;
        }
        try {
            if (fVar.g()) {
                return;
            }
            this.f59336f.i(fVar);
            this.f59336f.notifyDataSetChanged();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void m(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f59334d.d(bVar);
        }
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
            this.f59335e.a(gVar);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (this.f59337g == null) {
                this.f59337g = NoDataViewFactory.a(this.f59331a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.e.a(i2), null);
            }
            this.f59337g.setTextOption(NoDataViewFactory.e.a(i2));
            this.f59337g.f(this.f59331a, TbadkCoreApplication.getInst().getSkinType());
            this.f59337g.setVisibility(0);
            this.f59333c.removeHeaderView(this.f59337g);
            this.f59333c.addHeaderView(this.f59337g);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f59331a.getLayoutMode().k(i2 == 1);
            this.f59331a.getLayoutMode().j(this.f59332b);
            this.f59336f.h(i2);
            this.f59335e.I(i2);
            this.f59334d.c(this.mContext, i2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<Object> tbPageContext, View view, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, onKeyListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59331a = null;
        this.f59333c = null;
        this.f59335e = null;
        this.f59336f = null;
        this.f59331a = tbPageContext;
        this.f59332b = view;
        BdListView bdListView = (BdListView) view.findViewById(R.id.square_list);
        this.f59333c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.f59331a.getOrignalPage() instanceof SquareActivity) {
            this.f59333c.setOnItemClickListener((SquareActivity) this.f59331a.getOrignalPage());
        }
        e eVar = new e(tbPageContext);
        this.f59336f = eVar;
        this.f59333c.setAdapter((ListAdapter) eVar);
        d.a.r0.r.f0.g gVar = new d.a.r0.r.f0.g(tbPageContext);
        this.f59335e = gVar;
        this.f59333c.setPullRefresh(gVar);
        this.f59334d = (NoNetworkView) this.f59332b.findViewById(R.id.view_no_network);
    }
}
