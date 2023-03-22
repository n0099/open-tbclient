package kotlin.reflect.jvm.internal.impl.descriptors;

import com.baidu.mobstat.Config;
import com.google.gson.internal.bind.TypeAdapters;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.SuperCallReceiverValue;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ThisClassReceiver;
import kotlin.reflect.jvm.internal.impl.types.DynamicTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;
/* loaded from: classes9.dex */
public class Visibilities {
    public static final ReceiverValue ALWAYS_SUITABLE_RECEIVER;
    public static final Visibility DEFAULT_VISIBILITY;
    @Deprecated
    public static final ReceiverValue FALSE_IF_PROTECTED;
    public static final ReceiverValue IRRELEVANT_RECEIVER;
    public static final ModuleVisibilityHelper MODULE_VISIBILITY_HELPER;
    public static final Map<Visibility, Integer> ORDERED_VISIBILITIES;
    public static final Visibility PRIVATE = new Visibility(PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PRIVATE, false) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.1
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "what";
            } else if (i != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$1";
            if (i == 1 || i == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean hasContainingSourceFile(DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(0);
            }
            if (DescriptorUtils.getContainingSourceFile(declarationDescriptor) == SourceFile.NO_SOURCE_FILE) {
                return false;
            }
            return true;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:53:0x005d */
        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:55:0x0049 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithVisibility] */
        /* JADX WARN: Type inference failed for: r5v1, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
        /* JADX WARN: Type inference failed for: r5v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
        /* JADX WARN: Type inference failed for: r5v4, types: [kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor] */
        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == 0) {
                $$$reportNull$$$0(1);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(2);
            }
            if (DescriptorUtils.isTopLevelDeclaration(declarationDescriptorWithVisibility) && hasContainingSourceFile(declarationDescriptor)) {
                return Visibilities.inSameFile(declarationDescriptorWithVisibility, declarationDescriptor);
            }
            if (declarationDescriptorWithVisibility instanceof ConstructorDescriptor) {
                ClassifierDescriptorWithTypeParameters containingDeclaration = ((ConstructorDescriptor) declarationDescriptorWithVisibility).getContainingDeclaration();
                if (DescriptorUtils.isSealedClass(containingDeclaration) && DescriptorUtils.isTopLevelDeclaration(containingDeclaration) && (declarationDescriptor instanceof ConstructorDescriptor) && DescriptorUtils.isTopLevelDeclaration(declarationDescriptor.getContainingDeclaration()) && Visibilities.inSameFile(declarationDescriptorWithVisibility, declarationDescriptor)) {
                    return true;
                }
            }
            while (declarationDescriptorWithVisibility != 0) {
                declarationDescriptorWithVisibility = declarationDescriptorWithVisibility.getContainingDeclaration();
                if (declarationDescriptorWithVisibility instanceof ClassDescriptor) {
                    if (!DescriptorUtils.isCompanionObject(declarationDescriptorWithVisibility)) {
                        break;
                    }
                }
                if (declarationDescriptorWithVisibility instanceof PackageFragmentDescriptor) {
                    break;
                }
            }
            if (declarationDescriptorWithVisibility == 0) {
                return false;
            }
            while (declarationDescriptor != null) {
                if (declarationDescriptorWithVisibility == declarationDescriptor) {
                    return true;
                }
                if (declarationDescriptor instanceof PackageFragmentDescriptor) {
                    if ((declarationDescriptorWithVisibility instanceof PackageFragmentDescriptor) && declarationDescriptorWithVisibility.getFqName().equals(((PackageFragmentDescriptor) declarationDescriptor).getFqName()) && DescriptorUtils.areInSameModule(declarationDescriptor, declarationDescriptorWithVisibility)) {
                        return true;
                    }
                    return false;
                }
                declarationDescriptor = declarationDescriptor.getContainingDeclaration();
            }
            return false;
        }
    };
    public static final Visibility PRIVATE_TO_THIS = new Visibility("private_to_this", false) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.2
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public String getInternalDisplayName() {
            return "private/*private to this*/";
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            DeclarationDescriptor parentOfType;
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            if (Visibilities.PRIVATE.isVisible(receiverValue, declarationDescriptorWithVisibility, declarationDescriptor)) {
                if (receiverValue == Visibilities.ALWAYS_SUITABLE_RECEIVER) {
                    return true;
                }
                if (receiverValue != Visibilities.IRRELEVANT_RECEIVER && (parentOfType = DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility, ClassDescriptor.class)) != null && (receiverValue instanceof ThisClassReceiver)) {
                    return ((ThisClassReceiver) receiverValue).getClassDescriptor().getOriginal().equals(parentOfType.getOriginal());
                }
            }
            return false;
        }
    };
    public static final Visibility PROTECTED = new Visibility("protected", true) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.3
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "from";
            } else if (i == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$3";
            if (i == 2 || i == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        private boolean doesReceiverFitForProtectedVisibility(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, ClassDescriptor classDescriptor) {
            KotlinType type;
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(2);
            }
            if (classDescriptor == null) {
                $$$reportNull$$$0(3);
            }
            if (receiverValue == Visibilities.FALSE_IF_PROTECTED) {
                return false;
            }
            if (!(declarationDescriptorWithVisibility instanceof CallableMemberDescriptor) || (declarationDescriptorWithVisibility instanceof ConstructorDescriptor) || receiverValue == Visibilities.ALWAYS_SUITABLE_RECEIVER) {
                return true;
            }
            if (receiverValue == Visibilities.IRRELEVANT_RECEIVER || receiverValue == null) {
                return false;
            }
            if (receiverValue instanceof SuperCallReceiverValue) {
                type = ((SuperCallReceiverValue) receiverValue).getThisType();
            } else {
                type = receiverValue.getType();
            }
            if (!DescriptorUtils.isSubtypeOfClass(type, classDescriptor) && !DynamicTypesKt.isDynamic(type)) {
                return false;
            }
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            ClassDescriptor classDescriptor;
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            ClassDescriptor classDescriptor2 = (ClassDescriptor) DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility, ClassDescriptor.class);
            ClassDescriptor classDescriptor3 = (ClassDescriptor) DescriptorUtils.getParentOfType(declarationDescriptor, ClassDescriptor.class, false);
            if (classDescriptor3 == null) {
                return false;
            }
            if (classDescriptor2 != null && DescriptorUtils.isCompanionObject(classDescriptor2) && (classDescriptor = (ClassDescriptor) DescriptorUtils.getParentOfType(classDescriptor2, ClassDescriptor.class)) != null && DescriptorUtils.isSubclass(classDescriptor3, classDescriptor)) {
                return true;
            }
            DeclarationDescriptorWithVisibility unwrapFakeOverrideToAnyDeclaration = DescriptorUtils.unwrapFakeOverrideToAnyDeclaration(declarationDescriptorWithVisibility);
            ClassDescriptor classDescriptor4 = (ClassDescriptor) DescriptorUtils.getParentOfType(unwrapFakeOverrideToAnyDeclaration, ClassDescriptor.class);
            if (classDescriptor4 == null) {
                return false;
            }
            if (DescriptorUtils.isSubclass(classDescriptor3, classDescriptor4) && doesReceiverFitForProtectedVisibility(receiverValue, unwrapFakeOverrideToAnyDeclaration, classDescriptor3)) {
                return true;
            }
            return isVisible(receiverValue, declarationDescriptorWithVisibility, classDescriptor3.getContainingDeclaration());
        }
    };
    public static final Visibility INTERNAL = new Visibility("internal", false) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.4
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            if (!DescriptorUtils.getContainingModule(declarationDescriptor).shouldSeeInternalsOf(DescriptorUtils.getContainingModule(declarationDescriptorWithVisibility))) {
                return false;
            }
            return Visibilities.MODULE_VISIBILITY_HELPER.isInFriendModule(declarationDescriptorWithVisibility, declarationDescriptor);
        }
    };
    public static final Visibility PUBLIC = new Visibility("public", true) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.5
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            return true;
        }
    };
    public static final Visibility LOCAL = new Visibility("local", false) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.6
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    };
    public static final Visibility INHERITED = new Visibility("inherited", false) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.7
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    };
    public static final Visibility INVISIBLE_FAKE = new Visibility("invisible_fake", false) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.8
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            return false;
        }
    };
    public static final Visibility UNKNOWN = new Visibility("unknown", false) { // from class: kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.9
        public static /* synthetic */ void $$$reportNull$$$0(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.Visibility
        public boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
            if (declarationDescriptorWithVisibility == null) {
                $$$reportNull$$$0(0);
            }
            if (declarationDescriptor == null) {
                $$$reportNull$$$0(1);
            }
            return false;
        }
    };
    public static final Set<Visibility> INVISIBLE_FROM_OTHER_MODULES = Collections.unmodifiableSet(SetsKt__SetsKt.setOf((Object[]) new Visibility[]{PRIVATE, PRIVATE_TO_THIS, INTERNAL, LOCAL}));

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        Object[] objArr = new Object[3];
        if (i != 1 && i != 3 && i != 5 && i != 7) {
            switch (i) {
                case 9:
                    break;
                case 10:
                case 12:
                    objArr[0] = Config.TRACE_VISIT_FIRST;
                    break;
                case 11:
                case 13:
                    objArr[0] = TypeAdapters.AnonymousClass27.SECOND;
                    break;
                case 14:
                    objArr[0] = RemoteMessageConst.Notification.VISIBILITY;
                    break;
                default:
                    objArr[0] = "what";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities";
            switch (i) {
                case 2:
                case 3:
                    objArr[2] = "isVisibleIgnoringReceiver";
                    break;
                case 4:
                case 5:
                    objArr[2] = "isVisibleWithAnyReceiver";
                    break;
                case 6:
                case 7:
                    objArr[2] = "inSameFile";
                    break;
                case 8:
                case 9:
                    objArr[2] = "findInvisibleMember";
                    break;
                case 10:
                case 11:
                    objArr[2] = "compareLocal";
                    break;
                case 12:
                case 13:
                    objArr[2] = "compare";
                    break;
                case 14:
                    objArr[2] = "isPrivate";
                    break;
                default:
                    objArr[2] = "isVisible";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
        objArr[0] = "from";
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/Visibilities";
        switch (i) {
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    static {
        ModuleVisibilityHelper moduleVisibilityHelper;
        HashMap newHashMapWithExpectedSize = CollectionsKt.newHashMapWithExpectedSize(4);
        newHashMapWithExpectedSize.put(PRIVATE_TO_THIS, 0);
        newHashMapWithExpectedSize.put(PRIVATE, 0);
        newHashMapWithExpectedSize.put(INTERNAL, 1);
        newHashMapWithExpectedSize.put(PROTECTED, 1);
        newHashMapWithExpectedSize.put(PUBLIC, 2);
        ORDERED_VISIBILITIES = Collections.unmodifiableMap(newHashMapWithExpectedSize);
        DEFAULT_VISIBILITY = PUBLIC;
        IRRELEVANT_RECEIVER = new ReceiverValue() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.10
            @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
            public KotlinType getType() {
                throw new IllegalStateException("This method should not be called");
            }
        };
        ALWAYS_SUITABLE_RECEIVER = new ReceiverValue() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.11
            @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
            public KotlinType getType() {
                throw new IllegalStateException("This method should not be called");
            }
        };
        FALSE_IF_PROTECTED = new ReceiverValue() { // from class: kotlin.reflect.jvm.internal.impl.descriptors.Visibilities.12
            @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue
            public KotlinType getType() {
                throw new IllegalStateException("This method should not be called");
            }
        };
        Iterator it = ServiceLoader.load(ModuleVisibilityHelper.class, ModuleVisibilityHelper.class.getClassLoader()).iterator();
        if (it.hasNext()) {
            moduleVisibilityHelper = (ModuleVisibilityHelper) it.next();
        } else {
            moduleVisibilityHelper = ModuleVisibilityHelper.EMPTY.INSTANCE;
        }
        MODULE_VISIBILITY_HELPER = moduleVisibilityHelper;
    }

    public static Integer compare(Visibility visibility, Visibility visibility2) {
        if (visibility == null) {
            $$$reportNull$$$0(12);
        }
        if (visibility2 == null) {
            $$$reportNull$$$0(13);
        }
        Integer compareTo = visibility.compareTo(visibility2);
        if (compareTo != null) {
            return compareTo;
        }
        Integer compareTo2 = visibility2.compareTo(visibility);
        if (compareTo2 != null) {
            return Integer.valueOf(-compareTo2.intValue());
        }
        return null;
    }

    public static boolean inSameFile(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(6);
        }
        if (declarationDescriptor2 == null) {
            $$$reportNull$$$0(7);
        }
        SourceFile containingSourceFile = DescriptorUtils.getContainingSourceFile(declarationDescriptor2);
        if (containingSourceFile != SourceFile.NO_SOURCE_FILE) {
            return containingSourceFile.equals(DescriptorUtils.getContainingSourceFile(declarationDescriptor));
        }
        return false;
    }

    public static boolean isVisibleIgnoringReceiver(DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(2);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(3);
        }
        if (findInvisibleMember(ALWAYS_SUITABLE_RECEIVER, declarationDescriptorWithVisibility, declarationDescriptor) == null) {
            return true;
        }
        return false;
    }

    public static Integer compareLocal(Visibility visibility, Visibility visibility2) {
        if (visibility == null) {
            $$$reportNull$$$0(10);
        }
        if (visibility2 == null) {
            $$$reportNull$$$0(11);
        }
        if (visibility == visibility2) {
            return 0;
        }
        Integer num = ORDERED_VISIBILITIES.get(visibility);
        Integer num2 = ORDERED_VISIBILITIES.get(visibility2);
        if (num != null && num2 != null && !num.equals(num2)) {
            return Integer.valueOf(num.intValue() - num2.intValue());
        }
        return null;
    }

    public static DeclarationDescriptorWithVisibility findInvisibleMember(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor) {
        DeclarationDescriptorWithVisibility findInvisibleMember;
        if (declarationDescriptorWithVisibility == null) {
            $$$reportNull$$$0(8);
        }
        if (declarationDescriptor == null) {
            $$$reportNull$$$0(9);
        }
        for (DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) declarationDescriptorWithVisibility.getOriginal(); declarationDescriptorWithVisibility2 != null && declarationDescriptorWithVisibility2.getVisibility() != LOCAL; declarationDescriptorWithVisibility2 = (DeclarationDescriptorWithVisibility) DescriptorUtils.getParentOfType(declarationDescriptorWithVisibility2, DeclarationDescriptorWithVisibility.class)) {
            if (!declarationDescriptorWithVisibility2.getVisibility().isVisible(receiverValue, declarationDescriptorWithVisibility2, declarationDescriptor)) {
                return declarationDescriptorWithVisibility2;
            }
        }
        if ((declarationDescriptorWithVisibility instanceof TypeAliasConstructorDescriptor) && (findInvisibleMember = findInvisibleMember(receiverValue, ((TypeAliasConstructorDescriptor) declarationDescriptorWithVisibility).getUnderlyingConstructorDescriptor(), declarationDescriptor)) != null) {
            return findInvisibleMember;
        }
        return null;
    }

    public static boolean isPrivate(Visibility visibility) {
        if (visibility == null) {
            $$$reportNull$$$0(14);
        }
        if (visibility != PRIVATE && visibility != PRIVATE_TO_THIS) {
            return false;
        }
        return true;
    }
}
