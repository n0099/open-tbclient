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
    private final Field messageField;
    public final String name;
    private final Field qbA;
    private final Method qbB;
    private ProtoAdapter<?> qbC;
    private ProtoAdapter<?> qbD;
    public final WireField.Label qbw;
    private final String qbx;
    private final String qby;
    public final boolean qbz;
    public final int tag;

    private static Field j(Class<?> cls, String str) {
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
        this.qbw = wireField.eEd();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.qbx = wireField.eEb();
        this.qby = wireField.eEc();
        this.qbz = wireField.eEe();
        this.messageField = field;
        this.qbA = j(cls, this.name);
        this.qbB = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean eDR() {
        return !this.qbx.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> eDS() {
        ProtoAdapter<?> protoAdapter = this.qbC;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.qby);
        this.qbC = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> eDT() {
        ProtoAdapter<?> protoAdapter = this.qbD;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.qbx);
        this.qbD = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (eDR()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(eDT(), eDS());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = eDS().withLabel(this.qbw);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b, Object obj) {
        if (this.qbw.isRepeated()) {
            ((List) a((a<M, B>) b)).add(obj);
        } else if (!this.qbx.isEmpty()) {
            ((Map) a((a<M, B>) b)).putAll((Map) obj);
        } else {
            b(b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b, Object obj) {
        try {
            if (this.qbw.isOneOf()) {
                this.qbB.invoke(b, obj);
            } else {
                this.qbA.set(b, obj);
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
            return this.qbA.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
