package d.a.b.a.a.b;

import android.content.Context;
import android.util.Pair;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.b.a.a.a.a.c;
import d.a.b.a.a.a.a.i;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f40868b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f40869a;

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40869a = context.getApplicationContext();
    }

    public static synchronized a b(Context context) {
        InterceptResult invokeL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            synchronized (a.class) {
                if (f40868b == null) {
                    synchronized (a.class) {
                        if (f40868b == null) {
                            f40868b = new a(context.getApplicationContext());
                        }
                    }
                }
                aVar = f40868b;
            }
            return aVar;
        }
        return (a) invokeL.objValue;
    }

    public final i a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? new c(this.f40869a).c(str) : (i) invokeL.objValue;
    }

    public Pair c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            i a2 = a(str);
            long j = -1;
            if (a2.d()) {
                try {
                    j = d.a.b.a.a.e.a.a(a2.f40866a);
                    return new Pair(0, Long.valueOf(j));
                } catch (IllegalArgumentException unused) {
                    return new Pair(-108, Long.valueOf(j));
                }
            }
            return new Pair(Integer.valueOf(a2.f40867b), -1L);
        }
        return (Pair) invokeL.objValue;
    }
}
