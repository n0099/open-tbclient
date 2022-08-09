package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes7.dex */
public final class xt extends br implements zt {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final zr d;
    public final bs e;
    public final fs f;
    public final is g;
    public final ds h;
    public final yr i;
    public final es j;
    public final au k;
    public final iu l;

    public /* synthetic */ xt(zr zrVar, bs bsVar, fs fsVar, is isVar, ds dsVar, yr yrVar, es esVar, au auVar, iu iuVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(zrVar, bsVar, fsVar, isVar, dsVar, yrVar, esVar, (i & 128) != 0 ? new bu() : auVar, (i & 256) != 0 ? new ku() : iuVar);
    }

    @Override // com.repackage.ar
    public es a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (es) invokeV.objValue;
    }

    @Override // com.repackage.ar
    public fs b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (fs) invokeV.objValue;
    }

    @Override // com.repackage.ar
    public yr c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : (yr) invokeV.objValue;
    }

    @Override // com.repackage.zt
    public au d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (au) invokeV.objValue;
    }

    @Override // com.repackage.ar
    public is e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (is) invokeV.objValue;
    }

    @Override // com.repackage.zt
    public iu f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (iu) invokeV.objValue;
    }

    @Override // com.repackage.ar
    public bs g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (bs) invokeV.objValue;
    }

    @Override // com.repackage.ar
    public zr h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (zr) invokeV.objValue;
    }

    @Override // com.repackage.ar
    public ds i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h : (ds) invokeV.objValue;
    }

    public xt(zr zrVar, bs bsVar, fs fsVar, is isVar, ds dsVar, yr yrVar, es esVar, au auVar, iu iuVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zrVar, bsVar, fsVar, isVar, dsVar, yrVar, esVar, auVar, iuVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = zrVar;
        this.e = bsVar;
        this.f = fsVar;
        this.g = isVar;
        this.h = dsVar;
        this.i = yrVar;
        this.j = esVar;
        this.k = auVar;
        this.l = iuVar;
    }
}
