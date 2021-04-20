package com.google.common.collect;
/* loaded from: classes6.dex */
public class EmptyImmutableSetMultimap extends ImmutableSetMultimap<Object, Object> {
    public static final EmptyImmutableSetMultimap INSTANCE = new EmptyImmutableSetMultimap();
    public static final long serialVersionUID = 0;

    public EmptyImmutableSetMultimap() {
        super(ImmutableMap.of(), 0, null);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
