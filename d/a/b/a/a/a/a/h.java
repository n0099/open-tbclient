package d.a.b.a.a.a.a;

import android.content.Context;
import android.content.Intent;
import com.baidu.ad.magic.flute.a.a.q;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
/* loaded from: classes8.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Method f43785a;

    /* renamed from: b  reason: collision with root package name */
    public Method f43786b;

    /* renamed from: c  reason: collision with root package name */
    public Class f43787c;

    public h(Context context) {
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
        try {
            c(context);
        } catch (Exception e2) {
            throw new IllegalStateException("charset = " + Charset.defaultCharset(), e2);
        }
    }

    public int a(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) {
            try {
                return ((Integer) this.f43785a.invoke(obj, obj2)).intValue();
            } catch (Exception unused) {
                throw new q("gces error");
            }
        }
        return invokeLL.intValue;
    }

    public Object b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            try {
                return this.f43786b.invoke(context, new Object[0]);
            } catch (Exception unused) {
                throw new q("gpm error");
            }
        }
        return invokeL.objValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            Method d2 = k.d(Context.class, k.c(j.c()), null);
            this.f43786b = d2;
            Object invoke = d2.invoke(context, new Object[0]);
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "");
            this.f43787c = k.d(intent.getClass(), k.c(j.d()), null).invoke(intent, new Object[0]).getClass();
            String c2 = k.c(j.a());
            Class<?> cls = invoke.getClass();
            Class cls2 = Integer.TYPE;
            k.d(cls, c2, new Class[]{this.f43787c, cls2, cls2});
            this.f43785a = k.d(invoke.getClass(), k.c(j.b()), new Class[]{this.f43787c});
        }
    }
}
