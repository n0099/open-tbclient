package d.a.p0.e3.j;

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
import d.a.o0.r.f0.f;
/* loaded from: classes8.dex */
public class h extends d.a.c.a.d<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<Object> f56076a;

    /* renamed from: b  reason: collision with root package name */
    public View f56077b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f56078c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f56079d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.r.f0.g f56080e;

    /* renamed from: f  reason: collision with root package name */
    public e f56081f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f56082g;

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
        this.f56080e.a0(bdUniqueId);
    }

    public void d(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f56079d.a(bVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f56078c.A(0L);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f56079d.setVisibility(0);
        }
    }

    public void g(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) {
            e();
            if (z || str == null) {
                return;
            }
            this.f56076a.showToast(str, true);
        }
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f56077b : (View) invokeV.objValue;
    }

    public void j() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (noDataView = this.f56082g) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.f56078c.removeHeaderView(this.f56082g);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f56079d.setVisibility(8);
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
            this.f56081f.i(fVar);
            this.f56081f.notifyDataSetChanged();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void m(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f56079d.d(bVar);
        }
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
            this.f56080e.a(gVar);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (this.f56082g == null) {
                this.f56082g = NoDataViewFactory.a(this.f56076a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.e.a(i2), null);
            }
            this.f56082g.setTextOption(NoDataViewFactory.e.a(i2));
            this.f56082g.f(this.f56076a, TbadkCoreApplication.getInst().getSkinType());
            this.f56082g.setVisibility(0);
            this.f56078c.removeHeaderView(this.f56082g);
            this.f56078c.addHeaderView(this.f56082g);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f56076a.getLayoutMode().k(i2 == 1);
            this.f56076a.getLayoutMode().j(this.f56077b);
            this.f56081f.h(i2);
            this.f56080e.I(i2);
            this.f56079d.c(this.mContext, i2);
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
        this.f56076a = null;
        this.f56078c = null;
        this.f56080e = null;
        this.f56081f = null;
        this.f56076a = tbPageContext;
        this.f56077b = view;
        BdListView bdListView = (BdListView) view.findViewById(R.id.square_list);
        this.f56078c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.f56076a.getOrignalPage() instanceof SquareActivity) {
            this.f56078c.setOnItemClickListener((SquareActivity) this.f56076a.getOrignalPage());
        }
        e eVar = new e(tbPageContext);
        this.f56081f = eVar;
        this.f56078c.setAdapter((ListAdapter) eVar);
        d.a.o0.r.f0.g gVar = new d.a.o0.r.f0.g(tbPageContext);
        this.f56080e = gVar;
        this.f56078c.setPullRefresh(gVar);
        this.f56079d = (NoNetworkView) this.f56077b.findViewById(R.id.view_no_network);
    }
}
