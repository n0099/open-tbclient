package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes9.dex */
public abstract class ErrorValue extends ConstantValue<Unit> {
    public static final Companion Companion = new Companion(null);

    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ErrorValue create(String str) {
            return new ErrorValueWithMessage(str);
        }
    }

    /* loaded from: classes9.dex */
    public static final class ErrorValueWithMessage extends ErrorValue {
        public final String message;

        public ErrorValueWithMessage(String str) {
            this.message = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
        public SimpleType getType(ModuleDescriptor moduleDescriptor) {
            SimpleType createErrorType = ErrorUtils.createErrorType(this.message);
            Intrinsics.checkExpressionValueIsNotNull(createErrorType, "ErrorUtils.createErrorType(message)");
            return createErrorType;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
        public String toString() {
            return this.message;
        }
    }

    public ErrorValue() {
        super(Unit.INSTANCE);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue
    public Unit getValue() {
        throw new UnsupportedOperationException();
    }
}
