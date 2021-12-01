package com.google.protobuf;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes2.dex */
public abstract class AbstractMessageLite implements MessageLite {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AbstractMessageLite() {
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

    public UninitializedMessageException newUninitializedMessageException() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new UninitializedMessageException(this) : (UninitializedMessageException) invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                byte[] bArr = new byte[getSerializedSize()];
                CodedOutputStream newInstance = CodedOutputStream.newInstance(bArr);
                writeTo(newInstance);
                newInstance.checkNoSpaceLeft();
                return bArr;
            } catch (IOException e2) {
                throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString toByteString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                ByteString.CodedBuilder newCodedBuilder = ByteString.newCodedBuilder(getSerializedSize());
                writeTo(newCodedBuilder.getCodedOutput());
                return newCodedBuilder.build();
            } catch (IOException e2) {
                throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e2);
            }
        }
        return (ByteString) invokeV.objValue;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, outputStream) == null) {
            int serializedSize = getSerializedSize();
            CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream, CodedOutputStream.computePreferredBufferSize(CodedOutputStream.computeRawVarint32Size(serializedSize) + serializedSize));
            newInstance.writeRawVarint32(serializedSize);
            writeTo(newInstance);
            newInstance.flush();
        }
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, outputStream) == null) {
            CodedOutputStream newInstance = CodedOutputStream.newInstance(outputStream, CodedOutputStream.computePreferredBufferSize(getSerializedSize()));
            writeTo(newInstance);
            newInstance.flush();
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class Builder<BuilderType extends Builder> implements MessageLite.Builder {
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

        public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65537, null, iterable, collection) == null) {
                if (iterable instanceof LazyStringList) {
                    checkForNullValues(((LazyStringList) iterable).getUnderlyingElements());
                } else {
                    checkForNullValues(iterable);
                }
                if (iterable instanceof Collection) {
                    collection.addAll((Collection) iterable);
                    return;
                }
                for (T t : iterable) {
                    collection.add(t);
                }
            }
        }

        public static void checkForNullValues(Iterable<?> iterable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65538, null, iterable) == null) {
                Iterator<?> it = iterable.iterator();
                while (it.hasNext()) {
                    if (it.next() == null) {
                        throw null;
                    }
                }
            }
        }

        public static UninitializedMessageException newUninitializedMessageException(MessageLite messageLite) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, messageLite)) == null) ? new UninitializedMessageException(messageLite) : (UninitializedMessageException) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        public abstract BuilderType clone();

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, inputStream, extensionRegistryLite)) == null) {
                int read = inputStream.read();
                if (read == -1) {
                    return false;
                }
                mergeFrom((InputStream) new LimitedInputStream(inputStream, CodedInputStream.readRawVarint32(read, inputStream)), extensionRegistryLite);
                return true;
            }
            return invokeLL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        public abstract BuilderType mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException;

        /* loaded from: classes2.dex */
        public static final class LimitedInputStream extends FilterInputStream {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public int limit;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LimitedInputStream(InputStream inputStream, int i2) {
                super(inputStream);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {inputStream, Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super((InputStream) newInitContext.callArgs[0]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.limit = i2;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Math.min(super.available(), this.limit) : invokeV.intValue;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    if (this.limit <= 0) {
                        return -1;
                    }
                    int read = super.read();
                    if (read >= 0) {
                        this.limit--;
                    }
                    return read;
                }
                return invokeV.intValue;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j2) throws IOException {
                InterceptResult invokeJ;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeJ = interceptable.invokeJ(1048579, this, j2)) == null) {
                    long skip = super.skip(Math.min(j2, this.limit));
                    if (skip >= 0) {
                        this.limit = (int) (this.limit - skip);
                    }
                    return skip;
                }
                return invokeJ.longValue;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i2, int i3) throws IOException {
                InterceptResult invokeLII;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, bArr, i2, i3)) == null) {
                    int i4 = this.limit;
                    if (i4 <= 0) {
                        return -1;
                    }
                    int read = super.read(bArr, i2, Math.min(i3, i4));
                    if (read >= 0) {
                        this.limit -= read;
                    }
                    return read;
                }
                return invokeLII.intValue;
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, inputStream)) == null) ? mergeDelimitedFrom(inputStream, ExtensionRegistryLite.getEmptyRegistry()) : invokeL.booleanValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(CodedInputStream codedInputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, codedInputStream)) == null) ? mergeFrom(codedInputStream, ExtensionRegistryLite.getEmptyRegistry()) : (BuilderType) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, byteString)) == null) {
                try {
                    CodedInputStream newCodedInput = byteString.newCodedInput();
                    mergeFrom(newCodedInput);
                    newCodedInput.checkLastTagWas(0);
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2;
                } catch (IOException e3) {
                    throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e3);
                }
            }
            return (BuilderType) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, byteString, extensionRegistryLite)) == null) {
                try {
                    CodedInputStream newCodedInput = byteString.newCodedInput();
                    mergeFrom(newCodedInput, extensionRegistryLite);
                    newCodedInput.checkLastTagWas(0);
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2;
                } catch (IOException e3) {
                    throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e3);
                }
            }
            return (BuilderType) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] bArr) throws InvalidProtocolBufferException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bArr)) == null) ? mergeFrom(bArr, 0, bArr.length) : (BuilderType) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] bArr, int i2, int i3) throws InvalidProtocolBufferException {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(1048588, this, bArr, i2, i3)) == null) {
                try {
                    CodedInputStream newInstance = CodedInputStream.newInstance(bArr, i2, i3);
                    mergeFrom(newInstance);
                    newInstance.checkLastTagWas(0);
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2;
                } catch (IOException e3) {
                    throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e3);
                }
            }
            return (BuilderType) invokeLII.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, bArr, extensionRegistryLite)) == null) ? mergeFrom(bArr, 0, bArr.length, extensionRegistryLite) : (BuilderType) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(byte[] bArr, int i2, int i3, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{bArr, Integer.valueOf(i2), Integer.valueOf(i3), extensionRegistryLite})) == null) {
                try {
                    CodedInputStream newInstance = CodedInputStream.newInstance(bArr, i2, i3);
                    mergeFrom(newInstance, extensionRegistryLite);
                    newInstance.checkLastTagWas(0);
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2;
                } catch (IOException e3) {
                    throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e3);
                }
            }
            return (BuilderType) invokeCommon.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(InputStream inputStream) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, inputStream)) == null) {
                CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
                mergeFrom(newInstance);
                newInstance.checkLastTagWas(0);
                return this;
            }
            return (BuilderType) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        public BuilderType mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, inputStream, extensionRegistryLite)) == null) {
                CodedInputStream newInstance = CodedInputStream.newInstance(inputStream);
                mergeFrom(newInstance, extensionRegistryLite);
                newInstance.checkLastTagWas(0);
                return this;
            }
            return (BuilderType) invokeLL.objValue;
        }
    }
}
