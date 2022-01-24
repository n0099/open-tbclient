package com.ta.utdid2.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] getBytes(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            byte[] bArr = {(byte) ((r4 >> 8) % 256), (byte) (r4 % 256), (byte) (r4 % 256), (byte) (i2 % 256)};
            int i3 = i2 >> 8;
            int i4 = i3 >> 8;
            return bArr;
        }
        return (byte[]) invokeI.objValue;
    }
}
