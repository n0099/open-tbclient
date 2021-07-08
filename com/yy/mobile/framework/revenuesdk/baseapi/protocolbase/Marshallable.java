package com.yy.mobile.framework.revenuesdk.baseapi.protocolbase;

import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes6.dex */
public class Marshallable extends PacketBase {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class ELenType {
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

        public ELenType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ELenType) Enum.valueOf(ELenType.class, str) : (ELenType) invokeL.objValue;
        }

        public static ELenType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ELenType[]) $VALUES.clone() : (ELenType[]) invokeV.objValue;
        }
    }

    public Marshallable() {
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

    private <K> K popKey(Class<K> cls, ELenType eLenType) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, cls, eLenType)) == null) {
            if (cls == Byte.class) {
                return (K) Byte.valueOf(popInt8());
            }
            if (cls == Short.class) {
                return (K) Short.valueOf(popInt16());
            }
            if (cls == Integer.class) {
                if (eLenType == ELenType.E_INT16) {
                    return (K) Integer.valueOf(popUint16());
                }
                return (K) Integer.valueOf(popInt32());
            } else if (cls == Long.class) {
                if (eLenType == ELenType.E_INT32) {
                    return (K) Long.valueOf(popUint32());
                }
                return (K) Long.valueOf(popInt64());
            } else if (cls == String.class) {
                if (eLenType == ELenType.E_INT16) {
                    return (K) popString16();
                }
                return (K) popString32();
            } else {
                throw new IllegalStateException("unknow map key type: " + cls.getName());
            }
        }
        return (K) invokeLL.objValue;
    }

    private <V> V popValue(Class<V> cls, ELenType eLenType) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, cls, eLenType)) == null) {
            if (cls == Byte.class) {
                return (V) Byte.valueOf(popInt8());
            }
            if (cls == Short.class) {
                return (V) Short.valueOf(popInt16());
            }
            if (cls == Integer.class) {
                return (V) Integer.valueOf(popInt32());
            }
            if (cls == Long.class) {
                if (eLenType == ELenType.E_INT32) {
                    return (V) Long.valueOf(popUint32());
                }
                return (V) Long.valueOf(popInt64());
            } else if (cls == String.class) {
                if (eLenType == ELenType.E_INT16) {
                    return (V) popString16();
                }
                return (V) popString32();
            } else {
                throw new IllegalStateException("unknow map value type: " + cls.getName());
            }
        }
        return (V) invokeLL.objValue;
    }

    private <K> void pushKey(K k) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, k) == null) {
            if (k instanceof Byte) {
                pushInt8(((Byte) k).byteValue());
            } else if (k instanceof Short) {
                pushInt16(((Short) k).shortValue());
            } else if (k instanceof Integer) {
                pushInt32(((Integer) k).intValue());
            } else if (k instanceof String) {
                pushString16((String) k);
            } else {
                throw new IllegalStateException("unknow map value type: " + k.getClass().getName());
            }
        }
    }

    private <V> void pushValue(V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, v) == null) {
            if (v instanceof Byte) {
                pushInt8(((Byte) v).byteValue());
            } else if (v instanceof Short) {
                pushInt16(((Short) v).shortValue());
            } else if (v instanceof Integer) {
                pushInt32(((Integer) v).intValue());
            } else if (v instanceof String) {
                pushString16((String) v);
            } else {
                throw new IllegalStateException("unknow map value type: " + v.getClass().getName());
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

    /* JADX DEBUG: Multi-variable search result rejected for r5v2, resolved type: java.util.Collection<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Collection<T> popCollection(Class<? extends Collection> cls, Class<T> cls2, ELenType eLenType) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, cls, cls2, eLenType)) == null) {
            int popInt32 = popInt32();
            Collection<T> collection = (Collection<T>) cls.newInstance();
            if (collection != 0) {
                for (int i2 = 0; i2 < popInt32; i2++) {
                    collection.add(popValue(cls2, eLenType));
                }
            }
            return collection;
        }
        return (Collection) invokeLLL.objValue;
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v2, resolved type: java.util.TreeMap */
    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> popMap(Class<K> cls, ELenType eLenType, Class<V> cls2, ELenType eLenType2) throws Exception {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048583, this, cls, eLenType, cls2, eLenType2)) == null) {
            int popInt32 = popInt32();
            TreeMap treeMap = new TreeMap();
            for (int i2 = 0; i2 < popInt32; i2++) {
                treeMap.put(popKey(cls, eLenType), popValue(cls2, eLenType2));
            }
            return treeMap;
        }
        return (Map) invokeLLLL.objValue;
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

    public final void pushInt32(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            this.buffer.putInt(i2);
        }
    }

    public final void pushInt64(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.buffer.putLong(j);
        }
    }

    public final void pushInt8(byte b2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeB(1048595, this, b2) == null) {
            this.buffer.put(b2);
        }
    }

    public <K, V> void pushMap(Map<K, V> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, map) == null) {
            if (map != null && map.size() != 0) {
                pushInt32(map.size());
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    pushKey(entry.getKey());
                    pushValue(entry.getValue());
                }
                return;
            }
            pushInt32(0);
        }
    }

    public final void pushString16(String str) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, str) == null) || str == null) {
            return;
        }
        try {
            bArr = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            bArr = new byte[0];
        }
        pushInt16((short) bArr.length);
        this.buffer.put(bArr);
    }

    public final void pushString32(String str) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, str) == null) || str == null) {
            return;
        }
        try {
            bArr = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            bArr = new byte[0];
        }
        pushInt32(bArr.length);
        this.buffer.put(bArr);
    }

    public final void pushStringWithoutLength(String str) {
        byte[] bArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, str) == null) || str == null) {
            return;
        }
        try {
            bArr = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            bArr = new byte[0];
        }
        this.buffer.put(bArr);
    }

    public final <T> Collection<T> popCollection(Class<? extends Collection> cls, Class<T> cls2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, cls2)) == null) ? popCollection(cls, cls2, ELenType.E_INT32) : (Collection) invokeLL.objValue;
    }

    public <K, V> Map<K, V> popMap(Class<K> cls, Class<V> cls2) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cls, cls2)) == null) {
            ELenType eLenType = ELenType.E_INT64;
            return popMap(cls, eLenType, cls2, eLenType);
        }
        return (Map) invokeLL.objValue;
    }
}
