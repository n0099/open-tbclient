package kotlin.reflect.jvm.internal.impl.util;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
/* loaded from: classes9.dex */
public interface ModuleVisibilityHelper {

    /* loaded from: classes9.dex */
    public static final class EMPTY implements ModuleVisibilityHelper {
        public static final EMPTY INSTANCE = new EMPTY();

        @Override // kotlin.reflect.jvm.internal.impl.util.ModuleVisibilityHelper
        public boolean isInFriendModule(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2) {
            return true;
        }
    }

    boolean isInFriendModule(DeclarationDescriptor declarationDescriptor, DeclarationDescriptor declarationDescriptor2);
}
