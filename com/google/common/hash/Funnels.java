package com.google.common.hash;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.h.c.a.n;
import d.h.c.d.j;
import java.io.Serializable;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public final class Funnels {

    /* loaded from: classes6.dex */
    public enum ByteArrayFunnel implements Funnel<byte[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.hash.Funnel
        public void funnel(byte[] bArr, j jVar) {
            jVar.e(bArr);
        }
    }

    /* loaded from: classes6.dex */
    public enum IntegerFunnel implements Funnel<Integer> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.integerFunnel()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.hash.Funnel
        public void funnel(Integer num, j jVar) {
            jVar.b(num.intValue());
        }
    }

    /* loaded from: classes6.dex */
    public enum LongFunnel implements Funnel<Long> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.longFunnel()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.hash.Funnel
        public void funnel(Long l, j jVar) {
            jVar.d(l.longValue());
        }
    }

    /* loaded from: classes6.dex */
    public static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
        public final Funnel<E> elementFunnel;

        public SequentialFunnel(Funnel<E> funnel) {
            n.p(funnel);
            this.elementFunnel = funnel;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SequentialFunnel) {
                return this.elementFunnel.equals(((SequentialFunnel) obj).elementFunnel);
            }
            return false;
        }

        @Override // com.google.common.hash.Funnel
        public /* bridge */ /* synthetic */ void funnel(Object obj, j jVar) {
            funnel((Iterable) ((Iterable) obj), jVar);
        }

        public int hashCode() {
            return SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
        }

        public String toString() {
            return "Funnels.sequentialFunnel(" + this.elementFunnel + SmallTailInfo.EMOTION_SUFFIX;
        }

        public void funnel(Iterable<? extends E> iterable, j jVar) {
            for (E e2 : iterable) {
                this.elementFunnel.funnel(e2, jVar);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
        public final Charset charset;

        /* loaded from: classes6.dex */
        public static class SerializedForm implements Serializable {
            public static final long serialVersionUID = 0;
            public final String charsetCanonicalName;

            public SerializedForm(Charset charset) {
                this.charsetCanonicalName = charset.name();
            }

            private Object readResolve() {
                return Funnels.a(Charset.forName(this.charsetCanonicalName));
            }
        }

        public StringCharsetFunnel(Charset charset) {
            n.p(charset);
            this.charset = charset;
        }

        public boolean equals(Object obj) {
            if (obj instanceof StringCharsetFunnel) {
                return this.charset.equals(((StringCharsetFunnel) obj).charset);
            }
            return false;
        }

        public int hashCode() {
            return StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
        }

        public String toString() {
            return "Funnels.stringFunnel(" + this.charset.name() + SmallTailInfo.EMOTION_SUFFIX;
        }

        public Object writeReplace() {
            return new SerializedForm(this.charset);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.hash.Funnel
        public void funnel(CharSequence charSequence, j jVar) {
            jVar.c(charSequence, this.charset);
        }
    }

    /* loaded from: classes6.dex */
    public enum UnencodedCharsFunnel implements Funnel<CharSequence> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.hash.Funnel
        public void funnel(CharSequence charSequence, j jVar) {
            jVar.a(charSequence);
        }
    }

    public static Funnel<CharSequence> a(Charset charset) {
        return new StringCharsetFunnel(charset);
    }
}
