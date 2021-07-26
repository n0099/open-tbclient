package d.f.b.a.a0.o;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.i0.l;
import java.io.IOException;
/* loaded from: classes8.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final l f69734a;

    /* renamed from: b  reason: collision with root package name */
    public int f69735b;

    public e() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69734a = new l(8);
    }

    public final long a(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            int i2 = 0;
            fVar.c(this.f69734a.f70943a, 0, 1);
            int i3 = this.f69734a.f70943a[0] & 255;
            if (i3 == 0) {
                return Long.MIN_VALUE;
            }
            int i4 = 128;
            int i5 = 0;
            while ((i3 & i4) == 0) {
                i4 >>= 1;
                i5++;
            }
            int i6 = i3 & (~i4);
            fVar.c(this.f69734a.f70943a, 1, i5);
            while (i2 < i5) {
                i2++;
                i6 = (this.f69734a.f70943a[i2] & 255) + (i6 << 8);
            }
            this.f69735b += i5 + 1;
            return i6;
        }
        return invokeL.longValue;
    }

    public boolean b(d.f.b.a.a0.f fVar) throws IOException, InterruptedException {
        InterceptResult invokeL;
        long a2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar)) != null) {
            return invokeL.booleanValue;
        }
        long length = fVar.getLength();
        long j = 1024;
        int i3 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i3 != 0 && length <= 1024) {
            j = length;
        }
        int i4 = (int) j;
        fVar.c(this.f69734a.f70943a, 0, 4);
        long z = this.f69734a.z();
        this.f69735b = 4;
        while (z != 440786851) {
            int i5 = this.f69735b + 1;
            this.f69735b = i5;
            if (i5 == i4) {
                return false;
            }
            fVar.c(this.f69734a.f70943a, 0, 1);
            z = ((z << 8) & (-256)) | (this.f69734a.f70943a[0] & 255);
        }
        long a3 = a(fVar);
        long j2 = this.f69735b;
        if (a3 == Long.MIN_VALUE) {
            return false;
        }
        if (i3 != 0 && j2 + a3 >= length) {
            return false;
        }
        while (true) {
            int i6 = this.f69735b;
            long j3 = j2 + a3;
            if (i6 >= j3) {
                return ((long) i6) == j3;
            } else if (a(fVar) != Long.MIN_VALUE && (a(fVar)) >= 0 && a2 <= 2147483647L) {
                if (i2 != 0) {
                    fVar.g((int) a2);
                    this.f69735b = (int) (this.f69735b + a2);
                }
            }
        }
    }
}
