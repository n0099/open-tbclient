package com.kwad.sdk.core.network.b;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f72322a;

    /* renamed from: b  reason: collision with root package name */
    public long f72323b;

    /* renamed from: c  reason: collision with root package name */
    public long f72324c;

    /* renamed from: d  reason: collision with root package name */
    public long f72325d;

    /* renamed from: e  reason: collision with root package name */
    public long f72326e;

    /* renamed from: f  reason: collision with root package name */
    public String f72327f;

    /* renamed from: g  reason: collision with root package name */
    public String f72328g;

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
            return "NetworkMonitorInfo{requestTotalTime=" + this.f72322a + ", mRequestCreateTime" + this.f72323b + ", requestResponseTime=" + this.f72324c + ", requestParseDataTime=" + this.f72325d + ", requestCallbackTime=" + this.f72326e + ", requestFailReason='" + this.f72327f + ExtendedMessageFormat.QUOTE + ", requestUrl='" + this.f72328g + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
