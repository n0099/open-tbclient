package com.facebook.common.internal;

import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Nullsafe(Nullsafe.Mode.STRICT)
/* loaded from: classes8.dex */
public class ImmutableList<E> extends ArrayList<E> {
    public ImmutableList(int i) {
        super(i);
    }

    public static <E> ImmutableList<E> copyOf(List<E> list) {
        return new ImmutableList<>(list);
    }

    public static <E> ImmutableList<E> of(E... eArr) {
        ImmutableList<E> immutableList = new ImmutableList<>(eArr.length);
        Collections.addAll(immutableList, eArr);
        return immutableList;
    }

    public ImmutableList(List<E> list) {
        super(list);
    }
}
