package kotlin.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class i extends h {
    public static final boolean a(byte[] bArr, byte b) {
        kotlin.jvm.internal.p.j(bArr, "$receiver");
        return f.b(bArr, b) >= 0;
    }

    public static final int b(byte[] bArr, byte b) {
        kotlin.jvm.internal.p.j(bArr, "$receiver");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int c(byte[] bArr, byte b) {
        kotlin.jvm.internal.p.j(bArr, "$receiver");
        for (Number number : n.d(f.aA(bArr))) {
            int intValue = number.intValue();
            if (b == bArr[intValue]) {
                return intValue;
            }
        }
        return -1;
    }

    public static final char f(char[] cArr) {
        kotlin.jvm.internal.p.j(cArr, "$receiver");
        switch (cArr.length) {
            case 0:
                throw new NoSuchElementException("Array is empty.");
            case 1:
                return cArr[0];
            default:
                throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final List<Byte> a(byte[] bArr, kotlin.b.c cVar) {
        kotlin.jvm.internal.p.j(bArr, "$receiver");
        kotlin.jvm.internal.p.j(cVar, "indices");
        if (cVar.isEmpty()) {
            return n.dEC();
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, cVar.dEX().intValue(), cVar.dEY().intValue() + 1);
        kotlin.jvm.internal.p.i(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return f.aC(copyOfRange);
    }

    public static final kotlin.b.c aA(byte[] bArr) {
        kotlin.jvm.internal.p.j(bArr, "$receiver");
        return new kotlin.b.c(0, f.aB(bArr));
    }

    public static final int aB(byte[] bArr) {
        kotlin.jvm.internal.p.j(bArr, "$receiver");
        return bArr.length - 1;
    }

    public static final <T, C extends Collection<? super T>> C a(T[] tArr, C c) {
        kotlin.jvm.internal.p.j(tArr, "$receiver");
        kotlin.jvm.internal.p.j(c, "destination");
        for (T t : tArr) {
            c.add(t);
        }
        return c;
    }

    public static final <T> HashSet<T> M(T[] tArr) {
        kotlin.jvm.internal.p.j(tArr, "$receiver");
        return (HashSet) f.a(tArr, new HashSet(aa.MO(tArr.length)));
    }

    public static final <T> Set<T> N(T[] tArr) {
        kotlin.jvm.internal.p.j(tArr, "$receiver");
        switch (tArr.length) {
            case 0:
                return ag.dEJ();
            case 1:
                return ag.bO(tArr[0]);
            default:
                return (Set) f.a(tArr, new LinkedHashSet(aa.MO(tArr.length)));
        }
    }

    public static final <T> List<T> asList(T[] tArr) {
        kotlin.jvm.internal.p.j(tArr, "$receiver");
        List<T> asList = j.asList(tArr);
        kotlin.jvm.internal.p.i(asList, "ArraysUtilJVM.asList(this)");
        return asList;
    }

    /* loaded from: classes4.dex */
    public static final class a extends d<Byte> implements RandomAccess {
        final /* synthetic */ byte[] receiver$0;

        a(byte[] bArr) {
            this.receiver$0 = bArr;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj instanceof Byte) {
                return l(((Number) obj).byteValue());
            }
            return false;
        }

        @Override // kotlin.collections.d, java.util.List
        public final int indexOf(Object obj) {
            if (obj instanceof Byte) {
                return m(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // kotlin.collections.d, java.util.List
        public final int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                return n(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // kotlin.collections.a
        public int getSize() {
            return this.receiver$0.length;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public boolean isEmpty() {
            return this.receiver$0.length == 0;
        }

        public boolean l(byte b) {
            return f.a(this.receiver$0, b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.collections.d, java.util.List
        /* renamed from: MN */
        public Byte get(int i) {
            return Byte.valueOf(this.receiver$0[i]);
        }

        public int m(byte b) {
            return f.b(this.receiver$0, b);
        }

        public int n(byte b) {
            return f.c(this.receiver$0, b);
        }
    }

    public static final List<Byte> aC(byte[] bArr) {
        kotlin.jvm.internal.p.j(bArr, "$receiver");
        return new a(bArr);
    }
}
