package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ImplicitClassReceiver;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;
/* loaded from: classes2.dex */
public class LazyClassReceiverParameterDescriptor extends AbstractReceiverParameterDescriptor {
    public final ClassDescriptor descriptor;
    public final ImplicitClassReceiver receiverValue;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i == 1) {
            objArr[1] = "getValue";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i != 1 && i != 2) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = CommandUBCHelper.COMMAND_UBC_TYPE_COPY;
            }
        }
        String format = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyClassReceiverParameterDescriptor(ClassDescriptor classDescriptor) {
        super(Annotations.Companion.getEMPTY());
        if (classDescriptor == null) {
            $$$reportNull$$$0(0);
        }
        this.descriptor = classDescriptor;
        this.receiverValue = new ImplicitClassReceiver(classDescriptor, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    public DeclarationDescriptor getContainingDeclaration() {
        ClassDescriptor classDescriptor = this.descriptor;
        if (classDescriptor == null) {
            $$$reportNull$$$0(2);
        }
        return classDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor
    public ReceiverValue getValue() {
        ImplicitClassReceiver implicitClassReceiver = this.receiverValue;
        if (implicitClassReceiver == null) {
            $$$reportNull$$$0(1);
        }
        return implicitClassReceiver;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.DeclarationDescriptorImpl
    public String toString() {
        return "class " + this.descriptor.getName() + "::this";
    }
}
