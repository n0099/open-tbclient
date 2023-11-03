package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import com.baidu.searchbox.account.contants.AccountConstants;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.AdditionalClassPartsProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.ClassDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.descriptors.deserialization.PlatformDependentDeclarationFilter;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
/* loaded from: classes2.dex */
public final class JvmBuiltIns extends KotlinBuiltIns {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(JvmBuiltIns.class), AccountConstants.LOGOUT_TYPE_NATIVE_SRC_SETTINGS, "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsSettings;"))};
    public boolean isAdditionalBuiltInsFeatureSupported;
    public ModuleDescriptor ownerModuleDescriptor;
    public final NotNullLazyValue settings$delegate;

    /* loaded from: classes2.dex */
    public enum Kind {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK
    }

    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Kind.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Kind.FROM_DEPENDENCIES.ordinal()] = 1;
            $EnumSwitchMapping$0[Kind.FROM_CLASS_LOADER.ordinal()] = 2;
            $EnumSwitchMapping$0[Kind.FALLBACK.ordinal()] = 3;
        }
    }

    public final JvmBuiltInsSettings getSettings() {
        return (JvmBuiltInsSettings) StorageKt.getValue(this.settings$delegate, this, $$delegatedProperties[0]);
    }

    public JvmBuiltIns(final StorageManager storageManager, Kind kind) {
        super(storageManager);
        this.isAdditionalBuiltInsFeatureSupported = true;
        this.settings$delegate = storageManager.createLazyValue(new Function0<JvmBuiltInsSettings>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$settings$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function0
            public final JvmBuiltInsSettings invoke() {
                ModuleDescriptorImpl builtInsModule = JvmBuiltIns.this.getBuiltInsModule();
                Intrinsics.checkExpressionValueIsNotNull(builtInsModule, "builtInsModule");
                return new JvmBuiltInsSettings(builtInsModule, storageManager, new Function0<ModuleDescriptor>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$settings$2.1
                    {
                        super(0);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function0
                    public final ModuleDescriptor invoke() {
                        ModuleDescriptor moduleDescriptor;
                        moduleDescriptor = JvmBuiltIns.this.ownerModuleDescriptor;
                        if (moduleDescriptor != null) {
                            return moduleDescriptor;
                        }
                        throw new AssertionError("JvmBuiltins has not been initialized properly");
                    }
                }, new Function0<Boolean>() { // from class: kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltIns$settings$2.2
                    {
                        super(0);
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Boolean invoke() {
                        return Boolean.valueOf(invoke2());
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final boolean invoke2() {
                        ModuleDescriptor moduleDescriptor;
                        boolean z;
                        moduleDescriptor = JvmBuiltIns.this.ownerModuleDescriptor;
                        if (moduleDescriptor != null) {
                            z = JvmBuiltIns.this.isAdditionalBuiltInsFeatureSupported;
                            return z;
                        }
                        throw new AssertionError("JvmBuiltins has not been initialized properly");
                    }
                });
            }
        });
        int i = WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
        if (i != 2) {
            if (i == 3) {
                createBuiltInsModule(true);
                return;
            }
            return;
        }
        createBuiltInsModule(false);
    }

    public final void initialize(ModuleDescriptor moduleDescriptor, boolean z) {
        boolean z2;
        if (this.ownerModuleDescriptor == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (_Assertions.ENABLED && !z2) {
            throw new AssertionError("JvmBuiltins repeated initialization");
        }
        this.ownerModuleDescriptor = moduleDescriptor;
        this.isAdditionalBuiltInsFeatureSupported = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public AdditionalClassPartsProvider getAdditionalClassPartsProvider() {
        return getSettings();
    }

    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public PlatformDependentDeclarationFilter getPlatformDependentDeclarationFilter() {
        return getSettings();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns
    public List<ClassDescriptorFactory> getClassDescriptorFactories() {
        Iterable<ClassDescriptorFactory> classDescriptorFactories = super.getClassDescriptorFactories();
        Intrinsics.checkExpressionValueIsNotNull(classDescriptorFactories, "super.getClassDescriptorFactories()");
        StorageManager storageManager = getStorageManager();
        Intrinsics.checkExpressionValueIsNotNull(storageManager, "storageManager");
        ModuleDescriptorImpl builtInsModule = getBuiltInsModule();
        Intrinsics.checkExpressionValueIsNotNull(builtInsModule, "builtInsModule");
        return CollectionsKt___CollectionsKt.plus(classDescriptorFactories, new JvmBuiltInClassDescriptorFactory(storageManager, builtInsModule, null, 4, null));
    }
}
