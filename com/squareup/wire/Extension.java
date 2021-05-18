package com.squareup.wire;

import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import java.util.List;
/* loaded from: classes7.dex */
public final class Extension<T extends ExtendableMessage<?>, E> implements Comparable<Extension<?, ?>> {
    public final Message.Datatype datatype;
    public final Class<? extends ProtoEnum> enumType;
    public final Class<T> extendedType;
    public final Message.Label label;
    public final Class<? extends Message> messageType;
    public final String name;
    public final int tag;

    public Extension(Class<T> cls, Class<? extends Message> cls2, Class<? extends ProtoEnum> cls3, String str, int i2, Message.Label label, Message.Datatype datatype) {
        this.extendedType = cls;
        this.name = str;
        this.tag = i2;
        this.datatype = datatype;
        this.label = label;
        this.messageType = cls2;
        this.enumType = cls3;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Boolean> boolExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.BOOL, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, ByteString> bytesExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.BYTES, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Double> doubleExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.DOUBLE, null);
    }

    public static <T extends ExtendableMessage<?>, E extends Enum & ProtoEnum> Builder<T, E> enumExtending(Class<E> cls, Class<T> cls2) {
        return new Builder<>(cls2, null, cls, Message.Datatype.ENUM, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> fixed32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.FIXED32, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> fixed64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.FIXED64, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Float> floatExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.FLOAT, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> int32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.INT32, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> int64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.INT64, null);
    }

    public static <T extends ExtendableMessage<?>, M extends Message> Builder<T, M> messageExtending(Class<M> cls, Class<T> cls2) {
        return new Builder<>(cls2, cls, null, Message.Datatype.MESSAGE, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> sfixed32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.SFIXED32, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> sfixed64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.SFIXED64, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> sint32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.SINT32, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> sint64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.SINT64, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, String> stringExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.STRING, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> uint32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.UINT32, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> uint64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.UINT64, null);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Extension) && compareTo((Extension) obj) == 0;
    }

    public Message.Datatype getDatatype() {
        return this.datatype;
    }

    public Class<? extends ProtoEnum> getEnumType() {
        return this.enumType;
    }

    public Class<T> getExtendedType() {
        return this.extendedType;
    }

    public Message.Label getLabel() {
        return this.label;
    }

    public Class<? extends Message> getMessageType() {
        return this.messageType;
    }

    public String getName() {
        return this.name;
    }

    public int getTag() {
        return this.tag;
    }

    public int hashCode() {
        int value = ((((((this.tag * 37) + this.datatype.value()) * 37) + this.label.value()) * 37) + this.extendedType.hashCode()) * 37;
        Class<? extends Message> cls = this.messageType;
        int hashCode = (value + (cls != null ? cls.hashCode() : 0)) * 37;
        Class<? extends ProtoEnum> cls2 = this.enumType;
        return hashCode + (cls2 != null ? cls2.hashCode() : 0);
    }

    public String toString() {
        return String.format("[%s %s %s = %d]", this.label, this.datatype, this.name, Integer.valueOf(this.tag));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(Extension<?, ?> extension) {
        int value;
        int value2;
        if (extension == this) {
            return 0;
        }
        int i2 = this.tag;
        int i3 = extension.tag;
        if (i2 != i3) {
            return i2 - i3;
        }
        Message.Datatype datatype = this.datatype;
        if (datatype != extension.datatype) {
            value = datatype.value();
            value2 = extension.datatype.value();
        } else {
            Message.Label label = this.label;
            if (label != extension.label) {
                value = label.value();
                value2 = extension.label.value();
            } else {
                Class<T> cls = this.extendedType;
                if (cls != null && !cls.equals(extension.extendedType)) {
                    return this.extendedType.getName().compareTo(extension.extendedType.getName());
                }
                Class<? extends Message> cls2 = this.messageType;
                if (cls2 != null && !cls2.equals(extension.messageType)) {
                    return this.messageType.getName().compareTo(extension.messageType.getName());
                }
                Class<? extends ProtoEnum> cls3 = this.enumType;
                if (cls3 == null || cls3.equals(extension.enumType)) {
                    return 0;
                }
                return this.enumType.getName().compareTo(extension.enumType.getName());
            }
        }
        return value - value2;
    }

    /* loaded from: classes7.dex */
    public static final class Builder<T extends ExtendableMessage<?>, E> {
        public final Message.Datatype datatype;
        public final Class<? extends ProtoEnum> enumType;
        public final Class<T> extendedType;
        public Message.Label label;
        public final Class<? extends Message> messageType;
        public String name;
        public int tag;

        public Builder(Class<T> cls, Message.Datatype datatype) {
            this.name = null;
            this.tag = -1;
            this.label = null;
            this.extendedType = cls;
            this.messageType = null;
            this.enumType = null;
            this.datatype = datatype;
        }

        private void validate() {
            if (this.extendedType != null) {
                if (this.name != null) {
                    Message.Datatype datatype = this.datatype;
                    if (datatype != null) {
                        if (this.label != null) {
                            if (this.tag > 0) {
                                if (datatype == Message.Datatype.MESSAGE) {
                                    if (this.messageType == null || this.enumType != null) {
                                        throw new IllegalStateException("Message w/o messageType or w/ enumType");
                                    }
                                    return;
                                } else if (datatype == Message.Datatype.ENUM) {
                                    if (this.messageType != null || this.enumType == null) {
                                        throw new IllegalStateException("Enum w/ messageType or w/o enumType");
                                    }
                                    return;
                                } else if (this.messageType != null || this.enumType != null) {
                                    throw new IllegalStateException("Scalar w/ messageType or enumType");
                                } else {
                                    return;
                                }
                            }
                            throw new IllegalArgumentException("tag == " + this.tag);
                        }
                        throw new IllegalArgumentException("label == null");
                    }
                    throw new IllegalArgumentException("datatype == null");
                }
                throw new IllegalArgumentException("name == null");
            }
            throw new IllegalArgumentException("extendedType == null");
        }

        public Extension<T, E> buildOptional() {
            this.label = Message.Label.OPTIONAL;
            validate();
            return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype, null);
        }

        public Extension<T, List<E>> buildPacked() {
            this.label = Message.Label.PACKED;
            validate();
            return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype, null);
        }

        public Extension<T, List<E>> buildRepeated() {
            this.label = Message.Label.REPEATED;
            validate();
            return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype, null);
        }

        public Extension<T, E> buildRequired() {
            this.label = Message.Label.REQUIRED;
            validate();
            return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype, null);
        }

        public Builder<T, E> setName(String str) {
            this.name = str;
            return this;
        }

        public Builder<T, E> setTag(int i2) {
            this.tag = i2;
            return this;
        }

        public /* synthetic */ Builder(Class cls, Message.Datatype datatype, Builder builder) {
            this(cls, datatype);
        }

        public Builder(Class<T> cls, Class<? extends Message> cls2, Class<? extends ProtoEnum> cls3, Message.Datatype datatype) {
            this.name = null;
            this.tag = -1;
            this.label = null;
            this.extendedType = cls;
            this.messageType = cls2;
            this.enumType = cls3;
            this.datatype = datatype;
        }

        public /* synthetic */ Builder(Class cls, Class cls2, Class cls3, Message.Datatype datatype, Builder builder) {
            this(cls, cls2, cls3, datatype);
        }
    }

    public /* synthetic */ Extension(Class cls, Class cls2, Class cls3, String str, int i2, Message.Label label, Message.Datatype datatype, Extension extension) {
        this(cls, cls2, cls3, str, i2, label, datatype);
    }
}
