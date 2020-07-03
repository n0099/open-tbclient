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
    public final WireField.Label nEJ;
    private final String nEK;
    private final String nEL;
    public final boolean nEM;
    private final Field nEN;
    private final Method nEO;
    private ProtoAdapter<?> nEP;
    private ProtoAdapter<?> nEQ;
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
        this.nEJ = wireField.dNk();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.nEK = wireField.dNi();
        this.nEL = wireField.dNj();
        this.nEM = wireField.dNl();
        this.messageField = field;
        this.nEN = i(cls, this.name);
        this.nEO = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dMY() {
        return !this.nEK.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> dMZ() {
        ProtoAdapter<?> protoAdapter = this.nEP;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.nEL);
        this.nEP = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> dNa() {
        ProtoAdapter<?> protoAdapter = this.nEQ;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.nEK);
        this.nEQ = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (dMY()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(dNa(), dMZ());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = dMZ().withLabel(this.nEJ);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b, Object obj) {
        if (this.nEJ.isRepeated()) {
            ((List) a((a<M, B>) b)).add(obj);
        } else if (!this.nEK.isEmpty()) {
            ((Map) a((a<M, B>) b)).putAll((Map) obj);
        } else {
            b(b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b, Object obj) {
        try {
            if (this.nEJ.isOneOf()) {
                this.nEO.invoke(b, obj);
            } else {
                this.nEN.set(b, obj);
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
            return this.nEN.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
