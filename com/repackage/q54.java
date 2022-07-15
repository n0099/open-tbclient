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
public class q54 extends wv1<TextureMapView, tm2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<p54> n;
    public List<o54> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q54(@NonNull Context context, @NonNull tm2 tm2Var) {
        super(context, tm2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tm2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (xv1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = tm2Var.c;
        this.j = tm2Var.b;
        String str = tm2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = tm2Var.r;
    }

    public static q54 K(Context context, tm2 tm2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, tm2Var)) == null) {
            if (context == null || tm2Var == null || !tm2Var.isValid()) {
                return null;
            }
            return new q54(context, tm2Var);
        }
        return (q54) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (p54 p54Var : this.n) {
                this.l.removeView(p54Var.e);
            }
            this.n.clear();
            for (o54 o54Var : this.o) {
                this.l.removeView(o54Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public o54 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (o54 o54Var : this.o) {
                if (o54Var.b == view2) {
                    return o54Var;
                }
            }
            return null;
        }
        return (o54) invokeL.objValue;
    }

    @Nullable
    public p54 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (p54 p54Var : this.n) {
                if (marker == p54Var.b) {
                    return p54Var;
                }
            }
            return null;
        }
        return (p54) invokeL.objValue;
    }

    public List<p54> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (p54 p54Var : this.n) {
                bn2 bn2Var = p54Var.a;
                if (bn2Var != null && TextUtils.equals(str, bn2Var.a)) {
                    arrayList.add(p54Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wv1
    @NonNull
    /* renamed from: J */
    public TextureMapView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? this.l : (TextureMapView) invokeL.objValue;
    }
}
