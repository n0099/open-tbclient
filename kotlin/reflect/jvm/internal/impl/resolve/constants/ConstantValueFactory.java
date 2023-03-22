package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes9.dex */
public final class ConstantValueFactory {
    public static final ConstantValueFactory INSTANCE = new ConstantValueFactory();

    private final ArrayValue createArrayValue(List<?> list, final PrimitiveType primitiveType) {
        List<Object> list2 = CollectionsKt___CollectionsKt.toList(list);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            ConstantValue<?> createConstantValue = createConstantValue(obj);
            if (createConstantValue != null) {
                arrayList.add(createConstantValue);
            }
        }
        return new ArrayValue(arrayList, new Function1<ModuleDescriptor, SimpleType>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory$createArrayValue$3
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final SimpleType invoke(ModuleDescriptor moduleDescriptor) {
                SimpleType primitiveArrayKotlinType = moduleDescriptor.getBuiltIns().getPrimitiveArrayKotlinType(PrimitiveType.this);
                Intrinsics.checkExpressionValueIsNotNull(primitiveArrayKotlinType, "module.builtIns.getPrimi…KotlinType(componentType)");
                return primitiveArrayKotlinType;
            }
        });
    }

    public final ArrayValue createArrayValue(List<? extends ConstantValue<?>> list, final KotlinType kotlinType) {
        return new ArrayValue(list, new Function1<ModuleDescriptor, KotlinType>() { // from class: kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory$createArrayValue$1
            {
                super(1);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // kotlin.jvm.functions.Function1
            public final KotlinType invoke(ModuleDescriptor moduleDescriptor) {
                return KotlinType.this;
            }
        });
    }

    public final ConstantValue<?> createConstantValue(Object obj) {
        if (obj instanceof Byte) {
            return new ByteValue(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new ShortValue(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new IntValue(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new LongValue(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new CharValue(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new FloatValue(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new DoubleValue(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new BooleanValue(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new StringValue((String) obj);
        }
        if (obj instanceof byte[]) {
            return createArrayValue(ArraysKt___ArraysKt.toList((byte[]) obj), PrimitiveType.BYTE);
        }
        if (obj instanceof short[]) {
            return createArrayValue(ArraysKt___ArraysKt.toList((short[]) obj), PrimitiveType.SHORT);
        }
        if (obj instanceof int[]) {
            return createArrayValue(ArraysKt___ArraysKt.toList((int[]) obj), PrimitiveType.INT);
        }
        if (obj instanceof long[]) {
            return createArrayValue(ArraysKt___ArraysKt.toList((long[]) obj), PrimitiveType.LONG);
        }
        if (obj instanceof char[]) {
            return createArrayValue(ArraysKt___ArraysKt.toList((char[]) obj), PrimitiveType.CHAR);
        }
        if (obj instanceof float[]) {
            return createArrayValue(ArraysKt___ArraysKt.toList((float[]) obj), PrimitiveType.FLOAT);
        }
        if (obj instanceof double[]) {
            return createArrayValue(ArraysKt___ArraysKt.toList((double[]) obj), PrimitiveType.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            return createArrayValue(ArraysKt___ArraysKt.toList((boolean[]) obj), PrimitiveType.BOOLEAN);
        }
        if (obj == null) {
            return new NullValue();
        }
        return null;
    }
}
