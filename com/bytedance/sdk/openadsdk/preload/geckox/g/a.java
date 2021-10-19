package com.bytedance.sdk.openadsdk.preload.geckox.g;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.preload.geckox.utils.FileLock;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f69102a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public FileLock f69103b;

    /* renamed from: c  reason: collision with root package name */
    public String f69104c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1932788167, "Lcom/bytedance/sdk/openadsdk/preload/geckox/g/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1932788167, "Lcom/bytedance/sdk/openadsdk/preload/geckox/g/a;");
                return;
            }
        }
        f69102a = new HashMap();
    }

    public a(String str, FileLock fileLock) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, fileLock};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f69104c = str;
        this.f69103b = fileLock;
    }

    public static a a(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (f69102a) {
                Lock lock = f69102a.get(str);
                if (lock == null) {
                    lock = new ReentrantLock();
                    f69102a.put(str, lock);
                }
                if (lock.tryLock()) {
                    try {
                        FileLock c2 = FileLock.c(str);
                        if (c2 == null) {
                            lock.unlock();
                            return null;
                        }
                        return new a(str, c2);
                    } catch (Exception e2) {
                        lock.lock();
                        com.bytedance.sdk.openadsdk.preload.geckox.utils.c.a(new RuntimeException(e2));
                        return null;
                    }
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (f69102a) {
                this.f69103b.a();
                this.f69103b.b();
                f69102a.get(this.f69104c).unlock();
            }
        }
    }
}
