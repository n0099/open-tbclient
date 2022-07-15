package com.repackage;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.template.state.ViewType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ec5;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class zb5 implements yb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, ac5> a;
    public final ViewGroup b;
    public final hc5 c;
    public final ec5 d;
    public ViewType e;
    public ac5 f;

    public zb5(hc5 hc5Var, @NonNull ViewGroup viewGroup, @NonNull ec5 ec5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hc5Var, viewGroup, ec5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        this.b = viewGroup;
        this.c = hc5Var;
        this.d = ec5Var;
    }

    @Override // com.repackage.yb5
    public void a(ViewType viewType, String str) {
        ec5.a aVar;
        ec5.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, viewType, str) == null) {
            if (viewType == ViewType.ERROR && (bVar = this.d.c) != null) {
                bVar.a = str;
            } else if (viewType != ViewType.EMPTY || (aVar = this.d.b) == null) {
            } else {
                aVar.a = str;
            }
        }
    }

    @Override // com.repackage.yb5
    public void b(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewType) == null) || this.e == viewType) {
            return;
        }
        this.e = viewType;
        if (this.b == null) {
            return;
        }
        hc5 hc5Var = this.c;
        if (hc5Var != null && hc5Var.getView() != null) {
            this.c.getView().setVisibility(viewType == ViewType.CONTENT ? 0 : 8);
        }
        ac5 ac5Var = this.f;
        if (ac5Var != null) {
            ac5Var.b(this.b);
        }
        ac5 ac5Var2 = this.a.get(viewType);
        ec5.e d = d(viewType);
        if (ac5Var2 == null || d == null) {
            return;
        }
        ac5Var2.c(viewType, this.b, d);
        this.f = ac5Var2;
        this.a.put(viewType, ac5Var2);
    }

    @Override // com.repackage.yb5
    public void c(ViewType viewType, @NonNull ac5 ac5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, ac5Var) == null) {
            this.a.put(viewType, ac5Var);
        }
    }

    public final ec5.e d(ViewType viewType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewType)) == null) {
            if (viewType == ViewType.ERROR) {
                return this.d.c;
            }
            if (viewType == ViewType.EMPTY) {
                return this.d.b;
            }
            if (viewType == ViewType.LOADING) {
                return this.d.a;
            }
            return null;
        }
        return (ec5.e) invokeL.objValue;
    }

    @Override // com.repackage.yb5
    public void onChangeSkinType(int i) {
        ac5 ac5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (ac5Var = this.f) == null) {
            return;
        }
        ac5Var.e(i);
    }

    @Override // com.repackage.yb5
    public void onDestroy() {
        ac5 ac5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (ac5Var = this.f) == null) {
            return;
        }
        ac5Var.b(this.b);
    }
}
