package com.google.common.base;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import d.h.c.a.g;
import d.h.c.a.n;
import java.io.Serializable;
import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class Converter<A, B> implements g<A, B> {

    /* renamed from: e  reason: collision with root package name */
    public transient Converter<B, A> f30677e;
    public final boolean handleNullAutomatically;

    /* loaded from: classes6.dex */
    public static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        public static final long serialVersionUID = 0;
        public final Converter<A, B> first;
        public final Converter<B, C> second;

        public ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        @Override // com.google.common.base.Converter
        public A correctedDoBackward(C c2) {
            return this.first.correctedDoBackward(this.second.correctedDoBackward(c2));
        }

        @Override // com.google.common.base.Converter
        public C correctedDoForward(A a2) {
            return this.second.correctedDoForward(this.first.correctedDoForward(a2));
        }

        @Override // com.google.common.base.Converter
        public A doBackward(C c2) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public C doForward(A a2) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, d.h.c.a.g
        public boolean equals(Object obj) {
            if (obj instanceof ConverterComposition) {
                ConverterComposition converterComposition = (ConverterComposition) obj;
                return this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second);
            }
            return false;
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + SmallTailInfo.EMOTION_SUFFIX;
        }
    }

    /* loaded from: classes6.dex */
    public static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        public final g<? super B, ? extends A> backwardFunction;
        public final g<? super A, ? extends B> forwardFunction;

        public /* synthetic */ FunctionBasedConverter(g gVar, g gVar2, a aVar) {
            this(gVar, gVar2);
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b2) {
            return this.backwardFunction.apply(b2);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a2) {
            return this.forwardFunction.apply(a2);
        }

        @Override // com.google.common.base.Converter, d.h.c.a.g
        public boolean equals(Object obj) {
            if (obj instanceof FunctionBasedConverter) {
                FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
                return this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction);
            }
            return false;
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.backwardFunction + SmallTailInfo.EMOTION_SUFFIX;
        }

        public FunctionBasedConverter(g<? super A, ? extends B> gVar, g<? super B, ? extends A> gVar2) {
            n.p(gVar);
            this.forwardFunction = gVar;
            n.p(gVar2);
            this.backwardFunction = gVar2;
        }
    }

    /* loaded from: classes6.dex */
    public static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        public static final IdentityConverter INSTANCE = new IdentityConverter();
        public static final long serialVersionUID = 0;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            n.q(converter, "otherConverter");
            return converter;
        }

        @Override // com.google.common.base.Converter
        public T doBackward(T t) {
            return t;
        }

        @Override // com.google.common.base.Converter
        public T doForward(T t) {
            return t;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.base.Converter
        public IdentityConverter<T> reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    /* loaded from: classes6.dex */
    public static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        public static final long serialVersionUID = 0;
        public final Converter<A, B> original;

        public ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        @Override // com.google.common.base.Converter
        public B correctedDoBackward(A a2) {
            return this.original.correctedDoForward(a2);
        }

        @Override // com.google.common.base.Converter
        public A correctedDoForward(B b2) {
            return this.original.correctedDoBackward(b2);
        }

        @Override // com.google.common.base.Converter
        public B doBackward(A a2) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public A doForward(B b2) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, d.h.c.a.g
        public boolean equals(Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.original;
        }

        public String toString() {
            return this.original + ".reverse()";
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Iterable<B> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Iterable f30678e;

        /* renamed from: com.google.common.base.Converter$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0352a implements Iterator<B> {

            /* renamed from: e  reason: collision with root package name */
            public final Iterator<? extends A> f30680e;

            public C0352a() {
                this.f30680e = a.this.f30678e.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f30680e.hasNext();
            }

            @Override // java.util.Iterator
            public B next() {
                return (B) Converter.this.convert(this.f30680e.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f30680e.remove();
            }
        }

        public a(Iterable iterable) {
            this.f30678e = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<B> iterator() {
            return new C0352a();
        }
    }

    public Converter() {
        this(true);
    }

    public static <A, B> Converter<A, B> from(g<? super A, ? extends B> gVar, g<? super B, ? extends A> gVar2) {
        return new FunctionBasedConverter(gVar, gVar2, null);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @Override // d.h.c.a.g
    @Deprecated
    public final B apply(A a2) {
        return convert(a2);
    }

    public final B convert(A a2) {
        return correctedDoForward(a2);
    }

    public Iterable<B> convertAll(Iterable<? extends A> iterable) {
        n.q(iterable, "fromIterable");
        return new a(iterable);
    }

    public A correctedDoBackward(B b2) {
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

    public B correctedDoForward(A a2) {
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

    public <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        n.p(converter);
        return new ConverterComposition(this, converter);
    }

    public abstract A doBackward(B b2);

    public abstract B doForward(A a2);

    @Override // d.h.c.a.g
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.f30677e;
        if (converter == null) {
            ReverseConverter reverseConverter = new ReverseConverter(this);
            this.f30677e = reverseConverter;
            return reverseConverter;
        }
        return converter;
    }

    public Converter(boolean z) {
        this.handleNullAutomatically = z;
    }
}
