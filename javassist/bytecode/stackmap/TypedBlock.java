package javassist.bytecode.stackmap;

import com.baidu.location.BDLocation;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.an;
import javassist.bytecode.stackmap.TypeData;
/* loaded from: classes.dex */
public class TypedBlock extends BasicBlock {

    /* renamed from: a  reason: collision with root package name */
    public int f2827a;
    public int h;
    public TypeData[] i;
    public TypeData[] j;

    public static TypedBlock[] a(an anVar, CodeAttribute codeAttribute, boolean z) {
        TypedBlock[] typedBlockArr = (TypedBlock[]) new Maker().a(anVar);
        if (z && typedBlockArr.length < 2 && (typedBlockArr.length == 0 || typedBlockArr[0].d == 0)) {
            return null;
        }
        typedBlockArr[0].a(codeAttribute.f(), codeAttribute.g(), anVar.c().a(), anVar.g(), (anVar.f() & 8) != 0, anVar.d());
        return typedBlockArr;
    }

    protected TypedBlock(int i) {
        super(i);
        this.i = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // javassist.bytecode.stackmap.BasicBlock
    public void a(StringBuffer stringBuffer) {
        super.a(stringBuffer);
        stringBuffer.append(",\n stack={");
        a(stringBuffer, this.f2827a, this.j);
        stringBuffer.append("}, locals={");
        a(stringBuffer, this.h, this.i);
        stringBuffer.append('}');
    }

    private void a(StringBuffer stringBuffer, int i, TypeData[] typeDataArr) {
        if (typeDataArr != null) {
            for (int i2 = 0; i2 < i; i2++) {
                if (i2 > 0) {
                    stringBuffer.append(", ");
                }
                TypeData typeData = typeDataArr[i2];
                stringBuffer.append(typeData == null ? "<>" : typeData.toString());
            }
        }
    }

    public boolean a() {
        return this.i != null;
    }

    public void a(int i, TypeData[] typeDataArr, int i2, TypeData[] typeDataArr2) {
        this.f2827a = i;
        this.j = typeDataArr;
        this.h = i2;
        this.i = typeDataArr2;
    }

    public void b() {
        if (this.i != null) {
            int length = this.i.length;
            while (length > 0 && this.i[length - 1].c() == d.g && (length <= 1 || !this.i[length - 2].d())) {
                length--;
            }
            this.h = length;
        }
    }

    /* loaded from: classes.dex */
    public class Maker extends b {
        @Override // javassist.bytecode.stackmap.b
        protected BasicBlock a(int i) {
            return new TypedBlock(i);
        }

        @Override // javassist.bytecode.stackmap.b
        protected BasicBlock[] b(int i) {
            return new TypedBlock[i];
        }
    }

    void a(int i, int i2, String str, String str2, boolean z, boolean z2) {
        if (str2.charAt(0) != '(') {
            throw new BadBytecode("no method descriptor: " + str2);
        }
        this.f2827a = 0;
        this.j = TypeData.a(i);
        TypeData[] a2 = TypeData.a(i2);
        if (z2) {
            a2[0] = new TypeData.UninitThis(str);
        } else if (!z) {
            a2[0] = new TypeData.ClassName(str);
        }
        int i3 = z ? -1 : 0;
        int i4 = 1;
        while (true) {
            i3++;
            try {
                i4 = a(str2, i4, i3, a2);
                if (i4 > 0) {
                    if (a2[i3].d()) {
                        i3++;
                        a2[i3] = d.g;
                    }
                } else {
                    this.h = i3;
                    this.i = a2;
                    return;
                }
            } catch (StringIndexOutOfBoundsException e) {
                throw new BadBytecode("bad method descriptor: " + str2);
            }
        }
    }

    private static int a(String str, int i, int i2, TypeData[] typeDataArr) {
        char charAt = str.charAt(i);
        if (charAt == ')') {
            return 0;
        }
        int i3 = i;
        char c = charAt;
        int i4 = 0;
        while (c == '[') {
            i4++;
            i3++;
            c = str.charAt(i3);
        }
        if (c == 'L') {
            int indexOf = str.indexOf(59, i3 + 1);
            if (i4 > 0) {
                int i5 = indexOf + 1;
                typeDataArr[i2] = new TypeData.ClassName(str.substring(i, i5));
                return i5;
            }
            int i6 = indexOf + 1;
            typeDataArr[i2] = new TypeData.ClassName(str.substring(i + 1, i6 - 1).replace('/', '.'));
            return i6;
        } else if (i4 > 0) {
            int i7 = i3 + 1;
            typeDataArr[i2] = new TypeData.ClassName(str.substring(i, i7));
            return i7;
        } else {
            TypeData a2 = a(c);
            if (a2 == null) {
                throw new BadBytecode("bad method descriptor: " + str);
            }
            typeDataArr[i2] = a2;
            return i3 + 1;
        }
    }

    private static TypeData a(char c) {
        switch (c) {
            case BDLocation.TypeOffLineLocation /* 66 */:
            case BDLocation.TypeOffLineLocationFail /* 67 */:
            case 'I':
            case 'S':
            case 'Z':
                return d.h;
            case BDLocation.TypeOffLineLocationNetworkFail /* 68 */:
                return d.j;
            case 'F':
                return d.i;
            case 'J':
                return d.k;
            default:
                return null;
        }
    }

    public static String a(String str) {
        int indexOf = str.indexOf(41);
        if (indexOf < 0) {
            return "java.lang.Object";
        }
        char charAt = str.charAt(indexOf + 1);
        if (charAt == '[') {
            return str.substring(indexOf + 1);
        }
        if (charAt == 'L') {
            return str.substring(indexOf + 2, str.length() - 1).replace('/', '.');
        }
        return "java.lang.Object";
    }
}
