package com.kwad.sdk.core.network.a;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f58074b;

    /* renamed from: c  reason: collision with root package name */
    public long f58075c;

    /* renamed from: d  reason: collision with root package name */
    public long f58076d;

    /* renamed from: e  reason: collision with root package name */
    public long f58077e;

    /* renamed from: f  reason: collision with root package name */
    public String f58078f;

    /* renamed from: g  reason: collision with root package name */
    public String f58079g;

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
            return "NetworkMonitorInfo{requestTotalTime=" + this.a + ", mRequestCreateTime" + this.f58074b + ", requestResponseTime=" + this.f58075c + ", requestParseDataTime=" + this.f58076d + ", requestCallbackTime=" + this.f58077e + ", requestFailReason='" + this.f58078f + ExtendedMessageFormat.QUOTE + ", requestUrl='" + this.f58079g + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
