package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.FieldSet;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
/* loaded from: classes2.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {

    /* loaded from: classes2.dex */
    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageLiteOrBuilder {
    }

    public void makeExtensionsImmutable() {
    }

    /* loaded from: classes2.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        public final FieldSet<ExtensionDescriptor> extensions;

        /* loaded from: classes2.dex */
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

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        public ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(this, false, null);
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

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<MessageType extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            Object field = this.extensions.getField(generatedExtension.descriptor);
            if (field == null) {
                return generatedExtension.defaultValue;
            }
            return (Type) generatedExtension.fromFieldSetType(field);
        }

        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.getRepeatedFieldCount(generatedExtension.descriptor);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$GeneratedExtension<MessageType extends kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            verifyExtensionContainingType(generatedExtension);
            return this.extensions.hasField(generatedExtension.descriptor);
        }

        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i) {
            verifyExtensionContainingType(generatedExtension);
            return (Type) generatedExtension.singularFromFieldSetType(this.extensions.getRepeatedField(generatedExtension.descriptor, i));
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public boolean parseUnknownField(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), codedInputStream, codedOutputStream, extensionRegistryLite, i);
        }
    }

    /* renamed from: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$1  reason: invalid class name */
    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> {
        public ByteString unknownFields = ByteString.EMPTY;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public abstract MessageType getDefaultInstanceForType();

        public abstract BuilderType mergeFrom(MessageType messagetype);

        public final ByteString getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public BuilderType mo2099clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public final BuilderType setUnknownFields(ByteString byteString) {
            this.unknownFields = byteString;
            return this;
        }
    }

    /* loaded from: classes2.dex */
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
                this.extensions = this.extensions.clone();
                this.extensionsIsMutable = true;
            }
        }

        public boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        public final void mergeExtensionFields(MessageType messagetype) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(messagetype.extensions);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    /* loaded from: classes2.dex */
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            return this.number - extensionDescriptor.number;
        }

        public Internal.EnumLiteMap<?> getEnumType() {
            return this.enumTypeMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return this.type.getJavaType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return this.type;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.number;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return this.isPacked;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.isRepeated;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
        }
    }

    /* loaded from: classes2.dex */
    public static class GeneratedExtension<ContainingType extends MessageLite, Type> {
        public final ContainingType containingTypeDefaultInstance;
        public final Type defaultValue;
        public final ExtensionDescriptor descriptor;
        public final Method enumValueOf;
        public final MessageLite messageDefaultInstance;
        public final Class singularType;

        public GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor, Class cls) {
            if (containingtype != null) {
                if (extensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messageLite == null) {
                    throw new IllegalArgumentException("Null messageDefaultInstance");
                }
                this.containingTypeDefaultInstance = containingtype;
                this.defaultValue = type;
                this.messageDefaultInstance = messageLite;
                this.descriptor = extensionDescriptor;
                this.singularType = cls;
                if (Internal.EnumLite.class.isAssignableFrom(cls)) {
                    this.enumValueOf = GeneratedMessageLite.getMethodOrDie(cls, "valueOf", Integer.TYPE);
                    return;
                } else {
                    this.enumValueOf = null;
                    return;
                }
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        public Object fromFieldSetType(Object obj) {
            if (this.descriptor.isRepeated()) {
                if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : (List) obj) {
                        arrayList.add(singularFromFieldSetType(obj2));
                    }
                    return arrayList;
                }
                return obj;
            }
            return singularFromFieldSetType(obj);
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

        public Object singularFromFieldSetType(Object obj) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                return GeneratedMessageLite.invokeOrDie(this.enumValueOf, null, (Integer) obj);
            }
            return obj;
        }

        public Object singularToFieldSetType(Object obj) {
            if (this.descriptor.getLiteJavaType() == WireFormat.JavaType.ENUM) {
                return Integer.valueOf(((Internal.EnumLite) obj).getNumber());
            }
            return obj;
        }
    }

    public GeneratedMessageLite() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
    public Parser<? extends MessageLite> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    public GeneratedMessageLite(Builder builder) {
    }

    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            String valueOf = String.valueOf(String.valueOf(cls.getName()));
            String valueOf2 = String.valueOf(String.valueOf(str));
            StringBuilder sb = new StringBuilder(valueOf.length() + 45 + valueOf2.length());
            sb.append("Generated message class \"");
            sb.append(valueOf);
            sb.append("\" missing method \"");
            sb.append(valueOf2);
            sb.append("\".");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, Class cls) {
        return new GeneratedExtension<>(containingtype, Collections.emptyList(), messageLite, new ExtensionDescriptor(enumLiteMap, i, fieldType, true, z), cls);
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i, WireFormat.FieldType fieldType, Class cls) {
        return new GeneratedExtension<>(containingtype, type, messageLite, new ExtensionDescriptor(enumLiteMap, i, fieldType, false, false), cls);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <MessageType extends MessageLite> boolean parseUnknownField(FieldSet<ExtensionDescriptor> fieldSet, MessageType messagetype, CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
        boolean z;
        boolean z2;
        Object build;
        MessageLite messageLite;
        int tagWireType = WireFormat.getTagWireType(i);
        GeneratedExtension findLiteExtensionByNumber = extensionRegistryLite.findLiteExtensionByNumber(messagetype, WireFormat.getTagFieldNumber(i));
        if (findLiteExtensionByNumber != null) {
            if (tagWireType == FieldSet.getWireFormatForFieldType(findLiteExtensionByNumber.descriptor.getLiteType(), false)) {
                z = false;
                z2 = false;
                if (z) {
                    return codedInputStream.skipField(i, codedOutputStream);
                }
                if (z2) {
                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                    if (findLiteExtensionByNumber.descriptor.getLiteType() == WireFormat.FieldType.ENUM) {
                        while (codedInputStream.getBytesUntilLimit() > 0) {
                            Object findValueByNumber = findLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(codedInputStream.readEnum());
                            if (findValueByNumber == null) {
                                return true;
                            }
                            fieldSet.addRepeatedField(findLiteExtensionByNumber.descriptor, findLiteExtensionByNumber.singularToFieldSetType(findValueByNumber));
                        }
                    } else {
                        while (codedInputStream.getBytesUntilLimit() > 0) {
                            fieldSet.addRepeatedField(findLiteExtensionByNumber.descriptor, FieldSet.readPrimitiveField(codedInputStream, findLiteExtensionByNumber.descriptor.getLiteType(), false));
                        }
                    }
                    codedInputStream.popLimit(pushLimit);
                } else {
                    int i2 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[findLiteExtensionByNumber.descriptor.getLiteJavaType().ordinal()];
                    if (i2 != 1) {
                        if (i2 != 2) {
                            build = FieldSet.readPrimitiveField(codedInputStream, findLiteExtensionByNumber.descriptor.getLiteType(), false);
                        } else {
                            int readEnum = codedInputStream.readEnum();
                            Object findValueByNumber2 = findLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(readEnum);
                            if (findValueByNumber2 == null) {
                                codedOutputStream.writeRawVarint32(i);
                                codedOutputStream.writeUInt32NoTag(readEnum);
                                return true;
                            }
                            build = findValueByNumber2;
                        }
                    } else {
                        MessageLite.Builder builder = null;
                        if (!findLiteExtensionByNumber.descriptor.isRepeated() && (messageLite = (MessageLite) fieldSet.getField(findLiteExtensionByNumber.descriptor)) != null) {
                            builder = messageLite.toBuilder();
                        }
                        if (builder == null) {
                            builder = findLiteExtensionByNumber.getMessageDefaultInstance().newBuilderForType();
                        }
                        if (findLiteExtensionByNumber.descriptor.getLiteType() == WireFormat.FieldType.GROUP) {
                            codedInputStream.readGroup(findLiteExtensionByNumber.getNumber(), builder, extensionRegistryLite);
                        } else {
                            codedInputStream.readMessage(builder, extensionRegistryLite);
                        }
                        build = builder.build();
                    }
                    if (findLiteExtensionByNumber.descriptor.isRepeated()) {
                        fieldSet.addRepeatedField(findLiteExtensionByNumber.descriptor, findLiteExtensionByNumber.singularToFieldSetType(build));
                    } else {
                        fieldSet.setField(findLiteExtensionByNumber.descriptor, findLiteExtensionByNumber.singularToFieldSetType(build));
                    }
                }
                return true;
            }
            ExtensionDescriptor extensionDescriptor = findLiteExtensionByNumber.descriptor;
            if (extensionDescriptor.isRepeated && extensionDescriptor.type.isPackable() && tagWireType == FieldSet.getWireFormatForFieldType(findLiteExtensionByNumber.descriptor.getLiteType(), true)) {
                z = false;
                z2 = true;
                if (z) {
                }
            }
        }
        z = true;
        z2 = false;
        if (z) {
        }
    }

    public boolean parseUnknownField(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
        return codedInputStream.skipField(i, codedOutputStream);
    }
}
