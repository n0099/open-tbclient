package kotlin.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.h
/* loaded from: classes7.dex */
public class j extends i {
    public static final boolean a(byte[] bArr, byte b) {
        kotlin.jvm.internal.q.j(bArr, "receiver$0");
        return f.b(bArr, b) >= 0;
    }

    public static final int b(byte[] bArr, byte b) {
        kotlin.jvm.internal.q.j(bArr, "receiver$0");
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            if (b == bArr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static final int c(byte[] bArr, byte b) {
        kotlin.jvm.internal.q.j(bArr, "receiver$0");
        for (Number number : o.d(f.aH(bArr))) {
            int intValue = number.intValue();
            if (b == bArr[intValue]) {
                return intValue;
            }
        }
        return -1;
    }

    public static final char g(char[] cArr) {
        kotlin.jvm.internal.q.j(cArr, "receiver$0");
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
        kotlin.jvm.internal.q.j(bArr, "receiver$0");
        kotlin.jvm.internal.q.j(hVar, "indices");
        return hVar.isEmpty() ? o.dKE() : f.aG(f.l(bArr, hVar.dLi().intValue(), hVar.dLj().intValue() + 1));
    }

    public static final kotlin.b.h aH(byte[] bArr) {
        kotlin.jvm.internal.q.j(bArr, "receiver$0");
        return new kotlin.b.h(0, f.aI(bArr));
    }

    public static final int aI(byte[] bArr) {
        kotlin.jvm.internal.q.j(bArr, "receiver$0");
        return bArr.length - 1;
    }

    public static final <T, C extends Collection<? super T>> C a(T[] tArr, C c) {
        kotlin.jvm.internal.q.j(tArr, "receiver$0");
        kotlin.jvm.internal.q.j(c, "destination");
        for (T t : tArr) {
            c.add(t);
        }
        return c;
    }

    public static final <T> HashSet<T> O(T[] tArr) {
        kotlin.jvm.internal.q.j(tArr, "receiver$0");
        return (HashSet) f.a(tArr, new HashSet(af.NK(tArr.length)));
    }

    public static final <T> Set<T> P(T[] tArr) {
        kotlin.jvm.internal.q.j(tArr, "receiver$0");
        switch (tArr.length) {
            case 0:
                return al.dKL();
            case 1:
                return al.bT(tArr[0]);
            default:
                return (Set) f.a(tArr, new LinkedHashSet(af.NK(tArr.length)));
        }
    }
}
