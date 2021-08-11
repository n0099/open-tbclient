package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes10.dex */
public class PacketBase implements IPacket {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer buffer;

    public PacketBase() {
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

    public void checkPacket(int i2) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            ByteBuffer byteBuffer = this.buffer;
            if (byteBuffer != null) {
                if (byteBuffer.capacity() - this.buffer.position() < i2) {
                    throw new Exception("cause stack overflow exception when unmarshall the pack");
                }
                return;
            }
            throw new Exception("call supper unmarshall before pop data");
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public void marshall(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteBuffer) == null) {
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public byte[] marshall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.buffer == null) {
                ByteBuffer allocate = ByteBuffer.allocate(1);
                this.buffer = allocate;
                allocate.order(ByteOrder.LITTLE_ENDIAN);
            }
            marshall(this.buffer);
            return this.buffer.array();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public void unmarshall(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, byteBuffer) == null) {
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public void unmarshall(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bArr) == null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.buffer = wrap;
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            unmarshall(this.buffer);
        }
    }

    public PacketBase(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bArr};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        unmarshall(bArr);
    }
}
