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
import com.repackage.fc5;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ac5 implements zb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<ViewType, bc5> a;
    public final ViewGroup b;
    public final ic5 c;
    public final fc5 d;
    public ViewType e;
    public bc5 f;

    public ac5(ic5 ic5Var, @NonNull ViewGroup viewGroup, @NonNull fc5 fc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ic5Var, viewGroup, fc5Var};
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
        this.c = ic5Var;
        this.d = fc5Var;
    }

    @Override // com.repackage.zb5
    public void a(ViewType viewType, String str) {
        fc5.a aVar;
        fc5.b bVar;
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

    @Override // com.repackage.zb5
    public void b(ViewType viewType) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewType) == null) || this.e == viewType) {
            return;
        }
        this.e = viewType;
        if (this.b == null) {
            return;
        }
        ic5 ic5Var = this.c;
        if (ic5Var != null && ic5Var.getView() != null) {
            this.c.getView().setVisibility(viewType == ViewType.CONTENT ? 0 : 8);
        }
        bc5 bc5Var = this.f;
        if (bc5Var != null) {
            bc5Var.b(this.b);
        }
        bc5 bc5Var2 = this.a.get(viewType);
        fc5.e d = d(viewType);
        if (bc5Var2 == null || d == null) {
            return;
        }
        bc5Var2.c(viewType, this.b, d);
        this.f = bc5Var2;
        this.a.put(viewType, bc5Var2);
    }

    @Override // com.repackage.zb5
    public void c(ViewType viewType, @NonNull bc5 bc5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewType, bc5Var) == null) {
            this.a.put(viewType, bc5Var);
        }
    }

    public final fc5.e d(ViewType viewType) {
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
        return (fc5.e) invokeL.objValue;
    }

    @Override // com.repackage.zb5
    public void onChangeSkinType(int i) {
        bc5 bc5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048580, this, i) == null) || (bc5Var = this.f) == null) {
            return;
        }
        bc5Var.e(i);
    }

    @Override // com.repackage.zb5
    public void onDestroy() {
        bc5 bc5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (bc5Var = this.f) == null) {
            return;
        }
        bc5Var.b(this.b);
    }
}
