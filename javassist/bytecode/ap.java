package javassist.bytecode;

import java.io.DataInputStream;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends al {
    public ap(int i, int i2, int i3) {
        super(i, i2, i3);
    }

    public ap(DataInputStream dataInputStream, int i) {
        super(dataInputStream, i);
    }

    @Override // javassist.bytecode.w
    public int a() {
        return 10;
    }

    @Override // javassist.bytecode.al
    public String b() {
        return "Method";
    }

    @Override // javassist.bytecode.al
    protected int a(y yVar, int i, int i2) {
        return yVar.c(i, i2);
    }
}
