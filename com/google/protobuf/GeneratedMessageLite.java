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
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface ExtendableMessageOrBuilder extends MessageLiteOrBuilder {
        Object getExtension(GeneratedExtension generatedExtension);

        Object getExtension(GeneratedExtension generatedExtension, int i);

        int getExtensionCount(GeneratedExtension generatedExtension);

        boolean hasExtension(GeneratedExtension generatedExtension);
    }

    public void makeExtensionsImmutable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    /* loaded from: classes7.dex */
    public abstract class ExtendableMessage extends GeneratedMessageLite implements ExtendableMessageOrBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final FieldSet extensions;

        /* loaded from: classes7.dex */
        public class ExtensionWriter {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final Iterator iter;
            public final boolean messageSetWireFormat;
            public Map.Entry next;
            public final /* synthetic */ ExtendableMessage this$0;

            public ExtensionWriter(ExtendableMessage extendableMessage, boolean z) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {extendableMessage, Boolean.valueOf(z)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = extendableMessage;
                Iterator it = this.this$0.extensions.iterator();
                this.iter = it;
                if (it.hasNext()) {
                    this.next = (Map.Entry) this.iter.next();
                }
                this.messageSetWireFormat = z;
            }

            public /* synthetic */ ExtensionWriter(ExtendableMessage extendableMessage, boolean z, AnonymousClass1 anonymousClass1) {
                this(extendableMessage, z);
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeIL(1048576, this, i, codedOutputStream) != null) {
                    return;
                }
                while (true) {
                    Map.Entry entry = this.next;
                    if (entry != null && ((ExtensionDescriptor) entry.getKey()).getNumber() < i) {
                        ExtensionDescriptor extensionDescriptor = (ExtensionDescriptor) this.next.getKey();
                        if (this.messageSetWireFormat && extensionDescriptor.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !extensionDescriptor.isRepeated()) {
                            codedOutputStream.writeMessageSetExtension(extensionDescriptor.getNumber(), (MessageLite) this.next.getValue());
                        } else {
                            FieldSet.writeField(extensionDescriptor, this.next.getValue(), codedOutputStream);
                        }
                        if (this.iter.hasNext()) {
                            this.next = (Map.Entry) this.iter.next();
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
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.extensions = FieldSet.newFieldSet();
        }

        public boolean extensionsAreInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.extensions.isInitialized();
            }
            return invokeV.booleanValue;
        }

        public int extensionsSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.extensions.getSerializedSize();
            }
            return invokeV.intValue;
        }

        public int extensionsSerializedSizeAsMessageSet() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.extensions.getMessageSetSerializedSize();
            }
            return invokeV.intValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public void makeExtensionsImmutable() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                this.extensions.makeImmutable();
            }
        }

        public ExtensionWriter newExtensionWriter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return new ExtensionWriter(this, false, null);
            }
            return (ExtensionWriter) invokeV.objValue;
        }

        public ExtensionWriter newMessageSetExtensionWriter() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return new ExtensionWriter(this, true, null);
            }
            return (ExtensionWriter) invokeV.objValue;
        }

        public ExtendableMessage(ExtendableBuilder extendableBuilder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {extendableBuilder};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.extensions = extendableBuilder.buildExtensions();
        }

        private void verifyExtensionContainingType(GeneratedExtension generatedExtension) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(65539, this, generatedExtension) != null) || generatedExtension.getContainingTypeDefaultInstance() == getDefaultInstanceForType()) {
                return;
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final Object getExtension(GeneratedExtension generatedExtension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, generatedExtension)) == null) {
                verifyExtensionContainingType(generatedExtension);
                Object field = this.extensions.getField(generatedExtension.descriptor);
                if (field == null) {
                    return generatedExtension.defaultValue;
                }
                return field;
            }
            return invokeL.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final int getExtensionCount(GeneratedExtension generatedExtension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, generatedExtension)) == null) {
                verifyExtensionContainingType(generatedExtension);
                return this.extensions.getRepeatedFieldCount(generatedExtension.descriptor);
            }
            return invokeL.intValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final boolean hasExtension(GeneratedExtension generatedExtension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, generatedExtension)) == null) {
                verifyExtensionContainingType(generatedExtension);
                return this.extensions.hasField(generatedExtension.descriptor);
            }
            return invokeL.booleanValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final Object getExtension(GeneratedExtension generatedExtension, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, generatedExtension, i)) == null) {
                verifyExtensionContainingType(generatedExtension);
                return this.extensions.getRepeatedField(generatedExtension.descriptor, i);
            }
            return invokeLI.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048586, this, codedInputStream, extensionRegistryLite, i)) == null) {
                return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, i);
            }
            return invokeLLI.booleanValue;
        }
    }

    /* renamed from: com.google.protobuf.GeneratedMessageLite$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
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

    /* loaded from: classes7.dex */
    public abstract class Builder extends AbstractMessageLite.Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        public Builder clear() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (Builder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public abstract GeneratedMessageLite getDefaultInstanceForType();

        public abstract Builder mergeFrom(GeneratedMessageLite generatedMessageLite);

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public Builder clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
            }
            return (Builder) invokeV.objValue;
        }

        public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048585, this, codedInputStream, extensionRegistryLite, i)) == null) {
                return codedInputStream.skipField(i);
            }
            return invokeLLI.booleanValue;
        }
    }

    /* loaded from: classes7.dex */
    public abstract class ExtendableBuilder extends Builder implements ExtendableMessageOrBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public FieldSet extensions;
        public boolean extensionsIsMutable;

        public ExtendableBuilder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.extensions = FieldSet.emptySet();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public FieldSet buildExtensions() {
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
            if ((interceptable == null || interceptable.invokeV(65539, this) == null) && !this.extensionsIsMutable) {
                this.extensions = this.extensions.m78clone();
                this.extensionsIsMutable = true;
            }
        }

        public boolean extensionsAreInitialized() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.extensions.isInitialized();
            }
            return invokeV.booleanValue;
        }

        private void verifyExtensionContainingType(GeneratedExtension generatedExtension) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, generatedExtension) != null) || generatedExtension.getContainingTypeDefaultInstance() == getDefaultInstanceForType()) {
                return;
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }

        public final ExtendableBuilder clearExtension(GeneratedExtension generatedExtension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, generatedExtension)) == null) {
                verifyExtensionContainingType(generatedExtension);
                ensureExtensionsIsMutable();
                this.extensions.clearField(generatedExtension.descriptor);
                return this;
            }
            return (ExtendableBuilder) invokeL.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final Object getExtension(GeneratedExtension generatedExtension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, generatedExtension)) == null) {
                verifyExtensionContainingType(generatedExtension);
                Object field = this.extensions.getField(generatedExtension.descriptor);
                if (field != null) {
                    return field;
                }
                return generatedExtension.defaultValue;
            }
            return invokeL.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final int getExtensionCount(GeneratedExtension generatedExtension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, generatedExtension)) == null) {
                verifyExtensionContainingType(generatedExtension);
                return this.extensions.getRepeatedFieldCount(generatedExtension.descriptor);
            }
            return invokeL.intValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final boolean hasExtension(GeneratedExtension generatedExtension) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, generatedExtension)) == null) {
                verifyExtensionContainingType(generatedExtension);
                return this.extensions.hasField(generatedExtension.descriptor);
            }
            return invokeL.booleanValue;
        }

        public final void mergeExtensionFields(ExtendableMessage extendableMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048591, this, extendableMessage) == null) {
                ensureExtensionsIsMutable();
                this.extensions.mergeFrom(extendableMessage.extensions);
            }
        }

        public final ExtendableBuilder addExtension(GeneratedExtension generatedExtension, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, generatedExtension, obj)) == null) {
                verifyExtensionContainingType(generatedExtension);
                ensureExtensionsIsMutable();
                this.extensions.addRepeatedField(generatedExtension.descriptor, obj);
                return this;
            }
            return (ExtendableBuilder) invokeLL.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.ExtendableMessageOrBuilder
        public final Object getExtension(GeneratedExtension generatedExtension, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, generatedExtension, i)) == null) {
                verifyExtensionContainingType(generatedExtension);
                return this.extensions.getRepeatedField(generatedExtension.descriptor, i);
            }
            return invokeLI.objValue;
        }

        public final ExtendableBuilder setExtension(GeneratedExtension generatedExtension, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, generatedExtension, obj)) == null) {
                verifyExtensionContainingType(generatedExtension);
                ensureExtensionsIsMutable();
                this.extensions.setField(generatedExtension.descriptor, obj);
                return this;
            }
            return (ExtendableBuilder) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public ExtendableBuilder clear() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.extensions.clear();
                this.extensionsIsMutable = false;
                return (ExtendableBuilder) super.clear();
            }
            return (ExtendableBuilder) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public ExtendableBuilder clone() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
            }
            return (ExtendableBuilder) invokeV.objValue;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            InterceptResult invokeLLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048592, this, codedInputStream, extensionRegistryLite, i)) == null) {
                ensureExtensionsIsMutable();
                return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), codedInputStream, extensionRegistryLite, i);
            }
            return invokeLLI.booleanValue;
        }

        public final ExtendableBuilder setExtension(GeneratedExtension generatedExtension, int i, Object obj) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048593, this, generatedExtension, i, obj)) == null) {
                verifyExtensionContainingType(generatedExtension);
                ensureExtensionsIsMutable();
                this.extensions.setRepeatedField(generatedExtension.descriptor, i, obj);
                return this;
            }
            return (ExtendableBuilder) invokeLIL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class ExtensionDescriptor implements FieldSet.FieldDescriptorLite {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Internal.EnumLiteMap enumTypeMap;
        public final boolean isPacked;
        public final boolean isRepeated;
        public final int number;
        public final WireFormat.FieldType type;

        public ExtensionDescriptor(Internal.EnumLiteMap enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {enumLiteMap, Integer.valueOf(i), fieldType, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
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
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, extensionDescriptor)) == null) {
                return this.number - extensionDescriptor.number;
            }
            return invokeL.intValue;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public Internal.EnumLiteMap getEnumType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.enumTypeMap;
            }
            return (Internal.EnumLiteMap) invokeV.objValue;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.type.getJavaType();
            }
            return (WireFormat.JavaType) invokeV.objValue;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.type;
            }
            return (WireFormat.FieldType) invokeV.objValue;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.number;
            }
            return invokeV.intValue;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.isPacked;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.isRepeated;
            }
            return invokeV.booleanValue;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, builder, messageLite)) == null) {
                return ((Builder) builder).mergeFrom((GeneratedMessageLite) messageLite);
            }
            return (MessageLite.Builder) invokeLL.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class GeneratedExtension {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final MessageLite containingTypeDefaultInstance;
        public final Object defaultValue;
        public final ExtensionDescriptor descriptor;
        public final MessageLite messageDefaultInstance;

        public GeneratedExtension(MessageLite messageLite, Object obj, MessageLite messageLite2, ExtensionDescriptor extensionDescriptor) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {messageLite, obj, messageLite2, extensionDescriptor};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            if (messageLite != null) {
                if (extensionDescriptor.getLiteType() == WireFormat.FieldType.MESSAGE && messageLite2 == null) {
                    throw new IllegalArgumentException("Null messageDefaultInstance");
                }
                this.containingTypeDefaultInstance = messageLite;
                this.defaultValue = obj;
                this.messageDefaultInstance = messageLite2;
                this.descriptor = extensionDescriptor;
                return;
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        public /* synthetic */ GeneratedExtension(MessageLite messageLite, Object obj, MessageLite messageLite2, ExtensionDescriptor extensionDescriptor, AnonymousClass1 anonymousClass1) {
            this(messageLite, obj, messageLite2, extensionDescriptor);
        }

        public MessageLite getContainingTypeDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.containingTypeDefaultInstance;
            }
            return (MessageLite) invokeV.objValue;
        }

        public MessageLite getMessageDefaultInstance() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.messageDefaultInstance;
            }
            return (MessageLite) invokeV.objValue;
        }

        public int getNumber() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.descriptor.getNumber();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes7.dex */
    public final class SerializedForm implements Serializable {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            return invokeV.objValue;
        }
    }

    public GeneratedMessageLite() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.google.protobuf.MessageLite
    public Parser getParserForType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
        return (Parser) invokeV.objValue;
    }

    public Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new SerializedForm(this);
        }
        return invokeV.objValue;
    }

    public GeneratedMessageLite(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static GeneratedExtension newRepeatedGeneratedExtension(MessageLite messageLite, MessageLite messageLite2, Internal.EnumLiteMap enumLiteMap, int i, WireFormat.FieldType fieldType, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{messageLite, messageLite2, enumLiteMap, Integer.valueOf(i), fieldType, Boolean.valueOf(z)})) == null) {
            return new GeneratedExtension(messageLite, Collections.emptyList(), messageLite2, new ExtensionDescriptor(enumLiteMap, i, fieldType, true, z, null), null);
        }
        return (GeneratedExtension) invokeCommon.objValue;
    }

    public static GeneratedExtension newSingularGeneratedExtension(MessageLite messageLite, Object obj, MessageLite messageLite2, Internal.EnumLiteMap enumLiteMap, int i, WireFormat.FieldType fieldType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{messageLite, obj, messageLite2, enumLiteMap, Integer.valueOf(i), fieldType})) == null) {
            return new GeneratedExtension(messageLite, obj, messageLite2, new ExtensionDescriptor(enumLiteMap, i, fieldType, false, false, null), null);
        }
        return (GeneratedExtension) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean parseUnknownField(FieldSet fieldSet, MessageLite messageLite, CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
        InterceptResult invokeCommon;
        boolean z;
        Object build;
        MessageLite messageLite2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{fieldSet, messageLite, codedInputStream, extensionRegistryLite, Integer.valueOf(i)})) == null) {
            int tagWireType = WireFormat.getTagWireType(i);
            GeneratedExtension findLiteExtensionByNumber = extensionRegistryLite.findLiteExtensionByNumber(messageLite, WireFormat.getTagFieldNumber(i));
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
                            Internal.EnumLite findValueByNumber = findLiteExtensionByNumber.descriptor.getEnumType().findValueByNumber(codedInputStream.readEnum());
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
                        if (!findLiteExtensionByNumber.descriptor.isRepeated() && (messageLite2 = (MessageLite) fieldSet.getField(findLiteExtensionByNumber.descriptor)) != null) {
                            builder = messageLite2.toBuilder();
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
        } else {
            return invokeCommon.booleanValue;
        }
    }

    public boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, codedInputStream, extensionRegistryLite, i)) == null) {
            return codedInputStream.skipField(i);
        }
        return invokeLLI.booleanValue;
    }
}
