package protobuf.PushMessage;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.Error;
/* loaded from: classes9.dex */
public final class PushMessageResIdl extends Message {
    public static final Long DEFAULT_PUSHTIME = 0L;
    @ProtoField(tag = 2)
    public final DataRes data;
    @ProtoField(tag = 1)
    public final Error error;
    @ProtoField(tag = 4)
    public final PushMsg msgs;
    @ProtoField(tag = 3, type = Message.Datatype.INT64)
    public final Long pushTime;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<PushMessageResIdl> {
        public DataRes data;
        public Error error;
        public PushMsg msgs;
        public Long pushTime;

        public Builder() {
        }

        public Builder(PushMessageResIdl pushMessageResIdl) {
            super(pushMessageResIdl);
            if (pushMessageResIdl == null) {
                return;
            }
            this.error = pushMessageResIdl.error;
            this.data = pushMessageResIdl.data;
            this.pushTime = pushMessageResIdl.pushTime;
            this.msgs = pushMessageResIdl.msgs;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PushMessageResIdl build(boolean z) {
            return new PushMessageResIdl(this, z);
        }
    }

    public PushMessageResIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.error = builder.error;
            this.data = builder.data;
            Long l = builder.pushTime;
            if (l == null) {
                this.pushTime = DEFAULT_PUSHTIME;
            } else {
                this.pushTime = l;
            }
            this.msgs = builder.msgs;
            return;
        }
        this.error = builder.error;
        this.data = builder.data;
        this.pushTime = builder.pushTime;
        this.msgs = builder.msgs;
    }
}
