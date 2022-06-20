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
/* loaded from: classes5.dex */
public class b54 extends hv1<TextureMapView, em2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<a54> n;
    public List<z44> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b54(@NonNull Context context, @NonNull em2 em2Var) {
        super(context, em2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, em2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (iv1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = em2Var.c;
        this.j = em2Var.b;
        String str = em2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = em2Var.r;
    }

    public static b54 K(Context context, em2 em2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, em2Var)) == null) {
            if (context == null || em2Var == null || !em2Var.isValid()) {
                return null;
            }
            return new b54(context, em2Var);
        }
        return (b54) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (a54 a54Var : this.n) {
                this.l.removeView(a54Var.e);
            }
            this.n.clear();
            for (z44 z44Var : this.o) {
                this.l.removeView(z44Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public z44 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (z44 z44Var : this.o) {
                if (z44Var.b == view2) {
                    return z44Var;
                }
            }
            return null;
        }
        return (z44) invokeL.objValue;
    }

    @Nullable
    public a54 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (a54 a54Var : this.n) {
                if (marker == a54Var.b) {
                    return a54Var;
                }
            }
            return null;
        }
        return (a54) invokeL.objValue;
    }

    public List<a54> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (a54 a54Var : this.n) {
                mm2 mm2Var = a54Var.a;
                if (mm2Var != null && TextUtils.equals(str, mm2Var.a)) {
                    arrayList.add(a54Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.hv1
    @NonNull
    /* renamed from: J */
    public TextureMapView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? this.l : (TextureMapView) invokeL.objValue;
    }
}
