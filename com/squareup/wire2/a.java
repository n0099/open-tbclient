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
/* loaded from: classes4.dex */
public final class a<M extends Message<M, B>, B extends Message.a<M, B>> {
    private ProtoAdapter<Object> adapter;
    public final WireField.Label mMh;
    private final String mMi;
    private final String mMj;
    public final boolean mMk;
    private final Field mMl;
    private final Method mMm;
    private ProtoAdapter<?> mMn;
    private ProtoAdapter<?> mMo;
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
        this.mMh = wireField.dAS();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.mMi = wireField.dAQ();
        this.mMj = wireField.dAR();
        this.mMk = wireField.dAT();
        this.messageField = field;
        this.mMl = i(cls, this.name);
        this.mMm = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dAG() {
        return !this.mMi.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> dAH() {
        ProtoAdapter<?> protoAdapter = this.mMn;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.mMj);
        this.mMn = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> dAI() {
        ProtoAdapter<?> protoAdapter = this.mMo;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.mMi);
        this.mMo = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (dAG()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(dAI(), dAH());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = dAH().withLabel(this.mMh);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b, Object obj) {
        if (this.mMh.isRepeated()) {
            ((List) a((a<M, B>) b)).add(obj);
        } else if (!this.mMi.isEmpty()) {
            ((Map) a((a<M, B>) b)).putAll((Map) obj);
        } else {
            b(b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b, Object obj) {
        try {
            if (this.mMh.isOneOf()) {
                this.mMm.invoke(b, obj);
            } else {
                this.mMl.set(b, obj);
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
            return this.mMl.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
