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
    private ProtoAdapter<?> nNA;
    private ProtoAdapter<?> nNB;
    public final WireField.Label nNu;
    private final String nNv;
    private final String nNw;
    public final boolean nNx;
    private final Field nNy;
    private final Method nNz;
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
        this.nNu = wireField.dQK();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.nNv = wireField.dQI();
        this.nNw = wireField.dQJ();
        this.nNx = wireField.dQL();
        this.messageField = field;
        this.nNy = i(cls, this.name);
        this.nNz = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dQy() {
        return !this.nNv.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> dQz() {
        ProtoAdapter<?> protoAdapter = this.nNA;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.nNw);
        this.nNA = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> dQA() {
        ProtoAdapter<?> protoAdapter = this.nNB;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.nNv);
        this.nNB = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (dQy()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(dQA(), dQz());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = dQz().withLabel(this.nNu);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b, Object obj) {
        if (this.nNu.isRepeated()) {
            ((List) a((a<M, B>) b)).add(obj);
        } else if (!this.nNv.isEmpty()) {
            ((Map) a((a<M, B>) b)).putAll((Map) obj);
        } else {
            b(b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b, Object obj) {
        try {
            if (this.nNu.isOneOf()) {
                this.nNz.invoke(b, obj);
            } else {
                this.nNy.set(b, obj);
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
            return this.nNy.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
