package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.TypeTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionRequirementTable;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.VersionSpecificBehaviorKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.text.Typography;
/* loaded from: classes9.dex */
public final class DeserializationContext {
    public final DeserializationComponents components;
    public final DeserializedContainerSource containerSource;
    public final DeclarationDescriptor containingDeclaration;
    public final MemberDeserializer memberDeserializer;
    public final BinaryVersion metadataVersion;
    public final NameResolver nameResolver;
    public final TypeDeserializer typeDeserializer;
    public final TypeTable typeTable;
    public final VersionRequirementTable versionRequirementTable;

    public DeserializationContext(DeserializationComponents deserializationComponents, NameResolver nameResolver, DeclarationDescriptor declarationDescriptor, TypeTable typeTable, VersionRequirementTable versionRequirementTable, BinaryVersion binaryVersion, DeserializedContainerSource deserializedContainerSource, TypeDeserializer typeDeserializer, List<ProtoBuf.TypeParameter> list) {
        this.components = deserializationComponents;
        this.nameResolver = nameResolver;
        this.containingDeclaration = declarationDescriptor;
        this.typeTable = typeTable;
        this.versionRequirementTable = versionRequirementTable;
        this.metadataVersion = binaryVersion;
        this.containerSource = deserializedContainerSource;
        String str = "Deserializer for \"" + this.containingDeclaration.getName() + Typography.quote;
        DeserializedContainerSource deserializedContainerSource2 = this.containerSource;
        this.typeDeserializer = new TypeDeserializer(this, typeDeserializer, list, str, (deserializedContainerSource2 == null || (r0 = deserializedContainerSource2.getPresentableString()) == null) ? "[container not found]" : "[container not found]", false, 32, null);
        this.memberDeserializer = new MemberDeserializer(this);
    }

    public static /* synthetic */ DeserializationContext childContext$default(DeserializationContext deserializationContext, DeclarationDescriptor declarationDescriptor, List list, NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, BinaryVersion binaryVersion, int i, Object obj) {
        if ((i & 4) != 0) {
            nameResolver = deserializationContext.nameResolver;
        }
        NameResolver nameResolver2 = nameResolver;
        if ((i & 8) != 0) {
            typeTable = deserializationContext.typeTable;
        }
        TypeTable typeTable2 = typeTable;
        if ((i & 16) != 0) {
            versionRequirementTable = deserializationContext.versionRequirementTable;
        }
        VersionRequirementTable versionRequirementTable2 = versionRequirementTable;
        if ((i & 32) != 0) {
            binaryVersion = deserializationContext.metadataVersion;
        }
        return deserializationContext.childContext(declarationDescriptor, list, nameResolver2, typeTable2, versionRequirementTable2, binaryVersion);
    }

    public final DeserializationContext childContext(DeclarationDescriptor declarationDescriptor, List<ProtoBuf.TypeParameter> list, NameResolver nameResolver, TypeTable typeTable, VersionRequirementTable versionRequirementTable, BinaryVersion binaryVersion) {
        VersionRequirementTable versionRequirementTable2;
        DeserializationComponents deserializationComponents = this.components;
        if (VersionSpecificBehaviorKt.isVersionRequirementTableWrittenCorrectly(binaryVersion)) {
            versionRequirementTable2 = versionRequirementTable;
        } else {
            versionRequirementTable2 = this.versionRequirementTable;
        }
        return new DeserializationContext(deserializationComponents, nameResolver, declarationDescriptor, typeTable, versionRequirementTable2, binaryVersion, this.containerSource, this.typeDeserializer, list);
    }

    public final DeserializationComponents getComponents() {
        return this.components;
    }

    public final DeserializedContainerSource getContainerSource() {
        return this.containerSource;
    }

    public final DeclarationDescriptor getContainingDeclaration() {
        return this.containingDeclaration;
    }

    public final MemberDeserializer getMemberDeserializer() {
        return this.memberDeserializer;
    }

    public final NameResolver getNameResolver() {
        return this.nameResolver;
    }

    public final StorageManager getStorageManager() {
        return this.components.getStorageManager();
    }

    public final TypeDeserializer getTypeDeserializer() {
        return this.typeDeserializer;
    }

    public final TypeTable getTypeTable() {
        return this.typeTable;
    }

    public final VersionRequirementTable getVersionRequirementTable() {
        return this.versionRequirementTable;
    }
}
