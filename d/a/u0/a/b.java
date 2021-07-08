package d.a.u0.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ueg.encrypt.entity.EncryptAlgorithm;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67765a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2099983239, "Ld/a/u0/a/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2099983239, "Ld/a/u0/a/b$a;");
                    return;
                }
            }
            int[] iArr = new int[EncryptAlgorithm.values().length];
            f67765a = iArr;
            try {
                iArr[EncryptAlgorithm.RSA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static d.a.u0.a.a a(d.a.u0.a.d.a aVar) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, aVar)) == null) {
            if (a.f67765a[aVar.a().ordinal()] != 1) {
                return null;
            }
            return new c(aVar.b());
        }
        return (d.a.u0.a.a) invokeL.objValue;
    }
}
