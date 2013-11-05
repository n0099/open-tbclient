package javassist.bytecode;

import java.io.DataInputStream;
/* loaded from: classes.dex */
public class LocalVariableTypeAttribute extends LocalVariableAttribute {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalVariableTypeAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    private LocalVariableTypeAttribute(y yVar, byte[] bArr) {
        super(yVar, "LocalVariableTypeTable", bArr);
    }

    @Override // javassist.bytecode.LocalVariableAttribute
    LocalVariableAttribute a(y yVar, byte[] bArr) {
        return new LocalVariableTypeAttribute(yVar, bArr);
    }
}
