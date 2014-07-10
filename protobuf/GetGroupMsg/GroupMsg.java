package protobuf.GetGroupMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.MsgInfo;
/* loaded from: classes.dex */
public final class GroupMsg extends Message {
    public static final List<MsgInfo> DEFAULT_MSGLIST = Collections.emptyList();
    @ProtoField(tag = 1)
    public final GroupInfo groupInfo;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<MsgInfo> msgList;

    /* synthetic */ GroupMsg(Builder builder, boolean z, GroupMsg groupMsg) {
        this(builder, z);
    }

    private GroupMsg(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.groupInfo = builder.groupInfo;
            if (builder.msgList == null) {
                this.msgList = DEFAULT_MSGLIST;
                return;
            } else {
                this.msgList = immutableCopyOf(builder.msgList);
                return;
            }
        }
        this.groupInfo = builder.groupInfo;
        this.msgList = immutableCopyOf(builder.msgList);
    }

    /* loaded from: classes.dex */
    public final class Builder extends Message.Builder<GroupMsg> {
        public GroupInfo groupInfo;
        public List<MsgInfo> msgList;

        public Builder(GroupMsg groupMsg) {
            super(groupMsg);
            if (groupMsg != null) {
                this.groupInfo = groupMsg.groupInfo;
                this.msgList = GroupMsg.copyOf(groupMsg.msgList);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GroupMsg build(boolean z) {
            return new GroupMsg(this, z, null);
        }
    }
}
