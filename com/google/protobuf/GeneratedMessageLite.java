package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes9.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {
    public static final long serialVersionUID = 1;

    /* loaded from: classes9.dex */
    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageLiteOrBuilder {
        <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension);

        <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i);

        <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension);

        <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension);
    }

    public void makeExtensionsImmutable() {
    }

    /* loaded from: classes9.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        public final FieldSet<ExtensionDescriptor> extensions;

        /* loaded from: classes9.dex */
        public class ExtensionWriter {
            public final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            public final boolean messageSetWireFormat;
            public Map.Entry<ExtensionDescriptor, Object> next;

            public ExtensionWriter(boolean z) {
                Iterator<Map.Entry<ExtensionDescriptor, Object>> it = ExtendableMessage.this.extensions.iterator();
                this.iter = it;
                if (it.hasNext()) {
                    this.next = this.iter.next();
                }
                this.messageSetWireFormat = z;
            }

            public /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z, AnonymousClass1 anonymousClass1) {
                this(z);
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<ExtensionDescriptor, Object> entry = this.next;
                    if (entry != null && entry.getKey().getNumber() < i) {
                        ExtensionDescriptor key = this.next.getKey();
                        if (this.messageSetWireFormat && key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated()) {
                            codedOutputStream.writeMessageSetExtension(key.getNumber(), (MessageLite) this.next.getValue());
                        } else {
                            FieldSet.writeField(key, this.next.getValue(), codedOutputStream);
                        }
                        if (this.iter.hasNext()) {
                            this.next = this.iter.next();
                        } else {
                            this.next = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        public int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        public ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
        }

        public ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(this, true, null);
        }

        public ExtendableMessage(ExtendableBuilder<MessageType, ?> extendableBuilder) {
            this.extensions = extendableBuilder.buildExtensions();
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() == getDefaultInstanceForType()) {
                return;
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.protobuf.GeneratedMessageLite$GeneratedExtension<MessageType extends com.google.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Type type = (Type) this.extensions.getField(generatedExtension.descriptor);
            if (type != null) {
                return type;
            }
            return (Type) generatedExtension.defaultValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedFieldCount(generatedExtension.descriptor);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.protobuf.GeneratedMessageLite$GeneratedExtension<MessageType extends com.google.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(generatedExtension.descriptor);
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return (Type) this.extensions.getRepeatedField(generatedExtension.descriptor, i);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, i);
        }
    }

    /* renamed from: com.google.protobuf.GeneratedMessageLite$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

        static {
            int[] iArr = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = iArr;
            try {
                iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        public FieldSet<ExtensionDescriptor> extensions = FieldSet.emptySet();
        public boolean extensionsIsMutable;

        /* JADX INFO: Access modifiers changed from: private */
        public FieldSet<ExtensionDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            this.extensionsIsMutable = false;
            return this.extensions;
        }

        private void ensureExtensionsIsMutable() {
            if (!this.extensionsIsMutable) {
                this.extensions = this.extensions.m165clone();
                this.extensionsIsMutable = true;
            }
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            if (generatedExtension.getContainingTypeDefaultInstance() == getDefaultInstanceForType()) {
                return;
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        public final <Type> BuilderType clearExtension(GeneratedExtension<MessageType, ?> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.clearField(generatedExtension.descriptor);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.protobuf.GeneratedMessageLite$GeneratedExtension<MessageType extends com.google.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Type type = (Type) this.extensions.getField(generatedExtension.descriptor);
            if (type != null) {
                return type;
            }
            return (Type) generatedExtension.defaultValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedFieldCount(generatedExtension.descriptor);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.protobuf.GeneratedMessageLite$GeneratedExtension<MessageType extends com.google.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(generatedExtension.descriptor);
        }

        public final void mergeExtensionFields(MessageType messagetype) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(messagetype.extensions);
        }

        public final <Type> BuilderType addExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, Type type) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(generatedExtension.descriptor, type);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return (Type) this.extensions.getRepeatedField(generatedExtension.descriptor, i);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.protobuf.GeneratedMessageLite$GeneratedExtension<MessageType extends com.google.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, Type> generatedExtension, Type type) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.setField(generatedExtension.descriptor, type);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public BuilderType clear() {
            this.extensions.clear();
            this.extensionsIsMutable = false;
            return (BuilderType) super.clear();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public BuilderType mo43clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.protobuf.MessageLite, com.google.protobuf.GeneratedMessageLite] */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            ensureExtensionsIsMutable();
            return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, i);
        }

        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i, Type type) {
            verifyExtensionContainingType(generatedExtension);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(generatedExtension.descriptor, i, type);
            return this;
        }
    }

    /* loaded from: classes9.dex */
    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        public final Internal.EnumLiteMap<?> enumTypeMap;
        public final boolean isPacked;
        public final boolean isRepeated;
        public final int number;
        public final WireFormat.FieldType type;

        public ExtensionDescriptor(Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            this.enumTypeMap = enumLiteMap;
            this.number = i;
            this.type = fieldType;
            this.isRepeated = z;
            this.isPacked = z2;
        }

        public /* synthetic */ ExtensionDescriptor(Internal.EnumLiteMap enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2, AnonymousClass1 anonymousClass1) {
            this(enumLiteMap, i, fieldType, z, z2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.number - extensionDescriptor.number;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.number;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((Builder) ((GeneratedMessageLite) messageLite));
        }
    }

    /* loaded from: classes9.dex */
    public static final class GeneratedExtension<ContainingType extends MessageLite, Type> {
        public final ContainingType containingTypeDefaultInstance;
        public final Type defaultValue;
        public final ExtensionDescriptor descriptor;
        public final MessageLite messageDefaultInstance;

        public GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor) {
            if (containingtype != null) {
                if (extensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messageLite == null) {
                    throw new IllegalArgumentException("Null messageDefaultInstance");
                }
                this.containingTypeDefaultInstance = containingtype;
                this.defaultValue = type;
                this.messageDefaultInstance = messageLite;
                this.descriptor = extensionDescriptor;
                return;
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        public /* synthetic */ GeneratedExtension(MessageLite messageLite, Object obj, MessageLite messageLite2, ExtensionDescriptor extensionDescriptor, AnonymousClass1 anonymousClass1) {
            this(messageLite, obj, messageLite2, extensionDescriptor);
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.containingTypeDefaultInstance;
        }

        public MessageLite getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        public int getNumber() {
            return this.descriptor.getNumber();
        }
    }

    /* loaded from: classes9.dex */
    public static final class SerializedForm implements Serializable {
        public static final long serialVersionUID = 0;
        public byte[] asBytes;
        public String messageClassName;

        public SerializedForm(MessageLite messageLite) {
            this.messageClassName = messageLite.getClass().getName();
            this.asBytes = messageLite.toByteArray();
        }

        public Object readResolve() throws ObjectStreamException {
            try {
                MessageLite.Builder builder = (MessageLite.Builder) Class.forName(this.messageClassName).getMethod("newBuilder", new Class[0]).invoke(null, new Object[0]);
                builder.mergeFrom(this.asBytes);
                return builder.buildPartial();
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException("Unable to understand proto buffer", e);
            } catch (ClassNotFoundException e2) {
                throw new RuntimeException("Unable to find proto buffer class", e2);
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Unable to call newBuilder method", e3);
            } catch (NoSuchMethodException e4) {
                throw new RuntimeException("Unable to find newBuilder method", e4);
            } catch (InvocationTargetException e5) {
                throw new RuntimeException("Error calling newBuilder", e5.getCause());
            }
        }
    }

    public GeneratedMessageLite() {
    }

    @Override // com.google.protobuf.MessageLite
    public Parser<? extends MessageLite> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public Object writeReplace() throws ObjectStreamException {
        return new SerializedForm(this);
    }

    /* loaded from: classes9.dex */
    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType clear() {
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public abstract MessageType getDefaultInstanceForType();

        public abstract BuilderType mergeFrom(MessageType messagetype);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public BuilderType mo43clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            return codedInputStream.skipField(i);
        }
    }

    public GeneratedMessageLite(Builder builder) {
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z) {
        return new GeneratedExtension<>(containingtype, Collections.emptyList(), messageLite, new ExtensionDescriptor(enumLiteMap, i, fieldType, true, z, null), null);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType) {
        return new GeneratedExtension<>(containingtype, type, messageLite, new ExtensionDescriptor(enumLiteMap, i, fieldType, false, false, null), null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <MessageType extends MessageLite> boolean parseUnknownField(FieldSet<ExtensionDescriptor> fieldSet, MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
        boolean z;
        Object build;
        MessageLite messageLite;
        int tagWireType = WireFormat.getTagWireType(i);
        GeneratedExtension findLiteExtensionByNumber = extensionRegistryLite.findLiteExtensionByNumber(messagetype, WireFormat.getTagFieldNumber(i));
        boolean z2 = false;
        if (findLiteExtensionByNumber != null) {
            if (tagWireType == FieldSet.getWireFormatForFieldType(findLiteExtensionByNumber.descriptor.getLiteType(), false)) {
                z = false;
            } else if (findLiteExtensionByNumber.descriptor.isRepeated && findLiteExtensionByNumber.descriptor.type.isPackable() && tagWireType == FieldSet.getWireFormatForFieldType(findLiteExtensionByNumber.descriptor.getLiteType(), true)) {
                z = true;
            }
            if (!z2) {
                return codedInputStream.skipField(i);
            }
            if (z) {
                int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                if (findLiteExtensionByNumber.descriptor.getLiteType() == WireFormat.FieldType.ENUM) {
                    while (codedInputStream.getBytesUntilLimit() > 0) {
                        Object findValueByNumber = findLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(codedInputStream.readEnum());
                        if (findValueByNumber == null) {
                            return true;
                        }
                        fieldSet.addRepeatedField(findLiteExtensionByNumber.descriptor, findValueByNumber);
                    }
                } else {
                    while (codedInputStream.getBytesUntilLimit() > 0) {
                        fieldSet.addRepeatedField(findLiteExtensionByNumber.descriptor, FieldSet.readPrimitiveField(codedInputStream, findLiteExtensionByNumber.descriptor.getLiteType()));
                    }
                }
                codedInputStream.popLimit(pushLimit);
            } else {
                int i2 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[findLiteExtensionByNumber.descriptor.getLiteJavaType().ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        build = FieldSet.readPrimitiveField(codedInputStream, findLiteExtensionByNumber.descriptor.getLiteType());
                    } else {
                        build = findLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(codedInputStream.readEnum());
                        if (build == null) {
                            return true;
                        }
                    }
                } else {
                    MessageLite.Builder builder = null;
                    if (!findLiteExtensionByNumber.descriptor.isRepeated() && (messageLite = (MessageLite) fieldSet.getField(findLiteExtensionByNumber.descriptor)) != null) {
                        builder = messageLite.toBuilder();
                    }
                    if (builder == null) {
                        builder = findLiteExtensionByNumber.messageDefaultInstance.newBuilderForType();
                    }
                    if (findLiteExtensionByNumber.descriptor.getLiteType() == WireFormat.FieldType.GROUP) {
                        codedInputStream.readGroup(findLiteExtensionByNumber.getNumber(), builder, extensionRegistryLite);
                    } else {
                        codedInputStream.readMessage(builder, extensionRegistryLite);
                    }
                    build = builder.build();
                }
                if (findLiteExtensionByNumber.descriptor.isRepeated()) {
                    fieldSet.addRepeatedField(findLiteExtensionByNumber.descriptor, build);
                } else {
                    fieldSet.setField(findLiteExtensionByNumber.descriptor, build);
                }
            }
            return true;
        }
        z = false;
        z2 = true;
        if (!z2) {
        }
    }

    public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
        return codedInputStream.skipField(i);
    }
}
