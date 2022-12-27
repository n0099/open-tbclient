package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class PushSignMask extends Message {
    public static final Integer DEFAULT_SIGNPUSHMASK = 0;
    public static final Integer DEFAULT_SIGNPUSHTIMESTAMP = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer signPushMask;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer signPushTimeStamp;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<PushSignMask> {
        public Integer signPushMask;
        public Integer signPushTimeStamp;

        public Builder() {
        }

        public Builder(PushSignMask pushSignMask) {
            super(pushSignMask);
            if (pushSignMask == null) {
                return;
            }
            this.signPushMask = pushSignMask.signPushMask;
            this.signPushTimeStamp = pushSignMask.signPushTimeStamp;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PushSignMask build(boolean z) {
            return new PushSignMask(this, z);
        }
    }

    public PushSignMask(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.signPushMask;
            if (num == null) {
                this.signPushMask = DEFAULT_SIGNPUSHMASK;
            } else {
                this.signPushMask = num;
            }
            Integer num2 = builder.signPushTimeStamp;
            if (num2 == null) {
                this.signPushTimeStamp = DEFAULT_SIGNPUSHTIMESTAMP;
                return;
            } else {
                this.signPushTimeStamp = num2;
                return;
            }
        }
        this.signPushMask = builder.signPushMask;
        this.signPushTimeStamp = builder.signPushTimeStamp;
    }
}
