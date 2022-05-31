package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.g;
import com.vivo.push.util.p;
import com.vivo.push.util.x;
import com.vivo.push.util.z;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public abstract class c<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public transient /* synthetic */ FieldHolder $fh;
    public List<T> b;
    public Context c;
    public byte[] d;
    public byte[] e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(432263089, "Lcom/vivo/push/cache/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(432263089, "Lcom/vivo/push/cache/c;");
                return;
            }
        }
        a = new Object();
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.c = ContextDelegate.getContext(context);
        x b = x.b();
        b.a(this.c);
        this.d = b.c();
        this.e = b.d();
        c();
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? z.b(this.c).a(a(), null) : (String) invokeV.objValue;
    }

    private void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            z.b(this.c).b(a(), str);
        }
    }

    public abstract String a();

    public abstract List<T> a(String str);

    public abstract String b(String str) throws Exception;

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (a) {
                g.a(a());
                this.b.clear();
                c(b());
            }
        }
    }

    public final byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            byte[] bArr = this.d;
            return (bArr == null || bArr.length <= 0) ? x.b().c() : bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public final byte[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            byte[] bArr = this.e;
            return (bArr == null || bArr.length <= 0) ? x.b().d() : bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (a) {
                this.b.clear();
                d("");
                p.d("CacheSettings", "clear " + a() + " strApps");
            }
        }
    }

    private void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, str) == null) {
            if (TextUtils.isEmpty(str)) {
                p.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
            } else if (str.length() > 10000) {
                p.d("CacheSettings", "sync " + a() + " strApps lenght too large");
                d();
            } else {
                try {
                    p.d("CacheSettings", "ClientManager init " + a() + " strApps : " + str);
                    List<T> a2 = a(b(str));
                    if (a2 != null) {
                        this.b.addAll(a2);
                    }
                } catch (Exception e) {
                    d();
                    p.d("CacheSettings", p.a(e));
                }
            }
        }
    }
}
