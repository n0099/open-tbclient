package org.msgpack.template;

import org.msgpack.MessageTypeException;
/* loaded from: classes.dex */
public class CharacterTemplate extends AbstractTemplate<Character> {

    /* renamed from: a  reason: collision with root package name */
    static final CharacterTemplate f2891a = new CharacterTemplate();

    private CharacterTemplate() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // org.msgpack.template.d
    public void a(org.msgpack.packer.a aVar, Character ch, boolean z) {
        if (ch == null) {
            if (z) {
                throw new MessageTypeException("Attempted to write null");
            }
            aVar.d();
            return;
        }
        aVar.a((int) ch.charValue());
    }

    public static CharacterTemplate a() {
        return f2891a;
    }
}
