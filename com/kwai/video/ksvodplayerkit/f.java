package com.kwai.video.ksvodplayerkit;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AwesomeCache;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static f f39953a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, a> f39954b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f39955c;

    /* renamed from: d  reason: collision with root package name */
    public com.kwai.video.ksvodplayerkit.a f39956d;

    /* loaded from: classes7.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public boolean f39958a;

        /* renamed from: b  reason: collision with root package name */
        public long f39959b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f39960c;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f39960c = fVar;
            this.f39958a = false;
            this.f39959b = 0L;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(245192061, "Lcom/kwai/video/ksvodplayerkit/f;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(245192061, "Lcom/kwai/video/ksvodplayerkit/f;");
        }
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f39955c = new Object();
        this.f39954b = new LinkedHashMap(100);
        this.f39956d = new com.kwai.video.ksvodplayerkit.a(this) { // from class: com.kwai.video.ksvodplayerkit.f.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ f f39957a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f39957a = this;
            }

            @Override // com.kwai.video.ksvodplayerkit.a
            public String a(String str) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, str)) == null) ? com.kwai.video.ksvodplayerkit.c.c.c(str) : (String) invokeL.objValue;
            }
        };
    }

    public static synchronized f a() {
        InterceptResult invokeV;
        f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (f.class) {
                if (f39953a == null) {
                    f39953a = new f();
                }
                fVar = f39953a;
            }
            return fVar;
        }
        return (f) invokeV.objValue;
    }

    private boolean d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) ? AwesomeCache.isFullyCached(str) : invokeL.booleanValue;
    }

    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            com.kwai.video.ksvodplayerkit.a.b.a("KSVodPlayStatManager", "size:" + this.f39954b.size() + ", add url:" + str);
            synchronized (this.f39955c) {
                if (this.f39954b.size() >= 100) {
                    int i2 = 0;
                    Iterator<Map.Entry<String, a>> it = this.f39954b.entrySet().iterator();
                    while (it.hasNext()) {
                        it.next();
                        it.remove();
                        i2++;
                        if (i2 >= 20) {
                            break;
                        }
                    }
                }
                String a2 = this.f39956d.a(str);
                if (this.f39954b.containsKey(a2)) {
                    return a2;
                }
                a aVar = new a();
                aVar.f39958a = AwesomeCache.isFullyCached(a2);
                this.f39954b.put(a2, aVar);
                return a2;
            }
        }
        return (String) invokeL.objValue;
    }

    public void a(String str, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) || TextUtils.isEmpty(str) || j < 0) {
            return;
        }
        String a2 = this.f39956d.a(str);
        synchronized (this.f39955c) {
            if (!this.f39954b.containsKey(a2)) {
                a(str);
            }
            a aVar = this.f39954b.get(a2);
            if (aVar != null) {
                aVar.f39959b = j;
            }
        }
    }

    public boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return d(this.f39956d.a(str));
        }
        return invokeL.booleanValue;
    }

    public long c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            String a2 = this.f39956d.a(str);
            synchronized (this.f39955c) {
                if (this.f39954b.containsKey(a2)) {
                    a aVar = this.f39954b.get(a2);
                    if (aVar != null) {
                        return aVar.f39959b;
                    }
                    return 0L;
                }
                return 0L;
            }
        }
        return invokeL.longValue;
    }
}
