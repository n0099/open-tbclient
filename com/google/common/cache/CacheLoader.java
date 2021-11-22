package com.google.common.cache;

import b.h.d.a.g;
import b.h.d.a.n;
import b.h.d.a.r;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
/* loaded from: classes11.dex */
public abstract class CacheLoader<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final g<K, V> computingFunction;

        public FunctionToCacheLoader(g<K, V> gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(gVar);
            this.computingFunction = gVar;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) {
                g<K, V> gVar = this.computingFunction;
                n.p(k);
                return gVar.apply(k);
            }
            return (V) invokeL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class InvalidCacheLoadException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidCacheLoadException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final r<V> computingSupplier;

        public SupplierToCacheLoader(r<V> rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            n.p(rVar);
            this.computingSupplier = rVar;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                n.p(obj);
                return this.computingSupplier.get();
            }
            return (V) invokeL.objValue;
        }
    }

    /* loaded from: classes11.dex */
    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public UnsupportedLoadingOperationException() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes11.dex */
    public static class a extends CacheLoader<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CacheLoader f64058a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Executor f64059b;

        /* renamed from: com.google.common.cache.CacheLoader$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        public class CallableC1908a implements Callable<V> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Object f64060e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Object f64061f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ a f64062g;

            public CallableC1908a(a aVar, Object obj, Object obj2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, obj, obj2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f64062g = aVar;
                this.f64060e = obj;
                this.f64061f = obj2;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.google.common.cache.CacheLoader */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public V call() throws Exception {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64062g.f64058a.reload(this.f64060e, this.f64061f).get() : (V) invokeV.objValue;
            }
        }

        public a(CacheLoader cacheLoader, Executor executor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cacheLoader, executor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64058a = cacheLoader;
            this.f64059b = executor;
        }

        @Override // com.google.common.cache.CacheLoader
        public V load(K k) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) ? (V) this.f64058a.load(k) : (V) invokeL.objValue;
        }

        @Override // com.google.common.cache.CacheLoader
        public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iterable)) == null) ? this.f64058a.loadAll(iterable) : (Map) invokeL.objValue;
        }

        @Override // com.google.common.cache.CacheLoader
        public ListenableFuture<V> reload(K k, V v) throws Exception {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k, v)) == null) {
                ListenableFutureTask create = ListenableFutureTask.create(new CallableC1908a(this, k, v));
                this.f64059b.execute(create);
                return create;
            }
            return (ListenableFuture) invokeLL.objValue;
        }
    }

    public CacheLoader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> cacheLoader, Executor executor) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, cacheLoader, executor)) == null) {
            n.p(cacheLoader);
            n.p(executor);
            return new a(cacheLoader, executor);
        }
        return (CacheLoader) invokeLL.objValue;
    }

    public static <K, V> CacheLoader<K, V> from(g<K, V> gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gVar)) == null) ? new FunctionToCacheLoader(gVar) : (CacheLoader) invokeL.objValue;
    }

    public abstract V load(K k) throws Exception;

    public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iterable)) == null) {
            throw new UnsupportedLoadingOperationException();
        }
        return (Map) invokeL.objValue;
    }

    public ListenableFuture<V> reload(K k, V v) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, k, v)) == null) {
            n.p(k);
            n.p(v);
            return Futures.immediateFuture(load(k));
        }
        return (ListenableFuture) invokeLL.objValue;
    }

    public static <V> CacheLoader<Object, V> from(r<V> rVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, rVar)) == null) ? new SupplierToCacheLoader(rVar) : (CacheLoader) invokeL.objValue;
    }
}
