package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.Name;
/* loaded from: classes2.dex */
public final class ReflectJavaArrayAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaArrayAnnotationArgument {
    public final Object[] values;

    public ReflectJavaArrayAnnotationArgument(Name name, Object[] objArr) {
        super(name);
        this.values = objArr;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument
    public List<ReflectJavaAnnotationArgument> getElements() {
        Object[] objArr = this.values;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            ReflectJavaAnnotationArgument.Factory factory = ReflectJavaAnnotationArgument.Factory;
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            arrayList.add(factory.create(obj, null));
        }
        return arrayList;
    }
}
