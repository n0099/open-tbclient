package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class DoubleTemplate extends AbstractTemplate<Double> {

    /* renamed from: a  reason: collision with root package name */
    static final DoubleTemplate f2911a = new DoubleTemplate();

    private DoubleTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, Double d, boolean z) {
        if (d == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.a(d.doubleValue());
    }

    public static DoubleTemplate a() {
        return f2911a;
    }
}
