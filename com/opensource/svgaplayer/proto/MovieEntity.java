package com.opensource.svgaplayer.proto;

import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.Message;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import d.o.a.c;
import d.o.a.d;
import d.o.a.h.a;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
/* loaded from: classes6.dex */
public final class MovieEntity extends Message<MovieEntity, Builder> {
    public static final ProtoAdapter<MovieEntity> ADAPTER = new ProtoAdapter_MovieEntity();
    public static final String DEFAULT_VERSION = "";
    public static final long serialVersionUID = 0;
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

    /* loaded from: classes6.dex */
    public static final class Builder extends Message.a<MovieEntity, Builder> {
        public MovieParams params;
        public String version;
        public Map<String, ByteString> images = a.j();
        public List<SpriteEntity> sprites = a.i();
        public List<AudioEntity> audios = a.i();

        public Builder audios(List<AudioEntity> list) {
            a.a(list);
            this.audios = list;
            return this;
        }

        public Builder images(Map<String, ByteString> map) {
            a.b(map);
            this.images = map;
            return this;
        }

        public Builder params(MovieParams movieParams) {
            this.params = movieParams;
            return this;
        }

        public Builder sprites(List<SpriteEntity> list) {
            a.a(list);
            this.sprites = list;
            return this;
        }

        public Builder version(String str) {
            this.version = str;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public MovieEntity build() {
            return new MovieEntity(this.version, this.params, this.images, this.sprites, this.audios, super.buildUnknownFields());
        }
    }

    /* loaded from: classes6.dex */
    public static final class ProtoAdapter_MovieEntity extends ProtoAdapter<MovieEntity> {
        public final ProtoAdapter<Map<String, ByteString>> images;

        public ProtoAdapter_MovieEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, MovieEntity.class);
            this.images = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.BYTES);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public MovieEntity decode(c cVar) throws IOException {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(MovieEntity movieEntity) {
            String str = movieEntity.version;
            int encodedSizeWithTag = str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0;
            MovieParams movieParams = movieEntity.params;
            return encodedSizeWithTag + (movieParams != null ? MovieParams.ADAPTER.encodedSizeWithTag(2, movieParams) : 0) + this.images.encodedSizeWithTag(3, movieEntity.images) + SpriteEntity.ADAPTER.asRepeated().encodedSizeWithTag(4, movieEntity.sprites) + AudioEntity.ADAPTER.asRepeated().encodedSizeWithTag(5, movieEntity.audios) + movieEntity.unknownFields().size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r3v1, types: [com.squareup.wire2.Message$a, com.opensource.svgaplayer.proto.MovieEntity$Builder] */
        @Override // com.squareup.wire2.ProtoAdapter
        public MovieEntity redact(MovieEntity movieEntity) {
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
    }

    public MovieEntity(String str, MovieParams movieParams, Map<String, ByteString> map, List<SpriteEntity> list, List<AudioEntity> list2) {
        this(str, movieParams, map, list, list2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MovieEntity) {
            MovieEntity movieEntity = (MovieEntity) obj;
            return unknownFields().equals(movieEntity.unknownFields()) && a.f(this.version, movieEntity.version) && a.f(this.params, movieEntity.params) && this.images.equals(movieEntity.images) && this.sprites.equals(movieEntity.sprites) && this.audios.equals(movieEntity.audios);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.version;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
            MovieParams movieParams = this.params;
            int hashCode3 = ((((((hashCode2 + (movieParams != null ? movieParams.hashCode() : 0)) * 37) + this.images.hashCode()) * 37) + this.sprites.hashCode()) * 37) + this.audios.hashCode();
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
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

    public MovieEntity(String str, MovieParams movieParams, Map<String, ByteString> map, List<SpriteEntity> list, List<AudioEntity> list2, ByteString byteString) {
        super(ADAPTER, byteString);
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
        Builder builder = new Builder();
        builder.version = this.version;
        builder.params = this.params;
        builder.images = a.d("images", this.images);
        builder.sprites = a.c("sprites", this.sprites);
        builder.audios = a.c("audios", this.audios);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
