package com.google.common.collect;

import d.g.c.a.r;
import d.g.c.c.m;
import d.g.c.c.y0;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class HashBasedTable<R, C, V> extends StandardTable<R, C, V> {
    public static final long serialVersionUID = 0;

    /* loaded from: classes6.dex */
    public static class Factory<C, V> implements r<Map<C, V>>, Serializable {
        public static final long serialVersionUID = 0;
        public final int expectedSize;

        public Factory(int i) {
            this.expectedSize = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.g.c.a.r
        public Map<C, V> get() {
            return Maps.t(this.expectedSize);
        }
    }

    public HashBasedTable(Map<R, Map<C, V>> map, Factory<C, V> factory) {
        super(map, factory);
    }

    public static <R, C, V> HashBasedTable<R, C, V> create() {
        return new HashBasedTable<>(new LinkedHashMap(), new Factory(0));
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public boolean contains(Object obj, Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public V get(Object obj, Object obj2) {
        return (V) super.get(obj, obj2);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ void putAll(y0 y0Var) {
        super.putAll(y0Var);
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public V remove(Object obj, Object obj2) {
        return (V) super.remove(obj, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.StandardTable, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return super.row(obj);
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Map rowMap() {
        return super.rowMap();
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.y0
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // d.g.c.c.i
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.StandardTable, d.g.c.c.i, d.g.c.c.y0
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(int i, int i2) {
        m.b(i2, "expectedCellsPerRow");
        return new HashBasedTable<>(Maps.t(i), new Factory(i2));
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(y0<? extends R, ? extends C, ? extends V> y0Var) {
        HashBasedTable<R, C, V> create = create();
        create.putAll(y0Var);
        return create;
    }
}
