package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
/* loaded from: classes9.dex */
public final class PrimitiveTypeUtilKt {
    public static final Collection<KotlinType> getAllSignedLiteralTypes(ModuleDescriptor moduleDescriptor) {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new SimpleType[]{moduleDescriptor.getBuiltIns().getIntType(), moduleDescriptor.getBuiltIns().getLongType(), moduleDescriptor.getBuiltIns().getByteType(), moduleDescriptor.getBuiltIns().getShortType()});
    }
}
