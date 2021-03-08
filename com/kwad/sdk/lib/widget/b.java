package com.kwad.sdk.lib.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes3.dex */
public class b<T> implements List<T> {

    /* renamed from: a  reason: collision with root package name */
    private List<T> f6880a;

    public b(@NonNull List<T> list) {
        this.f6880a = list;
    }

    @Override // java.util.List
    public void add(int i, T t) {
        this.f6880a.add(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        return this.f6880a.add(t);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        return this.f6880a.addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        return this.f6880a.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f6880a.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(@Nullable Object obj) {
        return this.f6880a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.f6880a.containsAll(collection);
    }

    @Override // java.util.List
    public T get(int i) {
        T t = this.f6880a.get(i);
        if (t instanceof AdTemplate) {
            ((AdTemplate) t).setShowPosition(i);
        }
        return t;
    }

    @Override // java.util.List
    public int indexOf(@Nullable Object obj) {
        return this.f6880a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f6880a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<T> iterator() {
        return this.f6880a.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(@Nullable Object obj) {
        return this.f6880a.lastIndexOf(obj);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<T> listIterator() {
        return this.f6880a.listIterator();
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<T> listIterator(int i) {
        return this.f6880a.listIterator(i);
    }

    @Override // java.util.List
    public T remove(int i) {
        return this.f6880a.remove(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(@Nullable Object obj) {
        return this.f6880a.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.f6880a.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.f6880a.retainAll(collection);
    }

    @Override // java.util.List
    public T set(int i, T t) {
        return this.f6880a.set(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f6880a.size();
    }

    @Override // java.util.List
    @NonNull
    public List<T> subList(int i, int i2) {
        return this.f6880a.subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    @NonNull
    public Object[] toArray() {
        return this.f6880a.toArray();
    }

    @Override // java.util.List, java.util.Collection
    @NonNull
    public <T1> T1[] toArray(@NonNull T1[] t1Arr) {
        return (T1[]) this.f6880a.toArray(t1Arr);
    }
}
