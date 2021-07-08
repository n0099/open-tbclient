package com.google.common.base;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.d.a.g;
import d.f.d.a.n;
import java.io.Serializable;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class Converter<A, B> implements g<A, B> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean handleNullAutomatically;
    public transient Converter<B, A> reverse;

    /* loaded from: classes6.dex */
    public static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Converter<A, B> first;
        public final Converter<B, C> second;

        public ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {converter, converter2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.first = converter;
            this.second = converter2;
        }

        @Override // com.google.common.base.Converter
        public A correctedDoBackward(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c2)) == null) ? this.first.correctedDoBackward(this.second.correctedDoBackward(c2)) : (A) invokeL.objValue;
        }

        @Override // com.google.common.base.Converter
        public C correctedDoForward(A a2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a2)) == null) ? this.second.correctedDoForward(this.first.correctedDoForward(a2)) : (C) invokeL.objValue;
        }

        @Override // com.google.common.base.Converter
        public A doBackward(C c2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, c2)) == null) {
                throw new AssertionError();
            }
            return (A) invokeL.objValue;
        }

        @Override // com.google.common.base.Converter
        public C doForward(A a2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, a2)) == null) {
                throw new AssertionError();
            }
            return (C) invokeL.objValue;
        }

        @Override // com.google.common.base.Converter, d.f.d.a.g
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (obj instanceof ConverterComposition) {
                    ConverterComposition converterComposition = (ConverterComposition) obj;
                    return this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (this.first.hashCode() * 31) + this.second.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.first + ".andThen(" + this.second + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final g<? super B, ? extends A> backwardFunction;
        public final g<? super A, ? extends B> forwardFunction;

        public /* synthetic */ FunctionBasedConverter(g gVar, g gVar2, a aVar) {
            this(gVar, gVar2);
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, b2)) == null) ? this.backwardFunction.apply(b2) : (A) invokeL.objValue;
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a2)) == null) ? this.forwardFunction.apply(a2) : (B) invokeL.objValue;
        }

        @Override // com.google.common.base.Converter, d.f.d.a.g
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof FunctionBasedConverter) {
                    FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
                    return this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return "Converter.from(" + this.forwardFunction + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.backwardFunction + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }

        public FunctionBasedConverter(g<? super A, ? extends B> gVar, g<? super B, ? extends A> gVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, gVar2};
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
            this.forwardFunction = gVar;
            n.p(gVar2);
            this.backwardFunction = gVar2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final IdentityConverter INSTANCE;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(987005395, "Lcom/google/common/base/Converter$IdentityConverter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(987005395, "Lcom/google/common/base/Converter$IdentityConverter;");
                    return;
                }
            }
            INSTANCE = new IdentityConverter();
        }

        public IdentityConverter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        private Object readResolve() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? INSTANCE : invokeV.objValue;
        }

        @Override // com.google.common.base.Converter
        public <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, converter)) == null) {
                n.q(converter, "otherConverter");
                return converter;
            }
            return (Converter) invokeL.objValue;
        }

        @Override // com.google.common.base.Converter
        public T doBackward(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t)) == null) ? t : (T) invokeL.objValue;
        }

        @Override // com.google.common.base.Converter
        public T doForward(T t) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, t)) == null) ? t : (T) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public IdentityConverter<T> reverse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this : (IdentityConverter) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "Converter.identity()" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public final Converter<A, B> original;

        public ReverseConverter(Converter<A, B> converter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {converter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.original = converter;
        }

        @Override // com.google.common.base.Converter
        public B correctedDoBackward(A a2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, a2)) == null) ? this.original.correctedDoForward(a2) : (B) invokeL.objValue;
        }

        @Override // com.google.common.base.Converter
        public A correctedDoForward(B b2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2)) == null) ? this.original.correctedDoBackward(b2) : (A) invokeL.objValue;
        }

        @Override // com.google.common.base.Converter
        public B doBackward(A a2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a2)) == null) {
                throw new AssertionError();
            }
            return (B) invokeL.objValue;
        }

        @Override // com.google.common.base.Converter
        public A doForward(B b2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, b2)) == null) {
                throw new AssertionError();
            }
            return (A) invokeL.objValue;
        }

        @Override // com.google.common.base.Converter, d.f.d.a.g
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (obj instanceof ReverseConverter) {
                    return this.original.equals(((ReverseConverter) obj).original);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ~this.original.hashCode() : invokeV.intValue;
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.original : (Converter) invokeV.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.original + ".reverse()";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Iterable<B> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Iterable f33000e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Converter f33001f;

        /* renamed from: com.google.common.base.Converter$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0378a implements Iterator<B> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final Iterator<? extends A> f33002e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ a f33003f;

            public C0378a(a aVar) {
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
                this.f33003f = aVar;
                this.f33002e = this.f33003f.f33000e.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f33002e.hasNext() : invokeV.booleanValue;
            }

            @Override // java.util.Iterator
            public B next() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (B) this.f33003f.f33001f.convert(this.f33002e.next()) : (B) invokeV.objValue;
            }

            @Override // java.util.Iterator
            public void remove() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                    this.f33002e.remove();
                }
            }
        }

        public a(Converter converter, Iterable iterable) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {converter, iterable};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f33001f = converter;
            this.f33000e = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<B> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new C0378a(this) : (Iterator) invokeV.objValue;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Converter() {
        this(true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static <A, B> Converter<A, B> from(g<? super A, ? extends B> gVar, g<? super B, ? extends A> gVar2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, gVar, gVar2)) == null) ? new FunctionBasedConverter(gVar, gVar2, null) : (Converter) invokeLL.objValue;
    }

    public static <T> Converter<T, T> identity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? IdentityConverter.INSTANCE : (Converter) invokeV.objValue;
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, converter)) == null) ? doAndThen(converter) : (Converter) invokeL.objValue;
    }

    @Override // d.f.d.a.g
    @Deprecated
    public final B apply(A a2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, a2)) == null) ? convert(a2) : (B) invokeL.objValue;
    }

    public final B convert(A a2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, a2)) == null) ? correctedDoForward(a2) : (B) invokeL.objValue;
    }

    public Iterable<B> convertAll(Iterable<? extends A> iterable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iterable)) == null) {
            n.q(iterable, "fromIterable");
            return new a(this, iterable);
        }
        return (Iterable) invokeL.objValue;
    }

    public A correctedDoBackward(B b2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, b2)) == null) {
            if (this.handleNullAutomatically) {
                if (b2 == null) {
                    return null;
                }
                A doBackward = doBackward(b2);
                n.p(doBackward);
                return doBackward;
            }
            return doBackward(b2);
        }
        return (A) invokeL.objValue;
    }

    public B correctedDoForward(A a2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, a2)) == null) {
            if (this.handleNullAutomatically) {
                if (a2 == null) {
                    return null;
                }
                B doForward = doForward(a2);
                n.p(doForward);
                return doForward;
            }
            return doForward(a2);
        }
        return (B) invokeL.objValue;
    }

    public <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, converter)) == null) {
            n.p(converter);
            return new ConverterComposition(this, converter);
        }
        return (Converter) invokeL.objValue;
    }

    public abstract A doBackward(B b2);

    public abstract B doForward(A a2);

    @Override // d.f.d.a.g
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) ? super.equals(obj) : invokeL.booleanValue;
    }

    public Converter<B, A> reverse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Converter<B, A> converter = this.reverse;
            if (converter == null) {
                ReverseConverter reverseConverter = new ReverseConverter(this);
                this.reverse = reverseConverter;
                return reverseConverter;
            }
            return converter;
        }
        return (Converter) invokeV.objValue;
    }

    public Converter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.handleNullAutomatically = z;
    }
}
