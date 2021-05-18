package com.opensource.svgaplayer.proto;

import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.Message;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import d.n.a.c;
import d.n.a.d;
import d.n.a.g;
import d.n.a.h.a;
import java.io.IOException;
import okio.ByteString;
/* loaded from: classes6.dex */
public final class ShapeEntity extends Message<ShapeEntity, Builder> {
    public static final ProtoAdapter<ShapeEntity> ADAPTER = new ProtoAdapter_ShapeEntity();
    public static final ShapeType DEFAULT_TYPE = ShapeType.SHAPE;
    public static final long serialVersionUID = 0;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$EllipseArgs#ADAPTER", tag = 4)
    public final EllipseArgs ellipse;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$RectArgs#ADAPTER", tag = 3)
    public final RectArgs rect;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeArgs#ADAPTER", tag = 2)
    public final ShapeArgs shape;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle#ADAPTER", tag = 10)
    public final ShapeStyle styles;
    @WireField(adapter = "com.opensource.svgaplayer.proto.Transform#ADAPTER", tag = 11)
    public final Transform transform;
    @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeType#ADAPTER", tag = 1)
    public final ShapeType type;

    /* loaded from: classes6.dex */
    public static final class Builder extends Message.a<ShapeEntity, Builder> {
        public EllipseArgs ellipse;
        public RectArgs rect;
        public ShapeArgs shape;
        public ShapeStyle styles;
        public Transform transform;
        public ShapeType type;

        public Builder ellipse(EllipseArgs ellipseArgs) {
            this.ellipse = ellipseArgs;
            this.shape = null;
            this.rect = null;
            return this;
        }

        public Builder rect(RectArgs rectArgs) {
            this.rect = rectArgs;
            this.shape = null;
            this.ellipse = null;
            return this;
        }

        public Builder shape(ShapeArgs shapeArgs) {
            this.shape = shapeArgs;
            this.rect = null;
            this.ellipse = null;
            return this;
        }

        public Builder styles(ShapeStyle shapeStyle) {
            this.styles = shapeStyle;
            return this;
        }

        public Builder transform(Transform transform) {
            this.transform = transform;
            return this;
        }

        public Builder type(ShapeType shapeType) {
            this.type = shapeType;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public ShapeEntity build() {
            return new ShapeEntity(this.type, this.styles, this.transform, this.shape, this.rect, this.ellipse, super.buildUnknownFields());
        }
    }

    /* loaded from: classes6.dex */
    public static final class EllipseArgs extends Message<EllipseArgs, Builder> {
        public static final ProtoAdapter<EllipseArgs> ADAPTER = new ProtoAdapter_EllipseArgs();
        public static final Float DEFAULT_RADIUSX;
        public static final Float DEFAULT_RADIUSY;
        public static final Float DEFAULT_X;
        public static final Float DEFAULT_Y;
        public static final long serialVersionUID = 0;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float radiusX;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
        public final Float radiusY;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
        public final Float x;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
        public final Float y;

        /* loaded from: classes6.dex */
        public static final class Builder extends Message.a<EllipseArgs, Builder> {
            public Float radiusX;
            public Float radiusY;
            public Float x;
            public Float y;

            public Builder radiusX(Float f2) {
                this.radiusX = f2;
                return this;
            }

            public Builder radiusY(Float f2) {
                this.radiusY = f2;
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
            public EllipseArgs build() {
                return new EllipseArgs(this.x, this.y, this.radiusX, this.radiusY, super.buildUnknownFields());
            }
        }

