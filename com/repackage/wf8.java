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
import com.repackage.gu4;
/* loaded from: classes7.dex */
public class wf8 extends b9<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<Object> a;
    public View b;
    public BdListView c;
    public NoNetworkView d;
    public hu4 e;
    public tf8 f;
    public NoDataView g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public wf8(TbPageContext<Object> tbPageContext, BdUniqueId bdUniqueId, View view2, View.OnKeyListener onKeyListener) {
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
        this.e.b0(bdUniqueId);
    }

    public void a(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.d.a(bVar);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.A(0L);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.d.setVisibility(0);
        }
    }

    public void k(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) {
            h();
            if (z || str == null) {
                return;
            }
            this.a.showToast(str, true);
        }
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public void m() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (noDataView = this.g) == null) {
            return;
        }
        noDataView.setVisibility(8);
        this.c.removeHeaderView(this.g);
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.d.setVisibility(8);
        }
    }

    public void o(uf8 uf8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, uf8Var) == null) || uf8Var == null) {
            return;
        }
        try {
            if (uf8Var.g()) {
                return;
            }
            this.f.i(uf8Var);
            this.f.notifyDataSetChanged();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.b);
            this.f.h(i);
            this.e.H(i);
            this.d.d(this.mContext, i);
        }
    }

    public void p(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.d.e(bVar);
        }
    }

    public void q(gu4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.e.f(gVar);
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            if (this.g == null) {
                this.g = NoDataViewFactory.a(this.a.getPageActivity(), null, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.NODATA, pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070283)), NoDataViewFactory.e.a(i), null);
            }
            this.g.setTextOption(NoDataViewFactory.e.a(i));
            this.g.f(this.a, TbadkCoreApplication.getInst().getSkinType());
            this.g.setVisibility(0);
            this.c.removeHeaderView(this.g);
            this.c.addHeaderView(this.g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wf8(TbPageContext<Object> tbPageContext, View view2, View.OnKeyListener onKeyListener) {
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
                super((d9) newInitContext.callArgs[0]);
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
        BdListView bdListView = (BdListView) view2.findViewById(R.id.obfuscated_res_0x7f091e11);
        this.c = bdListView;
        bdListView.setOnKeyListener(onKeyListener);
        if (this.a.getOrignalPage() instanceof SquareActivity) {
            this.c.setOnItemClickListener((SquareActivity) this.a.getOrignalPage());
        }
        tf8 tf8Var = new tf8(tbPageContext);
        this.f = tf8Var;
        this.c.setAdapter((ListAdapter) tf8Var);
        hu4 hu4Var = new hu4(tbPageContext);
        this.e = hu4Var;
        this.c.setPullRefresh(hu4Var);
        this.d = (NoNetworkView) this.b.findViewById(R.id.obfuscated_res_0x7f09243b);
    }
}
