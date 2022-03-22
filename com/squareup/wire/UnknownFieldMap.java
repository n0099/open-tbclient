package com.squareup.wire;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public final class UnknownFieldMap {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<Integer, List<FieldValue>> fieldMap;

    /* loaded from: classes7.dex */
    public static abstract class FieldValue {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int tag;
        public final WireType wireType;

        public FieldValue(int i, WireType wireType) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), wireType};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.tag = i;
            this.wireType = wireType;
        }

        public static Fixed32FieldValue fixed32(int i, Integer num) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i, num)) == null) ? new Fixed32FieldValue(i, num) : (Fixed32FieldValue) invokeIL.objValue;
        }

        public static Fixed64FieldValue fixed64(int i, Long l) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, l)) == null) ? new Fixed64FieldValue(i, l) : (Fixed64FieldValue) invokeIL.objValue;
        }

        public static LengthDelimitedFieldValue lengthDelimited(int i, ByteString byteString) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(65539, null, i, byteString)) == null) ? new LengthDelimitedFieldValue(i, byteString) : (LengthDelimitedFieldValue) invokeIL.objValue;
        }

        public static VarintFieldValue varint(int i, Long l) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, null, i, l)) == null) ? new VarintFieldValue(i, l) : (VarintFieldValue) invokeIL.objValue;
        }

        public ByteString getAsBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                throw new IllegalStateException();
            }
            return (ByteString) invokeV.objValue;
        }

        public Integer getAsInteger() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                throw new IllegalStateException();
            }
            return (Integer) invokeV.objValue;
        }

        public Long getAsLong() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                throw new IllegalStateException();
            }
            return (Long) invokeV.objValue;
        }

        public abstract int getSerializedSize();

        public int getTag() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.tag : invokeV.intValue;
        }

        public WireType getWireType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.wireType : (WireType) invokeV.objValue;
        }

        public abstract void write(int i, WireOutput wireOutput) throws IOException;
    }

    /* loaded from: classes7.dex */
    public static final class Fixed32FieldValue extends FieldValue {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Integer value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Fixed32FieldValue(int i, Integer num) {
            super(i, WireType.FIXED32);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (WireType) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = num;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public Integer getAsInteger() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (Integer) invokeV.objValue;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 4;
            }
            return invokeV.intValue;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public void write(int i, WireOutput wireOutput) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, wireOutput) == null) {
                wireOutput.writeTag(i, WireType.FIXED32);
                wireOutput.writeFixed32(this.value.intValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class Fixed64FieldValue extends FieldValue {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Long value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Fixed64FieldValue(int i, Long l) {
            super(i, WireType.FIXED64);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), l};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (WireType) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = l;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public Long getAsLong() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (Long) invokeV.objValue;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 8;
            }
            return invokeV.intValue;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public void write(int i, WireOutput wireOutput) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, wireOutput) == null) {
                wireOutput.writeTag(i, WireType.FIXED64);
                wireOutput.writeFixed64(this.value.longValue());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class LengthDelimitedFieldValue extends FieldValue {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ByteString value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LengthDelimitedFieldValue(int i, ByteString byteString) {
            super(i, WireType.LENGTH_DELIMITED);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), byteString};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (WireType) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = byteString;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public ByteString getAsBytes() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (ByteString) invokeV.objValue;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? WireOutput.varint32Size(this.value.size()) + this.value.size() : invokeV.intValue;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public void write(int i, WireOutput wireOutput) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, wireOutput) == null) {
                wireOutput.writeTag(i, WireType.LENGTH_DELIMITED);
                wireOutput.writeVarint32(this.value.size());
                wireOutput.writeRawBytes(this.value.toByteArray());
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class UnknownFieldType {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ UnknownFieldType[] ENUM$VALUES;
        public static final UnknownFieldType FIXED32;
        public static final UnknownFieldType FIXED64;
        public static final UnknownFieldType LENGTH_DELIMITED;
        public static final UnknownFieldType VARINT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(548068076, "Lcom/squareup/wire/UnknownFieldMap$UnknownFieldType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(548068076, "Lcom/squareup/wire/UnknownFieldMap$UnknownFieldType;");
                    return;
                }
            }
            VARINT = new UnknownFieldType("VARINT", 0);
            FIXED32 = new UnknownFieldType("FIXED32", 1);
            FIXED64 = new UnknownFieldType("FIXED64", 2);
            UnknownFieldType unknownFieldType = new UnknownFieldType("LENGTH_DELIMITED", 3);
            LENGTH_DELIMITED = unknownFieldType;
            ENUM$VALUES = new UnknownFieldType[]{VARINT, FIXED32, FIXED64, unknownFieldType};
        }

        public UnknownFieldType(String str, int i) {
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

        public static UnknownFieldType of(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                if ("varint".equals(str)) {
                    return VARINT;
                }
                if ("fixed32".equals(str)) {
                    return FIXED32;
                }
                if ("fixed64".equals(str)) {
                    return FIXED64;
                }
                if ("length-delimited".equals(str)) {
                    return LENGTH_DELIMITED;
                }
                throw new IllegalArgumentException("Unknown type " + str);
            }
            return (UnknownFieldType) invokeL.objValue;
        }

        public static UnknownFieldType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (UnknownFieldType) Enum.valueOf(UnknownFieldType.class, str) : (UnknownFieldType) invokeL.objValue;
        }

        public static UnknownFieldType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                UnknownFieldType[] unknownFieldTypeArr = ENUM$VALUES;
                int length = unknownFieldTypeArr.length;
                UnknownFieldType[] unknownFieldTypeArr2 = new UnknownFieldType[length];
                System.arraycopy(unknownFieldTypeArr, 0, unknownFieldTypeArr2, 0, length);
                return unknownFieldTypeArr2;
            }
            return (UnknownFieldType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public static final class VarintFieldValue extends FieldValue {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Long value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VarintFieldValue(int i, Long l) {
            super(i, WireType.VARINT);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), l};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), (WireType) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = l;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public Long getAsLong() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : (Long) invokeV.objValue;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public int getSerializedSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? WireOutput.varint64Size(this.value.longValue()) : invokeV.intValue;
        }

        @Override // com.squareup.wire.UnknownFieldMap.FieldValue
        public void write(int i, WireOutput wireOutput) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, wireOutput) == null) {
                wireOutput.writeTag(i, WireType.VARINT);
                wireOutput.writeVarint64(this.value.longValue());
            }
        }
    }

    public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType() {
        int[] iArr = $SWITCH_TABLE$com$squareup$wire$WireType;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[WireType.values().length];
        try {
            iArr2[WireType.END_GROUP.ordinal()] = 5;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[WireType.FIXED32.ordinal()] = 6;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[WireType.FIXED64.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[WireType.LENGTH_DELIMITED.ordinal()] = 3;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[WireType.START_GROUP.ordinal()] = 4;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[WireType.VARINT.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        $SWITCH_TABLE$com$squareup$wire$WireType = iArr2;
        return iArr2;
    }

    public UnknownFieldMap() {
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

    private <T> void addElement(Map<Integer, List<FieldValue>> map, int i, T t, WireType wireType) {
        FieldValue varint;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65539, this, map, i, t, wireType) == null) {
            List<FieldValue> list = map.get(Integer.valueOf(i));
            if (list == null) {
                list = new ArrayList<>();
                map.put(Integer.valueOf(i), list);
            }
            int i2 = $SWITCH_TABLE$com$squareup$wire$WireType()[wireType.ordinal()];
            if (i2 == 1) {
                varint = FieldValue.varint(i, (Long) t);
            } else if (i2 == 2) {
                varint = FieldValue.fixed64(i, (Long) t);
            } else if (i2 == 3) {
                varint = FieldValue.lengthDelimited(i, (ByteString) t);
            } else if (i2 == 6) {
                varint = FieldValue.fixed32(i, (Integer) t);
            } else {
                throw new IllegalArgumentException("Unsupported wireType = " + wireType);
            }
            if (list.size() > 0 && list.get(0).getWireType() != varint.getWireType()) {
                throw new IllegalStateException("Wire type differs from previous type for tag");
            }
            list.add(varint);
        }
    }

    private Map<Integer, List<FieldValue>> ensureFieldMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (this.fieldMap == null) {
                this.fieldMap = new TreeMap();
            }
            return this.fieldMap;
        }
        return (Map) invokeV.objValue;
    }

    public void addFixed32(int i, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, num) == null) {
            addElement(ensureFieldMap(), i, num, WireType.FIXED32);
        }
    }

    public void addFixed64(int i, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, l) == null) {
            addElement(ensureFieldMap(), i, l, WireType.FIXED64);
        }
    }

    public void addLengthDelimited(int i, ByteString byteString) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, byteString) == null) {
            addElement(ensureFieldMap(), i, byteString, WireType.LENGTH_DELIMITED);
        }
    }

    public void addVarint(int i, Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, l) == null) {
            addElement(ensureFieldMap(), i, l, WireType.VARINT);
        }
    }

    public int getSerializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Map<Integer, List<FieldValue>> map = this.fieldMap;
            int i = 0;
            if (map != null) {
                for (Map.Entry<Integer, List<FieldValue>> entry : map.entrySet()) {
                    i += WireOutput.varintTagSize(entry.getKey().intValue());
                    for (FieldValue fieldValue : entry.getValue()) {
                        i += fieldValue.getSerializedSize();
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public void write(WireOutput wireOutput) throws IOException {
        Map<Integer, List<FieldValue>> map;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, wireOutput) == null) || (map = this.fieldMap) == null) {
            return;
        }
        for (Map.Entry<Integer, List<FieldValue>> entry : map.entrySet()) {
            int intValue = entry.getKey().intValue();
            for (FieldValue fieldValue : entry.getValue()) {
                fieldValue.write(intValue, wireOutput);
            }
        }
    }

    public UnknownFieldMap(UnknownFieldMap unknownFieldMap) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {unknownFieldMap};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (unknownFieldMap.fieldMap != null) {
            ensureFieldMap().putAll(unknownFieldMap.fieldMap);
        }
    }
}
