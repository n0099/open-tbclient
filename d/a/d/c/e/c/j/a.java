package d.a.d.c.e.c.j;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static byte f41442g = 4;

    /* renamed from: h  reason: collision with root package name */
    public static byte f41443h = Byte.MIN_VALUE;

    /* renamed from: i  reason: collision with root package name */
    public static byte f41444i = 64;
    public static byte j = 8;
    public static byte k = 4;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f41445a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f41446b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41447c;

    /* renamed from: d  reason: collision with root package name */
    public int f41448d;

    /* renamed from: e  reason: collision with root package name */
    public int f41449e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f41450f;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1408486865, "Ld/a/d/c/e/c/j/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1408486865, "Ld/a/d/c/e/c/j/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41445a = false;
        this.f41446b = false;
        this.f41447c = false;
        this.f41450f = false;
    }

    public static a a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bArr)) == null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, f());
            a aVar = new a();
            byte b2 = wrap.get();
            if ((f41443h & b2) != 0) {
                aVar.f41445a = true;
            }
            if ((f41444i & b2) != 0) {
                aVar.f41446b = true;
            }
            if ((j & b2) != 0) {
                aVar.f41447c = true;
            }
            if ((b2 & k) != 0) {
                aVar.f41450f = true;
            }
            aVar.f41448d = wrap.getInt();
            aVar.f41449e = wrap.getInt();
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public static int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return 9;
        }
        return invokeV.intValue;
    }

    public static byte[] i(boolean z, boolean z2, int i2, int i3, byte[] bArr, boolean z3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i2), Integer.valueOf(i3), bArr, Boolean.valueOf(z3)})) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(f() + (bArr != null ? bArr.length : 0));
            byte b2 = z ? (byte) (f41443h | 0) : (byte) 0;
            if (z2) {
                b2 = (byte) (f41444i | b2);
            }
            byte b3 = (byte) (j | b2);
            if (z3) {
                b3 = (byte) (b3 | k);
            }
            allocate.put(b3);
            allocate.putInt(i2);
            allocate.putInt(i3);
            if (bArr != null) {
                allocate.put(bArr);
            }
            allocate.flip();
            return allocate.array();
        }
        return (byte[]) invokeCommon.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f41448d : invokeV.intValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f41446b : invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41445a : invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f41450f : invokeV.booleanValue;
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f41447c : invokeV.booleanValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f41449e : invokeV.intValue;
    }
}
