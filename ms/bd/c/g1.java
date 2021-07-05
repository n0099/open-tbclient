package ms.bd.c;

import android.content.Context;
import com.baidu.searchbox.logsystem.basic.upload.LogSystemUploaderStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import io.flutter.plugin.common.StandardMessageCodec;
import java.lang.reflect.Method;
import ms.bd.c.b;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes10.dex */
public final class g1 extends b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g1() {
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
    public Object b(int i2, long j, String str, Object obj) throws Throwable {
        InterceptResult invokeCommon;
        double d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j), str, obj})) == null) {
            Context c2 = a.a().c();
            try {
                Class<?> cls = Class.forName(new String(c0.b((String) h.a(16777217, 0, 0L, "28f78d", new byte[]{LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 105, 67, 69, 81, 119, 99, 28, 97, 54, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 63, 67, 23, 80, PublicSuffixDatabase.EXCEPTION_MARKER, 103, 31, 97, 62, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 110, 71, 70, 81, 42, 103, 28, 96, 51, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 111, 66, 17, 81, 118, 103, 72, 97, 100, 113, 63, 67, 69, 80, 32, 99, 28, 98, 55, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 60, 66, 20, 81, 38, 102, 75, 98, 55, 116, 104, 67, 69, 81, 37, 103, 64, 97, 100, LogSystemUploaderStrategy.ContentUtil.GZIP_HEAD_1, 111}))));
                Object newInstance = cls.getConstructor(Context.class).newInstance(c2);
                Method declaredMethod = cls.getDeclaredMethod(new String(c0.b((String) h.a(16777217, 0, 0L, "6d882d", new byte[]{113, 49, 29, 25, 90, 39, 97, 20, 62, 62, 113, 51, 28, 30, 91, 34, 99, 18, 63, 61, 114, 54, 29, 74, 90, 36, 99, 16, 62, 58}))), String.class);
                declaredMethod.setAccessible(true);
                Object[] objArr = new Object[1];
                objArr[0] = new String(c0.b((String) h.a(16777217, 0, 0L, "eb2fdb", new byte[]{34, 50, 23, 67, StandardMessageCodec.LIST, PublicSuffixDatabase.EXCEPTION_MARKER, 49, 23, 53, 99, Base64.INTERNAL_PADDING, 50, 22, 75, 9, 112, 48, 16, 53, 103, Base64.INTERNAL_PADDING, 48, 23, 67, 13, 38, 48, 26, 52, 98, Base64.INTERNAL_PADDING, 57})));
                d2 = ((Double) declaredMethod.invoke(newInstance, objArr)).doubleValue();
            } catch (Throwable unused) {
                d2 = 0.0d;
            }
            return Integer.toString((int) d2);
        }
        return invokeCommon.objValue;
    }
}
