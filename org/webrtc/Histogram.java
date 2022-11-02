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

    public static native void nativeAddSample(long j, int i);

    public static native long nativeCreateCounts(String str, int i, int i2, int i3);

    public static native long nativeCreateEnumeration(String str, int i);

    public Histogram(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.handle = j;
    }

    public static Histogram createCounts(String str, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65537, null, str, i, i2, i3)) == null) {
            return new Histogram(nativeCreateCounts(str, i, i2, i3));
        }
        return (Histogram) invokeLIII.objValue;
    }

    public static Histogram createEnumeration(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            return new Histogram(nativeCreateEnumeration(str, i));
        }
        return (Histogram) invokeLI.objValue;
    }

    public void addSample(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            nativeAddSample(this.handle, i);
        }
    }
}
