package org.msgpack.template.builder;

import java.lang.reflect.Modifier;
import javassist.h;
import javassist.p;
import org.msgpack.MessageTypeException;
import org.msgpack.template.builder.JavassistTemplateBuilder;
/* loaded from: classes.dex */
public class DefaultBuildContext extends b<c> {

    /* renamed from: a  reason: collision with root package name */
    protected c[] f2938a;
    protected Class<?> b;
    protected String c;
    protected org.msgpack.template.d<?>[] d;

    public DefaultBuildContext(JavassistTemplateBuilder javassistTemplateBuilder) {
        super(javassistTemplateBuilder);
    }

    @Override // org.msgpack.template.builder.b
    public org.msgpack.template.d b(Class cls, c[] cVarArr, org.msgpack.template.d[] dVarArr) {
        this.f2938a = cVarArr;
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
        b("\n{\n");
        b("  if ($2 == null) {\n");
        b("    if ($3) {\n");
        a("      throw new %s(\"Attempted to write null\");\n", MessageTypeException.class.getName());
        b("    }\n");
        b("    $1.writeNil();\n");
        b("    return;\n");
        b("  }\n");
        a("  %s _$$_t = (%s) $2;\n", this.c, this.c);
        a("  $1.writeArrayBegin(%d);\n", Integer.valueOf(this.f2938a.length));
        for (int i = 0; i < this.f2938a.length; i++) {
            c cVar = this.f2938a[i];
            if (!cVar.g()) {
                b("  $1.writeNil();\n");
            } else {
                DefaultFieldEntry defaultFieldEntry = (DefaultFieldEntry) cVar;
                boolean isPrivate = Modifier.isPrivate(defaultFieldEntry.a().getModifiers());
                Class<?> e = defaultFieldEntry.e();
                if (e.isPrimitive()) {
                    if (!isPrivate) {
                        a("  $1.%s(_$$_t.%s);\n", b(e), defaultFieldEntry.d());
                    } else {
                        a("  %s.writePrivateField($1, _$$_t, %s.class, \"%s\", templates[%d]);\n", DefaultBuildContext.class.getName(), defaultFieldEntry.a().getDeclaringClass().getName(), defaultFieldEntry.d(), Integer.valueOf(i));
                    }
                } else {
                    if (!isPrivate) {
                        a("  if (_$$_t.%s == null) {\n", defaultFieldEntry.d());
                    } else {
                        a("  if (%s.readPrivateField(_$$_t, %s.class, \"%s\") == null) {\n", DefaultBuildContext.class.getName(), defaultFieldEntry.a().getDeclaringClass().getName(), defaultFieldEntry.d());
                    }
                    if (defaultFieldEntry.i()) {
                        a("    throw new %s(\"%s cannot be null by @NotNullable\");\n", MessageTypeException.class.getName(), defaultFieldEntry.d());
                    } else {
                        b("    $1.writeNil();\n");
                    }
                    b("  } else {\n");
                    if (!isPrivate) {
                        a("    templates[%d].write($1, _$$_t.%s);\n", Integer.valueOf(i), defaultFieldEntry.d());
                    } else {
                        a("    %s.writePrivateField($1, _$$_t, %s.class, \"%s\", templates[%d]);\n", DefaultBuildContext.class.getName(), defaultFieldEntry.a().getDeclaringClass().getName(), defaultFieldEntry.d(), Integer.valueOf(i));
                    }
                    b("  }\n");
                }
            }
        }
        b("  $1.writeArrayEnd();\n");
        b("}\n");
        return k();
    }

    @Override // org.msgpack.template.builder.b
    protected String e() {
        j();
        b("\n{\n");
        b("  if (!$3 && $1.trySkipNil()) {\n");
        b("    return null;\n");
        b("  }\n");
        a("  %s _$$_t;\n", this.c);
        b("  if ($2 == null) {\n");
        a("    _$$_t = new %s();\n", this.c);
        b("  } else {\n");
        a("    _$$_t = (%s) $2;\n", this.c);
        b("  }\n");
        b("  $1.readArrayBegin();\n");
        for (int i = 0; i < this.f2938a.length; i++) {
            c cVar = this.f2938a[i];
            if (!cVar.g()) {
                b("  $1.skip();\n");
            } else {
                if (cVar.h()) {
                    b("  if ($1.trySkipNil()) {");
                    b("  } else {\n");
                }
                DefaultFieldEntry defaultFieldEntry = (DefaultFieldEntry) cVar;
                boolean isPrivate = Modifier.isPrivate(defaultFieldEntry.a().getModifiers());
                Class<?> e = defaultFieldEntry.e();
                if (e.isPrimitive()) {
                    if (!isPrivate) {
                        a("    _$$_t.%s = $1.%s();\n", defaultFieldEntry.d(), c(e));
                    } else {
                        a("    %s.readPrivateField($1, _$$_t, %s.class, \"%s\", templates[%d]);\n", DefaultBuildContext.class.getName(), defaultFieldEntry.a().getDeclaringClass().getName(), defaultFieldEntry.d(), Integer.valueOf(i));
                    }
                } else if (!isPrivate) {
                    a("    _$$_t.%s = (%s) this.templates[%d].read($1, _$$_t.%s);\n", defaultFieldEntry.d(), defaultFieldEntry.j(), Integer.valueOf(i), defaultFieldEntry.d());
                } else {
                    a("    %s.readPrivateField($1, _$$_t, %s.class, \"%s\", templates[%d]);\n", DefaultBuildContext.class.getName(), defaultFieldEntry.a().getDeclaringClass().getName(), defaultFieldEntry.d(), Integer.valueOf(i));
                }
                if (defaultFieldEntry.h()) {
                    b("  }\n");
                }
            }
        }
        b("  $1.readArrayEnd();\n");
        b("  return _$$_t;\n");
        b("}\n");
        return k();
    }

    @Override // org.msgpack.template.builder.b
    public org.msgpack.template.d a(Class<?> cls, c[] cVarArr, org.msgpack.template.d[] dVarArr) {
        this.f2938a = cVarArr;
        this.d = dVarArr;
        this.b = cls;
        this.c = this.b.getName();
        return c(this.c);
    }
}
