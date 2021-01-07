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
/* loaded from: classes6.dex */
public final class a<M extends Message<M, B>, B extends Message.a<M, B>> {
    private ProtoAdapter<Object> adapter;
    private final Field messageField;
    public final String name;
    public final WireField.Label pUD;
    private final String pUE;
    private final String pUF;
    public final boolean pUG;
    private final Field pUH;
    private final Method pUI;
    private ProtoAdapter<?> pUJ;
    private ProtoAdapter<?> pUK;
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
        this.pUD = wireField.eFp();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.pUE = wireField.eFn();
        this.pUF = wireField.eFo();
        this.pUG = wireField.eFq();
        this.messageField = field;
        this.pUH = j(cls, this.name);
        this.pUI = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean eFd() {
        return !this.pUE.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> eFe() {
        ProtoAdapter<?> protoAdapter = this.pUJ;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.pUF);
        this.pUJ = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> eFf() {
        ProtoAdapter<?> protoAdapter = this.pUK;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.pUE);
        this.pUK = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (eFd()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(eFf(), eFe());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = eFe().withLabel(this.pUD);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b2, Object obj) {
        if (this.pUD.isRepeated()) {
            ((List) a((a<M, B>) b2)).add(obj);
        } else if (!this.pUE.isEmpty()) {
            ((Map) a((a<M, B>) b2)).putAll((Map) obj);
        } else {
            b(b2, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b2, Object obj) {
        try {
            if (this.pUD.isOneOf()) {
                this.pUI.invoke(b2, obj);
            } else {
                this.pUH.set(b2, obj);
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
    public Object a(B b2) {
        try {
            return this.pUH.get(b2);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
