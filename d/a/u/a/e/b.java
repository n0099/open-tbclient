package d.a.u.a.e;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes9.dex */
public final class b {
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
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return bArr2;
                }
            }
            return null;
        }
        return (byte[]) invokeL.objValue;
    }
}
