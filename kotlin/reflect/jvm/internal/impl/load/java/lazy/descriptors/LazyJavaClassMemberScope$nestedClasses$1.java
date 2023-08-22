package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Map;
import java.util.Set;
import kotlin.collections.SetsKt___SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JavaClassFinder;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotationsKt;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
/* loaded from: classes2.dex */
public final class LazyJavaClassMemberScope$nestedClasses$1 extends Lambda implements Function1<Name, ClassDescriptorBase> {
    public final /* synthetic */ LazyJavaResolverContext $c;
    public final /* synthetic */ LazyJavaClassMemberScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaClassMemberScope$nestedClasses$1(LazyJavaClassMemberScope lazyJavaClassMemberScope, LazyJavaResolverContext lazyJavaResolverContext) {
        super(1);
        this.this$0 = lazyJavaClassMemberScope;
        this.$c = lazyJavaResolverContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final ClassDescriptorBase invoke(Name name) {
        NotNullLazyValue notNullLazyValue;
        JavaClass javaClass;
        NotNullLazyValue notNullLazyValue2;
        notNullLazyValue = this.this$0.nestedClassIndex;
        if (((Set) notNullLazyValue.invoke()).contains(name)) {
            JavaClassFinder finder = this.$c.getComponents().getFinder();
            ClassId classId = DescriptorUtilsKt.getClassId(this.this$0.getOwnerDescriptor());
            if (classId == null) {
                Intrinsics.throwNpe();
            }
            ClassId createNestedClassId = classId.createNestedClassId(name);
            Intrinsics.checkExpressionValueIsNotNull(createNestedClassId, "ownerDescriptor.classId!…createNestedClassId(name)");
            javaClass = this.this$0.jClass;
            JavaClass findClass = finder.findClass(new JavaClassFinder.Request(createNestedClassId, null, javaClass, 2, null));
            if (findClass == null) {
                return null;
            }
            LazyJavaClassDescriptor lazyJavaClassDescriptor = new LazyJavaClassDescriptor(this.$c, this.this$0.getOwnerDescriptor(), findClass, null, 8, null);
            this.$c.getComponents().getJavaClassesTracker().reportClass(lazyJavaClassDescriptor);
            return lazyJavaClassDescriptor;
        }
        notNullLazyValue2 = this.this$0.enumEntryIndex;
        JavaField javaField = (JavaField) ((Map) notNullLazyValue2.invoke()).get(name);
        if (javaField == null) {
            return null;
        }
        return EnumEntrySyntheticClassDescriptor.create(this.$c.getStorageManager(), this.this$0.getOwnerDescriptor(), name, this.$c.getStorageManager().createLazyValue(new Function0<Set<? extends Name>>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope$nestedClasses$1$enumMemberNames$1
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'java.util.Set<kotlin.reflect.jvm.internal.impl.name.Name>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends Name> invoke() {
                return SetsKt___SetsKt.plus((Set) LazyJavaClassMemberScope$nestedClasses$1.this.this$0.getFunctionNames(), (Iterable) LazyJavaClassMemberScope$nestedClasses$1.this.this$0.getVariableNames());
            }
        }), LazyJavaAnnotationsKt.resolveAnnotations(this.$c, javaField), this.$c.getComponents().getSourceElementFactory().source(javaField));
    }
}
