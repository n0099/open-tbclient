package org.msgpack.template.builder;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.msgpack.MessageTypeException;
import org.msgpack.template.AbstractTemplate;
/* loaded from: classes.dex */
public class ReflectionTemplateBuilder extends AbstractTemplateBuilder {
    private static Logger b = Logger.getLogger(ReflectionBeansTemplateBuilder.class.getName());

    /* loaded from: classes.dex */
    public abstract class ReflectionFieldTemplate extends AbstractTemplate<Object> {

        /* renamed from: a  reason: collision with root package name */
        protected c f3106a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ReflectionFieldTemplate(c cVar) {
            this.f3106a = cVar;
        }
    }

    /* loaded from: classes.dex */
    public class ReflectionClassTemplate<T> extends AbstractTemplate<T> {

        /* renamed from: a  reason: collision with root package name */
        protected Class<T> f3105a;
        protected ReflectionFieldTemplate[] b;

        protected ReflectionClassTemplate(Class<T> cls, ReflectionFieldTemplate[] reflectionFieldTemplateArr) {
            this.f3105a = cls;
            this.b = reflectionFieldTemplateArr;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: org.msgpack.template.builder.ReflectionTemplateBuilder$ReflectionFieldTemplate[] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: org.msgpack.template.builder.e */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // org.msgpack.template.d
        public void a(org.msgpack.packer.a aVar, T t, boolean z) {
            ReflectionFieldTemplate[] reflectionFieldTemplateArr;
            if (t == null) {
                if (z) {
                    throw new MessageTypeException("attempted to write null");
                }
                aVar.d();
                return;
            }
            try {
                aVar.c(this.b.length);
                for (e eVar : this.b) {
                    if (!eVar.f3106a.g()) {
                        aVar.d();
                    } else {
                        Object a2 = eVar.f3106a.a(t);
                        if (a2 == null) {
                            if (eVar.f3106a.i()) {
                                throw new MessageTypeException(String.valueOf(eVar.f3106a.d()) + " cannot be null by @NotNullable");
                            }
                            aVar.d();
                        } else {
                            eVar.a(aVar, a2, true);
                        }
                    }
                }
                aVar.a();
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new MessageTypeException(e2);
            }
        }
    }

    public ReflectionTemplateBuilder(org.msgpack.template.e eVar, ClassLoader classLoader) {
        super(eVar);
    }

    @Override // org.msgpack.template.builder.f
    public boolean b(Type type, boolean z) {
        Class cls = (Class) type;
        boolean a2 = a((Class<?>) cls, z);
        if (a2 && b.isLoggable(Level.FINE)) {
            b.fine("matched type: " + cls.getName());
        }
        return a2;
    }

    @Override // org.msgpack.template.builder.AbstractTemplateBuilder
    public <T> org.msgpack.template.d<T> a(Class<T> cls, c[] cVarArr) {
        if (cVarArr == null) {
            throw new NullPointerException("entries is null: " + cls);
        }
        return new ReflectionClassTemplate(cls, a(cVarArr));
    }

    protected ReflectionFieldTemplate[] a(c[] cVarArr) {
        for (c cVar : cVarArr) {
            Field a2 = ((DefaultFieldEntry) cVar).a();
            if (!Modifier.isPublic(a2.getModifiers())) {
                a2.setAccessible(true);
            }
        }
        ReflectionFieldTemplate[] reflectionFieldTemplateArr = new ReflectionFieldTemplate[cVarArr.length];
        for (int i = 0; i < cVarArr.length; i++) {
            c cVar2 = cVarArr[i];
            reflectionFieldTemplateArr[i] = new e(cVar2, this.f3100a.a(cVar2.f()));
        }
        return reflectionFieldTemplateArr;
    }
}
