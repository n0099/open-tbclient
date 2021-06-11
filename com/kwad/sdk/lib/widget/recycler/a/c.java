package com.kwad.sdk.lib.widget.recycler.a;

import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
/* loaded from: classes7.dex */
public class c<T> implements List<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d<T> f36690a;

    public c(d<T> dVar) {
        this.f36690a = dVar;
    }

    @Override // java.util.List
    public void add(int i2, T t) {
        this.f36690a.a().add(i2, t);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        return this.f36690a.a().add(t);
    }

    @Override // java.util.List
    public boolean addAll(int i2, @NonNull Collection<? extends T> collection) {
        return this.f36690a.a().addAll(i2, collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NonNull Collection<? extends T> collection) {
        return this.f36690a.a().addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f36690a.a().clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f36690a.a().contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.f36690a.a().containsAll(collection);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super T> consumer) {
        this.f36690a.a().forEach(consumer);
    }

    @Override // java.util.List
    public T get(int i2) {
        return this.f36690a.a().get(i2);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f36690a.a().indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f36690a.a().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<T> iterator() {
        return this.f36690a.a().iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f36690a.a().lastIndexOf(obj);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<T> listIterator() {
        return this.f36690a.a().listIterator();
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<T> listIterator(int i2) {
        return this.f36690a.a().listIterator(i2);
    }

    @Override // java.util.List
    public T remove(int i2) {
        return this.f36690a.a().remove(i2);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.f36690a.a().remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.f36690a.a().removeAll(collection);
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<T> unaryOperator) {
        this.f36690a.a().replaceAll(unaryOperator);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.f36690a.a().retainAll(collection);
    }

    @Override // java.util.List
    public T set(int i2, T t) {
        return this.f36690a.a().set(i2, t);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f36690a.a().size();
    }

    @Override // java.util.List
    public void sort(Comparator<? super T> comparator) {
        this.f36690a.a().sort(comparator);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Spliterator<T> spliterator() {
        return this.f36690a.a().spliterator();
    }

    @Override // java.util.List
    @NonNull
    public List<T> subList(int i2, int i3) {
        return this.f36690a.a().subList(i2, i3);
    }

    @Override // java.util.List, java.util.Collection
    @NonNull
    public Object[] toArray() {
        return this.f36690a.a().toArray();
    }

    @Override // java.util.List, java.util.Collection
    @NonNull
    public <T1> T1[] toArray(@NonNull T1[] t1Arr) {
        return (T1[]) this.f36690a.a().toArray(t1Arr);
    }
}
