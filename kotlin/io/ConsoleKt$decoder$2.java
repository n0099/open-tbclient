package kotlin.io;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import kotlin.jvm.internal.Lambda;
/* loaded from: classes5.dex */
final class ConsoleKt$decoder$2 extends Lambda implements kotlin.jvm.a.a<CharsetDecoder> {
    public static final ConsoleKt$decoder$2 INSTANCE = new ConsoleKt$decoder$2();

    ConsoleKt$decoder$2() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.a.a
    public final CharsetDecoder invoke() {
        return Charset.defaultCharset().newDecoder();
    }
}
