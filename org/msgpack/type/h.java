package org.msgpack.type;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
/* loaded from: classes.dex */
class h extends ThreadLocal<CharsetDecoder> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    /* renamed from: a */
    public CharsetDecoder initialValue() {
        return Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.IGNORE).onUnmappableCharacter(CodingErrorAction.IGNORE);
    }
}
