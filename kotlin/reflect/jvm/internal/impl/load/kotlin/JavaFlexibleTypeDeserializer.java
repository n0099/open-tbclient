package kotlin.reflect.jvm.internal.impl.load.kotlin;

import com.baidu.android.common.others.IStringUtil;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes2.dex */
public final class JavaFlexibleTypeDeserializer implements FlexibleTypeDeserializer {
    public static final JavaFlexibleTypeDeserializer INSTANCE = new JavaFlexibleTypeDeserializer();

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer
    public KotlinType create(ProtoBuf.Type type, String str, SimpleType simpleType, SimpleType simpleType2) {
        if (!Intrinsics.areEqual(str, "kotlin.jvm.PlatformType")) {
            SimpleType createErrorType = ErrorUtils.createErrorType("Error java flexible type with id: " + str + ". (" + simpleType + IStringUtil.TOP_PATH + simpleType2 + ')');
            Intrinsics.checkExpressionValueIsNotNull(createErrorType, "ErrorUtils.createErrorTy…owerBound..$upperBound)\")");
            return createErrorType;
        } else if (type.hasExtension(JvmProtoBuf.isRaw)) {
            return new RawTypeImpl(simpleType, simpleType2);
        } else {
            return KotlinTypeFactory.flexibleType(simpleType, simpleType2);
        }
    }
}
