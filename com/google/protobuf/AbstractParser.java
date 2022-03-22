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
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public abstract class AbstractParser<MessageType extends MessageLite> implements Parser<MessageType> {
    public static /* synthetic */ Interceptable $ic;
    public static final ExtensionRegistryLite EMPTY_REGISTRY;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1423387026, "Lcom/google/protobuf/AbstractParser;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1423387026, "Lcom/google/protobuf/AbstractParser;");
                return;
            }
        }
        EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    }

    public AbstractParser() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private MessageType checkMessageInitialized(MessageType messagetype) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, messagetype)) == null) {
            if (messagetype == null || messagetype.isInitialized()) {
                return messagetype;
            }
            throw newUninitializedMessageException(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
        }
        return (MessageType) invokeL.objValue;
    }

    private UninitializedMessageException newUninitializedMessageException(MessageType messagetype) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, messagetype)) == null) {
            if (messagetype instanceof AbstractMessageLite) {
                return ((AbstractMessageLite) messagetype).newUninitializedMessageException();
            }
            return new UninitializedMessageException(messagetype);
        }
        return (UninitializedMessageException) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream, extensionRegistryLite)) == null) ? checkMessageInitialized(parsePartialDelimitedFrom(inputStream, extensionRegistryLite)) : (MessageType) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, inputStream, extensionRegistryLite)) == null) {
            try {
                int read = inputStream.read();
                if (read == -1) {
                    return null;
                }
                return parsePartialFrom((InputStream) new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)), extensionRegistryLite);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage());
            }
        }
        return (MessageType) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parseDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, inputStream)) == null) ? parseDelimitedFrom(inputStream, EMPTY_REGISTRY) : (MessageType) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parsePartialDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, inputStream)) == null) ? parsePartialDelimitedFrom(inputStream, EMPTY_REGISTRY) : (MessageType) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, codedInputStream)) == null) ? (MessageType) parsePartialFrom(codedInputStream, EMPTY_REGISTRY) : (MessageType) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.protobuf.AbstractParser<MessageType extends com.google.protobuf.MessageLite> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, codedInputStream, extensionRegistryLite)) == null) ? (MessageType) checkMessageInitialized((MessageLite) parsePartialFrom(codedInputStream, extensionRegistryLite)) : (MessageType) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, byteString, extensionRegistryLite)) == null) {
            try {
                try {
                    CodedInputStream newCodedInput = byteString.newCodedInput();
                    MessageType messagetype = (MessageType) parsePartialFrom(newCodedInput, extensionRegistryLite);
                    try {
                        newCodedInput.checkLastTagWas(0);
                        return messagetype;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(messagetype);
                    }
                } catch (IOException e3) {
                    throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e3);
                }
            } catch (InvalidProtocolBufferException e4) {
                throw e4;
            }
        }
        return (MessageType) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, codedInputStream)) == null) ? parseFrom(codedInputStream, EMPTY_REGISTRY) : (MessageType) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, byteString, extensionRegistryLite)) == null) ? checkMessageInitialized(parsePartialFrom(byteString, extensionRegistryLite)) : (MessageType) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, byteString)) == null) ? parseFrom(byteString, EMPTY_REGISTRY) : (MessageType) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), extensionRegistryLite})) == null) ? checkMessageInitialized(parsePartialFrom(bArr, i, i2, extensionRegistryLite)) : (MessageType) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048587, this, bArr, i, i2)) == null) ? parseFrom(bArr, i, i2, EMPTY_REGISTRY) : (MessageType) invokeLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, bArr, extensionRegistryLite)) == null) ? parseFrom(bArr, 0, bArr.length, extensionRegistryLite) : (MessageType) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, byteString)) == null) ? parsePartialFrom(byteString, EMPTY_REGISTRY) : (MessageType) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bArr)) == null) ? parseFrom(bArr, EMPTY_REGISTRY) : (MessageType) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), extensionRegistryLite})) == null) {
            try {
                try {
                    CodedInputStream newInstance = CodedInputStream.newInstance(bArr, i, i2);
                    MessageType messagetype = (MessageType) parsePartialFrom(newInstance, extensionRegistryLite);
                    try {
                        newInstance.checkLastTagWas(0);
                        return messagetype;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(messagetype);
                    }
                } catch (IOException e3) {
                    throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e3);
                }
            } catch (InvalidProtocolBufferException e4) {
                throw e4;
            }
        }
        return (MessageType) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, inputStream, extensionRegistryLite)) == null) ? checkMessageInitialized(parsePartialFrom(inputStream, extensionRegistryLite)) : (MessageType) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parseFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, inputStream)) == null) ? parseFrom(inputStream, EMPTY_REGISTRY) : (MessageType) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048610, this, bArr, i, i2)) == null) ? parsePartialFrom(bArr, i, i2, EMPTY_REGISTRY) : (MessageType) invokeLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, bArr, extensionRegistryLite)) == null) ? parsePartialFrom(bArr, 0, bArr.length, extensionRegistryLite) : (MessageType) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, bArr)) == null) ? parsePartialFrom(bArr, 0, bArr.length, EMPTY_REGISTRY) : (MessageType) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, inputStream, extensionRegistryLite)) == null) {
            CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
            MessageType messagetype = (MessageType) parsePartialFrom(newInstance, extensionRegistryLite);
            try {
                newInstance.checkLastTagWas(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.setUnfinishedMessage(messagetype);
            }
        }
        return (MessageType) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageType parsePartialFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, inputStream)) == null) ? parsePartialFrom(inputStream, EMPTY_REGISTRY) : (MessageType) invokeL.objValue;
    }
}
