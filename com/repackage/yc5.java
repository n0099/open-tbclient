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
import com.repackage.dd5;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class yc5 implements xc5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, zc5> a;
    public final ViewGroup b;
    public final gd5 c;
    public final dd5 d;
    public ViewType e;
    public zc5 f;

    public yc5(gd5 gd5Var, @NonNull ViewGroup viewGroup, @NonNull dd5 dd5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gd5Var, viewGroup, dd5Var};
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
        this.c = gd5Var;
        this.d = dd5Var;
    }

    @Override // com.repackage.xc5
    public void a(ViewType viewType, String str) {
        dd5.a aVar;
        dd5.b bVar;
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

    @Override // com.repackage.xc5
    public void b(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewType) == null) || this.e == viewType) {
            return;
        }
        this.e = viewType;
        if (this.b == null) {
            return;
        }
        gd5 gd5Var = this.c;
        if (gd5Var != null && gd5Var.getView() != null) {
            this.c.getView().setVisibility(viewType == ViewType.CONTENT ? 0 : 8);
        }
        zc5 zc5Var = this.f;
        if (zc5Var != null) {
            zc5Var.b(this.b);
        }
        zc5 zc5Var2 = this.a.get(viewType);
        dd5.e d = d(viewType);
        if (zc5Var2 == null || d == null) {
            return;
        }
        zc5Var2.c(viewType, this.b, d);
        this.f = zc5Var2;
        this.a.put(viewType, zc5Var2);
    }

    @Override // com.repackage.xc5
    public void c(ViewType viewType, @NonNull zc5 zc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, zc5Var) == null) {
            this.a.put(viewType, zc5Var);
        }
    }

    public final dd5.e d(ViewType viewType) {
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
        return (dd5.e) invokeL.objValue;
    }

    @Override // com.repackage.xc5
    public void onChangeSkinType(int i) {
        zc5 zc5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (zc5Var = this.f) == null) {
            return;
        }
        zc5Var.e(i);
    }

    @Override // com.repackage.xc5
    public void onDestroy() {
        zc5 zc5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (zc5Var = this.f) == null) {
            return;
        }
        zc5Var.b(this.b);
    }
}
