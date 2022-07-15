package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ly7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public iy7 a;
    public BaseFragmentActivity b;
    public int c;

    public ly7(BaseFragmentActivity baseFragmentActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = 3;
        this.b = baseFragmentActivity;
    }

    public final void a(jr7 jr7Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, jr7Var, str) == null) || jr7Var == null) {
            return;
        }
        if (this.a == null) {
            this.a = new iy7(LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0680, (ViewGroup) null));
        }
        this.a.m(jr7Var, str);
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            iy7 iy7Var = this.a;
            if (iy7Var == null) {
                return null;
            }
            return iy7Var.a;
        }
        return (View) invokeV.objValue;
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || this.c == i) {
            return;
        }
        iy7 iy7Var = this.a;
        if (iy7Var != null) {
            iy7Var.o();
        }
        this.c = i;
    }

    public void d(jr7 jr7Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048579, this, jr7Var, str) == null) || jr7Var == null || jr7Var.O() == null) {
            return;
        }
        a(jr7Var, str);
    }

    public void e(BdTypeListView bdTypeListView) {
        iy7 iy7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bdTypeListView) == null) || (iy7Var = this.a) == null) {
            return;
        }
        bdTypeListView.removeHeaderView(iy7Var.a);
    }
}
