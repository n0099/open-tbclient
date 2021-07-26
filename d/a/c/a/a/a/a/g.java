package d.a.c.a.a.a.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f41364a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f41365b;

    /* renamed from: c  reason: collision with root package name */
    public int f41366c;

    public g() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        i2 = c.f41357d;
        this.f41364a = i2;
        this.f41365b = new byte[i2];
    }

    public f a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new f(Arrays.copyOf(this.f41365b, this.f41366c)) : (f) invokeV.objValue;
    }

    public g b(byte b2) {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2)) == null) {
            c(this.f41366c + 1);
            byte[] bArr = this.f41365b;
            int i2 = this.f41366c;
            this.f41366c = i2 + 1;
            bArr[i2] = b2;
            return this;
        }
        return (g) invokeB.objValue;
    }

    public final void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            byte[] bArr = this.f41365b;
            if (i2 - bArr.length > 0) {
                int length = bArr.length;
                int i3 = length + (length >> 1);
                if (i3 - i2 >= 0) {
                    i2 = i3;
                }
                this.f41365b = Arrays.copyOf(this.f41365b, i2);
            }
        }
    }
}
