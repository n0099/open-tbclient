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
public final class AudioEntity extends Message<AudioEntity, Builder> {
    public static final String DEFAULT_AUDIOKEY = "";
    private static final long serialVersionUID = 0;
    @WireField(dFl = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String audioKey;
    @WireField(dFl = "com.squareup.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer endFrame;
    @WireField(dFl = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer startFrame;
    @WireField(dFl = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer startTime;
    @WireField(dFl = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer totalTime;
    public static final ProtoAdapter<AudioEntity> ADAPTER = new ProtoAdapter_AudioEntity();
    public static final Integer DEFAULT_STARTFRAME = 0;
    public static final Integer DEFAULT_ENDFRAME = 0;
    public static final Integer DEFAULT_STARTTIME = 0;
    public static final Integer DEFAULT_TOTALTIME = 0;

    public AudioEntity(String str, Integer num, Integer num2, Integer num3, Integer num4) {
        this(str, num, num2, num3, num4, ByteString.EMPTY);
    }

    public AudioEntity(String str, Integer num, Integer num2, Integer num3, Integer num4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.audioKey = str;
        this.startFrame = num;
        this.endFrame = num2;
        this.startTime = num3;
        this.totalTime = num4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Return type fixed from 'com.opensource.svgaplayer.proto.AudioEntity$Builder' to match base method */
    @Override // com.squareup.wire2.Message
    /* renamed from: newBuilder */
    public Message.a<AudioEntity, Builder> newBuilder2() {
        Builder builder = new Builder();
        builder.audioKey = this.audioKey;
        builder.startFrame = this.startFrame;
        builder.endFrame = this.endFrame;
        builder.startTime = this.startTime;
        builder.totalTime = this.totalTime;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AudioEntity) {
            AudioEntity audioEntity = (AudioEntity) obj;
            return unknownFields().equals(audioEntity.unknownFields()) && a.equals(this.audioKey, audioEntity.audioKey) && a.equals(this.startFrame, audioEntity.startFrame) && a.equals(this.endFrame, audioEntity.endFrame) && a.equals(this.startTime, audioEntity.startTime) && a.equals(this.totalTime, audioEntity.totalTime);
        }
        return false;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i == 0) {
            int hashCode = (((this.startTime != null ? this.startTime.hashCode() : 0) + (((this.endFrame != null ? this.endFrame.hashCode() : 0) + (((this.startFrame != null ? this.startFrame.hashCode() : 0) + (((this.audioKey != null ? this.audioKey.hashCode() : 0) + (unknownFields().hashCode() * 37)) * 37)) * 37)) * 37)) * 37) + (this.totalTime != null ? this.totalTime.hashCode() : 0);
            this.hashCode = hashCode;
            return hashCode;
        }
        return i;
    }

    @Override // com.squareup.wire2.Message
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.audioKey != null) {
            sb.append(", audioKey=").append(this.audioKey);
        }
        if (this.startFrame != null) {
            sb.append(", startFrame=").append(this.startFrame);
        }
        if (this.endFrame != null) {
            sb.append(", endFrame=").append(this.endFrame);
        }
        if (this.startTime != null) {
            sb.append(", startTime=").append(this.startTime);
        }
        if (this.totalTime != null) {
            sb.append(", totalTime=").append(this.totalTime);
        }
        return sb.replace(0, 2, "AudioEntity{").append('}').toString();
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.a<AudioEntity, Builder> {
        public String audioKey;
        public Integer endFrame;
        public Integer startFrame;
        public Integer startTime;
        public Integer totalTime;

        public Builder audioKey(String str) {
            this.audioKey = str;
            return this;
        }

        public Builder startFrame(Integer num) {
            this.startFrame = num;
            return this;
        }

        public Builder endFrame(Integer num) {
            this.endFrame = num;
            return this;
        }

        public Builder startTime(Integer num) {
            this.startTime = num;
            return this;
        }

        public Builder totalTime(Integer num) {
            this.totalTime = num;
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.Message.a
        public AudioEntity build() {
            return new AudioEntity(this.audioKey, this.startFrame, this.endFrame, this.startTime, this.totalTime, super.buildUnknownFields());
        }
    }

    /* loaded from: classes.dex */
    private static final class ProtoAdapter_AudioEntity extends ProtoAdapter<AudioEntity> {
        ProtoAdapter_AudioEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, AudioEntity.class);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public int encodedSize(AudioEntity audioEntity) {
            return (audioEntity.startTime != null ? ProtoAdapter.INT32.encodedSizeWithTag(4, audioEntity.startTime) : 0) + (audioEntity.startFrame != null ? ProtoAdapter.INT32.encodedSizeWithTag(2, audioEntity.startFrame) : 0) + (audioEntity.audioKey != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, audioEntity.audioKey) : 0) + (audioEntity.endFrame != null ? ProtoAdapter.INT32.encodedSizeWithTag(3, audioEntity.endFrame) : 0) + (audioEntity.totalTime != null ? ProtoAdapter.INT32.encodedSizeWithTag(5, audioEntity.totalTime) : 0) + audioEntity.unknownFields().size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public void encode(d dVar, AudioEntity audioEntity) throws IOException {
            if (audioEntity.audioKey != null) {
                ProtoAdapter.STRING.encodeWithTag(dVar, 1, audioEntity.audioKey);
            }
            if (audioEntity.startFrame != null) {
                ProtoAdapter.INT32.encodeWithTag(dVar, 2, audioEntity.startFrame);
            }
            if (audioEntity.endFrame != null) {
                ProtoAdapter.INT32.encodeWithTag(dVar, 3, audioEntity.endFrame);
            }
            if (audioEntity.startTime != null) {
                ProtoAdapter.INT32.encodeWithTag(dVar, 4, audioEntity.startTime);
            }
            if (audioEntity.totalTime != null) {
                ProtoAdapter.INT32.encodeWithTag(dVar, 5, audioEntity.totalTime);
            }
            dVar.b(audioEntity.unknownFields());
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire2.ProtoAdapter
        public AudioEntity decode(c cVar) throws IOException {
            Builder builder = new Builder();
            long dFd = cVar.dFd();
            while (true) {
                int dFe = cVar.dFe();
                if (dFe != -1) {
                    switch (dFe) {
                        case 1:
                            builder.audioKey(ProtoAdapter.STRING.decode(cVar));
                            break;
                        case 2:
                            builder.startFrame(ProtoAdapter.INT32.decode(cVar));
                            break;
                        case 3:
                            builder.endFrame(ProtoAdapter.INT32.decode(cVar));
                            break;
                        case 4:
                            builder.startTime(ProtoAdapter.INT32.decode(cVar));
                            break;
                        case 5:
                            builder.totalTime(ProtoAdapter.INT32.decode(cVar));
                            break;
                        default:
                            FieldEncoding dFf = cVar.dFf();
                            builder.addUnknownField(dFe, dFf, dFf.rawProtoAdapter().decode(cVar));
                            break;
                    }
                } else {
                    cVar.hb(dFd);
                    return builder.build();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire2.ProtoAdapter
        public AudioEntity redact(AudioEntity audioEntity) {
            Message.a<AudioEntity, Builder> newBuilder2 = audioEntity.newBuilder2();
            newBuilder2.clearUnknownFields();
            return newBuilder2.build();
        }
    }
}
