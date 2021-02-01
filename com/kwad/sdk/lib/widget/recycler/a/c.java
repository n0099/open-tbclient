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
/* loaded from: classes3.dex */
public class c<T> implements List<T> {

    /* renamed from: a  reason: collision with root package name */
    private final d<T> f10444a;

    public c(d<T> dVar) {
        this.f10444a = dVar;
    }

    @Override // java.util.List
    public void add(int i, T t) {
        this.f10444a.a().add(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        return this.f10444a.a().add(t);
    }

    @Override // java.util.List
    public boolean addAll(int i, @NonNull Collection<? extends T> collection) {
        return this.f10444a.a().addAll(i, collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(@NonNull Collection<? extends T> collection) {
        return this.f10444a.a().addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f10444a.a().clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f10444a.a().contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        return this.f10444a.a().containsAll(collection);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super T> consumer) {
        this.f10444a.a().forEach(consumer);
    }

    @Override // java.util.List
    public T get(int i) {
        return this.f10444a.a().get(i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f10444a.a().indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f10444a.a().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<T> iterator() {
        return this.f10444a.a().iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f10444a.a().lastIndexOf(obj);
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<T> listIterator() {
        return this.f10444a.a().listIterator();
    }

    @Override // java.util.List
    @NonNull
    public ListIterator<T> listIterator(int i) {
        return this.f10444a.a().listIterator(i);
    }

    @Override // java.util.List
    public T remove(int i) {
        return this.f10444a.a().remove(i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.f10444a.a().remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        return this.f10444a.a().removeAll(collection);
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<T> unaryOperator) {
        this.f10444a.a().replaceAll(unaryOperator);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        return this.f10444a.a().retainAll(collection);
    }

    @Override // java.util.List
    public T set(int i, T t) {
        return this.f10444a.a().set(i, t);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f10444a.a().size();
    }

    @Override // java.util.List
    public void sort(Comparator<? super T> comparator) {
        this.f10444a.a().sort(comparator);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Spliterator<T> spliterator() {
        return this.f10444a.a().spliterator();
    }

    @Override // java.util.List
    @NonNull
    public List<T> subList(int i, int i2) {
        return this.f10444a.a().subList(i, i2);
    }

    @Override // java.util.List, java.util.Collection
    @NonNull
    public Object[] toArray() {
        return this.f10444a.a().toArray();
    }

    @Override // java.util.List, java.util.Collection
    @NonNull
    public <T1> T1[] toArray(@NonNull T1[] t1Arr) {
        return (T1[]) this.f10444a.a().toArray(t1Arr);
    }
}
