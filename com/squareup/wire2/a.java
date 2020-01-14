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
    public final WireField.Label noq;
    private final String nor;
    private final String nos;
    public final boolean not;
    private final Field nou;
    private final Method nov;
    private ProtoAdapter<?> nox;
    private ProtoAdapter<?> noy;
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
        this.noq = wireField.dFo();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.nor = wireField.dFm();
        this.nos = wireField.dFn();
        this.not = wireField.dFp();
        this.messageField = field;
        this.nou = i(cls, this.name);
        this.nov = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dFc() {
        return !this.nor.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> dFd() {
        ProtoAdapter<?> protoAdapter = this.nox;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.nos);
        this.nox = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> dFe() {
        ProtoAdapter<?> protoAdapter = this.noy;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.nor);
        this.noy = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (dFc()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(dFe(), dFd());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = dFd().withLabel(this.noq);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b, Object obj) {
        if (this.noq.isRepeated()) {
            ((List) a((a<M, B>) b)).add(obj);
        } else if (!this.nor.isEmpty()) {
            ((Map) a((a<M, B>) b)).putAll((Map) obj);
        } else {
            b(b, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b, Object obj) {
        try {
            if (this.noq.isOneOf()) {
                this.nov.invoke(b, obj);
            } else {
                this.nou.set(b, obj);
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
            return this.nou.get(b);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
