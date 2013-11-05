package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    protected y f2763a;
    int b;
    byte[] c;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(y yVar, int i, byte[] bArr) {
        this.f2763a = yVar;
        this.b = i;
        this.c = bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(y yVar, String str) {
        this(yVar, str, (byte[]) null);
    }

    public e(y yVar, String str, byte[] bArr) {
        this(yVar, yVar.c(str), bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(y yVar, int i, DataInputStream dataInputStream) {
        this.f2763a = yVar;
        this.b = i;
        int readInt = dataInputStream.readInt();
        this.c = new byte[readInt];
        if (readInt > 0) {
            dataInputStream.readFully(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a(y yVar, DataInputStream dataInputStream) {
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        String w = yVar.w(readUnsignedShort);
        if (w.charAt(0) < 'L') {
            if (w.equals("AnnotationDefault")) {
                return new AnnotationDefaultAttribute(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("BootstrapMethods")) {
                return new BootstrapMethodsAttribute(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("Code")) {
                return new CodeAttribute(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("ConstantValue")) {
                return new ConstantAttribute(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("Deprecated")) {
                return new DeprecatedAttribute(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("EnclosingMethod")) {
                return new EnclosingMethodAttribute(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("Exceptions")) {
                return new ExceptionsAttribute(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("InnerClasses")) {
                return new InnerClassesAttribute(yVar, readUnsignedShort, dataInputStream);
            }
        } else if (w.equals("LineNumberTable")) {
            return new LineNumberAttribute(yVar, readUnsignedShort, dataInputStream);
        } else {
            if (w.equals("LocalVariableTable")) {
                return new LocalVariableAttribute(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("LocalVariableTypeTable")) {
                return new LocalVariableTypeAttribute(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("RuntimeVisibleAnnotations") || w.equals("RuntimeInvisibleAnnotations")) {
                return new AnnotationsAttribute(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("RuntimeVisibleParameterAnnotations") || w.equals("RuntimeInvisibleParameterAnnotations")) {
                return new ParameterAnnotationsAttribute(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("Signature")) {
                return new SignatureAttribute(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("SourceFile")) {
                return new SourceFileAttribute(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("Synthetic")) {
                return new SyntheticAttribute(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("StackMap")) {
                return new StackMap(yVar, readUnsignedShort, dataInputStream);
            }
            if (w.equals("StackMapTable")) {
                return new StackMapTable(yVar, readUnsignedShort, dataInputStream);
            }
        }
        return new e(yVar, readUnsignedShort, dataInputStream);
    }

    public String b() {
        return this.f2763a.w(this.b);
    }

    public y c() {
        return this.f2763a;
    }

    public int d() {
        return this.c.length + 6;
    }

    public byte[] e() {
        return this.c;
    }

    public void a(byte[] bArr) {
        this.c = bArr;
    }

    public e a(y yVar, Map map) {
        int length = this.c.length;
        byte[] bArr = this.c;
        byte[] bArr2 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr2[i] = bArr[i];
        }
        return new e(yVar, b(), bArr2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeShort(this.b);
        dataOutputStream.writeInt(this.c.length);
        if (this.c.length > 0) {
            dataOutputStream.write(this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(ArrayList arrayList) {
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += ((e) arrayList.get(i2)).d();
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a(ArrayList arrayList, String str) {
        if (arrayList == null) {
            return null;
        }
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            e eVar = (e) listIterator.next();
            if (eVar.b().equals(str)) {
                return eVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void b(ArrayList arrayList, String str) {
        synchronized (e.class) {
            if (arrayList != null) {
                ListIterator listIterator = arrayList.listIterator();
                while (listIterator.hasNext()) {
                    if (((e) listIterator.next()).b().equals(str)) {
                        listIterator.remove();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(ArrayList arrayList, DataOutputStream dataOutputStream) {
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((e) arrayList.get(i)).a(dataOutputStream);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList a(ArrayList arrayList, y yVar) {
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(((e) arrayList.get(i)).a(yVar, (Map) null));
        }
        return arrayList2;
    }
}
