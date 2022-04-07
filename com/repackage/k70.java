package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes6.dex */
public final class k70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, bArr)) == null) {
            byte[] bArr2 = null;
            if (bArr != null) {
                try {
                    if (bArr.length > 0) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        gZIPOutputStream.write(bArr);
                        gZIPOutputStream.finish();
                        gZIPOutputStream.close();
                        bArr2 = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        return bArr2;
                    }
                    return null;
                } catch (IOException e) {
                    e.printStackTrace();
                    return bArr2;
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
