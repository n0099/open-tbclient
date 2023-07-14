package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
/* loaded from: classes2.dex */
public final class KotlinTypeRefinerKt {
    public static final ModuleDescriptor.Capability<Ref<KotlinTypeRefiner>> REFINER_CAPABILITY = new ModuleDescriptor.Capability<>("KotlinTypeRefiner");

    public static final ModuleDescriptor.Capability<Ref<KotlinTypeRefiner>> getREFINER_CAPABILITY() {
        return REFINER_CAPABILITY;
    }

    public static final List<KotlinType> refineTypes(KotlinTypeRefiner kotlinTypeRefiner, Iterable<? extends KotlinType> iterable) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (KotlinType kotlinType : iterable) {
            arrayList.add(kotlinTypeRefiner.refineType(kotlinType));
        }
        return arrayList;
    }
}
