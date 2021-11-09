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
    public long f64783a;

    /* renamed from: b  reason: collision with root package name */
    public long f64784b;

    /* renamed from: c  reason: collision with root package name */
    public long f64785c;

    /* renamed from: d  reason: collision with root package name */
    public long f64786d;

    /* renamed from: e  reason: collision with root package name */
    public long f64787e;

    /* renamed from: f  reason: collision with root package name */
    public String f64788f;

    /* renamed from: g  reason: collision with root package name */
    public String f64789g;

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
            return "NetworkMonitorInfo{requestTotalTime=" + this.f64783a + ", mRequestCreateTime" + this.f64784b + ", requestResponseTime=" + this.f64785c + ", requestParseDataTime=" + this.f64786d + ", requestCallbackTime=" + this.f64787e + ", requestFailReason='" + this.f64788f + ExtendedMessageFormat.QUOTE + ", requestUrl='" + this.f64789g + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
