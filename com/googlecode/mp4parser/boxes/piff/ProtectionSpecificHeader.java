package com.googlecode.mp4parser.boxes.piff;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.coremedia.iso.Hex;
import com.googlecode.mp4parser.contentprotection.GenericHeader;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
/* loaded from: classes7.dex */
public abstract class ProtectionSpecificHeader {
    public static /* synthetic */ Interceptable $ic;
    public static Map<UUID, Class<? extends ProtectionSpecificHeader>> uuidRegistry;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract ByteBuffer getData();

    public abstract UUID getSystemId();

    public abstract void parse(ByteBuffer byteBuffer);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1945826671, "Lcom/googlecode/mp4parser/boxes/piff/ProtectionSpecificHeader;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1945826671, "Lcom/googlecode/mp4parser/boxes/piff/ProtectionSpecificHeader;");
                return;
            }
        }
        uuidRegistry = new HashMap();
    }

    public ProtectionSpecificHeader() {
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

    public static ProtectionSpecificHeader createFor(UUID uuid, ByteBuffer byteBuffer) {
        InterceptResult invokeLL;
        ProtectionSpecificHeader newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, uuid, byteBuffer)) == null) {
            Class<? extends ProtectionSpecificHeader> cls = uuidRegistry.get(uuid);
            if (cls != null) {
                try {
                    newInstance = cls.newInstance();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException(e2);
                }
            } else {
                newInstance = null;
            }
            if (newInstance == null) {
                newInstance = new GenericHeader();
            }
            newInstance.parse(byteBuffer);
            return newInstance;
        }
        return (ProtectionSpecificHeader) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            throw new RuntimeException("somebody called equals on me but that's not supposed to happen.");
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ProtectionSpecificHeader");
            sb.append("{data=");
            ByteBuffer duplicate = getData().duplicate();
            duplicate.rewind();
            byte[] bArr = new byte[duplicate.limit()];
            duplicate.get(bArr);
            sb.append(Hex.encodeHex(bArr));
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
