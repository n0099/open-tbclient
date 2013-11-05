package org.msgpack.template.builder;

import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.msgpack.template.OrdinalEnumTemplate;
/* loaded from: classes.dex */
public class OrdinalEnumTemplateBuilder extends AbstractTemplateBuilder {
    private static final Logger b = Logger.getLogger(OrdinalEnumTemplateBuilder.class.getName());

    public OrdinalEnumTemplateBuilder(org.msgpack.template.e eVar) {
        super(eVar);
    }

    @Override // org.msgpack.template.builder.f
    public boolean b(Type type, boolean z) {
        Class cls = (Class) type;
        boolean c = c(cls, z);
        if (c && b.isLoggable(Level.FINE)) {
            b.fine("matched type: " + cls.getName());
        }
        return c;
    }

    @Override // org.msgpack.template.builder.AbstractTemplateBuilder
    public <T> org.msgpack.template.d<T> a(Class<T> cls, c[] cVarArr) {
        throw new UnsupportedOperationException("fatal error: " + cls.getName());
    }

    @Override // org.msgpack.template.builder.AbstractTemplateBuilder, org.msgpack.template.builder.f
    public <T> org.msgpack.template.d<T> a(Type type) {
        Class<?> cls = (Class) type;
        c(cls);
        return new OrdinalEnumTemplate(cls);
    }

    protected void c(Class<?> cls) {
        if (!cls.isEnum()) {
            throw new TemplateBuildException("tried to build ordinal enum template of non-enum class: " + cls.getName());
        }
    }
}
