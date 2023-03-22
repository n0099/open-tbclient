package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
/* loaded from: classes9.dex */
public final class TypeTable {
    public final List<ProtoBuf.Type> types;

    public TypeTable(ProtoBuf.TypeTable typeTable) {
        List<ProtoBuf.Type> originalTypes = typeTable.getTypeList();
        if (typeTable.hasFirstNullable()) {
            int firstNullable = typeTable.getFirstNullable();
            List<ProtoBuf.Type> typeList = typeTable.getTypeList();
            Intrinsics.checkExpressionValueIsNotNull(typeList, "typeTable.typeList");
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(typeList, 10));
            int i = 0;
            for (Object obj : typeList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ProtoBuf.Type type = (ProtoBuf.Type) obj;
                if (i >= firstNullable) {
                    type = type.toBuilder().setNullable(true).build();
                }
                arrayList.add(type);
                i = i2;
            }
            originalTypes = arrayList;
        } else {
            Intrinsics.checkExpressionValueIsNotNull(originalTypes, "originalTypes");
        }
        this.types = originalTypes;
    }

    public final ProtoBuf.Type get(int i) {
        return this.types.get(i);
    }
}
