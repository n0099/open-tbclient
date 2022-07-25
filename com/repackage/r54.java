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
public class r54 extends xv1<TextureMapView, um2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<q54> n;
    public List<p54> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r54(@NonNull Context context, @NonNull um2 um2Var) {
        super(context, um2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, um2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (yv1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = um2Var.c;
        this.j = um2Var.b;
        String str = um2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = um2Var.r;
    }

    public static r54 K(Context context, um2 um2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, um2Var)) == null) {
            if (context == null || um2Var == null || !um2Var.isValid()) {
                return null;
            }
            return new r54(context, um2Var);
        }
        return (r54) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (q54 q54Var : this.n) {
                this.l.removeView(q54Var.e);
            }
            this.n.clear();
            for (p54 p54Var : this.o) {
                this.l.removeView(p54Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public p54 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (p54 p54Var : this.o) {
                if (p54Var.b == view2) {
                    return p54Var;
                }
            }
            return null;
        }
        return (p54) invokeL.objValue;
    }

    @Nullable
    public q54 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (q54 q54Var : this.n) {
                if (marker == q54Var.b) {
                    return q54Var;
                }
            }
            return null;
        }
        return (q54) invokeL.objValue;
    }

    public List<q54> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (q54 q54Var : this.n) {
                cn2 cn2Var = q54Var.a;
                if (cn2Var != null && TextUtils.equals(str, cn2Var.a)) {
                    arrayList.add(q54Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.xv1
    @NonNull
    /* renamed from: J */
    public TextureMapView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? this.l : (TextureMapView) invokeL.objValue;
    }
}
