package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.name.Name;
/* loaded from: classes9.dex */
public interface DeclaredMemberIndex {
    JavaField findFieldByName(Name name);

    Collection<JavaMethod> findMethodsByName(Name name);

    Set<Name> getFieldNames();

    Set<Name> getMethodNames();

    /* loaded from: classes9.dex */
    public static final class Empty implements DeclaredMemberIndex {
        public static final Empty INSTANCE = new Empty();

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        public JavaField findFieldByName(Name name) {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        public Set<Name> getFieldNames() {
            return SetsKt__SetsKt.emptySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        public Set<Name> getMethodNames() {
            return SetsKt__SetsKt.emptySet();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.DeclaredMemberIndex
        public List<JavaMethod> findMethodsByName(Name name) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
    }
}
