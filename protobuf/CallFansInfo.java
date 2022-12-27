package protobuf;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class CallFansInfo extends Message {
    public static final Integer DEFAULT_CANCALL = 0;
    public static final Long DEFAULT_THREADID = 0L;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer canCall;
    @ProtoField(tag = 2, type = Message.Datatype.INT64)
    public final Long threadId;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<CallFansInfo> {
        public Integer canCall;
        public Long threadId;

        public Builder() {
        }

        public Builder(CallFansInfo callFansInfo) {
            super(callFansInfo);
            if (callFansInfo == null) {
                return;
            }
            this.canCall = callFansInfo.canCall;
            this.threadId = callFansInfo.threadId;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public CallFansInfo build(boolean z) {
            return new CallFansInfo(this, z);
        }
    }

    public CallFansInfo(Builder builder, boolean z) {
        super(builder);
        if (z) {
            Integer num = builder.canCall;
            if (num == null) {
                this.canCall = DEFAULT_CANCALL;
            } else {
                this.canCall = num;
            }
            Long l = builder.threadId;
            if (l == null) {
                this.threadId = DEFAULT_THREADID;
                return;
            } else {
                this.threadId = l;
                return;
            }
        }
        this.canCall = builder.canCall;
        this.threadId = builder.threadId;
    }
}
