package com.squareup.wire;

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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MessageAdapter<M extends Message> {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$Message$Datatype;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType;
    private final Class<Message.Builder<M>> builderType;
    private final Class<M> messageType;
    private final Wire wire;
    private final Map<String, Integer> tagMap = new LinkedHashMap();
    private final Map<Integer, FieldInfo> fieldInfoMap = new LinkedHashMap();

    static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$Message$Datatype() {
        int[] iArr = $SWITCH_TABLE$com$squareup$wire$Message$Datatype;
        if (iArr == null) {
            iArr = new int[Message.Datatype.valuesCustom().length];
            try {
                iArr[Message.Datatype.BOOL.ordinal()] = 7;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Message.Datatype.BYTES.ordinal()] = 10;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Message.Datatype.DOUBLE.ordinal()] = 17;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Message.Datatype.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Message.Datatype.FIXED32.ordinal()] = 12;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[Message.Datatype.FIXED64.ordinal()] = 14;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[Message.Datatype.FLOAT.ordinal()] = 16;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[Message.Datatype.INT32.ordinal()] = 1;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[Message.Datatype.INT64.ordinal()] = 2;
            } catch (NoSuchFieldError e9) {
            }
            try {
                iArr[Message.Datatype.MESSAGE.ordinal()] = 11;
            } catch (NoSuchFieldError e10) {
            }
            try {
                iArr[Message.Datatype.SFIXED32.ordinal()] = 13;
            } catch (NoSuchFieldError e11) {
            }
            try {
                iArr[Message.Datatype.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError e12) {
            }
            try {
                iArr[Message.Datatype.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                iArr[Message.Datatype.SINT64.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                iArr[Message.Datatype.STRING.ordinal()] = 9;
            } catch (NoSuchFieldError e15) {
            }
            try {
                iArr[Message.Datatype.UINT32.ordinal()] = 3;
            } catch (NoSuchFieldError e16) {
            }
            try {
                iArr[Message.Datatype.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError e17) {
            }
            $SWITCH_TABLE$com$squareup$wire$Message$Datatype = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$squareup$wire$WireType() {
        int[] iArr = $SWITCH_TABLE$com$squareup$wire$WireType;
        if (iArr == null) {
            iArr = new int[WireType.valuesCustom().length];
            try {
                iArr[WireType.END_GROUP.ordinal()] = 5;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WireType.FIXED32.ordinal()] = 6;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WireType.FIXED64.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[WireType.LENGTH_DELIMITED.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[WireType.START_GROUP.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[WireType.VARINT.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            $SWITCH_TABLE$com$squareup$wire$WireType = iArr;
        }
        return iArr;
    }

    /* loaded from: classes.dex */
    public final class FieldInfo {
        private final Field builderMethod;
        final Message.Datatype datatype;
        final Class<? extends ProtoEnum> enumType;
        final Message.Label label;
        private final Field messageField;
        final Class<? extends Message> messageType;
        final String name;
        final int tag;

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.Class<?> */
        /* JADX WARN: Multi-variable type inference failed */
        private FieldInfo(int i, String str, Message.Datatype datatype, Message.Label label, Class<?> cls, Field field, Field field2) {
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

        /* synthetic */ FieldInfo(int i, String str, Message.Datatype datatype, Message.Label label, Class cls, Field field, Field field2, FieldInfo fieldInfo) {
            this(i, str, datatype, label, cls, field, field2);
        }
    }

    Message.Builder<M> newBuilder() {
        try {
            return this.builderType.newInstance();
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InstantiationException e2) {
            throw new AssertionError(e2);
        }
    }

    Collection<FieldInfo> getFields() {
        return this.fieldInfoMap.values();
    }

    FieldInfo getField(String str) {
        Integer num = this.tagMap.get(str);
        if (num == null) {
            return null;
        }
        return this.fieldInfoMap.get(num);
    }

    Object getFieldValue(M m, FieldInfo fieldInfo) {
        if (fieldInfo.messageField != null) {
            try {
                return fieldInfo.messageField.get(m);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
        throw new AssertionError("Field is not of type \"Message\"");
    }

    public void setBuilderField(Message.Builder<M> builder, int i, Object obj) {
        try {
            this.fieldInfoMap.get(Integer.valueOf(i)).builderMethod.set(builder, obj);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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

    private Class<Message.Builder<M>> getBuilderType(Class<M> cls) {
        try {
            return (Class<Message.Builder<M>>) Class.forName(String.valueOf(cls.getName()) + "$Builder");
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("No builder class found for message type " + cls.getName());
        }
    }

    private Field getBuilderMethod(String str, Class<?> cls) {
        try {
            return this.builderType.getDeclaredField(str);
        } catch (Exception e) {
            throw new AssertionError("No builder Field " + this.builderType.getName() + "." + str + "(" + cls.getName() + ")");
        }
    }

    private Class<Message> getMessageType(Field field) {
        Class type = field.getType();
        if (!Message.class.isAssignableFrom(type)) {
            if (List.class.isAssignableFrom(type)) {
                Type type2 = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                if ((type2 instanceof Class) && Message.class.isAssignableFrom((Class) type2)) {
                    return (Class) type2;
                }
            }
            return null;
        }
        return type;
    }

    private Class<Enum> getEnumType(Field field) {
        Class type = field.getType();
        if (!Enum.class.isAssignableFrom(type)) {
            if (List.class.isAssignableFrom(type)) {
                Type type2 = ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                if ((type2 instanceof Class) && Enum.class.isAssignableFrom((Class) type2)) {
                    return (Class) type2;
                }
            }
            return null;
        }
        return type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSerializedSize(M m) {
        int i = 0;
        for (FieldInfo fieldInfo : getFields()) {
            Object fieldValue = getFieldValue(m, fieldInfo);
            if (fieldValue != null) {
                int i2 = fieldInfo.tag;
                Message.Datatype datatype = fieldInfo.datatype;
                Message.Label label = fieldInfo.label;
                if (label.isRepeated()) {
                    if (label.isPacked()) {
                        i = getPackedSize((List) fieldValue, i2, datatype) + i;
                    } else {
                        i = getRepeatedSize((List) fieldValue, i2, datatype) + i;
                    }
                } else {
                    i = getSerializedSize(i2, fieldValue, datatype) + i;
                }
            }
        }
        if (m instanceof ExtendableMessage) {
            ExtendableMessage extendableMessage = (ExtendableMessage) m;
            if (extendableMessage.extensionMap != null) {
                i += getExtensionsSerializedSize(extendableMessage.extensionMap);
            }
        }
        return m.getUnknownFieldsSerializedSize() + i;
    }

    private <T extends ExtendableMessage<?>> int getExtensionsSerializedSize(ExtensionMap<T> extensionMap) {
        int i = 0;
        Iterator<Extension<T, ?>> it = extensionMap.getExtensions().iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                Extension<T, ?> next = it.next();
                Object obj = extensionMap.get(next);
                int tag = next.getTag();
                Message.Datatype datatype = next.getDatatype();
                Message.Label label = next.getLabel();
                if (label.isRepeated()) {
                    if (label.isPacked()) {
                        i = getPackedSize((List) obj, tag, datatype) + i2;
                    } else {
                        i = getRepeatedSize((List) obj, tag, datatype) + i2;
                    }
                } else {
                    i = getSerializedSize(tag, obj, datatype) + i2;
                }
            } else {
                return i2;
            }
        }
    }

    private int getRepeatedSize(List<?> list, int i, Message.Datatype datatype) {
        int i2 = 0;
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            i2 += getSerializedSize(i, it.next(), datatype);
        }
        return i2;
    }

    private int getPackedSize(List<?> list, int i, Message.Datatype datatype) {
        int i2 = 0;
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            i2 += getSerializedSizeNoTag(it.next(), datatype);
        }
        return i2 + WireOutput.varint32Size(WireOutput.makeTag(i, WireType.LENGTH_DELIMITED)) + WireOutput.varint32Size(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void write(M m, WireOutput wireOutput) {
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
        if (m instanceof ExtendableMessage) {
            ExtendableMessage extendableMessage = (ExtendableMessage) m;
            if (extendableMessage.extensionMap != null) {
                writeExtensions(wireOutput, extendableMessage.extensionMap);
            }
        }
        m.writeUnknownFieldMap(wireOutput);
    }

    private <T extends ExtendableMessage<?>> void writeExtensions(WireOutput wireOutput, ExtensionMap<T> extensionMap) {
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

    private void writeRepeated(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            writeValue(wireOutput, i, it.next(), datatype);
        }
    }

    private void writePacked(WireOutput wireOutput, List<?> list, int i, Message.Datatype datatype) {
        int i2 = 0;
        Iterator<?> it = list.iterator();
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] toByteArray(M m) {
        byte[] bArr = new byte[getSerializedSize(m)];
        try {
            write(m, WireOutput.newInstance(bArr));
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String toString(M m) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.messageType.getSimpleName());
        sb.append("{");
        String str = "";
        for (FieldInfo fieldInfo : getFields()) {
            Object fieldValue = getFieldValue(m, fieldInfo);
            if (fieldValue != null) {
                sb.append(str);
                str = ", ";
                sb.append(fieldInfo.name);
                sb.append("=");
                sb.append(fieldValue);
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

    private int getSerializedSize(int i, Object obj, Message.Datatype datatype) {
        return WireOutput.varintTagSize(i) + getSerializedSizeNoTag(obj, datatype);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.squareup.wire.MessageAdapter<M extends com.squareup.wire.Message> */
    /* JADX WARN: Multi-variable type inference failed */
    private int getSerializedSizeNoTag(Object obj, Message.Datatype datatype) {
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
                int utf8Length = utf8Length((String) obj);
                return utf8Length + WireOutput.varint32Size(utf8Length);
            case 10:
                int size = ((ByteString) obj).size();
                return size + WireOutput.varint32Size(size);
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
    }

    private int utf8Length(String str) {
        int i = 0;
        int length = str.length();
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

    private <E extends ProtoEnum> int getEnumSize(E e) {
        return WireOutput.varint32Size(this.wire.enumAdapter(e.getClass()).toInt(e));
    }

    private <M extends Message> int getMessageSize(M m) {
        int serializedSize = m.getSerializedSize();
        return serializedSize + WireOutput.varint32Size(serializedSize);
    }

    private void writeValue(WireOutput wireOutput, int i, Object obj, Message.Datatype datatype) {
        wireOutput.writeTag(i, datatype.wireType());
        writeValueNoTag(wireOutput, obj, datatype);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.squareup.wire.MessageAdapter<M extends com.squareup.wire.Message> */
    /* JADX WARN: Multi-variable type inference failed */
    private void writeValueNoTag(WireOutput wireOutput, Object obj, Message.Datatype datatype) {
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

    private <M extends Message> void writeMessage(M m, WireOutput wireOutput) {
        wireOutput.writeVarint32(m.getSerializedSize());
        this.wire.messageAdapter(m.getClass()).write(m, wireOutput);
    }

    private <E extends ProtoEnum> void writeEnum(E e, WireOutput wireOutput) {
        wireOutput.writeVarint32(this.wire.enumAdapter(e.getClass()).toInt(e));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public M read(WireInput wireInput) {
        Message.Datatype datatype;
        Extension<ExtendableMessage<?>, ?> extension;
        Message.Label label;
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
                    datatype = fieldInfo.datatype;
                    extension = null;
                    label = fieldInfo.label;
                } else {
                    Extension<ExtendableMessage<?>, ?> extension2 = getExtension(i);
                    if (extension2 == null) {
                        readUnknownField(newInstance, wireInput, i, valueOf);
                    } else {
                        Message.Datatype datatype2 = extension2.getDatatype();
                        Message.Label label2 = extension2.getLabel();
                        extension = extension2;
                        datatype = datatype2;
                        label = label2;
                    }
                }
                if (label.isPacked() && valueOf == WireType.LENGTH_DELIMITED) {
                    int readVarint32 = wireInput.readVarint32();
                    long position = wireInput.getPosition();
                    int pushLimit = wireInput.pushLimit(readVarint32);
                    while (wireInput.getPosition() < readVarint32 + position) {
                        Object readValue = readValue(wireInput, i, datatype);
                        if (datatype == Message.Datatype.ENUM && (readValue instanceof Integer)) {
                            newInstance.addVarint(i, ((Integer) readValue).intValue());
                        } else {
                            storage.add(i, readValue);
                        }
                    }
                    wireInput.popLimit(pushLimit);
                    if (wireInput.getPosition() != readVarint32 + position) {
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
    }

    private Object readValue(WireInput wireInput, int i, Message.Datatype datatype) {
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
                return wireInput.readVarint32() != 0;
            case 8:
                EnumAdapter enumAdapter = this.wire.enumAdapter(getEnumClass(i));
                int readVarint32 = wireInput.readVarint32();
                try {
                    return enumAdapter.fromInt(readVarint32);
                } catch (IllegalArgumentException e) {
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.squareup.wire.Wire */
    /* JADX WARN: Multi-variable type inference failed */
    private Message readMessage(WireInput wireInput, int i) {
        int readVarint32 = wireInput.readVarint32();
        if (wireInput.recursionDepth >= 64) {
            throw new IOException("Wire recursion limit exceeded");
        }
        int pushLimit = wireInput.pushLimit(readVarint32);
        wireInput.recursionDepth++;
        Message read = this.wire.messageAdapter(getMessageClass(i)).read(wireInput);
        wireInput.checkLastTagWas(0);
        wireInput.recursionDepth--;
        wireInput.popLimit(pushLimit);
        return read;
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
        if (cls == 0 && (extension = getExtension(i)) != null) {
            return extension.getMessageType();
        }
        return cls;
    }

    private void readUnknownField(Message.Builder builder, WireInput wireInput, int i, WireType wireType) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class Storage {
        private final Map<Integer, List<Object>> map;

        private Storage() {
            this.map = new LinkedHashMap();
        }

        /* synthetic */ Storage(Storage storage) {
            this();
        }

        void add(int i, Object obj) {
            List<Object> list = this.map.get(Integer.valueOf(i));
            if (list == null) {
                list = new ArrayList<>();
                this.map.put(Integer.valueOf(i), list);
            }
            list.add(obj);
        }

        Set<Integer> getTags() {
            return this.map.keySet();
        }

        List<Object> get(int i) {
            return this.map.get(Integer.valueOf(i));
        }
    }

    private Extension<ExtendableMessage<?>, ?> getExtension(int i) {
        ExtensionRegistry extensionRegistry = this.wire.registry;
        if (extensionRegistry == null) {
            return null;
        }
        return extensionRegistry.getExtension(this.messageType, i);
    }

    Extension<ExtendableMessage<?>, ?> getExtension(String str) {
        ExtensionRegistry extensionRegistry = this.wire.registry;
        if (extensionRegistry == null) {
            return null;
        }
        return extensionRegistry.getExtension(this.messageType, str);
    }

    private void setExtension(ExtendableMessage.ExtendableBuilder extendableBuilder, Extension<?, ?> extension, Object obj) {
        extendableBuilder.setExtension(extension, obj);
    }

    private Class<? extends ProtoEnum> getEnumClass(int i) {
        Extension<ExtendableMessage<?>, ?> extension;
        FieldInfo fieldInfo = this.fieldInfoMap.get(Integer.valueOf(i));
        Class<? extends ProtoEnum> cls = fieldInfo == null ? null : fieldInfo.enumType;
        if (cls == null && (extension = getExtension(i)) != null) {
            return extension.getEnumType();
        }
        return cls;
    }
}
