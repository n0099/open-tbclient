package com.opensource.svgaplayer.proto;

import c.n.a.c;
import c.n.a.d;
import c.n.a.h.a;
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
/* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
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

        public Builder viewBoxHeight(Float f2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, f2)) == null) {
                this.viewBoxHeight = f2;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder viewBoxWidth(Float f2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, f2)) == null) {
                this.viewBoxWidth = f2;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public MovieParams build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new MovieParams(this.viewBoxWidth, this.viewBoxHeight, this.fps, this.frames, super.buildUnknownFields()) : (MovieParams) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
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
        public MovieParams decode(c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, cVar)) != null) {
                return (MovieParams) invokeL.objValue;
            }
            Builder builder = new Builder();
            long c2 = cVar.c();
            while (true) {
                int f2 = cVar.f();
                if (f2 == -1) {
                    cVar.d(c2);
                    return builder.build();
                } else if (f2 == 1) {
                    builder.viewBoxWidth(ProtoAdapter.FLOAT.decode(cVar));
                } else if (f2 == 2) {
                    builder.viewBoxHeight(ProtoAdapter.FLOAT.decode(cVar));
                } else if (f2 == 3) {
                    builder.fps(ProtoAdapter.INT32.decode(cVar));
                } else if (f2 != 4) {
                    FieldEncoding g2 = cVar.g();
                    builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                } else {
                    builder.frames(ProtoAdapter.INT32.decode(cVar));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, MovieParams movieParams) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, movieParams) == null) {
                Float f2 = movieParams.viewBoxWidth;
                if (f2 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, f2);
                }
                Float f3 = movieParams.viewBoxHeight;
                if (f3 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, f3);
                }
                Integer num = movieParams.fps;
                if (num != null) {
                    ProtoAdapter.INT32.encodeWithTag(dVar, 3, num);
                }
                Integer num2 = movieParams.frames;
                if (num2 != null) {
                    ProtoAdapter.INT32.encodeWithTag(dVar, 4, num2);
                }
                dVar.k(movieParams.unknownFields());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(MovieParams movieParams) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, movieParams)) == null) {
                Float f2 = movieParams.viewBoxWidth;
                int encodedSizeWithTag = f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f2) : 0;
                Float f3 = movieParams.viewBoxHeight;
                int encodedSizeWithTag2 = encodedSizeWithTag + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f3) : 0);
                Integer num = movieParams.fps;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, num) : 0);
                Integer num2 = movieParams.frames;
                return encodedSizeWithTag3 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(4, num2) : 0) + movieParams.unknownFields().size();
            }
            return invokeL.intValue;
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
    public MovieParams(Float f2, Float f3, Integer num, Integer num2) {
        this(f2, f3, num, num2, ByteString.EMPTY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f2, f3, num, num2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Float) objArr2[0], (Float) objArr2[1], (Integer) objArr2[2], (Integer) objArr2[3], (ByteString) objArr2[4]);
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
            if (obj instanceof MovieParams) {
                MovieParams movieParams = (MovieParams) obj;
                return unknownFields().equals(movieParams.unknownFields()) && a.f(this.viewBoxWidth, movieParams.viewBoxWidth) && a.f(this.viewBoxHeight, movieParams.viewBoxHeight) && a.f(this.fps, movieParams.fps) && a.f(this.frames, movieParams.frames);
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
                Float f2 = this.viewBoxWidth;
                int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 37;
                Float f3 = this.viewBoxHeight;
                int hashCode3 = (hashCode2 + (f3 != null ? f3.hashCode() : 0)) * 37;
                Integer num = this.fps;
                int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 37;
                Integer num2 = this.frames;
                int hashCode5 = hashCode4 + (num2 != null ? num2.hashCode() : 0);
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
            replace.append(ExtendedMessageFormat.END_FE);
            return replace.toString();
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieParams(Float f2, Float f3, Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f2, f3, num, num2, byteString};
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
        this.viewBoxWidth = f2;
        this.viewBoxHeight = f3;
        this.fps = num;
        this.frames = num2;
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
