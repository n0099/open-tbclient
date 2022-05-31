package com.repackage;

import android.app.Activity;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oa5;
/* loaded from: classes7.dex */
public class ya5 extends ta5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oa5.c a;
    public TbPageContext b;
    public BdRecyclerView c;
    public PbListView d;

    public ya5(TbPageContext tbPageContext, BdRecyclerView bdRecyclerView, oa5.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdRecyclerView, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = tbPageContext;
        this.c = bdRecyclerView;
        this.a = cVar;
        PbListView pbListView = new PbListView(getActivity());
        this.d = pbListView;
        pbListView.b();
        this.d.p(R.color.transparent);
        this.d.t(this.a.a);
        this.d.L(this.a.b);
        this.d.x();
        this.d.G(R.dimen.tbfontsize33);
        this.d.E(SkinManager.getColor(R.color.CAM_X0107));
        this.d.A(R.color.CAM_X0110);
        this.d.s();
    }

    private Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.b.getPageActivity() : (Activity) invokeV.objValue;
    }

    @Override // com.repackage.ta5
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.a.g) {
                e();
            } else {
                d();
            }
        }
    }

    @Override // com.repackage.ta5
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c.setNextPage(this.d);
            this.d.Q();
            this.d.C(this.a.c);
            this.d.B(null);
        }
    }

    @Override // com.repackage.ta5
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.setNextPage(this.d);
            this.d.f();
            this.d.C(this.a.e);
            this.d.B(null);
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.c.setNextPage(this.d);
            this.d.f();
            this.d.C(this.a.d);
            this.d.B(null);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.setNextPage(this.d);
            this.d.f();
            this.d.C(this.a.f);
            this.d.B(this.a.h);
        }
    }

    @Override // com.repackage.wa5
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.d.d(i);
        }
    }
}
