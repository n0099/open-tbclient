package d.a.q0.h.d0.h;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f53221a;

    /* renamed from: b  reason: collision with root package name */
    public long f53222b;

    /* renamed from: c  reason: collision with root package name */
    public long f53223c;

    public b(long j, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f53221a = j;
        this.f53222b = j2;
        this.f53223c = j3;
    }

    @NonNull
    public static b b(long j, double d2, double d3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), Double.valueOf(d2), Double.valueOf(d3)})) == null) ? new b(j, (long) (d2 * 1000.0d), (long) (d3 * 1000.0d)) : (b) invokeCommon.objValue;
    }

    public a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c()) {
                a aVar = new a();
                aVar.f53219a = Math.max(this.f53221a - this.f53222b, 0L);
                aVar.f53220b = this.f53221a + this.f53223c;
                return aVar;
            }
            return null;
        }
        return (a) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            long j = this.f53221a;
            if (j >= 0) {
                long j2 = this.f53222b;
                if (j2 >= 0) {
                    long j3 = this.f53223c;
                    if (j3 >= 0 && j2 + j3 > 0 && j + j3 > 0) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return "[ mBaseline = " + this.f53221a + "; mLeftOffset = " + this.f53222b + "; mRightOffset = " + this.f53223c + " ]";
        }
        return (String) invokeV.objValue;
    }
}
