package com.google.common.collect;

import d.g.c.c.c1;
import d.g.c.c.f0;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;
/* loaded from: classes6.dex */
public final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {

    /* renamed from: e  reason: collision with root package name */
    public final transient EnumSet<E> f31087e;

    /* renamed from: f  reason: collision with root package name */
    public transient int f31088f;

    /* loaded from: classes6.dex */
    public static class EnumSerializedForm<E extends Enum<E>> implements Serializable {
        public static final long serialVersionUID = 0;
        public final EnumSet<E> delegate;

        public EnumSerializedForm(EnumSet<E> enumSet) {
            this.delegate = enumSet;
        }

        public Object readResolve() {
            return new ImmutableEnumSet(this.delegate.clone());
        }
    }

    public static ImmutableSet asImmutable(EnumSet enumSet) {
        int size = enumSet.size();
        if (size != 0) {
            if (size != 1) {
                return new ImmutableEnumSet(enumSet);
            }
            return ImmutableSet.of(f0.h(enumSet));
        }
        return ImmutableSet.of();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f31087e.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof ImmutableEnumSet) {
            collection = ((ImmutableEnumSet) collection).f31087e;
        }
        return this.f31087e.containsAll(collection);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumSet) {
            obj = ((ImmutableEnumSet) obj).f31087e;
        }
        return this.f31087e.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        int i2 = this.f31088f;
        if (i2 == 0) {
            int hashCode = this.f31087e.hashCode();
            this.f31088f = hashCode;
            return hashCode;
        }
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f31087e.isEmpty();
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f31087e.size();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.f31087e.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new EnumSerializedForm(this.f31087e);
    }

    public ImmutableEnumSet(EnumSet<E> enumSet) {
        this.f31087e = enumSet;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public c1<E> iterator() {
        return Iterators.x(this.f31087e.iterator());
    }
}
