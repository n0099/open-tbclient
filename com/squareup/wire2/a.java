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
/* loaded from: classes.dex */
public final class a<M extends Message<M, B>, B extends Message.a<M, B>> {
    private ProtoAdapter<Object> adapter;
    public final WireField.Label mNC;
    private final String mND;
    private final String mNE;
    public final boolean mNF;
    private final Field mNG;
    private final Method mNH;
    private ProtoAdapter<?> mNI;
    private ProtoAdapter<?> mNJ;
    private final Field messageField;
    public final String name;
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
        this.mNC = wireField.dBa();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.mND = wireField.dAY();
        this.mNE = wireField.dAZ();
        this.mNF = wireField.dBb();
        this.messageField = field;
        this.mNG = i(cls, this.name);
        this.mNH = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dAO() {
        return !this.mND.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> dAP() {
        ProtoAdapter<?> protoAdapter = this.mNI;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.mNE);
        this.mNI = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> dAQ() {
        ProtoAdapter<?> protoAdapter = this.mNJ;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.mND);
        this.mNJ = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (dAO()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(dAQ(), dAP());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = dAP().withLabel(this.mNC);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b, Object obj) {
        if (this.mNC.isRepeated()) {
            ((List) a((a<M, B>) b)).add(obj);
        } else if (!this.mND.isEmpty()) {
            ((Map) a((a<M, B>) b)).putAll((Map) obj);
        } else {
            b(b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b, Object obj) {
        try {
            if (this.mNC.isOneOf()) {
                this.mNH.invoke(b, obj);
            } else {
                this.mNG.set(b, obj);
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
            return this.mNG.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
