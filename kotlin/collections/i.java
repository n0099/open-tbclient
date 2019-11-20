package kotlin.collections;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i extends h {
    public static final char b(char[] cArr) {
        kotlin.jvm.internal.p.i(cArr, "$receiver");
        switch (cArr.length) {
            case 0:
                throw new NoSuchElementException("Array is empty.");
            case 1:
                return cArr[0];
            default:
                throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static final <T, C extends Collection<? super T>> C a(T[] tArr, C c) {
        kotlin.jvm.internal.p.i(tArr, "$receiver");
        kotlin.jvm.internal.p.i(c, "destination");
        for (T t : tArr) {
            c.add(t);
        }
        return c;
    }

    public static final <T> HashSet<T> K(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "$receiver");
        return (HashSet) f.a(tArr, new HashSet(aa.De(tArr.length)));
    }

    public static final <T> List<T> asList(T[] tArr) {
        kotlin.jvm.internal.p.i(tArr, "$receiver");
        List<T> asList = j.asList(tArr);
        kotlin.jvm.internal.p.h(asList, "ArraysUtilJVM.asList(this)");
        return asList;
    }
}
