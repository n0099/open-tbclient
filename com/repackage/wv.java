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
public final class wv extends at implements yv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final yt d;
    public final au e;
    public final eu f;
    public final hu g;
    public final cu h;
    public final xt i;
    public final du j;
    public final zv k;
    public final hw l;

    public /* synthetic */ wv(yt ytVar, au auVar, eu euVar, hu huVar, cu cuVar, xt xtVar, du duVar, zv zvVar, hw hwVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(ytVar, auVar, euVar, huVar, cuVar, xtVar, duVar, (i & 128) != 0 ? new aw() : zvVar, (i & 256) != 0 ? new jw() : hwVar);
    }

    @Override // com.repackage.zs
    public du a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (du) invokeV.objValue;
    }

    @Override // com.repackage.zs
    public eu b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (eu) invokeV.objValue;
    }

    @Override // com.repackage.zs
    public xt c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : (xt) invokeV.objValue;
    }

    @Override // com.repackage.yv
    public zv d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (zv) invokeV.objValue;
    }

    @Override // com.repackage.zs
    public hu e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (hu) invokeV.objValue;
    }

    @Override // com.repackage.yv
    public hw f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (hw) invokeV.objValue;
    }

    @Override // com.repackage.zs
    public au g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (au) invokeV.objValue;
    }

    @Override // com.repackage.zs
    public yt h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (yt) invokeV.objValue;
    }

    @Override // com.repackage.zs
    public cu i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h : (cu) invokeV.objValue;
    }

    public wv(yt ytVar, au auVar, eu euVar, hu huVar, cu cuVar, xt xtVar, du duVar, zv zvVar, hw hwVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ytVar, auVar, euVar, huVar, cuVar, xtVar, duVar, zvVar, hwVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = ytVar;
        this.e = auVar;
        this.f = euVar;
        this.g = huVar;
        this.h = cuVar;
        this.i = xtVar;
        this.j = duVar;
        this.k = zvVar;
        this.l = hwVar;
    }
}
