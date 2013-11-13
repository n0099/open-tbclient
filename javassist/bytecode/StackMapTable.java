package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Map;
import javassist.CannotCompileException;
/* loaded from: classes.dex */
public class StackMapTable extends e {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StackMapTable(y yVar, byte[] bArr) {
        super(yVar, "StackMapTable", bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StackMapTable(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        try {
            return new StackMapTable(yVar, new be(this.f2811a, this.c, yVar, map).a());
        } catch (BadBytecode e) {
            throw new RuntimeCopyException("bad bytecode. fatal?");
        }
    }

    /* loaded from: classes.dex */
    public class RuntimeCopyException extends RuntimeException {
        public RuntimeCopyException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.e
    public void a(DataOutputStream dataOutputStream) {
        super.a(dataOutputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2, boolean z) {
        new bg(this, i, i2).b();
        new bh(this, i, i2, z).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, int i2) {
        new bj(this, i, i2).a();
    }

    public void a(int i) {
        try {
            a(new bf(e(), i).a());
        } catch (BadBytecode e) {
            throw new CannotCompileException("bad stack map table", e);
        }
    }
}
