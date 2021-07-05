package d.f.b.a.d0.v.g;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.i0.u;
/* loaded from: classes10.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f72867a;

    /* renamed from: b  reason: collision with root package name */
    public final long f72868b;

    /* renamed from: c  reason: collision with root package name */
    public final String f72869c;

    /* renamed from: d  reason: collision with root package name */
    public int f72870d;

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
        this.f72869c = str == null ? "" : str;
        this.f72867a = j;
        this.f72868b = j2;
    }

    public f a(f fVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, fVar, str)) == null) {
            String c2 = c(str);
            if (fVar != null && c2.equals(fVar.c(str))) {
                long j = this.f72868b;
                if (j != -1) {
                    long j2 = this.f72867a;
                    if (j2 + j == fVar.f72867a) {
                        long j3 = fVar.f72868b;
                        return new f(c2, j2, j3 != -1 ? j + j3 : -1L);
                    }
                }
                long j4 = fVar.f72868b;
                if (j4 != -1) {
                    long j5 = fVar.f72867a;
                    if (j5 + j4 == this.f72867a) {
                        long j6 = this.f72868b;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? u.d(str, this.f72869c) : (Uri) invokeL.objValue;
    }

    public String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) ? u.c(str, this.f72869c) : (String) invokeL.objValue;
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
            return this.f72867a == fVar.f72867a && this.f72868b == fVar.f72868b && this.f72869c.equals(fVar.f72869c);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f72870d == 0) {
                this.f72870d = ((((527 + ((int) this.f72867a)) * 31) + ((int) this.f72868b)) * 31) + this.f72869c.hashCode();
            }
            return this.f72870d;
        }
        return invokeV.intValue;
    }
}
