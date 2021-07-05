package d.f.b.a.a0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.i0.v;
/* loaded from: classes10.dex */
public final class a implements l {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f72091a;

    /* renamed from: b  reason: collision with root package name */
    public final int[] f72092b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f72093c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f72094d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f72095e;

    /* renamed from: f  reason: collision with root package name */
    public final long f72096f;

    public a(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iArr, jArr, jArr2, jArr3};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f72092b = iArr;
        this.f72093c = jArr;
        this.f72094d = jArr2;
        this.f72095e = jArr3;
        int length = iArr.length;
        this.f72091a = length;
        if (length > 0) {
            this.f72096f = jArr2[length - 1] + jArr3[length - 1];
        } else {
            this.f72096f = 0L;
        }
    }

    public int a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) ? v.e(this.f72095e, j, true, true) : invokeJ.intValue;
    }

    @Override // d.f.b.a.a0.l
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.f.b.a.a0.l
    public long c(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) ? this.f72093c[a(j)] : invokeJ.longValue;
    }

    @Override // d.f.b.a.a0.l
    public long h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f72096f : invokeV.longValue;
    }
}
