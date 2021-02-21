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
    public final WireField.Label qaI;
    private final String qaJ;
    private final String qaK;
    public final boolean qaL;
    private final Field qaM;
    private final Method qaN;
    private ProtoAdapter<?> qaO;
    private ProtoAdapter<?> qaP;
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
        this.qaI = wireField.eDX();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.qaJ = wireField.eDV();
        this.qaK = wireField.eDW();
        this.qaL = wireField.eDY();
        this.messageField = field;
        this.qaM = j(cls, this.name);
        this.qaN = a(cls, this.name, field.getType());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean eDL() {
        return !this.qaJ.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<?> eDM() {
        ProtoAdapter<?> protoAdapter = this.qaO;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.qaK);
        this.qaO = protoAdapter2;
        return protoAdapter2;
    }

    ProtoAdapter<?> eDN() {
        ProtoAdapter<?> protoAdapter = this.qaP;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.qaJ);
        this.qaP = protoAdapter2;
        return protoAdapter2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter == null) {
            if (eDL()) {
                ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(eDN(), eDM());
                this.adapter = newMapAdapter;
                return newMapAdapter;
            }
            ProtoAdapter<?> withLabel = eDM().withLabel(this.qaI);
            this.adapter = withLabel;
            return withLabel;
        }
        return protoAdapter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(B b2, Object obj) {
        if (this.qaI.isRepeated()) {
            ((List) a((a<M, B>) b2)).add(obj);
        } else if (!this.qaJ.isEmpty()) {
            ((Map) a((a<M, B>) b2)).putAll((Map) obj);
        } else {
            b(b2, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(B b2, Object obj) {
        try {
            if (this.qaI.isOneOf()) {
                this.qaN.invoke(b2, obj);
            } else {
                this.qaM.set(b2, obj);
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
            return this.qaM.get(b2);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }
}
