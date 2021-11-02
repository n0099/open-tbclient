package com.tencent.mm.sdk.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(String str, int i2, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, str, i2, str2)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (str != null) {
                stringBuffer.append(str);
            }
            stringBuffer.append(i2);
            stringBuffer.append(str2);
            stringBuffer.append("mMcShCsTr");
            return com.tencent.mm.a.a.a(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
        }
        return (byte[]) invokeLIL.objValue;
    }
}
