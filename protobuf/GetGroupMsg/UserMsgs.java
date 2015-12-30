package protobuf.GetGroupMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.MsgInfo;
/* loaded from: classes.dex */
public final class UserMsgs extends Message {
    public static final List<MsgInfo> DEFAULT_MSGS = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<MsgInfo> msgs;

    /* synthetic */ UserMsgs(Builder builder, boolean z, UserMsgs userMsgs) {
        this(builder, z);
    }

    private UserMsgs(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.msgs == null) {
                this.msgs = DEFAULT_MSGS;
                return;
            } else {
                this.msgs = immutableCopyOf(builder.msgs);
                return;
            }
        }
        this.msgs = immutableCopyOf(builder.msgs);
    }

    /* loaded from: classes.dex */
    public static final class Builder extends Message.Builder<UserMsgs> {
        public List<MsgInfo> msgs;

        public Builder() {
        }

        public Builder(UserMsgs userMsgs) {
            super(userMsgs);
            if (userMsgs != null) {
                this.msgs = UserMsgs.copyOf(userMsgs.msgs);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public UserMsgs build(boolean z) {
            return new UserMsgs(this, z, null);
        }
    }
}
