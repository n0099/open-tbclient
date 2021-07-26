package d.a.m0.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.m0.l.f;
import d.a.m0.l.g;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static String f43578b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f43579a;

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f43579a = d.a.m0.b.b.f43440a;
    }

    public static synchronized e a(Context context) {
        InterceptResult invokeL;
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (e.class) {
                eVar = new e(context);
            }
            return eVar;
        }
        return (e) invokeL.objValue;
    }

    public String b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            String str3 = d.a.m0.a.f43422b;
            String str4 = d.a.m0.a.f43423c;
            String str5 = "";
            if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) {
                return "";
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            StringBuilder sb = new StringBuilder();
            try {
                str5 = c(str3, str4, currentTimeMillis);
            } catch (Throwable th) {
                d.a.m0.l.c.d(th);
            }
            sb.append(f());
            sb.append(str);
            sb.append("/");
            sb.append("100");
            sb.append("/");
            sb.append(str3);
            sb.append("/");
            sb.append(currentTimeMillis);
            sb.append("/");
            sb.append(str5);
            sb.append("?skey=");
            sb.append(str2);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public String c(String str, String str2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Long.valueOf(j)})) == null) {
            try {
                return g.b(str + j + str2);
            } catch (Throwable th) {
                d.a.m0.l.c.d(th);
                return "";
            }
        }
        return (String) invokeCommon.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                f43578b = new String(d.a.m0.l.e.e(Base64.decode(this.f43579a, 0), "30212102dicudiab".getBytes("utf-8")));
            } catch (Throwable th) {
                d.a.m0.l.c.d(th);
            }
        }
    }

    public byte[] e(byte[] bArr, String str) {
        InterceptResult invokeLL;
        byte[] bArr2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, bArr, str)) == null) {
            try {
                bArr2 = f.b(str.getBytes("utf-8"));
            } catch (Throwable th) {
                d.a.m0.l.c.d(th);
                bArr2 = null;
            }
            return d.a.m0.l.e.f(bArr2, bArr);
        }
        return (byte[]) invokeLL.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (TextUtils.isEmpty(f43578b)) {
                d();
            }
            return f43578b;
        }
        return (String) invokeV.objValue;
    }
}
