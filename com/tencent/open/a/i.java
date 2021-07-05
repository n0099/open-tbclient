package com.tencent.open.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tencent.open.a.d;
/* loaded from: classes7.dex */
public abstract class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile int f41903a;

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f41904b;

    /* renamed from: c  reason: collision with root package name */
    public h f41905c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i() {
        this(c.f41883a, true, h.f41902a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Integer) objArr[0]).intValue(), ((Boolean) objArr[1]).booleanValue(), (h) objArr[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            this.f41903a = i2;
        }
    }

    public abstract void a(int i2, Thread thread, long j, String str, String str2, Throwable th);

    public void b(int i2, Thread thread, long j, String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), thread, Long.valueOf(j), str, str2, th}) == null) && d() && d.a.a(this.f41903a, i2)) {
            a(i2, thread, j, str, str2, th);
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41904b : invokeV.booleanValue;
    }

    public h e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f41905c : (h) invokeV.objValue;
    }

    public i(int i2, boolean z, h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Boolean.valueOf(z), hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41903a = c.f41883a;
        this.f41904b = true;
        this.f41905c = h.f41902a;
        a(i2);
        a(z);
        a(hVar);
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f41904b = z;
        }
    }

    public void a(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, hVar) == null) {
            this.f41905c = hVar;
        }
    }
}
