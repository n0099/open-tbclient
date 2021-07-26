package d.f.b.a.a0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.Format;
import java.io.IOException;
import java.util.Arrays;
/* loaded from: classes8.dex */
public interface m {

    /* loaded from: classes8.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final int f69683a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f69684b;

        /* renamed from: c  reason: collision with root package name */
        public final int f69685c;

        /* renamed from: d  reason: collision with root package name */
        public final int f69686d;

        public a(int i2, byte[] bArr, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), bArr, Integer.valueOf(i3), Integer.valueOf(i4)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i5 = newInitContext.flag;
                if ((i5 & 1) != 0) {
                    int i6 = i5 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69683a = i2;
            this.f69684b = bArr;
            this.f69685c = i3;
            this.f69686d = i4;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || a.class != obj.getClass()) {
                    return false;
                }
                a aVar = (a) obj;
                return this.f69683a == aVar.f69683a && this.f69685c == aVar.f69685c && this.f69686d == aVar.f69686d && Arrays.equals(this.f69684b, aVar.f69684b);
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (((((this.f69683a * 31) + Arrays.hashCode(this.f69684b)) * 31) + this.f69685c) * 31) + this.f69686d : invokeV.intValue;
        }
    }

    void a(d.f.b.a.i0.l lVar, int i2);

    void b(Format format);

    void c(long j, int i2, int i3, int i4, a aVar);

    int d(f fVar, int i2, boolean z) throws IOException, InterruptedException;
}
