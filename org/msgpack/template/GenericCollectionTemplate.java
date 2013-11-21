package org.msgpack.template;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes.dex */
public class GenericCollectionTemplate implements c {

    /* renamed from: a  reason: collision with root package name */
    Constructor<? extends d> f2899a;

    public GenericCollectionTemplate(e eVar, Class<? extends d> cls) {
        try {
            this.f2899a = cls.getConstructor(d.class);
            this.f2899a.newInstance(new AnyTemplate(eVar));
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
            return this.f2899a.newInstance(dVarArr);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        } catch (InstantiationException e2) {
            throw new IllegalArgumentException(e2);
        } catch (InvocationTargetException e3) {
            throw new IllegalArgumentException(e3);
        }
    }
}
