package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
/* loaded from: classes9.dex */
public final class ScopesHolderForClass<T extends MemberScope> {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    public static final Companion Companion = new Companion(null);
    public final ClassDescriptor classDescriptor;
    public final KotlinTypeRefiner kotlinTypeRefinerForOwnerModule;
    public final Function1<KotlinTypeRefiner, T> scopeFactory;
    public final NotNullLazyValue scopeForOwnerModule$delegate;

    private final T getScopeForOwnerModule() {
        return (T) StorageKt.getValue(this.scopeForOwnerModule$delegate, this, $$delegatedProperties[0]);
    }

    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T extends MemberScope> ScopesHolderForClass<T> create(ClassDescriptor classDescriptor, StorageManager storageManager, KotlinTypeRefiner kotlinTypeRefiner, Function1<? super KotlinTypeRefiner, ? extends T> function1) {
            return new ScopesHolderForClass<>(classDescriptor, storageManager, function1, kotlinTypeRefiner, null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner, ? extends T extends kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope> */
    /* JADX WARN: Multi-variable type inference failed */
    public ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1<? super KotlinTypeRefiner, ? extends T> function1, KotlinTypeRefiner kotlinTypeRefiner) {
        this.classDescriptor = classDescriptor;
        this.scopeFactory = function1;
        this.kotlinTypeRefinerForOwnerModule = kotlinTypeRefiner;
        this.scopeForOwnerModule$delegate = storageManager.createLazyValue(new Function0<T>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass$scopeForOwnerModule$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            public final MemberScope invoke() {
                Function1 function12;
                KotlinTypeRefiner kotlinTypeRefiner2;
                function12 = ScopesHolderForClass.this.scopeFactory;
                kotlinTypeRefiner2 = ScopesHolderForClass.this.kotlinTypeRefinerForOwnerModule;
                return (MemberScope) function12.invoke(kotlinTypeRefiner2);
            }
        });
    }

    public /* synthetic */ ScopesHolderForClass(ClassDescriptor classDescriptor, StorageManager storageManager, Function1 function1, KotlinTypeRefiner kotlinTypeRefiner, DefaultConstructorMarker defaultConstructorMarker) {
        this(classDescriptor, storageManager, function1, kotlinTypeRefiner);
    }

    public final T getScope(final KotlinTypeRefiner kotlinTypeRefiner) {
        if (!kotlinTypeRefiner.isRefinementNeededForModule(DescriptorUtilsKt.getModule(this.classDescriptor))) {
            return getScopeForOwnerModule();
        }
        TypeConstructor typeConstructor = this.classDescriptor.getTypeConstructor();
        Intrinsics.checkExpressionValueIsNotNull(typeConstructor, "classDescriptor.typeConstructor");
        if (!kotlinTypeRefiner.isRefinementNeededForTypeConstructor(typeConstructor)) {
            return getScopeForOwnerModule();
        }
        return (T) kotlinTypeRefiner.getOrPutScopeForClass(this.classDescriptor, new Function0<T>() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass$getScope$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            public final MemberScope invoke() {
                Function1 function1;
                function1 = ScopesHolderForClass.this.scopeFactory;
                return (MemberScope) function1.invoke(kotlinTypeRefiner);
            }
        });
    }
}
