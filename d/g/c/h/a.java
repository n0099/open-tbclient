package d.g.c.h;

import com.google.common.reflect.TypeToken;
import d.g.c.a.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
/* loaded from: classes6.dex */
public class a extends AccessibleObject implements Member {

    /* renamed from: e  reason: collision with root package name */
    public final AccessibleObject f70166e;

    /* renamed from: f  reason: collision with root package name */
    public final Member f70167f;

    public <M extends AccessibleObject & Member> a(M m) {
        n.p(m);
        this.f70166e = m;
        this.f70167f = m;
    }

    public TypeToken<?> a() {
        return TypeToken.of((Class) getDeclaringClass());
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return a().equals(aVar.a()) && this.f70167f.equals(aVar.f70167f);
        }
        return false;
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.f70166e.getAnnotation(cls);
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.f70166e.getAnnotations();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.f70166e.getDeclaredAnnotations();
    }

    @Override // java.lang.reflect.Member
    public Class<?> getDeclaringClass() {
        return this.f70167f.getDeclaringClass();
    }

    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.f70167f.getModifiers();
    }

    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.f70167f.getName();
    }

    public int hashCode() {
        return this.f70167f.hashCode();
    }

    @Override // java.lang.reflect.AccessibleObject
    public final boolean isAccessible() {
        return this.f70166e.isAccessible();
    }

    @Override // java.lang.reflect.AccessibleObject, java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.f70166e.isAnnotationPresent(cls);
    }

    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.f70167f.isSynthetic();
    }

    @Override // java.lang.reflect.AccessibleObject
    public final void setAccessible(boolean z) throws SecurityException {
        this.f70166e.setAccessible(z);
    }

    public String toString() {
        return this.f70167f.toString();
    }
}
