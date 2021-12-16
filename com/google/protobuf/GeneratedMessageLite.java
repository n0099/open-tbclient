package com.google.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes3.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.google.protobuf.GeneratedMessageLite$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-903908512, "Lcom/google/protobuf/GeneratedMessageLite$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-903908512, "Lcom/google/protobuf/GeneratedMessageLite$1;");
                    return;
                }
            }
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

    /* loaded from: classes3.dex */
    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageLiteOrBuilder {
        <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension);

        <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i2);

        <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension);

        <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension);
    }

    /* loaded from: classes3.dex */
    public static final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite<ExtensionDescriptor> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Internal.EnumLiteMap<?> enumTypeMap;
        public final boolean isPacked;
        public final boolean isRepeated;
        public final int number;
        public final WireFormat.FieldType type;

        public /* synthetic */ ExtensionDescriptor(Internal.EnumLiteMap enumLiteMap, int i2, WireFormat.FieldType fieldType, boolean z, boolean z2, AnonymousClass1 anonymousClass1) {
            this(enumLiteMap, i2, fieldType, z, z2);
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public Internal.EnumLiteMap<?> getEnumType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.enumTypeMap : (Internal.EnumLiteMap) invokeV.objValue;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.type.getJavaType() : (WireFormat.JavaType) invokeV.objValue;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.type : (WireFormat.FieldType) invokeV.objValue;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.number : invokeV.intValue;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, builder, messageLite)) == null) ? ((Builder) builder).mergeFrom((Builder) ((GeneratedMessageLite) messageLite)) : (MessageLite.Builder) invokeLL.objValue;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.isPacked : invokeV.booleanValue;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.isRepeated : invokeV.booleanValue;
        }

        public ExtensionDescriptor(Internal.EnumLiteMap<?> enumLiteMap, int i2, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enumLiteMap, Integer.valueOf(i2), fieldType, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.enumTypeMap = enumLiteMap;
            this.number = i2;
            this.type = fieldType;
            this.isRepeated = z;
            this.isPacked = z2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.lang.Comparable
        public int compareTo(ExtensionDescriptor extensionDescriptor) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, extensionDescriptor)) == null) ? this.number - extensionDescriptor.number : invokeL.intValue;
        }
    }

    /* loaded from: classes3.dex */
    public static final class GeneratedExtension<ContainingType extends MessageLite, Type> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ContainingType containingTypeDefaultInstance;
        public final Type defaultValue;
        public final ExtensionDescriptor descriptor;
        public final MessageLite messageDefaultInstance;

        public /* synthetic */ GeneratedExtension(MessageLite messageLite, Object obj, MessageLite messageLite2, ExtensionDescriptor extensionDescriptor, AnonymousClass1 anonymousClass1) {
            this(messageLite, obj, messageLite2, extensionDescriptor);
        }

        public ContainingType getContainingTypeDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.containingTypeDefaultInstance : (ContainingType) invokeV.objValue;
        }

        public MessageLite getMessageDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.messageDefaultInstance : (MessageLite) invokeV.objValue;
        }

        public int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.descriptor.getNumber() : invokeV.intValue;
        }

        public GeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, ExtensionDescriptor extensionDescriptor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {containingtype, type, messageLite, extensionDescriptor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
    }

    /* loaded from: classes3.dex */
    public static final class SerializedForm implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public byte[] asBytes;
        public String messageClassName;

        public SerializedForm(MessageLite messageLite) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {messageLite};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.messageClassName = messageLite.getClass().getName();
            this.asBytes = messageLite.toByteArray();
        }

        public Object readResolve() throws ObjectStreamException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    MessageLite.Builder builder = (MessageLite.Builder) Class.forName(this.messageClassName).getMethod("newBuilder", new Class[0]).invoke(null, new Object[0]);
                    builder.mergeFrom(this.asBytes);
                    return builder.buildPartial();
                } catch (InvalidProtocolBufferException e2) {
                    throw new RuntimeException("Unable to understand proto buffer", e2);
                } catch (ClassNotFoundException e3) {
                    throw new RuntimeException("Unable to find proto buffer class", e3);
                } catch (IllegalAccessException e4) {
                    throw new RuntimeException("Unable to call newBuilder method", e4);
                } catch (NoSuchMethodException e5) {
                    throw new RuntimeException("Unable to find newBuilder method", e5);
                } catch (InvocationTargetException e6) {
                    throw new RuntimeException("Error calling newBuilder", e6.getCause());
                }
            }
            return invokeV.objValue;
        }
    }

    public GeneratedMessageLite() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i2, WireFormat.FieldType fieldType, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{containingtype, messageLite, enumLiteMap, Integer.valueOf(i2), fieldType, Boolean.valueOf(z)})) == null) ? new GeneratedExtension<>(containingtype, Collections.emptyList(), messageLite, new ExtensionDescriptor(enumLiteMap, i2, fieldType, true, z, null), null) : (GeneratedExtension) invokeCommon.objValue;
    }

    public static <ContainingType extends MessageLite, Type> GeneratedExtension<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.EnumLiteMap<?> enumLiteMap, int i2, WireFormat.FieldType fieldType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{containingtype, type, messageLite, enumLiteMap, Integer.valueOf(i2), fieldType})) == null) ? new GeneratedExtension<>(containingtype, type, messageLite, new ExtensionDescriptor(enumLiteMap, i2, fieldType, false, false, null), null) : (GeneratedExtension) invokeCommon.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public Parser<? extends MessageLite> getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
        return (Parser) invokeV.objValue;
    }

    public void makeExtensionsImmutable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i2) throws IOException {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, codedInputStream, extensionRegistryLite, i2)) == null) ? codedInputStream.skipField(i2) : invokeLLI.booleanValue;
    }

    public Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new SerializedForm(this) : invokeV.objValue;
    }

    /* loaded from: classes3.dex */
    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage<MessageType>, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<MessageType, BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FieldSet<ExtensionDescriptor> extensions;
        public boolean extensionsIsMutable;

        public ExtendableBuilder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.extensions = FieldSet.emptySet();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FieldSet<ExtensionDescriptor> buildExtensions() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                this.extensions.makeImmutable();
                this.extensionsIsMutable = false;
                return this.extensions;
            }
            return (FieldSet) invokeV.objValue;
        }

        private void ensureExtensionsIsMutable() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.extensionsIsMutable) {
                return;
            }
            this.extensions = this.extensions.m107clone();
            this.extensionsIsMutable = true;
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, generatedExtension) == null) && generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public final <Type> BuilderType addExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, Type type) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, generatedExtension, type)) == null) {
                verifyExtensionContainingType(generatedExtension);
                ensureExtensionsIsMutable();
                this.extensions.addRepeatedField(generatedExtension.descriptor, type);
                return this;
            }
            return (BuilderType) invokeLL.objValue;
        }

        public final <Type> BuilderType clearExtension(GeneratedExtension<MessageType, ?> generatedExtension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, generatedExtension)) == null) {
                verifyExtensionContainingType(generatedExtension);
                ensureExtensionsIsMutable();
                this.extensions.clearField(generatedExtension.descriptor);
                return this;
            }
            return (BuilderType) invokeL.objValue;
        }

        public boolean extensionsAreInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.extensions.isInitialized() : invokeV.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.protobuf.GeneratedMessageLite$GeneratedExtension<MessageType extends com.google.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, generatedExtension)) == null) {
                verifyExtensionContainingType(generatedExtension);
                Type type = (Type) this.extensions.getField(generatedExtension.descriptor);
                return type == null ? (Type) generatedExtension.defaultValue : type;
            }
            return (Type) invokeL.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, generatedExtension)) == null) {
                verifyExtensionContainingType(generatedExtension);
                return this.extensions.getRepeatedFieldCount(generatedExtension.descriptor);
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.protobuf.GeneratedMessageLite$GeneratedExtension<MessageType extends com.google.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, generatedExtension)) == null) {
                verifyExtensionContainingType(generatedExtension);
                return this.extensions.hasField(generatedExtension.descriptor);
            }
            return invokeL.booleanValue;
        }

        public final void mergeExtensionFields(MessageType messagetype) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, messagetype) == null) {
                ensureExtensionsIsMutable();
                this.extensions.mergeFrom(messagetype.extensions);
            }
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.google.protobuf.MessageLite, com.google.protobuf.GeneratedMessageLite] */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i2) throws IOException {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048592, this, codedInputStream, extensionRegistryLite, i2)) == null) {
                ensureExtensionsIsMutable();
                return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, i2);
            }
            return invokeLLI.booleanValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.protobuf.GeneratedMessageLite$GeneratedExtension<MessageType extends com.google.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, Type> generatedExtension, Type type) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, generatedExtension, type)) == null) {
                verifyExtensionContainingType(generatedExtension);
                ensureExtensionsIsMutable();
                this.extensions.setField(generatedExtension.descriptor, type);
                return this;
            }
            return (BuilderType) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public BuilderType clear() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.extensions.clear();
                this.extensionsIsMutable = false;
                return (BuilderType) super.clear();
            }
            return (BuilderType) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, generatedExtension, i2)) == null) {
                verifyExtensionContainingType(generatedExtension);
                return (Type) this.extensions.getRepeatedField(generatedExtension.descriptor, i2);
            }
            return (Type) invokeLI.objValue;
        }

        public final <Type> BuilderType setExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i2, Type type) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048593, this, generatedExtension, i2, type)) == null) {
                verifyExtensionContainingType(generatedExtension);
                ensureExtensionsIsMutable();
                this.extensions.setRepeatedField(generatedExtension.descriptor, i2, type);
                return this;
            }
            return (BuilderType) invokeLIL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public BuilderType clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
            }
            return (BuilderType) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements ExtendableMessageOrBuilder<MessageType> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final FieldSet<ExtensionDescriptor> extensions;

        /* loaded from: classes3.dex */
        public class ExtensionWriter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final Iterator<Map.Entry<ExtensionDescriptor, Object>> iter;
            public final boolean messageSetWireFormat;
            public Map.Entry<ExtensionDescriptor, Object> next;
            public final /* synthetic */ ExtendableMessage this$0;

            public /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z, AnonymousClass1 anonymousClass1) {
                this(extendableMessage, z);
            }

            public void writeUntil(int i2, CodedOutputStream codedOutputStream) throws IOException {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeIL(1048576, this, i2, codedOutputStream) != null) {
                    return;
                }
                while (true) {
                    Map.Entry<ExtensionDescriptor, Object> entry = this.next;
                    if (entry == null || entry.getKey().getNumber() >= i2) {
                        return;
                    }
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
                }
            }

            public ExtensionWriter(ExtendableMessage extendableMessage, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {extendableMessage, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = extendableMessage;
                Iterator<Map.Entry<ExtensionDescriptor, Object>> it = this.this$0.extensions.iterator();
                this.iter = it;
                if (it.hasNext()) {
                    this.next = this.iter.next();
                }
                this.messageSetWireFormat = z;
            }
        }

        public ExtendableMessage() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.extensions = FieldSet.newFieldSet();
        }

        private void verifyExtensionContainingType(GeneratedExtension<MessageType, ?> generatedExtension) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(65539, this, generatedExtension) == null) && generatedExtension.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        public boolean extensionsAreInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.extensions.isInitialized() : invokeV.booleanValue;
        }

        public int extensionsSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.extensions.getSerializedSize() : invokeV.intValue;
        }

        public int extensionsSerializedSizeAsMessageSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.extensions.getMessageSetSerializedSize() : invokeV.intValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.protobuf.GeneratedMessageLite$GeneratedExtension<MessageType extends com.google.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, generatedExtension)) == null) {
                verifyExtensionContainingType(generatedExtension);
                Type type = (Type) this.extensions.getField(generatedExtension.descriptor);
                return type == null ? (Type) generatedExtension.defaultValue : type;
            }
            return (Type) invokeL.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, generatedExtension)) == null) {
                verifyExtensionContainingType(generatedExtension);
                return this.extensions.getRepeatedFieldCount(generatedExtension.descriptor);
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.protobuf.GeneratedMessageLite$GeneratedExtension<MessageType extends com.google.protobuf.GeneratedMessageLite$ExtendableMessage<MessageType>, Type> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, generatedExtension)) == null) {
                verifyExtensionContainingType(generatedExtension);
                return this.extensions.hasField(generatedExtension.descriptor);
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public void makeExtensionsImmutable() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.extensions.makeImmutable();
            }
        }

        public ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new ExtensionWriter(this, false, null) : (ExtensionWriter) invokeV.objValue;
        }

        public ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new ExtensionWriter(this, true, null) : (ExtensionWriter) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i2) throws IOException {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048586, this, codedInputStream, extensionRegistryLite, i2)) == null) ? GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, i2) : invokeLLI.booleanValue;
        }

        public ExtendableMessage(ExtendableBuilder<MessageType, ?> extendableBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {extendableBuilder};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.extensions = extendableBuilder.buildExtensions();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, generatedExtension, i2)) == null) {
                verifyExtensionContainingType(generatedExtension);
                return (Type) this.extensions.getRepeatedField(generatedExtension.descriptor, i2);
            }
            return (Type) invokeLI.objValue;
        }
    }

    public GeneratedMessageLite(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <MessageType extends MessageLite> boolean parseUnknownField(FieldSet<ExtensionDescriptor> fieldSet, MessageType messagetype, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i2) throws IOException {
        InterceptResult invokeCommon;
        boolean z;
        Object build;
        MessageLite messageLite;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{fieldSet, messagetype, codedInputStream, extensionRegistryLite, Integer.valueOf(i2)})) != null) {
            return invokeCommon.booleanValue;
        }
        int tagWireType = WireFormat.getTagWireType(i2);
        GeneratedExtension findLiteExtensionByNumber = extensionRegistryLite.findLiteExtensionByNumber(messagetype, WireFormat.getTagFieldNumber(i2));
        boolean z2 = false;
        if (findLiteExtensionByNumber != null) {
            if (tagWireType == FieldSet.getWireFormatForFieldType(findLiteExtensionByNumber.descriptor.getLiteType(), false)) {
                z = false;
            } else if (findLiteExtensionByNumber.descriptor.isRepeated && findLiteExtensionByNumber.descriptor.type.isPackable() && tagWireType == FieldSet.getWireFormatForFieldType(findLiteExtensionByNumber.descriptor.getLiteType(), true)) {
                z = true;
            }
            if (z2) {
                if (!z) {
                    int i3 = AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[findLiteExtensionByNumber.descriptor.getLiteJavaType().ordinal()];
                    if (i3 == 1) {
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
                    } else if (i3 != 2) {
                        build = FieldSet.readPrimitiveField(codedInputStream, findLiteExtensionByNumber.descriptor.getLiteType());
                    } else {
                        build = findLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(codedInputStream.readEnum());
                        if (build == null) {
                            return true;
                        }
                    }
                    if (findLiteExtensionByNumber.descriptor.isRepeated()) {
                        fieldSet.addRepeatedField(findLiteExtensionByNumber.descriptor, build);
                    } else {
                        fieldSet.setField(findLiteExtensionByNumber.descriptor, build);
                    }
                } else {
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
                }
                return true;
            }
            return codedInputStream.skipField(i2);
        }
        z = false;
        z2 = true;
        if (z2) {
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class Builder<MessageType extends GeneratedMessageLite, BuilderType extends Builder> extends AbstractMessageLite.Builder<BuilderType> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType clear() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (BuilderType) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public abstract MessageType getDefaultInstanceForType();

        public abstract BuilderType mergeFrom(MessageType messagetype);

        public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i2) throws IOException {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, codedInputStream, extensionRegistryLite, i2)) == null) ? codedInputStream.skipField(i2) : invokeLLI.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public BuilderType clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
            }
            return (BuilderType) invokeV.objValue;
        }
    }
}
