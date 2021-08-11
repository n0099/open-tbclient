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
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Lock> f68379a;

    /* renamed from: b  reason: collision with root package name */
    public static ReentrantLock f68380b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f68381c;

    /* renamed from: d  reason: collision with root package name */
    public FileLock f68382d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1932788198, "Lcom/bytedance/sdk/openadsdk/preload/geckox/g/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1932788198, "Lcom/bytedance/sdk/openadsdk/preload/geckox/g/b;");
                return;
            }
        }
        f68379a = new HashMap();
        f68380b = new ReentrantLock();
    }

    public b(String str, FileLock fileLock) {
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
        this.f68381c = str;
        this.f68382d = fileLock;
    }

    public static b a(String str) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            f68380b.lock();
            try {
                FileLock a2 = FileLock.a(str);
                Lock lock = f68379a.get(str);
                if (lock == null) {
                    lock = new ReentrantLock();
                    f68379a.put(str, lock);
                }
                lock.lock();
                return new b(str, a2);
            } catch (Exception e2) {
                f68380b.unlock();
                throw e2;
            }
        }
        return (b) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                this.f68382d.a();
                this.f68382d.b();
                Lock lock = f68379a.get(this.f68381c);
                if (lock == null) {
                    return;
                }
                lock.unlock();
            } finally {
                f68380b.unlock();
            }
        }
    }
}
