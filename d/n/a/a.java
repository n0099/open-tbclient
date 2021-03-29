package d.n.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.squareup.wire2.Message;
import com.squareup.wire2.Message.a;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class a<M extends Message<M, B>, B extends Message.a<M, B>> {

    /* renamed from: a  reason: collision with root package name */
    public final WireField.Label f66308a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66309b;

    /* renamed from: c  reason: collision with root package name */
    public final int f66310c;

    /* renamed from: d  reason: collision with root package name */
    public final String f66311d;

    /* renamed from: e  reason: collision with root package name */
    public final String f66312e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f66313f;

    /* renamed from: g  reason: collision with root package name */
    public final Field f66314g;

    /* renamed from: h  reason: collision with root package name */
    public final Field f66315h;
    public final Method i;
    public ProtoAdapter<?> j;
    public ProtoAdapter<?> k;
    public ProtoAdapter<Object> l;

    public a(WireField wireField, Field field, Class<B> cls) {
        this.f66308a = wireField.label();
        this.f66309b = field.getName();
        this.f66310c = wireField.tag();
        this.f66311d = wireField.keyAdapter();
        this.f66312e = wireField.adapter();
        this.f66313f = wireField.redacted();
        this.f66314g = field;
        this.f66315h = c(cls, this.f66309b);
        this.i = d(cls, this.f66309b, field.getType());
    }

    public static Field c(Class<?> cls, String str) {
        try {
            return cls.getField(str);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError("No builder field " + cls.getName() + "." + str);
        }
    }

    public static Method d(Class<?> cls, String str, Class<?> cls2) {
        try {
            return cls.getMethod(str, cls2);
        } catch (NoSuchMethodException unused) {
            throw new AssertionError("No builder method " + cls.getName() + "." + str + "(" + cls2.getName() + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public ProtoAdapter<Object> a() {
        ProtoAdapter<Object> protoAdapter = this.l;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        if (f()) {
            ProtoAdapter<Object> newMapAdapter = ProtoAdapter.newMapAdapter(g(), i());
            this.l = newMapAdapter;
            return newMapAdapter;
        }
        ProtoAdapter<?> withLabel = i().withLabel(this.f66308a);
        this.l = withLabel;
        return withLabel;
    }

    public Object b(M m) {
        try {
            return this.f66314g.get(m);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    public Object e(B b2) {
        try {
            return this.f66315h.get(b2);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean f() {
        return !this.f66311d.isEmpty();
    }

    public ProtoAdapter<?> g() {
        ProtoAdapter<?> protoAdapter = this.k;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.f66311d);
        this.k = protoAdapter2;
        return protoAdapter2;
    }

    public void h(B b2, Object obj) {
        try {
            if (this.f66308a.isOneOf()) {
                this.i.invoke(b2, obj);
            } else {
                this.f66315h.set(b2, obj);
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    public ProtoAdapter<?> i() {
        ProtoAdapter<?> protoAdapter = this.j;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.f66312e);
        this.j = protoAdapter2;
        return protoAdapter2;
    }

    public void j(B b2, Object obj) {
        if (this.f66308a.isRepeated()) {
            ((List) e(b2)).add(obj);
        } else if (!this.f66311d.isEmpty()) {
            ((Map) e(b2)).putAll((Map) obj);
        } else {
            h(b2, obj);
        }
    }
}
