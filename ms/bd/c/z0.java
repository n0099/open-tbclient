package ms.bd.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import ms.bd.c.b;
/* loaded from: classes2.dex */
public final class z0 extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public z0() {
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
    public Object b(int i2, long j2, String str, Object obj) throws Throwable {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2), str, obj})) == null) {
            Context a2 = a.c().a();
            if (a2 != null) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) a2.getSystemService((String) h.a(16777217, 0, 0L, "e96af6", new byte[]{119, 52, 75, 27, 92, 34, 114, 17, 113, 56, 96, 34}));
                    Method declaredMethod = connectivityManager.getClass().getDeclaredMethod((String) h.a(16777217, 0, 0L, "4f6a44", new byte[]{34, 97, 81, 52, 8, 55, 62, 81, 98, 31, 32, 112, 82, 26, 25, 40, 30, 73, 97, 62}), new Class[0]);
                    declaredMethod.setAccessible(true);
                    NetworkInfo networkInfo = (NetworkInfo) declaredMethod.invoke(connectivityManager, new Object[0]);
                    if (networkInfo != null) {
                        Method declaredMethod2 = networkInfo.getClass().getDeclaredMethod((String) h.a(16777217, 0, 0L, "6d119b", new byte[]{46, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 99, 83, 7, 124, 57, 68, 98, 109, 34}), new Class[0]);
                        declaredMethod2.setAccessible(true);
                        return Boolean.valueOf(((Boolean) declaredMethod2.invoke(networkInfo, new Object[0])).booleanValue());
                    }
                } catch (Throwable unused) {
                }
            }
            return Boolean.FALSE;
        }
        return invokeCommon.objValue;
    }
}
