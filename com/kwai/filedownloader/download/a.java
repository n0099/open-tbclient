package com.kwai.filedownloader.download;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f73791a;

    /* renamed from: b  reason: collision with root package name */
    public final long f73792b;

    /* renamed from: c  reason: collision with root package name */
    public final long f73793c;

    /* renamed from: d  reason: collision with root package name */
    public final long f73794d;

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
        this.f73791a = j2;
        this.f73792b = j3;
        this.f73793c = j4;
        this.f73794d = j5;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwai.filedownloader.f.f.a("range[%d, %d) current offset[%d]", Long.valueOf(this.f73791a), Long.valueOf(this.f73793c), Long.valueOf(this.f73792b)) : (String) invokeV.objValue;
    }
}
