package javassist.bytecode;

import java.io.DataInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends al {
    public ae(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public ae(DataInputStream dataInputStream, int i) {
        super(dataInputStream, i);
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 9;
    }

    @Override // javassist.bytecode.al
    public String b() {
        return "Field";
    }

    @Override // javassist.bytecode.al
    protected int a(y yVar, int i, int i2) {
        return yVar.b(i, i2);
    }
}
