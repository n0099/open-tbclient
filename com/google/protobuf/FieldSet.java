package com.google.protobuf;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.protobuf.FieldSet.FieldDescriptorLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyField;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes7.dex */
public final class FieldSet<FieldDescriptorType extends FieldDescriptorLite<FieldDescriptorType>> {
    public static /* synthetic */ Interceptable $ic;
    public static final FieldSet DEFAULT_INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public final SmallSortedMap<FieldDescriptorType, Object> fields;
    public boolean hasLazyField;
    public boolean isImmutable;

    /* loaded from: classes7.dex */
    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        Internal.EnumLiteMap<?> getEnumType();

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        MessageLite.Builder internalMergeFrom(MessageLite.Builder builder, MessageLite messageLite);

        boolean isPacked();

        boolean isRepeated();
    }

    /* renamed from: com.google.protobuf.FieldSet$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;
        public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-333752482, "Lcom/google/protobuf/FieldSet$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-333752482, "Lcom/google/protobuf/FieldSet$1;");
                    return;
                }
            }
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.GROUP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$JavaType = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$JavaType[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1385820597, "Lcom/google/protobuf/FieldSet;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1385820597, "Lcom/google/protobuf/FieldSet;");
                return;
            }
        }
        DEFAULT_INSTANCE = new FieldSet(true);
    }

    public FieldSet() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(16);
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> emptySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return DEFAULT_INSTANCE;
        }
        return (FieldSet) invokeV.objValue;
    }

    public static <T extends FieldDescriptorLite<T>> FieldSet<T> newFieldSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            return new FieldSet<>();
        }
        return (FieldSet) invokeV.objValue;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.fields.clear();
            this.hasLazyField = false;
        }
    }

    public boolean isImmutable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.isImmutable;
        }
        return invokeV.booleanValue;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.hasLazyField) {
                return new LazyField.LazyIterator(this.fields.entrySet().iterator());
            }
            return this.fields.entrySet().iterator();
        }
        return (Iterator) invokeV.objValue;
    }

    public void makeImmutable() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048591, this) != null) || this.isImmutable) {
            return;
        }
        this.fields.makeImmutable();
        this.isImmutable = true;
    }

    public FieldSet(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.hasLazyField = false;
        this.fields = SmallSortedMap.newFieldMap(0);
        makeImmutable();
    }

    public void mergeFrom(FieldSet<FieldDescriptorType> fieldSet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fieldSet) == null) {
            for (int i = 0; i < fieldSet.fields.getNumArrayEntries(); i++) {
                mergeFromField(fieldSet.fields.getArrayEntryAt(i));
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : fieldSet.fields.getOverflowEntries()) {
                mergeFromField(entry);
            }
        }
    }

    public void writeMessageSetTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, codedOutputStream) == null) {
            for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
                writeMessageSetTo(this.fields.getArrayEntryAt(i), codedOutputStream);
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
                writeMessageSetTo(entry, codedOutputStream);
            }
        }
    }

    private void cloneFieldEntry(Map<FieldDescriptorType, Object> map, Map.Entry<FieldDescriptorType, Object> entry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, map, entry) == null) {
            FieldDescriptorType key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof LazyField) {
                map.put(key, ((LazyField) value).getValue());
            } else {
                map.put(key, value);
            }
        }
    }

    public static int getWireFormatForFieldType(WireFormat.FieldType fieldType, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65545, null, fieldType, z)) == null) {
            if (z) {
                return 2;
            }
            return fieldType.getWireType();
        }
        return invokeLZ.intValue;
    }

    public Object getRepeatedField(FieldDescriptorType fielddescriptortype, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, fielddescriptortype, i)) == null) {
            if (fielddescriptortype.isRepeated()) {
                Object field = getField(fielddescriptortype);
                if (field != null) {
                    return ((List) field).get(i);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        return invokeLI.objValue;
    }

    public static int computeElementSize(WireFormat.FieldType fieldType, int i, Object obj) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, fieldType, i, obj)) == null) {
            int computeTagSize = CodedOutputStream.computeTagSize(i);
            if (fieldType == WireFormat.FieldType.GROUP) {
                computeTagSize *= 2;
            }
            return computeTagSize + computeElementSizeNoTag(fieldType, obj);
        }
        return invokeLIL.intValue;
    }

    public static int computeElementSizeNoTag(WireFormat.FieldType fieldType, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, fieldType, obj)) == null) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
                case 1:
                    return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
                case 2:
                    return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
                case 3:
                    return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
                case 4:
                    return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
                case 5:
                    return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
                case 6:
                    return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
                case 7:
                    return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
                case 8:
                    return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
                case 9:
                    return CodedOutputStream.computeStringSizeNoTag((String) obj);
                case 10:
                    return CodedOutputStream.computeBytesSizeNoTag((ByteString) obj);
                case 11:
                    return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
                case 12:
                    return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
                case 13:
                    return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
                case 14:
                    return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
                case 15:
                    return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
                case 16:
                    return CodedOutputStream.computeGroupSizeNoTag((MessageLite) obj);
                case 17:
                    if (obj instanceof LazyField) {
                        return CodedOutputStream.computeLazyFieldSizeNoTag((LazyField) obj);
                    }
                    return CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
                case 18:
                    return CodedOutputStream.computeEnumSizeNoTag(((Internal.EnumLite) obj).getNumber());
                default:
                    throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
        }
        return invokeLL.intValue;
    }

    public static Object readPrimitiveField(CodedInputStream codedInputStream, WireFormat.FieldType fieldType) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, codedInputStream, fieldType)) == null) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
                case 1:
                    return Double.valueOf(codedInputStream.readDouble());
                case 2:
                    return Float.valueOf(codedInputStream.readFloat());
                case 3:
                    return Long.valueOf(codedInputStream.readInt64());
                case 4:
                    return Long.valueOf(codedInputStream.readUInt64());
                case 5:
                    return Integer.valueOf(codedInputStream.readInt32());
                case 6:
                    return Long.valueOf(codedInputStream.readFixed64());
                case 7:
                    return Integer.valueOf(codedInputStream.readFixed32());
                case 8:
                    return Boolean.valueOf(codedInputStream.readBool());
                case 9:
                    return codedInputStream.readString();
                case 10:
                    return codedInputStream.readBytes();
                case 11:
                    return Integer.valueOf(codedInputStream.readUInt32());
                case 12:
                    return Integer.valueOf(codedInputStream.readSFixed32());
                case 13:
                    return Long.valueOf(codedInputStream.readSFixed64());
                case 14:
                    return Integer.valueOf(codedInputStream.readSInt32());
                case 15:
                    return Long.valueOf(codedInputStream.readSInt64());
                case 16:
                    throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
                case 17:
                    throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
                case 18:
                    throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
                default:
                    throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
        }
        return invokeLL.objValue;
    }

    public static int computeFieldSize(FieldDescriptorLite<?> fieldDescriptorLite, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, fieldDescriptorLite, obj)) == null) {
            WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
            int number = fieldDescriptorLite.getNumber();
            if (fieldDescriptorLite.isRepeated()) {
                int i = 0;
                if (fieldDescriptorLite.isPacked()) {
                    for (Object obj2 : (List) obj) {
                        i += computeElementSizeNoTag(liteType, obj2);
                    }
                    return CodedOutputStream.computeTagSize(number) + i + CodedOutputStream.computeRawVarint32Size(i);
                }
                for (Object obj3 : (List) obj) {
                    i += computeElementSize(liteType, number, obj3);
                }
                return i;
            }
            return computeElementSize(liteType, number, obj);
        }
        return invokeLL.intValue;
    }

    public static void verifyType(WireFormat.FieldType fieldType, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, fieldType, obj) == null) {
            if (obj != null) {
                boolean z = false;
                switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$JavaType[fieldType.getJavaType().ordinal()]) {
                    case 1:
                        z = obj instanceof Integer;
                        break;
                    case 2:
                        z = obj instanceof Long;
                        break;
                    case 3:
                        z = obj instanceof Float;
                        break;
                    case 4:
                        z = obj instanceof Double;
                        break;
                    case 5:
                        z = obj instanceof Boolean;
                        break;
                    case 6:
                        z = obj instanceof String;
                        break;
                    case 7:
                        z = obj instanceof ByteString;
                        break;
                    case 8:
                        z = obj instanceof Internal.EnumLite;
                        break;
                    case 9:
                        if ((obj instanceof MessageLite) || (obj instanceof LazyField)) {
                            z = true;
                            break;
                        }
                        break;
                }
                if (z) {
                    return;
                }
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            throw null;
        }
    }

    private int getMessageSetSerializedSize(Map.Entry<FieldDescriptorType, Object> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, entry)) == null) {
            FieldDescriptorType key = entry.getKey();
            Object value = entry.getValue();
            if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated() && !key.isPacked()) {
                if (value instanceof LazyField) {
                    return CodedOutputStream.computeLazyFieldMessageSetExtensionSize(entry.getKey().getNumber(), (LazyField) value);
                }
                return CodedOutputStream.computeMessageSetExtensionSize(entry.getKey().getNumber(), (MessageLite) value);
            }
            return computeFieldSize(key, value);
        }
        return invokeL.intValue;
    }

    private boolean isInitialized(Map.Entry<FieldDescriptorType, Object> entry) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, this, entry)) == null) {
            FieldDescriptorType key = entry.getKey();
            if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
                if (key.isRepeated()) {
                    for (MessageLite messageLite : (List) entry.getValue()) {
                        if (!messageLite.isInitialized()) {
                            return false;
                        }
                    }
                } else {
                    Object value = entry.getValue();
                    if (value instanceof MessageLite) {
                        if (!((MessageLite) value).isInitialized()) {
                            return false;
                        }
                    } else if (value instanceof LazyField) {
                        return true;
                    } else {
                        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, codedOutputStream) == null) {
            for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
                Map.Entry<FieldDescriptorType, Object> arrayEntryAt = this.fields.getArrayEntryAt(i);
                writeField(arrayEntryAt.getKey(), arrayEntryAt.getValue(), codedOutputStream);
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
                writeField(entry.getKey(), entry.getValue(), codedOutputStream);
            }
        }
    }

    private void mergeFromField(Map.Entry<FieldDescriptorType, Object> entry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, entry) == null) {
            FieldDescriptorType key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof LazyField) {
                value = ((LazyField) value).getValue();
            }
            if (key.isRepeated()) {
                Object field = getField(key);
                if (field == null) {
                    this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) key, (FieldDescriptorType) new ArrayList((List) value));
                } else {
                    ((List) field).addAll((List) value);
                }
            } else if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
                Object field2 = getField(key);
                if (field2 == null) {
                    this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) key, (FieldDescriptorType) value);
                } else {
                    this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) key, (FieldDescriptorType) key.internalMergeFrom(((MessageLite) field2).toBuilder(), (MessageLite) value).build());
                }
            } else {
                this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) key, (FieldDescriptorType) value);
            }
        }
    }

    public static void writeElement(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i, Object obj) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65551, null, codedOutputStream, fieldType, i, obj) == null) {
            if (fieldType == WireFormat.FieldType.GROUP) {
                codedOutputStream.writeGroup(i, (MessageLite) obj);
                return;
            }
            codedOutputStream.writeTag(i, getWireFormatForFieldType(fieldType, false));
            writeElementNoTag(codedOutputStream, fieldType, obj);
        }
    }

    public static void writeElementNoTag(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65552, null, codedOutputStream, fieldType, obj) == null) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
                case 1:
                    codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                    return;
                case 2:
                    codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                    return;
                case 3:
                    codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                    return;
                case 4:
                    codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                    return;
                case 5:
                    codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                    return;
                case 6:
                    codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                    return;
                case 7:
                    codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                    return;
                case 8:
                    codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                    return;
                case 9:
                    codedOutputStream.writeStringNoTag((String) obj);
                    return;
                case 10:
                    codedOutputStream.writeBytesNoTag((ByteString) obj);
                    return;
                case 11:
                    codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                    return;
                case 12:
                    codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                    return;
                case 13:
                    codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                    return;
                case 14:
                    codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                    return;
                case 15:
                    codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                    return;
                case 16:
                    codedOutputStream.writeGroupNoTag((MessageLite) obj);
                    return;
                case 17:
                    codedOutputStream.writeMessageNoTag((MessageLite) obj);
                    return;
                case 18:
                    codedOutputStream.writeEnumNoTag(((Internal.EnumLite) obj).getNumber());
                    return;
                default:
                    return;
            }
        }
    }

    public static void writeField(FieldDescriptorLite<?> fieldDescriptorLite, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, null, fieldDescriptorLite, obj, codedOutputStream) == null) {
            WireFormat.FieldType liteType = fieldDescriptorLite.getLiteType();
            int number = fieldDescriptorLite.getNumber();
            if (fieldDescriptorLite.isRepeated()) {
                List<Object> list = (List) obj;
                if (fieldDescriptorLite.isPacked()) {
                    codedOutputStream.writeTag(number, 2);
                    int i = 0;
                    for (Object obj2 : list) {
                        i += computeElementSizeNoTag(liteType, obj2);
                    }
                    codedOutputStream.writeRawVarint32(i);
                    for (Object obj3 : list) {
                        writeElementNoTag(codedOutputStream, liteType, obj3);
                    }
                    return;
                }
                for (Object obj4 : list) {
                    writeElement(codedOutputStream, liteType, number, obj4);
                }
            } else if (obj instanceof LazyField) {
                writeElement(codedOutputStream, liteType, number, ((LazyField) obj).getValue());
            } else {
                writeElement(codedOutputStream, liteType, number, obj);
            }
        }
    }

    private void writeMessageSetTo(Map.Entry<FieldDescriptorType, Object> entry, CodedOutputStream codedOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65554, this, entry, codedOutputStream) == null) {
            FieldDescriptorType key = entry.getKey();
            if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE && !key.isRepeated() && !key.isPacked()) {
                codedOutputStream.writeMessageSetExtension(entry.getKey().getNumber(), (MessageLite) entry.getValue());
            } else {
                writeField(key, entry.getValue(), codedOutputStream);
            }
        }
    }

    public void addRepeatedField(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, fielddescriptortype, obj) == null) {
            if (fielddescriptortype.isRepeated()) {
                verifyType(fielddescriptortype.getLiteType(), obj);
                Object field = getField(fielddescriptortype);
                if (field == null) {
                    list = new ArrayList();
                    this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) list);
                } else {
                    list = (List) field;
                }
                list.add(obj);
                return;
            }
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
    }

    public void clearField(FieldDescriptorType fielddescriptortype) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fielddescriptortype) == null) {
            this.fields.remove(fielddescriptortype);
            if (this.fields.isEmpty()) {
                this.hasLazyField = false;
            }
        }
    }

    public Object getField(FieldDescriptorType fielddescriptortype) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fielddescriptortype)) == null) {
            Object obj = this.fields.get(fielddescriptortype);
            if (obj instanceof LazyField) {
                return ((LazyField) obj).getValue();
            }
            return obj;
        }
        return invokeL.objValue;
    }

    public int getRepeatedFieldCount(FieldDescriptorType fielddescriptortype) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, fielddescriptortype)) == null) {
            if (fielddescriptortype.isRepeated()) {
                Object field = getField(fielddescriptortype);
                if (field == null) {
                    return 0;
                }
                return ((List) field).size();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        return invokeL.intValue;
    }

    public boolean hasField(FieldDescriptorType fielddescriptortype) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fielddescriptortype)) == null) {
            if (!fielddescriptortype.isRepeated()) {
                if (this.fields.get(fielddescriptortype) != null) {
                    return true;
                }
                return false;
            }
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public FieldSet<FieldDescriptorType> m79clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            FieldSet<FieldDescriptorType> newFieldSet = newFieldSet();
            for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
                Map.Entry<FieldDescriptorType, Object> arrayEntryAt = this.fields.getArrayEntryAt(i);
                newFieldSet.setField(arrayEntryAt.getKey(), arrayEntryAt.getValue());
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
                newFieldSet.setField(entry.getKey(), entry.getValue());
            }
            newFieldSet.hasLazyField = this.hasLazyField;
            return newFieldSet;
        }
        return (FieldSet) invokeV.objValue;
    }

    public int getSerializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
                Map.Entry<FieldDescriptorType, Object> arrayEntryAt = this.fields.getArrayEntryAt(i2);
                i += computeFieldSize(arrayEntryAt.getKey(), arrayEntryAt.getValue());
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
                i += computeFieldSize(entry.getKey(), entry.getValue());
            }
            return i;
        }
        return invokeV.intValue;
    }

    public boolean isInitialized() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
                if (!isInitialized(this.fields.getArrayEntryAt(i))) {
                    return false;
                }
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
                if (!isInitialized(entry)) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public Map<FieldDescriptorType, Object> getAllFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.hasLazyField) {
                SmallSortedMap newFieldMap = SmallSortedMap.newFieldMap(16);
                for (int i = 0; i < this.fields.getNumArrayEntries(); i++) {
                    cloneFieldEntry(newFieldMap, this.fields.getArrayEntryAt(i));
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
                    cloneFieldEntry(newFieldMap, entry);
                }
                if (this.fields.isImmutable()) {
                    newFieldMap.makeImmutable();
                }
                return newFieldMap;
            } else if (this.fields.isImmutable()) {
                return this.fields;
            } else {
                return Collections.unmodifiableMap(this.fields);
            }
        }
        return (Map) invokeV.objValue;
    }

    public int getMessageSetSerializedSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < this.fields.getNumArrayEntries(); i2++) {
                i += getMessageSetSerializedSize(this.fields.getArrayEntryAt(i2));
            }
            for (Map.Entry<FieldDescriptorType, Object> entry : this.fields.getOverflowEntries()) {
                i += getMessageSetSerializedSize(entry);
            }
            return i;
        }
        return invokeV.intValue;
    }

    public void setField(FieldDescriptorType fielddescriptortype, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, fielddescriptortype, obj) == null) {
            if (fielddescriptortype.isRepeated()) {
                if (obj instanceof List) {
                    ArrayList<Object> arrayList = new ArrayList();
                    arrayList.addAll((List) obj);
                    for (Object obj2 : arrayList) {
                        verifyType(fielddescriptortype.getLiteType(), obj2);
                    }
                    obj = arrayList;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            } else {
                verifyType(fielddescriptortype.getLiteType(), obj);
            }
            if (obj instanceof LazyField) {
                this.hasLazyField = true;
            }
            this.fields.put((SmallSortedMap<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
        }
    }

    public void setRepeatedField(FieldDescriptorType fielddescriptortype, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048594, this, fielddescriptortype, i, obj) == null) {
            if (fielddescriptortype.isRepeated()) {
                Object field = getField(fielddescriptortype);
                if (field != null) {
                    verifyType(fielddescriptortype.getLiteType(), obj);
                    ((List) field).set(i, obj);
                    return;
                }
                throw new IndexOutOfBoundsException();
            }
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
    }
}
