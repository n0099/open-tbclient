package javassist.bytecode;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes.dex */
public class SignatureAttribute extends e {

    /* loaded from: classes.dex */
    public abstract class ObjectType extends av {
    }

    public SignatureAttribute(y yVar, int i, DataInputStream dataInputStream) {
        super(yVar, i, dataInputStream);
    }

    public SignatureAttribute(y yVar, String str) {
        super(yVar, "Signature");
        int c = yVar.c(str);
        a(new byte[]{(byte) (c >>> 8), (byte) c});
    }

    public String a() {
        return c().w(g.a(e(), 0));
    }

    @Override // javassist.bytecode.e
    public e a(y yVar, Map map) {
        return new SignatureAttribute(yVar, a());
    }

    /* loaded from: classes.dex */
    public class BaseType extends av {

        /* renamed from: a */
        char f2702a;

        BaseType(char c) {
            this.f2702a = c;
        }

        public String toString() {
            return z.c(Character.toString(this.f2702a));
        }
    }

    /* loaded from: classes.dex */
    public class ClassType extends ObjectType {
        public static ClassType c = new ClassType("java.lang.Object", null);

        /* renamed from: a */
        String f2703a;
        aw[] b;

        static ClassType a(String str, int i, int i2, aw[] awVarArr, ClassType classType) {
            return classType == null ? new ClassType(str, i, i2, awVarArr) : new NestedClassType(str, i, i2, awVarArr, classType);
        }

        ClassType(String str, int i, int i2, aw[] awVarArr) {
            this.f2703a = str.substring(i, i2).replace('/', '.');
            this.b = awVarArr;
        }

        public ClassType(String str, aw[] awVarArr) {
            this.f2703a = str;
            this.b = awVarArr;
        }

        public ClassType a() {
            return null;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            ClassType a2 = a();
            if (a2 != null) {
                stringBuffer.append(a2.toString()).append('.');
            }
            stringBuffer.append(this.f2703a);
            if (this.b != null) {
                stringBuffer.append('<');
                int length = this.b.length;
                for (int i = 0; i < length; i++) {
                    if (i > 0) {
                        stringBuffer.append(", ");
                    }
                    stringBuffer.append(this.b[i].toString());
                }
                stringBuffer.append('>');
            }
            return stringBuffer.toString();
        }
    }

    /* loaded from: classes.dex */
    public class NestedClassType extends ClassType {
        ClassType d;

        NestedClassType(String str, int i, int i2, aw[] awVarArr, ClassType classType) {
            super(str, i, i2, awVarArr);
            this.d = classType;
        }

        @Override // javassist.bytecode.SignatureAttribute.ClassType
        public ClassType a() {
            return this.d;
        }
    }

    /* loaded from: classes.dex */
    public class ArrayType extends ObjectType {

        /* renamed from: a */
        int f2701a;
        av b;

        public ArrayType(int i, av avVar) {
            this.f2701a = i;
            this.b = avVar;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer(this.b.toString());
            for (int i = 0; i < this.f2701a; i++) {
                stringBuffer.append("[]");
            }
            return stringBuffer.toString();
        }
    }

    /* loaded from: classes.dex */
    public class TypeVariable extends ObjectType {

        /* renamed from: a */
        String f2704a;

        TypeVariable(String str, int i, int i2) {
            this.f2704a = str.substring(i, i2);
        }

        public String toString() {
            return this.f2704a;
        }
    }

    public static av a(String str) {
        try {
            return c(str, new au());
        } catch (IndexOutOfBoundsException e) {
            throw c(str);
        }
    }

    private static ObjectType a(String str, au auVar, boolean z) {
        int i = auVar.f2746a;
        switch (str.charAt(i)) {
            case 'L':
                return a(str, auVar, (ClassType) null);
            case 'T':
                return new TypeVariable(str, i + 1, auVar.a(str, 59));
            case '[':
                return b(str, auVar);
            default:
                if (z) {
                    return null;
                }
                throw c(str);
        }
    }

    private static ClassType a(String str, au auVar, ClassType classType) {
        char charAt;
        aw[] awVarArr;
        int i = auVar.f2746a + 1;
        auVar.f2746a = i;
        do {
            int i2 = auVar.f2746a;
            auVar.f2746a = i2 + 1;
            charAt = str.charAt(i2);
            if (charAt == '$' || charAt == '<') {
                break;
            }
        } while (charAt != ';');
        int i3 = auVar.f2746a - 1;
        if (charAt == '<') {
            awVarArr = a(str, auVar);
            int i4 = auVar.f2746a;
            auVar.f2746a = i4 + 1;
            charAt = str.charAt(i4);
        } else {
            awVarArr = null;
        }
        ClassType a2 = ClassType.a(str, i, i3, awVarArr, classType);
        if (charAt == '$' || charAt == '.') {
            auVar.f2746a--;
            return a(str, auVar, a2);
        }
        return a2;
    }

    private static aw[] a(String str, au auVar) {
        aw awVar;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i = auVar.f2746a;
            auVar.f2746a = i + 1;
            char charAt = str.charAt(i);
            if (charAt != '>') {
                if (charAt == '*') {
                    awVar = new aw(null, '*');
                } else {
                    if (charAt != '+' && charAt != '-') {
                        charAt = ' ';
                        auVar.f2746a--;
                    }
                    awVar = new aw(a(str, auVar, false), charAt);
                }
                arrayList.add(awVar);
            } else {
                return (aw[]) arrayList.toArray(new aw[arrayList.size()]);
            }
        }
    }

    private static ObjectType b(String str, au auVar) {
        int i = 1;
        while (true) {
            int i2 = auVar.f2746a + 1;
            auVar.f2746a = i2;
            if (str.charAt(i2) == '[') {
                i++;
            } else {
                return new ArrayType(i, c(str, auVar));
            }
        }
    }

    private static av c(String str, au auVar) {
        ObjectType a2 = a(str, auVar, true);
        if (a2 == null) {
            int i = auVar.f2746a;
            auVar.f2746a = i + 1;
            return new BaseType(str.charAt(i));
        }
        return a2;
    }

    public static BadBytecode c(String str) {
        return new BadBytecode("bad signature: " + str);
    }
}
