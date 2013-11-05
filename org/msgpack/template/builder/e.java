package org.msgpack.template.builder;

import org.msgpack.template.builder.ReflectionTemplateBuilder;
/* loaded from: classes.dex */
final class e extends ReflectionTemplateBuilder.ReflectionFieldTemplate {
    private org.msgpack.template.d b;

    public e(c cVar, org.msgpack.template.d dVar) {
        super(cVar);
        this.b = dVar;
    }

    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, Object obj, boolean z) {
        this.b.a(aVar, obj, z);
    }
}
