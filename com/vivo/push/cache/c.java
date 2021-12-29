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
/* loaded from: classes4.dex */
public abstract class c<T> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public List<T> f63063b;

    /* renamed from: c  reason: collision with root package name */
    public Context f63064c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f63065d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f63066e;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f63063b = new ArrayList();
        this.f63064c = ContextDelegate.getContext(context);
        x b2 = x.b();
        b2.a(this.f63064c);
        this.f63065d = b2.c();
        this.f63066e = b2.d();
        c();
    }

    private String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? z.b(this.f63064c).a(a(), null) : (String) invokeV.objValue;
    }

    private void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str) == null) {
            z.b(this.f63064c).b(a(), str);
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
                this.f63063b.clear();
                c(b());
            }
        }
    }

    public final byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            byte[] bArr = this.f63065d;
            return (bArr == null || bArr.length <= 0) ? x.b().c() : bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public final byte[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            byte[] bArr = this.f63066e;
            return (bArr == null || bArr.length <= 0) ? x.b().d() : bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (a) {
                this.f63063b.clear();
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
                        this.f63063b.addAll(a2);
                    }
                } catch (Exception e2) {
                    d();
                    p.d("CacheSettings", p.a(e2));
                }
            }
        }
    }
}
