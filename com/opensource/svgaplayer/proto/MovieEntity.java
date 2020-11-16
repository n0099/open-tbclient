package com.opensource.svgaplayer.proto;

import com.baidu.tbadk.TbConfig;
import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.Message;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import com.squareup.wire2.c;
import com.squareup.wire2.d;
import com.squareup.wire2.internal.a;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
/* loaded from: classes17.dex */
public final class MovieEntity extends Message<MovieEntity, Builder> {
    public static final ProtoAdapter<MovieEntity> ADAPTER = new ProtoAdapter_MovieEntity();
    public static final String DEFAULT_VERSION = "";
    private static final long serialVersionUID = 0;
    @WireField(eyt = "com.opensource.svgaplayer.proto.AudioEntity#ADAPTER", eyu = WireField.Label.REPEATED, tag = 5)
    public final List<AudioEntity> audios;
    @WireField(eys = "com.squareup.wire.ProtoAdapter#STRING", eyt = "com.squareup.wire.ProtoAdapter#BYTES", tag = 3)
    public final Map<String, ByteString> images;
    @WireField(eyt = "com.opensource.svgaplayer.proto.MovieParams#ADAPTER", tag = 2)
    public final MovieParams params;
    @WireField(eyt = "com.opensource.svgaplayer.proto.SpriteEntity#ADAPTER", eyu = WireField.Label.REPEATED, tag = 4)
    public final List<SpriteEntity> sprites;
    @WireField(eyt = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String version;

    public MovieEntity(String str, MovieParams movieParams, Map<String, ByteString> map, List<SpriteEntity> list, List<AudioEntity> list2) {
        this(str, movieParams, map, list, list2, ByteString.EMPTY);
    }

    public MovieEntity(String str, MovieParams movieParams, Map<String, ByteString> map, List<SpriteEntity> list, List<AudioEntity> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.version = str;
        this.params = movieParams;
        this.images = a.o(TbConfig.IMAGE_CACHE_DIR_NAME, map);
        this.sprites = a.u("sprites", list);
        this.audios = a.u("audios", list2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.MovieEntity$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<MovieEntity, Builder> newBuilder2() {
        Builder builder = new Builder();
        builder.version = this.version;
        builder.params = this.params;
        builder.images = a.n(TbConfig.IMAGE_CACHE_DIR_NAME, this.images);
        builder.sprites = a.t("sprites", this.sprites);
        builder.audios = a.t("audios", this.audios);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MovieEntity) {
            MovieEntity movieEntity = (MovieEntity) obj;
            return unknownFields().equals(movieEntity.unknownFields()) && a.equals(this.version, movieEntity.version) && a.equals(this.params, movieEntity.params) && this.images.equals(movieEntity.images) && this.sprites.equals(movieEntity.sprites) && this.audios.equals(movieEntity.audios);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = (((((((((this.version != null ? this.version.hashCode() : 0) + (unknownFields().hashCode() * 37)) * 37) + (this.params != null ? this.params.hashCode() : 0)) * 37) + this.images.hashCode()) * 37) + this.sprites.hashCode()) * 37) + this.audios.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.version != null) {
            sb.append(", version=").append(this.version);
        }
        if (this.params != null) {
            sb.append(", params=").append(this.params);
        }
        if (!this.images.isEmpty()) {
            sb.append(", images=").append(this.images);
        }
        if (!this.sprites.isEmpty()) {
            sb.append(", sprites=").append(this.sprites);
        }
        if (!this.audios.isEmpty()) {
            sb.append(", audios=").append(this.audios);
        }
        return sb.replace(0, 2, "MovieEntity{").append('}').toString();
    }

    /* loaded from: classes17.dex */
    public static final class Builder extends Message.a<MovieEntity, Builder> {
        public MovieParams params;
        public String version;
        public Map<String, ByteString> images = a.eyx();
        public List<SpriteEntity> sprites = a.eyw();
        public List<AudioEntity> audios = a.eyw();

        public Builder version(String str) {
            this.version = str;
            return this;
        }

        public Builder params(MovieParams movieParams) {
            this.params = movieParams;
            return this;
        }

        public Builder images(Map<String, ByteString> map) {
            a.N(map);
            this.images = map;
            return this;
        }

        public Builder sprites(List<SpriteEntity> list) {
            a.gJ(list);
            this.sprites = list;
            return this;
        }

        public Builder audios(List<AudioEntity> list) {
            a.gJ(list);
            this.audios = list;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public MovieEntity build() {
            return new MovieEntity(this.version, this.params, this.images, this.sprites, this.audios, super.buildUnknownFields());
        }
    }

    /* loaded from: classes17.dex */
    private static final class ProtoAdapter_MovieEntity extends ProtoAdapter<MovieEntity> {
        private final ProtoAdapter<Map<String, ByteString>> images;

        ProtoAdapter_MovieEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, MovieEntity.class);
            this.images = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BYTES);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(MovieEntity movieEntity) {
            return (movieEntity.version != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, movieEntity.version) : 0) + (movieEntity.params != null ? MovieParams.ADAPTER.encodedSizeWithTag(2, movieEntity.params) : 0) + this.images.encodedSizeWithTag(3, movieEntity.images) + SpriteEntity.ADAPTER.asRepeated().encodedSizeWithTag(4, movieEntity.sprites) + AudioEntity.ADAPTER.asRepeated().encodedSizeWithTag(5, movieEntity.audios) + movieEntity.unknownFields().size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, MovieEntity movieEntity) throws IOException {
            if (movieEntity.version != null) {
                ProtoAdapter.STRING.encodeWithTag(dVar, 1, movieEntity.version);
            }
            if (movieEntity.params != null) {
                MovieParams.ADAPTER.encodeWithTag(dVar, 2, movieEntity.params);
            }
            this.images.encodeWithTag(dVar, 3, movieEntity.images);
            SpriteEntity.ADAPTER.asRepeated().encodeWithTag(dVar, 4, movieEntity.sprites);
            AudioEntity.ADAPTER.asRepeated().encodeWithTag(dVar, 5, movieEntity.audios);
            dVar.b(movieEntity.unknownFields());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public MovieEntity decode(c cVar) throws IOException {
            Builder builder = new Builder();
            long eyl = cVar.eyl();
            while (true) {
                int eym = cVar.eym();
                if (eym != -1) {
                    switch (eym) {
                        case 1:
                            builder.version(ProtoAdapter.STRING.decode(cVar));
                            break;
                        case 2:
                            builder.params(MovieParams.ADAPTER.decode(cVar));
                            break;
                        case 3:
                            builder.images.putAll(this.images.decode(cVar));
                            break;
                        case 4:
                            builder.sprites.add(SpriteEntity.ADAPTER.decode(cVar));
                            break;
                        case 5:
                            builder.audios.add(AudioEntity.ADAPTER.decode(cVar));
                            break;
                        default:
                            FieldEncoding eyn = cVar.eyn();
                            builder.addUnknownField(eym, eyn, eyn.rawProtoAdapter().decode(cVar));
                            break;
                    }
                } else {
                    cVar.ie(eyl);
                    return builder.build();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.opensource.svgaplayer.proto.MovieEntity$Builder] */
        @Override // com.squareup.wire2.ProtoAdapter
        public MovieEntity redact(MovieEntity movieEntity) {
            ?? newBuilder2 = movieEntity.newBuilder2();
            if (newBuilder2.params != null) {
                newBuilder2.params = MovieParams.ADAPTER.redact(newBuilder2.params);
            }
            a.a(newBuilder2.sprites, SpriteEntity.ADAPTER);
            a.a(newBuilder2.audios, AudioEntity.ADAPTER);
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }
}
