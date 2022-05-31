package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class jm7 implements Object<List<EmotionPackageData>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public BdListView b;
    public cm7 c;
    public fm7 d;
    public View e;
    public s35 f;
    public FrameLayout g;
    public NoDataView h;
    public boolean i;
    public NoNetworkView j;

    public jm7(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d02e3, (ViewGroup) null, false);
        this.e = inflate;
        NoNetworkView noNetworkView = (NoNetworkView) inflate.findViewById(R.id.obfuscated_res_0x7f0923a4);
        this.j = noNetworkView;
        noNetworkView.a(this);
        this.g = (FrameLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091d1a);
        this.b = (BdListView) this.e.findViewById(R.id.obfuscated_res_0x7f090896);
        this.d = new fm7(this.e.findViewById(R.id.obfuscated_res_0x7f090895), tbPageContext.getString(R.string.obfuscated_res_0x7f0f054e));
        this.b.setDivider(null);
        this.b.setOverScrollMode(2);
        this.b.setVerticalScrollBarEnabled(false);
        this.c = new cm7(tbPageContext, this.b);
        h();
    }

    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public void b() {
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f == null || (frameLayout = this.g) == null) {
            return;
        }
        frameLayout.setVisibility(8);
        this.f.dettachView(this.g);
        this.f = null;
    }

    public final void c() {
        NoDataView noDataView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (noDataView = this.h) != null && noDataView.getParent() == this.g) {
            this.h.setVisibility(8);
            this.g.removeView(this.h);
            this.g.setVisibility(8);
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && z) {
            h();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921314));
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            View view2 = this.e;
            if (view2 != null) {
                SkinManager.setBackgroundColor(view2, R.color.cp_bg_line_d_alpha90, i);
            }
            BdListView bdListView = this.b;
            if (bdListView != null) {
                SkinManager.setBackgroundColor(bdListView, R.color.CAM_X0201, i);
            }
            fm7 fm7Var = this.d;
            if (fm7Var != null) {
                fm7Var.b(i);
            }
            NoNetworkView noNetworkView = this.j;
            if (noNetworkView != null) {
                noNetworkView.c(this.a, i);
            }
            FrameLayout frameLayout = this.g;
            if (frameLayout != null) {
                SkinManager.setBackgroundColor(frameLayout, R.color.CAM_X0201, i);
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b();
            c();
        }
    }

    public final void g() {
        BdListView bdListView;
        fm7 fm7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (bdListView = this.b) == null || this.i || (fm7Var = this.d) == null) {
            return;
        }
        this.i = true;
        bdListView.setEmptyView(fm7Var.a());
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.a == null || this.g == null) {
            return;
        }
        f();
        this.g.setVisibility(0);
        if (this.f == null) {
            this.f = new s35(this.a.getPageActivity());
        }
        this.f.attachView(this.g, true);
        this.f.onChangeSkinType();
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.a == null || this.g == null) {
            return;
        }
        f();
        this.g.setVisibility(0);
        NoDataView b = NoDataViewFactory.b(this.a.getPageActivity(), this.g, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, li.f(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070239)), NoDataViewFactory.e.d(null, this.a.getString(R.string.obfuscated_res_0x7f0f0550)), null, true);
        this.h = b;
        b.setVisibility(0);
        this.h.d(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    public void update(List<EmotionPackageData> list) {
        cm7 cm7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, list) == null) {
            g();
            if (list == null || (cm7Var = this.c) == null) {
                return;
            }
            cm7Var.update(list);
        }
    }
}
