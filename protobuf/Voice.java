package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes2.dex */
public final class Voice extends Message {
    public static final String DEFAULT_VOICEMD5 = "";
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer duringTime;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer type;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String voiceMd5;
    public static final Integer DEFAULT_TYPE = 0;
    public static final Integer DEFAULT_DURINGTIME = 0;

    /* loaded from: classes2.dex */
    public static final class Builder extends Message.Builder<Voice> {
        public Integer duringTime;
        public Integer type;
        public String voiceMd5;

        public Builder() {
        }

        public Builder(Voice voice) {
            super(voice);
            if (voice == null) {
                return;
            }
            this.type = voice.type;
            this.duringTime = voice.duringTime;
            this.voiceMd5 = voice.voiceMd5;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public Voice build(boolean z) {
            return new Voice(this, z);
        }
    }

    public Voice(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.type;
            if (num == null) {
                this.type = DEFAULT_TYPE;
            } else {
                this.type = num;
            }
            Integer num2 = builder.duringTime;
            if (num2 == null) {
                this.duringTime = DEFAULT_DURINGTIME;
            } else {
                this.duringTime = num2;
            }
            String str = builder.voiceMd5;
            if (str == null) {
                this.voiceMd5 = "";
                return;
            } else {
                this.voiceMd5 = str;
                return;
            }
        }
        this.type = builder.type;
        this.duringTime = builder.duringTime;
        this.voiceMd5 = builder.voiceMd5;
    }
}
