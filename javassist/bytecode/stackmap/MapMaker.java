package javassist.bytecode.stackmap;

import java.util.ArrayList;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.StackMap;
import javassist.bytecode.StackMapTable;
import javassist.bytecode.an;
import javassist.bytecode.bd;
import javassist.bytecode.bl;
import javassist.bytecode.g;
import javassist.bytecode.stackmap.BasicBlock;
import javassist.bytecode.stackmap.TypeData;
import javassist.bytecode.y;
/* loaded from: classes.dex */
public class MapMaker extends Tracer {
    public static StackMapTable a(javassist.c cVar, an anVar) {
        CodeAttribute i = anVar.i();
        if (i == null) {
            return null;
        }
        try {
            TypedBlock[] a2 = TypedBlock.a(anVar, i, true);
            if (a2 != null) {
                MapMaker mapMaker = new MapMaker(cVar, anVar, i);
                try {
                    mapMaker.a(a2, i.i());
                    return mapMaker.a(a2);
                } catch (BadBytecode e) {
                    throw new BadBytecode(anVar, e);
                }
            }
            return null;
        } catch (BasicBlock.JsrBytecode e2) {
            return null;
        }
    }

    public static StackMap b(javassist.c cVar, an anVar) {
        CodeAttribute i = anVar.i();
        if (i == null) {
            return null;
        }
        try {
            TypedBlock[] a2 = TypedBlock.a(anVar, i, true);
            if (a2 != null) {
                MapMaker mapMaker = new MapMaker(cVar, anVar, i);
                try {
                    mapMaker.a(a2, i.i());
                    return mapMaker.a(anVar.c(), a2);
                } catch (BadBytecode e) {
                    throw new BadBytecode(anVar, e);
                }
            }
            return null;
        } catch (BasicBlock.JsrBytecode e2) {
            return null;
        }
    }

    public MapMaker(javassist.c cVar, an anVar, CodeAttribute codeAttribute) {
        super(cVar, anVar.c(), codeAttribute.f(), codeAttribute.g(), TypedBlock.a(anVar.g()));
    }

    protected MapMaker(MapMaker mapMaker) {
        super(mapMaker);
    }

    void a(TypedBlock[] typedBlockArr, byte[] bArr) {
        a(bArr, typedBlockArr[0]);
        a(bArr, typedBlockArr);
        try {
            b(bArr, typedBlockArr);
        } catch (NotFoundException e) {
            throw new BadBytecode("failed to resolve types", e);
        }
    }

