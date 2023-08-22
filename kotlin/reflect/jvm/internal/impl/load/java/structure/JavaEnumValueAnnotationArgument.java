package kotlin.reflect.jvm.internal.impl.load.java.structure;

import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
/* loaded from: classes2.dex */
public interface JavaEnumValueAnnotationArgument extends JavaAnnotationArgument {
    Name getEntryName();

    ClassId getEnumClassId();
}
