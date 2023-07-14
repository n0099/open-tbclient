package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.LinkedList;
import java.util.List;
import kotlin.Triple;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
/* loaded from: classes2.dex */
public final class NameResolverImpl implements NameResolver {
    public final ProtoBuf.QualifiedNameTable qualifiedNames;
    public final ProtoBuf.StringTable strings;

    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.CLASS.ordinal()] = 1;
            $EnumSwitchMapping$0[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.PACKAGE.ordinal()] = 2;
            $EnumSwitchMapping$0[ProtoBuf.QualifiedNameTable.QualifiedName.Kind.LOCAL.ordinal()] = 3;
        }
    }

    public NameResolverImpl(ProtoBuf.StringTable stringTable, ProtoBuf.QualifiedNameTable qualifiedNameTable) {
        this.strings = stringTable;
        this.qualifiedNames = qualifiedNameTable;
    }

    private final Triple<List<String>, List<String>, Boolean> traverseIds(int i) {
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        boolean z = false;
        while (i != -1) {
            ProtoBuf.QualifiedNameTable.QualifiedName proto = this.qualifiedNames.getQualifiedName(i);
            ProtoBuf.StringTable stringTable = this.strings;
            Intrinsics.checkExpressionValueIsNotNull(proto, "proto");
            String string = stringTable.getString(proto.getShortName());
            ProtoBuf.QualifiedNameTable.QualifiedName.Kind kind = proto.getKind();
            if (kind == null) {
                Intrinsics.throwNpe();
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[kind.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        linkedList2.addFirst(string);
                        z = true;
                    }
                } else {
                    linkedList.addFirst(string);
                }
            } else {
                linkedList2.addFirst(string);
            }
            i = proto.getParentQualifiedName();
        }
        return new Triple<>(linkedList, linkedList2, Boolean.valueOf(z));
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getQualifiedClassName(int i) {
        Triple<List<String>, List<String>, Boolean> traverseIds = traverseIds(i);
        List<String> component1 = traverseIds.component1();
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(traverseIds.component2(), ".", null, null, 0, null, null, 62, null);
        if (!component1.isEmpty()) {
            return CollectionsKt___CollectionsKt.joinToString$default(component1, "/", null, null, 0, null, null, 62, null) + WebvttCueParser.CHAR_SLASH + joinToString$default;
        }
        return joinToString$default;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public String getString(int i) {
        String string = this.strings.getString(i);
        Intrinsics.checkExpressionValueIsNotNull(string, "strings.getString(index)");
        return string;
    }

    @Override // kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver
    public boolean isLocalClassName(int i) {
        return traverseIds(i).getThird().booleanValue();
    }
}
