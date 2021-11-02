package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.vivo.push.util.h;
import com.vivo.push.util.p;
import com.vivo.push.util.y;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes2.dex */
public abstract class d<T> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f70295a;

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f70296b;

    /* renamed from: c  reason: collision with root package name */
    public static final Object f70297c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d  reason: collision with root package name */
    public List<T> f70298d;

    /* renamed from: e  reason: collision with root package name */
    public Context f70299e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(432263120, "Lcom/vivo/push/cache/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(432263120, "Lcom/vivo/push/cache/d;");
                return;
            }
        }
        f70295a = new byte[]{34, 32, PublicSuffixDatabase.EXCEPTION_MARKER, 37, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 32, PublicSuffixDatabase.EXCEPTION_MARKER, PublicSuffixDatabase.EXCEPTION_MARKER, PublicSuffixDatabase.EXCEPTION_MARKER, 34, 41, Base64.INTERNAL_PADDING, 32, 32, 32};
        f70296b = new byte[]{PublicSuffixDatabase.EXCEPTION_MARKER, 34, Base64.INTERNAL_PADDING, 36, 37, 38, 39, 40, 41, 32, 38, 37, 36, Base64.INTERNAL_PADDING, 34, PublicSuffixDatabase.EXCEPTION_MARKER};
        f70297c = new Object();
    }

    public d(Context context) {
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
        this.f70298d = new ArrayList();
        this.f70299e = context.getApplicationContext();
        c();
    }

    public abstract String a();

    public abstract List<T> a(String str);

    public abstract String b(String str) throws Exception;

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (f70297c) {
                h.a(a());
                this.f70298d.clear();
                String a2 = y.b(this.f70299e).a(a(), null);
                if (TextUtils.isEmpty(a2)) {
                    p.d("CacheSettings", "ClientManager init " + a() + " strApps empty.");
                } else if (a2.length() > 10000) {
                    p.d("CacheSettings", "sync " + a() + " strApps lenght too large");
                    d();
                } else {
                    try {
                        p.d("CacheSettings", "ClientManager init " + a() + " strApps : " + a2);
                        List<T> a3 = a(b(a2));
                        if (a3 != null) {
                            this.f70298d.addAll(a3);
                        }
                    } catch (Exception e2) {
                        d();
                        p.d("CacheSettings", p.a(e2));
                    }
                }
            }
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (f70297c) {
                this.f70298d.clear();
                y.b(this.f70299e).b(a(), "");
                p.d("CacheSettings", "clear " + a() + " strApps");
            }
        }
    }
}
