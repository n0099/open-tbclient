package javassist.bytecode.annotation;

import javassist.bytecode.y;
/* loaded from: classes.dex */
public class AnnotationMemberValue extends d {

    /* renamed from: a  reason: collision with root package name */
    a f2775a;

    public AnnotationMemberValue(a aVar, y yVar) {
        super('@', yVar);
        this.f2775a = aVar;
    }

    public String toString() {
        return this.f2775a.toString();
    }
}
