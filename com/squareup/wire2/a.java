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
    private final Field messageField;
    public final WireField.Label nEM;
    private final String nEN;
    private final String nEO;
    public final boolean nEP;
    private final Field nEQ;
    private final Method nER;
    private ProtoAdapter<?> nES;
    private ProtoAdapter<?> nET;
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
        this.nEM = wireField.dNo();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.nEN = wireField.dNm();
        this.nEO = wireField.dNn();
        this.nEP = wireField.dNp();
        this.messageField = field;
        this.nEQ = i(cls, this.name);
        this.nER = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dNc() {
        return !this.nEN.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> dNd() {
        ProtoAdapter<?> protoAdapter = this.nES;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.nEO);
        this.nES = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> dNe() {
        ProtoAdapter<?> protoAdapter = this.nET;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.nEN);
        this.nET = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (dNc()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(dNe(), dNd());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = dNd().withLabel(this.nEM);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b, Object obj) {
        if (this.nEM.isRepeated()) {
            ((List) a((a<M, B>) b)).add(obj);
        } else if (!this.nEN.isEmpty()) {
            ((Map) a((a<M, B>) b)).putAll((Map) obj);
        } else {
            b(b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b, Object obj) {
        try {
            if (this.nEM.isOneOf()) {
                this.nER.invoke(b, obj);
            } else {
                this.nEQ.set(b, obj);
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
            return this.nEQ.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
