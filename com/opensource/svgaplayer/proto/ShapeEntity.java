package com.opensource.svgaplayer.proto;

import androidx.core.view.InputDeviceCompat;
import b.m.a.c;
import b.m.a.d;
import b.m.a.g;
import b.m.a.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.Message;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import java.io.IOException;
import okio.ByteString;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes2.dex */
public final class ShapeEntity extends Message<ShapeEntity, Builder> {
    public static /* synthetic */ Interceptable $ic;
    public static final ProtoAdapter<ShapeEntity> ADAPTER;
    public static final ShapeType DEFAULT_TYPE;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$EllipseArgs#ADAPTER", tag = 4)
    public final EllipseArgs ellipse;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$RectArgs#ADAPTER", tag = 3)
    public final RectArgs rect;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeArgs#ADAPTER", tag = 2)
    public final ShapeArgs shape;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle#ADAPTER", tag = 10)
    public final ShapeStyle styles;
    @WireField(adapter = "com.opensource.svgaplayer.proto.Transform#ADAPTER", tag = 11)
    public final Transform transform;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeType#ADAPTER", tag = 1)
    public final ShapeType type;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.a<ShapeEntity, Builder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public EllipseArgs ellipse;
        public RectArgs rect;
        public ShapeArgs shape;
        public ShapeStyle styles;
        public Transform transform;
        public ShapeType type;

