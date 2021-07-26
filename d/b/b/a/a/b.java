package d.b.b.a.a;

import android.content.Context;
import android.os.Process;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.utils.UtilsBlink;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import ms.bd.c.b;
import ms.bd.c.h;
/* loaded from: classes8.dex */
public abstract class b extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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

    @Override // ms.bd.c.b.a
    public Object a(int i2, int i3, long j, String str, Object obj) throws Throwable {
        InterceptResult invokeCommon;
        boolean z;
        Context a2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), str, obj})) == null) {
            String[] strArr = {(String) h.a(16777217, 0, 0L, "5b541d", new byte[]{37, 110, 66, 82, 1, 122, 50, 13, 116, 97, 54, 109, 79, 83, 29, 122, 57, 77, 42, 77, 10, 84, 99, 114, 32, 86, 2})};
            try {
                a2 = ms.bd.c.a.c().a();
            } catch (Throwable unused) {
            }
            for (i4 = 0; i4 < 1; i4++) {
                if (a2.checkPermission(strArr[i4], Process.myPid(), Process.myUid()) != 0) {
                    z = false;
                    break;
                }
            }
            z = true;
            if (z) {
                switch (i2) {
                    case 196609:
                        Object[] objArr = (Object[]) obj;
                        return f(str, (byte[]) objArr[0], (String) objArr[1]);
                    case 196610:
                        return g(str, (String) obj);
                    case 196611:
                        return e(str, (String) obj);
                    default:
                        return super.a(i2, i3, j, str, obj);
                }
            }
            return null;
        }
        return invokeCommon.objValue;
    }

    public void c(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream) == null) || inputStream == null) {
            return;
        }
        try {
            inputStream.close();
        } catch (IOException unused) {
            String str = (String) h.a(16777217, 0, 0L, "53717f", new byte[]{41, 50, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_2, 70, 1});
        }
    }

    public void d(OutputStream outputStream) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, outputStream) == null) || outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (IOException unused) {
            String str = (String) h.a(16777217, 0, 0L, "22a7e2", new byte[]{46, 51, UtilsBlink.VER_TYPE_SEPARATOR, 64, 85});
        }
    }

    public abstract Object[] e(String str, String str2);

    public abstract Object[] f(String str, byte[] bArr, String str2);

    public abstract Object[] g(String str, String str2);
}
