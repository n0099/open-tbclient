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
    public long f34845a;

    /* renamed from: b  reason: collision with root package name */
    public long f34846b;

    /* renamed from: c  reason: collision with root package name */
    public long f34847c;

    /* renamed from: d  reason: collision with root package name */
    public long f34848d;

    /* renamed from: e  reason: collision with root package name */
    public long f34849e;

    /* renamed from: f  reason: collision with root package name */
    public String f34850f;

    /* renamed from: g  reason: collision with root package name */
    public String f34851g;

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
            return "NetworkMonitorInfo{requestTotalTime=" + this.f34845a + ", mRequestCreateTime" + this.f34846b + ", requestResponseTime=" + this.f34847c + ", requestParseDataTime=" + this.f34848d + ", requestCallbackTime=" + this.f34849e + ", requestFailReason='" + this.f34850f + "', requestUrl='" + this.f34851g + "'}";
        }
        return (String) invokeV.objValue;
    }
}
