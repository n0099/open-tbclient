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
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public abstract class AbstractParser implements Parser {
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

    private MessageLite checkMessageInitialized(MessageLite messageLite) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, messageLite)) == null) {
            if (messageLite != null && !messageLite.isInitialized()) {
                throw newUninitializedMessageException(messageLite).asInvalidProtocolBufferException().setUnfinishedMessage(messageLite);
            }
            return messageLite;
        }
        return (MessageLite) invokeL.objValue;
    }

    private UninitializedMessageException newUninitializedMessageException(MessageLite messageLite) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, messageLite)) == null) {
            if (messageLite instanceof AbstractMessageLite) {
                return ((AbstractMessageLite) messageLite).newUninitializedMessageException();
            }
            return new UninitializedMessageException(messageLite);
        }
        return (UninitializedMessageException) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parseDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, inputStream)) == null) {
            return parseDelimitedFrom(inputStream, EMPTY_REGISTRY);
        }
        return (MessageLite) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, byteString)) == null) {
            return parseFrom(byteString, EMPTY_REGISTRY);
        }
        return (MessageLite) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parsePartialDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, inputStream)) == null) {
            return parsePartialDelimitedFrom(inputStream, EMPTY_REGISTRY);
        }
        return (MessageLite) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parsePartialFrom(ByteString byteString) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, byteString)) == null) {
            return parsePartialFrom(byteString, EMPTY_REGISTRY);
        }
        return (MessageLite) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, inputStream, extensionRegistryLite)) == null) {
            return checkMessageInitialized(parsePartialDelimitedFrom(inputStream, extensionRegistryLite));
        }
        return (MessageLite) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, byteString, extensionRegistryLite)) == null) {
            return checkMessageInitialized(parsePartialFrom(byteString, extensionRegistryLite));
        }
        return (MessageLite) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parsePartialFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048608, this, inputStream, extensionRegistryLite)) == null) {
            CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
            MessageLite messageLite = (MessageLite) parsePartialFrom(newInstance, extensionRegistryLite);
            try {
                newInstance.checkLastTagWas(0);
                return messageLite;
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(messageLite);
            }
        }
        return (MessageLite) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parseFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, codedInputStream)) == null) {
            return parseFrom(codedInputStream, EMPTY_REGISTRY);
        }
        return (MessageLite) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parsePartialFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, codedInputStream)) == null) {
            return (MessageLite) parsePartialFrom(codedInputStream, EMPTY_REGISTRY);
        }
        return (MessageLite) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, codedInputStream, extensionRegistryLite)) == null) {
            return checkMessageInitialized((MessageLite) parsePartialFrom(codedInputStream, extensionRegistryLite));
        }
        return (MessageLite) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parsePartialFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, bArr, extensionRegistryLite)) == null) {
            return parsePartialFrom(bArr, 0, bArr.length, extensionRegistryLite);
        }
        return (MessageLite) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parseFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, inputStream)) == null) {
            return parseFrom(inputStream, EMPTY_REGISTRY);
        }
        return (MessageLite) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parsePartialFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, inputStream)) == null) {
            return parsePartialFrom(inputStream, EMPTY_REGISTRY);
        }
        return (MessageLite) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, inputStream, extensionRegistryLite)) == null) {
            return checkMessageInitialized(parsePartialFrom(inputStream, extensionRegistryLite));
        }
        return (MessageLite) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, bArr)) == null) {
            return parseFrom(bArr, EMPTY_REGISTRY);
        }
        return (MessageLite) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parsePartialFrom(byte[] bArr) throws InvalidProtocolBufferException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, bArr)) == null) {
            return parsePartialFrom(bArr, 0, bArr.length, EMPTY_REGISTRY);
        }
        return (MessageLite) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parseFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048587, this, bArr, i, i2)) == null) {
            return parseFrom(bArr, i, i2, EMPTY_REGISTRY);
        }
        return (MessageLite) invokeLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parsePartialFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048610, this, bArr, i, i2)) == null) {
            return parsePartialFrom(bArr, i, i2, EMPTY_REGISTRY);
        }
        return (MessageLite) invokeLII.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parseFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), extensionRegistryLite})) == null) {
            return checkMessageInitialized(parsePartialFrom(bArr, i, i2, extensionRegistryLite));
        }
        return (MessageLite) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, bArr, extensionRegistryLite)) == null) {
            return parseFrom(bArr, 0, bArr.length, extensionRegistryLite);
        }
        return (MessageLite) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parsePartialDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, inputStream, extensionRegistryLite)) == null) {
            try {
                int read = inputStream.read();
                if (read == -1) {
                    return null;
                }
                return parsePartialFrom((InputStream) new AbstractMessageLite.Builder.LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)), extensionRegistryLite);
            } catch (IOException e) {
                throw new InvalidProtocolBufferException(e.getMessage());
            }
        }
        return (MessageLite) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parsePartialFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048605, this, byteString, extensionRegistryLite)) == null) {
            try {
                try {
                    CodedInputStream newCodedInput = byteString.newCodedInput();
                    MessageLite messageLite = (MessageLite) parsePartialFrom(newCodedInput, extensionRegistryLite);
                    try {
                        newCodedInput.checkLastTagWas(0);
                        return messageLite;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(messageLite);
                    }
                } catch (IOException e2) {
                    throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e2);
                }
            } catch (InvalidProtocolBufferException e3) {
                throw e3;
            }
        }
        return (MessageLite) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.Parser
    public MessageLite parsePartialFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{bArr, Integer.valueOf(i), Integer.valueOf(i2), extensionRegistryLite})) == null) {
            try {
                try {
                    CodedInputStream newInstance = CodedInputStream.newInstance(bArr, i, i2);
                    MessageLite messageLite = (MessageLite) parsePartialFrom(newInstance, extensionRegistryLite);
                    try {
                        newInstance.checkLastTagWas(0);
                        return messageLite;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(messageLite);
                    }
                } catch (IOException e2) {
                    throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
                }
            } catch (InvalidProtocolBufferException e3) {
                throw e3;
            }
        }
        return (MessageLite) invokeCommon.objValue;
    }
}
