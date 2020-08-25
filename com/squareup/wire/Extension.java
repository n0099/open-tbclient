package com.squareup.wire;

import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import java.util.List;
/* loaded from: classes18.dex */
public final class Extension<T extends ExtendableMessage<?>, E> implements Comparable<Extension<?, ?>> {
    private final Message.Datatype datatype;
    private final Class<? extends ProtoEnum> enumType;
    private final Class<T> extendedType;
    private final Message.Label label;
    private final Class<? extends Message> messageType;
    private final String name;
    private final int tag;

    /* loaded from: classes18.dex */
    public static final class Builder<T extends ExtendableMessage<?>, E> {
        private final Message.Datatype datatype;
        private final Class<? extends ProtoEnum> enumType;
        private final Class<T> extendedType;
        private Message.Label label;
        private final Class<? extends Message> messageType;
        private String name;
        private int tag;

        private Builder(Class<T> cls, Message.Datatype datatype) {
            this.name = null;
            this.tag = -1;
            this.label = null;
            this.extendedType = cls;
            this.messageType = null;
            this.enumType = null;
            this.datatype = datatype;
        }

        /* synthetic */ Builder(Class cls, Message.Datatype datatype, Builder builder) {
            this(cls, datatype);
        }

        private Builder(Class<T> cls, Class<? extends Message> cls2, Class<? extends ProtoEnum> cls3, Message.Datatype datatype) {
            this.name = null;
            this.tag = -1;
            this.label = null;
            this.extendedType = cls;
            this.messageType = cls2;
            this.enumType = cls3;
            this.datatype = datatype;
        }

        /* synthetic */ Builder(Class cls, Class cls2, Class cls3, Message.Datatype datatype, Builder builder) {
            this(cls, cls2, cls3, datatype);
        }

        public Builder<T, E> setName(String str) {
            this.name = str;
            return this;
        }

        public Builder<T, E> setTag(int i) {
            this.tag = i;
            return this;
        }

        public Extension<T, E> buildOptional() {
            this.label = Message.Label.OPTIONAL;
            validate();
            return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype, null);
        }

        public Extension<T, E> buildRequired() {
            this.label = Message.Label.REQUIRED;
            validate();
            return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype, null);
        }

        public Extension<T, List<E>> buildRepeated() {
            this.label = Message.Label.REPEATED;
            validate();
            return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype, null);
        }

        public Extension<T, List<E>> buildPacked() {
            this.label = Message.Label.PACKED;
            validate();
            return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype, null);
        }

        private void validate() {
            if (this.extendedType == null) {
                throw new IllegalArgumentException("extendedType == null");
            }
            if (this.name == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (this.datatype == null) {
                throw new IllegalArgumentException("datatype == null");
            }
            if (this.label == null) {
                throw new IllegalArgumentException("label == null");
            }
            if (this.tag <= 0) {
                throw new IllegalArgumentException("tag == " + this.tag);
            }
            if (this.datatype == Message.Datatype.MESSAGE) {
                if (this.messageType == null || this.enumType != null) {
                    throw new IllegalStateException("Message w/o messageType or w/ enumType");
                }
            } else if (this.datatype == Message.Datatype.ENUM) {
                if (this.messageType != null || this.enumType == null) {
                    throw new IllegalStateException("Enum w/ messageType or w/o enumType");
                }
            } else if (this.messageType != null || this.enumType != null) {
                throw new IllegalStateException("Scalar w/ messageType or enumType");
            }
        }
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> int32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.INT32, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> sint32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.SINT32, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> uint32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.UINT32, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> fixed32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.FIXED32, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> sfixed32Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.SFIXED32, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> int64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.INT64, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> sint64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.SINT64, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> uint64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.UINT64, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> fixed64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.FIXED64, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> sfixed64Extending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.SFIXED64, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Boolean> boolExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.BOOL, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, String> stringExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.STRING, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, ByteString> bytesExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.BYTES, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Float> floatExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.FLOAT, null);
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Double> doubleExtending(Class<T> cls) {
        return new Builder<>(cls, Message.Datatype.DOUBLE, null);
    }

    public static <T extends ExtendableMessage<?>, E extends Enum & ProtoEnum> Builder<T, E> enumExtending(Class<E> cls, Class<T> cls2) {
        return new Builder<>(cls2, null, cls, Message.Datatype.ENUM, null);
    }

    public static <T extends ExtendableMessage<?>, M extends Message> Builder<T, M> messageExtending(Class<M> cls, Class<T> cls2) {
        return new Builder<>(cls2, cls, null, Message.Datatype.MESSAGE, null);
    }

    private Extension(Class<T> cls, Class<? extends Message> cls2, Class<? extends ProtoEnum> cls3, String str, int i, Message.Label label, Message.Datatype datatype) {
        this.extendedType = cls;
        this.name = str;
        this.tag = i;
        this.datatype = datatype;
        this.label = label;
        this.messageType = cls2;
        this.enumType = cls3;
    }

    /* synthetic */ Extension(Class cls, Class cls2, Class cls3, String str, int i, Message.Label label, Message.Datatype datatype, Extension extension) {
        this(cls, cls2, cls3, str, i, label, datatype);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(Extension<?, ?> extension) {
        if (extension == this) {
            return 0;
        }
        if (this.tag != extension.tag) {
            return this.tag - extension.tag;
        }
        if (this.datatype != extension.datatype) {
            return this.datatype.value() - extension.datatype.value();
        }
        if (this.label != extension.label) {
            return this.label.value() - extension.label.value();
        }
        if (this.extendedType != null && !this.extendedType.equals(extension.extendedType)) {
            return this.extendedType.getName().compareTo(extension.extendedType.getName());
        }
        if (this.messageType != null && !this.messageType.equals(extension.messageType)) {
            return this.messageType.getName().compareTo(extension.messageType.getName());
        }
        if (this.enumType == null || this.enumType.equals(extension.enumType)) {
            return 0;
        }
        return this.enumType.getName().compareTo(extension.enumType.getName());
    }

    public boolean equals(Object obj) {
        return (obj instanceof Extension) && compareTo((Extension) obj) == 0;
    }

    public int hashCode() {
        return (((this.messageType != null ? this.messageType.hashCode() : 0) + (((((((this.tag * 37) + this.datatype.value()) * 37) + this.label.value()) * 37) + this.extendedType.hashCode()) * 37)) * 37) + (this.enumType != null ? this.enumType.hashCode() : 0);
    }

    public String toString() {
        return String.format("[%s %s %s = %d]", this.label, this.datatype, this.name, Integer.valueOf(this.tag));
    }

    public Class<T> getExtendedType() {
        return this.extendedType;
    }

    public Class<? extends Message> getMessageType() {
        return this.messageType;
    }

    public Class<? extends ProtoEnum> getEnumType() {
        return this.enumType;
    }

    public String getName() {
        return this.name;
    }

    public int getTag() {
        return this.tag;
    }

    public Message.Datatype getDatatype() {
        return this.datatype;
    }

    public Message.Label getLabel() {
        return this.label;
    }
}
