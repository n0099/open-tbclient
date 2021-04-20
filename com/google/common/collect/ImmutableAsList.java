package com.google.common.collect;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
/* loaded from: classes6.dex */
public abstract class ImmutableAsList<E> extends ImmutableList<E> {

    /* loaded from: classes6.dex */
    public static class SerializedForm implements Serializable {
        public static final long serialVersionUID = 0;
        public final ImmutableCollection<?> collection;

        public SerializedForm(ImmutableCollection<?> immutableCollection) {
            this.collection = immutableCollection;
        }

        public Object readResolve() {
            return this.collection.asList();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return delegateCollection().contains(obj);
    }

    public abstract ImmutableCollection<E> delegateCollection();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return delegateCollection().isEmpty();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return delegateCollection().isPartialView();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return delegateCollection().size();
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(delegateCollection());
    }
}
