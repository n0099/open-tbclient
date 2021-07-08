package d.a.n0.e.n.b;

import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f49185a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1020469256, "Ld/a/n0/e/n/b/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1020469256, "Ld/a/n0/e/n/b/c;");
                return;
            }
        }
        f49185a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            Signature b2 = b(str);
            if (b2 == null) {
                return null;
            }
            try {
                return c(MessageDigest.getInstance("MD5").digest(b2.toByteArray()));
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    public static Signature b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return AppRuntime.getAppContext().getPackageManager().getPackageInfo(str, 64).signatures[0];
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Signature) invokeL.objValue;
    }

    public static String c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            char[] cArr = new char[bArr.length * 2];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                byte b2 = bArr[i2];
                int i3 = i2 * 2;
                char[] cArr2 = f49185a;
                cArr[i3] = cArr2[(b2 >>> 4) & 15];
                cArr[i3 + 1] = cArr2[b2 & 15];
            }
            return new String(cArr);
        }
        return (String) invokeL.objValue;
    }
}
