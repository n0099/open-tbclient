package d.f.b.a.d0.v.g;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final long f72841a;

    /* renamed from: b  reason: collision with root package name */
    public final long f72842b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f72843c;

    /* renamed from: d  reason: collision with root package name */
    public final long f72844d;

    /* renamed from: e  reason: collision with root package name */
    public final long f72845e;

    /* renamed from: f  reason: collision with root package name */
    public final long f72846f;

    /* renamed from: g  reason: collision with root package name */
    public final k f72847g;

    /* renamed from: h  reason: collision with root package name */
    public final Uri f72848h;

    /* renamed from: i  reason: collision with root package name */
    public final List<e> f72849i;

    public b(long j, long j2, long j3, boolean z, long j4, long j5, long j6, k kVar, Uri uri, List<e> list) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z), Long.valueOf(j4), Long.valueOf(j5), Long.valueOf(j6), kVar, uri, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72841a = j;
        this.f72842b = j2;
        this.f72843c = z;
        this.f72844d = j4;
        this.f72845e = j5;
        this.f72846f = j6;
        this.f72847g = kVar;
        this.f72848h = uri;
        this.f72849i = list == null ? Collections.emptyList() : list;
    }

    public final e a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.f72849i.get(i2) : (e) invokeI.objValue;
    }

    public final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f72849i.size() : invokeV.intValue;
    }

    public final long c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (i2 == this.f72849i.size() - 1) {
                long j = this.f72842b;
                if (j == -9223372036854775807L) {
                    return -9223372036854775807L;
                }
                return j - this.f72849i.get(i2).f72865b;
            }
            return this.f72849i.get(i2 + 1).f72865b - this.f72849i.get(i2).f72865b;
        }
        return invokeI.longValue;
    }

    public final long d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? d.f.b.a.b.a(c(i2)) : invokeI.longValue;
    }
}
