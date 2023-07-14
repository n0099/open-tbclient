package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* loaded from: classes2.dex */
public final class LazyWrappedType extends WrappedType {
    public final Function0<KotlinType> computation;
    public final NotNullLazyValue<KotlinType> lazyValue;
    public final StorageManager storageManager;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function0<? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyWrappedType(StorageManager storageManager, Function0<? extends KotlinType> function0) {
        this.storageManager = storageManager;
        this.computation = function0;
        this.lazyValue = storageManager.createLazyValue(function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    public KotlinType getDelegate() {
        return this.lazyValue.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.WrappedType
    public boolean isComputed() {
        return this.lazyValue.isComputed();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.types.KotlinType
    public LazyWrappedType refine(final KotlinTypeRefiner kotlinTypeRefiner) {
        return new LazyWrappedType(this.storageManager, new Function0<KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.types.LazyWrappedType$refine$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final KotlinType invoke() {
                Function0 function0;
                KotlinTypeRefiner kotlinTypeRefiner2 = kotlinTypeRefiner;
                function0 = LazyWrappedType.this.computation;
                return kotlinTypeRefiner2.refineType((KotlinType) function0.invoke());
            }
        });
    }
}
