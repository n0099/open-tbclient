package javassist.bytecode.stackmap;

import com.baidu.location.BDLocation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ab;
import javassist.bytecode.an;
import javassist.bytecode.stackmap.BasicBlock;
/* loaded from: classes.dex */
public class b {
    protected BasicBlock a(int i) {
        return new BasicBlock(i);
    }

    protected BasicBlock[] b(int i) {
        return new BasicBlock[i];
    }

    private BasicBlock[] a(BasicBlock basicBlock) {
        BasicBlock[] b = b(1);
        b[0] = basicBlock;
        return b;
    }

    private BasicBlock[] a(BasicBlock basicBlock, BasicBlock basicBlock2) {
        BasicBlock[] b = b(2);
        b[0] = basicBlock;
        b[1] = basicBlock2;
        return b;
    }

    public BasicBlock[] a(an anVar) {
        CodeAttribute i = anVar.i();
        if (i == null) {
            return null;
        }
        CodeIterator j = i.j();
        return a(j, 0, j.d(), i.k());
    }

    public BasicBlock[] a(CodeIterator codeIterator, int i, int i2, ab abVar) {
        BasicBlock[] a2 = a(b(codeIterator, i, i2, abVar));
        a(a2, abVar);
        return a2;
    }

    private c a(HashMap hashMap, int i) {
        return a(hashMap, i, true, true);
    }

    private c a(HashMap hashMap, int i, BasicBlock[] basicBlockArr, int i2, boolean z) {
        c a2 = a(hashMap, i, false, false);
        a2.a(basicBlockArr, i2, z);
        return a2;
    }

    private c a(HashMap hashMap, int i, boolean z, boolean z2) {
        Integer num = new Integer(i);
        c cVar = (c) hashMap.get(num);
        if (cVar == null) {
            cVar = new c(i);
            hashMap.put(num, cVar);
        }
        if (z) {
            if (cVar.b == null) {
                cVar.b = a(i);
            }
            if (z2) {
                cVar.b.d++;
            }
        }
        return cVar;
    }

    private HashMap b(CodeIterator codeIterator, int i, int i2, ab abVar) {
        int f;
        codeIterator.a();
        codeIterator.a(i);
        HashMap hashMap = new HashMap();
        while (codeIterator.e() && (f = codeIterator.f()) < i2) {
            int c = codeIterator.c(f);
            if ((153 <= c && c <= 166) || c == 198 || c == 199) {
                a(hashMap, f, a(a(hashMap, codeIterator.e(f + 1) + f).b, a(hashMap, f + 3).b), 3, false);
            } else if (167 <= c && c <= 171) {
                switch (c) {
                    case BDLocation.TypeServerError /* 167 */:
                        b(hashMap, f, codeIterator.e(f + 1) + f, 3);
                        continue;
                    case 168:
                        a(hashMap, f, codeIterator.e(f + 1) + f, 3);
                        continue;
                    case 169:
                        a(hashMap, f, null, 2, true);
                        continue;
                    case 170:
                        int i3 = (f & (-4)) + 4;
                        int f2 = (codeIterator.f(i3 + 8) - codeIterator.f(i3 + 4)) + 1;
                        BasicBlock[] b = b(f2 + 1);
                        b[0] = a(hashMap, codeIterator.f(i3) + f).b;
                        int i4 = i3 + 12;
                        int i5 = i4 + (f2 * 4);
                        int i6 = 1;
                        int i7 = i4;
                        while (i7 < i5) {
                            b[i6] = a(hashMap, codeIterator.f(i7) + f).b;
                            i7 += 4;
                            i6++;
                        }
                        a(hashMap, f, b, i5 - f, true);
                        continue;
                    case 171:
                        int i8 = (f & (-4)) + 4;
                        int f3 = codeIterator.f(i8 + 4);
                        BasicBlock[] b2 = b(f3 + 1);
                        b2[0] = a(hashMap, codeIterator.f(i8) + f).b;
                        int i9 = i8 + 8 + 4;
                        int i10 = ((f3 * 8) + i9) - 4;
                        int i11 = 1;
                        int i12 = i9;
                        while (i12 < i10) {
                            b2[i11] = a(hashMap, codeIterator.f(i12) + f).b;
                            i12 += 8;
                            i11++;
                        }
                        a(hashMap, f, b2, i10 - f, true);
                        continue;
                }
            } else if ((172 <= c && c <= 177) || c == 191) {
                a(hashMap, f, null, 1, true);
            } else if (c == 200) {
                b(hashMap, f, codeIterator.f(f + 1) + f, 5);
            } else if (c == 201) {
                a(hashMap, f, codeIterator.f(f + 1) + f, 5);
            } else if (c == 196 && codeIterator.c(f + 1) == 169) {
                a(hashMap, f, null, 4, true);
            }
        }
        if (abVar != null) {
            int a2 = abVar.a();
            while (true) {
                a2--;
                if (a2 >= 0) {
                    a(hashMap, abVar.a(a2), true, false);
                    a(hashMap, abVar.c(a2));
                }
            }
        }
        return hashMap;
    }

