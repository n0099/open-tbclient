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
/* loaded from: classes7.dex */
public final class Transform extends Message<Transform, Builder> {
    public static final ProtoAdapter<Transform> ADAPTER = new ProtoAdapter_Transform();
    public static final Float DEFAULT_A;
    public static final Float DEFAULT_B;
    public static final Float DEFAULT_C;
    public static final Float DEFAULT_D;
    public static final Float DEFAULT_TX;
    public static final Float DEFAULT_TY;
    public static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)

    /* renamed from: a  reason: collision with root package name */
    public final Float f35107a;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)

    /* renamed from: b  reason: collision with root package name */
    public final Float f35108b;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)

    /* renamed from: c  reason: collision with root package name */
    public final Float f35109c;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)

    /* renamed from: d  reason: collision with root package name */
    public final Float f35110d;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
    public final Float tx;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    public final Float ty;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.a<Transform, Builder> {

        /* renamed from: a  reason: collision with root package name */
        public Float f35111a;

        /* renamed from: b  reason: collision with root package name */
        public Float f35112b;

        /* renamed from: c  reason: collision with root package name */
        public Float f35113c;

        /* renamed from: d  reason: collision with root package name */
        public Float f35114d;
        public Float tx;
        public Float ty;

        public Builder a(Float f2) {
            this.f35111a = f2;
            return this;
        }

        public Builder b(Float f2) {
            this.f35112b = f2;
            return this;
        }

        public Builder c(Float f2) {
            this.f35113c = f2;
            return this;
        }

        public Builder d(Float f2) {
            this.f35114d = f2;
            return this;
        }

        public Builder tx(Float f2) {
            this.tx = f2;
            return this;
        }

        public Builder ty(Float f2) {
            this.ty = f2;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public Transform build() {
            return new Transform(this.f35111a, this.f35112b, this.f35113c, this.f35114d, this.tx, this.ty, super.buildUnknownFields());
        }
    }

    /* loaded from: classes7.dex */
    public static final class ProtoAdapter_Transform extends ProtoAdapter<Transform> {
        public ProtoAdapter_Transform() {
            super(FieldEncoding.LENGTH_DELIMITED, Transform.class);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public Transform decode(c cVar) throws IOException {
            Builder builder = new Builder();
            long c2 = cVar.c();
            while (true) {
                int f2 = cVar.f();
                if (f2 != -1) {
                    switch (f2) {
                        case 1:
                            builder.a(ProtoAdapter.FLOAT.decode(cVar));
                            break;
                        case 2:
                            builder.b(ProtoAdapter.FLOAT.decode(cVar));
                            break;
                        case 3:
                            builder.c(ProtoAdapter.FLOAT.decode(cVar));
                            break;
                        case 4:
                            builder.d(ProtoAdapter.FLOAT.decode(cVar));
                            break;
                        case 5:
                            builder.tx(ProtoAdapter.FLOAT.decode(cVar));
                            break;
                        case 6:
                            builder.ty(ProtoAdapter.FLOAT.decode(cVar));
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
        public void encode(d dVar, Transform transform) throws IOException {
            Float f2 = transform.f35107a;
            if (f2 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, f2);
            }
            Float f3 = transform.f35108b;
            if (f3 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, f3);
            }
            Float f4 = transform.f35109c;
            if (f4 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, f4);
            }
            Float f5 = transform.f35110d;
            if (f5 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 4, f5);
            }
            Float f6 = transform.tx;
            if (f6 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 5, f6);
            }
            Float f7 = transform.ty;
            if (f7 != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 6, f7);
            }
            dVar.k(transform.unknownFields());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(Transform transform) {
            Float f2 = transform.f35107a;
            int encodedSizeWithTag = f2 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, f2) : 0;
            Float f3 = transform.f35108b;
            int encodedSizeWithTag2 = encodedSizeWithTag + (f3 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, f3) : 0);
            Float f4 = transform.f35109c;
            int encodedSizeWithTag3 = encodedSizeWithTag2 + (f4 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, f4) : 0);
            Float f5 = transform.f35110d;
            int encodedSizeWithTag4 = encodedSizeWithTag3 + (f5 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, f5) : 0);
            Float f6 = transform.tx;
            int encodedSizeWithTag5 = encodedSizeWithTag4 + (f6 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(5, f6) : 0);
            Float f7 = transform.ty;
            return encodedSizeWithTag5 + (f7 != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(6, f7) : 0) + transform.unknownFields().size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public Transform redact(Transform transform) {
            Message.a<Transform, Builder> newBuilder2 = transform.newBuilder2();
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }

    static {
        Float valueOf = Float.valueOf(0.0f);
        DEFAULT_A = valueOf;
        DEFAULT_B = valueOf;
        DEFAULT_C = valueOf;
        DEFAULT_D = valueOf;
        DEFAULT_TX = valueOf;
        DEFAULT_TY = valueOf;
    }

    public Transform(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7) {
        this(f2, f3, f4, f5, f6, f7, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Transform) {
            Transform transform = (Transform) obj;
            return unknownFields().equals(transform.unknownFields()) && a.f(this.f35107a, transform.f35107a) && a.f(this.f35108b, transform.f35108b) && a.f(this.f35109c, transform.f35109c) && a.f(this.f35110d, transform.f35110d) && a.f(this.tx, transform.tx) && a.f(this.ty, transform.ty);
        }
        return false;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            Float f2 = this.f35107a;
            int hashCode2 = (hashCode + (f2 != null ? f2.hashCode() : 0)) * 37;
            Float f3 = this.f35108b;
            int hashCode3 = (hashCode2 + (f3 != null ? f3.hashCode() : 0)) * 37;
            Float f4 = this.f35109c;
            int hashCode4 = (hashCode3 + (f4 != null ? f4.hashCode() : 0)) * 37;
            Float f5 = this.f35110d;
            int hashCode5 = (hashCode4 + (f5 != null ? f5.hashCode() : 0)) * 37;
            Float f6 = this.tx;
            int hashCode6 = (hashCode5 + (f6 != null ? f6.hashCode() : 0)) * 37;
            Float f7 = this.ty;
            int hashCode7 = hashCode6 + (f7 != null ? f7.hashCode() : 0);
            this.hashCode = hashCode7;
            return hashCode7;
        }
        return i2;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f35107a != null) {
            sb.append(", a=");
            sb.append(this.f35107a);
        }
        if (this.f35108b != null) {
            sb.append(", b=");
            sb.append(this.f35108b);
        }
        if (this.f35109c != null) {
            sb.append(", c=");
            sb.append(this.f35109c);
        }
        if (this.f35110d != null) {
            sb.append(", d=");
            sb.append(this.f35110d);
        }
        if (this.tx != null) {
            sb.append(", tx=");
            sb.append(this.tx);
        }
        if (this.ty != null) {
            sb.append(", ty=");
            sb.append(this.ty);
        }
        StringBuilder replace = sb.replace(0, 2, "Transform{");
        replace.append('}');
        return replace.toString();
    }

    public Transform(Float f2, Float f3, Float f4, Float f5, Float f6, Float f7, ByteString byteString) {
        super(ADAPTER, byteString);
        this.f35107a = f2;
        this.f35108b = f3;
        this.f35109c = f4;
        this.f35110d = f5;
        this.tx = f6;
        this.ty = f7;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.Transform$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<Transform, Builder> newBuilder2() {
        Builder builder = new Builder();
        builder.f35111a = this.f35107a;
        builder.f35112b = this.f35108b;
        builder.f35113c = this.f35109c;
        builder.f35114d = this.f35110d;
        builder.tx = this.tx;
        builder.ty = this.ty;
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
