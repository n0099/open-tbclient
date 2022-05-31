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
public final class st extends wq implements ut {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ur d;
    public final wr e;
    public final as f;
    public final ds g;
    public final yr h;
    public final tr i;
    public final zr j;
    public final vt k;
    public final du l;

    public /* synthetic */ st(ur urVar, wr wrVar, as asVar, ds dsVar, yr yrVar, tr trVar, zr zrVar, vt vtVar, du duVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(urVar, wrVar, asVar, dsVar, yrVar, trVar, zrVar, (i & 128) != 0 ? new wt() : vtVar, (i & 256) != 0 ? new fu() : duVar);
    }

    @Override // com.repackage.vq
    public zr a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (zr) invokeV.objValue;
    }

    @Override // com.repackage.vq
    public as b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (as) invokeV.objValue;
    }

    @Override // com.repackage.vq
    public tr c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : (tr) invokeV.objValue;
    }

    @Override // com.repackage.ut
    public vt d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (vt) invokeV.objValue;
    }

    @Override // com.repackage.vq
    public ds e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (ds) invokeV.objValue;
    }

    @Override // com.repackage.ut
    public du f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (du) invokeV.objValue;
    }

    @Override // com.repackage.vq
    public wr g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (wr) invokeV.objValue;
    }

    @Override // com.repackage.vq
    public ur h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (ur) invokeV.objValue;
    }

    @Override // com.repackage.vq
    public yr i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h : (yr) invokeV.objValue;
    }

    public st(ur urVar, wr wrVar, as asVar, ds dsVar, yr yrVar, tr trVar, zr zrVar, vt vtVar, du duVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {urVar, wrVar, asVar, dsVar, yrVar, trVar, zrVar, vtVar, duVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = urVar;
        this.e = wrVar;
        this.f = asVar;
        this.g = dsVar;
        this.h = yrVar;
        this.i = trVar;
        this.j = zrVar;
        this.k = vtVar;
        this.l = duVar;
    }
}
