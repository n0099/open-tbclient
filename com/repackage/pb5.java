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
import com.repackage.ub5;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class pb5 implements ob5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, qb5> a;
    public final ViewGroup b;
    public final xb5 c;
    public final ub5 d;
    public ViewType e;
    public qb5 f;

    public pb5(xb5 xb5Var, @NonNull ViewGroup viewGroup, @NonNull ub5 ub5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xb5Var, viewGroup, ub5Var};
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
        this.c = xb5Var;
        this.d = ub5Var;
    }

    @Override // com.repackage.ob5
    public void a(ViewType viewType, String str) {
        ub5.a aVar;
        ub5.b bVar;
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

    @Override // com.repackage.ob5
    public void b(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewType) == null) || this.e == viewType) {
            return;
        }
        this.e = viewType;
        if (this.b == null) {
            return;
        }
        xb5 xb5Var = this.c;
        if (xb5Var != null && xb5Var.getView() != null) {
            this.c.getView().setVisibility(viewType == ViewType.CONTENT ? 0 : 8);
        }
        qb5 qb5Var = this.f;
        if (qb5Var != null) {
            qb5Var.b(this.b);
        }
        qb5 qb5Var2 = this.a.get(viewType);
        ub5.e d = d(viewType);
        if (qb5Var2 == null || d == null) {
            return;
        }
        qb5Var2.c(viewType, this.b, d);
        this.f = qb5Var2;
        this.a.put(viewType, qb5Var2);
    }

    @Override // com.repackage.ob5
    public void c(ViewType viewType, @NonNull qb5 qb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, qb5Var) == null) {
            this.a.put(viewType, qb5Var);
        }
    }

    public final ub5.e d(ViewType viewType) {
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
        return (ub5.e) invokeL.objValue;
    }

    @Override // com.repackage.ob5
    public void onChangeSkinType(int i) {
        qb5 qb5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (qb5Var = this.f) == null) {
            return;
        }
        qb5Var.e(i);
    }

    @Override // com.repackage.ob5
    public void onDestroy() {
        qb5 qb5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (qb5Var = this.f) == null) {
            return;
        }
        qb5Var.b(this.b);
    }
}
