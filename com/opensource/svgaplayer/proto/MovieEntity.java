package com.opensource.svgaplayer.proto;

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
import d.k.a.c;
import d.k.a.d;
import d.k.a.h.a;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
/* loaded from: classes7.dex */
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

    /* loaded from: classes7.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.images = a.j();
            this.sprites = a.i();
            this.audios = a.i();
        }

        public Builder audios(List<AudioEntity> list) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, list)) == null) {
                a.a(list);
                this.audios = list;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder images(Map<String, ByteString> map) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, map)) == null) {
                a.b(map);
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
                a.a(list);
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
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new MovieEntity(this.version, this.params, this.images, this.sprites, this.audios, super.buildUnknownFields()) : (MovieEntity) invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
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
            this.images = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BYTES);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public MovieEntity decode(c cVar) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, cVar)) != null) {
                return (MovieEntity) invokeL.objValue;
            }
            Builder builder = new Builder();
            long c2 = cVar.c();
            while (true) {
                int f2 = cVar.f();
                if (f2 == -1) {
                    cVar.d(c2);
                    return builder.build();
                } else if (f2 == 1) {
                    builder.version(ProtoAdapter.STRING.decode(cVar));
                } else if (f2 == 2) {
                    builder.params(MovieParams.ADAPTER.decode(cVar));
                } else if (f2 == 3) {
                    builder.images.putAll(this.images.decode(cVar));
                } else if (f2 == 4) {
                    builder.sprites.add(SpriteEntity.ADAPTER.decode(cVar));
                } else if (f2 != 5) {
                    FieldEncoding g2 = cVar.g();
                    builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                } else {
                    builder.audios.add(AudioEntity.ADAPTER.decode(cVar));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, MovieEntity movieEntity) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, movieEntity) == null) {
                String str = movieEntity.version;
                if (str != null) {
                    ProtoAdapter.STRING.encodeWithTag(dVar, 1, str);
                }
                MovieParams movieParams = movieEntity.params;
                if (movieParams != null) {
                    MovieParams.ADAPTER.encodeWithTag(dVar, 2, movieParams);
                }
                this.images.encodeWithTag(dVar, 3, movieEntity.images);
                SpriteEntity.ADAPTER.asRepeated().encodeWithTag(dVar, 4, movieEntity.sprites);
                AudioEntity.ADAPTER.asRepeated().encodeWithTag(dVar, 5, movieEntity.audios);
                dVar.k(movieEntity.unknownFields());
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(MovieEntity movieEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, movieEntity)) == null) {
                String str = movieEntity.version;
                int encodedSizeWithTag = str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0;
                MovieParams movieParams = movieEntity.params;
                return encodedSizeWithTag + (movieParams != null ? MovieParams.ADAPTER.encodedSizeWithTag(2, movieParams) : 0) + this.images.encodedSizeWithTag(3, movieEntity.images) + SpriteEntity.ADAPTER.asRepeated().encodedSizeWithTag(4, movieEntity.sprites) + AudioEntity.ADAPTER.asRepeated().encodedSizeWithTag(5, movieEntity.audios) + movieEntity.unknownFields().size();
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
                a.k(newBuilder2.sprites, SpriteEntity.ADAPTER);
                a.k(newBuilder2.audios, AudioEntity.ADAPTER);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (MovieParams) objArr2[1], (Map) objArr2[2], (List) objArr2[3], (List) objArr2[4], (ByteString) objArr2[5]);
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
            if (obj instanceof MovieEntity) {
                MovieEntity movieEntity = (MovieEntity) obj;
                return unknownFields().equals(movieEntity.unknownFields()) && a.f(this.version, movieEntity.version) && a.f(this.params, movieEntity.params) && this.images.equals(movieEntity.images) && this.sprites.equals(movieEntity.sprites) && this.audios.equals(movieEntity.audios);
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
                String str = this.version;
                int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
                MovieParams movieParams = this.params;
                int hashCode3 = ((((((hashCode2 + (movieParams != null ? movieParams.hashCode() : 0)) * 37) + this.images.hashCode()) * 37) + this.sprites.hashCode()) * 37) + this.audios.hashCode();
                this.hashCode = hashCode3;
                return hashCode3;
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MovieEntity(String str, MovieParams movieParams, Map<String, ByteString> map, List<SpriteEntity> list, List<AudioEntity> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, movieParams, map, list, list2, byteString};
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
        this.version = str;
        this.params = movieParams;
        this.images = a.h("images", map);
        this.sprites = a.g("sprites", list);
        this.audios = a.g("audios", list2);
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
            builder.images = a.d("images", this.images);
            builder.sprites = a.c("sprites", this.sprites);
            builder.audios = a.c("audios", this.audios);
            builder.addUnknownFields(unknownFields());
            return builder;
        }
        return (Builder) invokeV.objValue;
    }
}
