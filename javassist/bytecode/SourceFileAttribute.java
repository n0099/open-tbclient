package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class SourceFileAttribute extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SourceFileAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    public SourceFileAttribute(y yVar, String str) {
        super(yVar, "SourceFile");
        int c = yVar.c(str);
        a(new byte[]{(byte) (c >>> 8), (byte) c});
    }

    public String a() {
        return c().w(g.a(e(), 0));
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        return new SourceFileAttribute(yVar, a());
    }
}
