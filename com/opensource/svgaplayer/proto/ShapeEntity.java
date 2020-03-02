package com.opensource.svgaplayer.proto;

import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.Message;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import com.squareup.wire2.c;
import com.squareup.wire2.d;
import com.squareup.wire2.g;
import com.squareup.wire2.internal.a;
import java.io.IOException;
import okio.ByteString;
/* loaded from: classes.dex */
public final class ShapeEntity extends Message<ShapeEntity, Builder> {
    public static final ProtoAdapter<ShapeEntity> ADAPTER = new ProtoAdapter_ShapeEntity();
    public static final ShapeType DEFAULT_TYPE = ShapeType.SHAPE;
    private static final long serialVersionUID = 0;
    @WireField(dGw = "com.opensource.svgaplayer.proto.ShapeEntity$EllipseArgs#ADAPTER", tag = 4)
    public final EllipseArgs ellipse;
    @WireField(dGw = "com.opensource.svgaplayer.proto.ShapeEntity$RectArgs#ADAPTER", tag = 3)
    public final RectArgs rect;
    @WireField(dGw = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeArgs#ADAPTER", tag = 2)
    public final ShapeArgs shape;
    @WireField(dGw = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle#ADAPTER", tag = 10)
    public final ShapeStyle styles;
    @WireField(dGw = "com.opensource.svgaplayer.proto.Transform#ADAPTER", tag = 11)
    public final Transform transform;
    @WireField(dGw = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeType#ADAPTER", tag = 1)
    public final ShapeType type;

    public ShapeEntity(ShapeType shapeType, ShapeStyle shapeStyle, Transform transform, ShapeArgs shapeArgs, RectArgs rectArgs, EllipseArgs ellipseArgs) {
        this(shapeType, shapeStyle, transform, shapeArgs, rectArgs, ellipseArgs, ByteString.EMPTY);
    }

    public ShapeEntity(ShapeType shapeType, ShapeStyle shapeStyle, Transform transform, ShapeArgs shapeArgs, RectArgs rectArgs, EllipseArgs ellipseArgs, ByteString byteString) {
        super(ADAPTER, byteString);
        if (a.a(shapeArgs, rectArgs, ellipseArgs) > 1) {
            throw new IllegalArgumentException("at most one of shape, rect, ellipse may be non-null");
        }
        this.type = shapeType;
        this.styles = shapeStyle;
        this.transform = transform;
        this.shape = shapeArgs;
        this.rect = rectArgs;
        this.ellipse = ellipseArgs;
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

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ShapeEntity) {
            ShapeEntity shapeEntity = (ShapeEntity) obj;
            return unknownFields().equals(shapeEntity.unknownFields()) && a.equals(this.type, shapeEntity.type) && a.equals(this.styles, shapeEntity.styles) && a.equals(this.transform, shapeEntity.transform) && a.equals(this.shape, shapeEntity.shape) && a.equals(this.rect, shapeEntity.rect) && a.equals(this.ellipse, shapeEntity.ellipse);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = (((this.rect != null ? this.rect.hashCode() : 0) + (((this.shape != null ? this.shape.hashCode() : 0) + (((this.transform != null ? this.transform.hashCode() : 0) + (((this.styles != null ? this.styles.hashCode() : 0) + (((this.type != null ? this.type.hashCode() : 0) + (unknownFields().hashCode() * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.ellipse != null ? this.ellipse.hashCode() : 0);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            sb.append(", type=").append(this.type);
        }
        if (this.styles != null) {
            sb.append(", styles=").append(this.styles);
        }
        if (this.transform != null) {
            sb.append(", transform=").append(this.transform);
        }
        if (this.shape != null) {
            sb.append(", shape=").append(this.shape);
        }
        if (this.rect != null) {
            sb.append(", rect=").append(this.rect);
        }
        if (this.ellipse != null) {
            sb.append(", ellipse=").append(this.ellipse);
        }
        return sb.replace(0, 2, "ShapeEntity{").append('}').toString();
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.a<ShapeEntity, Builder> {
        public EllipseArgs ellipse;
        public RectArgs rect;
        public ShapeArgs shape;
        public ShapeStyle styles;
        public Transform transform;
        public ShapeType type;

        public Builder type(ShapeType shapeType) {
            this.type = shapeType;
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

        public Builder shape(ShapeArgs shapeArgs) {
            this.shape = shapeArgs;
            this.rect = null;
            this.ellipse = null;
            return this;
        }

        public Builder rect(RectArgs rectArgs) {
            this.rect = rectArgs;
            this.shape = null;
            this.ellipse = null;
            return this;
        }

        public Builder ellipse(EllipseArgs ellipseArgs) {
            this.ellipse = ellipseArgs;
            this.shape = null;
            this.rect = null;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public ShapeEntity build() {
            return new ShapeEntity(this.type, this.styles, this.transform, this.shape, this.rect, this.ellipse, super.buildUnknownFields());
        }
    }

    /* loaded from: classes.dex */
    public enum ShapeType implements g {
        SHAPE(0),
        RECT(1),
        ELLIPSE(2),
        KEEP(3);
        
        public static final ProtoAdapter<ShapeType> ADAPTER = ProtoAdapter.newEnumAdapter(ShapeType.class);
        private final int value;

        ShapeType(int i) {
            this.value = i;
        }

        public static ShapeType fromValue(int i) {
            switch (i) {
                case 0:
                    return SHAPE;
                case 1:
                    return RECT;
                case 2:
                    return ELLIPSE;
                case 3:
                    return KEEP;
                default:
                    return null;
            }
        }

        @Override // com.squareup.wire2.g
        public int getValue() {
            return this.value;
        }
    }

    /* loaded from: classes.dex */
    public static final class ShapeArgs extends Message<ShapeArgs, Builder> {
        public static final ProtoAdapter<ShapeArgs> ADAPTER = new ProtoAdapter_ShapeArgs();
        public static final String DEFAULT_D = "";
        private static final long serialVersionUID = 0;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
        public final String d;

        public ShapeArgs(String str) {
            this(str, ByteString.EMPTY);
        }

        public ShapeArgs(String str, ByteString byteString) {
            super(ADAPTER, byteString);
            this.d = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.ShapeEntity$ShapeArgs$Builder' to match base method */
        @Override // com.squareup.wire2.Message
        /* renamed from: newBuilder */
        public Message.a<ShapeArgs, Builder> newBuilder2() {
            Builder builder = new Builder();
            builder.d = this.d;
            builder.addUnknownFields(unknownFields());
            return builder;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ShapeArgs) {
                ShapeArgs shapeArgs = (ShapeArgs) obj;
                return unknownFields().equals(shapeArgs.unknownFields()) && a.equals(this.d, shapeArgs.d);
            }
            return false;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i == 0) {
                int hashCode = (this.d != null ? this.d.hashCode() : 0) + (unknownFields().hashCode() * 37);
                this.hashCode = hashCode;
                return hashCode;
            }
            return i;
        }

        @Override // com.squareup.wire2.Message
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.d != null) {
                sb.append(", d=").append(this.d);
            }
            return sb.replace(0, 2, "ShapeArgs{").append('}').toString();
        }

        /* loaded from: classes.dex */
        public static final class Builder extends Message.a<ShapeArgs, Builder> {
            public String d;

            public Builder d(String str) {
                this.d = str;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.Message.a
            public ShapeArgs build() {
                return new ShapeArgs(this.d, super.buildUnknownFields());
            }
        }

        /* loaded from: classes.dex */
        private static final class ProtoAdapter_ShapeArgs extends ProtoAdapter<ShapeArgs> {
            ProtoAdapter_ShapeArgs() {
                super(FieldEncoding.LENGTH_DELIMITED, ShapeArgs.class);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(ShapeArgs shapeArgs) {
                return (shapeArgs.d != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, shapeArgs.d) : 0) + shapeArgs.unknownFields().size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(d dVar, ShapeArgs shapeArgs) throws IOException {
                if (shapeArgs.d != null) {
                    ProtoAdapter.STRING.encodeWithTag(dVar, 1, shapeArgs.d);
                }
                dVar.b(shapeArgs.unknownFields());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.ProtoAdapter
            public ShapeArgs decode(c cVar) throws IOException {
                Builder builder = new Builder();
                long dGo = cVar.dGo();
                while (true) {
                    int dGp = cVar.dGp();
                    if (dGp != -1) {
                        switch (dGp) {
                            case 1:
                                builder.d(ProtoAdapter.STRING.decode(cVar));
                                break;
                            default:
                                FieldEncoding dGq = cVar.dGq();
                                builder.addUnknownField(dGp, dGq, dGq.rawProtoAdapter().decode(cVar));
                                break;
                        }
                    } else {
                        cVar.gZ(dGo);
                        return builder.build();
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public ShapeArgs redact(ShapeArgs shapeArgs) {
                Message.a<ShapeArgs, Builder> newBuilder2 = shapeArgs.newBuilder2();
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class RectArgs extends Message<RectArgs, Builder> {
        private static final long serialVersionUID = 0;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
        public final Float cornerRadius;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
        public final Float height;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float width;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
        public final Float x;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
        public final Float y;
        public static final ProtoAdapter<RectArgs> ADAPTER = new ProtoAdapter_RectArgs();
        public static final Float DEFAULT_X = Float.valueOf(0.0f);
        public static final Float DEFAULT_Y = Float.valueOf(0.0f);
        public static final Float DEFAULT_WIDTH = Float.valueOf(0.0f);
        public static final Float DEFAULT_HEIGHT = Float.valueOf(0.0f);
        public static final Float DEFAULT_CORNERRADIUS = Float.valueOf(0.0f);

        public RectArgs(Float f, Float f2, Float f3, Float f4, Float f5) {
            this(f, f2, f3, f4, f5, ByteString.EMPTY);
        }

        public RectArgs(Float f, Float f2, Float f3, Float f4, Float f5, ByteString byteString) {
            super(ADAPTER, byteString);
            this.x = f;
            this.y = f2;
            this.width = f3;
            this.height = f4;
            this.cornerRadius = f5;
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

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof RectArgs) {
                RectArgs rectArgs = (RectArgs) obj;
                return unknownFields().equals(rectArgs.unknownFields()) && a.equals(this.x, rectArgs.x) && a.equals(this.y, rectArgs.y) && a.equals(this.width, rectArgs.width) && a.equals(this.height, rectArgs.height) && a.equals(this.cornerRadius, rectArgs.cornerRadius);
            }
            return false;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i == 0) {
                int hashCode = (((this.height != null ? this.height.hashCode() : 0) + (((this.width != null ? this.width.hashCode() : 0) + (((this.y != null ? this.y.hashCode() : 0) + (((this.x != null ? this.x.hashCode() : 0) + (unknownFields().hashCode() * 37)) * 37)) * 37)) * 37)) * 37) + (this.cornerRadius != null ? this.cornerRadius.hashCode() : 0);
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
            if (this.cornerRadius != null) {
                sb.append(", cornerRadius=").append(this.cornerRadius);
            }
            return sb.replace(0, 2, "RectArgs{").append('}').toString();
        }

        /* loaded from: classes.dex */
        public static final class Builder extends Message.a<RectArgs, Builder> {
            public Float cornerRadius;
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

            public Builder cornerRadius(Float f) {
                this.cornerRadius = f;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.Message.a
            public RectArgs build() {
                return new RectArgs(this.x, this.y, this.width, this.height, this.cornerRadius, super.buildUnknownFields());
            }
        }

        /* loaded from: classes.dex */
        private static final class ProtoAdapter_RectArgs extends ProtoAdapter<RectArgs> {
            ProtoAdapter_RectArgs() {
                super(FieldEncoding.LENGTH_DELIMITED, RectArgs.class);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(RectArgs rectArgs) {
                return (rectArgs.height != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, rectArgs.height) : 0) + (rectArgs.y != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, rectArgs.y) : 0) + (rectArgs.x != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, rectArgs.x) : 0) + (rectArgs.width != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, rectArgs.width) : 0) + (rectArgs.cornerRadius != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(5, rectArgs.cornerRadius) : 0) + rectArgs.unknownFields().size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(d dVar, RectArgs rectArgs) throws IOException {
                if (rectArgs.x != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, rectArgs.x);
                }
                if (rectArgs.y != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, rectArgs.y);
                }
                if (rectArgs.width != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, rectArgs.width);
                }
                if (rectArgs.height != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 4, rectArgs.height);
                }
                if (rectArgs.cornerRadius != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 5, rectArgs.cornerRadius);
                }
                dVar.b(rectArgs.unknownFields());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.ProtoAdapter
            public RectArgs decode(c cVar) throws IOException {
                Builder builder = new Builder();
                long dGo = cVar.dGo();
                while (true) {
                    int dGp = cVar.dGp();
                    if (dGp != -1) {
                        switch (dGp) {
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
                            case 5:
                                builder.cornerRadius(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            default:
                                FieldEncoding dGq = cVar.dGq();
                                builder.addUnknownField(dGp, dGq, dGq.rawProtoAdapter().decode(cVar));
                                break;
                        }
                    } else {
                        cVar.gZ(dGo);
                        return builder.build();
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public RectArgs redact(RectArgs rectArgs) {
                Message.a<RectArgs, Builder> newBuilder2 = rectArgs.newBuilder2();
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class EllipseArgs extends Message<EllipseArgs, Builder> {
        private static final long serialVersionUID = 0;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float radiusX;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
        public final Float radiusY;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
        public final Float x;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
        public final Float y;
        public static final ProtoAdapter<EllipseArgs> ADAPTER = new ProtoAdapter_EllipseArgs();
        public static final Float DEFAULT_X = Float.valueOf(0.0f);
        public static final Float DEFAULT_Y = Float.valueOf(0.0f);
        public static final Float DEFAULT_RADIUSX = Float.valueOf(0.0f);
        public static final Float DEFAULT_RADIUSY = Float.valueOf(0.0f);

        public EllipseArgs(Float f, Float f2, Float f3, Float f4) {
            this(f, f2, f3, f4, ByteString.EMPTY);
        }

        public EllipseArgs(Float f, Float f2, Float f3, Float f4, ByteString byteString) {
            super(ADAPTER, byteString);
            this.x = f;
            this.y = f2;
            this.radiusX = f3;
            this.radiusY = f4;
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

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof EllipseArgs) {
                EllipseArgs ellipseArgs = (EllipseArgs) obj;
                return unknownFields().equals(ellipseArgs.unknownFields()) && a.equals(this.x, ellipseArgs.x) && a.equals(this.y, ellipseArgs.y) && a.equals(this.radiusX, ellipseArgs.radiusX) && a.equals(this.radiusY, ellipseArgs.radiusY);
            }
            return false;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i == 0) {
                int hashCode = (((this.radiusX != null ? this.radiusX.hashCode() : 0) + (((this.y != null ? this.y.hashCode() : 0) + (((this.x != null ? this.x.hashCode() : 0) + (unknownFields().hashCode() * 37)) * 37)) * 37)) * 37) + (this.radiusY != null ? this.radiusY.hashCode() : 0);
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
            if (this.radiusX != null) {
                sb.append(", radiusX=").append(this.radiusX);
            }
            if (this.radiusY != null) {
                sb.append(", radiusY=").append(this.radiusY);
            }
            return sb.replace(0, 2, "EllipseArgs{").append('}').toString();
        }

        /* loaded from: classes.dex */
        public static final class Builder extends Message.a<EllipseArgs, Builder> {
            public Float radiusX;
            public Float radiusY;
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

            public Builder radiusX(Float f) {
                this.radiusX = f;
                return this;
            }

            public Builder radiusY(Float f) {
                this.radiusY = f;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.Message.a
            public EllipseArgs build() {
                return new EllipseArgs(this.x, this.y, this.radiusX, this.radiusY, super.buildUnknownFields());
            }
        }

        /* loaded from: classes.dex */
        private static final class ProtoAdapter_EllipseArgs extends ProtoAdapter<EllipseArgs> {
            ProtoAdapter_EllipseArgs() {
                super(FieldEncoding.LENGTH_DELIMITED, EllipseArgs.class);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(EllipseArgs ellipseArgs) {
                return (ellipseArgs.radiusX != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, ellipseArgs.radiusX) : 0) + (ellipseArgs.y != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, ellipseArgs.y) : 0) + (ellipseArgs.x != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, ellipseArgs.x) : 0) + (ellipseArgs.radiusY != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, ellipseArgs.radiusY) : 0) + ellipseArgs.unknownFields().size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(d dVar, EllipseArgs ellipseArgs) throws IOException {
                if (ellipseArgs.x != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, ellipseArgs.x);
                }
                if (ellipseArgs.y != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, ellipseArgs.y);
                }
                if (ellipseArgs.radiusX != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, ellipseArgs.radiusX);
                }
                if (ellipseArgs.radiusY != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 4, ellipseArgs.radiusY);
                }
                dVar.b(ellipseArgs.unknownFields());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.ProtoAdapter
            public EllipseArgs decode(c cVar) throws IOException {
                Builder builder = new Builder();
                long dGo = cVar.dGo();
                while (true) {
                    int dGp = cVar.dGp();
                    if (dGp != -1) {
                        switch (dGp) {
                            case 1:
                                builder.x(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            case 2:
                                builder.y(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            case 3:
                                builder.radiusX(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            case 4:
                                builder.radiusY(ProtoAdapter.FLOAT.decode(cVar));
                                break;
                            default:
                                FieldEncoding dGq = cVar.dGq();
                                builder.addUnknownField(dGp, dGq, dGq.rawProtoAdapter().decode(cVar));
                                break;
                        }
                    } else {
                        cVar.gZ(dGo);
                        return builder.build();
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public EllipseArgs redact(EllipseArgs ellipseArgs) {
                Message.a<EllipseArgs, Builder> newBuilder2 = ellipseArgs.newBuilder2();
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class ShapeStyle extends Message<ShapeStyle, Builder> {
        private static final long serialVersionUID = 0;
        @WireField(dGw = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor#ADAPTER", tag = 1)
        public final RGBAColor fill;
        @WireField(dGw = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$LineCap#ADAPTER", tag = 4)
        public final LineCap lineCap;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 7)
        public final Float lineDashI;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 8)
        public final Float lineDashII;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 9)
        public final Float lineDashIII;
        @WireField(dGw = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$LineJoin#ADAPTER", tag = 5)
        public final LineJoin lineJoin;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
        public final Float miterLimit;
        @WireField(dGw = "com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor#ADAPTER", tag = 2)
        public final RGBAColor stroke;
        @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
        public final Float strokeWidth;
        public static final ProtoAdapter<ShapeStyle> ADAPTER = new ProtoAdapter_ShapeStyle();
        public static final Float DEFAULT_STROKEWIDTH = Float.valueOf(0.0f);
        public static final LineCap DEFAULT_LINECAP = LineCap.LineCap_BUTT;
        public static final LineJoin DEFAULT_LINEJOIN = LineJoin.LineJoin_MITER;
        public static final Float DEFAULT_MITERLIMIT = Float.valueOf(0.0f);
        public static final Float DEFAULT_LINEDASHI = Float.valueOf(0.0f);
        public static final Float DEFAULT_LINEDASHII = Float.valueOf(0.0f);
        public static final Float DEFAULT_LINEDASHIII = Float.valueOf(0.0f);

        public ShapeStyle(RGBAColor rGBAColor, RGBAColor rGBAColor2, Float f, LineCap lineCap, LineJoin lineJoin, Float f2, Float f3, Float f4, Float f5) {
            this(rGBAColor, rGBAColor2, f, lineCap, lineJoin, f2, f3, f4, f5, ByteString.EMPTY);
        }

        public ShapeStyle(RGBAColor rGBAColor, RGBAColor rGBAColor2, Float f, LineCap lineCap, LineJoin lineJoin, Float f2, Float f3, Float f4, Float f5, ByteString byteString) {
            super(ADAPTER, byteString);
            this.fill = rGBAColor;
            this.stroke = rGBAColor2;
            this.strokeWidth = f;
            this.lineCap = lineCap;
            this.lineJoin = lineJoin;
            this.miterLimit = f2;
            this.lineDashI = f3;
            this.lineDashII = f4;
            this.lineDashIII = f5;
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

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ShapeStyle) {
                ShapeStyle shapeStyle = (ShapeStyle) obj;
                return unknownFields().equals(shapeStyle.unknownFields()) && a.equals(this.fill, shapeStyle.fill) && a.equals(this.stroke, shapeStyle.stroke) && a.equals(this.strokeWidth, shapeStyle.strokeWidth) && a.equals(this.lineCap, shapeStyle.lineCap) && a.equals(this.lineJoin, shapeStyle.lineJoin) && a.equals(this.miterLimit, shapeStyle.miterLimit) && a.equals(this.lineDashI, shapeStyle.lineDashI) && a.equals(this.lineDashII, shapeStyle.lineDashII) && a.equals(this.lineDashIII, shapeStyle.lineDashIII);
            }
            return false;
        }

        public int hashCode() {
            int i = this.hashCode;
            if (i == 0) {
                int hashCode = (((this.lineDashII != null ? this.lineDashII.hashCode() : 0) + (((this.lineDashI != null ? this.lineDashI.hashCode() : 0) + (((this.miterLimit != null ? this.miterLimit.hashCode() : 0) + (((this.lineJoin != null ? this.lineJoin.hashCode() : 0) + (((this.lineCap != null ? this.lineCap.hashCode() : 0) + (((this.strokeWidth != null ? this.strokeWidth.hashCode() : 0) + (((this.stroke != null ? this.stroke.hashCode() : 0) + (((this.fill != null ? this.fill.hashCode() : 0) + (unknownFields().hashCode() * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.lineDashIII != null ? this.lineDashIII.hashCode() : 0);
                this.hashCode = hashCode;
                return hashCode;
            }
            return i;
        }

        @Override // com.squareup.wire2.Message
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.fill != null) {
                sb.append(", fill=").append(this.fill);
            }
            if (this.stroke != null) {
                sb.append(", stroke=").append(this.stroke);
            }
            if (this.strokeWidth != null) {
                sb.append(", strokeWidth=").append(this.strokeWidth);
            }
            if (this.lineCap != null) {
                sb.append(", lineCap=").append(this.lineCap);
            }
            if (this.lineJoin != null) {
                sb.append(", lineJoin=").append(this.lineJoin);
            }
            if (this.miterLimit != null) {
                sb.append(", miterLimit=").append(this.miterLimit);
            }
            if (this.lineDashI != null) {
                sb.append(", lineDashI=").append(this.lineDashI);
            }
            if (this.lineDashII != null) {
                sb.append(", lineDashII=").append(this.lineDashII);
            }
            if (this.lineDashIII != null) {
                sb.append(", lineDashIII=").append(this.lineDashIII);
            }
            return sb.replace(0, 2, "ShapeStyle{").append('}').toString();
        }

        /* loaded from: classes.dex */
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

            public Builder stroke(RGBAColor rGBAColor) {
                this.stroke = rGBAColor;
                return this;
            }

            public Builder strokeWidth(Float f) {
                this.strokeWidth = f;
                return this;
            }

            public Builder lineCap(LineCap lineCap) {
                this.lineCap = lineCap;
                return this;
            }

            public Builder lineJoin(LineJoin lineJoin) {
                this.lineJoin = lineJoin;
                return this;
            }

            public Builder miterLimit(Float f) {
                this.miterLimit = f;
                return this;
            }

            public Builder lineDashI(Float f) {
                this.lineDashI = f;
                return this;
            }

            public Builder lineDashII(Float f) {
                this.lineDashII = f;
                return this;
            }

            public Builder lineDashIII(Float f) {
                this.lineDashIII = f;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.Message.a
            public ShapeStyle build() {
                return new ShapeStyle(this.fill, this.stroke, this.strokeWidth, this.lineCap, this.lineJoin, this.miterLimit, this.lineDashI, this.lineDashII, this.lineDashIII, super.buildUnknownFields());
            }
        }

        /* loaded from: classes.dex */
        public static final class RGBAColor extends Message<RGBAColor, Builder> {
            private static final long serialVersionUID = 0;
            @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
            public final Float a;
            @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
            public final Float b;
            @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
            public final Float g;
            @WireField(dGw = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
            public final Float r;
            public static final ProtoAdapter<RGBAColor> ADAPTER = new ProtoAdapter_RGBAColor();
            public static final Float DEFAULT_R = Float.valueOf(0.0f);
            public static final Float DEFAULT_G = Float.valueOf(0.0f);
            public static final Float DEFAULT_B = Float.valueOf(0.0f);
            public static final Float DEFAULT_A = Float.valueOf(0.0f);

            public RGBAColor(Float f, Float f2, Float f3, Float f4) {
                this(f, f2, f3, f4, ByteString.EMPTY);
            }

            public RGBAColor(Float f, Float f2, Float f3, Float f4, ByteString byteString) {
                super(ADAPTER, byteString);
                this.r = f;
                this.g = f2;
                this.b = f3;
                this.a = f4;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$RGBAColor$Builder' to match base method */
            @Override // com.squareup.wire2.Message
            /* renamed from: newBuilder */
            public Message.a<RGBAColor, Builder> newBuilder2() {
                Builder builder = new Builder();
                builder.r = this.r;
                builder.g = this.g;
                builder.b = this.b;
                builder.a = this.a;
                builder.addUnknownFields(unknownFields());
                return builder;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof RGBAColor) {
                    RGBAColor rGBAColor = (RGBAColor) obj;
                    return unknownFields().equals(rGBAColor.unknownFields()) && a.equals(this.r, rGBAColor.r) && a.equals(this.g, rGBAColor.g) && a.equals(this.b, rGBAColor.b) && a.equals(this.a, rGBAColor.a);
                }
                return false;
            }

            public int hashCode() {
                int i = this.hashCode;
                if (i == 0) {
                    int hashCode = (((this.b != null ? this.b.hashCode() : 0) + (((this.g != null ? this.g.hashCode() : 0) + (((this.r != null ? this.r.hashCode() : 0) + (unknownFields().hashCode() * 37)) * 37)) * 37)) * 37) + (this.a != null ? this.a.hashCode() : 0);
                    this.hashCode = hashCode;
                    return hashCode;
                }
                return i;
            }

            @Override // com.squareup.wire2.Message
            public String toString() {
                StringBuilder sb = new StringBuilder();
                if (this.r != null) {
                    sb.append(", r=").append(this.r);
                }
                if (this.g != null) {
                    sb.append(", g=").append(this.g);
                }
                if (this.b != null) {
                    sb.append(", b=").append(this.b);
                }
                if (this.a != null) {
                    sb.append(", a=").append(this.a);
                }
                return sb.replace(0, 2, "RGBAColor{").append('}').toString();
            }

            /* loaded from: classes.dex */
            public static final class Builder extends Message.a<RGBAColor, Builder> {
                public Float a;
                public Float b;
                public Float g;
                public Float r;

                public Builder r(Float f) {
                    this.r = f;
                    return this;
                }

                public Builder g(Float f) {
                    this.g = f;
                    return this;
                }

                public Builder b(Float f) {
                    this.b = f;
                    return this;
                }

                public Builder a(Float f) {
                    this.a = f;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire2.Message.a
                public RGBAColor build() {
                    return new RGBAColor(this.r, this.g, this.b, this.a, super.buildUnknownFields());
                }
            }

            /* loaded from: classes.dex */
            private static final class ProtoAdapter_RGBAColor extends ProtoAdapter<RGBAColor> {
                ProtoAdapter_RGBAColor() {
                    super(FieldEncoding.LENGTH_DELIMITED, RGBAColor.class);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.squareup.wire2.ProtoAdapter
                public int encodedSize(RGBAColor rGBAColor) {
                    return (rGBAColor.b != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, rGBAColor.b) : 0) + (rGBAColor.g != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, rGBAColor.g) : 0) + (rGBAColor.r != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, rGBAColor.r) : 0) + (rGBAColor.a != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, rGBAColor.a) : 0) + rGBAColor.unknownFields().size();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.squareup.wire2.ProtoAdapter
                public void encode(d dVar, RGBAColor rGBAColor) throws IOException {
                    if (rGBAColor.r != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, rGBAColor.r);
                    }
                    if (rGBAColor.g != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, rGBAColor.g);
                    }
                    if (rGBAColor.b != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, rGBAColor.b);
                    }
                    if (rGBAColor.a != null) {
                        ProtoAdapter.FLOAT.encodeWithTag(dVar, 4, rGBAColor.a);
                    }
                    dVar.b(rGBAColor.unknownFields());
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire2.ProtoAdapter
                public RGBAColor decode(c cVar) throws IOException {
                    Builder builder = new Builder();
                    long dGo = cVar.dGo();
                    while (true) {
                        int dGp = cVar.dGp();
                        if (dGp != -1) {
                            switch (dGp) {
                                case 1:
                                    builder.r(ProtoAdapter.FLOAT.decode(cVar));
                                    break;
                                case 2:
                                    builder.g(ProtoAdapter.FLOAT.decode(cVar));
                                    break;
                                case 3:
                                    builder.b(ProtoAdapter.FLOAT.decode(cVar));
                                    break;
                                case 4:
                                    builder.a(ProtoAdapter.FLOAT.decode(cVar));
                                    break;
                                default:
                                    FieldEncoding dGq = cVar.dGq();
                                    builder.addUnknownField(dGp, dGq, dGq.rawProtoAdapter().decode(cVar));
                                    break;
                            }
                        } else {
                            cVar.gZ(dGo);
                            return builder.build();
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.squareup.wire2.ProtoAdapter
                public RGBAColor redact(RGBAColor rGBAColor) {
                    Message.a<RGBAColor, Builder> newBuilder2 = rGBAColor.newBuilder2();
                    newBuilder2.clearUnknownFields();
                    return newBuilder2.build();
                }
            }
        }

        /* loaded from: classes.dex */
        public enum LineCap implements g {
            LineCap_BUTT(0),
            LineCap_ROUND(1),
            LineCap_SQUARE(2);
            
            public static final ProtoAdapter<LineCap> ADAPTER = ProtoAdapter.newEnumAdapter(LineCap.class);
            private final int value;

            LineCap(int i) {
                this.value = i;
            }

            public static LineCap fromValue(int i) {
                switch (i) {
                    case 0:
                        return LineCap_BUTT;
                    case 1:
                        return LineCap_ROUND;
                    case 2:
                        return LineCap_SQUARE;
                    default:
                        return null;
                }
            }

            @Override // com.squareup.wire2.g
            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: classes.dex */
        public enum LineJoin implements g {
            LineJoin_MITER(0),
            LineJoin_ROUND(1),
            LineJoin_BEVEL(2);
            
            public static final ProtoAdapter<LineJoin> ADAPTER = ProtoAdapter.newEnumAdapter(LineJoin.class);
            private final int value;

            LineJoin(int i) {
                this.value = i;
            }

            public static LineJoin fromValue(int i) {
                switch (i) {
                    case 0:
                        return LineJoin_MITER;
                    case 1:
                        return LineJoin_ROUND;
                    case 2:
                        return LineJoin_BEVEL;
                    default:
                        return null;
                }
            }

            @Override // com.squareup.wire2.g
            public int getValue() {
                return this.value;
            }
        }

        /* loaded from: classes.dex */
        private static final class ProtoAdapter_ShapeStyle extends ProtoAdapter<ShapeStyle> {
            ProtoAdapter_ShapeStyle() {
                super(FieldEncoding.LENGTH_DELIMITED, ShapeStyle.class);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public int encodedSize(ShapeStyle shapeStyle) {
                return (shapeStyle.lineDashII != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(8, shapeStyle.lineDashII) : 0) + (shapeStyle.stroke != null ? RGBAColor.ADAPTER.encodedSizeWithTag(2, shapeStyle.stroke) : 0) + (shapeStyle.fill != null ? RGBAColor.ADAPTER.encodedSizeWithTag(1, shapeStyle.fill) : 0) + (shapeStyle.strokeWidth != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, shapeStyle.strokeWidth) : 0) + (shapeStyle.lineCap != null ? LineCap.ADAPTER.encodedSizeWithTag(4, shapeStyle.lineCap) : 0) + (shapeStyle.lineJoin != null ? LineJoin.ADAPTER.encodedSizeWithTag(5, shapeStyle.lineJoin) : 0) + (shapeStyle.miterLimit != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(6, shapeStyle.miterLimit) : 0) + (shapeStyle.lineDashI != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(7, shapeStyle.lineDashI) : 0) + (shapeStyle.lineDashIII != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(9, shapeStyle.lineDashIII) : 0) + shapeStyle.unknownFields().size();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.squareup.wire2.ProtoAdapter
            public void encode(d dVar, ShapeStyle shapeStyle) throws IOException {
                if (shapeStyle.fill != null) {
                    RGBAColor.ADAPTER.encodeWithTag(dVar, 1, shapeStyle.fill);
                }
                if (shapeStyle.stroke != null) {
                    RGBAColor.ADAPTER.encodeWithTag(dVar, 2, shapeStyle.stroke);
                }
                if (shapeStyle.strokeWidth != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, shapeStyle.strokeWidth);
                }
                if (shapeStyle.lineCap != null) {
                    LineCap.ADAPTER.encodeWithTag(dVar, 4, shapeStyle.lineCap);
                }
                if (shapeStyle.lineJoin != null) {
                    LineJoin.ADAPTER.encodeWithTag(dVar, 5, shapeStyle.lineJoin);
                }
                if (shapeStyle.miterLimit != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 6, shapeStyle.miterLimit);
                }
                if (shapeStyle.lineDashI != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 7, shapeStyle.lineDashI);
                }
                if (shapeStyle.lineDashII != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 8, shapeStyle.lineDashII);
                }
                if (shapeStyle.lineDashIII != null) {
                    ProtoAdapter.FLOAT.encodeWithTag(dVar, 9, shapeStyle.lineDashIII);
                }
                dVar.b(shapeStyle.unknownFields());
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire2.ProtoAdapter
            public ShapeStyle decode(c cVar) throws IOException {
                Builder builder = new Builder();
                long dGo = cVar.dGo();
                while (true) {
                    int dGp = cVar.dGp();
                    if (dGp != -1) {
                        switch (dGp) {
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
                                } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                                    builder.addUnknownField(dGp, FieldEncoding.VARINT, Long.valueOf(e.value));
                                    break;
                                }
                            case 5:
                                try {
                                    builder.lineJoin(LineJoin.ADAPTER.decode(cVar));
                                    break;
                                } catch (ProtoAdapter.EnumConstantNotFoundException e2) {
                                    builder.addUnknownField(dGp, FieldEncoding.VARINT, Long.valueOf(e2.value));
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
                                FieldEncoding dGq = cVar.dGq();
                                builder.addUnknownField(dGp, dGq, dGq.rawProtoAdapter().decode(cVar));
                                break;
                        }
                    } else {
                        cVar.gZ(dGo);
                        return builder.build();
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Type inference failed for: r1v0, types: [com.opensource.svgaplayer.proto.ShapeEntity$ShapeStyle$Builder] */
            @Override // com.squareup.wire2.ProtoAdapter
            public ShapeStyle redact(ShapeStyle shapeStyle) {
                ?? newBuilder2 = shapeStyle.newBuilder2();
                if (newBuilder2.fill != null) {
                    newBuilder2.fill = RGBAColor.ADAPTER.redact(newBuilder2.fill);
                }
                if (newBuilder2.stroke != null) {
                    newBuilder2.stroke = RGBAColor.ADAPTER.redact(newBuilder2.stroke);
                }
                newBuilder2.clearUnknownFields();
                return newBuilder2.build();
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class ProtoAdapter_ShapeEntity extends ProtoAdapter<ShapeEntity> {
        ProtoAdapter_ShapeEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, ShapeEntity.class);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(ShapeEntity shapeEntity) {
            return (shapeEntity.rect != null ? RectArgs.ADAPTER.encodedSizeWithTag(3, shapeEntity.rect) : 0) + (shapeEntity.styles != null ? ShapeStyle.ADAPTER.encodedSizeWithTag(10, shapeEntity.styles) : 0) + (shapeEntity.type != null ? ShapeType.ADAPTER.encodedSizeWithTag(1, shapeEntity.type) : 0) + (shapeEntity.transform != null ? Transform.ADAPTER.encodedSizeWithTag(11, shapeEntity.transform) : 0) + (shapeEntity.shape != null ? ShapeArgs.ADAPTER.encodedSizeWithTag(2, shapeEntity.shape) : 0) + (shapeEntity.ellipse != null ? EllipseArgs.ADAPTER.encodedSizeWithTag(4, shapeEntity.ellipse) : 0) + shapeEntity.unknownFields().size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, ShapeEntity shapeEntity) throws IOException {
            if (shapeEntity.type != null) {
                ShapeType.ADAPTER.encodeWithTag(dVar, 1, shapeEntity.type);
            }
            if (shapeEntity.styles != null) {
                ShapeStyle.ADAPTER.encodeWithTag(dVar, 10, shapeEntity.styles);
            }
            if (shapeEntity.transform != null) {
                Transform.ADAPTER.encodeWithTag(dVar, 11, shapeEntity.transform);
            }
            if (shapeEntity.shape != null) {
                ShapeArgs.ADAPTER.encodeWithTag(dVar, 2, shapeEntity.shape);
            }
            if (shapeEntity.rect != null) {
                RectArgs.ADAPTER.encodeWithTag(dVar, 3, shapeEntity.rect);
            }
            if (shapeEntity.ellipse != null) {
                EllipseArgs.ADAPTER.encodeWithTag(dVar, 4, shapeEntity.ellipse);
            }
            dVar.b(shapeEntity.unknownFields());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public ShapeEntity decode(c cVar) throws IOException {
            Builder builder = new Builder();
            long dGo = cVar.dGo();
            while (true) {
                int dGp = cVar.dGp();
                if (dGp != -1) {
                    switch (dGp) {
                        case 1:
                            try {
                                builder.type(ShapeType.ADAPTER.decode(cVar));
                                break;
                            } catch (ProtoAdapter.EnumConstantNotFoundException e) {
                                builder.addUnknownField(dGp, FieldEncoding.VARINT, Long.valueOf(e.value));
                                break;
                            }
                        case 2:
                            builder.shape(ShapeArgs.ADAPTER.decode(cVar));
                            break;
                        case 3:
                            builder.rect(RectArgs.ADAPTER.decode(cVar));
                            break;
                        case 4:
                            builder.ellipse(EllipseArgs.ADAPTER.decode(cVar));
                            break;
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        default:
                            FieldEncoding dGq = cVar.dGq();
                            builder.addUnknownField(dGp, dGq, dGq.rawProtoAdapter().decode(cVar));
                            break;
                        case 10:
                            builder.styles(ShapeStyle.ADAPTER.decode(cVar));
                            break;
                        case 11:
                            builder.transform(Transform.ADAPTER.decode(cVar));
                            break;
                    }
                } else {
                    cVar.gZ(dGo);
                    return builder.build();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.opensource.svgaplayer.proto.ShapeEntity$Builder] */
        @Override // com.squareup.wire2.ProtoAdapter
        public ShapeEntity redact(ShapeEntity shapeEntity) {
            ?? newBuilder2 = shapeEntity.newBuilder2();
            if (newBuilder2.styles != null) {
                newBuilder2.styles = ShapeStyle.ADAPTER.redact(newBuilder2.styles);
            }
            if (newBuilder2.transform != null) {
                newBuilder2.transform = Transform.ADAPTER.redact(newBuilder2.transform);
            }
            if (newBuilder2.shape != null) {
                newBuilder2.shape = ShapeArgs.ADAPTER.redact(newBuilder2.shape);
            }
            if (newBuilder2.rect != null) {
                newBuilder2.rect = RectArgs.ADAPTER.redact(newBuilder2.rect);
            }
            if (newBuilder2.ellipse != null) {
                newBuilder2.ellipse = EllipseArgs.ADAPTER.redact(newBuilder2.ellipse);
            }
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }
}
