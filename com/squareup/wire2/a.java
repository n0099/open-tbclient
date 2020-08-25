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
/* loaded from: classes19.dex */
public final class a<M extends Message<M, B>, B extends Message.a<M, B>> {
    private ProtoAdapter<Object> adapter;
    private final Field messageField;
    public final String name;
    public final WireField.Label ohq;
    private final String ohr;
    private final String ohs;
    public final boolean oht;
    private final Field ohu;
    private final Method ohv;
    private ProtoAdapter<?> ohw;
    private ProtoAdapter<?> ohx;
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
        this.ohq = wireField.ecN();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.ohr = wireField.ecL();
        this.ohs = wireField.ecM();
        this.oht = wireField.ecO();
        this.messageField = field;
        this.ohu = i(cls, this.name);
        this.ohv = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ecB() {
        return !this.ohr.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> ecC() {
        ProtoAdapter<?> protoAdapter = this.ohw;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.ohs);
        this.ohw = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> ecD() {
        ProtoAdapter<?> protoAdapter = this.ohx;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.ohr);
        this.ohx = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (ecB()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(ecD(), ecC());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = ecC().withLabel(this.ohq);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b, Object obj) {
        if (this.ohq.isRepeated()) {
            ((List) a((a<M, B>) b)).add(obj);
        } else if (!this.ohr.isEmpty()) {
            ((Map) a((a<M, B>) b)).putAll((Map) obj);
        } else {
            b(b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b, Object obj) {
        try {
            if (this.ohq.isOneOf()) {
                this.ohv.invoke(b, obj);
            } else {
                this.ohu.set(b, obj);
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
            return this.ohu.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
