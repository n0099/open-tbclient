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
public class d64 extends jw1<TextureMapView, gn2> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String i;
    public String j;
    public boolean k;
    @NonNull
    public TextureMapView l;
    public Context m;
    public List<c64> n;
    public List<b64> o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d64(@NonNull Context context, @NonNull gn2 gn2Var) {
        super(context, gn2Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, gn2Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (kw1) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.i = gn2Var.c;
        this.j = gn2Var.b;
        String str = gn2Var.d;
        this.m = context;
        this.l = new TextureMapView(context);
        this.k = gn2Var.r;
    }

    public static d64 K(Context context, gn2 gn2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, gn2Var)) == null) {
            if (context == null || gn2Var == null || !gn2Var.isValid()) {
                return null;
            }
            return new d64(context, gn2Var);
        }
        return (d64) invokeLL.objValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (c64 c64Var : this.n) {
                this.l.removeView(c64Var.e);
            }
            this.n.clear();
            for (b64 b64Var : this.o) {
                this.l.removeView(b64Var.b);
            }
            this.o.clear();
            this.l.getMap().clear();
        }
    }

    public b64 G(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            for (b64 b64Var : this.o) {
                if (b64Var.b == view2) {
                    return b64Var;
                }
            }
            return null;
        }
        return (b64) invokeL.objValue;
    }

    @Nullable
    public c64 H(Marker marker) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, marker)) == null) {
            for (c64 c64Var : this.n) {
                if (marker == c64Var.b) {
                    return c64Var;
                }
            }
            return null;
        }
        return (c64) invokeL.objValue;
    }

    public List<c64> I(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            ArrayList arrayList = new ArrayList(1);
            for (c64 c64Var : this.n) {
                on2 on2Var = c64Var.a;
                if (on2Var != null && TextUtils.equals(str, on2Var.a)) {
                    arrayList.add(c64Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.jw1
    @NonNull
    /* renamed from: J */
    public TextureMapView v(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) ? this.l : (TextureMapView) invokeL.objValue;
    }
}
