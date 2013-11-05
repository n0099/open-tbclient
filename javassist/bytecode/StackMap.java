package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class StackMap extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StackMap(y yVar, byte[] bArr) {
        super(yVar, "StackMap", bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StackMap(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        ax axVar = new ax(this, yVar, map);
        axVar.a();
        return axVar.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, boolean z) {
        new az(this, i, i2, z).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        new bb(this, i, i2).a();
    }

    public void a(int i) {
        a(new ay(this, i).b());
    }
}
