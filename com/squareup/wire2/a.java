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
    private final String pHA;
    public final boolean pHB;
    private final Field pHC;
    private final Method pHD;
    private ProtoAdapter<?> pHE;
    private ProtoAdapter<?> pHF;
    public final WireField.Label pHy;
    private final String pHz;
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
        this.pHy = wireField.eyt();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.pHz = wireField.eyr();
        this.pHA = wireField.eys();
        this.pHB = wireField.eyu();
        this.messageField = field;
        this.pHC = i(cls, this.name);
        this.pHD = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean eyh() {
        return !this.pHz.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> eyi() {
        ProtoAdapter<?> protoAdapter = this.pHE;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.pHA);
        this.pHE = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> eyj() {
        ProtoAdapter<?> protoAdapter = this.pHF;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.pHz);
        this.pHF = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (eyh()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(eyj(), eyi());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = eyi().withLabel(this.pHy);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b, Object obj) {
        if (this.pHy.isRepeated()) {
            ((List) a((a<M, B>) b)).add(obj);
        } else if (!this.pHz.isEmpty()) {
            ((Map) a((a<M, B>) b)).putAll((Map) obj);
        } else {
            b(b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b, Object obj) {
        try {
            if (this.pHy.isOneOf()) {
                this.pHD.invoke(b, obj);
            } else {
                this.pHC.set(b, obj);
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
            return this.pHC.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
