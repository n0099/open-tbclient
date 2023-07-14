package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
/* loaded from: classes2.dex */
public final class VersionRequirementTable {
    public static final Companion Companion = new Companion(null);
    public static final VersionRequirementTable EMPTY = new VersionRequirementTable(CollectionsKt__CollectionsKt.emptyList());
    public final List<ProtoBuf.VersionRequirement> infos;

    /* loaded from: classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public final VersionRequirementTable getEMPTY() {
            return VersionRequirementTable.EMPTY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VersionRequirementTable create(ProtoBuf.VersionRequirementTable versionRequirementTable) {
            if (versionRequirementTable.getRequirementCount() == 0) {
                return getEMPTY();
            }
            List<ProtoBuf.VersionRequirement> requirementList = versionRequirementTable.getRequirementList();
            Intrinsics.checkExpressionValueIsNotNull(requirementList, "table.requirementList");
            return new VersionRequirementTable(requirementList, null);
        }
    }

    public VersionRequirementTable(List<ProtoBuf.VersionRequirement> list) {
        this.infos = list;
    }

    public final ProtoBuf.VersionRequirement get(int i) {
        return (ProtoBuf.VersionRequirement) CollectionsKt___CollectionsKt.getOrNull(this.infos, i);
    }

    public /* synthetic */ VersionRequirementTable(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }
}
