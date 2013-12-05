package org.msgpack.template.builder;

import javassist.h;
import javassist.p;
import org.msgpack.MessageTypeException;
import org.msgpack.template.builder.JavassistTemplateBuilder;
/* loaded from: classes.dex */
public class BeansBuildContext extends b<BeansFieldEntry> {

    /* renamed from: a  reason: collision with root package name */
    protected BeansFieldEntry[] f3101a;
    protected Class<?> b;
    protected String c;
    protected org.msgpack.template.d<?>[] d;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Class, org.msgpack.template.builder.c[], org.msgpack.template.d[]] */
    @Override // org.msgpack.template.builder.b
    public /* synthetic */ org.msgpack.template.d a(Class cls, BeansFieldEntry[] beansFieldEntryArr, org.msgpack.template.d[] dVarArr) {
        return b2((Class<?>) cls, beansFieldEntryArr, dVarArr);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Class, org.msgpack.template.builder.c[], org.msgpack.template.d[]] */
    @Override // org.msgpack.template.builder.b
    public /* synthetic */ org.msgpack.template.d b(Class cls, BeansFieldEntry[] beansFieldEntryArr, org.msgpack.template.d[] dVarArr) {
        return a2((Class<?>) cls, beansFieldEntryArr, dVarArr);
    }

    public BeansBuildContext(JavassistTemplateBuilder javassistTemplateBuilder) {
        super(javassistTemplateBuilder);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public org.msgpack.template.d a2(Class<?> cls, BeansFieldEntry[] beansFieldEntryArr, org.msgpack.template.d[] dVarArr) {
        this.f3101a = beansFieldEntryArr;
        this.d = dVarArr;
        this.b = cls;
        this.c = this.b.getName();
        return a(this.c);
    }

    @Override // org.msgpack.template.builder.b
    protected void a() {
        this.f.c(this.e.b(JavassistTemplateBuilder.JavassistTemplate.class.getName()));
    }

    @Override // org.msgpack.template.builder.b
    protected void b() {
        this.f.a(p.a(new h[]{this.e.b(Class.class.getName()), this.e.b(String.valueOf(org.msgpack.template.d.class.getName()) + "[]")}, new h[0], this.f));
    }

    @Override // org.msgpack.template.builder.b
    protected org.msgpack.template.d a(Class<?> cls) {
        return (org.msgpack.template.d) cls.getConstructor(Class.class, org.msgpack.template.d[].class).newInstance(this.b, this.d);
    }

    @Override // org.msgpack.template.builder.b
    protected void c() {
    }

    @Override // org.msgpack.template.builder.b
    protected String d() {
        j();
        b("{");
        b("if($2 == null) {");
        b("  if($3) {");
        a("    throw new %s(\"Attempted to write null\");", MessageTypeException.class.getName());
        b("  }");
        b("  $1.writeNil();");
        b("  return;");
        b("}");
        a("%s _$$_t = (%s)$2;", this.c, this.c);
        a("$1.writeArrayBegin(%d);", Integer.valueOf(this.f3101a.length));
        for (int i = 0; i < this.f3101a.length; i++) {
            BeansFieldEntry beansFieldEntry = this.f3101a[i];
            if (!beansFieldEntry.g()) {
                b("$1.writeNil();");
            } else {
                Class<?> e = beansFieldEntry.e();
                if (e.isPrimitive()) {
                    a("$1.%s(_$$_t.%s());", b(e), beansFieldEntry.a());
                } else {
                    a("if(_$$_t.%s() == null) {", beansFieldEntry.a());
                    if (beansFieldEntry.i()) {
                        a("throw new %s();", MessageTypeException.class.getName());
                    } else {
                        b("$1.writeNil();");
                    }
                    b("} else {");
                    a("  this.templates[%d].write($1, _$$_t.%s());", Integer.valueOf(i), beansFieldEntry.a());
                    b("}");
                }
            }
        }
        b("$1.writeArrayEnd();");
        b("}");
        return k();
    }

    @Override // org.msgpack.template.builder.b
    protected String e() {
        j();
        b("{ ");
        b("if(!$3 && $1.trySkipNil()) {");
        b("  return null;");
        b("}");
        a("%s _$$_t;", this.c);
        b("if($2 == null) {");
        a("  _$$_t = new %s();", this.c);
        b("} else {");
        a("  _$$_t = (%s)$2;", this.c);
        b("}");
        b("$1.readArrayBegin();");
        for (int i = 0; i < this.f3101a.length; i++) {
            BeansFieldEntry beansFieldEntry = this.f3101a[i];
            if (!beansFieldEntry.g()) {
                b("$1.skip();");
            } else {
                if (beansFieldEntry.h()) {
                    b("if($1.trySkipNil()) {");
                    a("_$$_t.%s(null);", beansFieldEntry.b());
                    b("} else {");
                }
                Class<?> e = beansFieldEntry.e();
                if (e.isPrimitive()) {
                    a("_$$_t.%s( $1.%s() );", beansFieldEntry.b(), c(e));
                } else {
                    a("_$$_t.%s( (%s)this.templates[%d].read($1, _$$_t.%s()) );", beansFieldEntry.b(), beansFieldEntry.j(), Integer.valueOf(i), beansFieldEntry.a());
                }
                if (beansFieldEntry.h()) {
                    b("}");
                }
            }
        }
        b("$1.readArrayEnd();");
        b("return _$$_t;");
        b("}");
        return k();
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public org.msgpack.template.d b2(Class<?> cls, BeansFieldEntry[] beansFieldEntryArr, org.msgpack.template.d[] dVarArr) {
        return null;
    }
}
