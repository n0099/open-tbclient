package com.squareup.wire;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public final class MessageAdapter<M extends Message> {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$Message$Datatype;
    public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType;
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Class<Message.Builder<M>> builderType;
    public final Map<Integer, FieldInfo> fieldInfoMap;
    public final Class<M> messageType;
    public final Map<String, Integer> tagMap;
    public final Wire wire;

    /* loaded from: classes8.dex */
    public static final class FieldInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Field builderMethod;
        public final Message.Datatype datatype;
        public final Class<? extends ProtoEnum> enumType;
        public final Message.Label label;
        public final Field messageField;
        public final Class<? extends Message> messageType;
        public final String name;
        public final int tag;

        public FieldInfo(int i, String str, Message.Datatype datatype, Message.Label label, Class<?> cls, Field field, Field field2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), str, datatype, label, cls, field, field2};
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
            this.name = str;
            this.datatype = datatype;
            this.label = label;
            if (datatype == Message.Datatype.ENUM) {
                this.enumType = cls;
                this.messageType = null;
            } else if (datatype == Message.Datatype.MESSAGE) {
                this.messageType = cls;
                this.enumType = null;
            } else {
                this.enumType = null;
                this.messageType = null;
            }
            this.messageField = field;
            this.builderMethod = field2;
        }

        public /* synthetic */ FieldInfo(int i, String str, Message.Datatype datatype, Message.Label label, Class cls, Field field, Field field2, FieldInfo fieldInfo) {
            this(i, str, datatype, label, cls, field, field2);
        }
    }

    /* loaded from: classes8.dex */
    public static class Storage {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Map<Integer, List<Object>> map;

        public Storage() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.map = new LinkedHashMap();
        }

        public Set<Integer> getTags() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.map.keySet();
            }
            return (Set) invokeV.objValue;
        }

        public /* synthetic */ Storage(Storage storage) {
            this();
        }

        public List<Object> get(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                return this.map.get(Integer.valueOf(i));
            }
            return (List) invokeI.objValue;
        }

        public void add(int i, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, obj) == null) {
                List<Object> list = this.map.get(Integer.valueOf(i));
                if (list == null) {
                    list = new ArrayList<>();
                    this.map.put(Integer.valueOf(i), list);
                }
                list.add(obj);
            }
        }
    }

    public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$Message$Datatype() {
        int[] iArr = $SWITCH_TABLE$com$squareup$wire$Message$Datatype;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Message.Datatype.values().length];
        try {
            iArr2[Message.Datatype.BOOL.ordinal()] = 7;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[Message.Datatype.BYTES.ordinal()] = 10;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[Message.Datatype.DOUBLE.ordinal()] = 17;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[Message.Datatype.ENUM.ordinal()] = 8;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[Message.Datatype.FIXED32.ordinal()] = 12;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[Message.Datatype.FIXED64.ordinal()] = 14;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[Message.Datatype.FLOAT.ordinal()] = 16;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[Message.Datatype.INT32.ordinal()] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[Message.Datatype.INT64.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[Message.Datatype.MESSAGE.ordinal()] = 11;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            iArr2[Message.Datatype.SFIXED32.ordinal()] = 13;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            iArr2[Message.Datatype.SFIXED64.ordinal()] = 15;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            iArr2[Message.Datatype.SINT32.ordinal()] = 5;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            iArr2[Message.Datatype.SINT64.ordinal()] = 6;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            iArr2[Message.Datatype.STRING.ordinal()] = 9;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            iArr2[Message.Datatype.UINT32.ordinal()] = 3;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            iArr2[Message.Datatype.UINT64.ordinal()] = 4;
        } catch (NoSuchFieldError unused17) {
        }
        $SWITCH_TABLE$com$squareup$wire$Message$Datatype = iArr2;
        return iArr2;
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

    public MessageAdapter(Wire wire, Class<M> cls) {
        Field[] declaredFields;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {wire, cls};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.tagMap = new LinkedHashMap();
        this.fieldInfoMap = new LinkedHashMap();
        this.wire = wire;
        this.messageType = cls;
        this.builderType = getBuilderType(cls);
        for (Field field : cls.getDeclaredFields()) {
            ProtoField protoField = (ProtoField) field.getAnnotation(ProtoField.class);
            if (protoField != null) {
                int tag = protoField.tag();
                String name = field.getName();
                this.tagMap.put(name, Integer.valueOf(tag));
                Class cls2 = null;
                Message.Datatype type = protoField.type();
                if (type == Message.Datatype.ENUM) {
                    cls2 = getEnumType(field);
                } else if (type == Message.Datatype.MESSAGE) {
                    cls2 = getMessageType(field);
                }
                this.fieldInfoMap.put(Integer.valueOf(tag), new FieldInfo(tag, name, type, protoField.label(), cls2, field, getBuilderMethod(name, field.getType()), null));
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.squareup.wire.MessageAdapter<M extends com.squareup.wire.Message> */
    /* JADX WARN: Multi-variable type inference failed */
    private int getSerializedSizeNoTag(Object obj, Message.Datatype datatype) {
        InterceptResult invokeLL;
        int utf8Length;
        int varint32Size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, this, obj, datatype)) == null) {
            switch ($SWITCH_TABLE$com$squareup$wire$Message$Datatype()[datatype.ordinal()]) {
                case 1:
                    return WireOutput.int32Size(((Integer) obj).intValue());
                case 2:
                case 4:
                    return WireOutput.varint64Size(((Long) obj).longValue());
                case 3:
                    return WireOutput.varint32Size(((Integer) obj).intValue());
                case 5:
                    return WireOutput.varint32Size(WireOutput.zigZag32(((Integer) obj).intValue()));
                case 6:
                    return WireOutput.varint64Size(WireOutput.zigZag64(((Long) obj).longValue()));
                case 7:
                    return 1;
                case 8:
                    return getEnumSize((ProtoEnum) obj);
                case 9:
                    utf8Length = utf8Length((String) obj);
                    varint32Size = WireOutput.varint32Size(utf8Length);
                    break;
                case 10:
                    utf8Length = ((ByteString) obj).size();
                    varint32Size = WireOutput.varint32Size(utf8Length);
                    break;
                case 11:
                    return getMessageSize((Message) obj);
                case 12:
                case 13:
                case 16:
                    return 4;
                case 14:
                case 15:
                case 17:
                    return 8;
                default:
                    throw new RuntimeException();
            }
            return varint32Size + utf8Length;
        }
        return invokeLL.intValue;
    }

    private Field getBuilderMethod(String str, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, cls)) == null) {
            try {
                return this.builderType.getDeclaredField(str);
            } catch (Exception unused) {
                throw new AssertionError("No builder Field " + this.builderType.getName() + "." + str + "(" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
        return (Field) invokeLL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.squareup.wire.Wire */
    /* JADX WARN: Multi-variable type inference failed */
    private Message readMessage(WireInput wireInput, int i) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65553, this, wireInput, i)) == null) {
            int readVarint32 = wireInput.readVarint32();
            if (wireInput.recursionDepth < 64) {
                int pushLimit = wireInput.pushLimit(readVarint32);
                wireInput.recursionDepth++;
                Message read = this.wire.messageAdapter(getMessageClass(i)).read(wireInput);
                wireInput.checkLastTagWas(0);
                wireInput.recursionDepth--;
                wireInput.popLimit(pushLimit);
                return read;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        return (Message) invokeLI.objValue;
    }

    private <T extends ExtendableMessage<?>> void writeExtensions(WireOutput wireOutput, ExtensionMap<T> extensionMap) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, this, wireOutput, extensionMap) == null) {
            for (Extension<T, ?> extension : extensionMap.getExtensions()) {
                Object obj = extensionMap.get(extension);
                int tag = extension.getTag();
                Message.Datatype datatype = extension.getDatatype();
                Message.Label label = extension.getLabel();
                if (label.isRepeated()) {
                    if (label.isPacked()) {
                        writePacked(wireOutput, (List) obj, tag, datatype);
                    } else {
                        writeRepeated(wireOutput, (List) obj, tag, datatype);
                    }
                } else {
                    writeValue(wireOutput, tag, obj, datatype);
                }
            }
        }
    }

    public void write(M m, WireOutput wireOutput) throws IOException {
        ExtensionMap<T> extensionMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, m, wireOutput) == null) {
            for (FieldInfo fieldInfo : getFields()) {
                Object fieldValue = getFieldValue(m, fieldInfo);
                if (fieldValue != null) {
                    int i = fieldInfo.tag;
                    Message.Datatype datatype = fieldInfo.datatype;
                    Message.Label label = fieldInfo.label;
                    if (label.isRepeated()) {
                        if (label.isPacked()) {
                            writePacked(wireOutput, (List) fieldValue, i, datatype);
                        } else {
                            writeRepeated(wireOutput, (List) fieldValue, i, datatype);
                        }
                    } else {
                        writeValue(wireOutput, i, fieldValue, datatype);
                    }
                }
            }
            if ((m instanceof ExtendableMessage) && (extensionMap = ((ExtendableMessage) m).extensionMap) != 0) {
                writeExtensions(wireOutput, extensionMap);
            }
            m.writeUnknownFieldMap(wireOutput);
        }
    }

    private Class<Message.Builder<M>> getBuilderType(Class<M> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, cls)) == null) {
            try {
                ClassLoader classLoader = cls.getClassLoader();
                return (Class<Message.Builder<M>>) classLoader.loadClass(String.valueOf(cls.getName()) + "$Builder");
            } catch (ClassNotFoundException unused) {
                throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
            }
        }
        return (Class) invokeL.objValue;
    }

    private <T extends ExtendableMessage<?>> int getExtensionsSerializedSize(ExtensionMap<T> extensionMap) {
        InterceptResult invokeL;
        int serializedSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, extensionMap)) == null) {
            int i = 0;
            for (Extension<T, ?> extension : extensionMap.getExtensions()) {
                Object obj = extensionMap.get(extension);
                int tag = extension.getTag();
                Message.Datatype datatype = extension.getDatatype();
                Message.Label label = extension.getLabel();
                if (label.isRepeated()) {
                    if (label.isPacked()) {
                        serializedSize = getPackedSize((List) obj, tag, datatype);
                    } else {
                        serializedSize = getRepeatedSize((List) obj, tag, datatype);
                    }
                } else {
                    serializedSize = getSerializedSize(tag, obj, datatype);
                }
                i += serializedSize;
            }
            return i;
        }
        return invokeL.intValue;
    }

    private Class<? extends ProtoEnum> getEnumClass(int i) {
        InterceptResult invokeI;
        Class<? extends ProtoEnum> cls;
        Extension<ExtendableMessage<?>, ?> extension;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, this, i)) == null) {
            FieldInfo fieldInfo = this.fieldInfoMap.get(Integer.valueOf(i));
            if (fieldInfo == null) {
                cls = null;
            } else {
                cls = fieldInfo.enumType;
            }
            if (cls == null && (extension = getExtension(i)) != null) {
                return extension.getEnumType();
            }
            return cls;
        }
        return (Class) invokeI.objValue;
    }

    private <E extends ProtoEnum> int getEnumSize(E e) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, e)) == null) {
            return WireOutput.varint32Size(this.wire.enumAdapter(e.getClass()).toInt(e));
        }
        return invokeL.intValue;
    }

    private Extension<ExtendableMessage<?>, ?> getExtension(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65544, this, i)) == null) {
            ExtensionRegistry extensionRegistry = this.wire.registry;
            if (extensionRegistry == null) {
                return null;
            }
            return extensionRegistry.getExtension(this.messageType, i);
        }
        return (Extension) invokeI.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.lang.Class<com.squareup.wire.Message> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v8, resolved type: java.lang.Class<com.squareup.wire.Message> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: java.lang.Class<com.squareup.wire.Message> */
    /* JADX DEBUG: Type inference failed for r0v7. Raw type applied. Possible types: java.lang.Class<? extends com.squareup.wire.Message>, java.lang.Class<com.squareup.wire.Message> */
    /* JADX WARN: Multi-variable type inference failed */
    private Class<Message> getMessageClass(int i) {
        InterceptResult invokeI;
        Class<Message> cls;
        Extension<ExtendableMessage<?>, ?> extension;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, this, i)) == null) {
            FieldInfo fieldInfo = this.fieldInfoMap.get(Integer.valueOf(i));
            if (fieldInfo == null) {
                cls = 0;
            } else {
                cls = fieldInfo.messageType;
            }
            if (cls == 0 && (extension = getExtension(i)) != null) {
                return extension.getMessageType();
            }
            return cls;
        }
        return (Class) invokeI.objValue;
    }

    private <M extends Message> int getMessageSize(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, m)) == null) {
            int serializedSize = m.getSerializedSize();
            return WireOutput.varint32Size(serializedSize) + serializedSize;
        }
        return invokeL.intValue;
    }

    public FieldInfo getField(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            Integer num = this.tagMap.get(str);
            if (num == null) {
                return null;
            }
            return this.fieldInfoMap.get(num);
        }
        return (FieldInfo) invokeL.objValue;
    }

    public byte[] toByteArray(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, m)) == null) {
            byte[] bArr = new byte[getSerializedSize(m)];
            try {
                write(m, WireOutput.newInstance(bArr));
                return bArr;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return (byte[]) invokeL.objValue;
    }

    private Class<Enum> getEnumType(Field field) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, field)) == null) {
            Class type = field.getType();
            if (Enum.class.isAssignableFrom(type)) {
                return type;
            }
            if (List.class.isAssignableFrom(type)) {
                Type type2 = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    Class<Enum> cls = (Class) type2;
                    if (Enum.class.isAssignableFrom(cls)) {
                        return cls;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (Class) invokeL.objValue;
    }

    private Class<Message> getMessageType(Field field) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, field)) == null) {
            Class type = field.getType();
            if (Message.class.isAssignableFrom(type)) {
                return type;
            }
            if (List.class.isAssignableFrom(type)) {
                Type type2 = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                if (type2 instanceof Class) {
                    Class<Message> cls = (Class) type2;
                    if (Message.class.isAssignableFrom(cls)) {
                        return cls;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        return (Class) invokeL.objValue;
    }

    private int utf8Length(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, str)) == null) {
            int length = str.length();
            int i = 0;
            int i2 = 0;
            while (i < length) {
                char charAt = str.charAt(i);
                if (charAt <= 127) {
                    i2++;
                } else if (charAt <= 2047) {
                    i2 += 2;
                } else if (Character.isHighSurrogate(charAt)) {
                    i2 += 4;
                    i++;
                } else {
                    i2 += 3;
                }
                i++;
            }
            return i2;
        }
        return invokeL.intValue;
    }

    private int getPackedSize(List<?> list, int i, Message.Datatype datatype) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65549, this, list, i, datatype)) == null) {
            Iterator<?> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 += getSerializedSizeNoTag(it.next(), datatype);
            }
            return WireOutput.varint32Size(WireOutput.makeTag(i, WireType.LENGTH_DELIMITED)) + WireOutput.varint32Size(i2) + i2;
        }
        return invokeLIL.intValue;
    }

    private int getRepeatedSize(List<?> list, int i, Message.Datatype datatype) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65550, this, list, i, datatype)) == null) {
            Iterator<?> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 += getSerializedSize(i, it.next(), datatype);
            }
            return i2;
        }
        return invokeLIL.intValue;
    }

    private int getSerializedSize(int i, Object obj, Message.Datatype datatype) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(65551, this, i, obj, datatype)) == null) {
            return WireOutput.varintTagSize(i) + getSerializedSizeNoTag(obj, datatype);
        }
        return invokeILL.intValue;
    }

    private void setExtension(ExtendableMessage.ExtendableBuilder extendableBuilder, Extension<?, ?> extension, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65556, this, extendableBuilder, extension, obj) == null) {
            extendableBuilder.setExtension(extension, obj);
        }
    }

    public void setBuilderField(Message.Builder<M> builder, int i, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048583, this, builder, i, obj) == null) {
            try {
                this.fieldInfoMap.get(Integer.valueOf(i)).builderMethod.set(builder, obj);
            } catch (Exception e) {
                throw new AssertionError(e);
            }
        }
    }

    private void readUnknownField(Message.Builder builder, WireInput wireInput, int i, WireType wireType) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65554, this, builder, wireInput, i, wireType) == null) {
            switch ($SWITCH_TABLE$com$squareup$wire$WireType()[wireType.ordinal()]) {
                case 1:
                    builder.addVarint(i, wireInput.readVarint64());
                    return;
                case 2:
                    builder.addFixed64(i, wireInput.readFixed64());
                    return;
                case 3:
                    builder.addLengthDelimited(i, wireInput.readBytes(wireInput.readVarint32()));
                    return;
                case 4:
                    wireInput.skipGroup();
                    return;
                case 5:
                    return;
                case 6:
                    builder.addFixed32(i, wireInput.readFixed32());
                    return;
                default:
                    throw new RuntimeException("Unsupported wire type: " + wireType);
            }
        }
    }

    private Object readValue(WireInput wireInput, int i, Message.Datatype datatype) throws IOException {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65555, this, wireInput, i, datatype)) == null) {
            switch ($SWITCH_TABLE$com$squareup$wire$Message$Datatype()[datatype.ordinal()]) {
                case 1:
                case 3:
                    return Integer.valueOf(wireInput.readVarint32());
                case 2:
                case 4:
                    return Long.valueOf(wireInput.readVarint64());
                case 5:
                    return Integer.valueOf(WireInput.decodeZigZag32(wireInput.readVarint32()));
                case 6:
                    return Long.valueOf(WireInput.decodeZigZag64(wireInput.readVarint64()));
                case 7:
                    if (wireInput.readVarint32() != 0) {
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                case 8:
                    EnumAdapter enumAdapter = this.wire.enumAdapter(getEnumClass(i));
                    int readVarint32 = wireInput.readVarint32();
                    try {
                        return enumAdapter.fromInt(readVarint32);
                    } catch (IllegalArgumentException unused) {
                        return Integer.valueOf(readVarint32);
                    }
                case 9:
                    return wireInput.readString();
                case 10:
                    return wireInput.readBytes();
                case 11:
                    return readMessage(wireInput, i);
                case 12:
                case 13:
                    return Integer.valueOf(wireInput.readFixed32());
                case 14:
                case 15:
                    return Long.valueOf(wireInput.readFixed64());
                case 16:
                    return Float.valueOf(Float.intBitsToFloat(wireInput.readFixed32()));
                case 17:
                    return Double.valueOf(Double.longBitsToDouble(wireInput.readFixed64()));
                default:
                    throw new RuntimeException();
            }
        }
        return invokeLIL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.squareup.wire.MessageAdapter<M extends com.squareup.wire.Message> */
    /* JADX WARN: Multi-variable type inference failed */
    private void writeValueNoTag(WireOutput wireOutput, Object obj, Message.Datatype datatype) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65564, this, wireOutput, obj, datatype) == null) {
            switch ($SWITCH_TABLE$com$squareup$wire$Message$Datatype()[datatype.ordinal()]) {
                case 1:
                    wireOutput.writeSignedVarint32(((Integer) obj).intValue());
                    return;
                case 2:
                case 4:
                    wireOutput.writeVarint64(((Long) obj).longValue());
                    return;
                case 3:
                    wireOutput.writeVarint32(((Integer) obj).intValue());
                    return;
                case 5:
                    wireOutput.writeVarint32(WireOutput.zigZag32(((Integer) obj).intValue()));
                    return;
                case 6:
                    wireOutput.writeVarint64(WireOutput.zigZag64(((Long) obj).longValue()));
                    return;
                case 7:
                    wireOutput.writeRawByte(((Boolean) obj).booleanValue() ? 1 : 0);
                    return;
                case 8:
                    writeEnum((ProtoEnum) obj, wireOutput);
                    return;
                case 9:
                    byte[] bytes = ((String) obj).getBytes("UTF-8");
                    wireOutput.writeVarint32(bytes.length);
                    wireOutput.writeRawBytes(bytes);
                    return;
                case 10:
                    ByteString byteString = (ByteString) obj;
                    wireOutput.writeVarint32(byteString.size());
                    wireOutput.writeRawBytes(byteString.toByteArray());
                    return;
                case 11:
                    writeMessage((Message) obj, wireOutput);
                    return;
                case 12:
                case 13:
                    wireOutput.writeFixed32(((Integer) obj).intValue());
                    return;
                case 14:
                case 15:
                    wireOutput.writeFixed64(((Long) obj).longValue());
                    return;
                case 16:
                    wireOutput.writeFixed32(Float.floatToIntBits(((Float) obj).floatValue()));
                    return;
                case 17:
                    wireOutput.writeFixed64(Double.doubleToLongBits(((Double) obj).doubleValue()));
                    return;
                default:
                    throw new RuntimeException();
            }
        }
    }

    private <E extends ProtoEnum> void writeEnum(E e, WireOutput wireOutput) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65558, this, e, wireOutput) == null) {
            wireOutput.writeVarint32(this.wire.enumAdapter(e.getClass()).toInt(e));
        }
    }

    private <M extends Message> void writeMessage(M m, WireOutput wireOutput) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65560, this, m, wireOutput) == null) {
            wireOutput.writeVarint32(m.getSerializedSize());
            this.wire.messageAdapter(m.getClass()).write(m, wireOutput);
        }
    }

    public Object getFieldValue(M m, FieldInfo fieldInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, m, fieldInfo)) == null) {
            if (fieldInfo.messageField != null) {
                try {
                    return fieldInfo.messageField.get(m);
                } catch (IllegalAccessException e) {
                    throw new AssertionError(e);
                }
            }
            throw new AssertionError("Field is not of type \"Message\"");
        }
        return invokeLL.objValue;
    }

    private void writePacked(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65561, this, wireOutput, list, i, datatype) == null) {
            Iterator<?> it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 += getSerializedSizeNoTag(it.next(), datatype);
            }
            wireOutput.writeTag(i, WireType.LENGTH_DELIMITED);
            wireOutput.writeVarint32(i2);
            Iterator<?> it2 = list.iterator();
            while (it2.hasNext()) {
                writeValueNoTag(wireOutput, it2.next(), datatype);
            }
        }
    }

    private void writeRepeated(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65562, this, wireOutput, list, i, datatype) == null) {
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                writeValue(wireOutput, i, it.next(), datatype);
            }
        }
    }

    private void writeValue(WireOutput wireOutput, int i, Object obj, Message.Datatype datatype) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65563, this, wireOutput, i, obj, datatype) == null) {
            wireOutput.writeTag(i, datatype.wireType());
            writeValueNoTag(wireOutput, obj, datatype);
        }
    }

    public Extension<ExtendableMessage<?>, ?> getExtension(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            ExtensionRegistry extensionRegistry = this.wire.registry;
            if (extensionRegistry == null) {
                return null;
            }
            return extensionRegistry.getExtension(this.messageType, str);
        }
        return (Extension) invokeL.objValue;
    }

    public Collection<FieldInfo> getFields() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.fieldInfoMap.values();
        }
        return (Collection) invokeV.objValue;
    }

    public Message.Builder<M> newBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                return this.builderType.newInstance();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InstantiationException e2) {
                throw new AssertionError(e2);
            }
        }
        return (Message.Builder) invokeV.objValue;
    }

    public int getSerializedSize(M m) {
        InterceptResult invokeL;
        ExtensionMap<T> extensionMap;
        int serializedSize;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, m)) == null) {
            int i = 0;
            for (FieldInfo fieldInfo : getFields()) {
                Object fieldValue = getFieldValue(m, fieldInfo);
                if (fieldValue != null) {
                    int i2 = fieldInfo.tag;
                    Message.Datatype datatype = fieldInfo.datatype;
                    Message.Label label = fieldInfo.label;
                    if (label.isRepeated()) {
                        if (label.isPacked()) {
                            serializedSize = getPackedSize((List) fieldValue, i2, datatype);
                        } else {
                            serializedSize = getRepeatedSize((List) fieldValue, i2, datatype);
                        }
                    } else {
                        serializedSize = getSerializedSize(i2, fieldValue, datatype);
                    }
                    i += serializedSize;
                }
            }
            if ((m instanceof ExtendableMessage) && (extensionMap = ((ExtendableMessage) m).extensionMap) != 0) {
                i += getExtensionsSerializedSize(extensionMap);
            }
            return i + m.getUnknownFieldsSerializedSize();
        }
        return invokeL.intValue;
    }

    public String toString(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.messageType.getSimpleName());
            sb.append("{");
            String str = "";
            for (FieldInfo fieldInfo : getFields()) {
                Object fieldValue = getFieldValue(m, fieldInfo);
                if (fieldValue != null) {
                    sb.append(str);
                    sb.append(fieldInfo.name);
                    sb.append("=");
                    sb.append(fieldValue);
                    str = StringUtil.ARRAY_ELEMENT_SEPARATOR;
                }
            }
            if (m instanceof ExtendableMessage) {
                sb.append(str);
                sb.append("{extensions=");
                sb.append(((ExtendableMessage) m).extensionsToString());
                sb.append("}");
            }
            sb.append("}");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public M read(WireInput wireInput) throws IOException {
        InterceptResult invokeL;
        Message.Label label;
        Message.Datatype datatype;
        Extension<ExtendableMessage<?>, ?> extension;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, wireInput)) == null) {
            try {
                Message.Builder<M> newInstance = this.builderType.newInstance();
                Storage storage = new Storage(null);
                while (true) {
                    int readTag = wireInput.readTag();
                    int i = readTag >> 3;
                    WireType valueOf = WireType.valueOf(readTag);
                    if (i == 0) {
                        for (Integer num : storage.getTags()) {
                            int intValue = num.intValue();
                            if (this.fieldInfoMap.get(Integer.valueOf(intValue)) != null) {
                                setBuilderField(newInstance, intValue, storage.get(intValue));
                            } else {
                                setExtension((ExtendableMessage.ExtendableBuilder) newInstance, getExtension(intValue), storage.get(intValue));
                            }
                        }
                        return newInstance.build(true);
                    }
                    FieldInfo fieldInfo = this.fieldInfoMap.get(Integer.valueOf(i));
                    if (fieldInfo != null) {
                        Message.Datatype datatype2 = fieldInfo.datatype;
                        label = fieldInfo.label;
                        datatype = datatype2;
                        extension = null;
                    } else {
                        Extension<ExtendableMessage<?>, ?> extension2 = getExtension(i);
                        if (extension2 == null) {
                            readUnknownField(newInstance, wireInput, i, valueOf);
                        } else {
                            Message.Datatype datatype3 = extension2.getDatatype();
                            extension = extension2;
                            label = extension2.getLabel();
                            datatype = datatype3;
                        }
                    }
                    if (label.isPacked() && valueOf == WireType.LENGTH_DELIMITED) {
                        int readVarint32 = wireInput.readVarint32();
                        long position = wireInput.getPosition();
                        int pushLimit = wireInput.pushLimit(readVarint32);
                        while (true) {
                            j = readVarint32 + position;
                            if (wireInput.getPosition() >= j) {
                                break;
                            }
                            Object readValue = readValue(wireInput, i, datatype);
                            if (datatype == Message.Datatype.ENUM && (readValue instanceof Integer)) {
                                newInstance.addVarint(i, ((Integer) readValue).intValue());
                            } else {
                                storage.add(i, readValue);
                            }
                        }
                        wireInput.popLimit(pushLimit);
                        if (wireInput.getPosition() != j) {
                            throw new IOException("Packed data had wrong length!");
                        }
                    } else {
                        Object readValue2 = readValue(wireInput, i, datatype);
                        if (datatype == Message.Datatype.ENUM && (readValue2 instanceof Integer)) {
                            newInstance.addVarint(i, ((Integer) readValue2).intValue());
                        } else if (label.isRepeated()) {
                            storage.add(i, readValue2);
                        } else if (extension != null) {
                            setExtension((ExtendableMessage.ExtendableBuilder) newInstance, extension, readValue2);
                        } else {
                            setBuilderField(newInstance, i, readValue2);
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e2) {
                throw new RuntimeException(e2);
            }
        } else {
            return (M) invokeL.objValue;
        }
    }
}
