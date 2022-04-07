package com.squareup.wire;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.UnknownFieldMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class Message {
    public static /* synthetic */ Interceptable $ic;
    public static final Wire WIRE;
    public transient /* synthetic */ FieldHolder $fh;
    public transient int cachedSerializedSize;
    public transient int hashCode;
    public transient boolean haveCachedSerializedSize;
    public transient UnknownFieldMap unknownFields;

    /* loaded from: classes7.dex */
    public static abstract class Builder<T extends Message> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public UnknownFieldMap unknownFieldMap;

        public Builder() {
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

        public static <T> List<T> checkForNulls(List<T> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
                if (list != null && !list.isEmpty()) {
                    for (T t : list) {
                        if (t == null) {
                            throw null;
                        }
                    }
                }
                return list;
            }
            return (List) invokeL.objValue;
        }

        private UnknownFieldMap ensureUnknownFieldMap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
                if (this.unknownFieldMap == null) {
                    this.unknownFieldMap = new UnknownFieldMap();
                }
                return this.unknownFieldMap;
            }
            return (UnknownFieldMap) invokeV.objValue;
        }

        public void addFixed32(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                ensureUnknownFieldMap().addFixed32(i, Integer.valueOf(i2));
            }
        }

        public void addFixed64(int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
                ensureUnknownFieldMap().addFixed64(i, Long.valueOf(j));
            }
        }

        public void addLengthDelimited(int i, ByteString byteString) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, byteString) == null) {
                ensureUnknownFieldMap().addLengthDelimited(i, byteString);
            }
        }

        public void addVarint(int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
                ensureUnknownFieldMap().addVarint(i, Long.valueOf(j));
            }
        }

        public abstract T build(boolean z);

        public void checkRequiredFields() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                Message.WIRE.builderAdapter(getClass()).checkRequiredFields(this);
            }
        }

        public Builder(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {message};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (message == null || message.unknownFields == null) {
                return;
            }
            this.unknownFieldMap = new UnknownFieldMap(message.unknownFields);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Datatype {
        public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$Message$Datatype;
        public static /* synthetic */ Interceptable $ic;
        public static final Datatype BOOL;
        public static final Datatype BYTES;
        public static final Datatype DOUBLE;
        public static final Datatype ENUM;
        public static final /* synthetic */ Datatype[] ENUM$VALUES;
        public static final Datatype FIXED32;
        public static final Datatype FIXED64;
        public static final Datatype FLOAT;
        public static final Datatype INT32;
        public static final Datatype INT64;
        public static final Datatype MESSAGE;
        public static final Comparator<Datatype> ORDER_BY_NAME;
        public static final Datatype SFIXED32;
        public static final Datatype SFIXED64;
        public static final Datatype SINT32;
        public static final Datatype SINT64;
        public static final Datatype STRING;
        public static final Map<String, Datatype> TYPES_BY_NAME;
        public static final Datatype UINT32;
        public static final Datatype UINT64;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$Message$Datatype() {
            int[] iArr = $SWITCH_TABLE$com$squareup$wire$Message$Datatype;
            if (iArr != null) {
                return iArr;
            }
            int[] iArr2 = new int[values().length];
            try {
                iArr2[BOOL.ordinal()] = 7;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr2[BYTES.ordinal()] = 10;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[DOUBLE.ordinal()] = 17;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FIXED64.ordinal()] = 14;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[FLOAT.ordinal()] = 16;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[INT32.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[INT64.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[MESSAGE.ordinal()] = 11;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[SFIXED32.ordinal()] = 13;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[SINT64.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[UINT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused17) {
            }
            $SWITCH_TABLE$com$squareup$wire$Message$Datatype = iArr2;
            return iArr2;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-658930099, "Lcom/squareup/wire/Message$Datatype;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-658930099, "Lcom/squareup/wire/Message$Datatype;");
                    return;
                }
            }
            INT32 = new Datatype("INT32", 0, 1);
            INT64 = new Datatype("INT64", 1, 2);
            UINT32 = new Datatype("UINT32", 2, 3);
            UINT64 = new Datatype("UINT64", 3, 4);
            SINT32 = new Datatype("SINT32", 4, 5);
            SINT64 = new Datatype("SINT64", 5, 6);
            BOOL = new Datatype("BOOL", 6, 7);
            ENUM = new Datatype("ENUM", 7, 8);
            STRING = new Datatype("STRING", 8, 9);
            BYTES = new Datatype("BYTES", 9, 10);
            MESSAGE = new Datatype("MESSAGE", 10, 11);
            FIXED32 = new Datatype("FIXED32", 11, 12);
            SFIXED32 = new Datatype("SFIXED32", 12, 13);
            FIXED64 = new Datatype("FIXED64", 13, 14);
            SFIXED64 = new Datatype("SFIXED64", 14, 15);
            FLOAT = new Datatype("FLOAT", 15, 16);
            Datatype datatype = new Datatype("DOUBLE", 16, 17);
            DOUBLE = datatype;
            ENUM$VALUES = new Datatype[]{INT32, INT64, UINT32, UINT64, SINT32, SINT64, BOOL, ENUM, STRING, BYTES, MESSAGE, FIXED32, SFIXED32, FIXED64, SFIXED64, FLOAT, datatype};
            ORDER_BY_NAME = new Comparator<Datatype>() { // from class: com.squareup.wire.Message.Datatype.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(Datatype datatype2, Datatype datatype3) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, datatype2, datatype3)) == null) ? datatype2.name().compareTo(datatype3.name()) : invokeLL.intValue;
                }
            };
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            TYPES_BY_NAME = linkedHashMap;
            linkedHashMap.put("int32", INT32);
            TYPES_BY_NAME.put("int64", INT64);
            TYPES_BY_NAME.put("uint32", UINT32);
            TYPES_BY_NAME.put("uint64", UINT64);
            TYPES_BY_NAME.put("sint32", SINT32);
            TYPES_BY_NAME.put("sint64", SINT64);
            TYPES_BY_NAME.put("bool", BOOL);
            TYPES_BY_NAME.put("enum", ENUM);
            TYPES_BY_NAME.put(EMABTest.TYPE_STRING, STRING);
            TYPES_BY_NAME.put("bytes", BYTES);
            TYPES_BY_NAME.put("message", MESSAGE);
            TYPES_BY_NAME.put("fixed32", FIXED32);
            TYPES_BY_NAME.put("sfixed32", SFIXED32);
            TYPES_BY_NAME.put("fixed64", FIXED64);
            TYPES_BY_NAME.put("sfixed64", SFIXED64);
            TYPES_BY_NAME.put(ShaderParams.VALUE_TYPE_FLOAT, FLOAT);
            TYPES_BY_NAME.put("double", DOUBLE);
        }

        public Datatype(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.value = i2;
        }

        public static Datatype of(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? TYPES_BY_NAME.get(str) : (Datatype) invokeL.objValue;
        }

        public static Datatype valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) ? (Datatype) Enum.valueOf(Datatype.class, str) : (Datatype) invokeL.objValue;
        }

        public static Datatype[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
                Datatype[] datatypeArr = ENUM$VALUES;
                int length = datatypeArr.length;
                Datatype[] datatypeArr2 = new Datatype[length];
                System.arraycopy(datatypeArr, 0, datatypeArr2, 0, length);
                return datatypeArr2;
            }
            return (Datatype[]) invokeV.objValue;
        }

        public int value() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }

        public WireType wireType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                switch ($SWITCH_TABLE$com$squareup$wire$Message$Datatype()[ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        return WireType.VARINT;
                    case 9:
                    case 10:
                    case 11:
                        return WireType.LENGTH_DELIMITED;
                    case 12:
                    case 13:
                    case 16:
                        return WireType.FIXED32;
                    case 14:
                    case 15:
                    case 17:
                        return WireType.FIXED64;
                    default:
                        throw new AssertionError("No wiretype for datatype " + this);
                }
            }
            return (WireType) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class Label {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ Label[] ENUM$VALUES;
        public static final Label OPTIONAL;
        public static final Comparator<Label> ORDER_BY_NAME;
        public static final Label PACKED;
        public static final Label REPEATED;
        public static final Label REQUIRED;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1839063023, "Lcom/squareup/wire/Message$Label;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1839063023, "Lcom/squareup/wire/Message$Label;");
                    return;
                }
            }
            REQUIRED = new Label("REQUIRED", 0, 32);
            OPTIONAL = new Label("OPTIONAL", 1, 64);
            REPEATED = new Label("REPEATED", 2, 128);
            Label label = new Label("PACKED", 3, 256);
            PACKED = label;
            ENUM$VALUES = new Label[]{REQUIRED, OPTIONAL, REPEATED, label};
            ORDER_BY_NAME = new Comparator<Label>() { // from class: com.squareup.wire.Message.Label.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // java.util.Comparator
                public int compare(Label label2, Label label3) {
                    InterceptResult invokeLL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, label2, label3)) == null) ? label2.name().compareTo(label3.name()) : invokeLL.intValue;
                }
            };
        }

        public Label(String str, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i2;
        }

        public static Label valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Label) Enum.valueOf(Label.class, str) : (Label) invokeL.objValue;
        }

        public static Label[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                Label[] labelArr = ENUM$VALUES;
                int length = labelArr.length;
                Label[] labelArr2 = new Label[length];
                System.arraycopy(labelArr, 0, labelArr2, 0, length);
                return labelArr2;
            }
            return (Label[]) invokeV.objValue;
        }

        public boolean isPacked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this == PACKED : invokeV.booleanValue;
        }

        public boolean isRepeated() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this == REPEATED || this == PACKED : invokeV.booleanValue;
        }

        public int value() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-775832639, "Lcom/squareup/wire/Message;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-775832639, "Lcom/squareup/wire/Message;");
                return;
            }
        }
        WIRE = new Wire(new Class[0]);
    }

    public Message(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hashCode = 0;
        UnknownFieldMap unknownFieldMap = builder.unknownFieldMap;
        if (unknownFieldMap != null) {
            this.unknownFields = new UnknownFieldMap(unknownFieldMap);
        }
    }

    public static <T> List<T> asList(T... tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, tArr)) == null) ? Arrays.asList(tArr) : (List) invokeL.objValue;
    }

    public static <T> List<T> copyOf(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, list)) == null) {
            if (list == null) {
                return null;
            }
            return new ArrayList(list);
        }
        return (List) invokeL.objValue;
    }

    public static <E extends Enum & ProtoEnum> E enumFromInt(Class<E> cls, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, cls, i)) == null) ? (E) ((Enum) WIRE.enumAdapter(cls).fromInt(i)) : (E) ((Enum) invokeLI.objValue);
    }

    public static <T> List<T> immutableCopyOf(List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, list)) == null) {
            if (list == null) {
                return Collections.emptyList();
            }
            return Collections.unmodifiableList(new ArrayList(list));
        }
        return (List) invokeL.objValue;
    }

    public static <E extends Enum & ProtoEnum> int intFromEnum(E e) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, e)) == null) ? WIRE.enumAdapter(e.getClass()).toInt(e) : invokeL.intValue;
    }

    private void write(WireOutput wireOutput) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, this, wireOutput) == null) {
            try {
                WIRE.messageAdapter(getClass()).write(this, wireOutput);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean equals(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, obj2)) == null) {
            if (obj != obj2) {
                return obj != null && obj.equals(obj2);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public int getSerializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (!this.haveCachedSerializedSize) {
                this.cachedSerializedSize = WIRE.messageAdapter(getClass()).getSerializedSize(this);
                this.haveCachedSerializedSize = true;
            }
            return this.cachedSerializedSize;
        }
        return invokeV.intValue;
    }

    public int getUnknownFieldsSerializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            UnknownFieldMap unknownFieldMap = this.unknownFields;
            if (unknownFieldMap == null) {
                return 0;
            }
            return unknownFieldMap.getSerializedSize();
        }
        return invokeV.intValue;
    }

    public byte[] toByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? WIRE.messageAdapter(getClass()).toByteArray(this) : (byte[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? WIRE.messageAdapter(getClass()).toString(this) : (String) invokeV.objValue;
    }

    public Collection<List<UnknownFieldMap.FieldValue>> unknownFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            UnknownFieldMap unknownFieldMap = this.unknownFields;
            return unknownFieldMap == null ? Collections.emptySet() : unknownFieldMap.fieldMap.values();
        }
        return (Collection) invokeV.objValue;
    }

    public void writeTo(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bArr) == null) {
            writeTo(bArr, 0, bArr.length);
        }
    }

    public void writeUnknownFieldMap(WireOutput wireOutput) throws IOException {
        UnknownFieldMap unknownFieldMap;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, wireOutput) == null) || (unknownFieldMap = this.unknownFields) == null) {
            return;
        }
        unknownFieldMap.write(wireOutput);
    }

    public boolean equals(List<?> list, List<?> list2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list, list2)) == null) {
            if (list != null && list.isEmpty()) {
                list = null;
            }
            if (list2 != null && list2.isEmpty()) {
                list2 = null;
            }
            if (list != list2) {
                return list != null && list.equals(list2);
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void writeTo(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TOUCHPAD, this, bArr, i, i2) == null) {
            write(WireOutput.newInstance(bArr, i, i2));
        }
    }
}
