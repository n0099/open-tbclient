package d.l.a.e.b.m;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.l.a.e.b.g.s;
/* loaded from: classes8.dex */
public class p implements s {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long[] f71981a;

    public p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f71981a = b(str);
    }

    @Override // d.l.a.e.b.g.s
    public long a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            long[] jArr = this.f71981a;
            if (jArr == null || jArr.length <= 0) {
                return 0L;
            }
            int i4 = i2 - 1;
            if (i4 < 0) {
                i4 = 0;
            }
            long[] jArr2 = this.f71981a;
            if (i4 > jArr2.length - 1) {
                i4 = jArr2.length - 1;
            }
            return this.f71981a[i4];
        }
        return invokeII.longValue;
    }

    public final long[] b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                String[] split = str.split(",");
                if (split.length == 0) {
                    return null;
                }
                long[] jArr = new long[split.length];
                for (int i2 = 0; i2 < split.length; i2++) {
                    jArr[i2] = Long.parseLong(split[i2]);
                }
                return jArr;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return (long[]) invokeL.objValue;
    }
}
