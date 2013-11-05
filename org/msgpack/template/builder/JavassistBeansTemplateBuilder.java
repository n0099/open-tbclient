package org.msgpack.template.builder;

import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public class JavassistBeansTemplateBuilder extends JavassistTemplateBuilder {
    private static final Logger e = Logger.getLogger(JavassistBeansTemplateBuilder.class.getName());

    @Override // org.msgpack.template.builder.JavassistTemplateBuilder, org.msgpack.template.builder.f
    public boolean b(Type type, boolean z) {
        Class cls = (Class) type;
        boolean a2 = a((Class<?>) cls, z);
        if (a2 && e.isLoggable(Level.FINE)) {
            e.fine("matched type: " + cls.getName());
        }
        return a2;
    }

    @Override // org.msgpack.template.builder.JavassistTemplateBuilder
    protected b a() {
        return new BeansBuildContext(this);
    }
}
