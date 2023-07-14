package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
/* loaded from: classes2.dex */
public final class ProtoBasedClassDataFinder implements ClassDataFinder {
    public final Map<ClassId, ProtoBuf.Class> classIdToProto;
    public final Function1<ClassId, SourceElement> classSource;
    public final BinaryVersion metadataVersion;
    public final NameResolver nameResolver;

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function1<? super kotlin.reflect.jvm.internal.impl.name.ClassId, ? extends kotlin.reflect.jvm.internal.impl.descriptors.SourceElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBasedClassDataFinder(ProtoBuf.PackageFragment packageFragment, NameResolver nameResolver, BinaryVersion binaryVersion, Function1<? super ClassId, ? extends SourceElement> function1) {
        this.nameResolver = nameResolver;
        this.metadataVersion = binaryVersion;
        this.classSource = function1;
        List<ProtoBuf.Class> class_List = packageFragment.getClass_List();
        Intrinsics.checkExpressionValueIsNotNull(class_List, "proto.class_List");
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(class_List, 10)), 16));
        for (Object obj : class_List) {
            ProtoBuf.Class klass = (ProtoBuf.Class) obj;
            NameResolver nameResolver2 = this.nameResolver;
            Intrinsics.checkExpressionValueIsNotNull(klass, "klass");
            linkedHashMap.put(NameResolverUtilKt.getClassId(nameResolver2, klass.getFqName()), obj);
        }
        this.classIdToProto = linkedHashMap;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId classId) {
        ProtoBuf.Class r0 = this.classIdToProto.get(classId);
        if (r0 != null) {
            return new ClassData(this.nameResolver, r0, this.metadataVersion, this.classSource.invoke(classId));
        }
        return null;
    }

    public final Collection<ClassId> getAllClassIds() {
        return this.classIdToProto.keySet();
    }
}
