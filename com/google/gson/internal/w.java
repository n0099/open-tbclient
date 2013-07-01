package com.google.gson.internal;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements Map.Entry {

    /* renamed from: a  reason: collision with root package name */
    final String f1664a;
    Object b;
    final int c;
    w d;
    w e;
    w f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w() {
        this(null, null, 0, null, null, null);
        this.f = this;
        this.e = this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(String str, Object obj, int i, w wVar, w wVar2, w wVar3) {
        this.f1664a = str;
        this.b = obj;
        this.c = i;
        this.d = wVar;
        this.e = wVar2;
        this.f = wVar3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map.Entry
    /* renamed from: a */
    public final String getKey() {
        return this.f1664a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object obj2 = this.b;
        this.b = obj;
        return obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            if (this.f1664a.equals(entry.getKey())) {
                if (this.b == null) {
                    if (value != null) {
                        return false;
                    }
                } else if (!this.b.equals(value)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return (this.f1664a == null ? 0 : this.f1664a.hashCode()) ^ (this.b != null ? this.b.hashCode() : 0);
    }

    public final String toString() {
        return this.f1664a + "=" + this.b;
    }
}
