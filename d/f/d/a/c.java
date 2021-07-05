package d.f.d.a;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.charset.Charset;
import org.apache.commons.base.CharEncoding;
/* loaded from: classes10.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f73717a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1601558575, "Ld/f/d/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1601558575, "Ld/f/d/a/c;");
                return;
            }
        }
        Charset.forName("US-ASCII");
        Charset.forName("ISO-8859-1");
        f73717a = Charset.forName("UTF-8");
        Charset.forName(CharEncoding.UTF_16BE);
        Charset.forName(CharEncoding.UTF_16LE);
        Charset.forName("UTF-16");
    }
}
