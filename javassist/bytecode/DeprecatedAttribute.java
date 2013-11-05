package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class DeprecatedAttribute extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public DeprecatedAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    public DeprecatedAttribute(y yVar) {
        super(yVar, "Deprecated", new byte[0]);
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        return new DeprecatedAttribute(yVar);
    }
}
