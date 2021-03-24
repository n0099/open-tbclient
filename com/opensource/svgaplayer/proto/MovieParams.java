package com.opensource.svgaplayer.proto;

import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.Message;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import d.n.a.c;
import d.n.a.d;
import d.n.a.h.a;
import java.io.IOException;
import okio.ByteString;
/* loaded from: classes.dex */
public final class MovieParams extends Message<MovieParams, Builder> {
    public static final ProtoAdapter<MovieParams> ADAPTER = new ProtoAdapter_MovieParams();
    public static final Integer DEFAULT_FPS;
    public static final Integer DEFAULT_FRAMES;
    public static final Float DEFAULT_VIEWBOXHEIGHT;
    public static final Float DEFAULT_VIEWBOXWIDTH;
    public static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer fps;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer frames;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float viewBoxHeight;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float viewBoxWidth;

    /* loaded from: classes6.dex */
    public static final class Builder extends Message.a<MovieParams, Builder> {
        public Integer fps;
        public Integer frames;
        public Float viewBoxHeight;
        public Float viewBoxWidth;

        public Builder fps(Integer num) {
            this.fps = num;
            return this;
        }

        public Builder frames(Integer num) {
            this.frames = num;
            return this;
        }

        public Builder viewBoxHeight(Float f2) {
            this.viewBoxHeight = f2;
            return this;
        }

        public Builder viewBoxWidth(Float f2) {
            this.viewBoxWidth = f2;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public MovieParams build() {
            return new MovieParams(this.viewBoxWidth, this.viewBoxHeight, this.fps, this.frames, super.buildUnknownFields());
        }
    }

    /* loaded from: classes6.dex */
    public static final class ProtoAdapter_MovieParams extends ProtoAdapter<MovieParams> {
        public ProtoAdapter_MovieParams() {
            super(FieldEncoding.LENGTH_DELIMITED, MovieParams.class);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public MovieParams decode(c cVar) throws IOException {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(MovieParams movieParams) {
            Float f2 = movieParams.viewBoxWidth;
            int encodedSizeWithTag = f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f2) : 0;
            Float f3 = movieParams.viewBoxHeight;
            int encodedSizeWithTag2 = encodedSizeWithTag + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f3) : 0);
            Integer num = movieParams.fps;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (num != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, num) : 0);
            Integer num2 = movieParams.frames;
            return encodedSizeWithTag3 + (num2 != null ? ProtoAdapter.INT32.encodedSizeWithTag(4, num2) : 0) + movieParams.unknownFields().size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public MovieParams redact(MovieParams movieParams) {
            Message.a<MovieParams, Builder> newBuilder2 = movieParams.newBuilder2();
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_VIEWBOXWIDTH = valueOf;
        DEFAULT_VIEWBOXHEIGHT = valueOf;
        DEFAULT_FPS = 0;
        DEFAULT_FRAMES = 0;
    }

    public MovieParams(Float f2, Float f3, Integer num, Integer num2) {
        this(f2, f3, num, num2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MovieParams) {
            MovieParams movieParams = (MovieParams) obj;
            return unknownFields().equals(movieParams.unknownFields()) && a.f(this.viewBoxWidth, movieParams.viewBoxWidth) && a.f(this.viewBoxHeight, movieParams.viewBoxHeight) && a.f(this.fps, movieParams.fps) && a.f(this.frames, movieParams.frames);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
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
        return i;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
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

    public MovieParams(Float f2, Float f3, Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
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
        Builder builder = new Builder();
        builder.viewBoxWidth = this.viewBoxWidth;
        builder.viewBoxHeight = this.viewBoxHeight;
        builder.fps = this.fps;
        builder.frames = this.frames;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
