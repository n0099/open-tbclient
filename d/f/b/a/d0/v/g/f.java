package d.f.b.a.d0.v.g;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.i0.u;
/* loaded from: classes8.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f69970a;

    /* renamed from: b  reason: collision with root package name */
    public final long f69971b;

    /* renamed from: c  reason: collision with root package name */
    public final String f69972c;

    /* renamed from: d  reason: collision with root package name */
    public int f69973d;

    public f(String str, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69972c = str == null ? "" : str;
        this.f69970a = j;
        this.f69971b = j2;
    }

    public f a(f fVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, str)) == null) {
            String c2 = c(str);
            if (fVar != null && c2.equals(fVar.c(str))) {
                long j = this.f69971b;
                if (j != -1) {
                    long j2 = this.f69970a;
                    if (j2 + j == fVar.f69970a) {
                        long j3 = fVar.f69971b;
                        return new f(c2, j2, j3 != -1 ? j + j3 : -1L);
                    }
                }
                long j4 = fVar.f69971b;
                if (j4 != -1) {
                    long j5 = fVar.f69970a;
                    if (j5 + j4 == this.f69970a) {
                        long j6 = this.f69971b;
                        return new f(c2, j5, j6 != -1 ? j4 + j6 : -1L);
                    }
                }
            }
            return null;
        }
        return (f) invokeLL.objValue;
    }

    public Uri b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? u.d(str, this.f69972c) : (Uri) invokeL.objValue;
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? u.c(str, this.f69972c) : (String) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.f69970a == fVar.f69970a && this.f69971b == fVar.f69971b && this.f69972c.equals(fVar.f69972c);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f69973d == 0) {
                this.f69973d = ((((527 + ((int) this.f69970a)) * 31) + ((int) this.f69971b)) * 31) + this.f69972c.hashCode();
            }
            return this.f69973d;
        }
        return invokeV.intValue;
    }
}
