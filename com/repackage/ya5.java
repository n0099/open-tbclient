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
import com.repackage.db5;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class ya5 implements xa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, za5> a;
    public final ViewGroup b;
    public final gb5 c;
    public final db5 d;
    public ViewType e;
    public za5 f;

    public ya5(gb5 gb5Var, @NonNull ViewGroup viewGroup, @NonNull db5 db5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gb5Var, viewGroup, db5Var};
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
        this.c = gb5Var;
        this.d = db5Var;
    }

    @Override // com.repackage.xa5
    public void a(ViewType viewType, String str) {
        db5.a aVar;
        db5.b bVar;
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

    @Override // com.repackage.xa5
    public void b(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewType) == null) || this.e == viewType) {
            return;
        }
        this.e = viewType;
        if (this.b == null) {
            return;
        }
        gb5 gb5Var = this.c;
        if (gb5Var != null && gb5Var.getView() != null) {
            this.c.getView().setVisibility(viewType == ViewType.CONTENT ? 0 : 8);
        }
        za5 za5Var = this.f;
        if (za5Var != null) {
            za5Var.b(this.b);
        }
        za5 za5Var2 = this.a.get(viewType);
        db5.e d = d(viewType);
        if (za5Var2 == null || d == null) {
            return;
        }
        za5Var2.c(viewType, this.b, d);
        this.f = za5Var2;
        this.a.put(viewType, za5Var2);
    }

    @Override // com.repackage.xa5
    public void c(ViewType viewType, @NonNull za5 za5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, za5Var) == null) {
            this.a.put(viewType, za5Var);
        }
    }

    public final db5.e d(ViewType viewType) {
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
        return (db5.e) invokeL.objValue;
    }

    @Override // com.repackage.xa5
    public void onChangeSkinType(int i) {
        za5 za5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (za5Var = this.f) == null) {
            return;
        }
        za5Var.e(i);
    }

    @Override // com.repackage.xa5
    public void onDestroy() {
        za5 za5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (za5Var = this.f) == null) {
            return;
        }
        za5Var.b(this.b);
    }
}
