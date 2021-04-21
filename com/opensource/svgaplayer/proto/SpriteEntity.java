package com.opensource.svgaplayer.proto;

import com.squareup.wire2.FieldEncoding;
import com.squareup.wire2.Message;
import com.squareup.wire2.ProtoAdapter;
import com.squareup.wire2.WireField;
import d.o.a.c;
import d.o.a.d;
import d.o.a.h.a;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
/* loaded from: classes6.dex */
public final class SpriteEntity extends Message<SpriteEntity, Builder> {
    public static final ProtoAdapter<SpriteEntity> ADAPTER = new ProtoAdapter_SpriteEntity();
    public static final String DEFAULT_IMAGEKEY = "";
    public static final long serialVersionUID = 0;
    @WireField(adapter = "com.opensource.svgaplayer.proto.FrameEntity#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<FrameEntity> frames;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String imageKey;

    /* loaded from: classes6.dex */
    public static final class Builder extends Message.a<SpriteEntity, Builder> {
        public List<FrameEntity> frames = a.i();
        public String imageKey;

        public Builder frames(List<FrameEntity> list) {
            a.a(list);
            this.frames = list;
            return this;
        }

        public Builder imageKey(String str) {
            this.imageKey = str;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public SpriteEntity build() {
            return new SpriteEntity(this.imageKey, this.frames, super.buildUnknownFields());
        }
    }

    /* loaded from: classes6.dex */
    public static final class ProtoAdapter_SpriteEntity extends ProtoAdapter<SpriteEntity> {
        public ProtoAdapter_SpriteEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, SpriteEntity.class);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public SpriteEntity decode(c cVar) throws IOException {
            Builder builder = new Builder();
            long c2 = cVar.c();
            while (true) {
                int f2 = cVar.f();
                if (f2 == -1) {
                    cVar.d(c2);
                    return builder.build();
                } else if (f2 == 1) {
                    builder.imageKey(ProtoAdapter.STRING.decode(cVar));
                } else if (f2 != 2) {
                    FieldEncoding g2 = cVar.g();
                    builder.addUnknownField(f2, g2, g2.rawProtoAdapter().decode(cVar));
                } else {
                    builder.frames.add(FrameEntity.ADAPTER.decode(cVar));
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, SpriteEntity spriteEntity) throws IOException {
            String str = spriteEntity.imageKey;
            if (str != null) {
                ProtoAdapter.STRING.encodeWithTag(dVar, 1, str);
            }
            FrameEntity.ADAPTER.asRepeated().encodeWithTag(dVar, 2, spriteEntity.frames);
            dVar.k(spriteEntity.unknownFields());
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(SpriteEntity spriteEntity) {
            String str = spriteEntity.imageKey;
            return (str != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, str) : 0) + FrameEntity.ADAPTER.asRepeated().encodedSizeWithTag(2, spriteEntity.frames) + spriteEntity.unknownFields().size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Type inference failed for: r3v1, types: [com.squareup.wire2.Message$a, com.opensource.svgaplayer.proto.SpriteEntity$Builder] */
        @Override // com.squareup.wire2.ProtoAdapter
        public SpriteEntity redact(SpriteEntity spriteEntity) {
            ?? newBuilder2 = spriteEntity.newBuilder2();
            a.k(newBuilder2.frames, FrameEntity.ADAPTER);
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }

    public SpriteEntity(String str, List<FrameEntity> list) {
        this(str, list, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SpriteEntity) {
            SpriteEntity spriteEntity = (SpriteEntity) obj;
            return unknownFields().equals(spriteEntity.unknownFields()) && a.f(this.imageKey, spriteEntity.imageKey) && this.frames.equals(spriteEntity.frames);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = unknownFields().hashCode() * 37;
            String str = this.imageKey;
            int hashCode2 = ((hashCode + (str != null ? str.hashCode() : 0)) * 37) + this.frames.hashCode();
            this.hashCode = hashCode2;
            return hashCode2;
        }
        return i;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.imageKey != null) {
            sb.append(", imageKey=");
            sb.append(this.imageKey);
        }
        if (!this.frames.isEmpty()) {
            sb.append(", frames=");
            sb.append(this.frames);
        }
        StringBuilder replace = sb.replace(0, 2, "SpriteEntity{");
        replace.append('}');
        return replace.toString();
    }

    public SpriteEntity(String str, List<FrameEntity> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.imageKey = str;
        this.frames = a.g("frames", list);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.SpriteEntity$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<SpriteEntity, Builder> newBuilder2() {
        Builder builder = new Builder();
        builder.imageKey = this.imageKey;
        builder.frames = a.c("frames", this.frames);
        builder.addUnknownFields(unknownFields());
        return builder;
    }
}
