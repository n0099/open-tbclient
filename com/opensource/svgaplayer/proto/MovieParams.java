package com.opensource.svgaplayer.proto;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pv9;
import com.baidu.tieba.qv9;
import com.baidu.tieba.uv9;
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
public final class MovieParams extends Message<MovieParams, Builder> {
    public static /* synthetic */ Interceptable $ic;
    public static final ProtoAdapter<MovieParams> ADAPTER;
    public static final Integer DEFAULT_FPS;
    public static final Integer DEFAULT_FRAMES;
    public static final Float DEFAULT_VIEWBOXHEIGHT;
    public static final Float DEFAULT_VIEWBOXWIDTH;
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer fps;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer frames;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float viewBoxHeight;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float viewBoxWidth;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.a<MovieParams, Builder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer fps;
        public Integer frames;
        public Float viewBoxHeight;
        public Float viewBoxWidth;

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
        public MovieParams build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new MovieParams(this.viewBoxWidth, this.viewBoxHeight, this.fps, this.frames, super.buildUnknownFields());
            }
            return (MovieParams) invokeV.objValue;
        }

        public Builder fps(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, num)) == null) {
                this.fps = num;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder frames(Integer num) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, num)) == null) {
                this.frames = num;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder viewBoxHeight(Float f) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f)) == null) {
                this.viewBoxHeight = f;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder viewBoxWidth(Float f) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f)) == null) {
                this.viewBoxWidth = f;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static final class ProtoAdapter_MovieParams extends ProtoAdapter<MovieParams> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProtoAdapter_MovieParams() {
            super(FieldEncoding.LENGTH_DELIMITED, MovieParams.class);
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
        public MovieParams decode(pv9 pv9Var) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pv9Var)) == null) {
                Builder builder = new Builder();
                long c = pv9Var.c();
                while (true) {
                    int f = pv9Var.f();
                    if (f != -1) {
                        if (f != 1) {
                            if (f != 2) {
                                if (f != 3) {
                                    if (f != 4) {
                                        FieldEncoding g = pv9Var.g();
                                        builder.addUnknownField(f, g, g.rawProtoAdapter().decode(pv9Var));
                                    } else {
                                        builder.frames(ProtoAdapter.INT32.decode(pv9Var));
                                    }
                                } else {
                                    builder.fps(ProtoAdapter.INT32.decode(pv9Var));
                                }
                            } else {
                                builder.viewBoxHeight(ProtoAdapter.FLOAT.decode(pv9Var));
                            }
                        } else {
                            builder.viewBoxWidth(ProtoAdapter.FLOAT.decode(pv9Var));
                        }
                    } else {
                        pv9Var.d(c);
                        return builder.build();
                    }
                }
            } else {
                return (MovieParams) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public MovieParams redact(MovieParams movieParams) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, movieParams)) == null) {
                Message.a<MovieParams, Builder> newBuilder2 = movieParams.newBuilder2();
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
            return (MovieParams) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(qv9 qv9Var, MovieParams movieParams) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, qv9Var, movieParams) == null) {
                Float f = movieParams.viewBoxWidth;
                if (f != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(qv9Var, 1, f);
                }
                Float f2 = movieParams.viewBoxHeight;
                if (f2 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(qv9Var, 2, f2);
                }
                Integer num = movieParams.fps;
                if (num != null) {
                    ProtoAdapter.INT32.encodeWithTag(qv9Var, 3, num);
                }
                Integer num2 = movieParams.frames;
                if (num2 != null) {
                    ProtoAdapter.INT32.encodeWithTag(qv9Var, 4, num2);
                }
                qv9Var.k(movieParams.unknownFields());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(MovieParams movieParams) {
            InterceptResult invokeL;
            int i;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, movieParams)) == null) {
                Float f = movieParams.viewBoxWidth;
                int i4 = 0;
                if (f != null) {
                    i = ProtoAdapter.FLOAT.encodedSizeWithTag(1, f);
                } else {
                    i = 0;
                }
                Float f2 = movieParams.viewBoxHeight;
                if (f2 != null) {
                    i2 = ProtoAdapter.FLOAT.encodedSizeWithTag(2, f2);
                } else {
                    i2 = 0;
                }
                int i5 = i + i2;
                Integer num = movieParams.fps;
                if (num != null) {
                    i3 = ProtoAdapter.INT32.encodedSizeWithTag(3, num);
                } else {
                    i3 = 0;
                }
                int i6 = i5 + i3;
                Integer num2 = movieParams.frames;
                if (num2 != null) {
                    i4 = ProtoAdapter.INT32.encodedSizeWithTag(4, num2);
                }
                return i6 + i4 + movieParams.unknownFields().size();
            }
            return invokeL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1197518195, "Lcom/opensource/svgaplayer/proto/MovieParams;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1197518195, "Lcom/opensource/svgaplayer/proto/MovieParams;");
                return;
            }
        }
        ADAPTER = new ProtoAdapter_MovieParams();
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_VIEWBOXWIDTH = valueOf;
        DEFAULT_VIEWBOXHEIGHT = valueOf;
        DEFAULT_FPS = 0;
        DEFAULT_FRAMES = 0;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MovieParams(Float f, Float f2, Integer num, Integer num2) {
        this(f, f2, num, num2, ByteString.EMPTY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f, f2, num, num2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Float) objArr2[0], (Float) objArr2[1], (Integer) objArr2[2], (Integer) objArr2[3], (ByteString) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieParams(Float f, Float f2, Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f, f2, num, num2, byteString};
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
        this.viewBoxWidth = f;
        this.viewBoxHeight = f2;
        this.fps = num;
        this.frames = num2;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MovieParams)) {
                return false;
            }
            MovieParams movieParams = (MovieParams) obj;
            if (unknownFields().equals(movieParams.unknownFields()) && uv9.f(this.viewBoxWidth, movieParams.viewBoxWidth) && uv9.f(this.viewBoxHeight, movieParams.viewBoxHeight) && uv9.f(this.fps, movieParams.fps) && uv9.f(this.frames, movieParams.frames)) {
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
                Float f = this.viewBoxWidth;
                int i5 = 0;
                if (f != null) {
                    i = f.hashCode();
                } else {
                    i = 0;
                }
                int i6 = (hashCode + i) * 37;
                Float f2 = this.viewBoxHeight;
                if (f2 != null) {
                    i2 = f2.hashCode();
                } else {
                    i2 = 0;
                }
                int i7 = (i6 + i2) * 37;
                Integer num = this.fps;
                if (num != null) {
                    i3 = num.hashCode();
                } else {
                    i3 = 0;
                }
                int i8 = (i7 + i3) * 37;
                Integer num2 = this.frames;
                if (num2 != null) {
                    i5 = num2.hashCode();
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
            if (this.viewBoxWidth != null) {
                sb.append(", viewBoxWidth=");
                sb.append(this.viewBoxWidth);
            }
            if (this.viewBoxHeight != null) {
                sb.append(", viewBoxHeight=");
                sb.append(this.viewBoxHeight);
            }
            if (this.fps != null) {
                sb.append(", fps=");
                sb.append(this.fps);
            }
            if (this.frames != null) {
                sb.append(", frames=");
                sb.append(this.frames);
            }
            StringBuilder replace = sb.replace(0, 2, "MovieParams{");
            replace.append('}');
            return replace.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.MovieParams$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<MovieParams, Builder> newBuilder2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Builder builder = new Builder();
            builder.viewBoxWidth = this.viewBoxWidth;
            builder.viewBoxHeight = this.viewBoxHeight;
            builder.fps = this.fps;
            builder.frames = this.frames;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
        return (Builder) invokeV.objValue;
    }
}
