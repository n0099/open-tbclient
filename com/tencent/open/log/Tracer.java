package com.tencent.open.log;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.log.d;
/* loaded from: classes10.dex */
public abstract class Tracer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f76725a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f76726b;

    /* renamed from: c  reason: collision with root package name */
    public g f76727c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Tracer() {
        this(c.f76748a, true, g.f76764a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Boolean) objArr[1]).booleanValue(), (g) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(int i2, Thread thread, long j2, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), thread, Long.valueOf(j2), str, str2, th}) == null) && d() && d.a.a(this.f76725a, i2)) {
            doTrace(i2, thread, j2, str, str2, th);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f76726b : invokeV.booleanValue;
    }

    public abstract void doTrace(int i2, Thread thread, long j2, String str, String str2, Throwable th);

    public g e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f76727c : (g) invokeV.objValue;
    }

    public Tracer(int i2, boolean z, g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), gVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f76725a = c.f76748a;
        this.f76726b = true;
        this.f76727c = g.f76764a;
        a(i2);
        a(z);
        a(gVar);
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f76725a = i2;
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f76726b = z;
        }
    }

    public void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            this.f76727c = gVar;
        }
    }
}
