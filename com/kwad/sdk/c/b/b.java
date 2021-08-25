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
    public String f71106a;

    /* renamed from: b  reason: collision with root package name */
    public long f71107b;

    /* renamed from: c  reason: collision with root package name */
    public long f71108c;

    /* renamed from: d  reason: collision with root package name */
    public long f71109d;

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
            return "PageMonitorInfo{pageName='" + this.f71106a + ExtendedMessageFormat.QUOTE + ", pageLaunchTime=" + this.f71107b + ", pageCreateTime=" + this.f71108c + ", pageResumeTime=" + this.f71109d + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
