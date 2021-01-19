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
    public final String name;
    public final WireField.Label pQe;
    private final String pQf;
    private final String pQg;
    public final boolean pQh;
    private final Field pQi;
    private final Method pQj;
    private ProtoAdapter<?> pQk;
    private ProtoAdapter<?> pQl;
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
        this.pQe = wireField.eBy();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.pQf = wireField.eBw();
        this.pQg = wireField.eBx();
        this.pQh = wireField.eBz();
        this.messageField = field;
        this.pQi = j(cls, this.name);
        this.pQj = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean eBm() {
        return !this.pQf.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> eBn() {
        ProtoAdapter<?> protoAdapter = this.pQk;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.pQg);
        this.pQk = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> eBo() {
        ProtoAdapter<?> protoAdapter = this.pQl;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.pQf);
        this.pQl = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (eBm()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(eBo(), eBn());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = eBn().withLabel(this.pQe);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b2, Object obj) {
        if (this.pQe.isRepeated()) {
            ((List) a((a<M, B>) b2)).add(obj);
        } else if (!this.pQf.isEmpty()) {
            ((Map) a((a<M, B>) b2)).putAll((Map) obj);
        } else {
            b(b2, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b2, Object obj) {
        try {
            if (this.pQe.isOneOf()) {
                this.pQj.invoke(b2, obj);
            } else {
                this.pQi.set(b2, obj);
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
            return this.pQi.get(b2);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
