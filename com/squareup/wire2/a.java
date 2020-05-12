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
    public final WireField.Label mNF;
    private final String mNG;
    private final String mNH;
    public final boolean mNI;
    private final Field mNJ;
    private final Method mNK;
    private ProtoAdapter<?> mNL;
    private ProtoAdapter<?> mNM;
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
        this.mNF = wireField.dAX();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.mNG = wireField.dAV();
        this.mNH = wireField.dAW();
        this.mNI = wireField.dAY();
        this.messageField = field;
        this.mNJ = i(cls, this.name);
        this.mNK = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dAL() {
        return !this.mNG.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> dAM() {
        ProtoAdapter<?> protoAdapter = this.mNL;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.mNH);
        this.mNL = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> dAN() {
        ProtoAdapter<?> protoAdapter = this.mNM;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.mNG);
        this.mNM = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (dAL()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(dAN(), dAM());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = dAM().withLabel(this.mNF);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b, Object obj) {
        if (this.mNF.isRepeated()) {
            ((List) a((a<M, B>) b)).add(obj);
        } else if (!this.mNG.isEmpty()) {
            ((Map) a((a<M, B>) b)).putAll((Map) obj);
        } else {
            b(b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b, Object obj) {
        try {
            if (this.mNF.isOneOf()) {
                this.mNK.invoke(b, obj);
            } else {
                this.mNJ.set(b, obj);
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
            return this.mNJ.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
