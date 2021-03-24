package protobuf.PushNotify;

import com.squareup.wire.Message;
/* loaded from: classes7.dex */
public final class PushNotifyReqIdl extends Message {

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<PushNotifyReqIdl> {
        public Builder() {
        }

        public Builder(PushNotifyReqIdl pushNotifyReqIdl) {
            super(pushNotifyReqIdl);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PushNotifyReqIdl build(boolean z) {
            return new PushNotifyReqIdl(this, z);
        }
    }

    public PushNotifyReqIdl(Builder builder, boolean z) {
        super(builder);
    }
}
