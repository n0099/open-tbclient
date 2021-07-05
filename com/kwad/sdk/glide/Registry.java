package com.kwad.sdk.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.a.e;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.b.o;
import com.kwad.sdk.glide.load.b.p;
import com.kwad.sdk.glide.load.engine.q;
import com.kwad.sdk.glide.load.engine.s;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes7.dex */
public class Registry {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final p f37551a;

    /* renamed from: b  reason: collision with root package name */
    public final com.kwad.sdk.glide.e.a f37552b;

    /* renamed from: c  reason: collision with root package name */
    public final com.kwad.sdk.glide.e.e f37553c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.e.f f37554d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.a.f f37555e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.resource.e.f f37556f;

    /* renamed from: g  reason: collision with root package name */
    public final com.kwad.sdk.glide.e.b f37557g;

    /* renamed from: h  reason: collision with root package name */
    public final com.kwad.sdk.glide.e.d f37558h;

    /* renamed from: i  reason: collision with root package name */
    public final com.kwad.sdk.glide.e.c f37559i;
    public final Pools.Pool<List<Throwable>> j;

    /* loaded from: classes7.dex */
    public static class MissingComponentException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MissingComponentException(@NonNull String str) {
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

    /* loaded from: classes7.dex */
    public static final class NoImageHeaderParserException extends MissingComponentException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
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

    /* loaded from: classes7.dex */
    public static class NoModelLoaderAvailableException extends MissingComponentException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoModelLoaderAvailableException(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, cls2};
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoModelLoaderAvailableException(@NonNull Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {obj};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class NoResultEncoderAvailableException extends MissingComponentException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoResultEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls};
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

    /* loaded from: classes7.dex */
    public static class NoSourceEncoderAvailableException extends MissingComponentException {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NoSourceEncoderAvailableException(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls};
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

    public Registry() {
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
        this.f37558h = new com.kwad.sdk.glide.e.d();
        this.f37559i = new com.kwad.sdk.glide.e.c();
        Pools.Pool<List<Throwable>> a2 = com.kwad.sdk.glide.g.a.a.a();
        this.j = a2;
        this.f37551a = new p(a2);
        this.f37552b = new com.kwad.sdk.glide.e.a();
        this.f37553c = new com.kwad.sdk.glide.e.e();
        this.f37554d = new com.kwad.sdk.glide.e.f();
        this.f37555e = new com.kwad.sdk.glide.load.a.f();
        this.f37556f = new com.kwad.sdk.glide.load.resource.e.f();
        this.f37557g = new com.kwad.sdk.glide.e.b();
        a(Arrays.asList(com.bumptech.glide.Registry.BUCKET_GIF, com.bumptech.glide.Registry.BUCKET_BITMAP, com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE));
    }

