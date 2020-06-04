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
    public final String name;
    public final WireField.Label niU;
    private final String niV;
    private final String niW;
    public final boolean niX;
    private final Field niY;
    private final Method niZ;
    private ProtoAdapter<?> nja;
    private ProtoAdapter<?> njb;
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
        this.niU = wireField.dIE();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.niV = wireField.dIC();
        this.niW = wireField.dID();
        this.niX = wireField.dIF();
        this.messageField = field;
        this.niY = i(cls, this.name);
        this.niZ = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dIs() {
        return !this.niV.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> dIt() {
        ProtoAdapter<?> protoAdapter = this.nja;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.niW);
        this.nja = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> dIu() {
        ProtoAdapter<?> protoAdapter = this.njb;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.niV);
        this.njb = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (dIs()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(dIu(), dIt());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = dIt().withLabel(this.niU);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b, Object obj) {
        if (this.niU.isRepeated()) {
            ((List) a((a<M, B>) b)).add(obj);
        } else if (!this.niV.isEmpty()) {
            ((Map) a((a<M, B>) b)).putAll((Map) obj);
        } else {
            b(b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b, Object obj) {
        try {
            if (this.niU.isOneOf()) {
                this.niZ.invoke(b, obj);
            } else {
                this.niY.set(b, obj);
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
            return this.niY.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
