package com.kwad.sdk.core.network.b;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f34656a;

    /* renamed from: b  reason: collision with root package name */
    public long f34657b;

    /* renamed from: c  reason: collision with root package name */
    public long f34658c;

    /* renamed from: d  reason: collision with root package name */
    public long f34659d;

    /* renamed from: e  reason: collision with root package name */
    public long f34660e;

    /* renamed from: f  reason: collision with root package name */
    public String f34661f;

    /* renamed from: g  reason: collision with root package name */
    public String f34662g;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "NetworkMonitorInfo{requestTotalTime=" + this.f34656a + ", mRequestCreateTime" + this.f34657b + ", requestResponseTime=" + this.f34658c + ", requestParseDataTime=" + this.f34659d + ", requestCallbackTime=" + this.f34660e + ", requestFailReason='" + this.f34661f + "', requestUrl='" + this.f34662g + "'}";
        }
        return (String) invokeV.objValue;
    }
}
