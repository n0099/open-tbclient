package com.kwad.sdk.core.videocache;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes10.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final String f72746a;

    /* renamed from: b  reason: collision with root package name */
    public final long f72747b;

    /* renamed from: c  reason: collision with root package name */
    public final String f72748c;

    public n(String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j2), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72746a = str;
        this.f72747b = j2;
        this.f72748c = str2;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return "SourceInfo{url='" + this.f72746a + ExtendedMessageFormat.QUOTE + ", length=" + this.f72747b + ", mime='" + this.f72748c + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }
}
