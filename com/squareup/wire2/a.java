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
    public final WireField.Label pSV;
    private final String pSW;
    private final String pSX;
    public final boolean pSY;
    private final Field pSZ;
    private final Method pTa;
    private ProtoAdapter<?> pTb;
    private ProtoAdapter<?> pTc;
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
        this.pSV = wireField.eEL();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.pSW = wireField.eEJ();
        this.pSX = wireField.eEK();
        this.pSY = wireField.eEM();
        this.messageField = field;
        this.pSZ = j(cls, this.name);
        this.pTa = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean eEz() {
        return !this.pSW.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> eEA() {
        ProtoAdapter<?> protoAdapter = this.pTb;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.pSX);
        this.pTb = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> eEB() {
        ProtoAdapter<?> protoAdapter = this.pTc;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.pSW);
        this.pTc = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (eEz()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(eEB(), eEA());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = eEA().withLabel(this.pSV);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b2, Object obj) {
        if (this.pSV.isRepeated()) {
            ((List) a((a<M, B>) b2)).add(obj);
        } else if (!this.pSW.isEmpty()) {
            ((Map) a((a<M, B>) b2)).putAll((Map) obj);
        } else {
            b(b2, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b2, Object obj) {
        try {
            if (this.pSV.isOneOf()) {
                this.pTa.invoke(b2, obj);
            } else {
                this.pSZ.set(b2, obj);
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
            return this.pSZ.get(b2);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
