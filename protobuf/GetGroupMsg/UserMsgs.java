package protobuf.GetGroupMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.MsgInfo;
/* loaded from: classes9.dex */
public final class UserMsgs extends Message {
    public static final List<MsgInfo> DEFAULT_MSGS = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<MsgInfo> msgs;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<UserMsgs> {
        public List<MsgInfo> msgs;

        public Builder() {
        }

        public Builder(UserMsgs userMsgs) {
            super(userMsgs);
            if (userMsgs == null) {
                return;
            }
            this.msgs = Message.copyOf(userMsgs.msgs);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UserMsgs build(boolean z) {
            return new UserMsgs(this, z);
        }
    }

    public UserMsgs(Builder builder, boolean z) {
        super(builder);
        if (z) {
            List<MsgInfo> list = builder.msgs;
            if (list == null) {
                this.msgs = DEFAULT_MSGS;
                return;
            } else {
                this.msgs = Message.immutableCopyOf(list);
                return;
            }
        }
        this.msgs = Message.immutableCopyOf(builder.msgs);
    }
}
