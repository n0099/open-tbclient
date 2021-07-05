package d.a.s0.j1.b;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.io.IOException;
import tbclient.ReplyMe.ReplyMeResIdl;
/* loaded from: classes9.dex */
public class m extends k implements d.a.r0.g0.b.b, d.a.r0.g0.b.h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public m() {
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

    @Override // d.a.r0.g0.b.c
    public String getCacheKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "replyme_cache" : (String) invokeV.objValue;
    }

    @Override // d.a.r0.g0.b.b
    public boolean initByByteArray(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            try {
                initByProtobuf((ReplyMeResIdl) new Wire(new Class[0]).parseFrom(bArr, ReplyMeResIdl.class));
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.r0.g0.b.b
    public byte[] toCacheByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (byte[]) invokeV.objValue;
    }
}
