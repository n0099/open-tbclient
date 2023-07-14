package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.util.Check;
/* loaded from: classes2.dex */
public abstract class ReturnsCheck implements Check {
    public final String description;
    public final String name;
    public final Function1<KotlinBuiltIns, KotlinType> type;

    /* loaded from: classes2.dex */
    public static final class ReturnsBoolean extends ReturnsCheck {
        public static final ReturnsBoolean INSTANCE = new ReturnsBoolean();

        public ReturnsBoolean() {
            super("Boolean", new Function1<KotlinBuiltIns, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsBoolean.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final SimpleType invoke(KotlinBuiltIns kotlinBuiltIns) {
                    SimpleType booleanType = kotlinBuiltIns.getBooleanType();
                    Intrinsics.checkExpressionValueIsNotNull(booleanType, "booleanType");
                    return booleanType;
                }
            }, null);
        }
    }

    /* loaded from: classes2.dex */
    public static final class ReturnsInt extends ReturnsCheck {
        public static final ReturnsInt INSTANCE = new ReturnsInt();

        public ReturnsInt() {
            super("Int", new Function1<KotlinBuiltIns, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsInt.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final SimpleType invoke(KotlinBuiltIns kotlinBuiltIns) {
                    SimpleType intType = kotlinBuiltIns.getIntType();
                    Intrinsics.checkExpressionValueIsNotNull(intType, "intType");
                    return intType;
                }
            }, null);
        }
    }

    /* loaded from: classes2.dex */
    public static final class ReturnsUnit extends ReturnsCheck {
        public static final ReturnsUnit INSTANCE = new ReturnsUnit();

        public ReturnsUnit() {
            super("Unit", new Function1<KotlinBuiltIns, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsUnit.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final SimpleType invoke(KotlinBuiltIns kotlinBuiltIns) {
                    SimpleType unitType = kotlinBuiltIns.getUnitType();
                    Intrinsics.checkExpressionValueIsNotNull(unitType, "unitType");
                    return unitType;
                }
            }, null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns, ? extends kotlin.reflect.jvm.internal.impl.types.KotlinType> */
    /* JADX WARN: Multi-variable type inference failed */
    public ReturnsCheck(String str, Function1<? super KotlinBuiltIns, ? extends KotlinType> function1) {
        this.name = str;
        this.type = function1;
        this.description = "must return " + this.name;
    }

    public /* synthetic */ ReturnsCheck(String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public boolean check(FunctionDescriptor functionDescriptor) {
        return Intrinsics.areEqual(functionDescriptor.getReturnType(), this.type.invoke(DescriptorUtilsKt.getBuiltIns(functionDescriptor)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String invoke(FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.Check
    public String getDescription() {
        return this.description;
    }
}
