package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class StringTemplate extends AbstractTemplate<String> {

    /* renamed from: a  reason: collision with root package name */
    static final StringTemplate f2930a = new StringTemplate();

    private StringTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, String str, boolean z) {
        if (str == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.a(str);
    }

    public static StringTemplate a() {
        return f2930a;
    }
}
