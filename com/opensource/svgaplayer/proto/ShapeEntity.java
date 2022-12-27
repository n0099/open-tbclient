package com.opensource.svgaplayer.proto;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.az9;
import com.baidu.tieba.bz9;
import com.baidu.tieba.ez9;
import com.baidu.tieba.fz9;
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
/* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
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

        /* loaded from: classes8.dex */
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
            public final Float a;
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
            public final Float b;
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
            public final Float g;
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
            public final Float r;

            /* loaded from: classes8.dex */
            public static final class Builder extends Message.a<RGBAColor, Builder> {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public Float a;
                public Float b;
                public Float g;
                public Float r;

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

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire2.Message.a
                public RGBAColor build() {
                    InterceptResult invokeV;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        return new RGBAColor(this.r, this.g, this.b, this.a, super.buildUnknownFields());
                    }
                    return (RGBAColor) invokeV.objValue;
                }

                public Builder a(Float f) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, f)) == null) {
                        this.a = f;
                        return this;
                    }
                    return (Builder) invokeL.objValue;
                }

                public Builder b(Float f) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
                        this.b = f;
                        return this;
                    }
                    return (Builder) invokeL.objValue;
                }

                public Builder g(Float f) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f)) == null) {
                        this.g = f;
                        return this;
                    }
                    return (Builder) invokeL.objValue;
                }

                public Builder r(Float f) {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f)) == null) {
                        this.r = f;
                        return this;
                    }
                    return (Builder) invokeL.objValue;
                }
            }

            /* loaded from: classes8.dex */
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
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
                public RGBAColor decode(az9 az9Var) throws IOException {
                    InterceptResult invokeL;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, az9Var)) == null) {
                        Builder builder = new Builder();
                        long c = az9Var.c();
                        while (true) {
                            int f = az9Var.f();
                            if (f != -1) {
                                if (f != 1) {
                                    if (f != 2) {
                                        if (f != 3) {
                                            if (f != 4) {
                                                FieldEncoding g = az9Var.g();
                                                builder.addUnknownField(f, g, g.rawProtoAdapter().decode(az9Var));
                                            } else {
                                                builder.a(ProtoAdapter.FLOAT.decode(az9Var));
                                            }
                                        } else {
                                            builder.b(ProtoAdapter.FLOAT.decode(az9Var));
                                        }
                                    } else {
                                        builder.g(ProtoAdapter.FLOAT.decode(az9Var));
                                    }
                                } else {
                                    builder.r(ProtoAdapter.FLOAT.decode(az9Var));
                                }
                            } else {
                                az9Var.d(c);
                                return builder.build();
                            }
                        }
                    } else {
                        return (RGBAColor) invokeL.objValue;
                    }
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

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.squareup.wire2.ProtoAdapter
                public void encode(bz9 bz9Var, RGBAColor rGBAColor) throws IOException {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bz9Var, rGBAColor) == null) {
                        Float f = rGBAColor.r;
                        if (f != null) {
                            ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 1, f);
                        }
                        Float f2 = rGBAColor.g;
                        if (f2 != null) {
                            ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 2, f2);
                        }
                        Float f3 = rGBAColor.b;
                        if (f3 != null) {
                            ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 3, f3);
                        }
                        Float f4 = rGBAColor.a;
                        if (f4 != null) {
                            ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 4, f4);
                        }
                        bz9Var.k(rGBAColor.unknownFields());
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.squareup.wire2.ProtoAdapter
                public int encodedSize(RGBAColor rGBAColor) {
                    InterceptResult invokeL;
                    int i;
                    int i2;
                    int i3;
                    Interceptable interceptable = $ic;
                    if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rGBAColor)) == null) {
                        Float f = rGBAColor.r;
                        int i4 = 0;
                        if (f != null) {
                            i = ProtoAdapter.FLOAT.encodedSizeWithTag(1, f);
                        } else {
                            i = 0;
                        }
                        Float f2 = rGBAColor.g;
                        if (f2 != null) {
                            i2 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, f2);
                        } else {
                            i2 = 0;
                        }
                        int i5 = i + i2;
                        Float f3 = rGBAColor.b;
                        if (f3 != null) {
                            i3 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, f3);
                        } else {
                            i3 = 0;
                        }
                        int i6 = i5 + i3;
                        Float f4 = rGBAColor.a;
                        if (f4 != null) {
                            i4 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, f4);
                        }
                        return i6 + i4 + rGBAColor.unknownFields().size();
                    }
                    return invokeL.intValue;
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
            public RGBAColor(Float f, Float f2, Float f3, Float f4) {
                this(f, f2, f3, f4, ByteString.EMPTY);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f, f2, f3, f4};
                    interceptable.invokeUnInit(65537, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        this((Float) objArr2[0], (Float) objArr2[1], (Float) objArr2[2], (Float) objArr2[3], (ByteString) objArr2[4]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65537, newInitContext);
                        return;
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RGBAColor(Float f, Float f2, Float f3, Float f4, ByteString byteString) {
                super(ADAPTER, byteString);
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {f, f2, f3, f4, byteString};
                    interceptable.invokeUnInit(65538, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        Object[] objArr2 = newInitContext.callArgs;
                        super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65538, newInitContext);
                        return;
                    }
                }
                this.r = f;
                this.g = f2;
                this.b = f3;
                this.a = f4;
            }

            public boolean equals(Object obj) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                    if (obj == this) {
                        return true;
                    }
                    if (!(obj instanceof RGBAColor)) {
                        return false;
                    }
                    RGBAColor rGBAColor = (RGBAColor) obj;
                    if (unknownFields().equals(rGBAColor.unknownFields()) && fz9.f(this.r, rGBAColor.r) && fz9.f(this.g, rGBAColor.g) && fz9.f(this.b, rGBAColor.b) && fz9.f(this.a, rGBAColor.a)) {
                        return true;
                    }
                    return false;
                }
                return invokeL.booleanValue;
            }

            public int hashCode() {
                InterceptResult invokeV;
                int i;
                int i2;
                int i3;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    int i4 = this.hashCode;
                    if (i4 == 0) {
                        int hashCode = unknownFields().hashCode() * 37;
                        Float f = this.r;
                        int i5 = 0;
                        if (f != null) {
                            i = f.hashCode();
                        } else {
                            i = 0;
                        }
                        int i6 = (hashCode + i) * 37;
                        Float f2 = this.g;
                        if (f2 != null) {
                            i2 = f2.hashCode();
                        } else {
                            i2 = 0;
                        }
                        int i7 = (i6 + i2) * 37;
                        Float f3 = this.b;
                        if (f3 != null) {
                            i3 = f3.hashCode();
                        } else {
                            i3 = 0;
                        }
                        int i8 = (i7 + i3) * 37;
                        Float f4 = this.a;
                        if (f4 != null) {
                            i5 = f4.hashCode();
                        }
                        int i9 = i8 + i5;
                        this.hashCode = i9;
                        return i9;
                    }
                    return i4;
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
                    if (this.g != null) {
                        sb.append(", g=");
                        sb.append(this.g);
                    }
                    if (this.b != null) {
                        sb.append(", b=");
                        sb.append(this.b);
                    }
                    if (this.a != null) {
                        sb.append(", a=");
                        sb.append(this.a);
                    }
                    StringBuilder replace = sb.replace(0, 2, "RGBAColor{");
                    replace.append('}');
                    return replace.toString();
                }
                return (String) invokeV.objValue;
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
                    builder.g = this.g;
                    builder.b = this.b;
                    builder.a = this.a;
                    builder.addUnknownFields(unknownFields());
                    return builder;
                }
                return (Builder) invokeV.objValue;
            }
        }

        /* loaded from: classes8.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.Message.a
            public ShapeStyle build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return new ShapeStyle(this.fill, this.stroke, this.strokeWidth, this.lineCap, this.lineJoin, this.miterLimit, this.lineDashI, this.lineDashII, this.lineDashIII, super.buildUnknownFields());
                }
                return (ShapeStyle) invokeV.objValue;
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

            public Builder lineDashI(Float f) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f)) == null) {
                    this.lineDashI = f;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder lineDashII(Float f) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f)) == null) {
                    this.lineDashII = f;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder lineDashIII(Float f) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, f)) == null) {
                    this.lineDashIII = f;
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

            public Builder miterLimit(Float f) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, f)) == null) {
                    this.miterLimit = f;
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

            public Builder strokeWidth(Float f) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, f)) == null) {
                    this.strokeWidth = f;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes8.dex */
        public static final class LineCap implements ez9 {
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

            public LineCap(String str, int i, int i2) {
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

            public static LineCap fromValue(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
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
                if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                    return (LineCap) Enum.valueOf(LineCap.class, str);
                }
                return (LineCap) invokeL.objValue;
            }

            public static LineCap[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                    return (LineCap[]) $VALUES.clone();
                }
                return (LineCap[]) invokeV.objValue;
            }

            @Override // com.baidu.tieba.ez9
            public int getValue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.value;
                }
                return invokeV.intValue;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* loaded from: classes8.dex */
        public static final class LineJoin implements ez9 {
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

            public LineJoin(String str, int i, int i2) {
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

            public static LineJoin fromValue(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                    if (i != 0) {
                        if (i != 1) {
                            if (i != 2) {
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
                if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                    return (LineJoin) Enum.valueOf(LineJoin.class, str);
                }
                return (LineJoin) invokeL.objValue;
            }

            public static LineJoin[] values() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                    return (LineJoin[]) $VALUES.clone();
                }
                return (LineJoin[]) invokeV.objValue;
            }

            @Override // com.baidu.tieba.ez9
            public int getValue() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return this.value;
                }
                return invokeV.intValue;
            }
        }

        /* loaded from: classes8.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
            public ShapeStyle decode(az9 az9Var) throws IOException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, az9Var)) == null) {
                    Builder builder = new Builder();
                    long c = az9Var.c();
                    while (true) {
                        int f = az9Var.f();
                        if (f != -1) {
                            switch (f) {
                                case 1:
                                    builder.fill(RGBAColor.ADAPTER.decode(az9Var));
                                    break;
                                case 2:
                                    builder.stroke(RGBAColor.ADAPTER.decode(az9Var));
                                    break;
                                case 3:
                                    builder.strokeWidth(ProtoAdapter.FLOAT.decode(az9Var));
                                    break;
                                case 4:
                                    try {
                                        builder.lineCap(LineCap.ADAPTER.decode(az9Var));
                                        break;
                                    } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                                        builder.addUnknownField(f, FieldEncoding.VARINT, Long.valueOf(e.value));
                                        break;
                                    }
                                case 5:
                                    try {
                                        builder.lineJoin(LineJoin.ADAPTER.decode(az9Var));
                                        break;
                                    } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                        builder.addUnknownField(f, FieldEncoding.VARINT, Long.valueOf(e2.value));
                                        break;
                                    }
                                case 6:
                                    builder.miterLimit(ProtoAdapter.FLOAT.decode(az9Var));
                                    break;
                                case 7:
                                    builder.lineDashI(ProtoAdapter.FLOAT.decode(az9Var));
                                    break;
                                case 8:
                                    builder.lineDashII(ProtoAdapter.FLOAT.decode(az9Var));
                                    break;
                                case 9:
                                    builder.lineDashIII(ProtoAdapter.FLOAT.decode(az9Var));
                                    break;
                                default:
                                    FieldEncoding g = az9Var.g();
                                    builder.addUnknownField(f, g, g.rawProtoAdapter().decode(az9Var));
                                    break;
                            }
                        } else {
                            az9Var.d(c);
                            return builder.build();
                        }
                    }
                } else {
                    return (ShapeStyle) invokeL.objValue;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(bz9 bz9Var, ShapeStyle shapeStyle) throws IOException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bz9Var, shapeStyle) == null) {
                    RGBAColor rGBAColor = shapeStyle.fill;
                    if (rGBAColor != null) {
                        RGBAColor.ADAPTER.encodeWithTag(bz9Var, 1, rGBAColor);
                    }
                    RGBAColor rGBAColor2 = shapeStyle.stroke;
                    if (rGBAColor2 != null) {
                        RGBAColor.ADAPTER.encodeWithTag(bz9Var, 2, rGBAColor2);
                    }
                    Float f = shapeStyle.strokeWidth;
                    if (f != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 3, f);
                    }
                    LineCap lineCap = shapeStyle.lineCap;
                    if (lineCap != null) {
                        LineCap.ADAPTER.encodeWithTag(bz9Var, 4, lineCap);
                    }
                    LineJoin lineJoin = shapeStyle.lineJoin;
                    if (lineJoin != null) {
                        LineJoin.ADAPTER.encodeWithTag(bz9Var, 5, lineJoin);
                    }
                    Float f2 = shapeStyle.miterLimit;
                    if (f2 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 6, f2);
                    }
                    Float f3 = shapeStyle.lineDashI;
                    if (f3 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 7, f3);
                    }
                    Float f4 = shapeStyle.lineDashII;
                    if (f4 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 8, f4);
                    }
                    Float f5 = shapeStyle.lineDashIII;
                    if (f5 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 9, f5);
                    }
                    bz9Var.k(shapeStyle.unknownFields());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(ShapeStyle shapeStyle) {
                InterceptResult invokeL;
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                int i6;
                int i7;
                int i8;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, shapeStyle)) == null) {
                    RGBAColor rGBAColor = shapeStyle.fill;
                    int i9 = 0;
                    if (rGBAColor != null) {
                        i = RGBAColor.ADAPTER.encodedSizeWithTag(1, rGBAColor);
                    } else {
                        i = 0;
                    }
                    RGBAColor rGBAColor2 = shapeStyle.stroke;
                    if (rGBAColor2 != null) {
                        i2 = RGBAColor.ADAPTER.encodedSizeWithTag(2, rGBAColor2);
                    } else {
                        i2 = 0;
                    }
                    int i10 = i + i2;
                    Float f = shapeStyle.strokeWidth;
                    if (f != null) {
                        i3 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, f);
                    } else {
                        i3 = 0;
                    }
                    int i11 = i10 + i3;
                    LineCap lineCap = shapeStyle.lineCap;
                    if (lineCap != null) {
                        i4 = LineCap.ADAPTER.encodedSizeWithTag(4, lineCap);
                    } else {
                        i4 = 0;
                    }
                    int i12 = i11 + i4;
                    LineJoin lineJoin = shapeStyle.lineJoin;
                    if (lineJoin != null) {
                        i5 = LineJoin.ADAPTER.encodedSizeWithTag(5, lineJoin);
                    } else {
                        i5 = 0;
                    }
                    int i13 = i12 + i5;
                    Float f2 = shapeStyle.miterLimit;
                    if (f2 != null) {
                        i6 = ProtoAdapter.FLOAT.encodedSizeWithTag(6, f2);
                    } else {
                        i6 = 0;
                    }
                    int i14 = i13 + i6;
                    Float f3 = shapeStyle.lineDashI;
                    if (f3 != null) {
                        i7 = ProtoAdapter.FLOAT.encodedSizeWithTag(7, f3);
                    } else {
                        i7 = 0;
                    }
                    int i15 = i14 + i7;
                    Float f4 = shapeStyle.lineDashII;
                    if (f4 != null) {
                        i8 = ProtoAdapter.FLOAT.encodedSizeWithTag(8, f4);
                    } else {
                        i8 = 0;
                    }
                    int i16 = i15 + i8;
                    Float f5 = shapeStyle.lineDashIII;
                    if (f5 != null) {
                        i9 = ProtoAdapter.FLOAT.encodedSizeWithTag(9, f5);
                    }
                    return i16 + i9 + shapeStyle.unknownFields().size();
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

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ShapeStyle(RGBAColor rGBAColor, RGBAColor rGBAColor2, Float f, LineCap lineCap, LineJoin lineJoin, Float f2, Float f3, Float f4, Float f5) {
            this(rGBAColor, rGBAColor2, f, lineCap, lineJoin, f2, f3, f4, f5, ByteString.EMPTY);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {rGBAColor, rGBAColor2, f, lineCap, lineJoin, f2, f3, f4, f5};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((RGBAColor) objArr2[0], (RGBAColor) objArr2[1], (Float) objArr2[2], (LineCap) objArr2[3], (LineJoin) objArr2[4], (Float) objArr2[5], (Float) objArr2[6], (Float) objArr2[7], (Float) objArr2[8], (ByteString) objArr2[9]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShapeStyle(RGBAColor rGBAColor, RGBAColor rGBAColor2, Float f, LineCap lineCap, LineJoin lineJoin, Float f2, Float f3, Float f4, Float f5, ByteString byteString) {
            super(ADAPTER, byteString);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {rGBAColor, rGBAColor2, f, lineCap, lineJoin, f2, f3, f4, f5, byteString};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.fill = rGBAColor;
            this.stroke = rGBAColor2;
            this.strokeWidth = f;
            this.lineCap = lineCap;
            this.lineJoin = lineJoin;
            this.miterLimit = f2;
            this.lineDashI = f3;
            this.lineDashII = f4;
            this.lineDashIII = f5;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof ShapeStyle)) {
                    return false;
                }
                ShapeStyle shapeStyle = (ShapeStyle) obj;
                if (unknownFields().equals(shapeStyle.unknownFields()) && fz9.f(this.fill, shapeStyle.fill) && fz9.f(this.stroke, shapeStyle.stroke) && fz9.f(this.strokeWidth, shapeStyle.strokeWidth) && fz9.f(this.lineCap, shapeStyle.lineCap) && fz9.f(this.lineJoin, shapeStyle.lineJoin) && fz9.f(this.miterLimit, shapeStyle.miterLimit) && fz9.f(this.lineDashI, shapeStyle.lineDashI) && fz9.f(this.lineDashII, shapeStyle.lineDashII) && fz9.f(this.lineDashIII, shapeStyle.lineDashIII)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i9 = this.hashCode;
                if (i9 == 0) {
                    int hashCode = unknownFields().hashCode() * 37;
                    RGBAColor rGBAColor = this.fill;
                    int i10 = 0;
                    if (rGBAColor != null) {
                        i = rGBAColor.hashCode();
                    } else {
                        i = 0;
                    }
                    int i11 = (hashCode + i) * 37;
                    RGBAColor rGBAColor2 = this.stroke;
                    if (rGBAColor2 != null) {
                        i2 = rGBAColor2.hashCode();
                    } else {
                        i2 = 0;
                    }
                    int i12 = (i11 + i2) * 37;
                    Float f = this.strokeWidth;
                    if (f != null) {
                        i3 = f.hashCode();
                    } else {
                        i3 = 0;
                    }
                    int i13 = (i12 + i3) * 37;
                    LineCap lineCap = this.lineCap;
                    if (lineCap != null) {
                        i4 = lineCap.hashCode();
                    } else {
                        i4 = 0;
                    }
                    int i14 = (i13 + i4) * 37;
                    LineJoin lineJoin = this.lineJoin;
                    if (lineJoin != null) {
                        i5 = lineJoin.hashCode();
                    } else {
                        i5 = 0;
                    }
                    int i15 = (i14 + i5) * 37;
                    Float f2 = this.miterLimit;
                    if (f2 != null) {
                        i6 = f2.hashCode();
                    } else {
                        i6 = 0;
                    }
                    int i16 = (i15 + i6) * 37;
                    Float f3 = this.lineDashI;
                    if (f3 != null) {
                        i7 = f3.hashCode();
                    } else {
                        i7 = 0;
                    }
                    int i17 = (i16 + i7) * 37;
                    Float f4 = this.lineDashII;
                    if (f4 != null) {
                        i8 = f4.hashCode();
                    } else {
                        i8 = 0;
                    }
                    int i18 = (i17 + i8) * 37;
                    Float f5 = this.lineDashIII;
                    if (f5 != null) {
                        i10 = f5.hashCode();
                    }
                    int i19 = i18 + i10;
                    this.hashCode = i19;
                    return i19;
                }
                return i9;
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
                replace.append('}');
                return replace.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
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

        /* loaded from: classes8.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.Message.a
            public EllipseArgs build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return new EllipseArgs(this.x, this.y, this.radiusX, this.radiusY, super.buildUnknownFields());
                }
                return (EllipseArgs) invokeV.objValue;
            }

            public Builder radiusX(Float f) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f)) == null) {
                    this.radiusX = f;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder radiusY(Float f) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, f)) == null) {
                    this.radiusY = f;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder x(Float f) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f)) == null) {
                    this.x = f;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder y(Float f) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f)) == null) {
                    this.y = f;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }
        }

        /* loaded from: classes8.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
            public EllipseArgs decode(az9 az9Var) throws IOException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, az9Var)) == null) {
                    Builder builder = new Builder();
                    long c = az9Var.c();
                    while (true) {
                        int f = az9Var.f();
                        if (f != -1) {
                            if (f != 1) {
                                if (f != 2) {
                                    if (f != 3) {
                                        if (f != 4) {
                                            FieldEncoding g = az9Var.g();
                                            builder.addUnknownField(f, g, g.rawProtoAdapter().decode(az9Var));
                                        } else {
                                            builder.radiusY(ProtoAdapter.FLOAT.decode(az9Var));
                                        }
                                    } else {
                                        builder.radiusX(ProtoAdapter.FLOAT.decode(az9Var));
                                    }
                                } else {
                                    builder.y(ProtoAdapter.FLOAT.decode(az9Var));
                                }
                            } else {
                                builder.x(ProtoAdapter.FLOAT.decode(az9Var));
                            }
                        } else {
                            az9Var.d(c);
                            return builder.build();
                        }
                    }
                } else {
                    return (EllipseArgs) invokeL.objValue;
                }
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(bz9 bz9Var, EllipseArgs ellipseArgs) throws IOException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bz9Var, ellipseArgs) == null) {
                    Float f = ellipseArgs.x;
                    if (f != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 1, f);
                    }
                    Float f2 = ellipseArgs.y;
                    if (f2 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 2, f2);
                    }
                    Float f3 = ellipseArgs.radiusX;
                    if (f3 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 3, f3);
                    }
                    Float f4 = ellipseArgs.radiusY;
                    if (f4 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 4, f4);
                    }
                    bz9Var.k(ellipseArgs.unknownFields());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(EllipseArgs ellipseArgs) {
                InterceptResult invokeL;
                int i;
                int i2;
                int i3;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, ellipseArgs)) == null) {
                    Float f = ellipseArgs.x;
                    int i4 = 0;
                    if (f != null) {
                        i = ProtoAdapter.FLOAT.encodedSizeWithTag(1, f);
                    } else {
                        i = 0;
                    }
                    Float f2 = ellipseArgs.y;
                    if (f2 != null) {
                        i2 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, f2);
                    } else {
                        i2 = 0;
                    }
                    int i5 = i + i2;
                    Float f3 = ellipseArgs.radiusX;
                    if (f3 != null) {
                        i3 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, f3);
                    } else {
                        i3 = 0;
                    }
                    int i6 = i5 + i3;
                    Float f4 = ellipseArgs.radiusY;
                    if (f4 != null) {
                        i4 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, f4);
                    }
                    return i6 + i4 + ellipseArgs.unknownFields().size();
                }
                return invokeL.intValue;
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
        public EllipseArgs(Float f, Float f2, Float f3, Float f4) {
            this(f, f2, f3, f4, ByteString.EMPTY);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f, f2, f3, f4};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Float) objArr2[0], (Float) objArr2[1], (Float) objArr2[2], (Float) objArr2[3], (ByteString) objArr2[4]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EllipseArgs(Float f, Float f2, Float f3, Float f4, ByteString byteString) {
            super(ADAPTER, byteString);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f, f2, f3, f4, byteString};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.x = f;
            this.y = f2;
            this.radiusX = f3;
            this.radiusY = f4;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof EllipseArgs)) {
                    return false;
                }
                EllipseArgs ellipseArgs = (EllipseArgs) obj;
                if (unknownFields().equals(ellipseArgs.unknownFields()) && fz9.f(this.x, ellipseArgs.x) && fz9.f(this.y, ellipseArgs.y) && fz9.f(this.radiusX, ellipseArgs.radiusX) && fz9.f(this.radiusY, ellipseArgs.radiusY)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            int i;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i4 = this.hashCode;
                if (i4 == 0) {
                    int hashCode = unknownFields().hashCode() * 37;
                    Float f = this.x;
                    int i5 = 0;
                    if (f != null) {
                        i = f.hashCode();
                    } else {
                        i = 0;
                    }
                    int i6 = (hashCode + i) * 37;
                    Float f2 = this.y;
                    if (f2 != null) {
                        i2 = f2.hashCode();
                    } else {
                        i2 = 0;
                    }
                    int i7 = (i6 + i2) * 37;
                    Float f3 = this.radiusX;
                    if (f3 != null) {
                        i3 = f3.hashCode();
                    } else {
                        i3 = 0;
                    }
                    int i8 = (i7 + i3) * 37;
                    Float f4 = this.radiusY;
                    if (f4 != null) {
                        i5 = f4.hashCode();
                    }
                    int i9 = i8 + i5;
                    this.hashCode = i9;
                    return i9;
                }
                return i4;
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
                replace.append('}');
                return replace.toString();
            }
            return (String) invokeV.objValue;
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

    /* loaded from: classes8.dex */
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

        /* loaded from: classes8.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.Message.a
            public RectArgs build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return new RectArgs(this.x, this.y, this.width, this.height, this.cornerRadius, super.buildUnknownFields());
                }
                return (RectArgs) invokeV.objValue;
            }

            public Builder cornerRadius(Float f) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f)) == null) {
                    this.cornerRadius = f;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder height(Float f) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, f)) == null) {
                    this.height = f;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder width(Float f) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f)) == null) {
                    this.width = f;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder x(Float f) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f)) == null) {
                    this.x = f;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }

            public Builder y(Float f) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, f)) == null) {
                    this.y = f;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }
        }

        /* loaded from: classes8.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
            public RectArgs decode(az9 az9Var) throws IOException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, az9Var)) == null) {
                    Builder builder = new Builder();
                    long c = az9Var.c();
                    while (true) {
                        int f = az9Var.f();
                        if (f != -1) {
                            if (f != 1) {
                                if (f != 2) {
                                    if (f != 3) {
                                        if (f != 4) {
                                            if (f != 5) {
                                                FieldEncoding g = az9Var.g();
                                                builder.addUnknownField(f, g, g.rawProtoAdapter().decode(az9Var));
                                            } else {
                                                builder.cornerRadius(ProtoAdapter.FLOAT.decode(az9Var));
                                            }
                                        } else {
                                            builder.height(ProtoAdapter.FLOAT.decode(az9Var));
                                        }
                                    } else {
                                        builder.width(ProtoAdapter.FLOAT.decode(az9Var));
                                    }
                                } else {
                                    builder.y(ProtoAdapter.FLOAT.decode(az9Var));
                                }
                            } else {
                                builder.x(ProtoAdapter.FLOAT.decode(az9Var));
                            }
                        } else {
                            az9Var.d(c);
                            return builder.build();
                        }
                    }
                } else {
                    return (RectArgs) invokeL.objValue;
                }
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(bz9 bz9Var, RectArgs rectArgs) throws IOException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bz9Var, rectArgs) == null) {
                    Float f = rectArgs.x;
                    if (f != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 1, f);
                    }
                    Float f2 = rectArgs.y;
                    if (f2 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 2, f2);
                    }
                    Float f3 = rectArgs.width;
                    if (f3 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 3, f3);
                    }
                    Float f4 = rectArgs.height;
                    if (f4 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 4, f4);
                    }
                    Float f5 = rectArgs.cornerRadius;
                    if (f5 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(bz9Var, 5, f5);
                    }
                    bz9Var.k(rectArgs.unknownFields());
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(RectArgs rectArgs) {
                InterceptResult invokeL;
                int i;
                int i2;
                int i3;
                int i4;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rectArgs)) == null) {
                    Float f = rectArgs.x;
                    int i5 = 0;
                    if (f != null) {
                        i = ProtoAdapter.FLOAT.encodedSizeWithTag(1, f);
                    } else {
                        i = 0;
                    }
                    Float f2 = rectArgs.y;
                    if (f2 != null) {
                        i2 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, f2);
                    } else {
                        i2 = 0;
                    }
                    int i6 = i + i2;
                    Float f3 = rectArgs.width;
                    if (f3 != null) {
                        i3 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, f3);
                    } else {
                        i3 = 0;
                    }
                    int i7 = i6 + i3;
                    Float f4 = rectArgs.height;
                    if (f4 != null) {
                        i4 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, f4);
                    } else {
                        i4 = 0;
                    }
                    int i8 = i7 + i4;
                    Float f5 = rectArgs.cornerRadius;
                    if (f5 != null) {
                        i5 = ProtoAdapter.FLOAT.encodedSizeWithTag(5, f5);
                    }
                    return i8 + i5 + rectArgs.unknownFields().size();
                }
                return invokeL.intValue;
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

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RectArgs(Float f, Float f2, Float f3, Float f4, Float f5) {
            this(f, f2, f3, f4, f5, ByteString.EMPTY);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f, f2, f3, f4, f5};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((Float) objArr2[0], (Float) objArr2[1], (Float) objArr2[2], (Float) objArr2[3], (Float) objArr2[4], (ByteString) objArr2[5]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RectArgs(Float f, Float f2, Float f3, Float f4, Float f5, ByteString byteString) {
            super(ADAPTER, byteString);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f, f2, f3, f4, f5, byteString};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.x = f;
            this.y = f2;
            this.width = f3;
            this.height = f4;
            this.cornerRadius = f5;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof RectArgs)) {
                    return false;
                }
                RectArgs rectArgs = (RectArgs) obj;
                if (unknownFields().equals(rectArgs.unknownFields()) && fz9.f(this.x, rectArgs.x) && fz9.f(this.y, rectArgs.y) && fz9.f(this.width, rectArgs.width) && fz9.f(this.height, rectArgs.height) && fz9.f(this.cornerRadius, rectArgs.cornerRadius)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            int i;
            int i2;
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i5 = this.hashCode;
                if (i5 == 0) {
                    int hashCode = unknownFields().hashCode() * 37;
                    Float f = this.x;
                    int i6 = 0;
                    if (f != null) {
                        i = f.hashCode();
                    } else {
                        i = 0;
                    }
                    int i7 = (hashCode + i) * 37;
                    Float f2 = this.y;
                    if (f2 != null) {
                        i2 = f2.hashCode();
                    } else {
                        i2 = 0;
                    }
                    int i8 = (i7 + i2) * 37;
                    Float f3 = this.width;
                    if (f3 != null) {
                        i3 = f3.hashCode();
                    } else {
                        i3 = 0;
                    }
                    int i9 = (i8 + i3) * 37;
                    Float f4 = this.height;
                    if (f4 != null) {
                        i4 = f4.hashCode();
                    } else {
                        i4 = 0;
                    }
                    int i10 = (i9 + i4) * 37;
                    Float f5 = this.cornerRadius;
                    if (f5 != null) {
                        i6 = f5.hashCode();
                    }
                    int i11 = i10 + i6;
                    this.hashCode = i11;
                    return i11;
                }
                return i5;
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
                replace.append('}');
                return replace.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class ShapeArgs extends Message<ShapeArgs, Builder> {
        public static /* synthetic */ Interceptable $ic = null;
        public static final ProtoAdapter<ShapeArgs> ADAPTER;
        public static final String DEFAULT_D = "";
        public static final long serialVersionUID = 0;
        public transient /* synthetic */ FieldHolder $fh;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
        public final String d;

        /* loaded from: classes8.dex */
        public static final class Builder extends Message.a<ShapeArgs, Builder> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public String d;

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

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.Message.a
            public ShapeArgs build() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    return new ShapeArgs(this.d, super.buildUnknownFields());
                }
                return (ShapeArgs) invokeV.objValue;
            }

            public Builder d(String str) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                    this.d = str;
                    return this;
                }
                return (Builder) invokeL.objValue;
            }
        }

        /* loaded from: classes8.dex */
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
            public ShapeArgs decode(az9 az9Var) throws IOException {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, az9Var)) == null) {
                    Builder builder = new Builder();
                    long c = az9Var.c();
                    while (true) {
                        int f = az9Var.f();
                        if (f != -1) {
                            if (f != 1) {
                                FieldEncoding g = az9Var.g();
                                builder.addUnknownField(f, g, g.rawProtoAdapter().decode(az9Var));
                            } else {
                                builder.d(ProtoAdapter.STRING.decode(az9Var));
                            }
                        } else {
                            az9Var.d(c);
                            return builder.build();
                        }
                    }
                } else {
                    return (ShapeArgs) invokeL.objValue;
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(ShapeArgs shapeArgs) {
                InterceptResult invokeL;
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, shapeArgs)) == null) {
                    String str = shapeArgs.d;
                    if (str != null) {
                        i = ProtoAdapter.STRING.encodedSizeWithTag(1, str);
                    } else {
                        i = 0;
                    }
                    return i + shapeArgs.unknownFields().size();
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

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(bz9 bz9Var, ShapeArgs shapeArgs) throws IOException {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bz9Var, shapeArgs) == null) {
                    String str = shapeArgs.d;
                    if (str != null) {
                        ProtoAdapter.STRING.encodeWithTag(bz9Var, 1, str);
                    }
                    bz9Var.k(shapeArgs.unknownFields());
                }
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

        public int hashCode() {
            InterceptResult invokeV;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                int i2 = this.hashCode;
                if (i2 == 0) {
                    int hashCode = unknownFields().hashCode() * 37;
                    String str = this.d;
                    if (str != null) {
                        i = str.hashCode();
                    } else {
                        i = 0;
                    }
                    int i3 = hashCode + i;
                    this.hashCode = i3;
                    return i3;
                }
                return i2;
            }
            return invokeV.intValue;
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
                builder.d = this.d;
                builder.addUnknownFields(unknownFields());
                return builder;
            }
            return (Builder) invokeV.objValue;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (!(obj instanceof ShapeArgs)) {
                    return false;
                }
                ShapeArgs shapeArgs = (ShapeArgs) obj;
                if (unknownFields().equals(shapeArgs.unknownFields()) && fz9.f(this.d, shapeArgs.d)) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.d = str;
        }

        @Override // com.squareup.wire2.Message
        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                StringBuilder sb = new StringBuilder();
                if (this.d != null) {
                    sb.append(", d=");
                    sb.append(this.d);
                }
                StringBuilder replace = sb.replace(0, 2, "ShapeArgs{");
                replace.append('}');
                return replace.toString();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public ShapeEntity build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new ShapeEntity(this.type, this.styles, this.transform, this.shape, this.rect, this.ellipse, super.buildUnknownFields());
            }
            return (ShapeEntity) invokeV.objValue;
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
    }

    /* loaded from: classes8.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        public ShapeEntity decode(az9 az9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, az9Var)) == null) {
                Builder builder = new Builder();
                long c = az9Var.c();
                while (true) {
                    int f = az9Var.f();
                    if (f != -1) {
                        if (f != 1) {
                            if (f != 2) {
                                if (f != 3) {
                                    if (f != 4) {
                                        if (f != 10) {
                                            if (f != 11) {
                                                FieldEncoding g = az9Var.g();
                                                builder.addUnknownField(f, g, g.rawProtoAdapter().decode(az9Var));
                                            } else {
                                                builder.transform(Transform.ADAPTER.decode(az9Var));
                                            }
                                        } else {
                                            builder.styles(ShapeStyle.ADAPTER.decode(az9Var));
                                        }
                                    } else {
                                        builder.ellipse(EllipseArgs.ADAPTER.decode(az9Var));
                                    }
                                } else {
                                    builder.rect(RectArgs.ADAPTER.decode(az9Var));
                                }
                            } else {
                                builder.shape(ShapeArgs.ADAPTER.decode(az9Var));
                            }
                        } else {
                            try {
                                builder.type(ShapeType.ADAPTER.decode(az9Var));
                            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                                builder.addUnknownField(f, FieldEncoding.VARINT, Long.valueOf(e.value));
                            }
                        }
                    } else {
                        az9Var.d(c);
                        return builder.build();
                    }
                }
            } else {
                return (ShapeEntity) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(bz9 bz9Var, ShapeEntity shapeEntity) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, bz9Var, shapeEntity) == null) {
                ShapeType shapeType = shapeEntity.type;
                if (shapeType != null) {
                    ShapeType.ADAPTER.encodeWithTag(bz9Var, 1, shapeType);
                }
                ShapeStyle shapeStyle = shapeEntity.styles;
                if (shapeStyle != null) {
                    ShapeStyle.ADAPTER.encodeWithTag(bz9Var, 10, shapeStyle);
                }
                Transform transform = shapeEntity.transform;
                if (transform != null) {
                    Transform.ADAPTER.encodeWithTag(bz9Var, 11, transform);
                }
                ShapeArgs shapeArgs = shapeEntity.shape;
                if (shapeArgs != null) {
                    ShapeArgs.ADAPTER.encodeWithTag(bz9Var, 2, shapeArgs);
                }
                RectArgs rectArgs = shapeEntity.rect;
                if (rectArgs != null) {
                    RectArgs.ADAPTER.encodeWithTag(bz9Var, 3, rectArgs);
                }
                EllipseArgs ellipseArgs = shapeEntity.ellipse;
                if (ellipseArgs != null) {
                    EllipseArgs.ADAPTER.encodeWithTag(bz9Var, 4, ellipseArgs);
                }
                bz9Var.k(shapeEntity.unknownFields());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(ShapeEntity shapeEntity) {
            InterceptResult invokeL;
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, shapeEntity)) == null) {
                ShapeType shapeType = shapeEntity.type;
                int i6 = 0;
                if (shapeType != null) {
                    i = ShapeType.ADAPTER.encodedSizeWithTag(1, shapeType);
                } else {
                    i = 0;
                }
                ShapeStyle shapeStyle = shapeEntity.styles;
                if (shapeStyle != null) {
                    i2 = ShapeStyle.ADAPTER.encodedSizeWithTag(10, shapeStyle);
                } else {
                    i2 = 0;
                }
                int i7 = i + i2;
                Transform transform = shapeEntity.transform;
                if (transform != null) {
                    i3 = Transform.ADAPTER.encodedSizeWithTag(11, transform);
                } else {
                    i3 = 0;
                }
                int i8 = i7 + i3;
                ShapeArgs shapeArgs = shapeEntity.shape;
                if (shapeArgs != null) {
                    i4 = ShapeArgs.ADAPTER.encodedSizeWithTag(2, shapeArgs);
                } else {
                    i4 = 0;
                }
                int i9 = i8 + i4;
                RectArgs rectArgs = shapeEntity.rect;
                if (rectArgs != null) {
                    i5 = RectArgs.ADAPTER.encodedSizeWithTag(3, rectArgs);
                } else {
                    i5 = 0;
                }
                int i10 = i9 + i5;
                EllipseArgs ellipseArgs = shapeEntity.ellipse;
                if (ellipseArgs != null) {
                    i6 = EllipseArgs.ADAPTER.encodedSizeWithTag(4, ellipseArgs);
                }
                return i10 + i6 + shapeEntity.unknownFields().size();
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class ShapeType implements ez9 {
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

        public ShapeType(String str, int i, int i2) {
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

        public static ShapeType fromValue(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
                if (i != 0) {
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
                return (ShapeType) Enum.valueOf(ShapeType.class, str);
            }
            return (ShapeType) invokeL.objValue;
        }

        public static ShapeType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
                return (ShapeType[]) $VALUES.clone();
            }
            return (ShapeType[]) invokeV.objValue;
        }

        @Override // com.baidu.tieba.ez9
        public int getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.value;
            }
            return invokeV.intValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((ShapeType) objArr2[0], (ShapeStyle) objArr2[1], (Transform) objArr2[2], (ShapeArgs) objArr2[3], (RectArgs) objArr2[4], (EllipseArgs) objArr2[5], (ByteString) objArr2[6]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ProtoAdapter) objArr2[0], (ByteString) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (fz9.e(shapeArgs, rectArgs, ellipseArgs) <= 1) {
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

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShapeEntity)) {
                return false;
            }
            ShapeEntity shapeEntity = (ShapeEntity) obj;
            if (unknownFields().equals(shapeEntity.unknownFields()) && fz9.f(this.type, shapeEntity.type) && fz9.f(this.styles, shapeEntity.styles) && fz9.f(this.transform, shapeEntity.transform) && fz9.f(this.shape, shapeEntity.shape) && fz9.f(this.rect, shapeEntity.rect) && fz9.f(this.ellipse, shapeEntity.ellipse)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i6 = this.hashCode;
            if (i6 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                ShapeType shapeType = this.type;
                int i7 = 0;
                if (shapeType != null) {
                    i = shapeType.hashCode();
                } else {
                    i = 0;
                }
                int i8 = (hashCode + i) * 37;
                ShapeStyle shapeStyle = this.styles;
                if (shapeStyle != null) {
                    i2 = shapeStyle.hashCode();
                } else {
                    i2 = 0;
                }
                int i9 = (i8 + i2) * 37;
                Transform transform = this.transform;
                if (transform != null) {
                    i3 = transform.hashCode();
                } else {
                    i3 = 0;
                }
                int i10 = (i9 + i3) * 37;
                ShapeArgs shapeArgs = this.shape;
                if (shapeArgs != null) {
                    i4 = shapeArgs.hashCode();
                } else {
                    i4 = 0;
                }
                int i11 = (i10 + i4) * 37;
                RectArgs rectArgs = this.rect;
                if (rectArgs != null) {
                    i5 = rectArgs.hashCode();
                } else {
                    i5 = 0;
                }
                int i12 = (i11 + i5) * 37;
                EllipseArgs ellipseArgs = this.ellipse;
                if (ellipseArgs != null) {
                    i7 = ellipseArgs.hashCode();
                }
                int i13 = i12 + i7;
                this.hashCode = i13;
                return i13;
            }
            return i6;
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
            replace.append('}');
            return replace.toString();
        }
        return (String) invokeV.objValue;
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
