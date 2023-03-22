package com.opensource.svgaplayer.proto;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.apa;
import com.baidu.tieba.epa;
import com.baidu.tieba.zoa;
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
public final class Layout extends Message<Layout, Builder> {
    public static /* synthetic */ Interceptable $ic;
    public static final ProtoAdapter<Layout> ADAPTER;
    public static final Float DEFAULT_HEIGHT;
    public static final Float DEFAULT_WIDTH;
    public static final Float DEFAULT_X;
    public static final Float DEFAULT_Y;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float height;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float width;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float x;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float y;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.a<Layout, Builder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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
        public Layout build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new Layout(this.x, this.y, this.width, this.height, super.buildUnknownFields());
            }
            return (Layout) invokeV.objValue;
        }

        public Builder height(Float f) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f)) == null) {
                this.height = f;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder width(Float f) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, f)) == null) {
                this.width = f;
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
    public static final class ProtoAdapter_Layout extends ProtoAdapter<Layout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProtoAdapter_Layout() {
            super(FieldEncoding.LENGTH_DELIMITED, Layout.class);
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
        public Layout decode(zoa zoaVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, zoaVar)) == null) {
                Builder builder = new Builder();
                long c = zoaVar.c();
                while (true) {
                    int f = zoaVar.f();
                    if (f != -1) {
                        if (f != 1) {
                            if (f != 2) {
                                if (f != 3) {
                                    if (f != 4) {
                                        FieldEncoding g = zoaVar.g();
                                        builder.addUnknownField(f, g, g.rawProtoAdapter().decode(zoaVar));
                                    } else {
                                        builder.height(ProtoAdapter.FLOAT.decode(zoaVar));
                                    }
                                } else {
                                    builder.width(ProtoAdapter.FLOAT.decode(zoaVar));
                                }
                            } else {
                                builder.y(ProtoAdapter.FLOAT.decode(zoaVar));
                            }
                        } else {
                            builder.x(ProtoAdapter.FLOAT.decode(zoaVar));
                        }
                    } else {
                        zoaVar.d(c);
                        return builder.build();
                    }
                }
            } else {
                return (Layout) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public Layout redact(Layout layout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, layout)) == null) {
                Message.a<Layout, Builder> newBuilder2 = layout.newBuilder2();
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
            return (Layout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(apa apaVar, Layout layout) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, apaVar, layout) == null) {
                Float f = layout.x;
                if (f != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(apaVar, 1, f);
                }
                Float f2 = layout.y;
                if (f2 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(apaVar, 2, f2);
                }
                Float f3 = layout.width;
                if (f3 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(apaVar, 3, f3);
                }
                Float f4 = layout.height;
                if (f4 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(apaVar, 4, f4);
                }
                apaVar.k(layout.unknownFields());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(Layout layout) {
            InterceptResult invokeL;
            int i;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, layout)) == null) {
                Float f = layout.x;
                int i4 = 0;
                if (f != null) {
                    i = ProtoAdapter.FLOAT.encodedSizeWithTag(1, f);
                } else {
                    i = 0;
                }
                Float f2 = layout.y;
                if (f2 != null) {
                    i2 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, f2);
                } else {
                    i2 = 0;
                }
                int i5 = i + i2;
                Float f3 = layout.width;
                if (f3 != null) {
                    i3 = ProtoAdapter.FLOAT.encodedSizeWithTag(3, f3);
                } else {
                    i3 = 0;
                }
                int i6 = i5 + i3;
                Float f4 = layout.height;
                if (f4 != null) {
                    i4 = ProtoAdapter.FLOAT.encodedSizeWithTag(4, f4);
                }
                return i6 + i4 + layout.unknownFields().size();
            }
            return invokeL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(990482665, "Lcom/opensource/svgaplayer/proto/Layout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(990482665, "Lcom/opensource/svgaplayer/proto/Layout;");
                return;
            }
        }
        ADAPTER = new ProtoAdapter_Layout();
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
        DEFAULT_WIDTH = valueOf;
        DEFAULT_HEIGHT = valueOf;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Layout(Float f, Float f2, Float f3, Float f4) {
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
    public Layout(Float f, Float f2, Float f3, Float f4, ByteString byteString) {
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
        this.width = f3;
        this.height = f4;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Layout)) {
                return false;
            }
            Layout layout = (Layout) obj;
            if (unknownFields().equals(layout.unknownFields()) && epa.f(this.x, layout.x) && epa.f(this.y, layout.y) && epa.f(this.width, layout.width) && epa.f(this.height, layout.height)) {
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
                Float f3 = this.width;
                if (f3 != null) {
                    i3 = f3.hashCode();
                } else {
                    i3 = 0;
                }
                int i8 = (i7 + i3) * 37;
                Float f4 = this.height;
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
            if (this.width != null) {
                sb.append(", width=");
                sb.append(this.width);
            }
            if (this.height != null) {
                sb.append(", height=");
                sb.append(this.height);
            }
            StringBuilder replace = sb.replace(0, 2, "Layout{");
            replace.append('}');
            return replace.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.Layout$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<Layout, Builder> newBuilder2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Builder builder = new Builder();
            builder.x = this.x;
            builder.y = this.y;
            builder.width = this.width;
            builder.height = this.height;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
        return (Builder) invokeV.objValue;
    }
}
