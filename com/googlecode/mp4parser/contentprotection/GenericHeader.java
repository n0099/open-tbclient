package com.googlecode.mp4parser.contentprotection;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader;
import java.nio.ByteBuffer;
import java.util.UUID;
/* loaded from: classes2.dex */
public class GenericHeader extends ProtectionSpecificHeader {
    public static /* synthetic */ Interceptable $ic;
    public static UUID PROTECTION_SYSTEM_ID;
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer data;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1286806974, "Lcom/googlecode/mp4parser/contentprotection/GenericHeader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1286806974, "Lcom/googlecode/mp4parser/contentprotection/GenericHeader;");
                return;
            }
        }
        PROTECTION_SYSTEM_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        ProtectionSpecificHeader.uuidRegistry.put(PROTECTION_SYSTEM_ID, GenericHeader.class);
    }

    public GenericHeader() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader
    public ByteBuffer getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.data : (ByteBuffer) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader
    public UUID getSystemId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? PROTECTION_SYSTEM_ID : (UUID) invokeV.objValue;
    }

    @Override // com.googlecode.mp4parser.boxes.piff.ProtectionSpecificHeader
    public void parse(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteBuffer) == null) {
            this.data = byteBuffer;
        }
    }
}
