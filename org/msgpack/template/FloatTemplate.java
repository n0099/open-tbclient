package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class FloatTemplate extends AbstractTemplate<Float> {

    /* renamed from: a  reason: collision with root package name */
    static final FloatTemplate f3079a = new FloatTemplate();

    private FloatTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, Float f, boolean z) {
        if (f == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.a(f.floatValue());
    }

    public static FloatTemplate a() {
        return f3079a;
    }
}
