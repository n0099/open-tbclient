package io.reactivex.internal.util;

import io.reactivex.functions.BiFunction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public final class MergerBiFunction<T> implements BiFunction<List<T>, List<T>, List<T>> {
    public final Comparator<? super T> comparator;

    public MergerBiFunction(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    @Override // io.reactivex.functions.BiFunction
    public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
        return apply((List) ((List) obj), (List) ((List) obj2));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0036 -> B:14:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<T> apply(List<T> list, List<T> list2) throws Exception {
        T t;
        int size = list.size() + list2.size();
        if (size == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator<T> it = list.iterator();
        Iterator<T> it2 = list2.iterator();
        T next = it.hasNext() ? it.next() : null;
        if (it2.hasNext()) {
            t = it2.next();
            while (next != null && t != null) {
                if (this.comparator.compare(next, t) >= 0) {
                    arrayList.add(next);
                    next = it.hasNext() ? it.next() : null;
                } else {
                    arrayList.add(t);
                    if (it2.hasNext()) {
                        t = it2.next();
                    }
                }
            }
            if (next == null) {
                arrayList.add(next);
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            } else {
                arrayList.add(t);
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
            return arrayList;
        }
        t = null;
        while (next != null) {
            if (this.comparator.compare(next, t) >= 0) {
            }
        }
        if (next == null) {
        }
        return arrayList;
    }
}
