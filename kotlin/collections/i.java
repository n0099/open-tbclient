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
@kotlin.e
/* loaded from: classes17.dex */
public class i extends h {
    public static final boolean a(byte[] bArr, byte b) {
        kotlin.jvm.internal.p.o(bArr, "$receiver");
        return f.b(bArr, b) >= 0;
    }

    public static final int b(byte[] bArr, byte b) {
        kotlin.jvm.internal.p.o(bArr, "$receiver");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int c(byte[] bArr, byte b) {
        kotlin.jvm.internal.p.o(bArr, "$receiver");
        for (Number number : n.e(f.av(bArr))) {
            int intValue = number.intValue();
            if (b == bArr[intValue]) {
                return intValue;
            }
        }
        return -1;
    }

    public static final char b(char[] cArr) {
        kotlin.jvm.internal.p.o(cArr, "$receiver");
        switch (cArr.length) {
            case 0:
                throw new NoSuchElementException("Array is empty.");
            case 1:
                return cArr[0];
            default:
                throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final List<Byte> a(byte[] bArr, kotlin.b.h hVar) {
        kotlin.jvm.internal.p.o(bArr, "$receiver");
        kotlin.jvm.internal.p.o(hVar, "indices");
        if (hVar.isEmpty()) {
            return n.eDJ();
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, hVar.eEi().intValue(), hVar.eEj().intValue() + 1);
        kotlin.jvm.internal.p.n(copyOfRange, "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return f.ax(copyOfRange);
    }

    public static final kotlin.b.h av(byte[] bArr) {
        kotlin.jvm.internal.p.o(bArr, "$receiver");
        return new kotlin.b.h(0, f.aw(bArr));
    }

    public static final int aw(byte[] bArr) {
        kotlin.jvm.internal.p.o(bArr, "$receiver");
        return bArr.length - 1;
    }

    public static final <T, C extends Collection<? super T>> C a(T[] tArr, C c) {
        kotlin.jvm.internal.p.o(tArr, "$receiver");
        kotlin.jvm.internal.p.o(c, "destination");
        for (T t : tArr) {
            c.add(t);
        }
        return c;
    }

    public static final <T> HashSet<T> O(T[] tArr) {
        kotlin.jvm.internal.p.o(tArr, "$receiver");
        return (HashSet) f.a(tArr, new HashSet(aa.RV(tArr.length)));
    }

    public static final <T> Set<T> P(T[] tArr) {
        kotlin.jvm.internal.p.o(tArr, "$receiver");
        switch (tArr.length) {
            case 0:
                return ag.eDR();
            case 1:
                return ag.bQ(tArr[0]);
            default:
                return (Set) f.a(tArr, new LinkedHashSet(aa.RV(tArr.length)));
        }
    }

    public static final <T> List<T> asList(T[] tArr) {
        kotlin.jvm.internal.p.o(tArr, "$receiver");
        List<T> asList = j.asList(tArr);
        kotlin.jvm.internal.p.n(asList, "ArraysUtilJVM.asList(this)");
        return asList;
    }

    @kotlin.e
    /* loaded from: classes17.dex */
    public static final class a extends d<Byte> implements RandomAccess {
        final /* synthetic */ byte[] receiver$0;

        a(byte[] bArr) {
            this.receiver$0 = bArr;
        }

        @Override // kotlin.collections.a, java.util.Collection
        public final boolean contains(Object obj) {
            if (obj instanceof Byte) {
                return e(((Number) obj).byteValue());
            }
            return false;
        }

        @Override // kotlin.collections.d, java.util.List
        public final int indexOf(Object obj) {
            if (obj instanceof Byte) {
                return f(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // kotlin.collections.d, java.util.List
        public final int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                return g(((Number) obj).byteValue());
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

        public boolean e(byte b) {
            return f.a(this.receiver$0, b);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.collections.d, java.util.List
        /* renamed from: RU */
        public Byte get(int i) {
            return Byte.valueOf(this.receiver$0[i]);
        }

        public int f(byte b) {
            return f.b(this.receiver$0, b);
        }

        public int g(byte b) {
            return f.c(this.receiver$0, b);
        }
    }

    public static final List<Byte> ax(byte[] bArr) {
        kotlin.jvm.internal.p.o(bArr, "$receiver");
        return new a(bArr);
    }
}
