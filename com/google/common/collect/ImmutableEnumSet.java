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
    public final transient EnumSet<E> f30788e;

    /* renamed from: f  reason: collision with root package name */
    public transient int f30789f;

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
        return this.f30788e.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof ImmutableEnumSet) {
            collection = ((ImmutableEnumSet) collection).f30788e;
        }
        return this.f30788e.containsAll(collection);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumSet) {
            obj = ((ImmutableEnumSet) obj).f30788e;
        }
        return this.f30788e.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        int i = this.f30789f;
        if (i == 0) {
            int hashCode = this.f30788e.hashCode();
            this.f30789f = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f30788e.isEmpty();
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
        return this.f30788e.size();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.f30788e.toString();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new EnumSerializedForm(this.f30788e);
    }

    public ImmutableEnumSet(EnumSet<E> enumSet) {
        this.f30788e = enumSet;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public c1<E> iterator() {
        return Iterators.x(this.f30788e.iterator());
    }
}
