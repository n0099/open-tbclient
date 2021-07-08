package org.webrtc;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class Histogram {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final long handle;

    public Histogram(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.handle = j;
    }

    public static Histogram createCounts(String str, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIII = interceptable.invokeLIII(65537, null, str, i2, i3, i4)) == null) ? new Histogram(nativeCreateCounts(str, i2, i3, i4)) : (Histogram) invokeLIII.objValue;
    }

    public static Histogram createEnumeration(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) ? new Histogram(nativeCreateEnumeration(str, i2)) : (Histogram) invokeLI.objValue;
    }

    public static native void nativeAddSample(long j, int i2);

    public static native long nativeCreateCounts(String str, int i2, int i3, int i4);

    public static native long nativeCreateEnumeration(String str, int i2);

    public void addSample(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            nativeAddSample(this.handle, i2);
        }
    }
}
