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
/* loaded from: classes6.dex */
public final class Layout extends Message<Layout, Builder> {
    private static final long serialVersionUID = 0;
    @WireField(eDO = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float height;
    @WireField(eDO = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float width;
    @WireField(eDO = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float x;
    @WireField(eDO = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float y;
    public static final ProtoAdapter<Layout> ADAPTER = new ProtoAdapter_Layout();
    public static final Float DEFAULT_X = Float.valueOf(0.0f);
    public static final Float DEFAULT_Y = Float.valueOf(0.0f);
    public static final Float DEFAULT_WIDTH = Float.valueOf(0.0f);
    public static final Float DEFAULT_HEIGHT = Float.valueOf(0.0f);

    public Layout(Float f, Float f2, Float f3, Float f4) {
        this(f, f2, f3, f4, ByteString.EMPTY);
    }

    public Layout(Float f, Float f2, Float f3, Float f4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
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

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Layout) {
            Layout layout = (Layout) obj;
            return unknownFields().equals(layout.unknownFields()) && a.equals(this.x, layout.x) && a.equals(this.y, layout.y) && a.equals(this.width, layout.width) && a.equals(this.height, layout.height);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = (((this.width != null ? this.width.hashCode() : 0) + (((this.y != null ? this.y.hashCode() : 0) + (((this.x != null ? this.x.hashCode() : 0) + (unknownFields().hashCode() * 37)) * 37)) * 37)) * 37) + (this.height != null ? this.height.hashCode() : 0);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.x != null) {
            sb.append(", x=").append(this.x);
        }
        if (this.y != null) {
            sb.append(", y=").append(this.y);
        }
        if (this.width != null) {
            sb.append(", width=").append(this.width);
        }
        if (this.height != null) {
            sb.append(", height=").append(this.height);
        }
        return sb.replace(0, 2, "Layout{").append('}').toString();
    }

    /* loaded from: classes6.dex */
    public static final class Builder extends Message.a<Layout, Builder> {
        public Float height;
        public Float width;
        public Float x;
        public Float y;

        public Builder x(Float f) {
            this.x = f;
            return this;
        }

        public Builder y(Float f) {
            this.y = f;
            return this;
        }

        public Builder width(Float f) {
            this.width = f;
            return this;
        }

        public Builder height(Float f) {
            this.height = f;
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
    private static final class ProtoAdapter_Layout extends ProtoAdapter<Layout> {
        ProtoAdapter_Layout() {
            super(FieldEncoding.LENGTH_DELIMITED, Layout.class);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(Layout layout) {
            return (layout.width != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, layout.width) : 0) + (layout.y != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, layout.y) : 0) + (layout.x != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, layout.x) : 0) + (layout.height != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, layout.height) : 0) + layout.unknownFields().size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, Layout layout) throws IOException {
            if (layout.x != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, layout.x);
            }
            if (layout.y != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, layout.y);
            }
            if (layout.width != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, layout.width);
            }
            if (layout.height != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 4, layout.height);
            }
            dVar.b(layout.unknownFields());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public Layout decode(c cVar) throws IOException {
            Builder builder = new Builder();
            long eDG = cVar.eDG();
            while (true) {
                int eDH = cVar.eDH();
                if (eDH != -1) {
                    switch (eDH) {
                        case 1:
                            builder.x(ProtoAdapter.FLOAT.decode(cVar));
                            break;
                        case 2:
                            builder.y(ProtoAdapter.FLOAT.decode(cVar));
                            break;
                        case 3:
                            builder.width(ProtoAdapter.FLOAT.decode(cVar));
                            break;
                        case 4:
                            builder.height(ProtoAdapter.FLOAT.decode(cVar));
                            break;
                        default:
                            FieldEncoding eDI = cVar.eDI();
                            builder.addUnknownField(eDH, eDI, eDI.rawProtoAdapter().decode(cVar));
                            break;
                    }
                } else {
                    cVar.iV(eDG);
                    return builder.build();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public Layout redact(Layout layout) {
            Message.a<Layout, Builder> newBuilder2 = layout.newBuilder2();
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }
}
