package com.opensource.svgaplayer.proto;

import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.Message;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import com.squareup.wire2.c;
import com.squareup.wire2.d;
import com.squareup.wire2.internal.a;
import java.io.IOException;
import okio.ByteString;
/* loaded from: classes.dex */
public final class MovieParams extends Message<MovieParams, Builder> {
    private static final long serialVersionUID = 0;
    @WireField(dGu = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer fps;
    @WireField(dGu = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer frames;
    @WireField(dGu = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float viewBoxHeight;
    @WireField(dGu = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float viewBoxWidth;
    public static final ProtoAdapter<MovieParams> ADAPTER = new ProtoAdapter_MovieParams();
    public static final Float DEFAULT_VIEWBOXWIDTH = Float.valueOf(0.0f);
    public static final Float DEFAULT_VIEWBOXHEIGHT = Float.valueOf(0.0f);
    public static final Integer DEFAULT_FPS = 0;
    public static final Integer DEFAULT_FRAMES = 0;

    public MovieParams(Float f, Float f2, Integer num, Integer num2) {
        this(f, f2, num, num2, ByteString.EMPTY);
    }

    public MovieParams(Float f, Float f2, Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.viewBoxWidth = f;
        this.viewBoxHeight = f2;
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

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MovieParams) {
            MovieParams movieParams = (MovieParams) obj;
            return unknownFields().equals(movieParams.unknownFields()) && a.equals(this.viewBoxWidth, movieParams.viewBoxWidth) && a.equals(this.viewBoxHeight, movieParams.viewBoxHeight) && a.equals(this.fps, movieParams.fps) && a.equals(this.frames, movieParams.frames);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = (((this.fps != null ? this.fps.hashCode() : 0) + (((this.viewBoxHeight != null ? this.viewBoxHeight.hashCode() : 0) + (((this.viewBoxWidth != null ? this.viewBoxWidth.hashCode() : 0) + (unknownFields().hashCode() * 37)) * 37)) * 37)) * 37) + (this.frames != null ? this.frames.hashCode() : 0);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.viewBoxWidth != null) {
            sb.append(", viewBoxWidth=").append(this.viewBoxWidth);
        }
        if (this.viewBoxHeight != null) {
            sb.append(", viewBoxHeight=").append(this.viewBoxHeight);
        }
        if (this.fps != null) {
            sb.append(", fps=").append(this.fps);
        }
        if (this.frames != null) {
            sb.append(", frames=").append(this.frames);
        }
        return sb.replace(0, 2, "MovieParams{").append('}').toString();
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.a<MovieParams, Builder> {
        public Integer fps;
        public Integer frames;
        public Float viewBoxHeight;
        public Float viewBoxWidth;

        public Builder viewBoxWidth(Float f) {
            this.viewBoxWidth = f;
            return this;
        }

        public Builder viewBoxHeight(Float f) {
            this.viewBoxHeight = f;
            return this;
        }

        public Builder fps(Integer num) {
            this.fps = num;
            return this;
        }

        public Builder frames(Integer num) {
            this.frames = num;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public MovieParams build() {
            return new MovieParams(this.viewBoxWidth, this.viewBoxHeight, this.fps, this.frames, super.buildUnknownFields());
        }
    }

    /* loaded from: classes.dex */
    private static final class ProtoAdapter_MovieParams extends ProtoAdapter<MovieParams> {
        ProtoAdapter_MovieParams() {
            super(FieldEncoding.LENGTH_DELIMITED, MovieParams.class);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(MovieParams movieParams) {
            return (movieParams.fps != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, movieParams.fps) : 0) + (movieParams.viewBoxHeight != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, movieParams.viewBoxHeight) : 0) + (movieParams.viewBoxWidth != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, movieParams.viewBoxWidth) : 0) + (movieParams.frames != null ? ProtoAdapter.INT32.encodedSizeWithTag(4, movieParams.frames) : 0) + movieParams.unknownFields().size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, MovieParams movieParams) throws IOException {
            if (movieParams.viewBoxWidth != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, movieParams.viewBoxWidth);
            }
            if (movieParams.viewBoxHeight != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, movieParams.viewBoxHeight);
            }
            if (movieParams.fps != null) {
                ProtoAdapter.INT32.encodeWithTag(dVar, 3, movieParams.fps);
            }
            if (movieParams.frames != null) {
                ProtoAdapter.INT32.encodeWithTag(dVar, 4, movieParams.frames);
            }
            dVar.b(movieParams.unknownFields());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public MovieParams decode(c cVar) throws IOException {
            Builder builder = new Builder();
            long dGm = cVar.dGm();
            while (true) {
                int dGn = cVar.dGn();
                if (dGn != -1) {
                    switch (dGn) {
                        case 1:
                            builder.viewBoxWidth(ProtoAdapter.FLOAT.decode(cVar));
                            break;
                        case 2:
                            builder.viewBoxHeight(ProtoAdapter.FLOAT.decode(cVar));
                            break;
                        case 3:
                            builder.fps(ProtoAdapter.INT32.decode(cVar));
                            break;
                        case 4:
                            builder.frames(ProtoAdapter.INT32.decode(cVar));
                            break;
                        default:
                            FieldEncoding dGo = cVar.dGo();
                            builder.addUnknownField(dGn, dGo, dGo.rawProtoAdapter().decode(cVar));
                            break;
                    }
                } else {
                    cVar.gZ(dGm);
                    return builder.build();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public MovieParams redact(MovieParams movieParams) {
            Message.a<MovieParams, Builder> newBuilder2 = movieParams.newBuilder2();
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }
}
