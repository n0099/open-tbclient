package javassist.bytecode;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class w {
    int b;

    public abstract int a();

    public abstract int a(y yVar, y yVar2, Map map);

    public abstract void a(DataOutputStream dataOutputStream);

    public abstract void a(PrintWriter printWriter);

    public w(int i) {
        this.b = i;
    }

    public String toString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(new PrintWriter(byteArrayOutputStream));
        return byteArrayOutputStream.toString();
    }
}
