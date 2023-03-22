package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
/* loaded from: classes9.dex */
public interface SupertypeLoopChecker {

    /* loaded from: classes9.dex */
    public static final class EMPTY implements SupertypeLoopChecker {
        public static final EMPTY INSTANCE = new EMPTY();

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker
        public Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor typeConstructor, Collection<? extends KotlinType> collection, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> function1, Function1<? super KotlinType, Unit> function12) {
            return collection;
        }
    }

    Collection<KotlinType> findLoopsInSupertypesAndDisconnect(TypeConstructor typeConstructor, Collection<? extends KotlinType> collection, Function1<? super TypeConstructor, ? extends Iterable<? extends KotlinType>> function1, Function1<? super KotlinType, Unit> function12);
}
