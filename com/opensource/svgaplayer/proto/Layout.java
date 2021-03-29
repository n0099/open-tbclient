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
/* loaded from: classes6.dex */
public final class Layout extends Message<Layout, Builder> {
    public static final ProtoAdapter<Layout> ADAPTER = new ProtoAdapter_Layout();
    public static final Float DEFAULT_HEIGHT;
    public static final Float DEFAULT_WIDTH;
    public static final Float DEFAULT_X;
    public static final Float DEFAULT_Y;
    public static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float height;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float width;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float x;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float y;

    /* loaded from: classes6.dex */
    public static final class Builder extends Message.a<Layout, Builder> {
        public Float height;
        public Float width;
        public Float x;
        public Float y;

        public Builder height(Float f2) {
            this.height = f2;
            return this;
        }

        public Builder width(Float f2) {
            this.width = f2;
            return this;
        }

        public Builder x(Float f2) {
            this.x = f2;
            return this;
        }

        public Builder y(Float f2) {
            this.y = f2;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public Layout build() {
            return new Layout(this.x, this.y, this.width, this.height, super.buildUnknownFields());
        }
    }

    /* loaded from: classes6.dex */
    public static final class ProtoAdapter_Layout extends ProtoAdapter<Layout> {
        public ProtoAdapter_Layout() {
            super(FieldEncoding.LENGTH_DELIMITED, Layout.class);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public Layout decode(c cVar) throws IOException {
            Builder builder = new Builder();
            long c2 = cVar.c();
            while (true) {
                int f2 = cVar.f();
                if (f2 == -1) {
                    cVar.d(c2);
                    return builder.build();
                } else if (f2 == 1) {
                    builder.x(ProtoAdapter.FLOAT.decode(cVar));
                } else if (f2 == 2) {
                    builder.y(ProtoAdapter.FLOAT.decode(cVar));
                } else if (f2 == 3) {
                    builder.width(ProtoAdapter.FLOAT.decode(cVar));
                } else if (f2 != 4) {
                    FieldEncoding g2 = cVar.g();
                    builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                } else {
                    builder.height(ProtoAdapter.FLOAT.decode(cVar));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, Layout layout) throws IOException {
            Float f2 = layout.x;
            if (f2 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, f2);
            }
            Float f3 = layout.y;
            if (f3 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, f3);
            }
            Float f4 = layout.width;
            if (f4 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, f4);
            }
            Float f5 = layout.height;
            if (f5 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 4, f5);
            }
            dVar.k(layout.unknownFields());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(Layout layout) {
            Float f2 = layout.x;
            int encodedSizeWithTag = f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f2) : 0;
            Float f3 = layout.y;
            int encodedSizeWithTag2 = encodedSizeWithTag + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f3) : 0);
            Float f4 = layout.width;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f4) : 0);
            Float f5 = layout.height;
            return encodedSizeWithTag3 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f5) : 0) + layout.unknownFields().size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public Layout redact(Layout layout) {
            Message.a<Layout, Builder> newBuilder2 = layout.newBuilder2();
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_X = valueOf;
        DEFAULT_Y = valueOf;
        DEFAULT_WIDTH = valueOf;
        DEFAULT_HEIGHT = valueOf;
    }

    public Layout(Float f2, Float f3, Float f4, Float f5) {
        this(f2, f3, f4, f5, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Layout) {
            Layout layout = (Layout) obj;
            return unknownFields().equals(layout.unknownFields()) && a.f(this.x, layout.x) && a.f(this.y, layout.y) && a.f(this.width, layout.width) && a.f(this.height, layout.height);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Float f2 = this.x;
            int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 37;
            Float f3 = this.y;
            int hashCode3 = (hashCode2 + (f3 != null ? f3.hashCode() : 0)) * 37;
            Float f4 = this.width;
            int hashCode4 = (hashCode3 + (f4 != null ? f4.hashCode() : 0)) * 37;
            Float f5 = this.height;
            int hashCode5 = hashCode4 + (f5 != null ? f5.hashCode() : 0);
            this.hashCode = hashCode5;
            return hashCode5;
        }
        return i;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
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

    public Layout(Float f2, Float f3, Float f4, Float f5, ByteString byteString) {
        super(ADAPTER, byteString);
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.Layout$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<Layout, Builder> newBuilder2() {
        Builder builder = new Builder();
        builder.x = this.x;
        builder.y = this.y;
        builder.width = this.width;
        builder.height = this.height;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