    private void b(HashMap hashMap, int i, int i2, int i3) {
        a(hashMap, i, a(a(hashMap, i2).b), i3, true);
    }

    protected void a(HashMap hashMap, int i, int i2, int i3) {
        throw new BasicBlock.JsrBytecode();
    }

    private BasicBlock[] a(HashMap hashMap) {
        BasicBlock a2;
        int i;
        c[] cVarArr = (c[]) hashMap.values().toArray(new c[hashMap.size()]);
        Arrays.sort(cVarArr);
        ArrayList arrayList = new ArrayList();
        if (cVarArr.length > 0 && cVarArr[0].f2813a == 0 && cVarArr[0].b != null) {
            i = 1;
            a2 = a(cVarArr[0]);
        } else {
            a2 = a(0);
            i = 0;
        }
        arrayList.add(a2);
        while (i < cVarArr.length) {
            int i2 = i + 1;
            c cVar = cVarArr[i];
            BasicBlock a3 = a(cVar);
            if (a3 == null) {
                if (a2.c > 0) {
                    a2 = a(a2.c + a2.b);
                    arrayList.add(a2);
                }
                a2.c = (cVar.f2813a + cVar.e) - a2.b;
                a2.e = cVar.c;
                a2.f = cVar.d;
            } else {
                if (a2.c == 0) {
                    a2.c = cVar.f2813a - a2.b;
                    a3.d++;
                    a2.e = a(a3);
                } else {
                    int i3 = a2.b;
                    if (a2.c + i3 < cVar.f2813a) {
                        BasicBlock a4 = a(a2.c + i3);
                        a4.c = cVar.f2813a - i3;
                        a4.e = a(a3);
                    }
                }
                arrayList.add(a3);
                a2 = a3;
            }
            i = i2;
        }
        return (BasicBlock[]) arrayList.toArray(b(arrayList.size()));
    }

    private static BasicBlock a(c cVar) {
        BasicBlock basicBlock = cVar.b;
        if (basicBlock != null && cVar.e > 0) {
            basicBlock.e = cVar.c;
            basicBlock.c = cVar.e;
            basicBlock.f = cVar.d;
        }
        return basicBlock;
    }

    private void a(BasicBlock[] basicBlockArr, ab abVar) {
        if (abVar != null) {
            int a2 = abVar.a();
            while (true) {
                int i = a2 - 1;
                if (i >= 0) {
                    BasicBlock a3 = BasicBlock.a(basicBlockArr, abVar.c(i));
                    int a4 = abVar.a(i);
                    int b = abVar.b(i);
                    int d = abVar.d(i);
                    a3.d--;
                    for (BasicBlock basicBlock : basicBlockArr) {
                        int i2 = basicBlock.b;
                        if (a4 <= i2 && i2 < b) {
                            basicBlock.g = new a(a3, d, basicBlock.g);
                            a3.d++;
                        }
                    }
                    a2 = i;
                } else {
                    return;
                }
            }
        }
    }
}
