package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class ConstantAttribute extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstantAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    public ConstantAttribute(y yVar, int i) {
        super(yVar, "ConstantValue");
        a(new byte[]{(byte) (i >>> 8), (byte) i});
    }

    public int a() {
        return g.a(e(), 0);
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        return new ConstantAttribute(yVar, c().a(a(), yVar, map));
    }
}
