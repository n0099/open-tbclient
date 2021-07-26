package d.a.q0.e3.j;

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
import d.a.d.e.p.l;
import d.a.p0.s.f0.f;
/* loaded from: classes8.dex */
public class h extends d.a.d.a.d<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<Object> f56620a;

    /* renamed from: b  reason: collision with root package name */
    public View f56621b;

    /* renamed from: c  reason: collision with root package name */
    public BdListView f56622c;

    /* renamed from: d  reason: collision with root package name */
    public NoNetworkView f56623d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.s.f0.g f56624e;

    /* renamed from: f  reason: collision with root package name */
    public e f56625f;

    /* renamed from: g  reason: collision with root package name */
    public NoDataView f56626g;

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
        this.f56624e.a0(bdUniqueId);
    }

    public void d(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f56623d.a(bVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f56622c.A(0L);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f56623d.setVisibility(0);
        }
    }

    public void g(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) {
            e();
            if (z || str == null) {
                return;
            }
            this.f56620a.showToast(str, true);
        }
    }

    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f56621b : (View) invokeV.objValue;
    }

    public void j() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (noDataView = this.f56626g) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.f56622c.removeHeaderView(this.f56626g);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.f56623d.setVisibility(8);
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
            this.f56625f.i(fVar);
            this.f56625f.notifyDataSetChanged();
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void m(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f56623d.d(bVar);
        }
    }

    public void n(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
            this.f56624e.a(gVar);
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            if (this.f56626g == null) {
                this.f56626g = NoDataViewFactory.a(this.f56620a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds240)), NoDataViewFactory.e.a(i2), null);
            }
            this.f56626g.setTextOption(NoDataViewFactory.e.a(i2));
            this.f56626g.f(this.f56620a, TbadkCoreApplication.getInst().getSkinType());
            this.f56626g.setVisibility(0);
            this.f56622c.removeHeaderView(this.f56626g);
            this.f56622c.addHeaderView(this.f56626g);
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f56620a.getLayoutMode().k(i2 == 1);
            this.f56620a.getLayoutMode().j(this.f56621b);
            this.f56625f.h(i2);
            this.f56624e.I(i2);
            this.f56623d.c(this.mContext, i2);
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
                super((d.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56620a = null;
        this.f56622c = null;
        this.f56624e = null;
        this.f56625f = null;
        this.f56620a = tbPageContext;
        this.f56621b = view;
        BdListView bdListView = (BdListView) view.findViewById(R.id.square_list);
        this.f56622c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.f56620a.getOrignalPage() instanceof SquareActivity) {
            this.f56622c.setOnItemClickListener((SquareActivity) this.f56620a.getOrignalPage());
        }
        e eVar = new e(tbPageContext);
        this.f56625f = eVar;
        this.f56622c.setAdapter((ListAdapter) eVar);
        d.a.p0.s.f0.g gVar = new d.a.p0.s.f0.g(tbPageContext);
        this.f56624e = gVar;
        this.f56622c.setPullRefresh(gVar);
        this.f56623d = (NoNetworkView) this.f56621b.findViewById(R.id.view_no_network);
    }
}
