package com.google.common.base;

import androidx.core.view.InputDeviceCompat;
import c.i.d.a.g;
import c.i.d.a.n;
import c.i.d.a.r;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes9.dex */
public abstract class Optional<T> implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements Iterable<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Iterable f70634e;

        /* renamed from: com.google.common.base.Optional$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1958a extends AbstractIterator<T> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: g  reason: collision with root package name */
            public final Iterator<? extends Optional<? extends T>> f70635g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ a f70636h;

            /* JADX DEBUG: Type inference failed for r6v4. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator<? extends com.google.common.base.Optional<? extends T>> */
            public C1958a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f70636h = aVar;
                Iterator it = this.f70636h.f70634e.iterator();
                n.p(it);
                this.f70635g = (Iterator<T>) it;
            }

            @Override // com.google.common.base.AbstractIterator
            public T a() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    while (this.f70635g.hasNext()) {
                        Optional<? extends T> next = this.f70635g.next();
                        if (next.isPresent()) {
                            return next.get();
                        }
                    }
                    return b();
                }
                return (T) invokeV.objValue;
            }
        }

        public a(Iterable iterable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iterable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f70634e = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C1958a(this) : (Iterator) invokeV.objValue;
        }
    }

    public Optional() {
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

    public static <T> Optional<T> absent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? Absent.withType() : (Optional) invokeV.objValue;
    }

    public static <T> Optional<T> fromNullable(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, t)) == null) ? t == null ? absent() : new Present(t) : (Optional) invokeL.objValue;
    }

    public static <T> Optional<T> of(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, t)) == null) {
            n.p(t);
            return new Present(t);
        }
        return (Optional) invokeL.objValue;
    }

    public static <T> Iterable<T> presentInstances(Iterable<? extends Optional<? extends T>> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, iterable)) == null) {
            n.p(iterable);
            return new a(iterable);
        }
        return (Iterable) invokeL.objValue;
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    public abstract T or(r<? extends T> rVar);

    public abstract T or(T t);

    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(g<? super T, V> gVar);
}
