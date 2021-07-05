package d.f.b.a.a0.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.i0.v;
/* loaded from: classes10.dex */
public final class m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f72317a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f72318b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f72319c;

    /* renamed from: d  reason: collision with root package name */
    public final int f72320d;

    /* renamed from: e  reason: collision with root package name */
    public final long[] f72321e;

    /* renamed from: f  reason: collision with root package name */
    public final int[] f72322f;

    public m(long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jArr, iArr, Integer.valueOf(i2), jArr2, iArr2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d.f.b.a.i0.a.a(iArr.length == jArr2.length);
        d.f.b.a.i0.a.a(jArr.length == jArr2.length);
        d.f.b.a.i0.a.a(iArr2.length == jArr2.length);
        this.f72318b = jArr;
        this.f72319c = iArr;
        this.f72320d = i2;
        this.f72321e = jArr2;
        this.f72322f = iArr2;
        this.f72317a = jArr.length;
    }

    public int a(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048576, this, j)) == null) {
            for (int e2 = v.e(this.f72321e, j, true, false); e2 >= 0; e2--) {
                if ((this.f72322f[e2] & 1) != 0) {
                    return e2;
                }
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    public int b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j)) == null) {
            for (int b2 = v.b(this.f72321e, j, true, false); b2 < this.f72321e.length; b2++) {
                if ((this.f72322f[b2] & 1) != 0) {
                    return b2;
                }
            }
            return -1;
        }
        return invokeJ.intValue;
    }
}
