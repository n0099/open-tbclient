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
import com.repackage.bb5;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class wa5 implements va5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, xa5> a;
    public final ViewGroup b;
    public final eb5 c;
    public final bb5 d;
    public ViewType e;
    public xa5 f;

    public wa5(eb5 eb5Var, @NonNull ViewGroup viewGroup, @NonNull bb5 bb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eb5Var, viewGroup, bb5Var};
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
        this.c = eb5Var;
        this.d = bb5Var;
    }

    @Override // com.repackage.va5
    public void a(ViewType viewType, String str) {
        bb5.a aVar;
        bb5.b bVar;
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

    @Override // com.repackage.va5
    public void b(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewType) == null) || this.e == viewType) {
            return;
        }
        this.e = viewType;
        if (this.b == null) {
            return;
        }
        eb5 eb5Var = this.c;
        if (eb5Var != null && eb5Var.getView() != null) {
            this.c.getView().setVisibility(viewType == ViewType.CONTENT ? 0 : 8);
        }
        xa5 xa5Var = this.f;
        if (xa5Var != null) {
            xa5Var.b(this.b);
        }
        xa5 xa5Var2 = this.a.get(viewType);
        bb5.e d = d(viewType);
        if (xa5Var2 == null || d == null) {
            return;
        }
        xa5Var2.c(viewType, this.b, d);
        this.f = xa5Var2;
        this.a.put(viewType, xa5Var2);
    }

    @Override // com.repackage.va5
    public void c(ViewType viewType, @NonNull xa5 xa5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, xa5Var) == null) {
            this.a.put(viewType, xa5Var);
        }
    }

    public final bb5.e d(ViewType viewType) {
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
        return (bb5.e) invokeL.objValue;
    }

    @Override // com.repackage.va5
    public void onChangeSkinType(int i) {
        xa5 xa5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (xa5Var = this.f) == null) {
            return;
        }
        xa5Var.e(i);
    }

    @Override // com.repackage.va5
    public void onDestroy() {
        xa5 xa5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (xa5Var = this.f) == null) {
            return;
        }
        xa5Var.b(this.b);
    }
}
