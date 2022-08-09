package com.tencent.mm.opensdk.channel.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(String str, int i, String str2) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65536, null, str, i, str2)) == null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (str != null) {
                stringBuffer.append(str);
            }
            stringBuffer.append(i);
            stringBuffer.append(str2);
            stringBuffer.append("mMcShCsTr");
            return com.tencent.mm.opensdk.utils.b.c(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
        }
        return (byte[]) invokeLIL.objValue;
    }
}
