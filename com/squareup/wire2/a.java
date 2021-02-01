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
    public final WireField.Label qai;
    private final String qaj;
    private final String qak;
    public final boolean qal;
    private final Field qam;
    private final Method qan;
    private ProtoAdapter<?> qao;
    private ProtoAdapter<?> qap;
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
        this.qai = wireField.eDP();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.qaj = wireField.eDN();
        this.qak = wireField.eDO();
        this.qal = wireField.eDQ();
        this.messageField = field;
        this.qam = j(cls, this.name);
        this.qan = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean eDD() {
        return !this.qaj.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> eDE() {
        ProtoAdapter<?> protoAdapter = this.qao;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.qak);
        this.qao = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> eDF() {
        ProtoAdapter<?> protoAdapter = this.qap;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.qaj);
        this.qap = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (eDD()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(eDF(), eDE());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = eDE().withLabel(this.qai);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b2, Object obj) {
        if (this.qai.isRepeated()) {
            ((List) a((a<M, B>) b2)).add(obj);
        } else if (!this.qaj.isEmpty()) {
            ((Map) a((a<M, B>) b2)).putAll((Map) obj);
        } else {
            b(b2, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b2, Object obj) {
        try {
            if (this.qai.isOneOf()) {
                this.qan.invoke(b2, obj);
            } else {
                this.qam.set(b2, obj);
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
            return this.qam.get(b2);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
