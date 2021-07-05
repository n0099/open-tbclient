package d.a.w0.a.e;

import android.content.Context;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.w0.a.e.a;
import java.util.Date;
/* loaded from: classes9.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f70910a;

    /* renamed from: b  reason: collision with root package name */
    public static a.InterfaceC1961a f70911b;

    /* renamed from: c  reason: collision with root package name */
    public static a.InterfaceC1961a f70912c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1419824894, "Ld/a/w0/a/e/b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1419824894, "Ld/a/w0/a/e/b;");
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            synchronized (b.class) {
                if (!f70910a) {
                    d.a.w0.a.f.a.b(" ActivityLifeTask   add  " + new Date().toLocaleString());
                    f70911b = new c();
                    f70912c = new m();
                    a.a().c();
                    a.a().d(f70912c);
                    a.a().d(f70911b);
                    a.a().e(context);
                    f70910a = true;
                    return;
                }
                d.a.w0.a.f.a.b(" ActivityLifeTask  is added  " + new Date().toLocaleString());
            }
        }
    }
}
