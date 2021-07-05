package com.kwad.sdk.glide.load.engine;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.Registry;
import com.kwad.sdk.glide.load.b.n;
import com.kwad.sdk.glide.load.engine.DecodeJob;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class f<Transcode> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final List<n.a<?>> f38071a;

    /* renamed from: b  reason: collision with root package name */
    public final List<com.kwad.sdk.glide.load.c> f38072b;

    /* renamed from: c  reason: collision with root package name */
    public com.kwad.sdk.glide.e f38073c;

    /* renamed from: d  reason: collision with root package name */
    public Object f38074d;

    /* renamed from: e  reason: collision with root package name */
    public int f38075e;

    /* renamed from: f  reason: collision with root package name */
    public int f38076f;

    /* renamed from: g  reason: collision with root package name */
    public Class<?> f38077g;

    /* renamed from: h  reason: collision with root package name */
    public DecodeJob.d f38078h;

    /* renamed from: i  reason: collision with root package name */
    public com.kwad.sdk.glide.load.e f38079i;
    public Map<Class<?>, com.kwad.sdk.glide.load.h<?>> j;
    public Class<Transcode> k;
    public boolean l;
    public boolean m;
    public com.kwad.sdk.glide.load.c n;
    public Priority o;
    public h p;
    public boolean q;
    public boolean r;

    public f() {
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
        this.f38071a = new ArrayList();
        this.f38072b = new ArrayList();
    }

    public <X> com.kwad.sdk.glide.load.a<X> a(X x) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x)) == null) ? this.f38073c.d().a((Registry) x) : (com.kwad.sdk.glide.load.a) invokeL.objValue;
    }

    public List<com.kwad.sdk.glide.load.b.n<File, ?>> a(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file)) == null) ? this.f38073c.d().c(file) : (List) invokeL.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f38073c = null;
            this.f38074d = null;
            this.n = null;
            this.f38077g = null;
            this.k = null;
            this.f38079i = null;
            this.o = null;
            this.j = null;
            this.p = null;
            this.f38071a.clear();
            this.l = false;
            this.f38072b.clear();
            this.m = false;
        }
    }

    public <R> void a(com.kwad.sdk.glide.e eVar, Object obj, com.kwad.sdk.glide.load.c cVar, int i2, int i3, h hVar, Class<?> cls, Class<R> cls2, Priority priority, com.kwad.sdk.glide.load.e eVar2, Map<Class<?>, com.kwad.sdk.glide.load.h<?>> map, boolean z, boolean z2, DecodeJob.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{eVar, obj, cVar, Integer.valueOf(i2), Integer.valueOf(i3), hVar, cls, cls2, priority, eVar2, map, Boolean.valueOf(z), Boolean.valueOf(z2), dVar}) == null) {
            this.f38073c = eVar;
            this.f38074d = obj;
            this.n = cVar;
            this.f38075e = i2;
            this.f38076f = i3;
            this.p = hVar;
            this.f38077g = cls;
            this.f38078h = dVar;
            this.k = cls2;
            this.o = priority;
            this.f38079i = eVar2;
            this.j = map;
            this.q = z;
            this.r = z2;
        }
    }

    public boolean a(com.kwad.sdk.glide.load.c cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cVar)) == null) {
            List<n.a<?>> n = n();
            int size = n.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (n.get(i2).f37878a.equals(cVar)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean a(s<?> sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sVar)) == null) ? this.f38073c.d().a(sVar) : invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, cls)) == null) ? b(cls) != null : invokeL.booleanValue;
    }

    public com.kwad.sdk.glide.load.engine.a.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f38078h.a() : (com.kwad.sdk.glide.load.engine.a.a) invokeV.objValue;
    }

    public <Data> q<Data, ?, Transcode> b(Class<Data> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls)) == null) ? this.f38073c.d().a(cls, this.f38077g, this.k) : (q) invokeL.objValue;
    }

    public <Z> com.kwad.sdk.glide.load.g<Z> b(s<Z> sVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, sVar)) == null) ? this.f38073c.d().b((s) sVar) : (com.kwad.sdk.glide.load.g) invokeL.objValue;
    }

    public h c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.p : (h) invokeV.objValue;
    }

    public <Z> com.kwad.sdk.glide.load.h<Z> c(Class<Z> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cls)) == null) {
            com.kwad.sdk.glide.load.h<Z> hVar = (com.kwad.sdk.glide.load.h<Z>) this.j.get(cls);
            if (hVar == null) {
                Iterator<Map.Entry<Class<?>, com.kwad.sdk.glide.load.h<?>>> it = this.j.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<Class<?>, com.kwad.sdk.glide.load.h<?>> next = it.next();
                    if (next.getKey().isAssignableFrom(cls)) {
                        hVar = (com.kwad.sdk.glide.load.h<Z>) next.getValue();
                        break;
                    }
                }
            }
            if (hVar == null) {
                if (this.j.isEmpty() && this.q) {
                    throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
                }
                return com.kwad.sdk.glide.load.resource.b.a();
            }
            return hVar;
        }
        return (com.kwad.sdk.glide.load.h) invokeL.objValue;
    }

    public Priority d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.o : (Priority) invokeV.objValue;
    }

    public com.kwad.sdk.glide.load.e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f38079i : (com.kwad.sdk.glide.load.e) invokeV.objValue;
    }

    public com.kwad.sdk.glide.load.c f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.n : (com.kwad.sdk.glide.load.c) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f38075e : invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f38076f : invokeV.intValue;
    }

    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f38073c.f() : (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) invokeV.objValue;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.lang.Class<Transcode>, java.lang.Class<?> */
    public Class<?> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (Class<Transcode>) this.k : (Class) invokeV.objValue;
    }

    public Class<?> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f38074d.getClass() : (Class) invokeV.objValue;
    }

    public List<Class<?>> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f38073c.d().b(this.f38074d.getClass(), this.f38077g, this.k) : (List) invokeV.objValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public List<n.a<?>> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (!this.l) {
                this.l = true;
                this.f38071a.clear();
                List c2 = this.f38073c.d().c(this.f38074d);
                int size = c2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    n.a<?> a2 = ((com.kwad.sdk.glide.load.b.n) c2.get(i2)).a(this.f38074d, this.f38075e, this.f38076f, this.f38079i);
                    if (a2 != null) {
                        this.f38071a.add(a2);
                    }
                }
            }
            return this.f38071a;
        }
        return (List) invokeV.objValue;
    }

    public List<com.kwad.sdk.glide.load.c> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (!this.m) {
                this.m = true;
                this.f38072b.clear();
                List<n.a<?>> n = n();
                int size = n.size();
                for (int i2 = 0; i2 < size; i2++) {
                    n.a<?> aVar = n.get(i2);
                    if (!this.f38072b.contains(aVar.f37878a)) {
                        this.f38072b.add(aVar.f37878a);
                    }
                    for (int i3 = 0; i3 < aVar.f37879b.size(); i3++) {
                        if (!this.f38072b.contains(aVar.f37879b.get(i3))) {
                            this.f38072b.add(aVar.f37879b.get(i3));
                        }
                    }
                }
            }
            return this.f38072b;
        }
        return (List) invokeV.objValue;
    }
}
