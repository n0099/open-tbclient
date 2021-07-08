package ms.bd.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import ms.bd.c.m1;
/* loaded from: classes9.dex */
public final class l1 implements m1.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f73098a;

    /* renamed from: b  reason: collision with root package name */
    public Context f73099b;

    /* renamed from: c  reason: collision with root package name */
    public e0 f73100c;

    public l1(e0 e0Var, Context context, long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e0Var, context, Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (e0Var == null) {
            throw new NullPointerException("config could not be null");
        }
        if (context == null) {
            throw new NullPointerException("context could not be null");
        }
        this.f73100c = e0Var;
        this.f73099b = context.getApplicationContext();
        this.f73098a = j;
    }

    @Override // ms.bd.c.m1.a
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || this.f73098a == -1 || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(InputDeviceCompat.SOURCE_HDMI, 0, this.f73098a, str, this.f73099b);
    }

    @Override // ms.bd.c.m1.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j = this.f73098a;
            return j != -1 ? (String) b.a(33554439, 0, j, null, null) : "";
        }
        return (String) invokeV.objValue;
    }

    @Override // ms.bd.c.m1.a
    public Map<String, String> c(String str, byte[] bArr) {
        InterceptResult invokeLL;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, bArr)) == null) {
            HashMap hashMap = new HashMap();
            if (str != null && str.length() != 0 && (strArr = (String[]) b.a(33554438, 0, this.f73098a, str, bArr)) != null && strArr.length % 2 == 0) {
                for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                    String str2 = strArr[i2];
                    String str3 = strArr[i2 + 1];
                    if (str2 != null && str3 != null) {
                        hashMap.put(str2, str3);
                    }
                }
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    @Override // ms.bd.c.m1.a
    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f73100c.f73083c = str;
            long j = this.f73098a;
            if (j != -1) {
                b.a(33554434, 0, j, str, this.f73099b);
            }
        }
    }
}
