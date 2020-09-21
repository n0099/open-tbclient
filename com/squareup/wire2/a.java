package com.squareup.wire2;

import com.squareup.wire2.Message;
import com.squareup.wire2.Message.a;
import com.squareup.wire2.WireField;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes24.dex */
public final class a<M extends Message<M, B>, B extends Message.a<M, B>> {
    private ProtoAdapter<Object> adapter;
    private final Field messageField;
    public final String name;
    public final WireField.Label ors;
    private final String ort;
    private final String oru;
    public final boolean orv;
    private final Field orw;
    private final Method orx;
    private ProtoAdapter<?> ory;
    private ProtoAdapter<?> orz;
    public final int tag;

    private static Field i(Class<?> cls, String str) {
        try {
            return cls.getField(str);
        } catch (NoSuchFieldException e) {
            throw new AssertionError("No builder field " + cls.getName() + "." + str);
        }
    }

    private static Method a(Class<?> cls, String str, Class<?> cls2) {
        try {
            return cls.getMethod(str, cls2);
        } catch (NoSuchMethodException e) {
            throw new AssertionError("No builder method " + cls.getName() + "." + str + "(" + cls2.getName() + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WireField wireField, Field field, Class<B> cls) {
        this.ors = wireField.egT();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.ort = wireField.egR();
        this.oru = wireField.egS();
        this.orv = wireField.egU();
        this.messageField = field;
        this.orw = i(cls, this.name);
        this.orx = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean egH() {
        return !this.ort.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> egI() {
        ProtoAdapter<?> protoAdapter = this.ory;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.oru);
        this.ory = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> egJ() {
        ProtoAdapter<?> protoAdapter = this.orz;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.ort);
        this.orz = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (egH()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(egJ(), egI());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = egI().withLabel(this.ors);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b, Object obj) {
        if (this.ors.isRepeated()) {
            ((List) a((a<M, B>) b)).add(obj);
        } else if (!this.ort.isEmpty()) {
            ((Map) a((a<M, B>) b)).putAll((Map) obj);
        } else {
            b(b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b, Object obj) {
        try {
            if (this.ors.isOneOf()) {
                this.orx.invoke(b, obj);
            } else {
                this.orw.set(b, obj);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(M m) {
        try {
            return this.messageField.get(m);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(B b) {
        try {
            return this.orw.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
