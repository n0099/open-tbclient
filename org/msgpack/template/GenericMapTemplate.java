package org.msgpack.template;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class GenericMapTemplate implements c {

    /* renamed from: a  reason: collision with root package name */
    Constructor<? extends d> f2900a;

    public GenericMapTemplate(e eVar, Class<? extends d> cls) {
        try {
            this.f2900a = cls.getConstructor(d.class, d.class);
            this.f2900a.newInstance(new AnyTemplate(eVar), new AnyTemplate(eVar));
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        } catch (InstantiationException e2) {
            throw new IllegalArgumentException(e2);
        } catch (NoSuchMethodException e3) {
            throw new IllegalArgumentException(e3);
        } catch (InvocationTargetException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    @Override // org.msgpack.template.c
    public d a(d[] dVarArr) {
        try {
            return this.f2900a.newInstance(dVarArr);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        } catch (InstantiationException e2) {
            throw new IllegalArgumentException(e2);
        } catch (InvocationTargetException e3) {
            throw new IllegalArgumentException(e3);
        }
    }
}
