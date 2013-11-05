package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class SyntheticAttribute extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public SyntheticAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    public SyntheticAttribute(y yVar) {
        super(yVar, "Synthetic", new byte[0]);
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        return new SyntheticAttribute(yVar);
    }
}
