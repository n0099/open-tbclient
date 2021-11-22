package com.ss.android.socialbase.downloader.network.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.i.f;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f70569a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, c> f70570b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, d> f70571c;

    /* renamed from: com.ss.android.socialbase.downloader.network.a.a$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.ss.android.socialbase.downloader.network.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C2047a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f70572a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1414354774, "Lcom/ss/android/socialbase/downloader/network/a/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1414354774, "Lcom/ss/android/socialbase/downloader/network/a/a$a;");
                    return;
                }
            }
            f70572a = new a(null);
        }
    }

    public /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public void a(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, cVar) == null) {
            synchronized (this.f70570b) {
                this.f70570b.put(str, cVar);
            }
        }
    }

    public d b(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeLL;
        d remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, list)) == null) {
            synchronized (this.f70571c) {
                remove = this.f70571c.remove(str);
            }
            if (remove != null) {
                if (f.a(remove.f(), list)) {
                    try {
                        remove.e();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    if (remove.h() && remove.g()) {
                        return remove;
                    }
                }
                try {
                    remove.d();
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }
        return (d) invokeLL.objValue;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70570b = new HashMap();
        this.f70571c = new LinkedHashMap(3);
        this.f70569a = 3;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.f70569a = i2;
        }
    }

    public c a(String str, List<com.ss.android.socialbase.downloader.model.c> list) {
        InterceptResult invokeLL;
        c remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, list)) == null) {
            synchronized (this.f70570b) {
                remove = this.f70570b.remove(str);
            }
            if (remove != null) {
                if (f.a(remove.h(), list)) {
                    try {
                        remove.d();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                    if (remove.f() && remove.e()) {
                        return remove;
                    }
                }
                try {
                    remove.c();
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return null;
        }
        return (c) invokeLL.objValue;
    }

    public boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            c cVar = this.f70570b.get(str);
            if (cVar != null) {
                if (cVar.g()) {
                    return true;
                }
                return cVar.f() && cVar.e();
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? C2047a.f70572a : (a) invokeV.objValue;
    }
}
