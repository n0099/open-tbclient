package ms.bd.c;

import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.Base64;
import io.flutter.plugin.common.StandardMessageCodec;
import kotlin.jvm.internal.ByteCompanionObject;
/* loaded from: classes10.dex */
public final class b0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? b((String) h.a(16777217, 0, 0L, "ccae52", new byte[]{113, 110, 31, 95, 8, 60, 116, 71, 52, 52, 124, 98, 23, 95, 30, 49, 110, 71, 36, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 70, 85, 60, 20, 30, StandardMessageCodec.LIST, 110, 75, 36})) : invokeV.booleanValue;
    }

    public static boolean b(String... strArr) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, strArr)) == null) {
            boolean z2 = true;
            for (String str : strArr) {
                try {
                    Class.forName(str);
                    z = true;
                } catch (Exception unused) {
                    z = false;
                }
                z2 &= z;
                if (!z2) {
                    break;
                }
            }
            return z2;
        }
        return invokeL.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b((String) h.a(16777217, 0, 0L, "1b993c", new byte[]{Base64.INTERNAL_PADDING, 111, 71, 3, 14, 109, 38, 70, 108, 104, 46, 99, 79, 3, 10, 102, 51, 78, ByteCompanionObject.MAX_VALUE, 102, 50, 107, 4, 78, 3, 102, 55, 13, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 109, 43, 109, 69, 67, 5, 96, 61, 81, 38, 90, 4, 75, 103, 66, 2, 125, 38, 76, 122, 92, 52, 105, 70, 94})) : invokeV.booleanValue;
    }
}
