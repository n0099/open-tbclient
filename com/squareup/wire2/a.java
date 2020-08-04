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
/* loaded from: classes5.dex */
public final class a<M extends Message<M, B>, B extends Message.a<M, B>> {
    private ProtoAdapter<Object> adapter;
    private final Field messageField;
    private final Field nNA;
    private final Method nNB;
    private ProtoAdapter<?> nNC;
    private ProtoAdapter<?> nND;
    public final WireField.Label nNw;
    private final String nNx;
    private final String nNy;
    public final boolean nNz;
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
        this.nNw = wireField.dQL();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.nNx = wireField.dQJ();
        this.nNy = wireField.dQK();
        this.nNz = wireField.dQM();
        this.messageField = field;
        this.nNA = i(cls, this.name);
        this.nNB = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dQz() {
        return !this.nNx.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> dQA() {
        ProtoAdapter<?> protoAdapter = this.nNC;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.nNy);
        this.nNC = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> dQB() {
        ProtoAdapter<?> protoAdapter = this.nND;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.nNx);
        this.nND = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (dQz()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(dQB(), dQA());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = dQA().withLabel(this.nNw);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b, Object obj) {
        if (this.nNw.isRepeated()) {
            ((List) a((a<M, B>) b)).add(obj);
        } else if (!this.nNx.isEmpty()) {
            ((Map) a((a<M, B>) b)).putAll((Map) obj);
        } else {
            b(b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b, Object obj) {
        try {
            if (this.nNw.isOneOf()) {
                this.nNB.invoke(b, obj);
            } else {
                this.nNA.set(b, obj);
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
            return this.nNA.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
