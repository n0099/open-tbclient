package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* loaded from: classes6.dex */
public abstract class RequestPacket extends Marshallable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public RequestPacket() {
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

    public abstract int getPacketSize();

    @Override // com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.PacketBase, com.yy.mobile.framework.revenuesdk.baseapi.protocolbase.IPacket
    public byte[] marshall() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ByteBuffer allocate = ByteBuffer.allocate(getPacketSize());
            this.buffer = allocate;
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            marshall(this.buffer);
            pushPacketData();
            return this.buffer.array();
        }
        return (byte[]) invokeV.objValue;
    }

    public abstract void pushPacketData();
}
