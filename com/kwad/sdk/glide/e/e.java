package com.kwad.sdk.glide.e;

import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f37691a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, List<a<?, ?>>> f37692b;

    /* loaded from: classes7.dex */
    public static class a<T, R> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Class<R> f37693a;

        /* renamed from: b  reason: collision with root package name */
        public final com.kwad.sdk.glide.load.f<T, R> f37694b;

        /* renamed from: c  reason: collision with root package name */
        public final Class<T> f37695c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, com.kwad.sdk.glide.load.f<T, R> fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, cls2, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37695c = cls;
            this.f37693a = cls2;
            this.f37694b = fVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, cls2)) == null) ? this.f37695c.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f37693a) : invokeLL.booleanValue;
        }
    }

    public e() {
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
        this.f37691a = new ArrayList();
        this.f37692b = new HashMap();
    }

    @NonNull
    private synchronized List<a<?, ?>> a(@NonNull String str) {
        InterceptResult invokeL;
        List<a<?, ?>> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, str)) == null) {
            synchronized (this) {
                if (!this.f37691a.contains(str)) {
                    this.f37691a.add(str);
                }
                list = this.f37692b.get(str);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f37692b.put(str, list);
                }
            }
            return list;
        }
        return (List) invokeL.objValue;
    }

    @NonNull
    public synchronized <T, R> List<com.kwad.sdk.glide.load.f<T, R>> a(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        InterceptResult invokeLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, cls2)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (String str : this.f37691a) {
                    List<a<?, ?>> list = this.f37692b.get(str);
                    if (list != null) {
                        for (a<?, ?> aVar : list) {
                            if (aVar.a(cls, cls2)) {
                                arrayList.add(aVar.f37694b);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull com.kwad.sdk.glide.load.f<T, R> fVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, fVar, cls, cls2) == null) {
            synchronized (this) {
                a(str).add(new a<>(cls, cls2, fVar));
            }
        }
    }

    public synchronized void a(@NonNull List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            synchronized (this) {
                ArrayList<String> arrayList = new ArrayList(this.f37691a);
                this.f37691a.clear();
                this.f37691a.addAll(list);
                for (String str : arrayList) {
                    if (!list.contains(str)) {
                        this.f37691a.add(str);
                    }
                }
            }
        }
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        InterceptResult invokeLL;
        ArrayList arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, cls, cls2)) == null) {
            synchronized (this) {
                arrayList = new ArrayList();
                for (String str : this.f37691a) {
                    List<a<?, ?>> list = this.f37692b.get(str);
                    if (list != null) {
                        for (a<?, ?> aVar : list) {
                            if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f37693a)) {
                                arrayList.add(aVar.f37693a);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public synchronized <T, R> void b(@NonNull String str, @NonNull com.kwad.sdk.glide.load.f<T, R> fVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, str, fVar, cls, cls2) == null) {
            synchronized (this) {
                a(str).add(0, new a<>(cls, cls2, fVar));
            }
        }
    }
}