    @NonNull
    private <Data, TResource, Transcode> List<com.kwad.sdk.glide.load.engine.g<Data, TResource, Transcode>> c(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, cls, cls2, cls3)) == null) {
            ArrayList arrayList = new ArrayList();
            for (Class cls4 : this.f37553c.b(cls, cls2)) {
                for (Class cls5 : this.f37556f.b(cls4, cls3)) {
                    arrayList.add(new com.kwad.sdk.glide.load.engine.g(cls, cls4, cls5, this.f37553c.a(cls, cls4), this.f37556f.a(cls4, cls5), this.j));
                }
            }
            return arrayList;
        }
        return (List) invokeLLL.objValue;
    }

    @NonNull
    public Registry a(@NonNull ImageHeaderParser imageHeaderParser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageHeaderParser)) == null) {
            this.f37557g.a(imageHeaderParser);
            return this;
        }
        return (Registry) invokeL.objValue;
    }

    @NonNull
    public Registry a(@NonNull e.a<?> aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            this.f37555e.a(aVar);
            return this;
        }
        return (Registry) invokeL.objValue;
    }

    @NonNull
    public <Data> Registry a(@NonNull Class<Data> cls, @NonNull com.kwad.sdk.glide.load.a<Data> aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, cls, aVar)) == null) {
            this.f37552b.a(cls, aVar);
            return this;
        }
        return (Registry) invokeLL.objValue;
    }

    @NonNull
    public <TResource> Registry a(@NonNull Class<TResource> cls, @NonNull com.kwad.sdk.glide.load.g<TResource> gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cls, gVar)) == null) {
            this.f37554d.a(cls, gVar);
            return this;
        }
        return (Registry) invokeLL.objValue;
    }

    @NonNull
    public <Model, Data> Registry a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048580, this, cls, cls2, oVar)) == null) {
            this.f37551a.a(cls, cls2, oVar);
            return this;
        }
        return (Registry) invokeLLL.objValue;
    }

    @NonNull
    public <Data, TResource> Registry a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.kwad.sdk.glide.load.f<Data, TResource> fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048581, this, cls, cls2, fVar)) == null) {
            a(com.bumptech.glide.Registry.BUCKET_APPEND_ALL, cls, cls2, fVar);
            return this;
        }
        return (Registry) invokeLLL.objValue;
    }

    @NonNull
    public <TResource, Transcode> Registry a(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull com.kwad.sdk.glide.load.resource.e.e<TResource, Transcode> eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048582, this, cls, cls2, eVar)) == null) {
            this.f37556f.a(cls, cls2, eVar);
            return this;
        }
        return (Registry) invokeLLL.objValue;
    }

    @NonNull
    public <Data, TResource> Registry a(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.kwad.sdk.glide.load.f<Data, TResource> fVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, str, cls, cls2, fVar)) == null) {
            this.f37553c.a(str, fVar, cls, cls2);
            return this;
        }
        return (Registry) invokeLLLL.objValue;
    }

    @NonNull
    public final Registry a(@NonNull List<String> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list)) == null) {
            ArrayList arrayList = new ArrayList(list.size());
            arrayList.addAll(list);
            arrayList.add(0, com.bumptech.glide.Registry.BUCKET_PREPEND_ALL);
            arrayList.add(com.bumptech.glide.Registry.BUCKET_APPEND_ALL);
            this.f37553c.a(arrayList);
            return this;
        }
        return (Registry) invokeL.objValue;
    }

    @NonNull
    public <X> com.kwad.sdk.glide.load.a<X> a(@NonNull X x) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, x)) == null) {
            com.kwad.sdk.glide.load.a<X> a2 = this.f37552b.a(x.getClass());
            if (a2 != null) {
                return a2;
            }
            throw new NoSourceEncoderAvailableException(x.getClass());
        }
        return (com.kwad.sdk.glide.load.a) invokeL.objValue;
    }

    @Nullable
    public <Data, TResource, Transcode> q<Data, TResource, Transcode> a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, cls, cls2, cls3)) == null) {
            q<Data, TResource, Transcode> a2 = this.f37559i.a(cls, cls2, cls3);
            if (this.f37559i.a(a2)) {
                return null;
            }
            if (a2 == null) {
                List<com.kwad.sdk.glide.load.engine.g<Data, TResource, Transcode>> c2 = c(cls, cls2, cls3);
                a2 = c2.isEmpty() ? null : new q<>(cls, cls2, cls3, c2, this.j);
                this.f37559i.a(cls, cls2, cls3, a2);
            }
            return a2;
        }
        return (q) invokeLLL.objValue;
    }

    @NonNull
    public List<ImageHeaderParser> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            List<ImageHeaderParser> a2 = this.f37557g.a();
            if (a2.isEmpty()) {
                throw new NoImageHeaderParserException();
            }
            return a2;
        }
        return (List) invokeV.objValue;
    }

    public boolean a(@NonNull s<?> sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, sVar)) == null) ? this.f37554d.a(sVar.a()) != null : invokeL.booleanValue;
    }

    @NonNull
    public <TResource> Registry b(@NonNull Class<TResource> cls, @NonNull com.kwad.sdk.glide.load.g<TResource> gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, cls, gVar)) == null) {
            this.f37554d.b(cls, gVar);
            return this;
        }
        return (Registry) invokeLL.objValue;
    }

    @NonNull
    public <Data, TResource> Registry b(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.kwad.sdk.glide.load.f<Data, TResource> fVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, cls, cls2, fVar)) == null) {
            b(com.bumptech.glide.Registry.BUCKET_PREPEND_ALL, cls, cls2, fVar);
            return this;
        }
        return (Registry) invokeLLL.objValue;
    }

    @NonNull
    public <Data, TResource> Registry b(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull com.kwad.sdk.glide.load.f<Data, TResource> fVar) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048591, this, str, cls, cls2, fVar)) == null) {
            this.f37553c.b(str, fVar, cls, cls2);
            return this;
        }
        return (Registry) invokeLLLL.objValue;
    }

    @NonNull
    public <X> com.kwad.sdk.glide.load.a.e<X> b(@NonNull X x) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, x)) == null) ? this.f37555e.a((com.kwad.sdk.glide.load.a.f) x) : (com.kwad.sdk.glide.load.a.e) invokeL.objValue;
    }

    @NonNull
    public <X> com.kwad.sdk.glide.load.g<X> b(@NonNull s<X> sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, sVar)) == null) {
            com.kwad.sdk.glide.load.g<X> a2 = this.f37554d.a(sVar.a());
            if (a2 != null) {
                return a2;
            }
            throw new NoResultEncoderAvailableException(sVar.a());
        }
        return (com.kwad.sdk.glide.load.g) invokeL.objValue;
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> b(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048594, this, cls, cls2, cls3)) == null) {
            List<Class<?>> a2 = this.f37558h.a(cls, cls2, cls3);
            if (a2 == null) {
                a2 = new ArrayList<>();
                for (Class<?> cls4 : this.f37551a.a((Class<?>) cls)) {
                    for (Class<?> cls5 : this.f37553c.b(cls4, cls2)) {
                        if (!this.f37556f.b(cls5, cls3).isEmpty() && !a2.contains(cls5)) {
                            a2.add(cls5);
                        }
                    }
                }
                this.f37558h.a(cls, cls2, cls3, Collections.unmodifiableList(a2));
            }
            return a2;
        }
        return (List) invokeLLL.objValue;
    }

    @NonNull
    public <Model> List<n<Model, ?>> c(@NonNull Model model) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, model)) == null) {
            List<n<Model, ?>> a2 = this.f37551a.a((p) model);
            if (a2.isEmpty()) {
                throw new NoModelLoaderAvailableException(model);
            }
            return a2;
        }
        return (List) invokeL.objValue;
    }
}
