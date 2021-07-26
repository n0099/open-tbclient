package d.f.b.a.a0.t;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes8.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final int f70075a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f70076b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f70077c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f70078d;

    /* renamed from: e  reason: collision with root package name */
    public int f70079e;

    public o(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70075a = i2;
        byte[] bArr = new byte[i3 + 3];
        this.f70078d = bArr;
        bArr[2] = 1;
    }

    public void a(byte[] bArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048576, this, bArr, i2, i3) == null) && this.f70076b) {
            int i4 = i3 - i2;
            byte[] bArr2 = this.f70078d;
            int length = bArr2.length;
            int i5 = this.f70079e;
            if (length < i5 + i4) {
                this.f70078d = Arrays.copyOf(bArr2, (i5 + i4) * 2);
            }
            System.arraycopy(bArr, i2, this.f70078d, this.f70079e, i4);
            this.f70079e += i4;
        }
    }

    public boolean b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            if (this.f70076b) {
                this.f70079e -= i2;
                this.f70076b = false;
                this.f70077c = true;
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f70077c : invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f70076b = false;
            this.f70077c = false;
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            d.f.b.a.i0.a.f(!this.f70076b);
            boolean z = i2 == this.f70075a;
            this.f70076b = z;
            if (z) {
                this.f70079e = 3;
                this.f70077c = false;
            }
        }
    }
}
