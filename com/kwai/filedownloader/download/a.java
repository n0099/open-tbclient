package com.kwai.filedownloader.download;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long a;

    /* renamed from: b  reason: collision with root package name */
    public final long f58269b;

    /* renamed from: c  reason: collision with root package name */
    public final long f58270c;

    /* renamed from: d  reason: collision with root package name */
    public final long f58271d;

    public a(long j2, long j3, long j4, long j5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = j2;
        this.f58269b = j3;
        this.f58270c = j4;
        this.f58271d = j5;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwai.filedownloader.e.f.a("range[%d, %d) current offset[%d]", Long.valueOf(this.a), Long.valueOf(this.f58270c), Long.valueOf(this.f58269b)) : (String) invokeV.objValue;
    }
}
