package com.kwai.filedownloader.download;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f66902a;

    /* renamed from: b  reason: collision with root package name */
    public final long f66903b;

    /* renamed from: c  reason: collision with root package name */
    public final long f66904c;

    /* renamed from: d  reason: collision with root package name */
    public final long f66905d;

    public a(long j, long j2, long j3, long j4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66902a = j;
        this.f66903b = j2;
        this.f66904c = j3;
        this.f66905d = j4;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? com.kwai.filedownloader.f.f.a("range[%d, %d) current offset[%d]", Long.valueOf(this.f66902a), Long.valueOf(this.f66904c), Long.valueOf(this.f66903b)) : (String) invokeV.objValue;
    }
}
