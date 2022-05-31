package com.repackage;

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
import com.repackage.ft4;
/* loaded from: classes7.dex */
public class ud8 extends z8<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<Object> a;
    public View b;
    public BdListView c;
    public NoNetworkView d;
    public gt4 e;
    public rd8 f;
    public NoDataView g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ud8(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view2, View.OnKeyListener onKeyListener) {
        this(tbPageContext, view2, onKeyListener);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, view2, onKeyListener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (View) objArr2[1], (View.OnKeyListener) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e.a0(bdUniqueId);
    }

    public void b(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.d.a(bVar);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.A(0L);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.setVisibility(0);
        }
    }

    public void h(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) {
            e();
            if (z || str == null) {
                return;
            }
            this.a.showToast(str, true);
        }
    }

    public View i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public void j() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (noDataView = this.g) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.c.removeHeaderView(this.g);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d.setVisibility(8);
        }
    }

    public void l(sd8 sd8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, sd8Var) == null) || sd8Var == null) {
            return;
        }
        try {
            if (sd8Var.g()) {
                return;
            }
            this.f.i(sd8Var);
            this.f.notifyDataSetChanged();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void m(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.d.d(bVar);
        }
    }

    public void n(ft4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gVar) == null) {
            this.e.e(gVar);
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            if (this.g == null) {
                this.g = NoDataViewFactory.a(this.a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, li.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070286)), NoDataViewFactory.e.a(i), null);
            }
            this.g.setTextOption(NoDataViewFactory.e.a(i));
            this.g.f(this.a, TbadkCoreApplication.getInst().getSkinType());
            this.g.setVisibility(0);
            this.c.removeHeaderView(this.g);
            this.c.addHeaderView(this.g);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.b);
            this.f.h(i);
            this.e.H(i);
            this.d.c(this.mContext, i);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ud8(TbPageContext<Object> tbPageContext, View view2, View.OnKeyListener onKeyListener) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, onKeyListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = null;
        this.e = null;
        this.f = null;
        this.a = tbPageContext;
        this.b = view2;
        BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f091d70);
        this.c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.a.getOrignalPage() instanceof SquareActivity) {
            this.c.setOnItemClickListener((SquareActivity) this.a.getOrignalPage());
        }
        rd8 rd8Var = new rd8(tbPageContext);
        this.f = rd8Var;
        this.c.setAdapter((ListAdapter) rd8Var);
        gt4 gt4Var = new gt4(tbPageContext);
        this.e = gt4Var;
        this.c.setPullRefresh(gt4Var);
        this.d = (NoNetworkView) this.b.findViewById(R.id.obfuscated_res_0x7f0923a4);
    }
}
