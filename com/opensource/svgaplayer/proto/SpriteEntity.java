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
/* loaded from: classes17.dex */
public final class SpriteEntity extends Message<SpriteEntity, Builder> {
    public static final ProtoAdapter<SpriteEntity> ADAPTER = new ProtoAdapter_SpriteEntity();
    public static final String DEFAULT_IMAGEKEY = "";
    private static final long serialVersionUID = 0;
    @WireField(eyt = "com.opensource.svgaplayer.proto.FrameEntity#ADAPTER", eyu = WireField.Label.REPEATED, tag = 2)
    public final List<FrameEntity> frames;
    @WireField(eyt = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String imageKey;

    public SpriteEntity(String str, List<FrameEntity> list) {
        this(str, list, ByteString.EMPTY);
    }

    public SpriteEntity(String str, List<FrameEntity> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.imageKey = str;
        this.frames = a.u("frames", list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.SpriteEntity$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<SpriteEntity, Builder> newBuilder2() {
        Builder builder = new Builder();
        builder.imageKey = this.imageKey;
        builder.frames = a.t("frames", this.frames);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SpriteEntity) {
            SpriteEntity spriteEntity = (SpriteEntity) obj;
            return unknownFields().equals(spriteEntity.unknownFields()) && a.equals(this.imageKey, spriteEntity.imageKey) && this.frames.equals(spriteEntity.frames);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = (((this.imageKey != null ? this.imageKey.hashCode() : 0) + (unknownFields().hashCode() * 37)) * 37) + this.frames.hashCode();
            this.hashCode = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.imageKey != null) {
            sb.append(", imageKey=").append(this.imageKey);
        }
        if (!this.frames.isEmpty()) {
            sb.append(", frames=").append(this.frames);
        }
        return sb.replace(0, 2, "SpriteEntity{").append('}').toString();
    }

    /* loaded from: classes17.dex */
    public static final class Builder extends Message.a<SpriteEntity, Builder> {
        public List<FrameEntity> frames = a.eyw();
        public String imageKey;

        public Builder imageKey(String str) {
            this.imageKey = str;
            return this;
        }

        public Builder frames(List<FrameEntity> list) {
            a.gJ(list);
            this.frames = list;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public SpriteEntity build() {
            return new SpriteEntity(this.imageKey, this.frames, super.buildUnknownFields());
        }
    }

    /* loaded from: classes17.dex */
    private static final class ProtoAdapter_SpriteEntity extends ProtoAdapter<SpriteEntity> {
        ProtoAdapter_SpriteEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, SpriteEntity.class);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(SpriteEntity spriteEntity) {
            return (spriteEntity.imageKey != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, spriteEntity.imageKey) : 0) + FrameEntity.ADAPTER.asRepeated().encodedSizeWithTag(2, spriteEntity.frames) + spriteEntity.unknownFields().size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, SpriteEntity spriteEntity) throws IOException {
            if (spriteEntity.imageKey != null) {
                ProtoAdapter.STRING.encodeWithTag(dVar, 1, spriteEntity.imageKey);
            }
            FrameEntity.ADAPTER.asRepeated().encodeWithTag(dVar, 2, spriteEntity.frames);
            dVar.b(spriteEntity.unknownFields());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public SpriteEntity decode(c cVar) throws IOException {
            Builder builder = new Builder();
            long eyl = cVar.eyl();
            while (true) {
                int eym = cVar.eym();
                if (eym != -1) {
                    switch (eym) {
                        case 1:
                            builder.imageKey(ProtoAdapter.STRING.decode(cVar));
                            break;
                        case 2:
                            builder.frames.add(FrameEntity.ADAPTER.decode(cVar));
                            break;
                        default:
                            FieldEncoding eyn = cVar.eyn();
                            builder.addUnknownField(eym, eyn, eyn.rawProtoAdapter().decode(cVar));
                            break;
                    }
                } else {
                    cVar.ie(eyl);
                    return builder.build();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.opensource.svgaplayer.proto.SpriteEntity$Builder] */
        @Override // com.squareup.wire2.ProtoAdapter
        public SpriteEntity redact(SpriteEntity spriteEntity) {
            ?? newBuilder2 = spriteEntity.newBuilder2();
            a.a(newBuilder2.frames, FrameEntity.ADAPTER);
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }
}
