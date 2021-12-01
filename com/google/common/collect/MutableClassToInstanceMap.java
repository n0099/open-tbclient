package com.google.common.collect;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.n;
import c.i.d.c.d0;
import c.i.d.c.e0;
import c.i.d.c.j0;
import c.i.d.c.m1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public final class MutableClassToInstanceMap<B> extends d0<Class<? extends B>, B> implements Object<B>, Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Class<? extends B>, B> delegate;

    /* loaded from: classes2.dex */
    public static final class SerializedForm<B> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Class<? extends B>, B> backingMap;

        public SerializedForm(Map<Class<? extends B>, B> map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.backingMap = map;
        }

        public Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? MutableClassToInstanceMap.create(this.backingMap) : invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends e0<Class<? extends B>, B> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map.Entry f56375e;

        public a(Map.Entry entry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {entry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56375e = entry;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.h0
        /* renamed from: d */
        public Map.Entry<Class<? extends B>, B> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f56375e : (Map.Entry) invokeV.objValue;
        }

        @Override // c.i.d.c.e0, java.util.Map.Entry
        public B setValue(B b2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2)) == null) ? (B) super.setValue(MutableClassToInstanceMap.cast(getKey(), b2)) : (B) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends j0<Map.Entry<Class<? extends B>, B>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MutableClassToInstanceMap f56376e;

        /* loaded from: classes2.dex */
        public class a extends m1<Map.Entry<Class<? extends B>, B>, Map.Entry<Class<? extends B>, B>> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, Iterator it) {
                super(it);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, it};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        super((Iterator) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // c.i.d.c.m1
            /* renamed from: b */
            public Map.Entry<Class<? extends B>, B> a(Map.Entry<Class<? extends B>, B> entry) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) ? MutableClassToInstanceMap.checkedEntry(entry) : (Map.Entry) invokeL.objValue;
            }
        }

        public b(MutableClassToInstanceMap mutableClassToInstanceMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mutableClassToInstanceMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56376e = mutableClassToInstanceMap;
        }

        @Override // c.i.d.c.y, java.util.Collection, java.lang.Iterable, c.i.d.c.s0
        public Iterator<Map.Entry<Class<? extends B>, B>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new a(this, delegate().iterator()) : (Iterator) invokeV.objValue;
        }

        @Override // c.i.d.c.y, java.util.Collection
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? standardToArray() : (Object[]) invokeV.objValue;
        }

        @Override // c.i.d.c.y, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, tArr)) == null) ? (T[]) standardToArray(tArr) : (T[]) ((Object[]) invokeL.objValue);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.j0, c.i.d.c.y, c.i.d.c.h0
        public Set<Map.Entry<Class<? extends B>, B>> delegate() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f56376e.delegate().entrySet() : (Set) invokeV.objValue;
        }
    }

    public MutableClassToInstanceMap(Map<Class<? extends B>, B> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        n.p(map);
        this.delegate = map;
    }

    public static <B, T extends B> T cast(Class<T> cls, B b2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cls, b2)) == null) ? (T) c.i.d.g.a.d(cls).cast(b2) : (T) invokeLL.objValue;
    }

    public static <B> Map.Entry<Class<? extends B>, B> checkedEntry(Map.Entry<Class<? extends B>, B> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, entry)) == null) ? new a(entry) : (Map.Entry) invokeL.objValue;
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? new MutableClassToInstanceMap<>(new HashMap()) : (MutableClassToInstanceMap) invokeV.objValue;
    }

    private Object writeReplace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) ? new SerializedForm(delegate()) : invokeV.objValue;
    }

    @Override // c.i.d.c.d0, java.util.Map
    public Set<Map.Entry<Class<? extends B>, B>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new b(this) : (Set) invokeV.objValue;
    }

    public <T extends B> T getInstance(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, cls)) == null) ? (T) cast(cls, get(cls)) : (T) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.i.d.c.d0, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((Class<? extends Class<? extends B>>) obj, (Class<? extends B>) obj2);
    }

    @Override // c.i.d.c.d0, java.util.Map
    public void putAll(Map<? extends Class<? extends B>, ? extends B> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, map) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                cast((Class) entry.getKey(), entry.getValue());
            }
            super.putAll(linkedHashMap);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Class<T extends B> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: T extends B */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends B> T putInstance(Class<T> cls, T t) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, cls, t)) == null) ? (T) cast(cls, put((Class<? extends Class<T>>) cls, (Class<T>) t)) : (T) invokeLL.objValue;
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, map)) == null) ? new MutableClassToInstanceMap<>(map) : (MutableClassToInstanceMap) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.i.d.c.d0, c.i.d.c.h0
    public Map<Class<? extends B>, B> delegate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.delegate : (Map) invokeV.objValue;
    }

    public B put(Class<? extends B> cls, B b2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, cls, b2)) == null) ? (B) super.put((MutableClassToInstanceMap<B>) cls, (Class<? extends B>) cast(cls, b2)) : (B) invokeLL.objValue;
    }
}
