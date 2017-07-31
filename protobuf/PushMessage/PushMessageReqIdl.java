package protobuf.PushMessage;

import com.squareup.wire.Message;
/* loaded from: classes.dex */
public final class PushMessageReqIdl extends Message {
    private PushMessageReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<PushMessageReqIdl> {
        public Builder() {
        }

        public Builder(PushMessageReqIdl pushMessageReqIdl) {
            super(pushMessageReqIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PushMessageReqIdl build(boolean z) {
            return new PushMessageReqIdl(this, z);
        }
    }
}
