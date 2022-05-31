package com.repackage;

import com.baidu.ala.widget.multicolumn.BdTypeMultiColumnListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class xq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b9 a;
    public final List<wm> b;
    public BdTypeMultiColumnListView c;
    public yq5 d;
    public br5 e;

    public xq5(b9 b9Var, BdTypeMultiColumnListView bdTypeMultiColumnListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {b9Var, bdTypeMultiColumnListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.a = b9Var;
        this.c = bdTypeMultiColumnListView;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d = new yq5((TbPageContext) this.a, er5.b);
            this.e = new br5((TbPageContext) this.a, er5.c);
            this.b.add(this.d);
            this.b.add(this.e);
            this.c.addAdapters(this.b);
        }
    }

    public void b(mm5 mm5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mm5Var) == null) {
            yq5 yq5Var = this.d;
            if (yq5Var != null) {
                yq5Var.b0(mm5Var);
            }
            br5 br5Var = this.e;
            if (br5Var != null) {
                br5Var.b0(mm5Var);
            }
        }
    }

    public void c(List<jn> list) {
        BdTypeMultiColumnListView bdTypeMultiColumnListView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || (bdTypeMultiColumnListView = this.c) == null) {
            return;
        }
        bdTypeMultiColumnListView.setData(list);
    }
}
