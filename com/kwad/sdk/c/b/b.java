package com.kwad.sdk.c.b;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f71640a;

    /* renamed from: b  reason: collision with root package name */
    public long f71641b;

    /* renamed from: c  reason: collision with root package name */
    public long f71642c;

    /* renamed from: d  reason: collision with root package name */
    public long f71643d;

    public b() {
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
            return "PageMonitorInfo{pageName='" + this.f71640a + ExtendedMessageFormat.QUOTE + ", pageLaunchTime=" + this.f71641b + ", pageCreateTime=" + this.f71642c + ", pageResumeTime=" + this.f71643d + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
