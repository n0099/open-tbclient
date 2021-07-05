package com.squareup.wire;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.ExtendableMessage;
import com.squareup.wire.Message;
import java.util.List;
/* loaded from: classes7.dex */
public final class Extension<T extends ExtendableMessage<?>, E> implements Comparable<Extension<?, ?>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Message.Datatype datatype;
    public final Class<? extends ProtoEnum> enumType;
    public final Class<T> extendedType;
    public final Message.Label label;
    public final Class<? extends Message> messageType;
    public final String name;
    public final int tag;

    public Extension(Class<T> cls, Class<? extends Message> cls2, Class<? extends ProtoEnum> cls3, String str, int i2, Message.Label label, Message.Datatype datatype) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, cls2, cls3, str, Integer.valueOf(i2), label, datatype};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.extendedType = cls;
        this.name = str;
        this.tag = i2;
        this.datatype = datatype;
        this.label = label;
        this.messageType = cls2;
        this.enumType = cls3;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Boolean> boolExtending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.BOOL, null) : (Builder) invokeL.objValue;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, ByteString> bytesExtending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.BYTES, null) : (Builder) invokeL.objValue;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Double> doubleExtending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.DOUBLE, null) : (Builder) invokeL.objValue;
    }

    public static <T extends ExtendableMessage<?>, E extends Enum & ProtoEnum> Builder<T, E> enumExtending(Class<E> cls, Class<T> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, cls, cls2)) == null) ? new Builder<>(cls2, null, cls, Message.Datatype.ENUM, null) : (Builder) invokeLL.objValue;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> fixed32Extending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.FIXED32, null) : (Builder) invokeL.objValue;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> fixed64Extending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.FIXED64, null) : (Builder) invokeL.objValue;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Float> floatExtending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.FLOAT, null) : (Builder) invokeL.objValue;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> int32Extending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.INT32, null) : (Builder) invokeL.objValue;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> int64Extending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.INT64, null) : (Builder) invokeL.objValue;
    }

    public static <T extends ExtendableMessage<?>, M extends Message> Builder<T, M> messageExtending(Class<M> cls, Class<T> cls2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, cls, cls2)) == null) ? new Builder<>(cls2, cls, null, Message.Datatype.MESSAGE, null) : (Builder) invokeLL.objValue;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> sfixed32Extending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.SFIXED32, null) : (Builder) invokeL.objValue;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> sfixed64Extending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.SFIXED64, null) : (Builder) invokeL.objValue;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> sint32Extending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.SINT32, null) : (Builder) invokeL.objValue;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> sint64Extending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65551, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.SINT64, null) : (Builder) invokeL.objValue;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, String> stringExtending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.STRING, null) : (Builder) invokeL.objValue;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Integer> uint32Extending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.UINT32, null) : (Builder) invokeL.objValue;
    }

    public static <T extends ExtendableMessage<?>> Builder<T, Long> uint64Extending(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, cls)) == null) ? new Builder<>(cls, Message.Datatype.UINT64, null) : (Builder) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? (obj instanceof Extension) && compareTo((Extension) obj) == 0 : invokeL.booleanValue;
    }

    public Message.Datatype getDatatype() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.datatype : (Message.Datatype) invokeV.objValue;
    }

    public Class<? extends ProtoEnum> getEnumType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.enumType : (Class) invokeV.objValue;
    }

    public Class<T> getExtendedType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.extendedType : (Class) invokeV.objValue;
    }

    public Message.Label getLabel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.label : (Message.Label) invokeV.objValue;
    }

    public Class<? extends Message> getMessageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.messageType : (Class) invokeV.objValue;
    }

    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.name : (String) invokeV.objValue;
    }

    public int getTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.tag : invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int value = ((((((this.tag * 37) + this.datatype.value()) * 37) + this.label.value()) * 37) + this.extendedType.hashCode()) * 37;
            Class<? extends Message> cls = this.messageType;
            int hashCode = (value + (cls != null ? cls.hashCode() : 0)) * 37;
            Class<? extends ProtoEnum> cls2 = this.enumType;
            return hashCode + (cls2 != null ? cls2.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? String.format("[%s %s %s = %d]", this.label, this.datatype, this.name, Integer.valueOf(this.tag)) : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(Extension<?, ?> extension) {
        InterceptResult invokeL;
        int value;
        int value2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, extension)) == null) {
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
        return invokeL.intValue;
    }

    /* loaded from: classes7.dex */
    public static final class Builder<T extends ExtendableMessage<?>, E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Message.Datatype datatype;
        public final Class<? extends ProtoEnum> enumType;
        public final Class<T> extendedType;
        public Message.Label label;
        public final Class<? extends Message> messageType;
        public String name;
        public int tag;

        public Builder(Class<T> cls, Message.Datatype datatype) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, datatype};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.name = null;
            this.tag = -1;
            this.label = null;
            this.extendedType = cls;
            this.messageType = null;
            this.enumType = null;
            this.datatype = datatype;
        }

        private void validate() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65540, this) == null) {
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
        }

        public Extension<T, E> buildOptional() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.label = Message.Label.OPTIONAL;
                validate();
                return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype, null);
            }
            return (Extension) invokeV.objValue;
        }

        public Extension<T, List<E>> buildPacked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.label = Message.Label.PACKED;
                validate();
                return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype, null);
            }
            return (Extension) invokeV.objValue;
        }

        public Extension<T, List<E>> buildRepeated() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.label = Message.Label.REPEATED;
                validate();
                return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype, null);
            }
            return (Extension) invokeV.objValue;
        }

        public Extension<T, E> buildRequired() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.label = Message.Label.REQUIRED;
                validate();
                return new Extension<>(this.extendedType, this.messageType, this.enumType, this.name, this.tag, this.label, this.datatype, null);
            }
            return (Extension) invokeV.objValue;
        }

        public Builder<T, E> setName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.name = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder<T, E> setTag(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
                this.tag = i2;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public /* synthetic */ Builder(Class cls, Message.Datatype datatype, Builder builder) {
            this(cls, datatype);
        }

        public Builder(Class<T> cls, Class<? extends Message> cls2, Class<? extends ProtoEnum> cls3, Message.Datatype datatype) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cls, cls2, cls3, datatype};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
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
