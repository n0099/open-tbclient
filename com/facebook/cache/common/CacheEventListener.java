package com.facebook.cache.common;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public interface CacheEventListener {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class EvictionReason {
        public static final /* synthetic */ EvictionReason[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final EvictionReason CACHE_FULL;
        public static final EvictionReason CACHE_MANAGER_TRIMMED;
        public static final EvictionReason CONTENT_STALE;
        public static final EvictionReason USER_FORCED;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(415376616, "Lcom/facebook/cache/common/CacheEventListener$EvictionReason;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(415376616, "Lcom/facebook/cache/common/CacheEventListener$EvictionReason;");
                    return;
                }
            }
            CACHE_FULL = new EvictionReason("CACHE_FULL", 0);
            CONTENT_STALE = new EvictionReason("CONTENT_STALE", 1);
            USER_FORCED = new EvictionReason("USER_FORCED", 2);
            EvictionReason evictionReason = new EvictionReason("CACHE_MANAGER_TRIMMED", 3);
            CACHE_MANAGER_TRIMMED = evictionReason;
            $VALUES = new EvictionReason[]{CACHE_FULL, CONTENT_STALE, USER_FORCED, evictionReason};
        }

        public EvictionReason(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static EvictionReason valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (EvictionReason) Enum.valueOf(EvictionReason.class, str) : (EvictionReason) invokeL.objValue;
        }

        public static EvictionReason[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (EvictionReason[]) $VALUES.clone() : (EvictionReason[]) invokeV.objValue;
        }
    }

    void onCleared();

    void onEviction(CacheEvent cacheEvent);

    void onHit(CacheEvent cacheEvent);

    void onMiss(CacheEvent cacheEvent);

    void onReadException(CacheEvent cacheEvent);

    void onWriteAttempt(CacheEvent cacheEvent);

    void onWriteException(CacheEvent cacheEvent);

    void onWriteSuccess(CacheEvent cacheEvent);
}
