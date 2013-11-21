package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class FloatArrayTemplate extends AbstractTemplate<float[]> {

    /* renamed from: a  reason: collision with root package name */
    static final FloatArrayTemplate f2897a = new FloatArrayTemplate();

    private FloatArrayTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, float[] fArr, boolean z) {
        if (fArr == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.c(fArr.length);
        for (float f : fArr) {
            aVar.a(f);
        }
        aVar.a();
    }

    public static FloatArrayTemplate a() {
        return f2897a;
    }
}
