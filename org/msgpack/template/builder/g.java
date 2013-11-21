package org.msgpack.template.builder;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    protected List<f> f2933a;
    protected f b;

    private static boolean b() {
        return !org.msgpack.util.android.a.a();
    }

    public g(org.msgpack.template.e eVar) {
        this(eVar, null);
    }

    public g(org.msgpack.template.e eVar, ClassLoader classLoader) {
        this.f2933a = new ArrayList();
        a(eVar, classLoader);
    }

    protected void a(org.msgpack.template.e eVar, ClassLoader classLoader) {
        String str;
        if (eVar == null) {
            throw new NullPointerException("registry is null");
        }
        if (b()) {
            str = "org.msgpack.template.builder.JavassistTemplateBuilder";
        } else {
            str = "org.msgpack.template.builder.ReflectionTemplateBuilder";
        }
        this.b = a(str, eVar, classLoader);
        f fVar = this.b;
        this.f2933a.add(new ArrayTemplateBuilder(eVar));
        this.f2933a.add(new OrdinalEnumTemplateBuilder(eVar));
        this.f2933a.add(fVar);
        this.f2933a.add(new ReflectionBeansTemplateBuilder(eVar));
    }

    private static f a(String str, org.msgpack.template.e eVar, ClassLoader classLoader) {
        try {
            return (f) Class.forName(str).getConstructor(org.msgpack.template.e.class, ClassLoader.class).newInstance(eVar, classLoader);
        } catch (Exception e) {
            e.printStackTrace();
            return new ReflectionTemplateBuilder(eVar, classLoader);
        }
    }

    public f a() {
        return this.b;
    }

    public f a(Type type, boolean z) {
        for (f fVar : this.f2933a) {
            if (fVar.b(type, z)) {
                return fVar;
            }
        }
        return null;
    }
}