        public Builder() {
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

        public Builder ellipse(EllipseArgs ellipseArgs) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ellipseArgs)) == null) {
                this.ellipse = ellipseArgs;
                this.shape = null;
                this.rect = null;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder rect(RectArgs rectArgs) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rectArgs)) == null) {
                this.rect = rectArgs;
                this.shape = null;
                this.ellipse = null;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder shape(ShapeArgs shapeArgs) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, shapeArgs)) == null) {
                this.shape = shapeArgs;
                this.rect = null;
                this.ellipse = null;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder styles(ShapeStyle shapeStyle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, shapeStyle)) == null) {
                this.styles = shapeStyle;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder transform(Transform transform) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, transform)) == null) {
                this.transform = transform;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder type(ShapeType shapeType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, shapeType)) == null) {
                this.type = shapeType;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public ShapeEntity build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ShapeEntity(this.type, this.styles, this.transform, this.shape, this.rect, this.ellipse, super.buildUnknownFields()) : (ShapeEntity) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class EllipseArgs extends Message<EllipseArgs, Builder> {
        public static /* synthetic */ Interceptable $ic;
        public static final ProtoAdapter<EllipseArgs> ADAPTER;
        public static final Float DEFAULT_RADIUSX;
        public static final Float DEFAULT_RADIUSY;
        public static final Float DEFAULT_X;
        public static final Float DEFAULT_Y;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float radiusX;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
        public final Float radiusY;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
        public final Float x;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
        public final Float y;

        /* loaded from: classes2.dex */
        public static final class Builder extends Message.a<EllipseArgs, Builder> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Float radiusX;
            public Float radiusY;
            public Float x;
            public Float y;

            public Builder() {
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

            public Builder radiusX(Float f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
                    this.radiusX = f2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder radiusY(Float f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, f2)) == null) {
                    this.radiusY = f2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder x(Float f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f2)) == null) {
                    this.x = f2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder y(Float f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f2)) == null) {
                    this.y = f2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.Message.a
            public EllipseArgs build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new EllipseArgs(this.x, this.y, this.radiusX, this.radiusY, super.buildUnknownFields()) : (EllipseArgs) invokeV.objValue;
            }
        }

        /* loaded from: classes2.dex */
        public static final class ProtoAdapter_EllipseArgs extends ProtoAdapter<EllipseArgs> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ProtoAdapter_EllipseArgs() {
                super(FieldEncoding.LENGTH_DELIMITED, EllipseArgs.class);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr = newInitContext.callArgs;
                        super((FieldEncoding) objArr[0], (Class) objArr[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.ProtoAdapter
            public EllipseArgs decode(c cVar) throws IOException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, cVar)) != null) {
                    return (EllipseArgs) invokeL.objValue;
                }
                Builder builder = new Builder();
                long c2 = cVar.c();
                while (true) {
                    int f2 = cVar.f();
                    if (f2 == -1) {
                        cVar.d(c2);
                        return builder.build();
                    } else if (f2 == 1) {
                        builder.x(ProtoAdapter.FLOAT.decode(cVar));
                    } else if (f2 == 2) {
                        builder.y(ProtoAdapter.FLOAT.decode(cVar));
                    } else if (f2 == 3) {
                        builder.radiusX(ProtoAdapter.FLOAT.decode(cVar));
                    } else if (f2 != 4) {
                        FieldEncoding g2 = cVar.g();
                        builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                    } else {
                        builder.radiusY(ProtoAdapter.FLOAT.decode(cVar));
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(d dVar, EllipseArgs ellipseArgs) throws IOException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, ellipseArgs) == null) {
                    Float f2 = ellipseArgs.x;
                    if (f2 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, f2);
                    }
                    Float f3 = ellipseArgs.y;
                    if (f3 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, f3);
                    }
                    Float f4 = ellipseArgs.radiusX;
                    if (f4 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, f4);
                    }
                    Float f5 = ellipseArgs.radiusY;
                    if (f5 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 4, f5);
                    }
                    dVar.k(ellipseArgs.unknownFields());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(EllipseArgs ellipseArgs) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ellipseArgs)) == null) {
                    Float f2 = ellipseArgs.x;
                    int encodedSizeWithTag = f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f2) : 0;
                    Float f3 = ellipseArgs.y;
                    int encodedSizeWithTag2 = encodedSizeWithTag + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f3) : 0);
                    Float f4 = ellipseArgs.radiusX;
                    int encodedSizeWithTag3 = encodedSizeWithTag2 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f4) : 0);
                    Float f5 = ellipseArgs.radiusY;
                    return encodedSizeWithTag3 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f5) : 0) + ellipseArgs.unknownFields().size();
                }
                return invokeL.intValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public EllipseArgs redact(EllipseArgs ellipseArgs) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, ellipseArgs)) == null) {
                    Message.a<EllipseArgs, Builder> newBuilder2 = ellipseArgs.newBuilder2();
                    newBuilder2.clearUnknownFields();
                    return newBuilder2.build();
                }
                return (EllipseArgs) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(371639304, "Lcom/opensource/svgaplayer/proto/ShapeEntity$EllipseArgs;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(371639304, "Lcom/opensource/svgaplayer/proto/ShapeEntity$EllipseArgs;");
                    return;
                }
            }
            ADAPTER = new ProtoAdapter_EllipseArgs();
            Float valueOf = Float.valueOf(0.0f);
            DEFAULT_X = valueOf;
            DEFAULT_Y = valueOf;
            DEFAULT_RADIUSX = valueOf;
            DEFAULT_RADIUSY = valueOf;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public EllipseArgs(Float f2, Float f3, Float f4, Float f5) {
            this(f2, f3, f4, f5, ByteString.EMPTY);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f2, f3, f4, f5};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Float) objArr2[0], (Float) objArr2[1], (Float) objArr2[2], (Float) objArr2[3], (ByteString) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof EllipseArgs) {
                    EllipseArgs ellipseArgs = (EllipseArgs) obj;
                    return unknownFields().equals(ellipseArgs.unknownFields()) && a.f(this.x, ellipseArgs.x) && a.f(this.y, ellipseArgs.y) && a.f(this.radiusX, ellipseArgs.radiusX) && a.f(this.radiusY, ellipseArgs.radiusY);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.hashCode;
                if (i2 == 0) {
                    int hashCode = unknownFields().hashCode() * 37;
                    Float f2 = this.x;
                    int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 37;
                    Float f3 = this.y;
                    int hashCode3 = (hashCode2 + (f3 != null ? f3.hashCode() : 0)) * 37;
                    Float f4 = this.radiusX;
                    int hashCode4 = (hashCode3 + (f4 != null ? f4.hashCode() : 0)) * 37;
                    Float f5 = this.radiusY;
                    int hashCode5 = hashCode4 + (f5 != null ? f5.hashCode() : 0);
                    this.hashCode = hashCode5;
                    return hashCode5;
                }
                return i2;
            }
            return invokeV.intValue;
        }

        @Override // com.squareup.wire2.Message
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                StringBuilder sb = new StringBuilder();
                if (this.x != null) {
                    sb.append(", x=");
                    sb.append(this.x);
                }
                if (this.y != null) {
                    sb.append(", y=");
                    sb.append(this.y);
                }
                if (this.radiusX != null) {
                    sb.append(", radiusX=");
                    sb.append(this.radiusX);
                }
                if (this.radiusY != null) {
                    sb.append(", radiusY=");
                    sb.append(this.radiusY);
                }
                StringBuilder replace = sb.replace(0, 2, "EllipseArgs{");
                replace.append(ExtendedMessageFormat.END_FE);
                return replace.toString();
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EllipseArgs(Float f2, Float f3, Float f4, Float f5, ByteString byteString) {
            super(ADAPTER, byteString);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f2, f3, f4, f5, byteString};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.x = f2;
            this.y = f3;
            this.radiusX = f4;
            this.radiusY = f5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.ShapeEntity$EllipseArgs$Builder' to match base method */
        @Override // com.squareup.wire2.Message
        /* renamed from: newBuilder */
        public Message.a<EllipseArgs, Builder> newBuilder2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Builder builder = new Builder();
                builder.x = this.x;
                builder.y = this.y;
                builder.radiusX = this.radiusX;
                builder.radiusY = this.radiusY;
                builder.addUnknownFields(unknownFields());
                return builder;
            }
            return (Builder) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ProtoAdapter_ShapeEntity extends ProtoAdapter<ShapeEntity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProtoAdapter_ShapeEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, ShapeEntity.class);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr = newInitContext.callArgs;
                    super((FieldEncoding) objArr[0], (Class) objArr[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public ShapeEntity decode(c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, cVar)) != null) {
                return (ShapeEntity) invokeL.objValue;
            }
            Builder builder = new Builder();
            long c2 = cVar.c();
            while (true) {
                int f2 = cVar.f();
                if (f2 == -1) {
                    cVar.d(c2);
                    return builder.build();
                } else if (f2 == 1) {
                    try {
                        builder.type(ShapeType.ADAPTER.decode(cVar));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                        builder.addUnknownField(f2, FieldEncoding.VARINT, Long.valueOf(e2.value));
                    }
                } else if (f2 == 2) {
                    builder.shape(ShapeArgs.ADAPTER.decode(cVar));
                } else if (f2 == 3) {
                    builder.rect(RectArgs.ADAPTER.decode(cVar));
                } else if (f2 == 4) {
                    builder.ellipse(EllipseArgs.ADAPTER.decode(cVar));
                } else if (f2 == 10) {
                    builder.styles(ShapeStyle.ADAPTER.decode(cVar));
                } else if (f2 != 11) {
                    FieldEncoding g2 = cVar.g();
                    builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                } else {
                    builder.transform(Transform.ADAPTER.decode(cVar));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, ShapeEntity shapeEntity) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, shapeEntity) == null) {
                ShapeType shapeType = shapeEntity.type;
                if (shapeType != null) {
                    ShapeType.ADAPTER.encodeWithTag(dVar, 1, shapeType);
                }
                ShapeStyle shapeStyle = shapeEntity.styles;
                if (shapeStyle != null) {
                    ShapeStyle.ADAPTER.encodeWithTag(dVar, 10, shapeStyle);
                }
                Transform transform = shapeEntity.transform;
                if (transform != null) {
                    Transform.ADAPTER.encodeWithTag(dVar, 11, transform);
                }
                ShapeArgs shapeArgs = shapeEntity.shape;
                if (shapeArgs != null) {
                    ShapeArgs.ADAPTER.encodeWithTag(dVar, 2, shapeArgs);
                }
                RectArgs rectArgs = shapeEntity.rect;
                if (rectArgs != null) {
                    RectArgs.ADAPTER.encodeWithTag(dVar, 3, rectArgs);
                }
                EllipseArgs ellipseArgs = shapeEntity.ellipse;
                if (ellipseArgs != null) {
                    EllipseArgs.ADAPTER.encodeWithTag(dVar, 4, ellipseArgs);
                }
                dVar.k(shapeEntity.unknownFields());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(ShapeEntity shapeEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, shapeEntity)) == null) {
                ShapeType shapeType = shapeEntity.type;
                int encodedSizeWithTag = shapeType != null ? ShapeType.ADAPTER.encodedSizeWithTag(1, shapeType) : 0;
                ShapeStyle shapeStyle = shapeEntity.styles;
                int encodedSizeWithTag2 = encodedSizeWithTag + (shapeStyle != null ? ShapeStyle.ADAPTER.encodedSizeWithTag(10, shapeStyle) : 0);
                Transform transform = shapeEntity.transform;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + (transform != null ? Transform.ADAPTER.encodedSizeWithTag(11, transform) : 0);
                ShapeArgs shapeArgs = shapeEntity.shape;
                int encodedSizeWithTag4 = encodedSizeWithTag3 + (shapeArgs != null ? ShapeArgs.ADAPTER.encodedSizeWithTag(2, shapeArgs) : 0);
                RectArgs rectArgs = shapeEntity.rect;
                int encodedSizeWithTag5 = encodedSizeWithTag4 + (rectArgs != null ? RectArgs.ADAPTER.encodedSizeWithTag(3, rectArgs) : 0);
                EllipseArgs ellipseArgs = shapeEntity.ellipse;
                return encodedSizeWithTag5 + (ellipseArgs != null ? EllipseArgs.ADAPTER.encodedSizeWithTag(4, ellipseArgs) : 0) + shapeEntity.unknownFields().size();
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r5v1, types: [com.squareup.wire2.Message$a, com.opensource.svgaplayer.proto.ShapeEntity$Builder] */
        @Override // com.squareup.wire2.ProtoAdapter
        public ShapeEntity redact(ShapeEntity shapeEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, shapeEntity)) == null) {
                ?? newBuilder2 = shapeEntity.newBuilder2();
                ShapeStyle shapeStyle = newBuilder2.styles;
                if (shapeStyle != null) {
                    newBuilder2.styles = ShapeStyle.ADAPTER.redact(shapeStyle);
                }
                Transform transform = newBuilder2.transform;
                if (transform != null) {
                    newBuilder2.transform = Transform.ADAPTER.redact(transform);
                }
                ShapeArgs shapeArgs = newBuilder2.shape;
                if (shapeArgs != null) {
                    newBuilder2.shape = ShapeArgs.ADAPTER.redact(shapeArgs);
                }
                RectArgs rectArgs = newBuilder2.rect;
                if (rectArgs != null) {
                    newBuilder2.rect = RectArgs.ADAPTER.redact(rectArgs);
                }
                EllipseArgs ellipseArgs = newBuilder2.ellipse;
                if (ellipseArgs != null) {
                    newBuilder2.ellipse = EllipseArgs.ADAPTER.redact(ellipseArgs);
                }
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
            return (ShapeEntity) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class RectArgs extends Message<RectArgs, Builder> {
        public static /* synthetic */ Interceptable $ic;
        public static final ProtoAdapter<RectArgs> ADAPTER;
        public static final Float DEFAULT_CORNERRADIUS;
        public static final Float DEFAULT_HEIGHT;
        public static final Float DEFAULT_WIDTH;
        public static final Float DEFAULT_X;
        public static final Float DEFAULT_Y;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
        public final Float cornerRadius;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
        public final Float height;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float width;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
        public final Float x;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
        public final Float y;

        /* loaded from: classes2.dex */
        public static final class Builder extends Message.a<RectArgs, Builder> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public Float cornerRadius;
            public Float height;
            public Float width;
            public Float x;
            public Float y;

            public Builder() {
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

            public Builder cornerRadius(Float f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f2)) == null) {
                    this.cornerRadius = f2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder height(Float f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, f2)) == null) {
                    this.height = f2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder width(Float f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f2)) == null) {
                    this.width = f2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder x(Float f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f2)) == null) {
                    this.x = f2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder y(Float f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, f2)) == null) {
                    this.y = f2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.Message.a
            public RectArgs build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new RectArgs(this.x, this.y, this.width, this.height, this.cornerRadius, super.buildUnknownFields()) : (RectArgs) invokeV.objValue;
            }
        }

        /* loaded from: classes2.dex */
        public static final class ProtoAdapter_RectArgs extends ProtoAdapter<RectArgs> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ProtoAdapter_RectArgs() {
                super(FieldEncoding.LENGTH_DELIMITED, RectArgs.class);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr = newInitContext.callArgs;
                        super((FieldEncoding) objArr[0], (Class) objArr[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.ProtoAdapter
            public RectArgs decode(c cVar) throws IOException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, cVar)) != null) {
                    return (RectArgs) invokeL.objValue;
                }
                Builder builder = new Builder();
                long c2 = cVar.c();
                while (true) {
                    int f2 = cVar.f();
                    if (f2 == -1) {
                        cVar.d(c2);
                        return builder.build();
                    } else if (f2 == 1) {
                        builder.x(ProtoAdapter.FLOAT.decode(cVar));
                    } else if (f2 == 2) {
                        builder.y(ProtoAdapter.FLOAT.decode(cVar));
                    } else if (f2 == 3) {
                        builder.width(ProtoAdapter.FLOAT.decode(cVar));
                    } else if (f2 == 4) {
                        builder.height(ProtoAdapter.FLOAT.decode(cVar));
                    } else if (f2 != 5) {
                        FieldEncoding g2 = cVar.g();
                        builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                    } else {
                        builder.cornerRadius(ProtoAdapter.FLOAT.decode(cVar));
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(d dVar, RectArgs rectArgs) throws IOException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, rectArgs) == null) {
                    Float f2 = rectArgs.x;
                    if (f2 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, f2);
                    }
                    Float f3 = rectArgs.y;
                    if (f3 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, f3);
                    }
                    Float f4 = rectArgs.width;
                    if (f4 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, f4);
                    }
                    Float f5 = rectArgs.height;
                    if (f5 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 4, f5);
                    }
                    Float f6 = rectArgs.cornerRadius;
                    if (f6 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 5, f6);
                    }
                    dVar.k(rectArgs.unknownFields());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(RectArgs rectArgs) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rectArgs)) == null) {
                    Float f2 = rectArgs.x;
                    int encodedSizeWithTag = f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f2) : 0;
                    Float f3 = rectArgs.y;
                    int encodedSizeWithTag2 = encodedSizeWithTag + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f3) : 0);
                    Float f4 = rectArgs.width;
                    int encodedSizeWithTag3 = encodedSizeWithTag2 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f4) : 0);
                    Float f5 = rectArgs.height;
                    int encodedSizeWithTag4 = encodedSizeWithTag3 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f5) : 0);
                    Float f6 = rectArgs.cornerRadius;
                    return encodedSizeWithTag4 + (f6 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(5, f6) : 0) + rectArgs.unknownFields().size();
                }
                return invokeL.intValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public RectArgs redact(RectArgs rectArgs) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rectArgs)) == null) {
                    Message.a<RectArgs, Builder> newBuilder2 = rectArgs.newBuilder2();
                    newBuilder2.clearUnknownFields();
                    return newBuilder2.build();
                }
                return (RectArgs) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1544213966, "Lcom/opensource/svgaplayer/proto/ShapeEntity$RectArgs;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1544213966, "Lcom/opensource/svgaplayer/proto/ShapeEntity$RectArgs;");
                    return;
                }
            }
            ADAPTER = new ProtoAdapter_RectArgs();
            Float valueOf = Float.valueOf(0.0f);
            DEFAULT_X = valueOf;
            DEFAULT_Y = valueOf;
            DEFAULT_WIDTH = valueOf;
            DEFAULT_HEIGHT = valueOf;
            DEFAULT_CORNERRADIUS = valueOf;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RectArgs(Float f2, Float f3, Float f4, Float f5, Float f6) {
            this(f2, f3, f4, f5, f6, ByteString.EMPTY);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f2, f3, f4, f5, f6};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Float) objArr2[0], (Float) objArr2[1], (Float) objArr2[2], (Float) objArr2[3], (Float) objArr2[4], (ByteString) objArr2[5]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof RectArgs) {
                    RectArgs rectArgs = (RectArgs) obj;
                    return unknownFields().equals(rectArgs.unknownFields()) && a.f(this.x, rectArgs.x) && a.f(this.y, rectArgs.y) && a.f(this.width, rectArgs.width) && a.f(this.height, rectArgs.height) && a.f(this.cornerRadius, rectArgs.cornerRadius);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.hashCode;
                if (i2 == 0) {
                    int hashCode = unknownFields().hashCode() * 37;
                    Float f2 = this.x;
                    int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 37;
                    Float f3 = this.y;
                    int hashCode3 = (hashCode2 + (f3 != null ? f3.hashCode() : 0)) * 37;
                    Float f4 = this.width;
                    int hashCode4 = (hashCode3 + (f4 != null ? f4.hashCode() : 0)) * 37;
                    Float f5 = this.height;
                    int hashCode5 = (hashCode4 + (f5 != null ? f5.hashCode() : 0)) * 37;
                    Float f6 = this.cornerRadius;
                    int hashCode6 = hashCode5 + (f6 != null ? f6.hashCode() : 0);
                    this.hashCode = hashCode6;
                    return hashCode6;
                }
                return i2;
            }
            return invokeV.intValue;
        }

        @Override // com.squareup.wire2.Message
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                StringBuilder sb = new StringBuilder();
                if (this.x != null) {
                    sb.append(", x=");
                    sb.append(this.x);
                }
                if (this.y != null) {
                    sb.append(", y=");
                    sb.append(this.y);
                }
                if (this.width != null) {
                    sb.append(", width=");
                    sb.append(this.width);
                }
                if (this.height != null) {
                    sb.append(", height=");
                    sb.append(this.height);
                }
                if (this.cornerRadius != null) {
                    sb.append(", cornerRadius=");
                    sb.append(this.cornerRadius);
                }
                StringBuilder replace = sb.replace(0, 2, "RectArgs{");
                replace.append(ExtendedMessageFormat.END_FE);
                return replace.toString();
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RectArgs(Float f2, Float f3, Float f4, Float f5, Float f6, ByteString byteString) {
            super(ADAPTER, byteString);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f2, f3, f4, f5, f6, byteString};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.x = f2;
            this.y = f3;
            this.width = f4;
            this.height = f5;
            this.cornerRadius = f6;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.ShapeEntity$RectArgs$Builder' to match base method */
        @Override // com.squareup.wire2.Message
        /* renamed from: newBuilder */
        public Message.a<RectArgs, Builder> newBuilder2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Builder builder = new Builder();
                builder.x = this.x;
                builder.y = this.y;
                builder.width = this.width;
                builder.height = this.height;
                builder.cornerRadius = this.cornerRadius;
                builder.addUnknownFields(unknownFields());
                return builder;
            }
            return (Builder) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ShapeArgs extends Message<ShapeArgs, Builder> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final ProtoAdapter<ShapeArgs> ADAPTER;
        public static final String DEFAULT_D = "";
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)

        /* renamed from: d  reason: collision with root package name */
        public final String f68702d;

        /* loaded from: classes2.dex */
        public static final class Builder extends Message.a<ShapeArgs, Builder> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: d  reason: collision with root package name */
            public String f68703d;

            public Builder() {
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

            public Builder d(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                    this.f68703d = str;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.Message.a
            public ShapeArgs build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ShapeArgs(this.f68703d, super.buildUnknownFields()) : (ShapeArgs) invokeV.objValue;
            }
        }

        /* loaded from: classes2.dex */
        public static final class ProtoAdapter_ShapeArgs extends ProtoAdapter<ShapeArgs> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ProtoAdapter_ShapeArgs() {
                super(FieldEncoding.LENGTH_DELIMITED, ShapeArgs.class);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr = newInitContext.callArgs;
                        super((FieldEncoding) objArr[0], (Class) objArr[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.ProtoAdapter
            public ShapeArgs decode(c cVar) throws IOException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, cVar)) != null) {
                    return (ShapeArgs) invokeL.objValue;
                }
                Builder builder = new Builder();
                long c2 = cVar.c();
                while (true) {
                    int f2 = cVar.f();
                    if (f2 == -1) {
                        cVar.d(c2);
                        return builder.build();
                    } else if (f2 != 1) {
                        FieldEncoding g2 = cVar.g();
                        builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                    } else {
                        builder.d(ProtoAdapter.STRING.decode(cVar));
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(d dVar, ShapeArgs shapeArgs) throws IOException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, shapeArgs) == null) {
                    String str = shapeArgs.f68702d;
                    if (str != null) {
                        ProtoAdapter.STRING.encodeWithTag(dVar, 1, str);
                    }
                    dVar.k(shapeArgs.unknownFields());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(ShapeArgs shapeArgs) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, shapeArgs)) == null) {
                    String str = shapeArgs.f68702d;
                    return (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0) + shapeArgs.unknownFields().size();
                }
                return invokeL.intValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public ShapeArgs redact(ShapeArgs shapeArgs) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, shapeArgs)) == null) {
                    Message.a<ShapeArgs, Builder> newBuilder2 = shapeArgs.newBuilder2();
                    newBuilder2.clearUnknownFields();
                    return newBuilder2.build();
                }
                return (ShapeArgs) invokeL.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(590111781, "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeArgs;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(590111781, "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeArgs;");
                    return;
                }
            }
            ADAPTER = new ProtoAdapter_ShapeArgs();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ShapeArgs(String str) {
            this(str, ByteString.EMPTY);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((String) objArr2[0], (ByteString) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof ShapeArgs) {
                    ShapeArgs shapeArgs = (ShapeArgs) obj;
                    return unknownFields().equals(shapeArgs.unknownFields()) && a.f(this.f68702d, shapeArgs.f68702d);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.hashCode;
                if (i2 == 0) {
                    int hashCode = unknownFields().hashCode() * 37;
                    String str = this.f68702d;
                    int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
                    this.hashCode = hashCode2;
                    return hashCode2;
                }
                return i2;
            }
            return invokeV.intValue;
        }

        @Override // com.squareup.wire2.Message
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                StringBuilder sb = new StringBuilder();
                if (this.f68702d != null) {
                    sb.append(", d=");
                    sb.append(this.f68702d);
                }
                StringBuilder replace = sb.replace(0, 2, "ShapeArgs{");
                replace.append(ExtendedMessageFormat.END_FE);
                return replace.toString();
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShapeArgs(String str, ByteString byteString) {
            super(ADAPTER, byteString);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, byteString};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.f68702d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.ShapeEntity$ShapeArgs$Builder' to match base method */
        @Override // com.squareup.wire2.Message
        /* renamed from: newBuilder */
        public Message.a<ShapeArgs, Builder> newBuilder2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Builder builder = new Builder();
                builder.f68703d = this.f68702d;
                builder.addUnknownFields(unknownFields());
                return builder;
            }
            return (Builder) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static final class ShapeStyle extends Message<ShapeStyle, Builder> {
        public static /* synthetic */ Interceptable $ic;
        public static final ProtoAdapter<ShapeStyle> ADAPTER;
        public static final LineCap DEFAULT_LINECAP;
        public static final Float DEFAULT_LINEDASHI;
        public static final Float DEFAULT_LINEDASHII;
        public static final Float DEFAULT_LINEDASHIII;
        public static final LineJoin DEFAULT_LINEJOIN;
        public static final Float DEFAULT_MITERLIMIT;
        public static final Float DEFAULT_STROKEWIDTH;
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor#ADAPTER", tag = 1)
        public final RGBAColor fill;
        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$LineCap#ADAPTER", tag = 4)
        public final LineCap lineCap;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 7)
        public final Float lineDashI;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 8)
        public final Float lineDashII;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 9)
        public final Float lineDashIII;
        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$LineJoin#ADAPTER", tag = 5)
        public final LineJoin lineJoin;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
        public final Float miterLimit;
        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor#ADAPTER", tag = 2)
        public final RGBAColor stroke;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float strokeWidth;

        /* loaded from: classes2.dex */
        public static final class Builder extends Message.a<ShapeStyle, Builder> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public RGBAColor fill;
            public LineCap lineCap;
            public Float lineDashI;
            public Float lineDashII;
            public Float lineDashIII;
            public LineJoin lineJoin;
            public Float miterLimit;
            public RGBAColor stroke;
            public Float strokeWidth;

            public Builder() {
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

            public Builder fill(RGBAColor rGBAColor) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rGBAColor)) == null) {
                    this.fill = rGBAColor;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder lineCap(LineCap lineCap) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, lineCap)) == null) {
                    this.lineCap = lineCap;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder lineDashI(Float f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f2)) == null) {
                    this.lineDashI = f2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder lineDashII(Float f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f2)) == null) {
                    this.lineDashII = f2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder lineDashIII(Float f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, f2)) == null) {
                    this.lineDashIII = f2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder lineJoin(LineJoin lineJoin) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, lineJoin)) == null) {
                    this.lineJoin = lineJoin;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder miterLimit(Float f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2)) == null) {
                    this.miterLimit = f2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder stroke(RGBAColor rGBAColor) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, rGBAColor)) == null) {
                    this.stroke = rGBAColor;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder strokeWidth(Float f2) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, f2)) == null) {
                    this.strokeWidth = f2;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.Message.a
            public ShapeStyle build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new ShapeStyle(this.fill, this.stroke, this.strokeWidth, this.lineCap, this.lineJoin, this.miterLimit, this.lineDashI, this.lineDashII, this.lineDashIII, super.buildUnknownFields()) : (ShapeStyle) invokeV.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes2.dex */
        public static final class LineCap implements g {
            public static final /* synthetic */ LineCap[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final ProtoAdapter<LineCap> ADAPTER;
            public static final LineCap LineCap_BUTT;
            public static final LineCap LineCap_ROUND;
            public static final LineCap LineCap_SQUARE;
            public transient /* synthetic */ FieldHolder $fh;
            public final int value;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(475300137, "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeStyle$LineCap;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(475300137, "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeStyle$LineCap;");
                        return;
                    }
                }
                LineCap_BUTT = new LineCap("LineCap_BUTT", 0, 0);
                LineCap_ROUND = new LineCap("LineCap_ROUND", 1, 1);
                LineCap lineCap = new LineCap("LineCap_SQUARE", 2, 2);
                LineCap_SQUARE = lineCap;
                $VALUES = new LineCap[]{LineCap_BUTT, LineCap_ROUND, lineCap};
                ADAPTER = ProtoAdapter.newEnumAdapter(LineCap.class);
            }

            public LineCap(String str, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.value = i3;
            }

            public static LineCap fromValue(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                return null;
                            }
                            return LineCap_SQUARE;
                        }
                        return LineCap_ROUND;
                    }
                    return LineCap_BUTT;
                }
                return (LineCap) invokeI.objValue;
            }

            public static LineCap valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (LineCap) Enum.valueOf(LineCap.class, str) : (LineCap) invokeL.objValue;
            }

            public static LineCap[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (LineCap[]) $VALUES.clone() : (LineCap[]) invokeV.objValue;
            }

            @Override // b.m.a.g
            public int getValue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes2.dex */
        public static final class LineJoin implements g {
            public static final /* synthetic */ LineJoin[] $VALUES;
            public static /* synthetic */ Interceptable $ic;
            public static final ProtoAdapter<LineJoin> ADAPTER;
            public static final LineJoin LineJoin_BEVEL;
            public static final LineJoin LineJoin_MITER;
            public static final LineJoin LineJoin_ROUND;
            public transient /* synthetic */ FieldHolder $fh;
            public final int value;

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1856278993, "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeStyle$LineJoin;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(1856278993, "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeStyle$LineJoin;");
                        return;
                    }
                }
                LineJoin_MITER = new LineJoin("LineJoin_MITER", 0, 0);
                LineJoin_ROUND = new LineJoin("LineJoin_ROUND", 1, 1);
                LineJoin lineJoin = new LineJoin("LineJoin_BEVEL", 2, 2);
                LineJoin_BEVEL = lineJoin;
                $VALUES = new LineJoin[]{LineJoin_MITER, LineJoin_ROUND, lineJoin};
                ADAPTER = ProtoAdapter.newEnumAdapter(LineJoin.class);
            }

            public LineJoin(String str, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        String str2 = (String) objArr2[0];
                        ((Integer) objArr2[1]).intValue();
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
                this.value = i3;
            }

            public static LineJoin fromValue(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                return null;
                            }
                            return LineJoin_BEVEL;
                        }
                        return LineJoin_ROUND;
                    }
                    return LineJoin_MITER;
                }
                return (LineJoin) invokeI.objValue;
            }

            public static LineJoin valueOf(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (LineJoin) Enum.valueOf(LineJoin.class, str) : (LineJoin) invokeL.objValue;
            }

            public static LineJoin[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (LineJoin[]) $VALUES.clone() : (LineJoin[]) invokeV.objValue;
            }

            @Override // b.m.a.g
            public int getValue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
            }
        }

        /* loaded from: classes2.dex */
        public static final class ProtoAdapter_ShapeStyle extends ProtoAdapter<ShapeStyle> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ProtoAdapter_ShapeStyle() {
                super(FieldEncoding.LENGTH_DELIMITED, ShapeStyle.class);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr = newInitContext.callArgs;
                        super((FieldEncoding) objArr[0], (Class) objArr[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.ProtoAdapter
            public ShapeStyle decode(c cVar) throws IOException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cVar)) == null) {
                    Builder builder = new Builder();
                    long c2 = cVar.c();
                    while (true) {
                        int f2 = cVar.f();
                        if (f2 != -1) {
                            switch (f2) {
                                case 1:
                                    builder.fill(RGBAColor.ADAPTER.decode(cVar));
                                    break;
                                case 2:
                                    builder.stroke(RGBAColor.ADAPTER.decode(cVar));
                                    break;
                                case 3:
                                    builder.strokeWidth(ProtoAdapter.FLOAT.decode(cVar));
                                    break;
                                case 4:
                                    try {
                                        builder.lineCap(LineCap.ADAPTER.decode(cVar));
                                        break;
                                    } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                        builder.addUnknownField(f2, FieldEncoding.VARINT, Long.valueOf(e2.value));
                                        break;
                                    }
                                case 5:
                                    try {
                                        builder.lineJoin(LineJoin.ADAPTER.decode(cVar));
                                        break;
                                    } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                        builder.addUnknownField(f2, FieldEncoding.VARINT, Long.valueOf(e3.value));
                                        break;
                                    }
                                case 6:
                                    builder.miterLimit(ProtoAdapter.FLOAT.decode(cVar));
                                    break;
                                case 7:
                                    builder.lineDashI(ProtoAdapter.FLOAT.decode(cVar));
                                    break;
                                case 8:
                                    builder.lineDashII(ProtoAdapter.FLOAT.decode(cVar));
                                    break;
                                case 9:
                                    builder.lineDashIII(ProtoAdapter.FLOAT.decode(cVar));
                                    break;
                                default:
                                    FieldEncoding g2 = cVar.g();
                                    builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                                    break;
                            }
                        } else {
                            cVar.d(c2);
                            return builder.build();
                        }
                    }
                } else {
                    return (ShapeStyle) invokeL.objValue;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(d dVar, ShapeStyle shapeStyle) throws IOException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, shapeStyle) == null) {
                    RGBAColor rGBAColor = shapeStyle.fill;
                    if (rGBAColor != null) {
                        RGBAColor.ADAPTER.encodeWithTag(dVar, 1, rGBAColor);
                    }
                    RGBAColor rGBAColor2 = shapeStyle.stroke;
                    if (rGBAColor2 != null) {
                        RGBAColor.ADAPTER.encodeWithTag(dVar, 2, rGBAColor2);
                    }
                    Float f2 = shapeStyle.strokeWidth;
                    if (f2 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, f2);
                    }
                    LineCap lineCap = shapeStyle.lineCap;
                    if (lineCap != null) {
                        LineCap.ADAPTER.encodeWithTag(dVar, 4, lineCap);
                    }
                    LineJoin lineJoin = shapeStyle.lineJoin;
                    if (lineJoin != null) {
                        LineJoin.ADAPTER.encodeWithTag(dVar, 5, lineJoin);
                    }
                    Float f3 = shapeStyle.miterLimit;
                    if (f3 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 6, f3);
                    }
                    Float f4 = shapeStyle.lineDashI;
                    if (f4 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 7, f4);
                    }
                    Float f5 = shapeStyle.lineDashII;
                    if (f5 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 8, f5);
                    }
                    Float f6 = shapeStyle.lineDashIII;
                    if (f6 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 9, f6);
                    }
                    dVar.k(shapeStyle.unknownFields());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(ShapeStyle shapeStyle) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, shapeStyle)) == null) {
                    RGBAColor rGBAColor = shapeStyle.fill;
                    int encodedSizeWithTag = rGBAColor != null ? RGBAColor.ADAPTER.encodedSizeWithTag(1, rGBAColor) : 0;
                    RGBAColor rGBAColor2 = shapeStyle.stroke;
                    int encodedSizeWithTag2 = encodedSizeWithTag + (rGBAColor2 != null ? RGBAColor.ADAPTER.encodedSizeWithTag(2, rGBAColor2) : 0);
                    Float f2 = shapeStyle.strokeWidth;
                    int encodedSizeWithTag3 = encodedSizeWithTag2 + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f2) : 0);
                    LineCap lineCap = shapeStyle.lineCap;
                    int encodedSizeWithTag4 = encodedSizeWithTag3 + (lineCap != null ? LineCap.ADAPTER.encodedSizeWithTag(4, lineCap) : 0);
                    LineJoin lineJoin = shapeStyle.lineJoin;
                    int encodedSizeWithTag5 = encodedSizeWithTag4 + (lineJoin != null ? LineJoin.ADAPTER.encodedSizeWithTag(5, lineJoin) : 0);
                    Float f3 = shapeStyle.miterLimit;
                    int encodedSizeWithTag6 = encodedSizeWithTag5 + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(6, f3) : 0);
                    Float f4 = shapeStyle.lineDashI;
                    int encodedSizeWithTag7 = encodedSizeWithTag6 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(7, f4) : 0);
                    Float f5 = shapeStyle.lineDashII;
                    int encodedSizeWithTag8 = encodedSizeWithTag7 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(8, f5) : 0);
                    Float f6 = shapeStyle.lineDashIII;
                    return encodedSizeWithTag8 + (f6 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(9, f6) : 0) + shapeStyle.unknownFields().size();
                }
                return invokeL.intValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Type inference failed for: r5v1, types: [com.squareup.wire2.Message$a, com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$Builder] */
            @Override // com.squareup.wire2.ProtoAdapter
            public ShapeStyle redact(ShapeStyle shapeStyle) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, shapeStyle)) == null) {
                    ?? newBuilder2 = shapeStyle.newBuilder2();
                    RGBAColor rGBAColor = newBuilder2.fill;
                    if (rGBAColor != null) {
                        newBuilder2.fill = RGBAColor.ADAPTER.redact(rGBAColor);
                    }
                    RGBAColor rGBAColor2 = newBuilder2.stroke;
                    if (rGBAColor2 != null) {
                        newBuilder2.stroke = RGBAColor.ADAPTER.redact(rGBAColor2);
                    }
                    newBuilder2.clearUnknownFields();
                    return newBuilder2.build();
                }
                return (ShapeStyle) invokeL.objValue;
            }
        }

        /* loaded from: classes2.dex */
        public static final class RGBAColor extends Message<RGBAColor, Builder> {
            public static /* synthetic */ Interceptable $ic;
            public static final ProtoAdapter<RGBAColor> ADAPTER;
            public static final Float DEFAULT_A;
            public static final Float DEFAULT_B;
            public static final Float DEFAULT_G;
            public static final Float DEFAULT_R;
            public static final long serialVersionUID = 0;
            public transient /* synthetic */ FieldHolder $fh;
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)

            /* renamed from: a  reason: collision with root package name */
            public final Float f68704a;
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)

            /* renamed from: b  reason: collision with root package name */
            public final Float f68705b;
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)

            /* renamed from: g  reason: collision with root package name */
            public final Float f68706g;
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
            public final Float r;

            /* loaded from: classes2.dex */
            public static final class Builder extends Message.a<RGBAColor, Builder> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public Float f68707a;

                /* renamed from: b  reason: collision with root package name */
                public Float f68708b;

                /* renamed from: g  reason: collision with root package name */
                public Float f68709g;
                public Float r;

                public Builder() {
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

                public Builder a(Float f2) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f2)) == null) {
                        this.f68707a = f2;
                        return this;
                    }
                    return (Builder) invokeL.objValue;
                }

                public Builder b(Float f2) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2)) == null) {
                        this.f68708b = f2;
                        return this;
                    }
                    return (Builder) invokeL.objValue;
                }

                public Builder g(Float f2) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f2)) == null) {
                        this.f68709g = f2;
                        return this;
                    }
                    return (Builder) invokeL.objValue;
                }

                public Builder r(Float f2) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f2)) == null) {
                        this.r = f2;
                        return this;
                    }
                    return (Builder) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire2.Message.a
                public RGBAColor build() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new RGBAColor(this.r, this.f68709g, this.f68708b, this.f68707a, super.buildUnknownFields()) : (RGBAColor) invokeV.objValue;
                }
            }

            /* loaded from: classes2.dex */
            public static final class ProtoAdapter_RGBAColor extends ProtoAdapter<RGBAColor> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public ProtoAdapter_RGBAColor() {
                    super(FieldEncoding.LENGTH_DELIMITED, RGBAColor.class);
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            Object[] objArr = newInitContext.callArgs;
                            super((FieldEncoding) objArr[0], (Class) objArr[1]);
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire2.ProtoAdapter
                public RGBAColor decode(c cVar) throws IOException {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, cVar)) != null) {
                        return (RGBAColor) invokeL.objValue;
                    }
                    Builder builder = new Builder();
                    long c2 = cVar.c();
                    while (true) {
                        int f2 = cVar.f();
                        if (f2 == -1) {
                            cVar.d(c2);
                            return builder.build();
                        } else if (f2 == 1) {
                            builder.r(ProtoAdapter.FLOAT.decode(cVar));
                        } else if (f2 == 2) {
                            builder.g(ProtoAdapter.FLOAT.decode(cVar));
                        } else if (f2 == 3) {
                            builder.b(ProtoAdapter.FLOAT.decode(cVar));
                        } else if (f2 != 4) {
                            FieldEncoding g2 = cVar.g();
                            builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                        } else {
                            builder.a(ProtoAdapter.FLOAT.decode(cVar));
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.squareup.wire2.ProtoAdapter
                public void encode(d dVar, RGBAColor rGBAColor) throws IOException {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, rGBAColor) == null) {
                        Float f2 = rGBAColor.r;
                        if (f2 != null) {
                            ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, f2);
                        }
                        Float f3 = rGBAColor.f68706g;
                        if (f3 != null) {
                            ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, f3);
                        }
                        Float f4 = rGBAColor.f68705b;
                        if (f4 != null) {
                            ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, f4);
                        }
                        Float f5 = rGBAColor.f68704a;
                        if (f5 != null) {
                            ProtoAdapter.FLOAT.encodeWithTag(dVar, 4, f5);
                        }
                        dVar.k(rGBAColor.unknownFields());
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.squareup.wire2.ProtoAdapter
                public int encodedSize(RGBAColor rGBAColor) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rGBAColor)) == null) {
                        Float f2 = rGBAColor.r;
                        int encodedSizeWithTag = f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f2) : 0;
                        Float f3 = rGBAColor.f68706g;
                        int encodedSizeWithTag2 = encodedSizeWithTag + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f3) : 0);
                        Float f4 = rGBAColor.f68705b;
                        int encodedSizeWithTag3 = encodedSizeWithTag2 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f4) : 0);
                        Float f5 = rGBAColor.f68704a;
                        return encodedSizeWithTag3 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f5) : 0) + rGBAColor.unknownFields().size();
                    }
                    return invokeL.intValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.squareup.wire2.ProtoAdapter
                public RGBAColor redact(RGBAColor rGBAColor) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rGBAColor)) == null) {
                        Message.a<RGBAColor, Builder> newBuilder2 = rGBAColor.newBuilder2();
                        newBuilder2.clearUnknownFields();
                        return newBuilder2.build();
                    }
                    return (RGBAColor) invokeL.objValue;
                }
            }

            static {
                InterceptResult invokeClinit;
                ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(394985688, "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeStyle$RGBAColor;")) != null) {
                    Interceptable interceptable = invokeClinit.interceptor;
                    if (interceptable != null) {
                        $ic = interceptable;
                    }
                    if ((invokeClinit.flags & 1) != 0) {
                        classClinitInterceptable.invokePostClinit(394985688, "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeStyle$RGBAColor;");
                        return;
                    }
                }
                ADAPTER = new ProtoAdapter_RGBAColor();
                Float valueOf = Float.valueOf(0.0f);
                DEFAULT_R = valueOf;
                DEFAULT_G = valueOf;
                DEFAULT_B = valueOf;
                DEFAULT_A = valueOf;
            }

            /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
            public RGBAColor(Float f2, Float f3, Float f4, Float f5) {
                this(f2, f3, f4, f5, ByteString.EMPTY);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f2, f3, f4, f5};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        this((Float) objArr2[0], (Float) objArr2[1], (Float) objArr2[2], (Float) objArr2[3], (ByteString) objArr2[4]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
            }

            public boolean equals(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                    if (obj == this) {
                        return true;
                    }
                    if (obj instanceof RGBAColor) {
                        RGBAColor rGBAColor = (RGBAColor) obj;
                        return unknownFields().equals(rGBAColor.unknownFields()) && a.f(this.r, rGBAColor.r) && a.f(this.f68706g, rGBAColor.f68706g) && a.f(this.f68705b, rGBAColor.f68705b) && a.f(this.f68704a, rGBAColor.f68704a);
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            public int hashCode() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    int i2 = this.hashCode;
                    if (i2 == 0) {
                        int hashCode = unknownFields().hashCode() * 37;
                        Float f2 = this.r;
                        int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 37;
                        Float f3 = this.f68706g;
                        int hashCode3 = (hashCode2 + (f3 != null ? f3.hashCode() : 0)) * 37;
                        Float f4 = this.f68705b;
                        int hashCode4 = (hashCode3 + (f4 != null ? f4.hashCode() : 0)) * 37;
                        Float f5 = this.f68704a;
                        int hashCode5 = hashCode4 + (f5 != null ? f5.hashCode() : 0);
                        this.hashCode = hashCode5;
                        return hashCode5;
                    }
                    return i2;
                }
                return invokeV.intValue;
            }

            @Override // com.squareup.wire2.Message
            public String toString() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    StringBuilder sb = new StringBuilder();
                    if (this.r != null) {
                        sb.append(", r=");
                        sb.append(this.r);
                    }
                    if (this.f68706g != null) {
                        sb.append(", g=");
                        sb.append(this.f68706g);
                    }
                    if (this.f68705b != null) {
                        sb.append(", b=");
                        sb.append(this.f68705b);
                    }
                    if (this.f68704a != null) {
                        sb.append(", a=");
                        sb.append(this.f68704a);
                    }
                    StringBuilder replace = sb.replace(0, 2, "RGBAColor{");
                    replace.append(ExtendedMessageFormat.END_FE);
                    return replace.toString();
                }
                return (String) invokeV.objValue;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RGBAColor(Float f2, Float f3, Float f4, Float f5, ByteString byteString) {
                super(ADAPTER, byteString);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f2, f3, f4, f5, byteString};
                    interceptable.invokeUnInit(65538, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65538, newInitContext);
                        return;
                    }
                }
                this.r = f2;
                this.f68706g = f3;
                this.f68705b = f4;
                this.f68704a = f5;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor$Builder' to match base method */
            @Override // com.squareup.wire2.Message
            /* renamed from: newBuilder */
            public Message.a<RGBAColor, Builder> newBuilder2() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                    Builder builder = new Builder();
                    builder.r = this.r;
                    builder.f68709g = this.f68706g;
                    builder.f68708b = this.f68705b;
                    builder.f68707a = this.f68704a;
                    builder.addUnknownFields(unknownFields());
                    return builder;
                }
                return (Builder) invokeV.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1631298659, "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeStyle;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1631298659, "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeStyle;");
                    return;
                }
            }
            ADAPTER = new ProtoAdapter_ShapeStyle();
            Float valueOf = Float.valueOf(0.0f);
            DEFAULT_STROKEWIDTH = valueOf;
            DEFAULT_LINECAP = LineCap.LineCap_BUTT;
            DEFAULT_LINEJOIN = LineJoin.LineJoin_MITER;
            DEFAULT_MITERLIMIT = valueOf;
            DEFAULT_LINEDASHI = valueOf;
            DEFAULT_LINEDASHII = valueOf;
            DEFAULT_LINEDASHIII = valueOf;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ShapeStyle(RGBAColor rGBAColor, RGBAColor rGBAColor2, Float f2, LineCap lineCap, LineJoin lineJoin, Float f3, Float f4, Float f5, Float f6) {
            this(rGBAColor, rGBAColor2, f2, lineCap, lineJoin, f3, f4, f5, f6, ByteString.EMPTY);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {rGBAColor, rGBAColor2, f2, lineCap, lineJoin, f3, f4, f5, f6};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((RGBAColor) objArr2[0], (RGBAColor) objArr2[1], (Float) objArr2[2], (LineCap) objArr2[3], (LineJoin) objArr2[4], (Float) objArr2[5], (Float) objArr2[6], (Float) objArr2[7], (Float) objArr2[8], (ByteString) objArr2[9]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof ShapeStyle) {
                    ShapeStyle shapeStyle = (ShapeStyle) obj;
                    return unknownFields().equals(shapeStyle.unknownFields()) && a.f(this.fill, shapeStyle.fill) && a.f(this.stroke, shapeStyle.stroke) && a.f(this.strokeWidth, shapeStyle.strokeWidth) && a.f(this.lineCap, shapeStyle.lineCap) && a.f(this.lineJoin, shapeStyle.lineJoin) && a.f(this.miterLimit, shapeStyle.miterLimit) && a.f(this.lineDashI, shapeStyle.lineDashI) && a.f(this.lineDashII, shapeStyle.lineDashII) && a.f(this.lineDashIII, shapeStyle.lineDashIII);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.hashCode;
                if (i2 == 0) {
                    int hashCode = unknownFields().hashCode() * 37;
                    RGBAColor rGBAColor = this.fill;
                    int hashCode2 = (hashCode + (rGBAColor != null ? rGBAColor.hashCode() : 0)) * 37;
                    RGBAColor rGBAColor2 = this.stroke;
                    int hashCode3 = (hashCode2 + (rGBAColor2 != null ? rGBAColor2.hashCode() : 0)) * 37;
                    Float f2 = this.strokeWidth;
                    int hashCode4 = (hashCode3 + (f2 != null ? f2.hashCode() : 0)) * 37;
                    LineCap lineCap = this.lineCap;
                    int hashCode5 = (hashCode4 + (lineCap != null ? lineCap.hashCode() : 0)) * 37;
                    LineJoin lineJoin = this.lineJoin;
                    int hashCode6 = (hashCode5 + (lineJoin != null ? lineJoin.hashCode() : 0)) * 37;
                    Float f3 = this.miterLimit;
                    int hashCode7 = (hashCode6 + (f3 != null ? f3.hashCode() : 0)) * 37;
                    Float f4 = this.lineDashI;
                    int hashCode8 = (hashCode7 + (f4 != null ? f4.hashCode() : 0)) * 37;
                    Float f5 = this.lineDashII;
                    int hashCode9 = (hashCode8 + (f5 != null ? f5.hashCode() : 0)) * 37;
                    Float f6 = this.lineDashIII;
                    int hashCode10 = hashCode9 + (f6 != null ? f6.hashCode() : 0);
                    this.hashCode = hashCode10;
                    return hashCode10;
                }
                return i2;
            }
            return invokeV.intValue;
        }

        @Override // com.squareup.wire2.Message
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                StringBuilder sb = new StringBuilder();
                if (this.fill != null) {
                    sb.append(", fill=");
                    sb.append(this.fill);
                }
                if (this.stroke != null) {
                    sb.append(", stroke=");
                    sb.append(this.stroke);
                }
                if (this.strokeWidth != null) {
                    sb.append(", strokeWidth=");
                    sb.append(this.strokeWidth);
                }
                if (this.lineCap != null) {
                    sb.append(", lineCap=");
                    sb.append(this.lineCap);
                }
                if (this.lineJoin != null) {
                    sb.append(", lineJoin=");
                    sb.append(this.lineJoin);
                }
                if (this.miterLimit != null) {
                    sb.append(", miterLimit=");
                    sb.append(this.miterLimit);
                }
                if (this.lineDashI != null) {
                    sb.append(", lineDashI=");
                    sb.append(this.lineDashI);
                }
                if (this.lineDashII != null) {
                    sb.append(", lineDashII=");
                    sb.append(this.lineDashII);
                }
                if (this.lineDashIII != null) {
                    sb.append(", lineDashIII=");
                    sb.append(this.lineDashIII);
                }
                StringBuilder replace = sb.replace(0, 2, "ShapeStyle{");
                replace.append(ExtendedMessageFormat.END_FE);
                return replace.toString();
            }
            return (String) invokeV.objValue;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShapeStyle(RGBAColor rGBAColor, RGBAColor rGBAColor2, Float f2, LineCap lineCap, LineJoin lineJoin, Float f3, Float f4, Float f5, Float f6, ByteString byteString) {
            super(ADAPTER, byteString);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {rGBAColor, rGBAColor2, f2, lineCap, lineJoin, f3, f4, f5, f6, byteString};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.fill = rGBAColor;
            this.stroke = rGBAColor2;
            this.strokeWidth = f2;
            this.lineCap = lineCap;
            this.lineJoin = lineJoin;
            this.miterLimit = f3;
            this.lineDashI = f4;
            this.lineDashII = f5;
            this.lineDashIII = f6;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$Builder' to match base method */
        @Override // com.squareup.wire2.Message
        /* renamed from: newBuilder */
        public Message.a<ShapeStyle, Builder> newBuilder2() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Builder builder = new Builder();
                builder.fill = this.fill;
                builder.stroke = this.stroke;
                builder.strokeWidth = this.strokeWidth;
                builder.lineCap = this.lineCap;
                builder.lineJoin = this.lineJoin;
                builder.miterLimit = this.miterLimit;
                builder.lineDashI = this.lineDashI;
                builder.lineDashII = this.lineDashII;
                builder.lineDashIII = this.lineDashIII;
                builder.addUnknownFields(unknownFields());
                return builder;
            }
            return (Builder) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class ShapeType implements g {
        public static final /* synthetic */ ShapeType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ProtoAdapter<ShapeType> ADAPTER;
        public static final ShapeType ELLIPSE;
        public static final ShapeType KEEP;
        public static final ShapeType RECT;
        public static final ShapeType SHAPE;
        public transient /* synthetic */ FieldHolder $fh;
        public final int value;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(607875432, "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(607875432, "Lcom/opensource/svgaplayer/proto/ShapeEntity$ShapeType;");
                    return;
                }
            }
            SHAPE = new ShapeType("SHAPE", 0, 0);
            RECT = new ShapeType("RECT", 1, 1);
            ELLIPSE = new ShapeType("ELLIPSE", 2, 2);
            ShapeType shapeType = new ShapeType("KEEP", 3, 3);
            KEEP = shapeType;
            $VALUES = new ShapeType[]{SHAPE, RECT, ELLIPSE, shapeType};
            ADAPTER = ProtoAdapter.newEnumAdapter(ShapeType.class);
        }

        public ShapeType(String str, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.value = i3;
        }

        public static ShapeType fromValue(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                return null;
                            }
                            return KEEP;
                        }
                        return ELLIPSE;
                    }
                    return RECT;
                }
                return SHAPE;
            }
            return (ShapeType) invokeI.objValue;
        }

        public static ShapeType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (ShapeType) Enum.valueOf(ShapeType.class, str) : (ShapeType) invokeL.objValue;
        }

        public static ShapeType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (ShapeType[]) $VALUES.clone() : (ShapeType[]) invokeV.objValue;
        }

        @Override // b.m.a.g
        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1463061953, "Lcom/opensource/svgaplayer/proto/ShapeEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1463061953, "Lcom/opensource/svgaplayer/proto/ShapeEntity;");
                return;
            }
        }
        ADAPTER = new ProtoAdapter_ShapeEntity();
        DEFAULT_TYPE = ShapeType.SHAPE;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShapeEntity(ShapeType shapeType, ShapeStyle shapeStyle, Transform transform, ShapeArgs shapeArgs, RectArgs rectArgs, EllipseArgs ellipseArgs) {
        this(shapeType, shapeStyle, transform, shapeArgs, rectArgs, ellipseArgs, ByteString.EMPTY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {shapeType, shapeStyle, transform, shapeArgs, rectArgs, ellipseArgs};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ShapeType) objArr2[0], (ShapeStyle) objArr2[1], (Transform) objArr2[2], (ShapeArgs) objArr2[3], (RectArgs) objArr2[4], (EllipseArgs) objArr2[5], (ByteString) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ShapeEntity) {
                ShapeEntity shapeEntity = (ShapeEntity) obj;
                return unknownFields().equals(shapeEntity.unknownFields()) && a.f(this.type, shapeEntity.type) && a.f(this.styles, shapeEntity.styles) && a.f(this.transform, shapeEntity.transform) && a.f(this.shape, shapeEntity.shape) && a.f(this.rect, shapeEntity.rect) && a.f(this.ellipse, shapeEntity.ellipse);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.hashCode;
            if (i2 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                ShapeType shapeType = this.type;
                int hashCode2 = (hashCode + (shapeType != null ? shapeType.hashCode() : 0)) * 37;
                ShapeStyle shapeStyle = this.styles;
                int hashCode3 = (hashCode2 + (shapeStyle != null ? shapeStyle.hashCode() : 0)) * 37;
                Transform transform = this.transform;
                int hashCode4 = (hashCode3 + (transform != null ? transform.hashCode() : 0)) * 37;
                ShapeArgs shapeArgs = this.shape;
                int hashCode5 = (hashCode4 + (shapeArgs != null ? shapeArgs.hashCode() : 0)) * 37;
                RectArgs rectArgs = this.rect;
                int hashCode6 = (hashCode5 + (rectArgs != null ? rectArgs.hashCode() : 0)) * 37;
                EllipseArgs ellipseArgs = this.ellipse;
                int hashCode7 = hashCode6 + (ellipseArgs != null ? ellipseArgs.hashCode() : 0);
                this.hashCode = hashCode7;
                return hashCode7;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.type != null) {
                sb.append(", type=");
                sb.append(this.type);
            }
            if (this.styles != null) {
                sb.append(", styles=");
                sb.append(this.styles);
            }
            if (this.transform != null) {
                sb.append(", transform=");
                sb.append(this.transform);
            }
            if (this.shape != null) {
                sb.append(", shape=");
                sb.append(this.shape);
            }
            if (this.rect != null) {
                sb.append(", rect=");
                sb.append(this.rect);
            }
            if (this.ellipse != null) {
                sb.append(", ellipse=");
                sb.append(this.ellipse);
            }
            StringBuilder replace = sb.replace(0, 2, "ShapeEntity{");
            replace.append(ExtendedMessageFormat.END_FE);
            return replace.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShapeEntity(ShapeType shapeType, ShapeStyle shapeStyle, Transform transform, ShapeArgs shapeArgs, RectArgs rectArgs, EllipseArgs ellipseArgs, ByteString byteString) {
        super(ADAPTER, byteString);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {shapeType, shapeStyle, transform, shapeArgs, rectArgs, ellipseArgs, byteString};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (a.e(shapeArgs, rectArgs, ellipseArgs) <= 1) {
            this.type = shapeType;
            this.styles = shapeStyle;
            this.transform = transform;
            this.shape = shapeArgs;
            this.rect = rectArgs;
            this.ellipse = ellipseArgs;
            return;
        }
        throw new IllegalArgumentException("at most one of shape, rect, ellipse may be non-null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.ShapeEntity$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<ShapeEntity, Builder> newBuilder2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Builder builder = new Builder();
            builder.type = this.type;
            builder.styles = this.styles;
            builder.transform = this.transform;
            builder.shape = this.shape;
            builder.rect = this.rect;
            builder.ellipse = this.ellipse;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
        return (Builder) invokeV.objValue;
    }
}
