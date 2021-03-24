package com.squareup.wire;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
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
/* loaded from: classes6.dex */
public final class MessageAdapter<M extends Message> {
    public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$Message$Datatype;
    public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType;
    public final Class<Message.Builder<M>> builderType;
    public final Class<M> messageType;
    public final Wire wire;
    public final Map<String, Integer> tagMap = new LinkedHashMap();
    public final Map<Integer, FieldInfo> fieldInfoMap = new LinkedHashMap();

    public static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$Message$Datatype() {
        int[] iArr = $SWITCH_TABLE$com$squareup$wire$Message$Datatype;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[Message.Datatype.valuesCustom().length];
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
        int[] iArr2 = new int[WireType.valuesCustom().length];
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

    private Field getBuilderMethod(String str, Class<?> cls) {
        try {
            return this.builderType.getDeclaredField(str);
        } catch (Exception unused) {
            throw new AssertionError("No builder Field " + this.builderType.getName() + "." + str + "(" + cls.getName() + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    private Class<Message.Builder<M>> getBuilderType(Class<M> cls) {
        try {
            ClassLoader classLoader = cls.getClassLoader();
            return (Class<Message.Builder<M>>) classLoader.loadClass(String.valueOf(cls.getName()) + "$Builder");
        } catch (ClassNotFoundException unused) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    private Class<? extends ProtoEnum> getEnumClass(int i) {
        Extension<ExtendableMessage<?>, ?> extension;
        FieldInfo fieldInfo = this.fieldInfoMap.get(Integer.valueOf(i));
        Class<? extends ProtoEnum> cls = fieldInfo == null ? null : fieldInfo.enumType;
        return (cls != null || (extension = getExtension(i)) == null) ? cls : extension.getEnumType();
    }

    private <E extends ProtoEnum> int getEnumSize(E e2) {
        return WireOutput.varint32Size(this.wire.enumAdapter(e2.getClass()).toInt(e2));
    }

    private Class<Enum> getEnumType(Field field) {
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

    private Extension<ExtendableMessage<?>, ?> getExtension(int i) {
        ExtensionRegistry extensionRegistry = this.wire.registry;
        if (extensionRegistry == null) {
            return null;
        }
        return extensionRegistry.getExtension(this.messageType, i);
    }

    private <T extends ExtendableMessage<?>> int getExtensionsSerializedSize(ExtensionMap<T> extensionMap) {
        int serializedSize;
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

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.lang.Class<com.squareup.wire.Message> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: java.lang.Class<com.squareup.wire.Message> */
    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: java.lang.Class<com.squareup.wire.Message> */
    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: java.lang.Class<? extends com.squareup.wire.Message>, java.lang.Class<com.squareup.wire.Message> */
    /* JADX WARN: Multi-variable type inference failed */
    private Class<Message> getMessageClass(int i) {
        Extension<ExtendableMessage<?>, ?> extension;
        FieldInfo fieldInfo = this.fieldInfoMap.get(Integer.valueOf(i));
        Class<Message> cls = fieldInfo == null ? 0 : fieldInfo.messageType;
        return (cls != 0 || (extension = getExtension(i)) == null) ? cls : extension.getMessageType();
    }

    private <M extends Message> int getMessageSize(M m) {
        int serializedSize = m.getSerializedSize();
        return WireOutput.varint32Size(serializedSize) + serializedSize;
    }

    private Class<Message> getMessageType(Field field) {
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

    private int getPackedSize(List<?> list, int i, Message.Datatype datatype) {
        Iterator<?> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += getSerializedSizeNoTag(it.next(), datatype);
        }
        return WireOutput.varint32Size(WireOutput.makeTag(i, WireType.LENGTH_DELIMITED)) + WireOutput.varint32Size(i2) + i2;
    }

    private int getRepeatedSize(List<?> list, int i, Message.Datatype datatype) {
        Iterator<?> it = list.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            i2 += getSerializedSize(i, it.next(), datatype);
        }
        return i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.squareup.wire.MessageAdapter<M extends com.squareup.wire.Message> */
    /* JADX WARN: Multi-variable type inference failed */
    private int getSerializedSizeNoTag(Object obj, Message.Datatype datatype) {
        int utf8Length;
        int varint32Size;
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.squareup.wire.Wire */
    /* JADX WARN: Multi-variable type inference failed */
    private Message readMessage(WireInput wireInput, int i) throws IOException {
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

    private void readUnknownField(Message.Builder builder, WireInput wireInput, int i, WireType wireType) throws IOException {
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

    private Object readValue(WireInput wireInput, int i, Message.Datatype datatype) throws IOException {
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
                return wireInput.readVarint32() != 0 ? Boolean.TRUE : Boolean.FALSE;
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

    private void setExtension(ExtendableMessage.ExtendableBuilder extendableBuilder, Extension<?, ?> extension, Object obj) {
        extendableBuilder.setExtension(extension, obj);
    }

    private int utf8Length(String str) {
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

    private <E extends ProtoEnum> void writeEnum(E e2, WireOutput wireOutput) throws IOException {
        wireOutput.writeVarint32(this.wire.enumAdapter(e2.getClass()).toInt(e2));
    }

    private <T extends ExtendableMessage<?>> void writeExtensions(WireOutput wireOutput, ExtensionMap<T> extensionMap) throws IOException {
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

    private <M extends Message> void writeMessage(M m, WireOutput wireOutput) throws IOException {
        wireOutput.writeVarint32(m.getSerializedSize());
        this.wire.messageAdapter(m.getClass()).write(m, wireOutput);
    }

    private void writePacked(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) throws IOException {
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

    private void writeRepeated(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) throws IOException {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            writeValue(wireOutput, i, it.next(), datatype);
        }
    }

    private void writeValue(WireOutput wireOutput, int i, Object obj, Message.Datatype datatype) throws IOException {
        wireOutput.writeTag(i, datatype.wireType());
        writeValueNoTag(wireOutput, obj, datatype);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.squareup.wire.MessageAdapter<M extends com.squareup.wire.Message> */
    /* JADX WARN: Multi-variable type inference failed */
    private void writeValueNoTag(WireOutput wireOutput, Object obj, Message.Datatype datatype) throws IOException {
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

    public FieldInfo getField(String str) {
        Integer num = this.tagMap.get(str);
        if (num == null) {
            return null;
        }
        return this.fieldInfoMap.get(num);
    }

    public Object getFieldValue(M m, FieldInfo fieldInfo) {
        if (fieldInfo.messageField != null) {
            try {
                return fieldInfo.messageField.get(m);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
        throw new AssertionError("Field is not of type \"Message\"");
    }

    public Collection<FieldInfo> getFields() {
        return this.fieldInfoMap.values();
    }

    public int getSerializedSize(M m) {
        ExtensionMap<T> extensionMap;
        int serializedSize;
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

    public Message.Builder<M> newBuilder() {
        try {
            return this.builderType.newInstance();
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (InstantiationException e3) {
            throw new AssertionError(e3);
        }
    }

    public M read(WireInput wireInput) throws IOException {
        Message.Label label;
        Message.Datatype datatype;
        Extension<ExtendableMessage<?>, ?> extension;
        long j;
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
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        }
    }

    public void setBuilderField(Message.Builder<M> builder, int i, Object obj) {
        try {
            this.fieldInfoMap.get(Integer.valueOf(i)).builderMethod.set(builder, obj);
        } catch (Exception e2) {
            throw new AssertionError(e2);
        }
    }

    public byte[] toByteArray(M m) {
        byte[] bArr = new byte[getSerializedSize(m)];
        try {
            write(m, WireOutput.newInstance(bArr));
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public String toString(M m) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.messageType.getSimpleName());
        sb.append(StringUtil.ARRAY_START);
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

    public void write(M m, WireOutput wireOutput) throws IOException {
        ExtensionMap<T> extensionMap;
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

    /* loaded from: classes6.dex */
    public static class Storage {
        public final Map<Integer, List<Object>> map;

        public Storage() {
            this.map = new LinkedHashMap();
        }

        public void add(int i, Object obj) {
            List<Object> list = this.map.get(Integer.valueOf(i));
            if (list == null) {
                list = new ArrayList<>();
                this.map.put(Integer.valueOf(i), list);
            }
            list.add(obj);
        }

        public List<Object> get(int i) {
            return this.map.get(Integer.valueOf(i));
        }

        public Set<Integer> getTags() {
            return this.map.keySet();
        }

        public /* synthetic */ Storage(Storage storage) {
            this();
        }
    }

    public Extension<ExtendableMessage<?>, ?> getExtension(String str) {
        ExtensionRegistry extensionRegistry = this.wire.registry;
        if (extensionRegistry == null) {
            return null;
        }
        return extensionRegistry.getExtension(this.messageType, str);
    }

    /* loaded from: classes6.dex */
    public static final class FieldInfo {
        public final Field builderMethod;
        public final Message.Datatype datatype;
        public final Class<? extends ProtoEnum> enumType;
        public final Message.Label label;
        public final Field messageField;
        public final Class<? extends Message> messageType;
        public final String name;
        public final int tag;

        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Class<?> */
        /* JADX WARN: Multi-variable type inference failed */
        public FieldInfo(int i, String str, Message.Datatype datatype, Message.Label label, Class<?> cls, Field field, Field field2) {
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

    private int getSerializedSize(int i, Object obj, Message.Datatype datatype) {
        return WireOutput.varintTagSize(i) + getSerializedSizeNoTag(obj, datatype);
    }
}
