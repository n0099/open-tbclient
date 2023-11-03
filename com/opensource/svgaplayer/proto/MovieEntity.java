package com.opensource.svgaplayer.proto;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cac;
import com.baidu.tieba.dac;
import com.baidu.tieba.hac;
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
import java.util.List;
import java.util.Map;
import okio.ByteString;
/* loaded from: classes10.dex */
public final class MovieEntity extends Message<MovieEntity, Builder> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final ProtoAdapter<MovieEntity> ADAPTER;
    public static final String DEFAULT_VERSION = "";
    public static final long serialVersionUID = 0;
    public transient /* synthetic */ FieldHolder $fh;
    @WireField(adapter = "com.opensource.svgaplayer.proto.AudioEntity#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<AudioEntity> audios;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", keyAdapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final Map<String, ByteString> images;
    @WireField(adapter = "com.opensource.svgaplayer.proto.MovieParams#ADAPTER", tag = 2)
    public final MovieParams params;
    @WireField(adapter = "com.opensource.svgaplayer.proto.SpriteEntity#ADAPTER", label = WireField.Label.REPEATED, tag = 4)
    public final List<SpriteEntity> sprites;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String version;

    /* loaded from: classes10.dex */
    public static final class Builder extends Message.a<MovieEntity, Builder> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<AudioEntity> audios;
        public Map<String, ByteString> images;
        public MovieParams params;
        public List<SpriteEntity> sprites;
        public String version;

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
                    return;
                }
            }
            this.images = hac.j();
            this.sprites = hac.i();
            this.audios = hac.i();
        }

        public Builder audios(List<AudioEntity> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                hac.a(list);
                this.audios = list;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder images(Map<String, ByteString> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
                hac.b(map);
                this.images = map;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder params(MovieParams movieParams) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, movieParams)) == null) {
                this.params = movieParams;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder sprites(List<SpriteEntity> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, list)) == null) {
                hac.a(list);
                this.sprites = list;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder version(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
                this.version = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public MovieEntity build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return new MovieEntity(this.version, this.params, this.images, this.sprites, this.audios, super.buildUnknownFields());
            }
            return (MovieEntity) invokeV.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public static final class ProtoAdapter_MovieEntity extends ProtoAdapter<MovieEntity> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final ProtoAdapter<Map<String, ByteString>> images;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ProtoAdapter_MovieEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, MovieEntity.class);
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
            this.images = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BYTES);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public MovieEntity decode(cac cacVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cacVar)) == null) {
                Builder builder = new Builder();
                long c = cacVar.c();
                while (true) {
                    int f = cacVar.f();
                    if (f != -1) {
                        if (f != 1) {
                            if (f != 2) {
                                if (f != 3) {
                                    if (f != 4) {
                                        if (f != 5) {
                                            FieldEncoding g = cacVar.g();
                                            builder.addUnknownField(f, g, g.rawProtoAdapter().decode(cacVar));
                                        } else {
                                            builder.audios.add(AudioEntity.ADAPTER.decode(cacVar));
                                        }
                                    } else {
                                        builder.sprites.add(SpriteEntity.ADAPTER.decode(cacVar));
                                    }
                                } else {
                                    builder.images.putAll(this.images.decode(cacVar));
                                }
                            } else {
                                builder.params(MovieParams.ADAPTER.decode(cacVar));
                            }
                        } else {
                            builder.version(ProtoAdapter.STRING.decode(cacVar));
                        }
                    } else {
                        cacVar.d(c);
                        return builder.build();
                    }
                }
            } else {
                return (MovieEntity) invokeL.objValue;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(dac dacVar, MovieEntity movieEntity) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dacVar, movieEntity) == null) {
                String str = movieEntity.version;
                if (str != null) {
                    ProtoAdapter.STRING.encodeWithTag(dacVar, 1, str);
                }
                MovieParams movieParams = movieEntity.params;
                if (movieParams != null) {
                    MovieParams.ADAPTER.encodeWithTag(dacVar, 2, movieParams);
                }
                this.images.encodeWithTag(dacVar, 3, movieEntity.images);
                SpriteEntity.ADAPTER.asRepeated().encodeWithTag(dacVar, 4, movieEntity.sprites);
                AudioEntity.ADAPTER.asRepeated().encodeWithTag(dacVar, 5, movieEntity.audios);
                dacVar.k(movieEntity.unknownFields());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(MovieEntity movieEntity) {
            InterceptResult invokeL;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, movieEntity)) == null) {
                String str = movieEntity.version;
                int i2 = 0;
                if (str != null) {
                    i = ProtoAdapter.STRING.encodedSizeWithTag(1, str);
                } else {
                    i = 0;
                }
                MovieParams movieParams = movieEntity.params;
                if (movieParams != null) {
                    i2 = MovieParams.ADAPTER.encodedSizeWithTag(2, movieParams);
                }
                return i + i2 + this.images.encodedSizeWithTag(3, movieEntity.images) + SpriteEntity.ADAPTER.asRepeated().encodedSizeWithTag(4, movieEntity.sprites) + AudioEntity.ADAPTER.asRepeated().encodedSizeWithTag(5, movieEntity.audios) + movieEntity.unknownFields().size();
            }
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r5v1, types: [com.squareup.wire2.Message$a, com.opensource.svgaplayer.proto.MovieEntity$Builder] */
        @Override // com.squareup.wire2.ProtoAdapter
        public MovieEntity redact(MovieEntity movieEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, movieEntity)) == null) {
                ?? newBuilder2 = movieEntity.newBuilder2();
                MovieParams movieParams = newBuilder2.params;
                if (movieParams != null) {
                    newBuilder2.params = MovieParams.ADAPTER.redact(movieParams);
                }
                hac.k(newBuilder2.sprites, SpriteEntity.ADAPTER);
                hac.k(newBuilder2.audios, AudioEntity.ADAPTER);
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
            return (MovieEntity) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1995852848, "Lcom/opensource/svgaplayer/proto/MovieEntity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1995852848, "Lcom/opensource/svgaplayer/proto/MovieEntity;");
                return;
            }
        }
        ADAPTER = new ProtoAdapter_MovieEntity();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MovieEntity(String str, MovieParams movieParams, Map<String, ByteString> map, List<SpriteEntity> list, List<AudioEntity> list2) {
        this(str, movieParams, map, list, list2, ByteString.EMPTY);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, movieParams, map, list, list2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (MovieParams) objArr2[1], (Map) objArr2[2], (List) objArr2[3], (List) objArr2[4], (ByteString) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieEntity(String str, MovieParams movieParams, Map<String, ByteString> map, List<SpriteEntity> list, List<AudioEntity> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, movieParams, map, list, list2, byteString};
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
        this.version = str;
        this.params = movieParams;
        this.images = hac.h("images", map);
        this.sprites = hac.g("sprites", list);
        this.audios = hac.g("audios", list2);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MovieEntity)) {
                return false;
            }
            MovieEntity movieEntity = (MovieEntity) obj;
            if (unknownFields().equals(movieEntity.unknownFields()) && hac.f(this.version, movieEntity.version) && hac.f(this.params, movieEntity.params) && this.images.equals(movieEntity.images) && this.sprites.equals(movieEntity.sprites) && this.audios.equals(movieEntity.audios)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int i2 = this.hashCode;
            if (i2 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                String str = this.version;
                int i3 = 0;
                if (str != null) {
                    i = str.hashCode();
                } else {
                    i = 0;
                }
                int i4 = (hashCode + i) * 37;
                MovieParams movieParams = this.params;
                if (movieParams != null) {
                    i3 = movieParams.hashCode();
                }
                int hashCode2 = ((((((i4 + i3) * 37) + this.images.hashCode()) * 37) + this.sprites.hashCode()) * 37) + this.audios.hashCode();
                this.hashCode = hashCode2;
                return hashCode2;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.MovieEntity$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<MovieEntity, Builder> newBuilder2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Builder builder = new Builder();
            builder.version = this.version;
            builder.params = this.params;
            builder.images = hac.d("images", this.images);
            builder.sprites = hac.c("sprites", this.sprites);
            builder.audios = hac.c("audios", this.audios);
            builder.addUnknownFields(unknownFields());
            return builder;
        }
        return (Builder) invokeV.objValue;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StringBuilder sb = new StringBuilder();
            if (this.version != null) {
                sb.append(", version=");
                sb.append(this.version);
            }
            if (this.params != null) {
                sb.append(", params=");
                sb.append(this.params);
            }
            if (!this.images.isEmpty()) {
                sb.append(", images=");
                sb.append(this.images);
            }
            if (!this.sprites.isEmpty()) {
                sb.append(", sprites=");
                sb.append(this.sprites);
            }
            if (!this.audios.isEmpty()) {
                sb.append(", audios=");
                sb.append(this.audios);
            }
            StringBuilder replace = sb.replace(0, 2, "MovieEntity{");
            replace.append('}');
            return replace.toString();
        }
        return (String) invokeV.objValue;
    }
}