    private void a(byte[] bArr, TypedBlock typedBlock) {
        b(typedBlock.f2992a, typedBlock.j, this.e);
        this.d = typedBlock.f2992a;
        b(typedBlock.i.length, typedBlock.i, this.f);
        a(bArr, typedBlock.g);
        int i = typedBlock.b;
        int i2 = typedBlock.c + i;
        while (i < i2) {
            i += a(i, bArr);
        }
        a(bArr, typedBlock.g);
        if (typedBlock.e != null) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < typedBlock.e.length) {
                    TypedBlock typedBlock2 = (TypedBlock) typedBlock.e[i4];
                    if (typedBlock2.a()) {
                        a(typedBlock2, true);
                    } else {
                        a(typedBlock2);
                        new MapMaker(this).a(bArr, typedBlock2);
                    }
                    i3 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    private void a(byte[] bArr, a aVar) {
        while (aVar != null) {
            TypedBlock typedBlock = (TypedBlock) aVar.b;
            if (typedBlock.a()) {
                a(typedBlock, false);
                if (typedBlock.f2992a < 1) {
                    throw new BadBytecode("bad catch clause: " + aVar.c);
                }
                typedBlock.j[0] = a(a(aVar.c), typedBlock.j[0]);
            } else {
                a(typedBlock, aVar.c);
                new MapMaker(this).a(bArr, typedBlock);
            }
            aVar = aVar.f2993a;
        }
    }

    private void a(TypedBlock typedBlock, boolean z) {
        int length = this.f.length;
        for (int i = 0; i < length; i++) {
            typedBlock.i[i] = a(this.f[i], typedBlock.i[i]);
        }
        if (z) {
            int i2 = this.d;
            for (int i3 = 0; i3 < i2; i3++) {
                typedBlock.j[i3] = a(this.e[i3], typedBlock.j[i3]);
            }
        }
    }

    private TypeData a(TypeData typeData, TypeData typeData2) {
        if (typeData != typeData2 && !(typeData2 instanceof TypeData.ClassName) && !(typeData2 instanceof TypeData.BasicType)) {
            if (typeData2 instanceof TypeData.AbsTypeVar) {
                ((TypeData.AbsTypeVar) typeData2).b(typeData);
            } else {
                throw new RuntimeException("fatal: this should never happen");
            }
        }
        return typeData2;
    }

    private void a(TypedBlock typedBlock) {
        TypeData[] a2 = TypeData.a(this.e.length);
        int i = this.d;
        a(i, this.e, a2);
        a(typedBlock, i, a2);
    }

    private void a(TypedBlock typedBlock, int i) {
        TypeData[] a2 = TypeData.a(this.e.length);
        a2[0] = a(i).b();
        a(typedBlock, 1, a2);
    }

    private TypeData.ClassName a(int i) {
        String d;
        if (i == 0) {
            d = "java.lang.Throwable";
        } else {
            d = this.b.d(i);
        }
        return new TypeData.ClassName(d);
    }

    private void a(TypedBlock typedBlock, int i, TypeData[] typeDataArr) {
        int length = this.f.length;
        TypeData[] a2 = TypeData.a(length);
        typedBlock.a(i, typeDataArr, a(length, this.f, a2), a2);
    }

    protected static int a(int i, TypeData[] typeDataArr, TypeData[] typeDataArr2) {
        int i2 = -1;
        for (int i3 = 0; i3 < i; i3++) {
            TypeData typeData = typeDataArr[i3];
            typeDataArr2[i3] = typeData.b();
            if (typeData != g) {
                i2 = i3 + 1;
            }
        }
        return i2 + 1;
    }

    protected static void b(int i, TypeData[] typeDataArr, TypeData[] typeDataArr2) {
        for (int i2 = 0; i2 < i; i2++) {
            typeDataArr2[i2] = typeDataArr[i2];
        }
    }

    private void a(byte[] bArr, TypedBlock[] typedBlockArr) {
        for (TypedBlock typedBlock : typedBlockArr) {
            if (typedBlock.i == null) {
                a aVar = typedBlock.g;
                while (true) {
                    if (aVar == null) {
                        break;
                    } else if (aVar.b == typedBlock) {
                        a(bArr, new a(typedBlock, aVar.c, null));
                        break;
                    } else {
                        aVar = aVar.f2993a;
                    }
                }
            }
        }
    }

    private void b(byte[] bArr, TypedBlock[] typedBlockArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (TypedBlock typedBlock : typedBlockArr) {
            if (typedBlock.i == null) {
                b(bArr, typedBlock);
            } else {
                int length = typedBlock.i.length;
                int i2 = 0;
                while (i2 < length) {
                    int a2 = typedBlock.i[i2].a(arrayList, i, this.f2984a);
                    i2++;
                    i = a2;
                }
                int i3 = typedBlock.f2992a;
                int i4 = 0;
                while (i4 < i3) {
                    int a3 = typedBlock.j[i4].a(arrayList, i, this.f2984a);
                    i4++;
                    i = a3;
                }
            }
        }
    }

    private void b(byte[] bArr, TypedBlock typedBlock) {
        int i = typedBlock.b;
        int i2 = typedBlock.c - 3;
        if (i2 < 0) {
            throw new BadBytecode("dead code detected at " + i + ".  No stackmap table generated.");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            bArr[i + i3] = 0;
        }
        bArr[i + i2] = -89;
        g.a(-i2, bArr, i + i2 + 1);
    }

    public StackMapTable a(TypedBlock[] typedBlockArr) {
        int i;
        bl blVar = new bl(32);
        int length = typedBlockArr.length;
        TypedBlock typedBlock = typedBlockArr[0];
        int i2 = typedBlock.c;
        if (typedBlock.d > 0) {
            blVar.a(0);
            i2--;
        }
        int i3 = 1;
        int i4 = i2;
        while (i3 < length) {
            TypedBlock typedBlock2 = typedBlockArr[i3];
            if (a(typedBlock2, typedBlockArr[i3 - 1])) {
                typedBlock2.b();
                a(blVar, typedBlock2, a(typedBlock.h, typedBlock.i, typedBlock2.h, typedBlock2.i), i4, typedBlock);
                i = typedBlock2.c - 1;
            } else if (typedBlock2.d == 0) {
                blVar.a(i4);
                i = typedBlock2.c - 1;
            } else {
                i = typedBlock2.c + i4;
                typedBlock2 = typedBlock;
            }
            i3++;
            i4 = i;
            typedBlock = typedBlock2;
        }
        return blVar.a(this.b);
    }

    private boolean a(TypedBlock typedBlock, TypedBlock typedBlock2) {
        int i = typedBlock.d;
        if (i > 1) {
            return true;
        }
        if (i < 1) {
            return false;
        }
        return typedBlock2.f;
    }

    private void a(bl blVar, TypedBlock typedBlock, int i, int i2, TypedBlock typedBlock2) {
        int i3 = typedBlock.f2992a;
        if (i3 == 0) {
            if (i == 0) {
                blVar.a(i2);
                return;
            } else if (i < 0 && i >= -3) {
                blVar.a(i2, -i);
                return;
            } else if (i > 0 && i <= 3) {
                int[] iArr = new int[i];
                blVar.a(i2, a(typedBlock.h - typedBlock2.h, typedBlock2.h, iArr, typedBlock.i), iArr);
                return;
            }
        } else if (i3 == 1 && i == 0) {
            TypeData typeData = typedBlock.j[0];
            blVar.a(i2, typeData.a(), typeData.a(this.b));
            return;
        } else if (i3 == 2 && i == 0) {
            TypeData typeData2 = typedBlock.j[0];
            if (typeData2.d()) {
                blVar.a(i2, typeData2.a(), typeData2.a(this.b));
                return;
            }
        }
        int[] iArr2 = new int[i3];
        int[] a2 = a(i3, 0, iArr2, typedBlock.j);
        int[] iArr3 = new int[typedBlock.h];
        blVar.a(i2, a(typedBlock.h, 0, iArr3, typedBlock.i), iArr3, a2, iArr2);
    }

    private int[] a(int i, int i2, int[] iArr, TypeData[] typeDataArr) {
        int i3 = 0;
        int a2 = a(typeDataArr, i2, i2 + i);
        y yVar = this.b;
        int[] iArr2 = new int[a2];
        int i4 = 0;
        while (i3 < i) {
            TypeData typeData = typeDataArr[i2 + i3];
            iArr2[i4] = typeData.a();
            iArr[i4] = typeData.a(yVar);
            if (typeData.d()) {
                i3++;
            }
            i4++;
            i3++;
        }
        return iArr2;
    }

    private static int a(int i, TypeData[] typeDataArr, int i2, TypeData[] typeDataArr2) {
        int i3 = i2 - i;
        int i4 = i3 > 0 ? i : i2;
        if (a(typeDataArr, typeDataArr2, i4)) {
            if (i3 > 0) {
                return a(typeDataArr2, i4, i2);
            }
            return -a(typeDataArr, i4, i);
        }
        return -100;
    }

    private static boolean a(TypeData[] typeDataArr, TypeData[] typeDataArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!typeDataArr[i2].a(typeDataArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private static int a(TypeData[] typeDataArr, int i, int i2) {
        int i3 = 0;
        while (i < i2) {
            int i4 = i + 1;
            i3++;
            if (typeDataArr[i].d()) {
                i4++;
            }
            i = i4;
        }
        return i3;
    }

    public StackMap a(y yVar, TypedBlock[] typedBlockArr) {
        bd bdVar = new bd();
        int length = typedBlockArr.length;
        boolean[] zArr = new boolean[length];
        zArr[0] = typedBlockArr[0].d > 0;
        int i = zArr[0] ? 1 : 0;
        for (int i2 = 1; i2 < length; i2++) {
            TypedBlock typedBlock = typedBlockArr[i2];
            boolean a2 = a(typedBlock, typedBlockArr[i2 - 1]);
            zArr[i2] = a2;
            if (a2) {
                typedBlock.b();
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        bdVar.a(i);
        for (int i3 = 0; i3 < length; i3++) {
            if (zArr[i3]) {
                a(bdVar, yVar, typedBlockArr[i3].b, typedBlockArr[i3]);
            }
        }
        return bdVar.a(yVar);
    }

    private void a(bd bdVar, y yVar, int i, TypedBlock typedBlock) {
        bdVar.a(i);
        a(bdVar, yVar, typedBlock.i, typedBlock.h);
        a(bdVar, yVar, typedBlock.j, typedBlock.f2992a);
    }

    private void a(bd bdVar, y yVar, TypeData[] typeDataArr, int i) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            TypeData typeData = typeDataArr[i2];
            if (typeData != null && typeData.d()) {
                i3++;
                i2++;
            }
            i2++;
        }
        bdVar.a(i - i3);
        int i4 = 0;
        while (i4 < i) {
            TypeData typeData2 = typeDataArr[i4];
            bdVar.a(typeData2.a(), typeData2.a(yVar));
            if (typeData2.d()) {
                i4++;
            }
            i4++;
        }
    }
}
