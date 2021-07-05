package com.bytedance.sdk.openadsdk.preload.geckox.statistic;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Map<Long, b> f32135a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a> f32136b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(817463133, "Lcom/bytedance/sdk/openadsdk/preload/geckox/statistic/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(817463133, "Lcom/bytedance/sdk/openadsdk/preload/geckox/statistic/b;");
                return;
            }
        }
        f32135a = new HashMap();
    }

    public b() {
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
        this.f32136b = new HashMap();
    }

    public static b a(long j) {
        InterceptResult invokeJ;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            synchronized (f32135a) {
                bVar = f32135a.get(Long.valueOf(j));
                if (bVar == null) {
                    bVar = new b();
                    f32135a.put(Long.valueOf(j), bVar);
                }
            }
            return bVar;
        }
        return (b) invokeJ.objValue;
    }

    public com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a a(String str) {
        InterceptResult invokeL;
        com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            synchronized (this.f32136b) {
                aVar = this.f32136b.get(str);
                if (aVar == null) {
                    aVar = new com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a();
                    this.f32136b.put(str, aVar);
                }
            }
            return aVar;
        }
        return (com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a) invokeL.objValue;
    }

    public List<com.bytedance.sdk.openadsdk.preload.geckox.statistic.model.a> a() {
        InterceptResult invokeV;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this.f32136b) {
                arrayList = new ArrayList(this.f32136b.values());
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }
}
