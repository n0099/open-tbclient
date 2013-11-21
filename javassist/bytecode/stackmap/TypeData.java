package javassist.bytecode.stackmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.y;
import javassist.bytecode.z;
import javassist.h;
/* loaded from: classes.dex */
public abstract class TypeData {
    public abstract int a();

    public abstract int a(y yVar);

    public abstract void a(String str, javassist.c cVar);

    public abstract boolean a(TypeData typeData);

    public abstract BasicType c();

    public abstract boolean d();

    public abstract String g();

    public static TypeData[] a(int i) {
        TypeData[] typeDataArr = new TypeData[i];
        for (int i2 = 0; i2 < i; i2++) {
            typeDataArr[i2] = d.g;
        }
        return typeDataArr;
    }

    protected TypeData() {
    }

    public TypeData b() {
        return new TypeVar(this);
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public int a(ArrayList arrayList, int i, javassist.c cVar) {
        return i;
    }

    protected TypeVar h() {
        return null;
    }

    public void b(int i) {
    }

    /* loaded from: classes.dex */
    public class BasicType extends TypeData {

        /* renamed from: a  reason: collision with root package name */
        private String f2806a;
        private int b;

        public BasicType(String str, int i) {
            this.f2806a = str;
            this.b = i;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public int a() {
            return this.b;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public int a(y yVar) {
            return 0;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public TypeData b() {
            return this == d.g ? this : super.b();
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public BasicType c() {
            return this;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public boolean d() {
            return this.b == 4 || this.b == 3;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public boolean a(TypeData typeData) {
            return this == typeData;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public String g() {
            return this.f2806a;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public void a(String str, javassist.c cVar) {
            throw new BadBytecode("conflict: " + this.f2806a + " and " + str);
        }

        public String toString() {
            return this.f2806a;
        }
    }

    /* loaded from: classes.dex */
    public abstract class AbsTypeVar extends TypeData {
        public abstract void b(TypeData typeData);

        @Override // javassist.bytecode.stackmap.TypeData
        public int a() {
            return 7;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public int a(y yVar) {
            return yVar.a(g());
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public boolean a(TypeData typeData) {
            return g().equals(typeData.g());
        }
    }

    /* loaded from: classes.dex */
    public class TypeVar extends AbsTypeVar {
        protected String d;
        private int e = 0;
        private int f = 0;
        private boolean g = false;
        protected ArrayList c = null;

        /* renamed from: a  reason: collision with root package name */
        protected ArrayList f2808a = new ArrayList(2);
        protected ArrayList b = new ArrayList(2);

        public TypeVar(TypeData typeData) {
            b(typeData);
            this.d = null;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public String g() {
            return this.d == null ? ((TypeData) this.f2808a.get(0)).g() : this.d;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public BasicType c() {
            if (this.d == null) {
                return ((TypeData) this.f2808a.get(0)).c();
            }
            return null;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public boolean d() {
            if (this.d == null) {
                return ((TypeData) this.f2808a.get(0)).d();
            }
            return false;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public boolean e() {
            if (this.d == null) {
                return ((TypeData) this.f2808a.get(0)).e();
            }
            return false;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public boolean f() {
            if (this.d == null) {
                return ((TypeData) this.f2808a.get(0)).f();
            }
            return false;
        }

        @Override // javassist.bytecode.stackmap.TypeData.AbsTypeVar
        public void b(TypeData typeData) {
            this.f2808a.add(typeData);
            if (typeData instanceof TypeVar) {
                ((TypeVar) typeData).b.add(this);
            }
        }

        @Override // javassist.bytecode.stackmap.TypeData.AbsTypeVar, javassist.bytecode.stackmap.TypeData
        public int a() {
            return this.d == null ? ((TypeData) this.f2808a.get(0)).a() : super.a();
        }

        @Override // javassist.bytecode.stackmap.TypeData.AbsTypeVar, javassist.bytecode.stackmap.TypeData
        public int a(y yVar) {
            return this.d == null ? ((TypeData) this.f2808a.get(0)).a(yVar) : super.a(yVar);
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public void a(String str, javassist.c cVar) {
            if (this.c == null) {
                this.c = new ArrayList();
            }
            this.c.add(str);
        }

        @Override // javassist.bytecode.stackmap.TypeData
        protected TypeVar h() {
            return this;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public int a(ArrayList arrayList, int i, javassist.c cVar) {
            TypeVar typeVar;
            int i2;
            if (this.e <= 0) {
                int i3 = i + 1;
                this.f = i3;
                this.e = i3;
                arrayList.add(this);
                this.g = true;
                int size = this.f2808a.size();
                int i4 = 0;
                while (i4 < size) {
                    TypeVar h = ((TypeData) this.f2808a.get(i4)).h();
                    if (h != null) {
                        if (h.e == 0) {
                            i2 = h.a(arrayList, i3, cVar);
                            if (h.f < this.f) {
                                this.f = h.f;
                            }
                            i4++;
                            i3 = i2;
                        } else if (h.g && h.e < this.f) {
                            this.f = h.e;
                        }
                    }
                    i2 = i3;
                    i4++;
                    i3 = i2;
                }
                if (this.e == this.f) {
                    ArrayList arrayList2 = new ArrayList();
                    do {
                        typeVar = (TypeVar) arrayList.remove(arrayList.size() - 1);
                        typeVar.g = false;
                        arrayList2.add(typeVar);
                    } while (typeVar != this);
                    a(arrayList2, cVar);
                }
                return i3;
            }
            return i;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0058, code lost:
            r0 = javassist.bytecode.stackmap.d.g;
            r1 = true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(ArrayList arrayList, javassist.c cVar) {
            TypeData typeData;
            boolean z;
            int i = 0;
            HashSet hashSet = new HashSet();
            int size = arrayList.size();
            int i2 = 0;
            BasicType basicType = null;
            boolean z2 = false;
            while (i2 < size) {
                ArrayList arrayList2 = ((TypeVar) arrayList.get(i2)).f2808a;
                int size2 = arrayList2.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size2) {
                        typeData = basicType;
                        z = z2;
                        break;
                    }
                    typeData = (TypeData) arrayList2.get(i3);
                    BasicType c = typeData.c();
                    if (basicType == null) {
                        if (c != null) {
                            basicType = c;
                            z2 = true;
                        } else if (typeData.f()) {
                            z = false;
                            break;
                        } else {
                            basicType = typeData;
                            z2 = false;
                        }
                        if (c == null && !typeData.e()) {
                            hashSet.add(typeData.g());
                        }
                        i3++;
                    } else {
                        if ((c == null && z2) || (c != null && basicType != c)) {
                            break;
                        }
                        if (c == null) {
                            hashSet.add(typeData.g());
                        }
                        i3++;
                    }
                }
                i2++;
                z2 = z;
                basicType = typeData;
            }
            if (z2) {
                while (i < size) {
                    TypeVar typeVar = (TypeVar) arrayList.get(i);
                    typeVar.f2808a.clear();
                    typeVar.f2808a.add(basicType);
                    i++;
                }
                return;
            }
            String a2 = a(arrayList, hashSet, cVar);
            while (i < size) {
                ((TypeVar) arrayList.get(i)).d = a2;
                i++;
            }
        }

        private String a(ArrayList arrayList, HashSet hashSet, javassist.c cVar) {
            h hVar;
            Iterator it = hashSet.iterator();
            if (hashSet.size() == 0) {
                return null;
            }
            if (hashSet.size() == 1) {
                return (String) it.next();
            }
            h c = cVar.c((String) it.next());
            while (true) {
                hVar = c;
                if (!it.hasNext()) {
                    break;
                }
                c = a(hVar, cVar.c((String) it.next()));
            }
            if (hVar.f() == null || a(hVar)) {
                hVar = a(arrayList, cVar, new HashSet(), hVar);
            }
            if (hVar.b()) {
                return z.a(hVar);
            }
            return hVar.n();
        }

        private static boolean a(h hVar) {
            return hVar.b() && hVar.e().f() == null;
        }

        private h a(ArrayList arrayList, javassist.c cVar, HashSet hashSet, h hVar) {
            if (arrayList == null) {
                return hVar;
            }
            int size = arrayList.size();
            h hVar2 = hVar;
            for (int i = 0; i < size; i++) {
                TypeVar typeVar = (TypeVar) arrayList.get(i);
                if (hashSet.add(typeVar)) {
                    if (typeVar.c != null) {
                        int size2 = typeVar.c.size();
                        int i2 = 0;
                        while (i2 < size2) {
                            h c = cVar.c((String) typeVar.c.get(i2));
                            if (!c.a(hVar2)) {
                                c = hVar2;
                            }
                            i2++;
                            hVar2 = c;
                        }
                    }
                    hVar2 = a(typeVar.b, cVar, hashSet, hVar2);
                } else {
                    return hVar2;
                }
            }
            return hVar2;
        }
    }

    public static h a(h hVar, h hVar2) {
        if (hVar != hVar2) {
            if (hVar.b() && hVar2.b()) {
                h e = hVar.e();
                h e2 = hVar2.e();
                h a2 = a(e, e2);
                if (a2 != e) {
                    if (a2 == e2) {
                        return hVar2;
                    }
                    return hVar.a().c(a2 == null ? "java.lang.Object" : a2.n() + "[]");
                }
                return hVar;
            } else if (hVar.m() || hVar2.m()) {
                return null;
            } else {
                if (hVar.b() || hVar2.b()) {
                    return hVar.a().c("java.lang.Object");
                }
                return b(hVar, hVar2);
            }
        }
        return hVar;
    }

    public static h b(h hVar, h hVar2) {
        h hVar3 = hVar2;
        h hVar4 = hVar;
        while (true) {
            if (!c(hVar4, hVar3) || hVar4.f() == null) {
                h f = hVar4.f();
                h f2 = hVar3.f();
                if (f2 == null) {
                    break;
                } else if (f == null) {
                    hVar4 = hVar3;
                    hVar = hVar2;
                    hVar2 = hVar;
                    break;
                } else {
                    hVar3 = f2;
                    hVar4 = f;
                }
            } else {
                return hVar4;
            }
        }
        while (true) {
            hVar4 = hVar4.f();
            if (hVar4 == null) {
                break;
            }
            hVar = hVar.f();
        }
        while (!c(hVar, hVar2)) {
            hVar = hVar.f();
            hVar2 = hVar2.f();
        }
        return hVar;
    }

    static boolean c(h hVar, h hVar2) {
        return hVar == hVar2 || !(hVar == null || hVar2 == null || !hVar.n().equals(hVar2.n()));
    }

    public static void a(TypeData typeData, TypeData typeData2, javassist.c cVar) {
        if ((typeData instanceof AbsTypeVar) && !typeData2.e()) {
            ((AbsTypeVar) typeData).b(ArrayType.c(typeData2));
        }
        if (typeData2 instanceof AbsTypeVar) {
            if (typeData instanceof AbsTypeVar) {
                ArrayElement.c(typeData);
            } else if (typeData instanceof ClassName) {
                if (!typeData.e()) {
                    typeData2.a(ArrayElement.b(typeData.g()), cVar);
                }
            } else {
                throw new BadBytecode("bad AASTORE: " + typeData);
            }
        }
    }

    /* loaded from: classes.dex */
    public class ArrayType extends AbsTypeVar {

        /* renamed from: a  reason: collision with root package name */
        private AbsTypeVar f2805a;

        private ArrayType(AbsTypeVar absTypeVar) {
            this.f2805a = absTypeVar;
        }

        static TypeData c(TypeData typeData) {
            if (typeData instanceof ArrayElement) {
                return ((ArrayElement) typeData).i();
            }
            if (typeData instanceof AbsTypeVar) {
                return new ArrayType((AbsTypeVar) typeData);
            }
            if ((typeData instanceof ClassName) && !typeData.e()) {
                return new ClassName(a(typeData.g()));
            }
            throw new BadBytecode("bad AASTORE: " + typeData);
        }

        @Override // javassist.bytecode.stackmap.TypeData.AbsTypeVar
        public void b(TypeData typeData) {
            try {
                if (!typeData.e()) {
                    this.f2805a.b(ArrayElement.c(typeData));
                }
            } catch (BadBytecode e) {
                throw new RuntimeException("fatal: " + e);
            }
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public String g() {
            return a(this.f2805a.g());
        }

        public AbsTypeVar i() {
            return this.f2805a;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public BasicType c() {
            return null;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public boolean d() {
            return false;
        }

        public static String a(String str) {
            return str.charAt(0) == '[' ? "[" + str : "[L" + str.replace('.', '/') + ";";
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public void a(String str, javassist.c cVar) {
            this.f2805a.a(ArrayElement.b(str), cVar);
        }

        @Override // javassist.bytecode.stackmap.TypeData
        protected TypeVar h() {
            return this.f2805a.h();
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public int a(ArrayList arrayList, int i, javassist.c cVar) {
            return this.f2805a.a(arrayList, i, cVar);
        }
    }

    /* loaded from: classes.dex */
    public class ArrayElement extends AbsTypeVar {

        /* renamed from: a  reason: collision with root package name */
        private AbsTypeVar f2804a;

        private ArrayElement(AbsTypeVar absTypeVar) {
            this.f2804a = absTypeVar;
        }

        public static TypeData c(TypeData typeData) {
            if (typeData instanceof ArrayType) {
                return ((ArrayType) typeData).i();
            }
            if (typeData instanceof AbsTypeVar) {
                return new ArrayElement((AbsTypeVar) typeData);
            }
            if ((typeData instanceof ClassName) && !typeData.e()) {
                return new ClassName(b(typeData.g()));
            }
            throw new BadBytecode("bad AASTORE: " + typeData);
        }

        @Override // javassist.bytecode.stackmap.TypeData.AbsTypeVar
        public void b(TypeData typeData) {
            try {
                if (!typeData.e()) {
                    this.f2804a.b(ArrayType.c(typeData));
                }
            } catch (BadBytecode e) {
                throw new RuntimeException("fatal: " + e);
            }
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public String g() {
            return b(this.f2804a.g());
        }

        public AbsTypeVar i() {
            return this.f2804a;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public BasicType c() {
            return null;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public boolean d() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String b(String str) {
            if (str.length() > 1 && str.charAt(0) == '[') {
                char charAt = str.charAt(1);
                if (charAt == 'L') {
                    return str.substring(2, str.length() - 1).replace('/', '.');
                }
                if (charAt == '[') {
                    return str.substring(1);
                }
            }
            return "java.lang.Object";
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public void a(String str, javassist.c cVar) {
            this.f2804a.a(ArrayType.a(str), cVar);
        }

        @Override // javassist.bytecode.stackmap.TypeData
        protected TypeVar h() {
            return this.f2804a.h();
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public int a(ArrayList arrayList, int i, javassist.c cVar) {
            return this.f2804a.a(arrayList, i, cVar);
        }
    }

    /* loaded from: classes.dex */
    public class UninitTypeVar extends AbsTypeVar {

        /* renamed from: a  reason: collision with root package name */
        protected TypeData f2810a;

        public UninitTypeVar(UninitData uninitData) {
            this.f2810a = uninitData;
        }

        @Override // javassist.bytecode.stackmap.TypeData.AbsTypeVar, javassist.bytecode.stackmap.TypeData
        public int a() {
            return this.f2810a.a();
        }

        @Override // javassist.bytecode.stackmap.TypeData.AbsTypeVar, javassist.bytecode.stackmap.TypeData
        public int a(y yVar) {
            return this.f2810a.a(yVar);
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public BasicType c() {
            return this.f2810a.c();
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public boolean d() {
            return this.f2810a.d();
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public boolean f() {
            return this.f2810a.f();
        }

        @Override // javassist.bytecode.stackmap.TypeData.AbsTypeVar, javassist.bytecode.stackmap.TypeData
        public boolean a(TypeData typeData) {
            return this.f2810a.a(typeData);
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public String g() {
            return this.f2810a.g();
        }

        @Override // javassist.bytecode.stackmap.TypeData
        protected TypeVar h() {
            return null;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public TypeData b() {
            return this.f2810a.b();
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public void a(String str, javassist.c cVar) {
            this.f2810a.a(str, cVar);
        }

        @Override // javassist.bytecode.stackmap.TypeData.AbsTypeVar
        public void b(TypeData typeData) {
            if (!typeData.a(this.f2810a)) {
                this.f2810a = d.g;
            }
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public void b(int i) {
            this.f2810a.b(i);
        }

        public int i() {
            if (this.f2810a instanceof UninitData) {
                return ((UninitData) this.f2810a).f2809a;
            }
            throw new RuntimeException("not available");
        }
    }

    /* loaded from: classes.dex */
    public class ClassName extends TypeData {

        /* renamed from: a  reason: collision with root package name */
        private String f2807a;

        public ClassName(String str) {
            this.f2807a = str;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public String g() {
            return this.f2807a;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public BasicType c() {
            return null;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public boolean d() {
            return false;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public int a() {
            return 7;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public int a(y yVar) {
            return yVar.a(g());
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public boolean a(TypeData typeData) {
            return this.f2807a.equals(typeData.g());
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public void a(String str, javassist.c cVar) {
        }
    }

    /* loaded from: classes.dex */
    public class NullType extends ClassName {
        public NullType() {
            super("null-type");
        }

        @Override // javassist.bytecode.stackmap.TypeData.ClassName, javassist.bytecode.stackmap.TypeData
        public int a() {
            return 5;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public boolean e() {
            return true;
        }

        @Override // javassist.bytecode.stackmap.TypeData.ClassName, javassist.bytecode.stackmap.TypeData
        public int a(y yVar) {
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public class UninitData extends ClassName {

        /* renamed from: a  reason: collision with root package name */
        int f2809a;
        boolean b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public UninitData(int i, String str) {
            super(str);
            this.f2809a = i;
            this.b = false;
        }

        public UninitData i() {
            return new UninitData(this.f2809a, g());
        }

        @Override // javassist.bytecode.stackmap.TypeData.ClassName, javassist.bytecode.stackmap.TypeData
        public int a() {
            return 8;
        }

        @Override // javassist.bytecode.stackmap.TypeData.ClassName, javassist.bytecode.stackmap.TypeData
        public int a(y yVar) {
            return this.f2809a;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public TypeData b() {
            return this.b ? new TypeVar(new ClassName(g())) : new UninitTypeVar(i());
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public boolean f() {
            return true;
        }

        @Override // javassist.bytecode.stackmap.TypeData.ClassName, javassist.bytecode.stackmap.TypeData
        public boolean a(TypeData typeData) {
            if (typeData instanceof UninitData) {
                UninitData uninitData = (UninitData) typeData;
                return this.f2809a == uninitData.f2809a && g().equals(uninitData.g());
            }
            return false;
        }

        public String toString() {
            return "uninit:" + g() + "@" + this.f2809a;
        }

        public int j() {
            return this.f2809a;
        }

        @Override // javassist.bytecode.stackmap.TypeData
        public void b(int i) {
            if (i == this.f2809a) {
                this.b = true;
            }
        }
    }

    /* loaded from: classes.dex */
    public class UninitThis extends UninitData {
        /* JADX INFO: Access modifiers changed from: package-private */
        public UninitThis(String str) {
            super(-1, str);
        }

        @Override // javassist.bytecode.stackmap.TypeData.UninitData
        public UninitData i() {
            return new UninitThis(g());
        }

        @Override // javassist.bytecode.stackmap.TypeData.UninitData, javassist.bytecode.stackmap.TypeData.ClassName, javassist.bytecode.stackmap.TypeData
        public int a() {
            return 6;
        }

        @Override // javassist.bytecode.stackmap.TypeData.UninitData, javassist.bytecode.stackmap.TypeData.ClassName, javassist.bytecode.stackmap.TypeData
        public int a(y yVar) {
            return 0;
        }

        @Override // javassist.bytecode.stackmap.TypeData.UninitData
        public String toString() {
            return "uninit:this";
        }
    }
}
