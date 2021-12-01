package okhttp3;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class TlsVersion {
    public static final /* synthetic */ TlsVersion[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final TlsVersion SSL_3_0;
    public static final TlsVersion TLS_1_0;
    public static final TlsVersion TLS_1_1;
    public static final TlsVersion TLS_1_2;
    public static final TlsVersion TLS_1_3;
    public transient /* synthetic */ FieldHolder $fh;
    public final String javaName;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1652988206, "Lokhttp3/TlsVersion;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1652988206, "Lokhttp3/TlsVersion;");
                return;
            }
        }
        TLS_1_3 = new TlsVersion("TLS_1_3", 0, "TLSv1.3");
        TLS_1_2 = new TlsVersion("TLS_1_2", 1, "TLSv1.2");
        TLS_1_1 = new TlsVersion("TLS_1_1", 2, "TLSv1.1");
        TLS_1_0 = new TlsVersion("TLS_1_0", 3, "TLSv1");
        TlsVersion tlsVersion = new TlsVersion("SSL_3_0", 4, "SSLv3");
        SSL_3_0 = tlsVersion;
        $VALUES = new TlsVersion[]{TLS_1_3, TLS_1_2, TLS_1_1, TLS_1_0, tlsVersion};
    }

    public TlsVersion(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.javaName = str2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static TlsVersion forJavaName(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            int hashCode = str.hashCode();
            if (hashCode == 79201641) {
                if (str.equals("SSLv3")) {
                    c2 = 4;
                }
                c2 = 65535;
            } else if (hashCode != 79923350) {
                switch (hashCode) {
                    case -503070503:
                        if (str.equals("TLSv1.1")) {
                            c2 = 2;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -503070502:
                        if (str.equals("TLSv1.2")) {
                            c2 = 1;
                            break;
                        }
                        c2 = 65535;
                        break;
                    case -503070501:
                        if (str.equals("TLSv1.3")) {
                            c2 = 0;
                            break;
                        }
                        c2 = 65535;
                        break;
                    default:
                        c2 = 65535;
                        break;
                }
            } else {
                if (str.equals("TLSv1")) {
                    c2 = 3;
                }
                c2 = 65535;
            }
            if (c2 != 0) {
                if (c2 != 1) {
                    if (c2 != 2) {
                        if (c2 != 3) {
                            if (c2 == 4) {
                                return SSL_3_0;
                            }
                            throw new IllegalArgumentException("Unexpected TLS version: " + str);
                        }
                        return TLS_1_0;
                    }
                    return TLS_1_1;
                }
                return TLS_1_2;
            }
            return TLS_1_3;
        }
        return (TlsVersion) invokeL.objValue;
    }

    public static List<TlsVersion> forJavaNames(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, strArr)) == null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                arrayList.add(forJavaName(str));
            }
            return Collections.unmodifiableList(arrayList);
        }
        return (List) invokeL.objValue;
    }

    public static TlsVersion valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (TlsVersion) Enum.valueOf(TlsVersion.class, str) : (TlsVersion) invokeL.objValue;
    }

    public static TlsVersion[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? (TlsVersion[]) $VALUES.clone() : (TlsVersion[]) invokeV.objValue;
    }

    public String javaName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.javaName : (String) invokeV.objValue;
    }
}
