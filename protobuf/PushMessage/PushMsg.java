package protobuf.PushMessage;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.PushMsgInfo;
/* loaded from: classes.dex */
public final class PushMsg extends Message {
    public static final Integer DEFAULT_CMD = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer cmd;
    @ProtoField(tag = 2)
    public final PushMsgInfo data;

    /* synthetic */ PushMsg(Builder builder, boolean z, PushMsg pushMsg) {
        this(builder, z);
    }

    private PushMsg(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.cmd == null) {
                this.cmd = DEFAULT_CMD;
            } else {
                this.cmd = builder.cmd;
            }
            this.data = builder.data;
            return;
        }
        this.cmd = builder.cmd;
        this.data = builder.data;
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<PushMsg> {
        public Integer cmd;
        public PushMsgInfo data;

        public Builder() {
        }

        public Builder(PushMsg pushMsg) {
            super(pushMsg);
            if (pushMsg != null) {
                this.cmd = pushMsg.cmd;
                this.data = pushMsg.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PushMsg build(boolean z) {
            return new PushMsg(this, z, null);
        }
    }
}