        /* loaded from: classes6.dex */
        public static final class ProtoAdapter_EllipseArgs extends ProtoAdapter<EllipseArgs> {
            public ProtoAdapter_EllipseArgs() {
                super(FieldEncoding.LENGTH_DELIMITED, EllipseArgs.class);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.ProtoAdapter
            public EllipseArgs decode(c cVar) throws IOException {
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
                        builder.radiusX(ProtoAdapter.FLOAT.decode(cVar));
                    } else if (f2 != 4) {
                        FieldEncoding g2 = cVar.g();
                        builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                    } else {
                        builder.radiusY(ProtoAdapter.FLOAT.decode(cVar));
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(d dVar, EllipseArgs ellipseArgs) throws IOException {
                Float f2 = ellipseArgs.x;
                if (f2 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, f2);
                }
                Float f3 = ellipseArgs.y;
                if (f3 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, f3);
                }
                Float f4 = ellipseArgs.radiusX;
                if (f4 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, f4);
                }
                Float f5 = ellipseArgs.radiusY;
                if (f5 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 4, f5);
                }
                dVar.k(ellipseArgs.unknownFields());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(EllipseArgs ellipseArgs) {
                Float f2 = ellipseArgs.x;
                int encodedSizeWithTag = f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f2) : 0;
                Float f3 = ellipseArgs.y;
                int encodedSizeWithTag2 = encodedSizeWithTag + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f3) : 0);
                Float f4 = ellipseArgs.radiusX;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f4) : 0);
                Float f5 = ellipseArgs.radiusY;
                return encodedSizeWithTag3 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f5) : 0) + ellipseArgs.unknownFields().size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public EllipseArgs redact(EllipseArgs ellipseArgs) {
                Message.a<EllipseArgs, Builder> newBuilder2 = ellipseArgs.newBuilder2();
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
        }

        static {
            Float valueOf = Float.valueOf(0.0f);
            DEFAULT_X = valueOf;
            DEFAULT_Y = valueOf;
            DEFAULT_RADIUSX = valueOf;
            DEFAULT_RADIUSY = valueOf;
        }

        public EllipseArgs(Float f2, Float f3, Float f4, Float f5) {
            this(f2, f3, f4, f5, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof EllipseArgs) {
                EllipseArgs ellipseArgs = (EllipseArgs) obj;
                return unknownFields().equals(ellipseArgs.unknownFields()) && a.f(this.x, ellipseArgs.x) && a.f(this.y, ellipseArgs.y) && a.f(this.radiusX, ellipseArgs.radiusX) && a.f(this.radiusY, ellipseArgs.radiusY);
            }
            return false;
        }

        public int hashCode() {
            int i2 = this.hashCode;
            if (i2 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                Float f2 = this.x;
                int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 37;
                Float f3 = this.y;
                int hashCode3 = (hashCode2 + (f3 != null ? f3.hashCode() : 0)) * 37;
                Float f4 = this.radiusX;
                int hashCode4 = (hashCode3 + (f4 != null ? f4.hashCode() : 0)) * 37;
                Float f5 = this.radiusY;
                int hashCode5 = hashCode4 + (f5 != null ? f5.hashCode() : 0);
                this.hashCode = hashCode5;
                return hashCode5;
            }
            return i2;
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
            if (this.radiusX != null) {
                sb.append(", radiusX=");
                sb.append(this.radiusX);
            }
            if (this.radiusY != null) {
                sb.append(", radiusY=");
                sb.append(this.radiusY);
            }
            StringBuilder replace = sb.replace(0, 2, "EllipseArgs{");
            replace.append('}');
            return replace.toString();
        }

        public EllipseArgs(Float f2, Float f3, Float f4, Float f5, ByteString byteString) {
            super(ADAPTER, byteString);
            this.x = f2;
            this.y = f3;
            this.radiusX = f4;
            this.radiusY = f5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.ShapeEntity$EllipseArgs$Builder' to match base method */
        @Override // com.squareup.wire2.Message
        /* renamed from: newBuilder */
        public Message.a<EllipseArgs, Builder> newBuilder2() {
            Builder builder = new Builder();
            builder.x = this.x;
            builder.y = this.y;
            builder.radiusX = this.radiusX;
            builder.radiusY = this.radiusY;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    /* loaded from: classes6.dex */
    public static final class ProtoAdapter_ShapeEntity extends ProtoAdapter<ShapeEntity> {
        public ProtoAdapter_ShapeEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, ShapeEntity.class);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public ShapeEntity decode(c cVar) throws IOException {
            Builder builder = new Builder();
            long c2 = cVar.c();
            while (true) {
                int f2 = cVar.f();
                if (f2 == -1) {
                    cVar.d(c2);
                    return builder.build();
                } else if (f2 == 1) {
                    try {
                        builder.type(ShapeType.ADAPTER.decode(cVar));
                    } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                        builder.addUnknownField(f2, FieldEncoding.VARINT, Long.valueOf(e2.value));
                    }
                } else if (f2 == 2) {
                    builder.shape(ShapeArgs.ADAPTER.decode(cVar));
                } else if (f2 == 3) {
                    builder.rect(RectArgs.ADAPTER.decode(cVar));
                } else if (f2 == 4) {
                    builder.ellipse(EllipseArgs.ADAPTER.decode(cVar));
                } else if (f2 == 10) {
                    builder.styles(ShapeStyle.ADAPTER.decode(cVar));
                } else if (f2 != 11) {
                    FieldEncoding g2 = cVar.g();
                    builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                } else {
                    builder.transform(Transform.ADAPTER.decode(cVar));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, ShapeEntity shapeEntity) throws IOException {
            ShapeType shapeType = shapeEntity.type;
            if (shapeType != null) {
                ShapeType.ADAPTER.encodeWithTag(dVar, 1, shapeType);
            }
            ShapeStyle shapeStyle = shapeEntity.styles;
            if (shapeStyle != null) {
                ShapeStyle.ADAPTER.encodeWithTag(dVar, 10, shapeStyle);
            }
            Transform transform = shapeEntity.transform;
            if (transform != null) {
                Transform.ADAPTER.encodeWithTag(dVar, 11, transform);
            }
            ShapeArgs shapeArgs = shapeEntity.shape;
            if (shapeArgs != null) {
                ShapeArgs.ADAPTER.encodeWithTag(dVar, 2, shapeArgs);
            }
            RectArgs rectArgs = shapeEntity.rect;
            if (rectArgs != null) {
                RectArgs.ADAPTER.encodeWithTag(dVar, 3, rectArgs);
            }
            EllipseArgs ellipseArgs = shapeEntity.ellipse;
            if (ellipseArgs != null) {
                EllipseArgs.ADAPTER.encodeWithTag(dVar, 4, ellipseArgs);
            }
            dVar.k(shapeEntity.unknownFields());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(ShapeEntity shapeEntity) {
            ShapeType shapeType = shapeEntity.type;
            int encodedSizeWithTag = shapeType != null ? ShapeType.ADAPTER.encodedSizeWithTag(1, shapeType) : 0;
            ShapeStyle shapeStyle = shapeEntity.styles;
            int encodedSizeWithTag2 = encodedSizeWithTag + (shapeStyle != null ? ShapeStyle.ADAPTER.encodedSizeWithTag(10, shapeStyle) : 0);
            Transform transform = shapeEntity.transform;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (transform != null ? Transform.ADAPTER.encodedSizeWithTag(11, transform) : 0);
            ShapeArgs shapeArgs = shapeEntity.shape;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (shapeArgs != null ? ShapeArgs.ADAPTER.encodedSizeWithTag(2, shapeArgs) : 0);
            RectArgs rectArgs = shapeEntity.rect;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (rectArgs != null ? RectArgs.ADAPTER.encodedSizeWithTag(3, rectArgs) : 0);
            EllipseArgs ellipseArgs = shapeEntity.ellipse;
            return encodedSizeWithTag5 + (ellipseArgs != null ? EllipseArgs.ADAPTER.encodedSizeWithTag(4, ellipseArgs) : 0) + shapeEntity.unknownFields().size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r3v1, types: [com.squareup.wire2.Message$a, com.opensource.svgaplayer.proto.ShapeEntity$Builder] */
        @Override // com.squareup.wire2.ProtoAdapter
        public ShapeEntity redact(ShapeEntity shapeEntity) {
            ?? newBuilder2 = shapeEntity.newBuilder2();
            ShapeStyle shapeStyle = newBuilder2.styles;
            if (shapeStyle != null) {
                newBuilder2.styles = ShapeStyle.ADAPTER.redact(shapeStyle);
            }
            Transform transform = newBuilder2.transform;
            if (transform != null) {
                newBuilder2.transform = Transform.ADAPTER.redact(transform);
            }
            ShapeArgs shapeArgs = newBuilder2.shape;
            if (shapeArgs != null) {
                newBuilder2.shape = ShapeArgs.ADAPTER.redact(shapeArgs);
            }
            RectArgs rectArgs = newBuilder2.rect;
            if (rectArgs != null) {
                newBuilder2.rect = RectArgs.ADAPTER.redact(rectArgs);
            }
            EllipseArgs ellipseArgs = newBuilder2.ellipse;
            if (ellipseArgs != null) {
                newBuilder2.ellipse = EllipseArgs.ADAPTER.redact(ellipseArgs);
            }
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }

    /* loaded from: classes6.dex */
    public static final class RectArgs extends Message<RectArgs, Builder> {
        public static final ProtoAdapter<RectArgs> ADAPTER = new ProtoAdapter_RectArgs();
        public static final Float DEFAULT_CORNERRADIUS;
        public static final Float DEFAULT_HEIGHT;
        public static final Float DEFAULT_WIDTH;
        public static final Float DEFAULT_X;
        public static final Float DEFAULT_Y;
        public static final long serialVersionUID = 0;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
        public final Float cornerRadius;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
        public final Float height;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float width;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
        public final Float x;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
        public final Float y;

        /* loaded from: classes6.dex */
        public static final class Builder extends Message.a<RectArgs, Builder> {
            public Float cornerRadius;
            public Float height;
            public Float width;
            public Float x;
            public Float y;

            public Builder cornerRadius(Float f2) {
                this.cornerRadius = f2;
                return this;
            }

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
            public RectArgs build() {
                return new RectArgs(this.x, this.y, this.width, this.height, this.cornerRadius, super.buildUnknownFields());
            }
        }

        /* loaded from: classes6.dex */
        public static final class ProtoAdapter_RectArgs extends ProtoAdapter<RectArgs> {
            public ProtoAdapter_RectArgs() {
                super(FieldEncoding.LENGTH_DELIMITED, RectArgs.class);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.ProtoAdapter
            public RectArgs decode(c cVar) throws IOException {
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
                    } else if (f2 == 4) {
                        builder.height(ProtoAdapter.FLOAT.decode(cVar));
                    } else if (f2 != 5) {
                        FieldEncoding g2 = cVar.g();
                        builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                    } else {
                        builder.cornerRadius(ProtoAdapter.FLOAT.decode(cVar));
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(d dVar, RectArgs rectArgs) throws IOException {
                Float f2 = rectArgs.x;
                if (f2 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, f2);
                }
                Float f3 = rectArgs.y;
                if (f3 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, f3);
                }
                Float f4 = rectArgs.width;
                if (f4 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, f4);
                }
                Float f5 = rectArgs.height;
                if (f5 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 4, f5);
                }
                Float f6 = rectArgs.cornerRadius;
                if (f6 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 5, f6);
                }
                dVar.k(rectArgs.unknownFields());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(RectArgs rectArgs) {
                Float f2 = rectArgs.x;
                int encodedSizeWithTag = f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f2) : 0;
                Float f3 = rectArgs.y;
                int encodedSizeWithTag2 = encodedSizeWithTag + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f3) : 0);
                Float f4 = rectArgs.width;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f4) : 0);
                Float f5 = rectArgs.height;
                int encodedSizeWithTag4 = encodedSizeWithTag3 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f5) : 0);
                Float f6 = rectArgs.cornerRadius;
                return encodedSizeWithTag4 + (f6 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(5, f6) : 0) + rectArgs.unknownFields().size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public RectArgs redact(RectArgs rectArgs) {
                Message.a<RectArgs, Builder> newBuilder2 = rectArgs.newBuilder2();
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
            DEFAULT_CORNERRADIUS = valueOf;
        }

        public RectArgs(Float f2, Float f3, Float f4, Float f5, Float f6) {
            this(f2, f3, f4, f5, f6, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof RectArgs) {
                RectArgs rectArgs = (RectArgs) obj;
                return unknownFields().equals(rectArgs.unknownFields()) && a.f(this.x, rectArgs.x) && a.f(this.y, rectArgs.y) && a.f(this.width, rectArgs.width) && a.f(this.height, rectArgs.height) && a.f(this.cornerRadius, rectArgs.cornerRadius);
            }
            return false;
        }

        public int hashCode() {
            int i2 = this.hashCode;
            if (i2 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                Float f2 = this.x;
                int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 37;
                Float f3 = this.y;
                int hashCode3 = (hashCode2 + (f3 != null ? f3.hashCode() : 0)) * 37;
                Float f4 = this.width;
                int hashCode4 = (hashCode3 + (f4 != null ? f4.hashCode() : 0)) * 37;
                Float f5 = this.height;
                int hashCode5 = (hashCode4 + (f5 != null ? f5.hashCode() : 0)) * 37;
                Float f6 = this.cornerRadius;
                int hashCode6 = hashCode5 + (f6 != null ? f6.hashCode() : 0);
                this.hashCode = hashCode6;
                return hashCode6;
            }
            return i2;
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
            if (this.cornerRadius != null) {
                sb.append(", cornerRadius=");
                sb.append(this.cornerRadius);
            }
            StringBuilder replace = sb.replace(0, 2, "RectArgs{");
            replace.append('}');
            return replace.toString();
        }

        public RectArgs(Float f2, Float f3, Float f4, Float f5, Float f6, ByteString byteString) {
            super(ADAPTER, byteString);
            this.x = f2;
            this.y = f3;
            this.width = f4;
            this.height = f5;
            this.cornerRadius = f6;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.ShapeEntity$RectArgs$Builder' to match base method */
        @Override // com.squareup.wire2.Message
        /* renamed from: newBuilder */
        public Message.a<RectArgs, Builder> newBuilder2() {
            Builder builder = new Builder();
            builder.x = this.x;
            builder.y = this.y;
            builder.width = this.width;
            builder.height = this.height;
            builder.cornerRadius = this.cornerRadius;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    /* loaded from: classes6.dex */
    public static final class ShapeArgs extends Message<ShapeArgs, Builder> {
        public static final ProtoAdapter<ShapeArgs> ADAPTER = new ProtoAdapter_ShapeArgs();
        public static final String DEFAULT_D = "";
        public static final long serialVersionUID = 0;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)

        /* renamed from: d  reason: collision with root package name */
        public final String f35170d;

        /* loaded from: classes6.dex */
        public static final class Builder extends Message.a<ShapeArgs, Builder> {

            /* renamed from: d  reason: collision with root package name */
            public String f35171d;

            public Builder d(String str) {
                this.f35171d = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.Message.a
            public ShapeArgs build() {
                return new ShapeArgs(this.f35171d, super.buildUnknownFields());
            }
        }

        /* loaded from: classes6.dex */
        public static final class ProtoAdapter_ShapeArgs extends ProtoAdapter<ShapeArgs> {
            public ProtoAdapter_ShapeArgs() {
                super(FieldEncoding.LENGTH_DELIMITED, ShapeArgs.class);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.ProtoAdapter
            public ShapeArgs decode(c cVar) throws IOException {
                Builder builder = new Builder();
                long c2 = cVar.c();
                while (true) {
                    int f2 = cVar.f();
                    if (f2 == -1) {
                        cVar.d(c2);
                        return builder.build();
                    } else if (f2 != 1) {
                        FieldEncoding g2 = cVar.g();
                        builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                    } else {
                        builder.d(ProtoAdapter.STRING.decode(cVar));
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(d dVar, ShapeArgs shapeArgs) throws IOException {
                String str = shapeArgs.f35170d;
                if (str != null) {
                    ProtoAdapter.STRING.encodeWithTag(dVar, 1, str);
                }
                dVar.k(shapeArgs.unknownFields());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(ShapeArgs shapeArgs) {
                String str = shapeArgs.f35170d;
                return (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0) + shapeArgs.unknownFields().size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public ShapeArgs redact(ShapeArgs shapeArgs) {
                Message.a<ShapeArgs, Builder> newBuilder2 = shapeArgs.newBuilder2();
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
        }

        public ShapeArgs(String str) {
            this(str, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ShapeArgs) {
                ShapeArgs shapeArgs = (ShapeArgs) obj;
                return unknownFields().equals(shapeArgs.unknownFields()) && a.f(this.f35170d, shapeArgs.f35170d);
            }
            return false;
        }

        public int hashCode() {
            int i2 = this.hashCode;
            if (i2 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                String str = this.f35170d;
                int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
                this.hashCode = hashCode2;
                return hashCode2;
            }
            return i2;
        }

        @Override // com.squareup.wire2.Message
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f35170d != null) {
                sb.append(", d=");
                sb.append(this.f35170d);
            }
            StringBuilder replace = sb.replace(0, 2, "ShapeArgs{");
            replace.append('}');
            return replace.toString();
        }

        public ShapeArgs(String str, ByteString byteString) {
            super(ADAPTER, byteString);
            this.f35170d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.ShapeEntity$ShapeArgs$Builder' to match base method */
        @Override // com.squareup.wire2.Message
        /* renamed from: newBuilder */
        public Message.a<ShapeArgs, Builder> newBuilder2() {
            Builder builder = new Builder();
            builder.f35171d = this.f35170d;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    /* loaded from: classes6.dex */
    public static final class ShapeStyle extends Message<ShapeStyle, Builder> {
        public static final ProtoAdapter<ShapeStyle> ADAPTER = new ProtoAdapter_ShapeStyle();
        public static final LineCap DEFAULT_LINECAP;
        public static final Float DEFAULT_LINEDASHI;
        public static final Float DEFAULT_LINEDASHII;
        public static final Float DEFAULT_LINEDASHIII;
        public static final LineJoin DEFAULT_LINEJOIN;
        public static final Float DEFAULT_MITERLIMIT;
        public static final Float DEFAULT_STROKEWIDTH;
        public static final long serialVersionUID = 0;
        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor#ADAPTER", tag = 1)
        public final RGBAColor fill;
        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$LineCap#ADAPTER", tag = 4)
        public final LineCap lineCap;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 7)
        public final Float lineDashI;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 8)
        public final Float lineDashII;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 9)
        public final Float lineDashIII;
        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$LineJoin#ADAPTER", tag = 5)
        public final LineJoin lineJoin;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
        public final Float miterLimit;
        @WireField(adapter = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor#ADAPTER", tag = 2)
        public final RGBAColor stroke;
        @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float strokeWidth;

        /* loaded from: classes6.dex */
        public static final class Builder extends Message.a<ShapeStyle, Builder> {
            public RGBAColor fill;
            public LineCap lineCap;
            public Float lineDashI;
            public Float lineDashII;
            public Float lineDashIII;
            public LineJoin lineJoin;
            public Float miterLimit;
            public RGBAColor stroke;
            public Float strokeWidth;

            public Builder fill(RGBAColor rGBAColor) {
                this.fill = rGBAColor;
                return this;
            }

            public Builder lineCap(LineCap lineCap) {
                this.lineCap = lineCap;
                return this;
            }

            public Builder lineDashI(Float f2) {
                this.lineDashI = f2;
                return this;
            }

            public Builder lineDashII(Float f2) {
                this.lineDashII = f2;
                return this;
            }

            public Builder lineDashIII(Float f2) {
                this.lineDashIII = f2;
                return this;
            }

            public Builder lineJoin(LineJoin lineJoin) {
                this.lineJoin = lineJoin;
                return this;
            }

            public Builder miterLimit(Float f2) {
                this.miterLimit = f2;
                return this;
            }

            public Builder stroke(RGBAColor rGBAColor) {
                this.stroke = rGBAColor;
                return this;
            }

            public Builder strokeWidth(Float f2) {
                this.strokeWidth = f2;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.Message.a
            public ShapeStyle build() {
                return new ShapeStyle(this.fill, this.stroke, this.strokeWidth, this.lineCap, this.lineJoin, this.miterLimit, this.lineDashI, this.lineDashII, this.lineDashIII, super.buildUnknownFields());
            }
        }

        /* loaded from: classes6.dex */
        public enum LineCap implements g {
            LineCap_BUTT(0),
            LineCap_ROUND(1),
            LineCap_SQUARE(2);
            
            public static final ProtoAdapter<LineCap> ADAPTER = ProtoAdapter.newEnumAdapter(LineCap.class);
            public final int value;

            LineCap(int i2) {
                this.value = i2;
            }

            public static LineCap fromValue(int i2) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return null;
                        }
                        return LineCap_SQUARE;
                    }
                    return LineCap_ROUND;
                }
                return LineCap_BUTT;
            }

            @Override // d.n.a.g
            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: classes6.dex */
        public enum LineJoin implements g {
            LineJoin_MITER(0),
            LineJoin_ROUND(1),
            LineJoin_BEVEL(2);
            
            public static final ProtoAdapter<LineJoin> ADAPTER = ProtoAdapter.newEnumAdapter(LineJoin.class);
            public final int value;

            LineJoin(int i2) {
                this.value = i2;
            }

            public static LineJoin fromValue(int i2) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            return null;
                        }
                        return LineJoin_BEVEL;
                    }
                    return LineJoin_ROUND;
                }
                return LineJoin_MITER;
            }

            @Override // d.n.a.g
            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: classes6.dex */
        public static final class ProtoAdapter_ShapeStyle extends ProtoAdapter<ShapeStyle> {
            public ProtoAdapter_ShapeStyle() {
                super(FieldEncoding.LENGTH_DELIMITED, ShapeStyle.class);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.ProtoAdapter
            public ShapeStyle decode(c cVar) throws IOException {
                Builder builder = new Builder();
                long c2 = cVar.c();
                while (true) {
                    int f2 = cVar.f();
                    if (f2 != -1) {
                        switch (f2) {
                            case 1:
                                builder.fill(RGBAColor.ADAPTER.decode(cVar));
                                break;
                            case 2:
                                builder.stroke(RGBAColor.ADAPTER.decode(cVar));
                                break;
                            case 3:
                                builder.strokeWidth(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            case 4:
                                try {
                                    builder.lineCap(LineCap.ADAPTER.decode(cVar));
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                    builder.addUnknownField(f2, FieldEncoding.VARINT, Long.valueOf(e2.value));
                                    break;
                                }
                            case 5:
                                try {
                                    builder.lineJoin(LineJoin.ADAPTER.decode(cVar));
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e3) {
                                    builder.addUnknownField(f2, FieldEncoding.VARINT, Long.valueOf(e3.value));
                                    break;
                                }
                            case 6:
                                builder.miterLimit(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            case 7:
                                builder.lineDashI(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            case 8:
                                builder.lineDashII(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            case 9:
                                builder.lineDashIII(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            default:
                                FieldEncoding g2 = cVar.g();
                                builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                                break;
                        }
                    } else {
                        cVar.d(c2);
                        return builder.build();
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(d dVar, ShapeStyle shapeStyle) throws IOException {
                RGBAColor rGBAColor = shapeStyle.fill;
                if (rGBAColor != null) {
                    RGBAColor.ADAPTER.encodeWithTag(dVar, 1, rGBAColor);
                }
                RGBAColor rGBAColor2 = shapeStyle.stroke;
                if (rGBAColor2 != null) {
                    RGBAColor.ADAPTER.encodeWithTag(dVar, 2, rGBAColor2);
                }
                Float f2 = shapeStyle.strokeWidth;
                if (f2 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, f2);
                }
                LineCap lineCap = shapeStyle.lineCap;
                if (lineCap != null) {
                    LineCap.ADAPTER.encodeWithTag(dVar, 4, lineCap);
                }
                LineJoin lineJoin = shapeStyle.lineJoin;
                if (lineJoin != null) {
                    LineJoin.ADAPTER.encodeWithTag(dVar, 5, lineJoin);
                }
                Float f3 = shapeStyle.miterLimit;
                if (f3 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 6, f3);
                }
                Float f4 = shapeStyle.lineDashI;
                if (f4 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 7, f4);
                }
                Float f5 = shapeStyle.lineDashII;
                if (f5 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 8, f5);
                }
                Float f6 = shapeStyle.lineDashIII;
                if (f6 != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 9, f6);
                }
                dVar.k(shapeStyle.unknownFields());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(ShapeStyle shapeStyle) {
                RGBAColor rGBAColor = shapeStyle.fill;
                int encodedSizeWithTag = rGBAColor != null ? RGBAColor.ADAPTER.encodedSizeWithTag(1, rGBAColor) : 0;
                RGBAColor rGBAColor2 = shapeStyle.stroke;
                int encodedSizeWithTag2 = encodedSizeWithTag + (rGBAColor2 != null ? RGBAColor.ADAPTER.encodedSizeWithTag(2, rGBAColor2) : 0);
                Float f2 = shapeStyle.strokeWidth;
                int encodedSizeWithTag3 = encodedSizeWithTag2 + (f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f2) : 0);
                LineCap lineCap = shapeStyle.lineCap;
                int encodedSizeWithTag4 = encodedSizeWithTag3 + (lineCap != null ? LineCap.ADAPTER.encodedSizeWithTag(4, lineCap) : 0);
                LineJoin lineJoin = shapeStyle.lineJoin;
                int encodedSizeWithTag5 = encodedSizeWithTag4 + (lineJoin != null ? LineJoin.ADAPTER.encodedSizeWithTag(5, lineJoin) : 0);
                Float f3 = shapeStyle.miterLimit;
                int encodedSizeWithTag6 = encodedSizeWithTag5 + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(6, f3) : 0);
                Float f4 = shapeStyle.lineDashI;
                int encodedSizeWithTag7 = encodedSizeWithTag6 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(7, f4) : 0);
                Float f5 = shapeStyle.lineDashII;
                int encodedSizeWithTag8 = encodedSizeWithTag7 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(8, f5) : 0);
                Float f6 = shapeStyle.lineDashIII;
                return encodedSizeWithTag8 + (f6 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(9, f6) : 0) + shapeStyle.unknownFields().size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Type inference failed for: r3v1, types: [com.squareup.wire2.Message$a, com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$Builder] */
            @Override // com.squareup.wire2.ProtoAdapter
            public ShapeStyle redact(ShapeStyle shapeStyle) {
                ?? newBuilder2 = shapeStyle.newBuilder2();
                RGBAColor rGBAColor = newBuilder2.fill;
                if (rGBAColor != null) {
                    newBuilder2.fill = RGBAColor.ADAPTER.redact(rGBAColor);
                }
                RGBAColor rGBAColor2 = newBuilder2.stroke;
                if (rGBAColor2 != null) {
                    newBuilder2.stroke = RGBAColor.ADAPTER.redact(rGBAColor2);
                }
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
        }

        /* loaded from: classes6.dex */
        public static final class RGBAColor extends Message<RGBAColor, Builder> {
            public static final ProtoAdapter<RGBAColor> ADAPTER = new ProtoAdapter_RGBAColor();
            public static final Float DEFAULT_A;
            public static final Float DEFAULT_B;
            public static final Float DEFAULT_G;
            public static final Float DEFAULT_R;
            public static final long serialVersionUID = 0;
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)

            /* renamed from: a  reason: collision with root package name */
            public final Float f35172a;
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)

            /* renamed from: b  reason: collision with root package name */
            public final Float f35173b;
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)

            /* renamed from: g  reason: collision with root package name */
            public final Float f35174g;
            @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
            public final Float r;

            /* loaded from: classes6.dex */
            public static final class Builder extends Message.a<RGBAColor, Builder> {

                /* renamed from: a  reason: collision with root package name */
                public Float f35175a;

                /* renamed from: b  reason: collision with root package name */
                public Float f35176b;

                /* renamed from: g  reason: collision with root package name */
                public Float f35177g;
                public Float r;

                public Builder a(Float f2) {
                    this.f35175a = f2;
                    return this;
                }

                public Builder b(Float f2) {
                    this.f35176b = f2;
                    return this;
                }

                public Builder g(Float f2) {
                    this.f35177g = f2;
                    return this;
                }

                public Builder r(Float f2) {
                    this.r = f2;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire2.Message.a
                public RGBAColor build() {
                    return new RGBAColor(this.r, this.f35177g, this.f35176b, this.f35175a, super.buildUnknownFields());
                }
            }

            /* loaded from: classes6.dex */
            public static final class ProtoAdapter_RGBAColor extends ProtoAdapter<RGBAColor> {
                public ProtoAdapter_RGBAColor() {
                    super(FieldEncoding.LENGTH_DELIMITED, RGBAColor.class);
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire2.ProtoAdapter
                public RGBAColor decode(c cVar) throws IOException {
                    Builder builder = new Builder();
                    long c2 = cVar.c();
                    while (true) {
                        int f2 = cVar.f();
                        if (f2 == -1) {
                            cVar.d(c2);
                            return builder.build();
                        } else if (f2 == 1) {
                            builder.r(ProtoAdapter.FLOAT.decode(cVar));
                        } else if (f2 == 2) {
                            builder.g(ProtoAdapter.FLOAT.decode(cVar));
                        } else if (f2 == 3) {
                            builder.b(ProtoAdapter.FLOAT.decode(cVar));
                        } else if (f2 != 4) {
                            FieldEncoding g2 = cVar.g();
                            builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                        } else {
                            builder.a(ProtoAdapter.FLOAT.decode(cVar));
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.squareup.wire2.ProtoAdapter
                public void encode(d dVar, RGBAColor rGBAColor) throws IOException {
                    Float f2 = rGBAColor.r;
                    if (f2 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, f2);
                    }
                    Float f3 = rGBAColor.f35174g;
                    if (f3 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, f3);
                    }
                    Float f4 = rGBAColor.f35173b;
                    if (f4 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, f4);
                    }
                    Float f5 = rGBAColor.f35172a;
                    if (f5 != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 4, f5);
                    }
                    dVar.k(rGBAColor.unknownFields());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.squareup.wire2.ProtoAdapter
                public int encodedSize(RGBAColor rGBAColor) {
                    Float f2 = rGBAColor.r;
                    int encodedSizeWithTag = f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f2) : 0;
                    Float f3 = rGBAColor.f35174g;
                    int encodedSizeWithTag2 = encodedSizeWithTag + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f3) : 0);
                    Float f4 = rGBAColor.f35173b;
                    int encodedSizeWithTag3 = encodedSizeWithTag2 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f4) : 0);
                    Float f5 = rGBAColor.f35172a;
                    return encodedSizeWithTag3 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f5) : 0) + rGBAColor.unknownFields().size();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.squareup.wire2.ProtoAdapter
                public RGBAColor redact(RGBAColor rGBAColor) {
                    Message.a<RGBAColor, Builder> newBuilder2 = rGBAColor.newBuilder2();
                    newBuilder2.clearUnknownFields();
                    return newBuilder2.build();
                }
            }

            static {
                Float valueOf = Float.valueOf(0.0f);
                DEFAULT_R = valueOf;
                DEFAULT_G = valueOf;
                DEFAULT_B = valueOf;
                DEFAULT_A = valueOf;
            }

            public RGBAColor(Float f2, Float f3, Float f4, Float f5) {
                this(f2, f3, f4, f5, ByteString.EMPTY);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof RGBAColor) {
                    RGBAColor rGBAColor = (RGBAColor) obj;
                    return unknownFields().equals(rGBAColor.unknownFields()) && a.f(this.r, rGBAColor.r) && a.f(this.f35174g, rGBAColor.f35174g) && a.f(this.f35173b, rGBAColor.f35173b) && a.f(this.f35172a, rGBAColor.f35172a);
                }
                return false;
            }

            public int hashCode() {
                int i2 = this.hashCode;
                if (i2 == 0) {
                    int hashCode = unknownFields().hashCode() * 37;
                    Float f2 = this.r;
                    int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 37;
                    Float f3 = this.f35174g;
                    int hashCode3 = (hashCode2 + (f3 != null ? f3.hashCode() : 0)) * 37;
                    Float f4 = this.f35173b;
                    int hashCode4 = (hashCode3 + (f4 != null ? f4.hashCode() : 0)) * 37;
                    Float f5 = this.f35172a;
                    int hashCode5 = hashCode4 + (f5 != null ? f5.hashCode() : 0);
                    this.hashCode = hashCode5;
                    return hashCode5;
                }
                return i2;
            }

            @Override // com.squareup.wire2.Message
            public String toString() {
                StringBuilder sb = new StringBuilder();
                if (this.r != null) {
                    sb.append(", r=");
                    sb.append(this.r);
                }
                if (this.f35174g != null) {
                    sb.append(", g=");
                    sb.append(this.f35174g);
                }
                if (this.f35173b != null) {
                    sb.append(", b=");
                    sb.append(this.f35173b);
                }
                if (this.f35172a != null) {
                    sb.append(", a=");
                    sb.append(this.f35172a);
                }
                StringBuilder replace = sb.replace(0, 2, "RGBAColor{");
                replace.append('}');
                return replace.toString();
            }

            public RGBAColor(Float f2, Float f3, Float f4, Float f5, ByteString byteString) {
                super(ADAPTER, byteString);
                this.r = f2;
                this.f35174g = f3;
                this.f35173b = f4;
                this.f35172a = f5;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor$Builder' to match base method */
            @Override // com.squareup.wire2.Message
            /* renamed from: newBuilder */
            public Message.a<RGBAColor, Builder> newBuilder2() {
                Builder builder = new Builder();
                builder.r = this.r;
                builder.f35177g = this.f35174g;
                builder.f35176b = this.f35173b;
                builder.f35175a = this.f35172a;
                builder.addUnknownFields(unknownFields());
                return builder;
            }
        }

        static {
            Float valueOf = Float.valueOf(0.0f);
            DEFAULT_STROKEWIDTH = valueOf;
            DEFAULT_LINECAP = LineCap.LineCap_BUTT;
            DEFAULT_LINEJOIN = LineJoin.LineJoin_MITER;
            DEFAULT_MITERLIMIT = valueOf;
            DEFAULT_LINEDASHI = valueOf;
            DEFAULT_LINEDASHII = valueOf;
            DEFAULT_LINEDASHIII = valueOf;
        }

        public ShapeStyle(RGBAColor rGBAColor, RGBAColor rGBAColor2, Float f2, LineCap lineCap, LineJoin lineJoin, Float f3, Float f4, Float f5, Float f6) {
            this(rGBAColor, rGBAColor2, f2, lineCap, lineJoin, f3, f4, f5, f6, ByteString.EMPTY);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ShapeStyle) {
                ShapeStyle shapeStyle = (ShapeStyle) obj;
                return unknownFields().equals(shapeStyle.unknownFields()) && a.f(this.fill, shapeStyle.fill) && a.f(this.stroke, shapeStyle.stroke) && a.f(this.strokeWidth, shapeStyle.strokeWidth) && a.f(this.lineCap, shapeStyle.lineCap) && a.f(this.lineJoin, shapeStyle.lineJoin) && a.f(this.miterLimit, shapeStyle.miterLimit) && a.f(this.lineDashI, shapeStyle.lineDashI) && a.f(this.lineDashII, shapeStyle.lineDashII) && a.f(this.lineDashIII, shapeStyle.lineDashIII);
            }
            return false;
        }

        public int hashCode() {
            int i2 = this.hashCode;
            if (i2 == 0) {
                int hashCode = unknownFields().hashCode() * 37;
                RGBAColor rGBAColor = this.fill;
                int hashCode2 = (hashCode + (rGBAColor != null ? rGBAColor.hashCode() : 0)) * 37;
                RGBAColor rGBAColor2 = this.stroke;
                int hashCode3 = (hashCode2 + (rGBAColor2 != null ? rGBAColor2.hashCode() : 0)) * 37;
                Float f2 = this.strokeWidth;
                int hashCode4 = (hashCode3 + (f2 != null ? f2.hashCode() : 0)) * 37;
                LineCap lineCap = this.lineCap;
                int hashCode5 = (hashCode4 + (lineCap != null ? lineCap.hashCode() : 0)) * 37;
                LineJoin lineJoin = this.lineJoin;
                int hashCode6 = (hashCode5 + (lineJoin != null ? lineJoin.hashCode() : 0)) * 37;
                Float f3 = this.miterLimit;
                int hashCode7 = (hashCode6 + (f3 != null ? f3.hashCode() : 0)) * 37;
                Float f4 = this.lineDashI;
                int hashCode8 = (hashCode7 + (f4 != null ? f4.hashCode() : 0)) * 37;
                Float f5 = this.lineDashII;
                int hashCode9 = (hashCode8 + (f5 != null ? f5.hashCode() : 0)) * 37;
                Float f6 = this.lineDashIII;
                int hashCode10 = hashCode9 + (f6 != null ? f6.hashCode() : 0);
                this.hashCode = hashCode10;
                return hashCode10;
            }
            return i2;
        }

        @Override // com.squareup.wire2.Message
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.fill != null) {
                sb.append(", fill=");
                sb.append(this.fill);
            }
            if (this.stroke != null) {
                sb.append(", stroke=");
                sb.append(this.stroke);
            }
            if (this.strokeWidth != null) {
                sb.append(", strokeWidth=");
                sb.append(this.strokeWidth);
            }
            if (this.lineCap != null) {
                sb.append(", lineCap=");
                sb.append(this.lineCap);
            }
            if (this.lineJoin != null) {
                sb.append(", lineJoin=");
                sb.append(this.lineJoin);
            }
            if (this.miterLimit != null) {
                sb.append(", miterLimit=");
                sb.append(this.miterLimit);
            }
            if (this.lineDashI != null) {
                sb.append(", lineDashI=");
                sb.append(this.lineDashI);
            }
            if (this.lineDashII != null) {
                sb.append(", lineDashII=");
                sb.append(this.lineDashII);
            }
            if (this.lineDashIII != null) {
                sb.append(", lineDashIII=");
                sb.append(this.lineDashIII);
            }
            StringBuilder replace = sb.replace(0, 2, "ShapeStyle{");
            replace.append('}');
            return replace.toString();
        }

        public ShapeStyle(RGBAColor rGBAColor, RGBAColor rGBAColor2, Float f2, LineCap lineCap, LineJoin lineJoin, Float f3, Float f4, Float f5, Float f6, ByteString byteString) {
            super(ADAPTER, byteString);
            this.fill = rGBAColor;
            this.stroke = rGBAColor2;
            this.strokeWidth = f2;
            this.lineCap = lineCap;
            this.lineJoin = lineJoin;
            this.miterLimit = f3;
            this.lineDashI = f4;
            this.lineDashII = f5;
            this.lineDashIII = f6;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$Builder' to match base method */
        @Override // com.squareup.wire2.Message
        /* renamed from: newBuilder */
        public Message.a<ShapeStyle, Builder> newBuilder2() {
            Builder builder = new Builder();
            builder.fill = this.fill;
            builder.stroke = this.stroke;
            builder.strokeWidth = this.strokeWidth;
            builder.lineCap = this.lineCap;
            builder.lineJoin = this.lineJoin;
            builder.miterLimit = this.miterLimit;
            builder.lineDashI = this.lineDashI;
            builder.lineDashII = this.lineDashII;
            builder.lineDashIII = this.lineDashIII;
            builder.addUnknownFields(unknownFields());
            return builder;
        }
    }

    /* loaded from: classes6.dex */
    public enum ShapeType implements g {
        SHAPE(0),
        RECT(1),
        ELLIPSE(2),
        KEEP(3);
        
        public static final ProtoAdapter<ShapeType> ADAPTER = ProtoAdapter.newEnumAdapter(ShapeType.class);
        public final int value;

        ShapeType(int i2) {
            this.value = i2;
        }

        public static ShapeType fromValue(int i2) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            return null;
                        }
                        return KEEP;
                    }
                    return ELLIPSE;
                }
                return RECT;
            }
            return SHAPE;
        }

        @Override // d.n.a.g
        public int getValue() {
            return this.value;
        }
    }

    public ShapeEntity(ShapeType shapeType, ShapeStyle shapeStyle, Transform transform, ShapeArgs shapeArgs, RectArgs rectArgs, EllipseArgs ellipseArgs) {
        this(shapeType, shapeStyle, transform, shapeArgs, rectArgs, ellipseArgs, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ShapeEntity) {
            ShapeEntity shapeEntity = (ShapeEntity) obj;
            return unknownFields().equals(shapeEntity.unknownFields()) && a.f(this.type, shapeEntity.type) && a.f(this.styles, shapeEntity.styles) && a.f(this.transform, shapeEntity.transform) && a.f(this.shape, shapeEntity.shape) && a.f(this.rect, shapeEntity.rect) && a.f(this.ellipse, shapeEntity.ellipse);
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            ShapeType shapeType = this.type;
            int hashCode2 = (hashCode + (shapeType != null ? shapeType.hashCode() : 0)) * 37;
            ShapeStyle shapeStyle = this.styles;
            int hashCode3 = (hashCode2 + (shapeStyle != null ? shapeStyle.hashCode() : 0)) * 37;
            Transform transform = this.transform;
            int hashCode4 = (hashCode3 + (transform != null ? transform.hashCode() : 0)) * 37;
            ShapeArgs shapeArgs = this.shape;
            int hashCode5 = (hashCode4 + (shapeArgs != null ? shapeArgs.hashCode() : 0)) * 37;
            RectArgs rectArgs = this.rect;
            int hashCode6 = (hashCode5 + (rectArgs != null ? rectArgs.hashCode() : 0)) * 37;
            EllipseArgs ellipseArgs = this.ellipse;
            int hashCode7 = hashCode6 + (ellipseArgs != null ? ellipseArgs.hashCode() : 0);
            this.hashCode = hashCode7;
            return hashCode7;
        }
        return i2;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        if (this.styles != null) {
            sb.append(", styles=");
            sb.append(this.styles);
        }
        if (this.transform != null) {
            sb.append(", transform=");
            sb.append(this.transform);
        }
        if (this.shape != null) {
            sb.append(", shape=");
            sb.append(this.shape);
        }
        if (this.rect != null) {
            sb.append(", rect=");
            sb.append(this.rect);
        }
        if (this.ellipse != null) {
            sb.append(", ellipse=");
            sb.append(this.ellipse);
        }
        StringBuilder replace = sb.replace(0, 2, "ShapeEntity{");
        replace.append('}');
        return replace.toString();
    }

    public ShapeEntity(ShapeType shapeType, ShapeStyle shapeStyle, Transform transform, ShapeArgs shapeArgs, RectArgs rectArgs, EllipseArgs ellipseArgs, ByteString byteString) {
        super(ADAPTER, byteString);
        if (a.e(shapeArgs, rectArgs, ellipseArgs) <= 1) {
            this.type = shapeType;
            this.styles = shapeStyle;
            this.transform = transform;
            this.shape = shapeArgs;
            this.rect = rectArgs;
            this.ellipse = ellipseArgs;
            return;
        }
        throw new IllegalArgumentException("at most one of shape, rect, ellipse may be non-null");
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.ShapeEntity$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<ShapeEntity, Builder> newBuilder2() {
        Builder builder = new Builder();
        builder.type = this.type;
        builder.styles = this.styles;
        builder.transform = this.transform;
        builder.shape = this.shape;
        builder.rect = this.rect;
        builder.ellipse = this.ellipse;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
