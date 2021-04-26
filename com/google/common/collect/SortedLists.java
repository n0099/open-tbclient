package com.google.common.collect;

import d.g.c.a.g;
import d.g.c.a.n;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
/* loaded from: classes6.dex */
public final class SortedLists {

    /* loaded from: classes6.dex */
    public enum KeyAbsentBehavior {
        NEXT_LOWER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i2) {
                return i2 - 1;
            }
        },
        NEXT_HIGHER { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.2
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i2) {
                return i2;
            }
        },
        INVERTED_INSERTION_INDEX { // from class: com.google.common.collect.SortedLists.KeyAbsentBehavior.3
            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i2) {
                return ~i2;
            }
        };

        public abstract int resultIndex(int i2);
    }

    /* loaded from: classes6.dex */
    public enum KeyPresentBehavior {
        ANY_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.1
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i2) {
                return i2;
            }
        },
        LAST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.2
            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: E */
            /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: E, ? super E */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i2) {
                int size = list.size() - 1;
                while (i2 < size) {
                    int i3 = ((i2 + size) + 1) >>> 1;
                    if (comparator.compare((E) list.get(i3), e2) > 0) {
                        size = i3 - 1;
                    } else {
                        i2 = i3;
                    }
                }
                return i2;
            }
        },
        FIRST_PRESENT { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.3
            /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: E */
            /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: E, ? super E */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i2) {
                int i3 = 0;
                while (i3 < i2) {
                    int i4 = (i3 + i2) >>> 1;
                    if (comparator.compare((E) list.get(i4), e2) < 0) {
                        i3 = i4 + 1;
                    } else {
                        i2 = i4;
                    }
                }
                return i3;
            }
        },
        FIRST_AFTER { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.4
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i2) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e2, list, i2) + 1;
            }
        },
        LAST_BEFORE { // from class: com.google.common.collect.SortedLists.KeyPresentBehavior.5
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i2) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e2, list, i2) - 1;
            }
        };

        public abstract <E> int resultIndex(Comparator<? super E> comparator, E e2, List<? extends E> list, int i2);
    }

    public static <E, K extends Comparable> int a(List<E> list, g<? super E, K> gVar, K k, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return b(list, gVar, k, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int b(List<E> list, g<? super E, K> gVar, K k, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return c(Lists.n(list, gVar), k, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    /* JADX DEBUG: Type inference failed for r3v0. Raw type applied. Possible types: E, ? super E */
    public static <E> int c(List<? extends E> list, E e2, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        n.p(comparator);
        n.p(list);
        n.p(keyPresentBehavior);
        n.p(keyAbsentBehavior);
        if (!(list instanceof RandomAccess)) {
            list = Lists.j(list);
        }
        int i2 = 0;
        int size = list.size() - 1;
        while (i2 <= size) {
            int i3 = (i2 + size) >>> 1;
            int compare = comparator.compare(e2, (E) list.get(i3));
            if (compare < 0) {
                size = i3 - 1;
            } else if (compare <= 0) {
                return i2 + keyPresentBehavior.resultIndex(comparator, e2, list.subList(i2, size + 1), i3 - i2);
            } else {
                i2 = i3 + 1;
            }
        }
        return keyAbsentBehavior.resultIndex(i2);
    }
}
