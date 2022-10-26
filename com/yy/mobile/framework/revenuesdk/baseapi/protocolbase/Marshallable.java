package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import kotlin.UShort;
/* loaded from: classes8.dex */
public class Marshallable extends PacketBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public final class ELenType {
        public static final /* synthetic */ ELenType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ELenType E_INT16;
        public static final ELenType E_INT32;
        public static final ELenType E_INT64;
        public static final ELenType E_NONE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1199294381, "Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/Marshallable$ELenType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1199294381, "Lcom/yy/mobile/framework/revenuesdk/baseapi/protocolbase/Marshallable$ELenType;");
                    return;
                }
            }
            E_INT16 = new ELenType("E_INT16", 0);
            E_INT32 = new ELenType("E_INT32", 1);
            E_INT64 = new ELenType("E_INT64", 2);
            ELenType eLenType = new ELenType("E_NONE", 3);
            E_NONE = eLenType;
            $VALUES = new ELenType[]{E_INT16, E_INT32, E_INT64, eLenType};
        }

        public ELenType(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static ELenType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (ELenType) Enum.valueOf(ELenType.class, str);
            }
            return (ELenType) invokeL.objValue;
        }

        public static ELenType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (ELenType[]) $VALUES.clone();
            }
            return (ELenType[]) invokeV.objValue;
        }
    }

    public Marshallable() {
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

    public final byte[] popByteArray16() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            checkPacket(2);
            int popInt16 = popInt16();
            checkPacket(popInt16);
            byte[] bArr = new byte[popInt16];
            this.buffer.get(bArr);
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public final short popInt16() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            checkPacket(2);
            return this.buffer.getShort();
        }
        return invokeV.shortValue;
    }

    public final int popInt32() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            checkPacket(4);
            return this.buffer.getInt();
        }
        return invokeV.intValue;
    }

    public final long popInt64() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            checkPacket(8);
            return this.buffer.getLong();
        }
        return invokeV.longValue;
    }

    public final byte popInt8() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            checkPacket(1);
            return this.buffer.get();
        }
        return invokeV.byteValue;
    }

    public final String popStingWithOutLength() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int remaining = this.buffer.remaining();
            byte[] bArr = new byte[remaining];
            checkPacket(remaining);
            this.buffer.get(bArr);
            return new String(bArr, "UTF-8");
        }
        return (String) invokeV.objValue;
    }

    public final String popString16() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            checkPacket(2);
            int popInt16 = popInt16();
            checkPacket(popInt16);
            byte[] bArr = new byte[popInt16];
            this.buffer.get(bArr);
            return new String(bArr, "UTF-8");
        }
        return (String) invokeV.objValue;
    }

    public final String popString32() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            checkPacket(4);
            int popInt32 = popInt32();
            checkPacket(popInt32);
            byte[] bArr = new byte[popInt32];
            this.buffer.get(bArr);
            return new String(bArr, "UTF-8");
        }
        return (String) invokeV.objValue;
    }

    public final int popUint16() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            checkPacket(2);
            return popInt16() & UShort.MAX_VALUE;
        }
        return invokeV.intValue;
    }

    public final long popUint32() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            checkPacket(4);
            return popInt32() & 4294967295L;
        }
        return invokeV.longValue;
    }

    public final short popUint8() throws Exception {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            checkPacket(1);
            return (short) (popInt8() & 255);
        }
        return invokeV.shortValue;
    }

    private Object popKey(Class cls, ELenType eLenType) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, cls, eLenType)) == null) {
            if (cls == Byte.class) {
                return Byte.valueOf(popInt8());
            }
            if (cls == Short.class) {
                return Short.valueOf(popInt16());
            }
            if (cls == Integer.class) {
                if (eLenType == ELenType.E_INT16) {
                    return Integer.valueOf(popUint16());
                }
                return Integer.valueOf(popInt32());
            } else if (cls == Long.class) {
                if (eLenType == ELenType.E_INT32) {
                    return Long.valueOf(popUint32());
                }
                return Long.valueOf(popInt64());
            } else if (cls == String.class) {
                if (eLenType == ELenType.E_INT16) {
                    return popString16();
                }
                return popString32();
            } else {
                throw new IllegalStateException("unknow map key type: " + cls.getName());
            }
        }
        return invokeLL.objValue;
    }

    private Object popValue(Class cls, ELenType eLenType) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, cls, eLenType)) == null) {
            if (cls == Byte.class) {
                return Byte.valueOf(popInt8());
            }
            if (cls == Short.class) {
                return Short.valueOf(popInt16());
            }
            if (cls == Integer.class) {
                return Integer.valueOf(popInt32());
            }
            if (cls == Long.class) {
                if (eLenType == ELenType.E_INT32) {
                    return Long.valueOf(popUint32());
                }
                return Long.valueOf(popInt64());
            } else if (cls == String.class) {
                if (eLenType == ELenType.E_INT16) {
                    return popString16();
                }
                return popString32();
            } else {
                throw new IllegalStateException("unknow map value type: " + cls.getName());
            }
        }
        return invokeLL.objValue;
    }

    private void pushKey(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, obj) == null) {
            if (obj instanceof Byte) {
                pushInt8(((Byte) obj).byteValue());
            } else if (obj instanceof Short) {
                pushInt16(((Short) obj).shortValue());
            } else if (obj instanceof Integer) {
                pushInt32(((Integer) obj).intValue());
            } else if (obj instanceof String) {
                pushString16((String) obj);
            } else {
                throw new IllegalStateException("unknow map value type: " + obj.getClass().getName());
            }
        }
    }

    private void pushValue(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, obj) == null) {
            if (obj instanceof Byte) {
                pushInt8(((Byte) obj).byteValue());
            } else if (obj instanceof Short) {
                pushInt16(((Short) obj).shortValue());
            } else if (obj instanceof Integer) {
                pushInt32(((Integer) obj).intValue());
            } else if (obj instanceof String) {
                pushString16((String) obj);
            } else {
                throw new IllegalStateException("unknow map value type: " + obj.getClass().getName());
            }
        }
    }

    public void pushMap(Map map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, map) == null) {
            if (map != null && map.size() != 0) {
                pushInt32(map.size());
                for (Map.Entry entry : map.entrySet()) {
                    pushKey(entry.getKey());
                    pushValue(entry.getValue());
                }
                return;
            }
            pushInt32(0);
        }
    }

    public final Collection popCollection(Class cls, Class cls2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2)) == null) {
            return popCollection(cls, cls2, ELenType.E_INT32);
        }
        return (Collection) invokeLL.objValue;
    }

    public Map popMap(Class cls, Class cls2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, cls2)) == null) {
            ELenType eLenType = ELenType.E_INT64;
            return popMap(cls, eLenType, cls2, eLenType);
        }
        return (Map) invokeLL.objValue;
    }

    public final Collection popCollection(Class cls, Class cls2, ELenType eLenType) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, eLenType)) == null) {
            int popInt32 = popInt32();
            Collection collection = (Collection) cls.newInstance();
            if (collection != null) {
                for (int i = 0; i < popInt32; i++) {
                    collection.add(popValue(cls2, eLenType));
                }
            }
            return collection;
        }
        return (Collection) invokeLLL.objValue;
    }

    public Map popMap(Class cls, ELenType eLenType, Class cls2, ELenType eLenType2) throws Exception {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, cls, eLenType, cls2, eLenType2)) == null) {
            int popInt32 = popInt32();
            TreeMap treeMap = new TreeMap();
            for (int i = 0; i < popInt32; i++) {
                treeMap.put(popKey(cls, eLenType), popValue(cls2, eLenType2));
            }
            return treeMap;
        }
        return (Map) invokeLLLL.objValue;
    }

    public final void pushByteArray(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bArr) == null) {
            this.buffer.put(bArr);
        }
    }

    public final void pushInt16(short s) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Short.valueOf(s)}) == null) {
            this.buffer.putShort(s);
        }
    }

    public final void pushInt32(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.buffer.putInt(i);
        }
    }

    public final void pushInt64(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.buffer.putLong(j);
        }
    }

    public final void pushInt8(byte b) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048595, this, b) == null) {
            this.buffer.put(b);
        }
    }

    public final void pushString16(String str) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && str != null) {
            try {
                bArr = str.getBytes(IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                bArr = new byte[0];
            }
            pushInt16((short) bArr.length);
            this.buffer.put(bArr);
        }
    }

    public final void pushString32(String str) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, str) == null) && str != null) {
            try {
                bArr = str.getBytes(IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                bArr = new byte[0];
            }
            pushInt32(bArr.length);
            this.buffer.put(bArr);
        }
    }

    public final void pushStringWithoutLength(String str) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, str) == null) && str != null) {
            try {
                bArr = str.getBytes(IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                bArr = new byte[0];
            }
            this.buffer.put(bArr);
        }
    }
}
