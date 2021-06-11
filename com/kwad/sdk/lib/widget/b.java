package com.kwad.sdk.lib.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
/* loaded from: classes7.dex */
public class b<T> implements List<T> {

    /* renamed from: a  reason: collision with root package name */
    public List<T> f36674a;

    public b(@NonNull List<T> list) {
        this.f36674a = list;
    }

    @Override // java.util.List
    public void add(int i2, T t) {
        this.f36674a.add(i2, t);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        return this.f36674a.add(t);
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends T> collection) {
        return this.f36674a.addAll(i2, collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        return this.f36674a.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f36674a.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(@Nullable Object obj) {
        return this.f36674a.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.f36674a.containsAll(collection);
    }

    @Override // java.util.List
    public T get(int i2) {
        T t = this.f36674a.get(i2);
        if (t instanceof AdTemplate) {
            ((AdTemplate) t).setShowPosition(i2);
        }
        return t;
    }

    @Override // java.util.List
    public int indexOf(@Nullable Object obj) {
        return this.f36674a.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f36674a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<T> iterator() {
        return this.f36674a.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(@Nullable Object obj) {
        return this.f36674a.lastIndexOf(obj);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<T> listIterator() {
        return this.f36674a.listIterator();
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<T> listIterator(int i2) {
        return this.f36674a.listIterator(i2);
    }

    @Override // java.util.List
    public T remove(int i2) {
        return this.f36674a.remove(i2);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(@Nullable Object obj) {
        return this.f36674a.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.f36674a.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.f36674a.retainAll(collection);
    }

    @Override // java.util.List
    public T set(int i2, T t) {
        return this.f36674a.set(i2, t);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f36674a.size();
    }

    @Override // java.util.List
    @NonNull
    public List<T> subList(int i2, int i3) {
        return this.f36674a.subList(i2, i3);
    }

    @Override // java.util.List, java.util.Collection
    @NonNull
    public Object[] toArray() {
        return this.f36674a.toArray();
    }

    @Override // java.util.List, java.util.Collection
    @NonNull
    public <T1> T1[] toArray(@NonNull T1[] t1Arr) {
        return (T1[]) this.f36674a.toArray(t1Arr);
    }
}
