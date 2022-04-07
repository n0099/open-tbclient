package com.repackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.TextureMapView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class t54 extends yv1<TextureMapView, vm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<s54> n;
    public List<r54> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t54(@NonNull Context context, @NonNull vm2 vm2Var) {
        super(context, vm2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, vm2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (zv1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = vm2Var.c;
        this.j = vm2Var.b;
        String str = vm2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = vm2Var.r;
    }

    public static t54 K(Context context, vm2 vm2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, vm2Var)) == null) {
            if (context == null || vm2Var == null || !vm2Var.isValid()) {
                return null;
            }
            return new t54(context, vm2Var);
        }
        return (t54) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (s54 s54Var : this.n) {
                this.l.removeView(s54Var.e);
            }
            this.n.clear();
            for (r54 r54Var : this.o) {
                this.l.removeView(r54Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public r54 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (r54 r54Var : this.o) {
                if (r54Var.b == view2) {
                    return r54Var;
                }
            }
            return null;
        }
        return (r54) invokeL.objValue;
    }

    @Nullable
    public s54 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (s54 s54Var : this.n) {
                if (marker == s54Var.b) {
                    return s54Var;
                }
            }
            return null;
        }
        return (s54) invokeL.objValue;
    }

    public List<s54> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (s54 s54Var : this.n) {
                dn2 dn2Var = s54Var.a;
                if (dn2Var != null && TextUtils.equals(str, dn2Var.a)) {
                    arrayList.add(s54Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.yv1
    @NonNull
    /* renamed from: J */
    public TextureMapView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? this.l : (TextureMapView) invokeL.objValue;
    }
}
