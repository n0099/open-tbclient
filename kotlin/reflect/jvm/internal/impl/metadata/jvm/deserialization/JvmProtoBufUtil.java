package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoBufUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
/* loaded from: classes2.dex */
public final class JvmProtoBufUtil {
    public static final ExtensionRegistryLite EXTENSION_REGISTRY;
    public static final JvmProtoBufUtil INSTANCE = new JvmProtoBufUtil();

    static {
        ExtensionRegistryLite newInstance = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(newInstance);
        Intrinsics.checkExpressionValueIsNotNull(newInstance, "ExtensionRegistryLite.ne…f::registerAllExtensions)");
        EXTENSION_REGISTRY = newInstance;
    }

    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return EXTENSION_REGISTRY;
    }

    public static /* synthetic */ JvmMemberSignature.Field getJvmFieldSignature$default(JvmProtoBufUtil jvmProtoBufUtil, ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = true;
        }
        return jvmProtoBufUtil.getJvmFieldSignature(property, nameResolver, typeTable, z);
    }

    @JvmStatic
    public static final boolean isMovedFromInterfaceCompanion(ProtoBuf.Property property) {
        Flags.BooleanFlagField is_moved_from_interface_companion = JvmFlags.INSTANCE.getIS_MOVED_FROM_INTERFACE_COMPANION();
        Object extension = property.getExtension(JvmProtoBuf.flags);
        Intrinsics.checkExpressionValueIsNotNull(extension, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean bool = is_moved_from_interface_companion.get(((Number) extension).intValue());
        Intrinsics.checkExpressionValueIsNotNull(bool, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
        return bool.booleanValue();
    }

    private final String mapTypeDefault(ProtoBuf.Type type, NameResolver nameResolver) {
        if (type.hasClassName()) {
            return ClassMapperLite.mapClass(nameResolver.getQualifiedClassName(type.getClassName()));
        }
        return null;
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(byte[] bArr, String[] strArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strArr), ProtoBuf.Class.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Function> readFunctionDataFrom(String[] strArr, String[] strArr2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(BitEncoding.decodeBytes(strArr));
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strArr2), ProtoBuf.Function.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    private final JvmNameResolver readNameResolver(InputStream inputStream, String[] strArr) {
        JvmProtoBuf.StringTableTypes parseDelimitedFrom = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(inputStream, EXTENSION_REGISTRY);
        Intrinsics.checkExpressionValueIsNotNull(parseDelimitedFrom, "JvmProtoBuf.StringTableT…this, EXTENSION_REGISTRY)");
        return new JvmNameResolver(parseDelimitedFrom, strArr);
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(byte[] bArr, String[] strArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(INSTANCE.readNameResolver(byteArrayInputStream, strArr), ProtoBuf.Package.parseFrom(byteArrayInputStream, EXTENSION_REGISTRY));
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Class> readClassDataFrom(String[] strArr, String[] strArr2) {
        byte[] decodeBytes = BitEncoding.decodeBytes(strArr);
        Intrinsics.checkExpressionValueIsNotNull(decodeBytes, "BitEncoding.decodeBytes(data)");
        return readClassDataFrom(decodeBytes, strArr2);
    }

    @JvmStatic
    public static final Pair<JvmNameResolver, ProtoBuf.Package> readPackageDataFrom(String[] strArr, String[] strArr2) {
        byte[] decodeBytes = BitEncoding.decodeBytes(strArr);
        Intrinsics.checkExpressionValueIsNotNull(decodeBytes, "BitEncoding.decodeBytes(data)");
        return readPackageDataFrom(decodeBytes, strArr2);
    }

    public final JvmMemberSignature.Method getJvmConstructorSignature(ProtoBuf.Constructor constructor, NameResolver nameResolver, TypeTable typeTable) {
        String str;
        String joinToString$default;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmProtoBuf.JvmMethodSignature> generatedExtension = JvmProtoBuf.constructorSignature;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension, "JvmProtoBuf.constructorSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(constructor, generatedExtension);
        if (jvmMethodSignature != null && jvmMethodSignature.hasName()) {
            str = nameResolver.getString(jvmMethodSignature.getName());
        } else {
            str = "<init>";
        }
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            joinToString$default = nameResolver.getString(jvmMethodSignature.getDesc());
        } else {
            List<ProtoBuf.ValueParameter> valueParameterList = constructor.getValueParameterList();
            Intrinsics.checkExpressionValueIsNotNull(valueParameterList, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(valueParameterList, 10));
            for (ProtoBuf.ValueParameter it : valueParameterList) {
                JvmProtoBufUtil jvmProtoBufUtil = INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                String mapTypeDefault = jvmProtoBufUtil.mapTypeDefault(ProtoTypeTableUtilKt.type(it, typeTable), nameResolver);
                if (mapTypeDefault != null) {
                    arrayList.add(mapTypeDefault);
                } else {
                    return null;
                }
            }
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, "", "(", ")V", 0, null, null, 56, null);
        }
        return new JvmMemberSignature.Method(str, joinToString$default);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x004b, code lost:
        if (r4 != null) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JvmMemberSignature.Field getJvmFieldSignature(ProtoBuf.Property property, NameResolver nameResolver, TypeTable typeTable, boolean z) {
        JvmProtoBuf.JvmFieldSignature jvmFieldSignature;
        int name;
        String mapTypeDefault;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> generatedExtension = JvmProtoBuf.propertySignature;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension, "JvmProtoBuf.propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) ProtoBufUtilKt.getExtensionOrNull(property, generatedExtension);
        if (jvmPropertySignature != null) {
            if (jvmPropertySignature.hasField()) {
                jvmFieldSignature = jvmPropertySignature.getField();
            } else {
                jvmFieldSignature = null;
            }
            if (jvmFieldSignature == null && z) {
                return null;
            }
            if (jvmFieldSignature != null && jvmFieldSignature.hasName()) {
                name = jvmFieldSignature.getName();
            } else {
                name = property.getName();
            }
            if (jvmFieldSignature != null && jvmFieldSignature.hasDesc()) {
                mapTypeDefault = nameResolver.getString(jvmFieldSignature.getDesc());
            } else {
                mapTypeDefault = mapTypeDefault(ProtoTypeTableUtilKt.returnType(property, typeTable), nameResolver);
            }
            return new JvmMemberSignature.Field(nameResolver.getString(name), mapTypeDefault);
        }
        return null;
    }

    public final JvmMemberSignature.Method getJvmMethodSignature(ProtoBuf.Function function, NameResolver nameResolver, TypeTable typeTable) {
        int name;
        String str;
        GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmProtoBuf.JvmMethodSignature> generatedExtension = JvmProtoBuf.methodSignature;
        Intrinsics.checkExpressionValueIsNotNull(generatedExtension, "JvmProtoBuf.methodSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) ProtoBufUtilKt.getExtensionOrNull(function, generatedExtension);
        if (jvmMethodSignature != null && jvmMethodSignature.hasName()) {
            name = jvmMethodSignature.getName();
        } else {
            name = function.getName();
        }
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            str = nameResolver.getString(jvmMethodSignature.getDesc());
        } else {
            List listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(ProtoTypeTableUtilKt.receiverType(function, typeTable));
            List<ProtoBuf.ValueParameter> valueParameterList = function.getValueParameterList();
            Intrinsics.checkExpressionValueIsNotNull(valueParameterList, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(valueParameterList, 10));
            for (ProtoBuf.ValueParameter it : valueParameterList) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                arrayList.add(ProtoTypeTableUtilKt.type(it, typeTable));
            }
            List<ProtoBuf.Type> plus = CollectionsKt___CollectionsKt.plus((Collection) listOfNotNull, (Iterable) arrayList);
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(plus, 10));
            for (ProtoBuf.Type type : plus) {
                String mapTypeDefault = INSTANCE.mapTypeDefault(type, nameResolver);
                if (mapTypeDefault == null) {
                    return null;
                }
                arrayList2.add(mapTypeDefault);
            }
            String mapTypeDefault2 = mapTypeDefault(ProtoTypeTableUtilKt.returnType(function, typeTable), nameResolver);
            if (mapTypeDefault2 == null) {
                return null;
            }
            str = CollectionsKt___CollectionsKt.joinToString$default(arrayList2, "", "(", SmallTailInfo.EMOTION_SUFFIX, 0, null, null, 56, null) + mapTypeDefault2;
        }
        return new JvmMemberSignature.Method(nameResolver.getString(name), str);
    }
}
