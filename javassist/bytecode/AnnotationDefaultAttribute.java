package javassist.bytecode;

import java.io.DataInputStream;
import java.util.Map;
/* loaded from: classes.dex */
public class AnnotationDefaultAttribute extends e {
    public AnnotationDefaultAttribute(y yVar, byte[] bArr) {
        super(yVar, "AnnotationDefault", bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnnotationDefaultAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        b bVar = new b(this.c, this.f2795a, yVar, map);
        try {
            bVar.g(0);
            return new AnnotationDefaultAttribute(yVar, bVar.a());
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    public javassist.bytecode.annotation.d a() {
        try {
            return new c(this.c, this.f2795a).c();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    public String toString() {
        return a().toString();
    }
}
