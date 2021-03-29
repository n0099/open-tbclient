package protobuf.GetGroupMsg;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
import protobuf.GroupInfo;
import protobuf.MsgInfo;
/* loaded from: classes7.dex */
public final class GroupMsg extends Message {
    @ProtoField(tag = 1)
    public final GroupInfo groupInfo;
    @ProtoField(tag = 3, type = Message.Datatype.INT32)
    public final Integer hasMore;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<MsgInfo> msgList;
    public static final List<MsgInfo> DEFAULT_MSGLIST = Collections.emptyList();
    public static final Integer DEFAULT_HASMORE = 0;

    /* loaded from: classes7.dex */
    public static final class Builder extends Message.Builder<GroupMsg> {
        public GroupInfo groupInfo;
        public Integer hasMore;
        public List<MsgInfo> msgList;

        public Builder() {
        }

        public Builder(GroupMsg groupMsg) {
            super(groupMsg);
            if (groupMsg == null) {
                return;
            }
            this.groupInfo = groupMsg.groupInfo;
            this.msgList = Message.copyOf(groupMsg.msgList);
            this.hasMore = groupMsg.hasMore;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public GroupMsg build(boolean z) {
            return new GroupMsg(this, z);
        }
    }

    public GroupMsg(Builder builder, boolean z) {
        super(builder);
        if (z) {
            this.groupInfo = builder.groupInfo;
            List<MsgInfo> list = builder.msgList;
            if (list == null) {
                this.msgList = DEFAULT_MSGLIST;
            } else {
                this.msgList = Message.immutableCopyOf(list);
            }
            Integer num = builder.hasMore;
            if (num == null) {
                this.hasMore = DEFAULT_HASMORE;
                return;
            } else {
                this.hasMore = num;
                return;
            }
        }
        this.groupInfo = builder.groupInfo;
        this.msgList = Message.immutableCopyOf(builder.msgList);
        this.hasMore = builder.hasMore;
    }
}
