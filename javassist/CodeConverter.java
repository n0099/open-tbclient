package javassist;

import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.an;
import javassist.bytecode.y;
import javassist.convert.Transformer;
/* loaded from: classes.dex */
public class CodeConverter {

    /* renamed from: a  reason: collision with root package name */
    protected Transformer f2723a = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(h hVar, an anVar, y yVar) {
        int i = 0;
        CodeAttribute i2 = anVar.i();
        if (i2 != null && this.f2723a != null) {
            for (Transformer transformer = this.f2723a; transformer != null; transformer = transformer.c()) {
                transformer.a(yVar, hVar, anVar);
            }
            CodeIterator j = i2.j();
            while (j.e()) {
                try {
                    int f = j.f();
                    for (Transformer transformer2 = this.f2723a; transformer2 != null; transformer2 = transformer2.c()) {
                        f = transformer2.a(hVar, f, j, yVar);
                    }
                } catch (BadBytecode e) {
                    throw new CannotCompileException(e);
                }
            }
            int i3 = 0;
            Transformer transformer3 = this.f2723a;
            while (transformer3 != null) {
                int b = transformer3.b();
                if (b <= i3) {
                    b = i3;
                }
                int d = transformer3.d();
                if (d <= i) {
                    d = i;
                }
                transformer3 = transformer3.c();
                i = d;
                i3 = b;
            }
            for (Transformer transformer4 = this.f2723a; transformer4 != null; transformer4 = transformer4.c()) {
                transformer4.a();
            }
            if (i3 > 0) {
                i2.b(i2.g() + i3);
            }
            if (i > 0) {
                i2.a(i2.f() + i);
            }
            try {
                anVar.a(hVar.a(), hVar.h());
            } catch (BadBytecode e2) {
                throw new CannotCompileException(e2.getMessage(), e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class DefaultArrayAccessReplacementMethodNames implements f {
        @Override // javassist.f
        public String a() {
            return "arrayReadByteOrBoolean";
        }

        @Override // javassist.f
        public String b() {
            return "arrayWriteByteOrBoolean";
        }

        @Override // javassist.f
        public String c() {
            return "arrayReadChar";
        }

        @Override // javassist.f
        public String d() {
            return "arrayWriteChar";
        }

        @Override // javassist.f
        public String e() {
            return "arrayReadDouble";
        }

        @Override // javassist.f
        public String f() {
            return "arrayWriteDouble";
        }

        @Override // javassist.f
        public String g() {
            return "arrayReadFloat";
        }

        @Override // javassist.f
        public String h() {
            return "arrayWriteFloat";
        }

        @Override // javassist.f
        public String i() {
            return "arrayReadInt";
        }

        @Override // javassist.f
        public String j() {
            return "arrayWriteInt";
        }

        @Override // javassist.f
        public String k() {
            return "arrayReadLong";
        }

        @Override // javassist.f
        public String l() {
            return "arrayWriteLong";
        }

        @Override // javassist.f
        public String m() {
            return "arrayReadObject";
        }

        @Override // javassist.f
        public String n() {
            return "arrayWriteObject";
        }

        @Override // javassist.f
        public String o() {
            return "arrayReadShort";
        }

        @Override // javassist.f
        public String p() {
            return "arrayWriteShort";
        }
    }
}
