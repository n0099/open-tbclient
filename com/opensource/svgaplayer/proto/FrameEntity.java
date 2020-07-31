package com.opensource.svgaplayer.proto;

import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.Message;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import com.squareup.wire2.c;
import com.squareup.wire2.d;
import com.squareup.wire2.internal.a;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
/* loaded from: classes8.dex */
public final class FrameEntity extends Message<FrameEntity, Builder> {
    public static final ProtoAdapter<FrameEntity> ADAPTER = new ProtoAdapter_FrameEntity();
    public static final Float DEFAULT_ALPHA = Float.valueOf(0.0f);
    public static final String DEFAULT_CLIPPATH = "";
    private static final long serialVersionUID = 0;
    @WireField(dQJ = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float alpha;
    @WireField(dQJ = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String clipPath;
    @WireField(dQJ = "com.opensource.svgaplayer.proto.Layout#ADAPTER", tag = 2)
    public final Layout layout;
    @WireField(dQJ = "com.opensource.svgaplayer.proto.ShapeEntity#ADAPTER", dQK = WireField.Label.REPEATED, tag = 5)
    public final List<ShapeEntity> shapes;
    @WireField(dQJ = "com.opensource.svgaplayer.proto.Transform#ADAPTER", tag = 3)
    public final Transform transform;

    public FrameEntity(Float f, Layout layout, Transform transform, String str, List<ShapeEntity> list) {
        this(f, layout, transform, str, list, ByteString.EMPTY);
    }

    public FrameEntity(Float f, Layout layout, Transform transform, String str, List<ShapeEntity> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.alpha = f;
        this.layout = layout;
        this.transform = transform;
        this.clipPath = str;
        this.shapes = a.v("shapes", list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.FrameEntity$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<FrameEntity, Builder> newBuilder2() {
        Builder builder = new Builder();
        builder.alpha = this.alpha;
        builder.layout = this.layout;
        builder.transform = this.transform;
        builder.clipPath = this.clipPath;
        builder.shapes = a.u("shapes", this.shapes);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FrameEntity) {
            FrameEntity frameEntity = (FrameEntity) obj;
            return unknownFields().equals(frameEntity.unknownFields()) && a.equals(this.alpha, frameEntity.alpha) && a.equals(this.layout, frameEntity.layout) && a.equals(this.transform, frameEntity.transform) && a.equals(this.clipPath, frameEntity.clipPath) && this.shapes.equals(frameEntity.shapes);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = (((((this.transform != null ? this.transform.hashCode() : 0) + (((this.layout != null ? this.layout.hashCode() : 0) + (((this.alpha != null ? this.alpha.hashCode() : 0) + (unknownFields().hashCode() * 37)) * 37)) * 37)) * 37) + (this.clipPath != null ? this.clipPath.hashCode() : 0)) * 37) + this.shapes.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.alpha != null) {
            sb.append(", alpha=").append(this.alpha);
        }
        if (this.layout != null) {
            sb.append(", layout=").append(this.layout);
        }
        if (this.transform != null) {
            sb.append(", transform=").append(this.transform);
        }
        if (this.clipPath != null) {
            sb.append(", clipPath=").append(this.clipPath);
        }
        if (!this.shapes.isEmpty()) {
            sb.append(", shapes=").append(this.shapes);
        }
        return sb.replace(0, 2, "FrameEntity{").append('}').toString();
    }

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.a<FrameEntity, Builder> {
        public Float alpha;
        public String clipPath;
        public Layout layout;
        public List<ShapeEntity> shapes = a.dQM();
        public Transform transform;

        public Builder alpha(Float f) {
            this.alpha = f;
            return this;
        }

        public Builder layout(Layout layout) {
            this.layout = layout;
            return this;
        }

        public Builder transform(Transform transform) {
            this.transform = transform;
            return this;
        }

        public Builder clipPath(String str) {
            this.clipPath = str;
            return this;
        }

        public Builder shapes(List<ShapeEntity> list) {
            a.fI(list);
            this.shapes = list;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public FrameEntity build() {
            return new FrameEntity(this.alpha, this.layout, this.transform, this.clipPath, this.shapes, super.buildUnknownFields());
        }
    }

    /* loaded from: classes8.dex */
    private static final class ProtoAdapter_FrameEntity extends ProtoAdapter<FrameEntity> {
        ProtoAdapter_FrameEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, FrameEntity.class);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(FrameEntity frameEntity) {
            return (frameEntity.transform != null ? Transform.ADAPTER.encodedSizeWithTag(3, frameEntity.transform) : 0) + (frameEntity.layout != null ? Layout.ADAPTER.encodedSizeWithTag(2, frameEntity.layout) : 0) + (frameEntity.alpha != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, frameEntity.alpha) : 0) + (frameEntity.clipPath != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, frameEntity.clipPath) : 0) + ShapeEntity.ADAPTER.asRepeated().encodedSizeWithTag(5, frameEntity.shapes) + frameEntity.unknownFields().size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, FrameEntity frameEntity) throws IOException {
            if (frameEntity.alpha != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, frameEntity.alpha);
            }
            if (frameEntity.layout != null) {
                Layout.ADAPTER.encodeWithTag(dVar, 2, frameEntity.layout);
            }
            if (frameEntity.transform != null) {
                Transform.ADAPTER.encodeWithTag(dVar, 3, frameEntity.transform);
            }
            if (frameEntity.clipPath != null) {
                ProtoAdapter.STRING.encodeWithTag(dVar, 4, frameEntity.clipPath);
            }
            ShapeEntity.ADAPTER.asRepeated().encodeWithTag(dVar, 5, frameEntity.shapes);
            dVar.b(frameEntity.unknownFields());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public FrameEntity decode(c cVar) throws IOException {
            Builder builder = new Builder();
            long dQB = cVar.dQB();
            while (true) {
                int dQC = cVar.dQC();
                if (dQC != -1) {
                    switch (dQC) {
                        case 1:
                            builder.alpha(ProtoAdapter.FLOAT.decode(cVar));
                            break;
                        case 2:
                            builder.layout(Layout.ADAPTER.decode(cVar));
                            break;
                        case 3:
                            builder.transform(Transform.ADAPTER.decode(cVar));
                            break;
                        case 4:
                            builder.clipPath(ProtoAdapter.STRING.decode(cVar));
                            break;
                        case 5:
                            builder.shapes.add(ShapeEntity.ADAPTER.decode(cVar));
                            break;
                        default:
                            FieldEncoding dQD = cVar.dQD();
                            builder.addUnknownField(dQC, dQD, dQD.rawProtoAdapter().decode(cVar));
                            break;
                    }
                } else {
                    cVar.gu(dQB);
                    return builder.build();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.opensource.svgaplayer.proto.FrameEntity$Builder] */
        @Override // com.squareup.wire2.ProtoAdapter
        public FrameEntity redact(FrameEntity frameEntity) {
            ?? newBuilder2 = frameEntity.newBuilder2();
            if (newBuilder2.layout != null) {
                newBuilder2.layout = Layout.ADAPTER.redact(newBuilder2.layout);
            }
            if (newBuilder2.transform != null) {
                newBuilder2.transform = Transform.ADAPTER.redact(newBuilder2.transform);
            }
            a.a(newBuilder2.shapes, ShapeEntity.ADAPTER);
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }
}
