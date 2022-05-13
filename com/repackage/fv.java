package com.repackage;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes6.dex */
public final class fv extends js implements hv {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final ht d;
    public final jt e;
    public final nt f;
    public final qt g;
    public final lt h;
    public final gt i;
    public final mt j;
    public final iv k;
    public final qv l;

    public /* synthetic */ fv(ht htVar, jt jtVar, nt ntVar, qt qtVar, lt ltVar, gt gtVar, mt mtVar, iv ivVar, qv qvVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(htVar, jtVar, ntVar, qtVar, ltVar, gtVar, mtVar, (i & 128) != 0 ? new jv() : ivVar, (i & 256) != 0 ? new sv() : qvVar);
    }

    @Override // com.repackage.is
    public mt a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j : (mt) invokeV.objValue;
    }

    @Override // com.repackage.is
    public nt b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f : (nt) invokeV.objValue;
    }

    @Override // com.repackage.is
    public gt c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.i : (gt) invokeV.objValue;
    }

    @Override // com.repackage.hv
    public iv d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : (iv) invokeV.objValue;
    }

    @Override // com.repackage.is
    public qt e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (qt) invokeV.objValue;
    }

    @Override // com.repackage.hv
    public qv f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.l : (qv) invokeV.objValue;
    }

    @Override // com.repackage.is
    public jt g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (jt) invokeV.objValue;
    }

    @Override // com.repackage.is
    public ht h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (ht) invokeV.objValue;
    }

    @Override // com.repackage.is
    public lt i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.h : (lt) invokeV.objValue;
    }

    public fv(ht htVar, jt jtVar, nt ntVar, qt qtVar, lt ltVar, gt gtVar, mt mtVar, iv ivVar, qv qvVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {htVar, jtVar, ntVar, qtVar, ltVar, gtVar, mtVar, ivVar, qvVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = htVar;
        this.e = jtVar;
        this.f = ntVar;
        this.g = qtVar;
        this.h = ltVar;
        this.i = gtVar;
        this.j = mtVar;
        this.k = ivVar;
        this.l = qvVar;
    }
}
