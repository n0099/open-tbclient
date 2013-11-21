package javassist.bytecode.annotation;

import javassist.bytecode.y;
/* loaded from: classes.dex */
public class AnnotationMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    a f2759a;

    public AnnotationMemberValue(a aVar, y yVar) {
        super('@', yVar);
        this.f2759a = aVar;
    }

    public String toString() {
        return this.f2759a.toString();
    }
}
