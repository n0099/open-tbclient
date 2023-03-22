package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.load.java.components.DescriptorResolverUtils;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
/* loaded from: classes9.dex */
public class ClassDeclaredMemberIndex implements DeclaredMemberIndex {
    public final Map<Name, JavaField> fields;
    public final JavaClass jClass;
    public final Function1<JavaMember, Boolean> memberFilter;
    public final Function1<JavaMethod, Boolean> methodFilter = new Function1<JavaMethod, Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.ClassDeclaredMemberIndex$methodFilter$1
        {
            super(1);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(JavaMethod javaMethod) {
            return Boolean.valueOf(invoke2(javaMethod));
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final boolean invoke2(JavaMethod javaMethod) {
            Function1 function1;
            function1 = ClassDeclaredMemberIndex.this.memberFilter;
            if (((Boolean) function1.invoke(javaMethod)).booleanValue() && !DescriptorResolverUtils.isObjectMethodInInterface(javaMethod)) {
                return true;
            }
            return false;
        }
    };
    public final Map<Name, List<JavaMethod>> methods;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember, java.lang.Boolean> */
    /* JADX WARN: Multi-variable type inference failed */
    public ClassDeclaredMemberIndex(JavaClass javaClass, Function1<? super JavaMember, Boolean> function1) {
        this.jClass = javaClass;
        this.memberFilter = function1;
        Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.jClass.getMethods()), this.methodFilter);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : filter) {
            Name name = ((JavaMethod) obj).getName();
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.methods = linkedHashMap;
        Sequence filter2 = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : filter2) {
            linkedHashMap2.put(((JavaField) obj3).getName(), obj3);
        }
        this.fields = linkedHashMap2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public JavaField findFieldByName(Name name) {
        return this.fields.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Collection<JavaMethod> findMethodsByName(Name name) {
        List<JavaMethod> list = this.methods.get(name);
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getFieldNames() {
        Sequence<JavaField> filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.jClass.getFields()), this.memberFilter);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaField javaField : filter) {
            linkedHashSet.add(javaField.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
    public Set<Name> getMethodNames() {
        Sequence<JavaMethod> filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(this.jClass.getMethods()), this.methodFilter);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (JavaMethod javaMethod : filter) {
            linkedHashSet.add(javaMethod.getName());
        }
        return linkedHashSet;
    }
}
