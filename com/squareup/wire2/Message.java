package com.squareup.wire2;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.wt9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.io.Serializable;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
/* loaded from: classes8.dex */
public abstract class Message implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final transient ProtoAdapter adapter;
    public transient int cachedSerializedSize;
    public transient int hashCode;
    public final transient ByteString unknownFields;

    public abstract a newBuilder();

    /* loaded from: classes8.dex */
    public abstract class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Buffer unknownFieldsBuffer;
        public wt9 unknownFieldsWriter;

        public abstract Message build();

        public a() {
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

        public final ByteString buildUnknownFields() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                Buffer buffer = this.unknownFieldsBuffer;
                if (buffer != null) {
                    return buffer.clone().readByteString();
                }
                return ByteString.EMPTY;
            }
            return (ByteString) invokeV.objValue;
        }

        public final a clearUnknownFields() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.unknownFieldsWriter = null;
                this.unknownFieldsBuffer = null;
                return this;
            }
            return (a) invokeV.objValue;
        }

        public final a addUnknownField(int i, FieldEncoding fieldEncoding, Object obj) {
            InterceptResult invokeILL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048576, this, i, fieldEncoding, obj)) == null) {
                if (this.unknownFieldsWriter == null) {
                    Buffer buffer = new Buffer();
                    this.unknownFieldsBuffer = buffer;
                    this.unknownFieldsWriter = new wt9(buffer);
                }
                try {
                    fieldEncoding.rawProtoAdapter().encodeWithTag(this.unknownFieldsWriter, i, obj);
                    return this;
                } catch (IOException unused) {
                    throw new AssertionError();
                }
            }
            return (a) invokeILL.objValue;
        }

        public final a addUnknownFields(ByteString byteString) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteString)) == null) {
                if (byteString.size() > 0) {
                    if (this.unknownFieldsWriter == null) {
                        Buffer buffer = new Buffer();
                        this.unknownFieldsBuffer = buffer;
                        this.unknownFieldsWriter = new wt9(buffer);
                    }
                    try {
                        this.unknownFieldsWriter.k(byteString);
                    } catch (IOException unused) {
                        throw new AssertionError();
                    }
                }
                return this;
            }
            return (a) invokeL.objValue;
        }
    }

    public Message(ProtoAdapter protoAdapter, ByteString byteString) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {protoAdapter, byteString};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.cachedSerializedSize = 0;
        this.hashCode = 0;
        if (protoAdapter != null) {
            if (byteString != null) {
                this.adapter = protoAdapter;
                this.unknownFields = byteString;
                return;
            }
            throw new NullPointerException("unknownFields == null");
        }
        throw new NullPointerException("adapter == null");
    }

    public final ProtoAdapter adapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.adapter;
        }
        return (ProtoAdapter) invokeV.objValue;
    }

    public final byte[] encode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.adapter.encode(this);
        }
        return (byte[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.adapter.toString(this);
        }
        return (String) invokeV.objValue;
    }

    public final ByteString unknownFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ByteString byteString = this.unknownFields;
            if (byteString == null) {
                return ByteString.EMPTY;
            }
            return byteString;
        }
        return (ByteString) invokeV.objValue;
    }

    public final Message withoutUnknownFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return newBuilder().clearUnknownFields().build();
        }
        return (Message) invokeV.objValue;
    }

    public final Object writeReplace() throws ObjectStreamException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return new MessageSerializedForm(encode(), getClass());
        }
        return invokeV.objValue;
    }

    public final void encode(OutputStream outputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, outputStream) == null) {
            this.adapter.encode(outputStream, this);
        }
    }

    public final void encode(BufferedSink bufferedSink) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
            this.adapter.encode(bufferedSink, this);
        }
    }
}
