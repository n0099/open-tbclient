package com.kwad.sdk.core.network.b;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f65696a;

    /* renamed from: b  reason: collision with root package name */
    public long f65697b;

    /* renamed from: c  reason: collision with root package name */
    public long f65698c;

    /* renamed from: d  reason: collision with root package name */
    public long f65699d;

    /* renamed from: e  reason: collision with root package name */
    public long f65700e;

    /* renamed from: f  reason: collision with root package name */
    public String f65701f;

    /* renamed from: g  reason: collision with root package name */
    public String f65702g;

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
            return "NetworkMonitorInfo{requestTotalTime=" + this.f65696a + ", mRequestCreateTime" + this.f65697b + ", requestResponseTime=" + this.f65698c + ", requestParseDataTime=" + this.f65699d + ", requestCallbackTime=" + this.f65700e + ", requestFailReason='" + this.f65701f + ExtendedMessageFormat.QUOTE + ", requestUrl='" + this.f65702g + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
