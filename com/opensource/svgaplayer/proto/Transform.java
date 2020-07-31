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
/* loaded from: classes8.dex */
public final class Transform extends Message<Transform, Builder> {
    public static final ProtoAdapter<Transform> ADAPTER = new ProtoAdapter_Transform();
    public static final Float DEFAULT_A = Float.valueOf(0.0f);
    public static final Float DEFAULT_B = Float.valueOf(0.0f);
    public static final Float DEFAULT_C = Float.valueOf(0.0f);
    public static final Float DEFAULT_D = Float.valueOf(0.0f);
    public static final Float DEFAULT_TX = Float.valueOf(0.0f);
    public static final Float DEFAULT_TY = Float.valueOf(0.0f);
    private static final long serialVersionUID = 0;
    @WireField(dQJ = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 1)
    public final Float a;
    @WireField(dQJ = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 2)
    public final Float b;
    @WireField(dQJ = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float c;
    @WireField(dQJ = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 4)
    public final Float d;
    @WireField(dQJ = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 5)
    public final Float tx;
    @WireField(dQJ = "com.squareup.wire.ProtoAdapter#FLOAT", tag = 6)
    public final Float ty;

    public Transform(Float f, Float f2, Float f3, Float f4, Float f5, Float f6) {
        this(f, f2, f3, f4, f5, f6, ByteString.EMPTY);
    }

    public Transform(Float f, Float f2, Float f3, Float f4, Float f5, Float f6, ByteString byteString) {
        super(ADAPTER, byteString);
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.tx = f5;
        this.ty = f6;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.Transform$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<Transform, Builder> newBuilder2() {
        Builder builder = new Builder();
        builder.a = this.a;
        builder.b = this.b;
        builder.c = this.c;
        builder.d = this.d;
        builder.tx = this.tx;
        builder.ty = this.ty;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Transform) {
            Transform transform = (Transform) obj;
            return unknownFields().equals(transform.unknownFields()) && a.equals(this.a, transform.a) && a.equals(this.b, transform.b) && a.equals(this.c, transform.c) && a.equals(this.d, transform.d) && a.equals(this.tx, transform.tx) && a.equals(this.ty, transform.ty);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = (((this.tx != null ? this.tx.hashCode() : 0) + (((this.d != null ? this.d.hashCode() : 0) + (((this.c != null ? this.c.hashCode() : 0) + (((this.b != null ? this.b.hashCode() : 0) + (((this.a != null ? this.a.hashCode() : 0) + (unknownFields().hashCode() * 37)) * 37)) * 37)) * 37)) * 37)) * 37) + (this.ty != null ? this.ty.hashCode() : 0);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.a != null) {
            sb.append(", a=").append(this.a);
        }
        if (this.b != null) {
            sb.append(", b=").append(this.b);
        }
        if (this.c != null) {
            sb.append(", c=").append(this.c);
        }
        if (this.d != null) {
            sb.append(", d=").append(this.d);
        }
        if (this.tx != null) {
            sb.append(", tx=").append(this.tx);
        }
        if (this.ty != null) {
            sb.append(", ty=").append(this.ty);
        }
        return sb.replace(0, 2, "Transform{").append('}').toString();
    }

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.a<Transform, Builder> {
        public Float a;
        public Float b;
        public Float c;
        public Float d;
        public Float tx;
        public Float ty;

        public Builder a(Float f) {
            this.a = f;
            return this;
        }

        public Builder b(Float f) {
            this.b = f;
            return this;
        }

        public Builder c(Float f) {
            this.c = f;
            return this;
        }

        public Builder d(Float f) {
            this.d = f;
            return this;
        }

        public Builder tx(Float f) {
            this.tx = f;
            return this;
        }

        public Builder ty(Float f) {
            this.ty = f;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public Transform build() {
            return new Transform(this.a, this.b, this.c, this.d, this.tx, this.ty, super.buildUnknownFields());
        }
    }

    /* loaded from: classes8.dex */
    private static final class ProtoAdapter_Transform extends ProtoAdapter<Transform> {
        ProtoAdapter_Transform() {
            super(FieldEncoding.LENGTH_DELIMITED, Transform.class);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(Transform transform) {
            return (transform.tx != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(5, transform.tx) : 0) + (transform.b != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(2, transform.b) : 0) + (transform.a != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(1, transform.a) : 0) + (transform.c != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(3, transform.c) : 0) + (transform.d != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(4, transform.d) : 0) + (transform.ty != null ? ProtoAdapter.FLOAT.encodedSizeWithTag(6, transform.ty) : 0) + transform.unknownFields().size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, Transform transform) throws IOException {
            if (transform.a != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 1, transform.a);
            }
            if (transform.b != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 2, transform.b);
            }
            if (transform.c != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 3, transform.c);
            }
            if (transform.d != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 4, transform.d);
            }
            if (transform.tx != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 5, transform.tx);
            }
            if (transform.ty != null) {
                ProtoAdapter.FLOAT.encodeWithTag(dVar, 6, transform.ty);
            }
            dVar.b(transform.unknownFields());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public Transform decode(c cVar) throws IOException {
            Builder builder = new Builder();
            long dQB = cVar.dQB();
            while (true) {
                int dQC = cVar.dQC();
                if (dQC != -1) {
                    switch (dQC) {
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
        @Override // com.squareup.wire2.ProtoAdapter
        public Transform redact(Transform transform) {
            Message.a<Transform, Builder> newBuilder2 = transform.newBuilder2();
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }
}
