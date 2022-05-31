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
/* loaded from: classes6.dex */
public class q44 extends wu1<TextureMapView, tl2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<p44> n;
    public List<o44> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q44(@NonNull Context context, @NonNull tl2 tl2Var) {
        super(context, tl2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, tl2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (xu1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = tl2Var.c;
        this.j = tl2Var.b;
        String str = tl2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = tl2Var.r;
    }

    public static q44 K(Context context, tl2 tl2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, tl2Var)) == null) {
            if (context == null || tl2Var == null || !tl2Var.isValid()) {
                return null;
            }
            return new q44(context, tl2Var);
        }
        return (q44) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (p44 p44Var : this.n) {
                this.l.removeView(p44Var.e);
            }
            this.n.clear();
            for (o44 o44Var : this.o) {
                this.l.removeView(o44Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public o44 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (o44 o44Var : this.o) {
                if (o44Var.b == view2) {
                    return o44Var;
                }
            }
            return null;
        }
        return (o44) invokeL.objValue;
    }

    @Nullable
    public p44 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (p44 p44Var : this.n) {
                if (marker == p44Var.b) {
                    return p44Var;
                }
            }
            return null;
        }
        return (p44) invokeL.objValue;
    }

    public List<p44> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (p44 p44Var : this.n) {
                bm2 bm2Var = p44Var.a;
                if (bm2Var != null && TextUtils.equals(str, bm2Var.a)) {
                    arrayList.add(p44Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.wu1
    @NonNull
    /* renamed from: J */
    public TextureMapView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? this.l : (TextureMapView) invokeL.objValue;
    }
}
