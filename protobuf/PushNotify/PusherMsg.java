package protobuf.PushNotify;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import protobuf.PusherMsgInfo;
/* loaded from: classes.dex */
public final class PusherMsg extends Message {
    public static final Integer DEFAULT_CMD = 0;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer cmd;
    @ProtoField(tag = 2)
    public final PusherMsgInfo data;

    /* synthetic */ PusherMsg(Builder builder, boolean z, PusherMsg pusherMsg) {
        this(builder, z);
    }

    private PusherMsg(Builder builder, boolean z) {
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
    public static final class Builder extends Message.Builder<PusherMsg> {
        public Integer cmd;
        public PusherMsgInfo data;

        public Builder() {
        }

        public Builder(PusherMsg pusherMsg) {
            super(pusherMsg);
            if (pusherMsg != null) {
                this.cmd = pusherMsg.cmd;
                this.data = pusherMsg.data;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public PusherMsg build(boolean z) {
            return new PusherMsg(this, z, null);
        }
    }
}
